package de.fhdo.ddmm.technology.validation

import org.eclipse.xtext.validation.NamesAreUniqueValidationHelper
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EStructuralFeature
import de.fhdo.ddmm.technology.TechnologyPackage
import de.fhdo.ddmm.data.DataPackage
import com.google.common.collect.ImmutableSet
import org.eclipse.xtext.validation.ValidationMessageAcceptor
import java.util.Map
import org.eclipse.xtext.naming.QualifiedName
import de.fhdo.ddmm.technology.OperationEnvironment
import de.fhdo.ddmm.technology.ServiceProperty

/**
 * Implementation of NamesAreUniqueValidationHelper to produce custom error messages for duplicated
 * names in a technology definition.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class TechnologyDslNamesAreUniqueValidationHelper extends NamesAreUniqueValidationHelper {
    /**
     * Set cluster types explicitly
     */
    override getClusterTypes() {
        // DeploymentTechnology and InfrastructureTechnology have the same abstract superclass.
        // However, we want their names to be unique only for concrete subclasses.
        return ImmutableSet.of(
            TechnologyPackage::Literals.DEPLOYMENT_TECHNOLOGY,
            TechnologyPackage::Literals.INFRASTRUCTURE_TECHNOLOGY
        );
    }

    /**
     * Hook to perform the actual duplication check for a certain concept
     */
    override checkDescriptionForDuplicatedName(IEObjectDescription description,
        Map<EClass, Map<QualifiedName, IEObjectDescription>> clusterTypeToName,
        ValidationMessageAcceptor acceptor) {
        val descriptionObject = description.EObjectOrProxy

        /*
         * Deactivate unique name checks for certain concepts:
         *      - OperationEnvironment: Check is performed by DSL validator. Otherwise the helper
         *                              will assume that _all_ names of an OperationEnvironment in
         *                              the model will need to have a distinct name. Instead, the
         *                              environments' names should be unique for each concrete
         *                              instance of an OperationTechnology, i.e.,
         *                              DeploymentTechnology and InfrastructureTechnology.
         *      - ServiceProperty: ditto
         */
        if (descriptionObject instanceof OperationEnvironment ||
            descriptionObject instanceof ServiceProperty) {
            return
        }

        super.checkDescriptionForDuplicatedName(description, clusterTypeToName, acceptor)
    }

    /**
     * Build a custom error message for duplicated names of certain technology model concepts
     */
    override getDuplicateNameErrorMessage(IEObjectDescription description,
        EClass clusterType, EStructuralFeature feature) {
        val duplicateName = description.name.lastSegment

        return switch(clusterType) {
            /* Import */
            case TechnologyPackage::Literals.TECHNOLOGY_IMPORT: '''Duplicate import alias ''' +
                '''«duplicateName»'''

            /* Technology-specific type */
            case DataPackage::Literals.TYPE: '''Duplicate type «duplicateName»'''

            /* Protocol */
            case TechnologyPackage::Literals.PROTOCOL: '''Duplicate protocol «duplicateName»'''

            /* Deployment technology */
            case TechnologyPackage::Literals.DEPLOYMENT_TECHNOLOGY:
                '''Duplicate deployment technology «duplicateName»'''

            /* Infrastructure technology */
            case TechnologyPackage::Literals.INFRASTRUCTURE_TECHNOLOGY:
                '''Duplicate infrastructure technology «duplicateName»'''

            /* If the cluster type is not covered by the helper, use the default implementation. */
            default: super.getDuplicateNameErrorMessage(description, clusterType, feature)
        }
    }
}