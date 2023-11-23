package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator;

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.AbstractLaunchConfigurationTemplate;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.ProcessingConfigurationWithLaunchConfigurationName;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Abstract superclass for launch configuration templates targeting code generation with the Java
 * Base Generator.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class JavaBaseGeneratorTemplate extends AbstractJavaBaseGeneratorTemplate {
  /**
   * Dialog for template completion
   */
  public static class TemplateCompletionDialog extends AbstractJavaBaseGeneratorCompletionDialog {
    private GenletsTable genletsTable;

    /**
     * Constructor
     */
    public TemplateCompletionDialog(final Shell parentShell, final IProject project, final IFile file) {
      super(parentShell, project, file);
    }

    /**
     * Addendum for generator long name as part of the label for the generator executable path's
     * text field
     */
    @Override
    public final String getGeneratorExecutableLabelTextAddendum() {
      return "path";
    }

    /**
     * Create the dialog
     */
    @Override
    public final void create() {
      super.create();
      this.setTitle("Generate Java Microservices From LEMMA Models");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Use this dialog to configure and run LEMMA\'s ");
      _builder.append(this.generatorLongName);
      _builder.append(" on ");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("the selected ");
      String _printableModelFileType = this.printableModelFileType();
      _builder_1.append(_printableModelFileType);
      _builder_1.append(" model");
      String _plus = (_builder.toString() + _builder_1);
      this.setMessage(_plus);
    }

    /**
     * Create the dialog area
     */
    @Override
    public Control createDialogArea(final Composite parent) {
      final Control area = super.createDialogArea(parent);
      Shell _shell = parent.getShell();
      Point _point = new Point(AbstractLaunchConfigurationTemplate.AbstractTemplateCompletionDialog.DEFAULT_WIDTH, 600);
      _shell.setSize(_point);
      return area;
    }

    /**
     * Add additional controls to the dialog
     */
    @Override
    public final void insertAdditionalControlsAfterDefaults(final Composite parent) {
      super.insertAdditionalControlsAfterDefaults(parent);
      this.insertAdditionalControlsBeforeGenletsGroup(parent);
      final Group genletsTableGroup = new Group(parent, SWT.SHADOW_ETCHED_IN);
      genletsTableGroup.setText("Genlets");
      GridLayout _gridLayout = new GridLayout(1, false);
      genletsTableGroup.setLayout(_gridLayout);
      final GridData layoutData = new GridData(GridData.FILL, GridData.FILL, true, true);
      genletsTableGroup.setLayoutData(layoutData);
      layoutData.horizontalSpan = 3;
      GenletsTable _genletsTable = new GenletsTable(genletsTableGroup, this.configurationTemplate);
      this.genletsTable = _genletsTable;
      this.genletsTable.addPropertyChangeListener(this);
      this.insertAdditionalControlsAfterGenletsGroup(parent);
    }

    /**
     * Insert additional controls before the group with the Genlet table
     */
    public void insertAdditionalControlsBeforeGenletsGroup(final Composite parent) {
    }

    /**
     * Insert additional controls after the group with the Genlet table
     */
    public void insertAdditionalControlsAfterGenletsGroup(final Composite parent) {
    }

    /**
     * Complete the template with the Argument instances for the specified Genlets
     */
    @Override
    public void completeProcessingConfigurationTemplate(final ProcessingConfigurationWithLaunchConfigurationName templateToComplete) {
      templateToComplete.getArguments().addAll(this.genletsTable.getGenletArguments());
    }

    /**
     * Close the dialog
     */
    @Override
    public boolean close() {
      boolean _xblockexpression = false;
      {
        this.genletsTable.removePropertyChangeListener(this);
        this.genletsTable.dispose();
        _xblockexpression = super.close();
      }
      return _xblockexpression;
    }
  }

  /**
   * Constructor
   */
  public JavaBaseGeneratorTemplate(final Shell parentShell, final IProject project, final IFile file) {
    this(parentShell, "Java microservice generation", project, file);
  }

  /**
   * Constructor with explicit template name parameter
   */
  public JavaBaseGeneratorTemplate(final Shell parentShell, final String name, final IProject project, final IFile file) {
    super(ProcessorExecutableType.LOCAL_JAVA_PROGRAM, parentShell, name, project, file);
  }

  /**
   * Get template completion dialog
   */
  @Override
  public AbstractJavaBaseGeneratorCompletionDialog getJavaBaseGeneratorCompletionDialog() {
    return new JavaBaseGeneratorTemplate.TemplateCompletionDialog(this.parentShell, this.project, this.file);
  }
}
