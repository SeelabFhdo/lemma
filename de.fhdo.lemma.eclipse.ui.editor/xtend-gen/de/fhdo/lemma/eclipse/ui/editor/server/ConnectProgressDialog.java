package de.fhdo.lemma.eclipse.ui.editor.server;

import com.google.common.base.Function;
import de.fhdo.lemma.eclipse.ui.editor.server.ConnectThread;
import de.fhdo.lemma.eclipse.ui.editor.server.ServerConnection;
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function2;

/**
 * Dialog to show progress while connecting to a Live Validation server.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ConnectProgressDialog extends TitleAreaDialog {
  private static final ResourceManager RESOURCE_MANAGER = new LocalResourceManager(JFaceResources.getResources());
  
  private static final int MIN_DIALOG_WIDTH = 200;
  
  private static final int MIN_DIALOG_HEIGHT = 100;
  
  private String hostname;
  
  private int port;
  
  private Function<ConnectProgressDialog, Void> connectedCallback;
  
  private Function2<ConnectProgressDialog, Exception, Void> connectionErrorCallback;
  
  private ConnectThread connectThread;
  
  public ConnectProgressDialog(final Shell parentShell, final String hostname, final int port, final Function<ConnectProgressDialog, Void> connectedCallback, final Function2<ConnectProgressDialog, Exception, Void> connectionErrorCallback) {
    super(parentShell);
    this.setShellStyle((this.getShellStyle() | SWT.SHEET));
    this.hostname = hostname;
    this.port = port;
    this.connectedCallback = connectedCallback;
    this.connectionErrorCallback = connectionErrorCallback;
  }
  
  /**
   * Create dialog (to be called after constructor and before open())
   */
  @Override
  public void create() {
    super.create();
    this.setTitle("Connecting to Live Validation server");
    this.setMessage("Attempting to connect to a Live Validation server.", 
      IMessageProvider.INFORMATION);
  }
  
  /**
   * Create buttons for the button bar
   */
  @Override
  public void createButtonsForButtonBar(final Composite parent) {
    this.createButton(parent, Window.CANCEL, IDialogConstants.CANCEL_LABEL, false);
  }
  
  /**
   * Internal callback for dialog area creation
   */
  @Override
  public Control createDialogArea(final Composite parent) {
    Control _createDialogArea = super.createDialogArea(parent);
    final Composite area = ((Composite) _createDialogArea);
    final Composite container = new Composite(area, SWT.NONE);
    GridData _gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
    container.setLayoutData(_gridData);
    final GridLayout layout = new GridLayout(1, false);
    container.setLayout(layout);
    final CLabel progressTitleLabel = new CLabel(container, SWT.NONE);
    progressTitleLabel.setImage(
      LemmaUiUtils.createImage(ConnectProgressDialog.RESOURCE_MANAGER, this.getClass(), "connectLiveValidationServer.gif"));
    GridData _gridData_1 = new GridData(GridData.FILL, GridData.CENTER, true, false);
    progressTitleLabel.setLayoutData(_gridData_1);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Connecting to Live Validation server at ");
    _builder.append(this.hostname);
    _builder.append(":");
    _builder.append(this.port);
    progressTitleLabel.setText(_builder.toString());
    final ProgressBar progressBar = new ProgressBar(container, SWT.INDETERMINATE);
    GridData _gridData_2 = new GridData(GridData.FILL, GridData.CENTER, true, false);
    progressBar.setLayoutData(_gridData_2);
    return area;
  }
  
  /**
   * Open dialog and connect to server
   */
  public int openAndConnectToServer() {
    this.constrainShellSize();
    this.getShell().open();
    Display _display = this.getShell().getDisplay();
    final Function<Void, Void> _function = (Void it) -> {
      return this.internalConnectedCallback();
    };
    final Function<Exception, Void> _function_1 = (Exception it) -> {
      return this.internalConnectionErrorCallback(it);
    };
    ConnectThread _connectThread = new ConnectThread(this.hostname, this.port, _display, _function, _function_1);
    this.connectThread = _connectThread;
    this.connectThread.start();
    LemmaUiUtils.runEventLoop(this.getShell());
    return this.getReturnCode();
  }
  
  /**
   * Internal callback when server connection was established successfully
   */
  private Void internalConnectedCallback() {
    return this.connectedCallback.apply(this);
  }
  
  /**
   * Internal callback when server connection could not be established successfully
   */
  private Void internalConnectionErrorCallback(final Exception error) {
    return this.connectionErrorCallback.apply(this, error);
  }
  
  /**
   * Catch button press
   */
  @Override
  public void buttonPressed(final int buttonId) {
    if (((buttonId == Window.CANCEL) && (this.connectThread != null))) {
      this.connectThread.interrupt();
      ServerConnection.instance().disconnect();
    }
    this.close();
  }
  
  /**
   * Initial size
   */
  @Override
  public Point getInitialSize() {
    final Point shellSize = super.getInitialSize();
    int _max = Math.max(this.convertHorizontalDLUsToPixels(ConnectProgressDialog.MIN_DIALOG_WIDTH), shellSize.x);
    int _convertVerticalDLUsToPixels = this.convertVerticalDLUsToPixels(ConnectProgressDialog.MIN_DIALOG_HEIGHT);
    return new Point(_max, _convertVerticalDLUsToPixels);
  }
}
