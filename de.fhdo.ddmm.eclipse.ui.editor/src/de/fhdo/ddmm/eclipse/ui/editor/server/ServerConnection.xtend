package de.fhdo.ddmm.eclipse.ui.editor.server

import org.eclipse.core.resources.ResourcesPlugin
import de.fhdo.ddmm.live_validation.clients.AbstractLiveValidationInitiator
import de.fhdo.ddmm.live_validation.protocol.PublishIssuesParams
import de.fhdo.ddmm.eclipse.ui.editor.LiveValidationCapableXtextEditor
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils

/**
 * This class represents and manages a connection to a Live Validation server.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ServerConnection {
    static val WORKSPACE_URI = ResourcesPlugin.workspace.root.locationURI.toString()
    static var ServerConnection INSTANCE

    var LiveValidationClient serverConnection
    var boolean isConnected
    var String connectedHostname = ""
    var int connectedPort = -1

    private new() {
        // NOOP
    }

    /**
     * Get singleton instance
     */
    static def instance() {
        if (INSTANCE === null)
            INSTANCE = new ServerConnection

        return INSTANCE
    }

    /**
     * Connect to server
     */
    def connect(String hostname, int port) {
        checkIsNotConnected

        try {
            INSTANCE.serverConnection = new LiveValidationClient
            INSTANCE.serverConnection.start(hostname, port, WORKSPACE_URI)
            INSTANCE.isConnected = true
            INSTANCE.connectedHostname = hostname
            INSTANCE.connectedPort = port
        } catch (Exception ex) {
            disconnect()

            // Rethrow to allow GUI callers to inform the user that a connection problem occurred
            throw ex
        }
    }

    /**
     * Send validation request to server
     */
    def validate(String documentUri, String sourceCode) {
        checkIsConnected
        INSTANCE.serverConnection.validate(documentUri, sourceCode)
    }

    /**
     * Disconnect from server
     */
    def disconnect() {
        if (isConnected)
            INSTANCE.serverConnection.disconnect()

        INSTANCE.isConnected = false
        INSTANCE.connectedHostname = ""
        INSTANCE.connectedPort = -1
    }

    /**
     * Internal Live Validation client implementation. It realizes the server connection and
     * receives issues as results of validation requests.
     */
    private static class LiveValidationClient extends AbstractLiveValidationInitiator {
        override publishIssues(PublishIssuesParams issues) {
            LemmaUiUtils.getOpenEditorsOfType(LiveValidationCapableXtextEditor).forEach[
                if (resource.locationURI.toString == issues.uri)
                    addIssueMarkers(issues.diagnostics)
            ]
        }
    }

    /**
     * Convenience method to verify that a server connection wasn't already established
     */
    private def checkIsNotConnected() {
        if (isConnected)
            throw new IllegalStateException("Live Validation server connection must not be " +
                "already established")
    }

    /**
     * Convenience method to verify that a server connection has been established
     */
    private def checkIsConnected() {
        if (!isConnected)
            throw new IllegalStateException("Live Validation server connection must be " +
                "established first")
    }

    def isConnected() {
        INSTANCE.isConnected
    }

    def getConnectedHostname() {
        INSTANCE.connectedHostname
    }

    def getConnectedPort() {
        INSTANCE.connectedPort
    }
}