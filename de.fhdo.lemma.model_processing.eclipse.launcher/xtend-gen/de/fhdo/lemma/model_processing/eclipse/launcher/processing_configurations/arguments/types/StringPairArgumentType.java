package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types;

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Type of arguments representing pairs of strings of which the first element acts as parameter name
 * and the second element as parameter value.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class StringPairArgumentType extends AbstractArgumentType {
  public static final ArgumentTypeIdentifier IDENTIFIER = ArgumentTypeIdentifier.STRING_PAIR;

  /**
   * Constructor
   */
  public StringPairArgumentType() {
    super(StringPairArgumentType.IDENTIFIER, "String pair");
  }

  /**
   * Validate the type-specific argument value in its internal representation, i.e., the parameter
   * value
   */
  @Override
  public final void validateValueInInternalRepresentation(final ProcessingConfiguration processingConfiguration, final String value) {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(value);
    if (_isNullOrEmpty) {
      throw new IllegalArgumentException("Please specify a value");
    }
  }
}
