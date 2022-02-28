package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ui

import org.eclipse.ui.dialogs.ElementTreeSelectionDialog
import org.eclipse.swt.widgets.Shell
import org.eclipse.swt.widgets.Composite
import org.eclipse.core.resources.IProject
import org.eclipse.jface.dialogs.MessageDialog

import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.core.resources.IFile
import org.eclipse.ui.model.BaseWorkbenchContentProvider
import org.eclipse.core.resources.IContainer
import org.eclipse.ui.model.WorkbenchLabelProvider
import org.eclipse.core.resources.ResourcesPlugin

/**
 * Dialog to select files from an Eclipse project.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class ProjectFileSelectionDialog extends ElementTreeSelectionDialog {
    IProject project
    @Accessors(PUBLIC_GETTER)
    IFile selectedFile

    /**
     * Constructor
     */
    new(Shell parent, IProject project) {
        super(parent, new WorkbenchLabelProvider(), new ProjectWorkbenchContentProvider(project))
        this.project = project
        input = ResourcesPlugin.workspace.root
        message = "Please select a file from the project tree:"
    }

    /**
     * Workbench content provider for Eclipse projects
     */
    final static class ProjectWorkbenchContentProvider extends BaseWorkbenchContentProvider {
        var IProject project

        /**
         * Constructor
         */
        new(IProject project) {
            this.project = project
        }

        /**
         * Get project elements from workbench
         */
        final override getElements(Object inputElement) {
            val elements = super.getElements(inputElement)
            return #[elements.findFirst[it instanceof IProject && (it as IProject) == project]]
        }

        /**
         * Get IContainer children of a parent workbench element
         */
        final override getChildren(Object parentElement) {
            val children = super.getChildren(parentElement)
            return children.filter[it instanceof IContainer || it instanceof IFile]
        }
    }

    /**
     * Internal callback for dialog area creation
     */
    final override createDialogArea(Composite parent) {
        val composite = super.createDialogArea(parent) as Composite
        treeViewer.expandedElements = project
        return composite
    }

    /**
     * OK button was pressed
     */
    final override okPressed() {
        selectedFile = treeViewer.selection.selectedFile
        if (selectedFile === null) {
            MessageDialog.openError(shell, "No file selected", "Please select a file from the " +
                "project tree.")
            return
        }

        super.okPressed
    }

    /**
     * Get the selected IFile from the tree viewer's ISelection
     */
    private def getSelectedFile(ISelection selection) {
        if (!(selection instanceof IStructuredSelection) || selection.empty)
            return null

        val selectedElement = (selection as IStructuredSelection).toList.get(0)
        return if (selectedElement instanceof IFile)
                selectedElement as IFile
            else
                null
    }
}