package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ui

import org.eclipse.swt.widgets.Shell
import org.eclipse.swt.widgets.Composite

import org.eclipse.jface.dialogs.Dialog

import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*
import static org.apache.commons.lang.StringUtils.*
import org.eclipse.jface.viewers.TableViewer
import org.eclipse.jface.viewers.IStructuredContentProvider
import org.eclipse.swt.layout.GridData
import org.eclipse.jface.viewers.ColumnLabelProvider
import org.eclipse.jface.viewers.TableViewerColumn
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.Point
import org.eclipse.jface.dialogs.MessageDialog
import org.eclipse.jface.window.Window
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.jface.viewers.IStructuredSelection
import java.io.IOException
import java.util.List
import java.util.stream.Collectors

/**
 * Dialog for selecting a local Docker image.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class LocalDockerImageSelectionDialog extends Dialog {
    static val IMAGE_TAG_SEPARATOR = ":"

    val List<Pair<String, String>>imagesAndTags
    val List<String> invalidImages
    var TableViewer viewer
    @Accessors(PUBLIC_GETTER)
    var String selectedImage = null

    /**
     * Constructor
     */
    new(Shell parentShell, String basicDockerCommand) {
        super(parentShell)

        if (basicDockerCommand.nullOrEmpty)
            throw new IllegalArgumentException("Docker selection dialog requires basic Docker " +
                "command but none was given")

        val images = queryImagesWithTags(basicDockerCommand, IMAGE_TAG_SEPARATOR)
        val splitResult = images.splitImagesByTag(IMAGE_TAG_SEPARATOR)
        imagesAndTags = splitResult.key
        invalidImages = splitResult.value
    }

    /**
     * Query local Docker images leveraging the basic Docker command. Returns the list of available
     * images including their tags. Throws an exception in case the executed query command, i.e.,
     * the basic Docker command plus some image query parameters, returns an exit code other than 0.
     */
    private def queryImagesWithTags(String basicDockerCommand, String imageTagSeperator) {
        val queryCommand = '''«basicDockerCommand» image ls --format ''' + "'{{.Repository}}" +
            imageTagSeperator + "{{.Tag}}'"

        val queryExitCodeAndResult = try {
            executeShellCommandBlocking(queryCommand, 100, 10)
        } catch (IOException ex) {
            throw new IllegalArgumentException("Available Docker images not determinable: " +
                '''Invalid query command "«queryCommand»"''')
        }

        val exitCode = queryExitCodeAndResult.key
        val queryResult = queryExitCodeAndResult.value
        return if (exitCode == 0)
                queryResult.lines.sorted.collect(Collectors.toList)
            else
                throw new IllegalArgumentException("Available Docker images not determinable. " +
                    '''Command "«queryCommand»" returned with exit code «exitCode»: ''' +
                    queryResult)
    }

    /**
     * Split the given list of images with tags into a list of pairs with the image name as key and
     * the respective tag as value. Splitting assumes that each entry in the list of images with
     * tags starts with the image name, followed by a Docker-specific separator (usually a colon)
     * and the tag name. Next to the list of image-tag pairs, the method returns a second list that
     * comprises images that could not be split due to an non-supported format, e.g., an unexpected
     * tag separator.
     */
    private def splitImagesByTag(List<String> imagesWithTags, String imageTagSeperator) {
        val splitImagesAndTags = <Pair<String, String>>newArrayList
        val unparseableImages = <String>newArrayList

        imagesWithTags.forEach[
            // Remove possible apostrophes at the beginning and end of an image name. The occurrence
            // of the apostrophes may result from the image query command and is shell-dependent.
            val result = removeEnd(removeStart(it, "'"), "'")
            val image = substringBeforeLast(result, imageTagSeperator)
            val tag = substringAfterLast(result, imageTagSeperator)
            if (!image.nullOrEmpty && !tag.nullOrEmpty)
                splitImagesAndTags.add(image -> tag)
            else
                unparseableImages.add(it)
        ]

        return splitImagesAndTags -> unparseableImages
    }

    /**
     * Create dialog area
     */
    final override createDialogArea(Composite parent) {
        val container = super.createDialogArea(parent) as Composite

        viewer = new TableViewer(container)
        viewer.contentProvider = new IStructuredContentProvider() {
            override getElements(Object inputElement) {
                return imagesAndTags
            }
        }
        viewer.addDoubleClickListener([
            val selection = it.selection as IStructuredSelection
            val imageAndTag = selection?.firstElement as Pair<String, String>
            if (imageAndTag !== null)
                okPressedFor(imageAndTag)
        ])
        viewer.table.headerVisible = true
        viewer.table.linesVisible = true
        viewer.table.layoutData = new GridData(GridData.FILL, GridData.FILL, true, true)

        createImageColumn()
        createTagColumn()

        viewer.input = imagesAndTags

        return container
    }

    /**
     * Trigger click on OK for the given image and tag as dialog selection
     */
    private def okPressedFor(Pair<String, String> imageAndTag) {
        selectedImage = '''«imageAndTag.key»:«imageAndTag.value»'''
        super.okPressed()
    }

    /**
     * Create image column for the table viewer
     */
    private def createImageColumn() {
        val column = new TableViewerColumn(viewer, SWT.NONE)
        column.column.width = 300
        column.column.text = "Image"
        column.labelProvider = new ColumnLabelProvider() {
            override getText(Object element) {
                return (element as Pair<String, String>).key
            }
        }
    }

    /**
     * Create tag column for the table viewer
     */
    private def createTagColumn() {
        val column = new TableViewerColumn(viewer, SWT.NONE)
        column.column.width = 150
        column.column.text = "Tag"
        column.labelProvider = new ColumnLabelProvider() {
            override getText(Object element) {
                return (element as Pair<String, String>).value
            }
        }
    }

    /**
     * Flag to indicate that the dialog is resizable
     */
    final override isResizable() {
        return true
    }

    /**
     * Determine the initial dialog size
     */
    final override getInitialSize() {
        return new Point(600, 700)
    }

    /**
     * Configure the shell
     */
    final override configureShell(Shell shell) {
        super.configureShell(shell)
        shell.text = "Docker Image Selection"
    }

    /**
     * Open the dialog
     */
    final override open() {
        if (imagesAndTags.empty) {
            MessageDialog.openError(shell, "No Docker Images", "No local Docker images found")
            return Window.CANCEL
        }

        if (!invalidImages.empty)
            MessageDialog.openWarning(shell, "Non-Parseable Docker Images", "The image or tag " +
                "names of the following local Docker images could not be parsed:\n" +
                invalidImages.map['''\t- «it»'''].join("\n") + "\nThey will be " +
                "missing in the list of selectable images")

        return super.open()
    }

    /**
     * OK button was pressed
     */
    final override okPressed() {
        val selectedRow = singleRowSelectionOrError(viewer)?.firstElement as Pair<String, String>
        if (selectedRow !== null)
            okPressedFor(selectedRow)
    }

    /**
     * Cancel button was pressed
     */
    final override cancelPressed() {
        selectedImage = null
        super.cancelPressed()
    }
}