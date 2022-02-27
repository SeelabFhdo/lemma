package de.fhdo.lemma.eclipse.ui.internal

import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider
import org.eclipse.jface.viewers.LabelProvider
import org.eclipse.jface.resource.ResourceManager
import org.eclipse.swt.graphics.Image
import org.eclipse.jface.resource.LocalResourceManager
import org.eclipse.jface.resource.JFaceResources
import org.eclipse.jface.viewers.StyledString
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils
import de.fhdo.lemma.eclipse.ui.ModelFile

/**
 * Base class for styled label providers of model files.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ModelFileStyledLabelProvider extends LabelProvider implements IStyledLabelProvider {
    protected ResourceManager resourceManager
    protected Image errorIcon
    protected Image warningIcon

    /**
     * Constructor
     */
    new() {
        resourceManager = new LocalResourceManager(JFaceResources.getResources())
        errorIcon = LemmaUiUtils.createImage(resourceManager, class, "error.gif")
        warningIcon = LemmaUiUtils.createImage(resourceManager, class, "warning.gif")
    }

    /**
     * Get default styled text for element
     */
    override getStyledText(Object element) {
        if (!(element instanceof ModelFile))
            return new StyledString("")

        return new StyledString((element as ModelFile).file.fullPath.toString())
    }

    /**
     * Get image for element
     */
    override getImage(Object element) {
        if (!(element instanceof ModelFile))
            return null

        return (element as ModelFile).fileIcon
    }

    /**
     * Garbage collector callback
     */
    override dispose() {
        super.dispose()
        resourceManager.dispose
    }

    /**
     * Helper method to get the icon of a model file element
     */
    protected def getFileIcon(ModelFile modelFile) {
        /* Special icons for errors and warnings */
        if (modelFile.hasErrors)
            return errorIcon
        else if (modelFile.hasWarnings)
            return warningIcon

        /* Set icon depending on file type, if file does not contain errors or warnings */
        return modelFile.fileTypeDescription.icon
    }
}