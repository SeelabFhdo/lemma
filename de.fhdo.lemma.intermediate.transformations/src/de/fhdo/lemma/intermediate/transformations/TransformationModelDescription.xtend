package de.fhdo.lemma.intermediate.transformations

import org.eclipse.xtend.lib.annotations.Accessors
import java.util.Objects

/**
 * Enum for transformation model directions.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
enum TransformationModelDirection {
    IN,
    OUT,
    INOUT
}

/**
 * Description of a model in a model-to-model transformation.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class TransformationModelDescription {
    /* Name of the model in the transformation, e.g., "IN" or "OUT" */
    @Accessors
    String nameInModelTransformation

    /* Reference name of the model in the transformation, e.g., "Service" or "Intermediate" */
    @Accessors
    String referenceModelName

    /* Direction of the model in the transformation */
    @Accessors
    TransformationModelDirection direction

    /**
     * Constructor
     */
    new(String nameInModelTransformation, String referenceModelName,
        TransformationModelDirection direction) {
        this.nameInModelTransformation = nameInModelTransformation
        this.referenceModelName = referenceModelName
        this.direction = direction
    }

    /**
     * Two model descriptions are equal if they have the same name in model transformations
     */
    override equals(Object o) {
        if (o === this)
            return true

        if (!(o instanceof TransformationModelDescription))
            return false

        return (o as TransformationModelDescription)
            .nameInModelTransformation === nameInModelTransformation
    }

    override hashCode() {
        return Objects.hashCode(nameInModelTransformation)
    }
}