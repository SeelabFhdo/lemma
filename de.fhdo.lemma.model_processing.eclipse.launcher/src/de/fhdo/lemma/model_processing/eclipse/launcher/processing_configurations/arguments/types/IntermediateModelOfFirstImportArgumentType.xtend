package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration
import de.fhdo.lemma.eclipse.ui.ProgrammaticIntermediateModelTransformation
import de.fhdo.lemma.eclipse.ui.ServiceModelTransformationStrategy
import de.fhdo.lemma.eclipse.ui.OperationModelTransformationStrategy

/**
 * Type of arguments representing intermediate models of LEMMA models that are the first imports
 * of other LEMMA models.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class IntermediateModelOfFirstImportArgumentType
    extends AbstractIntermediateModelArgumentTypeWithEnumValue<ImportedIntermediateModelKind> {
    public static val IDENTIFIER = ArgumentTypeIdentifier.INTERMEDIATE_MODEL_OF_IMPORT

    static val LITERAL_DESCRIPTIONS = #{
        ImportedIntermediateModelKind.FIRST_DOMAIN_MODEL
            -> "Intermediate representation of first imported data model",
        ImportedIntermediateModelKind.FIRST_OPERATION_MODEL
            -> "Intermediate representation of first imported operation model",
        ImportedIntermediateModelKind.FIRST_SERVICE_MODEL
            -> "Intermediate representation of first imported service model"
    }

    /**
     * Constructor
     */
    new() {
        super(IDENTIFIER, "Intermediate model of first import", LITERAL_DESCRIPTIONS)
    }

    /**
     * Validate the user value. Next to the validation implemented by the superclass, this
     * validation method also checks if the source model kind of the given model processing
     * configuration provides support for intermediate transformation of the specified kind of the
     * first imported model.
     */
    final override validateValueInUserRepresentation(ProcessingConfiguration configuration,
        String literalDescription) {
        super.validateValueInUserRepresentation(configuration, literalDescription)

        // Might not have a source model when user selected a new project and the source model
        // input field got cleared
        val sourceModelFileExtension = configuration.sourceModelFile?.fileExtension
        if (sourceModelFileExtension === null)
            return

        // Check if the source model provides intermediate transformation support for the specified
        // kind of the first imported model
        val transformableFileExtensions = ProgrammaticIntermediateModelTransformation
            .getTransformationStrategy(sourceModelFileExtension)
            .modelFileTypeDescriptions
            .values
            .map[extensions]
            .flatten

        val intermediateModelKind = ImportedIntermediateModelKind
            .valueOf(getLiteralName(literalDescription))
        val importedModelFileExtensions = switch(intermediateModelKind) {
            case FIRST_DOMAIN_MODEL:
                ServiceModelTransformationStrategy.DATA_MODEL_FILE_EXTENSIONS
            case FIRST_OPERATION_MODEL:
                OperationModelTransformationStrategy.OPERATION_MODEL_FILE_EXTENSIONS
            case FIRST_SERVICE_MODEL:
                ServiceModelTransformationStrategy.SERVICE_MODEL_FILE_EXTENSIONS
        }

        if (transformableFileExtensions.exists[importedModelFileExtensions.contains(it)])
            return

        // There is no intermediate transformation support
        val kindHint = if (importedModelFileExtensions.size == 1)
                '''kind *.«importedModelFileExtensions.get(0)»'''
            else
                "kinds " + importedModelFileExtensions.map['''*.«it»'''].join(", ")

        throw new IllegalArgumentException("Source model intermediate transformation does not " +
            '''support transformation of imported model files of «kindHint»''')
    }
}