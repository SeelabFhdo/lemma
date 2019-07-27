package de.fhdo.lemma.data.validation

import org.eclipse.xtext.validation.NamesAreUniqueValidationHelper
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EStructuralFeature
import de.fhdo.lemma.data.DataPackage

/**
 * Implementation of NamesAreUniqueValidationHelper to produce custom error messages for duplicated
 * names in a data model.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class DataDslNamesAreUniqueValidationHelper extends NamesAreUniqueValidationHelper {
    /**
     * Build a custom error message for duplicated names of certain data model concepts
     */
    override getDuplicateNameErrorMessage(IEObjectDescription description,
        EClass clusterType, EStructuralFeature feature) {
        return switch(clusterType) {
            /* Version */
            case DataPackage::Literals.VERSION: '''Duplicate version «description.name»'''

            /* Context */
            case DataPackage::Literals.CONTEXT: '''Duplicate context «description.name»'''

            /* Type (includes data structures and list types) */
            case DataPackage::Literals.TYPE: '''Duplicate type «description.name»'''

            /* Data field */
            case DataPackage::Literals.DATA_FIELD: '''Duplicate data field «description.name»'''

            /*
             * If the cluster type is not covered by the helper, use the default implementation.
             * Note that this should not happen. One exception is ComplexTypeImport and its name
             * feature. The unique names validator won't consider checking imports and their names.
             * The check for unique import aliases is therefore implemented in the DSL's validator.
             */
            default: super.getDuplicateNameErrorMessage(description, clusterType, feature)
        }
    }
}