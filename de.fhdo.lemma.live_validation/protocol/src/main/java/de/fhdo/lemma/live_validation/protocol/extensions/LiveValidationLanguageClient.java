package de.fhdo.lemma.live_validation.protocol.extensions;

import de.fhdo.lemma.live_validation.model.IssueDiagnostic;
import org.eclipse.lsp4j.jsonrpc.services.JsonNotification;
import org.eclipse.lsp4j.jsonrpc.services.JsonRequest;
import org.eclipse.lsp4j.services.LanguageClient;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static de.fhdo.lemma.live_validation.protocol.extensions.LiveValidationServer.EXTENSION_PREFIX;

/**
 * Client-side LSP extensions for Live Validation (cf. the Live Validation protocol documentation in the
 * "Documentation.md" file for further details).
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
public interface LiveValidationLanguageClient extends LanguageClient {
    /**
     * Send RegisterValidator request from server to any initialized Live Validation clients
     */
    @JsonRequest(EXTENSION_PREFIX + "/client/registerValidator")
    CompletableFuture<Set<String>> requestValidatorRegistration();

    /**
     * Send PerformValidation request from server to validating Live Validation clients, i.e., clients that realize the
     * AbstractLiveValidator class from the Live Validation client project
     */
    @JsonRequest(EXTENSION_PREFIX + "/textDocument/performValidation")
    CompletableFuture<List<IssueDiagnostic>> requestValidation(String documentUri, String sourceCode);

    /**
     * Send PublishIssues notification from server to initiating Live Validation clients, i.e., clients that realize the
     * AbstractLiveValidationInitiator class from the Live Validation client project
     */
    @JsonNotification(EXTENSION_PREFIX + "/textDocument/publishIssues")
    void publishIssues(PublishIssuesParams publishIssuesParams);
}