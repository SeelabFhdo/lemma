package de.fhdo.ddmm.eclipse.ui.specify_paths_dialog;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import de.fhdo.ddmm.eclipse.ui.AbstractUiModelTransformationStrategy;
import de.fhdo.ddmm.eclipse.ui.ModelFile;
import de.fhdo.ddmm.eclipse.ui.ModelFileStyledLabelProvider;
import de.fhdo.ddmm.eclipse.ui.file_container_selection_dialog.FileContainerSelectionDialog;
import de.fhdo.ddmm.eclipse.ui.specify_paths_dialog.ModelTableCheckboxColumnEditingSupport;
import de.fhdo.ddmm.eclipse.ui.specify_paths_dialog.ModelTableContentProvider;
import de.fhdo.ddmm.eclipse.ui.specify_paths_dialog.ModelTableTransformationTargetPathColumnEditingSupport;
import de.fhdo.ddmm.eclipse.ui.utils.DdmmUiUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Generic dialog to specify paths for subsequent intermediate model transformations.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class SpecifyPathsDialog extends TitleAreaDialog {
  private final static int MIN_DIALOG_WIDTH = 500;
  
  private final static int MIN_DIALOG_HEIGHT = 250;
  
  private final static int UNSELECT_ALL = 2;
  
  private final static int SELECT_ALL = 3;
  
  private final static ResourceManager RESOURCE_MANAGER = new LocalResourceManager(JFaceResources.getResources());
  
  private Shell parentShell;
  
  private Map<String, List<ModelFile>> inputModelFiles;
  
  private AbstractUiModelTransformationStrategy strategy;
  
  private TableViewer tableViewer;
  
  private Image checkboxActive;
  
  private Image checkboxInactive;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private List<ModelFile> selectedModelFiles = CollectionLiterals.<ModelFile>newArrayList();
  
  /**
   * Constructor
   */
  public SpecifyPathsDialog(final Shell parentShell, final AbstractUiModelTransformationStrategy strategy, final Map<String, List<ModelFile>> inputModelFiles) {
    super(parentShell);
    if ((parentShell == null)) {
      throw new IllegalArgumentException("Shell must not be null");
    } else {
      if ((strategy == null)) {
        throw new IllegalArgumentException("Transformation strategy must not be null");
      } else {
        if (((inputModelFiles == null) || inputModelFiles.isEmpty())) {
          throw new IllegalArgumentException("Input models must not be null or empty");
        }
      }
    }
    this.parentShell = parentShell;
    this.strategy = strategy;
    this.inputModelFiles = inputModelFiles;
    this.checkboxActive = DdmmUiUtils.createImage(SpecifyPathsDialog.RESOURCE_MANAGER, "checkboxActive.gif");
    this.checkboxInactive = DdmmUiUtils.createImage(SpecifyPathsDialog.RESOURCE_MANAGER, "checkboxInactive.gif");
  }
  
  /**
   * Create dialog (to be called after constructor and before open())
   */
  @Override
  public void create() {
    super.create();
    String _elvis = null;
    String _specifyPathsDialogTitle = this.strategy.getSpecifyPathsDialogTitle();
    if (_specifyPathsDialogTitle != null) {
      _elvis = _specifyPathsDialogTitle;
    } else {
      _elvis = "";
    }
    final String title = _elvis;
    this.setTitle(title);
    String _elvis_1 = null;
    String _specifyPathsDialogMessage = this.strategy.getSpecifyPathsDialogMessage();
    if (_specifyPathsDialogMessage != null) {
      _elvis_1 = _specifyPathsDialogMessage;
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
    this.createModelTable(container);
    return area;
  }
  
  /**
   * Create buttons for the button bar
   */
  @Override
  public void createButtonsForButtonBar(final Composite parent) {
    this.createButton(parent, SpecifyPathsDialog.UNSELECT_ALL, "Unselect all", false);
    this.createButton(parent, SpecifyPathsDialog.SELECT_ALL, "Select all", false);
    super.createButtonsForButtonBar(parent);
  }
  
  /**
   * Catch button press
   */
  @Override
  public void buttonPressed(final int buttonId) {
    switch (buttonId) {
      case SpecifyPathsDialog.UNSELECT_ALL:
        this.unselectAllPressed();
        break;
      case SpecifyPathsDialog.SELECT_ALL:
        this.selectAllPressed();
        break;
      case IDialogConstants.OK_ID:
        this.okPressed();
        break;
      case IDialogConstants.CANCEL_ID:
        this.cancelPressed();
        break;
    }
  }
  
  /**
   * "Unselect all" was pressed
   */
  private void unselectAllPressed() {
    final Consumer<ModelFile> _function = (ModelFile it) -> {
      it.setSelectedForTransformation(false);
    };
    Iterables.<ModelFile>concat(this.inputModelFiles.values()).forEach(_function);
    this.tableViewer.refresh();
  }
  
  /**
   * "Select all" was pressed
   */
  private void selectAllPressed() {
    final Consumer<ModelFile> _function = (ModelFile it) -> {
      it.setSelectedForTransformation(true);
    };
    Iterables.<ModelFile>concat(this.inputModelFiles.values()).forEach(_function);
    this.tableViewer.refresh();
  }
  
  /**
   * OK button was pressed
   */
  @Override
  public void okPressed() {
    this.selectedModelFiles = this.filterSelectedModelFiles();
    boolean _isEmpty = this.selectedModelFiles.isEmpty();
    if (_isEmpty) {
      MessageDialog.openError(this.parentShell, "No model files selected", ("Please select at " + 
        "least one model file. Transformation aborted."));
      return;
    }
    final Map<String, IFile> childrenPaths = this.getPathsForUnselectedChildren(this.selectedModelFiles);
    if ((childrenPaths == null)) {
      return;
    }
    this.distributeSpecifiedPaths(this.selectedModelFiles, childrenPaths);
    super.okPressed();
  }
  
  /**
   * Helper for getting the paths for unselected children of selected model files from user
   * interaction
   */
  private Map<String, IFile> getPathsForUnselectedChildren(final List<ModelFile> selectedModelFiles) {
    final Set<ModelFile> unselectedChildren = this.filterUnselectedChildren(selectedModelFiles);
    boolean _isEmpty = unselectedChildren.isEmpty();
    if (_isEmpty) {
      return Collections.EMPTY_MAP;
    }
    final int buttonPressed = MessageDialog.open(MessageDialog.QUESTION_WITH_CANCEL, this.parentShell, 
      "How to proceed with paths of unselected, imported model files?", (((("Some of the model " + 
      "files not being selected for transformation are imported by model files that are ") + 
      "selected for transformation. In the transformation process, however, imported model ") + 
      "files are linked to importing model files on the basis of their paths. How do you ") + 
      "want to proceed in regard of the paths of the unselected, imported model files?"), 
      SWT.NONE, "Specify Paths manually", "Return to Dialog", "Use Paths from Dialog");
    Map<String, IFile> _switchResult = null;
    switch (buttonPressed) {
      case 0:
        _switchResult = this.manualPathSpecificationForUnselectedChildren(unselectedChildren, selectedModelFiles);
        break;
      case 1:
        _switchResult = null;
        break;
      case 2:
        _switchResult = this.useCurrentPathsForUnselectedChildren(unselectedChildren);
        break;
    }
    return _switchResult;
  }
  
  /**
   * Distribute specified paths across children of selected model files
   */
  private void distributeSpecifiedPaths(final List<ModelFile> selectedModelFiles, final Map<String, IFile> childrenPaths) {
    final Function1<ModelFile, String> _function = (ModelFile it) -> {
      return it.getFile().getFullPath().toString();
    };
    final Function1<ModelFile, String> _function_1 = (ModelFile it) -> {
      return it.getTransformationTargetPath();
    };
    final Map<String, String> allSpecifiedPaths = IterableExtensions.<ModelFile, String, String>toMap(selectedModelFiles, _function, _function_1);
    final BiConsumer<String, IFile> _function_2 = (String physicalPath, IFile specifiedFile) -> {
      allSpecifiedPaths.put(physicalPath, specifiedFile.getFullPath().toString());
    };
    childrenPaths.forEach(_function_2);
    final Function1<ModelFile, List<ModelFile>> _function_3 = (ModelFile it) -> {
      return it.getChildren();
    };
    final Consumer<ModelFile> _function_4 = (ModelFile it) -> {
      final String childPath = it.getFile().getFullPath().toString();
      it.setTransformationTargetPath(allSpecifiedPaths.get(childPath));
    };
    Iterables.<ModelFile>concat(ListExtensions.<ModelFile, List<ModelFile>>map(selectedModelFiles, _function_3)).forEach(_function_4);
  }
  
  /**
   * Helper to handle user decision of using the current paths for unselected children
   */
  private Map<String, IFile> useCurrentPathsForUnselectedChildren(final Set<ModelFile> unselectedChildren) {
    final Function1<ModelFile, Boolean> _function = (ModelFile it) -> {
      boolean _xblockexpression = false;
      {
        String _transformationTargetPath = it.getTransformationTargetPath();
        final Path transformationTargetPath = new Path(_transformationTargetPath);
        final IFile unselectedFile = ResourcesPlugin.getWorkspace().getRoot().getFile(transformationTargetPath);
        boolean _exists = unselectedFile.exists();
        _xblockexpression = (!_exists);
      }
      return Boolean.valueOf(_xblockexpression);
    };
    final boolean fileNotExisting = IterableExtensions.<ModelFile>exists(unselectedChildren, _function);
    boolean _xifexpression = false;
    if (fileNotExisting) {
      _xifexpression = MessageDialog.openConfirm(this.getShell(), "Non-existent Paths in Dialog", (("In the dialog, " + 
        "the transformation paths of some unselected children point to files that do ") + 
        "not exist. Do you want to proceed with the transformation?"));
    } else {
      _xifexpression = true;
    }
    final boolean proceedWithTransformation = _xifexpression;
    Map<String, IFile> _xifexpression_1 = null;
    if (proceedWithTransformation) {
      final Function1<ModelFile, String> _function_1 = (ModelFile it) -> {
        return it.getFile().getFullPath().toString();
      };
      final Function1<ModelFile, IFile> _function_2 = (ModelFile it) -> {
        return it.getFile();
      };
      _xifexpression_1 = IterableExtensions.<ModelFile, String, IFile>toMap(unselectedChildren, _function_1, _function_2);
    } else {
      _xifexpression_1 = null;
    }
    return _xifexpression_1;
  }
  
  /**
   * Enable user to manually specify a path for an imported model file that hasn't been selected
   * for transformation
   */
  private HashMap<String, IFile> manualPathSpecificationForUnselectedChildren(final Set<ModelFile> unselectedChildren, final List<ModelFile> selectedModelFiles) {
    final Function1<ModelFile, String> _function = (ModelFile it) -> {
      return it.getTransformationTargetPath();
    };
    final Map<String, ModelFile> alreadySpecifiedPaths = IterableExtensions.<String, ModelFile>toMap(selectedModelFiles, _function);
    final HashMap<String, IFile> manualPaths = CollectionLiterals.<String, IFile>newHashMap();
    final int childCount = unselectedChildren.size();
    int i = 0;
    while ((i < childCount)) {
      {
        final ModelFile child = ((ModelFile[])Conversions.unwrapArray(unselectedChildren, ModelFile.class))[i];
        final String childFullPath = child.getFile().getFullPath().toString();
        final IFile existingManualPath = manualPaths.get(childFullPath);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Specify path of imported model file (");
        _builder.append((i + 1));
        _builder.append(" of ");
        _builder.append(childCount);
        _builder.append(")");
        final String dialogTitle = _builder.toString();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Please select a container and filename for the imported ");
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("model file \"");
        _builder_2.append(childFullPath);
        _builder_2.append("\". The filename needs to end with .xmi and ");
        String _plus = (_builder_1.toString() + _builder_2);
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("should point to an existing XMI file in the workspace.");
        final String dialogMessage = (_plus + _builder_3);
        Shell _shell = this.getShell();
        final FileContainerSelectionDialog fileContainerSelectionDialog = new FileContainerSelectionDialog(_shell, child, existingManualPath, alreadySpecifiedPaths, dialogTitle, dialogMessage, (i + 1), childCount);
        fileContainerSelectionDialog.create();
        final int dialogResult = fileContainerSelectionDialog.open();
        switch (dialogResult) {
          case FileContainerSelectionDialog.ABORT:
            return null;
          case FileContainerSelectionDialog.CANCEL:
            i++;
            break;
          case FileContainerSelectionDialog.PREVIOUS:
            i--;
            break;
          case FileContainerSelectionDialog.NEXT:
          case FileContainerSelectionDialog.RUN_TRANSFORMATIONS:
            final IFile selectedFile = fileContainerSelectionDialog.getSelectedFile();
            if ((existingManualPath != null)) {
              alreadySpecifiedPaths.remove(existingManualPath.getFullPath().toString());
            }
            alreadySpecifiedPaths.put(selectedFile.getFullPath().toString(), child);
            manualPaths.put(childFullPath, selectedFile);
            i++;
            break;
        }
      }
    }
    return manualPaths;
  }
  
  /**
   * Helper method to get selected model files
   */
  private List<ModelFile> filterSelectedModelFiles() {
    final Function1<ModelFile, Boolean> _function = (ModelFile it) -> {
      return Boolean.valueOf(it.isSelectedForTransformation());
    };
    final List<ModelFile> selectedModelFiles = IterableExtensions.<ModelFile>toList(IterableExtensions.<ModelFile>filter(Iterables.<ModelFile>concat(this.inputModelFiles.values()), _function));
    final Consumer<ModelFile> _function_1 = (ModelFile it) -> {
      IPath _fullPath = it.getFile().getProject().getFullPath();
      String _transformationTargetPath = it.getTransformationTargetPath();
      String _plus = (_fullPath + _transformationTargetPath);
      it.setTransformationTargetPath(_plus);
    };
    selectedModelFiles.forEach(_function_1);
    return selectedModelFiles;
  }
  
  /**
   * Helper method to get unselected imported model files of selected model files, i.e., their
   * "children"
   */
  private Set<ModelFile> filterUnselectedChildren(final List<ModelFile> selectedModelFiles) {
    final Function1<ModelFile, Iterable<ModelFile>> _function = (ModelFile it) -> {
      final Function1<ModelFile, Boolean> _function_1 = (ModelFile it_1) -> {
        boolean _isSelectedForTransformation = it_1.isSelectedForTransformation();
        return Boolean.valueOf((!_isSelectedForTransformation));
      };
      return IterableExtensions.<ModelFile>filter(it.getChildren(), _function_1);
    };
    final Set<ModelFile> unselectedChildren = IterableExtensions.<ModelFile>toSet(Iterables.<ModelFile>concat(ListExtensions.<ModelFile, Iterable<ModelFile>>map(selectedModelFiles, _function)));
    final Consumer<ModelFile> _function_1 = (ModelFile it) -> {
      IPath _fullPath = it.getFile().getProject().getFullPath();
      String _transformationTargetPath = it.getTransformationTargetPath();
      String _plus = (_fullPath + _transformationTargetPath);
      it.setTransformationTargetPath(_plus);
    };
    unselectedChildren.forEach(_function_1);
    return unselectedChildren;
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
    int _max = Math.max(this.convertHorizontalDLUsToPixels(SpecifyPathsDialog.MIN_DIALOG_WIDTH), shellSize.x);
    int _max_1 = Math.max(this.convertVerticalDLUsToPixels(SpecifyPathsDialog.MIN_DIALOG_HEIGHT), shellSize.y);
    return new Point(_max, _max_1);
  }
  
  /**
   * Close dialog
   */
  @Override
  public void closeTray() {
    SpecifyPathsDialog.RESOURCE_MANAGER.dispose();
    super.closeTray();
  }
  
  /**
   * Create table viewer for dialog area
   */
  private void createModelTable(final Composite parent) {
    this.createTableViewer(parent);
    this.createCheckboxColumn();
    this.createModelFileColumn();
    this.createModelTypeColumn();
    this.createTransformationTargetPathColumn();
    this.tableViewer.setInput(this.inputModelFiles);
  }
  
  /**
   * Helper to create the dialog's table viewer
   */
  private void createTableViewer(final Composite parent) {
    TableViewer _tableViewer = new TableViewer(parent);
    this.tableViewer = _tableViewer;
    ModelTableContentProvider _modelTableContentProvider = new ModelTableContentProvider(this.strategy);
    this.tableViewer.setContentProvider(_modelTableContentProvider);
    this.tableViewer.getTable().setHeaderVisible(true);
    this.tableViewer.getTable().setLinesVisible(true);
    final GridData tableViewerData = new GridData();
    tableViewerData.grabExcessHorizontalSpace = true;
    tableViewerData.grabExcessVerticalSpace = true;
    tableViewerData.horizontalAlignment = GridData.FILL;
    tableViewerData.verticalAlignment = GridData.FILL;
    this.tableViewer.getTable().setLayoutData(tableViewerData);
    Table _table = this.tableViewer.getTable();
    _table.addListener(SWT.Selection, new Listener() {
      @Override
      public void handleEvent(final Event event) {
        event.detail = SWT.NONE;
        event.type = SWT.None;
        event.doit = false;
        try {
          SpecifyPathsDialog.this.tableViewer.getTable().setRedraw(false);
          SpecifyPathsDialog.this.tableViewer.getTable().deselectAll();
        } finally {
          SpecifyPathsDialog.this.tableViewer.getTable().setRedraw(true);
        }
      }
    });
  }
  
  /**
   * Helper to create the table's checkbox column
   */
  private void createCheckboxColumn() {
    final TableViewerColumn tableViewerColumnCheckbox = new TableViewerColumn(this.tableViewer, SWT.NONE);
    tableViewerColumnCheckbox.getColumn().setWidth(20);
    tableViewerColumnCheckbox.setLabelProvider(new ColumnLabelProvider() {
      @Override
      public String getText(final Object element) {
        return null;
      }
      
      @Override
      public Image getImage(final Object element) {
        Image _xifexpression = null;
        boolean _isSelectedForTransformation = ((ModelFile) element).isSelectedForTransformation();
        if (_isSelectedForTransformation) {
          _xifexpression = SpecifyPathsDialog.this.checkboxActive;
        } else {
          _xifexpression = SpecifyPathsDialog.this.checkboxInactive;
        }
        return _xifexpression;
      }
    });
    final Predicate<Pair<ModelFile, Boolean>> _function = (Pair<ModelFile, Boolean> it) -> {
      final Boolean newSelectedForTransformation = it.getValue();
      if ((!(newSelectedForTransformation).booleanValue())) {
        return true;
      }
      final ModelFile affectedModelFile = it.getKey();
      final Function1<ModelFile, Boolean> _function_1 = (ModelFile it_1) -> {
        return Boolean.valueOf(((it_1.isSelectedForTransformation() && 
          (!Objects.equal(it_1, affectedModelFile))) && 
          Objects.equal(it_1.getTransformationTargetPath(), affectedModelFile.getTransformationTargetPath())));
      };
      final boolean duplicatePathExists = IterableExtensions.<ModelFile>exists(Iterables.<ModelFile>concat(this.inputModelFiles.values()), _function_1);
      if (duplicatePathExists) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("The transformation target path ");
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("\"");
        String _transformationTargetPath = affectedModelFile.getTransformationTargetPath();
        _builder_1.append(_transformationTargetPath);
        _builder_1.append("\" was already specified ");
        String _plus = (_builder.toString() + _builder_1);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("for another file.");
        String _plus_1 = (_plus + _builder_2);
        MessageDialog.openError(this.parentShell, "Duplicate transformation target path", _plus_1);
      }
      return (!duplicatePathExists);
    };
    final Predicate<Pair<ModelFile, Boolean>> checkboxValidator = _function;
    ModelTableCheckboxColumnEditingSupport _modelTableCheckboxColumnEditingSupport = new ModelTableCheckboxColumnEditingSupport(this.tableViewer, checkboxValidator);
    tableViewerColumnCheckbox.setEditingSupport(_modelTableCheckboxColumnEditingSupport);
  }
  
  /**
   * Helper to create the table's model file column
   */
  private void createModelFileColumn() {
    final TableViewerColumn tableViewerColumnModelFile = new TableViewerColumn(this.tableViewer, SWT.NONE);
    tableViewerColumnModelFile.getColumn().setWidth(300);
    tableViewerColumnModelFile.getColumn().setText("Model file");
    ModelFileStyledLabelProvider _modelFileStyledLabelProvider = new ModelFileStyledLabelProvider();
    DelegatingStyledCellLabelProvider _delegatingStyledCellLabelProvider = new DelegatingStyledCellLabelProvider(_modelFileStyledLabelProvider);
    tableViewerColumnModelFile.setLabelProvider(_delegatingStyledCellLabelProvider);
  }
  
  /**
   * Helper to create the table's model type column
   */
  private void createModelTypeColumn() {
    final TableViewerColumn tableViewerColumnModelType = new TableViewerColumn(this.tableViewer, SWT.NONE);
    tableViewerColumnModelType.getColumn().setWidth(110);
    tableViewerColumnModelType.getColumn().setText("Model type");
    tableViewerColumnModelType.setLabelProvider(new ColumnLabelProvider() {
      @Override
      public String getText(final Object element) {
        return ((ModelFile) element).getFileTypeDescription().getDescription();
      }
    });
  }
  
  /**
   * Helper to create the table's transformation target path column
   */
  private void createTransformationTargetPathColumn() {
    final TableViewerColumn tableViewerColumnTransformationTargetPath = new TableViewerColumn(this.tableViewer, SWT.NONE);
    tableViewerColumnTransformationTargetPath.getColumn().setWidth(470);
    tableViewerColumnTransformationTargetPath.getColumn().setText(("Project-related transformation " + 
      "target path"));
    tableViewerColumnTransformationTargetPath.setLabelProvider(new ColumnLabelProvider() {
      @Override
      public String getText(final Object element) {
        return ((ModelFile) element).getTransformationTargetPath();
      }
    });
    final Predicate<Pair<ModelFile, String>> _function = (Pair<ModelFile, String> it) -> {
      final ModelFile affectedModelFile = it.getKey();
      boolean _isSelectedForTransformation = affectedModelFile.isSelectedForTransformation();
      boolean _not = (!_isSelectedForTransformation);
      if (_not) {
        return true;
      }
      final String newTransformationTargetPath = it.getValue();
      final Function1<ModelFile, Boolean> _function_1 = (ModelFile it_1) -> {
        return Boolean.valueOf(((it_1.isSelectedForTransformation() && 
          (!Objects.equal(it_1, affectedModelFile))) && 
          Objects.equal(it_1.getTransformationTargetPath(), newTransformationTargetPath)));
      };
      final boolean duplicatePathExists = IterableExtensions.<ModelFile>exists(Iterables.<ModelFile>concat(this.inputModelFiles.values()), _function_1);
      if (duplicatePathExists) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("The transformation target path \"");
        _builder.append(newTransformationTargetPath);
        _builder.append("\" was ");
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("already specified for another file. Change aborted.");
        String _plus = (_builder.toString() + _builder_1);
        MessageDialog.openError(this.parentShell, "Duplicate transformation target path", _plus);
      }
      return (!duplicatePathExists);
    };
    final Predicate<Pair<ModelFile, String>> transformationTargetPathValidator = _function;
    ModelTableTransformationTargetPathColumnEditingSupport _modelTableTransformationTargetPathColumnEditingSupport = new ModelTableTransformationTargetPathColumnEditingSupport(this.tableViewer, transformationTargetPathValidator);
    tableViewerColumnTransformationTargetPath.setEditingSupport(_modelTableTransformationTargetPathColumnEditingSupport);
  }
  
  @Pure
  public List<ModelFile> getSelectedModelFiles() {
    return this.selectedModelFiles;
  }
}
