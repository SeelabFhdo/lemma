package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types;

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration;

/**
 * Type of arguments representing raw strings, i.e., strings to be used as-is for parameterizing
 * model processor executions.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class RawStringArgumentType extends AbstractArgumentType {
  public static final ArgumentTypeIdentifier IDENTIFIER = ArgumentTypeIdentifier.RAW_STRING;

  /**
   * Constructor
   */
  public RawStringArgumentType() {
    super(RawStringArgumentType.IDENTIFIER, "Raw string");
  }

  /**
   * Validate the type-specific argument value in its internal representation which is a no-op for
   * raw strings
   */
  @Override
  public final void validateValueInInternalRepresentation(final ProcessingConfiguration processingConfiguration, final String value) {
  }
}
