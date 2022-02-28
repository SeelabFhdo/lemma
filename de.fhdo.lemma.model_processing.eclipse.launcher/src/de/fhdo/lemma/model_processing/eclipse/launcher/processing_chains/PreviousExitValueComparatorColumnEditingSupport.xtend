package de.fhdo.lemma.model_processing.eclipse.launcher.processing_chains

import org.eclipse.jface.databinding.viewers.ObservableValueEditingSupport
import org.eclipse.core.databinding.DataBindingContext
import org.eclipse.jface.viewers.TableViewer
import org.eclipse.jface.viewers.ComboBoxCellEditor
import org.eclipse.swt.SWT
import org.eclipse.jface.viewers.CellEditor
import org.eclipse.swt.custom.CCombo
import org.eclipse.jface.databinding.swt.typed.WidgetProperties
import org.eclipse.jface.viewers.ViewerCell
import org.eclipse.core.databinding.beans.typed.BeanProperties
import org.eclipse.core.databinding.observable.value.IObservableValue
import org.eclipse.core.databinding.UpdateValueStrategy
import org.eclipse.core.databinding.conversion.IConverter
import de.fhdo.lemma.model_processing.eclipse.launcher.ui.UpdatingColumnViewerEditorActivationListener

/**
 * Observable value-editing support for the column of previous exit value comparators in the launch
 * configuration tab of model processing chain configurations.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class PreviousExitValueComparatorColumnEditingSupport
    extends ObservableValueEditingSupport<
        ProcessingChainEntry, PreviousExitValueComparator.Comparator, String
    > {
    var TableViewer tableViewer
    var DataBindingContext dataBindingContext

    /**
     * Constructor
     */
    new(TableViewer tableViewer, DataBindingContext dataBindingContext) {
        super(tableViewer, dataBindingContext)
        this.tableViewer = tableViewer
        this.dataBindingContext = dataBindingContext

        tableViewer.columnViewerEditor.addEditorActivationListener(
            new UpdatingColumnViewerEditorActivationListener(tableViewer)
        )
    }

    /**
     * Return the column's CellEditor
     */
    final override getCellEditor(Object element) {
        return new ComboBoxCellEditor(
            tableViewer.table,
            PreviousExitValueComparator.userRepresentationValues,
            SWT.DROP_DOWN.bitwiseOr(SWT.READ_ONLY)
        )
    }

    /**
     * Return the IObservableValue of the column's CellEditor
     */
    final override doCreateCellEditorObservable(CellEditor editor) {
        return WidgetProperties.ccomboSelection.observe(editor.control as CCombo)
    }

    /**
     * Return the IObservableValue of the Bean element
     */
    final override doCreateElementObservable(ProcessingChainEntry entry, ViewerCell cell) {
        return BeanProperties.value(ProcessingChainEntry, "previousExitValueComparator", null)
            .observe(entry)
    }

    /**
     * Bind the CellEditor's and Bean element's IObservableValues
     */
    final override createBinding(IObservableValue<String> target,
        IObservableValue<PreviousExitValueComparator.Comparator> model) {
        val modelToTargetConverter
            = new UpdateValueStrategy<PreviousExitValueComparator.Comparator, String>()
        modelToTargetConverter.converter = IConverter.create([
            PreviousExitValueComparator.getUserRepresentation(it)
        ])

        val targetToModelConverter
            = new UpdateValueStrategy<String, PreviousExitValueComparator.Comparator>()
        targetToModelConverter.converter = IConverter.create([
            PreviousExitValueComparator.getInternalRepresentation(it)
        ])

        return dataBindingContext.bindValue(target, model, targetToModelConverter,
            modelToTargetConverter)
    }

    /**
     * Enable column-editing
     */
    final override canEdit(Object element) {
        return (element as ProcessingChainEntry).editable
    }
}