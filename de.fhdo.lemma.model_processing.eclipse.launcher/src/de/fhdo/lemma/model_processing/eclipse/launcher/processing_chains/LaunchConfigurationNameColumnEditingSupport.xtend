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
import java.util.List
import org.eclipse.core.databinding.UpdateValueStrategy
import de.fhdo.lemma.model_processing.eclipse.launcher.ui.UpdatingColumnViewerEditorActivationListener

/**
 * Observable value-editing support for the column of model processing configurations in the launch
 * configuration tab of model processing chain configurations.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class LaunchConfigurationNameColumnEditingSupport
    extends ObservableValueEditingSupport<ProcessingChainEntry, String, String> {
    var TableViewer tableViewer
    var DataBindingContext dataBindingContext
    val List<String> launchConfigurationNames

    /**
     * Constructor
     */
    new(TableViewer tableViewer, DataBindingContext dataBindingContext,
        List<String> launchConfigurationNames) {
        super(tableViewer, dataBindingContext)
        this.tableViewer = tableViewer
        this.dataBindingContext = dataBindingContext
        this.launchConfigurationNames = launchConfigurationNames

        tableViewer.columnViewerEditor.addEditorActivationListener(
            new UpdatingColumnViewerEditorActivationListener(tableViewer)
        )
    }

    /**
     * Return the column's CellEditor
     */
    final override getCellEditor(Object element) {
        return new ComboBoxCellEditor(tableViewer.table, launchConfigurationNames,
            SWT.DROP_DOWN.bitwiseOr(SWT.READ_ONLY))
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
        return BeanProperties.value(ProcessingChainEntry, "launchConfigurationName", null)
            .observe(entry)
    }

    /**
     * Bind the CellEditor's and Bean element's IObservableValues
     */
    final override createBinding(IObservableValue<String> target, IObservableValue<String> model) {
        return dataBindingContext.bindValue(target, model,
            new UpdateValueStrategy(UpdateValueStrategy.POLICY_UPDATE), null)
    }
}