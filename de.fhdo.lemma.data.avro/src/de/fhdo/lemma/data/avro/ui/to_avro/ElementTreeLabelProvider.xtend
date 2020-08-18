package de.fhdo.lemma.data.avro.ui.to_avro

import org.eclipse.jface.viewers.LabelProvider
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider

import static de.fhdo.lemma.data.avro.Util.*
import org.eclipse.jface.viewers.StyledString
import org.eclipse.emf.ecore.EObject
import org.eclipse.jface.resource.ResourceManager
import org.eclipse.swt.graphics.Image
import org.eclipse.jface.resource.LocalResourceManager
import org.eclipse.jface.resource.JFaceResources
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils
import de.fhdo.lemma.data.intermediate.IntermediateVersion
import de.fhdo.lemma.data.intermediate.IntermediateContext
import de.fhdo.lemma.data.intermediate.IntermediateComplexType

/**
 * Provider of styled labels for model tree elements.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ElementTreeLabelProvider extends LabelProvider implements IStyledLabelProvider {
    static val ResourceManager RESOURCE_MANAGER
        = new LocalResourceManager(JFaceResources.getResources())

    /**
     * Icon for LEMMA Versions
     */
    public static val Image VERSION_ICON = LemmaUiUtils.createImage(
            RESOURCE_MANAGER,
            ElementTreeLabelProvider,
            "version.png"
        )

    /**
     * Icon for LEMMA Contexts
     */
    public static val Image CONTEXT_ICON = LemmaUiUtils.createImage(
            RESOURCE_MANAGER,
            ElementTreeLabelProvider,
            "context.gif"
        )

    /**
     * Icon for LEMMA ComplexTypes
     */
    public static val Image COMPLEX_TYPE_ICON = LemmaUiUtils.createImage(
            RESOURCE_MANAGER,
            ElementTreeLabelProvider,
            "complexType.gif"
        )

    /**
     * Get styled text for element
     */
    override getStyledText(Object element) {
        return new StyledString(getSimpleName(qualifiedName(element as EObject)))
    }

    /**
     * Get image for element
     */
    override getImage(Object element) {
        return switch(element) {
            IntermediateVersion: VERSION_ICON
            IntermediateContext: CONTEXT_ICON
            IntermediateComplexType: COMPLEX_TYPE_ICON
        }
    }
}