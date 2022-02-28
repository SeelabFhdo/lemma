package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut

import org.eclipse.swt.widgets.Shell
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IFile
import static de.fhdo.lemma.model_processing.eclipse.launcher.LaunchConfigurationConstants.SUPPORTED_DEFAULT_BASIC_PROCESSOR_EXECUTION_COMMANDS
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableType

/**
 * Abstract superclass for launch configuration templates targeting code generation.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
abstract class AbstractCodeGeneratorTemplate extends AbstractLaunchConfigurationTemplate {
    protected val Shell parentShell
    protected val IProject project
    protected val IFile file
    val ProcessorExecutableType generatorExecutableType
    var Argument targetFolderArgument

    /**
     * Get the dialog for completing the launch configuration template. Note that implementers of
     * concrete code generation templates must override the specialized method
     * getCodeGeneratorCompletionDialog(), whereas this method completes the returned dialog with
     * information required by the superclass.
     */
    final override getCompletionDialog() {
        val dialog = getCodeGeneratorCompletionDialog()
        dialog.generatorExecutableType = generatorExecutableType
        dialog.targetFolderArgument = targetFolderArgument
        return dialog
    }

    /**
     * Get the dialog for completing a concrete code generation template
     */
    abstract def AbstractCodeGeneratorCompletionDialog getCodeGeneratorCompletionDialog()

    /**
     * Constructor
     */
    new(ProcessorExecutableType generatorExecutableType, Shell parentShell, String name,
        IProject project, IFile file) {
        super(parentShell, name, project, file)
        this.generatorExecutableType = generatorExecutableType
        this.parentShell = parentShell
        this.project = project
        this.file = file
    }

    /**
     * Extend the model processing configuration template initialized by the superclass
     */
    override extendInitializedProcessingConfigurationTemplate(
        ProcessingConfigurationWithLaunchConfigurationName configuration
    ) {
        configuration.processorExecutableType = generatorExecutableType
        configuration.basicProcessorExecutionCommand
            = SUPPORTED_DEFAULT_BASIC_PROCESSOR_EXECUTION_COMMANDS.get(generatorExecutableType)

        val arguments = configuration.arguments
        arguments.add(Argument.newArgument.singleValued.sourceModel.parameter("-s"))
        arguments.add(Argument.newArgument.singleValued.intermediateModel.parameter("-i"))
        targetFolderArgument = Argument.newArgument.singleValued.folder.parameter("-t").value("")
        arguments.add(targetFolderArgument)

        return configuration
    }
}