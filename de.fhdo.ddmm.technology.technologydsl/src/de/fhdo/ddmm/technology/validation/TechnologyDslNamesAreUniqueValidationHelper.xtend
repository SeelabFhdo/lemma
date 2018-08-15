package de.fhdo.ddmm.technology.validation

import org.eclipse.xtext.validation.NamesAreUniqueValidationHelper
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EStructuralFeature
import de.fhdo.ddmm.technology.TechnologyPackage
import de.fhdo.ddmm.data.DataPackage

/**
 * Implementation of NamesAreUniqueValidationHelper to produce custom error messages for duplicated
 * names in a technology definition.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de>Florian Rademacher</a>
 */
class TechnologyDslNamesAreUniqueValidationHelper extends NamesAreUniqueValidationHelper {
    /**
     * Build a custom error message for duplicated names of certain technology model concepts
     */
    override getDuplicateNameErrorMessage(IEObjectDescription description,
        EClass clusterType, EStructuralFeature feature) {
        return switch(clusterType) {
            /* Technology */
            case TechnologyPackage::Literals.TECHNOLOGY: '''Duplicate technology ''' +
                '''«description.name»'''

            /* Technology-specific type */
            case DataPackage::Literals.TYPE: '''Duplicate type «description.name»'''

            /* Protocol */
            case TechnologyPackage::Literals.PROTOCOL: '''Duplicate protocol «description.name»'''

            /* If the cluster type is not covered by the helper, use the default implementation. */
            default: super.getDuplicateNameErrorMessage(description, clusterType, feature)
        }
    }
}