package de.fhdo.lemma.eclipse.ui.internal;

import de.fhdo.lemma.eclipse.ui.AbstractUiModelTransformationStrategy;
import de.fhdo.lemma.eclipse.ui.ServiceModelTransformationStrategy;

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
