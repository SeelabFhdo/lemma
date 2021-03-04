package de.fhdo.lemma.eclipse.ui.specify_openapi_dialog;

import de.fhdo.lemma.service.open_api.LemmaGenerator;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class SpecifyOpenApiDialog extends TitleAreaDialog {
  private static final int MIN_DIALOG_WIDTH = 500;
  
  private static final int MIN_DIALOG_HEIGHT = 250;
  
  private Text txtUrl;
  
  private Text txtTargetLocation;
  
  private Text txtDataModelName;
  
  private Text txtServModelName;
  
  private Text txtTechnologyModelName;
  
  public URL fetchUrl;
  
  public String targetLocation;
  
  public String dataName;
  
  public String serviceName;
  
  public String servicePrefix;
  
  public String technologyName;
  
  private Button btnBrowseLocation;
  
  private Text txtServicePrefix;
  
  private String externalFetchUrl;
  
  private String externalServiceName;
  
  private String externalTargetLocation;
  
  public SpecifyOpenApiDialog(final Shell parentShell) {
    super(parentShell);
    this.externalFetchUrl = "";
    this.externalServiceName = "";
    this.externalTargetLocation = "";
  }
  
  public SpecifyOpenApiDialog(final Shell parentShell, final String fetchUrl, final String serviceName, final String targetLocation) {
    super(parentShell);
    this.externalFetchUrl = fetchUrl;
    this.externalServiceName = serviceName;
    this.externalTargetLocation = targetLocation;
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
        final List<String> parsingMessages = generator.parse(this.fetchUrl.toString());
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
          _builder_1.append(this.targetLocation);
          _builder_1.append("/");
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append(this.dataName);
          _builder_2.append(".data");
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append(this.serviceName);
          _builder_3.append(".services");
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append(this.technologyName);
          _builder_4.append(".technology");
          generator.generateModels(_builder_1.toString(), _builder_2.toString(), _builder_3.toString(), _builder_4.toString(), this.servicePrefix);
        } else {
          Shell _shell_1 = this.getShell();
          StringConcatenation _builder_5 = new StringConcatenation();
          _builder_5.append("It was not possible to generate an in-memory ");
          StringConcatenation _builder_6 = new StringConcatenation();
          _builder_6.append("representation of the file located at ");
          String _string = this.fetchUrl.toString();
          _builder_6.append(_string);
          _builder_6.append(" .");
          String _plus = (_builder_5.toString() + _builder_6);
          MessageDialog.openError(_shell_1, "Parsing Error", _plus);
        }
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception ex = (Exception)_t;
          Shell _shell_2 = this.getShell();
          StringConcatenation _builder_7 = new StringConcatenation();
          _builder_7.append("An error occured during extraction...");
          ex.printStackTrace();
          MessageDialog.openError(_shell_2, "Error", _builder_7.toString());
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
    final Composite container = new Composite(area, SWT.NONE);
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
    dataUrl.horizontalSpan = 3;
    Text _text = new Text(container, SWT.SINGLE);
    this.txtUrl = _text;
    this.txtUrl.setMessage("e.g. https://petstore3.swagger.io/api/v3/openapi.json");
    boolean _isEmpty = this.externalFetchUrl.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.txtUrl.setText(this.externalFetchUrl);
      this.txtUrl.setEnabled(false);
      this.txtUrl.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_DARK_GRAY));
    }
    this.txtUrl.setLayoutData(dataUrl);
  }
  
  private void createTargetLocation(final Composite container) {
    final Label lblTargetLocation = new Label(container, SWT.NONE);
    lblTargetLocation.setText("Target Location: ");
    final GridData dataTargetLocation = new GridData();
    dataTargetLocation.grabExcessHorizontalSpace = true;
    dataTargetLocation.horizontalAlignment = GridData.FILL;
    dataTargetLocation.horizontalSpan = 2;
    Text _text = new Text(container, SWT.SINGLE);
    this.txtTargetLocation = _text;
    this.txtTargetLocation.setMessage("Select Directory");
    this.txtTargetLocation.setEnabled(false);
    this.txtTargetLocation.setLayoutData(dataTargetLocation);
    final GridData dataTargetLocationButton = new GridData();
    dataTargetLocationButton.grabExcessHorizontalSpace = true;
    dataTargetLocationButton.horizontalAlignment = SWT.RIGHT;
    Button _button = new Button(container, SWT.BUTTON1);
    this.btnBrowseLocation = _button;
    this.btnBrowseLocation.setText("Browse");
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
    boolean _isEmpty = this.externalTargetLocation.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.txtTargetLocation.setText(this.externalTargetLocation);
      this.btnBrowseLocation.setEnabled(false);
      this.txtTargetLocation.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_DARK_GRAY));
    }
  }
  
  private void createDataModelName(final Composite container) {
    final Label lblDataModelName = new Label(container, SWT.NONE);
    lblDataModelName.setText("Data Model Name: ");
    final GridData dataDataModelName = new GridData();
    dataDataModelName.grabExcessHorizontalSpace = true;
    dataDataModelName.horizontalAlignment = GridData.FILL;
    dataDataModelName.horizontalSpan = 3;
    Text _text = new Text(container, SWT.SINGLE);
    this.txtDataModelName = _text;
    this.txtDataModelName.setMessage("MyServiceData");
    this.txtDataModelName.setLayoutData(dataDataModelName);
  }
  
  private void createServiceModelName(final Composite container) {
    final Label lblServiceModelName = new Label(container, SWT.NONE);
    lblServiceModelName.setText("Service Model Name: ");
    final GridData dataServiceModelName = new GridData();
    dataServiceModelName.grabExcessHorizontalSpace = true;
    dataServiceModelName.horizontalAlignment = GridData.FILL;
    dataServiceModelName.horizontalSpan = 3;
    Text _text = new Text(container, SWT.SINGLE);
    this.txtServModelName = _text;
    this.txtServModelName.setMessage("MyServiceService");
    this.txtServModelName.setLayoutData(dataServiceModelName);
    boolean _isEmpty = this.externalServiceName.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.txtServModelName.setText(this.externalServiceName);
      this.txtServModelName.setEnabled(false);
      this.txtServModelName.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_DARK_GRAY));
    }
  }
  
  private void createServicePrefix(final Composite container) {
    final Label lblServicePrefix = new Label(container, SWT.NONE);
    lblServicePrefix.setText("Service Model Prefix: ");
    final GridData dataServicePrefix = new GridData();
    dataServicePrefix.grabExcessHorizontalSpace = true;
    dataServicePrefix.horizontalAlignment = GridData.FILL;
    dataServicePrefix.horizontalSpan = 3;
    Text _text = new Text(container, SWT.SINGLE);
    this.txtServicePrefix = _text;
    this.txtServicePrefix.setMessage("de.example");
    this.txtServicePrefix.setLayoutData(dataServicePrefix);
  }
  
  private void createTechnologyModelName(final Composite container) {
    final Label lblTechnologyModelName = new Label(container, SWT.NONE);
    lblTechnologyModelName.setText("Technology Model Name: ");
    final GridData dataTechnologyModelName = new GridData();
    dataTechnologyModelName.grabExcessHorizontalSpace = true;
    dataTechnologyModelName.horizontalAlignment = GridData.FILL;
    dataTechnologyModelName.horizontalSpan = 3;
    Text _text = new Text(container, SWT.SINGLE);
    this.txtTechnologyModelName = _text;
    this.txtTechnologyModelName.setText("OpenApi");
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
    this.targetLocation = this.txtTargetLocation.getText();
    this.dataName = this.txtDataModelName.getText();
    this.serviceName = this.txtServModelName.getText();
    this.technologyName = this.txtTechnologyModelName.getText();
    this.servicePrefix = this.txtServicePrefix.getText();
    if ((((((!this.targetLocation.trim().isEmpty()) && (!this.dataName.trim().isEmpty())) && 
      (!this.serviceName.trim().isEmpty())) && (!this.technologyName.trim().isEmpty())) && 
      (!this.servicePrefix.trim().isEmpty()))) {
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
    int _max = Math.max(this.convertHorizontalDLUsToPixels(SpecifyOpenApiDialog.MIN_DIALOG_WIDTH), shellSize.x);
    int _max_1 = Math.max(this.convertVerticalDLUsToPixels(SpecifyOpenApiDialog.MIN_DIALOG_HEIGHT), shellSize.y);
    return new Point(_max, _max_1);
  }
}
