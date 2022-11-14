package de.fhdo.lemma.data.avro.ui.to_avro

import org.eclipse.ui.dialogs.ElementTreeSelectionDialog
import org.eclipse.swt.widgets.Shell
import org.eclipse.jface.viewers.ILabelProvider
import org.eclipse.swt.widgets.Composite
import org.eclipse.core.resources.IProject
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Text
import org.eclipse.swt.widgets.Display
import org.eclipse.jface.dialogs.MessageDialog

import static de.fhdo.lemma.utils.LemmaUtils.*
import org.eclipse.core.resources.IContainer
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.jface.fieldassist.ControlDecoration
import org.eclipse.jface.fieldassist.FieldDecorationRegistry
import org.eclipse.xtend.lib.annotations.Accessors
import java.io.File

/**
 * Dialog to select files from an Eclipse project.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ProjectFileSelectionDialog extends ElementTreeSelectionDialog {
    String initialFilename = ""
    IProject project
    String fileExtension
    Text filenameInput
    ControlDecoration filenameWarning
    @Accessors(PUBLIC_GETTER)
    IContainer targetContainer
    @Accessors(PUBLIC_GETTER)
    String targetFilepath

    /**
     * Constructor
     */
    new(Shell parent, IProject project, String initialFilename, String fileExtension,
        ILabelProvider labelProvider) {
        super(parent, labelProvider, new ProjectWorkbenchContentProvider(project))
        this.project = project
        this.initialFilename = initialFilename

        this.fileExtension = if (fileExtension !== null)
                removePrefix(fileExtension, ".", true)
            else
                ""
    }

    /**
     * Create dialog (to be called after constructor and before open())
     */
    override create() {
        super.create()
        updateFilenameWarningDisplay()
    }

    /**
     * Helper to update the warning sign on the filename input based on the tree viewer's selection
     * and the filename input
     */
    private def void updateFilenameWarningDisplay() {
        val filepath = treeViewer.selection.selectedContainer.projectRelativeFilepath
        if (filepath.existsInWorkspace) {
            filenameWarning.descriptionText = '''Resource «filepath» already exists in ''' +
                "workspace and will be overwritten. Do you want to proceed?"
            filenameWarning.show
        } else
            filenameWarning.hide
    }

    /**
     * Check if the given project-relative path to a file already exists in the current Eclipse
     * workspace
     */
    private def boolean existsInWorkspace(String projectRelativeFilepath) {
        return !projectRelativeFilepath.empty &&
            ResourcesPlugin.workspace.root.findMember(projectRelativeFilepath) !== null
    }

    /**
     * Get file path of filename input relative to the given IContainer
     */
    private def String projectRelativeFilepath(IContainer container) {
        return if (filenameInput.text.empty || container === null)
                ""
            else
                container.fullPath.append('''«filenameInput.text».«fileExtension»''').toString
    }

    /**
     * Get the selected IContainer from the tree viewer's ISelection
     */
    private def IContainer getSelectedContainer(ISelection selection) {
        return if (selection instanceof IStructuredSelection && !selection.empty)
            (selection as IStructuredSelection).toList.get(0) as IContainer
        else
            null
    }

    /**
     * Internal callback for dialog area creation
     */
    override createDialogArea(Composite parent) {
        val composite = super.createDialogArea(parent) as Composite
        treeViewer.expandedElements = project

        val filenameRow = new Composite(composite, SWT.NONE)
        filenameRow.layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)
        filenameRow.layout = new GridLayout(3, false)

        val filenameLabel = new Label(filenameRow, SWT.NONE)
        filenameLabel.text = "Filename:"

        filenameInput = new Text(filenameRow, SWT.BORDER)
        filenameInput.layoutData = new GridData(SWT.FILL, SWT.FILL, true, false)
        filenameInput.text = initialFilename
        filenameInput.addModifyListener([updateFilenameWarningDisplay()])

        filenameWarning = new ControlDecoration(filenameInput, SWT.TOP.bitwiseXor(SWT.RIGHT))
        filenameWarning.image = FieldDecorationRegistry.getDefault
            .getFieldDecoration(FieldDecorationRegistry.DEC_WARNING)
            .image

        if (!fileExtension.empty) {
            val filenameExtensionLabel = new Label(filenameRow, SWT.NONE)
            filenameExtensionLabel.text = '''.«fileExtension»'''
        }

        return composite
    }

    /**
     * OK button was pressed
     */
    override okPressed() {
        val targetContainer = treeViewer.selection.selectedContainer
        val projectRelativeFilepath = targetContainer.projectRelativeFilepath

        var proceed = true
        if (projectRelativeFilepath.empty) {
            MessageDialog.openError(Display.current.activeShell, "Invalid File Path", "Please " +
                "select a project folder and specify a filename to proceed.")
            proceed = false
        } else if (projectRelativeFilepath.existsInWorkspace)
            proceed = MessageDialog.openQuestion(Display.current.activeShell, "Existing File " +
                "Path", '''A resource with the path «projectRelativeFilepath» already exists ''' +
                "in the workspace. Do you want to proceed?")

        if (!proceed) {
            return
        }

        this.targetContainer = targetContainer
        this.targetFilepath = targetContainer.abosluteFilepath
        super.okPressed
    }

    /**
     * Get absolute file path of filename input based on the given IContainer
     */
    private def String abosluteFilepath(IContainer container) {
        return if (filenameInput.text.empty || container === null)
                ""
            else
                '''«container.location»«File.separator»«filenameInput.text».«fileExtension»'''
    }
}