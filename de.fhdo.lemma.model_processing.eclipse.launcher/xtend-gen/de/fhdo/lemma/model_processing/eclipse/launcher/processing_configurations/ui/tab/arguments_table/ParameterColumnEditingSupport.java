package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ui.tab.arguments_table;

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.typed.BeanProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.typed.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ObservableValueEditingSupport;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;

/**
 * Observable value-editing support for the parameter column in the arguments table.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class ParameterColumnEditingSupport extends ObservableValueEditingSupport<Argument, String, String> {
  private final ArgumentsTable argumentsTable;
  
  private DataBindingContext dataBindingContext;
  
  /**
   * Constructor
   */
  public ParameterColumnEditingSupport(final ArgumentsTable argumentsTable, final DataBindingContext dataBindingContext) {
    super(argumentsTable.getViewer(), dataBindingContext);
    this.argumentsTable = argumentsTable;
    this.dataBindingContext = dataBindingContext;
  }
  
  /**
   * Enable/disable column editing
   */
  @Override
  public final boolean canEdit(final Object element) {
    return this.argumentsTable.getEnabled();
  }
  
  /**
   * Return the column's CellEditor
   */
  @Override
  public final CellEditor getCellEditor(final Object element) {
    Table _table = this.argumentsTable.getViewer().getTable();
    return new TextCellEditor(_table);
  }
  
  /**
   * Return the IObservableValue of the column's CellEditor
   */
  @Override
  public final IObservableValue<String> doCreateCellEditorObservable(final CellEditor editor) {
    return WidgetProperties.<Control>text(SWT.Modify).observe(editor.getControl());
  }
  
  /**
   * Return the IObservableValue of the Bean element
   */
  @Override
  public final IObservableValue<String> doCreateElementObservable(final Argument argument, final ViewerCell cell) {
    return BeanProperties.<Argument, String>value(Argument.class, "parameter", null).observe(argument);
  }
  
  /**
   * Bind the CellEditor's and Bean element's IObservableValues
   */
  @Override
  public final Binding createBinding(final IObservableValue<String> target, final IObservableValue<String> model) {
    UpdateValueStrategy<String, String> _updateValueStrategy = new UpdateValueStrategy<String, String>(UpdateValueStrategy.POLICY_UPDATE);
    return this.dataBindingContext.<String, String>bindValue(target, model, _updateValueStrategy, null);
  }
}
