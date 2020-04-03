package de.fhdo.lemma.eclipse.ui.select_models_dialog

import org.eclipse.jface.dialogs.TitleAreaDialog
import org.eclipse.swt.widgets.Shell
import org.eclipse.jface.dialogs.IMessageProvider
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.SWT
import org.eclipse.core.resources.IProject
import java.util.Map
import java.util.List
import org.eclipse.jface.viewers.TreeViewer
import org.eclipse.jface.viewers.TreeViewerColumn
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Group
import org.eclipse.swt.layout.RowLayout
import org.eclipse.swt.graphics.Point
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.jface.viewers.IDoubleClickListener
import org.eclipse.jface.viewers.DoubleClickEvent
import org.eclipse.jface.viewers.ITreeSelection
import de.fhdo.lemma.eclipse.ui.ModelFile
import de.fhdo.lemma.eclipse.ui.ModelFileTypeDescription
import org.eclipse.jface.dialogs.MessageDialog
import de.fhdo.lemma.eclipse.ui.AbstractUiModelTransformationStrategy
import org.eclipse.jface.viewers.ColumnLabelProvider
import org.eclipse.jface.dialogs.IDialogConstants

/**
 * Generic dialog to select models for subsequent intermediate model transformations.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class SelectModelsDialog extends TitleAreaDialog {
    static val MIN_DIALOG_WIDTH = 500
    static val MIN_DIALOG_HEIGHT = 250
    static val int CONTINUE_WITH_ALL = 2

    AbstractUiModelTransformationStrategy strategy
    Map<IProject, List<ModelFile>> inputModelFiles
    TreeViewer treeViewer

    @Accessors(PUBLIC_GETTER)
    var List<ModelFile> selectedModelFiles = <ModelFile> newArrayList

    /**
     * Constructor
     */
    new(Shell parentShell, AbstractUiModelTransformationStrategy strategy,
        Map<IProject, List<ModelFile>> inputModelFiles) {
        super(parentShell)

        if (strategy === null)
            throw new IllegalArgumentException("Transformation strategy must not be null")

        if (inputModelFiles === null || inputModelFiles.empty)
            throw new IllegalArgumentException("Input models must not be null or empty")

        this.strategy = strategy
        this.inputModelFiles = inputModelFiles
    }

    /**
     * OK button was pressed
     */
    override okPressed() {
        selectedModelFiles = getSelectedModelFilesFromTree()
        if (selectedModelFiles.empty) {
            MessageDialog.openError(shell, "No model files selected", "No model files were " +
                "selected. Transformation aborted.")
            return
        }

        filterSelectedModelFilesForErrorsAndContinue()
    }

    /**
     * Helper to filer selected model files for errors and leave the dialog for the next step if
     * there is at least one selected model without errors
     */
    private def filterSelectedModelFilesForErrorsAndContinue() {
        selectedModelFiles = selectedModelFiles.filter[!hasErrors].toList
        if (selectedModelFiles.empty)
            MessageDialog.openError(shell, "All selected models contain errors", "All selected " +
                "model files contain errors. Transformation is only possible on correct models. " +
                "Transformation aborted.")
        else
            super.okPressed
    }

    /**
     * Helper method to get selected files from tree viewer
     */
    private def getSelectedModelFilesFromTree() {
        val iter = treeViewer.structuredSelection.iterator
        return iter.filter[it instanceof ModelFile]
            .map[it as ModelFile]
            .toList
    }

    /**
     * Create dialog (to be called after constructor and before open())
     */
    override create() {
        super.create()
        val title = strategy.modelSelectionDialogTitle ?: ""
        setTitle(title)

        val message = strategy.modelSelectionDialogMessage ?: ""
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
        createModelTree(container)

        // Create legend if more than one file type is supported by the dialog
        val modelFileTypeDescriptions = strategy.modelFileTypeDescriptions
        if (modelFileTypeDescriptions !== null && modelFileTypeDescriptions.size > 1)
            createLegend(container, modelFileTypeDescriptions.values.toList)

        return area
    }

    /**
     * Create buttons for the button bar
     */
    override createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, "Continue with selected models", true)
        createButton(parent, CONTINUE_WITH_ALL, "Select all models and continue", false)
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false)
    }

    /**
     * Catch button press
     */
    override buttonPressed(int buttonId) {
        switch (buttonId) {
            case IDialogConstants.OK_ID: okPressed
            case CONTINUE_WITH_ALL: continueWithAllPressed
            case IDialogConstants.CANCEL_ID: cancelPressed
        }
    }

    /**
     * "Continue with all" was pressed
     */
    private def continueWithAllPressed() {
        selectedModelFiles = inputModelFiles.values.flatten.toList
        filterSelectedModelFilesForErrorsAndContinue()
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
     * Create tree viewer for dialog area
     */
    private def createModelTree(Composite parent) {
        /* Tree viewer */
        treeViewer = new TreeViewer(parent)
        treeViewer.setContentProvider(new ModelTreeContentProvider(inputModelFiles, strategy))
        val rootLabelProvider = new DelegatingStyledCellLabelProvider(new ModelTreeLabelProvider())
        treeViewer.setLabelProvider(rootLabelProvider)
        treeViewer.tree.setHeaderVisible(true)
        treeViewer.tree.setLinesVisible(true)

        // Toggle element collapse state on double click
        treeViewer.addDoubleClickListener(new IDoubleClickListener() {
            override doubleClick(DoubleClickEvent event) {
                if (!(event.source instanceof TreeViewer)) {
                    return
                }

                val elementSelection = treeViewer.getSelection() as ITreeSelection
                if (elementSelection === null ||
                    elementSelection.empty ||
                    !(elementSelection instanceof IStructuredSelection)) {
                    return
                }

                val selectedElement = elementSelection.firstElement
                if (treeViewer.getExpandedState(selectedElement))
                    treeViewer.collapseToLevel(selectedElement, TreeViewer.ALL_LEVELS)
                else
                    treeViewer.expandToLevel(selectedElement, 1)
            }
        })

        // Let viewer take all remaining space in area
        val treeViewerData = new GridData()
        treeViewerData.grabExcessHorizontalSpace = true
        treeViewerData.grabExcessVerticalSpace = true
        treeViewerData.horizontalAlignment = GridData.FILL
        treeViewerData.verticalAlignment = GridData.FILL
        treeViewer.tree.setLayoutData(treeViewerData)

        /* Model files column */
        val treeViewerColumnModelFiles = new TreeViewerColumn(treeViewer, SWT.NONE)
        treeViewerColumnModelFiles.column.setWidth(300)
        treeViewerColumnModelFiles.column.setText("Found model files in workspace")
        val modelFilesColumnLabelProvider = new DelegatingStyledCellLabelProvider(
            new ModelTreeLabelProvider()
        )
        treeViewerColumnModelFiles.setLabelProvider(modelFilesColumnLabelProvider)

        /* Path column */
        val treeViewerColumnFilePaths = new TreeViewerColumn(treeViewer, SWT.NONE)
        treeViewerColumnFilePaths.column.setWidth(600)
        treeViewerColumnFilePaths.column.setText("Model file path")
        treeViewerColumnFilePaths.setLabelProvider(new ColumnLabelProvider() {
            override getText(Object element) {
                return switch(element) {
                    ModelFile: element.file.fullPath.toString
                }
            }
        })

        treeViewer.setInput(inputModelFiles)
    }

    /**
     * Create legend for tree viewer icons
     */
    private def createLegend(Composite parent,
        List<ModelFileTypeDescription> modelFileTypeDescriptions) {
        /* Create legend group */
        val legend = new Group(parent, SWT.SHADOW_ETCHED_IN)
        legend.setText("Icon Legend")
        legend.setLayout(new GridLayout(1, false))

        // Set legend group layout data
        val legendGridData = new GridData()
        legendGridData.grabExcessHorizontalSpace = true
        legendGridData.horizontalAlignment = GridData.FILL
        legend.setLayoutData(legendGridData)

        /* Create legend entries for model file types */
        modelFileTypeDescriptions.forEach[
            val legendEntry = new Composite(legend, SWT.NONE)
            legendEntry.setLayout(new RowLayout(SWT.HORIZONTAL))
            val imageLabel = new Label(legendEntry, SWT.NONE)
            imageLabel.setImage(icon)
            val textLabel = new Label(legendEntry, SWT.NONE)
            textLabel.setText("-" + description)
        ]
    }
}