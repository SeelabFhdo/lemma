package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator

import org.eclipse.swt.widgets.Shell
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IFile
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableType
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.graphics.Point
import org.eclipse.swt.widgets.Group
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.layout.GridData
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.ProcessingConfigurationWithLaunchConfigurationName

/**
 * Abstract superclass for launch configuration templates targeting code generation with the Java
 * Base Generator.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class JavaBaseGeneratorTemplate extends AbstractJavaBaseGeneratorTemplate {
    /**
     * Constructor
     */
    new(Shell parentShell, IProject project, IFile file) {
        this(parentShell, "Java microservice generation", project, file)
    }

    /**
     * Constructor with explicit template name parameter
     */
    new(Shell parentShell, String name, IProject project, IFile file) {
        super(ProcessorExecutableType.LOCAL_JAVA_PROGRAM, parentShell, name, project, file)
    }

    /**
     * Get template completion dialog
     */
    override getJavaBaseGeneratorCompletionDialog() {
        return new TemplateCompletionDialog(parentShell, project, file)
    }

    /**
     * Dialog for template completion
     */
    static class TemplateCompletionDialog extends AbstractJavaBaseGeneratorCompletionDialog {
        GenletsTable genletsTable

        /**
         * Constructor
         */
        new(Shell parentShell, IProject project, IFile file) {
            super(parentShell, project, file)
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
            title = "Generate Java Microservices From LEMMA Models"
            message = '''Use this dialog to configure and run LEMMA's «generatorLongName» on ''' +
                '''the selected «printableModelFileType» model'''
        }

        /**
         * Create the dialog area
         */
        override createDialogArea(Composite parent) {
            val area = super.createDialogArea(parent)
            parent.shell.size = new Point(DEFAULT_WIDTH, 600)
            return area
        }

        /**
         * Add additional controls to the dialog
         */
        final override insertAdditionalControlsAfterDefaults(Composite parent) {
            super.insertAdditionalControlsAfterDefaults(parent)

            parent.insertAdditionalControlsBeforeGenletsGroup

            val genletsTableGroup = new Group(parent, SWT.SHADOW_ETCHED_IN)
            genletsTableGroup.text = "Genlets"
            genletsTableGroup.layout = new GridLayout(1, false)
            val layoutData = new GridData(GridData.FILL, GridData.FILL, true, true)
            genletsTableGroup.layoutData = layoutData
            layoutData.horizontalSpan = 3

            genletsTable = new GenletsTable(genletsTableGroup, configurationTemplate)
            genletsTable.addPropertyChangeListener(this)

            parent.insertAdditionalControlsAfterGenletsGroup
        }

        /**
         * Insert additional controls before the group with the Genlet table
         */
        def void insertAdditionalControlsBeforeGenletsGroup(Composite parent) {
            // NOOP
        }

        /**
         * Insert additional controls after the group with the Genlet table
         */
        def void insertAdditionalControlsAfterGenletsGroup(Composite parent) {
            // NOOP
        }

        /**
         * Complete the template with the Argument instances for the specified Genlets
         */
        override completeProcessingConfigurationTemplate(
            ProcessingConfigurationWithLaunchConfigurationName templateToComplete
        ) {
            templateToComplete.arguments.addAll(genletsTable.genletArguments)
        }

        /**
         * Close the dialog
         */
        override close() {
            genletsTable.removePropertyChangeListener(this)
            genletsTable.dispose()
            super.close()
        }
    }
}