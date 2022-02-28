package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.mongodb

import org.eclipse.swt.widgets.Shell
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IFile
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.AbstractCodeGeneratorCompletionDialog
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.ProcessingConfigurationWithLaunchConfigurationName

/**
 * Launch configuration template targeting code generation with the MongoDB Generator in a Docker
 * container based on a local image.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class DockerMongoDBGeneratorTemplate extends AbstractMongoDBGeneratorTemplate {
    /**
     * Constructor
     */
    new(Shell parentShell, IProject project, IFile file) {
        super(ProcessorExecutableType.LOCAL_DOCKER_IMAGE, parentShell, "Docker-based MongoDB " +
            "artifact generation", project, file)
    }

    /**
     * Extend the model processing configuration template initialized by the superclass
     */
    final override extendInitializedProcessingConfigurationTemplate(
        ProcessingConfigurationWithLaunchConfigurationName configuration
    ) {
        val initializedConfiguration = super
            .extendInitializedProcessingConfigurationTemplate(configuration)

        initializedConfiguration.processorExecutablePath
            = MongoDBGeneratorConstants.DEFAULT_DOCKER_IMAGE_NAME

        return configuration
    }

    /**
     * Return the dialog for template completion
     */
    final override getCodeGeneratorCompletionDialog() {
        return new TemplateCompletionDialog(parentShell, project, file)
    }

    /**
     * Dialog for template completion
     */
    final static class TemplateCompletionDialog extends AbstractCodeGeneratorCompletionDialog {
        /**
         * Constructor
         */
        new(Shell parentShell, IProject project, IFile file) {
            super(parentShell, project, file, MongoDBGeneratorConstants.GENERATOR_LONG_NAME,
                MongoDBGeneratorConstants.GENERATOR_SHORT_NAME)
        }

        /**
         * Addendum for the generator short name as part of the launch configuration name
         */
        final override getGeneratorNameAddendum() {
            return "Docker"
        }

        /**
         * Addendum for generator long name as part of the label for the generator executable path's
         * text field
         */
        final override getGeneratorExecutableLabelTextAddendum() {
            return "Docker image"
        }

        /**
         * Create the dialog
         */
        final override create() {
            super.create()
            title = "Generate MongoDB Artifacts From LEMMA Models Using Docker"
            message = '''Use this dialog to configure and run LEMMA's «generatorLongName» in a ''' +
                "Docker container on the selected operation model"
        }
    }
}