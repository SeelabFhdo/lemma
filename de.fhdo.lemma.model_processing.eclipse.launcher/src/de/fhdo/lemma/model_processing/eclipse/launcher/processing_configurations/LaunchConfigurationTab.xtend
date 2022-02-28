package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations

import org.eclipse.debug.ui.AbstractLaunchConfigurationTab
import org.eclipse.debug.core.ILaunchConfiguration
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Combo
import org.eclipse.swt.events.SelectionListener
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.widgets.Text
import org.eclipse.jface.fieldassist.ControlDecoration
import org.eclipse.jface.fieldassist.FieldDecorationRegistry
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration
import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*
import org.eclipse.core.databinding.DataBindingContext
import java.util.function.Supplier
import org.eclipse.jface.databinding.swt.typed.WidgetProperties
import org.eclipse.core.databinding.beans.typed.BeanProperties
import org.eclipse.core.databinding.UpdateValueStrategy
import org.eclipse.core.databinding.conversion.IConverter
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.ArgumentKindFactory
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.ConstantParameterArgumentKind
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.MultiValuedParameterArgumentKind
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.SingleValuedParameterArgumentKind
import org.eclipse.swt.widgets.Group
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ui.tab.arguments_table.ArgumentsTable
import static de.fhdo.lemma.model_processing.eclipse.launcher.LaunchConfigurationConstants.*
import org.eclipse.swt.widgets.Button
import org.eclipse.ui.dialogs.ResourceListSelectionDialog
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.resources.IResource
import org.eclipse.swt.widgets.Shell
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IFile
import org.eclipse.jface.window.Window
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument
import java.beans.PropertyChangeListener
import java.beans.PropertyChangeEvent
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AbstractIntermediateModelArgumentTypeWithEnumValue
import de.fhdo.lemma.eclipse.ui.ProgrammaticIntermediateModelTransformation
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ui.ProjectSelectionDialog
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ui.ProjectFileSelectionDialog
import org.eclipse.jface.dialogs.MessageDialog

/**
 * UI tab for the creation and maintenance of a model processing launch configuration.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class LaunchConfigurationTab extends AbstractLaunchConfigurationTab
    implements PropertyChangeListener {
    static val DEFAULT_PROCESSOR_EXECUTABLE_TYPE = ProcessorExecutableType.LOCAL_JAVA_PROGRAM

    static val DEFAULT_SOURCE_MODEL_FILE_ARGUMENT = Argument.newArgument
        .singleValued
        .sourceModel
        .parameter("-s")

    static val SUPPORTED_ARGUMENT_KINDS = #{
        ArgumentKindFactory.fromIdentifier(ConstantParameterArgumentKind.IDENTIFIER),
        ArgumentKindFactory.fromIdentifier(MultiValuedParameterArgumentKind.IDENTIFIER),
        ArgumentKindFactory.fromIdentifier(SingleValuedParameterArgumentKind.IDENTIFIER)
    }

    val CONFIGURATION_BINDERS = <Supplier<ControlDecoration>>newArrayList(
            [bindSourceModelProjectName],
            [bindSourceModelFilePath],
            [bindProcessorExecutableType],
            [bindProcessorExecutablePath],
            [bindBasicProcessorExecutionCommand]
        ).unmodifiableView

    val dataBindingContext = new DataBindingContext()
    val currentDecorations = <ControlDecoration>newArrayList

    var Composite mainComposite
    var Text sourceModelProjectName
    var Text sourceModelFilePath
    var Combo processorExecutableType
    var Text basicProcessorExecutionCommand
    var Text processorExecutablePath
    var ControlDecoration processorExecutablePathDecorator
    var ArgumentsTable argumentsTable

    var initializationDone = false
    var sourceModelArgumentWasAddedOnce = false
    var ProcessingConfiguration originalConfiguration
    var ProcessingConfiguration currentConfiguration
    var ProcessorExecutableType previousProcessorExecutableType

    /**
     * Create the control
     */
    final override createControl(Composite parent) {
        mainComposite = new Composite(parent, SWT.NULL)
        mainComposite.layoutData = new GridData(SWT.FILL, SWT.FILL, true, true)
        mainComposite.layout = new GridLayout(1, false)
        setControl(mainComposite)

        mainComposite.addResourceInputs()
        mainComposite.addProcessorInputs()
        mainComposite.addArgumentsTable()
    }

    /**
     * Add input fields for filesystem resources
     */
    private def addResourceInputs(Composite parent) {
        val resourceInputsGrid = new Composite(parent, SWT.NULL)
        resourceInputsGrid.layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)
        resourceInputsGrid.layout = new GridLayout(3, false)

        resourceInputsGrid.addSourceModelProject()
        resourceInputsGrid.addSourceModelFile()
    }

    /**
     * Add text field and button for specifying the name of the source model project
     */
    private def addSourceModelProject(Composite parent) {
        new Label(parent, SWT.NULL).text = "Source model project:"

        sourceModelProjectName = new Text(parent, SWT.BORDER)
        sourceModelProjectName.layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)

        val projectSelectionButton = new Button(parent, SWT.PUSH)
        projectSelectionButton.text = "Browse..."
        projectSelectionButton.addListener(SWT.Selection,
            [handleSourceModelProjectSelection(parent.shell)])
    }

    /**
     * Handler for a click on the button for selecting the name of the source model project
     */
    private def handleSourceModelProjectSelection(Shell shell) {
        var IProject selectedProject
        val dialog = new ProjectSelectionDialog(shell)
        if (dialog.open() != Window.CANCEL) {
            selectedProject = dialog.selectedProject
            sourceModelProjectName.text = selectedProject.name
        }

        // Don't clear source model file field if it already contains a file that exists in the
        // selected project
        try {
            ProcessingConfiguration.validateSourceModelFilePath(selectedProject?.name,
                sourceModelFilePath.text)
        } catch (IllegalArgumentException ex) {
            sourceModelFilePath.text = ""
        }
    }

    /**
     * Bind the text field for specifying the name of the source model project
     */
    private def ControlDecoration bindSourceModelProjectName() {
        return sourceModelProjectName.bindWithValidationDecorationSupport(
            ProcessingConfiguration,
            "sourceModelProjectName",
            currentConfiguration,
            [ProcessingConfiguration.validateSourceModelProjectName(it)]
        )
    }

    /**
     * Helper to bind a text field with validation support to the tab's data binding context
     */
    private def <T> bindWithValidationDecorationSupport(
        Text field,
        Class<T> beanClass,
        String propertyName,
        T source,
        (String)=>void validationProcedure
    ) {
        return bindWithValidationDecorationSupport(
            field,
            dataBindingContext,
            beanClass,
            propertyName,
            source,
            validationProcedure
        ).value
    }

    /**
     * Add text field and button for specifying the path to the source model file
     */
    private def addSourceModelFile(Composite parent) {
        new Label(parent, SWT.NULL).text = "Source model file:"

        sourceModelFilePath = new Text(parent, SWT.BORDER)
        sourceModelFilePath.layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)

        val fileSelectionButton = new Button(parent, SWT.PUSH)
        fileSelectionButton.text = "Browse..."
        fileSelectionButton.addListener(SWT.Selection,
            [handleSourceModelFileSelection(parent.shell)])
    }

    /**
     * Handler for a click on the button for selecting the path to the source model file
     */
    private def handleSourceModelFileSelection(Shell shell) {
        val selectedProject = findProjectInCurrentWorkspace(sourceModelProjectName.text)
        var IFile selectedFile
        if (selectedProject !== null) {
            // In case the user already selected a project, enable selection of the file from this
            // project only
            val dialog = new ProjectFileSelectionDialog(shell, selectedProject)
            if (dialog.open() != Window.CANCEL)
                selectedFile = dialog.selectedFile
        } else {
            // In case the user hasn't selected a project yet, enable selection of the file from all
            // workspace projects
            val dialog = new ResourceListSelectionDialog(shell, ResourcesPlugin.workspace.root,
                IResource.FILE)
            if (dialog.open() != Window.CANCEL && !dialog.result.empty)
                selectedFile = dialog.result.get(0) as IFile
        }

        if (selectedFile === null) {
            return
        }

        // If no project was specified before, use that of the selected file. Note that the
        // assignment to the "text" property of the project text field must happen before that for
        // the file text field. Otherwise, the binding validation of the file text field is likely
        // to report a non-existing file because the binding model has not been updated with the new
        // project name, yet.
        if (selectedProject === null)
            sourceModelProjectName.text = selectedFile.project.name
        sourceModelFilePath.text = selectedFile.projectRelativePath.toString
    }

    /**
     * Bind the text field for specifying the path to the source model file
     */
    private def ControlDecoration bindSourceModelFilePath() {
        return sourceModelFilePath.bindWithValidationDecorationSupport(
            ProcessingConfiguration,
            "sourceModelFilePath",
            currentConfiguration,
            [
                ProcessingConfiguration.validateSourceModelFilePath(
                    currentConfiguration.sourceModelProjectName,
                    it
                )
            ]
        )
    }

    /**
     * Add input fields for model processor specification
     */
    private def addProcessorInputs(Composite parent) {
        val inputGroup = new Group(parent, SWT.SHADOW_ETCHED_IN)
        inputGroup.text = "Processor Information"
        inputGroup.layout = new GridLayout(2, false)
        inputGroup.layoutData = new GridData(GridData.FILL, GridData.BEGINNING, true, false)

        inputGroup.addTypeOfProcessorExecutable()
        inputGroup.addPathToProcessorExecutable()
        inputGroup.addBasicProcessorExecutionCommand()
    }

    /**
     * Add combo field for selecting the type of the processor executable
     */
    private def addTypeOfProcessorExecutable(Composite parent) {
        new Label(parent, SWT.NULL).text = "Type of processor executable:"
        processorExecutableType = new Combo(parent, SWT.DROP_DOWN.bitwiseOr(SWT.READ_ONLY))
        processorExecutableType.layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)
        ProcessorExecutableType.values
            .map[ProcessorExecutableTypesInformationManager.label(it)]
            .forEach[processorExecutableType.add(it)]
        processorExecutableType.addSelectionListener(new SelectionListener() {
            override widgetDefaultSelected(SelectionEvent e) {
                widgetSelected(e)
            }

            override widgetSelected(SelectionEvent e) {
                toggleProcessorExecutablePathDecorator()
                if (!setDefaultBasicProcessorExecutionCommandOnExecutableTypeSwitch()) {
                    // Dirty hack to programmatically trigger the validation of the
                    // basicProcessorExecutionCommand field in case its value was not reset to a
                    // default processor execution command before. The validation triggering enables
                    // validators for processor execution commands to take the executable type into
                    // account. For example, processing configurations with a Docker executable type
                    // require the specification of a processor execution command. Note that the
                    // call to triggerValidation() cannot happen in propertyChange() as
                    // triggerValidation() changes the value of the text field which again triggers
                    // propertyChange() resulting in an infinite chain of propertyChange() calls.
                    triggerValidation(basicProcessorExecutionCommand)
                }
            }
        })
    }

    /**
     * Toggle the decorator on the text field for the path to the model processor executable
     * depending on whether the type of the processor executable provides support for specifying the
     * path
     */
    private def toggleProcessorExecutablePathDecorator() {
        val executableTypeHasInputSupport = ProcessorExecutableTypesInformationManager
            .hasInputSupport(currentConfiguration.processorExecutableType)
        if (executableTypeHasInputSupport)
            processorExecutablePathDecorator.show()
        else
            processorExecutablePathDecorator.hide()
    }

    /**
     * In case the type of the processor executable was changed, set the basic execution command to
     * the type's default if certain conditions of user interaction are met. Return true in case a
     * reset was performed and false otherwise.
     */
    private def setDefaultBasicProcessorExecutionCommandOnExecutableTypeSwitch() {
        val previousDefaultCommand = SUPPORTED_DEFAULT_BASIC_PROCESSOR_EXECUTION_COMMANDS
            .get(previousProcessorExecutableType)
        val newDefaultCommand = SUPPORTED_DEFAULT_BASIC_PROCESSOR_EXECUTION_COMMANDS
            .get(currentConfiguration.processorExecutableType)
        val currentCommand = currentConfiguration.basicProcessorExecutionCommand

        // Don't set default value in case there are no previous or new default values. Furthermore,
        // don't set default value if the user did not change the default command for the previous
        // processor executable type. In case the user already entered a valid command but for an
        // unintended processor executable type, we don't want her to having to enter the execution
        // command again.
        if (previousDefaultCommand === null || newDefaultCommand === null ||
            previousDefaultCommand != currentCommand)
            return false

        currentConfiguration.basicProcessorExecutionCommand = newDefaultCommand
        return true
    }

    /**
     * Bind the combo field for selecting the type of the processor executable
     */
    private def ControlDecoration bindProcessorExecutableType() {
        val target = WidgetProperties.comboSelection.observe(processorExecutableType)
        val model = BeanProperties.value(ProcessingConfiguration, "processorExecutableType",
            ProcessorExecutableType).observe(currentConfiguration)

        val modelToTargetConverter = new UpdateValueStrategy<ProcessorExecutableType, String>()
        modelToTargetConverter.converter = IConverter.create(
            [execType | ProcessorExecutableTypesInformationManager.label(execType)]
        )

        val targetToModelConverter = new UpdateValueStrategy<String, ProcessorExecutableType>()
        targetToModelConverter.converter = IConverter.create(
            [
                label |
                // Make previous executable type accessible to
                // resetBasicProcessorExecutionCommandOnExecutableTypeSwitch() for determining if
                // the basic execution command shall be reset to a default value
                previousProcessorExecutableType = currentConfiguration.processorExecutableType
                ProcessorExecutableTypesInformationManager.literal(label)
            ]
        )

        dataBindingContext.bindValue(target, model, targetToModelConverter, modelToTargetConverter)
        return null
    }

    /**
     * Add text field and decorator for specifying the path to the model processor executable
     */
    private def addPathToProcessorExecutable(Composite parent) {
        new Label(parent, SWT.NULL).text = "Path to processor executable:"
        processorExecutablePath = new Text(parent, SWT.BORDER)
        val layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)
        layoutData.widthHint = 50
        processorExecutablePath.layoutData = layoutData

        processorExecutablePathDecorator = new ControlDecoration(processorExecutablePath,
            SWT.TOP.bitwiseOr(SWT.RIGHT))
        processorExecutablePathDecorator.descriptionText = "Click to receive input support for " +
            "the selected type of the processor executable"
        processorExecutablePathDecorator.image = FieldDecorationRegistry.^default
            .getFieldDecoration(FieldDecorationRegistry.DEC_CONTENT_PROPOSAL).image
        processorExecutablePathDecorator.addSelectionListener(new SelectionListener() {
            override widgetDefaultSelected(SelectionEvent e) {
                widgetDefaultSelected(e)
            }

            override widgetSelected(SelectionEvent e) {
                // The decorator enables the specification of the path to the model processor
                // executable depending on whether the type of the processor executable provides a
                // support function for path specification
                val selectedInput = try {
                    ProcessorExecutableTypesInformationManager
                        .inputSupportFunction(currentConfiguration.processorExecutableType)
                        ?.apply(shell, currentConfiguration)
                } catch (IllegalArgumentException ex) {
                    MessageDialog.openError(shell, "Input Support Error", ex.message)
                    null
                }

                if (selectedInput !== null)
                    processorExecutablePath.text = selectedInput
            }
        })
    }

    /**
     * Bind the text field for specifying the path to the model processor executable
     */
    private def ControlDecoration bindProcessorExecutablePath() {
        return processorExecutablePath.bindWithValidationDecorationSupport(
            ProcessingConfiguration,
            "processorExecutablePath",
            currentConfiguration,
            [
                ProcessingConfiguration.validateProcessorExecutablePath(
                    currentConfiguration.processorExecutableType,
                    currentConfiguration.basicProcessorExecutionCommand,
                    it
                )
            ]
        )
    }

    /**
     * Add text field and decorator for specifying the basic model processor execution command
     */
    private def addBasicProcessorExecutionCommand(Composite parent) {
        new Label(parent, SWT.NULL).text = "Basic processor execution command:"
        basicProcessorExecutionCommand = new Text(parent, SWT.BORDER)
        basicProcessorExecutionCommand.layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)
        val executionCommandHint = new ControlDecoration(basicProcessorExecutionCommand,
            SWT.TOP.bitwiseOr(SWT.RIGHT))
        executionCommandHint.descriptionText = "The basic execution command to invoke the " +
            '''processor executable, e.g., "java" or "docker"'''
        executionCommandHint.image = FieldDecorationRegistry.^default
            .getFieldDecoration(FieldDecorationRegistry.DEC_INFORMATION).image
    }

    /**
     * Bind the text field for specifying the basic model processor execution command
     */
    private def ControlDecoration bindBasicProcessorExecutionCommand() {
        return basicProcessorExecutionCommand.bindWithValidationDecorationSupport(
            ProcessingConfiguration,
            "basicProcessorExecutionCommand",
            currentConfiguration,
            [
                ProcessingConfiguration.validateBasicProcessorExecutionCommand(
                    currentConfiguration.processorExecutableType,
                    it
                )
            ]
        )
    }

    /**
     * Add arguments table
     */
    private def addArgumentsTable(Composite parent) {
        val tableGroup = new Group(parent, SWT.SHADOW_ETCHED_IN)
        tableGroup.text = "Arguments"
        tableGroup.layout = new GridLayout(1, false)
        tableGroup.layoutData = new GridData(GridData.FILL, GridData.FILL, true, true)

        argumentsTable = new ArgumentsTable(tableGroup, SUPPORTED_ARGUMENT_KINDS)
    }

    /**
     * Initialize the tab from the given ILaunchConfiguration
     */
    final override initializeFrom(ILaunchConfiguration launchConfiguration) {
        val configuration = ProcessingConfiguration.deserializeFrom(launchConfiguration)
            ?: prepareNewProcessingConfiguration()

        setCurrentConfiguration(configuration)
        toggleProcessorExecutablePathDecorator()

        initializationDone = true
    }

    /**
     * Helper to prepare a new ProcessingConfiguration instance with default values
     */
    private def prepareNewProcessingConfiguration() {
        return new ProcessingConfiguration(
                "",
                "",
                DEFAULT_PROCESSOR_EXECUTABLE_TYPE,
                "",
                SUPPORTED_DEFAULT_BASIC_PROCESSOR_EXECUTION_COMMANDS
                    .get(DEFAULT_PROCESSOR_EXECUTABLE_TYPE)
            )
    }

    /**
     * Set the current ProcessingConfiguration instance handled by the tab
     */
    private def setCurrentConfiguration(ProcessingConfiguration configuration) {
        /* Remove old bindings, decorations, and property change listener */
        removeCurrentConfigurationBindingsAndDecorations()
        currentConfiguration?.removePropertyChangeListener(this)

        /* Set the new configuration and its working copy */
        originalConfiguration = configuration
        // We always work on a copy of the original configuration which enables us to later identify
        // changes by the user
        currentConfiguration = configuration.clone() as ProcessingConfiguration

        // Convert both the original and current (working copy) configuration to their user
        // representations so that we can identify changes caused by the user
        originalConfiguration.convertToUserRepresentation()
        currentConfiguration.convertToUserRepresentation()

        /* Configure arguments table to operate with the new configuration */
        argumentsTable.removePropertyChangeListener(this)
        argumentsTable.input = currentConfiguration
        argumentsTable.addPropertyChangeListener(this)

        /*
         * Establish bindings and decorations, and add property change listener to the current
         * configuration
         */
        establishCurrentConfigurationBindingsAndDecorations()
        currentConfiguration.addPropertyChangeListener(this)
    }

    /**
     * Remove all bindings from the current data binding context including control decorations
     */
    private def removeCurrentConfigurationBindingsAndDecorations() {
        dataBindingContext.bindings.forEach[
            dispose
            dataBindingContext.removeBinding(it)
        ]

        currentDecorations.forEach[it.dispose]
        currentDecorations.clear
    }

    /**
     * Establish bindings and add control decorations for the current configuration
     */
    private def establishCurrentConfigurationBindingsAndDecorations() {
        CONFIGURATION_BINDERS.forEach[binder |
            val decoration = binder.get()
            if (decoration !== null)
                currentDecorations.add(decoration)
        ]
    }

    /**
     * React to a property change event
     */
    final override propertyChange(PropertyChangeEvent event) {
        switch(event.propertyName) {
            case "sourceModelProjectName",
            case "sourceModelFilePath": {
                addSourceModelFileArgumentIfAllowed()
                // Update all intermediate model table items to render, e.g., errors of lacking
                // transformation support
                argumentsTable.updateArguments(AbstractIntermediateModelArgumentTypeWithEnumValue)
            }
            case "basicProcessorExecutionCommand":
                triggerValidation(processorExecutablePath)
        }

        updateLaunchConfigurationDialog()
    }

    /**
     * Add argument for the source model file to the arguments table
     */
    private def addSourceModelFileArgumentIfAllowed() {
        // The argument will only be added if (i) the tab hasn't been initialized yet; (ii) the
        // argument wasn't already added once (i.e., we won't continuously add it to allow the user
        // its subsequent removal); (iii) the arguments table doesn't already contain the argument;
        // (iv) the source model path is valid; and (v) the source model file supports intermediate
        // transformations.
        if (!initializationDone ||
            sourceModelArgumentWasAddedOnce ||
            argumentsTable.containsArgument(DEFAULT_SOURCE_MODEL_FILE_ARGUMENT)) {
            return
        }

        try {
            ProcessingConfiguration.validateSourceModelFilePath(
                currentConfiguration.sourceModelProjectName,
                currentConfiguration.sourceModelFilePath
            )
        } catch (IllegalArgumentException ex) {
            return
        }

        if (!ProgrammaticIntermediateModelTransformation
            .supportsTranformation(currentConfiguration.sourceModelFile)) {
            return
        }

        argumentsTable.addArgument(DEFAULT_SOURCE_MODEL_FILE_ARGUMENT)
        sourceModelArgumentWasAddedOnce = true
    }

    /**
     * Validate the given ILaunchConfiguration
     */
    final override isValid(ILaunchConfiguration configuration) {
        return try {
            currentConfiguration.validateInUserRepresentation
            true
        } catch (IllegalArgumentException ex) {
            false
        }
    }

    /**
     * Check if the tab's domain object is dirty
     */
    final override isDirty() {
        return originalConfiguration != currentConfiguration
    }

    /**
     * Apply the changes transported by the given ILaunchConfigurationWorkingCopy
     */
    final override performApply(ILaunchConfigurationWorkingCopy launchConfiguration) {
        ProcessingConfiguration.setProcessingConfigurationAsAttribute(launchConfiguration,
            currentConfiguration)
        // Setting the configuration as attribute of the ILaunchConfigurationWorkingCopy implicitly
        // results in the configuration being converted to its internal representation
        currentConfiguration.convertToUserRepresentation()
    }

    /**
     * Get tab's name
     */
    final override getName() {
        return COMMON_LAUNCH_CONFIGURATION_TAB_NAME
    }

    /**
     * Get tab's image
     */
    final override getImage() {
        return COMMON_LAUNCH_CONFIGURATION_TAB_IMAGE
    }

    /**
     * Set the tab's defaults
     */
    final override setDefaults(ILaunchConfigurationWorkingCopy configuration) {
        // NOOP
    }

    /**
     * Dispose the tab
     */
    final override dispose() {
        // Perform null-safe dispose() calls to prevent NPE when user creates a new launch
        // configuration manually (Eclipse's Debug Framework seems to call dispose() prior to
        // create Control() in some cases)
        argumentsTable?.dispose
        dataBindingContext?.dispose
        currentDecorations?.forEach[it.dispose]
        super.dispose()
    }
}