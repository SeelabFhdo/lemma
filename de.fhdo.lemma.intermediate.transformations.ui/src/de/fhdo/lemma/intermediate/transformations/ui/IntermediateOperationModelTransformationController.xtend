package de.fhdo.lemma.intermediate.transformations.ui

/**
 * Controller for handling the intermediate operation model transformation in the UI.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class IntermediateOperationModelTransformationController
    extends AbstractIntermediateModelTransformationController {

    override getTransformationStrategy() {
        new OperationModelTransformationStrategy
    }
}