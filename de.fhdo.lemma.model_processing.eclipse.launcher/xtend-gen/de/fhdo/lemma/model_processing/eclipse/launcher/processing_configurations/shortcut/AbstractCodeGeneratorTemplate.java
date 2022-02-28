package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut;

import de.fhdo.lemma.model_processing.eclipse.launcher.LaunchConfigurationConstants;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument;
import java.util.ArrayList;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.swt.widgets.Shell;

/**
 * Abstract superclass for launch configuration templates targeting code generation.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public abstract class AbstractCodeGeneratorTemplate extends AbstractLaunchConfigurationTemplate {
  protected final Shell parentShell;
  
  protected final IProject project;
  
  protected final IFile file;
  
  private final ProcessorExecutableType generatorExecutableType;
  
  private Argument targetFolderArgument;
  
  /**
   * Get the dialog for completing the launch configuration template. Note that implementers of
   * concrete code generation templates must override the specialized method
   * getCodeGeneratorCompletionDialog(), whereas this method completes the returned dialog with
   * information required by the superclass.
   */
  @Override
  public final AbstractLaunchConfigurationTemplate.AbstractTemplateCompletionDialog getCompletionDialog() {
    final AbstractCodeGeneratorCompletionDialog dialog = this.getCodeGeneratorCompletionDialog();
    dialog.setGeneratorExecutableType(this.generatorExecutableType);
    dialog.setTargetFolderArgument(this.targetFolderArgument);
    return dialog;
  }
  
  /**
   * Get the dialog for completing a concrete code generation template
   */
  public abstract AbstractCodeGeneratorCompletionDialog getCodeGeneratorCompletionDialog();
  
  /**
   * Constructor
   */
  public AbstractCodeGeneratorTemplate(final ProcessorExecutableType generatorExecutableType, final Shell parentShell, final String name, final IProject project, final IFile file) {
    super(parentShell, name, project, file);
    this.generatorExecutableType = generatorExecutableType;
    this.parentShell = parentShell;
    this.project = project;
    this.file = file;
  }
  
  /**
   * Extend the model processing configuration template initialized by the superclass
   */
  @Override
  public ProcessingConfigurationWithLaunchConfigurationName extendInitializedProcessingConfigurationTemplate(final ProcessingConfigurationWithLaunchConfigurationName configuration) {
    configuration.setProcessorExecutableType(this.generatorExecutableType);
    configuration.setBasicProcessorExecutionCommand(LaunchConfigurationConstants.SUPPORTED_DEFAULT_BASIC_PROCESSOR_EXECUTION_COMMANDS.get(this.generatorExecutableType));
    final ArrayList<Argument> arguments = configuration.getArguments();
    arguments.add(Argument.newArgument().singleValued().sourceModel().parameter("-s"));
    arguments.add(Argument.newArgument().singleValued().intermediateModel().parameter("-i"));
    this.targetFolderArgument = Argument.newArgument().singleValued().folder().parameter("-t").value("");
    arguments.add(this.targetFolderArgument);
    return configuration;
  }
}
