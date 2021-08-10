package de.fhdo.lemma.model_processing.phases

import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.debugPhase
import de.fhdo.lemma.model_processing.debugPhaseArguments
import de.fhdo.lemma.model_processing.languages.LanguageDescription
import de.fhdo.lemma.model_processing.languages.LanguageDescriptions
import de.fhdo.lemma.model_processing.readModelingNamespacesFromXmi
import org.eclipse.emf.ecore.resource.Resource
import java.lang.IllegalArgumentException

/**
 * Superclass for all model processor phases that conduct model parsing.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal abstract class AbstractModelParsingPhase(private val modelKind: ModelKind) : AbstractModelProcessingPhase() {
    /**
     * Initialize the phase
     */
    final override fun initialize(id: String, isOmittable: Boolean, isBlocking: Boolean,
        processorImplementationPackage: String) {
        super.initialize(id, isOmittable, isBlocking, processorImplementationPackage)

        parameters {
            returns {
                modelKind.modelFilePathParameterName withType String::class.java
                modelKind.modelFileExtensionParameterName withType String::class.java
                modelKind.languageNamespacesParameterName withType Set::class.java
                modelKind.languageDescriptionParameterName withType LanguageDescription::class.java
                modelKind.modelResourceParameterName withType Resource::class.java
            }
        }
    }

    /**
     * Execute the phase
     */
    final override fun process(args: Array<String>) {
        debugPhaseArguments(args)

        /* Handle model file path and extension */
        // Convert model file path to an absolute one to ensure the correct resolution of relative references between
        // models, e.g., when importing a model into another one
        val inputModelFilePath = modelKind.getFilePathOfPassedModelFromCommandLine()!!
        val modelFile = inputModelFilePath.asFile()
        val absoluteModelFilePath = modelFile.absolutePath
        returnModelFilePath(absoluteModelFilePath)
        debugPhase { "Got model file \"$absoluteModelFilePath\" for parsing" }

        val fileExtension = modelFile.extension
        if (fileExtension.isEmpty())
            throw IllegalArgumentException("""Model file "$inputModelFilePath" must have an extension""")
        returnModelFileExtension(fileExtension)

        /* Try to get a language description from the model file's extension */
        val languageDescription = LanguageDescriptions.getLanguageDescription(
            forLanguageNamespace = false,
            forFileExtension = true,
            languageNamespaceOrFileExtension = fileExtension
        )

        if (languageDescription == null)
            debugPhase { "No language description provided for model file extension .$fileExtension" }
        else {
            debugPhase {
                "Received language description with namespace \"${languageDescription.nsUri}\" for model file " +
                "extension .$fileExtension"
            }
            languageDescription.registerLanguage()
            debugPhase { "Language description registered" }
        }

        /* Perform the actual model parsing in case we got a language description based on the model file's extension */
        val modelResource = languageDescription?.loadModel(absoluteModelFilePath)
        if (modelResource != null) {
            debugPhase { "Model file parsed" }
            returnLanguageDescription(languageDescription)
            returnLanguageNamespaces(languageDescription.nsUri)
            returnParsedResource(modelResource)
            return
        }

        /*
         * If we did not receive a language description for the model file's extension, we try XMI as a generic parsing
         * fallback. That is, we try to extract the language namespaces of the model by treating it as an XMI file. From
         * the namespaces, we then try to obtain a language description from the model processor's language description
         * provider.
         */
        debugPhase { "Did not receive a language description. Falling back to XMI parsing." }

        val languageNamespaces = try {
            readModelingNamespacesFromXmi(absoluteModelFilePath)
        } catch (ex: Exception) {
            throw PhaseException("Could not parse model file \"$absoluteModelFilePath\", because no language " +
                "description was provided for file extension .$fileExtension. Tried XMI parsing as fallback but the " +
                "the following error occurred: ${ex.message}")
        }

        var matchingLanguageDescription: LanguageDescription? = null
        for (namespace in languageNamespaces) {
            matchingLanguageDescription = LanguageDescriptions.getLanguageDescription(
                forLanguageNamespace = true,
                forFileExtension = false,
                languageNamespaceOrFileExtension = namespace
            )
            if (matchingLanguageDescription !== null)
                break
        }

        if (matchingLanguageDescription == null)
            throw PhaseException("No language description found for XMI model \"$absoluteModelFilePath\". Language " +
                "description provider ${LanguageDescriptions.getProviderClassname()} did neither return a " +
                "description for the model file's extension .$fileExtension, nor did it return a description for any " +
                "of the model's language namespaces ${languageNamespaces.joinToString()}, which were obtained by " +
                "parsing the model's XMI structure. Without a language description, the model cannot be parsed and " +
                "processed.")

        try {
            matchingLanguageDescription.registerLanguage()
            debugPhase {
                "XMI parsing fallback: XMI Language description with namespace " +
                "\"${matchingLanguageDescription.nsUri}\" registered"
            }
            returnLanguageDescription(matchingLanguageDescription)
            returnLanguageNamespaces(languageNamespaces)
            returnParsedResource(matchingLanguageDescription.loadModel(absoluteModelFilePath))
            debugPhase { "XMI parsing fallback: Model file parsed" }
        } catch(ex: Exception) {
            throw PhaseException("Could not parse model file \"$absoluteModelFilePath\". Tried XMI parsing as " +
                "fallback but the following error occurred: ${ex.message}")
        }
    }

    /**
     * Convenience method to put the model file on the phase heap
     */
    private fun returnModelFilePath(modelFilePath: String) = modelKind.modelFilePathParameterName returns modelFilePath

    /**
     * Convenience method to put the model file's extension on the phase heap
     */
    private fun returnModelFileExtension(modelFileExtension: String)
        = modelKind.modelFileExtensionParameterName returns modelFileExtension

    /**
     * Convenience method to put the model file's language namespaces on the phase heap
     */
    private fun returnLanguageNamespaces(vararg namespaces: String) = returnLanguageNamespaces(setOf(*namespaces))

    /**
     * Convenience method to put the model file's language namespaces passed as [Set] on the phase heap
     */
    private fun returnLanguageNamespaces(namespaces: Set<String>)
        = modelKind.languageNamespacesParameterName returns namespaces

    /**
     * Convenience method to put the model file's parsed Ecore [Resource] on the phase heap
     */
    private fun returnParsedResource(parsedResource: Resource)
        = modelKind.modelResourceParameterName returns parsedResource

    /**
     * Convenience method to put the model file's language description on the phase heap
     */
    private fun returnLanguageDescription(languageDescription: LanguageDescription)
        = modelKind.languageDescriptionParameterName returns languageDescription
}