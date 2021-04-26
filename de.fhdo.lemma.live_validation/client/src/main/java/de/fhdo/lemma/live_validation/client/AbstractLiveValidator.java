package de.fhdo.lemma.live_validation.client;

import de.fhdo.lemma.live_validation.protocol.extensions.PublishIssuesParams;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * Abstract superclass for Live Validators, i.e., components that perform a Live Validation.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
public abstract class AbstractLiveValidator extends BaseClient {
    /**
     * Retrieve supported file extensions to identify the file formats a concrete Live Validator may handle
     */
    public abstract Set<String> getSupportedFileExtensions();

    /**
     * Convenience implementation of LiveValidationLanguageClient.requestValidatorRegistration. Internally invokes
     * getSupportedFileExtensions.
     */
    @Override
    public final CompletableFuture<Set<String>> requestValidatorRegistration() {
        return CompletableFuture.completedFuture(getSupportedFileExtensions());
    }

    /**
     * NOOP implementation of LiveValidationLanguageClient.publishIssues, because Live Validators never simultaneously
     * act as Live Validation initiators
     */
    @Override
    public final void publishIssues(PublishIssuesParams publishIssuesParams) {
        // NOOP
    }
}
