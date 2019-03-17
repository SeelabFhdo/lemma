package de.fhdo.ddmm.model_processing.builtin_phases.live_validation

import de.fhdo.ddmm.live_validation.clients.AbstractLiveValidator
import de.fhdo.ddmm.live_validation.common.IssueDiagnostic
import de.fhdo.ddmm.model_processing.asFile
import de.fhdo.ddmm.model_processing.builtin_phases.source_model_validation.SourceModelValidationPhase
import de.fhdo.ddmm.model_processing.builtin_phases.ValidationResultType
import de.fhdo.ddmm.model_processing.builtin_phases.toIssueDiagnostic
import io.github.classgraph.ClassInfo
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import java.util.concurrent.CompletableFuture

/**
 * Implementation of [AbstractLiveValidator] for the model processor's Live Validation phase. It delegates
 * PerformValidation requests to the [SourceModelValidationPhase].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class LiveValidator(private val validatorsForExtensions: Map<String, List<ClassInfo>>)
    : AbstractLiveValidator() {
    /**
     * Return the supported file extensions determined via the
     * [de.fhdo.ddmm.model_processing.annotations.SourceModelValidator] annotation.
     */
    override fun getSupportedFileExtensions() : Set<String> {
        return validatorsForExtensions.keys
    }

    /**
     * Callback to handle PerformValidation requests
     */
    override fun requestValidation(documentUri: String, sourceCode: String)
        : CompletableFuture<List<IssueDiagnostic>> {
        val fileExtension = documentUri.asFile().extension
        if (fileExtension !in validatorsForExtensions)
            return CompletableFuture.completedFuture(emptyList())

        /* Run all validators found on the classpath and passed to this instance in parallel coroutines */
        val validationResults = runBlocking {
            validatorsForExtensions.getValue(fileExtension)
                // Delegate the validation to Xtext-specific source model validation
                .map {
                    async {
                        SourceModelValidationPhase.executeXtextValidator(it, documentUri, sourceCode.byteInputStream())
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
}