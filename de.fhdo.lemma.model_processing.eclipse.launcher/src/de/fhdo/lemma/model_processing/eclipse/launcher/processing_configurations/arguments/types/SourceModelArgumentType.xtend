package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types

/**
 * Type of arguments representing the source model file specified for a model processing
 * configuration.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class SourceModelArgumentType
    extends AbstractArgumentTypeWithEnumValueSelection<SourceModelKind> {
    public static val IDENTIFIER = ArgumentTypeIdentifier.SOURCE_MODEL

    static val LITERAL_DESCRIPTIONS = #{
        SourceModelKind.SELECTED_FILE -> "Selected model file"
    }

    /**
     * Constructor
     */
    new() {
        super(IDENTIFIER, "Source model", LITERAL_DESCRIPTIONS)
    }
}