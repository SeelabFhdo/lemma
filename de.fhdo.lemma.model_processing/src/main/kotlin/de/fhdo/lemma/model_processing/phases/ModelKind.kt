package de.fhdo.lemma.model_processing.phases

import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.model_processing.annotations.SourceModelValidator
import de.fhdo.lemma.model_processing.command_line.BasicCommandLine
import de.fhdo.lemma.model_processing.languages.LanguageDescription
import org.eclipse.emf.ecore.resource.Resource
import kotlin.reflect.KClass

/**
 * Enumeration that identifies a model kind supported by the model processing framework.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
enum class ModelKind(
    /* Printable label of the model kind */
    internal val label: String,

    /* Function to get the file path of the passed model of the model kind from the commandline */
    internal val getFilePathOfPassedModelFromCommandLine: () -> String?,

    /* Identifier of the phase being responsible for parsing models of the model kind */
    private val parsingPhase: String,
    /* Parsing phase return parameter: Path to the parsed model */
    internal val modelFilePathParameterName: String,
    /* Parsing phase return parameter: Extension of the parsed model file */
    internal val modelFileExtensionParameterName: String,
    /* Parsing phase return parameter: Namespace(s) of the parsed model */
    internal val languageNamespacesParameterName: String,
    /* Parsing phase return parameter: Language description of the parsed model */
    internal val languageDescriptionParameterName: String,
    /* Parsing phase return parameter: Ecore Resource of the parsed model */
    internal val modelResourceParameterName: String,

    /* Identifier of the phase being responsible for querying models of the model kind */
    private val queryPhase: String,
    /* Query phase return parameter: List of relevant model elements (i.e., model elements matching the query) */
    internal val relevantElementsParameterName: String,
    /* Query phase return parameter: The query string */
    internal val queryParameterName: String,
    /* Query phase return parameter: Path to the file containing the query string */
    internal val queryFilePathParameterName: String,

    /* Identifier of the phase being responsible for validating models of the model kind */
    internal val validationPhase: String,
    /* Annotation to identify model validators for the model kind on the classpath */
    internal val validatorAnnotation: KClass<out Annotation>,
    /* Validation phase return parameter: Phase arguments */
    internal val validationPhaseArgumentsParameterName: String
) {
    /* Source model kind */
    SOURCE(
        label = "source",

        getFilePathOfPassedModelFromCommandLine = { BasicCommandLine.sourceModelFile },

        parsingPhase = "source_model_parsing",
        modelFilePathParameterName = "sourceModelFilePath",
        modelFileExtensionParameterName = "sourceModelFileExtension",
        languageNamespacesParameterName = "sourceModelLanguageNamespaces",
        languageDescriptionParameterName = "sourceModelLanguageDescription",
        modelResourceParameterName = "sourceModelResource",

        queryPhase = "source_model_query",
        relevantElementsParameterName = "sourceModelRelevantElements",
        queryParameterName = "sourceModelQuery",
        queryFilePathParameterName = "sourceModelQueryFile",

        validationPhase = "source_model_validation",
        validatorAnnotation = SourceModelValidator::class,
        validationPhaseArgumentsParameterName = "sourceModelValidationPhaseArguments"
    ),

    /* Intermediate model kind */
    INTERMEDIATE(
        label = "intermediate",

        getFilePathOfPassedModelFromCommandLine = { BasicCommandLine.intermediateModelFile },

        parsingPhase = "intermediate_model_parsing",
        modelFilePathParameterName = "intermediateModelFilePath",
        modelFileExtensionParameterName = "intermediateModelFileExtension",
        languageNamespacesParameterName = "intermediateModelLanguageNamespaces",
        languageDescriptionParameterName = "intermediateModelLanguageDescription",
        modelResourceParameterName = "intermediateModelResource",

        queryPhase = "intermediate_model_query",
        relevantElementsParameterName = "intermediateModelRelevantElements",
        queryParameterName = "intermediateModelQuery",
        queryFilePathParameterName = "intermediateModelQueryFile",

        validationPhase = "intermediate_model_validation",
        validatorAnnotation = IntermediateModelValidator::class,
        validationPhaseArgumentsParameterName = "intermediateModelValidationPhaseArguments"
    );

    /**
     * Check if a model of the model king got passed to the model processor
     */
    internal fun modelOfKindPassedForProcessing() = PhaseHeap[parsingPhase, modelFilePathParameterName] != null

    /**
     * Get the path to the model of the model kind from the phase heap
     */
    internal fun getFilePathOfPassedModelFromHeap() = PhaseHeap[parsingPhase, modelFilePathParameterName] as? String

    /**
     * Get the extension of the model file of the model kind from the phase heap
     */
    internal fun getExtensionOfPassedModel() = PhaseHeap[parsingPhase, modelFileExtensionParameterName] as? String

    /**
     * Get the language description of the model of the model kind from the phase heap
     */
    internal fun getLanguageDescriptionOfPassedModel()
        = PhaseHeap[parsingPhase, languageDescriptionParameterName] as? LanguageDescription

    /**
     * Get the Ecore Resource of the parsed model of the model kind from the phase heap
     */
    internal fun getResourceOfPassedModel() = PhaseHeap[parsingPhase, modelResourceParameterName] as? Resource

    /**
     * Get the relevant model elements of the model of the model kind from the phase heap
     */
    internal fun getRelevantElementsOfPassedModel()
        = PhaseHeap[queryPhase, relevantElementsParameterName] as? Collection<*>?

    /**
     * Get the query for the relevant elements of the model of the model kind from the phase heap
     */
    internal fun getQueryOfPassedModel() = PhaseHeap[queryPhase, queryParameterName] as? String

    /**
     * Get the language namespaces of the model of the model kind from the phase heap
     */
    @Suppress("UNCHECKED_CAST")
    internal fun getLanguageNamespacesOfPassedModel() = PhaseHeap[parsingPhase, languageNamespacesParameterName]
        as? Set<String>
}