package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ui;

import com.google.common.base.Objects;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Dialog to select files from an Eclipse project.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class ProjectFileSelectionDialog extends ElementTreeSelectionDialog {
  /**
   * Workbench content provider for Eclipse projects
   */
  public static final class ProjectWorkbenchContentProvider extends BaseWorkbenchContentProvider {
    private IProject project;
    
    /**
     * Constructor
     */
    public ProjectWorkbenchContentProvider(final IProject project) {
      this.project = project;
    }
    
    /**
     * Get project elements from workbench
     */
    @Override
    public final Object[] getElements(final Object inputElement) {
      final Object[] elements = super.getElements(inputElement);
      final Function1<Object, Boolean> _function = (Object it) -> {
        return Boolean.valueOf(((it instanceof IProject) && Objects.equal(((IProject) it), this.project)));
      };
      Object _findFirst = IterableExtensions.<Object>findFirst(((Iterable<Object>)Conversions.doWrapArray(elements)), _function);
      return new Object[] { _findFirst };
    }
    
    /**
     * Get IContainer children of a parent workbench element
     */
    @Override
    public final Object[] getChildren(final Object parentElement) {
      final Object[] children = super.getChildren(parentElement);
      final Function1<Object, Boolean> _function = (Object it) -> {
        return Boolean.valueOf(((it instanceof IContainer) || (it instanceof IFile)));
      };
      return ((Object[])Conversions.unwrapArray(IterableExtensions.<Object>filter(((Iterable<Object>)Conversions.doWrapArray(children)), _function), Object.class));
    }
  }
  
  private IProject project;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private IFile selectedFile;
  
  /**
   * Constructor
   */
  public ProjectFileSelectionDialog(final Shell parent, final IProject project) {
    super(parent, new WorkbenchLabelProvider(), new ProjectFileSelectionDialog.ProjectWorkbenchContentProvider(project));
    this.project = project;
    this.setInput(ResourcesPlugin.getWorkspace().getRoot());
    this.setMessage("Please select a file from the project tree:");
  }
  
  /**
   * Internal callback for dialog area creation
   */
  @Override
  public final Control createDialogArea(final Composite parent) {
    Control _createDialogArea = super.createDialogArea(parent);
    final Composite composite = ((Composite) _createDialogArea);
    TreeViewer _treeViewer = this.getTreeViewer();
    _treeViewer.setExpandedElements(this.project);
    return composite;
  }
  
  /**
   * OK button was pressed
   */
  @Override
  public final void okPressed() {
    this.selectedFile = this.getSelectedFile(this.getTreeViewer().getSelection());
    if ((this.selectedFile == null)) {
      MessageDialog.openError(this.getShell(), "No file selected", ("Please select a file from the " + 
        "project tree."));
      return;
    }
    super.okPressed();
  }
  
  /**
   * Get the selected IFile from the tree viewer's ISelection
   */
  private IFile getSelectedFile(final ISelection selection) {
    if (((!(selection instanceof IStructuredSelection)) || selection.isEmpty())) {
      return null;
    }
    final Object selectedElement = ((IStructuredSelection) selection).toList().get(0);
    IFile _xifexpression = null;
    if ((selectedElement instanceof IFile)) {
      _xifexpression = ((IFile) selectedElement);
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  @Pure
  public IFile getSelectedFile() {
    return this.selectedFile;
  }
}
