package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.eureka

import org.eclipse.swt.widgets.Shell
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IFile
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.AbstractCodeGeneratorCompletionDialog

/**
 * Launch configuration template targeting code generation with the Eureka Generator as a local Java
 * program.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class EurekaGeneratorTemplate extends AbstractEurekaGeneratorTemplate {
    /**
     * Constructor
     */
    new(Shell parentShell, IProject project, IFile file) {
        super(ProcessorExecutableType.LOCAL_JAVA_PROGRAM, parentShell, "Eureka artifact " +
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
            super(parentShell, project, file, EurekaGeneratorConstants.GENERATOR_LONG_NAME,
                EurekaGeneratorConstants.GENERATOR_SHORT_NAME)
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
            title = "Generate Eureka Artifacts From LEMMA Models"
            message = '''Use this dialog to configure and run LEMMA's «generatorLongName» on ''' +
                "the selected operation model"
        }
    }
}