package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.AbstractLaunchConfigurationTemplate.AbstractTemplateCompletionDialog
import org.eclipse.swt.widgets.Shell
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IFile
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument
import org.eclipse.debug.core.DebugPlugin
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Text
import org.eclipse.swt.widgets.Button
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.ProcessingConfigurationWithLaunchConfigurationName
import org.eclipse.swt.widgets.DirectoryDialog
import org.eclipse.jface.dialogs.MessageDialog
import java.beans.PropertyChangeEvent
import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*
import org.apache.commons.io.FilenameUtils
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessorExecutableTypesInformationManager

/**
 * Abstract superclass for dialogs that enable the completion of code generator configuration
 * templates for model processing launch shortcuts.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
abstract class AbstractCodeGeneratorCompletionDialog extends AbstractTemplateCompletionDialog {
    static val LAUNCH_MANAGER = DebugPlugin.^default.launchManager

    var ProcessorExecutableType generatorExecutableType
    var Argument targetFolderArgument
    protected var Text generatorExecutablePath
    protected var Text basicGeneratorExecutionCommand
    protected var Text targetFolder
    protected val String generatorLongName
    protected val String generatorShortName

    /**
     * Constructor
     */
    new(
        Shell parentShell,
        IProject project,
        IFile file,
        String generatorLongName,
        String generatorShortName
    ) {
        super(parentShell, project, file, 3)
        this.generatorLongName = generatorLongName
        this.generatorShortName = generatorShortName
    }

    /**
     * Set the generator executable type for the dialog
     */
    final protected def setGeneratorExecutableType(
        ProcessorExecutableType generatorExecutableType
    ) {
        this.generatorExecutableType = generatorExecutableType
    }

    /**
     * Set the target folder Argument instance for the dialog
     */
    final protected def setTargetFolderArgument(Argument targetFolderArgument) {
        this.targetFolderArgument = targetFolderArgument
        // Let argument participate in configuration validation in
        // AbstractTemplateCompletionDialog.propertyChange()
        this.targetFolderArgument.addPropertyChangeListener(this)
    }

    /**
     * Create the dialog
     */
    override create() {
        super.create()

        // Derive launch configuration name with file-specific prefix
        val fileBasename = FilenameUtils.getBaseName(file.name)
        val fileExtension = file.fileExtension ?: ""
        var generatorNameAddendum = getGeneratorNameAddendum()
        if (!generatorNameAddendum.empty)
            generatorNameAddendum = replace(generatorNameAddendum, " ", "_") + "_"
        val configurationNamePrefix = '''Run_«generatorShortName»_«generatorNameAddendum»''' +
            '''«fileBasename»_«fileExtension»'''
        configurationTemplate.launchConfigurationName = LAUNCH_MANAGER
            .generateLaunchConfigurationName(configurationNamePrefix)
    }

    /**
     * Enable dialog implementers to provide an addendum for the generator short name as part of the
     * launch configuration name
     */
    def getGeneratorNameAddendum() {
        return ""
    }

    /**
     * Add additional controls to the dialog
     */
    override insertAdditionalControlsAfterDefaults(Composite parent) {
        parent.addPathToGeneratorExecutable
        parent.addBasicGeneratorExecutionCommand
        parent.addTargetFolder
    }

    /**
     * Add text field to specify the path to the code generator executable
     */
    private def addPathToGeneratorExecutable(Composite parent) {
        var labelAddendum = getGeneratorExecutableLabelTextAddendum()
        if (!labelAddendum.empty)
            labelAddendum = " " + labelAddendum
        new Label(parent, SWT.NULL).text = '''«generatorLongName»«labelAddendum»:'''

        generatorExecutablePath = new Text(parent, SWT.BORDER)
        generatorExecutablePath.layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)

        val generatorExecutablePathSelectionButton = new Button(parent, SWT.PUSH)
        generatorExecutablePathSelectionButton.text = "Browse..."
        generatorExecutablePathSelectionButton.addListener(SWT.Selection, [
            val selectedExecutablePath = try {
                ProcessorExecutableTypesInformationManager
                    .inputSupportFunction(generatorExecutableType)
                    .apply(shell, configurationTemplate)
            } catch (IllegalArgumentException ex) {
                MessageDialog.openError(shell, "Input Support Error", ex.message)
                null
            }

            if (selectedExecutablePath !== null)
                generatorExecutablePath.text = selectedExecutablePath
        ])

        bindWithValidationDecorationSupport(
            generatorExecutablePath,
            ProcessingConfigurationWithLaunchConfigurationName,
            "processorExecutablePath",
            configurationTemplate,
            [
                ProcessingConfigurationWithLaunchConfigurationName.validateProcessorExecutablePath(
                    configurationTemplate.processorExecutableType,
                    configurationTemplate.basicProcessorExecutionCommand,
                    it
                )
            ]
        )
    }

    /**
     * Enable dialog implementers to provide an addendum for the generator long name as part of the
     * label for the generator executable path's text field
     */
    def String getGeneratorExecutableLabelTextAddendum() {
        return ""
    }

    /**
     * Add text field to specify the code generator's basic execution command
     */
    private def addBasicGeneratorExecutionCommand(Composite parent) {
        new Label(parent, SWT.NULL).text = "Basic generator execution command:"
        basicGeneratorExecutionCommand = new Text(parent, SWT.BORDER)
        val layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)
        layoutData.horizontalSpan = 2
        basicGeneratorExecutionCommand.layoutData = layoutData

        bindWithValidationDecorationSupport(
            basicGeneratorExecutionCommand,
            ProcessingConfigurationWithLaunchConfigurationName,
            "basicProcessorExecutionCommand",
            configurationTemplate,
            [
                ProcessingConfigurationWithLaunchConfigurationName
                    .validateBasicProcessorExecutionCommand(
                        configurationTemplate.processorExecutableType,
                        it
                    )
            ]
        )
    }

    /**
     * Add text field to specify the target folder for generated code
     */
    private def addTargetFolder(Composite parent) {
        new Label(parent, SWT.NULL).text = "Generation target folder:"
        targetFolder = new Text(parent, SWT.BORDER)
        targetFolder.layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)

        val folderSelectionButton = new Button(parent, SWT.PUSH)
        folderSelectionButton.text = "Browse..."
        folderSelectionButton.addListener(SWT.Selection, [
            val directoryDialog = new DirectoryDialog(shell, SWT.OPEN)
            directoryDialog.text = "Select target folder for generated artifacts"
            directoryDialog.filterPath = configurationTemplate.sourceModelFile.project
                .location.makeAbsolute.toString

            val selectedFolder = directoryDialog.open
            if (selectedFolder !== null)
                targetFolder.text = selectedFolder
        ])

        bindWithValidationDecorationSupport(
            targetFolder,
            Argument,
            "value",
            targetFolderArgument,
            [
                targetFolderArgument.type.validateValueInUserRepresentation(configurationTemplate,
                it)
            ]
        )
    }

    /**
     * Callback for property changes
     */
    final override reactToPropertyChange(PropertyChangeEvent event) {
        if (event.propertyName == "basicProcessorExecutionCommand")
            triggerValidation(generatorExecutablePath)
    }

    /**
     * Close the dialog
     */
    override close() {
        targetFolderArgument.removePropertyChangeListener(this)
        super.close()
    }
}