package de.fhdo.lemma.reconstruction.ui

import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils
import de.fhdo.lemma.reconstruction.domain.Context
import de.fhdo.lemma.reconstruction.domain.DataStructure
import de.fhdo.lemma.reconstruction.domain.Field
import org.eclipse.jface.resource.JFaceResources
import org.eclipse.jface.resource.LocalResourceManager
import org.eclipse.jface.resource.ResourceManager
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider
import org.eclipse.jface.viewers.LabelProvider
import org.eclipse.jface.viewers.StyledString
import org.eclipse.swt.graphics.Image

/**
 * User Interface class for displaying lables for the ReconstructionTreeProvider
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ReconstructionTreeLableProvider  extends LabelProvider implements IStyledLabelProvider {
	static val ResourceManager RESOURCE_MANAGER
        = new LocalResourceManager(JFaceResources.getResources())

 	/**
     * Icon for reconstruction part
     */
    public static val Image CONTEXT_ICON = LemmaUiUtils.createImage(
            RESOURCE_MANAGER,
            ReconstructionTreeLableProvider,
            "protocol.gif"
        )

	/**
     * Get styled text for element
     */
    override getStyledText(Object element) {
        return new StyledString(switch(element) {
            Context: element.qualifiedName
            DataStructure: element.name
            Field: element.name
            default: "default"
        })
    }
}