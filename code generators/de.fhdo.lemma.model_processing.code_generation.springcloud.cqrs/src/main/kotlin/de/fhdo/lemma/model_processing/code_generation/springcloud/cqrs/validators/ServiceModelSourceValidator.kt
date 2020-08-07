package de.fhdo.lemma.model_processing.code_generation.springcloud.cqrs.validators

import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.SourceModelValidator
import de.fhdo.lemma.model_processing.builtin_phases.source_model_validation.AbstractXtextSourceModelValidator
import de.fhdo.lemma.model_processing.builtin_phases.source_model_validation.SourceModelValidationMode
import de.fhdo.lemma.model_processing.code_generation.springcloud.cqrs.cqrsAlias
import de.fhdo.lemma.model_processing.languages.convertToAbsoluteFileUrisInPlace
import de.fhdo.lemma.model_processing.utils.getServiceAspect
import de.fhdo.lemma.model_processing.utils.getPropertyValue
import de.fhdo.lemma.model_processing.utils.hasInputParameters
import de.fhdo.lemma.model_processing.utils.hasResultParameters
import de.fhdo.lemma.model_processing.utils.hasServiceAspect
import de.fhdo.lemma.service.Interface
import de.fhdo.lemma.service.Microservice
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
@SourceModelValidator(
    validationMode = SourceModelValidationMode.XTEXT,
    supportedFileExtensions = ["services"]
)
internal class ServiceModelSourceValidator : AbstractXtextSourceModelValidator() {
    override fun getLanguageNamespace() = ServicePackage.eNS_URI

    /**
     * Prepare import model paths before validation
     */
    @Before
    private fun prepareImportModelPaths(resource: Resource) {
        val sm = resource.contents[0] as ServiceModel
        sm.imports.convertToAbsoluteFileUrisInPlace(resource)
    }

    /**
     * Check command side microservice
     */
    @Check
    private fun checkCommandSide(microservice: Microservice) {
        microservice.checkSideOperations("CommandSide") { operationsToCheck ->
            val hasAsynchronousOutgoingParameters = operationsToCheck.any {
                it.hasResultParameters(CommunicationType.ASYNCHRONOUS)
            }

            if (!hasAsynchronousOutgoingParameters)
                warning("Command side should have operations with asynchronous outgoing parameters that communicate " +
                    "state changes to query sides", ServicePackage.Literals.MICROSERVICE__REQUIRED_MICROSERVICES)
        }
    }

    /**
     * Helper to run checks on all operations specified for a given side [Microservice]
     */
    private fun Microservice.checkSideOperations(sideAspectName: String, checkOperations: (List<Operation>) -> Unit) {
        val cqrsAlias = cqrsAlias() ?: return
        val sideInterfaces = interfaces.filter { it.hasServiceAspect(cqrsAlias, sideAspectName) }.ifEmpty { interfaces }
        val operationsToCheck = sideInterfaces.map { it.operations }.flatten()
        checkOperations(operationsToCheck)
    }

    /**
     * Check command side interface
     */
    @Check
    private fun checkCommandSide(iface: Interface) {
        iface.checkSideOperations("CommandSide") { operations ->
            val hasAsynchronousOutgoingParameters = operations.any {
                it.hasResultParameters(CommunicationType.ASYNCHRONOUS)
            }

            if (!hasAsynchronousOutgoingParameters)
                warning("Command side should have operations with asynchronous outgoing parameters that communicate " +
                    "state changes to query sides", ServicePackage.Literals.INTERFACE__NAME)
        }
    }

    /**
     * Helper to run checks on all operations specified for a given side [Interface]
     */
    private fun Interface.checkSideOperations(sideAspectName: String, checkOperations: (List<Operation>) -> Unit) {
        val cqrsAlias = microservice.cqrsAlias() ?: return
        if (!hasServiceAspect(cqrsAlias, sideAspectName))
            return
        checkOperations(operations)
    }

    /**
     * Check query side microservice
     */
    @Check
    private fun checkQuerySide(microservice: Microservice) {
        microservice.checkSideOperations("QuerySide") { operationsToCheck ->
            val hasAsynchronousIncomingParameters = operationsToCheck.any {
                it.hasInputParameters(CommunicationType.ASYNCHRONOUS)
            }

            if (!hasAsynchronousIncomingParameters)
                warning("Query side should have operations with asynchronous incoming parameters to receive state " +
                    "changes from command sides", ServicePackage.Literals.MICROSERVICE__NAME)
        }

        // The query side should require a command side in order to receive updates on domain objects' states
        val cqrsAlias = microservice.cqrsAlias() ?: return
        val querySideAspect = microservice.getServiceAspect(cqrsAlias, "QuerySide") ?: return
        val logicalService = querySideAspect.getPropertyValue("logicalService") ?: return
        if (!microservice.requiresCommandSide(logicalService))
            warning("Command side with matching logical service could not be found in required microservices",
                    ServicePackage.Literals.MICROSERVICE__REQUIRED_MICROSERVICES)
    }

    /**
     * Helper to check whether this query side [Microservice] requires the command side from the same [logicalService]
     */
    private fun Microservice.requiresCommandSide(logicalService: String) : Boolean {
        return requiredMicroservices.any {
            val cqrsAlias = it.microservice.cqrsAlias()
            val commandSideAspect = if (cqrsAlias != null)
                    it.microservice.getServiceAspect(cqrsAlias, "CommandSide")
                else
                    null

            commandSideAspect != null && logicalService == commandSideAspect.getPropertyValue("logicalService")
        }
    }

    /**
     * Check query side interface
     */
    @Check
    private fun checkQuerySide(iface: Interface) {
        iface.checkSideOperations("QuerySide") { operations ->
            val hasAsynchronousIncomingParameters = operations.any {
                it.hasInputParameters(CommunicationType.ASYNCHRONOUS)
            }

            if (!hasAsynchronousIncomingParameters)
                warning("Query side should have operations with asynchronous incoming parameters to receive state " +
                    "changes from command sides", ServicePackage.Literals.INTERFACE__NAME)
        }

        // The query side interface should be part of a microservice with a command side interface in order to receive
        // updates on domain objects' states
        val microservice = iface.microservice
        val cqrsAlias = microservice.cqrsAlias() ?: return
        val hasCommandSide = microservice.interfaces.any {
            it.hasServiceAspect(cqrsAlias, "CommandSide")
        }
        if (!hasCommandSide)
            warning("No corresponding command side interface found in microservice",
                ServicePackage.Literals.INTERFACE__NAME)
    }
}