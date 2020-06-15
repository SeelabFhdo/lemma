package de.fhdo.lemma.model_processing.builtin_phases.code_generation

import de.fhdo.lemma.model_processing.annotations.CodeGenerationModule
import de.fhdo.lemma.model_processing.annotations.CodeGenerationPropertyProvider
import de.fhdo.lemma.model_processing.annotations.ExplicitlyInvokedCodeGenerationModule
import de.fhdo.lemma.model_processing.annotations.ModelProcessingPhase
import de.fhdo.lemma.model_processing.annotations.RequiresBasicCommandLineOptions
import de.fhdo.lemma.model_processing.annotations.findAnnotatedClasses
import de.fhdo.lemma.model_processing.annotations.get
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.asXmiResource
import de.fhdo.lemma.model_processing.phases.AbstractModelProcessingPhase
import de.fhdo.lemma.model_processing.builtin_phases.intermediate_model_validation.IntermediateModelValidationPhase
import de.fhdo.lemma.model_processing.command_line.BasicCommandLine
import de.fhdo.lemma.model_processing.command_line.BasicOption
import de.fhdo.lemma.model_processing.command_line.parseCommandLine
import de.fhdo.lemma.model_processing.containsAny
import de.fhdo.lemma.model_processing.extendsImplementsOrException
import de.fhdo.lemma.model_processing.isChildPathOf
import de.fhdo.lemma.model_processing.languages.registerLanguages
import de.fhdo.lemma.model_processing.phases.PhaseException
import de.fhdo.lemma.model_processing.phases.PhaseHeap
import de.fhdo.lemma.model_processing.printlnError
import de.fhdo.lemma.model_processing.printlnWarning
import de.fhdo.lemma.model_processing.readModelingNamespacesFromXmi
import io.github.classgraph.ClassInfo
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import java.nio.charset.Charset
import java.util.ArrayDeque
import java.util.Deque
import java.util.LinkedList
import kotlin.reflect.KClass

/**
 * Implementation of the model processor's code generation phase.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@ModelProcessingPhase("code_generation", IntermediateModelValidationPhase::class)
@RequiresBasicCommandLineOptions(BasicOption.INTERMEDIATE_MODEL_FILE, BasicOption.TARGET_FOLDER)
internal class CodeGenerationPhase : AbstractModelProcessingPhase() {
    /**
     * Phase initialization (overridden to specify parameter constraints)
     */
    override fun initialize(id: String, isBlocking: Boolean, processorImplementationPackage: String) {
        super.initialize(id, isBlocking, processorImplementationPackage)

        parameters {
            expects {
                from("intermediate_model_validation") {
                    "intermediateModelFileNamespaces" withType Set::class.java
                    "resource" withType Resource::class.java
                }
            }
        }
    }

    /**
     * Execute the phase
     */
    override fun process(args: Array<String>) {
        /* Get code generation properties from provider, if any */
        val propertyProvider = findCodeGenerationPropertyProvider(processorImplementationPackage)
        val codeGenerationProperties = propertyProvider?.getProperties() ?: emptyMap()

        /* Find and initialize code generation modules */
        val (modules, dependencyRelationships) = findAndInitCodeGenerationModules(processorImplementationPackage,
            CodeGenerationModule::class, codeGenerationProperties)
        val (explicitlyInvokedModules, _) = findAndInitCodeGenerationModules(processorImplementationPackage,
            ExplicitlyInvokedCodeGenerationModule::class, codeGenerationProperties)

        // Prepare loaded module information that assigns a Boolean value to each module, stating whether the module is
        // to be explicitly invoked or not
        val loadedModuleInfo = modules.keys.associateBy({it}, {false}).toMutableMap()
        loadedModuleInfo.putAll(explicitlyInvokedModules.keys.associateBy({it}, {true}))

        if (loadedModuleInfo.isEmpty())
            throw PhaseException("No code generation modules were found on the classpath")

        /* Parse commandline */
        val (phaseArguments, modulesArguments) = parseCommandLine(args, loadedModuleInfo.keys.toList())
        try {
            PhaseCommandLine(phaseArguments)
        } catch (ex: Exception) {
            throw PhaseException(ex.message)
        }

        /* Only print properties if requested by user */
        if (PhaseCommandLine.printProperties) {
            if (codeGenerationProperties.isNotEmpty())
                codeGenerationProperties.forEach { println("${it.key}: ${it.value}") }
            else
                println("No properties found for code generation phase")

            return
        }

        // Only print names of generation modules if requested by user
        if (PhaseCommandLine.printModules) {
            println("Loaded code generation modules:")
            loadedModuleInfo.toSortedMap().forEach { (name, explicitlyInvoked) ->
                if (explicitlyInvoked)
                    println("$name (to be explicitly invoked)")
                else
                    println(name)
            }
            return
        }

        /* Calculate module execution plan that considers possible module dependencies */
        val modulesToExecute = when {
            // Invoke only those modules that were explicitly specified on the commandline
            PhaseCommandLine.invokeOnlySpecifiedModules -> {
                (modules + explicitlyInvokedModules).filter { it.key in modulesArguments.keys }
            }

            // In case an explicitly invoked module was stated on the commandline, only invoke those modules that need
            // to be explicitly invoked (this behavior is consistent with that of [AbstractModelProcessor])
            modulesArguments.keys.containsAny(explicitlyInvokedModules.keys) -> explicitlyInvokedModules

            // Invoke all modules that do not need to be invoked explicitly
            else -> modules
        }

        if (modulesToExecute.isEmpty())
            throw PhaseException("No modules found to execute. Probably the " +
                "${PhaseCommandLine.INVOKE_ONLY_SPECIFIED_MODULES} option was specified without a module.")
        else {
            val missingDependency = dependencyRelationships.keys.find { it !in modulesToExecute.keys }
            if (missingDependency != null)
                throw PhaseException("Some code generation modules depend on module \"$missingDependency\", which " +
                    "was not found on the classpath. Probably it was excluded with the " +
                    "${PhaseCommandLine.INVOKE_ONLY_SPECIFIED_MODULES} option.")
        }

        val executionPlan = calculateExecutionPlan(modulesToExecute, dependencyRelationships)

        /* Execute code generation modules */
        val generatedFiles = mutableMapOf<String, Pair<String, Charset>>()
        executionPlan.forEach {
            val moduleArguments = modulesArguments[it.name]?.toTypedArray() ?: emptyArray()
            generatedFiles.putAll(it.execute(phaseArguments.toTypedArray(), moduleArguments))
        }

        if (generatedFiles.isEmpty()) {
            println("No files were generated by the code generation modules")
            return
        }

        /* Write generated contents to files */
        val targetFolder = BasicCommandLine.targetFolder!!
        for ((filepath, content) in generatedFiles) {
            if (!PhaseCommandLine.allowCodeGenerationOutsideTargetFolder && !(filepath isChildPathOf targetFolder)) {
                printlnWarning("Generated file \"$filepath\" is not a child of generation target folder " +
                    "\"$targetFolder\" and code generation outside the target folder is not allowed. If you want to " +
                    "enable code generation outside the target folder, invoke the code generation phase with the " +
                    "${PhaseCommandLine.ALLOW_CODE_GENERATION_OUTSIDE_TARGET_FOLDER_OPTION_NAME} option")

                continue
            }

            val file = filepath.asFile()
            if (PhaseCommandLine.preserveExistingFiles && file.exists()) {
                printlnWarning("File \"$filepath\" already exists and will not be overridden, because the code " +
                    "generation phase was invoked with the ${PhaseCommandLine.PRESERVE_EXISTING_FILES_OPTION_NAME} " +
                    "option")

                continue
            }

            try {
                file.parentFile.mkdirs()
                file.writeText(content.first, content.second)
            } catch (ex: Exception) {
                printlnError("Error while writing generated contents to target file \"$filepath\": ${ex.message}")
            }
        }
    }
}

/**
 * Helper to find the code generation property provider on the classpath.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun findCodeGenerationPropertyProvider(processorPackage : String) : CodeGenerationPropertyProviderI? {
    val annotatedClasses = findAnnotatedClasses(processorPackage, CodeGenerationPropertyProvider::class)
    when {
        annotatedClasses.isEmpty() ->
            return null
        annotatedClasses.size > 1 ->
            throw PhaseException("Ambiguous code generation property providers. Only one class on the classpath may " +
                "be annotated as being a code generation property provider")
    }

    val providerInfo = annotatedClasses.first()
    providerInfo.extendsImplementsOrException(
        "Code generation property provider",
        expectedInterface = CodeGenerationPropertyProviderI::class
    )

    return providerInfo
        .loadClass(CodeGenerationPropertyProviderI::class.java)
        .getDeclaredConstructor()
        .newInstance()
}

/**
 * Helper to find and initialize [AbstractCodeGenerationModule] implementers on the classpath.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun findAndInitCodeGenerationModules(processorPackage: String, annotationClass: KClass<out Annotation>,
    codeGenerationProperties: Map<String, String>)
    : Pair<Map<String, AbstractCodeGenerationModule>, Map<String, List<String>>> {
    val loadedModules = mutableMapOf<String, AbstractCodeGenerationModule>()
    val dependencyRelationships = mutableMapOf<String, List<String>>()

    val annotatedClasses = findAnnotatedClasses(processorPackage, annotationClass)
    for (classInfo in annotatedClasses) {
        /* Code generation modules must extend AbstractCodeGenerationModule */
        classInfo.extendsImplementsOrException(
            "Code generation module",
            expectedSuperclass = AbstractCodeGenerationModule::class
        )

        /* Check name and duplicates */
        val annotationInfo = classInfo.annotationInfo[annotationClass]!!
        val moduleName = annotationInfo.parameterValues["name"].value as String
        if (moduleName.isEmpty())
            throw PhaseException("Name of code generation module implemented in class \"${classInfo.simpleName}\" " +
                "must not be empty")

        if (loadedModules.containsKey(moduleName))
            throw PhaseException("Duplicate module detected: \"$moduleName\"")

        /* Create and initialize module instance */
        // dependsOn annotation parameter does not exist for modules to be invoked explicitly
        val dependsOnModule = annotationInfo.parameterValues["dependsOn"]?.value as? String ?: ""
        val moduleInstance = initCodeGenerationModuleInstance(classInfo, moduleName, dependsOnModule,
             codeGenerationProperties)
        loadedModules += moduleName to moduleInstance

        /*
         * Add module to the map of dependency relationships, which assigns the list of dependent modules (values) to
         * those modules they depend on (key)
         */
        if (dependsOnModule.isNotEmpty())
            (dependencyRelationships
                .putIfAbsent(dependsOnModule, mutableListOf(moduleName))
                    as? MutableList<String>
            )?.add(moduleName)
    }

    return loadedModules to dependencyRelationships
}

/**
 * Helper to create and initialize [AbstractCodeGenerationModule] instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun initCodeGenerationModuleInstance(classInfo: ClassInfo, moduleName: String, dependsOn: String,
    codeGenerationProperties: Map<String, String>) : AbstractCodeGenerationModule {
    // Create instance
    val moduleInstance = classInfo.loadClass(AbstractCodeGenerationModule::class.java)
        .getDeclaredConstructor()
        .newInstance()

    // Register all EPackages needed by the intermediate model
    registerLanguages(getIntermediateModelFileNamespaces())

    // Load intermediate model Ecore Resource
    val intermediateModelResource = getIntermediateModelResource()
    @Suppress("UNCHECKED_CAST")
    val relevantModelElements = PhaseHeap["intermediate_model_query", "relevantModelElements"] as? List<EObject>
    val modelElementQuery = PhaseHeap["intermediate_model_query", "query"] as? String

    // Initialize module instance
    moduleInstance.initialize(moduleName, dependsOn, codeGenerationProperties, BasicCommandLine.intermediateModelFile!!,
        BasicCommandLine.targetFolder!!, intermediateModelResource, relevantModelElements, modelElementQuery)
    return moduleInstance
}

/**
 * Helper to retrieve the intermediate model's Ecore namespace(s). Reuses namespace information from previous phases if
 * existent.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun getIntermediateModelFileNamespaces() : Set<String> {
    @Suppress("UNCHECKED_CAST")
    return PhaseHeap["intermediate_model_query", "intermediateModelFileNamespaces"] as? Set<String>
        ?: PhaseHeap["intermediate_model_validation", "intermediateModelFileNamespaces"] as? Set<String>
        ?: readModelingNamespacesFromXmi(BasicCommandLine.intermediateModelFile!!)
}

/**
 * Helper to load the intermediate model as Ecore Resource. Reuses Resource instances from previous phases if existent.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun getIntermediateModelResource() : Resource {
    return PhaseHeap["intermediate_model_query", "resource"] as? Resource
        ?: PhaseHeap["intermediate_model_validation", "resource"] as? Resource
        ?: BasicCommandLine.intermediateModelFile!!.asXmiResource()
}

/**
 * Helper to calculate an execution plan for an [AbstractCodeGenerationModule] set by considering dependencies between
 * modules.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun calculateExecutionPlan(modules: Map<String, AbstractCodeGenerationModule>,
    dependencyRelationships: Map<String, List<String>>) : Deque<AbstractCodeGenerationModule> {
    val independentModules = modules.filter { it.value.dependsOn.isEmpty() }.keys
    val executionPlan = LinkedList<String>(independentModules)

    /*
     * Calculate the execution plan. Effectively, the execution plan is a stack whose elements' ordering corresponds to
     * the modules' execution. Independent modules will always be executed before dependent modules. The ordering of the
     * dependent modules reflects their dependency specifications, i.e., dependent modules will be executed after the
     * modules they depend on were executed.
     *
     * The algorithm to build the "dependent" part of the execution plan consists of the following steps:
     *     (1) Setup a stack of modules whose possible "dependents", i.e., the modules that depend on them, shall be
     *         checked. Initially, this stack holds all modules that definitely have dependents as reflected by the
     *         list of dependency relationships passed to this function.
     *     (2.1) For each dependency and its dependents, determine the lowest index in the execution plan at which the
     *           dependency can be inserted so that each dependent's execution is planned after the dependency. If the
     *           module has no dependents or none of its dependents are in the plan yet, the module is appended to the
     *           stack.
     *     (2.2) Check for circular dependencies by checking the stack entries that were placed before the dependency
     *           for dependents, i.e., check if a dependent's execution was previously determined to need to happen
     *           before the one of the current dependency, on which the dependent also depends. Consequently, dependency
     *           and dependent were determined to depend on each other (possibly indirectly), which is essentially the
     *           definition of circular dependency.
     *     (2.3) In case no circular dependency was detected, add dependency to the position the execution plan
     *           determined step (2.1).
     *     (3) Add dependents to the stack of dependents to check an goto (1) or quit the planning, in case the stack
     *         is empty and no further dependents to check exist.
     */
    val checkDependentsFor = ArrayDeque(dependencyRelationships.keys)
    while (checkDependentsFor.isNotEmpty()) {
        val currentDependency = checkDependentsFor.pop()
        val dependents = dependencyRelationships[currentDependency]

        var maxPositionBeforeDependents = if (dependents != null)
                dependents.map{ executionPlan.indexOf(it) }.min()!!
            else
                -1

        if (maxPositionBeforeDependents > -1) {
            val modulesBefore = executionPlan.subList(0, maxPositionBeforeDependents + 1)
            val circularDependency = if (dependents != null) modulesBefore.find { it in dependents } else null
            if (circularDependency != null)
                throw PhaseException("Circular dependency detected: Code generation module \"$currentDependency\" " +
                        "depends on \"$circularDependency\" and vice versa, possibly indirectly")
        } else
            maxPositionBeforeDependents = executionPlan.size

        if (!executionPlan.contains(currentDependency))
            executionPlan.add(maxPositionBeforeDependents, currentDependency)

        if (dependents != null)
            checkDependentsFor.addAll(dependents)
    }

    val result = ArrayDeque<AbstractCodeGenerationModule>()
    executionPlan.forEach { result.add(modules[it]) }
    return result
}