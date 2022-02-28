package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds;

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.ArgumentTypeFactory;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.RawStringArgumentType;

/**
 * Argument kind for arguments with constant parameters.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class ConstantParameterArgumentKind extends AbstractArgumentKind {
  public static final ArgumentKindIdentifier IDENTIFIER = ArgumentKindIdentifier.CONSTANT_PARAMETER;
  
  /**
   * Constructor
   */
  public ConstantParameterArgumentKind() {
    super(ConstantParameterArgumentKind.IDENTIFIER, "Constant Parameter", 
      ArgumentTypeFactory.fromIdentifier(RawStringArgumentType.IDENTIFIER));
  }
}
