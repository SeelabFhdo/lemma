package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations;

import com.google.common.base.Objects;
import de.fhdo.lemma.eclipse.ui.ProgrammaticIntermediateModelTransformation;
import de.fhdo.lemma.model_processing.eclipse.launcher.LaunchConfigurationConstants;
import de.fhdo.lemma.model_processing.eclipse.launcher.Utils;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.AbstractArgumentKind;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.ArgumentKindFactory;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.ConstantParameterArgumentKind;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.MultiValuedParameterArgumentKind;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.SingleValuedParameterArgumentKind;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AbstractIntermediateModelArgumentTypeWithEnumValue;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ui.ProjectFileSelectionDialog;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ui.ProjectSelectionDialog;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ui.tab.arguments_table.ArgumentsTable;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.typed.BeanProperties;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.typed.WidgetProperties;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ResourceListSelectionDialog;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * UI tab for the creation and maintenance of a model processing launch configuration.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class LaunchConfigurationTab extends AbstractLaunchConfigurationTab implements PropertyChangeListener {
  private static final ProcessorExecutableType DEFAULT_PROCESSOR_EXECUTABLE_TYPE = ProcessorExecutableType.LOCAL_JAVA_PROGRAM;

  private static final Argument DEFAULT_SOURCE_MODEL_FILE_ARGUMENT = Argument.newArgument().singleValued().sourceModel().parameter("-s");

  private static final Set<AbstractArgumentKind> SUPPORTED_ARGUMENT_KINDS = Collections.<AbstractArgumentKind>unmodifiableSet(CollectionLiterals.<AbstractArgumentKind>newHashSet(ArgumentKindFactory.fromIdentifier(ConstantParameterArgumentKind.IDENTIFIER), ArgumentKindFactory.fromIdentifier(MultiValuedParameterArgumentKind.IDENTIFIER), ArgumentKindFactory.fromIdentifier(SingleValuedParameterArgumentKind.IDENTIFIER)));

  private final List<Supplier<ControlDecoration>> CONFIGURATION_BINDERS = Collections.<Supplier<ControlDecoration>>unmodifiableList(CollectionLiterals.<Supplier<ControlDecoration>>newArrayList(
    ((Supplier<ControlDecoration>) () -> {
      return this.bindSourceModelProjectName();
    }), 
    ((Supplier<ControlDecoration>) () -> {
      return this.bindSourceModelFilePath();
    }), 
    ((Supplier<ControlDecoration>) () -> {
      return this.bindProcessorExecutableType();
    }), 
    ((Supplier<ControlDecoration>) () -> {
      return this.bindProcessorExecutablePath();
    }), 
    ((Supplier<ControlDecoration>) () -> {
      return this.bindBasicProcessorExecutionCommand();
    })));

  private final DataBindingContext dataBindingContext = new DataBindingContext();

  private final ArrayList<ControlDecoration> currentDecorations = CollectionLiterals.<ControlDecoration>newArrayList();

  private Composite mainComposite;

  private Text sourceModelProjectName;

  private Text sourceModelFilePath;

  private Combo processorExecutableType;

  private Text basicProcessorExecutionCommand;

  private Text processorExecutablePath;

  private ControlDecoration processorExecutablePathDecorator;

  private ArgumentsTable argumentsTable;

  private boolean initializationDone = false;

  private boolean sourceModelArgumentWasAddedOnce = false;

  private ProcessingConfiguration originalConfiguration;

  private ProcessingConfiguration currentConfiguration;

  private ProcessorExecutableType previousProcessorExecutableType;

  /**
   * Create the control
   */
  @Override
  public final void createControl(final Composite parent) {
    Composite _composite = new Composite(parent, SWT.NULL);
    this.mainComposite = _composite;
    GridData _gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
    this.mainComposite.setLayoutData(_gridData);
    GridLayout _gridLayout = new GridLayout(1, false);
    this.mainComposite.setLayout(_gridLayout);
    this.setControl(this.mainComposite);
    this.addResourceInputs(this.mainComposite);
    this.addProcessorInputs(this.mainComposite);
    this.addArgumentsTable(this.mainComposite);
  }

  /**
   * Add input fields for filesystem resources
   */
  private void addResourceInputs(final Composite parent) {
    final Composite resourceInputsGrid = new Composite(parent, SWT.NULL);
    GridData _gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
    resourceInputsGrid.setLayoutData(_gridData);
    GridLayout _gridLayout = new GridLayout(3, false);
    resourceInputsGrid.setLayout(_gridLayout);
    this.addSourceModelProject(resourceInputsGrid);
    this.addSourceModelFile(resourceInputsGrid);
  }

  /**
   * Add text field and button for specifying the name of the source model project
   */
  private void addSourceModelProject(final Composite parent) {
    Label _label = new Label(parent, SWT.NULL);
    _label.setText("Source model project:");
    Text _text = new Text(parent, SWT.BORDER);
    this.sourceModelProjectName = _text;
    GridData _gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
    this.sourceModelProjectName.setLayoutData(_gridData);
    final Button projectSelectionButton = new Button(parent, SWT.PUSH);
    projectSelectionButton.setText("Browse...");
    final Listener _function = (Event it) -> {
      this.handleSourceModelProjectSelection(parent.getShell());
    };
    projectSelectionButton.addListener(SWT.Selection, _function);
  }

  /**
   * Handler for a click on the button for selecting the name of the source model project
   */
  private void handleSourceModelProjectSelection(final Shell shell) {
    IProject selectedProject = null;
    final ProjectSelectionDialog dialog = new ProjectSelectionDialog(shell);
    int _open = dialog.open();
    boolean _notEquals = (_open != Window.CANCEL);
    if (_notEquals) {
      selectedProject = dialog.getSelectedProject();
      this.sourceModelProjectName.setText(selectedProject.getName());
    }
    try {
      String _name = null;
      if (selectedProject!=null) {
        _name=selectedProject.getName();
      }
      ProcessingConfiguration.validateSourceModelFilePath(_name, 
        this.sourceModelFilePath.getText());
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
        this.sourceModelFilePath.setText("");
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }

  /**
   * Bind the text field for specifying the name of the source model project
   */
  private ControlDecoration bindSourceModelProjectName() {
    final Procedure1<String> _function = (String it) -> {
      ProcessingConfiguration.validateSourceModelProjectName(it);
    };
    return this.<ProcessingConfiguration>bindWithValidationDecorationSupport(this.sourceModelProjectName, 
      ProcessingConfiguration.class, 
      "sourceModelProjectName", 
      this.currentConfiguration, _function);
  }

  /**
   * Helper to bind a text field with validation support to the tab's data binding context
   */
  private <T extends Object> ControlDecoration bindWithValidationDecorationSupport(final Text field, final Class<T> beanClass, final String propertyName, final T source, final Procedure1<? super String> validationProcedure) {
    return Utils.<T>bindWithValidationDecorationSupport(field, 
      this.dataBindingContext, beanClass, propertyName, source, validationProcedure).getValue();
  }

  /**
   * Add text field and button for specifying the path to the source model file
   */
  private void addSourceModelFile(final Composite parent) {
    Label _label = new Label(parent, SWT.NULL);
    _label.setText("Source model file:");
    Text _text = new Text(parent, SWT.BORDER);
    this.sourceModelFilePath = _text;
    GridData _gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
    this.sourceModelFilePath.setLayoutData(_gridData);
    final Button fileSelectionButton = new Button(parent, SWT.PUSH);
    fileSelectionButton.setText("Browse...");
    final Listener _function = (Event it) -> {
      this.handleSourceModelFileSelection(parent.getShell());
    };
    fileSelectionButton.addListener(SWT.Selection, _function);
  }

  /**
   * Handler for a click on the button for selecting the path to the source model file
   */
  private void handleSourceModelFileSelection(final Shell shell) {
    final IProject selectedProject = Utils.findProjectInCurrentWorkspace(this.sourceModelProjectName.getText());
    IFile selectedFile = null;
    if ((selectedProject != null)) {
      final ProjectFileSelectionDialog dialog = new ProjectFileSelectionDialog(shell, selectedProject);
      int _open = dialog.open();
      boolean _notEquals = (_open != Window.CANCEL);
      if (_notEquals) {
        selectedFile = dialog.getSelectedFile();
      }
    } else {
      IWorkspaceRoot _root = ResourcesPlugin.getWorkspace().getRoot();
      final ResourceListSelectionDialog dialog_1 = new ResourceListSelectionDialog(shell, _root, 
        IResource.FILE);
      if (((dialog_1.open() != Window.CANCEL) && (!((List<Object>)Conversions.doWrapArray(dialog_1.getResult())).isEmpty()))) {
        Object _get = dialog_1.getResult()[0];
        selectedFile = ((IFile) _get);
      }
    }
    if ((selectedFile == null)) {
      return;
    }
    if ((selectedProject == null)) {
      this.sourceModelProjectName.setText(selectedFile.getProject().getName());
    }
    this.sourceModelFilePath.setText(selectedFile.getProjectRelativePath().toString());
  }

  /**
   * Bind the text field for specifying the path to the source model file
   */
  private ControlDecoration bindSourceModelFilePath() {
    final Procedure1<String> _function = (String it) -> {
      ProcessingConfiguration.validateSourceModelFilePath(
        this.currentConfiguration.getSourceModelProjectName(), it);
    };
    return this.<ProcessingConfiguration>bindWithValidationDecorationSupport(this.sourceModelFilePath, 
      ProcessingConfiguration.class, 
      "sourceModelFilePath", 
      this.currentConfiguration, _function);
  }

  /**
   * Add input fields for model processor specification
   */
  private void addProcessorInputs(final Composite parent) {
    final Group inputGroup = new Group(parent, SWT.SHADOW_ETCHED_IN);
    inputGroup.setText("Processor Information");
    GridLayout _gridLayout = new GridLayout(2, false);
    inputGroup.setLayout(_gridLayout);
    GridData _gridData = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
    inputGroup.setLayoutData(_gridData);
    this.addTypeOfProcessorExecutable(inputGroup);
    this.addPathToProcessorExecutable(inputGroup);
    this.addBasicProcessorExecutionCommand(inputGroup);
  }

  /**
   * Add combo field for selecting the type of the processor executable
   */
  private void addTypeOfProcessorExecutable(final Composite parent) {
    Label _label = new Label(parent, SWT.NULL);
    _label.setText("Type of processor executable:");
    Combo _combo = new Combo(parent, (SWT.DROP_DOWN | SWT.READ_ONLY));
    this.processorExecutableType = _combo;
    GridData _gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
    this.processorExecutableType.setLayoutData(_gridData);
    final Function1<ProcessorExecutableType, String> _function = (ProcessorExecutableType it) -> {
      return ProcessorExecutableTypesInformationManager.label(it);
    };
    final Consumer<String> _function_1 = (String it) -> {
      this.processorExecutableType.add(it);
    };
    ListExtensions.<ProcessorExecutableType, String>map(((List<ProcessorExecutableType>)Conversions.doWrapArray(ProcessorExecutableType.values())), _function).forEach(_function_1);
    this.processorExecutableType.addSelectionListener(new SelectionListener() {
      @Override
      public void widgetDefaultSelected(final SelectionEvent e) {
        this.widgetSelected(e);
      }

      @Override
      public void widgetSelected(final SelectionEvent e) {
        LaunchConfigurationTab.this.toggleProcessorExecutablePathDecorator();
        boolean _setDefaultBasicProcessorExecutionCommandOnExecutableTypeSwitch = LaunchConfigurationTab.this.setDefaultBasicProcessorExecutionCommandOnExecutableTypeSwitch();
        boolean _not = (!_setDefaultBasicProcessorExecutionCommandOnExecutableTypeSwitch);
        if (_not) {
          Utils.triggerValidation(LaunchConfigurationTab.this.basicProcessorExecutionCommand);
        }
      }
    });
  }

  /**
   * Toggle the decorator on the text field for the path to the model processor executable
   * depending on whether the type of the processor executable provides support for specifying the
   * path
   */
  private void toggleProcessorExecutablePathDecorator() {
    final boolean executableTypeHasInputSupport = ProcessorExecutableTypesInformationManager.hasInputSupport(this.currentConfiguration.getProcessorExecutableType());
    if (executableTypeHasInputSupport) {
      this.processorExecutablePathDecorator.show();
    } else {
      this.processorExecutablePathDecorator.hide();
    }
  }

  /**
   * In case the type of the processor executable was changed, set the basic execution command to
   * the type's default if certain conditions of user interaction are met. Return true in case a
   * reset was performed and false otherwise.
   */
  private boolean setDefaultBasicProcessorExecutionCommandOnExecutableTypeSwitch() {
    final String previousDefaultCommand = LaunchConfigurationConstants.SUPPORTED_DEFAULT_BASIC_PROCESSOR_EXECUTION_COMMANDS.get(this.previousProcessorExecutableType);
    final String newDefaultCommand = LaunchConfigurationConstants.SUPPORTED_DEFAULT_BASIC_PROCESSOR_EXECUTION_COMMANDS.get(this.currentConfiguration.getProcessorExecutableType());
    final String currentCommand = this.currentConfiguration.getBasicProcessorExecutionCommand();
    if ((((previousDefaultCommand == null) || (newDefaultCommand == null)) || 
      (!Objects.equal(previousDefaultCommand, currentCommand)))) {
      return false;
    }
    this.currentConfiguration.setBasicProcessorExecutionCommand(newDefaultCommand);
    return true;
  }

  /**
   * Bind the combo field for selecting the type of the processor executable
   */
  private ControlDecoration bindProcessorExecutableType() {
    final ISWTObservableValue<String> target = WidgetProperties.comboSelection().observe(this.processorExecutableType);
    final IObservableValue<ProcessorExecutableType> model = BeanProperties.<ProcessingConfiguration, ProcessorExecutableType>value(ProcessingConfiguration.class, "processorExecutableType", 
      ProcessorExecutableType.class).observe(this.currentConfiguration);
    final UpdateValueStrategy<ProcessorExecutableType, String> modelToTargetConverter = new UpdateValueStrategy<ProcessorExecutableType, String>();
    final Function<ProcessorExecutableType, String> _function = (ProcessorExecutableType execType) -> {
      return ProcessorExecutableTypesInformationManager.label(execType);
    };
    modelToTargetConverter.setConverter(IConverter.<ProcessorExecutableType, String>create(_function));
    final UpdateValueStrategy<String, ProcessorExecutableType> targetToModelConverter = new UpdateValueStrategy<String, ProcessorExecutableType>();
    final Function<String, ProcessorExecutableType> _function_1 = (String label) -> {
      ProcessorExecutableType _xblockexpression = null;
      {
        this.previousProcessorExecutableType = this.currentConfiguration.getProcessorExecutableType();
        _xblockexpression = ProcessorExecutableTypesInformationManager.literal(label);
      }
      return _xblockexpression;
    };
    targetToModelConverter.setConverter(IConverter.<String, ProcessorExecutableType>create(_function_1));
    this.dataBindingContext.<String, ProcessorExecutableType>bindValue(target, model, targetToModelConverter, modelToTargetConverter);
    return null;
  }

  /**
   * Add text field and decorator for specifying the path to the model processor executable
   */
  private void addPathToProcessorExecutable(final Composite parent) {
    Label _label = new Label(parent, SWT.NULL);
    _label.setText("Path to processor executable:");
    Text _text = new Text(parent, SWT.BORDER);
    this.processorExecutablePath = _text;
    final GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, false);
    layoutData.widthHint = 50;
    this.processorExecutablePath.setLayoutData(layoutData);
    ControlDecoration _controlDecoration = new ControlDecoration(this.processorExecutablePath, 
      (SWT.TOP | SWT.RIGHT));
    this.processorExecutablePathDecorator = _controlDecoration;
    this.processorExecutablePathDecorator.setDescriptionText(("Click to receive input support for " + 
      "the selected type of the processor executable"));
    this.processorExecutablePathDecorator.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_CONTENT_PROPOSAL).getImage());
    this.processorExecutablePathDecorator.addSelectionListener(new SelectionListener() {
      @Override
      public void widgetDefaultSelected(final SelectionEvent e) {
        this.widgetDefaultSelected(e);
      }

      @Override
      public void widgetSelected(final SelectionEvent e) {
        String _xtrycatchfinallyexpression = null;
        try {
          Function2<? super Shell, ? super ProcessingConfiguration, ? extends String> _inputSupportFunction = ProcessorExecutableTypesInformationManager.inputSupportFunction(LaunchConfigurationTab.this.currentConfiguration.getProcessorExecutableType());
          String _apply = null;
          if (_inputSupportFunction!=null) {
            _apply=_inputSupportFunction.apply(LaunchConfigurationTab.this.getShell(), LaunchConfigurationTab.this.currentConfiguration);
          }
          _xtrycatchfinallyexpression = _apply;
        } catch (final Throwable _t) {
          if (_t instanceof IllegalArgumentException) {
            final IllegalArgumentException ex = (IllegalArgumentException)_t;
            Object _xblockexpression = null;
            {
              MessageDialog.openError(LaunchConfigurationTab.this.getShell(), "Input Support Error", ex.getMessage());
              _xblockexpression = null;
            }
            _xtrycatchfinallyexpression = ((String)_xblockexpression);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        final String selectedInput = _xtrycatchfinallyexpression;
        if ((selectedInput != null)) {
          LaunchConfigurationTab.this.processorExecutablePath.setText(selectedInput);
        }
      }
    });
  }

  /**
   * Bind the text field for specifying the path to the model processor executable
   */
  private ControlDecoration bindProcessorExecutablePath() {
    final Procedure1<String> _function = (String it) -> {
      ProcessingConfiguration.validateProcessorExecutablePath(
        this.currentConfiguration.getProcessorExecutableType(), 
        this.currentConfiguration.getBasicProcessorExecutionCommand(), it);
    };
    return this.<ProcessingConfiguration>bindWithValidationDecorationSupport(this.processorExecutablePath, 
      ProcessingConfiguration.class, 
      "processorExecutablePath", 
      this.currentConfiguration, _function);
  }

  /**
   * Add text field and decorator for specifying the basic model processor execution command
   */
  private void addBasicProcessorExecutionCommand(final Composite parent) {
    Label _label = new Label(parent, SWT.NULL);
    _label.setText("Basic processor execution command:");
    Text _text = new Text(parent, SWT.BORDER);
    this.basicProcessorExecutionCommand = _text;
    GridData _gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
    this.basicProcessorExecutionCommand.setLayoutData(_gridData);
    final ControlDecoration executionCommandHint = new ControlDecoration(this.basicProcessorExecutionCommand, 
      (SWT.TOP | SWT.RIGHT));
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("processor executable, e.g., \"java\" or \"docker\"");
    String _plus = ("The basic execution command to invoke the " + _builder);
    executionCommandHint.setDescriptionText(_plus);
    executionCommandHint.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION).getImage());
  }

  /**
   * Bind the text field for specifying the basic model processor execution command
   */
  private ControlDecoration bindBasicProcessorExecutionCommand() {
    final Procedure1<String> _function = (String it) -> {
      ProcessingConfiguration.validateBasicProcessorExecutionCommand(
        this.currentConfiguration.getProcessorExecutableType(), it);
    };
    return this.<ProcessingConfiguration>bindWithValidationDecorationSupport(this.basicProcessorExecutionCommand, 
      ProcessingConfiguration.class, 
      "basicProcessorExecutionCommand", 
      this.currentConfiguration, _function);
  }

  /**
   * Add arguments table
   */
  private ArgumentsTable addArgumentsTable(final Composite parent) {
    ArgumentsTable _xblockexpression = null;
    {
      final Group tableGroup = new Group(parent, SWT.SHADOW_ETCHED_IN);
      tableGroup.setText("Arguments");
      GridLayout _gridLayout = new GridLayout(1, false);
      tableGroup.setLayout(_gridLayout);
      GridData _gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
      tableGroup.setLayoutData(_gridData);
      ArgumentsTable _argumentsTable = new ArgumentsTable(tableGroup, LaunchConfigurationTab.SUPPORTED_ARGUMENT_KINDS);
      _xblockexpression = this.argumentsTable = _argumentsTable;
    }
    return _xblockexpression;
  }

  /**
   * Initialize the tab from the given ILaunchConfiguration
   */
  @Override
  public final void initializeFrom(final ILaunchConfiguration launchConfiguration) {
    ProcessingConfiguration _elvis = null;
    ProcessingConfiguration _deserializeFrom = ProcessingConfiguration.deserializeFrom(launchConfiguration);
    if (_deserializeFrom != null) {
      _elvis = _deserializeFrom;
    } else {
      ProcessingConfiguration _prepareNewProcessingConfiguration = this.prepareNewProcessingConfiguration();
      _elvis = _prepareNewProcessingConfiguration;
    }
    final ProcessingConfiguration configuration = _elvis;
    this.setCurrentConfiguration(configuration);
    this.toggleProcessorExecutablePathDecorator();
    this.initializationDone = true;
  }

  /**
   * Helper to prepare a new ProcessingConfiguration instance with default values
   */
  private ProcessingConfiguration prepareNewProcessingConfiguration() {
    String _get = LaunchConfigurationConstants.SUPPORTED_DEFAULT_BASIC_PROCESSOR_EXECUTION_COMMANDS.get(LaunchConfigurationTab.DEFAULT_PROCESSOR_EXECUTABLE_TYPE);
    return new ProcessingConfiguration(
      "", 
      "", 
      LaunchConfigurationTab.DEFAULT_PROCESSOR_EXECUTABLE_TYPE, 
      "", _get);
  }

  /**
   * Set the current ProcessingConfiguration instance handled by the tab
   */
  private void setCurrentConfiguration(final ProcessingConfiguration configuration) {
    this.removeCurrentConfigurationBindingsAndDecorations();
    if (this.currentConfiguration!=null) {
      this.currentConfiguration.removePropertyChangeListener(this);
    }
    this.originalConfiguration = configuration;
    Object _clone = configuration.clone();
    this.currentConfiguration = ((ProcessingConfiguration) _clone);
    this.originalConfiguration.convertToUserRepresentation();
    this.currentConfiguration.convertToUserRepresentation();
    this.argumentsTable.removePropertyChangeListener(this);
    this.argumentsTable.setInput(this.currentConfiguration);
    this.argumentsTable.addPropertyChangeListener(this);
    this.establishCurrentConfigurationBindingsAndDecorations();
    this.currentConfiguration.addPropertyChangeListener(this);
  }

  /**
   * Remove all bindings from the current data binding context including control decorations
   */
  private void removeCurrentConfigurationBindingsAndDecorations() {
    final Consumer<Binding> _function = (Binding it) -> {
      it.dispose();
      this.dataBindingContext.removeBinding(it);
    };
    this.dataBindingContext.getBindings().forEach(_function);
    final Consumer<ControlDecoration> _function_1 = (ControlDecoration it) -> {
      it.dispose();
    };
    this.currentDecorations.forEach(_function_1);
    this.currentDecorations.clear();
  }

  /**
   * Establish bindings and add control decorations for the current configuration
   */
  private void establishCurrentConfigurationBindingsAndDecorations() {
    final Consumer<Supplier<ControlDecoration>> _function = (Supplier<ControlDecoration> binder) -> {
      final ControlDecoration decoration = binder.get();
      if ((decoration != null)) {
        this.currentDecorations.add(decoration);
      }
    };
    this.CONFIGURATION_BINDERS.forEach(_function);
  }

  /**
   * React to a property change event
   */
  @Override
  public final void propertyChange(final PropertyChangeEvent event) {
    String _propertyName = event.getPropertyName();
    if (_propertyName != null) {
      switch (_propertyName) {
        case "sourceModelProjectName":
        case "sourceModelFilePath":
          this.addSourceModelFileArgumentIfAllowed();
          this.argumentsTable.updateArguments(AbstractIntermediateModelArgumentTypeWithEnumValue.class);
          break;
        case "basicProcessorExecutionCommand":
          Utils.triggerValidation(this.processorExecutablePath);
          break;
      }
    }
    this.updateLaunchConfigurationDialog();
  }

  /**
   * Add argument for the source model file to the arguments table
   */
  private void addSourceModelFileArgumentIfAllowed() {
    if ((((!this.initializationDone) || 
      this.sourceModelArgumentWasAddedOnce) || 
      this.argumentsTable.containsArgument(LaunchConfigurationTab.DEFAULT_SOURCE_MODEL_FILE_ARGUMENT))) {
      return;
    }
    try {
      ProcessingConfiguration.validateSourceModelFilePath(
        this.currentConfiguration.getSourceModelProjectName(), 
        this.currentConfiguration.getSourceModelFilePath());
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
        return;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    boolean _supportsTranformation = ProgrammaticIntermediateModelTransformation.supportsTranformation(this.currentConfiguration.getSourceModelFile());
    boolean _not = (!_supportsTranformation);
    if (_not) {
      return;
    }
    this.argumentsTable.addArgument(LaunchConfigurationTab.DEFAULT_SOURCE_MODEL_FILE_ARGUMENT);
    this.sourceModelArgumentWasAddedOnce = true;
  }

  /**
   * Validate the given ILaunchConfiguration
   */
  @Override
  public final boolean isValid(final ILaunchConfiguration configuration) {
    boolean _xtrycatchfinallyexpression = false;
    try {
      boolean _xblockexpression = false;
      {
        this.currentConfiguration.validateInUserRepresentation();
        _xblockexpression = true;
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
        _xtrycatchfinallyexpression = false;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }

  /**
   * Check if the tab's domain object is dirty
   */
  @Override
  public final boolean isDirty() {
    return (!Objects.equal(this.originalConfiguration, this.currentConfiguration));
  }

  /**
   * Apply the changes transported by the given ILaunchConfigurationWorkingCopy
   */
  @Override
  public final void performApply(final ILaunchConfigurationWorkingCopy launchConfiguration) {
    ProcessingConfiguration.setProcessingConfigurationAsAttribute(launchConfiguration, 
      this.currentConfiguration);
    this.currentConfiguration.convertToUserRepresentation();
  }

  /**
   * Get tab's name
   */
  @Override
  public final String getName() {
    return LaunchConfigurationConstants.COMMON_LAUNCH_CONFIGURATION_TAB_NAME;
  }

  /**
   * Get tab's image
   */
  @Override
  public final Image getImage() {
    return LaunchConfigurationConstants.COMMON_LAUNCH_CONFIGURATION_TAB_IMAGE;
  }

  /**
   * Set the tab's defaults
   */
  @Override
  public final void setDefaults(final ILaunchConfigurationWorkingCopy configuration) {
  }

  /**
   * Dispose the tab
   */
  @Override
  public final void dispose() {
    if (this.argumentsTable!=null) {
      this.argumentsTable.dispose();
    }
    if (this.dataBindingContext!=null) {
      this.dataBindingContext.dispose();
    }
    if (this.currentDecorations!=null) {
      final Consumer<ControlDecoration> _function = (ControlDecoration it) -> {
        it.dispose();
      };
      this.currentDecorations.forEach(_function);
    }
    super.dispose();
  }
}
