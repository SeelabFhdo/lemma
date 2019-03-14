package de.fhdo.ddmm.eclipse.ui.editor

import com.google.common.base.Function
import org.eclipse.swt.widgets.Display

/**
 * Thread to connect to Live Validation server.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ConnectThread extends Thread {
    String hostname
    int port
    Display display
    Function<Void, Void> connectedCallback
    Function<Exception, Void> errorOccurredCallback

    /**
     * Constructor
     */
    new(String hostname, int port, Display display, Function<Void, Void> connectedCallback,
        Function<Exception, Void> errorOccurredCallback) {
        super()

        this.hostname = hostname
        this.port = port
        this.display = display
        this.connectedCallback = connectedCallback
        this.errorOccurredCallback = errorOccurredCallback
    }

    /**
     * Connect to server
     */
    override void run() {
        try {
            ServerConnection.instance.connect(hostname, port)
            connectedCallback.invokeGuiCallbackIfSpecified()
        } catch (Exception ex) {
            errorOccurredCallback.invokeGuiCallbackIfSpecified(ex)
        }
    }

    /**
     * Helper to invoke a callback function in sync with the current display, i.e., the GUI
     */
    private def invokeGuiCallbackIfSpecified(Function<Void, Void> function) {
        if (function === null) {
            return
        }

        display.syncExec(new Runnable() {
            override run() {
                function.apply(null)
            }
        })
    }

    /**
     * Helper to invoke a callback function in sync with the current display, i.e., the GUI
     */
    private def invokeGuiCallbackIfSpecified(Function<Exception, Void> function,
        Exception argument) {
        if (function === null) {
            return
        }

        display.syncExec(new Runnable() {
            override run() {
                function.apply(argument)
            }
        })
    }
}