package de.fhdo.lemma.live_validation.protocol.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import de.fhdo.lemma.live_validation.protocol.extensions.LiveValidationCapabilities;
import org.eclipse.lsp4j.ClientCapabilities;
import org.eclipse.lsp4j.DidChangeTextDocumentParams;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.InitializedParams;
import org.eclipse.lsp4j.ResourceOperationKind;
import org.eclipse.lsp4j.SynchronizationCapabilities;
import org.eclipse.lsp4j.TextDocumentClientCapabilities;
import org.eclipse.lsp4j.TextDocumentContentChangeEvent;
import org.eclipse.lsp4j.VersionedTextDocumentIdentifier;
import org.eclipse.lsp4j.WorkspaceClientCapabilities;
import org.eclipse.lsp4j.WorkspaceEditCapabilities;
import org.eclipse.lsp4j.services.LanguageServer;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Client-side LSP protocol implementation for Live Validation (cf. the Live Validation protocol documentation in the
 * "Documentation.md" file for further details).
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
public final class ClientProtocolImpl {
    /**
     * Send LSP <a href="https://microsoft.github.io/language-server-protocol/specification#initialize">
     *  Initialize Request
     * </a> to a Live Validation server.
     */
    public static void requestClientInitialization(LanguageServer server, String rootUri)
        throws ExecutionException, InterruptedException {
        var initializeParams = new InitializeParams();
        initializeParams.setRootUri(rootUri);

        var capabilities = new ClientCapabilities();
        capabilities.setWorkspace(new WorkspaceClientCapabilities());
        capabilities.getWorkspace().setWorkspaceEdit(new WorkspaceEditCapabilities());
        capabilities.getWorkspace().getWorkspaceEdit().setResourceOperations(new ArrayList<>());
        capabilities.getWorkspace().getWorkspaceEdit().getResourceOperations().add(ResourceOperationKind.Create);
        capabilities.getWorkspace().getWorkspaceEdit().getResourceOperations().add(ResourceOperationKind.Rename);
        capabilities.getWorkspace().getWorkspaceEdit().getResourceOperations().add(ResourceOperationKind.Delete);
        capabilities.getWorkspace().setWorkspaceFolders(true);

        capabilities.setTextDocument(new TextDocumentClientCapabilities());
        capabilities.getTextDocument().setSynchronization(new SynchronizationCapabilities());
        capabilities.getTextDocument().getSynchronization().setWillSave(true);
        capabilities.getTextDocument().getSynchronization().setDidSave(true);

        initializeParams.setCapabilities(capabilities);

        // Wait for the server to answer the request with an InitializeResult response. A server is identified by a
        // client to be capable of Live Validation leveraging the "experimental" field in the ServerCapabilities
        // interface. If the server is able to perform Live Validation, the field will contain an instance of
        // LiveValidationCapabilities.
        var initializeResult = server.initialize(initializeParams).get();
        LiveValidationCapabilities liveValidationCapabilities;
        try {
            var experimentalJson = (JsonObject) initializeResult.getCapabilities().getExperimental();
            liveValidationCapabilities = new Gson().fromJson(experimentalJson, LiveValidationCapabilities.class);
        } catch (ClassCastException ex) {
            throw new IllegalStateException("Server does not support live validation");
        }

        if (liveValidationCapabilities == null || !liveValidationCapabilities.isSupportsLiveValidation())
            throw new IllegalStateException("Server does not support live validation");
    }

    /**
     * Send LSP <a href="https://microsoft.github.io/language-server-protocol/specification#initialized">
     *  Initialized Notification
     * </a>
     * to a Live Validation server
     */
    public static void notifyClientInitialized(LanguageServer server) {
        server.initialized(new InitializedParams());
    }

    /**
     * Send LSP <a href="https://microsoft.github.io/language-server-protocol/specification#textDocument_didChange>
     *  DidChangeTextDocument Notification
     * </a>
     * to a Live Validation server. Note that the method always sends the passed source code as a whole to the server,
     * which corresponds to clientInitializationResponse sending org.eclipse.lsp4j.TextDocumentSyncKind.Full as value
     * for org.eclipse.lsp4j.TextDocumentSyncOptions.change to Live Validation clients (cf. LSP's
     * <a href="https://microsoft.github.io/language-server-protocol/specification#initialize">
     *  ServerCapabilities interface
     * </a>
     */
     public static void notifyDidChange(LanguageServer server, String documentUri, String sourceCode) {
         var didChangeParams = new DidChangeTextDocumentParams();
         didChangeParams.setTextDocument(new VersionedTextDocumentIdentifier());
         didChangeParams.getTextDocument().setUri(documentUri);

         var contentChangeEvent = new TextDocumentContentChangeEvent();
         contentChangeEvent.setText(sourceCode);
         var contentChanges = new ArrayList<TextDocumentContentChangeEvent>();
         contentChanges.add(contentChangeEvent);
         didChangeParams.setContentChanges(contentChanges);

         server.getTextDocumentService().didChange(didChangeParams);
     }
}
