package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.FileArgumentType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelArgumentType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.SourceModelArgumentType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.FolderArgumentType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.ArgumentTypeFactory
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.StringPairArgumentType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelOfImportWithAliasArgumentType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelOfFirstImportArgumentType

/**
 * Argument kind for arguments with single-valued parameters.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class SingleValuedParameterArgumentKind extends AbstractArgumentKind {
    public static val IDENTIFIER = ArgumentKindIdentifier.SINGLE_VALUED_PARAMETER

    /**
     * Constructor
     */
    new() {
        super(
            IDENTIFIER,
            "Single-Valued Parameter",
            ArgumentTypeFactory.fromIdentifier(FileArgumentType.IDENTIFIER),
            ArgumentTypeFactory.fromIdentifier(FolderArgumentType.IDENTIFIER),
            ArgumentTypeFactory.fromIdentifier(IntermediateModelArgumentType.IDENTIFIER),
            ArgumentTypeFactory
                .fromIdentifier(IntermediateModelOfFirstImportArgumentType.IDENTIFIER),
            ArgumentTypeFactory
                .fromIdentifier(IntermediateModelOfImportWithAliasArgumentType.IDENTIFIER),
            ArgumentTypeFactory.fromIdentifier(SourceModelArgumentType.IDENTIFIER),
            ArgumentTypeFactory.fromIdentifier(StringPairArgumentType.IDENTIFIER)
        )
    }
}