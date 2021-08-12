package de.fhdo.lemma.eclipse.ui.editor;

import de.fhdo.lemma.eclipse.ui.editor.server.ServerConnection;
import de.fhdo.lemma.eclipse.ui.editor.server.ServerConnectionDialog;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.services.IEvaluationService;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Controller for handling the interaction with a Live Validation server.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class LiveValidationController extends AbstractHandler {
  private final Shell SHELL = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
  
  /**
   * Execute commands
   */
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    String _id = event.getCommand().getId();
    if (_id != null) {
      switch (_id) {
        case "de.fhdo.lemma.eclipse.ui.commands.connectToLiveValidationServer":
          this.connectToLiveValidationServer();
          break;
        case "de.fhdo.lemma.eclipse.ui.commands.disconnectFromLiveValidationServer":
          ServerConnection.instance().disconnect();
          break;
        case "de.fhdo.lemma.eclipse.ui.commands.connectionInformation":
          this.displayConnectionInformation();
          break;
      }
    }
    PlatformUI.getWorkbench().<IEvaluationService>getService(IEvaluationService.class).requestEvaluation("de.fhdo.lemma.eclipse.ui.editor.isConnectedToServer");
    return null;
  }
  
  /**
   * Trigger Live Validation server connect
   */
  private int connectToLiveValidationServer() {
    int _xblockexpression = (int) 0;
    {
      final ServerConnectionDialog connectionDialog = new ServerConnectionDialog(this.SHELL);
      connectionDialog.create();
      _xblockexpression = connectionDialog.open();
    }
    return _xblockexpression;
  }
  
  /**
   * Display information about Live Validation server connection
   */
  private void displayConnectionInformation() {
    final StringBuffer informationText = new StringBuffer("Connection information:\n");
    boolean hasInformationText = false;
    final ServerConnection connection = ServerConnection.instance();
    boolean _isEmpty = connection.getConnectedHostname().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("- Hostname: ");
      String _connectedHostname = connection.getConnectedHostname();
      _builder.append(_connectedHostname);
      String _plus = (_builder.toString() + "\n");
      informationText.append(_plus);
      hasInformationText = true;
    }
    int _connectedPort = connection.getConnectedPort();
    boolean _greaterThan = (_connectedPort > (-1));
    if (_greaterThan) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("- Port: ");
      int _connectedPort_1 = connection.getConnectedPort();
      _builder_1.append(_connectedPort_1);
      informationText.append(_builder_1);
      hasInformationText = true;
    }
    if (hasInformationText) {
      MessageDialog.openInformation(this.SHELL, "Connection Information", informationText.toString());
    } else {
      MessageDialog.openInformation(this.SHELL, "Connection Information", ("No connection " + 
        "information available."));
    }
  }
}
