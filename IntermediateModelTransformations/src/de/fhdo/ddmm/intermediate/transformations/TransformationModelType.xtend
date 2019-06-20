package de.fhdo.ddmm.intermediate.transformations

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EObject

/**
 * A type of a transformation model.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class TransformationModelType {
    /* URI of the Ecore namespace */
    @Accessors
    String namespaceUri

    /* EPackage instance */
    @Accessors
    EPackage ecorePackage

    /* Root class of the model */
    @Accessors
    Class<? extends EObject> rootClass

    /**
     * Constructor
     */
    new(String namespaceUri, EPackage ePackage, Class<? extends EObject> rootClass) {
        this.namespaceUri = namespaceUri
        this.ecorePackage = ePackage
        this.rootClass = rootClass
    }
}