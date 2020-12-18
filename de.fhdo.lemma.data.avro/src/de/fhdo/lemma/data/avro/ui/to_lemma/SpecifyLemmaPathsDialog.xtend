package de.fhdo.lemma.data.avro.ui.to_lemma

import org.eclipse.jface.dialogs.TitleAreaDialog
import org.eclipse.jface.resource.ResourceManager
import org.eclipse.jface.resource.LocalResourceManager
import org.eclipse.jface.resource.JFaceResources
import org.eclipse.swt.widgets.Shell
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridLayout
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.emf.ecore.EObject
import de.fhdo.lemma.data.DataModel
import de.fhdo.lemma.technology.mapping.TechnologyMapping
import org.eclipse.swt.graphics.Image

import static de.fhdo.lemma.data.avro.ui.Util.*
import static de.fhdo.lemma.utils.LemmaUtils.*
import static de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils.*
import de.fhdo.lemma.service.ServiceModel
import org.eclipse.xtend.lib.annotations.Accessors
import de.fhdo.lemma.technology.Technology
import java.util.Map
import org.eclipse.swt.graphics.Point
import org.eclipse.swt.widgets.Listener
import org.eclipse.jface.viewers.TableViewer
import org.eclipse.swt.widgets.Event
import org.eclipse.jface.viewers.IStructuredContentProvider
import org.eclipse.jface.viewers.TableViewerColumn
import org.eclipse.jface.viewers.ColumnLabelProvider
import com.google.common.base.Predicate
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IProject
import java.io.File
import java.util.List

/**
 * Dialog for LEMMA paths specification.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class SpecifyLemmaPathsDialog extends TitleAreaDialog {
    static val MIN_DIALOG_WIDTH = 500
    static val MIN_DIALOG_HEIGHT = 250
    static val int DESELECT_ALL = 2
    static val int SELECT_ALL = 3
    static val ResourceManager RESOURCE_MANAGER =
        new LocalResourceManager(JFaceResources.getResources())
    static val Image CHECKBOX_ACTIVE_ICON = createImage(RESOURCE_MANAGER, SpecifyLemmaPathsDialog,
        "checkboxActive.gif")
    static val Image CHECKBOX_INACTIVE_ICON = createImage(RESOURCE_MANAGER, SpecifyLemmaPathsDialog,
        "checkboxInactive.gif")

    val MODEL_KINDS = <LemmaModelKind>newArrayList()

    @Accessors(PUBLIC_GETTER)
    Map<Class<? extends EObject>, Pair<String, String>> modelKindPaths = newHashMap
    TableViewer tableViewer
    IProject project

    /**
     * Constructor
     */
    new(Shell parentShell, IContainer container) {
        super(parentShell)

        project = container.project

        MODEL_KINDS.add(new LemmaModelKind(DataModel, "Data Model", "dataModel.gif", false,
            container.withFile("Domain.data")))
        // Service model kind should point to existing resource, because it is imported by possible
        // mapping models
        MODEL_KINDS.add(new LemmaModelKind(ServiceModel, "Service Model", "serviceModel.gif", true,
            container.withFile("Microservices.services")))
        MODEL_KINDS.add(new LemmaModelKind(TechnologyMapping, "Mapping Model", "mappingModel.gif",
            false, container.withFile("Avro.mapping")))
        MODEL_KINDS.add(new LemmaModelKind(Technology, "Technology Model", "technologyModel.png",
            false, project.withFile("Avro.technology")))
    }

    /**
     * Add the given filename to the full path of an IContainer
     */
    private def String withFile(IContainer container, String filename) {
        container.fullPath.append(filename).toString
    }

    /**
     * Helper class to represent a certain LEMMA model kind with a name and icon. Furthermore, it
     * may be configured whether the model kind should point to an existing resource in its
     * transformation target path.
     */
    static class LemmaModelKind {
        @Accessors(PUBLIC_GETTER)
        Class<? extends EObject> kind
        @Accessors(PUBLIC_GETTER)
        String name
        @Accessors(PUBLIC_GETTER)
        String hint
        @Accessors(PUBLIC_GETTER)
        Image icon
        @Accessors(PUBLIC_GETTER)
        boolean pathShouldExist
        public String targetPath
        public boolean selectedForTransformation

        /**
         * Constructor
         */
        new (Class<? extends EObject> kind, String name, String iconFile, boolean pathShouldExist,
            String targetPath) {
            this.kind = kind
            this.name = name
            this.icon = createImage(RESOURCE_MANAGER, SpecifyLemmaPathsDialog, iconFile)
            this.pathShouldExist = pathShouldExist
            hint = if (pathShouldExist)
                    "Specified path should point to existing resource"
                else
                    ""
            this.targetPath = targetPath
            selectedForTransformation = true
        }

        /**
         * Compare with Object
         */
        override equals(Object o) {
            if (!(o instanceof LemmaModelKind))
                return false

            return kind == (o as LemmaModelKind).kind
        }

        /**
         * Get hash code
         */
        override hashCode() {
            return kind.hashCode
        }
    }

    /**
     * Create dialog (to be called after constructor and before open())
     */
    override create() {
        super.create()
        title = "Specify Paths for LEMMA Models"
        message = "Specify target paths for the LEMMA models to be derived from the previously " +
            "selected Avro schemas"
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
        createModelKindTable(container)

        return area
    }

    /**
     * Create model kind table
     */
    private def createModelKindTable(Composite parent) {
        createTableViewer(parent)
        createCheckboxColumn()
        createModelKindColumn()
        createHintColumn()
        createTargetPathColumn()
        tableViewer.setInput(MODEL_KINDS)
    }

    /**
     * Create table viewer
     */
    private def createTableViewer(Composite parent) {
        // Table viewer
        tableViewer = new TableViewer(parent)
        tableViewer.contentProvider = new IStructuredContentProvider() {
            override getElements(Object inputElement) {
                return MODEL_KINDS
            }
        }
        tableViewer.table.headerVisible = true
        tableViewer.table.linesVisible = true
        tableViewer.table.layoutData = new GridData(SWT.FILL, SWT.FILL, true, true)

        // Disable selection of table rows
        tableViewer.table.addListener(SWT.Selection, new Listener() {
            override handleEvent(Event event) {
                event.detail = SWT.NONE
                event.type = SWT.None
                event.doit = false
                try {
                    tableViewer.table.redraw = false
                    tableViewer.table.deselectAll()
                } finally {
                    tableViewer.table.redraw = true
                }
            }
        })
    }

    /**
     * Create checkbox column
     */
    private def createCheckboxColumn() {
        val column = new TableViewerColumn(tableViewer, SWT.NONE)
        column.column.width = 20
        column.labelProvider = new ColumnLabelProvider() {
            override getText(Object element) {
                return null
            }

            override getImage(Object element) {
                return if ((element as LemmaModelKind).selectedForTransformation)
                        CHECKBOX_ACTIVE_ICON
                    else
                        CHECKBOX_INACTIVE_ICON
            }
        }

        // Enable cell editing
        val Predicate<Pair<LemmaModelKind, Boolean>> checkboxValidator = [
            val newSelectedForTransformation = it.value
            if (!newSelectedForTransformation)
                return true

            val affectedModelKind = it.key
            val duplicatePathExists = MODEL_KINDS.exists[
                it.selectedForTransformation &&
                it != affectedModelKind &&
                it.targetPath == affectedModelKind.targetPath
            ]

            if (duplicatePathExists)
                showError("Duplicate transformation target path", "The transformation target " +
                    '''path «affectedModelKind.targetPath»" was already specified for another ''' +
                    "model kind.")

            return !duplicatePathExists
        ]

        column.editingSupport = new ModelTableCheckboxColumnEditingSupport(tableViewer,
            checkboxValidator)
    }

    /**
     * Create model kind column
     */
    private def createModelKindColumn() {
        val column = new TableViewerColumn(tableViewer, SWT.NONE)
        column.column.width = 130
        column.column.text = "Model kind"
        column.labelProvider = new DelegatingStyledCellLabelProvider(
            new ModelKindStyledLabelProvider()
        )
    }

    /**
     * Create hint column
     */
    private def createHintColumn() {
        val column = new TableViewerColumn(tableViewer, SWT.NONE)
        column.column.width = 270
        column.column.text = "Hint"
        column.labelProvider = new ColumnLabelProvider() {
            override getText(Object element) {
                return (element as LemmaModelKind).hint
            }
        }
    }

    /**
     * Create target path column
     */
    private def createTargetPathColumn() {
        val column = new TableViewerColumn(tableViewer, SWT.NONE)
        column.column.width = 470
        column.column.setText("Project-related transformation target path")
        column.labelProvider = new ColumnLabelProvider() {
            override getText(Object element) {
                return (element as LemmaModelKind).targetPath
            }
        }

        // Enable editing of column content
        val Predicate<Pair<LemmaModelKind, String>> targetPathValidator = [
            val affectedModelKind = it.key
            if (!affectedModelKind.selectedForTransformation)
                return true

            val newTargetPath = it.value
            val duplicatePathExists = MODEL_KINDS.exists[
                it.selectedForTransformation &&
                it != affectedModelKind &&
                it.targetPath == newTargetPath
            ]

            if (duplicatePathExists)
                showError("Duplicate transformation target path", "The transformation target " +
                    '''path «newTargetPath»" was already specified for another model kind''' +
                    "Change aborted.")

            return !duplicatePathExists
        ]
        column.editingSupport = new ModelTableTargetPathColumnEditingSupport(tableViewer,
            targetPathValidator)
    }

    /**
     * Create buttons for the button bar
     */
    override createButtonsForButtonBar(Composite parent) {
        createButton(parent, DESELECT_ALL, "Deselect all", false)
        createButton(parent, SELECT_ALL, "Select all", false)

        super.createButtonsForButtonBar(parent)
    }

    /**
     * Catch button press
     */
    override buttonPressed(int buttonId) {
        switch (buttonId) {
            case DESELECT_ALL: deselectAllPressed()
            case SELECT_ALL: selectAllPressed()
            case IDialogConstants.OK_ID: okPressed
            case IDialogConstants.CANCEL_ID: cancelPressed
        }
    }

    /**
     * "Deselect all" button was pressed
     */
    private def deselectAllPressed() {
        MODEL_KINDS.forEach[selectedForTransformation = false]
        tableViewer.refresh
    }

    /**
     * "Select all" button was pressed
     */
    private def selectAllPressed() {
        MODEL_KINDS.forEach[selectedForTransformation = true]
        tableViewer.refresh
    }

    /**
     * OK button was pressed
     */
    override okPressed() {
        val modelKindFilepaths = MODEL_KINDS
            .filter[it.selectedForTransformation]
            .toMap([it.kind], [it.targetPath -> it.targetPath.toAbsoluteFilepath])

        if (modelKindFilepaths.empty) {
            showError("No model files selected", "Please select at least one model file. " +
                "Transformation aborted.")
            return
        }

        if (!overwriteExistingFiles(modelKindFilepaths.values.map[it.value].toList)) {
            return
        }

        modelKindPaths = modelKindFilepaths
        super.okPressed
    }

    /**
     * Convert a project-relative path to an absolute file path
     */
    private def String toAbsoluteFilepath(String projectRelativePath) {
        return removeFileUri(convertProjectPathToAbsoluteFileUri(projectRelativePath))
    }

    /**
     * Ask to overwrite existing files in the given list of file paths. Returns false if the user
     * does not agree to overwrite existing files and true otherwise.
     */
    private def boolean overwriteExistingFiles(List<String> filepaths) {
        var existingFiles = filepaths.map[new File(it)].filter[exists].map[name].join("\n\t- ")
        return if (!existingFiles.empty) {
            existingFiles = "\n\t- " + existingFiles + "\n\n"
            question("Overwrite Existing Files?", "The following files already exist in the " +
                '''workspace and will be overwritten:«existingFiles»Do you want to proceed?''')
        } else
            true
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
     * Dispose resource manager
     */
    override closeTray() {
        RESOURCE_MANAGER.dispose
        super.closeTray()
    }
}