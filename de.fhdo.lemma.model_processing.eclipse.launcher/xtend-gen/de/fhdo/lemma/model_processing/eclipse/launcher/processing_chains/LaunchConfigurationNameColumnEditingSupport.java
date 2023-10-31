package de.fhdo.lemma.model_processing.eclipse.launcher.processing_chains;

import de.fhdo.lemma.model_processing.eclipse.launcher.ui.UpdatingColumnViewerEditorActivationListener;
import java.util.List;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.typed.BeanProperties;
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
 * Observable value-editing support for the column of model processing configurations in the launch
 * configuration tab of model processing chain configurations.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class LaunchConfigurationNameColumnEditingSupport extends ObservableValueEditingSupport<ProcessingChainEntry, String, String> {
  private TableViewer tableViewer;

  private DataBindingContext dataBindingContext;

  private final List<String> launchConfigurationNames;

  /**
   * Constructor
   */
  public LaunchConfigurationNameColumnEditingSupport(final TableViewer tableViewer, final DataBindingContext dataBindingContext, final List<String> launchConfigurationNames) {
    super(tableViewer, dataBindingContext);
    this.tableViewer = tableViewer;
    this.dataBindingContext = dataBindingContext;
    this.launchConfigurationNames = launchConfigurationNames;
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
    return new ComboBoxCellEditor(_table, ((String[])Conversions.unwrapArray(this.launchConfigurationNames, String.class)), 
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
  public final IObservableValue<String> doCreateElementObservable(final ProcessingChainEntry entry, final ViewerCell cell) {
    return BeanProperties.<ProcessingChainEntry, String>value(ProcessingChainEntry.class, "launchConfigurationName", null).observe(entry);
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
