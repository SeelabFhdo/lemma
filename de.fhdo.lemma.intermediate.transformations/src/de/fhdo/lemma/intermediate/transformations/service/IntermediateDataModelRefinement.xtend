package de.fhdo.lemma.intermediate.transformations.service

import de.fhdo.lemma.data.intermediate.IntermediatePackage
import de.fhdo.lemma.data.intermediate.IntermediateDataModel
import de.fhdo.lemma.intermediate.transformations.TransformationModelDirection
import de.fhdo.lemma.intermediate.transformations.TransformationModelDescription
import de.fhdo.lemma.service.ServicePackage
import de.fhdo.lemma.service.ServiceModel
import de.fhdo.lemma.intermediate.transformations.AbstractEmftvmIntermediateModelTransformationStrategy
import de.fhdo.lemma.intermediate.transformations.TransformationModelType

/**
 * Implementation of the EMFTVM-based refining transformation of intermediate data models.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class IntermediateDataModelRefinement
    extends AbstractEmftvmIntermediateModelTransformationStrategy {
    // Despite that fact that the transformation file specifies an "OUT" model, it is not included
    // as a transformation model description. Instead, the "IN" model is declared as being inout as
    // it yields the refined model eventually.
    public static final TransformationModelDescription IN_MODEL_DESCRIPTION =
        new TransformationModelDescription("IN", "Intermediate", TransformationModelDirection.INOUT)
    public static final TransformationModelDescription SERVICE_MODEL_DESCRIPTION =
        new TransformationModelDescription("SERVICE", "Service", TransformationModelDirection.IN)

    /**
     * Get the platform path to the folder that holds the transformation model file
     */
    override getModelTransformationFilePlatformFolder() {
        return "platform:/plugin/de.fhdo.lemma.intermediate.transformations/transformation/"
    }

    /**
     * Get the name of the transformation model file
     */
    override getModelTransformationFileName() {
        return "IntermediateDataModelRefinement"
    }

    /**
     * Register model types
     */
    override registerModelTypes() {
        return newLinkedHashMap(
            IN_MODEL_DESCRIPTION -> new TransformationModelType(
                IntermediatePackage.eNS_URI, IntermediatePackage.eINSTANCE, IntermediateDataModel
            ),

            SERVICE_MODEL_DESCRIPTION -> new TransformationModelType(
                ServicePackage.eNS_URI, ServicePackage.eINSTANCE, ServiceModel
            )
        )
    }
}