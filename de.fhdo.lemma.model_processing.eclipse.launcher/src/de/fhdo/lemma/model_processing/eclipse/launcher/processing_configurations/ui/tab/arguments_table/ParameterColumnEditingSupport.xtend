package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ui.tab.arguments_table

import org.eclipse.jface.databinding.swt.typed.WidgetProperties
import org.eclipse.core.databinding.UpdateValueStrategy
import org.eclipse.jface.viewers.TextCellEditor
import org.eclipse.swt.SWT
import org.eclipse.jface.databinding.viewers.ObservableValueEditingSupport
import org.eclipse.jface.viewers.CellEditor
import org.eclipse.jface.viewers.ViewerCell
import org.eclipse.core.databinding.observable.value.IObservableValue
import org.eclipse.core.databinding.beans.typed.BeanProperties
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument
import org.eclipse.core.databinding.DataBindingContext

/**
 * Observable value-editing support for the parameter column in the arguments table.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class ParameterColumnEditingSupport
    extends ObservableValueEditingSupport<Argument, String, String> {
    val ArgumentsTable argumentsTable
    DataBindingContext dataBindingContext

    /**
     * Constructor
     */
    new(ArgumentsTable argumentsTable, DataBindingContext dataBindingContext) {
        super(argumentsTable.viewer, dataBindingContext)
        this.argumentsTable = argumentsTable
        this.dataBindingContext = dataBindingContext
    }

    /**
     * Enable/disable column editing
     */
    final override canEdit(Object element) {
        argumentsTable.enabled
    }

    /**
     * Return the column's CellEditor
     */
    final override getCellEditor(Object element) {
        return new TextCellEditor(argumentsTable.viewer.table)
    }

    /**
     * Return the IObservableValue of the column's CellEditor
     */
    final override doCreateCellEditorObservable(CellEditor editor) {
        return WidgetProperties.text(SWT.Modify).observe(editor.control)
    }

    /**
     * Return the IObservableValue of the Bean element
     */
    final override doCreateElementObservable(Argument argument, ViewerCell cell) {
        return BeanProperties.value(Argument, "parameter", null).observe(argument)
    }

    /**
     * Bind the CellEditor's and Bean element's IObservableValues
     */
    final override createBinding(IObservableValue<String> target,
        IObservableValue<String> model) {
        return dataBindingContext.bindValue(target, model,
            new UpdateValueStrategy(UpdateValueStrategy.POLICY_UPDATE), null)
    }
}