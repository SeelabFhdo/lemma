package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration

/**
 * Type of arguments representing pairs of strings of which the first element acts as parameter name
 * and the second element as parameter value.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class StringPairArgumentType extends AbstractArgumentType {
    public static val IDENTIFIER = ArgumentTypeIdentifier.STRING_PAIR

    /**
     * Constructor
     */
    new() {
        super(IDENTIFIER, "String pair")
    }

    /**
     * Validate the type-specific argument value in its internal representation, i.e., the parameter
     * value
     */
    final override validateValueInInternalRepresentation(
        ProcessingConfiguration processingConfiguration,
        String value
    ) {
        if (value.nullOrEmpty)
            throw new IllegalArgumentException("Please specify a value")
    }
}