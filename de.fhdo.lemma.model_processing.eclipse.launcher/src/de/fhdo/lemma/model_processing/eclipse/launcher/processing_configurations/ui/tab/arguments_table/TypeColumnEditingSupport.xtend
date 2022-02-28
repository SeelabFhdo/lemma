package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ui.tab.arguments_table

import org.eclipse.jface.viewers.ComboBoxCellEditor
import org.eclipse.jface.databinding.swt.typed.WidgetProperties
import org.eclipse.swt.custom.CCombo
import org.eclipse.core.databinding.UpdateValueStrategy
import org.eclipse.core.databinding.conversion.IConverter
import org.eclipse.jface.databinding.viewers.ObservableValueEditingSupport
import org.eclipse.jface.viewers.CellEditor
import org.eclipse.jface.viewers.ViewerCell
import org.eclipse.core.databinding.beans.typed.BeanProperties
import org.eclipse.core.databinding.observable.value.IObservableValue
import org.eclipse.swt.SWT
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AbstractArgumentType
import java.util.List
import org.eclipse.jface.viewers.ColumnViewerEditorActivationListener
import org.eclipse.jface.viewers.ColumnViewerEditorDeactivationEvent
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent
import java.util.EventObject
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AbstractArgumentTypeWithEnumValueSelection
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelOfImportWithAliasArgumentType
import org.eclipse.core.databinding.DataBindingContext
import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*

/**
 * Observable value-editing support for the type column in the arguments table.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class TypeColumnEditingSupport
    extends ObservableValueEditingSupport<Argument, AbstractArgumentType, String> {
    val ArgumentsTable argumentsTable
    val DataBindingContext dataBindingContext
    var List<AbstractArgumentType> supportedArgumentTypes
    var List<String> supportedArgumentTypesNames

    /**
     * Constructor
     */
    new(ArgumentsTable argumentsTable, DataBindingContext dataBindingContext) {
        super(argumentsTable.viewer, dataBindingContext)
        this.argumentsTable = argumentsTable
        this.dataBindingContext = dataBindingContext
    }

    /**
     * Editor activation listener that resets an argument's parameter and value when a new argument
     * type was selected
     */
    private static class EditorActivationListener extends ColumnViewerEditorActivationListener {
        val ArgumentsTable argumentsTable
        var AbstractArgumentType currentArgumentType

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
            currentArgumentType = event.argumentType
        }

        /**
         * Get the AbstractArgumentType instance from the given editor activation event
         */
        private def getArgumentType(EventObject event) {
            val cell = event.source as ViewerCell
            return (cell.element as Argument).type
        }

        /**
         * React to the end of an editor's deactivation
         */
        final override afterEditorDeactivated(ColumnViewerEditorDeactivationEvent event) {
            if (event.argumentType == currentArgumentType)
                return

            // Reset argument parameter and value due to selection of a different argument type
            val cell = event.source as ViewerCell
            val argument = cell.element as Argument
            argument.parameter = ""

            // For argument types with predefined or literal values, select the first value as
            // default
            val argumentType = argument.type
            switch(argumentType) {
                AbstractArgumentTypeWithEnumValueSelection<?>: {
                    val items = argumentType.literalDescriptionsSorted
                    if (!items.empty)
                        argument.value = items.get(0)
                }

                IntermediateModelOfImportWithAliasArgumentType: {
                    try {
                        val configuration = argumentsTable.currentConfiguration
                        val transformableImports =
                            parseTransformableImportedModelsOfSourceModelFile(configuration)
                        val importAliases = transformableImports.map[it.value.alias].sort
                        if (!importAliases.empty)
                            argument.value = importAliases.get(0)
                    } catch (IllegalArgumentException ex) {
                        argument.value = ""
                    }
                }

                default:
                    argument.value = ""
            }

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
        supportedArgumentTypes = (element as Argument).kind.supportedArgumentTypes.sortBy[name]
        supportedArgumentTypesNames = supportedArgumentTypes.map[name]
        return new ComboBoxCellEditor(argumentsTable.viewer.table, supportedArgumentTypesNames,
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
        return BeanProperties.value(Argument, "type", null).observe(argument)
    }

    /**
     * Bind the CellEditor's and Bean element's IObservableValues
     */
    final override createBinding(IObservableValue<String> target,
        IObservableValue<AbstractArgumentType> model) {
        val modelToTargetConverter = new UpdateValueStrategy<AbstractArgumentType, String>()
        modelToTargetConverter.converter = IConverter.create([name])

        val targetToModelConverter = new UpdateValueStrategy<String, AbstractArgumentType>()
        targetToModelConverter.converter = IConverter.create([
            supportedArgumentTypes.get(supportedArgumentTypesNames.indexOf(it))
        ])

        return dataBindingContext.bindValue(target, model, targetToModelConverter,
            modelToTargetConverter)
    }
}