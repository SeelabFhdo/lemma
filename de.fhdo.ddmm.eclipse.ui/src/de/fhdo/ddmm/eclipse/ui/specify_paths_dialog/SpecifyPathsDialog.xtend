package de.fhdo.ddmm.eclipse.ui.specify_paths_dialog

import org.eclipse.jface.dialogs.TitleAreaDialog
import java.util.List
import java.util.Map
import de.fhdo.ddmm.eclipse.ui.ModelFile
import org.eclipse.jface.viewers.TableViewer
import org.eclipse.swt.widgets.Shell
import de.fhdo.ddmm.eclipse.ui.AbstractUiModelTransformationStrategy
import org.eclipse.jface.dialogs.IMessageProvider
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.graphics.Point
import org.eclipse.jface.viewers.TableViewerColumn
import org.eclipse.jface.viewers.ColumnLabelProvider
import de.fhdo.ddmm.eclipse.ui.ModelFileStyledLabelProvider
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider
import org.eclipse.jface.resource.ResourceManager
import org.eclipse.jface.resource.LocalResourceManager
import org.eclipse.jface.resource.JFaceResources
import org.eclipse.swt.graphics.Image
import de.fhdo.ddmm.eclipse.ui.utils.DdmmUiUtils
import org.eclipse.swt.widgets.Listener
import org.eclipse.swt.widgets.Event
import com.google.common.base.Predicate
import org.eclipse.jface.dialogs.MessageDialog
import java.util.Set
import de.fhdo.ddmm.eclipse.ui.file_container_selection_dialog.FileContainerSelectionDialog
import org.eclipse.core.resources.IFile
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.Collections
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.Path
import org.eclipse.jface.dialogs.IDialogConstants

/**
 * Generic dialog to specify paths for subsequent intermediate model transformations.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class SpecifyPathsDialog extends TitleAreaDialog {
    static val MIN_DIALOG_WIDTH = 500
    static val MIN_DIALOG_HEIGHT = 250
    static val int UNSELECT_ALL = 2
    static val int SELECT_ALL = 3
    static val ResourceManager RESOURCE_MANAGER =
        new LocalResourceManager(JFaceResources.getResources())

    Shell parentShell
    Map<String, List<ModelFile>> inputModelFiles
    AbstractUiModelTransformationStrategy strategy
    TableViewer tableViewer
    Image checkboxActive
    Image checkboxInactive

    @Accessors(PUBLIC_GETTER)
    List<ModelFile> selectedModelFiles = <ModelFile> newArrayList

    /**
     * Constructor
     */
    new(Shell parentShell, AbstractUiModelTransformationStrategy strategy,
        Map<String, List<ModelFile>> inputModelFiles) {
        super(parentShell)

        if (parentShell === null)
            throw new IllegalArgumentException("Shell must not be null")
        else if (strategy === null)
            throw new IllegalArgumentException("Transformation strategy must not be null")
        else if (inputModelFiles === null || inputModelFiles.empty)
            throw new IllegalArgumentException("Input models must not be null or empty")

        this.parentShell = parentShell
        this.strategy = strategy
        this.inputModelFiles = inputModelFiles

        checkboxActive = DdmmUiUtils.createImage(RESOURCE_MANAGER, class, "checkboxActive.gif")
        checkboxInactive = DdmmUiUtils.createImage(RESOURCE_MANAGER, class, "checkboxInactive.gif")
    }

    /**
     * Create dialog (to be called after constructor and before open())
     */
    override create() {
        super.create()

        val title = strategy.specifyPathsDialogTitle ?: ""
        setTitle(title)

        val message = strategy.specifyPathsDialogMessage ?: ""
        setMessage(message, IMessageProvider.INFORMATION)
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
        createModelTable(container)

        return area
    }

    /**
     * Create buttons for the button bar
     */
    override createButtonsForButtonBar(Composite parent) {
        createButton(parent, UNSELECT_ALL, "Unselect all", false)
        createButton(parent, SELECT_ALL, "Select all", false)

        super.createButtonsForButtonBar(parent)
    }

    /**
     * Catch button press
     */
    override buttonPressed(int buttonId) {
        switch (buttonId) {
            case UNSELECT_ALL: unselectAllPressed()
            case SELECT_ALL: selectAllPressed()
            case IDialogConstants.OK_ID: okPressed
            case IDialogConstants.CANCEL_ID: cancelPressed
        }
    }

    /**
     * "Unselect all" was pressed
     */
    private def unselectAllPressed() {
        inputModelFiles.values.flatten.forEach[selectedForTransformation = false]
        tableViewer.refresh
    }

    /**
     * "Select all" was pressed
     */
    private def selectAllPressed() {
        inputModelFiles.values.flatten.forEach[selectedForTransformation = true]
        tableViewer.refresh
    }

    /**
     * OK button was pressed
     */
    override okPressed() {
        /* Get selected model files */
        selectedModelFiles = filterSelectedModelFiles()
        if (selectedModelFiles.empty) {
            MessageDialog.openError(parentShell, "No model files selected", "Please select at " +
                "least one model file. Transformation aborted.")
            return
        }

        /*
         * Get paths of unselected import model files, i.e., the "children" of the selected model
         * files, if any.
         */
        val childrenPaths = getPathsForUnselectedChildren(selectedModelFiles)
        if (childrenPaths === null) {
            return
        }

        // Distribute the children paths across the selected model files. This means that all
        // occurrences of a child will, i.e., each instance of a child in the "children" list of
        // a selected ModelFile, will receive the target transformation path that was specified by
        // the user. This step is necessary, because the dialogs in which transformation target
        // paths may be specified by the user only list one entry for a child. The same "child
        // file", however, may be imported more than once, i.e., by different model files.
        distributeSpecifiedPaths(selectedModelFiles, childrenPaths)

        super.okPressed
    }

    /**
     * Helper for getting the paths for unselected children of selected model files from user
     * interaction
     */
    private def Map<String, IFile>
        getPathsForUnselectedChildren(List<ModelFile> selectedModelFiles) {
        val unselectedChildren = filterUnselectedChildren(selectedModelFiles)
        if (unselectedChildren.empty)
            return Collections.EMPTY_MAP

        val buttonPressed = MessageDialog.open(MessageDialog.QUESTION_WITH_CANCEL, parentShell,
            "How to proceed with paths of unselected, imported model files?", "Some of the model " +
            "files not being selected for transformation are imported by model files that are " +
            "selected for transformation. In the transformation process, however, imported model " +
            "files are linked to importing model files on the basis of their paths. How do you " +
            "want to proceed in regard of the paths of the unselected, imported model files?",
            SWT.NONE, "Specify Paths manually", "Return to Dialog", "Use Paths from Dialog"
        )

        return switch(buttonPressed) {
            // Specify paths of unselected children manually
            case 0: manualPathSpecificationForUnselectedChildren(unselectedChildren,
                selectedModelFiles)
            case 1: null
            // Use paths from dialog
            case 2: useCurrentPathsForUnselectedChildren(unselectedChildren)
        }
    }

    /**
     * Distribute specified paths across children of selected model files
     */
    private def distributeSpecifiedPaths(List<ModelFile> selectedModelFiles,
        Map<String, IFile> childrenPaths) {
        val allSpecifiedPaths = selectedModelFiles.toMap([file.fullPath.toString],
            [transformationTargetPath])
        childrenPaths.forEach[physicalPath, specifiedFile |
            allSpecifiedPaths.put(physicalPath, specifiedFile.fullPath.toString)
        ]

        selectedModelFiles.map[children].flatten.forEach[
            val childPath = file.fullPath.toString
            transformationTargetPath = allSpecifiedPaths.get(childPath)
        ]
    }

    /**
     * Helper to handle user decision of using the current paths for unselected children
     */
    private def useCurrentPathsForUnselectedChildren(Set<ModelFile> unselectedChildren) {
        val fileNotExisting = unselectedChildren.exists[
            val transformationTargetPath = new Path(it.transformationTargetPath)
            val unselectedFile = ResourcesPlugin.workspace.root.getFile(transformationTargetPath)
            !unselectedFile.exists
        ]

        val boolean proceedWithTransformation = if (fileNotExisting)
                MessageDialog.openConfirm(shell, "Non-existent Paths in Dialog", "In the dialog, " +
                    "the transformation paths of some unselected children point to files that do " +
                    "not exist. Do you want to proceed with the transformation?")
            else
                true

        return if (proceedWithTransformation)
            unselectedChildren.toMap([file.fullPath.toString], [file])
        else
            null
    }

    /**
     * Enable user to manually specify a path for an imported model file that hasn't been selected
     * for transformation
     */
    private def manualPathSpecificationForUnselectedChildren(Set<ModelFile> unselectedChildren,
        List<ModelFile> selectedModelFiles) {
        /* Setup collection of all specified paths of the selected model files */
        val alreadySpecifiedPaths = selectedModelFiles.toMap([transformationTargetPath])

        /*
         * Initialize variables needed throughout the iteration over the imported models, i.e., the
         * "children" of the selected model files
         */
        val manualPaths = <String, IFile> newHashMap
        val childCount = unselectedChildren.size

        /*
         * Iterate over the children until the last child is reached or the user aborted the
         * specification process
         */
        var i = 0
        while (i < childCount) {
            val child = unselectedChildren.get(i)
            val childFullPath = child.file.fullPath.toString
            val existingManualPath = manualPaths.get(childFullPath)

            // Invoke the dialog to specify the path of the current child
            val dialogTitle = '''Specify path of imported model file («i+1» of «childCount»)'''
            val dialogMessage = '''Please select a container and filename for the imported ''' +
                '''model file "«childFullPath»". The filename needs to end with .xmi and ''' +
                '''should point to an existing XMI file in the workspace.'''
            val fileContainerSelectionDialog = new FileContainerSelectionDialog(shell, child,
                existingManualPath, alreadySpecifiedPaths, dialogTitle, dialogMessage, i+1,
                childCount)
            fileContainerSelectionDialog.create()
            val dialogResult = fileContainerSelectionDialog.open()

            // React to the result of the user's interaction with the dialog
            switch (dialogResult) {
                // Abort the manual specification process
                case FileContainerSelectionDialog.ABORT: return null

                // Cancel the path specification for the current child (i.e., the transformation
                // path that was specified in the general path specification dialog shall be used)
                // and move to next file
                case FileContainerSelectionDialog.CANCEL: i++

                // Go back to previous child and dialog
                case FileContainerSelectionDialog.PREVIOUS: i--

                // Go to the next child or run the transformations, i.e., store the specified path
                // for the subsequent action
                case FileContainerSelectionDialog.NEXT,
                case FileContainerSelectionDialog.RUN_TRANSFORMATIONS: {
                    val selectedFile = fileContainerSelectionDialog.selectedFile

                    // Store the specified path in the collection of already specified paths to
                    // enable validation of specified paths for uniqueness. If the file already had
                    // a path specified from a previous dialog interaction for the respective model
                    // file, remove the old path from the list of already specified paths first, so
                    // that it's assignable again.
                    if (existingManualPath !== null)
                        alreadySpecifiedPaths.remove(existingManualPath.fullPath.toString)
                    alreadySpecifiedPaths.put(selectedFile.fullPath.toString, child)

                    // Store specified path in the actual collection of manual paths
                    manualPaths.put(childFullPath, selectedFile)

                    // Next child and dialog
                    i++
                }
            }
        }

        return manualPaths
    }

    /**
     * Helper method to get selected model files
     */
    private def filterSelectedModelFiles() {
        val selectedModelFiles = inputModelFiles.values.flatten
            .filter[selectedForTransformation]
            .toList
        // Since in the dialog the transformation target path is project-relative, prefix it with
        // the project's full path
        selectedModelFiles.forEach[
            transformationTargetPath = file.project.fullPath + transformationTargetPath
        ]
        return selectedModelFiles
    }

    /**
     * Helper method to get unselected imported model files of selected model files, i.e., their
     * "children"
     */
    private def filterUnselectedChildren(List<ModelFile> selectedModelFiles) {
        val unselectedChildren = selectedModelFiles
            .map[children.filter[!selectedForTransformation]]
            .flatten
            .toSet
        // Since in the dialog the transformation target path is project-relative, prefix it with
        // the project's full path
        unselectedChildren.forEach[
            transformationTargetPath = file.project.fullPath + transformationTargetPath
        ]
        return unselectedChildren
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
     * Close dialog
     */
    override closeTray() {
        RESOURCE_MANAGER.dispose
        super.closeTray()
    }

    /**
     * Create table viewer for dialog area
     */
    private def createModelTable(Composite parent) {
        createTableViewer(parent)
        createCheckboxColumn()
        createModelFileColumn()
        createModelTypeColumn()
        createTransformationTargetPathColumn()
        tableViewer.setInput(inputModelFiles)
    }

    /**
     * Helper to create the dialog's table viewer
     */
    private def createTableViewer(Composite parent) {
        /* Table viewer */
        tableViewer = new TableViewer(parent)
        tableViewer.setContentProvider(new ModelTableContentProvider(strategy))
        tableViewer.table.setHeaderVisible(true)
        tableViewer.table.setLinesVisible(true)

        // Let viewer take all remaining space in area
        val tableViewerData = new GridData()
        tableViewerData.grabExcessHorizontalSpace = true
        tableViewerData.grabExcessVerticalSpace = true
        tableViewerData.horizontalAlignment = GridData.FILL
        tableViewerData.verticalAlignment = GridData.FILL
        tableViewer.table.setLayoutData(tableViewerData)

        // Disable selection of table rows
        tableViewer.table.addListener(SWT.Selection, new Listener() {
            override handleEvent(Event event) {
                event.detail = SWT.NONE
                event.type = SWT.None
                event.doit = false
                try {
                    tableViewer.table.setRedraw(false)
                    tableViewer.table.deselectAll()
                } finally {
                    tableViewer.table.setRedraw(true)
                }
            }
        })
    }

    /**
     * Helper to create the table's checkbox column
     */
    private def createCheckboxColumn() {
        val tableViewerColumnCheckbox = new TableViewerColumn(tableViewer, SWT.NONE)
        tableViewerColumnCheckbox.column.setWidth(20)
        tableViewerColumnCheckbox.labelProvider = new ColumnLabelProvider() {
            override getText(Object element) {
                return null
            }

            override getImage(Object element) {
                return if ((element as ModelFile).selectedForTransformation)
                        checkboxActive
                    else
                        checkboxInactive
            }
        }

        // Enable cell editing
        val Predicate<Pair<ModelFile, Boolean>> checkboxValidator = [
            val newSelectedForTransformation = it.value
            if (!newSelectedForTransformation)
                return true

            val affectedModelFile = it.key
            val duplicatePathExists = inputModelFiles.values.flatten.exists[
                it.selectedForTransformation &&
                it != affectedModelFile &&
                it.transformationTargetPath == affectedModelFile.transformationTargetPath
            ]

            if (duplicatePathExists)
                MessageDialog.openError(parentShell, "Duplicate transformation target path",
                    '''The transformation target path ''' +
                    '''"«affectedModelFile.transformationTargetPath»" was already specified ''' +
                    '''for another file.'''
                )

            return !duplicatePathExists
        ]

        tableViewerColumnCheckbox.editingSupport =
            new ModelTableCheckboxColumnEditingSupport(tableViewer, checkboxValidator)
    }

    /**
     * Helper to create the table's model file column
     */
    private def createModelFileColumn() {
        val tableViewerColumnModelFile = new TableViewerColumn(tableViewer, SWT.NONE)
        tableViewerColumnModelFile.column.setWidth(300)
        tableViewerColumnModelFile.column.setText("Model file")
        tableViewerColumnModelFile.labelProvider = new DelegatingStyledCellLabelProvider(
            new ModelFileStyledLabelProvider()
        )
    }

    /**
     * Helper to create the table's model type column
     */
    private def createModelTypeColumn() {
        val tableViewerColumnModelType = new TableViewerColumn(tableViewer, SWT.NONE)
        tableViewerColumnModelType.column.setWidth(110)
        tableViewerColumnModelType.column.setText("Model type")
        tableViewerColumnModelType.labelProvider = new ColumnLabelProvider() {
            override getText(Object element) {
                return (element as ModelFile).fileTypeDescription.description
            }
        }
    }

    /**
     * Helper to create the table's transformation target path column
     */
    private def createTransformationTargetPathColumn() {
        val tableViewerColumnTransformationTargetPath = new TableViewerColumn(tableViewer, SWT.NONE)
        tableViewerColumnTransformationTargetPath.column.setWidth(470)
        tableViewerColumnTransformationTargetPath.column.setText("Project-related transformation " +
            "target path")
        tableViewerColumnTransformationTargetPath.labelProvider = new ColumnLabelProvider() {
            override getText(Object element) {
                return (element as ModelFile).transformationTargetPath
            }
        }

        // Enable editing of column content
        val Predicate<Pair<ModelFile, String>> transformationTargetPathValidator = [
            val affectedModelFile = it.key
            if (!affectedModelFile.selectedForTransformation)
                return true

            val newTransformationTargetPath = it.value
            val duplicatePathExists = inputModelFiles.values.flatten.exists[
                it.selectedForTransformation &&
                it != affectedModelFile &&
                it.transformationTargetPath == newTransformationTargetPath
            ]

            if (duplicatePathExists)
                MessageDialog.openError(parentShell, "Duplicate transformation target path",
                    '''The transformation target path "«newTransformationTargetPath»" was ''' +
                    '''already specified for another file. Change aborted.''')

            return !duplicatePathExists
        ]
        tableViewerColumnTransformationTargetPath.editingSupport =
            new ModelTableTransformationTargetPathColumnEditingSupport(tableViewer,
                transformationTargetPathValidator)
    }
}