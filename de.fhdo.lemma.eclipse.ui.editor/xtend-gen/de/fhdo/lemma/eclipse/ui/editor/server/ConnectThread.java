package de.fhdo.lemma.eclipse.ui.editor.server;

import com.google.common.base.Function;
import de.fhdo.lemma.eclipse.ui.editor.server.ServerConnection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * Thread to connect to Live Validation server.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ConnectThread extends Thread {
  private String hostname;
  
  private int port;
  
  private Display display;
  
  private Function<Void, Void> connectedCallback;
  
  private Function<Exception, Void> errorOccurredCallback;
  
  /**
   * Constructor
   */
  public ConnectThread(final String hostname, final int port, final Display display, final Function<Void, Void> connectedCallback, final Function<Exception, Void> errorOccurredCallback) {
    super();
    this.hostname = hostname;
    this.port = port;
    this.display = display;
    this.connectedCallback = connectedCallback;
    this.errorOccurredCallback = errorOccurredCallback;
  }
  
  /**
   * Connect to server
   */
  public void run() {
    try {
      ServerConnection.instance().connect(this.hostname, this.port);
      this.invokeGuiCallbackIfSpecified(this.connectedCallback);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
        this.invokeGuiCallbackIfSpecified(this.errorOccurredCallback, ex);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * Helper to invoke a callback function in sync with the current display, i.e., the GUI
   */
  private void invokeGuiCallbackIfSpecified(final Function<Void, Void> function) {
    if ((function == null)) {
      return;
    }
    this.display.syncExec(new Runnable() {
      public void run() {
        function.apply(null);
      }
    });
  }
  
  /**
   * Helper to invoke a callback function in sync with the current display, i.e., the GUI
   */
  private void invokeGuiCallbackIfSpecified(final Function<Exception, Void> function, final Exception argument) {
    if ((function == null)) {
      return;
    }
    this.display.syncExec(new Runnable() {
      public void run() {
        function.apply(argument);
      }
    });
  }
}
