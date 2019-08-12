package de.fhdo.lemma.eclipse.ui.editor.server;

import com.google.common.base.Function;
import de.fhdo.ddmm.live_validation.protocol.LiveValidationServer;
import de.fhdo.lemma.eclipse.ui.editor.server.ConnectProgressDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function2;

/**
 * Dialog to request data needed to connect to a Live Validation server.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ServerConnectionDialog extends TitleAreaDialog {
  private static final String HOSTNAME_REGEX = (("^(" + 
    "([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-]*[a-zA-Z0-9])\\.)*") + 
    "([A-Za-z0-9]|[A-Za-z0-9][A-Za-z0-9\\-]*[A-Za-z0-9])");
  
  private static final int MIN_DIALOG_WIDTH = 220;
  
  private static final int MIN_DIALOG_HEIGHT = 110;
  
  private Text hostnameField;
  
  private Text portField;
  
  /**
   * Constructor
   */
  public ServerConnectionDialog(final Shell parentShell) {
    super(parentShell);
    this.setShellStyle((this.getShellStyle() | SWT.SHEET));
  }
  
  /**
   * Create dialog (to be called after constructor and before open())
   */
  public void create() {
    super.create();
    this.setTitle("Connect to Live Validation server");
    this.setMessage("Enter data needed to connect to a running Live Validation server instance:", 
      IMessageProvider.INFORMATION);
  }
  
  /**
   * Create buttons for the button bar
   */
  public void createButtonsForButtonBar(final Composite parent) {
    this.createButton(parent, Window.CANCEL, IDialogConstants.CANCEL_LABEL, false);
    this.createButton(parent, Window.OK, "Connect", true);
  }
  
  /**
   * Create the dialog's content
   */
  public Control createDialogArea(final Composite parent) {
    Control _createDialogArea = super.createDialogArea(parent);
    final Composite area = ((Composite) _createDialogArea);
    final Composite container = new Composite(area, SWT.NONE);
    GridData _gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
    container.setLayoutData(_gridData);
    GridLayout _gridLayout = new GridLayout(2, false);
    container.setLayout(_gridLayout);
    this.hostnameField = this.createTextField(container, "Hostname:", 
      LiveValidationServer.DEFAULT_HOSTNAME);
    this.portField = this.createTextField(container, "Port:", Integer.valueOf(LiveValidationServer.DEFAULT_PORT));
    return area;
  }
  
  /**
   * Catch button press
   */
  public void buttonPressed(final int buttonId) {
    switch (buttonId) {
      case Window.CANCEL:
        this.setReturnCodeAndClose(Window.CANCEL);
        break;
      case Window.OK:
        this.connectPressed();
        break;
    }
  }
  
  /**
   * Handle click on the connect button
   */
  private void connectPressed() {
    boolean _isHostnameValid = this.isHostnameValid();
    boolean _not = (!_isHostnameValid);
    if (_not) {
      return;
    } else {
      boolean _isPortValid = this.isPortValid();
      boolean _not_1 = (!_isPortValid);
      if (_not_1) {
        return;
      } else {
        this.connectToServer(this.hostnameField.getText(), Integer.parseInt(this.portField.getText()));
      }
    }
  }
  
  /**
   * Attempt to connect to Live Validation server
   */
  private int connectToServer(final String hostname, final int port) {
    int _xblockexpression = (int) 0;
    {
      Shell _shell = this.getShell();
      final Function<ConnectProgressDialog, Void> _function = new Function<ConnectProgressDialog, Void>() {
        public Void apply(final ConnectProgressDialog it) {
          return ServerConnectionDialog.this.connectionToServerEstablished(it);
        }
      };
      final Function2<ConnectProgressDialog, Exception, Void> _function_1 = new Function2<ConnectProgressDialog, Exception, Void>() {
        public Void apply(final ConnectProgressDialog dialog, final Exception error) {
          return ServerConnectionDialog.this.errorDuringConnectionAttemptCallback(dialog, error);
        }
      };
      final ConnectProgressDialog connectProgressDialog = new ConnectProgressDialog(_shell, hostname, port, _function, _function_1);
      connectProgressDialog.create();
      _xblockexpression = connectProgressDialog.openAndConnectToServer();
    }
    return _xblockexpression;
  }
  
  /**
   * Connect thread callback: Connection was established
   */
  private Void connectionToServerEstablished(final ConnectProgressDialog connectDialog) {
    connectDialog.close();
    this.close();
    return null;
  }
  
  /**
   * Connect thread callback: Error occurred during connection approach
   */
  private Void errorDuringConnectionAttemptCallback(final ConnectProgressDialog connectDialog, final Exception error) {
    Shell _shell = this.getShell();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("An error ");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("occurred while trying to connect to the Live Validation server at ");
    String _plus = (_builder.toString() + _builder_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    String _text = this.hostnameField.getText();
    _builder_2.append(_text);
    _builder_2.append(":");
    String _text_1 = this.portField.getText();
    _builder_2.append(_text_1);
    _builder_2.append(": ");
    String _message = error.getMessage();
    _builder_2.append(_message);
    String _plus_1 = (_plus + _builder_2);
    MessageDialog.openError(_shell, "Error during server connection attempt", _plus_1);
    connectDialog.close();
    return null;
  }
  
  /**
   * Check entered hostname for correctness
   */
  private boolean isHostnameValid() {
    final String hostname = this.hostnameField.getText();
    boolean _xifexpression = false;
    if (((hostname == null) || hostname.isEmpty())) {
      boolean _xblockexpression = false;
      {
        this.showError("Invalid hostname", "Hostname must not be empty.");
        _xblockexpression = false;
      }
      _xifexpression = _xblockexpression;
    } else {
      boolean _xifexpression_1 = false;
      boolean _matches = hostname.matches(ServerConnectionDialog.HOSTNAME_REGEX);
      boolean _not = (!_matches);
      if (_not) {
        boolean _xblockexpression_1 = false;
        {
          this.showError("Invalid hostname", "Hostname has invalid format.");
          _xblockexpression_1 = false;
        }
        _xifexpression_1 = _xblockexpression_1;
      } else {
        _xifexpression_1 = true;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  /**
   * Check entered port for correctness
   */
  private boolean isPortValid() {
    if (((this.portField.getText() == null) || this.portField.getText().isEmpty())) {
      this.showError("Invalid port", "Port must not be empty.");
      return false;
    }
    int _xtrycatchfinallyexpression = (int) 0;
    try {
      _xtrycatchfinallyexpression = Integer.parseInt(this.portField.getText());
    } catch (final Throwable _t) {
      if (_t instanceof NumberFormatException) {
        this.showError("Invalid port", "Port has invalid format.");
        return false;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    final int port = _xtrycatchfinallyexpression;
    if (((port < 0) || (port > 65535))) {
      this.showError("Invalid port", "Port has invalid format.");
      return false;
    }
    return true;
  }
  
  /**
   * Convenience method to show an error message
   */
  private void showError(final String title, final String message) {
    MessageDialog.openError(this.getShell(), title, message);
  }
  
  /**
   * Helper method to set the return code and also close the dialog
   */
  private void setReturnCodeAndClose(final int buttonId) {
    this.setReturnCode(buttonId);
    this.close();
  }
  
  /**
   * Create input text field for the file path and related labels
   */
  private Text createTextField(final Composite container, final String labelText, final Object initialValue) {
    final Label label = new Label(container, SWT.NULL);
    label.setText(labelText);
    final Text textField = new Text(container, (SWT.SINGLE | SWT.BORDER));
    final GridData fieldData = new GridData();
    fieldData.grabExcessHorizontalSpace = true;
    fieldData.horizontalAlignment = GridData.FILL;
    textField.setLayoutData(fieldData);
    String _xifexpression = null;
    if ((initialValue != null)) {
      _xifexpression = initialValue.toString();
    } else {
      _xifexpression = "";
    }
    textField.setText(_xifexpression);
    return textField;
  }
  
  /**
   * Flag to indicate that dialog is resizable
   */
  public boolean isResizable() {
    return true;
  }
  
  /**
   * Initial size
   */
  public Point getInitialSize() {
    int _convertHorizontalDLUsToPixels = this.convertHorizontalDLUsToPixels(ServerConnectionDialog.MIN_DIALOG_WIDTH);
    int _convertVerticalDLUsToPixels = this.convertVerticalDLUsToPixels(ServerConnectionDialog.MIN_DIALOG_HEIGHT);
    return new Point(_convertHorizontalDLUsToPixels, _convertVerticalDLUsToPixels);
  }
}
