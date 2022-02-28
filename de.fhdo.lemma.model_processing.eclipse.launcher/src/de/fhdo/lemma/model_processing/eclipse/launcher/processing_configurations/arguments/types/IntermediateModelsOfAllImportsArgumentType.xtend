package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration
import de.fhdo.lemma.eclipse.ui.ProgrammaticIntermediateModelTransformation
import de.fhdo.lemma.eclipse.ui.ServiceModelTransformationStrategy
import de.fhdo.lemma.eclipse.ui.OperationModelTransformationStrategy

/**
     * Start building a multi-valued argument which is currently only supported for certain kinds of
     * intermediate representations of LEMMA models imported into other LEMMA models. Return a
     * builder for arguments with parameters but without values. The parameter represents the
     * argument's parameter that is repeated for each intermediate model.
     */
/**
 * Type of arguments representing selections of all intermediate models of LEMMA models that are
 * imported into other LEMMA models and are of a certain kind.
 */
final class IntermediateModelsOfAllImportsArgumentType
    extends AbstractIntermediateModelArgumentTypeWithEnumValue<AllImportedIntermediateModelKinds> {
    public static val IDENTIFIER = ArgumentTypeIdentifier.INTERMEDIATE_MODELS_OF_ALL_IMPORTS

    static val LITERAL_DESCRIPTIONS = #{
        AllImportedIntermediateModelKinds.ALL_DOMAIN_MODELS
            -> "Intermediate representations of all imported data models",
        AllImportedIntermediateModelKinds.ALL_OPERATION_MODELS
            -> "Intermediate representations of all imported operation models",
        AllImportedIntermediateModelKinds.ALL_SERVICE_MODELS
            -> "Intermediate representations of all imported service models"
    }

    /**
     * Constructor
     */
    new() {
        super(IDENTIFIER, "Intermediate models of all imports", LITERAL_DESCRIPTIONS)
    }

    /**
     * Validate the user value. Next to the validation implemented by the superclass, this
     * validation method also checks if the source model kind of the given model processing
     * configuration provides support for intermediate transformation of the specified kind of
     * imported models.
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
        // kind of imported models
        val transformableFileExtensions = ProgrammaticIntermediateModelTransformation
            .getTransformationStrategy(sourceModelFileExtension)
            .modelFileTypeDescriptions
            .values
            .map[extensions]
            .flatten

        val intermediateModelKind = AllImportedIntermediateModelKinds
            .valueOf(getLiteralName(literalDescription))
        val importedModelFileExtensions = switch(intermediateModelKind) {
            case ALL_DOMAIN_MODELS:
                ServiceModelTransformationStrategy.DATA_MODEL_FILE_EXTENSIONS
            case ALL_OPERATION_MODELS:
                OperationModelTransformationStrategy.OPERATION_MODEL_FILE_EXTENSIONS
            case ALL_SERVICE_MODELS:
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