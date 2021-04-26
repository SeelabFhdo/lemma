package de.fhdo.lemma.live_validation.client;

import de.fhdo.lemma.live_validation.model.IssueDiagnostic;
import static de.fhdo.lemma.live_validation.protocol.client.ClientProtocolImpl.notifyDidChange;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * Abstract superclass for Live Validation initiators, i.e., components that trigger a Live Validation and eventually
 * receive the results.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
public abstract class AbstractLiveValidationInitiator extends BaseClient {
    /**
     * NOOP implementation of LiveValidationLanguageClient.requestValidatorRegistration as Live Validation initiators,
     * i.e., subclasses of AbstractLiveValidationInitiator, never simultaneously act as validators
     */
    @Override
    public final CompletableFuture<Set<String>> requestValidatorRegistration() {
        return CompletableFuture.completedFuture(null);
    }

    /**
     * NOOP implementation of LiveValidationLanguageClient.requestValidation as Live Validation initiators never
     * simultaneously act as validators
     */
    @Override
    public final CompletableFuture<List<IssueDiagnostic>> requestValidation(String documentUri, String sourceCode) {
        return CompletableFuture.failedFuture(new IllegalStateException("Client is not a validator"));
    }

    /**
     * Initiate validation of a document and the source code it contains
     */
    public void validate(String documentUri, String sourceCode) {
        notifyDidChange(server, documentUri, sourceCode);
    }
}
