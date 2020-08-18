package de.fhdo.lemma.data.avro.ui.to_lemma

import org.eclipse.jface.dialogs.TitleAreaDialog
import org.eclipse.swt.widgets.Shell

import java.util.List
import org.apache.avro.Schema
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.jface.dialogs.IMessageProvider
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Group
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.swt.graphics.Point
import org.eclipse.jface.viewers.TreeViewer
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.jface.viewers.TreeViewerColumn
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider
import org.eclipse.jface.viewers.ColumnLabelProvider
import org.eclipse.swt.graphics.Image
import org.eclipse.swt.layout.RowLayout
import org.apache.avro.Protocol
import de.fhdo.lemma.data.avro.ui.to_lemma.SchemaTreeContentProvider
import de.fhdo.lemma.data.avro.ui.to_lemma.SchemaTreeLabelProvider

/**
 * Dialog to convert Avro schema specification files to LEMMA models.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class AvroToLemmaDialog extends TitleAreaDialog {
    static val MIN_DIALOG_WIDTH = 500
    static val MIN_DIALOG_HEIGHT = 250
    static val int CONTINUE_WITH_ALL = 2

    TreeViewer treeViewer

    String avroFilename
    String schemaName
    String schemaNamespace
    String schemaDocumentation
    List<Schema> initialSchemas
    Protocol protocol
    @Accessors(PUBLIC_GETTER)
    Protocol selectedProtocol
    @Accessors(PUBLIC_GETTER)
    List<Schema> selectedSchemas = emptyList

    /**
     * Constructor
     */
    new(Shell parentShell, String avroFilename, String schemaName, String schemaNamespace,
        String schemaDocumentation, List<Schema> initialSchemas, Protocol protocol) {
        super(parentShell)

        this.avroFilename = avroFilename
        this.schemaName = schemaName
        this.schemaNamespace = schemaNamespace
        this.schemaDocumentation = schemaDocumentation
        this.initialSchemas = initialSchemas
        this.protocol = protocol
    }

    /**
     * Create dialog (to be called after constructor and before open())
     */
    override create() {
        super.create()
        title = "Transform Avro Schema Declarations to LEMMA Models"
        setMessage('''Determine schemas from Avro schema specification file "«avroFilename»" ''' +
            "to be transformed to LEMMA models.", IMessageProvider.INFORMATION)
    }

    /**
     * Internal callback for dialog area creation
     */
    override createDialogArea(Composite parent) {
        val area = super.createDialogArea(parent) as Composite

        val container = new Composite(area, SWT.NONE)
        container.layoutData = new GridData(SWT.FILL, SWT.FILL, true, true)
        container.layout = new GridLayout(1, false)

        createTopRow(container)
        createModelTree(container)
        createBottomRow(container)

        return area
    }

    /**
     * Create top row in the dialog comprising schema information
     */
    private def void createTopRow(Composite parent) {
        if (schemaName.empty)
            return

        val group = new Group(parent, SWT.SHADOW_ETCHED_IN)
        group.text = "Schema Information"
        group.layoutData = new GridData(SWT.FILL, SWT.FILL, false, false)
        group.layout = new GridLayout(2, false)

        group.createSchemaInformationLine("Name", if (!schemaNamespace.empty)
                '''«schemaNamespace».«schemaName»'''
            else
                schemaName
        )
        group.createSchemaInformationLine("Documentation", schemaDocumentation)
    }

    /**
     * Create line for schema information output
     */
    private def void createSchemaInformationLine(Composite parent, String caption, String value) {
        val label = new Label(parent, SWT.NONE)
        label.text = '''«caption»:'''

        val valueLabel = new Label(parent, SWT.NONE)
        valueLabel.text = value
    }

    /**
     * Create the tree viewer
     */
    private def void createModelTree(Composite parent) {
        // Tree viewer
        treeViewer = new TreeViewer(parent)
        treeViewer.contentProvider = new SchemaTreeContentProvider
        treeViewer.tree.headerVisible = true
        treeViewer.tree.linesVisible = true
        treeViewer.tree.layoutData = new GridData(SWT.FILL, SWT.FILL, true, true)

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

        // Columns
        createNameColumn
        createTypeColumn

        treeViewer.input = initialSchemas.toTreeElements
    }

    /**
     * Create schema name tree column
     */
    private def void createNameColumn() {
        val column = new TreeViewerColumn(treeViewer, SWT.NONE)
        column.column.width = 300
        column.column.text = "Schema name"
        column.labelProvider = new DelegatingStyledCellLabelProvider(
            new SchemaTreeLabelProvider())
    }

    /**
     * Create schema type tree column
     */
    private def void createTypeColumn() {
        val column = new TreeViewerColumn(treeViewer, SWT.NONE)
        column.column.width = 300
        column.column.text = "Schema type"
        column.labelProvider = new ColumnLabelProvider() {
            override getText(Object element) {
                return if (element instanceof AvroSchemaWithNamespace)
                        element.schema.type.toString.toLowerCase.toFirstUpper
                    else
                        ""
            }
        }
    }

    /**
     * Convert the given list of Avro schemas to elements as expected by the tree viewer
     */
    private def List<? extends Object> toTreeElements(List<Schema> schemas) {
        val namespaces = <String, AvroNamespace>newHashMap
        schemas.forEach[
            var namespaceObject = namespaces.get(it.namespace)
            if (namespaceObject === null) {
                namespaceObject = new AvroNamespace(it.namespace)
                namespaces.put(it.namespace, namespaceObject)
            }
            namespaceObject.addChild(it)
        ]

        return if (protocol !== null)
                newArrayList(new AvroProtocol(protocol, namespaces.values.toList))
            else
                namespaces.values.toList
    }

    /**
     * Intermediate class to represent an Avro namespace inside the tree viewer
     */
    static class AvroNamespace {
        @Accessors(PUBLIC_GETTER)
        String namespace
        @Accessors
        AvroProtocol parent
        @Accessors(PUBLIC_GETTER)
        List<AvroSchemaWithNamespace> children

        /**
         * Constructor
         */
        new (String namespace) {
            this.namespace = namespace
            this.children = newArrayList
        }

        /**
         * Add child Avro schema
         */
        def addChild(Schema schema) {
            children.add(new AvroSchemaWithNamespace(schema, this, null))
        }

        /**
         * Compare with Object
         */
        override equals(Object o) {
            return if (o == this)
                    true
                else if (!(o instanceof AvroNamespace))
                    false
                else if (namespace === null)
                    (o as AvroNamespace).namespace === null
                else
                    namespace == (o as AvroNamespace).namespace
        }

        /**
         * Get hash code
         */
        override hashCode() {
            return if (namespace !== null) namespace.hashCode else 0
        }
    }

    /**
     * Intermediate class to represent an Avro schema inside the tree viewer
     */
    static class AvroSchemaWithNamespace {
        @Accessors(PUBLIC_GETTER)
        Schema schema
        @Accessors(PUBLIC_GETTER)
        AvroNamespace namespace
        @Accessors(PUBLIC_GETTER)
        AvroSchemaWithNamespace parentSchema
        @Accessors(PUBLIC_GETTER)
        List<AvroSchemaWithNamespace> children

        /**
         * Constructor
         */
        new (Schema schema, AvroNamespace namespace, AvroSchemaWithNamespace parentSchema) {
            this.schema = schema
            this.namespace = namespace
            this.parentSchema = parentSchema
            this.children = if (schema.type == Schema.Type.UNION)
                    schema.types.map[new AvroSchemaWithNamespace(it, namespace, this)]
                else
                    newArrayList
        }

        /**
         * Get parent schema or namespace
         */
        def getParent() {
            return if (parentSchema !== null) parentSchema else namespace
        }

        /**
         * Compare with Object (does not correspond to equals()-contract on purpose)
         */
        override equals(Object o) {
            return schema == o
        }

        /**
         * Get hash code
         */
        override hashCode() {
            return schema.hashCode
        }
    }

    /**
     * Intermediate class to represent an Avro protocol inside the tree viewer
     */
    static class AvroProtocol {
        @Accessors(PUBLIC_GETTER)
        Protocol protocol
        @Accessors(PUBLIC_GETTER)
        List<AvroNamespace> children

        /**
         * Constructor
         */
        new (Protocol protocol, List<AvroNamespace> children) {
            this.protocol = protocol
            this.children = children
        }

        /**
         * Add child Avro namespace
         */
        def addChild(AvroNamespace namespace) {
            namespace.parent = this
            children.add(namespace)
        }
    }

    /**
     * Create bottom row of dialog
     */
    private def void createBottomRow(Composite parent) {
        val bottomRow = new Composite(parent, SWT.NONE)
        bottomRow.layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)
        bottomRow.layout = new GridLayout(1, false)

        /* Create key group */
        val key = new Group(parent, SWT.SHADOW_ETCHED_IN)
        key.text = "Key"
        key.layoutData = new GridData(SWT.FILL, SWT.FILL, false, false)
        key.layout = new GridLayout(1, false)

        /* Create key entries */
        key.createKeyEntry(SchemaTreeLabelProvider.PROTOCOL_ICON, "Protocol")
        key.createKeyEntry(SchemaTreeLabelProvider.NAMESPACE_ICON, "Namespace")
        key.createKeyEntry(SchemaTreeLabelProvider.SCHEMA_ICON, "Schema")
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
     * Create buttons for the button bar
     */
    override createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, "Continue with selected schemas", true)
        createButton(parent, CONTINUE_WITH_ALL, "Select all schemas and continue", false)
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
        val selectedSchemasFromTree = getSelectedSchemasFromTree
        // Set the protocol as selected element for callers in case it was selected from the tree or
        // all available schemas were selected
        if (protocolInTreeSelection || selectedSchemasFromTree.allAvailableSchemas)
            returnProtocol

        if (!selectedSchemasFromTree.empty)
            returnSchemas(selectedSchemasFromTree)
        else
            MessageDialog.openError(shell, "No Schemas Selected", "No schemas were selected. " +
                "Transformation aborted.")
    }

    /**
     * Get all selected schemas from the tree
     */
    private def List<Schema> getSelectedSchemasFromTree() {
        return treeViewer.structuredSelection.map[
            switch (it) {
                AvroNamespace: it.children.map[it.schema]
                AvroSchemaWithNamespace: newArrayList(it.schema)
            }
        ].flatten.toList
    }

    /**
     * Check if an Avro protocol is in the set of selected tree elements
     */
    private def boolean protocolInTreeSelection() {
        return treeViewer.structuredSelection.findFirst[it instanceof AvroProtocol] !== null
    }

    /**
     * Set the protocol as selected element for callers
     */
    private def void returnProtocol() {
        selectedProtocol = protocol
        super.okPressed
    }

    /**
     * Check if the given list of schemas corresponds to the list of all available schemas
     */
    private def boolean allAvailableSchemas(List<Schema> schemas) {
        return schemas.size === initialSchemas.size
    }

    /**
     * Set the given schemas as selected elements for callers
     */
    private def void returnSchemas(List<Schema> schemas) {
        selectedSchemas = schemas
        super.okPressed
    }

    /**
     * Button to continue with all transformable elements was pressed
     */
    private def void continueWithAllPressed() {
        if (protocol !== null)
            returnProtocol
        else
            returnSchemas(initialSchemas)
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