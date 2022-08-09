package de.fhdo.lemma.eclipse.ui.specify_url_dialog;

import de.fhdo.lemma.service.openapi.LemmaGenerator;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.IDialogConstants;
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
  private static final int MIN_DIALOG_WIDTH = 400;
  
  private static final int MIN_DIALOG_HEIGHT = 250;
  
  private Text txtUrl;
  
  private Text txtTargetLocation;
  
  private Text txtDataModelName;
  
  private Text txtServiceModelName;
  
  private Text txtTechnologyModelName;
  
  private Text txtServicePrefix;
  
  private Button btnBrowseLocation;
  
  private Button btnUriWebLocation;
  
  private Button btnUriFileLocation;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private URL fetchUrl;
  
  private String targetLoc;
  
  private String dataName;
  
  private String servName;
  
  private String servPre;
  
  private String techName;
  
  public SpecifyUrlDialog(final Shell parentShell) {
    super(parentShell);
    TrayDialog.setDialogHelpAvailable(false);
    this.setHelpAvailable(false);
  }
  
  /**
   * OK button was pressed
   */
  @Override
  public void okPressed() {
    boolean _saveInput = this.saveInput();
    if (_saveInput) {
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
          _builder_1.append(this.targetLoc);
          _builder_1.append("/");
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append(this.dataName);
          _builder_2.append(".data");
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append(this.techName);
          _builder_3.append(".technology");
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append(this.servName);
          _builder_4.append(".services");
          generator.generateModels(_builder_1.toString(), _builder_2.toString(), _builder_3.toString(), _builder_4.toString(), this.servPre);
          Shell _shell_1 = this.getShell();
          StringConcatenation _builder_5 = new StringConcatenation();
          _builder_5.append("The transformation was a success!");
          _builder_5.newLine();
          _builder_5.append("Encountered problems (empty if none):");
          _builder_5.newLine();
          {
            List<String> _transMsgs = generator.getTransMsgs();
            for(final String msg_1 : _transMsgs) {
              _builder_5.append(msg_1);
              _builder_5.newLineIfNotEmpty();
            }
          }
          MessageDialog.openInformation(_shell_1, "Transformation Report", _builder_5.toString());
        } else {
          Shell _shell_2 = this.getShell();
          StringConcatenation _builder_6 = new StringConcatenation();
          _builder_6.append("It was not possible to generate an in-memory ");
          StringConcatenation _builder_7 = new StringConcatenation();
          _builder_7.append("representation of the file located at ");
          String _string = this.fetchUrl.toString();
          _builder_7.append(_string);
          _builder_7.append(" .");
          String _plus = (_builder_6.toString() + _builder_7);
          MessageDialog.openError(_shell_2, "Parsing Error", _plus);
        }
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception ex = (Exception)_t;
          Shell _shell_3 = this.getShell();
          StringConcatenation _builder_8 = new StringConcatenation();
          _builder_8.append("An error occured during extraction...");
          ex.printStackTrace();
          MessageDialog.openError(_shell_3, "Error", _builder_8.toString());
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      super.okPressed();
    }
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
   * Create dialog (to be called after constructor and before open())
   */
  @Override
  public void create() {
    super.create();
    this.setTitle("Specify OpenAPI Address");
    this.setMessage(("Specify the url of the OpenAPI specification from which the " + 
      "LEMMA models should be extracted."), IMessageProvider.INFORMATION);
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
    this.createTargetLocation(container);
    this.createDataModelName(container);
    this.createServiceModelName(container);
    this.createServicePrefix(container);
    this.createTechnologyModelName(container);
    return area;
  }
  
  private void createUrl(final Composite container) {
    final Label lblUrl = new Label(container, SWT.NONE);
    lblUrl.setText("URL: ");
    final GridData dataUrl = new GridData();
    dataUrl.grabExcessHorizontalSpace = true;
    dataUrl.horizontalAlignment = GridData.FILL;
    dataUrl.horizontalSpan = 1;
    dataUrl.widthHint = ((int) (this.getShell().getSize().x * 0.3));
    Text _text = new Text(container, SWT.BORDER);
    this.txtUrl = _text;
    this.txtUrl.setMessage("e.g. https://petstore3.swagger.io/api/v3/openapi.json");
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
      UrlTextValidator _urlTextValidator = new UrlTextValidator();
      final InputDialog urlDialog = new InputDialog(_shell, "", "Enter URL", 
        "Please enter the URL", _urlTextValidator);
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
    this.btnUriFileLocation.setText("Browse Filesystem");
    this.btnUriFileLocation.setLayoutData(uriWebLocationButton);
    final Consumer<SelectionEvent> _function_1 = (SelectionEvent e) -> {
      Shell _shell = this.getShell();
      final FileDialog fileDialog = new FileDialog(_shell);
      fileDialog.setText("Select your OpenAPI file");
      final String selectedFile = fileDialog.open();
      this.txtUrl.setText(new File(selectedFile).toURI().toString());
    };
    this.btnUriFileLocation.addSelectionListener(SelectionListener.widgetSelectedAdapter(_function_1));
  }
  
  private void createTargetLocation(final Composite container) {
    final Label lblTargetLocation = new Label(container, SWT.NULL);
    lblTargetLocation.setText("Target Location: ");
    final GridData dataTargetLocation = new GridData();
    dataTargetLocation.grabExcessHorizontalSpace = true;
    dataTargetLocation.horizontalAlignment = GridData.FILL;
    dataTargetLocation.horizontalSpan = 2;
    Text _text = new Text(container, SWT.BORDER);
    this.txtTargetLocation = _text;
    this.txtTargetLocation.setMessage("Select Directory");
    this.txtTargetLocation.setEnabled(false);
    this.txtTargetLocation.setLayoutData(dataTargetLocation);
    final GridData dataTargetLocationButton = new GridData();
    dataTargetLocationButton.grabExcessHorizontalSpace = true;
    dataTargetLocationButton.horizontalAlignment = SWT.RIGHT;
    Button _button = new Button(container, SWT.BUTTON1);
    this.btnBrowseLocation = _button;
    this.btnBrowseLocation.setText("Browse Filesystem");
    this.btnBrowseLocation.setLayoutData(dataTargetLocationButton);
    final Consumer<SelectionEvent> _function = (SelectionEvent e) -> {
      Shell _shell = this.getShell();
      final DirectoryDialog dirDialog = new DirectoryDialog(_shell);
      dirDialog.setText("Select your target directory");
      dirDialog.setFilterPath(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString());
      final String selectedDir = dirDialog.open();
      this.txtTargetLocation.setText(selectedDir);
    };
    this.btnBrowseLocation.addSelectionListener(SelectionListener.widgetSelectedAdapter(_function));
  }
  
  private void createDataModelName(final Composite container) {
    final Label lblDataModelName = new Label(container, SWT.NULL);
    lblDataModelName.setText("Data Model Name: ");
    final GridData dataDataModelName = new GridData();
    dataDataModelName.grabExcessHorizontalSpace = true;
    dataDataModelName.horizontalAlignment = GridData.FILL;
    dataDataModelName.horizontalSpan = 3;
    Text _text = new Text(container, SWT.BORDER);
    this.txtDataModelName = _text;
    this.txtDataModelName.setMessage("MyServiceData");
    this.txtDataModelName.setLayoutData(dataDataModelName);
  }
  
  private void createServiceModelName(final Composite container) {
    final Label lblServiceModelName = new Label(container, SWT.NULL);
    lblServiceModelName.setText("Service Model Name: ");
    final GridData dataServiceModelName = new GridData();
    dataServiceModelName.grabExcessHorizontalSpace = true;
    dataServiceModelName.horizontalAlignment = GridData.FILL;
    dataServiceModelName.horizontalSpan = 3;
    Text _text = new Text(container, SWT.BORDER);
    this.txtServiceModelName = _text;
    this.txtServiceModelName.setMessage("MyServiceService");
    this.txtServiceModelName.setLayoutData(dataServiceModelName);
  }
  
  private void createServicePrefix(final Composite container) {
    final Label lblServicePrefix = new Label(container, SWT.NULL);
    lblServicePrefix.setText("Service Model Prefix: ");
    final GridData dataServicePrefix = new GridData();
    dataServicePrefix.grabExcessHorizontalSpace = true;
    dataServicePrefix.horizontalAlignment = GridData.FILL;
    dataServicePrefix.horizontalSpan = 3;
    Text _text = new Text(container, SWT.BORDER);
    this.txtServicePrefix = _text;
    this.txtServicePrefix.setMessage("de.example");
    this.txtServicePrefix.setLayoutData(dataServicePrefix);
  }
  
  private void createTechnologyModelName(final Composite container) {
    final Label lblTechnologyModelName = new Label(container, SWT.NULL);
    lblTechnologyModelName.setText("Technology Model Name: ");
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
   * Stores the textfield values to actual fields.
   * Is called when a button in the dialog is pressed.
   */
  private boolean saveInput() {
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
        _builder.append(" is not a valid url!");
        MessageDialog.openError(_shell, "Invalid URL", _builder.toString());
        return false;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    this.fetchUrl = _xtrycatchfinallyexpression;
    this.targetLoc = this.txtTargetLocation.getText();
    this.dataName = this.txtDataModelName.getText();
    this.servName = this.txtServiceModelName.getText();
    this.techName = this.txtTechnologyModelName.getText();
    this.servPre = this.txtServicePrefix.getText();
    if ((((((!this.targetLoc.trim().isEmpty()) && (!this.dataName.trim().isEmpty())) && 
      (!this.servName.trim().isEmpty())) && (!this.techName.trim().isEmpty())) && 
      (!this.servPre.trim().isEmpty()))) {
      return true;
    } else {
      Shell _shell = this.getShell();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Please fill all the fields with proper data.");
      MessageDialog.openError(_shell, "Empty Fields", _builder.toString());
      return false;
    }
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
