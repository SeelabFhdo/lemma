package de.fhdo.ddmm.live_validation.protocol

import de.fhdo.ddmm.live_validation.common.IssueDiagnostic
import org.eclipse.lsp4j.DidChangeConfigurationParams
import org.eclipse.lsp4j.DidChangeTextDocumentParams
import org.eclipse.lsp4j.DidChangeWatchedFilesParams
import org.eclipse.lsp4j.DidCloseTextDocumentParams
import org.eclipse.lsp4j.DidOpenTextDocumentParams
import org.eclipse.lsp4j.DidSaveTextDocumentParams
import org.eclipse.lsp4j.MessageActionItem
import org.eclipse.lsp4j.MessageParams
import org.eclipse.lsp4j.PublishDiagnosticsParams
import org.eclipse.lsp4j.ShowMessageRequestParams
import org.eclipse.lsp4j.jsonrpc.services.JsonNotification
import org.eclipse.lsp4j.jsonrpc.services.JsonRequest
import org.eclipse.lsp4j.services.LanguageClient
import org.eclipse.lsp4j.services.LanguageServer
import org.eclipse.lsp4j.services.TextDocumentService
import org.eclipse.lsp4j.services.WorkspaceService
import java.util.concurrent.CompletableFuture

private const val EXTENSION_PREFIX = "live_validation"

/**
 * Server-side LSP extensions for Live Validation (cf. the [Live Validation protocol documentation](Documentation.md)
 * for further details).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
interface LiveValidationServer : LanguageServer {
    companion object {
        const val DEFAULT_HOSTNAME = "localhost"
        const val DEFAULT_PORT = 44203
    }

    /**
     * Send Disconnect request from any Live Validation client to server
     */
    @JsonRequest("$EXTENSION_PREFIX/client/disconnect")
    fun requestDisconnect() : CompletableFuture<Void>

    /**
     * Send Bye notification from any Live Validation client to server
     */
    @JsonNotification("$EXTENSION_PREFIX/client/bye")
    fun bye()

    /**
     * Implementation of [TextDocumentService]. While all other notifications are NOOP implementations, the
     * [TextDocumentService.didChange] implementation invokes [performValidations] to trigger validations.
     */
    override fun getTextDocumentService(): TextDocumentService {
        return object : TextDocumentService {
            override fun didChange(params: DidChangeTextDocumentParams?) {
                performValidations(params)
            }

            override fun didOpen(params: DidOpenTextDocumentParams?) {
                // NOOP
            }

            override fun didSave(params: DidSaveTextDocumentParams?) {
                // NOOP
            }

            override fun didClose(params: DidCloseTextDocumentParams?) {
                // NOOP
            }
        }
    }

    /**
     * Trigger PerformValidation requests from server to registered
     * [de.fhdo.ddmm.live_validation.clients.AbstractLiveValidator] clients
     */
    fun performValidations(params: DidChangeTextDocumentParams?)

    /**
     * NOOP implementation of [WorkspaceService] for [LiveValidationServer] implementers' convenience
     */
    override fun getWorkspaceService() : WorkspaceService {
        return object : WorkspaceService {
            override fun didChangeConfiguration(params: DidChangeConfigurationParams?) {
                // NOOP
            }

            override fun didChangeWatchedFiles(params: DidChangeWatchedFilesParams?) {
                // NOOP
            }

        }
    }
}

/**
 * Structure to identify an LSP server as capable of handling Live Validation requests (used by
 * [LanguageServer.requestClientInitialization] and [LiveValidationLanguageClient.clientInitializationResponse]).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class LiveValidationCapabilities(val supportsLiveValidation: Boolean = true)

/**
 * Client-side LSP extensions for Live Validation (cf. the [Live Validation protocol documentation](Documentation.md)
 * for further details).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
interface LiveValidationLanguageClient : LanguageClient {
    /**
     * Send RegisterValidator request from server to any initialized Live Validation clients
     */
    @JsonRequest("$EXTENSION_PREFIX/client/registerValidator")
    fun requestValidatorRegistration() : CompletableFuture<Set<String>>

    /**
     * Send PerformValidation request from server to [de.fhdo.ddmm.live_validation.clients.AbstractLiveValidator]
     * clients
     */
    @JsonRequest("$EXTENSION_PREFIX/textDocument/performValidation")
    fun requestValidation(documentUri: String, sourceCode: String) : CompletableFuture<List<IssueDiagnostic>>

    /**
     * Send PublishIssues notification from server to
     * [de.fhdo.ddmm.live_validation.clients.AbstractLiveValidationInitiator] clients
     */
    @JsonNotification("$EXTENSION_PREFIX/textDocument/publishIssues")
    fun publishIssues(publishIssuesParams: PublishIssuesParams)

    override fun telemetryEvent(o: Any) {
        // NOOP default implementation for convenience
    }

    override fun publishDiagnostics(publishDiagnosticsParams: PublishDiagnosticsParams) {
        // NOOP default implementation for convenience
    }

    override fun showMessage(messageParams: MessageParams) {
        // NOOP default implementation for convenience
    }

    override fun showMessageRequest(showMessageRequestParams: ShowMessageRequestParams)
            : CompletableFuture<MessageActionItem>? = null  // NOOP default implementation for convenience

    override fun logMessage(messageParams: MessageParams) {
        // NOOP default implementation for convenience
    }
}

/**
 * Structure to send gathered validation results from the server to
 * [de.fhdo.ddmm.live_validation.clients.AbstractLiveValidationInitiator] clients.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
data class PublishIssuesParams(var uri: String, var diagnostics: List<IssueDiagnostic> = mutableListOf())