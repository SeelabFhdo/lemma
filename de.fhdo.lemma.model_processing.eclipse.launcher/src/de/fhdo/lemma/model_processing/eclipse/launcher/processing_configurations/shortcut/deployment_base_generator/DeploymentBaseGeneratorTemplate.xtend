package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.deployment_base_generator

import org.eclipse.swt.widgets.Shell
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IFile
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.AbstractCodeGeneratorCompletionDialog
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableType

/**
 * Launch configuration template targeting code generation with the Deployment Base Generator as a
 * local Java program.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class DeploymentBaseGeneratorTemplate extends AbstractDeploymentBaseGeneratorTemplate {
    /**
     * Constructor
     */
    new(Shell parentShell, IProject project, IFile file) {
        super(ProcessorExecutableType.LOCAL_JAVA_PROGRAM, parentShell, "Deployment artifact " +
            "generation", project, file)
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
            super(parentShell, project, file, DeploymentBaseGeneratorConstants.GENERATOR_LONG_NAME,
                DeploymentBaseGeneratorConstants.GENERATOR_SHORT_NAME)
        }

        /**
         * Addendum for generator long name as part of the label for the generator executable path's
         * text field
         */
        final override getGeneratorExecutableLabelTextAddendum() {
            return "path"
        }

        /**
         * Create the dialog
         */
        final override create() {
            super.create()
            title = "Generate Deployment Artifacts From LEMMA Models"
            message = '''Use this dialog to configure and run LEMMA's «generatorLongName» on ''' +
                "the selected operation model"
        }
    }
}