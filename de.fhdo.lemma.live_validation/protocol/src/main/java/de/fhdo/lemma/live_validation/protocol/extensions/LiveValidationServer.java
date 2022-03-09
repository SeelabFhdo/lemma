package de.fhdo.lemma.live_validation.protocol.extensions;

import org.eclipse.lsp4j.DidChangeTextDocumentParams;
import org.eclipse.lsp4j.jsonrpc.services.JsonNotification;
import org.eclipse.lsp4j.jsonrpc.services.JsonRequest;
import org.eclipse.lsp4j.services.LanguageServer;

import java.util.concurrent.CompletableFuture;

/**
 * Server-side LSP extensions for Live Validation (cf. the Live Validation protocol documentation in the
 * "Documentation.md" file for further details).
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
public interface LiveValidationServer extends LanguageServer {
    // Shared Live Validation constants
    String DEFAULT_HOSTNAME = "localhost";
    int DEFAULT_PORT = 44203;
    long DEFAULT_TIMEOUT_THRESHOLDS_IN_MILLISECONDS = 2000L;
    String EXTENSION_PREFIX = "live_validation";

    /**
     * Send Disconnect request from any Live Validation client to server
     */
    @JsonRequest(EXTENSION_PREFIX + "/client/disconnect")
    CompletableFuture<Void> requestDisconnect();

    /**
     * Send Bye notification from any Live Validation client to server
     */
    @JsonNotification(EXTENSION_PREFIX + "/client/bye")
    void bye();

    /**
     * Trigger PerformValidation requests from server to registered validating Live Validation clients, i.e., clients
     * that realize the AbstractLiveValidator class from the Live Validation client project
     */
    void performValidations(DidChangeTextDocumentParams params);
}
