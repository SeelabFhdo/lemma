package de.fhdo.lemma.live_validation.protocol

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonSyntaxException
import org.eclipse.lsp4j.ClientCapabilities
import org.eclipse.lsp4j.DidChangeTextDocumentParams
import org.eclipse.lsp4j.InitializeParams
import org.eclipse.lsp4j.InitializedParams
import org.eclipse.lsp4j.ResourceOperationKind
import org.eclipse.lsp4j.SynchronizationCapabilities
import org.eclipse.lsp4j.TextDocumentClientCapabilities
import org.eclipse.lsp4j.TextDocumentContentChangeEvent
import org.eclipse.lsp4j.VersionedTextDocumentIdentifier
import org.eclipse.lsp4j.WorkspaceClientCapabilities
import org.eclipse.lsp4j.WorkspaceEditCapabilities
import org.eclipse.lsp4j.services.LanguageServer

/**
 * Send LSP [Initialize Request](https://microsoft.github.io/language-server-protocol/specification#initialize) to
 * a Live Validation server.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun LanguageServer.requestClientInitialization(rootUri: String?) {
    val initializeParams = InitializeParams()
    initializeParams.rootUri = rootUri

    val capabilities = ClientCapabilities()
    capabilities.workspace = WorkspaceClientCapabilities()
    capabilities.workspace.workspaceEdit = WorkspaceEditCapabilities()
    capabilities.workspace.workspaceEdit.resourceOperations = mutableListOf()
    capabilities.workspace.workspaceEdit.resourceOperations.add(ResourceOperationKind.Create)
    capabilities.workspace.workspaceEdit.resourceOperations.add(ResourceOperationKind.Rename)
    capabilities.workspace.workspaceEdit.resourceOperations.add(ResourceOperationKind.Delete)
    capabilities.workspace.workspaceFolders = true
    capabilities.textDocument = TextDocumentClientCapabilities()
    capabilities.textDocument.synchronization = SynchronizationCapabilities()
    capabilities.textDocument.synchronization.willSave = true
    capabilities.textDocument.synchronization.didSave = true
    initializeParams.capabilities = capabilities

    // Wait for the server to answer the request with an InitializeResult response. A server is identified by a client
    // to be capable of Live Validation leveraging the "experimental" field in the ServerCapabilities interface. If the
    // server is able to perform Live Validation, the field will contain an instance of LiveValidationCapabilities.
    val initializeResult = this.initialize(initializeParams).get()
    val experimentalJson = initializeResult.capabilities.experimental as? JsonObject
        ?: throw IllegalStateException("Server does not support live validation")
    val liveValidationCapabilities = try {
        Gson().fromJson(experimentalJson, LiveValidationCapabilities::class.java)
    } catch (ex: JsonSyntaxException) {
        null
    }
    if (liveValidationCapabilities == null || !liveValidationCapabilities.supportsLiveValidation)
        throw IllegalStateException("Server does not support live validation")
}

/**
 * Send LSP [Initialized Notification](https://microsoft.github.io/language-server-protocol/specification#initialized)
 * to a Live Validation server.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun LanguageServer.notifyClientInitialized() {
    this.initialized(InitializedParams())
}

/**
 * Send LSP [DidChangeTextDocument Notification](
 * https://microsoft.github.io/language-server-protocol/specification#textDocument_didChange) to a Live Validation
 * server. Note that the method always sends the passed source code as a whole to the server, which corresponds to
 * [clientInitializationResponse] sending [org.eclipse.lsp4j.TextDocumentSyncKind.Full] as value for
 * [org.eclipse.lsp4j.TextDocumentSyncOptions.change] to Live Validation clients (cf. LSP's
 * [ServerCapabilities interface](https://microsoft.github.io/language-server-protocol/specification#initialize)).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun LanguageServer.notifyDidChange(documentUri: String, sourceCode: String) {
    val contentChangeEvent = TextDocumentContentChangeEvent()
    contentChangeEvent.text = sourceCode

    val didChangeParams = DidChangeTextDocumentParams()
    didChangeParams.textDocument = VersionedTextDocumentIdentifier()
    didChangeParams.textDocument.uri = documentUri
    didChangeParams.contentChanges = listOf(contentChangeEvent)

    this.textDocumentService.didChange(didChangeParams)
}