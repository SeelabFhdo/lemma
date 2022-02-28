package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ui.tab.arguments_table;

import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils;
import de.fhdo.lemma.model_processing.eclipse.launcher.Utils;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Arguments;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.AbstractArgumentKind;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.ArgumentKindFactory;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds.SingleValuedParameterArgumentKind;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AbstractArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.FileArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.FolderArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.ui.UpdatingColumnViewerEditorActivationListener;
import de.fhdo.lemma.model_processing.eclipse.launcher.ui.ValidatingColumnLabelProvider;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
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
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Table for argument specification in the model processing launch configuration tab.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class ArgumentsTable {
  private static final AbstractArgumentKind DEFAULT_ARGUMENT_KIND = ArgumentKindFactory.fromIdentifier(SingleValuedParameterArgumentKind.IDENTIFIER);
  
  private static final LocalResourceManager RESOURCE_MANAGER = new LocalResourceManager(JFaceResources.getResources());
  
  private static final Image NEW_IMAGE = LemmaUiUtils.createImage(ArgumentsTable.RESOURCE_MANAGER, ArgumentsTable.class, "add.gif");
  
  private static final Image REMOVE_IMAGE = LemmaUiUtils.createImage(ArgumentsTable.RESOURCE_MANAGER, ArgumentsTable.class, 
    "remove.png");
  
  private static final Image MOVE_UP_IMAGE = LemmaUiUtils.createImage(ArgumentsTable.RESOURCE_MANAGER, ArgumentsTable.class, 
    "moveUp.png");
  
  private static final Image MOVE_DOWN_IMAGE = LemmaUiUtils.createImage(ArgumentsTable.RESOURCE_MANAGER, ArgumentsTable.class, 
    "moveDown.png");
  
  private static final HashMap<Argument, Button> INPUT_SUPPORT_BUTTONS = CollectionLiterals.<Argument, Button>newHashMap();
  
  private final Composite parent;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final TableViewer viewer;
  
  private Button newButton;
  
  private Button removeButton;
  
  private Button moveUpButton;
  
  private Button moveDownButton;
  
  private final List<AbstractArgumentKind> supportedArgumentKinds;
  
  private final DataBindingContext dataBindingContext = new DataBindingContext();
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private boolean enabled = true;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private ProcessingConfiguration currentConfiguration;
  
  private Arguments currentArguments;
  
  private final Map<Class<? extends AbstractArgumentType>, Consumer<Argument>> ARGUMENT_VALUE_INPUT_SUPPORT = Collections.<Class<? extends AbstractArgumentType>, Consumer<Argument>>unmodifiableMap(CollectionLiterals.<Class<? extends AbstractArgumentType>, Consumer<Argument>>newHashMap(Pair.<Class<FileArgumentType>, Consumer<Argument>>of(FileArgumentType.class, new Consumer<Argument>() {
    @Override
    public void accept(final Argument argument) {
      Shell _activeShell = ArgumentsTable.this.viewer.getControl().getDisplay().getActiveShell();
      final FileDialog dialog = new FileDialog(_activeShell, SWT.OPEN);
      dialog.setText("Select a file");
      final String selectedFile = dialog.open();
      if ((selectedFile != null)) {
        argument.setValue(selectedFile);
      }
    }
  }), Pair.<Class<FolderArgumentType>, Consumer<Argument>>of(FolderArgumentType.class, new Consumer<Argument>() {
    @Override
    public void accept(final Argument argument) {
      Shell _activeShell = ArgumentsTable.this.viewer.getControl().getDisplay().getActiveShell();
      final DirectoryDialog dialog = new DirectoryDialog(_activeShell, SWT.OPEN);
      dialog.setText("Select a folder");
      final String selectedFolder = dialog.open();
      if ((selectedFolder != null)) {
        argument.setValue(selectedFolder);
      }
    }
  })));
  
  /**
   * Constructor
   */
  public ArgumentsTable(final Composite parent, final Set<AbstractArgumentKind> supportedArgumentKinds) {
    boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(supportedArgumentKinds);
    if (_isNullOrEmpty) {
      throw new IllegalArgumentException("Set of supported argument kinds must not be empty");
    }
    this.parent = parent;
    final Function1<AbstractArgumentKind, String> _function = (AbstractArgumentKind it) -> {
      return it.getName();
    };
    this.supportedArgumentKinds = IterableExtensions.<AbstractArgumentKind, String>sortBy(IterableExtensions.<AbstractArgumentKind>toList(supportedArgumentKinds), _function);
    TableViewer _tableViewer = new TableViewer(parent);
    this.viewer = _tableViewer;
    ColumnViewerToolTipSupport.enableFor(this.viewer);
    this.viewer.setContentProvider(new IStructuredContentProvider() {
      @Override
      public Object[] getElements(final Object inputElement) {
        return ((Object[])Conversions.unwrapArray(ArgumentsTable.this.currentArguments.get(), Object.class));
      }
    });
    Table _table = this.viewer.getTable();
    _table.setHeaderVisible(true);
    Table _table_1 = this.viewer.getTable();
    _table_1.setLinesVisible(true);
    Table _table_2 = this.viewer.getTable();
    GridData _gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
    _table_2.setLayoutData(_gridData);
    this.createKindColumn();
    this.createTypeColumn();
    this.createParameterColumn();
    this.createValueColumn();
    this.createInputSupportColumn();
    ColumnViewerEditor _columnViewerEditor = this.viewer.getColumnViewerEditor();
    UpdatingColumnViewerEditorActivationListener _updatingColumnViewerEditorActivationListener = new UpdatingColumnViewerEditorActivationListener(this.viewer);
    _columnViewerEditor.addEditorActivationListener(_updatingColumnViewerEditorActivationListener);
    this.createButtonRow();
  }
  
  /**
   * Create kind column
   */
  private void createKindColumn() {
    final TableViewerColumn kindColumn = new TableViewerColumn(this.viewer, SWT.NONE);
    TableColumn _column = kindColumn.getColumn();
    _column.setWidth(150);
    TableColumn _column_1 = kindColumn.getColumn();
    _column_1.setText("Kind");
    kindColumn.setLabelProvider(new ColumnLabelProvider() {
      @Override
      public String getText(final Object element) {
        return ((Argument) element).getKind().getName();
      }
    });
    KindColumnEditingSupport _kindColumnEditingSupport = new KindColumnEditingSupport(this, this.dataBindingContext, 
      this.supportedArgumentKinds);
    kindColumn.setEditingSupport(_kindColumnEditingSupport);
  }
  
  /**
   * Create type column
   */
  private void createTypeColumn() {
    final TableViewerColumn typeColumn = new TableViewerColumn(this.viewer, SWT.NONE);
    TableColumn _column = typeColumn.getColumn();
    _column.setWidth(200);
    TableColumn _column_1 = typeColumn.getColumn();
    _column_1.setText("Type");
    typeColumn.setLabelProvider(new ColumnLabelProvider() {
      @Override
      public String getText(final Object element) {
        return ((Argument) element).getType().getName();
      }
    });
    TypeColumnEditingSupport _typeColumnEditingSupport = new TypeColumnEditingSupport(this, this.dataBindingContext);
    typeColumn.setEditingSupport(_typeColumnEditingSupport);
  }
  
  /**
   * Create parameter column
   */
  private void createParameterColumn() {
    final TableViewerColumn parameterColumn = new TableViewerColumn(this.viewer, SWT.NONE);
    TableColumn _column = parameterColumn.getColumn();
    _column.setWidth(200);
    TableColumn _column_1 = parameterColumn.getColumn();
    _column_1.setText("Parameter");
    parameterColumn.setLabelProvider(new ValidatingColumnLabelProvider<Argument>() {
      @Override
      public String getElementText(final Argument element) {
        return element.getParameter();
      }
      
      @Override
      public void validate(final Argument element) {
        element.validateParameter();
      }
    });
    ParameterColumnEditingSupport _parameterColumnEditingSupport = new ParameterColumnEditingSupport(this, this.dataBindingContext);
    parameterColumn.setEditingSupport(_parameterColumnEditingSupport);
  }
  
  /**
   * Create value column
   */
  private void createValueColumn() {
    final TableViewerColumn valueColumn = new TableViewerColumn(this.viewer, SWT.NONE);
    TableColumn _column = valueColumn.getColumn();
    _column.setWidth(830);
    TableColumn _column_1 = valueColumn.getColumn();
    _column_1.setText("Value");
    valueColumn.setLabelProvider(new ValidatingColumnLabelProvider<Argument>() {
      @Override
      public String getElementText(final Argument element) {
        return element.getValue();
      }
      
      @Override
      public void validate(final Argument element) {
        element.getType().validateValueInUserRepresentation(ArgumentsTable.this.currentConfiguration, element.getValue());
      }
    });
    ValueColumnEditingSupport _valueColumnEditingSupport = new ValueColumnEditingSupport(this, this.dataBindingContext);
    valueColumn.setEditingSupport(_valueColumnEditingSupport);
  }
  
  /**
   * Create input support column
   */
  private void createInputSupportColumn() {
    final TableViewerColumn inputSupportColumn = new TableViewerColumn(this.viewer, SWT.NONE);
    TableColumn _column = inputSupportColumn.getColumn();
    _column.setWidth(20);
    inputSupportColumn.setLabelProvider(new ColumnLabelProvider() {
      @Override
      public void update(final ViewerCell cell) {
        Object _element = cell.getElement();
        final Argument argument = ((Argument) _element);
        Button _get = ArgumentsTable.INPUT_SUPPORT_BUTTONS.get(argument);
        if (_get!=null) {
          _get.dispose();
        }
        Control _control = ArgumentsTable.this.viewer.getControl();
        final Button inputSupportButton = ArgumentsTable.this.putInputSupportButtonIfProvided(ArgumentsTable.INPUT_SUPPORT_BUTTONS, 
          ((Composite) _control), argument);
        Widget _item = cell.getItem();
        final TableItem item = ((TableItem) _item);
        Table _parent = item.getParent();
        final TableEditor editor = new TableEditor(_parent);
        editor.grabHorizontal = true;
        editor.grabVertical = true;
        editor.setEditor(inputSupportButton, item, cell.getColumnIndex());
        editor.layout();
      }
      
      @Override
      public void dispose(final ColumnViewer viewer, final ViewerColumn column) {
        final Consumer<Button> _function = (Button it) -> {
          it.dispose();
        };
        ArgumentsTable.INPUT_SUPPORT_BUTTONS.values().forEach(_function);
        super.dispose();
      }
    });
  }
  
  /**
   * Put an input support button for the given argument to the given map if the argument's type
   * has input support
   */
  private Button putInputSupportButtonIfProvided(final Map<Argument, Button> buttonsPerArgument, final Composite parent, final Argument argument) {
    final Consumer<Argument> inputSupport = this.ARGUMENT_VALUE_INPUT_SUPPORT.get(argument.getType().getClass());
    if ((inputSupport == null)) {
      return null;
    }
    final Button inputSupportButton = new Button(parent, SWT.NONE);
    GridData _gridData = new GridData(SWT.CENTER, SWT.FILL, false, true);
    inputSupportButton.setLayoutData(_gridData);
    inputSupportButton.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_CONTENT_PROPOSAL).getImage());
    final Listener _function = (Event it) -> {
      inputSupport.accept(argument);
      this.viewer.update(argument, null);
    };
    inputSupportButton.addListener(SWT.Selection, _function);
    buttonsPerArgument.put(argument, inputSupportButton);
    return inputSupportButton;
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
   * Create button for the specification of a new argument
   */
  private void createNewButton(final Composite parent) {
    Button _button = new Button(parent, SWT.PUSH);
    this.newButton = _button;
    this.newButton.setImage(ArgumentsTable.NEW_IMAGE);
    final Listener _function = (Event it) -> {
      Object _input = this.viewer.getInput();
      boolean _tripleEquals = (_input == null);
      if (_tripleEquals) {
        return;
      }
      AbstractArgumentType _alphabeticallyFirstSupportedArgumentType = ArgumentsTable.DEFAULT_ARGUMENT_KIND.getAlphabeticallyFirstSupportedArgumentType();
      final Argument argument = new Argument(
        ArgumentsTable.DEFAULT_ARGUMENT_KIND, _alphabeticallyFirstSupportedArgumentType, 
        "", 
        "");
      this.addArgument(argument);
      this.viewer.editElement(argument, 1);
    };
    this.newButton.addListener(SWT.Selection, _function);
  }
  
  /**
   * Check if the table already contains the given argument
   */
  public final boolean containsArgument(final Argument argument) {
    return this.currentArguments.contains(argument);
  }
  
  /**
   * Update the table viewer for all arguments of the given type
   */
  public final void updateArguments(final Class<? extends AbstractArgumentType> argumentTypeClass) {
    final List<Argument> argumentsToUpdate = this.currentArguments.get(argumentTypeClass);
    final Consumer<Argument> _function = (Argument it) -> {
      this.viewer.update(it, null);
    };
    argumentsToUpdate.forEach(_function);
  }
  
  /**
   * Add an argument to the table
   */
  public final void addArgument(final Argument argument) {
    this.currentArguments.add(argument);
    this.syncInput();
  }
  
  /**
   * Synchronize the viewer input with the domain object
   */
  private void syncInput() {
    this.viewer.setInput(this.currentArguments.get());
  }
  
  /**
   * Create button for argument removal
   */
  private void createRemoveButton(final Composite parent) {
    Button _button = new Button(parent, SWT.PUSH);
    this.removeButton = _button;
    this.removeButton.setImage(ArgumentsTable.REMOVE_IMAGE);
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
          Button _remove = ArgumentsTable.INPUT_SUPPORT_BUTTONS.remove(it_1);
          if (_remove!=null) {
            _remove.dispose();
          }
        };
        selectedArguments.forEach(_function_2);
        this.syncInput();
      }
    };
    this.removeButton.addListener(SWT.Selection, _function);
  }
  
  /**
   * Create button to move argument up in the table
   */
  private void createMoveUpButton(final Composite parent) {
    Button _button = new Button(parent, SWT.PUSH);
    this.moveUpButton = _button;
    this.moveUpButton.setImage(ArgumentsTable.MOVE_UP_IMAGE);
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
        this.syncInput();
      }
    };
    this.moveUpButton.addListener(SWT.Selection, _function);
  }
  
  /**
   * Create button to move argument down in the table
   */
  private void createMoveDownButton(final Composite parent) {
    Button _button = new Button(parent, SWT.PUSH);
    this.moveDownButton = _button;
    this.moveDownButton.setImage(ArgumentsTable.MOVE_DOWN_IMAGE);
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
        this.syncInput();
      }
    };
    this.moveDownButton.addListener(SWT.Selection, _function);
  }
  
  /**
   * Set the given model processing configuration as input for the arguments table
   */
  public final void setInput(final ProcessingConfiguration configuration) {
    this.currentConfiguration = configuration;
    ArrayList<Argument> _elvis = null;
    ArrayList<Argument> _arguments = this.currentConfiguration.getArguments();
    if (_arguments != null) {
      _elvis = _arguments;
    } else {
      ArrayList<Argument> _newArrayList = CollectionLiterals.<Argument>newArrayList();
      _elvis = _newArrayList;
    }
    Arguments _arguments_1 = new Arguments(_elvis);
    this.currentArguments = _arguments_1;
    this.syncInput();
  }
  
  /**
   * Add property change listener to the arguments table
   */
  public final void addPropertyChangeListener(final PropertyChangeListener listener) {
    if (this.currentArguments!=null) {
      this.currentArguments.addPropertyChangeListener(listener);
    }
  }
  
  /**
   * Remove property change listener from the arguments table
   */
  public final void removePropertyChangeListener(final PropertyChangeListener listener) {
    if (this.currentArguments!=null) {
      this.currentArguments.removePropertyChangeListener(listener);
    }
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
  
  @Pure
  public TableViewer getViewer() {
    return this.viewer;
  }
  
  @Pure
  public boolean getEnabled() {
    return this.enabled;
  }
  
  @Pure
  public ProcessingConfiguration getCurrentConfiguration() {
    return this.currentConfiguration;
  }
}
