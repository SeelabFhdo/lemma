package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds;

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.ArgumentTypeFactory;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelsOfAllImportsArgumentType;

/**
 * Argument kind for arguments with multi-valued parameters.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class MultiValuedParameterArgumentKind extends AbstractArgumentKind {
  public static final ArgumentKindIdentifier IDENTIFIER = ArgumentKindIdentifier.MULTI_VALUED_PARAMETER;

  /**
   * Constructor
   */
  public MultiValuedParameterArgumentKind() {
    super(MultiValuedParameterArgumentKind.IDENTIFIER, "Multi-Valued Parameter", 
      ArgumentTypeFactory.fromIdentifier(IntermediateModelsOfAllImportsArgumentType.IDENTIFIER));
  }
}
