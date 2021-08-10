package de.fhdo.lemma.model_processing.builtin_phases.code_generation

import de.fhdo.lemma.model_processing.languages.LanguageDescription
import de.fhdo.lemma.model_processing.phases.ModelKind
import org.eclipse.emf.ecore.resource.Resource
import java.nio.charset.Charset

typealias CharsetAwareFileContent = Pair<String, Charset>

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
    @Suppress("MemberVisibilityCanBePrivate")
    lateinit var dependsOn: String
        private set
    @Suppress("MemberVisibilityCanBePrivate")
    lateinit var properties: Map<String, String>
        private set
    @Suppress("MemberVisibilityCanBePrivate")
    lateinit var modelFile: String
        private set
    @Suppress("MemberVisibilityCanBePrivate")
    lateinit var targetFolder: String
        private set
    @Suppress("MemberVisibilityCanBePrivate")
    lateinit var languageDescription: LanguageDescription
        private set
    lateinit var resource: Resource
        private set
    @Suppress("MemberVisibilityCanBePrivate")
    lateinit var modelKind: ModelKind
        private set
    @Suppress("MemberVisibilityCanBePrivate")
    var relevantModelElements: Collection<*>? = null
        private set
    @Suppress("MemberVisibilityCanBePrivate")
    var modelElementQuery: String? = null
        private set

    /**
     * Get supported language namespace
     */
    abstract fun getLanguageNamespace() : String

    /**
     * Implementation of the actual code generation. The arguments of the [CodeGenerationPhase] invocation will be
     * passed within the [phaseArguments]. If the module accepts its own specific arguments, these will be passed within
     * the [moduleArguments]. The code generation implementation is expected to return a map consisting of the target
     * path of a generated file, and its content and charset.
     */
    abstract fun execute(phaseArguments: Array<String>, moduleArguments: Array<String>)
        : Map<String, CharsetAwareFileContent>

    /**
     * Helper to convert a map of generated files (key: path, value: content) to a map that assigns a common charset to
     * each content value.
     */
    @Suppress("unused")
    protected fun withCharset(map: Map<String, String>, charsetName: String) : Map<String, CharsetAwareFileContent> {
        val resultMap = mutableMapOf<String, CharsetAwareFileContent>()
        map.forEach { (k, v) ->
            resultMap[k] = v to Charset.forName(charsetName)
        }
        return resultMap
    }

    /**
     * Initializes the module. Gets invoked by [CodeGenerationPhase].
     */
    internal fun initialize(
        name: String,
        dependsOn: String,
        properties: Map<String, String>,
        modelKind: ModelKind,
        targetFolder: String
    ) {
        if (initialized)
            throw IllegalStateException("Module was already initialized")

        this.name = name
        this.dependsOn = dependsOn
        this.properties = properties
        this.modelKind = modelKind
        this.modelFile = modelKind.getFilePathOfPassedModelFromHeap()!!
        this.targetFolder = targetFolder
        this.languageDescription = modelKind.getLanguageDescriptionOfPassedModel()!!
        this.resource = modelKind.getResourceOfPassedModel()!!
        this.relevantModelElements = modelKind.getRelevantElementsOfPassedModel()
        this.modelElementQuery = modelKind.getQueryOfPassedModel()

        initialized = true
    }
}