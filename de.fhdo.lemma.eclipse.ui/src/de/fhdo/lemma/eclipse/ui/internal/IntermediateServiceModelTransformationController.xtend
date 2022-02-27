package de.fhdo.lemma.eclipse.ui.internal

import de.fhdo.lemma.eclipse.ui.ServiceModelTransformationStrategy

/**
 * Controller for handling the intermediate service model transformation in the UI.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class IntermediateServiceModelTransformationController
    extends AbstractIntermediateModelTransformationController {

    override getTransformationStrategy() {
        new ServiceModelTransformationStrategy
    }
}