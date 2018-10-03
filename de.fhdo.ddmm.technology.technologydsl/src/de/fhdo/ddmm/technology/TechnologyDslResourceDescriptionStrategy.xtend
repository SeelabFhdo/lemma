package de.fhdo.ddmm.technology

import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.EObjectDescription

/**
 * Custom resource description strategy for the Technology DSL.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class TechnologyDslResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {
    /**
     * Export selected EObjects from DSL models
     */
    override createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
        // Export operation aspects without technology name as prefix. That is, only the name of
        // the aspect is exported to be directly referenceable within operation models.
        if (eObject instanceof OperationAspect) {
            acceptor.accept(EObjectDescription.create(eObject.name, eObject))
            return true
        }

        return super.createEObjectDescriptions(eObject, acceptor)
    }
}