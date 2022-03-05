package de.fhdo.lemma.model_processing.code_generation.springcloud.cqrs.validators

import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.SourceModelValidator
import de.fhdo.lemma.model_processing.code_generation.springcloud.cqrs.cqrsAlias
import de.fhdo.lemma.model_processing.languages.convertToAbsoluteFileUrisInPlace
import de.fhdo.lemma.model_processing.phases.validation.AbstractXtextModelValidator
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
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.validation.Check

/**
 * Validator for service source models. We implement the validation as an Xtext source model validator to take advantage
 * of LEMMA's Live Validation capabilities.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("unused")
@SourceModelValidator
internal class ServiceModelSourceValidator : AbstractXtextModelValidator() {
    override fun getSupportedFileExtensions() = setOf("services")

    /**
     * Prepare import model paths before validation
     */
    @Suppress("unused")
    @Before
    private fun prepareImportModelPaths(resource: Resource) {
        val sm = resource.contents[0] as ServiceModel
        sm.imports.convertToAbsoluteFileUrisInPlace(resource)
    }

    /**
     * Check command side microservice
     */
    @Suppress("unused")
    @Check
    private fun checkCommandSide(microservice: Microservice) {
        if (!microservice.hasSideAspect("CommandSide"))
            return

        microservice.checkSideOperations { operationsToCheck ->
            val hasAsynchronousOutgoingParameters = operationsToCheck.any {
                it.hasResultParameters(CommunicationType.ASYNCHRONOUS)
            }

            if (!hasAsynchronousOutgoingParameters)
                warning("Command side should have operations with asynchronous outgoing parameters that communicate " +
                    "state changes to query sides", microservice.getTargetLiteralForRequiredMicroservicesIssue())
        }
    }

    /**
     * Helper to check that this [Microservice] has an aspect from the CQRS technology model with the given
     * [sideAspectName]
     */
    private fun Microservice.hasSideAspect(sideAspectName: String) : Boolean {
        val cqrsAlias = cqrsAlias() ?: return false
        return hasServiceAspect(cqrsAlias, sideAspectName)
    }

    /**
     * Helper to run checks on all operations specified for a given side [Microservice]
     */
    private fun Microservice.checkSideOperations(checkOperations: (List<Operation>) -> Unit) {
        val operationsToCheck = interfaces.map { it.operations }.flatten()
        // Note that by intent we also invoke the check-lambda when the list of operations is empty
        checkOperations(operationsToCheck)
    }

    /**
     * Helper to determine the target [EStructuralFeature] for issues related to the specified required microservices
     * of this [Microservice]
     */
    private fun Microservice.getTargetLiteralForRequiredMicroservicesIssue() : EStructuralFeature {
        return if (requiredMicroservices.isNotEmpty())
                ServicePackage.Literals.MICROSERVICE__REQUIRED_MICROSERVICES
            // In case the microservice does not specify required microservices, use the name of the service as issue
            // target
            else
                ServicePackage.Literals.MICROSERVICE__NAME
    }

    /**
     * Check command side interface
     */
    @Suppress("unused")
    @Check
    private fun checkCommandSide(iface: Interface) {
        if (!iface.hasSideAspect("CommandSide"))
            return

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
     * Helper to check that this [Interface] has an aspect from the CQRS technology model with the given
     * [sideAspectName]
     */
    private fun Interface.hasSideAspect(sideAspectName: String) : Boolean {
        val cqrsAlias = microservice.cqrsAlias() ?: return false
        return hasServiceAspect(cqrsAlias, sideAspectName)
    }

    /**
     * Helper to run checks on all operations specified for a given side [Interface]
     */
    private fun Interface.checkSideOperations(sideAspectName: String, checkOperations: (List<Operation>) -> Unit) {
        if (!hasSideAspect(sideAspectName))
            return

        checkOperations(operations)
    }

    /**
     * Check query side microservice
     */
    @Suppress("unused")
    @Check
    private fun checkQuerySide(microservice: Microservice) {
        if (!microservice.hasSideAspect("QuerySide"))
            return

        microservice.checkSideOperations { operationsToCheck ->
            val hasAsynchronousIncomingParameters = operationsToCheck.any {
                it.hasInputParameters(CommunicationType.ASYNCHRONOUS)
            }

            if (!hasAsynchronousIncomingParameters)
                warning("Query side should have operations with asynchronous incoming parameters to receive state " +
                    "changes from command sides", ServicePackage.Literals.MICROSERVICE__NAME)
        }

        // The query side should require a command side in order to receive updates on domain objects' states
        val cqrsAlias = microservice.cqrsAlias()!!
        val querySideAspect = microservice.getServiceAspect(cqrsAlias, "QuerySide")!!
        val logicalService = querySideAspect.getPropertyValue("logicalService") ?: return
        if (!microservice.requiresCommandSide(logicalService))
            warning("Command side with matching logical service could not be found in required microservices",
                microservice.getTargetLiteralForRequiredMicroservicesIssue())
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
    @Suppress("unused")
    @Check
    private fun checkQuerySide(iface: Interface) {
        if (!iface.hasSideAspect("QuerySide"))
            return

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
        val cqrsAlias = microservice.cqrsAlias()!!
        val hasCommandSide = microservice.interfaces.any { it.hasServiceAspect(cqrsAlias, "CommandSide") }
        if (!hasCommandSide)
            warning("No corresponding command side interface found in microservice",
                ServicePackage.Literals.INTERFACE__NAME)
    }
}