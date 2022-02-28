package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types

import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration
import de.fhdo.lemma.eclipse.ui.ProgrammaticIntermediateModelTransformation
import java.util.Map

/**
 * Abstract superclass for argument types that are based on enumerations and point to some sort of
 * intermediate model. That is, the class provides a user validation that checks if the source model
 * selected for a given model processing configuration actually supports intermediate
 * transformations and is thus applicable with the argument type.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
abstract class AbstractIntermediateModelArgumentTypeWithEnumValue<T extends Enum<?>>
    extends AbstractArgumentTypeWithEnumValueSelection<T> {

    /**
     * Constructor
     */
    new(ArgumentTypeIdentifier identifier, String name, Map<T, String> validLiteralStringValues) {
        super(identifier, name, validLiteralStringValues)
    }

    /**
     * Validate the user value, i.e., the description of the literal, of an argument of this
     * enumeration-based type. Implementers may override this method to accompany user validation
     * with additional checks. However, overridden methods must invoke this method on the
     * superclass.
     */
    override validateValueInUserRepresentation(ProcessingConfiguration configuration,
        String literalDescription) {
        super.validateValueInUserRepresentation(configuration, literalDescription)

        val sourceModelFile = configuration.sourceModelFile
        // Might not have a source model when user selected a new project and the source model input
        // field got cleared
        if (sourceModelFile !== null &&
            !ProgrammaticIntermediateModelTransformation.supportsTranformation(sourceModelFile))
            throw new IllegalArgumentException("Intermediate transformation of model files of " +
                '''kind *.«sourceModelFile.fileExtension» is not supported''')
    }
}
