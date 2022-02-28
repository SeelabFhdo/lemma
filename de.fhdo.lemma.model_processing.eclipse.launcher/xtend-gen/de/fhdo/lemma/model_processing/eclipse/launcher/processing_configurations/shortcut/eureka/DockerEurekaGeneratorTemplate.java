package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.eureka;

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.AbstractCodeGeneratorCompletionDialog;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.ProcessingConfigurationWithLaunchConfigurationName;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtend2.lib.StringConcatenation;

/**
 * Launch configuration template targeting code generation with the Eureka Generator in a Docker
 * container based on a local image.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class DockerEurekaGeneratorTemplate extends AbstractEurekaGeneratorTemplate {
  /**
   * Dialog for template completion
   */
  public static final class TemplateCompletionDialog extends AbstractCodeGeneratorCompletionDialog {
    /**
     * Constructor
     */
    public TemplateCompletionDialog(final Shell parentShell, final IProject project, final IFile file) {
      super(parentShell, project, file, EurekaGeneratorConstants.GENERATOR_LONG_NAME, 
        EurekaGeneratorConstants.GENERATOR_SHORT_NAME);
    }
    
    /**
     * Addendum for the generator short name as part of the launch configuration name
     */
    @Override
    public final String getGeneratorNameAddendum() {
      return "Docker";
    }
    
    /**
     * Addendum for generator long name as part of the label for the generator executable path's
     * text field
     */
    @Override
    public final String getGeneratorExecutableLabelTextAddendum() {
      return "Docker image";
    }
    
    /**
     * Create the dialog
     */
    @Override
    public final void create() {
      super.create();
      this.setTitle("Generate Eureka Artifacts From LEMMA Models Using Docker");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Use this dialog to configure and run LEMMA\'s ");
      _builder.append(this.generatorLongName);
      _builder.append(" in a ");
      String _plus = (_builder.toString() + 
        "Docker container on the selected operation model");
      this.setMessage(_plus);
    }
  }
  
  /**
   * Constructor
   */
  public DockerEurekaGeneratorTemplate(final Shell parentShell, final IProject project, final IFile file) {
    super(ProcessorExecutableType.LOCAL_DOCKER_IMAGE, parentShell, ("Docker-based Eureka " + 
      "artifact generation"), project, file);
  }
  
  /**
   * Extend the model processing configuration template initialized by the superclass
   */
  @Override
  public final ProcessingConfigurationWithLaunchConfigurationName extendInitializedProcessingConfigurationTemplate(final ProcessingConfigurationWithLaunchConfigurationName configuration) {
    final ProcessingConfigurationWithLaunchConfigurationName initializedConfiguration = super.extendInitializedProcessingConfigurationTemplate(configuration);
    initializedConfiguration.setProcessorExecutablePath(EurekaGeneratorConstants.DEFAULT_DOCKER_IMAGE_NAME);
    return configuration;
  }
  
  /**
   * Return the dialog for template completion
   */
  @Override
  public final AbstractCodeGeneratorCompletionDialog getCodeGeneratorCompletionDialog() {
    return new DockerEurekaGeneratorTemplate.TemplateCompletionDialog(this.parentShell, this.project, this.file);
  }
}
