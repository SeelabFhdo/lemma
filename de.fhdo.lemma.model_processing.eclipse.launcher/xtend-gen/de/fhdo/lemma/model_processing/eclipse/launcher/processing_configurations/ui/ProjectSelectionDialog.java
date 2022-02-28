package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ui;

import java.util.List;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ResourceListSelectionDialog;
import org.eclipse.xtext.xbase.lib.Conversions;

/**
 * Dialog to select a project from the Eclipse workspace.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class ProjectSelectionDialog extends ResourceListSelectionDialog {
  private boolean initializePattern = true;
  
  /**
   * Constructor
   */
  public ProjectSelectionDialog(final Shell parentShell) {
    super(parentShell, ResourcesPlugin.getWorkspace().getRoot(), IResource.PROJECT);
  }
  
  /**
   * Create the dialog area
   */
  @Override
  public final Control createDialogArea(final Composite parent) {
    final Control dialogArea = super.createDialogArea(parent);
    this.refresh(false);
    return dialogArea;
  }
  
  /**
   * Get the pattern for project selection
   */
  @Override
  public final String adjustPattern() {
    String _xifexpression = null;
    if (this.initializePattern) {
      String _xblockexpression = null;
      {
        this.initializePattern = false;
        _xblockexpression = "*";
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = super.adjustPattern();
    }
    return _xifexpression;
  }
  
  /**
   * Get the selected project or null if no project was selected
   */
  public final IProject getSelectedProject() {
    IProject _xifexpression = null;
    if (((this.getResult() != null) && (!((List<Object>)Conversions.doWrapArray(this.getResult())).isEmpty()))) {
      Object _get = this.getResult()[0];
      _xifexpression = ((IProject) _get);
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
}
