package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.swt.widgets.Shell
import org.eclipse.jface.dialogs.TitleAreaDialog
import org.eclipse.swt.widgets.Composite
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.core.databinding.DataBindingContext
import org.eclipse.swt.widgets.Text

import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*
import org.eclipse.core.databinding.Binding
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IFile
import java.beans.PropertyChangeListener
import java.beans.PropertyChangeEvent
import org.eclipse.swt.widgets.Button
import org.eclipse.jface.fieldassist.ControlDecoration
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.CommandLineGenerator
import org.eclipse.swt.widgets.Control
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.swt.graphics.Point
import org.eclipse.swt.layout.GridLayout
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.CommandLineGenerator.CoherentCommandLineParts

/**
 * Abstract superclass for launch configuration templates. Conceptually, a launch configuration
 * template is a partially initialized model processing configuration that can be completed by the
 * user via a template-specific dialog. Templates are used by launch shortcuts for model processing
 * configurations to gather the minimum of required data for subsequent model processor execution.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
abstract class AbstractLaunchConfigurationTemplate {
    val protected Shell parentShell
    val protected IProject project
    val protected IFile file

    @Accessors(PUBLIC_GETTER)
    val String name

    /**
     * Enable implementers to decide whether the template is applicable to a LEMMA model. The map
     * of technology names to aliases can be used as an additional source of information whether the
     * template is applicable in the context of the specified source model file. For example, a
     * template for generating code for the Eureka technology likely requires the import of a
     * technology with name "Eureka" at least.
     */
    abstract def Boolean isApplicable(EObject modelRoot, Map<String, String> technologyNamePerAlias)

    /**
     * Get the template completion dialog
     */
    abstract def AbstractTemplateCompletionDialog getCompletionDialog()

    /**
     * Constructor
     */
    new(Shell parentShell, String name, IProject project, IFile file) {
        this.parentShell = parentShell
        this.name = name
        this.project = project
        this.file = file
    }

    /**
     * Enable implementers the extension of the partially initialized processing configuration
     * template
     */
    def ProcessingConfigurationWithLaunchConfigurationName
    extendInitializedProcessingConfigurationTemplate(
        ProcessingConfigurationWithLaunchConfigurationName initializedConfiguration
    ) {
        // NOOP
    }

    /**
     * Abstract superclass for template completion dialogs
     */
    static abstract class AbstractTemplateCompletionDialog extends TitleAreaDialog
        implements PropertyChangeListener {
        static val DEFAULT_COLUMN_COUNT = 2

        protected static val DEFAULT_WIDTH = 800
        protected static val DEFAULT_SIZE = new Point(DEFAULT_WIDTH, 300)

        protected val IProject project
        protected val IFile file
        protected val int columnCount

        @Accessors(PROTECTED_GETTER)
        protected var ProcessingConfigurationWithLaunchConfigurationName configurationTemplate

        protected val dataBindingContext = new DataBindingContext()
        protected val bindings = <Binding>newArrayList
        val decorations = <ControlDecoration>newArrayList

        var (ProcessingConfigurationWithLaunchConfigurationName)=>void runCallback
        var (ProcessingConfigurationWithLaunchConfigurationName)=>void storeCallback

        var Button showCommandLineButton
        var Button storeButton
        var Button runButton

        /**
         * Constructor
         */
        new(Shell parentShell, IProject project, IFile file) {
            this(parentShell, project, file, DEFAULT_COLUMN_COUNT)
        }

        /**
         * Constructor to configure a non-default number of columns for the dialog's grid layout
         */
        new(Shell parentShell, IProject project, IFile file, int columnCount) {
            super(parentShell)

            if (columnCount < 2)
                throw new IllegalArgumentException("Column count must be equal or greater 2")

            this.project = project
            this.file = file
            this.columnCount = columnCount
            helpAvailable = false
        }

        /**
         * Set the partially initialized model processing configuration as the actual template
         * domain object to be sufficiently completed for subsequent model processor execution. This
         * method must not be called by implementers.
         */
        package final def setInitializedProcessingConfigurationTemplate(
            ProcessingConfigurationWithLaunchConfigurationName configurationTemplate
        ) {
            this.configurationTemplate = configurationTemplate
            this.configurationTemplate.addPropertyChangeListener(this)
        }

        /**
         * Set the callback to be invoked when the user hit the store button. This method must not
         * be called by implementers.
         */
        package final def setStoreCallback(
            (ProcessingConfigurationWithLaunchConfigurationName)=>void callback
        ) {
            storeCallback = callback
        }

        /**
         * Set the callback to be invoked when the user hit the run button. This method must not be
         * called by implementers.
         */
        package final def setRunCallback(
            (ProcessingConfigurationWithLaunchConfigurationName)=>void callback
        ) {
            runCallback = callback
        }

        /**
         * Create the dialog area
         */
        override createDialogArea(Composite parent) {
            val area = super.createDialogArea(parent) as Composite
            val container = new Composite(area, SWT.NONE)
            container.layoutData = new GridData(SWT.FILL, SWT.FILL, true, true)
            container.layout = new GridLayout(columnCount, false)

            container.insertAdditionalControlsBeforeDefaults
            container.addConfigurationName
            container.insertAdditionalControlsAfterDefaults

            parent.shell.size = DEFAULT_SIZE

            return area
        }

        /**
         * Enable implementers to place additional controls before default controls
         */
        def void insertAdditionalControlsBeforeDefaults(Composite parent) {
            // NOOP
        }

        /**
         * Add text field for launch configuration name
         */
        private def addConfigurationName(Composite parent) {
            new Label(parent, SWT.NULL).text = "Launch configuration name:"

            val nameTextField = new Text(parent, SWT.BORDER)
            val layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)
            // Let the text field span across all columns excluding that for the label
            val textFieldSpan = columnCount - 1
            if (textFieldSpan > 0)
                layoutData.horizontalSpan = textFieldSpan
            nameTextField.layoutData = layoutData

            bindWithValidationDecorationSupport(
                nameTextField,
                ProcessingConfigurationWithLaunchConfigurationName,
                "launchConfigurationName",
                configurationTemplate,
                [
                    ProcessingConfigurationWithLaunchConfigurationName
                        .validateLaunchConfigurationName(it)
                ]
            )
        }

        /**
         * Helper to bind a control and property including validation and decoration support in the
         * dialog's binding and decoration contexts
         */
        final protected def <T> void bindWithValidationDecorationSupport(
            Control control,
            Class<T> beanClass,
            String propertyName,
            T source,
            (String)=>void validationProcedure
        ) {
            val bindingAndDecoration = bindWithValidationDecorationSupport(
                control,
                dataBindingContext,
                beanClass,
                propertyName,
                source,
                validationProcedure
            )
            bindings.add(bindingAndDecoration.key)
            decorations.add(bindingAndDecoration.value)
        }

        /**
         * Enable implementers to place additional controls after default controls
         */
        def void insertAdditionalControlsAfterDefaults(Composite parent) {
            // NOOP
        }

        /**
         * React to changes of template properties
         */
        final override propertyChange(PropertyChangeEvent event) {
            val completedConfiguration = configurationTemplate.clone
                as ProcessingConfigurationWithLaunchConfigurationName
            completeProcessingConfigurationTemplate(completedConfiguration)

            val configurationIsValid = completedConfiguration.isValidInUserRepresentation
            showCommandLineButton.enabled = configurationIsValid
            storeButton.enabled = configurationIsValid
            runButton.enabled = configurationIsValid

            event.reactToPropertyChange
        }

        /**
         * Enable implementers of concrete dialog's to complete the template, e.g., with additional
         * execution arguments. This callback gets invoked each time the user changes a template
         * property, and before the validity check, which may enable further controls for
         * interacting with valid configuration templates, and the generic reactToPropertyChange()
         * callback. Additionally, the callback gets invoked each time the user hits a button to
         * interact with the template, e.g., to store or run it.
         */
        def void completeProcessingConfigurationTemplate(
            ProcessingConfigurationWithLaunchConfigurationName templateToComplete
        ) {
            // NOOP
        }

        /**
         * Helper to check of the given model processing configuration is valid in its user
         * representation
         */
        private def isValidInUserRepresentation(
            ProcessingConfigurationWithLaunchConfigurationName configuration
        ) {
            return try {
                configuration.validateInUserRepresentation
                true
            } catch (IllegalArgumentException ex) {
                false
            }
        }

        /**
         * Generic callback to react to changes of template properties. This callback gets invoked
         * each time the user changes a template property, after
         * the completeProcessingConfigurationTemplate() callback and the validity check, which may
         * enable further controls for interacting with valid configuration templates.
         */
        def void reactToPropertyChange(PropertyChangeEvent evt) {
            // NOOP
        }

        /**
         * Create the dialog buttons
         */
        final override createButtonsForButtonBar(Composite parent) {
            createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false)
            showCommandLineButton = createButton(parent, IDialogConstants.DETAILS_ID, "Show " +
                "Command Line", false)
            storeButton = createButton(parent, IDialogConstants.FINISH_ID, "Store Without Running",
                false)
            runButton = createButton(parent, IDialogConstants.OK_ID, "Run", true)
        }

        /**
         * React to the user hitting a button
         */
        final override buttonPressed(int buttonId) {
            switch (buttonId) {
                case IDialogConstants.DETAILS_ID: showCommandLinePressed()
                case IDialogConstants.FINISH_ID: storePressed()
                default: super.buttonPressed(buttonId)
            }
        }

        /**
         * The user hit the show commandline button
         */
        private def showCommandLinePressed() {
            // The commandline generator operates on a completed clone of the current configuration
            // template. This approach ensures that the configuration is complete but also that the
            // current configuration, which the user may want to adapt again, remains in its current
            // state.
            val completedTemplate = configurationTemplate.clone()
                as ProcessingConfigurationWithLaunchConfigurationName
            completeProcessingConfigurationTemplate(completedTemplate)
            val commandLineGenerator = new CommandLineGenerator(completedTemplate)

            var CoherentCommandLineParts commandLineParts = null
            try {
                val partsAndWarnings = commandLineGenerator.generateCoherentCommandLineParts()
                commandLineParts = partsAndWarnings.key
                partsAndWarnings.value.forEach[
                    MessageDialog.openWarning(shell, "Warning during commandline generation", it)
                ]
            } catch (Exception ex) {
                MessageDialog.openError(shell, "Error during commandline generation", ex.message)
                return
            }

            val commandLine = commandLineGenerator.toPrintableCommandLine(commandLineParts, "\n\t")
            val commandLineDialog = new ShowCommandLineDialog(shell, commandLine)
            commandLineDialog.open()
        }

        /**
         * The user hit the store button
         */
        private def storePressed() {
            try {
                completeProcessingConfigurationTemplate(configurationTemplate)
                storeCallback.apply(configurationTemplate)
                super.okPressed()
            } catch(Exception ex) {
                // NOOP
            }
        }

        /**
         * The user hit the run button
         */
        final override okPressed() {
            try {
                completeProcessingConfigurationTemplate(configurationTemplate)
                runCallback.apply(configurationTemplate)
                super.okPressed()
            } catch(Exception ex) {
                // NOOP
            }
        }

        /**
         * Close the dialog
         */
        override close() {
            bindings.forEach[it.dispose]
            bindings.clear
            dataBindingContext.dispose()
            decorations.forEach[it.dispose]
            decorations.clear
            configurationTemplate.removePropertyChangeListener(this)
            super.close()
        }

        /**
         * Flag to indicate that the dialog is resizable
         */
        final override isResizable() {
            return true
        }
    }
}