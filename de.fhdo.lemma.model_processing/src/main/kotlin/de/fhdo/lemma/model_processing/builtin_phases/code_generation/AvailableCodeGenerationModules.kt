package de.fhdo.lemma.model_processing.builtin_phases.code_generation

import de.fhdo.lemma.model_processing.annotations.CodeGenerationModule
import de.fhdo.lemma.model_processing.annotations.ExplicitlyInvokedCodeGenerationModule
import de.fhdo.lemma.model_processing.annotations.findAnnotatedClasses
import de.fhdo.lemma.model_processing.annotations.get
import de.fhdo.lemma.model_processing.command_line.BasicCommandLine
import de.fhdo.lemma.model_processing.debugPhase
import de.fhdo.lemma.model_processing.extendsImplementsOrException
import de.fhdo.lemma.model_processing.phases.ModelKind
import de.fhdo.lemma.model_processing.phases.PhaseException
import io.github.classgraph.AnnotationEnumValue
import kotlin.reflect.KClass

private typealias ModelKindSpecificDependencyRelationships
    = MutableMap<ModelKind, MutableMap<String, MutableList<String>>>

/**
 * Object to maintain a conveniently accessible runtime list of [CodeGenerationModule]s discovered on the classpath.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object AvailableCodeGenerationModules {
    private lateinit var codeGenerationProperties: Map<String, String>
    private val moduleNames = mutableSetOf<String>()
    private val moduleIdentifiers = mutableSetOf<String>()
    private val dependencyRelationships: ModelKindSpecificDependencyRelationships = mutableMapOf()
    private val modulesByModelKind = mutableMapOf<ModelKind, MutableList<CodeGenerationModuleRegistrationInfo>>()
    private val explicitlyInvokedModulesByModelKind
        = mutableMapOf<ModelKind, MutableList<CodeGenerationModuleRegistrationInfo>>()
    private val explicitlyInvokedModulesNames = mutableSetOf<String>()

    /**
     * Initialize the object
     */
    fun initialize(processorPackage: String, codeGenerationProperties: Map<String, String>) {
        this.codeGenerationProperties = codeGenerationProperties

        registerModules(processorPackage, ModelKind.SOURCE)
        registerModules(processorPackage, ModelKind.INTERMEDIATE)
    }

    /**
     * Register code generation modules for the given [modelKind]
     */
    private fun registerModules(processorPackage: String, modelKind: ModelKind) {
        // Check if code generation for model kind is actually feasible
        if (!modelKind.modelOfKindPassedForProcessing()) {
            debugPhase { "No ${modelKind.label} model passed. Code generation for this model kind aborted." }
            return
        }

        // Perform the actual registration
        registerModules(findCodeGenerationModules(processorPackage, CodeGenerationModule::class, modelKind))
        registerModules(findCodeGenerationModules(processorPackage, ExplicitlyInvokedCodeGenerationModule::class,
            modelKind))
    }

    /**
     * Register code generation modules from a given list if [CodeGenerationModuleRegistrationInfo]s in the object
     */
    private fun registerModules(registrationInfos: List<CodeGenerationModuleRegistrationInfo>) {
        registrationInfos.forEach {
            /* Initialize the module's instance*/
            it.initializeInstance()

            /* Add module name to name and identifier set, respectively */
            moduleNames.add(it.name)
            // A module may be registered twice, i.e., once for source models and once for intermediate models. A module
            // identifier considers this circumstance as it involves the model kind targeted by a module
            if (it.identifier in moduleIdentifiers)
                throw PhaseException("Duplicate module detected: \"${it.name}\"")
            moduleIdentifiers.add(it.identifier)

            /*
             * Add module to the map of dependency relationships. The map assigns the list of dependent modules (values)
             * to those modules they depend on (key).
             */
            if (it.dependsOn.isNotEmpty()) {
                if (it.modelKind !in dependencyRelationships)
                    dependencyRelationships[it.modelKind] = mutableMapOf()

                val dependencyRelationshipsForModelKind = dependencyRelationships[it.modelKind]!!
                if (it.dependsOn !in dependencyRelationshipsForModelKind)
                    dependencyRelationshipsForModelKind[it.dependsOn] = mutableListOf()

                val dependencyRelationshipsForModule = dependencyRelationshipsForModelKind[it.dependsOn]!!
                dependencyRelationshipsForModule.add(it.name)
            }

            /* Add module to modules-by-model-kind view */
            if (it.modelKind !in modulesByModelKind)
                modulesByModelKind[it.modelKind] = mutableListOf()
            modulesByModelKind[it.modelKind]!!.add(it)

            /* Add module to the views of modules that require explicit invocation */
            if (it.explicitlyInvoked) {
                explicitlyInvokedModulesNames.add(it.name)
                if (it.modelKind !in explicitlyInvokedModulesByModelKind)
                    explicitlyInvokedModulesByModelKind[it.modelKind] = mutableListOf()
                explicitlyInvokedModulesByModelKind[it.modelKind]!!.add(it)
            }
        }
    }

    /**
     * Initialize the instance of the code generation module represented by this [CodeGenerationModuleRegistrationInfo]
     */
    private fun CodeGenerationModuleRegistrationInfo.initializeInstance()
        = instance.initialize(
            name,
            dependsOn,
            codeGenerationProperties,
            modelKind,
            BasicCommandLine.targetFolder!!
        )

    /**
     * Get the names of all registered modules
     */
    fun getAllModuleNames() = moduleNames.toSet()

    /**
     * Exist modules for the given [ModelKind]
     */
    fun existModules(modelKind: ModelKind) = modelKind in modulesByModelKind

    /**
     * Get all modules for the given [ModelKind]
     */
    fun getModules(modelKind: ModelKind) = modulesByModelKind[modelKind]?.toList() ?: emptyList()

    /**
     * Get the names of all modules that require explicit invocation
     */
    fun getNamesOfAllExplicitlyInvokedModules() = explicitlyInvokedModulesNames.toSet()

    /**
     * Get all modules that require explicit invocation for the given [ModelKind]
     */
    fun getExplicitlyInvokedModules(modelKind: ModelKind)
        = explicitlyInvokedModulesByModelKind[modelKind]?.toList() ?: emptyList()

    /**
     * Check if there is a missing dependency in this list of [CodeGenerationModuleRegistrationInfo]s for the given
     * [ModelKind]
     */
    fun List<CodeGenerationModuleRegistrationInfo>.missingDependency(modelKind: ModelKind) : String? {
        if (modelKind !in dependencyRelationships)
            return null

        val moduleNames = this.map { it.name }
        return dependencyRelationships[modelKind]!!.keys.find { it !in moduleNames }
    }

    /**
     * Get the names of all modules, on which other modules depend, for the given [ModelKind]
     */
    fun getNamesOfModulesWithDependents(modelKind: ModelKind)
        = dependencyRelationships[modelKind]?.keys?.toSet() ?: emptySet()

    /**
     * Get the dependent modules for the given [ModelKind] and the module with name [moduleName]
     */
    fun getDependents(modelKind: ModelKind, moduleName: String)
        = dependencyRelationships[modelKind]?.get(moduleName)?.toList() ?: emptyList()
}

/**
 * Class to store registration information about a code generation module.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class CodeGenerationModuleRegistrationInfo(
    val name: String,
    val explicitlyInvoked: Boolean,
    val modelKind: ModelKind,
    val dependsOn: String,
    val languageNamespace: String,
    val instance: AbstractCodeGenerationModule)
{
    val identifier: String = "${modelKind.label}__$name"
}

/**
 * Find all code generation modules in the given [processorPackage] that have an annotation of type [annotationClass]
 * and that concern models of kind [modelKind].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun findCodeGenerationModules(processorPackage: String, annotationClass: KClass<out Annotation>,
    modelKind: ModelKind) : List<CodeGenerationModuleRegistrationInfo> {
    val registrationInfos = mutableListOf<CodeGenerationModuleRegistrationInfo>()

    val explicitlyInvoked = annotationClass == ExplicitlyInvokedCodeGenerationModule::class
    for (classInfo in findAnnotatedClasses(processorPackage, annotationClass)) {
        /* Code generation modules must extend AbstractCodeGenerationModule */
        classInfo.extendsImplementsOrException(
            "Code generation module",
            expectedSuperclass = AbstractCodeGenerationModule::class
        )

        /* Handle name */
        val annotationInfo = classInfo.annotationInfo[annotationClass]!!
        val moduleName = annotationInfo.parameterValues["name"].value as String
        if (moduleName.isEmpty())
            throw PhaseException("Name of code generation module implemented in class \"${classInfo.simpleName}\" " +
                "must not be empty")

        /* Handle model kind */
        @Suppress("UNCHECKED_CAST")
        val modelKinds = (annotationInfo.parameterValues["modelKinds"].value as Array<Any>)
            .map { ModelKind.valueOf((it as AnnotationEnumValue).valueName) }
        if (modelKind !in modelKinds)
            continue

        /* Handle dependency information */
        // dependsOn annotation parameter does not exist for modules that require explicit invocation
        val dependsOn = annotationInfo.parameterValues["dependsOn"]?.value as? String ?: ""

        /* Handle language namespace */
        val moduleInstance = classInfo.loadClass(AbstractCodeGenerationModule::class.java)
            .getDeclaredConstructor()
            .newInstance()
        val languageNamespace = moduleInstance.getLanguageNamespace()

        /* Gather collected registration information */
        registrationInfos.add(CodeGenerationModuleRegistrationInfo(
            moduleName,
            explicitlyInvoked,
            modelKind,
            dependsOn,
            languageNamespace,
            moduleInstance
        ))
    }

    val invocationHint = if (explicitlyInvoked) " *with required explicit invocation*" else ""
    if (registrationInfos.isNotEmpty()) {
        debugPhase {
            "Found the following code generation modules$invocationHint for ${modelKind.label} model in processor " +
            "implementation package:"
        }
        registrationInfos.forEach { debugPhase {
            "\t- ${it.name} (language namespace: ${it.languageNamespace}" +
            if (it.dependsOn.isNotEmpty()) ", depends on: ${it.dependsOn})" else ")"
        } }
    } else
        debugPhase {
            "Found no code generation modules$invocationHint for ${modelKind.label} in processor implementation package"
        }

    return registrationInfos
}