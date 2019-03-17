package de.fhdo.ddmm.eclipse.ui.editor.server

import org.eclipse.jface.dialogs.TitleAreaDialog
import org.eclipse.swt.widgets.Shell
import org.eclipse.swt.SWT
import org.eclipse.jface.dialogs.IMessageProvider
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.swt.widgets.Composite
import com.google.common.base.Function
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.jface.resource.ResourceManager
import org.eclipse.jface.resource.LocalResourceManager
import org.eclipse.jface.resource.JFaceResources
import org.eclipse.swt.custom.CLabel
import org.eclipse.swt.widgets.ProgressBar
import org.eclipse.swt.graphics.Point
import org.eclipse.xtext.xbase.lib.Functions.Function2
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils

/**
 * Dialog to show progress while connecting to a Live Validation server.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ConnectProgressDialog extends TitleAreaDialog {
    static val ResourceManager RESOURCE_MANAGER =
        new LocalResourceManager(JFaceResources.getResources())
    static val MIN_DIALOG_WIDTH = 200
    static val MIN_DIALOG_HEIGHT = 100

    String hostname
    int port
    Function<ConnectProgressDialog, Void> connectedCallback
    Function2<ConnectProgressDialog, Exception, Void> connectionErrorCallback
    ConnectThread connectThread

    new(Shell parentShell, String hostname, int port,
        Function<ConnectProgressDialog, Void> connectedCallback,
        Function2<ConnectProgressDialog, Exception, Void> connectionErrorCallback) {
        super(parentShell)
        setShellStyle(getShellStyle().bitwiseOr(SWT.SHEET))

        this.hostname = hostname
        this.port = port
        this.connectedCallback = connectedCallback
        this.connectionErrorCallback = connectionErrorCallback
    }

    /**
     * Create dialog (to be called after constructor and before open())
     */
    override create() {
        super.create()
        setTitle("Connecting to Live Validation server")
        setMessage("Attempting to connect to a Live Validation server.",
            IMessageProvider.INFORMATION)
    }

    /**
     * Create buttons for the button bar
     */
    override createButtonsForButtonBar(Composite parent) {
        createButton(parent, CANCEL, IDialogConstants.CANCEL_LABEL, false)
    }

    /**
     * Internal callback for dialog area creation
     */
    override createDialogArea(Composite parent) {
        val area = super.createDialogArea(parent) as Composite
        val container = new Composite(area, SWT.NONE)
        container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true))

        val layout = new GridLayout(1, false)
        container.setLayout(layout)

        val progressTitleLabel = new CLabel(container, SWT.NONE)
        progressTitleLabel.setImage(
            LemmaUiUtils.createImage(RESOURCE_MANAGER, class, "connectLiveValidationServer.gif")
        )
        progressTitleLabel.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false))
        progressTitleLabel.text = '''Connecting to Live Validation server at «hostname»:«port»'''

        val progressBar = new ProgressBar(container, SWT.INDETERMINATE)
        progressBar.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false))

        return area
    }

    /**
     * Open dialog and connect to server
     */
    def openAndConnectToServer() {
        /* Code taken from Window.open() */
        // Limit the shell size to the display size
        constrainShellSize()

        // Open the window
        shell.open()

        /* Start connecting to server before event loop is started */
        connectThread = new ConnectThread(hostname, port, shell.display,
            [internalConnectedCallback], [internalConnectionErrorCallback])
        connectThread.start()

        LemmaUiUtils.runEventLoop(shell)

        return returnCode
    }

    /**
     * Internal callback when server connection was established successfully
     */
    private def Void internalConnectedCallback() {
        connectedCallback.apply(this)
    }

    /**
     * Internal callback when server connection could not be established successfully
     */
    private def Void internalConnectionErrorCallback(Exception error) {
        connectionErrorCallback.apply(this, error)
    }

    /**
     * Catch button press
     */
    override buttonPressed(int buttonId) {
        if (buttonId === CANCEL && connectThread !== null) {
            connectThread.interrupt()
            ServerConnection.instance.disconnect()
        }
        close()
    }

    /**
     * Initial size
     */
    override getInitialSize() {
        val shellSize = super.getInitialSize()
        return new Point(
            Math.max(convertHorizontalDLUsToPixels(MIN_DIALOG_WIDTH), shellSize.x),
            convertVerticalDLUsToPixels(MIN_DIALOG_HEIGHT)
        )
    }
}