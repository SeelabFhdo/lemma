package de.fhdo.lemma.reconstruction.ui;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class LemmaReconstructionDialog extends TitleAreaDialog {
  private Text mongoDbHostnameText;
  
  private Text mongoDbPortText;
  
  @Accessors
  private String mongoDbHostname;
  
  @Accessors
  private String mongoDbPort;
  
  public LemmaReconstructionDialog(final Shell parentShell) {
    super(parentShell);
  }
  
  /**
   * Create dialog (to be called after constructor and before open())
   */
  @Override
  public void create() {
    super.create();
    this.setTitle("LEMMA Reconstruction from MongoDB reconstruction store.");
    this.setMessage("Reconstruct LEMMA Models.", IMessageProvider.INFORMATION);
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
    GridLayout _gridLayout = new GridLayout(2, false);
    container.setLayout(_gridLayout);
    this.createInputFiles(container);
    return area;
  }
  
  /**
   * Create top row in the dialog comprising schema information
   */
  private void createInputFiles(final Composite parent) {
    final Label hostnameLabel = new Label(parent, SWT.NONE);
    hostnameLabel.setText("MongoDB Hostname:");
    final GridData hostnameDataGrid = new GridData();
    hostnameDataGrid.grabExcessHorizontalSpace = true;
    hostnameDataGrid.horizontalAlignment = GridData.FILL;
    Text _text = new Text(parent, SWT.NONE);
    this.mongoDbHostnameText = _text;
    this.mongoDbHostnameText.setLayoutData(hostnameDataGrid);
    final Label portLabel = new Label(parent, SWT.NONE);
    portLabel.setText("MongoDB Port:");
    final GridData parentDataGrid = new GridData();
    parentDataGrid.grabExcessHorizontalSpace = true;
    parentDataGrid.horizontalAlignment = GridData.FILL;
    Text _text_1 = new Text(parent, SWT.NONE);
    this.mongoDbPortText = _text_1;
    this.mongoDbPortText.setLayoutData(hostnameDataGrid);
  }
  
  @Override
  public void createButtonsForButtonBar(final Composite parent) {
    this.createButton(parent, IDialogConstants.OK_ID, "Continue", true);
    this.createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
  }
  
  @Override
  public boolean isResizable() {
    return true;
  }
  
  @Override
  public void okPressed() {
    this.saveInput();
    super.okPressed();
  }
  
  private String saveInput() {
    String _xblockexpression = null;
    {
      this.mongoDbHostname = this.mongoDbHostnameText.getText();
      _xblockexpression = this.mongoDbPort = this.mongoDbPortText.getText();
    }
    return _xblockexpression;
  }
  
  @Pure
  public String getMongoDbHostname() {
    return this.mongoDbHostname;
  }
  
  public void setMongoDbHostname(final String mongoDbHostname) {
    this.mongoDbHostname = mongoDbHostname;
  }
  
  @Pure
  public String getMongoDbPort() {
    return this.mongoDbPort;
  }
  
  public void setMongoDbPort(final String mongoDbPort) {
    this.mongoDbPort = mongoDbPort;
  }
}
