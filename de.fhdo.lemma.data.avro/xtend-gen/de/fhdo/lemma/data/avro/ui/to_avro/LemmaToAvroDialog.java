package de.fhdo.lemma.data.avro.ui.to_avro;

import de.fhdo.lemma.data.avro.Util;
import de.fhdo.lemma.data.intermediate.IntermediateCollectionType;
import de.fhdo.lemma.data.intermediate.IntermediateDataModel;
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure;
import de.fhdo.lemma.data.intermediate.IntermediateEnumeration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Dialog to convert LEMMA models to Avro schema specification files.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class LemmaToAvroDialog extends TitleAreaDialog {
  private static final int MIN_DIALOG_WIDTH = 500;
  
  private static final int MIN_DIALOG_HEIGHT = 250;
  
  private static final int CONTINUE_WITH_ALL = 2;
  
  private TreeViewer treeViewer;
  
  private Button protocolCheckbox;
  
  private Text protocolNameInput;
  
  private Text protocolDocumentationInput;
  
  private final ArrayList<Control> inputRowControls = CollectionLiterals.<Control>newArrayList();
  
  private String modelFilename;
  
  private List<? extends EObject> initialElements;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private List<? extends EObject> selectedElements = CollectionLiterals.<EObject>emptyList();
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String protocolName = "";
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String protocolDocumentation = "";
  
  /**
   * Constructor
   */
  public LemmaToAvroDialog(final Shell parentShell, final String modelFilename, final List<? extends EObject> topLevelTypeContainers) {
    super(parentShell);
    this.initialElements = topLevelTypeContainers;
    this.modelFilename = modelFilename;
  }
  
  /**
   * Create dialog (to be called after constructor and before open())
   */
  @Override
  public void create() {
    super.create();
    this.setTitle("Transform Intermediate Models to Avro Schema Declarations");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Select elements from intermediate model \"");
    _builder.append(this.modelFilename);
    _builder.append("\" to be ");
    String _plus = (_builder.toString() + 
      "transformed to Avro schemas.");
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
    this.createModelTree(container);
    this.createBottomRow(container);
    return area;
  }
  
  /**
   * Create TreeViewer for LEMMA EObjects that can be transformed to Avro schemas
   */
  private void createModelTree(final Composite parent) {
    TreeViewer _treeViewer = new TreeViewer(parent);
    this.treeViewer = _treeViewer;
    ElementTreeContentProvider _elementTreeContentProvider = new ElementTreeContentProvider();
    this.treeViewer.setContentProvider(_elementTreeContentProvider);
    Tree _tree = this.treeViewer.getTree();
    _tree.setHeaderVisible(true);
    Tree _tree_1 = this.treeViewer.getTree();
    _tree_1.setLinesVisible(true);
    Tree _tree_2 = this.treeViewer.getTree();
    _tree_2.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent event) {
        LemmaToAvroDialog.this.updateProtocolNameInput();
      }
    });
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
    final GridData treeViewerData = new GridData();
    treeViewerData.grabExcessHorizontalSpace = true;
    treeViewerData.grabExcessVerticalSpace = true;
    treeViewerData.horizontalAlignment = GridData.FILL;
    treeViewerData.verticalAlignment = GridData.FILL;
    Tree _tree_3 = this.treeViewer.getTree();
    _tree_3.setLayoutData(treeViewerData);
    this.createNameColumn();
    this.createTypeKindColumn();
    this.treeViewer.setInput(this.allTransformableElements());
  }
  
  /**
   * Helper to update the text field for the Avro protocol name based on its "enabled" state
   */
  private void updateProtocolNameInput() {
    boolean _isEnabled = this.protocolNameInput.isEnabled();
    if (_isEnabled) {
      final EObject eObject = this.getSelectedEObject(this.treeViewer.getSelection());
      String _xifexpression = null;
      if ((eObject != null)) {
        _xifexpression = Util.qualifiedName(eObject);
      } else {
        _xifexpression = "";
      }
      final String qualifiedName = _xifexpression;
      this.protocolNameInput.setText(qualifiedName);
    } else {
      this.protocolNameInput.setText("");
    }
  }
  
  /**
   * Get selected LEMMA EObject from tree viewer ISelection object
   */
  private EObject getSelectedEObject(final ISelection selection) {
    EObject _xifexpression = null;
    if (((selection instanceof IStructuredSelection) && (!selection.isEmpty()))) {
      Object _get = ((IStructuredSelection) selection).toList().get(0);
      _xifexpression = ((EObject) _get);
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  /**
   * Create element name column in tree viewer
   */
  private void createNameColumn() {
    final TreeViewerColumn column = new TreeViewerColumn(this.treeViewer, SWT.NONE);
    TreeColumn _column = column.getColumn();
    _column.setWidth(300);
    TreeColumn _column_1 = column.getColumn();
    _column_1.setText("Element name");
    ElementTreeLabelProvider _elementTreeLabelProvider = new ElementTreeLabelProvider();
    DelegatingStyledCellLabelProvider _delegatingStyledCellLabelProvider = new DelegatingStyledCellLabelProvider(_elementTreeLabelProvider);
    column.setLabelProvider(_delegatingStyledCellLabelProvider);
  }
  
  /**
   * Create type kind column in tree viewer
   */
  private void createTypeKindColumn() {
    final TreeViewerColumn column = new TreeViewerColumn(this.treeViewer, SWT.NONE);
    TreeColumn _column = column.getColumn();
    _column.setWidth(600);
    TreeColumn _column_1 = column.getColumn();
    _column_1.setText("Complex type kind");
    column.setLabelProvider(new ColumnLabelProvider() {
      @Override
      public String getText(final Object element) {
        String _switchResult = null;
        boolean _matched = false;
        if (element instanceof IntermediateEnumeration) {
          _matched=true;
          _switchResult = "Enumeration";
        }
        if (!_matched) {
          if (element instanceof IntermediateDataStructure) {
            _matched=true;
            _switchResult = "Data structure";
          }
        }
        if (!_matched) {
          if (element instanceof IntermediateCollectionType) {
            _matched=true;
            _switchResult = "Collection type";
          }
        }
        if (!_matched) {
          _switchResult = "";
        }
        return _switchResult;
      }
    });
  }
  
  /**
   * Get all LEMMA EObjects from the initial elements of this dialog, which may be transformed to
   * Avro schemas
   */
  private List<? extends EObject> allTransformableElements() {
    final EObject firstContainer = this.initialElements.get(0);
    List<? extends EObject> _xifexpression = null;
    if ((firstContainer instanceof IntermediateDataModel)) {
      _xifexpression = ((IntermediateDataModel)firstContainer).getComplexTypes();
    } else {
      _xifexpression = this.initialElements;
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
    GridLayout _gridLayout = new GridLayout(2, false);
    bottomRow.setLayout(_gridLayout);
    this.createKey(bottomRow);
    final Group protocolGroup = this.createProtocolGroup(bottomRow);
    GridData _gridData_1 = new GridData(SWT.FILL, SWT.FILL, true, false);
    protocolGroup.setLayoutData(_gridData_1);
  }
  
  /**
   * Create key in bottom row
   */
  private void createKey(final Composite parent) {
    final Group key = new Group(parent, SWT.SHADOW_ETCHED_IN);
    key.setText("Key");
    GridData _gridData = new GridData(SWT.FILL, SWT.FILL, false, false);
    key.setLayoutData(_gridData);
    GridLayout _gridLayout = new GridLayout(1, false);
    key.setLayout(_gridLayout);
    this.createKeyEntry(key, ElementTreeLabelProvider.VERSION_ICON, "Version");
    this.createKeyEntry(key, ElementTreeLabelProvider.CONTEXT_ICON, "Context");
    this.createKeyEntry(key, ElementTreeLabelProvider.COMPLEX_TYPE_ICON, "Complex Type");
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
   * Create group for Avro protocol specification
   */
  private Group createProtocolGroup(final Composite parent) {
    final Group group = new Group(parent, SWT.SHADOW_ETCHED_IN);
    group.setText("Avro Protocol Transformation");
    GridLayout _gridLayout = new GridLayout(2, false);
    group.setLayout(_gridLayout);
    Button _button = new Button(group, SWT.CHECK);
    this.protocolCheckbox = _button;
    GridData _gridData = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
    this.protocolCheckbox.setLayoutData(_gridData);
    this.protocolCheckbox.setText("Transform elements into Avro protocol specification");
    this.protocolCheckbox.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent event) {
        final boolean selected = ((Button) event.widget).getSelection();
        final Consumer<Control> _function = (Control it) -> {
          it.setEnabled(selected);
        };
        LemmaToAvroDialog.this.inputRowControls.forEach(_function);
        LemmaToAvroDialog.this.updateProtocolNameInput();
        LemmaToAvroDialog.this.protocolDocumentationInput.setText("");
        if (selected) {
          LemmaToAvroDialog.this.protocolNameInput.setFocus();
        }
      }
    });
    final Pair<Label, Text> protocolName = this.createInputRow(group, "Name*:");
    this.inputRowControls.add(protocolName.getKey());
    this.inputRowControls.add(protocolName.getValue());
    this.protocolNameInput = protocolName.getValue();
    final Pair<Label, Text> protocolDocumentation = this.createInputRow(group, "Documentation:");
    this.inputRowControls.add(protocolDocumentation.getKey());
    this.inputRowControls.add(protocolDocumentation.getValue());
    this.protocolDocumentationInput = protocolDocumentation.getValue();
    return group;
  }
  
  /**
   * Create an input row consisting of a Text input and its Label
   */
  private Pair<Label, Text> createInputRow(final Composite parent, final String labelText) {
    final Label label = new Label(parent, SWT.NONE);
    label.setEnabled(false);
    label.setText(labelText);
    final Text input = new Text(parent, SWT.BORDER);
    GridData _gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
    input.setLayoutData(_gridData);
    input.setEnabled(false);
    return Pair.<Label, Text>of(label, input);
  }
  
  /**
   * Create buttons for the button bar
   */
  @Override
  public void createButtonsForButtonBar(final Composite parent) {
    this.createButton(parent, IDialogConstants.OK_ID, "Continue with selected elements", true);
    this.createButton(parent, LemmaToAvroDialog.CONTINUE_WITH_ALL, "Select all elements and continue", false);
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
      case LemmaToAvroDialog.CONTINUE_WITH_ALL:
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
    boolean _checkProtocolInputs = this.checkProtocolInputs();
    boolean _not = (!_checkProtocolInputs);
    if (_not) {
      return;
    }
    final Function1<Object, EObject> _function = (Object it) -> {
      return ((EObject) it);
    };
    this.selectedElements = IterableExtensions.<EObject>toList(IterableExtensions.<Object, EObject>map(this.treeViewer.getStructuredSelection(), _function));
    boolean _isEmpty = this.selectedElements.isEmpty();
    if (_isEmpty) {
      MessageDialog.openError(this.getShell(), "No Model Elements Selected", ("No model elements were " + 
        "selected. Transformation aborted."));
      return;
    }
    this.protocolName = this.protocolNameInput.getText();
    this.protocolDocumentation = this.protocolDocumentationInput.getText();
    super.okPressed();
  }
  
  /**
   * Helper to check the inputs related to the Avro protocol for validity
   */
  private boolean checkProtocolInputs() {
    boolean _xifexpression = false;
    if ((this.protocolCheckbox.getSelection() && this.protocolNameInput.getText().isEmpty())) {
      boolean _xblockexpression = false;
      {
        MessageDialog.openError(this.getShell(), "No Protocol Name Specified", ("Please specify a name " + 
          "for the Avro protocol to be derived from selected LEMMA model elements."));
        _xblockexpression = false;
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = true;
    }
    return _xifexpression;
  }
  
  /**
   * Button to continue with all transformable elements was pressed
   */
  private void continueWithAllPressed() {
    boolean _checkProtocolInputs = this.checkProtocolInputs();
    boolean _not = (!_checkProtocolInputs);
    if (_not) {
      return;
    } else {
      this.protocolName = this.protocolNameInput.getText();
      this.protocolDocumentation = this.protocolDocumentationInput.getText();
    }
    this.selectedElements = this.allTransformableElements();
    super.okPressed();
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
    int _max = Math.max(this.convertHorizontalDLUsToPixels(LemmaToAvroDialog.MIN_DIALOG_WIDTH), shellSize.x);
    int _max_1 = Math.max(this.convertVerticalDLUsToPixels(LemmaToAvroDialog.MIN_DIALOG_HEIGHT), shellSize.y);
    return new Point(_max, _max_1);
  }
  
  @Pure
  public List<? extends EObject> getSelectedElements() {
    return this.selectedElements;
  }
  
  @Pure
  public String getProtocolName() {
    return this.protocolName;
  }
  
  @Pure
  public String getProtocolDocumentation() {
    return this.protocolDocumentation;
  }
}
