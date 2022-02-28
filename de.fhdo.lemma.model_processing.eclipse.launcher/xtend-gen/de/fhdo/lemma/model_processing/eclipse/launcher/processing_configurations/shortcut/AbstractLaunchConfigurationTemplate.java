package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut;

import de.fhdo.lemma.model_processing.eclipse.launcher.Utils;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.CommandLineGenerator;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Abstract superclass for launch configuration templates. Conceptually, a launch configuration
 * template is a partially initialized model processing configuration that can be completed by the
 * user via a template-specific dialog. Templates are used by launch shortcuts for model processing
 * configurations to gather the minimum of required data for subsequent model processor execution.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public abstract class AbstractLaunchConfigurationTemplate {
  /**
   * Abstract superclass for template completion dialogs
   */
  public static abstract class AbstractTemplateCompletionDialog extends TitleAreaDialog implements PropertyChangeListener {
    private static final int DEFAULT_COLUMN_COUNT = 2;
    
    protected static final int DEFAULT_WIDTH = 800;
    
    protected static final Point DEFAULT_SIZE = new Point(AbstractLaunchConfigurationTemplate.AbstractTemplateCompletionDialog.DEFAULT_WIDTH, 300);
    
    protected final IProject project;
    
    protected final IFile file;
    
    protected final int columnCount;
    
    @Accessors(AccessorType.PROTECTED_GETTER)
    protected ProcessingConfigurationWithLaunchConfigurationName configurationTemplate;
    
    protected final DataBindingContext dataBindingContext = new DataBindingContext();
    
    protected final ArrayList<Binding> bindings = CollectionLiterals.<Binding>newArrayList();
    
    private final ArrayList<ControlDecoration> decorations = CollectionLiterals.<ControlDecoration>newArrayList();
    
    private Procedure1<? super ProcessingConfigurationWithLaunchConfigurationName> runCallback;
    
    private Procedure1<? super ProcessingConfigurationWithLaunchConfigurationName> storeCallback;
    
    private Button showCommandLineButton;
    
    private Button storeButton;
    
    private Button runButton;
    
    /**
     * Constructor
     */
    public AbstractTemplateCompletionDialog(final Shell parentShell, final IProject project, final IFile file) {
      this(parentShell, project, file, AbstractLaunchConfigurationTemplate.AbstractTemplateCompletionDialog.DEFAULT_COLUMN_COUNT);
    }
    
    /**
     * Constructor to configure a non-default number of columns for the dialog's grid layout
     */
    public AbstractTemplateCompletionDialog(final Shell parentShell, final IProject project, final IFile file, final int columnCount) {
      super(parentShell);
      if ((columnCount < 2)) {
        throw new IllegalArgumentException("Column count must be equal or greater 2");
      }
      this.project = project;
      this.file = file;
      this.columnCount = columnCount;
      this.setHelpAvailable(false);
    }
    
    /**
     * Set the partially initialized model processing configuration as the actual template
     * domain object to be sufficiently completed for subsequent model processor execution. This
     * method must not be called by implementers.
     */
    final void setInitializedProcessingConfigurationTemplate(final ProcessingConfigurationWithLaunchConfigurationName configurationTemplate) {
      this.configurationTemplate = configurationTemplate;
      this.configurationTemplate.addPropertyChangeListener(this);
    }
    
    /**
     * Set the callback to be invoked when the user hit the store button. This method must not
     * be called by implementers.
     */
    final Procedure1<? super ProcessingConfigurationWithLaunchConfigurationName> setStoreCallback(final Procedure1<? super ProcessingConfigurationWithLaunchConfigurationName> callback) {
      return this.storeCallback = callback;
    }
    
    /**
     * Set the callback to be invoked when the user hit the run button. This method must not be
     * called by implementers.
     */
    final Procedure1<? super ProcessingConfigurationWithLaunchConfigurationName> setRunCallback(final Procedure1<? super ProcessingConfigurationWithLaunchConfigurationName> callback) {
      return this.runCallback = callback;
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
      GridLayout _gridLayout = new GridLayout(this.columnCount, false);
      container.setLayout(_gridLayout);
      this.insertAdditionalControlsBeforeDefaults(container);
      this.addConfigurationName(container);
      this.insertAdditionalControlsAfterDefaults(container);
      Shell _shell = parent.getShell();
      _shell.setSize(AbstractLaunchConfigurationTemplate.AbstractTemplateCompletionDialog.DEFAULT_SIZE);
      return area;
    }
    
    /**
     * Enable implementers to place additional controls before default controls
     */
    public void insertAdditionalControlsBeforeDefaults(final Composite parent) {
    }
    
    /**
     * Add text field for launch configuration name
     */
    private void addConfigurationName(final Composite parent) {
      Label _label = new Label(parent, SWT.NULL);
      _label.setText("Launch configuration name:");
      final Text nameTextField = new Text(parent, SWT.BORDER);
      final GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, false);
      final int textFieldSpan = (this.columnCount - 1);
      if ((textFieldSpan > 0)) {
        layoutData.horizontalSpan = textFieldSpan;
      }
      nameTextField.setLayoutData(layoutData);
      final Procedure1<String> _function = (String it) -> {
        ProcessingConfigurationWithLaunchConfigurationName.validateLaunchConfigurationName(it);
      };
      this.<ProcessingConfigurationWithLaunchConfigurationName>bindWithValidationDecorationSupport(nameTextField, 
        ProcessingConfigurationWithLaunchConfigurationName.class, 
        "launchConfigurationName", 
        this.configurationTemplate, _function);
    }
    
    /**
     * Helper to bind a control and property including validation and decoration support in the
     * dialog's binding and decoration contexts
     */
    protected final <T extends Object> void bindWithValidationDecorationSupport(final Control control, final Class<T> beanClass, final String propertyName, final T source, final Procedure1<? super String> validationProcedure) {
      final Pair<Binding, ControlDecoration> bindingAndDecoration = Utils.<T>bindWithValidationDecorationSupport(control, 
        this.dataBindingContext, beanClass, propertyName, source, validationProcedure);
      this.bindings.add(bindingAndDecoration.getKey());
      this.decorations.add(bindingAndDecoration.getValue());
    }
    
    /**
     * Enable implementers to place additional controls after default controls
     */
    public void insertAdditionalControlsAfterDefaults(final Composite parent) {
    }
    
    /**
     * React to changes of template properties
     */
    @Override
    public final void propertyChange(final PropertyChangeEvent event) {
      Object _clone = this.configurationTemplate.clone();
      final ProcessingConfigurationWithLaunchConfigurationName completedConfiguration = ((ProcessingConfigurationWithLaunchConfigurationName) _clone);
      this.completeProcessingConfigurationTemplate(completedConfiguration);
      final boolean configurationIsValid = this.isValidInUserRepresentation(completedConfiguration);
      this.showCommandLineButton.setEnabled(configurationIsValid);
      this.storeButton.setEnabled(configurationIsValid);
      this.runButton.setEnabled(configurationIsValid);
      this.reactToPropertyChange(event);
    }
    
    /**
     * Enable implementers of concrete dialog's to complete the template, e.g., with additional
     * execution arguments. This callback gets invoked each time the user changes a template
     * property, and before the validity check, which may enable further controls for
     * interacting with valid configuration templates, and the generic reactToPropertyChange()
     * callback. Additionally, the callback gets invoked each time the user hits a button to
     * interact with the template, e.g., to store or run it.
     */
    public void completeProcessingConfigurationTemplate(final ProcessingConfigurationWithLaunchConfigurationName templateToComplete) {
    }
    
    /**
     * Helper to check of the given model processing configuration is valid in its user
     * representation
     */
    private boolean isValidInUserRepresentation(final ProcessingConfigurationWithLaunchConfigurationName configuration) {
      boolean _xtrycatchfinallyexpression = false;
      try {
        boolean _xblockexpression = false;
        {
          configuration.validateInUserRepresentation();
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
     * Generic callback to react to changes of template properties. This callback gets invoked
     * each time the user changes a template property, after
     * the completeProcessingConfigurationTemplate() callback and the validity check, which may
     * enable further controls for interacting with valid configuration templates.
     */
    public void reactToPropertyChange(final PropertyChangeEvent evt) {
    }
    
    /**
     * Create the dialog buttons
     */
    @Override
    public final void createButtonsForButtonBar(final Composite parent) {
      this.createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
      this.showCommandLineButton = this.createButton(parent, IDialogConstants.DETAILS_ID, ("Show " + 
        "Command Line"), false);
      this.storeButton = this.createButton(parent, IDialogConstants.FINISH_ID, "Store Without Running", 
        false);
      this.runButton = this.createButton(parent, IDialogConstants.OK_ID, "Run", true);
    }
    
    /**
     * React to the user hitting a button
     */
    @Override
    public final void buttonPressed(final int buttonId) {
      switch (buttonId) {
        case IDialogConstants.DETAILS_ID:
          this.showCommandLinePressed();
          break;
        case IDialogConstants.FINISH_ID:
          this.storePressed();
          break;
        default:
          super.buttonPressed(buttonId);
          break;
      }
    }
    
    /**
     * The user hit the show commandline button
     */
    private void showCommandLinePressed() {
      Object _clone = this.configurationTemplate.clone();
      final ProcessingConfigurationWithLaunchConfigurationName completedTemplate = ((ProcessingConfigurationWithLaunchConfigurationName) _clone);
      this.completeProcessingConfigurationTemplate(completedTemplate);
      final CommandLineGenerator commandLineGenerator = new CommandLineGenerator(completedTemplate);
      CommandLineGenerator.CoherentCommandLineParts commandLineParts = null;
      try {
        final Pair<CommandLineGenerator.CoherentCommandLineParts, List<String>> partsAndWarnings = commandLineGenerator.generateCoherentCommandLineParts();
        commandLineParts = partsAndWarnings.getKey();
        final Consumer<String> _function = (String it) -> {
          MessageDialog.openWarning(this.getShell(), "Warning during commandline generation", it);
        };
        partsAndWarnings.getValue().forEach(_function);
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception ex = (Exception)_t;
          MessageDialog.openError(this.getShell(), "Error during commandline generation", ex.getMessage());
          return;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      final String commandLine = commandLineGenerator.toPrintableCommandLine(commandLineParts, "\n\t");
      Shell _shell = this.getShell();
      final ShowCommandLineDialog commandLineDialog = new ShowCommandLineDialog(_shell, commandLine);
      commandLineDialog.open();
    }
    
    /**
     * The user hit the store button
     */
    private Object storePressed() {
      Object _xtrycatchfinallyexpression = null;
      try {
        this.completeProcessingConfigurationTemplate(this.configurationTemplate);
        this.storeCallback.apply(this.configurationTemplate);
        super.okPressed();
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          _xtrycatchfinallyexpression = null;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      return _xtrycatchfinallyexpression;
    }
    
    /**
     * The user hit the run button
     */
    @Override
    public final void okPressed() {
      try {
        this.completeProcessingConfigurationTemplate(this.configurationTemplate);
        this.runCallback.apply(this.configurationTemplate);
        super.okPressed();
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    
    /**
     * Close the dialog
     */
    @Override
    public boolean close() {
      boolean _xblockexpression = false;
      {
        final Consumer<Binding> _function = (Binding it) -> {
          it.dispose();
        };
        this.bindings.forEach(_function);
        this.bindings.clear();
        this.dataBindingContext.dispose();
        final Consumer<ControlDecoration> _function_1 = (ControlDecoration it) -> {
          it.dispose();
        };
        this.decorations.forEach(_function_1);
        this.decorations.clear();
        this.configurationTemplate.removePropertyChangeListener(this);
        _xblockexpression = super.close();
      }
      return _xblockexpression;
    }
    
    /**
     * Flag to indicate that the dialog is resizable
     */
    @Override
    public final boolean isResizable() {
      return true;
    }
    
    @Pure
    protected ProcessingConfigurationWithLaunchConfigurationName getConfigurationTemplate() {
      return this.configurationTemplate;
    }
  }
  
  protected final Shell parentShell;
  
  protected final IProject project;
  
  protected final IFile file;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final String name;
  
  /**
   * Enable implementers to decide whether the template is applicable to a LEMMA model. The map
   * of technology names to aliases can be used as an additional source of information whether the
   * template is applicable in the context of the specified source model file. For example, a
   * template for generating code for the Eureka technology likely requires the import of a
   * technology with name "Eureka" at least.
   */
  public abstract Boolean isApplicable(final EObject modelRoot, final Map<String, String> technologyNamePerAlias);
  
  /**
   * Get the template completion dialog
   */
  public abstract AbstractLaunchConfigurationTemplate.AbstractTemplateCompletionDialog getCompletionDialog();
  
  /**
   * Constructor
   */
  public AbstractLaunchConfigurationTemplate(final Shell parentShell, final String name, final IProject project, final IFile file) {
    this.parentShell = parentShell;
    this.name = name;
    this.project = project;
    this.file = file;
  }
  
  /**
   * Enable implementers the extension of the partially initialized processing configuration
   * template
   */
  public ProcessingConfigurationWithLaunchConfigurationName extendInitializedProcessingConfigurationTemplate(final ProcessingConfigurationWithLaunchConfigurationName initializedConfiguration) {
    return null;
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
}
