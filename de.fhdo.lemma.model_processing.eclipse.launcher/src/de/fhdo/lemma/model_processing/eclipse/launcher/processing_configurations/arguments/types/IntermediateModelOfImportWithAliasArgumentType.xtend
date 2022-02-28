package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration
import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*

/**
 * Type of arguments representing intermediate models of LEMMA models that are imported into other
 * LEMMA models with some given aliases.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class IntermediateModelOfImportWithAliasArgumentType extends AbstractArgumentType {
    public static val IDENTIFIER = ArgumentTypeIdentifier.INTERMEDIATE_MODEL_WITH_IMPORT_ALIAS

    /**
     * Constructor
     */
    new() {
        super(IDENTIFIER, "Intermediate model of import with alias")
    }

    /**
     * Validate the type-specific argument value in its internal representation, i.e., the import
     * alias. Specifically, check that the import with the alias points to a LEMMA model for which
     * an intermediate transformation exists.
     */
    final override validateValueInInternalRepresentation(
        ProcessingConfiguration processingConfiguration,
        String alias
    ) {
        val imports = parseTransformableImportedModelsOfSourceModelFile(processingConfiguration)
        if (!imports.exists[it.value.alias == alias])
            throw new IllegalArgumentException('''Source model import with alias "«alias»" ''' +
                "does not point to a transformable LEMMA model")
    }
}