package de.fhdo.lemma.eclipse.ui.transformation_dialog

import org.eclipse.jface.dialogs.TitleAreaDialog
import org.eclipse.swt.widgets.Shell
import de.fhdo.lemma.eclipse.ui.AbstractUiModelTransformationStrategy
import java.util.List
import de.fhdo.lemma.eclipse.ui.ModelFile
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridLayout
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.swt.custom.CLabel
import org.eclipse.jface.resource.LocalResourceManager
import org.eclipse.jface.resource.JFaceResources
import org.eclipse.jface.resource.ResourceManager
import org.eclipse.swt.widgets.ProgressBar
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.graphics.Point
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.custom.StyledText
import org.eclipse.swt.custom.StyleRange
import org.eclipse.jface.dialogs.MessageDialog
import java.io.StringWriter
import java.io.PrintWriter
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import de.fhdo.lemma.intermediate.transformations.IntermediateTransformationException
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils
import java.util.LinkedList

class TransformationDialog  extends TitleAreaDialog {
    static val MIN_DIALOG_WIDTH = 200
    static val MIN_DIALOG_HEIGHT = 120
    static val PROGRESS_TITLE_TEXT = "Performing intermediate model transformations"
    static final Logger LOGGER = LoggerFactory.getLogger(TransformationDialog)

    LinkedList<ModelFile> filesToTransform
    boolean convertToRelativeUris
    boolean outputRefinementModels
    ModelFile currentModelFile
    static val ResourceManager RESOURCE_MANAGER =
        new LocalResourceManager(JFaceResources.getResources())
    TransformationThread transformationThread
    Button cancelButton
    int currentTransformationIndex
    CLabel progressTitleLabel
    ProgressBar progressBar
    Label progressMessageLabel
    StyledText progressMessageText
    boolean stopTransformations
    boolean cancelPressed
    boolean shellClosed
    boolean ignoreAllTransformationWarnings

    /**
     * Constructor
     */
    new(
        Shell parentShell,
        AbstractUiModelTransformationStrategy strategy,
        List<ModelFile> inputModelFiles,
        boolean convertToRelativeUris,
        boolean outputRefinementModels
    ) {
        super(parentShell)

        if (parentShell === null)
            throw new IllegalArgumentException("Shell must not be null")
        else if (strategy === null)
            throw new IllegalArgumentException("Transformation strategy must not be null")
        else if (inputModelFiles === null || inputModelFiles.empty)
            throw new IllegalArgumentException("Input models must not be null or empty")

        filesToTransform = inputModelFiles.filterAndOrderForTransformation(strategy)
        this.convertToRelativeUris = convertToRelativeUris
        this.outputRefinementModels = outputRefinementModels
    }

    /**
     * Filter input files for transformable files and order those files as per the transformation
     * strategy
     */
    private def filterAndOrderForTransformation(List<ModelFile> inputModelFiles,
        AbstractUiModelTransformationStrategy strategy) {
        return strategy.sortByTransformationOrder(
            inputModelFiles.filter[fileTypeDescription.canBeTransformed].toList
        )
    }

    /**
     * Open dialog and run transformations
     */
    def openAndRunTransformations() {
        /* Code taken from Window.open() */
        // Limit the shell size to the display size
        constrainShellSize()

        // Open the window
        shell.open()

        /* Start transformation before event loop is started */
        transformationThread = new TransformationThread(
            filesToTransform,
            convertToRelativeUris,
            outputRefinementModels,
            shell.display,
            [nextTransformation],
            [transformationWarningOccurred],
            [transformationExceptionOccurred],
            [currentTransformationFinished],
            [transformationsFinished]
        )
        transformationThread.start()

        LemmaUiUtils.runEventLoop(shell)

        return returnCode
    }

    /**
     * Transformation thread callback: Next transformation starts
     */
    private def nextTransformation(ModelFile nextFile) {
        currentModelFile = nextFile
        currentTransformationIndex++
        progressTitleLabel.text = '''«PROGRESS_TITLE_TEXT» ''' +
            '''(«currentTransformationIndex»/«filesToTransform.size»)'''

        val filePathText = currentModelFile.file.fullPath.toString
        val transformationPathText = currentModelFile.transformationTargetPath
        val styleRange = new StyleRange
        styleRange.start = filePathText.length
        styleRange.length = 4
        styleRange.fontStyle = SWT.BOLD
        progressMessageText.text = '''«filePathText» to «transformationPathText»'''
        progressMessageText.setStyleRange(styleRange)

        progressBar.selection = currentTransformationIndex
        return !stopTransformations
    }

    /**
     * Transformation thread callback: Warning occurred during transformation
     */
    private def boolean transformationWarningOccurred(IntermediateTransformationException warning) {
        return switch (warning.phase) {
            case INPUT_MODEL_VALIDATION: inputModelValidationWarning(warning.message)
            case TRANSFORMATION_FINISHED: transformationFinishedWarning(warning.message)
            default: true
        }
    }

    /**
     * Handle source model validation warning
     */
    private def boolean inputModelValidationWarning(String warningMessage) {
        if (ignoreAllTransformationWarnings)
            return true

        val dialog = new MessageDialog(shell, "Source model validation warning", null, '''The ''' +
            '''following warning occurred while validating «currentModelFile.file.name»: ''' +
            '''«warningMessage» How do you want to proceed?''', MessageDialog.WARNING, 3,
            "Abort all transformations", "Abort current transformation", "Ignore validation " +
            "warnings and proceed", "Proceed")

        val buttonPressed = dialog.open()
        return switch (buttonPressed) {
            // Abort all transformations
            case -1,  // User closed dialog via window bar
            case 0: {
                stopTransformations = true
                false
            }

            // Abort current transformation
            case 1: false

            // Ignore all upcoming warnings and proceed
            case 2: {
                ignoreAllTransformationWarnings = true
                true
            }

            // Proceed with current transformation
            default: true
        }
    }

    /**
     * Handle warnings that occur after a transformation was finished
     */
    private def boolean transformationFinishedWarning(String warningMessage) {
        MessageDialog.openWarning(shell, "Warning after transformation", warningMessage)
        return true
    }

    /**
     * Transformation thread callback: Exception occurred during transformation
     */
    private def boolean transformationExceptionOccurred(Exception exception) {
        val exceptionMessage = if (exception.message !== null && !exception.message.empty)
                exception.message
            else {
                // An empty exception message may happen if an unexpected ATL-related exception
                // occurred
                exception.printStackTrace

                val stringWriter = new StringWriter
                val printWriter = new PrintWriter(stringWriter)
                exception.printStackTrace(printWriter)
                val stackTraceString = stringWriter.toString
                LOGGER.error(stackTraceString)

                "Unexpected transformation exception. Please consult the Eclipse log file for " +
                "the detailed stack trace."
            }

        val dialog = new MessageDialog(shell, "Transformation error", null, '''The following ''' +
            '''error occurred during the transformation of «currentModelFile.file.name»: ''' +
            '''"«exceptionMessage»" The current transformation was not executed. How do you ''' +
            '''want to proceed?''', MessageDialog.ERROR, 1, "Abort all transformations",
            "Continue with next transformation")

        val buttonPressed = dialog.open()
        return switch (buttonPressed) {
            // Abort all transformations
            case -1,
            case 0: {
                stopTransformations = true
                false
            }

            // Continue with next transformation
            default: true
        }
    }

    /**
     * Transformation thread callback: Current transformation finished
     */
    private def boolean currentTransformationFinished() {
        return !stopTransformations
    }

    /**
     * Transformation thread callback: All transformations were finished
     */
    private def transformationsFinished() {
        RESOURCE_MANAGER.dispose

        if (shellClosed)
            super.handleShellCloseEvent()
        else if (cancelPressed)
            super.cancelPressed()
        else
            super.okPressed()

        return false
    }

    /**
     * Create dialog (to be called after constructor and before open())
     */
    override create() {
        super.create()
        setTitle("Performing Intermediate Model Transformations")
    }

    /**
     * Close dialog
     */
    override closeTray() {
        RESOURCE_MANAGER.dispose
        super.closeTray()
    }

    /**
     * Flag to indicate that dialog is resizable
     */
    override isResizable() {
        return true
    }

    /**
     * Initial size
     */
    override getInitialSize() {
        val shellSize = super.getInitialSize()
        return new Point(
            Math.max(convertHorizontalDLUsToPixels(MIN_DIALOG_WIDTH), shellSize.x),
            Math.max(convertVerticalDLUsToPixels(MIN_DIALOG_HEIGHT), shellSize.y)
        )
    }

    /**
     * Internal callback for dialog area creation
     */
    override createDialogArea(Composite parent) {
        val area = super.createDialogArea(parent) as Composite
        val container = new Composite(area, SWT.NONE)
        container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true))

        val layout = new GridLayout(1, false)
        container.setLayout(layout)

        progressTitleLabel = new CLabel(container, SWT.NONE)
        progressTitleLabel.setImage(
            LemmaUiUtils.createImage(RESOURCE_MANAGER, class, "transformedFile.gif")
        )
        progressTitleLabel.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false))
        progressTitleLabel.text = PROGRESS_TITLE_TEXT

        progressBar = new ProgressBar(container, SWT.SMOOTH)
        progressBar.setMaximum(filesToTransform.size)
        progressBar.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false))

        progressMessageText = new StyledText(container, SWT.NONE)
        progressMessageText.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false))
        progressMessageText.background = parent.background
        progressMessageText.editable = false
        progressMessageText.enabled = false
        progressMessageText.background
        progressMessageText.caret = null

        progressMessageLabel = new Label(container, SWT.NONE)
        progressMessageLabel.setLayoutData(
            new GridData(GridData.FILL, GridData.CENTER, true, false)
        )
        val line = new Label(container, SWT.HORIZONTAL.bitwiseOr(SWT.SEPARATOR))
        line.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false))

        return area
    }

    /**
     * Create buttons for the button bar
     */
    override createButtonsForButtonBar(Composite parent) {
        cancelButton = createButton(parent, IDialogConstants.CANCEL_ID,
            IDialogConstants.CANCEL_LABEL, false)
    }

    /**
     * User clicked close icon in the window bar
     */
    override handleShellCloseEvent() {
        userAborted(true)
    }

    /**
     * "Cancel" was pressed
     */
    override cancelPressed() {
        userAborted(false)
    }

    /**
     * User clicked on "Cancel" or the close icon in the window bar
     */
    private def userAborted(boolean shellClosed) {
        if (transformationThread === null) {
            if (shellClosed)
                super.handleShellCloseEvent()
            else
                super.cancelPressed()
        }

        this.shellClosed = shellClosed
        this.cancelPressed = !shellClosed

        cancelButton.text = "Canceling"
        cancelButton.enabled = false
        stopTransformations = true
    }
}