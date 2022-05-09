package de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.validators

import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.SourceModelValidator
import de.fhdo.lemma.model_processing.phases.validation.AbstractXtextModelValidator
import de.fhdo.lemma.service.Operation
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.validation.Check

@SourceModelValidator
class ServiceModelSourceValidator : AbstractXtextModelValidator() {
    override fun getSupportedFileExtensions() = setOf("services")


    /**
     * Prepare import model paths before validation
     */
    @Before
    private fun prepareImportModelPaths(resource: Resource) {
//        val sm = resource.contents[0] as ServiceModel
//        sm.imports.convertToAbsoluteFileUrisInPlace(resource)
    }


    /**
     * Check event producers
     */
    @Check
    private fun checkProducer(operation: Operation) {
//        val domainEventsAlias = operation.`interface`.microservice.domainEventsAlias ?: return
//
//        // Operations with the Producer aspect must exhibit a result parameter
//        if (operation.hasServiceAspect(domainEventsAlias, "Producer") &&
//            !operation.hasResultParameters(CommunicationType.ASYNCHRONOUS))
//            error("The Producer aspect may only be applied to operations with a result parameter",
//                ServicePackage.Literals.OPERATION__NAME)
    }
}