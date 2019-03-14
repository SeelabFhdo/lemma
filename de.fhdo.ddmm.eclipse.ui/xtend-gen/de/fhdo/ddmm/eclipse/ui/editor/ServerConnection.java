package de.fhdo.ddmm.eclipse.ui.editor;

import de.fhdo.ddmm.live_validation.clients.AbstractLiveValidationInitiator;
import de.fhdo.ddmm.live_validation.protocol.PublishIssuesParams;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * Connection to Live Validation server.
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
    public void publishIssues(final PublishIssuesParams arg0) {
      throw new UnsupportedOperationException("TODO: auto-generated method stub");
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
      int _xtrycatchfinallyexpression = (int) 0;
      try {
        int _xblockexpression = (int) 0;
        {
          ServerConnection.LiveValidationClient _liveValidationClient = new ServerConnection.LiveValidationClient();
          ServerConnection.INSTANCE.serverConnection = _liveValidationClient;
          ServerConnection.INSTANCE.serverConnection.start(hostname, port, ServerConnection.WORKSPACE_URI);
          ServerConnection.INSTANCE.isConnected = true;
          ServerConnection.INSTANCE.connectedHostname = hostname;
          _xblockexpression = ServerConnection.INSTANCE.connectedPort = port;
        }
        _xtrycatchfinallyexpression = _xblockexpression;
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception ex = (Exception)_t;
          this.disconnect();
          throw ex;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      return _xtrycatchfinallyexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
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
