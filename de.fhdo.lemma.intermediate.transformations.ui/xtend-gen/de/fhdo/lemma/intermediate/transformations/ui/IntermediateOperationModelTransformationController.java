package de.fhdo.lemma.intermediate.transformations.ui;

/**
 * Controller for handling the intermediate operation model transformation in the UI.
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@SuppressWarnings("all")
public class IntermediateOperationModelTransformationController extends AbstractIntermediateModelTransformationController {
  @Override
  public AbstractUiModelTransformationStrategy getTransformationStrategy() {
    return new OperationModelTransformationStrategy();
  }
}
