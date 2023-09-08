package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.shortcut.java_base_generator;

import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils;
import de.fhdo.lemma.model_processing.eclipse.launcher.Utils;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Arguments;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AbstractArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.FileArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.ui.ValidatingColumnLabelProvider;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.typed.BeanProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.typed.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ObservableValueEditingSupport;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Table for Genlet specification in template completion dialogs targeting the Java Base Generator.
 * Note that each Genlet is effectively backed by an Argument that points to the Genlet in generator
 * executions.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class GenletsTable {
  /**
   * Editing support for the Genlet path column
   */
  private static class PathColumnEditingSupport extends ObservableValueEditingSupport<Argument, String, String> {
    private final GenletsTable genletsTable;

    private DataBindingContext dataBindingContext;

    /**
     * Constructor
     */
    public PathColumnEditingSupport(final GenletsTable genletsTable, final DataBindingContext dataBindingContext) {
      super(genletsTable.viewer, dataBindingContext);
      this.genletsTable = genletsTable;
      this.dataBindingContext = dataBindingContext;
    }

    /**
     * Get cell editor
     */
    @Override
    public CellEditor getCellEditor(final Object element) {
      Table _table = this.genletsTable.viewer.getTable();
      return new TextCellEditor(_table);
    }

    /**
     * Create the observable for the cell editor control
     */
    @Override
    public IObservableValue<String> doCreateCellEditorObservable(final CellEditor cellEditor) {
      return WidgetProperties.<Control>text(SWT.Modify).observe(cellEditor.getControl());
    }

    /**
     * Create the observable for the element value
     */
    @Override
    public IObservableValue<String> doCreateElementObservable(final Argument argument, final ViewerCell cell) {
      return BeanProperties.<Argument, String>value(Argument.class, "value", null).observe(argument);
    }

    /**
     * Bind the observable for the element value to the observable for the cell editor control
     */
    @Override
    public Binding createBinding(final IObservableValue<String> target, final IObservableValue<String> model) {
      UpdateValueStrategy<String, String> _updateValueStrategy = new UpdateValueStrategy<String, String>(UpdateValueStrategy.POLICY_UPDATE);
      return this.dataBindingContext.<String, String>bindValue(target, model, _updateValueStrategy, null);
    }
  }

  private static final LocalResourceManager RESOURCE_MANAGER = new LocalResourceManager(JFaceResources.getResources());

  private static final Image NEW_IMAGE = LemmaUiUtils.createImage(GenletsTable.RESOURCE_MANAGER, GenletsTable.class, "add.gif");

  private static final Image REMOVE_IMAGE = LemmaUiUtils.createImage(GenletsTable.RESOURCE_MANAGER, GenletsTable.class, "remove.png");

  private static final Image MOVE_UP_IMAGE = LemmaUiUtils.createImage(GenletsTable.RESOURCE_MANAGER, GenletsTable.class, 
    "moveUp.png");

  private static final Image MOVE_DOWN_IMAGE = LemmaUiUtils.createImage(GenletsTable.RESOURCE_MANAGER, GenletsTable.class, 
    "moveDown.png");

  private static final HashMap<Argument, Button> PATH_SELECTION_BUTTONS = CollectionLiterals.<Argument, Button>newHashMap();

  private final Composite parent;

  private final ProcessingConfiguration processingConfiguration;

  private final TableViewer viewer;

  private final Arguments currentArguments = new Arguments(CollectionLiterals.<Argument>newArrayList());

  private final DataBindingContext dataBindingContext = new DataBindingContext();

  private Button newButton;

  private Button removeButton;

  private Button moveUpButton;

  private Button moveDownButton;

  /**
   * Constructor
   */
  public GenletsTable(final Composite parent, final ProcessingConfiguration processingConfiguration) {
    this.parent = parent;
    this.processingConfiguration = processingConfiguration;
    TableViewer _tableViewer = new TableViewer(parent);
    this.viewer = _tableViewer;
    ColumnViewerToolTipSupport.enableFor(this.viewer);
    this.viewer.setContentProvider(new IStructuredContentProvider() {
      @Override
      public Object[] getElements(final Object inputElement) {
        return ((Object[])Conversions.unwrapArray(GenletsTable.this.currentArguments.get(), Object.class));
      }
    });
    Table _table = this.viewer.getTable();
    _table.setHeaderVisible(true);
    Table _table_1 = this.viewer.getTable();
    _table_1.setLinesVisible(true);
    Table _table_2 = this.viewer.getTable();
    GridData _gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
    _table_2.setLayoutData(_gridData);
    this.createPathColumn();
    this.createPathSelectionColumn();
    this.createButtonRow();
  }

  /**
   * Create the column for specifying the path to a Genlet's JAR archive
   */
  private void createPathColumn() {
    final TableViewerColumn pathColumn = new TableViewerColumn(this.viewer, SWT.NONE);
    TableColumn _column = pathColumn.getColumn();
    _column.setWidth(730);
    TableColumn _column_1 = pathColumn.getColumn();
    _column_1.setText("Genlet");
    pathColumn.setLabelProvider(new ValidatingColumnLabelProvider<Argument>() {
      @Override
      public String getElementText(final Argument element) {
        return element.getValue();
      }

      @Override
      public void validate(final Argument element) {
        AbstractArgumentType _type = element.getType();
        final FileArgumentType type = ((FileArgumentType) _type);
        type.validateValueInUserRepresentation(GenletsTable.this.processingConfiguration, element.getValue());
      }
    });
    GenletsTable.PathColumnEditingSupport _pathColumnEditingSupport = new GenletsTable.PathColumnEditingSupport(this, this.dataBindingContext);
    pathColumn.setEditingSupport(_pathColumnEditingSupport);
  }

  /**
   * Create the column with the button for supporting the specification of the path to a Genlet's
   * JAR archive via a file selection dialog
   */
  private void createPathSelectionColumn() {
    final TableViewerColumn pathSelectionColumn = new TableViewerColumn(this.viewer, SWT.NONE);
    TableColumn _column = pathSelectionColumn.getColumn();
    _column.setWidth(20);
    pathSelectionColumn.setLabelProvider(new ColumnLabelProvider() {
      @Override
      public void update(final ViewerCell cell) {
        Object _element = cell.getElement();
        final Argument argument = ((Argument) _element);
        Button _get = GenletsTable.PATH_SELECTION_BUTTONS.get(argument);
        if (_get!=null) {
          _get.dispose();
        }
        Control _control = GenletsTable.this.viewer.getControl();
        final Button pathSelectionButton = new Button(((Composite) _control), SWT.NONE);
        GridData _gridData = new GridData(SWT.CENTER, SWT.FILL, false, true);
        pathSelectionButton.setLayoutData(_gridData);
        pathSelectionButton.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_CONTENT_PROPOSAL).getImage());
        final Listener _function = (Event it) -> {
          final String selectedPath = GenletsTable.this.pathSelectionDialog();
          if ((selectedPath != null)) {
            argument.setValue(selectedPath);
            GenletsTable.this.viewer.update(argument, null);
          }
        };
        pathSelectionButton.addListener(SWT.Selection, _function);
        GenletsTable.PATH_SELECTION_BUTTONS.put(argument, pathSelectionButton);
        Widget _item = cell.getItem();
        final TableItem item = ((TableItem) _item);
        Table _parent = item.getParent();
        final TableEditor editor = new TableEditor(_parent);
        editor.grabHorizontal = true;
        editor.grabVertical = true;
        editor.setEditor(pathSelectionButton, item, cell.getColumnIndex());
        editor.layout();
      }

      @Override
      public void dispose(final ColumnViewer viewer, final ViewerColumn column) {
        final Consumer<Button> _function = (Button it) -> {
          it.dispose();
        };
        GenletsTable.PATH_SELECTION_BUTTONS.values().forEach(_function);
        super.dispose();
      }
    });
  }

  /**
   * Open the file selection dialog for specifying a Genlet's path. The method returns the path to
   * the Genlet as a String or null in case the user aborted the file selection.
   */
  private String pathSelectionDialog() {
    Shell _shell = this.parent.getShell();
    final FileDialog dialog = new FileDialog(_shell, SWT.OPEN);
    dialog.setText("Select a Genlet");
    dialog.setFilterExtensions(new String[] { "*.jar" });
    return dialog.open();
  }

  /**
   * Create the button row below the table
   */
  private void createButtonRow() {
    final Composite buttonRow = new Composite(this.parent, SWT.NONE);
    RowLayout _rowLayout = new RowLayout();
    buttonRow.setLayout(_rowLayout);
    this.createNewButton(buttonRow);
    this.createRemoveButton(buttonRow);
    this.createMoveUpButton(buttonRow);
    this.createMoveDownButton(buttonRow);
  }

  /**
   * Create button for the specification of a new Genlet
   */
  private void createNewButton(final Composite parent) {
    Button _button = new Button(parent, SWT.PUSH);
    this.newButton = _button;
    this.newButton.setImage(GenletsTable.NEW_IMAGE);
    final Listener _function = (Event it) -> {
      Object _input = this.viewer.getInput();
      boolean _tripleEquals = (_input == null);
      if (_tripleEquals) {
        this.viewer.setInput(CollectionLiterals.<Argument>newArrayList());
      }
      final Argument newArgument = Argument.newArgument().singleValued().file().parameter(JavaBaseGeneratorParameters.GENLET_PARAMETER).value("");
      this.currentArguments.add(newArgument);
      this.viewer.setInput(this.currentArguments.get());
      final String selectedPath = this.pathSelectionDialog();
      if ((selectedPath != null)) {
        newArgument.setValue(selectedPath);
        this.viewer.update(newArgument, null);
      }
    };
    this.newButton.addListener(SWT.Selection, _function);
  }

  /**
   * Create button for Genlet removal
   */
  private void createRemoveButton(final Composite parent) {
    Button _button = new Button(parent, SWT.PUSH);
    this.removeButton = _button;
    this.removeButton.setImage(GenletsTable.REMOVE_IMAGE);
    final Listener _function = (Event it) -> {
      Object _input = this.viewer.getInput();
      boolean _tripleEquals = (_input == null);
      if (_tripleEquals) {
        return;
      }
      final IStructuredSelection selectedArguments = Utils.rowSelectionOrError(this.viewer);
      if ((selectedArguments != null)) {
        final Function1<Object, Argument> _function_1 = (Object it_1) -> {
          return ((Argument) it_1);
        };
        this.currentArguments.removeAll(IterableExtensions.<Argument>toList(IterableExtensions.<Object, Argument>map(selectedArguments, _function_1)));
        final Consumer<Object> _function_2 = (Object it_1) -> {
          Button _remove = GenletsTable.PATH_SELECTION_BUTTONS.remove(it_1);
          if (_remove!=null) {
            _remove.dispose();
          }
        };
        selectedArguments.forEach(_function_2);
        this.viewer.setInput(this.currentArguments.get());
      }
    };
    this.removeButton.addListener(SWT.Selection, _function);
  }

  /**
   * Create button to move Genlet up in the table
   */
  private void createMoveUpButton(final Composite parent) {
    Button _button = new Button(parent, SWT.PUSH);
    this.moveUpButton = _button;
    this.moveUpButton.setImage(GenletsTable.MOVE_UP_IMAGE);
    final Listener _function = (Event it) -> {
      Object _input = this.viewer.getInput();
      boolean _tripleEquals = (_input == null);
      if (_tripleEquals) {
        return;
      }
      IStructuredSelection _singleRowSelectionOrError = Utils.singleRowSelectionOrError(this.viewer);
      Object _firstElement = null;
      if (_singleRowSelectionOrError!=null) {
        _firstElement=_singleRowSelectionOrError.getFirstElement();
      }
      final Argument selectedArgument = ((Argument) _firstElement);
      if ((selectedArgument != null)) {
        this.currentArguments.moveUp(selectedArgument);
        this.viewer.setInput(this.currentArguments.get());
      }
    };
    this.moveUpButton.addListener(SWT.Selection, _function);
  }

  /**
   * Create button to move Genlet down in the table
   */
  private void createMoveDownButton(final Composite parent) {
    Button _button = new Button(parent, SWT.PUSH);
    this.moveDownButton = _button;
    this.moveDownButton.setImage(GenletsTable.MOVE_DOWN_IMAGE);
    final Listener _function = (Event it) -> {
      Object _input = this.viewer.getInput();
      boolean _tripleEquals = (_input == null);
      if (_tripleEquals) {
        return;
      }
      IStructuredSelection _singleRowSelectionOrError = Utils.singleRowSelectionOrError(this.viewer);
      Object _firstElement = null;
      if (_singleRowSelectionOrError!=null) {
        _firstElement=_singleRowSelectionOrError.getFirstElement();
      }
      final Argument selectedArgument = ((Argument) _firstElement);
      if ((selectedArgument != null)) {
        this.currentArguments.moveDown(selectedArgument);
        this.viewer.setInput(this.currentArguments.get());
      }
    };
    this.moveDownButton.addListener(SWT.Selection, _function);
  }

  /**
   * Get all Argument instances created for the Genlets in the table
   */
  public final List<Argument> getGenletArguments() {
    return this.currentArguments.get();
  }

  /**
   * Add property change listener for Genlet-specific Argument instances
   */
  public final void addPropertyChangeListener(final PropertyChangeListener listener) {
    this.currentArguments.addPropertyChangeListener(listener);
  }

  /**
   * Remove property change listener for Genlet-specific Argument instances
   */
  public final void removePropertyChangeListener(final PropertyChangeListener listener) {
    this.currentArguments.removePropertyChangeListener(listener);
  }

  /**
   * Dispose the table
   */
  public final void dispose() {
    this.dataBindingContext.dispose();
    this.newButton.dispose();
    this.removeButton.dispose();
    this.moveUpButton.dispose();
    this.moveDownButton.dispose();
    this.viewer.getControl().dispose();
    this.parent.dispose();
  }
}
