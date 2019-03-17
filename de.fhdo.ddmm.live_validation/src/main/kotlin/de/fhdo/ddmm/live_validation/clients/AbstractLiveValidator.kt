package de.fhdo.ddmm.live_validation.clients

import de.fhdo.ddmm.live_validation.protocol.LiveValidationLanguageClient
import de.fhdo.ddmm.live_validation.protocol.PublishIssuesParams
import java.io.OutputStream
import java.util.concurrent.CompletableFuture

/**
 * Abstract superclass for Live Validators, i.e., components that perform a Live Validation.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
abstract class AbstractLiveValidator : BaseClient(), LiveValidationLanguageClient {
    /**
     * Establish connection to a Live Validation server
     */
    @JvmOverloads fun start(hostname: String, port: Int, rootUri: String? = null, traceStream: OutputStream? = null) {
        super.start(hostname, port, this, rootUri, traceStream)
    }

    /**
     * Retrieve supported file extensions to identify the file formats a concrete Live Validator may handle
     */
    abstract fun getSupportedFileExtensions() : Set<String>

    /**
     * Convenience implementation of [LiveValidationLanguageClient.requestValidatorRegistration]. Internally invokes
     * [getSupportedFileExtensions].
     */
    final override fun requestValidatorRegistration(): CompletableFuture<Set<String>>
        = CompletableFuture.completedFuture(getSupportedFileExtensions())

    /**
     * NOOP implementation of [LiveValidationLanguageClient.publishIssues], because Live Validators never simultaneously
     * act as Live Validation initiators, i.e., hence validation result receivers
     */
    final override fun publishIssues(publishIssuesParams: PublishIssuesParams) { }
}