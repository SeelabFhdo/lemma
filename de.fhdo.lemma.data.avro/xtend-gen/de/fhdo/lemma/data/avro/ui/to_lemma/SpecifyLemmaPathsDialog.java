package de.fhdo.lemma.data.avro.ui.to_lemma;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.data.avro.ui.Util;
import de.fhdo.lemma.data.avro.ui.to_lemma.ModelKindStyledLabelProvider;
import de.fhdo.lemma.data.avro.ui.to_lemma.ModelTableCheckboxColumnEditingSupport;
import de.fhdo.lemma.data.avro.ui.to_lemma.ModelTableTargetPathColumnEditingSupport;
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils;
import de.fhdo.lemma.service.ServiceModel;
import de.fhdo.lemma.technology.Technology;
import de.fhdo.lemma.technology.mapping.TechnologyMapping;
import de.fhdo.lemma.utils.LemmaUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
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
import org.eclipse.swt.widgets.TableColumn;
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
 * Dialog for LEMMA paths specification.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class SpecifyLemmaPathsDialog extends TitleAreaDialog {
  /**
   * Helper class to represent a certain LEMMA model kind with a name and icon. Furthermore, it
   * may be configured whether the model kind should point to an existing resource in its
   * transformation target path.
   */
  public static class LemmaModelKind {
    @Accessors(AccessorType.PUBLIC_GETTER)
    private Class<? extends EObject> kind;
    
    @Accessors(AccessorType.PUBLIC_GETTER)
    private String name;
    
    @Accessors(AccessorType.PUBLIC_GETTER)
    private String hint;
    
    @Accessors(AccessorType.PUBLIC_GETTER)
    private Image icon;
    
    @Accessors(AccessorType.PUBLIC_GETTER)
    private boolean pathShouldExist;
    
    public String targetPath;
    
    public boolean selectedForTransformation;
    
    /**
     * Constructor
     */
    public LemmaModelKind(final Class<? extends EObject> kind, final String name, final String iconFile, final boolean pathShouldExist, final String targetPath) {
      this.kind = kind;
      this.name = name;
      this.icon = LemmaUiUtils.createImage(SpecifyLemmaPathsDialog.RESOURCE_MANAGER, SpecifyLemmaPathsDialog.class, iconFile);
      this.pathShouldExist = pathShouldExist;
      String _xifexpression = null;
      if (pathShouldExist) {
        _xifexpression = "Specified path should point to existing resource";
      } else {
        _xifexpression = "";
      }
      this.hint = _xifexpression;
      this.targetPath = targetPath;
      this.selectedForTransformation = true;
    }
    
    /**
     * Compare with Object (does not correspond to equals()-contract on purpose)
     */
    @Override
    public boolean equals(final Object o) {
      return Objects.equal(this.kind, o);
    }
    
    /**
     * Get hash code
     */
    @Override
    public int hashCode() {
      return this.kind.hashCode();
    }
    
    @Pure
    public Class<? extends EObject> getKind() {
      return this.kind;
    }
    
    @Pure
    public String getName() {
      return this.name;
    }
    
    @Pure
    public String getHint() {
      return this.hint;
    }
    
    @Pure
    public Image getIcon() {
      return this.icon;
    }
    
    @Pure
    public boolean isPathShouldExist() {
      return this.pathShouldExist;
    }
  }
  
  private static final int MIN_DIALOG_WIDTH = 500;
  
  private static final int MIN_DIALOG_HEIGHT = 250;
  
  private static final int DESELECT_ALL = 2;
  
  private static final int SELECT_ALL = 3;
  
  private static final ResourceManager RESOURCE_MANAGER = new LocalResourceManager(JFaceResources.getResources());
  
  private static final Image CHECKBOX_ACTIVE_ICON = LemmaUiUtils.createImage(SpecifyLemmaPathsDialog.RESOURCE_MANAGER, SpecifyLemmaPathsDialog.class, 
    "checkboxActive.gif");
  
  private static final Image CHECKBOX_INACTIVE_ICON = LemmaUiUtils.createImage(SpecifyLemmaPathsDialog.RESOURCE_MANAGER, SpecifyLemmaPathsDialog.class, 
    "checkboxInactive.gif");
  
  private final ArrayList<SpecifyLemmaPathsDialog.LemmaModelKind> MODEL_KINDS = CollectionLiterals.<SpecifyLemmaPathsDialog.LemmaModelKind>newArrayList();
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private Map<Class<? extends EObject>, Pair<String, String>> modelKindPaths = CollectionLiterals.<Class<? extends EObject>, Pair<String, String>>newHashMap();
  
  private TableViewer tableViewer;
  
  private IProject project;
  
  /**
   * Constructor
   */
  public SpecifyLemmaPathsDialog(final Shell parentShell, final IContainer container) {
    super(parentShell);
    this.project = container.getProject();
    String _withFile = this.withFile(container, "Domain.data");
    SpecifyLemmaPathsDialog.LemmaModelKind _lemmaModelKind = new SpecifyLemmaPathsDialog.LemmaModelKind(DataModel.class, "Data Model", "dataModel.gif", false, _withFile);
    this.MODEL_KINDS.add(_lemmaModelKind);
    String _withFile_1 = this.withFile(container, "Microservices.services");
    SpecifyLemmaPathsDialog.LemmaModelKind _lemmaModelKind_1 = new SpecifyLemmaPathsDialog.LemmaModelKind(ServiceModel.class, "Service Model", "serviceModel.gif", true, _withFile_1);
    this.MODEL_KINDS.add(_lemmaModelKind_1);
    String _withFile_2 = this.withFile(container, "Avro.mapping");
    SpecifyLemmaPathsDialog.LemmaModelKind _lemmaModelKind_2 = new SpecifyLemmaPathsDialog.LemmaModelKind(TechnologyMapping.class, "Mapping Model", "mappingModel.gif", 
      false, _withFile_2);
    this.MODEL_KINDS.add(_lemmaModelKind_2);
    String _withFile_3 = this.withFile(this.project, "Avro.technology");
    SpecifyLemmaPathsDialog.LemmaModelKind _lemmaModelKind_3 = new SpecifyLemmaPathsDialog.LemmaModelKind(Technology.class, "Technology Model", "technologyModel.png", 
      false, _withFile_3);
    this.MODEL_KINDS.add(_lemmaModelKind_3);
  }
  
  /**
   * Add the given filename to the full path of an IContainer
   */
  private String withFile(final IContainer container, final String filename) {
    return container.getFullPath().append(filename).toString();
  }
  
  /**
   * Create dialog (to be called after constructor and before open())
   */
  @Override
  public void create() {
    super.create();
    this.setTitle("Specify Paths for LEMMA Models");
    this.setMessage(("Specify target paths for the LEMMA models to be derived from the previously " + 
      "selected Avro schemas"));
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
    this.createModelKindTable(container);
    return area;
  }
  
  /**
   * Create model kind table
   */
  private void createModelKindTable(final Composite parent) {
    this.createTableViewer(parent);
    this.createCheckboxColumn();
    this.createModelKindColumn();
    this.createHintColumn();
    this.createTargetPathColumn();
    this.tableViewer.setInput(this.MODEL_KINDS);
  }
  
  /**
   * Create table viewer
   */
  private void createTableViewer(final Composite parent) {
    TableViewer _tableViewer = new TableViewer(parent);
    this.tableViewer = _tableViewer;
    this.tableViewer.setContentProvider(new IStructuredContentProvider() {
      @Override
      public Object[] getElements(final Object inputElement) {
        return ((Object[])Conversions.unwrapArray(SpecifyLemmaPathsDialog.this.MODEL_KINDS, Object.class));
      }
    });
    Table _table = this.tableViewer.getTable();
    _table.setHeaderVisible(true);
    Table _table_1 = this.tableViewer.getTable();
    _table_1.setLinesVisible(true);
    Table _table_2 = this.tableViewer.getTable();
    GridData _gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
    _table_2.setLayoutData(_gridData);
    Table _table_3 = this.tableViewer.getTable();
    _table_3.addListener(SWT.Selection, new Listener() {
      @Override
      public void handleEvent(final Event event) {
        event.detail = SWT.NONE;
        event.type = SWT.None;
        event.doit = false;
        try {
          Table _table = SpecifyLemmaPathsDialog.this.tableViewer.getTable();
          _table.setRedraw(false);
          SpecifyLemmaPathsDialog.this.tableViewer.getTable().deselectAll();
        } finally {
          Table _table_1 = SpecifyLemmaPathsDialog.this.tableViewer.getTable();
          _table_1.setRedraw(true);
        }
      }
    });
  }
  
  /**
   * Create checkbox column
   */
  private void createCheckboxColumn() {
    final TableViewerColumn column = new TableViewerColumn(this.tableViewer, SWT.NONE);
    TableColumn _column = column.getColumn();
    _column.setWidth(20);
    column.setLabelProvider(new ColumnLabelProvider() {
      @Override
      public String getText(final Object element) {
        return null;
      }
      
      @Override
      public Image getImage(final Object element) {
        Image _xifexpression = null;
        if (((SpecifyLemmaPathsDialog.LemmaModelKind) element).selectedForTransformation) {
          _xifexpression = SpecifyLemmaPathsDialog.CHECKBOX_ACTIVE_ICON;
        } else {
          _xifexpression = SpecifyLemmaPathsDialog.CHECKBOX_INACTIVE_ICON;
        }
        return _xifexpression;
      }
    });
    final Predicate<Pair<SpecifyLemmaPathsDialog.LemmaModelKind, Boolean>> _function = (Pair<SpecifyLemmaPathsDialog.LemmaModelKind, Boolean> it) -> {
      final Boolean newSelectedForTransformation = it.getValue();
      if ((!(newSelectedForTransformation).booleanValue())) {
        return true;
      }
      final SpecifyLemmaPathsDialog.LemmaModelKind affectedModelKind = it.getKey();
      final Function1<SpecifyLemmaPathsDialog.LemmaModelKind, Boolean> _function_1 = (SpecifyLemmaPathsDialog.LemmaModelKind it_1) -> {
        return Boolean.valueOf(((it_1.selectedForTransformation && 
          (!Objects.equal(it_1, affectedModelKind))) && 
          Objects.equal(it_1.targetPath, affectedModelKind.targetPath)));
      };
      final boolean duplicatePathExists = IterableExtensions.<SpecifyLemmaPathsDialog.LemmaModelKind>exists(this.MODEL_KINDS, _function_1);
      if (duplicatePathExists) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("path ");
        _builder.append(affectedModelKind.targetPath);
        _builder.append("\" was already specified for another ");
        String _plus = ("The transformation target " + _builder);
        String _plus_1 = (_plus + 
          "model kind.");
        Util.showError("Duplicate transformation target path", _plus_1);
      }
      return (!duplicatePathExists);
    };
    final Predicate<Pair<SpecifyLemmaPathsDialog.LemmaModelKind, Boolean>> checkboxValidator = _function;
    ModelTableCheckboxColumnEditingSupport _modelTableCheckboxColumnEditingSupport = new ModelTableCheckboxColumnEditingSupport(this.tableViewer, checkboxValidator);
    column.setEditingSupport(_modelTableCheckboxColumnEditingSupport);
  }
  
  /**
   * Create model kind column
   */
  private void createModelKindColumn() {
    final TableViewerColumn column = new TableViewerColumn(this.tableViewer, SWT.NONE);
    TableColumn _column = column.getColumn();
    _column.setWidth(130);
    TableColumn _column_1 = column.getColumn();
    _column_1.setText("Model kind");
    ModelKindStyledLabelProvider _modelKindStyledLabelProvider = new ModelKindStyledLabelProvider();
    DelegatingStyledCellLabelProvider _delegatingStyledCellLabelProvider = new DelegatingStyledCellLabelProvider(_modelKindStyledLabelProvider);
    column.setLabelProvider(_delegatingStyledCellLabelProvider);
  }
  
  /**
   * Create hint column
   */
  private void createHintColumn() {
    final TableViewerColumn column = new TableViewerColumn(this.tableViewer, SWT.NONE);
    TableColumn _column = column.getColumn();
    _column.setWidth(270);
    TableColumn _column_1 = column.getColumn();
    _column_1.setText("Hint");
    column.setLabelProvider(new ColumnLabelProvider() {
      @Override
      public String getText(final Object element) {
        return ((SpecifyLemmaPathsDialog.LemmaModelKind) element).hint;
      }
    });
  }
  
  /**
   * Create target path column
   */
  private void createTargetPathColumn() {
    final TableViewerColumn column = new TableViewerColumn(this.tableViewer, SWT.NONE);
    TableColumn _column = column.getColumn();
    _column.setWidth(470);
    column.getColumn().setText("Project-related transformation target path");
    column.setLabelProvider(new ColumnLabelProvider() {
      @Override
      public String getText(final Object element) {
        return ((SpecifyLemmaPathsDialog.LemmaModelKind) element).targetPath;
      }
    });
    final Predicate<Pair<SpecifyLemmaPathsDialog.LemmaModelKind, String>> _function = (Pair<SpecifyLemmaPathsDialog.LemmaModelKind, String> it) -> {
      final SpecifyLemmaPathsDialog.LemmaModelKind affectedModelKind = it.getKey();
      if ((!affectedModelKind.selectedForTransformation)) {
        return true;
      }
      final String newTargetPath = it.getValue();
      final Function1<SpecifyLemmaPathsDialog.LemmaModelKind, Boolean> _function_1 = (SpecifyLemmaPathsDialog.LemmaModelKind it_1) -> {
        return Boolean.valueOf(((it_1.selectedForTransformation && 
          (!Objects.equal(it_1, affectedModelKind))) && 
          Objects.equal(it_1.targetPath, newTargetPath)));
      };
      final boolean duplicatePathExists = IterableExtensions.<SpecifyLemmaPathsDialog.LemmaModelKind>exists(this.MODEL_KINDS, _function_1);
      if (duplicatePathExists) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("path ");
        _builder.append(newTargetPath);
        _builder.append("\" was already specified for another model kind");
        String _plus = ("The transformation target " + _builder);
        String _plus_1 = (_plus + 
          "Change aborted.");
        Util.showError("Duplicate transformation target path", _plus_1);
      }
      return (!duplicatePathExists);
    };
    final Predicate<Pair<SpecifyLemmaPathsDialog.LemmaModelKind, String>> targetPathValidator = _function;
    ModelTableTargetPathColumnEditingSupport _modelTableTargetPathColumnEditingSupport = new ModelTableTargetPathColumnEditingSupport(this.tableViewer, targetPathValidator);
    column.setEditingSupport(_modelTableTargetPathColumnEditingSupport);
  }
  
  /**
   * Create buttons for the button bar
   */
  @Override
  public void createButtonsForButtonBar(final Composite parent) {
    this.createButton(parent, SpecifyLemmaPathsDialog.DESELECT_ALL, "Deselect all", false);
    this.createButton(parent, SpecifyLemmaPathsDialog.SELECT_ALL, "Select all", false);
    super.createButtonsForButtonBar(parent);
  }
  
  /**
   * Catch button press
   */
  @Override
  public void buttonPressed(final int buttonId) {
    switch (buttonId) {
      case SpecifyLemmaPathsDialog.DESELECT_ALL:
        this.deselectAllPressed();
        break;
      case SpecifyLemmaPathsDialog.SELECT_ALL:
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
   * "Deselect all" button was pressed
   */
  private void deselectAllPressed() {
    final Consumer<SpecifyLemmaPathsDialog.LemmaModelKind> _function = (SpecifyLemmaPathsDialog.LemmaModelKind it) -> {
      it.selectedForTransformation = false;
    };
    this.MODEL_KINDS.forEach(_function);
    this.tableViewer.refresh();
  }
  
  /**
   * "Select all" button was pressed
   */
  private void selectAllPressed() {
    final Consumer<SpecifyLemmaPathsDialog.LemmaModelKind> _function = (SpecifyLemmaPathsDialog.LemmaModelKind it) -> {
      it.selectedForTransformation = true;
    };
    this.MODEL_KINDS.forEach(_function);
    this.tableViewer.refresh();
  }
  
  /**
   * OK button was pressed
   */
  @Override
  public void okPressed() {
    final Function1<SpecifyLemmaPathsDialog.LemmaModelKind, Boolean> _function = (SpecifyLemmaPathsDialog.LemmaModelKind it) -> {
      return Boolean.valueOf(it.selectedForTransformation);
    };
    final Function1<SpecifyLemmaPathsDialog.LemmaModelKind, Class<? extends EObject>> _function_1 = (SpecifyLemmaPathsDialog.LemmaModelKind it) -> {
      return it.kind;
    };
    final Function1<SpecifyLemmaPathsDialog.LemmaModelKind, Pair<String, String>> _function_2 = (SpecifyLemmaPathsDialog.LemmaModelKind it) -> {
      String _absoluteFilepath = this.toAbsoluteFilepath(it.targetPath);
      return Pair.<String, String>of(it.targetPath, _absoluteFilepath);
    };
    final Map<Class<? extends EObject>, Pair<String, String>> modelKindFilepaths = IterableExtensions.<SpecifyLemmaPathsDialog.LemmaModelKind, Class<? extends EObject>, Pair<String, String>>toMap(IterableExtensions.<SpecifyLemmaPathsDialog.LemmaModelKind>filter(this.MODEL_KINDS, _function), _function_1, _function_2);
    boolean _isEmpty = modelKindFilepaths.isEmpty();
    if (_isEmpty) {
      Util.showError("No model files selected", ("Please select at least one model file. " + 
        "Transformation aborted."));
      return;
    }
    final Function1<Pair<String, String>, String> _function_3 = (Pair<String, String> it) -> {
      return it.getValue();
    };
    boolean _overwriteExistingFiles = this.overwriteExistingFiles(IterableExtensions.<String>toList(IterableExtensions.<Pair<String, String>, String>map(modelKindFilepaths.values(), _function_3)));
    boolean _not = (!_overwriteExistingFiles);
    if (_not) {
      return;
    }
    this.modelKindPaths = modelKindFilepaths;
    super.okPressed();
  }
  
  /**
   * Convert a project-relative path to an absolute file path
   */
  private String toAbsoluteFilepath(final String projectRelativePath) {
    return LemmaUtils.removeFileUri(LemmaUtils.convertProjectPathToAbsoluteFileUri(projectRelativePath));
  }
  
  /**
   * Ask to overwrite existing files in the given list of file paths. Returns false if the user
   * does not agree to overwrite existing files and true otherwise.
   */
  private boolean overwriteExistingFiles(final List<String> filepaths) {
    final Function1<String, File> _function = (String it) -> {
      return new File(it);
    };
    final Function1<File, Boolean> _function_1 = (File it) -> {
      return Boolean.valueOf(it.exists());
    };
    final Function1<File, String> _function_2 = (File it) -> {
      return it.getName();
    };
    String existingFiles = IterableExtensions.join(IterableExtensions.<File, String>map(IterableExtensions.<File>filter(ListExtensions.<String, File>map(filepaths, _function), _function_1), _function_2), "\n\t- ");
    boolean _xifexpression = false;
    boolean _isEmpty = existingFiles.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      boolean _xblockexpression = false;
      {
        existingFiles = (("\n\t- " + existingFiles) + "\n\n");
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("workspace and will be overwritten:");
        _builder.append(existingFiles);
        _builder.append("Do you want to proceed?");
        String _plus = ("The following files already exist in the " + _builder);
        _xblockexpression = Util.question("Overwrite Existing Files?", _plus);
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = true;
    }
    return _xifexpression;
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
    int _max = Math.max(this.convertHorizontalDLUsToPixels(SpecifyLemmaPathsDialog.MIN_DIALOG_WIDTH), shellSize.x);
    int _max_1 = Math.max(this.convertVerticalDLUsToPixels(SpecifyLemmaPathsDialog.MIN_DIALOG_HEIGHT), shellSize.y);
    return new Point(_max, _max_1);
  }
  
  /**
   * Dispose resource manager
   */
  @Override
  public void closeTray() {
    SpecifyLemmaPathsDialog.RESOURCE_MANAGER.dispose();
    super.closeTray();
  }
  
  @Pure
  public Map<Class<? extends EObject>, Pair<String, String>> getModelKindPaths() {
    return this.modelKindPaths;
  }
}
