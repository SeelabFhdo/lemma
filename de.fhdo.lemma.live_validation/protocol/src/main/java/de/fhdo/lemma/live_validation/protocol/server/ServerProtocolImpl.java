package de.fhdo.lemma.live_validation.protocol.server;

import de.fhdo.lemma.live_validation.model.IssueDiagnostic;
import de.fhdo.lemma.live_validation.protocol.extensions.LiveValidationCapabilities;
import de.fhdo.lemma.live_validation.protocol.extensions.LiveValidationLanguageClient;
import de.fhdo.lemma.live_validation.protocol.extensions.PublishIssuesParams;
import org.eclipse.lsp4j.InitializeResult;
import org.eclipse.lsp4j.SaveOptions;
import org.eclipse.lsp4j.ServerCapabilities;
import org.eclipse.lsp4j.TextDocumentSyncKind;
import org.eclipse.lsp4j.TextDocumentSyncOptions;
import org.eclipse.lsp4j.WorkspaceFoldersOptions;
import org.eclipse.lsp4j.WorkspaceServerCapabilities;
import org.eclipse.lsp4j.services.LanguageClient;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Server-side LSP protocol implementation for Live Validation (cf. the Live Validation protocol documentation in the
 * "Documentation.md" file for further details).
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
public final class ServerProtocolImpl {
    /**
     * Create a unique identifier for a Live Validation client connected to the server
     */
    public static int identifier(LanguageClient client) {
        return System.identityHashCode(client);
    }

    /**
     * Create the log prefix for LSP message exchange related to a specific Live Validation client
     */
    public static String logPrefix(LanguageClient client) {
        return String.format("[Client %d]:", identifier(client));
    }

    /**
     * Send server response for an LSP
     * <a href="https://microsoft.github.io/language-server-protocol/specification#initialize">
     *  Initialize Request
     * </a>
     * to a Live Validation client
     */
     public static CompletableFuture<InitializeResult> clientInitializationResponse() {
         var syncOptions = new TextDocumentSyncOptions();
         syncOptions.setChange(TextDocumentSyncKind.Full);
         syncOptions.setOpenClose(true);
         var saveOptions = new SaveOptions();
         saveOptions.setIncludeText(true);
         syncOptions.setSave(saveOptions);
         syncOptions.setWillSave(true);

         var initializeResult = new InitializeResult();
         initializeResult.setCapabilities(new ServerCapabilities());
         initializeResult.getCapabilities().setTextDocumentSync(syncOptions);
         initializeResult.getCapabilities().setWorkspace(new WorkspaceServerCapabilities());
         initializeResult.getCapabilities().getWorkspace().setWorkspaceFolders(new WorkspaceFoldersOptions());
         initializeResult.getCapabilities().getWorkspace().getWorkspaceFolders().setSupported(true);
         initializeResult.getCapabilities().setExperimental(new LiveValidationCapabilities());

         return CompletableFuture.completedFuture(initializeResult);
     }

    /**
     * Send LiveValidationLanguageClient.publishIssues Notification to a Live Validation client. This is an extension to
     * LSP, which communicates issues produced by validating Live Validation clients, i.e., clients that realize the
     * AbstractLiveValidator class from the Live Validation client project, to an initiating Live Validation client,
     * i.e., a client that realize the AbstractLiveValidationInitiator class from the Live Validation client project.
     */
     public static void publishIssues(LiveValidationLanguageClient client, String documentUri,
         List<IssueDiagnostic> issues) {
         client.publishIssues(new PublishIssuesParams(documentUri, issues));
     }
}
