package de.fhdo.lemma.intermediate.transformations.service

import de.fhdo.lemma.service.ServiceModel
import de.fhdo.lemma.intermediate.transformations.AbstractInputModelValidator
import de.fhdo.lemma.intermediate.transformations.IntermediateTransformationException

/**
 * Validator for service models that shall be transformed.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ServiceModelTransformationValidator extends AbstractInputModelValidator<ServiceModel> {
    /**
     * Validate input models for errors
     */
    override checkInputModelForErrors(ServiceModel serviceModel)
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
            [warnReferredMicroserviceTechnologies]
        ]
    }

    /**
     * Warn if microservices with technologies refer to microservices without technologies
     */
    private def Void warnReferredMicroserviceTechnologies(ServiceModel serviceModel) {
        val microservicesWithTechnologies = serviceModel.microservices
            .filter[!technologyReferences.empty]
        val referencesToMicroservicesWithoutTechnologies = microservicesWithTechnologies
            .exists[allRequiredMicroservices.keySet.exists[technologyReferences.empty]]

        if (referencesToMicroservicesWithoutTechnologies)
            warning("The model contains microservices with technology assignments, which refer " +
                "to services without technology assignments. For the services without " +
                "technology assignments, a code generation involving explicit technology " +
                "specifications would have to be performed.")
    }
}