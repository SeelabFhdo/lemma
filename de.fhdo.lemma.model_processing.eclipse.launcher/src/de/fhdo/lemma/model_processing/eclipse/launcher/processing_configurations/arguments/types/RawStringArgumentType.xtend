package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration

/**
 * Type of arguments representing raw strings, i.e., strings to be used as-is for parameterizing
 * model processor executions.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class RawStringArgumentType extends AbstractArgumentType {
    public static val IDENTIFIER = ArgumentTypeIdentifier.RAW_STRING

    /**
     * Constructor
     */
    new() {
        super(IDENTIFIER, "Raw string")
    }

    /**
     * Validate the type-specific argument value in its internal representation which is a no-op for
     * raw strings
     */
    final override validateValueInInternalRepresentation(
        ProcessingConfiguration processingConfiguration,
        String value
    ) {
        // NOOP
    }
}