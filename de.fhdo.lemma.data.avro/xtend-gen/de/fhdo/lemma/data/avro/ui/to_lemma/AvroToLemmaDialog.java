package de.fhdo.lemma.data.avro.ui.to_lemma;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import de.fhdo.lemma.data.avro.ui.to_lemma.SchemaTreeContentProvider;
import de.fhdo.lemma.data.avro.ui.to_lemma.SchemaTreeLabelProvider;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import org.apache.avro.Protocol;
import org.apache.avro.Schema;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Dialog to convert Avro schema specification files to LEMMA models.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class AvroToLemmaDialog extends TitleAreaDialog {
  /**
   * Intermediate class to represent an Avro namespace inside the tree viewer
   */
  public static class AvroNamespace {
    @Accessors(AccessorType.PUBLIC_GETTER)
    private String namespace;
    
    @Accessors
    private AvroToLemmaDialog.AvroProtocol parent;
    
    @Accessors(AccessorType.PUBLIC_GETTER)
    private List<AvroToLemmaDialog.AvroSchemaWithNamespace> children;
    
    /**
     * Constructor
     */
    public AvroNamespace(final String namespace) {
      this.namespace = namespace;
      this.children = CollectionLiterals.<AvroToLemmaDialog.AvroSchemaWithNamespace>newArrayList();
    }
    
    /**
     * Add child Avro schema
     */
    public boolean addChild(final Schema schema) {
      AvroToLemmaDialog.AvroSchemaWithNamespace _avroSchemaWithNamespace = new AvroToLemmaDialog.AvroSchemaWithNamespace(schema, this, null);
      return this.children.add(_avroSchemaWithNamespace);
    }
    
    /**
     * Compare with Object
     */
    @Override
    public boolean equals(final Object o) {
      boolean _xifexpression = false;
      boolean _equals = Objects.equal(o, this);
      if (_equals) {
        _xifexpression = true;
      } else {
        boolean _xifexpression_1 = false;
        if ((!(o instanceof AvroToLemmaDialog.AvroNamespace))) {
          _xifexpression_1 = false;
        } else {
          boolean _xifexpression_2 = false;
          if ((this.namespace == null)) {
            _xifexpression_2 = (((AvroToLemmaDialog.AvroNamespace) o).namespace == null);
          } else {
            _xifexpression_2 = Objects.equal(this.namespace, ((AvroToLemmaDialog.AvroNamespace) o).namespace);
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      return _xifexpression;
    }
    
    /**
     * Get hash code
     */
    @Override
    public int hashCode() {
      int _xifexpression = (int) 0;
      if ((this.namespace != null)) {
        _xifexpression = this.namespace.hashCode();
      } else {
        _xifexpression = 0;
      }
      return _xifexpression;
    }
    
    @Pure
    public String getNamespace() {
      return this.namespace;
    }
    
    @Pure
    public AvroToLemmaDialog.AvroProtocol getParent() {
      return this.parent;
    }
    
    public void setParent(final AvroToLemmaDialog.AvroProtocol parent) {
      this.parent = parent;
    }
    
    @Pure
    public List<AvroToLemmaDialog.AvroSchemaWithNamespace> getChildren() {
      return this.children;
    }
  }
  
  /**
   * Intermediate class to represent an Avro schema inside the tree viewer
   */
  public static class AvroSchemaWithNamespace {
    @Accessors(AccessorType.PUBLIC_GETTER)
    private Schema schema;
    
    @Accessors(AccessorType.PUBLIC_GETTER)
    private AvroToLemmaDialog.AvroNamespace namespace;
    
    @Accessors(AccessorType.PUBLIC_GETTER)
    private AvroToLemmaDialog.AvroSchemaWithNamespace parentSchema;
    
    @Accessors(AccessorType.PUBLIC_GETTER)
    private List<AvroToLemmaDialog.AvroSchemaWithNamespace> children;
    
    /**
     * Constructor
     */
    public AvroSchemaWithNamespace(final Schema schema, final AvroToLemmaDialog.AvroNamespace namespace, final AvroToLemmaDialog.AvroSchemaWithNamespace parentSchema) {
      this.schema = schema;
      this.namespace = namespace;
      this.parentSchema = parentSchema;
      List<AvroToLemmaDialog.AvroSchemaWithNamespace> _xifexpression = null;
      Schema.Type _type = schema.getType();
      boolean _equals = Objects.equal(_type, Schema.Type.UNION);
      if (_equals) {
        final Function1<Schema, AvroToLemmaDialog.AvroSchemaWithNamespace> _function = (Schema it) -> {
          return new AvroToLemmaDialog.AvroSchemaWithNamespace(it, namespace, this);
        };
        _xifexpression = ListExtensions.<Schema, AvroToLemmaDialog.AvroSchemaWithNamespace>map(schema.getTypes(), _function);
      } else {
        _xifexpression = CollectionLiterals.<AvroToLemmaDialog.AvroSchemaWithNamespace>newArrayList();
      }
      this.children = _xifexpression;
    }
    
    /**
     * Get parent schema or namespace
     */
    public Object getParent() {
      Object _xifexpression = null;
      if ((this.parentSchema != null)) {
        _xifexpression = this.parentSchema;
      } else {
        _xifexpression = this.namespace;
      }
      return _xifexpression;
    }
    
    /**
     * Compare with Object (does not correspond to equals()-contract on purpose)
     */
    @Override
    public boolean equals(final Object o) {
      return Objects.equal(this.schema, o);
    }
    
    /**
     * Get hash code
     */
    @Override
    public int hashCode() {
      return this.schema.hashCode();
    }
    
    @Pure
    public Schema getSchema() {
      return this.schema;
    }
    
    @Pure
    public AvroToLemmaDialog.AvroNamespace getNamespace() {
      return this.namespace;
    }
    
    @Pure
    public AvroToLemmaDialog.AvroSchemaWithNamespace getParentSchema() {
      return this.parentSchema;
    }
    
    @Pure
    public List<AvroToLemmaDialog.AvroSchemaWithNamespace> getChildren() {
      return this.children;
    }
  }
  
  /**
   * Intermediate class to represent an Avro protocol inside the tree viewer
   */
  public static class AvroProtocol {
    @Accessors(AccessorType.PUBLIC_GETTER)
    private Protocol protocol;
    
    @Accessors(AccessorType.PUBLIC_GETTER)
    private List<AvroToLemmaDialog.AvroNamespace> children;
    
    /**
     * Constructor
     */
    public AvroProtocol(final Protocol protocol, final List<AvroToLemmaDialog.AvroNamespace> children) {
      this.protocol = protocol;
      this.children = children;
    }
    
    /**
     * Add child Avro namespace
     */
    public boolean addChild(final AvroToLemmaDialog.AvroNamespace namespace) {
      boolean _xblockexpression = false;
      {
        namespace.parent = this;
        _xblockexpression = this.children.add(namespace);
      }
      return _xblockexpression;
    }
    
    @Pure
    public Protocol getProtocol() {
      return this.protocol;
    }
    
    @Pure
    public List<AvroToLemmaDialog.AvroNamespace> getChildren() {
      return this.children;
    }
  }
  
  private static final int MIN_DIALOG_WIDTH = 500;
  
  private static final int MIN_DIALOG_HEIGHT = 250;
  
  private static final int CONTINUE_WITH_ALL = 2;
  
  private TreeViewer treeViewer;
  
  private String avroFilename;
  
  private String schemaName;
  
  private String schemaNamespace;
  
  private String schemaDocumentation;
  
  private List<Schema> initialSchemas;
  
  private Protocol protocol;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private Protocol selectedProtocol;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private List<Schema> selectedSchemas = CollectionLiterals.<Schema>emptyList();
  
  /**
   * Constructor
   */
  public AvroToLemmaDialog(final Shell parentShell, final String avroFilename, final String schemaName, final String schemaNamespace, final String schemaDocumentation, final List<Schema> initialSchemas, final Protocol protocol) {
    super(parentShell);
    this.avroFilename = avroFilename;
    this.schemaName = schemaName;
    this.schemaNamespace = schemaNamespace;
    this.schemaDocumentation = schemaDocumentation;
    this.initialSchemas = initialSchemas;
    this.protocol = protocol;
  }
  
  /**
   * Create dialog (to be called after constructor and before open())
   */
  @Override
  public void create() {
    super.create();
    this.setTitle("Transform Avro Schema Declarations to LEMMA Models");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Determine schemas from Avro schema specification file \"");
    _builder.append(this.avroFilename);
    _builder.append("\" ");
    String _plus = (_builder.toString() + 
      "to be transformed to LEMMA models.");
    this.setMessage(_plus, IMessageProvider.INFORMATION);
  }
  
  /**
   * Internal callback for dialog area creation
   */
  @Override
  public Control createDialogArea(final Composite parent) {
    Control _createDialogArea = super.createDialogArea(parent);
    final Composite area = ((Composite) _createDialogArea);
    final Composite container = new Composite(area, SWT.NONE);
    GridData _gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
    container.setLayoutData(_gridData);
    GridLayout _gridLayout = new GridLayout(1, false);
    container.setLayout(_gridLayout);
    this.createTopRow(container);
    this.createModelTree(container);
    this.createBottomRow(container);
    return area;
  }
  
  /**
   * Create top row in the dialog comprising schema information
   */
  private void createTopRow(final Composite parent) {
    boolean _isEmpty = this.schemaName.isEmpty();
    if (_isEmpty) {
      return;
    }
    final Group group = new Group(parent, SWT.SHADOW_ETCHED_IN);
    group.setText("Schema Information");
    GridData _gridData = new GridData(SWT.FILL, SWT.FILL, false, false);
    group.setLayoutData(_gridData);
    GridLayout _gridLayout = new GridLayout(2, false);
    group.setLayout(_gridLayout);
    String _xifexpression = null;
    boolean _isEmpty_1 = this.schemaNamespace.isEmpty();
    boolean _not = (!_isEmpty_1);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(this.schemaNamespace);
      _builder.append(".");
      _builder.append(this.schemaName);
      _xifexpression = _builder.toString();
    } else {
      _xifexpression = this.schemaName;
    }
    this.createSchemaInformationLine(group, "Name", _xifexpression);
    this.createSchemaInformationLine(group, "Documentation", this.schemaDocumentation);
  }
  
  /**
   * Create line for schema information output
   */
  private void createSchemaInformationLine(final Composite parent, final String caption, final String value) {
    final Label label = new Label(parent, SWT.NONE);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(caption);
    _builder.append(":");
    label.setText(_builder.toString());
    final Label valueLabel = new Label(parent, SWT.NONE);
    valueLabel.setText(value);
  }
  
  /**
   * Create the tree viewer
   */
  private void createModelTree(final Composite parent) {
    TreeViewer _treeViewer = new TreeViewer(parent);
    this.treeViewer = _treeViewer;
    SchemaTreeContentProvider _schemaTreeContentProvider = new SchemaTreeContentProvider();
    this.treeViewer.setContentProvider(_schemaTreeContentProvider);
    Tree _tree = this.treeViewer.getTree();
    _tree.setHeaderVisible(true);
    Tree _tree_1 = this.treeViewer.getTree();
    _tree_1.setLinesVisible(true);
    Tree _tree_2 = this.treeViewer.getTree();
    GridData _gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
    _tree_2.setLayoutData(_gridData);
    final IDoubleClickListener _function = (DoubleClickEvent it) -> {
      if ((this.treeViewer.getSelection().isEmpty() || 
        (!(this.treeViewer.getSelection() instanceof IStructuredSelection)))) {
        return;
      }
      ISelection _selection = this.treeViewer.getSelection();
      final Object selectedElement = ((IStructuredSelection) _selection).getFirstElement();
      boolean _expandedState = this.treeViewer.getExpandedState(selectedElement);
      if (_expandedState) {
        this.treeViewer.collapseToLevel(selectedElement, TreeViewer.ALL_LEVELS);
      } else {
        this.treeViewer.expandToLevel(selectedElement, 1);
      }
    };
    this.treeViewer.addDoubleClickListener(_function);
    this.createNameColumn();
    this.createTypeColumn();
    this.treeViewer.setInput(this.toTreeElements(this.initialSchemas));
  }
  
  /**
   * Create schema name tree column
   */
  private void createNameColumn() {
    final TreeViewerColumn column = new TreeViewerColumn(this.treeViewer, SWT.NONE);
    TreeColumn _column = column.getColumn();
    _column.setWidth(300);
    TreeColumn _column_1 = column.getColumn();
    _column_1.setText("Schema name");
    SchemaTreeLabelProvider _schemaTreeLabelProvider = new SchemaTreeLabelProvider();
    DelegatingStyledCellLabelProvider _delegatingStyledCellLabelProvider = new DelegatingStyledCellLabelProvider(_schemaTreeLabelProvider);
    column.setLabelProvider(_delegatingStyledCellLabelProvider);
  }
  
  /**
   * Create schema type tree column
   */
  private void createTypeColumn() {
    final TreeViewerColumn column = new TreeViewerColumn(this.treeViewer, SWT.NONE);
    TreeColumn _column = column.getColumn();
    _column.setWidth(300);
    TreeColumn _column_1 = column.getColumn();
    _column_1.setText("Schema type");
    column.setLabelProvider(new ColumnLabelProvider() {
      @Override
      public String getText(final Object element) {
        String _xifexpression = null;
        if ((element instanceof AvroToLemmaDialog.AvroSchemaWithNamespace)) {
          _xifexpression = StringExtensions.toFirstUpper(((AvroToLemmaDialog.AvroSchemaWithNamespace)element).schema.getType().toString().toLowerCase());
        } else {
          _xifexpression = "";
        }
        return _xifexpression;
      }
    });
  }
  
  /**
   * Convert the given list of Avro schemas to elements as expected by the tree viewer
   */
  private List<?> toTreeElements(final List<Schema> schemas) {
    final HashMap<String, AvroToLemmaDialog.AvroNamespace> namespaces = CollectionLiterals.<String, AvroToLemmaDialog.AvroNamespace>newHashMap();
    final Consumer<Schema> _function = (Schema it) -> {
      AvroToLemmaDialog.AvroNamespace namespaceObject = namespaces.get(it.getNamespace());
      if ((namespaceObject == null)) {
        String _namespace = it.getNamespace();
        AvroToLemmaDialog.AvroNamespace _avroNamespace = new AvroToLemmaDialog.AvroNamespace(_namespace);
        namespaceObject = _avroNamespace;
        namespaces.put(it.getNamespace(), namespaceObject);
      }
      namespaceObject.addChild(it);
    };
    schemas.forEach(_function);
    List<?> _xifexpression = null;
    if ((this.protocol != null)) {
      List<AvroToLemmaDialog.AvroNamespace> _list = IterableExtensions.<AvroToLemmaDialog.AvroNamespace>toList(namespaces.values());
      AvroToLemmaDialog.AvroProtocol _avroProtocol = new AvroToLemmaDialog.AvroProtocol(this.protocol, _list);
      _xifexpression = CollectionLiterals.<AvroToLemmaDialog.AvroProtocol>newArrayList(_avroProtocol);
    } else {
      _xifexpression = IterableExtensions.<AvroToLemmaDialog.AvroNamespace>toList(namespaces.values());
    }
    return _xifexpression;
  }
  
  /**
   * Create bottom row of dialog
   */
  private void createBottomRow(final Composite parent) {
    final Composite bottomRow = new Composite(parent, SWT.NONE);
    GridData _gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
    bottomRow.setLayoutData(_gridData);
    GridLayout _gridLayout = new GridLayout(1, false);
    bottomRow.setLayout(_gridLayout);
    final Group key = new Group(parent, SWT.SHADOW_ETCHED_IN);
    key.setText("Key");
    GridData _gridData_1 = new GridData(SWT.FILL, SWT.FILL, false, false);
    key.setLayoutData(_gridData_1);
    GridLayout _gridLayout_1 = new GridLayout(1, false);
    key.setLayout(_gridLayout_1);
    this.createKeyEntry(key, SchemaTreeLabelProvider.PROTOCOL_ICON, "Protocol");
    this.createKeyEntry(key, SchemaTreeLabelProvider.NAMESPACE_ICON, "Namespace");
    this.createKeyEntry(key, SchemaTreeLabelProvider.SCHEMA_ICON, "Schema");
  }
  
  /**
   * Create key entry in the given group, and with the specified icon and description
   */
  private void createKeyEntry(final Group keyGroup, final Image icon, final String description) {
    final Composite keyEntry = new Composite(keyGroup, SWT.NONE);
    RowLayout _rowLayout = new RowLayout(SWT.HORIZONTAL);
    keyEntry.setLayout(_rowLayout);
    final Label imageLabel = new Label(keyEntry, SWT.NONE);
    imageLabel.setImage(icon);
    final Label textLabel = new Label(keyEntry, SWT.NONE);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("-");
    _builder.append(description);
    textLabel.setText(_builder.toString());
  }
  
  /**
   * Create buttons for the button bar
   */
  @Override
  public void createButtonsForButtonBar(final Composite parent) {
    this.createButton(parent, IDialogConstants.OK_ID, "Continue with selected schemas", true);
    this.createButton(parent, AvroToLemmaDialog.CONTINUE_WITH_ALL, "Select all schemas and continue", false);
    this.createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
  }
  
  /**
   * Catch button press
   */
  @Override
  public void buttonPressed(final int buttonId) {
    switch (buttonId) {
      case IDialogConstants.OK_ID:
        this.okPressed();
        break;
      case AvroToLemmaDialog.CONTINUE_WITH_ALL:
        this.continueWithAllPressed();
        break;
      case IDialogConstants.CANCEL_ID:
        this.cancelPressed();
        break;
    }
  }
  
  /**
   * OK button was pressed
   */
  @Override
  public void okPressed() {
    final List<Schema> selectedSchemasFromTree = this.getSelectedSchemasFromTree();
    if ((this.protocolInTreeSelection() || this.allAvailableSchemas(selectedSchemasFromTree))) {
      this.returnProtocol();
    }
    boolean _isEmpty = selectedSchemasFromTree.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      this.returnSchemas(selectedSchemasFromTree);
    } else {
      MessageDialog.openError(this.getShell(), "No Schemas Selected", ("No schemas were selected. " + 
        "Transformation aborted."));
    }
  }
  
  /**
   * Get all selected schemas from the tree
   */
  private List<Schema> getSelectedSchemasFromTree() {
    final Function1<Object, List<Schema>> _function = (Object it) -> {
      List<Schema> _switchResult = null;
      boolean _matched = false;
      if (it instanceof AvroToLemmaDialog.AvroNamespace) {
        _matched=true;
        final Function1<AvroToLemmaDialog.AvroSchemaWithNamespace, Schema> _function_1 = (AvroToLemmaDialog.AvroSchemaWithNamespace it_1) -> {
          return it_1.schema;
        };
        _switchResult = ListExtensions.<AvroToLemmaDialog.AvroSchemaWithNamespace, Schema>map(((AvroToLemmaDialog.AvroNamespace)it).children, _function_1);
      }
      if (!_matched) {
        if (it instanceof AvroToLemmaDialog.AvroSchemaWithNamespace) {
          _matched=true;
          _switchResult = CollectionLiterals.<Schema>newArrayList(((AvroToLemmaDialog.AvroSchemaWithNamespace)it).schema);
        }
      }
      return _switchResult;
    };
    return IterableExtensions.<Schema>toList(Iterables.<Schema>concat(IterableExtensions.<Object, List<Schema>>map(this.treeViewer.getStructuredSelection(), _function)));
  }
  
  /**
   * Check if an Avro protocol is in the set of selected tree elements
   */
  private boolean protocolInTreeSelection() {
    final Function1<Object, Boolean> _function = (Object it) -> {
      return Boolean.valueOf((it instanceof AvroToLemmaDialog.AvroProtocol));
    };
    Object _findFirst = IterableExtensions.<Object>findFirst(this.treeViewer.getStructuredSelection(), _function);
    return (_findFirst != null);
  }
  
  /**
   * Set the protocol as selected element for callers
   */
  private void returnProtocol() {
    this.selectedProtocol = this.protocol;
    super.okPressed();
  }
  
  /**
   * Check if the given list of schemas corresponds to the list of all available schemas
   */
  private boolean allAvailableSchemas(final List<Schema> schemas) {
    int _size = schemas.size();
    int _size_1 = this.initialSchemas.size();
    return (_size == _size_1);
  }
  
  /**
   * Set the given schemas as selected elements for callers
   */
  private void returnSchemas(final List<Schema> schemas) {
    this.selectedSchemas = schemas;
    super.okPressed();
  }
  
  /**
   * Button to continue with all transformable elements was pressed
   */
  private void continueWithAllPressed() {
    if ((this.protocol != null)) {
      this.returnProtocol();
    } else {
      this.returnSchemas(this.initialSchemas);
    }
  }
  
  /**
   * Flag to indicate that dialog is resizable
   */
  @Override
  public boolean isResizable() {
    return true;
  }
  
  /**
   * Initial size
   */
  @Override
  public Point getInitialSize() {
    final Point shellSize = super.getInitialSize();
    int _max = Math.max(this.convertHorizontalDLUsToPixels(AvroToLemmaDialog.MIN_DIALOG_WIDTH), shellSize.x);
    int _max_1 = Math.max(this.convertVerticalDLUsToPixels(AvroToLemmaDialog.MIN_DIALOG_HEIGHT), shellSize.y);
    return new Point(_max, _max_1);
  }
  
  @Pure
  public Protocol getSelectedProtocol() {
    return this.selectedProtocol;
  }
  
  @Pure
  public List<Schema> getSelectedSchemas() {
    return this.selectedSchemas;
  }
}
