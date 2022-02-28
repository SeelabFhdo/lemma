package de.fhdo.lemma.model_processing.eclipse.launcher.ui

import org.eclipse.jface.viewers.ColumnViewerEditorActivationListener
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent
import org.eclipse.jface.viewers.ColumnViewerEditorDeactivationEvent
import org.eclipse.jface.viewers.ViewerCell
import org.eclipse.jface.viewers.ColumnViewer

/**
 * Column viewer editor activation listener that updates the edited element after the editor was
 * deactivated. Consequently, a new value for a property of the element won't disappear from the
 * control after it was set in the bound domain object.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class UpdatingColumnViewerEditorActivationListener
    extends ColumnViewerEditorActivationListener {
    val ColumnViewer viewer

    /**
     * Constructor
     */
    new(ColumnViewer viewer) {
        this.viewer = viewer
    }

    /**
     * Editor was deactivated. Update the edited element.
     */
    final override afterEditorDeactivated(ColumnViewerEditorDeactivationEvent event) {
        val cell = event.source as ViewerCell
        viewer.update(cell.element, null)
    }

    final override afterEditorActivated(ColumnViewerEditorActivationEvent event) {
        // NOOP
    }

    final override beforeEditorActivated(ColumnViewerEditorActivationEvent event) {
        // NOOP
    }

    final override beforeEditorDeactivated(ColumnViewerEditorDeactivationEvent event) {
        // NOOP
    }
}