package de.fhdo.lemma.eclipse.ui.file_container_selection_dialog;

import com.google.common.base.Function;
import de.fhdo.lemma.eclipse.ui.ModelFile;
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils;
import java.util.ArrayList;
import java.util.Map;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Generic dialog to select the container for a filename. The dialog is inspired by the
 * ContainerSelectionDialog from package org.eclipse.ui.dialogs, which may not directly be
 * subclassed.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class FileContainerSelectionDialog extends TitleAreaDialog {
  public static final int NEXT = 2;

  public static final int PREVIOUS = 3;

  public static final int ABORT = 4;

  public static final int RUN_TRANSFORMATIONS = 5;

  private static final int MIN_DIALOG_WIDTH = 500;

  private static final int MIN_DIALOG_HEIGHT = 250;

  private String title;

  private String message;

  private ModelFile modelFile;

  private IResource initialResource;

  private IResource initialSelection;

  private int currentFileIndex;

  private boolean lastFile;

  private TreeViewer containerSelectionTree;

  private Text filepathField;

  private Map<String, ModelFile> alreadySpecifiedPaths;

  @Accessors(AccessorType.PUBLIC_GETTER)
  private IFile selectedFile;

  /**
   * Constructor
   */
  public FileContainerSelectionDialog(final Shell parentShell, final ModelFile modelFile, final IFile initialFile, final Map<String, ModelFile> alreadySpecifiedPaths, final String title, final String message, final int currentFileIndex, final int fileCount) {
    super(parentShell);
    if ((modelFile == null)) {
      throw new IllegalArgumentException("Model file must not be null");
    } else {
      if ((alreadySpecifiedPaths == null)) {
        throw new IllegalArgumentException("Map of already specified paths must not be null");
      } else {
        if ((currentFileIndex <= 0)) {
          throw new IllegalArgumentException("File index starts with 1");
        } else {
          if ((fileCount <= 0)) {
            throw new IllegalArgumentException("File count must be positive");
          } else {
            if ((currentFileIndex > fileCount)) {
              throw new IllegalArgumentException(("Current file index must not be greater than file " + 
                "count"));
            }
          }
        }
      }
    }
    this.title = title;
    this.message = message;
    this.modelFile = modelFile;
    this.alreadySpecifiedPaths = alreadySpecifiedPaths;
    this.currentFileIndex = currentFileIndex;
    this.lastFile = (currentFileIndex == fileCount);
    if ((initialFile != null)) {
      this.initialResource = initialFile;
    } else {
      this.initialResource = modelFile.getFile().getParent();
    }
    this.setShellStyle((this.getShellStyle() | SWT.SHEET));
  }

  /**
   * Create dialog (to be called after constructor and before open())
   */
  @Override
  public void create() {
    super.create();
    String _elvis = null;
    if (this.title != null) {
      _elvis = this.title;
    } else {
      _elvis = "";
    }
    this.setTitle(_elvis);
    String _elvis_1 = null;
    if (this.message != null) {
      _elvis_1 = this.message;
    } else {
      _elvis_1 = "";
    }
    this.setMessage(_elvis_1, IMessageProvider.INFORMATION);
  }

  /**
   * Treat shell closing event like a press of the abort button
   */
  @Override
  public void handleShellCloseEvent() {
    this.abortPressed();
  }

  /**
   * Create buttons for the button bar
   */
  @Override
  public void createButtonsForButtonBar(final Composite parent) {
    this.createButton(parent, FileContainerSelectionDialog.ABORT, "Abort", false);
    this.createButton(parent, Window.CANCEL, IDialogConstants.CANCEL_LABEL, false);
    final Button previousButton = this.createButton(parent, FileContainerSelectionDialog.PREVIOUS, "< Previous", false);
    previousButton.setEnabled((this.currentFileIndex > 1));
    Shell _shell = this.getShell();
    Button _xifexpression = null;
    if ((!this.lastFile)) {
      _xifexpression = this.createButton(parent, FileContainerSelectionDialog.NEXT, "Next >", true);
    } else {
      _xifexpression = this.createButton(parent, FileContainerSelectionDialog.RUN_TRANSFORMATIONS, "Run transformations", true);
    }
    _shell.setDefaultButton(_xifexpression);
  }

  /**
   * Handle click on the abort button. A click on abort should stop the whole container selection
   * process.
   */
  private void abortPressed() {
    final int buttonPressed = MessageDialog.open(MessageDialog.QUESTION, this.getShell(), ("Abort manual path " + 
      "specification"), ("Aborting manual path specification will discard all previously " + 
      "specified paths and return to the previous dialog. Do you want to proceed?"), SWT.NONE, 
      "Yes", "No");
    if ((buttonPressed == 0)) {
      this.setReturnCodeAndClose(FileContainerSelectionDialog.ABORT);
    }
  }

  /**
   * Handle click on the cancel button
   */
  @Override
  public void cancelPressed() {
    Shell _shell = this.getShell();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("If you cancel the explicit specification of a path for the ");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("imported model file \"");
    IPath _fullPath = this.modelFile.getFile().getFullPath();
    _builder_1.append(_fullPath);
    _builder_1.append("\" the default path ");
    String _plus = (_builder.toString() + _builder_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("\"");
    String _transformationTargetPath = this.modelFile.getTransformationTargetPath();
    _builder_2.append(_transformationTargetPath);
    _builder_2.append("\" will be used instead. Do you want to ");
    String _plus_1 = (_plus + _builder_2);
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("proceed?");
    String _plus_2 = (_plus_1 + _builder_3);
    final int buttonPressed = MessageDialog.open(MessageDialog.QUESTION, _shell, ("Confirm usage of " + 
      "default path"), _plus_2, SWT.NONE, "Yes", "No");
    if ((buttonPressed == 0)) {
      this.setReturnCodeAndClose(Window.CANCEL);
    }
  }

  /**
   * Handle click on the next or run transformations button
   */
  private void nextOrRunButtonPressed(final int buttonId) {
    this.selectedFile = this.getSelectedFileFromInput();
    if ((this.selectedFile != null)) {
      this.setReturnCodeAndClose(buttonId);
    }
  }

  /**
   * Helper method to set the return code and also close the dialog
   */
  private void setReturnCodeAndClose(final int buttonId) {
    this.setReturnCode(buttonId);
    this.close();
  }

  /**
   * Catch button press
   */
  @Override
  public void buttonPressed(final int buttonId) {
    switch (buttonId) {
      case FileContainerSelectionDialog.ABORT:
        this.abortPressed();
        break;
      case Window.CANCEL:
        this.cancelPressed();
        break;
      case FileContainerSelectionDialog.PREVIOUS:
        this.setReturnCodeAndClose(FileContainerSelectionDialog.PREVIOUS);
        break;
      case FileContainerSelectionDialog.NEXT:
      case FileContainerSelectionDialog.RUN_TRANSFORMATIONS:
        this.nextOrRunButtonPressed(buttonId);
        break;
    }
  }

  /**
   * Get the selected IFile from the input being specified by the user
   */
  private IFile getSelectedFileFromInput() {
    String _text = this.filepathField.getText();
    final String filepath = (_text + ".xmi");
    boolean _isEmpty = filepath.isEmpty();
    if (_isEmpty) {
      MessageDialog.openError(this.getShell(), "No file path specified", "Please specify a file path.");
      return null;
    }
    final ModelFile pathAlreadySpecifiedFor = this.alreadySpecifiedPaths.get(filepath);
    if ((pathAlreadySpecifiedFor != null)) {
      final String alreadySpecifiedForPath = pathAlreadySpecifiedFor.getFile().getFullPath().toString();
      Shell _shell = this.getShell();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("The path \"");
      _builder.append(filepath);
      _builder.append("\" ");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("was already specified for the model file \"");
      _builder_1.append(alreadySpecifiedForPath);
      _builder_1.append("\". ");
      String _plus = (_builder.toString() + _builder_1);
      MessageDialog.openError(_shell, "Path already specified", _plus);
      return null;
    }
    IFile selectedFile = null;
    try {
      final Path selectedFilePath = new Path(filepath);
      selectedFile = ResourcesPlugin.getWorkspace().getRoot().getFile(selectedFilePath);
    } catch (final Throwable _t) {
      if (_t instanceof RuntimeException) {
        final RuntimeException ex = (RuntimeException)_t;
        MessageDialog.openError(this.getShell(), "Invalid file path specified", ex.getMessage());
        selectedFile = null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    if ((selectedFile == null)) {
      return null;
    }
    boolean _exists = ResourcesPlugin.getWorkspace().getRoot().exists(selectedFile.getProject().getFullPath());
    boolean _not = (!_exists);
    if (_not) {
      Shell _shell_1 = this.getShell();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("\"");
      IPath _fullPath = selectedFile.getParent().getFullPath();
      _builder_2.append(_fullPath);
      _builder_2.append("\" is not a project in the current workspace.");
      MessageDialog.openError(_shell_1, "Invalid file path specified", _builder_2.toString());
      return null;
    }
    boolean _exists_1 = selectedFile.exists();
    boolean _not_1 = (!_exists_1);
    if (_not_1) {
      Shell _shell_2 = this.getShell();
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("The specified path \"");
      _builder_3.append(filepath);
      _builder_3.append("\" does not point to an existing ");
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("file. Code generators may not be able to use the file and will likely show ");
      String _plus_1 = (_builder_3.toString() + _builder_4);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("unexpected behavior. Do you want to proceed?");
      String _plus_2 = (_plus_1 + _builder_5);
      final int buttonPressed = MessageDialog.open(MessageDialog.QUESTION, _shell_2, ("File does not " + 
        "exist"), _plus_2, SWT.NONE, "Yes", "No");
      if ((buttonPressed == 1)) {
        return null;
      }
    } else {
      final XMIResource xmiResource = LemmaUiUtils.loadXmiResource(selectedFile);
      boolean _xifexpression = false;
      boolean _isEmpty_1 = xmiResource.getContents().isEmpty();
      if (_isEmpty_1) {
        _xifexpression = true;
      } else {
        boolean _xblockexpression = false;
        {
          final EObject root = xmiResource.getContents().get(0);
          final Class<? extends EObject> expectedRootClass = this.modelFile.getFileTypeDescription().getOutputModelTypes().get(0).getRootClass();
          boolean _isAssignableFrom = expectedRootClass.isAssignableFrom(root.getClass());
          _xblockexpression = (!_isAssignableFrom);
        }
        _xifexpression = _xblockexpression;
      }
      final boolean showConfirmDialog = _xifexpression;
      if (showConfirmDialog) {
        Shell _shell_3 = this.getShell();
        StringConcatenation _builder_6 = new StringConcatenation();
        _builder_6.append("The file under the specified path ");
        StringConcatenation _builder_7 = new StringConcatenation();
        _builder_7.append("\"");
        _builder_7.append(filepath);
        _builder_7.append("\" does not contain the expected type of model. Do you want to ");
        String _plus_3 = (_builder_6.toString() + _builder_7);
        StringConcatenation _builder_8 = new StringConcatenation();
        _builder_8.append("proceed?");
        String _plus_4 = (_plus_3 + _builder_8);
        final int buttonPressed_1 = MessageDialog.open(MessageDialog.QUESTION, _shell_3, ("File does " + 
          "not contain expected model type"), _plus_4, SWT.NONE, "Yes", "No");
        if ((buttonPressed_1 == 1)) {
          return null;
        }
      }
    }
    return selectedFile;
  }

  /**
   * Create the dialog's content
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
    this.createContainerSelection(container);
    this.createFilepathInput(container);
    this.selectInitialResource(this.initialResource);
    return area;
  }

  /**
   * Create the file container selection tree
   */
  private void createContainerSelection(final Composite parent) {
    TreeViewer _treeViewer = new TreeViewer(parent);
    this.containerSelectionTree = _treeViewer;
    final Class<? extends EObject> intermediateModelRootClass = this.modelFile.getFileTypeDescription().getOutputModelTypes().get(0).getRootClass();
    FileContainerSelectionTreeContentProvider _fileContainerSelectionTreeContentProvider = new FileContainerSelectionTreeContentProvider(intermediateModelRootClass);
    this.containerSelectionTree.setContentProvider(_fileContainerSelectionTreeContentProvider);
    this.containerSelectionTree.setLabelProvider(
      WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider());
    ViewerComparator _viewerComparator = new ViewerComparator();
    this.containerSelectionTree.setComparator(_viewerComparator);
    this.containerSelectionTree.setUseHashlookup(true);
    final GridData treeViewerData = new GridData();
    treeViewerData.grabExcessHorizontalSpace = true;
    treeViewerData.grabExcessVerticalSpace = true;
    treeViewerData.horizontalAlignment = GridData.FILL;
    treeViewerData.verticalAlignment = GridData.FILL;
    Tree _tree = this.containerSelectionTree.getTree();
    _tree.setLayoutData(treeViewerData);
    this.containerSelectionTree.addDoubleClickListener(new IDoubleClickListener() {
      @Override
      public void doubleClick(final DoubleClickEvent event) {
        Object _source = event.getSource();
        boolean _not = (!(_source instanceof TreeViewer));
        if (_not) {
          return;
        }
        ISelection _selection = FileContainerSelectionDialog.this.containerSelectionTree.getSelection();
        final ITreeSelection elementSelection = ((ITreeSelection) _selection);
        if ((((elementSelection == null) || 
          elementSelection.isEmpty()) || 
          (!(elementSelection instanceof IStructuredSelection)))) {
          return;
        }
        final Object selectedElement = elementSelection.getFirstElement();
        boolean _expandedState = FileContainerSelectionDialog.this.containerSelectionTree.getExpandedState(selectedElement);
        if (_expandedState) {
          FileContainerSelectionDialog.this.containerSelectionTree.collapseToLevel(selectedElement, TreeViewer.ALL_LEVELS);
        } else {
          FileContainerSelectionDialog.this.containerSelectionTree.expandToLevel(selectedElement, 1);
        }
      }
    });
    this.containerSelectionTree.addSelectionChangedListener(new ISelectionChangedListener() {
      @Override
      public void selectionChanged(final SelectionChangedEvent event) {
        IResource selectedResource = null;
        if ((FileContainerSelectionDialog.this.initialSelection != null)) {
          selectedResource = FileContainerSelectionDialog.this.initialSelection;
          FileContainerSelectionDialog.this.initialSelection = null;
        } else {
          ISelection _selection = event.getSelection();
          final IStructuredSelection selection = ((IStructuredSelection) _selection);
          Object _firstElement = selection.getFirstElement();
          selectedResource = ((IResource) _firstElement);
        }
        if ((selectedResource instanceof IFile)) {
          final Function<IFile, String> _function = (IFile it) -> {
            return it.getFullPath().toString();
          };
          FileContainerSelectionDialog.this.filepathField.setText(LemmaUiUtils.removeExtension(((IFile)selectedResource), _function));
        } else {
          if ((selectedResource instanceof IContainer)) {
            String _string = ((IContainer)selectedResource).getFullPath().toString();
            String _plus = (_string + "/");
            FileContainerSelectionDialog.this.filepathField.setText(_plus);
          }
        }
      }
    });
    this.containerSelectionTree.setInput(ResourcesPlugin.getWorkspace());
  }

  /**
   * Create input text field for the file path and related labels
   */
  private void createFilepathInput(final Composite parent) {
    final Composite inputContainer = new Composite(parent, SWT.NONE);
    GridData _gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
    inputContainer.setLayoutData(_gridData);
    GridLayout _gridLayout = new GridLayout(3, false);
    inputContainer.setLayout(_gridLayout);
    final Label filepathLabel = new Label(inputContainer, SWT.NULL);
    filepathLabel.setText("File path:");
    Text _text = new Text(inputContainer, (SWT.SINGLE | SWT.BORDER));
    this.filepathField = _text;
    final GridData filepathData = new GridData();
    filepathData.grabExcessHorizontalSpace = true;
    filepathData.horizontalAlignment = GridData.FILL;
    this.filepathField.setLayoutData(filepathData);
    final Label extensionLabel = new Label(inputContainer, SWT.NULL);
    extensionLabel.setText(".xmi");
  }

  /**
   * Select initial resource after the dialog's startup
   */
  private void selectInitialResource(final IResource resource) {
    this.initialSelection = resource;
    final ArrayList<IContainer> itemsToExpand = CollectionLiterals.<IContainer>newArrayList();
    IContainer parent = resource.getParent();
    while ((parent != null)) {
      {
        itemsToExpand.add(0, parent);
        parent = parent.getParent();
      }
    }
    this.containerSelectionTree.setExpandedElements(itemsToExpand.toArray());
    IResource _xifexpression = null;
    boolean _exists = resource.exists();
    if (_exists) {
      _xifexpression = resource;
    } else {
      _xifexpression = resource.getParent();
    }
    final IResource selectionResource = _xifexpression;
    StructuredSelection _structuredSelection = new StructuredSelection(selectionResource);
    this.containerSelectionTree.setSelection(_structuredSelection, true);
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
    int _max = Math.max(this.convertHorizontalDLUsToPixels(FileContainerSelectionDialog.MIN_DIALOG_WIDTH), shellSize.x);
    int _max_1 = Math.max(this.convertVerticalDLUsToPixels(FileContainerSelectionDialog.MIN_DIALOG_HEIGHT), shellSize.y);
    return new Point(_max, _max_1);
  }

  @Pure
  public IFile getSelectedFile() {
    return this.selectedFile;
  }
}
