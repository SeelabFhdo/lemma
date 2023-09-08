package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator;

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.AbstractLaunchConfigurationTemplate;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.ProcessingConfigurationWithLaunchConfigurationName;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;

/**
 * Launch configuration template targeting code generation with the Java Base Generator from a
 * service model and in a Docker container based on a local image.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class DockerJavaBaseGeneratorTemplate extends AbstractJavaBaseGeneratorTemplate {
  /**
   * Docker-specific dialog for template completion
   */
  public static class TemplateCompletionDialog extends AbstractJavaBaseGeneratorCompletionDialog {
    /**
     * Constructor
     */
    public TemplateCompletionDialog(final Shell parentShell, final IProject project, final IFile file) {
      super(parentShell, project, file);
    }

    /**
     * Addendum for the generator short name as part of the launch configuration name
     */
    @Override
    public String getGeneratorNameAddendum() {
      return "Docker";
    }

    /**
     * Addendum for generator long name as part of the label for the generator executable path's
     * text field
     */
    @Override
    public String getGeneratorExecutableLabelTextAddendum() {
      return "Docker image";
    }

    /**
     * Create the dialog
     */
    @Override
    public void create() {
      super.create();
      this.setTitle("Generate Java Microservices From LEMMA Models Using Docker");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Use this dialog to configure and run LEMMA\'s ");
      _builder.append(this.generatorLongName);
      _builder.append(" in a ");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Docker container on the selected ");
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
      Point _point = new Point(AbstractLaunchConfigurationTemplate.AbstractTemplateCompletionDialog.DEFAULT_WIDTH, 340);
      _shell.setSize(_point);
      return area;
    }
  }

  protected static final String TEMPLATE_NAME = "Docker-based Java microservice generation";

  /**
   * Constructor
   */
  public DockerJavaBaseGeneratorTemplate(final Shell parentShell, final IProject project, final IFile file) {
    this(parentShell, DockerJavaBaseGeneratorTemplate.TEMPLATE_NAME, project, file);
  }

  /**
   * Constructor with explicit template name parameter
   */
  public DockerJavaBaseGeneratorTemplate(final Shell parentShell, final String name, final IProject project, final IFile file) {
    super(ProcessorExecutableType.LOCAL_DOCKER_IMAGE, parentShell, name, project, file);
  }

  /**
   * Extend the model processing configuration template initialized by the superclass
   */
  @Override
  public final ProcessingConfigurationWithLaunchConfigurationName extendInitializedProcessingConfigurationTemplate(final ProcessingConfigurationWithLaunchConfigurationName configuration) {
    final ProcessingConfigurationWithLaunchConfigurationName initializedConfiguration = super.extendInitializedProcessingConfigurationTemplate(configuration);
    initializedConfiguration.setProcessorExecutablePath(
      JavaBaseGeneratorParameters.DEFAULT_DOCKER_IMAGE_NAME);
    final Consumer<JavaBaseGeneratorParameters.GenletType> _function = (JavaBaseGeneratorParameters.GenletType it) -> {
      initializedConfiguration.getArguments().add(this.buildGenletArgument(it));
    };
    ((List<JavaBaseGeneratorParameters.GenletType>)Conversions.doWrapArray(JavaBaseGeneratorParameters.GenletType.values())).forEach(_function);
    return configuration;
  }

  /**
   * Build an Argument instance that specifies the execution of a Genlet of the given type with
   * the Java Base Generator
   */
  private Argument buildGenletArgument(final JavaBaseGeneratorParameters.GenletType genletType) {
    return Argument.newArgument().singleValued().stringPair().parameter(JavaBaseGeneratorParameters.GENLET_PARAMETER).value(JavaBaseGeneratorParameters.instance().getDockerGenletFilePath(genletType));
  }

  /**
   * Return the dialog for template completion
   */
  @Override
  public AbstractJavaBaseGeneratorCompletionDialog getJavaBaseGeneratorCompletionDialog() {
    return new DockerJavaBaseGeneratorTemplate.TemplateCompletionDialog(this.parentShell, this.project, this.file);
  }
}
