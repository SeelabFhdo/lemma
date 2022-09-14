package de.fhdo.lemma.data.avro.ui.to_avro

import org.eclipse.jface.dialogs.TitleAreaDialog
import org.eclipse.swt.widgets.Shell
import org.eclipse.jface.viewers.TreeViewer
import org.eclipse.jface.dialogs.IMessageProvider
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.swt.graphics.Point
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider
import de.fhdo.lemma.data.intermediate.IntermediateDataModel
import org.eclipse.swt.widgets.Group
import org.eclipse.swt.layout.RowLayout
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.graphics.Image
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.jface.viewers.TreeViewerColumn
import org.eclipse.jface.viewers.ColumnLabelProvider
import org.eclipse.emf.ecore.EObject

import static de.fhdo.lemma.data.avro.Util.*
import de.fhdo.lemma.data.intermediate.IntermediateEnumeration
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.data.intermediate.IntermediateCollectionType
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Text
import org.eclipse.swt.widgets.Control
import org.eclipse.swt.events.SelectionAdapter
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.jface.viewers.ISelection
import de.fhdo.lemma.data.avro.ui.to_avro.ElementTreeContentProvider
import de.fhdo.lemma.data.avro.ui.to_avro.ElementTreeLabelProvider

/**
 * Dialog to convert LEMMA models to Avro schema specification files.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class LemmaToAvroDialog extends TitleAreaDialog {
    static val MIN_DIALOG_WIDTH = 500
    static val MIN_DIALOG_HEIGHT = 250
    static val int CONTINUE_WITH_ALL = 2

    TreeViewer treeViewer
    Button protocolCheckbox
    Text protocolNameInput
    Text protocolDocumentationInput
    val inputRowControls = <Control>newArrayList

    String modelFilename
    List<? extends EObject> initialElements
    @Accessors(PUBLIC_GETTER)
    List<? extends EObject> selectedElements = emptyList
    @Accessors(PUBLIC_GETTER)
    String protocolName = ""
    @Accessors(PUBLIC_GETTER)
    String protocolDocumentation = ""

    /**
     * Constructor
     */
    new(Shell parentShell, String modelFilename, List<? extends EObject> topLevelTypeContainers) {
        super(parentShell)
        this.initialElements = topLevelTypeContainers
        this.modelFilename = modelFilename
    }

    /**
     * Create dialog (to be called after constructor and before open())
     */
    override create() {
        super.create()
        title = "Transform Intermediate Models to Avro Schema Declarations"
        setMessage('''Select elements from intermediate model "«modelFilename»" to be ''' +
            "transformed to Avro schemas.", IMessageProvider.INFORMATION)
    }

    /**
     * Internal callback for dialog area creation
     */
    override createDialogArea(Composite parent) {
        val area = super.createDialogArea(parent) as Composite

        val container = new Composite(area, SWT.NONE)
        container.layoutData = new GridData(SWT.FILL, SWT.FILL, true, true)
        container.layout = new GridLayout(1, false)

        createModelTree(container)
        createBottomRow(container)

        return area
    }

    /**
     * Create TreeViewer for LEMMA EObjects that can be transformed to Avro schemas
     */
    private def void createModelTree(Composite parent) {
        // Tree viewer
        treeViewer = new TreeViewer(parent)
        treeViewer.contentProvider = new ElementTreeContentProvider
        treeViewer.tree.headerVisible = true
        treeViewer.tree.linesVisible = true

        treeViewer.tree.addSelectionListener(new SelectionAdapter() {
            override widgetSelected(SelectionEvent event) {
                updateProtocolNameInput()
            }
        })

        // Toggle element collapse state on double click
        treeViewer.addDoubleClickListener([
            if (treeViewer.selection.empty ||
                !(treeViewer.selection instanceof IStructuredSelection))
                return

            val selectedElement = (treeViewer.selection as IStructuredSelection).firstElement
            if (treeViewer.getExpandedState(selectedElement))
                treeViewer.collapseToLevel(selectedElement, TreeViewer.ALL_LEVELS)
            else
                treeViewer.expandToLevel(selectedElement, 1)
        ])

        // Let viewer take all remaining space in area
        val treeViewerData = new GridData()
        treeViewerData.grabExcessHorizontalSpace = true
        treeViewerData.grabExcessVerticalSpace = true
        treeViewerData.horizontalAlignment = GridData.FILL
        treeViewerData.verticalAlignment = GridData.FILL
        treeViewer.tree.layoutData = treeViewerData

        // Columns
        createNameColumn
        createTypeKindColumn

        // Set input
        treeViewer.input = allTransformableElements()
    }

    /**
     * Helper to update the text field for the Avro protocol name based on its "enabled" state
     */
    private def void updateProtocolNameInput() {
        if (protocolNameInput.isEnabled) {
            val eObject = treeViewer.selection.selectedEObject
            val qualifiedName = if (eObject !== null) qualifiedName(eObject) else ""
            protocolNameInput.text = qualifiedName
        } else
            protocolNameInput.text = ""
    }

    /**
     * Get selected LEMMA EObject from tree viewer ISelection object
     */
    private def EObject getSelectedEObject(ISelection selection) {
        return if (selection instanceof IStructuredSelection && !selection.empty)
            (selection as IStructuredSelection).toList.get(0) as EObject
        else
            null
    }

    /**
     * Create element name column in tree viewer
     */
    private def void createNameColumn() {
        val column = new TreeViewerColumn(treeViewer, SWT.NONE)
        column.column.width = 300
        column.column.text = "Element name"
        column.labelProvider = new DelegatingStyledCellLabelProvider(
            new ElementTreeLabelProvider())
    }

    /**
     * Create type kind column in tree viewer
     */
    private def void createTypeKindColumn() {
        val column = new TreeViewerColumn(treeViewer, SWT.NONE)
        column.column.width = 600
        column.column.text = "Complex type kind"
        column.labelProvider = new ColumnLabelProvider() {
            override getText(Object element) {
                return switch(element) {
                    IntermediateEnumeration: "Enumeration"
                    IntermediateDataStructure: "Data structure"
                    IntermediateCollectionType: "Collection type"
                    default: ""
                }
            }
        }
    }

    /**
     * Get all LEMMA EObjects from the initial elements of this dialog, which may be transformed to
     * Avro schemas
     */
    private def List<? extends EObject> allTransformableElements() {
        val firstContainer = initialElements.get(0)
        return if (firstContainer instanceof IntermediateDataModel)
                firstContainer.complexTypes
            else
                initialElements

    }

    /**
     * Create bottom row of dialog
     */
    private def void createBottomRow(Composite parent) {
        val bottomRow = new Composite(parent, SWT.NONE)
        bottomRow.layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)
        bottomRow.layout = new GridLayout(2, false)

        bottomRow.createKey

        val protocolGroup = bottomRow.createProtocolGroup
        protocolGroup.layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)
    }

    /**
     * Create key in bottom row
     */
    private def void createKey(Composite parent) {
        /* Create key group */
        val key = new Group(parent, SWT.SHADOW_ETCHED_IN)
        key.text = "Key"
        key.layoutData = new GridData(SWT.FILL, SWT.FILL, false, false)
        key.layout = new GridLayout(1, false)

        /* Create key entries */
        key.createKeyEntry(ElementTreeLabelProvider.VERSION_ICON, "Version")
        key.createKeyEntry(ElementTreeLabelProvider.CONTEXT_ICON, "Context")
        key.createKeyEntry(ElementTreeLabelProvider.COMPLEX_TYPE_ICON, "Complex Type")
    }

    /**
     * Create key entry in the given group, and with the specified icon and description
     */
    private def void createKeyEntry(Group keyGroup, Image icon, String description) {
        val keyEntry = new Composite(keyGroup, SWT.NONE)
        keyEntry.layout = new RowLayout(SWT.HORIZONTAL)
        val imageLabel = new Label(keyEntry, SWT.NONE)
        imageLabel.image = icon
        val textLabel = new Label(keyEntry, SWT.NONE)
        textLabel.text = '''-«description»'''
    }

    /**
     * Create group for Avro protocol specification
     */
    private def Group createProtocolGroup(Composite parent) {
        val group = new Group(parent, SWT.SHADOW_ETCHED_IN)
        group.text = "Avro Protocol Transformation"
        group.layout = new GridLayout(2, false)

        protocolCheckbox = new Button(group, SWT.CHECK)
        protocolCheckbox.layoutData = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1)
        protocolCheckbox.text = "Transform elements into Avro protocol specification"
        protocolCheckbox.addSelectionListener(new SelectionAdapter() {
            override widgetSelected(SelectionEvent event) {
                val selected = (event.widget as Button).selection
                inputRowControls.forEach[it.enabled = selected]
                updateProtocolNameInput()
                protocolDocumentationInput.text = ""
                if (selected)
                    protocolNameInput.setFocus
            }
        })

        val protocolName = group.createInputRow("Name*:")
        inputRowControls.add(protocolName.key)
        inputRowControls.add(protocolName.value)
        protocolNameInput = protocolName.value

        val protocolDocumentation = group.createInputRow("Documentation:")
        inputRowControls.add(protocolDocumentation.key)
        inputRowControls.add(protocolDocumentation.value)
        protocolDocumentationInput = protocolDocumentation.value

        return group
    }

    /**
     * Create an input row consisting of a Text input and its Label
     */
    private def Pair<Label, Text> createInputRow(Composite parent, String labelText) {
        val label = new Label(parent, SWT.NONE)
        label.enabled = false
        label.text = labelText

        val input = new Text(parent, SWT.BORDER)
        input.layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)
        input.enabled = false

        return label -> input
    }

    /**
     * Create buttons for the button bar
     */
    override createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, "Continue with selected elements", true)
        createButton(parent, CONTINUE_WITH_ALL, "Select all elements and continue", false)
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
     * OK button was pressed
     */
    override okPressed() {
        if (!checkProtocolInputs()) {
            return
        }

        selectedElements = treeViewer.structuredSelection.map[it as EObject].toList
        if (selectedElements.empty) {
            MessageDialog.openError(shell, "No Model Elements Selected", "No model elements were " +
                "selected. Transformation aborted.")
            return
        }

        protocolName = protocolNameInput.text
        protocolDocumentation = protocolDocumentationInput.text
        super.okPressed
    }

    /**
     * Helper to check the inputs related to the Avro protocol for validity
     */
    private def boolean checkProtocolInputs() {
        return if (protocolCheckbox.selection && protocolNameInput.text.empty) {
            MessageDialog.openError(shell, "No Protocol Name Specified", "Please specify a name " +
                "for the Avro protocol to be derived from selected LEMMA model elements.")
            false
        } else
            true
    }

    /**
     * Button to continue with all transformable elements was pressed
     */
    private def void continueWithAllPressed() {
        if (!checkProtocolInputs())
            return
        else {
            protocolName = protocolNameInput.text
            protocolDocumentation = protocolDocumentationInput.text
        }

        selectedElements = allTransformableElements()
        super.okPressed
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