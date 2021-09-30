package de.fhdo.lemma.intermediate.transformations.ui;

/**
 * Controller for handling the intermediate service model transformation in the UI.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class IntermediateServiceModelTransformationController extends AbstractIntermediateModelTransformationController {
  @Override
  public AbstractUiModelTransformationStrategy getTransformationStrategy() {
    return new ServiceModelTransformationStrategy();
  }
}
