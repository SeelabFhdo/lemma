package de.fhdo.lemma.intermediate.transformations

import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.emf.ecore.EObject

/**
 * This class represents information about a target model of an intermediate model transformation.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class TargetModelInfo {
    @Accessors
    String namespaceUri

    @Accessors
    EPackage ecorePackage

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