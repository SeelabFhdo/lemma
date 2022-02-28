package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types

/**
 * Type of arguments representing intermediate models.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class IntermediateModelArgumentType
    extends AbstractIntermediateModelArgumentTypeWithEnumValue<IntermediateModelKind> {
    public static val IDENTIFIER = ArgumentTypeIdentifier.INTERMEDIATE_MODEL

    static val LITERAL_DESCRIPTIONS = #{
        IntermediateModelKind.SELECTED_FILE -> "Intermediate representation of selected model file"
    }

    /**
     * Constructor
     */
    new() {
        super(IDENTIFIER, "Intermediate model", LITERAL_DESCRIPTIONS)
    }
}