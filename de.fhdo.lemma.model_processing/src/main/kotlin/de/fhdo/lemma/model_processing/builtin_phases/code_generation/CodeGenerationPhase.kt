package de.fhdo.lemma.model_processing.builtin_phases.code_generation

import de.fhdo.lemma.model_processing.annotations.CodeGenerationPropertyProvider
import de.fhdo.lemma.model_processing.annotations.ModelProcessingPhase
import de.fhdo.lemma.model_processing.annotations.ConsumesBasicCommandLineOption
import de.fhdo.lemma.model_processing.annotations.findAnnotatedClasses
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.builtin_phases.code_generation.AvailableCodeGenerationModules.missingDependency
import de.fhdo.lemma.model_processing.builtin_phases.intermediate_model_validation.IntermediateModelValidationPhase
import de.fhdo.lemma.model_processing.phases.AbstractModelProcessingPhase
import de.fhdo.lemma.model_processing.command_line.BasicCommandLine
import de.fhdo.lemma.model_processing.command_line.BasicOption
import de.fhdo.lemma.model_processing.command_line.parseCommandLine
import de.fhdo.lemma.model_processing.containsAny
import de.fhdo.lemma.model_processing.debugPhase
import de.fhdo.lemma.model_processing.debugPhaseArguments
import de.fhdo.lemma.model_processing.extendsImplementsOrException
import de.fhdo.lemma.model_processing.isChildPathOf
import de.fhdo.lemma.model_processing.phases.ModelKind
import de.fhdo.lemma.model_processing.phases.PhaseException
import de.fhdo.lemma.model_processing.printlnError
import de.fhdo.lemma.model_processing.printlnPhaseError
import de.fhdo.lemma.model_processing.printlnWarning
import java.util.ArrayDeque
import java.util.Deque
import java.util.LinkedList

private typealias ModuleArguments = Map<String, List<String>>

/**
 * Implementation of the model processor's code generation phase.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@ModelProcessingPhase("code_generation", IntermediateModelValidationPhase::class)
@ConsumesBasicCommandLineOption(BasicOption.TARGET_FOLDER)
internal class CodeGenerationPhase : AbstractModelProcessingPhase() {
    /**
     * Execute the phase
     */
    override fun process(args: Array<String>) {
        debugPhaseArguments(args)

        /* Handle passed target folder */
        debugPhase {
            "Target folder \"${BasicCommandLine.targetFolder!!}\" will be used for code generation." +
            if (PhaseCommandLine.allowCodeGenerationOutsideTargetFolder)
                " However, user allowed code generation outside the target folder."
            else
                ""
        }

        /* Get code generation properties from provider, if any */
        val propertyProvider = findCodeGenerationPropertyProvider(processorImplementationPackage)
        if (propertyProvider != null)
            debugPhase {
                "Found code generation property provider ${propertyProvider::class.java.name} in processor " +
                "implementation package \"$processorImplementationPackage\""
            }

        val codeGenerationProperties = propertyProvider?.getProperties() ?: emptyMap()
        if (codeGenerationProperties.isNotEmpty()) {
            debugPhase { "Got the following properties from the code generation property provider:" }
            codeGenerationProperties.forEach { debugPhase { "\t- ${it.key} = ${it.value}" } }
        } else if (propertyProvider != null)
            debugPhase { "Code generation property provider did not yield any properties" }

        /* Find available code generation modules */
        AvailableCodeGenerationModules.initialize(processorImplementationPackage, codeGenerationProperties)

        /* Parse commandline */
        val codeGenerationModuleNames = AvailableCodeGenerationModules.getAllModuleNames().toList()
        val (phaseSpecificArguments, moduleSpecificArguments) = parseCommandLine(args, codeGenerationModuleNames)
        try {
            PhaseCommandLine(phaseSpecificArguments)
        } catch (ex: Exception) {
            throw PhaseException(ex.message)
        }

        /* Handle commands that might interrupt the phase's execution */
        val interruptExecution = handleInterruptingCommands(codeGenerationProperties)
        if (interruptExecution)
            return

        /* Execute code generation modules for model kinds */
        executeCodeGenerationModules(ModelKind.SOURCE, phaseSpecificArguments, moduleSpecificArguments)
        executeCodeGenerationModules(ModelKind.INTERMEDIATE, phaseSpecificArguments, moduleSpecificArguments)
    }

    /**
     * Helper to find the code generation property provider on the classpath
     */
    private fun findCodeGenerationPropertyProvider(processorPackage : String) : CodeGenerationPropertyProviderI? {
        val annotatedClasses = findAnnotatedClasses(processorPackage, CodeGenerationPropertyProvider::class)
        when {
            annotatedClasses.isEmpty() -> return null
            annotatedClasses.size > 1 -> throw PhaseException("Ambiguous code generation property providers. Only " +
                "one class in processor implementation package \"$processorPackage\" may be annotated as being a " +
                "code generation property provider")
        }

        val providerInfo = annotatedClasses.first()
        providerInfo.extendsImplementsOrException("Code generation property provider",
            expectedInterface = CodeGenerationPropertyProviderI::class)

        return providerInfo
            .loadClass(CodeGenerationPropertyProviderI::class.java)
            .getDeclaredConstructor()
            .newInstance()
    }

    /**
     * Handle CLI commands that might interrupt the execution of the code generation phase (returns true, if the phase
     * shall be interrupted after a certain command)
     */
    private fun handleInterruptingCommands(codeGenerationProperties: Map<String, String>) : Boolean {
        // Print properties
        if (PhaseCommandLine.printProperties) {
            if (codeGenerationProperties.isNotEmpty())
                codeGenerationProperties.forEach { println("${it.key} = ${it.value}") }
            else
                println("No properties found for code generation phase")

            return true
        }

        // Print names of available generation modules
        if (PhaseCommandLine.printModules) {
            printAvailableModulesForKind(ModelKind.SOURCE)
            printAvailableModulesForKind(ModelKind.INTERMEDIATE)

            return true
        }

        return false
    }

    /**
     * Helper to print the code generation modules available for the given [ModelKind]
     */
    private fun printAvailableModulesForKind(modelKind: ModelKind) {
        val moduleInfos = AvailableCodeGenerationModules.getModules(modelKind)
        println("Available code generation modules for ${modelKind.label} model:")
        moduleInfos.sortedBy { it.name }.forEach {
            println(
                "\t- ${it.name} (language namespace: ${it.languageNamespace}" +
                if (it.dependsOn.isNotEmpty()) ", depends on: ${it.dependsOn}" else "" +
                if (it.explicitlyInvoked) ", explicit invocation required)" else ")"
            )
        }
    }

    /**
     * Execute all code generation modules available for a certain [ModelKind]
     */
    private fun executeCodeGenerationModules(modelKind: ModelKind, phaseSpecificArguments: List<String>,
        moduleSpecificArguments: Map<String, List<String>>) {
        val kindLabel = modelKind.label

        /* Check if matching code generation modules exist */
        if (!AvailableCodeGenerationModules.existModules(modelKind)) {
            debugPhase {
                "No code generation modules for $kindLabel model found. Code generation for this model kind aborted."
            }
            return
        }

        /* Calculate module execution plan */
        val executionPlan = try {
            val (modulesToExecute, onlyExplicitlyInvokedModules)
                = determineModulesToExecute(modelKind, moduleSpecificArguments)
            modulesToExecute.calculateExecutionPlan(onlyExplicitlyInvokedModules)
        } catch (ex: ModuleExecutionDeterminationException) {
            printlnPhaseError(this, ex.message)
            return
        }

        /* Execute code generation modules according to the calculated execution plan */
        if (!executionPlan.isEmpty()) {
            debugPhase { "Calculated execution plan for code generation modules concerning $kindLabel model:" }
            executionPlan.forEachIndexed { index, module ->
                debugPhase {
                    "\t${index+1}. ${module.name}" +
                    if (module.explicitlyInvoked) " (explicit invocation required)" else ""
                }
            }
            executionPlan.execute(modelKind, phaseSpecificArguments, moduleSpecificArguments)
        }
    }

    /**
     * Determine the code generation modules to execute for the given [ModelKind]. The boolean flag of the returned
     * [Pair] specifies if the user passed CLI arguments to the processor that make it necessary to only execute those
     * code generation modules, which require explicit invocation.
     */
    private fun determineModulesToExecute(modelKind: ModelKind, moduleArguments: ModuleArguments)
        : Pair<List<CodeGenerationModuleRegistrationInfo>, Boolean> {
        val kindLabel = modelKind.label

        /* Determine modules to execute */
        val candidateModules = AvailableCodeGenerationModules.getModules(modelKind)
        val namesOfExplicitlyInvokedModules = AvailableCodeGenerationModules.getNamesOfAllExplicitlyInvokedModules()
        val (modulesToExecute, onlyExplicitlyInvokedModules) = when {
            // User explicitly requested to only invoke those modules that were specified on the commandline
            PhaseCommandLine.invokeOnlySpecifiedModules -> {
                candidateModules.filter { it.name in moduleArguments.keys } to false
            }

            // In case an explicitly invoked module was stated on the commandline, only invoke those modules that
            // require explicit invocation (this behavior is consistent with that of [AbstractModelProcessor])
            moduleArguments.keys.containsAny(namesOfExplicitlyInvokedModules) ->
                AvailableCodeGenerationModules.getExplicitlyInvokedModules(modelKind) to true

            // Invoke all modules that do not require explicit invocation
            else -> candidateModules.filter { !it.explicitlyInvoked } to false
        }

        if (modulesToExecute.isEmpty())
            debugPhase {
                "No executable code generation modules determinable for $kindLabel model. Maybe the " +
                "${PhaseCommandLine.INVOKE_ONLY_SPECIFIED_MODULES_OPTION_NAME} option was specified without a module " +
                "or only modules of the opposite model kind were selected for execution?"
            }
        // Modules that require explicit invocation cannot specify dependencies to other modules via the dependsOn
        // annotation parameter
        else if (!onlyExplicitlyInvokedModules) {
            val missingDependency = modulesToExecute.missingDependency(modelKind)
            if (missingDependency != null)
                throw ModuleExecutionDeterminationException("Some code generation modules for $kindLabel model " +
                    "depend on module \"$missingDependency\", which was not found in processor implementation " +
                    "package \"$processorImplementationPackage\". Maybe the module was excluded with the " +
                    "${PhaseCommandLine.INVOKE_ONLY_SPECIFIED_MODULES_OPTION_NAME} option?")
        }

        return modulesToExecute to onlyExplicitlyInvokedModules
    }

    /**
     * Exception to communicate that code generation module execution is not feasible and the whole phase is to be
     * aborted
     */
    private class ModuleExecutionDeterminationException(override val message: String) : PhaseException(message)

    /**
     * Execute a stack of code generation modules from their [CodeGenerationModuleRegistrationInfo] for a given
     * [ModelKind]
     */
    private fun Deque<CodeGenerationModuleRegistrationInfo>.execute(modelKind: ModelKind, phaseArguments: List<String>,
        allModuleArguments: ModuleArguments) {
        val kindLabel = modelKind.label

        /* Execute the modules and gather all generated files */
        val allGeneratedFiles = mutableMapOf<String, CharsetAwareFileContent>()
        forEach {
            val moduleArguments = allModuleArguments[it.name]?.toTypedArray() ?: emptyArray()
            if (moduleArguments.isNotEmpty())
                debugPhase {
                    "Executing code generation module \"${it.name}\" for $kindLabel model with arguments " +
                    "\"${moduleArguments.joinToString()}\""
                }
            else
                debugPhase { "Executing code generation module \"${it.name}\" for $kindLabel model without arguments" }

            // Actual module execution
            val generatedFiles = it.instance.execute(phaseArguments.toTypedArray(), moduleArguments)

            if (generatedFiles.isNotEmpty()) {
                debugPhase { "Module generated the following files for $kindLabel model:" }
                generatedFiles.forEach { path, (content, charset) ->
                    debugPhase { "\t- $path (charset: ${charset.name()}, character count: ${content.length})" }
                }
            } else
                debugPhase { "Module did not generate any files for $kindLabel model" }

            allGeneratedFiles.putAll(generatedFiles)
        }

        if (allGeneratedFiles.isEmpty()) {
            println("No files were generated by code generation modules for $kindLabel model")
            return
        }

        /* Write generated contents to files */
        val targetFolder = BasicCommandLine.targetFolder!!
        debugPhase { "Writing generated file contents to disk" }
        for ((filepath, content) in allGeneratedFiles) {
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
 * Helper to calculate an execution plan for this list of [AbstractCodeGenerationModule]s represented as
 * [CodeGenerationModuleRegistrationInfo]s. Note that the function requires the [CodeGenerationModuleRegistrationInfo]s
 * to concern only a single [ModelKind] and will otherwise throw an [IllegalArgumentException].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun List<CodeGenerationModuleRegistrationInfo>.calculateExecutionPlan(onlyExplicitlyInvokedModules: Boolean)
    : Deque<CodeGenerationModuleRegistrationInfo> {
    if (isEmpty())
        return ArrayDeque()

    require(map { it.modelKind }.toSet().size == 1) { "Ambiguous model kinds detected in execution plan calculation" }
    val modelKind = this[0].modelKind

    val independentModules = filter { it.dependsOn.isEmpty() }.map { it.name }
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
    val modulesWithDependents = if (!onlyExplicitlyInvokedModules)
            AvailableCodeGenerationModules.getNamesOfModulesWithDependents(modelKind)
        else
            emptySet()
    val checkDependentsFor = ArrayDeque(modulesWithDependents)
    while (checkDependentsFor.isNotEmpty()) {
        val currentDependency = checkDependentsFor.pop()
        val dependents = AvailableCodeGenerationModules.getDependents(modelKind, currentDependency)

        var maxPositionBeforeDependents = if (dependents.isNotEmpty())
            dependents.map{ executionPlan.indexOf(it) }.min()!!
        else
            -1

        if (maxPositionBeforeDependents > -1) {
            val modulesBefore = executionPlan.subList(0, maxPositionBeforeDependents + 1)
            val circularDependency = if (dependents.isNotEmpty()) modulesBefore.find { it in dependents } else null
            if (circularDependency != null)
                throw PhaseException("Circular dependency detected: Code generation module \"$currentDependency\" " +
                    "depends on \"$circularDependency\" and vice versa, possibly indirectly")
        } else
            maxPositionBeforeDependents = executionPlan.size

        if (!executionPlan.contains(currentDependency))
            executionPlan.add(maxPositionBeforeDependents, currentDependency)

        checkDependentsFor.addAll(dependents)
    }

    val result = ArrayDeque<CodeGenerationModuleRegistrationInfo>()
    val moduleInfoByName = this.associateBy { it.name }
    executionPlan.forEach { result.add(moduleInfoByName[it]!!) }
    return result
}