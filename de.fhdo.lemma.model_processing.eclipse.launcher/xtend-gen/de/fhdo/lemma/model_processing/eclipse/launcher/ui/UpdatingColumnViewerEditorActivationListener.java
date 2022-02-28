package de.fhdo.lemma.model_processing.eclipse.launcher.ui;

import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationListener;
import org.eclipse.jface.viewers.ColumnViewerEditorDeactivationEvent;
import org.eclipse.jface.viewers.ViewerCell;

/**
 * Column viewer editor activation listener that updates the edited element after the editor was
 * deactivated. Consequently, a new value for a property of the element won't disappear from the
 * control after it was set in the bound domain object.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class UpdatingColumnViewerEditorActivationListener extends ColumnViewerEditorActivationListener {
  private final ColumnViewer viewer;
  
  /**
   * Constructor
   */
  public UpdatingColumnViewerEditorActivationListener(final ColumnViewer viewer) {
    this.viewer = viewer;
  }
  
  /**
   * Editor was deactivated. Update the edited element.
   */
  @Override
  public final void afterEditorDeactivated(final ColumnViewerEditorDeactivationEvent event) {
    Object _source = event.getSource();
    final ViewerCell cell = ((ViewerCell) _source);
    this.viewer.update(cell.getElement(), null);
  }
  
  @Override
  public final void afterEditorActivated(final ColumnViewerEditorActivationEvent event) {
  }
  
  @Override
  public final void beforeEditorActivated(final ColumnViewerEditorActivationEvent event) {
  }
  
  @Override
  public final void beforeEditorDeactivated(final ColumnViewerEditorDeactivationEvent event) {
  }
}
