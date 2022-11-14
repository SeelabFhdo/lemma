package de.fhdo.lemma.data.avro.ui.to_avro;

import de.fhdo.lemma.utils.LemmaUtils;
import java.io.File;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Dialog to select files from an Eclipse project.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ProjectFileSelectionDialog extends ElementTreeSelectionDialog {
  private String initialFilename = "";
  
  private IProject project;
  
  private String fileExtension;
  
  private Text filenameInput;
  
  private ControlDecoration filenameWarning;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private IContainer targetContainer;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String targetFilepath;
  
  /**
   * Constructor
   */
  public ProjectFileSelectionDialog(final Shell parent, final IProject project, final String initialFilename, final String fileExtension, final ILabelProvider labelProvider) {
    super(parent, labelProvider, new ProjectWorkbenchContentProvider(project));
    this.project = project;
    this.initialFilename = initialFilename;
    String _xifexpression = null;
    if ((fileExtension != null)) {
      _xifexpression = LemmaUtils.removePrefix(fileExtension, ".", true);
    } else {
      _xifexpression = "";
    }
    this.fileExtension = _xifexpression;
  }
  
  /**
   * Create dialog (to be called after constructor and before open())
   */
  @Override
  public void create() {
    super.create();
    this.updateFilenameWarningDisplay();
  }
  
  /**
   * Helper to update the warning sign on the filename input based on the tree viewer's selection
   * and the filename input
   */
  private void updateFilenameWarningDisplay() {
    final String filepath = this.projectRelativeFilepath(this.getSelectedContainer(this.getTreeViewer().getSelection()));
    boolean _existsInWorkspace = this.existsInWorkspace(filepath);
    if (_existsInWorkspace) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Resource ");
      _builder.append(filepath);
      _builder.append(" already exists in ");
      String _plus = (_builder.toString() + 
        "workspace and will be overwritten. Do you want to proceed?");
      this.filenameWarning.setDescriptionText(_plus);
      this.filenameWarning.show();
    } else {
      this.filenameWarning.hide();
    }
  }
  
  /**
   * Check if the given project-relative path to a file already exists in the current Eclipse
   * workspace
   */
  private boolean existsInWorkspace(final String projectRelativeFilepath) {
    return ((!projectRelativeFilepath.isEmpty()) && 
      (ResourcesPlugin.getWorkspace().getRoot().findMember(projectRelativeFilepath) != null));
  }
  
  /**
   * Get file path of filename input relative to the given IContainer
   */
  private String projectRelativeFilepath(final IContainer container) {
    String _xifexpression = null;
    if ((this.filenameInput.getText().isEmpty() || (container == null))) {
      _xifexpression = "";
    } else {
      IPath _fullPath = container.getFullPath();
      StringConcatenation _builder = new StringConcatenation();
      String _text = this.filenameInput.getText();
      _builder.append(_text);
      _builder.append(".");
      _builder.append(this.fileExtension);
      _xifexpression = _fullPath.append(_builder.toString()).toString();
    }
    return _xifexpression;
  }
  
  /**
   * Get the selected IContainer from the tree viewer's ISelection
   */
  private IContainer getSelectedContainer(final ISelection selection) {
    IContainer _xifexpression = null;
    if (((selection instanceof IStructuredSelection) && (!selection.isEmpty()))) {
      Object _get = ((IStructuredSelection) selection).toList().get(0);
      _xifexpression = ((IContainer) _get);
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  /**
   * Internal callback for dialog area creation
   */
  @Override
  public Control createDialogArea(final Composite parent) {
    Control _createDialogArea = super.createDialogArea(parent);
    final Composite composite = ((Composite) _createDialogArea);
    TreeViewer _treeViewer = this.getTreeViewer();
    _treeViewer.setExpandedElements(this.project);
    final Composite filenameRow = new Composite(composite, SWT.NONE);
    GridData _gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
    filenameRow.setLayoutData(_gridData);
    GridLayout _gridLayout = new GridLayout(3, false);
    filenameRow.setLayout(_gridLayout);
    final Label filenameLabel = new Label(filenameRow, SWT.NONE);
    filenameLabel.setText("Filename:");
    Text _text = new Text(filenameRow, SWT.BORDER);
    this.filenameInput = _text;
    GridData _gridData_1 = new GridData(SWT.FILL, SWT.FILL, true, false);
    this.filenameInput.setLayoutData(_gridData_1);
    this.filenameInput.setText(this.initialFilename);
    final ModifyListener _function = (ModifyEvent it) -> {
      this.updateFilenameWarningDisplay();
    };
    this.filenameInput.addModifyListener(_function);
    ControlDecoration _controlDecoration = new ControlDecoration(this.filenameInput, (SWT.TOP ^ SWT.RIGHT));
    this.filenameWarning = _controlDecoration;
    this.filenameWarning.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_WARNING).getImage());
    boolean _isEmpty = this.fileExtension.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final Label filenameExtensionLabel = new Label(filenameRow, SWT.NONE);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(".");
      _builder.append(this.fileExtension);
      filenameExtensionLabel.setText(_builder.toString());
    }
    return composite;
  }
  
  /**
   * OK button was pressed
   */
  @Override
  public void okPressed() {
    final IContainer targetContainer = this.getSelectedContainer(this.getTreeViewer().getSelection());
    final String projectRelativeFilepath = this.projectRelativeFilepath(targetContainer);
    boolean proceed = true;
    boolean _isEmpty = projectRelativeFilepath.isEmpty();
    if (_isEmpty) {
      MessageDialog.openError(Display.getCurrent().getActiveShell(), "Invalid File Path", ("Please " + 
        "select a project folder and specify a filename to proceed."));
      proceed = false;
    } else {
      boolean _existsInWorkspace = this.existsInWorkspace(projectRelativeFilepath);
      if (_existsInWorkspace) {
        Shell _activeShell = Display.getCurrent().getActiveShell();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("A resource with the path ");
        _builder.append(projectRelativeFilepath);
        _builder.append(" already exists ");
        String _plus = (_builder.toString() + 
          "in the workspace. Do you want to proceed?");
        proceed = MessageDialog.openQuestion(_activeShell, ("Existing File " + 
          "Path"), _plus);
      }
    }
    if ((!proceed)) {
      return;
    }
    this.targetContainer = targetContainer;
    this.targetFilepath = this.abosluteFilepath(targetContainer);
    super.okPressed();
  }
  
  /**
   * Get absolute file path of filename input based on the given IContainer
   */
  private String abosluteFilepath(final IContainer container) {
    String _xifexpression = null;
    if ((this.filenameInput.getText().isEmpty() || (container == null))) {
      _xifexpression = "";
    } else {
      StringConcatenation _builder = new StringConcatenation();
      IPath _location = container.getLocation();
      _builder.append(_location);
      _builder.append(File.separator);
      String _text = this.filenameInput.getText();
      _builder.append(_text);
      _builder.append(".");
      _builder.append(this.fileExtension);
      _xifexpression = _builder.toString();
    }
    return _xifexpression;
  }
  
  @Pure
  public IContainer getTargetContainer() {
    return this.targetContainer;
  }
  
  @Pure
  public String getTargetFilepath() {
    return this.targetFilepath;
  }
}
