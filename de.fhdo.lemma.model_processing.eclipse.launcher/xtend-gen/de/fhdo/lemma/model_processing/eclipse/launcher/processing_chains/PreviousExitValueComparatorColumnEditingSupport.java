package de.fhdo.lemma.model_processing.eclipse.launcher.processing_chains;

import de.fhdo.lemma.model_processing.eclipse.launcher.ui.UpdatingColumnViewerEditorActivationListener;
import java.util.Set;
import java.util.function.Function;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.typed.BeanProperties;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.typed.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ObservableValueEditingSupport;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.xtext.xbase.lib.Conversions;

/**
 * Observable value-editing support for the column of previous exit value comparators in the launch
 * configuration tab of model processing chain configurations.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class PreviousExitValueComparatorColumnEditingSupport extends ObservableValueEditingSupport<ProcessingChainEntry, PreviousExitValueComparator.Comparator, String> {
  private TableViewer tableViewer;
  
  private DataBindingContext dataBindingContext;
  
  /**
   * Constructor
   */
  public PreviousExitValueComparatorColumnEditingSupport(final TableViewer tableViewer, final DataBindingContext dataBindingContext) {
    super(tableViewer, dataBindingContext);
    this.tableViewer = tableViewer;
    this.dataBindingContext = dataBindingContext;
    ColumnViewerEditor _columnViewerEditor = tableViewer.getColumnViewerEditor();
    UpdatingColumnViewerEditorActivationListener _updatingColumnViewerEditorActivationListener = new UpdatingColumnViewerEditorActivationListener(tableViewer);
    _columnViewerEditor.addEditorActivationListener(_updatingColumnViewerEditorActivationListener);
  }
  
  /**
   * Return the column's CellEditor
   */
  @Override
  public final CellEditor getCellEditor(final Object element) {
    Table _table = this.tableViewer.getTable();
    Set<String> _userRepresentationValues = PreviousExitValueComparator.getUserRepresentationValues();
    return new ComboBoxCellEditor(_table, ((String[])Conversions.unwrapArray(_userRepresentationValues, String.class)), 
      (SWT.DROP_DOWN | SWT.READ_ONLY));
  }
  
  /**
   * Return the IObservableValue of the column's CellEditor
   */
  @Override
  public final IObservableValue<String> doCreateCellEditorObservable(final CellEditor editor) {
    Control _control = editor.getControl();
    return WidgetProperties.ccomboSelection().observe(((CCombo) _control));
  }
  
  /**
   * Return the IObservableValue of the Bean element
   */
  @Override
  public final IObservableValue<PreviousExitValueComparator.Comparator> doCreateElementObservable(final ProcessingChainEntry entry, final ViewerCell cell) {
    return BeanProperties.<ProcessingChainEntry, PreviousExitValueComparator.Comparator>value(ProcessingChainEntry.class, "previousExitValueComparator", null).observe(entry);
  }
  
  /**
   * Bind the CellEditor's and Bean element's IObservableValues
   */
  @Override
  public final Binding createBinding(final IObservableValue<String> target, final IObservableValue<PreviousExitValueComparator.Comparator> model) {
    final UpdateValueStrategy<PreviousExitValueComparator.Comparator, String> modelToTargetConverter = new UpdateValueStrategy<PreviousExitValueComparator.Comparator, String>();
    final Function<PreviousExitValueComparator.Comparator, String> _function = (PreviousExitValueComparator.Comparator it) -> {
      return PreviousExitValueComparator.getUserRepresentation(it);
    };
    modelToTargetConverter.setConverter(IConverter.<PreviousExitValueComparator.Comparator, String>create(_function));
    final UpdateValueStrategy<String, PreviousExitValueComparator.Comparator> targetToModelConverter = new UpdateValueStrategy<String, PreviousExitValueComparator.Comparator>();
    final Function<String, PreviousExitValueComparator.Comparator> _function_1 = (String it) -> {
      return PreviousExitValueComparator.getInternalRepresentation(it);
    };
    targetToModelConverter.setConverter(IConverter.<String, PreviousExitValueComparator.Comparator>create(_function_1));
    return this.dataBindingContext.<String, PreviousExitValueComparator.Comparator>bindValue(target, model, targetToModelConverter, modelToTargetConverter);
  }
  
  /**
   * Enable column-editing
   */
  @Override
  public final boolean canEdit(final Object element) {
    return ((ProcessingChainEntry) element).isEditable();
  }
}
