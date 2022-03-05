package de.fhdo.lemma.model_processing.code_generation.springcloud.domain_events.validators

import de.fhdo.lemma.data.ComplexTypeFeature
import de.fhdo.lemma.data.DataStructure
import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.SourceModelValidator
import de.fhdo.lemma.model_processing.code_generation.springcloud.domain_events.domainEventsAlias
import de.fhdo.lemma.model_processing.languages.convertToAbsoluteFileUrisInPlace
import de.fhdo.lemma.model_processing.phases.validation.AbstractXtextModelValidator
import de.fhdo.lemma.model_processing.utils.getServiceAspect
import de.fhdo.lemma.model_processing.utils.hasInputParameters
import de.fhdo.lemma.model_processing.utils.hasResultParameters
import de.fhdo.lemma.model_processing.utils.hasServiceAspect
import de.fhdo.lemma.service.Operation
import de.fhdo.lemma.service.ServiceModel
import de.fhdo.lemma.service.ServicePackage
import de.fhdo.lemma.technology.CommunicationType
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.validation.Check

/**
 * Validator for service source models. We implement the validation as an Xtext source model validator to take advantage
 * of LEMMA's Live Validation capabilities.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@SourceModelValidator
internal class ServiceModelSourceValidator : AbstractXtextModelValidator() {
    override fun getSupportedFileExtensions() = setOf("services")

    /**
     * Prepare import model paths before validation
     */
    @Before
    private fun prepareImportModelPaths(resource: Resource) {
        val sm = resource.contents[0] as ServiceModel
        sm.imports.convertToAbsoluteFileUrisInPlace(resource)
    }

    /**
     * Check event producers
     */
    @Check
    private fun checkProducer(operation: Operation) {
        val domainEventsAlias = operation.`interface`.microservice.domainEventsAlias ?: return

        // Operations with the Producer aspect must exhibit a result parameter
        if (operation.hasServiceAspect(domainEventsAlias, "Producer") &&
            !operation.hasResultParameters(CommunicationType.ASYNCHRONOUS))
            error("The Producer aspect may only be applied to operations with a result parameter",
                ServicePackage.Literals.OPERATION__NAME)
    }

    /**
     * Check event consumers
     */
    @Check
    private fun checkConsumer(operation: Operation) {
        val domainEventsAlias = operation.`interface`.microservice.domainEventsAlias ?: return
        val consumerAspect = operation.getServiceAspect(domainEventsAlias, "Consumer") ?: return

        // Operations with the Consumer aspect must exhibit an input parameter
        if (!operation.hasInputParameters(CommunicationType.ASYNCHRONOUS)) {
            error("The Consumer aspect may only be applied to operations with an input parameter",
                ServicePackage.Literals.OPERATION__NAME)
            return
        }

        // All parameters of group-events-only consumers must be domain events
        val groupEventsOnly = consumerAspect.values.find { it.property.name == "groupEventsOnly" }!!.value.asBoolean()
        if (!groupEventsOnly)
            return
        val nonDomainEventParameters = operation.parameters.filterNot {
            val dataStructureType = it.effectiveType as? DataStructure
            dataStructureType?.hasFeature(ComplexTypeFeature.DOMAIN_EVENT) ?: false
        }
        nonDomainEventParameters.forEach {
            error("All parameters of group-events-only consumers must be domain events", it,
                ServicePackage.Literals.PARAMETER__NAME)
        }
    }
}