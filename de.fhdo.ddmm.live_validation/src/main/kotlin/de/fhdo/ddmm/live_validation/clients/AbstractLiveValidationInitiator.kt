package de.fhdo.ddmm.live_validation.clients

import de.fhdo.ddmm.live_validation.common.IssueDiagnostic
import de.fhdo.ddmm.live_validation.protocol.LiveValidationLanguageClient
import de.fhdo.ddmm.live_validation.protocol.notifyDidChange
import java.io.OutputStream
import java.lang.IllegalStateException
import java.util.concurrent.CompletableFuture

/**
 * Abstract superclass for Live Validation initiators, i.e., components that trigger a Live Validation and eventually
 * receive the results.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
abstract class AbstractLiveValidationInitiator : BaseClient(), LiveValidationLanguageClient {
    /**
     * Establish connection to a Live Validation server
     */
    @JvmOverloads fun start(hostname: String, port: Int, rootUri: String? = null, traceStream: OutputStream? = null) {
        super.start(hostname, port, this, rootUri, traceStream)
    }

    /**
     * NOOP implementation of [LiveValidationLanguageClient.requestValidatorRegistration] as Live Validation initiators,
     * i.e., subclasses of [AbstractLiveValidationInitiator], never simultaneously act as validators
     */
    final override fun requestValidatorRegistration(): CompletableFuture<Set<String>>
        = CompletableFuture.completedFuture(null)

    /**
     * NOOP implementation of [LiveValidationLanguageClient.requestValidation] as Live Validation initiators never
     * simultaneously act as validators
     */
    final override fun requestValidation(documentUri: String, sourceCode: String)
        : CompletableFuture<List<IssueDiagnostic>> {
        return CompletableFuture.failedFuture(IllegalStateException("Client is not a validator"))
    }

    /**
     * Initiate validation of a document and the source code it contains
     */
    fun validate(documentUri: String, sourceCode: String) {
        server.notifyDidChange(documentUri, sourceCode)
    }
}