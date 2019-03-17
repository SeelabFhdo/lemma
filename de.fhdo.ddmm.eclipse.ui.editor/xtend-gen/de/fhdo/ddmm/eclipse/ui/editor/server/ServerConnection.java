package de.fhdo.ddmm.eclipse.ui.editor.server;

import com.google.common.base.Objects;
import de.fhdo.ddmm.eclipse.ui.editor.LiveValidationCapableXtextEditor;
import de.fhdo.ddmm.live_validation.clients.AbstractLiveValidationInitiator;
import de.fhdo.ddmm.live_validation.protocol.PublishIssuesParams;
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils;
import java.util.function.Consumer;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * This class represents and manages a connection to a Live Validation server.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ServerConnection {
  /**
   * Internal Live Validation client implementation. It realizes the server connection and
   * receives issues as results of validation requests.
   */
  private static class LiveValidationClient extends AbstractLiveValidationInitiator {
    public void publishIssues(final PublishIssuesParams issues) {
      final Consumer<LiveValidationCapableXtextEditor> _function = new Consumer<LiveValidationCapableXtextEditor>() {
        public void accept(final LiveValidationCapableXtextEditor it) {
          String _string = it.getResource().getLocationURI().toString();
          String _uri = issues.getUri();
          boolean _equals = Objects.equal(_string, _uri);
          if (_equals) {
            it.addIssueMarkers(issues.getDiagnostics());
          }
        }
      };
      LemmaUiUtils.<LiveValidationCapableXtextEditor>getOpenEditorsOfType(LiveValidationCapableXtextEditor.class).forEach(_function);
    }
  }
  
  private static final String WORKSPACE_URI = ResourcesPlugin.getWorkspace().getRoot().getLocationURI().toString();
  
  private static ServerConnection INSTANCE;
  
  private ServerConnection.LiveValidationClient serverConnection;
  
  private boolean isConnected;
  
  private String connectedHostname = "";
  
  private int connectedPort = (-1);
  
  private ServerConnection() {
  }
  
  /**
   * Get singleton instance
   */
  public static ServerConnection instance() {
    if ((ServerConnection.INSTANCE == null)) {
      ServerConnection _serverConnection = new ServerConnection();
      ServerConnection.INSTANCE = _serverConnection;
    }
    return ServerConnection.INSTANCE;
  }
  
  /**
   * Connect to server
   */
  public int connect(final String hostname, final int port) {
    try {
      int _xblockexpression = (int) 0;
      {
        this.checkIsNotConnected();
        int _xtrycatchfinallyexpression = (int) 0;
        try {
          int _xblockexpression_1 = (int) 0;
          {
            ServerConnection.LiveValidationClient _liveValidationClient = new ServerConnection.LiveValidationClient();
            ServerConnection.INSTANCE.serverConnection = _liveValidationClient;
            ServerConnection.INSTANCE.serverConnection.start(hostname, port, ServerConnection.WORKSPACE_URI);
            ServerConnection.INSTANCE.isConnected = true;
            ServerConnection.INSTANCE.connectedHostname = hostname;
            _xblockexpression_1 = ServerConnection.INSTANCE.connectedPort = port;
          }
          _xtrycatchfinallyexpression = _xblockexpression_1;
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
            final Exception ex = (Exception)_t;
            this.disconnect();
            throw ex;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        _xblockexpression = _xtrycatchfinallyexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Send validation request to server
   */
  public void validate(final String documentUri, final String sourceCode) {
    this.checkIsConnected();
    ServerConnection.INSTANCE.serverConnection.validate(documentUri, sourceCode);
  }
  
  /**
   * Disconnect from server
   */
  public int disconnect() {
    int _xblockexpression = (int) 0;
    {
      if (this.isConnected) {
        ServerConnection.INSTANCE.serverConnection.disconnect();
      }
      ServerConnection.INSTANCE.isConnected = false;
      ServerConnection.INSTANCE.connectedHostname = "";
      _xblockexpression = ServerConnection.INSTANCE.connectedPort = (-1);
    }
    return _xblockexpression;
  }
  
  /**
   * Convenience method to verify that a server connection wasn't already established
   */
  private void checkIsNotConnected() {
    if (this.isConnected) {
      throw new IllegalStateException(("Live Validation server connection must not be " + 
        "already established"));
    }
  }
  
  /**
   * Convenience method to verify that a server connection has been established
   */
  private void checkIsConnected() {
    if ((!this.isConnected)) {
      throw new IllegalStateException(("Live Validation server connection must be " + 
        "established first"));
    }
  }
  
  public boolean isConnected() {
    return ServerConnection.INSTANCE.isConnected;
  }
  
  public String getConnectedHostname() {
    return ServerConnection.INSTANCE.connectedHostname;
  }
  
  public int getConnectedPort() {
    return ServerConnection.INSTANCE.connectedPort;
  }
}
