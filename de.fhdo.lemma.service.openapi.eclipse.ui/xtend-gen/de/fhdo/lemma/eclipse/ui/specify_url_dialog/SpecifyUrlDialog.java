package de.fhdo.lemma.eclipse.ui.specify_url_dialog;

import de.fhdo.lemma.service.openapi.LemmaGenerator;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.apache.commons.validator.routines.UrlValidator;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * The dialog for the transformation of OpenAPI specifications to LEMMA models.
 * 
 * @author <a href="mailto:jonas.sorgalla@fh-dortmund.de">Jonas Sorgalla</a>
 */
@SuppressWarnings("all")
public class SpecifyUrlDialog extends TitleAreaDialog {
  /**
   * Validator for strings to represent valid URLs
   */
  private static class UrlInputValidator implements IInputValidator {
    /**
     * Perform the validation
     */
    @Override
    public String isValid(final String newUrl) {
      String _xifexpression = null;
      boolean _isValid = new UrlValidator().isValid(newUrl);
      if (_isValid) {
        _xifexpression = null;
      } else {
        _xifexpression = "Invalid URL";
      }
      return _xifexpression;
    }
  }
  
  private static final int MIN_DIALOG_WIDTH = 400;
  
  private static final int MIN_DIALOG_HEIGHT = 250;
  
  private Text txtUrl;
  
  private Text txtTargetFolder;
  
  private Text txtDataModelName;
  
  private Text txtTechnologyModelName;
  
  private Text txtServiceModelName;
  
  private Text txtServicePrefix;
  
  private Button btnBrowseFolder;
  
  private Button btnUriWebLocation;
  
  private Button btnUriFileLocation;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private URL fetchUrl;
  
  private String targetFolder;
  
  private String dataModelName;
  
  private String technologyModelName;
  
  private String serviceModelName;
  
  private String servicePrefix;
  
  public SpecifyUrlDialog(final Shell parentShell) {
    super(parentShell);
    TrayDialog.setDialogHelpAvailable(false);
    this.setHelpAvailable(false);
  }
  
  /**
   * Create dialog (to be called after constructor and before open())
   */
  @Override
  public void create() {
    super.create();
    this.setTitle("Specify OpenAPI Specification URL");
    this.setMessage(("Specify the URL of the OpenAPI specification from which LEMMA models shall " + 
      "be extracted."), IMessageProvider.INFORMATION);
  }
  
  /**
   * Create buttons for the button bar
   */
  @Override
  public void createButtonsForButtonBar(final Composite parent) {
    this.createButton(parent, IDialogConstants.OK_ID, "Extract", true);
    this.createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
  }
  
  /**
   * Catch button press
   */
  @Override
  public void buttonPressed(final int buttonId) {
    switch (buttonId) {
      case IDialogConstants.OK_ID:
        this.okPressed();
        break;
      case IDialogConstants.CANCEL_ID:
        this.cancelPressed();
        break;
    }
  }
  
  /**
   * OK button was pressed
   */
  @Override
  public void okPressed() {
    boolean _syncInput = this.syncInput();
    boolean _not = (!_syncInput);
    if (_not) {
      return;
    }
    try {
      final LemmaGenerator generator = new LemmaGenerator();
      final ArrayList<String> parsingMessages = generator.parse(this.fetchUrl.toString());
      Shell _shell = this.getShell();
      StringConcatenation _builder = new StringConcatenation();
      {
        for(final String msg : parsingMessages) {
          _builder.newLineIfNotEmpty();
          _builder.append(msg);
          _builder.newLineIfNotEmpty();
        }
      }
      MessageDialog.openInformation(_shell, "Parsing Report", _builder.toString());
      boolean _isParsed = generator.isParsed();
      if (_isParsed) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(this.dataModelName);
        _builder_1.append(".data");
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append(this.technologyModelName);
        _builder_2.append(".technology");
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append(this.serviceModelName);
        _builder_3.append(".services");
        generator.generateModels(
          this.targetFolder, _builder_1.toString(), _builder_2.toString(), _builder_3.toString(), 
          this.servicePrefix);
        boolean _isEmpty = generator.getTransMsgs().isEmpty();
        if (_isEmpty) {
          MessageDialog.openInformation(this.getShell(), "Transformation Report", 
            "Transformation successfully completed");
        } else {
          Shell _shell_1 = this.getShell();
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append("There were error during the transformation:");
          _builder_4.newLine();
          {
            List<String> _transMsgs = generator.getTransMsgs();
            for(final String msg_1 : _transMsgs) {
              _builder_4.append("- ");
              _builder_4.append(msg_1);
              _builder_4.newLineIfNotEmpty();
            }
          }
          MessageDialog.openError(_shell_1, "Transformation Report", _builder_4.toString());
        }
      } else {
        Shell _shell_2 = this.getShell();
        String _string = this.fetchUrl.toString();
        String _plus = (("Generation of in-memory " + 
          "representation not possible for the OpenAPI specification URL ") + _string);
        MessageDialog.openError(_shell_2, "Parsing Error", _plus);
      }
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
        Shell _shell_3 = this.getShell();
        String _message = ex.getMessage();
        String _plus_1 = ("Error during extraction: " + _message);
        MessageDialog.openError(_shell_3, "Error", _plus_1);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    super.okPressed();
  }
  
  /**
   * Synchronize user input with class state
   */
  private boolean syncInput() {
    URL _xtrycatchfinallyexpression = null;
    try {
      String _text = this.txtUrl.getText();
      _xtrycatchfinallyexpression = new URL(_text);
    } catch (final Throwable _t) {
      if (_t instanceof MalformedURLException) {
        Shell _shell = this.getShell();
        StringConcatenation _builder = new StringConcatenation();
        String _text_1 = this.txtUrl.getText();
        _builder.append(_text_1);
        _builder.append(" is not a ");
        String _plus = (_builder.toString() + 
          "valid URL");
        MessageDialog.openError(_shell, "Invalid URL", _plus);
        return false;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    this.fetchUrl = _xtrycatchfinallyexpression;
    this.targetFolder = this.txtTargetFolder.getText().trim();
    this.dataModelName = this.txtDataModelName.getText().trim();
    this.technologyModelName = this.txtTechnologyModelName.getText().trim();
    this.serviceModelName = this.txtServiceModelName.getText().trim();
    this.servicePrefix = this.txtServicePrefix.getText().trim();
    final boolean missingValues = ((((this.targetFolder.isEmpty() || 
      this.dataModelName.isEmpty()) || 
      this.technologyModelName.isEmpty()) || 
      this.serviceModelName.isEmpty()) || 
      this.servicePrefix.isEmpty());
    if (missingValues) {
      MessageDialog.openError(this.getShell(), "Missing Field Values", ("Please specify a value " + 
        "for each field"));
    }
    return (!missingValues);
  }
  
  @Override
  public Control createDialogArea(final Composite parent) {
    Control _createDialogArea = super.createDialogArea(parent);
    final Composite area = ((Composite) _createDialogArea);
    final Composite container = new Composite(area, SWT.NULL);
    GridData _gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
    container.setLayoutData(_gridData);
    final GridLayout layout = new GridLayout(4, false);
    layout.verticalSpacing = 10;
    container.setLayout(layout);
    this.createUrl(container);
    this.createTargetFolder(container);
    this.createDataModelName(container);
    this.createServiceModelName(container);
    this.createServicePrefix(container);
    this.createTechnologyModelName(container);
    return area;
  }
  
  private void createUrl(final Composite container) {
    final Label lblUrl = new Label(container, SWT.NONE);
    lblUrl.setText("URL:");
    final GridData dataUrl = new GridData();
    dataUrl.grabExcessHorizontalSpace = true;
    dataUrl.horizontalAlignment = GridData.FILL;
    dataUrl.horizontalSpan = 1;
    dataUrl.widthHint = ((int) (this.getShell().getSize().x * 0.3));
    Text _text = new Text(container, SWT.BORDER);
    this.txtUrl = _text;
    this.txtUrl.setEnabled(false);
    this.txtUrl.setLayoutData(dataUrl);
    final GridData uriWebLocationButton = new GridData();
    uriWebLocationButton.grabExcessHorizontalSpace = true;
    uriWebLocationButton.horizontalAlignment = SWT.RIGHT;
    Button _button = new Button(container, SWT.BUTTON1);
    this.btnUriWebLocation = _button;
    this.btnUriWebLocation.setText("Enter URL");
    this.btnUriWebLocation.setLayoutData(uriWebLocationButton);
    final Consumer<SelectionEvent> _function = (SelectionEvent e) -> {
      Shell _shell = this.getShell();
      SpecifyUrlDialog.UrlInputValidator _urlInputValidator = new SpecifyUrlDialog.UrlInputValidator();
      final InputDialog urlDialog = new InputDialog(_shell, 
        "", 
        "Enter OpenAPI specification URL", 
        ("Please enter a URL to an OpenAPI specification, e.g., " + 
          "https://petstore3.swagger.io/api/v3/openapi.json"), _urlInputValidator);
      int _open = urlDialog.open();
      boolean _equals = (_open == Window.OK);
      if (_equals) {
        this.txtUrl.setText(urlDialog.getValue());
      }
    };
    this.btnUriWebLocation.addSelectionListener(SelectionListener.widgetSelectedAdapter(_function));
    final GridData uriFileLocationButton = new GridData();
    uriFileLocationButton.grabExcessHorizontalSpace = true;
    uriFileLocationButton.horizontalAlignment = SWT.RIGHT;
    Button _button_1 = new Button(container, SWT.BUTTON1);
    this.btnUriFileLocation = _button_1;
    this.btnUriFileLocation.setText("Select OpenAPI Specification File");
    this.btnUriFileLocation.setLayoutData(uriWebLocationButton);
    final Consumer<SelectionEvent> _function_1 = (SelectionEvent e) -> {
      Shell _shell = this.getShell();
      final FileDialog fileDialog = new FileDialog(_shell);
      fileDialog.setText("Please select an OpenAPI specification file");
      final String selectedFile = fileDialog.open();
      this.txtUrl.setText(new File(selectedFile).toURI().toString());
    };
    this.btnUriFileLocation.addSelectionListener(SelectionListener.widgetSelectedAdapter(_function_1));
  }
  
  private void createTargetFolder(final Composite container) {
    final Label lblTargetFolder = new Label(container, SWT.NULL);
    lblTargetFolder.setText("Target Folder:");
    final GridData dataTargetLocation = new GridData();
    dataTargetLocation.grabExcessHorizontalSpace = true;
    dataTargetLocation.horizontalAlignment = GridData.FILL;
    dataTargetLocation.horizontalSpan = 2;
    Text _text = new Text(container, SWT.BORDER);
    this.txtTargetFolder = _text;
    this.txtTargetFolder.setMessage("Select Target Folder");
    this.txtTargetFolder.setEnabled(false);
    this.txtTargetFolder.setLayoutData(dataTargetLocation);
    final GridData dataTargetFolderButton = new GridData();
    dataTargetFolderButton.grabExcessHorizontalSpace = true;
    dataTargetFolderButton.horizontalAlignment = SWT.RIGHT;
    Button _button = new Button(container, SWT.BUTTON1);
    this.btnBrowseFolder = _button;
    this.btnBrowseFolder.setText("Select Target Folder");
    this.btnBrowseFolder.setLayoutData(dataTargetFolderButton);
    final Consumer<SelectionEvent> _function = (SelectionEvent e) -> {
      Shell _shell = this.getShell();
      final DirectoryDialog dirDialog = new DirectoryDialog(_shell);
      dirDialog.setText("Select target folder.");
      dirDialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString());
      this.txtTargetFolder.setText(dirDialog.open());
    };
    this.btnBrowseFolder.addSelectionListener(SelectionListener.widgetSelectedAdapter(_function));
  }
  
  private void createDataModelName(final Composite container) {
    final Label lblDataModelName = new Label(container, SWT.NULL);
    lblDataModelName.setText("Data Model Name:");
    final GridData dataDataModelName = new GridData();
    dataDataModelName.grabExcessHorizontalSpace = true;
    dataDataModelName.horizontalAlignment = GridData.FILL;
    dataDataModelName.horizontalSpan = 3;
    Text _text = new Text(container, SWT.BORDER);
    this.txtDataModelName = _text;
    this.txtDataModelName.setMessage("DataModel");
    this.txtDataModelName.setLayoutData(dataDataModelName);
  }
  
  private void createServiceModelName(final Composite container) {
    final Label lblServiceModelName = new Label(container, SWT.NULL);
    lblServiceModelName.setText("Service Model Name:");
    final GridData dataServiceModelName = new GridData();
    dataServiceModelName.grabExcessHorizontalSpace = true;
    dataServiceModelName.horizontalAlignment = GridData.FILL;
    dataServiceModelName.horizontalSpan = 3;
    Text _text = new Text(container, SWT.BORDER);
    this.txtServiceModelName = _text;
    this.txtServiceModelName.setMessage("ServiceModel");
    this.txtServiceModelName.setLayoutData(dataServiceModelName);
  }
  
  private void createServicePrefix(final Composite container) {
    final Label lblServicePrefix = new Label(container, SWT.NULL);
    lblServicePrefix.setText("Service Model Prefix:");
    final GridData dataServicePrefix = new GridData();
    dataServicePrefix.grabExcessHorizontalSpace = true;
    dataServicePrefix.horizontalAlignment = GridData.FILL;
    dataServicePrefix.horizontalSpan = 3;
    Text _text = new Text(container, SWT.BORDER);
    this.txtServicePrefix = _text;
    this.txtServicePrefix.setMessage("org.example");
    this.txtServicePrefix.setLayoutData(dataServicePrefix);
  }
  
  private void createTechnologyModelName(final Composite container) {
    final Label lblTechnologyModelName = new Label(container, SWT.NULL);
    lblTechnologyModelName.setText("Technology Model Name:");
    final GridData dataTechnologyModelName = new GridData();
    dataTechnologyModelName.grabExcessHorizontalSpace = true;
    dataTechnologyModelName.horizontalAlignment = GridData.FILL;
    dataTechnologyModelName.horizontalSpan = 3;
    Text _text = new Text(container, SWT.BORDER);
    this.txtTechnologyModelName = _text;
    this.txtTechnologyModelName.setMessage("OpenAPI");
    this.txtTechnologyModelName.setLayoutData(dataTechnologyModelName);
  }
  
  /**
   * Flag to indicate that dialog is resizable
   */
  @Override
  public boolean isResizable() {
    return true;
  }
  
  /**
   * Initial size
   */
  @Override
  public Point getInitialSize() {
    final Point shellSize = super.getInitialSize();
    int _max = Math.max(this.convertHorizontalDLUsToPixels(SpecifyUrlDialog.MIN_DIALOG_WIDTH), shellSize.x);
    int _max_1 = Math.max(this.convertVerticalDLUsToPixels(SpecifyUrlDialog.MIN_DIALOG_HEIGHT), shellSize.y);
    return new Point(_max, _max_1);
  }
  
  @Pure
  public URL getFetchUrl() {
    return this.fetchUrl;
  }
}
