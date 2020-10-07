package de.fhdo.lemma.eclipse.ui;

import de.fhdo.lemma.eclipse.ui.AbstractIntermediateModelTransformationController;
import de.fhdo.lemma.eclipse.ui.AbstractUiModelTransformationStrategy;
import de.fhdo.lemma.eclipse.ui.OperationModelTransformationStrategy;

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
