package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator

import org.eclipse.swt.widgets.Composite
import org.eclipse.jface.viewers.TableViewer
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport
import org.eclipse.jface.viewers.IStructuredContentProvider
import org.eclipse.swt.layout.GridData
import org.eclipse.jface.viewers.TableViewerColumn
import org.eclipse.swt.SWT
import org.eclipse.jface.viewers.ColumnLabelProvider
import org.eclipse.jface.fieldassist.FieldDecorationRegistry
import org.eclipse.jface.viewers.ViewerCell
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.FileDialog
import org.eclipse.swt.widgets.TableItem
import org.eclipse.swt.custom.TableEditor
import org.eclipse.jface.viewers.ColumnViewer
import org.eclipse.jface.viewers.ViewerColumn
import org.eclipse.swt.layout.RowLayout
import org.eclipse.jface.resource.LocalResourceManager
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils
import org.eclipse.jface.resource.JFaceResources
import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*
import org.eclipse.jface.databinding.viewers.ObservableValueEditingSupport
import org.eclipse.core.databinding.DataBindingContext
import org.eclipse.jface.viewers.CellEditor
import org.eclipse.jface.viewers.TextCellEditor
import org.eclipse.jface.databinding.swt.typed.WidgetProperties
import org.eclipse.core.databinding.beans.typed.BeanProperties
import org.eclipse.core.databinding.observable.value.IObservableValue
import org.eclipse.core.databinding.UpdateValueStrategy
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.FileArgumentType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Arguments
import java.beans.PropertyChangeListener
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration
import de.fhdo.lemma.model_processing.eclipse.launcher.ui.ValidatingColumnLabelProvider

/**
 * Table for Genlet specification in template completion dialogs targeting the Java Base Generator.
 * Note that each Genlet is effectively backed by an Argument that points to the Genlet in generator
 * executions.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class GenletsTable {
    static val RESOURCE_MANAGER = new LocalResourceManager(JFaceResources.getResources())
    static val NEW_IMAGE = LemmaUiUtils.createImage(RESOURCE_MANAGER, GenletsTable, "add.gif")
    static val REMOVE_IMAGE = LemmaUiUtils.createImage(RESOURCE_MANAGER, GenletsTable, "remove.png")
    static val MOVE_UP_IMAGE = LemmaUiUtils.createImage(RESOURCE_MANAGER, GenletsTable,
        "moveUp.png")
    static val MOVE_DOWN_IMAGE = LemmaUiUtils.createImage(RESOURCE_MANAGER, GenletsTable,
        "moveDown.png")

    static val PATH_SELECTION_BUTTONS = <Argument, Button>newHashMap

    val Composite parent
    val ProcessingConfiguration processingConfiguration
    val TableViewer viewer
    val currentArguments = new Arguments(newArrayList)
    val dataBindingContext = new DataBindingContext()
    var Button newButton
    var Button removeButton
    var Button moveUpButton
    var Button moveDownButton

    /**
     * Constructor
     */
    new(Composite parent, ProcessingConfiguration processingConfiguration) {
        this.parent = parent
        this.processingConfiguration = processingConfiguration

        // Create table viewer
        viewer = new TableViewer(parent)
        ColumnViewerToolTipSupport.enableFor(viewer)
        viewer.contentProvider = new IStructuredContentProvider() {
            override getElements(Object inputElement) {
                return currentArguments.get
            }
        }
        viewer.table.headerVisible = true
        viewer.table.linesVisible = true
        viewer.table.layoutData = new GridData(GridData.FILL, GridData.FILL, true, true)

        // Create columns
        createPathColumn()
        createPathSelectionColumn()

        // Create button row
        createButtonRow()
    }

    /**
     * Create the column for specifying the path to a Genlet's JAR archive
     */
    private def createPathColumn() {
        val pathColumn = new TableViewerColumn(viewer, SWT.NONE)
        pathColumn.column.width = 730
        pathColumn.column.text = "Genlet"
        pathColumn.labelProvider = new ValidatingColumnLabelProvider<Argument>() {
            override getElementText(Argument element) {
                return element.value
            }

            override validate(Argument element) {
                val type = element.type as FileArgumentType
                type.validateValueInUserRepresentation(processingConfiguration, element.value)
            }
        }
        pathColumn.editingSupport = new PathColumnEditingSupport(this, dataBindingContext)
    }

    /**
     * Editing support for the Genlet path column
     */
    private static class PathColumnEditingSupport
        extends ObservableValueEditingSupport<Argument, String, String> {
        val GenletsTable genletsTable
        DataBindingContext dataBindingContext

        /**
         * Constructor
         */
        new(GenletsTable genletsTable, DataBindingContext dataBindingContext) {
            super(genletsTable.viewer, dataBindingContext)
            this.genletsTable = genletsTable
            this.dataBindingContext = dataBindingContext
        }

        /**
         * Get cell editor
         */
        override getCellEditor(Object element) {
            new TextCellEditor(genletsTable.viewer.table)
        }

        /**
         * Create the observable for the cell editor control
         */
        override doCreateCellEditorObservable(CellEditor cellEditor) {
            WidgetProperties.text(SWT.Modify).observe(cellEditor.control)
        }

        /**
         * Create the observable for the element value
         */
        override doCreateElementObservable(Argument argument, ViewerCell cell) {
            return BeanProperties.value(Argument, "value", null).observe(argument)
        }

        /**
         * Bind the observable for the element value to the observable for the cell editor control
         */
        override createBinding(IObservableValue<String> target,
            IObservableValue<String> model) {
            return dataBindingContext.bindValue(target, model,
                new UpdateValueStrategy(UpdateValueStrategy.POLICY_UPDATE), null)
        }
    }

    /**
     * Create the column with the button for supporting the specification of the path to a Genlet's
     * JAR archive via a file selection dialog
     */
    private def createPathSelectionColumn() {
        val pathSelectionColumn = new TableViewerColumn(viewer, SWT.NONE)
        pathSelectionColumn.column.width = 20
        pathSelectionColumn.labelProvider = new ColumnLabelProvider() {
            override update(ViewerCell cell) {
                val argument = cell.element as Argument

                // When an argument is moved by the user, there might already exist a button
                // instance for the argument as part of the source row of the move action. In this
                // case, dispose that obsolete button before creating a new one for the target row
                // of the move action.
                PATH_SELECTION_BUTTONS.get(argument)?.dispose

                // Create the button
                val pathSelectionButton = new Button(viewer.control as Composite, SWT.NONE)
                pathSelectionButton.layoutData = new GridData(SWT.CENTER, SWT.FILL, false, true)
                pathSelectionButton.image = FieldDecorationRegistry.^default
                    .getFieldDecoration(FieldDecorationRegistry.DEC_CONTENT_PROPOSAL).image
                pathSelectionButton.addListener(SWT.Selection, [
                    val selectedPath = pathSelectionDialog()
                    if (selectedPath !== null) {
                        argument.value = selectedPath
                        viewer.update(argument, null)
                    }
                ])
                PATH_SELECTION_BUTTONS.put(argument, pathSelectionButton)

                // Set the button as the cell's content
                val item = cell.item as TableItem
                val editor = new TableEditor(item.parent)
                editor.grabHorizontal  = true
                editor.grabVertical = true
                editor.setEditor(pathSelectionButton, item, cell.columnIndex)
                editor.layout()
            }

            override dispose(ColumnViewer viewer, ViewerColumn column) {
                PATH_SELECTION_BUTTONS.values.forEach[dispose]
                super.dispose()
            }
        }
    }

    /**
     * Open the file selection dialog for specifying a Genlet's path. The method returns the path to
     * the Genlet as a String or null in case the user aborted the file selection.
     */
    private def pathSelectionDialog() {
        val dialog = new FileDialog(parent.shell, SWT.OPEN)
        dialog.text = "Select a Genlet"
        dialog.filterExtensions = #["*.jar"]
        return dialog.open
    }

    /**
     * Create the button row below the table
     */
    private def createButtonRow() {
        val buttonRow = new Composite(parent, SWT.NONE)
        buttonRow.layout = new RowLayout
        createNewButton(buttonRow)
        createRemoveButton(buttonRow)
        createMoveUpButton(buttonRow)
        createMoveDownButton(buttonRow)
    }

    /**
     * Create button for the specification of a new Genlet
     */
    private def createNewButton(Composite parent) {
        newButton = new Button(parent, SWT.PUSH)
        newButton.image = NEW_IMAGE
        newButton.addListener(SWT.Selection, [
            if (viewer.input === null)
                viewer.input = <Argument>newArrayList

            val newArgument = Argument.newArgument
                .singleValued
                .file
                .parameter(JavaBaseGeneratorParameters.GENLET_PARAMETER)
                .value("")
            currentArguments.add(newArgument)
            viewer.input = currentArguments.get

            // Immediately open file selection dialog for convenience in specifying the new Genlet
            val selectedPath = pathSelectionDialog()
            if (selectedPath !== null) {
                newArgument.value = selectedPath
                viewer.update(newArgument, null)
            }
        ])
    }

    /**
     * Create button for Genlet removal
     */
    private def createRemoveButton(Composite parent) {
        removeButton = new Button(parent, SWT.PUSH)
        removeButton.image = REMOVE_IMAGE
        removeButton.addListener(SWT.Selection, [
            if (viewer.input === null) {
                return
            }

            val selectedArguments = rowSelectionOrError(viewer)
            if (selectedArguments !== null) {
                currentArguments.removeAll(selectedArguments.map[it as Argument].toList)
                selectedArguments.forEach[PATH_SELECTION_BUTTONS.remove(it)?.dispose()]
                viewer.input = currentArguments.get
            }
        ])
    }

    /**
     * Create button to move Genlet up in the table
     */
    private def createMoveUpButton(Composite parent) {
        moveUpButton = new Button(parent, SWT.PUSH)
        moveUpButton.image = MOVE_UP_IMAGE
        moveUpButton.addListener(SWT.Selection, [
            if (viewer.input === null) {
                return
            }

            val selectedArgument = singleRowSelectionOrError(viewer)?.firstElement as Argument
            if (selectedArgument !== null) {
                currentArguments.moveUp(selectedArgument)
                viewer.input = currentArguments.get
            }
        ])
    }

    /**
     * Create button to move Genlet down in the table
     */
    private def createMoveDownButton(Composite parent) {
        moveDownButton = new Button(parent, SWT.PUSH)
        moveDownButton.image = MOVE_DOWN_IMAGE
        moveDownButton.addListener(SWT.Selection, [
            if (viewer.input === null) {
                return
            }

            val selectedArgument = singleRowSelectionOrError(viewer)?.firstElement as Argument
            if (selectedArgument !== null) {
                currentArguments.moveDown(selectedArgument)
                viewer.input = currentArguments.get
            }
        ])
    }

    /**
     * Get all Argument instances created for the Genlets in the table
     */
    final def getGenletArguments() {
        return currentArguments.get
    }

    /**
     * Add property change listener for Genlet-specific Argument instances
     */
    final def void addPropertyChangeListener(PropertyChangeListener listener) {
        currentArguments.addPropertyChangeListener(listener)
    }

    /**
     * Remove property change listener for Genlet-specific Argument instances
     */
    final def void removePropertyChangeListener(PropertyChangeListener listener) {
        currentArguments.removePropertyChangeListener(listener)
    }

    /**
     * Dispose the table
     */
    final def dispose() {
        dataBindingContext.dispose
        newButton.dispose
        removeButton.dispose
        moveUpButton.dispose
        moveDownButton.dispose
        viewer.control.dispose
        parent.dispose
    }
}