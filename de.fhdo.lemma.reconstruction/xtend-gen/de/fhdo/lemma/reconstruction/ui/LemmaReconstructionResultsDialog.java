package de.fhdo.lemma.reconstruction.ui;

import de.fhdo.lemma.reconstruction.domain.Context;
import de.fhdo.lemma.reconstruction.domain.DataStructure;
import de.fhdo.lemma.reconstruction.domain.Field;
import de.fhdo.lemma.reconstruction.service.Interface;
import de.fhdo.lemma.reconstruction.service.Microservice;
import de.fhdo.lemma.reconstruction.service.Operation;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class LemmaReconstructionResultsDialog extends TitleAreaDialog {
  private TreeViewer treeViewer;
  
  private List<Context> contexts;
  
  private List<Microservice> microservices;
  
  @Accessors
  private List<Context> selectedContexts = CollectionLiterals.<Context>newLinkedList();
  
  @Accessors
  private List<Microservice> selectedMicroservices = CollectionLiterals.<Microservice>newLinkedList();
  
  public LemmaReconstructionResultsDialog(final Shell parentShell, final List<Context> contexts, final List<Microservice> microservice) {
    super(parentShell);
    this.contexts = contexts;
    this.microservices = microservice;
  }
  
  /**
   * Create dialog (to be called after constructor and before open())
   */
  @Override
  public void create() {
    super.create();
    this.setTitle("LEMMA Reconstruction from MongoDB reconstruction store.");
    this.setMessage("Reconstruct LEMMA Models.", IMessageProvider.INFORMATION);
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
    GridLayout _gridLayout = new GridLayout(2, false);
    container.setLayout(_gridLayout);
    this.createReconstructionTree(container);
    return area;
  }
  
  private void createReconstructionTree(final Composite parent) {
    TreeViewer _treeViewer = new TreeViewer(parent);
    this.treeViewer = _treeViewer;
    ReconstructionContentProvider _reconstructionContentProvider = new ReconstructionContentProvider();
    this.treeViewer.setContentProvider(_reconstructionContentProvider);
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
    final LinkedList<Object> input = CollectionLiterals.<Object>newLinkedList();
    input.addAll(this.contexts);
    input.addAll(this.microservices);
    this.treeViewer.setInput(((List<?>) input));
    final ISelection data = this.treeViewer.getSelection();
    InputOutput.println();
  }
  
  /**
   * Create schema name tree column
   */
  private void createNameColumn() {
    final TreeViewerColumn column = new TreeViewerColumn(this.treeViewer, SWT.NONE);
    TreeColumn _column = column.getColumn();
    _column.setWidth(500);
    TreeColumn _column_1 = column.getColumn();
    _column_1.setText("Schema name");
    ReconstructionTreeLableProvider _reconstructionTreeLableProvider = new ReconstructionTreeLableProvider();
    DelegatingStyledCellLabelProvider _delegatingStyledCellLabelProvider = new DelegatingStyledCellLabelProvider(_reconstructionTreeLableProvider);
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
        String _switchResult = null;
        boolean _matched = false;
        if (element instanceof Context) {
          _matched=true;
          _switchResult = "Context";
        }
        if (!_matched) {
          if (element instanceof DataStructure) {
            _matched=true;
            _switchResult = "Entity";
          }
        }
        if (!_matched) {
          if (element instanceof Field) {
            _matched=true;
            _switchResult = "Attribute";
          }
        }
        if (!_matched) {
          if (element instanceof Microservice) {
            _matched=true;
            _switchResult = "Microservice";
          }
        }
        if (!_matched) {
          if (element instanceof Interface) {
            _matched=true;
            _switchResult = "Interface";
          }
        }
        if (!_matched) {
          if (element instanceof Operation) {
            _matched=true;
            _switchResult = "Operation";
          }
        }
        if (!_matched) {
          _switchResult = "";
        }
        return _switchResult;
      }
    });
  }
  
  private List<?> toTreeElements(final List<Context> contects) {
    return null;
  }
  
  @Override
  public void createButtonsForButtonBar(final Composite parent) {
    this.createButton(parent, IDialogConstants.OK_ID, "Continue", true);
    this.createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
  }
  
  @Override
  public boolean isResizable() {
    return true;
  }
  
  @Override
  public void okPressed() {
    this.saveInput();
    super.okPressed();
  }
  
  private void saveInput() {
    final Consumer<Object> _function = (Object it) -> {
      boolean _matched = false;
      if (it instanceof Context) {
        _matched=true;
        this.selectedContexts.add(((Context)it));
      }
      if (!_matched) {
        if (it instanceof Microservice) {
          _matched=true;
          this.selectedMicroservices.add(((Microservice)it));
        }
      }
    };
    this.treeViewer.getStructuredSelection().forEach(_function);
    InputOutput.println();
  }
  
  @Pure
  public List<Context> getSelectedContexts() {
    return this.selectedContexts;
  }
  
  public void setSelectedContexts(final List<Context> selectedContexts) {
    this.selectedContexts = selectedContexts;
  }
  
  @Pure
  public List<Microservice> getSelectedMicroservices() {
    return this.selectedMicroservices;
  }
  
  public void setSelectedMicroservices(final List<Microservice> selectedMicroservices) {
    this.selectedMicroservices = selectedMicroservices;
  }
}
