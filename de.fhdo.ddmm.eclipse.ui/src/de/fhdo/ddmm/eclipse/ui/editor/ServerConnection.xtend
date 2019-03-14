package de.fhdo.ddmm.eclipse.ui.editor

import org.eclipse.core.resources.ResourcesPlugin
import de.fhdo.ddmm.live_validation.clients.AbstractLiveValidationInitiator
import de.fhdo.ddmm.live_validation.protocol.PublishIssuesParams

/**
 * Connection to Live Validation server.
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
        override publishIssues(PublishIssuesParams arg0) {
            throw new UnsupportedOperationException("TODO: auto-generated method stub")
        }
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