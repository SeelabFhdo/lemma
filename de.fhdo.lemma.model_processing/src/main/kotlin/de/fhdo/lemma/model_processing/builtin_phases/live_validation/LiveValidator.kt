package de.fhdo.lemma.model_processing.builtin_phases.live_validation

import de.fhdo.lemma.live_validation.clients.AbstractLiveValidator
import de.fhdo.lemma.live_validation.common.IssueDiagnostic
import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.builtin_phases.ValidationResult
import de.fhdo.lemma.model_processing.builtin_phases.ValidationResultType
import de.fhdo.lemma.model_processing.builtin_phases.toIssueDiagnostic
import de.fhdo.lemma.model_processing.extendsImplementsOrException
import de.fhdo.lemma.model_processing.languages.LanguageDescription
import de.fhdo.lemma.model_processing.languages.LanguageDescriptions
import de.fhdo.lemma.model_processing.languages.XtextLanguageDescription
import de.fhdo.lemma.model_processing.loadXtextResource
import de.fhdo.lemma.model_processing.phases.validation.AbstractXtextModelValidator
import de.fhdo.lemma.model_processing.printlnWarning
import io.github.classgraph.ClassInfo
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.eclipse.xtext.resource.XtextResource
import java.util.concurrent.CompletableFuture

/**
 * Implementation of [AbstractLiveValidator] for the model processor's Live Validation phase. It delegates
 * PerformValidation requests to applicable [AbstractXtextModelValidator]s.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class LiveValidator(
    private val validatorsAndArgumentsForExtensions: Map<String, List<ValidatorClassWithPhaseArguments>>
) : AbstractLiveValidator() {
    /**
     * Return the file extensions supported by the given [validatorsAndArgumentsForExtensions]
     */
    override fun getSupportedFileExtensions() : Set<String> {
        return validatorsAndArgumentsForExtensions.keys
    }

    /**
     * Callback to handle PerformValidation requests
     */
    override fun requestValidation(documentUri: String, sourceCode: String)
        : CompletableFuture<List<IssueDiagnostic>> {
        val fileExtension = documentUri.asFile().extension
        if (fileExtension !in validatorsAndArgumentsForExtensions)
            return CompletableFuture.completedFuture(emptyList())

        /* Load model to validate as an Ecore Resource */
        val languageDescription = LanguageDescriptions.getLanguageDescription(
            forLanguageNamespace = false,
            forFileExtension = true,
            languageNamespaceOrFileExtension = fileExtension
        )
        if (languageDescription == null || languageDescription !is XtextLanguageDescription) {
            printlnWarning("No Xtext language description found for file \"$documentUri\". Live validation aborted.")
            return CompletableFuture.completedFuture(emptyList())
        }

        languageDescription.registerLanguage()
        val validationResource = loadXtextResource(languageDescription.languageSetup, documentUri,
            sourceCode.byteInputStream())

        /*
         * Run all validators, which have been found on the classpath and that were passed to this instance, with their
         * respective phase arguments in parallel coroutines
         */
        val validationResults = runBlocking {
            validatorsAndArgumentsForExtensions.getValue(fileExtension)
                // Delegate the validation to Xtext-enabled validators
                .map {
                    async {
                        val (validatorInfo, phaseArguments) = it
                        executeXtextValidator(validatorInfo, phaseArguments, validationResource, languageDescription)
                    }
                }
                .map { it.await() }
                .flatten()
        }

        /* Collect issues and send them to the Live Validation server */
        val relevantIssueDiagnostics = mutableListOf<IssueDiagnostic>()
        // We do not use filtering and mapping for the conversion due to performance reasons
        validationResults.forEach {
            if (it.type != ValidationResultType.IGNORE)
                relevantIssueDiagnostics.add(it.toIssueDiagnostic())
        }

        return CompletableFuture.completedFuture(relevantIssueDiagnostics)
    }

    /**
     * Execute an Xtext-enabled validator. An Xtext-enabled validator extends [AbstractXtextModelValidator] to leverage
     * Xtext's annotation-based validation mechanism.
     */
    private fun executeXtextValidator(
        validatorInfo: ClassInfo,
        phaseArguments: Array<String>,
        validationResource: XtextResource,
        languageDescription: LanguageDescription
    ) : List<ValidationResult> {
        validatorInfo.extendsImplementsOrException(
            "Designated Xtext-enabled model validator",
            expectedSuperclass = AbstractXtextModelValidator::class
        )

        val validatorInstance = validatorInfo
            .loadClass(AbstractXtextModelValidator::class.java)
            .getDeclaredConstructor()
            .newInstance()
        validatorInstance.setPhaseArguments(phaseArguments)

        return validatorInstance(validationResource, languageDescription, null)
    }
}