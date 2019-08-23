package de.fhdo.lemma.model_processing.builtin_phases.code_generation

import de.fhdo.lemma.model_processing.languages.LanguageDescription
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import java.nio.charset.Charset

/**
 * Abstract superclass for code generation modules.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
abstract class AbstractCodeGenerationModule {
    private var initialized = false

    /* These properties will be passed to the module by the [CodeGenerationPhase] with invoking [initialize] */
    lateinit var name: String
        private set
    lateinit var dependsOn: String
        private set
    lateinit var properties: Map<String, String>
        private set
    lateinit var intermediateModelFile: String
        private set
    lateinit var targetFolder: String
        private set
    lateinit var intermediateModelResource: Resource
        private set
    var relevantModelElements: List<EObject>? = null
        private set
    var modelElementQuery: String? = null
        private set

    /**
     * Get language description of intermediate model
     */
    abstract fun getLanguageDescription() : LanguageDescription

    /**
     * Flag to indicate if this module accepts its own module-specific arguments
     */
    protected fun acceptsModuleSpecificArguments() = false

    /**
     * Implementation of the actual code generation. The arguments of the [CodeGenerationPhase] invocation will be
     * passed within the [phaseArguments]. If the module accepts its own specific arguments, these will be passed within
     * the [moduleArguments]. The code generation implementation is expected to return a map consisting of the target
     * path of a generated file, and its content and charset.
     */
    abstract fun execute(phaseArguments: Array<String>, moduleArguments: Array<String>)
        : Map<String, Pair<String, Charset>>

    /**
     * Helper to convert a map of generated files (key: path, value: content) to a map that assigns a common charset to
     * each content value.
     */
    protected fun withCharset(map: Map<String, String>, charsetName: String) : Map<String, Pair<String, Charset>> {
        val resultMap = mutableMapOf<String, Pair<String, Charset>>()
        map.forEach { (k, v) ->
            resultMap[k] = v to Charset.forName(charsetName)
        }
        return resultMap
    }

    /**
     * Initializes the module. Gets invoked by [CodeGenerationPhase].
     */
    internal fun initialize(name: String, dependsOn: String, properties: Map<String, String>,
        intermediateModelFile: String, targetFolder: String, intermediateModelResource: Resource,
        relevantModelElements: List<EObject>?, modelElementQuery: String?) {
        if (initialized)
            throw IllegalStateException("Module was already initialized")

        this.name = name
        this.dependsOn = dependsOn
        this.properties = properties
        this.intermediateModelFile = intermediateModelFile
        this.targetFolder = targetFolder
        this.intermediateModelResource = intermediateModelResource
        this.relevantModelElements = relevantModelElements
        this.modelElementQuery = modelElementQuery

        initialized = true
    }
}