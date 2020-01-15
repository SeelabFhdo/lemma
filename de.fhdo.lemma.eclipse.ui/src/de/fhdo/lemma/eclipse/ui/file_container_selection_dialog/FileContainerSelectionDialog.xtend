package de.fhdo.lemma.eclipse.ui.file_container_selection_dialog

import org.eclipse.jface.dialogs.TitleAreaDialog
import org.eclipse.swt.widgets.Shell
import org.eclipse.core.resources.IContainer
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.graphics.Point
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.jface.viewers.TreeViewer
import org.eclipse.ui.model.WorkbenchLabelProvider
import org.eclipse.jface.viewers.ViewerComparator
import org.eclipse.jface.viewers.IDoubleClickListener
import org.eclipse.jface.viewers.DoubleClickEvent
import org.eclipse.jface.viewers.ITreeSelection
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.jface.viewers.ISelectionChangedListener
import org.eclipse.jface.viewers.SelectionChangedEvent
import org.eclipse.jface.viewers.StructuredSelection
import org.eclipse.swt.widgets.Text
import org.eclipse.jface.dialogs.IMessageProvider
import org.eclipse.swt.widgets.Label
import org.eclipse.core.resources.IFile
import de.fhdo.lemma.eclipse.ui.ModelFile
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.core.runtime.Path
import org.eclipse.core.resources.IResource
import java.util.Map
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils

/**
 * Generic dialog to select the container for a filename. The dialog is inspired by the
 * ContainerSelectionDialog from package org.eclipse.ui.dialogs, which may not directly be
 * subclassed.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class FileContainerSelectionDialog extends TitleAreaDialog {
    public static val int NEXT = 2
    public static val int PREVIOUS = 3
    public static val int ABORT = 4
    public static val int RUN_TRANSFORMATIONS = 5

    static val MIN_DIALOG_WIDTH = 500
    static val MIN_DIALOG_HEIGHT = 250

    String title
    String message
    ModelFile modelFile
    IResource initialResource
    IResource initialSelection
    int currentFileIndex
    boolean lastFile
    TreeViewer containerSelectionTree
    Text filepathField
    Map<String, ModelFile> alreadySpecifiedPaths

    @Accessors(PUBLIC_GETTER)
    IFile selectedFile

    /**
     * Constructor
     */
    new(Shell parentShell, ModelFile modelFile, IFile initialFile,
        Map<String, ModelFile> alreadySpecifiedPaths, String title, String message,
        int currentFileIndex, int fileCount) {
        super(parentShell)

        if (modelFile === null)
            throw new IllegalArgumentException("Model file must not be null")
        else if (alreadySpecifiedPaths === null)
            throw new IllegalArgumentException("Map of already specified paths must not be null")
        else if (currentFileIndex <= 0)
            throw new IllegalArgumentException("File index starts with 1")
        else if (fileCount <= 0)
            throw new IllegalArgumentException("File count must be positive")
        else if (currentFileIndex > fileCount)
            throw new IllegalArgumentException("Current file index must not be greater than file " +
                "count")

        this.title = title
        this.message = message
        this.modelFile = modelFile
        this.alreadySpecifiedPaths = alreadySpecifiedPaths
        this.currentFileIndex = currentFileIndex
        lastFile = currentFileIndex === fileCount

        // The initial file may be null if the dialog is opened for the first time for the given
        // model file. In this case, no deviant transformation path in the form of an IFile instance
        // could have been specified before.
        if (initialFile !== null)
            this.initialResource = initialFile
        else
            this.initialResource = modelFile.file.parent

        setShellStyle(getShellStyle().bitwiseOr(SWT.SHEET))
    }

    /**
     * Create dialog (to be called after constructor and before open())
     */
    override create() {
        super.create()
        setTitle(title ?: "")
        setMessage(message ?: "", IMessageProvider.INFORMATION)
    }

    /**
     * Treat shell closing event like a press of the abort button
     */
    override handleShellCloseEvent() {
        abortPressed()
    }

    /**
     * Create buttons for the button bar
     */
    override createButtonsForButtonBar(Composite parent) {
        // Abort
        createButton(parent, ABORT, "Abort", false)

        // Cancel
        createButton(parent, CANCEL, IDialogConstants.CANCEL_LABEL, false)

        // Previous file
        val previousButton = createButton(parent, PREVIOUS, "< Previous", false)
        previousButton.enabled = currentFileIndex > 1

        // Next file/Run transformations
        shell.defaultButton = if (!lastFile)
            createButton(parent, NEXT, "Next >", true)
        else
            createButton(parent, RUN_TRANSFORMATIONS, "Run transformations", true)
    }

    /**
     * Handle click on the abort button. A click on abort should stop the whole container selection
     * process.
     */
    private def void abortPressed() {
        val buttonPressed = MessageDialog.open(MessageDialog.QUESTION, shell, "Abort manual path " +
            "specification", "Aborting manual path specification will discard all previously " +
            "specified paths and return to the previous dialog. Do you want to proceed?", SWT.NONE,
            "Yes", "No")

        if (buttonPressed === 0)
            setReturnCodeAndClose(ABORT)
    }

    /**
     * Handle click on the cancel button
     */
    override cancelPressed() {
        val buttonPressed = MessageDialog.open(MessageDialog.QUESTION, shell, "Confirm usage of " +
            "default path", '''If you cancel the explicit specification of a path for the ''' +
            '''imported model file "«modelFile.file.fullPath»" the default path ''' +
            '''"«modelFile.transformationTargetPath»" will be used instead. Do you want to ''' +
            '''proceed?''', SWT.NONE, "Yes", "No")

        if (buttonPressed === 0)
            setReturnCodeAndClose(CANCEL)
    }

    /**
     * Handle click on the next or run transformations button
     */
    private def nextOrRunButtonPressed(int buttonId) {
        selectedFile = getSelectedFileFromInput()
        if (selectedFile !== null)
            setReturnCodeAndClose(buttonId)
    }

    /**
     * Helper method to set the return code and also close the dialog
     */
    private def void setReturnCodeAndClose(int buttonId) {
        returnCode = buttonId
        close()
    }

    /**
     * Catch button press
     */
    override buttonPressed(int buttonId) {
        switch (buttonId) {
            case ABORT: abortPressed()
            case CANCEL: cancelPressed()
            case PREVIOUS: setReturnCodeAndClose(PREVIOUS)
            case NEXT,
            case RUN_TRANSFORMATIONS: nextOrRunButtonPressed(buttonId)
        }
    }

    /**
     * Get the selected IFile from the input being specified by the user
     */
    private def getSelectedFileFromInput() {
        val filepath = filepathField.text + ".xmi"

        // Catch empty file path field
        if (filepath.empty) {
            MessageDialog.openError(shell, "No file path specified", "Please specify a file path.")
            return null
        }

        // Check for already specified file path
        val pathAlreadySpecifiedFor = alreadySpecifiedPaths.get(filepath)
        if (pathAlreadySpecifiedFor !== null) {
            val alreadySpecifiedForPath = pathAlreadySpecifiedFor.file.fullPath.toString
            MessageDialog.openError(shell, "Path already specified", '''The path "«filepath»" ''' +
                '''was already specified for the model file "«alreadySpecifiedForPath»". ''')
            return null
        }

        // Create the IFile handle and catch potential errors
        var IFile selectedFile
        try {
            val selectedFilePath = new Path(filepath)
            selectedFile = ResourcesPlugin.workspace.root.getFile(selectedFilePath)
        } catch (RuntimeException ex) {
            MessageDialog.openError(shell, "Invalid file path specified", ex.message)
            selectedFile = null
        }

        if (selectedFile === null)
            return null

        // Check that the file'sparent is a project in the workspace
        if (!ResourcesPlugin.workspace.root.exists(selectedFile.project.fullPath)) {
            MessageDialog.openError(shell, "Invalid file path specified",
            '''"«selectedFile.parent.fullPath»" is not a project in the current workspace.''')
            return null
        }

        // Warn if the specified file does not exist and explicitly ask the user to proceed
        if (!selectedFile.exists) {
            val buttonPressed = MessageDialog.open(MessageDialog.QUESTION, shell, "File does not " +
                "exist", '''The specified path "«filepath»" does not point to an existing ''' +
                '''file. Code generators may not be able to use the file and will likely show ''' +
                '''unexpected behavior. Do you want to proceed?''', SWT.NONE, "Yes", "No")

            if (buttonPressed === 1)
                return null

        // Warn if the specified file exists, but its contained intermediate model does not fit the
        // expected one
        } else {
            val xmiResource = LemmaUiUtils.loadXmiResource(selectedFile)
            val showConfirmDialog = if (xmiResource.contents.empty)
                    true
                else {
                    val root = xmiResource.contents.get(0)

                    // Currently, we only support model transformation strategies that produce
                    // exactly one output model
                    val expectedRootClass = modelFile.fileTypeDescription.outputModelTypes.get(0)
                        .rootClass
                    !expectedRootClass.isAssignableFrom(root.class)
                }

            if (showConfirmDialog) {
                val buttonPressed = MessageDialog.open(MessageDialog.QUESTION, shell, "File does " +
                "not contain expected model type", '''The file under the specified path ''' +
                '''"«filepath»" does not contain the expected type of model. Do you want to ''' +
                '''proceed?''', SWT.NONE, "Yes", "No")

                if (buttonPressed === 1)
                    return null
            }
        }

        return selectedFile
    }

    /**
     * Create the dialog's content
     */
    override createDialogArea(Composite parent) {
        val area = super.createDialogArea(parent) as Composite
        val container = new Composite(area, SWT.NONE)
        container.layoutData = new GridData(SWT.FILL, SWT.FILL, true, true)
        container.layout = new GridLayout(1, false)

        createContainerSelection(container)
        createFilepathInput(container)
        selectInitialResource(initialResource)

        return area
    }

    /**
     * Create the file container selection tree
     */
    private def createContainerSelection(Composite parent) {
        containerSelectionTree = new TreeViewer(parent)
        // Currently, we only support model transformation strategies that produce exactly one
        // output model
        val intermediateModelRootClass = modelFile.fileTypeDescription.outputModelTypes.get(0)
            .rootClass
        containerSelectionTree.contentProvider =
            new FileContainerSelectionTreeContentProvider(intermediateModelRootClass)
        containerSelectionTree.labelProvider =
            WorkbenchLabelProvider.decoratingWorkbenchLabelProvider
        containerSelectionTree.comparator = new ViewerComparator()
        containerSelectionTree.useHashlookup = true

        // Let tree take all remaining space in area
        val treeViewerData = new GridData()
        treeViewerData.grabExcessHorizontalSpace = true
        treeViewerData.grabExcessVerticalSpace = true
        treeViewerData.horizontalAlignment = GridData.FILL
        treeViewerData.verticalAlignment = GridData.FILL
        containerSelectionTree.tree.layoutData = treeViewerData

        // Toggle element collapse state on double click
        containerSelectionTree.addDoubleClickListener(new IDoubleClickListener() {
            override doubleClick(DoubleClickEvent event) {
                if (!(event.source instanceof TreeViewer)) {
                    return
                }

                val elementSelection = containerSelectionTree.getSelection() as ITreeSelection
                if (elementSelection === null ||
                    elementSelection.empty ||
                    !(elementSelection instanceof IStructuredSelection)) {
                    return
                }

                val selectedElement = elementSelection.firstElement
                if (containerSelectionTree.getExpandedState(selectedElement))
                    containerSelectionTree.collapseToLevel(selectedElement, TreeViewer.ALL_LEVELS)
                else
                    containerSelectionTree.expandToLevel(selectedElement, 1)
            }
        })

        // React to selection changed event
        containerSelectionTree.addSelectionChangedListener(new ISelectionChangedListener() {
            override selectionChanged(SelectionChangedEvent event) {
                var IResource selectedResource

                // initialSelection acts as "intermediate field". It holds the resource being
                // initially selected when the dialog gets invoked, e.g., a file path that was
                // initially specified for the model file and shall get changed now again. However,
                // the initialSelection is only used once to select the initial resource after the
                // dialog's startup. All following selection changes are triggered by the user
                // instead and treated as such.
                if (initialSelection !== null) {
                    selectedResource = initialSelection
                    initialSelection = null
                } else {
                    val selection = event.selection as IStructuredSelection
                    selectedResource = selection.firstElement as IResource
                }

                // Set file path text field depending on the type of the selected resource
                if (selectedResource instanceof IFile)
                    filepathField.text = LemmaUiUtils.removeExtension(selectedResource,
                        [fullPath.toString])
                else if (selectedResource instanceof IContainer)
                    filepathField.text = selectedResource.fullPath.toString + "/"
            }
        })

        containerSelectionTree.setInput(ResourcesPlugin.workspace)
    }

    /**
     * Create input text field for the file path and related labels
     */
    private def createFilepathInput(Composite parent) {
        val inputContainer = new Composite(parent, SWT.NONE)
        inputContainer.layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)
        inputContainer.layout = new GridLayout(3, false)

        val filepathLabel = new Label(inputContainer, SWT.NULL)
        filepathLabel.text = "File path:"

        filepathField = new Text(inputContainer, SWT.SINGLE.bitwiseOr(SWT.BORDER))
        val filepathData = new GridData()
        filepathData.grabExcessHorizontalSpace = true
        filepathData.horizontalAlignment = GridData.FILL
        filepathField.layoutData = filepathData

        val extensionLabel = new Label(inputContainer, SWT.NULL)
        extensionLabel.text = ".xmi"
    }

    /**
     * Select initial resource after the dialog's startup
     */
    private def selectInitialResource(IResource resource) {
        // Set "intermediate field" initialSelection
        initialSelection = resource

        // Expand tree to container of selected resource
        val itemsToExpand = newArrayList()
        var parent = resource.parent
        while (parent !== null) {
            itemsToExpand.add(0, parent)
            parent = parent.parent
        }
        containerSelectionTree.setExpandedElements(itemsToExpand.toArray)

        // Select the actual resource, which must be an existing node in the tree. In case the
        // resource does not physically exist and is hence not a node in the tree, select its
        // parent, which can only be an IContainer and thus is represented in the tree as a node. A
        // non-existing resource is represented by a file path that points to a non-existing XMI
        // file.
        val selectionResource = if (resource.exists) resource else resource.parent
        containerSelectionTree.setSelection(new StructuredSelection(selectionResource), true)
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
}