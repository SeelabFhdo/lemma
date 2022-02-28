package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut;

import com.google.common.base.Objects;
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils;
import de.fhdo.lemma.model_processing.eclipse.launcher.LaunchConfigurationConstants;
import de.fhdo.lemma.model_processing.eclipse.launcher.Utils;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.container_base_generator.ContainerBaseGeneratorTemplate;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.container_base_generator.DockerContainerBaseGeneratorTemplate;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.eureka.DockerEurekaGeneratorTemplate;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.eureka.EurekaGeneratorTemplate;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator.DockerJavaBaseGeneratorTemplate;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator.DockerTypeFocusedMappingModelJavaBaseGeneratorTemplate;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator.JavaBaseGeneratorTemplate;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator.TypeFocusedMappingModelJavaBaseGeneratorTemplate;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.mariadb.DockerMariaDBGeneratorTemplate;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.mariadb.MariaDBGeneratorTemplate;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.mongodb.DockerMongoDBGeneratorTemplate;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.mongodb.MongoDBGeneratorTemplate;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.zuul.DockerZuulGeneratorTemplate;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.zuul.ZuulGeneratorTemplate;
import de.fhdo.lemma.operation.OperationModel;
import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.ImportType;
import de.fhdo.lemma.service.ServiceModel;
import de.fhdo.lemma.technology.Technology;
import de.fhdo.lemma.technology.mapping.TechnologyMapping;
import de.fhdo.lemma.utils.LemmaUtils;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.ILaunchShortcut2;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * Launch shortcut for model processing launch configurations.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class LaunchShortcut implements ILaunchShortcut2 {
  /**
   * Dialog to select a completable configuration template from a set of templates
   */
  private static class TemplateSelectionDialog extends TitleAreaDialog {
    private final IProject project;
    
    private final IFile file;
    
    private final List<? extends AbstractLaunchConfigurationTemplate> allTemplates;
    
    private List<? extends AbstractLaunchConfigurationTemplate> applicableTemplates;
    
    private List<? extends AbstractLaunchConfigurationTemplate> currentTemplates;
    
    private org.eclipse.swt.widgets.List templateSelectionList;
    
    private Button continueButton;
    
    /**
     * Constructor
     */
    public TemplateSelectionDialog(final Shell parentShell, final IProject project, final IFile file, final List<Class<? extends AbstractLaunchConfigurationTemplate>> templateClasses) {
      super(parentShell);
      this.project = project;
      this.file = file;
      final Function1<Class<? extends AbstractLaunchConfigurationTemplate>, AbstractLaunchConfigurationTemplate> _function = (Class<? extends AbstractLaunchConfigurationTemplate> it) -> {
        return this.instantiate(it);
      };
      final Function1<AbstractLaunchConfigurationTemplate, String> _function_1 = (AbstractLaunchConfigurationTemplate it) -> {
        return it.getName();
      };
      this.allTemplates = IterableExtensions.<AbstractLaunchConfigurationTemplate, String>sortBy(ListExtensions.<Class<? extends AbstractLaunchConfigurationTemplate>, AbstractLaunchConfigurationTemplate>map(templateClasses, _function), _function_1);
      this.currentTemplates = this.allTemplates;
      this.setHelpAvailable(false);
    }
    
    /**
     * Instantiate an AbstractLaunchConfigurationTemplate instance from the given class
     */
    private AbstractLaunchConfigurationTemplate instantiate(final Class<? extends AbstractLaunchConfigurationTemplate> templateClass) {
      try {
        final Function1<Constructor<?>, Boolean> _function = (Constructor<?> it) -> {
          return Boolean.valueOf(((((it.getParameterCount() == 3) && 
            Objects.equal(it.getParameterTypes()[0], Shell.class)) && 
            Objects.equal(it.getParameterTypes()[1], IProject.class)) && 
            Objects.equal(it.getParameterTypes()[2], IFile.class)));
        };
        final Constructor<?> constructor = IterableExtensions.<Constructor<?>>findFirst(((Iterable<Constructor<?>>)Conversions.doWrapArray(templateClass.getConstructors())), _function);
        if ((constructor != null)) {
          Object _newInstance = constructor.newInstance(this.getShell(), this.project, this.file);
          return ((AbstractLaunchConfigurationTemplate) _newInstance);
        } else {
          StringConcatenation _builder = new StringConcatenation();
          String _simpleName = templateClass.getSimpleName();
          _builder.append(_simpleName);
          _builder.append(" not instantiable. Required constructor with ");
          String _plus = ("Launch configuration template of type " + _builder);
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("parameters of types ");
          String _simpleName_1 = Shell.class.getSimpleName();
          _builder_1.append(_simpleName_1);
          _builder_1.append(", ");
          String _simpleName_2 = IProject.class.getSimpleName();
          _builder_1.append(_simpleName_2);
          _builder_1.append(" and ");
          String _plus_1 = (_plus + _builder_1);
          StringConcatenation _builder_2 = new StringConcatenation();
          String _simpleName_3 = IFile.class.getSimpleName();
          _builder_2.append(_simpleName_3);
          _builder_2.append(" not found.");
          String _plus_2 = (_plus_1 + _builder_2);
          throw new IllegalArgumentException(_plus_2);
        }
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
    
    /**
     * Create the dialog
     */
    @Override
    public void create() {
      super.create();
      this.setTitle("Select quick launch configuration");
      this.setMessage("Please select a quick launch configuration from the list below");
    }
    
    /**
     * Create the dialog area
     */
    @Override
    public Control createDialogArea(final Composite parent) {
      Control _createDialogArea = super.createDialogArea(parent);
      final Composite area = ((Composite) _createDialogArea);
      final Composite container = new Composite(area, SWT.NONE);
      GridData _gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
      container.setLayoutData(_gridData);
      GridLayout _gridLayout = new GridLayout(1, false);
      container.setLayout(_gridLayout);
      this.addTemplateSelection(container);
      this.addFilterNonApplicableTemplates(container);
      return area;
    }
    
    /**
     * Add template selection list to the dialog
     */
    private void addTemplateSelection(final Composite parent) {
      org.eclipse.swt.widgets.List _list = new org.eclipse.swt.widgets.List(parent, 
        ((SWT.BORDER | SWT.H_SCROLL) | SWT.V_SCROLL));
      this.templateSelectionList = _list;
      GridData _gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
      this.templateSelectionList.setLayoutData(_gridData);
      this.updateTemplateSelectionList();
    }
    
    /**
     * Update the template selection list from the domain object representing the list of
     * current templates
     */
    private void updateTemplateSelectionList() {
      this.templateSelectionList.removeAll();
      final Consumer<AbstractLaunchConfigurationTemplate> _function = (AbstractLaunchConfigurationTemplate it) -> {
        this.templateSelectionList.add(it.getName());
      };
      this.currentTemplates.forEach(_function);
    }
    
    /**
     * Add checkbox to filter non-applicable templates to the dialog
     */
    private void addFilterNonApplicableTemplates(final Composite parent) {
      final Button checkbox = new Button(parent, SWT.CHECK);
      checkbox.setText("Show only applicable templates");
      checkbox.addSelectionListener(new SelectionAdapter() {
        @Override
        public void widgetSelected(final SelectionEvent event) {
          Object _source = event.getSource();
          final Button button = ((Button) _source);
          boolean _selection = button.getSelection();
          if (_selection) {
            if ((TemplateSelectionDialog.this.applicableTemplates == null)) {
              TemplateSelectionDialog.this.applicableTemplates = TemplateSelectionDialog.this.getApplicableTemplates();
            }
            TemplateSelectionDialog.this.currentTemplates = TemplateSelectionDialog.this.applicableTemplates;
          } else {
            TemplateSelectionDialog.this.currentTemplates = TemplateSelectionDialog.this.allTemplates;
          }
          TemplateSelectionDialog.this.updateTemplateSelectionList();
          TemplateSelectionDialog.this.updateContinueButton();
        }
      });
    }
    
    /**
     * Helper to get the list of templates that are applicable to the source model file
     */
    private List<? extends AbstractLaunchConfigurationTemplate> getApplicableTemplates() {
      final XtextResource modelResource = LemmaUiUtils.loadXtextResource(this.file);
      boolean _isEmpty = modelResource.getContents().isEmpty();
      if (_isEmpty) {
        return CollectionLiterals.<AbstractLaunchConfigurationTemplate>emptyList();
      }
      final EObject modelRoot = modelResource.getContents().get(0);
      final String absoluteModelFilePath = this.file.getRawLocation().makeAbsolute().toString();
      final Function1<AbstractLaunchConfigurationTemplate, Boolean> _function = (AbstractLaunchConfigurationTemplate it) -> {
        return it.isApplicable(modelRoot, 
          this.getTechnologyNamePerAlias(this.getAbsoluteTechnologyModelImportPathPerAlias(modelRoot, absoluteModelFilePath)));
      };
      return IterableExtensions.toList(IterableExtensions.filter(this.allTemplates, _function));
    }
    
    /**
     * Helper to retrieve the aliases and absolute paths of LEMMA technology models imported by
     * the given LEMMA source model root
     */
    private Map<String, String> getAbsoluteTechnologyModelImportPathPerAlias(final EObject modelRoot, final String absoluteModelPath) {
      EList<Import> _xtrycatchfinallyexpression = null;
      try {
        _xtrycatchfinallyexpression = this.getImports(modelRoot);
      } catch (final Throwable _t) {
        if (_t instanceof IllegalArgumentException) {
          return CollectionLiterals.<String, String>emptyMap();
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      final EList<Import> imports = _xtrycatchfinallyexpression;
      final Function1<Import, Boolean> _function = (Import it) -> {
        ImportType _importType = it.getImportType();
        return Boolean.valueOf(Objects.equal(_importType, ImportType.TECHNOLOGY));
      };
      final Function1<Import, String> _function_1 = (Import it) -> {
        return it.getName();
      };
      final Function1<Import, String> _function_2 = (Import it) -> {
        return LemmaUtils.convertToAbsolutePath(it.getImportURI(), absoluteModelPath);
      };
      return IterableExtensions.<Import, String, String>toMap(IterableExtensions.<Import>filter(imports, _function), _function_1, _function_2);
    }
    
    /**
     * Retrieve all imports of the given ServiceModel
     */
    private EList<Import> _getImports(final ServiceModel modelRoot) {
      return modelRoot.getImports();
    }
    
    /**
     * Retrieve all imports of the given TechnologyMapping
     */
    private EList<Import> _getImports(final TechnologyMapping modelRoot) {
      return modelRoot.getImports();
    }
    
    /**
     * Retrieve all imports of the given OperationModel
     */
    private EList<Import> _getImports(final OperationModel modelRoot) {
      return modelRoot.getImports();
    }
    
    /**
     * Retrieve all imports of a generic EObject
     */
    private EList<Import> _getImports(final EObject modelRoot) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Model type ");
      String _simpleName = modelRoot.getClass().getSimpleName();
      _builder.append(_simpleName);
      _builder.append(" does ");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("not support model imports");
      String _plus = (_builder.toString() + _builder_1);
      throw new IllegalArgumentException(_plus);
    }
    
    /**
     * Parse LEMMA technology models to retrieve the names of the modeled technologies per alias
     * in the model which imports the technology models. The given map is expected to state per
     * import alias the absolute path of the corresponding technology model.
     */
    private HashMap<String, String> getTechnologyNamePerAlias(final Map<String, String> technologyModelImportPathPerAlias) {
      final HashMap<String, String> resultMap = CollectionLiterals.<String, String>newHashMap();
      Set<Map.Entry<String, String>> _entrySet = technologyModelImportPathPerAlias.entrySet();
      for (final Map.Entry<String, String> entry : _entrySet) {
        {
          final String importPath = entry.getValue();
          final EList<EObject> modelContents = LemmaUiUtils.loadXtextResource(importPath).getContents();
          EObject _xifexpression = null;
          boolean _isEmpty = modelContents.isEmpty();
          boolean _not = (!_isEmpty);
          if (_not) {
            _xifexpression = modelContents.get(0);
          } else {
            _xifexpression = null;
          }
          final EObject modelRoot = _xifexpression;
          String _xifexpression_1 = null;
          if ((modelRoot instanceof Technology)) {
            _xifexpression_1 = ((Technology)modelRoot).getName();
          } else {
            _xifexpression_1 = null;
          }
          final String technologyName = _xifexpression_1;
          final String alias = entry.getKey();
          resultMap.put(alias, technologyName);
        }
      }
      return resultMap;
    }
    
    /**
     * Update continue button from the dialog's state
     */
    private void updateContinueButton() {
      boolean _isEmpty = this.currentTemplates.isEmpty();
      boolean _not = (!_isEmpty);
      this.continueButton.setEnabled(_not);
    }
    
    /**
     * Create the dialog buttons
     */
    @Override
    public void createButtonsForButtonBar(final Composite parent) {
      this.continueButton = this.createButton(parent, IDialogConstants.OK_ID, "Continue", true);
      this.updateContinueButton();
      this.createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
    }
    
    /**
     * Continue button was pressed
     */
    @Override
    public void okPressed() {
      int _selectionIndex = this.templateSelectionList.getSelectionIndex();
      boolean _equals = (_selectionIndex == (-1));
      if (_equals) {
        MessageDialog.openError(Utils.getActiveShell(), "No configuration selected", ("Please " + 
          "select a quick launch configuration from the list"));
        return;
      }
      final AbstractLaunchConfigurationTemplate launchTemplate = this.currentTemplates.get(this.templateSelectionList.getSelectionIndex());
      ProcessingConfigurationWithLaunchConfigurationName initializedProcessingTemplate = this.initializeProcessingConfigurationTemplate();
      initializedProcessingTemplate = launchTemplate.extendInitializedProcessingConfigurationTemplate(initializedProcessingTemplate);
      final AbstractLaunchConfigurationTemplate.AbstractTemplateCompletionDialog completionDialog = launchTemplate.getCompletionDialog();
      completionDialog.setInitializedProcessingConfigurationTemplate(initializedProcessingTemplate);
      final Procedure1<ProcessingConfigurationWithLaunchConfigurationName> _function = (ProcessingConfigurationWithLaunchConfigurationName it) -> {
        this.store(it);
      };
      completionDialog.setStoreCallback(_function);
      final Procedure1<ProcessingConfigurationWithLaunchConfigurationName> _function_1 = (ProcessingConfigurationWithLaunchConfigurationName it) -> {
        this.storeAndRun(it);
      };
      completionDialog.setRunCallback(_function_1);
      super.okPressed();
      completionDialog.open();
    }
    
    /**
     * Initialize a model processing configuration to act as the domain object of a completable
     * model processing template
     */
    private ProcessingConfigurationWithLaunchConfigurationName initializeProcessingConfigurationTemplate() {
      final ProcessingConfigurationWithLaunchConfigurationName configuration = new ProcessingConfigurationWithLaunchConfigurationName();
      configuration.setSourceModelProjectName(this.project.getName());
      configuration.setSourceModelFilePath(this.file.getProjectRelativePath().toString());
      return configuration;
    }
    
    /**
     * Store the given model processing configuration if it is valid
     */
    private ILaunchConfiguration store(final ProcessingConfigurationWithLaunchConfigurationName completedProcessingConfiguration) {
      try {
        try {
          completedProcessingConfiguration.validateInUserRepresentation();
        } catch (final Throwable _t) {
          if (_t instanceof IllegalArgumentException) {
            final IllegalArgumentException ex = (IllegalArgumentException)_t;
            Shell _activeShell = Utils.getActiveShell();
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("Processing configuration is erroneous: ");
            String _message = ex.getMessage();
            _builder.append(_message);
            _builder.append(". Storage and ");
            String _plus = (_builder.toString() + 
              "execution not possible.");
            MessageDialog.openError(_activeShell, "Erroneous processing configuration", _plus);
            throw ex;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        final ILaunchConfigurationWorkingCopy launchConfiguration = LaunchConfigurationConstants.PROCESSING_CONFIGURATION_LAUNCH_CONFIGURATION_TYPE.newInstance(null, completedProcessingConfiguration.getLaunchConfigurationName());
        ProcessingConfiguration.setProcessingConfigurationAsAttribute(launchConfiguration, completedProcessingConfiguration);
        return launchConfiguration.doSave(ILaunchConfiguration.UPDATE_PROTOTYPE_CHILDREN);
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
    
    /**
     * Store the given model processing configuration if it is valid and run it afterwards
     */
    private void storeAndRun(final ProcessingConfigurationWithLaunchConfigurationName completedProcessingConfiguration) {
      DebugUITools.launch(this.store(completedProcessingConfiguration), ILaunchManager.RUN_MODE);
    }
    
    /**
     * Flag to indicate that the dialog is resizable
     */
    @Override
    public boolean isResizable() {
      return true;
    }
    
    private EList<Import> getImports(final EObject modelRoot) {
      if (modelRoot instanceof OperationModel) {
        return _getImports((OperationModel)modelRoot);
      } else if (modelRoot instanceof ServiceModel) {
        return _getImports((ServiceModel)modelRoot);
      } else if (modelRoot instanceof TechnologyMapping) {
        return _getImports((TechnologyMapping)modelRoot);
      } else if (modelRoot != null) {
        return _getImports(modelRoot);
      } else {
        throw new IllegalArgumentException("Unhandled parameter types: " +
          Arrays.<Object>asList(modelRoot).toString());
      }
    }
  }
  
  private static final ILaunchManager LAUNCH_MANAGER = DebugPlugin.getDefault().getLaunchManager();
  
  private static final Map<String, ArrayList<Class<? extends AbstractLaunchConfigurationTemplate>>> SUPPORTED_LAUNCH_CONFIGURATION_TEMPLATES = Collections.<String, ArrayList<Class<? extends AbstractLaunchConfigurationTemplate>>>unmodifiableMap(CollectionLiterals.<String, ArrayList<Class<? extends AbstractLaunchConfigurationTemplate>>>newHashMap(Pair.<String, ArrayList<Class<? extends AbstractLaunchConfigurationTemplate>>>of("mapping", CollectionLiterals.<Class<? extends AbstractLaunchConfigurationTemplate>>newArrayList(
    DockerJavaBaseGeneratorTemplate.class, 
    DockerTypeFocusedMappingModelJavaBaseGeneratorTemplate.class, 
    JavaBaseGeneratorTemplate.class, 
    TypeFocusedMappingModelJavaBaseGeneratorTemplate.class)), Pair.<String, ArrayList<Class<? extends AbstractLaunchConfigurationTemplate>>>of("operation", CollectionLiterals.<Class<? extends AbstractLaunchConfigurationTemplate>>newArrayList(
    ContainerBaseGeneratorTemplate.class, 
    EurekaGeneratorTemplate.class, 
    MariaDBGeneratorTemplate.class, 
    MongoDBGeneratorTemplate.class, 
    ZuulGeneratorTemplate.class, 
    DockerContainerBaseGeneratorTemplate.class, 
    DockerEurekaGeneratorTemplate.class, 
    DockerMariaDBGeneratorTemplate.class, 
    DockerMongoDBGeneratorTemplate.class, 
    DockerZuulGeneratorTemplate.class)), Pair.<String, ArrayList<Class<? extends AbstractLaunchConfigurationTemplate>>>of("services", CollectionLiterals.<Class<? extends AbstractLaunchConfigurationTemplate>>newArrayList(
    JavaBaseGeneratorTemplate.class, 
    DockerJavaBaseGeneratorTemplate.class))));
  
  /**
   * Get the launch configurations associated with a selected file
   */
  @Override
  public final ILaunchConfiguration[] getLaunchConfigurations(final ISelection selection) {
    final IFile file = Utils.getSelectedFile(selection);
    Iterable<ILaunchConfiguration> _xifexpression = null;
    if ((file != null)) {
      _xifexpression = this.getLaunchConfigurations(file);
    } else {
      _xifexpression = null;
    }
    return ((ILaunchConfiguration[])Conversions.unwrapArray(_xifexpression, ILaunchConfiguration.class));
  }
  
  /**
   * Get the launch configurations applicable to the given IFile as a mapped resource
   */
  private Iterable<ILaunchConfiguration> getLaunchConfigurations(final IFile file) {
    return Utils.getLaunchConfigurationsForMappedResource(
      LaunchShortcut.LAUNCH_MANAGER, 
      LaunchConfigurationConstants.PROCESSING_CONFIGURATION_LAUNCH_CONFIGURATION_TYPE, file);
  }
  
  /**
   * Get launchable resource associated with a selected file
   */
  @Override
  public final IResource getLaunchableResource(final ISelection selection) {
    return null;
  }
  
  /**
   * Execute the shortcut for the selected file in the given mode
   */
  @Override
  public final void launch(final ISelection selection, final String mode) {
    this.launch(Utils.getSelectedFile(selection), mode);
  }
  
  /**
   * Execute the shortcut on the given file in the given mode
   */
  private void launch(final IFile file, final String mode) {
    if ((file == null)) {
      return;
    }
    final IProject project = this.getProjectOrError(file);
    if ((project == null)) {
      return;
    }
    final List<Class<? extends AbstractLaunchConfigurationTemplate>> templates = this.getLaunchConfigurationTemplates(file);
    boolean _isEmpty = templates.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      Shell _activeShell = Utils.getActiveShell();
      new LaunchShortcut.TemplateSelectionDialog(_activeShell, project, file, templates).open();
    } else {
      Shell _activeShell_1 = Utils.getActiveShell();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("launch for model files with extension \"");
      String _fileExtension = file.getRawLocation().getFileExtension();
      _builder.append(_fileExtension);
      _builder.append("\" is ");
      String _plus = ("Quick " + _builder);
      String _plus_1 = (_plus + 
        "currently not supported");
      MessageDialog.openInformation(_activeShell_1, "Quick launch not supported", _plus_1);
    }
  }
  
  /**
   * Helper to the Eclipse project for the given IFile or display an error in case the project is
   * not determinable
   */
  private IProject getProjectOrError(final IFile file) {
    final IProject project = file.getProject();
    IProject _xifexpression = null;
    if ((project != null)) {
      _xifexpression = project;
    } else {
      Object _xblockexpression = null;
      {
        Shell _activeShell = Utils.getActiveShell();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("determine project for model file \"");
        IPath _makeAbsolute = file.getRawLocation().makeAbsolute();
        _builder.append(_makeAbsolute);
        _builder.append("\". ");
        String _plus = ("Could not " + _builder);
        String _plus_1 = (_plus + 
          "Model files must be part of a project in the current workspace to process ");
        String _plus_2 = (_plus_1 + 
          "them.");
        MessageDialog.openError(_activeShell, "Project not determinable", _plus_2);
        _xblockexpression = null;
      }
      _xifexpression = ((IProject)_xblockexpression);
    }
    return _xifexpression;
  }
  
  /**
   * Helper to retrieve completable launch configuration templates from the extension of the given
   * IFile
   */
  private List<Class<? extends AbstractLaunchConfigurationTemplate>> getLaunchConfigurationTemplates(final IFile file) {
    List<Class<? extends AbstractLaunchConfigurationTemplate>> _elvis = null;
    ArrayList<Class<? extends AbstractLaunchConfigurationTemplate>> _get = LaunchShortcut.SUPPORTED_LAUNCH_CONFIGURATION_TEMPLATES.get(file.getRawLocation().getFileExtension());
    if (_get != null) {
      _elvis = _get;
    } else {
      _elvis = Collections.<Class<? extends AbstractLaunchConfigurationTemplate>>unmodifiableList(CollectionLiterals.<Class<? extends AbstractLaunchConfigurationTemplate>>newArrayList());
    }
    return _elvis;
  }
  
  /**
   * Get the launch configurations associated with the currently edited file
   */
  @Override
  public final ILaunchConfiguration[] getLaunchConfigurations(final IEditorPart editor) {
    final IFile file = Utils.getEditedFile(editor);
    Iterable<ILaunchConfiguration> _xifexpression = null;
    if ((file != null)) {
      _xifexpression = this.getLaunchConfigurations(file);
    } else {
      _xifexpression = null;
    }
    return ((ILaunchConfiguration[])Conversions.unwrapArray(_xifexpression, ILaunchConfiguration.class));
  }
  
  /**
   * Get launchable resource associated with the currently edited file
   */
  @Override
  public final IResource getLaunchableResource(final IEditorPart editorpart) {
    return null;
  }
  
  /**
   * Execute the shortcut for the currently edited file in the given mode
   */
  @Override
  public final void launch(final IEditorPart editor, final String mode) {
    this.launch(Utils.getEditedFile(editor), mode);
  }
}
