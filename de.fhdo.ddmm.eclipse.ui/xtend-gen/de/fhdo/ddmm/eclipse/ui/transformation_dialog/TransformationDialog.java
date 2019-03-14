package de.fhdo.ddmm.eclipse.ui.transformation_dialog;

import com.google.common.base.Predicate;
import de.fhdo.ddmm.eclipse.ui.AbstractUiModelTransformationStrategy;
import de.fhdo.ddmm.eclipse.ui.ModelFile;
import de.fhdo.ddmm.eclipse.ui.transformation_dialog.TransformationThread;
import de.fhdo.ddmm.eclipse.ui.utils.DdmmUiUtils;
import de.fhdo.ddmm.intermediate.transformations.AbstractIntermediateModelTransformationStrategy;
import de.fhdo.ddmm.intermediate.transformations.IntermediateTransformationException;
import de.fhdo.ddmm.intermediate.transformations.IntermediateTransformationPhase;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public class TransformationDialog extends TitleAreaDialog {
  private static final int MIN_DIALOG_WIDTH = 200;
  
  private static final int MIN_DIALOG_HEIGHT = 120;
  
  private static final String PROGRESS_TITLE_TEXT = "Performing intermediate model transformations";
  
  private static final Logger LOGGER = LoggerFactory.getLogger(TransformationDialog.class);
  
  private AbstractUiModelTransformationStrategy strategy;
  
  private List<ModelFile> filesToTransform;
  
  private ModelFile currentModelFile;
  
  private static final ResourceManager RESOURCE_MANAGER = new LocalResourceManager(JFaceResources.getResources());
  
  private TransformationThread transformationThread;
  
  private Button cancelButton;
  
  private int currentTransformationIndex;
  
  private CLabel progressTitleLabel;
  
  private ProgressBar progressBar;
  
  private Label progressMessageLabel;
  
  private StyledText progressMessageText;
  
  private boolean stopTransformations;
  
  private boolean cancelPressed;
  
  private boolean shellClosed;
  
  private boolean ignoreAllTransformationWarnings;
  
  /**
   * Constructor
   */
  public TransformationDialog(final Shell parentShell, final AbstractUiModelTransformationStrategy strategy, final List<ModelFile> inputModelFiles) {
    super(parentShell);
    if ((parentShell == null)) {
      throw new IllegalArgumentException("Shell must not be null");
    } else {
      if ((strategy == null)) {
        throw new IllegalArgumentException("Transformation strategy must not be null");
      } else {
        if (((inputModelFiles == null) || inputModelFiles.isEmpty())) {
          throw new IllegalArgumentException("Input models must not be null or empty");
        }
      }
    }
    this.strategy = strategy;
    final Function1<ModelFile, Boolean> _function = new Function1<ModelFile, Boolean>() {
      public Boolean apply(final ModelFile it) {
        AbstractIntermediateModelTransformationStrategy _mainTransformationStrategy = it.getFileTypeDescription().getMainTransformationStrategy();
        return Boolean.valueOf((_mainTransformationStrategy != null));
      }
    };
    this.filesToTransform = IterableExtensions.<ModelFile>toList(IterableExtensions.<ModelFile>filter(inputModelFiles, _function));
  }
  
  /**
   * Open dialog and run transformations
   */
  public int openAndRunTransformations() {
    this.constrainShellSize();
    this.getShell().open();
    Display _display = this.getShell().getDisplay();
    final Predicate<ModelFile> _function = new Predicate<ModelFile>() {
      public boolean apply(final ModelFile it) {
        return TransformationDialog.this.nextTransformation(it);
      }
    };
    final Predicate<IntermediateTransformationException> _function_1 = new Predicate<IntermediateTransformationException>() {
      public boolean apply(final IntermediateTransformationException it) {
        return TransformationDialog.this.transformationWarningOccurred(it);
      }
    };
    final Predicate<Exception> _function_2 = new Predicate<Exception>() {
      public boolean apply(final Exception it) {
        return TransformationDialog.this.transformationExceptionOccurred(it);
      }
    };
    final Predicate<Void> _function_3 = new Predicate<Void>() {
      public boolean apply(final Void it) {
        return TransformationDialog.this.currentTransformationFinished();
      }
    };
    final Predicate<Void> _function_4 = new Predicate<Void>() {
      public boolean apply(final Void it) {
        return TransformationDialog.this.transformationsFinished();
      }
    };
    TransformationThread _transformationThread = new TransformationThread(this.filesToTransform, _display, _function, _function_1, _function_2, _function_3, _function_4);
    this.transformationThread = _transformationThread;
    this.transformationThread.start();
    DdmmUiUtils.runEventLoop(this.getShell());
    return this.getReturnCode();
  }
  
  /**
   * Transformation thread callback: Next transformation starts
   */
  private boolean nextTransformation(final ModelFile nextFile) {
    this.currentModelFile = nextFile;
    this.currentTransformationIndex++;
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(TransformationDialog.PROGRESS_TITLE_TEXT);
    _builder.append(" ");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("(");
    _builder_1.append(this.currentTransformationIndex);
    _builder_1.append("/");
    int _size = this.filesToTransform.size();
    _builder_1.append(_size);
    _builder_1.append(")");
    String _plus = (_builder.toString() + _builder_1);
    this.progressTitleLabel.setText(_plus);
    final String filePathText = this.currentModelFile.getFile().getFullPath().toString();
    final String transformationPathText = this.currentModelFile.getTransformationTargetPath();
    final StyleRange styleRange = new StyleRange();
    styleRange.start = filePathText.length();
    styleRange.length = 4;
    styleRange.fontStyle = SWT.BOLD;
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append(filePathText);
    _builder_2.append(" to ");
    _builder_2.append(transformationPathText);
    this.progressMessageText.setText(_builder_2.toString());
    this.progressMessageText.setStyleRange(styleRange);
    this.progressBar.setSelection(this.currentTransformationIndex);
    return (!this.stopTransformations);
  }
  
  /**
   * Transformation thread callback: Warning occurred during transformation
   */
  private boolean transformationWarningOccurred(final IntermediateTransformationException warning) {
    boolean _switchResult = false;
    IntermediateTransformationPhase _phase = warning.getPhase();
    if (_phase != null) {
      switch (_phase) {
        case SOURCE_MODEL_VALIDATION:
          _switchResult = this.sourceModelValidationWarning(warning.getMessage());
          break;
        case TRANSFORMATION_FINISHED:
          _switchResult = this.transformationFinishedWarning(warning.getMessage());
          break;
        default:
          _switchResult = true;
          break;
      }
    } else {
      _switchResult = true;
    }
    return _switchResult;
  }
  
  /**
   * Handle source model validation warning
   */
  private boolean sourceModelValidationWarning(final String warningMessage) {
    if (this.ignoreAllTransformationWarnings) {
      return true;
    }
    Shell _shell = this.getShell();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("The ");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("following warning occurred while validating ");
    String _name = this.currentModelFile.getFile().getName();
    _builder_1.append(_name);
    _builder_1.append(": ");
    String _plus = (_builder.toString() + _builder_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append(warningMessage);
    _builder_2.append(" How do you want to proceed?");
    String _plus_1 = (_plus + _builder_2);
    final MessageDialog dialog = new MessageDialog(_shell, "Source model validation warning", null, _plus_1, MessageDialog.WARNING, 3, 
      "Abort all transformations", "Abort current transformation", ("Ignore validation " + 
      "warnings and proceed"), "Proceed");
    final int buttonPressed = dialog.open();
    boolean _switchResult = false;
    switch (buttonPressed) {
      case (-1):
      case 0:
        boolean _xblockexpression = false;
        {
          this.stopTransformations = true;
          _xblockexpression = false;
        }
        _switchResult = _xblockexpression;
        break;
      case 1:
        _switchResult = false;
        break;
      case 2:
        boolean _xblockexpression_1 = false;
        {
          this.ignoreAllTransformationWarnings = true;
          _xblockexpression_1 = true;
        }
        _switchResult = _xblockexpression_1;
        break;
      default:
        _switchResult = true;
        break;
    }
    return _switchResult;
  }
  
  /**
   * Handle warnings that occur after a transformation was finished
   */
  private boolean transformationFinishedWarning(final String warningMessage) {
    MessageDialog.openWarning(this.getShell(), "Warning after transformation", warningMessage);
    return true;
  }
  
  /**
   * Transformation thread callback: Exception occurred during transformation
   */
  private boolean transformationExceptionOccurred(final Exception exception) {
    String _xifexpression = null;
    if (((exception.getMessage() != null) && (!exception.getMessage().isEmpty()))) {
      _xifexpression = exception.getMessage();
    } else {
      String _xblockexpression = null;
      {
        exception.printStackTrace();
        final StringWriter stringWriter = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(stringWriter);
        exception.printStackTrace(printWriter);
        final String stackTraceString = stringWriter.toString();
        TransformationDialog.LOGGER.error(stackTraceString);
        _xblockexpression = ("Unexpected transformation exception. Please consult the Eclipse log file for " + 
          "the detailed stack trace.");
      }
      _xifexpression = _xblockexpression;
    }
    final String exceptionMessage = _xifexpression;
    Shell _shell = this.getShell();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("The following ");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("error occurred during the transformation of ");
    String _name = this.currentModelFile.getFile().getName();
    _builder_1.append(_name);
    _builder_1.append(": ");
    String _plus = (_builder.toString() + _builder_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("\"");
    _builder_2.append(exceptionMessage);
    _builder_2.append("\" The current transformation was not executed. How do you ");
    String _plus_1 = (_plus + _builder_2);
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("want to proceed?");
    String _plus_2 = (_plus_1 + _builder_3);
    final MessageDialog dialog = new MessageDialog(_shell, "Transformation error", null, _plus_2, MessageDialog.ERROR, 1, "Abort all transformations", 
      "Continue with next transformation");
    final int buttonPressed = dialog.open();
    boolean _switchResult = false;
    switch (buttonPressed) {
      case (-1):
      case 0:
        boolean _xblockexpression_1 = false;
        {
          this.stopTransformations = true;
          _xblockexpression_1 = false;
        }
        _switchResult = _xblockexpression_1;
        break;
      default:
        _switchResult = true;
        break;
    }
    return _switchResult;
  }
  
  /**
   * Transformation thread callback: Current transformation finished
   */
  private boolean currentTransformationFinished() {
    return (!this.stopTransformations);
  }
  
  /**
   * Transformation thread callback: All transformations were finished
   */
  private boolean transformationsFinished() {
    TransformationDialog.RESOURCE_MANAGER.dispose();
    if (this.shellClosed) {
      super.handleShellCloseEvent();
    } else {
      if (this.cancelPressed) {
        super.cancelPressed();
      } else {
        super.okPressed();
      }
    }
    return false;
  }
  
  /**
   * Create dialog (to be called after constructor and before open())
   */
  public void create() {
    super.create();
    this.setTitle("Performing Intermediate Model Transformations");
  }
  
  /**
   * Close dialog
   */
  public void closeTray() {
    TransformationDialog.RESOURCE_MANAGER.dispose();
    super.closeTray();
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
    final Point shellSize = super.getInitialSize();
    int _max = Math.max(this.convertHorizontalDLUsToPixels(TransformationDialog.MIN_DIALOG_WIDTH), shellSize.x);
    int _max_1 = Math.max(this.convertVerticalDLUsToPixels(TransformationDialog.MIN_DIALOG_HEIGHT), shellSize.y);
    return new Point(_max, _max_1);
  }
  
  /**
   * Internal callback for dialog area creation
   */
  public Control createDialogArea(final Composite parent) {
    Control _createDialogArea = super.createDialogArea(parent);
    final Composite area = ((Composite) _createDialogArea);
    final Composite container = new Composite(area, SWT.NONE);
    GridData _gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
    container.setLayoutData(_gridData);
    final GridLayout layout = new GridLayout(1, false);
    container.setLayout(layout);
    CLabel _cLabel = new CLabel(container, SWT.NONE);
    this.progressTitleLabel = _cLabel;
    this.progressTitleLabel.setImage(
      DdmmUiUtils.createImage(TransformationDialog.RESOURCE_MANAGER, "transformedFile.gif"));
    GridData _gridData_1 = new GridData(GridData.FILL, GridData.CENTER, true, false);
    this.progressTitleLabel.setLayoutData(_gridData_1);
    this.progressTitleLabel.setText(TransformationDialog.PROGRESS_TITLE_TEXT);
    ProgressBar _progressBar = new ProgressBar(container, SWT.SMOOTH);
    this.progressBar = _progressBar;
    this.progressBar.setMaximum(this.filesToTransform.size());
    GridData _gridData_2 = new GridData(GridData.FILL, GridData.CENTER, true, false);
    this.progressBar.setLayoutData(_gridData_2);
    StyledText _styledText = new StyledText(container, SWT.NONE);
    this.progressMessageText = _styledText;
    GridData _gridData_3 = new GridData(GridData.FILL, GridData.CENTER, true, false);
    this.progressMessageText.setLayoutData(_gridData_3);
    this.progressMessageText.setBackground(parent.getBackground());
    this.progressMessageText.setEditable(false);
    this.progressMessageText.setEnabled(false);
    this.progressMessageText.getBackground();
    this.progressMessageText.setCaret(null);
    Label _label = new Label(container, SWT.NONE);
    this.progressMessageLabel = _label;
    GridData _gridData_4 = new GridData(GridData.FILL, GridData.CENTER, true, false);
    this.progressMessageLabel.setLayoutData(_gridData_4);
    final Label line = new Label(container, (SWT.HORIZONTAL | SWT.SEPARATOR));
    GridData _gridData_5 = new GridData(GridData.FILL, GridData.CENTER, true, false);
    line.setLayoutData(_gridData_5);
    return area;
  }
  
  /**
   * Create buttons for the button bar
   */
  public void createButtonsForButtonBar(final Composite parent) {
    this.cancelButton = this.createButton(parent, IDialogConstants.CANCEL_ID, 
      IDialogConstants.CANCEL_LABEL, false);
  }
  
  /**
   * User clicked close icon in the window bar
   */
  public void handleShellCloseEvent() {
    this.userAborted(true);
  }
  
  /**
   * "Cancel" was pressed
   */
  public void cancelPressed() {
    this.userAborted(false);
  }
  
  /**
   * User clicked on "Cancel" or the close icon in the window bar
   */
  private boolean userAborted(final boolean shellClosed) {
    boolean _xblockexpression = false;
    {
      if ((this.transformationThread == null)) {
        if (shellClosed) {
          super.handleShellCloseEvent();
        } else {
          super.cancelPressed();
        }
      }
      this.shellClosed = shellClosed;
      this.cancelPressed = (!shellClosed);
      this.cancelButton.setText("Canceling");
      this.cancelButton.setEnabled(false);
      _xblockexpression = this.stopTransformations = true;
    }
    return _xblockexpression;
  }
}
