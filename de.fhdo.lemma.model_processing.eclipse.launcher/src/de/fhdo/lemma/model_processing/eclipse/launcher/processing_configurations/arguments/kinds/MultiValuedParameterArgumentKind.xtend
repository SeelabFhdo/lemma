package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelsOfAllImportsArgumentType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.ArgumentTypeFactory

/**
 * Argument kind for arguments with multi-valued parameters.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class MultiValuedParameterArgumentKind extends AbstractArgumentKind {
    public static val IDENTIFIER = ArgumentKindIdentifier.MULTI_VALUED_PARAMETER

    /**
     * Constructor
     */
    new() {
        super(IDENTIFIER, "Multi-Valued Parameter",
            ArgumentTypeFactory.fromIdentifier(IntermediateModelsOfAllImportsArgumentType.IDENTIFIER))
    }
}