package de.fhdo.lemma.eclipse.ui.editor.server

import org.eclipse.jface.dialogs.TitleAreaDialog
import org.eclipse.swt.widgets.Shell
import org.eclipse.jface.dialogs.IMessageProvider
import org.eclipse.swt.widgets.Composite
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Text
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Label
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.swt.graphics.Point
import static de.fhdo.lemma.live_validation.protocol.extensions.LiveValidationServer.DEFAULT_HOSTNAME
import static de.fhdo.lemma.live_validation.protocol.extensions.LiveValidationServer.DEFAULT_PORT

/**
 * Dialog to request data needed to connect to a Live Validation server.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ServerConnectionDialog extends TitleAreaDialog {
    static val HOSTNAME_REGEX = "^(" +
        "([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-]*[a-zA-Z0-9])\\.)*" +
        "([A-Za-z0-9]|[A-Za-z0-9][A-Za-z0-9\\-]*[A-Za-z0-9])"
    static val MIN_DIALOG_WIDTH = 240
    static val MIN_DIALOG_HEIGHT = 110

    Text hostnameField
    Text portField

    /**
     * Constructor
     */
    new(Shell parentShell) {
        super(parentShell)
        setShellStyle(getShellStyle().bitwiseOr(SWT.SHEET))
    }

    /**
     * Create dialog (to be called after constructor and before open())
     */
    override create() {
        super.create()
        setTitle("Connect to Live Validation server")
        setMessage("Enter data needed to connect to a running Live Validation server instance:",
            IMessageProvider.INFORMATION)
    }

    /**
     * Create buttons for the button bar
     */
    override createButtonsForButtonBar(Composite parent) {
        createButton(parent, CANCEL, IDialogConstants.CANCEL_LABEL, false)
        createButton(parent, OK, "Connect", true)
    }

    /**
     * Create the dialog's content
     */
    override createDialogArea(Composite parent) {
        val area = super.createDialogArea(parent) as Composite
        val container = new Composite(area, SWT.NONE)
        container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true))
        container.setLayout(new GridLayout(2, false))

        hostnameField = createTextField(container, "Hostname:", DEFAULT_HOSTNAME)
        portField = createTextField(container, "Port:", DEFAULT_PORT)

        return area
    }

    /**
     * Catch button press
     */
    override buttonPressed(int buttonId) {
        switch (buttonId) {
            case CANCEL: setReturnCodeAndClose(CANCEL)
            case OK: connectPressed()
        }
    }

    /**
     * Handle click on the connect button
     */
    private def connectPressed() {
        if (!isHostnameValid)
            return
        else if (!isPortValid)
            return
        else
            connectToServer(hostnameField.text, Integer.parseInt(portField.text))
    }

    /**
     * Attempt to connect to Live Validation server
     */
    private def connectToServer(String hostname, int port) {
        val connectProgressDialog = new ConnectProgressDialog(shell, hostname, port,
            [connectionToServerEstablished],
            [dialog, error | errorDuringConnectionAttemptCallback(dialog, error)])
        connectProgressDialog.create()
        connectProgressDialog.openAndConnectToServer()
    }

    /**
     * Connect thread callback: Connection was established
     */
    private def Void connectionToServerEstablished(ConnectProgressDialog connectDialog) {
        connectDialog.close()
        close()
        return null
    }

    /**
     * Connect thread callback: Error occurred during connection approach
     */
    private def Void errorDuringConnectionAttemptCallback(ConnectProgressDialog connectDialog,
        Exception error) {
        MessageDialog.openError(shell, "Error during server connection attempt", '''An error ''' +
            '''occurred while trying to connect to the Live Validation server at ''' +
            '''«hostnameField.text»:«portField.text»: «error.message»''')
        connectDialog.close()

        return null
    }

    /**
     * Check entered hostname for correctness
     */
    private def isHostnameValid() {
        val hostname = hostnameField.text
        return if (hostname === null || hostname.empty) {
            showError("Invalid hostname", "Hostname must not be empty.")
            false
        } else if (!hostname.matches(HOSTNAME_REGEX)) {
            showError("Invalid hostname", "Hostname has invalid format.")
            false
        } else
            true
    }

    /**
     * Check entered port for correctness
     */
    private def isPortValid() {
        if (portField.text === null || portField.text.empty) {
            showError("Invalid port", "Port must not be empty.")
            return false
        }

        val port = try {
                Integer.parseInt(portField.text)
            } catch (NumberFormatException ex) {
                showError("Invalid port", "Port has invalid format.")
                return false
            }

        if (port < 0 || port > 65535) {
            showError("Invalid port", "Port has invalid format.")
            return false
        }

        return true
    }

    /**
     * Convenience method to show an error message
     */
    private def showError(String title, String message) {
        MessageDialog.openError(shell, title, message)
    }

    /**
     * Helper method to set the return code and also close the dialog
     */
    private def void setReturnCodeAndClose(int buttonId) {
        returnCode = buttonId
        close()
    }

    /**
     * Create input text field for the file path and related labels
     */
    private def createTextField(Composite container, String labelText, Object initialValue) {
        val label = new Label(container, SWT.NULL)
        label.text = labelText

        val textField = new Text(container, SWT.SINGLE.bitwiseOr(SWT.BORDER))
        val fieldData = new GridData()
        fieldData.grabExcessHorizontalSpace = true
        fieldData.horizontalAlignment = GridData.FILL
        textField.layoutData = fieldData
        textField.text = if (initialValue !== null) initialValue.toString else ""

        return textField
    }

    /**
     * Flag to indicate that dialog is resizable
     */
    override isResizable() {
        return true
    }

    /**
     * Initial size
     */
    override getInitialSize() {
        return new Point(
            convertHorizontalDLUsToPixels(MIN_DIALOG_WIDTH),
            convertVerticalDLUsToPixels(MIN_DIALOG_HEIGHT)
        )
    }
}