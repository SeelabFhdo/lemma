package de.fhdo.ddmm.data

import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.util.IAcceptor
import org.eclipse.xtext.resource.IEObjectDescription

/**
 * Custom resource description strategy for the DataDsl.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de>Florian Rademacher</a>
 */
class DataDslResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {
    /**
     * Export selected EObjects from DSL models
     */
    override createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
        switch (eObject) {
            ComplexTypeImport,  // Don't export imported complex types to prevent transitive imports
            PrimitiveType: return false
        }

        return super.createEObjectDescriptions(eObject, acceptor)
    }
}