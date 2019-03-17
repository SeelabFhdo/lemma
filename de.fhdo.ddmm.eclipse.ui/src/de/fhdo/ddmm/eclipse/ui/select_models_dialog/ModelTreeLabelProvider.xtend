package de.fhdo.ddmm.eclipse.ui.select_models_dialog

import org.eclipse.jface.viewers.StyledString
import org.eclipse.swt.graphics.Image
import de.fhdo.ddmm.eclipse.ui.utils.DdmmUiUtils
import org.eclipse.core.resources.IProject
import de.fhdo.ddmm.eclipse.ui.ModelFile
import de.fhdo.ddmm.eclipse.ui.ModelFileStyledLabelProvider

/**
 * Provider of styled labels for model tree elements.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ModelTreeLabelProvider extends ModelFileStyledLabelProvider {
    Image projectIcon

    /**
     * Constructor
     */
    new() {
        super()
        projectIcon = DdmmUiUtils.createImage(resourceManager, class, "project.gif")
    }

    /**
     * Get styled text for element
     */
    override getStyledText(Object element) {
        return switch (element) {
            IProject: new StyledString(element.name)
            ModelFile: new StyledString(element.file.name)
            default: null
        }
    }

    /**
     * Get image for element
     */
    override getImage(Object element) {
        return switch (element) {
            IProject: projectIcon
            ModelFile: element.fileIcon
            default: null
        }
    }
}