package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut;

import com.google.common.base.Objects;
import de.fhdo.lemma.model_processing.eclipse.launcher.Utils;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableTypesInformationManager;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.AbstractLaunchConfigurationTemplate;
import java.beans.PropertyChangeEvent;
import org.apache.commons.io.FilenameUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Abstract superclass for dialogs that enable the completion of code generator configuration
 * templates for model processing launch shortcuts.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public abstract class AbstractCodeGeneratorCompletionDialog extends AbstractLaunchConfigurationTemplate.AbstractTemplateCompletionDialog {
  private static final ILaunchManager LAUNCH_MANAGER = DebugPlugin.getDefault().getLaunchManager();
  
  private ProcessorExecutableType generatorExecutableType;
  
  private Argument targetFolderArgument;
  
  protected Text generatorExecutablePath;
  
  protected Text basicGeneratorExecutionCommand;
  
  protected Text targetFolder;
  
  protected final String generatorLongName;
  
  protected final String generatorShortName;
  
  /**
   * Constructor
   */
  public AbstractCodeGeneratorCompletionDialog(final Shell parentShell, final IProject project, final IFile file, final String generatorLongName, final String generatorShortName) {
    super(parentShell, project, file, 3);
    this.generatorLongName = generatorLongName;
    this.generatorShortName = generatorShortName;
  }
  
  /**
   * Set the generator executable type for the dialog
   */
  protected final ProcessorExecutableType setGeneratorExecutableType(final ProcessorExecutableType generatorExecutableType) {
    return this.generatorExecutableType = generatorExecutableType;
  }
  
  /**
   * Set the target folder Argument instance for the dialog
   */
  protected final void setTargetFolderArgument(final Argument targetFolderArgument) {
    this.targetFolderArgument = targetFolderArgument;
    this.targetFolderArgument.addPropertyChangeListener(this);
  }
  
  /**
   * Create the dialog
   */
  @Override
  public void create() {
    super.create();
    final String fileBasename = FilenameUtils.getBaseName(this.file.getName());
    String _elvis = null;
    String _fileExtension = this.file.getFileExtension();
    if (_fileExtension != null) {
      _elvis = _fileExtension;
    } else {
      _elvis = "";
    }
    final String fileExtension = _elvis;
    String generatorNameAddendum = this.getGeneratorNameAddendum();
    boolean _isEmpty = generatorNameAddendum.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      Object _replace = Utils.replace(generatorNameAddendum, " ", "_");
      String _plus = (_replace + "_");
      generatorNameAddendum = _plus;
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Run_");
    _builder.append(this.generatorShortName);
    _builder.append("_");
    _builder.append(generatorNameAddendum);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append(fileBasename);
    _builder_1.append("_");
    _builder_1.append(fileExtension);
    final String configurationNamePrefix = (_builder.toString() + _builder_1);
    this.configurationTemplate.setLaunchConfigurationName(AbstractCodeGeneratorCompletionDialog.LAUNCH_MANAGER.generateLaunchConfigurationName(configurationNamePrefix));
  }
  
  /**
   * Enable dialog implementers to provide an addendum for the generator short name as part of the
   * launch configuration name
   */
  public String getGeneratorNameAddendum() {
    return "";
  }
  
  /**
   * Add additional controls to the dialog
   */
  @Override
  public void insertAdditionalControlsAfterDefaults(final Composite parent) {
    this.addPathToGeneratorExecutable(parent);
    this.addBasicGeneratorExecutionCommand(parent);
    this.addTargetFolder(parent);
  }
  
  /**
   * Add text field to specify the path to the code generator executable
   */
  private void addPathToGeneratorExecutable(final Composite parent) {
    String labelAddendum = this.getGeneratorExecutableLabelTextAddendum();
    boolean _isEmpty = labelAddendum.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      labelAddendum = (" " + labelAddendum);
    }
    Label _label = new Label(parent, SWT.NULL);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(this.generatorLongName);
    _builder.append(labelAddendum);
    _builder.append(":");
    _label.setText(_builder.toString());
    Text _text = new Text(parent, SWT.BORDER);
    this.generatorExecutablePath = _text;
    GridData _gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
    this.generatorExecutablePath.setLayoutData(_gridData);
    final Button generatorExecutablePathSelectionButton = new Button(parent, SWT.PUSH);
    generatorExecutablePathSelectionButton.setText("Browse...");
    final Listener _function = (Event it) -> {
      String _xtrycatchfinallyexpression = null;
      try {
        _xtrycatchfinallyexpression = ProcessorExecutableTypesInformationManager.inputSupportFunction(this.generatorExecutableType).apply(this.getShell(), this.configurationTemplate);
      } catch (final Throwable _t) {
        if (_t instanceof IllegalArgumentException) {
          final IllegalArgumentException ex = (IllegalArgumentException)_t;
          Object _xblockexpression = null;
          {
            MessageDialog.openError(this.getShell(), "Input Support Error", ex.getMessage());
            _xblockexpression = null;
          }
          _xtrycatchfinallyexpression = ((String)_xblockexpression);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      final String selectedExecutablePath = _xtrycatchfinallyexpression;
      if ((selectedExecutablePath != null)) {
        this.generatorExecutablePath.setText(selectedExecutablePath);
      }
    };
    generatorExecutablePathSelectionButton.addListener(SWT.Selection, _function);
    final Procedure1<String> _function_1 = (String it) -> {
      ProcessingConfigurationWithLaunchConfigurationName.validateProcessorExecutablePath(
        this.configurationTemplate.getProcessorExecutableType(), 
        this.configurationTemplate.getBasicProcessorExecutionCommand(), it);
    };
    this.<ProcessingConfigurationWithLaunchConfigurationName>bindWithValidationDecorationSupport(
      this.generatorExecutablePath, 
      ProcessingConfigurationWithLaunchConfigurationName.class, 
      "processorExecutablePath", 
      this.configurationTemplate, _function_1);
  }
  
  /**
   * Enable dialog implementers to provide an addendum for the generator long name as part of the
   * label for the generator executable path's text field
   */
  public String getGeneratorExecutableLabelTextAddendum() {
    return "";
  }
  
  /**
   * Add text field to specify the code generator's basic execution command
   */
  private void addBasicGeneratorExecutionCommand(final Composite parent) {
    Label _label = new Label(parent, SWT.NULL);
    _label.setText("Basic generator execution command:");
    Text _text = new Text(parent, SWT.BORDER);
    this.basicGeneratorExecutionCommand = _text;
    final GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, false);
    layoutData.horizontalSpan = 2;
    this.basicGeneratorExecutionCommand.setLayoutData(layoutData);
    final Procedure1<String> _function = (String it) -> {
      ProcessingConfigurationWithLaunchConfigurationName.validateBasicProcessorExecutionCommand(
        this.configurationTemplate.getProcessorExecutableType(), it);
    };
    this.<ProcessingConfigurationWithLaunchConfigurationName>bindWithValidationDecorationSupport(
      this.basicGeneratorExecutionCommand, 
      ProcessingConfigurationWithLaunchConfigurationName.class, 
      "basicProcessorExecutionCommand", 
      this.configurationTemplate, _function);
  }
  
  /**
   * Add text field to specify the target folder for generated code
   */
  private void addTargetFolder(final Composite parent) {
    Label _label = new Label(parent, SWT.NULL);
    _label.setText("Generation target folder:");
    Text _text = new Text(parent, SWT.BORDER);
    this.targetFolder = _text;
    GridData _gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
    this.targetFolder.setLayoutData(_gridData);
    final Button folderSelectionButton = new Button(parent, SWT.PUSH);
    folderSelectionButton.setText("Browse...");
    final Listener _function = (Event it) -> {
      Shell _shell = this.getShell();
      final DirectoryDialog directoryDialog = new DirectoryDialog(_shell, SWT.OPEN);
      directoryDialog.setText("Select target folder for generated artifacts");
      directoryDialog.setFilterPath(this.configurationTemplate.getSourceModelFile().getProject().getLocation().makeAbsolute().toString());
      final String selectedFolder = directoryDialog.open();
      if ((selectedFolder != null)) {
        this.targetFolder.setText(selectedFolder);
      }
    };
    folderSelectionButton.addListener(SWT.Selection, _function);
    final Procedure1<String> _function_1 = (String it) -> {
      this.targetFolderArgument.getType().validateValueInUserRepresentation(this.configurationTemplate, it);
    };
    this.<Argument>bindWithValidationDecorationSupport(
      this.targetFolder, 
      Argument.class, 
      "value", 
      this.targetFolderArgument, _function_1);
  }
  
  /**
   * Callback for property changes
   */
  @Override
  public final void reactToPropertyChange(final PropertyChangeEvent event) {
    String _propertyName = event.getPropertyName();
    boolean _equals = Objects.equal(_propertyName, "basicProcessorExecutionCommand");
    if (_equals) {
      Utils.triggerValidation(this.generatorExecutablePath);
    }
  }
  
  /**
   * Close the dialog
   */
  @Override
  public boolean close() {
    boolean _xblockexpression = false;
    {
      this.targetFolderArgument.removePropertyChangeListener(this);
      _xblockexpression = super.close();
    }
    return _xblockexpression;
  }
}
