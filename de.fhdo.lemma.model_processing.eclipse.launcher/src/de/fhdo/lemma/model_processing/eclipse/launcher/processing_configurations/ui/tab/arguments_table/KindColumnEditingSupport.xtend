package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ui.tab.arguments_table

import org.eclipse.jface.viewers.ComboBoxCellEditor
import org.eclipse.jface.databinding.swt.typed.WidgetProperties
import org.eclipse.swt.custom.CCombo
import org.eclipse.core.databinding.UpdateValueStrategy
import org.eclipse.core.databinding.conversion.IConverter
import java.util.List
import org.eclipse.jface.databinding.viewers.ObservableValueEditingSupport
import org.eclipse.jface.viewers.CellEditor
import org.eclipse.jface.viewers.ViewerCell
import org.eclipse.core.databinding.beans.typed.BeanProperties
import org.eclipse.core.databinding.observable.value.IObservableValue
import org.eclipse.swt.SWT
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.AbstractArgumentKind
import org.eclipse.jface.viewers.ColumnViewerEditorActivationListener
import org.eclipse.jface.viewers.ColumnViewerEditorDeactivationEvent
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent
import java.util.EventObject
import org.eclipse.core.databinding.DataBindingContext

/**
 * Observable value-editing support for the kind column in the arguments table.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class KindColumnEditingSupport
    extends ObservableValueEditingSupport<Argument, AbstractArgumentKind, String> {
    val ArgumentsTable argumentsTable
    var DataBindingContext dataBindingContext
    var List<AbstractArgumentKind> supportedArgumentKinds
    var List<String> supportedArgumentKindsNames

    /**
     * Constructor
     */
    new(ArgumentsTable argumentsTable, DataBindingContext dataBindingContext,
        List<AbstractArgumentKind> supportedArgumentKinds) {
        super(argumentsTable.viewer, dataBindingContext)
        this.argumentsTable = argumentsTable
        this.dataBindingContext = dataBindingContext
        this.supportedArgumentKinds = supportedArgumentKinds.sortBy[name]
        supportedArgumentKindsNames = supportedArgumentKinds.map[name]
    }

    /**
     * Editor activation listener that resets all argument properties when a new argument kind was
     * selected
     */
    private static class EditorActivationListener extends ColumnViewerEditorActivationListener {
        val ArgumentsTable argumentsTable
        var AbstractArgumentKind currentArgumentKind

        /**
         * Constructor
         */
        new(ArgumentsTable argumentsTable) {
            this.argumentsTable = argumentsTable
        }

        /**
         * React to the begin of an editor's activation
         */
        final override beforeEditorActivated(ColumnViewerEditorActivationEvent event) {
            currentArgumentKind = event.argumentKind
        }

        /**
         * Get the AbstractArgumentKind instance from the given editor activation event
         */
        private def getArgumentKind(EventObject event) {
            val cell = event.source as ViewerCell
            return (cell.element as Argument).kind
        }

        /**
         * React to the end of an editor's deactivation
         */
        final override afterEditorDeactivated(ColumnViewerEditorDeactivationEvent event) {
            if (event.argumentKind == currentArgumentKind)
                return

            // Reset argument properties due to selection of a different argument kind
            val cell = event.source as ViewerCell
            val argument = cell.element as Argument
            argument.type = argument.kind.alphabeticallyFirstSupportedArgumentType
            argument.parameter = ""
            argument.value = ""
            argumentsTable.viewer.update(argument, null)
        }

        override afterEditorActivated(ColumnViewerEditorActivationEvent event) {
            // NOOP
        }

        override beforeEditorDeactivated(ColumnViewerEditorDeactivationEvent event) {
            // NOOP
        }
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
        return new ComboBoxCellEditor(argumentsTable.viewer.table, supportedArgumentKindsNames,
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
    final override doCreateElementObservable(Argument argument, ViewerCell cell) {
        return BeanProperties.value(Argument, "kind", null).observe(argument)
    }

    /**
     * Bind the CellEditor's and Bean element's IObservableValues
     */
    final override createBinding(IObservableValue<String> target,
        IObservableValue<AbstractArgumentKind> model) {
        val modelToTargetConverter = new UpdateValueStrategy<AbstractArgumentKind, String>()
        modelToTargetConverter.converter = IConverter.create([name])

        val targetToModelConverter = new UpdateValueStrategy<String, AbstractArgumentKind>()
        targetToModelConverter.converter = IConverter.create([
            supportedArgumentKinds.get(supportedArgumentKindsNames.indexOf(it))
        ])

        return dataBindingContext.bindValue(target, model, targetToModelConverter,
            modelToTargetConverter)
    }
}