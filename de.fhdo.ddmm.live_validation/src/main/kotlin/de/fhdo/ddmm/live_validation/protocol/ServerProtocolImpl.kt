package de.fhdo.ddmm.live_validation.protocol

import de.fhdo.ddmm.live_validation.common.IssueDiagnostic
import org.eclipse.lsp4j.InitializeResult
import org.eclipse.lsp4j.SaveOptions
import org.eclipse.lsp4j.ServerCapabilities
import org.eclipse.lsp4j.TextDocumentSyncKind
import org.eclipse.lsp4j.TextDocumentSyncOptions
import org.eclipse.lsp4j.WorkspaceFoldersOptions
import org.eclipse.lsp4j.WorkspaceServerCapabilities
import org.eclipse.lsp4j.services.LanguageClient
import java.util.concurrent.CompletableFuture

/**
 * Create a unique identifier for a Live Validation client connected to the server.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun LanguageClient.identifier() = System.identityHashCode(this)

/**
 * Create the log prefix for LSP message exchange related to a specific Live Validation client.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun LanguageClient.logPrefix() = "[Client ${identifier()}]:"

/**
 * Send server response for an LSP [Initialize Request](
 * https://microsoft.github.io/language-server-protocol/specification#initialize) to a Live Validation client.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun LiveValidationLanguageClient.clientInitializationResponse() : CompletableFuture<InitializeResult> {
    val syncOptions = TextDocumentSyncOptions()
    syncOptions.change = TextDocumentSyncKind.Full
    syncOptions.openClose = true
    syncOptions.save = SaveOptions()
    syncOptions.save.includeText = true
    syncOptions.willSave = true

    val initializeResult = InitializeResult()
    initializeResult.capabilities = ServerCapabilities()
    initializeResult.capabilities.setTextDocumentSync(syncOptions)
    initializeResult.capabilities.workspace = WorkspaceServerCapabilities()
    initializeResult.capabilities.workspace.workspaceFolders = WorkspaceFoldersOptions()
    initializeResult.capabilities.workspace.workspaceFolders.supported = true
    initializeResult.capabilities.experimental = LiveValidationCapabilities()

    return CompletableFuture.completedFuture(initializeResult)
}

/**
 * Send [LiveValidationLanguageClient.publishIssues] Notification to a Live Validation client. This is an extension to
 * LSP, which communicates issues produced by a concrete [de.fhdo.ddmm.live_validation.clients.AbstractLiveValidator]
 * (as a result of the server invoking the validator's ``requestValidation'' method) to a Live Validation client that
 * extends [de.fhdo.ddmm.live_validation.clients.AbstractLiveValidationInitiator].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun LiveValidationLanguageClient.publishIssues(documentUri: String, issues: List<IssueDiagnostic>) {
    this.publishIssues(PublishIssuesParams(documentUri, issues))
}