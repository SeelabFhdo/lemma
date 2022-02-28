package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ui

import org.eclipse.swt.widgets.Shell
import org.eclipse.swt.widgets.Composite

import org.eclipse.ui.dialogs.ResourceListSelectionDialog
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.resources.IResource

/**
 * Dialog to select a project from the Eclipse workspace.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class ProjectSelectionDialog extends ResourceListSelectionDialog {
    var initializePattern = true

    /**
     * Constructor
     */
    new(Shell parentShell) {
        super(parentShell, ResourcesPlugin.workspace.root, IResource.PROJECT)
    }

    /**
     * Create the dialog area
     */
    final override createDialogArea(Composite parent) {
        val dialogArea = super.createDialogArea(parent)
        // Let the dialog display all available projects based on the pattern provided by
        // adjustPattern()
        refresh(false)
        return dialogArea
    }

    /**
     * Get the pattern for project selection
     */
    final override adjustPattern() {
        // Let the dialog display all available projects after its opening
        return if (initializePattern) {
                initializePattern = false
                "*"
            } else
                super.adjustPattern()
    }

    /**
     * Get the selected project or null if no project was selected
     */
    final def getSelectedProject() {
        return if (result !== null && !result.empty)
                result.get(0) as IProject
            else
                null
    }
}