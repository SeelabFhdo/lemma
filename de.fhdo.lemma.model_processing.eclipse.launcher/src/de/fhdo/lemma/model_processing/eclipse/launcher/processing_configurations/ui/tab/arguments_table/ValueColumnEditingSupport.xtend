package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ui.tab.arguments_table

import org.eclipse.jface.databinding.swt.typed.WidgetProperties
import org.eclipse.jface.viewers.TextCellEditor
import org.eclipse.swt.SWT

import org.eclipse.jface.viewers.ComboBoxCellEditor
import org.eclipse.swt.custom.CCombo
import org.eclipse.jface.databinding.viewers.ObservableValueEditingSupport
import org.eclipse.jface.viewers.CellEditor
import org.eclipse.jface.viewers.ViewerCell
import org.eclipse.core.databinding.observable.value.IObservableValue
import org.eclipse.core.databinding.beans.typed.BeanProperties
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.FileArgumentType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.FolderArgumentType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.RawStringArgumentType
import org.eclipse.core.databinding.UpdateValueStrategy
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.StringPairArgumentType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelOfImportWithAliasArgumentType
import org.eclipse.jface.fieldassist.ControlDecoration
import org.eclipse.jface.fieldassist.FieldDecorationRegistry
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AbstractArgumentTypeWithEnumValueSelection
import org.eclipse.core.databinding.DataBindingContext
import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*

/**
 * Observable value-editing support for the value column in the arguments table.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class ValueColumnEditingSupport
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
     * Return the column's CellEditor depending on the type of the edited argument
     */
    final override getCellEditor(Object element) {
        val argument = element as Argument
        val argumentType = argument.type

        return switch (argumentType) {
            FileArgumentType,
            FolderArgumentType,
            StringPairArgumentType:
                new TextCellEditor(argumentsTable.viewer.table)

            AbstractArgumentTypeWithEnumValueSelection<?>:
                new ComboBoxCellEditor(
                    argumentsTable.viewer.table,
                    argumentType.literalDescriptionsSorted,
                    SWT.DROP_DOWN.bitwiseOr(SWT.READ_ONLY)
                )

            IntermediateModelOfImportWithAliasArgumentType: {
                try {
                    val configuration = argumentsTable.currentConfiguration
                    val transformableImports =
                        parseTransformableImportedModelsOfSourceModelFile(configuration)
                    val importAliases = transformableImports.map[it.value.alias].sort
                    new ComboBoxCellEditor(argumentsTable.viewer.table, importAliases,
                        SWT.DROP_DOWN.bitwiseOr(SWT.READ_ONLY))
                } catch (IllegalArgumentException ex) {
                    val editor = new ComboBoxCellEditor(argumentsTable.viewer.table, #[],
                        SWT.DROP_DOWN.bitwiseOr(SWT.READ_ONLY))
                    val decoration = new ControlDecoration(editor.control,
                        SWT.TOP.bitwiseOr(SWT.LEFT))
                    decoration.descriptionText = ex.message
                    decoration.image = FieldDecorationRegistry
                        .^default
                        .getFieldDecoration(FieldDecorationRegistry.DEC_ERROR)
                        .image
                    decoration.show()
                    editor
                }
            }

            // Raw string arguments don't have a value but the given parameter is a positional
            // standalone parameter
            RawStringArgumentType:
                null
        }
    }

    /**
     * Return the IObservableValue of the column's CellEditor
     */
    final override doCreateCellEditorObservable(CellEditor editor) {
        return switch (editor) {
            TextCellEditor: WidgetProperties.text(SWT.Modify).observe(editor.control)
            ComboBoxCellEditor: WidgetProperties.ccomboSelection.observe(editor.control as CCombo)
        }
    }

    /**
     * Return the IObservableValue of the Bean element
     */
    final override doCreateElementObservable(Argument argument, ViewerCell cell) {
        return BeanProperties.value(Argument, "value", null).observe(argument)
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