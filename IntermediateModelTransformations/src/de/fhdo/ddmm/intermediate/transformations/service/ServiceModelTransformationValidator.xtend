package de.fhdo.ddmm.intermediate.transformations.service

import de.fhdo.ddmm.service.ServiceModel
import de.fhdo.ddmm.intermediate.transformations.AbstractSourceModelValidator
import de.fhdo.ddmm.intermediate.transformations.IntermediateTransformationException

/**
 * Validator for service models that shall be transformed.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ServiceModelTransformationValidator extends AbstractSourceModelValidator<ServiceModel> {
    /**
     * Validate source models for errors
     */
    override checkSourceModelForErrors(ServiceModel serviceModel)
        throws IntermediateTransformationException {
        if (serviceModel === null)
            error("Service model is empty")

        if (serviceModel.eAllContents.empty)
            error("Service model is empty")
    }

    /**
     * Register warning functions
     */
    override registerWarningFunctions() {
        return #[
            [warnMissingTechnologies],
            [warnReferredMicroserviceTechnologies]
        ]
    }

    /**
     * Warn if microservices exist in the model without assigned technologies
     */
    private def Void warnMissingTechnologies(ServiceModel serviceModel) {
        val missingTechnologies = serviceModel.microservices.exists[technologies.empty]
        if (missingTechnologies)
            warning("The service model contains microservices without a technology assignment. " +
                "A technology would have to be explicitly chosen when generating source code for " +
                "them."
            )
    }

    /**
     * Warn if microservices with technologies refer to microservices without technologies
     */
    private def Void warnReferredMicroserviceTechnologies(ServiceModel serviceModel) {
        val microservicesWithTechnologies = serviceModel.microservices.filter[!technologies.empty]
        val referencesToMicroservicesWithoutTechnologies = microservicesWithTechnologies
            .exists[allRequiredMicroservices.keySet.exists[technologies.empty]]

        if (referencesToMicroservicesWithoutTechnologies)
            warning("The model contains microservices with technology assignments, which refer " +
                "to services without technology assignments. For the services without " +
                "technology assignments, a code generation involving explicit technology " +
                "specifications would have to be performed.")
    }
}