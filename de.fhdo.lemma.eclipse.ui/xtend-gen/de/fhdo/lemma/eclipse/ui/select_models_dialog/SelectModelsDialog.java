package de.fhdo.lemma.eclipse.ui.select_models_dialog;

import com.google.common.collect.Iterables;
import de.fhdo.lemma.eclipse.ui.AbstractUiModelTransformationStrategy;
import de.fhdo.lemma.eclipse.ui.ModelFile;
import de.fhdo.lemma.eclipse.ui.ModelFileTypeDescription;
import de.fhdo.lemma.eclipse.ui.select_models_dialog.ModelTreeContentProvider;
import de.fhdo.lemma.eclipse.ui.select_models_dialog.ModelTreeLabelProvider;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.core.resources.IProject;
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
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Generic dialog to select models for subsequent intermediate model transformations.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class SelectModelsDialog extends TitleAreaDialog {
  private static final int MIN_DIALOG_WIDTH = 500;
  
  private static final int MIN_DIALOG_HEIGHT = 250;
  
  private static final int CONTINUE_WITH_ALL = 2;
  
  private AbstractUiModelTransformationStrategy strategy;
  
  private Map<IProject, List<ModelFile>> inputModelFiles;
  
  private TreeViewer treeViewer;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private List<ModelFile> selectedModelFiles = CollectionLiterals.<ModelFile>newArrayList();
  
  /**
   * Constructor
   */
  public SelectModelsDialog(final Shell parentShell, final AbstractUiModelTransformationStrategy strategy, final Map<IProject, List<ModelFile>> inputModelFiles) {
    super(parentShell);
    if ((strategy == null)) {
      throw new IllegalArgumentException("Transformation strategy must not be null");
    }
    if (((inputModelFiles == null) || inputModelFiles.isEmpty())) {
      throw new IllegalArgumentException("Input models must not be null or empty");
    }
    this.strategy = strategy;
    this.inputModelFiles = inputModelFiles;
  }
  
  /**
   * OK button was pressed
   */
  @Override
  public void okPressed() {
    this.selectedModelFiles = this.getSelectedModelFilesFromTree();
    boolean _isEmpty = this.selectedModelFiles.isEmpty();
    if (_isEmpty) {
      MessageDialog.openError(this.getShell(), "No model files selected", ("No model files were " + 
        "selected. Transformation aborted."));
      return;
    }
    this.filterSelectedModelFilesForErrorsAndContinue();
  }
  
  /**
   * Helper to filer selected model files for errors and leave the dialog for the next step if
   * there is at least one selected model without errors
   */
  private void filterSelectedModelFilesForErrorsAndContinue() {
    final Function1<ModelFile, Boolean> _function = (ModelFile it) -> {
      Boolean _hasErrors = it.hasErrors();
      return Boolean.valueOf((!(_hasErrors).booleanValue()));
    };
    this.selectedModelFiles = IterableExtensions.<ModelFile>toList(IterableExtensions.<ModelFile>filter(this.selectedModelFiles, _function));
    boolean _isEmpty = this.selectedModelFiles.isEmpty();
    if (_isEmpty) {
      MessageDialog.openError(this.getShell(), "All selected models contain errors", (("All selected " + 
        "model files contain errors. Transformation is only possible on correct models. ") + 
        "Transformation aborted."));
    } else {
      super.okPressed();
    }
  }
  
  /**
   * Helper method to get selected files from tree viewer
   */
  private List<ModelFile> getSelectedModelFilesFromTree() {
    final Iterator iter = this.treeViewer.getStructuredSelection().iterator();
    final Function1<Object, Boolean> _function = (Object it) -> {
      return Boolean.valueOf((it instanceof ModelFile));
    };
    final Function1<Object, ModelFile> _function_1 = (Object it) -> {
      return ((ModelFile) it);
    };
    return IteratorExtensions.<ModelFile>toList(IteratorExtensions.<Object, ModelFile>map(IteratorExtensions.<Object>filter(iter, _function), _function_1));
  }
  
  /**
   * Create dialog (to be called after constructor and before open())
   */
  @Override
  public void create() {
    super.create();
    String _elvis = null;
    String _modelSelectionDialogTitle = this.strategy.getModelSelectionDialogTitle();
    if (_modelSelectionDialogTitle != null) {
      _elvis = _modelSelectionDialogTitle;
    } else {
      _elvis = "";
    }
    final String title = _elvis;
    this.setTitle(title);
    String _elvis_1 = null;
    String _modelSelectionDialogMessage = this.strategy.getModelSelectionDialogMessage();
    if (_modelSelectionDialogMessage != null) {
      _elvis_1 = _modelSelectionDialogMessage;
    } else {
      _elvis_1 = "";
    }
    final String message = _elvis_1;
    this.setMessage(message, IMessageProvider.INFORMATION);
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
    final GridLayout layout = new GridLayout(1, false);
    container.setLayout(layout);
    this.createModelTree(container);
    final LinkedHashMap<String, ModelFileTypeDescription> modelFileTypeDescriptions = this.strategy.getModelFileTypeDescriptions();
    if (((modelFileTypeDescriptions != null) && (modelFileTypeDescriptions.size() > 1))) {
      this.createLegend(container, IterableExtensions.<ModelFileTypeDescription>toList(modelFileTypeDescriptions.values()));
    }
    return area;
  }
  
  /**
   * Create buttons for the button bar
   */
  @Override
  public void createButtonsForButtonBar(final Composite parent) {
    this.createButton(parent, IDialogConstants.OK_ID, "Continue with selected models", true);
    this.createButton(parent, SelectModelsDialog.CONTINUE_WITH_ALL, "Select all models and continue", false);
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
      case SelectModelsDialog.CONTINUE_WITH_ALL:
        this.continueWithAllPressed();
        break;
      case IDialogConstants.CANCEL_ID:
        this.cancelPressed();
        break;
    }
  }
  
  /**
   * "Continue with all" was pressed
   */
  private void continueWithAllPressed() {
    this.selectedModelFiles = IterableExtensions.<ModelFile>toList(Iterables.<ModelFile>concat(this.inputModelFiles.values()));
    this.filterSelectedModelFilesForErrorsAndContinue();
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
    int _max = Math.max(this.convertHorizontalDLUsToPixels(SelectModelsDialog.MIN_DIALOG_WIDTH), shellSize.x);
    int _max_1 = Math.max(this.convertVerticalDLUsToPixels(SelectModelsDialog.MIN_DIALOG_HEIGHT), shellSize.y);
    return new Point(_max, _max_1);
  }
  
  /**
   * Create tree viewer for dialog area
   */
  private void createModelTree(final Composite parent) {
    TreeViewer _treeViewer = new TreeViewer(parent);
    this.treeViewer = _treeViewer;
    ModelTreeContentProvider _modelTreeContentProvider = new ModelTreeContentProvider(this.inputModelFiles, this.strategy);
    this.treeViewer.setContentProvider(_modelTreeContentProvider);
    ModelTreeLabelProvider _modelTreeLabelProvider = new ModelTreeLabelProvider();
    final DelegatingStyledCellLabelProvider rootLabelProvider = new DelegatingStyledCellLabelProvider(_modelTreeLabelProvider);
    this.treeViewer.setLabelProvider(rootLabelProvider);
    this.treeViewer.getTree().setHeaderVisible(true);
    this.treeViewer.getTree().setLinesVisible(true);
    this.treeViewer.addDoubleClickListener(new IDoubleClickListener() {
      @Override
      public void doubleClick(final DoubleClickEvent event) {
        Object _source = event.getSource();
        boolean _not = (!(_source instanceof TreeViewer));
        if (_not) {
          return;
        }
        ISelection _selection = SelectModelsDialog.this.treeViewer.getSelection();
        final ITreeSelection elementSelection = ((ITreeSelection) _selection);
        if ((((elementSelection == null) || 
          elementSelection.isEmpty()) || 
          (!(elementSelection instanceof IStructuredSelection)))) {
          return;
        }
        final Object selectedElement = elementSelection.getFirstElement();
        boolean _expandedState = SelectModelsDialog.this.treeViewer.getExpandedState(selectedElement);
        if (_expandedState) {
          SelectModelsDialog.this.treeViewer.collapseToLevel(selectedElement, TreeViewer.ALL_LEVELS);
        } else {
          SelectModelsDialog.this.treeViewer.expandToLevel(selectedElement, 1);
        }
      }
    });
    final GridData treeViewerData = new GridData();
    treeViewerData.grabExcessHorizontalSpace = true;
    treeViewerData.grabExcessVerticalSpace = true;
    treeViewerData.horizontalAlignment = GridData.FILL;
    treeViewerData.verticalAlignment = GridData.FILL;
    this.treeViewer.getTree().setLayoutData(treeViewerData);
    final TreeViewerColumn treeViewerColumnModelFiles = new TreeViewerColumn(this.treeViewer, SWT.NONE);
    treeViewerColumnModelFiles.getColumn().setWidth(300);
    treeViewerColumnModelFiles.getColumn().setText("Found model files in workspace");
    ModelTreeLabelProvider _modelTreeLabelProvider_1 = new ModelTreeLabelProvider();
    final DelegatingStyledCellLabelProvider modelFilesColumnLabelProvider = new DelegatingStyledCellLabelProvider(_modelTreeLabelProvider_1);
    treeViewerColumnModelFiles.setLabelProvider(modelFilesColumnLabelProvider);
    final TreeViewerColumn treeViewerColumnFilePaths = new TreeViewerColumn(this.treeViewer, SWT.NONE);
    treeViewerColumnFilePaths.getColumn().setWidth(600);
    treeViewerColumnFilePaths.getColumn().setText("Model file path");
    treeViewerColumnFilePaths.setLabelProvider(new ColumnLabelProvider() {
      @Override
      public String getText(final Object element) {
        String _switchResult = null;
        boolean _matched = false;
        if (element instanceof ModelFile) {
          _matched=true;
          _switchResult = ((ModelFile)element).getFile().getFullPath().toString();
        }
        return _switchResult;
      }
    });
    this.treeViewer.setInput(this.inputModelFiles);
  }
  
  /**
   * Create legend for tree viewer icons
   */
  private void createLegend(final Composite parent, final List<ModelFileTypeDescription> modelFileTypeDescriptions) {
    final Group legend = new Group(parent, SWT.SHADOW_ETCHED_IN);
    legend.setText("Icon Legend");
    GridLayout _gridLayout = new GridLayout(1, false);
    legend.setLayout(_gridLayout);
    final GridData legendGridData = new GridData();
    legendGridData.grabExcessHorizontalSpace = true;
    legendGridData.horizontalAlignment = GridData.FILL;
    legend.setLayoutData(legendGridData);
    final Consumer<ModelFileTypeDescription> _function = (ModelFileTypeDescription it) -> {
      final Composite legendEntry = new Composite(legend, SWT.NONE);
      RowLayout _rowLayout = new RowLayout(SWT.HORIZONTAL);
      legendEntry.setLayout(_rowLayout);
      final Label imageLabel = new Label(legendEntry, SWT.NONE);
      imageLabel.setImage(it.getIcon());
      final Label textLabel = new Label(legendEntry, SWT.NONE);
      String _description = it.getDescription();
      String _plus = ("-" + _description);
      textLabel.setText(_plus);
    };
    modelFileTypeDescriptions.forEach(_function);
  }
  
  @Pure
  public List<ModelFile> getSelectedModelFiles() {
    return this.selectedModelFiles;
  }
}
