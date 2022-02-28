package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.RawStringArgumentType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.ArgumentTypeFactory

/**
 * Argument kind for arguments with constant parameters.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class ConstantParameterArgumentKind extends AbstractArgumentKind {
    public static val IDENTIFIER = ArgumentKindIdentifier.CONSTANT_PARAMETER

    /**
     * Constructor
     */
    new() {
        super(IDENTIFIER, "Constant Parameter",
            ArgumentTypeFactory.fromIdentifier(RawStringArgumentType.IDENTIFIER))
    }
}