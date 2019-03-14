package de.fhdo.ddmm.eclipse.ui.editor

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.services.IEvaluationService
import org.eclipse.jface.dialogs.MessageDialog

/**
 * Controller for handling the interaction with a Live Validation server.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class LiveValidationController extends AbstractHandler {
    val SHELL = PlatformUI.workbench.activeWorkbenchWindow.shell

    /**
     * Execute commands
     */
    override execute(ExecutionEvent event) throws ExecutionException {
        switch (event.command.id) {
            case "de.fhdo.ddmm.eclipse.ui.commands.connectToLiveValidationServer":
                connectToLiveValidationServer()
            case "de.fhdo.ddmm.eclipse.ui.commands.disconnectFromLiveValidationServer":
                ServerConnection.instance.disconnect
            case "de.fhdo.ddmm.eclipse.ui.commands.connectionInformation":
                displayConnectionInformation()
        }

        // Re-evaluate server connection property to adapt UI (menu and toolbar entries)
        PlatformUI.workbench.getService(IEvaluationService)
            .requestEvaluation("de.fhdo.ddmm.eclipse.ui.editor.isConnectedToServer")

        return null
    }

    /**
     * Trigger Live Validation server connect
     */
    private def connectToLiveValidationServer() {
        val connectionDialog = new ServerConnectionDialog(SHELL)
        connectionDialog.create()
        connectionDialog.open()
    }

    /**
     * Display information about Live Validation server connection
     */
    private def displayConnectionInformation() {
        val informationText = new StringBuffer("Connection information:\n")
        var hasInformationText = false
        val connection = ServerConnection.instance

        if (!connection.connectedHostname.empty) {
            informationText.append('''- Hostname: «connection.connectedHostname»''' + "\n")
            hasInformationText = true
        }

        if (connection.connectedPort > -1) {
            informationText.append('''- Port: «connection.connectedPort»''')
            hasInformationText = true
        }

        if (hasInformationText)
            MessageDialog.openInformation(SHELL, "Connection Information", informationText.toString)
        else
            MessageDialog.openInformation(SHELL, "Connection Information", "No connection " +
                "information available.")
    }
}