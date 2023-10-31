package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ui.tab.arguments_table;

import de.fhdo.lemma.model_processing.eclipse.launcher.Utils;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AbstractArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AbstractArgumentTypeWithEnumValueSelection;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.FileArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.FolderArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelOfImportWithAliasArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.RawStringArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.StringPairArgumentType;
import java.util.List;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.typed.BeanProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.typed.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ObservableValueEditingSupport;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Observable value-editing support for the value column in the arguments table.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class ValueColumnEditingSupport extends ObservableValueEditingSupport<Argument, String, String> {
  private final ArgumentsTable argumentsTable;

  private DataBindingContext dataBindingContext;

  /**
   * Constructor
   */
  public ValueColumnEditingSupport(final ArgumentsTable argumentsTable, final DataBindingContext dataBindingContext) {
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
   * Return the column's CellEditor depending on the type of the edited argument
   */
  @Override
  public final CellEditor getCellEditor(final Object element) {
    final Argument argument = ((Argument) element);
    final AbstractArgumentType argumentType = argument.getType();
    CellEditor _switchResult = null;
    boolean _matched = false;
    if (argumentType instanceof FileArgumentType) {
      _matched=true;
    }
    if (!_matched) {
      if (argumentType instanceof FolderArgumentType) {
        _matched=true;
      }
    }
    if (!_matched) {
      if (argumentType instanceof StringPairArgumentType) {
        _matched=true;
      }
    }
    if (_matched) {
      Table _table = this.argumentsTable.getViewer().getTable();
      _switchResult = new TextCellEditor(_table);
    }
    if (!_matched) {
      if (argumentType instanceof AbstractArgumentTypeWithEnumValueSelection) {
        _matched=true;
        Table _table_1 = this.argumentsTable.getViewer().getTable();
        List<String> _literalDescriptionsSorted = ((AbstractArgumentTypeWithEnumValueSelection<?>)argumentType).getLiteralDescriptionsSorted();
        _switchResult = new ComboBoxCellEditor(_table_1, ((String[])Conversions.unwrapArray(_literalDescriptionsSorted, String.class)), 
          (SWT.DROP_DOWN | SWT.READ_ONLY));
      }
    }
    if (!_matched) {
      if (argumentType instanceof IntermediateModelOfImportWithAliasArgumentType) {
        _matched=true;
        ComboBoxCellEditor _xtrycatchfinallyexpression = null;
        try {
          ComboBoxCellEditor _xblockexpression = null;
          {
            final ProcessingConfiguration configuration = this.argumentsTable.getCurrentConfiguration();
            final List<Pair<Class<? extends EObject>, Utils.ImportInfo>> transformableImports = Utils.parseTransformableImportedModelsOfSourceModelFile(configuration);
            final Function1<Pair<Class<? extends EObject>, Utils.ImportInfo>, String> _function = (Pair<Class<? extends EObject>, Utils.ImportInfo> it) -> {
              return it.getValue().getAlias();
            };
            final List<String> importAliases = IterableExtensions.<String>sort(ListExtensions.<Pair<Class<? extends EObject>, Utils.ImportInfo>, String>map(transformableImports, _function));
            Table _table_1 = this.argumentsTable.getViewer().getTable();
            _xblockexpression = new ComboBoxCellEditor(_table_1, ((String[])Conversions.unwrapArray(importAliases, String.class)), 
              (SWT.DROP_DOWN | SWT.READ_ONLY));
          }
          _xtrycatchfinallyexpression = _xblockexpression;
        } catch (final Throwable _t) {
          if (_t instanceof IllegalArgumentException) {
            final IllegalArgumentException ex = (IllegalArgumentException)_t;
            ComboBoxCellEditor _xblockexpression_1 = null;
            {
              Table _table_1 = this.argumentsTable.getViewer().getTable();
              final ComboBoxCellEditor editor = new ComboBoxCellEditor(_table_1, new String[] {}, 
                (SWT.DROP_DOWN | SWT.READ_ONLY));
              Control _control = editor.getControl();
              final ControlDecoration decoration = new ControlDecoration(_control, 
                (SWT.TOP | SWT.LEFT));
              decoration.setDescriptionText(ex.getMessage());
              decoration.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR).getImage());
              decoration.show();
              _xblockexpression_1 = editor;
            }
            _xtrycatchfinallyexpression = _xblockexpression_1;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
        _switchResult = _xtrycatchfinallyexpression;
      }
    }
    if (!_matched) {
      if (argumentType instanceof RawStringArgumentType) {
        _matched=true;
        _switchResult = null;
      }
    }
    return _switchResult;
  }

  /**
   * Return the IObservableValue of the column's CellEditor
   */
  @Override
  public final IObservableValue<String> doCreateCellEditorObservable(final CellEditor editor) {
    ISWTObservableValue<String> _switchResult = null;
    boolean _matched = false;
    if (editor instanceof TextCellEditor) {
      _matched=true;
      _switchResult = WidgetProperties.<Control>text(SWT.Modify).observe(((TextCellEditor)editor).getControl());
    }
    if (!_matched) {
      if (editor instanceof ComboBoxCellEditor) {
        _matched=true;
        Control _control = ((ComboBoxCellEditor)editor).getControl();
        _switchResult = WidgetProperties.ccomboSelection().observe(((CCombo) _control));
      }
    }
    return _switchResult;
  }

  /**
   * Return the IObservableValue of the Bean element
   */
  @Override
  public final IObservableValue<String> doCreateElementObservable(final Argument argument, final ViewerCell cell) {
    return BeanProperties.<Argument, String>value(Argument.class, "value", null).observe(argument);
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
