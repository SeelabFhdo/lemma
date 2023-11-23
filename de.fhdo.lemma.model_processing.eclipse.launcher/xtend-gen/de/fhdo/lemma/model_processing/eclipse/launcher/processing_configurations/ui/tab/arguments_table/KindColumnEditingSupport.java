package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ui.tab.arguments_table;

import com.google.common.base.Objects;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.AbstractArgumentKind;
import java.util.EventObject;
import java.util.List;
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
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationListener;
import org.eclipse.jface.viewers.ColumnViewerEditorDeactivationEvent;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Observable value-editing support for the kind column in the arguments table.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class KindColumnEditingSupport extends ObservableValueEditingSupport<Argument, AbstractArgumentKind, String> {
  /**
   * Editor activation listener that resets all argument properties when a new argument kind was
   * selected
   */
  private static class EditorActivationListener extends ColumnViewerEditorActivationListener {
    private final ArgumentsTable argumentsTable;

    private AbstractArgumentKind currentArgumentKind;

    /**
     * Constructor
     */
    public EditorActivationListener(final ArgumentsTable argumentsTable) {
      this.argumentsTable = argumentsTable;
    }

    /**
     * React to the begin of an editor's activation
     */
    @Override
    public final void beforeEditorActivated(final ColumnViewerEditorActivationEvent event) {
      this.currentArgumentKind = this.getArgumentKind(event);
    }

    /**
     * Get the AbstractArgumentKind instance from the given editor activation event
     */
    private AbstractArgumentKind getArgumentKind(final EventObject event) {
      Object _source = event.getSource();
      final ViewerCell cell = ((ViewerCell) _source);
      Object _element = cell.getElement();
      return ((Argument) _element).getKind();
    }

    /**
     * React to the end of an editor's deactivation
     */
    @Override
    public final void afterEditorDeactivated(final ColumnViewerEditorDeactivationEvent event) {
      AbstractArgumentKind _argumentKind = this.getArgumentKind(event);
      boolean _equals = Objects.equal(_argumentKind, this.currentArgumentKind);
      if (_equals) {
        return;
      }
      Object _source = event.getSource();
      final ViewerCell cell = ((ViewerCell) _source);
      Object _element = cell.getElement();
      final Argument argument = ((Argument) _element);
      argument.setType(argument.getKind().getAlphabeticallyFirstSupportedArgumentType());
      argument.setParameter("");
      argument.setValue("");
      this.argumentsTable.getViewer().update(argument, null);
    }

    @Override
    public void afterEditorActivated(final ColumnViewerEditorActivationEvent event) {
    }

    @Override
    public void beforeEditorDeactivated(final ColumnViewerEditorDeactivationEvent event) {
    }
  }

  private final ArgumentsTable argumentsTable;

  private DataBindingContext dataBindingContext;

  private List<AbstractArgumentKind> supportedArgumentKinds;

  private List<String> supportedArgumentKindsNames;

  /**
   * Constructor
   */
  public KindColumnEditingSupport(final ArgumentsTable argumentsTable, final DataBindingContext dataBindingContext, final List<AbstractArgumentKind> supportedArgumentKinds) {
    super(argumentsTable.getViewer(), dataBindingContext);
    this.argumentsTable = argumentsTable;
    this.dataBindingContext = dataBindingContext;
    final Function1<AbstractArgumentKind, String> _function = (AbstractArgumentKind it) -> {
      return it.getName();
    };
    this.supportedArgumentKinds = IterableExtensions.<AbstractArgumentKind, String>sortBy(supportedArgumentKinds, _function);
    final Function1<AbstractArgumentKind, String> _function_1 = (AbstractArgumentKind it) -> {
      return it.getName();
    };
    this.supportedArgumentKindsNames = ListExtensions.<AbstractArgumentKind, String>map(supportedArgumentKinds, _function_1);
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
    return new ComboBoxCellEditor(_table, ((String[])Conversions.unwrapArray(this.supportedArgumentKindsNames, String.class)), 
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
  public final IObservableValue<AbstractArgumentKind> doCreateElementObservable(final Argument argument, final ViewerCell cell) {
    return BeanProperties.<Argument, AbstractArgumentKind>value(Argument.class, "kind", null).observe(argument);
  }

  /**
   * Bind the CellEditor's and Bean element's IObservableValues
   */
  @Override
  public final Binding createBinding(final IObservableValue<String> target, final IObservableValue<AbstractArgumentKind> model) {
    final UpdateValueStrategy<AbstractArgumentKind, String> modelToTargetConverter = new UpdateValueStrategy<AbstractArgumentKind, String>();
    final Function<AbstractArgumentKind, String> _function = (AbstractArgumentKind it) -> {
      return it.getName();
    };
    modelToTargetConverter.setConverter(IConverter.<AbstractArgumentKind, String>create(_function));
    final UpdateValueStrategy<String, AbstractArgumentKind> targetToModelConverter = new UpdateValueStrategy<String, AbstractArgumentKind>();
    final Function<Object, AbstractArgumentKind> _function_1 = (Object it) -> {
      return this.supportedArgumentKinds.get(this.supportedArgumentKindsNames.indexOf(it));
    };
    targetToModelConverter.setConverter(IConverter.<Object, AbstractArgumentKind>create(_function_1));
    return this.dataBindingContext.<String, AbstractArgumentKind>bindValue(target, model, targetToModelConverter, modelToTargetConverter);
  }
}
