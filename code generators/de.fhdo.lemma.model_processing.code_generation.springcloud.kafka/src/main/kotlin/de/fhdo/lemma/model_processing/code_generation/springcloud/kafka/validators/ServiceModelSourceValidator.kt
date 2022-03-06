package de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.validators

import com.google.common.base.Function
import de.fhdo.lemma.data.Type
import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.SourceModelValidator
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.cqrsAlias
import de.fhdo.lemma.model_processing.utils.countInputParameters
import de.fhdo.lemma.model_processing.utils.countResultParameters
import de.fhdo.lemma.model_processing.utils.getAllServiceAspects
import de.fhdo.lemma.model_processing.utils.getServiceAspect
import de.fhdo.lemma.model_processing.utils.getEndpointAddresses
import de.fhdo.lemma.model_processing.utils.hasServiceAspect
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.kafkaAlias
import de.fhdo.lemma.model_processing.languages.convertToAbsoluteFileUrisInPlace
import de.fhdo.lemma.model_processing.phases.validation.AbstractXtextModelValidator
import de.fhdo.lemma.model_processing.utils.getPropertyValue
import de.fhdo.lemma.model_processing.utils.hasInputParameters
import de.fhdo.lemma.model_processing.utils.hasResultParameters
import de.fhdo.lemma.model_processing.utils.isInputParameter
import de.fhdo.lemma.model_processing.utils.isResultParameter
import de.fhdo.lemma.service.ImportedServiceAspect
import de.fhdo.lemma.service.Interface
import de.fhdo.lemma.service.Microservice
import de.fhdo.lemma.service.Operation
import de.fhdo.lemma.service.ServiceModel
import de.fhdo.lemma.service.ServicePackage
import de.fhdo.lemma.technology.CommunicationType
import de.fhdo.lemma.typechecking.TypeChecker
import de.fhdo.lemma.typechecking.TypesNotCompatibleException
import de.fhdo.lemma.utils.LemmaUtils
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.validation.Check
import java.lang.IllegalArgumentException

/**
 * Validator for service source models. We implement the validation as an Xtext source model validator to take advantage
 * of LEMMA's Live Validation capabilities.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@SourceModelValidator
@Suppress("unused")
internal class ServiceModelSourceValidator : AbstractXtextModelValidator() {
    override fun getSupportedFileExtensions() = setOf("services")

    /**
     * Prepare import model paths before validation
     */
    @Before
    @Suppress("unused")
    private fun prepareImportModelPaths(resource: Resource) {
        val sm = resource.contents[0] as ServiceModel
        sm.imports.convertToAbsoluteFileUrisInPlace(resource)
    }

    /**
     * Check that a source [Microservice] with the Kafka technology has a valid Kafka bootstrap address specified via
     * the BootstrapAddress aspect
     */
    @Check
    @Suppress("unused")
    private fun checkBootstrapAddress(microservice: Microservice) {
        // Check aspect existence
        val kafkaAlias = microservice.kafkaAlias ?: return
        val bootstrapAddressAspect = microservice.getServiceAspect(kafkaAlias, "BootstrapAddress")
        if (bootstrapAddressAspect == null) {
            error("Kafka microservice requires BootstrapAddress aspect", ServicePackage.Literals.MICROSERVICE__NAME)
            return
        }

        // The bootstrap address must also be an endpoint of the microservice for the kafka protocol being specified in
        // the Kafka technology model
        val bootstrapAddress = bootstrapAddressAspect.getPropertyValue("address")!!.trim()
        val kafkaEndpointAddresses = microservice.getEndpointAddresses(kafkaAlias, "kafka")
        if (bootstrapAddress !in kafkaEndpointAddresses)
            error("Bootstrap address $bootstrapAddress is not defined as an endpoint address for " +
                "the kafka protocol on this microservice", bootstrapAddressAspect,
                ServicePackage.Literals.IMPORTED_SERVICE_ASPECT__IMPORTED_ASPECT)
    }

    /**
     * Warn if a microservice has an Avro schema registry address, but does not comprise Avro participant operations
     */
    @Check
    @Suppress("unused")
    private fun warnAvroRegistryAddress(microservice: Microservice) {
        val kafkaAlias = microservice.kafkaAlias ?: return
        if (!microservice.hasServiceAspect(kafkaAlias, "AvroRegistryAddress"))
            return

        val hasAvroParticipants = microservice.interfaces.map { it.operations }.flatten()
            .any { it.hasServiceAspect(kafkaAlias, "AvroParticipant") }
        if (!hasAvroParticipants)
            warning("Microservice specifies Avro schema registry address, but does not comprise Avro-specific Kafka " +
                "operation participants", microservice, ServicePackage.Literals.MICROSERVICE__NAME)
    }

    /**
     * Check that a microservice with an Avro schema registry address has Avro participant operations
     */
    @Check
    @Suppress("unused")
    private fun checkAvroRegistryAddress(operation: Operation) {
        val microservice = operation.`interface`.microservice
        val kafkaAlias = microservice.kafkaAlias ?: return
        if (operation.hasServiceAspect(kafkaAlias, "AvroParticipant") &&
            !microservice.hasServiceAspect(kafkaAlias, "AvroRegistryAddress"))
            error("Microservice of this Avro-specific Kafka operation participant does not specify Avro schema " +
                "registry address", operation, ServicePackage.Literals.OPERATION__NAME)
    }

    /**
     * Check source [Operation] that represents a Kafka participant as indicated by the Participant technology aspect
     */
    @Check
    @Suppress("unused")
    private fun checkKafkaParticipant(operation: Operation) {
        val kafkaAlias = operation.`interface`.microservice.kafkaAlias ?: return
        val participantAspects = operation.getAllServiceAspects(kafkaAlias, "Participant").toMutableList()
        participantAspects.addAll(operation.getAllServiceAspects(kafkaAlias, "AvroParticipant"))
        if (participantAspects.isEmpty())
            return

        // A Kafka participant must have at least one asynchronous parameter, and at most one input and result
        // asynchronous parameter
        val asynchronousInputParameterCount = operation.countInputParameters(CommunicationType.ASYNCHRONOUS)
        val asynchronousResultParameterCount = operation.countResultParameters(CommunicationType.ASYNCHRONOUS)
        if (asynchronousInputParameterCount == 0 && asynchronousResultParameterCount == 0)
            error("A Kafka operation participant must specify at least one asynchronous parameter", operation,
                ServicePackage.Literals.OPERATION__NAME)
        else if (asynchronousInputParameterCount > 1)
            error("A Kafka operation participant may specify at most one asynchronous input parameter", operation,
                ServicePackage.Literals.OPERATION__NAME)
        else if (asynchronousResultParameterCount > 1)
            error("A Kafka operation participant may specify at most one asynchronous result parameter", operation,
                ServicePackage.Literals.OPERATION__NAME)

        // Check for duplicate topics
        val topics = participantAspects.map { it.getPropertyValue("topic")!! }
        val duplicateIndex = LemmaUtils.getDuplicateIndex(topics, Function<String, String> { it })
        if (duplicateIndex > -1) {
            val aspect = participantAspects[duplicateIndex]
            val duplicateTopic = topics[duplicateIndex]
            error("""Duplicate topic "$duplicateTopic" in Participant aspect""", aspect,
                ServicePackage.Literals.IMPORTED_SERVICE_ASPECT__VALUES)
        }

        // A Kafka participant receiving asynchronous values via incoming asynchronous parameters must specify a Kafka
        // consumer group
        participantAspects.forEach {
            if (asynchronousInputParameterCount > 0 && it.getPropertyValue("consumerGroup") == null)
                error("A Kafka operation participant with incoming asynchronous parameters must specify a consumer " +
                    "group", it, ServicePackage.Literals.IMPORTED_SERVICE_ASPECT__IMPORTED_ASPECT)
        }
    }

    /**
     * Check error handling configuration of an [Operation] with the ErrorHandlingConfiguration aspect
     */
    @Check
    @Suppress("unused")
    private fun checkErrorHandlingConfiguration(operation: Operation) {
        val kafkaAlias = operation.`interface`.microservice.kafkaAlias ?: return
        val errorHandlingConfigurationAspect = operation.getServiceAspect(kafkaAlias, "ErrorHandlingConfiguration")
            ?: return

        // Retries upon error must not be negative
        val retriesUponError = errorHandlingConfigurationAspect.getPropertyValue("retriesUponError")?.toLong()
        if (retriesUponError != null && retriesUponError < 0)
            error("Value of retriesUponError property must not be negative", errorHandlingConfigurationAspect,
                ServicePackage.Literals.IMPORTED_SERVICE_ASPECT__IMPORTED_ASPECT)

        // Warn if error handling was disabled by means of DomainEvents.Consumer aspect
        if (operation.hasServiceAspect("DomainEvents.Consumer", "disableErrorHandling"))
            warning("ErrorHandlingConfiguration will not be effective, because error handling was disabled via the " +
                    "DomainEvents.Consumer aspect", errorHandlingConfigurationAspect,
                ServicePackage.Literals.IMPORTED_SERVICE_ASPECT__IMPORTED_ASPECT)

        // TODO For future Spring versions (retry interval)
        /*val retryInterval = errorHandlingConfigurationAspect.getPropertyValue("retryInterval")?.toLong()
        if (retryInterval != null && retryInterval < 0)
            error("Value of retryInterval property must not be negative", errorHandlingConfigurationAspect,
                ServicePackage.Literals.IMPORTED_SERVICE_ASPECT__IMPORTED_ASPECT)*/
    }

    /**
     * Check that for all operations of the CQRS query side of a microservice, type-compatible sender methods for
     * synchronization purposes exist in the command side of the microservice
     */
    @Check
    @Suppress("unused")
    private fun checkCommandSideSenderExistence(microservice: Microservice) {
        val cqrsAlias = microservice.cqrsAlias ?: return
        val querySideAspect = microservice.getServiceAspect(cqrsAlias, "QuerySide") ?: return
        val querySideOperations = microservice.getSideInterfaces(querySideAspect).getSideOperations(querySideAspect)

        // Command side microservices must be required by query side microservices to be identifiable as a corresponding
        // side
        val commandSideOperations = microservice.requiredMicroservices
            .filter { it.microservice.isCorrespondingSide(querySideAspect) }
            .map { it.microservice.getCorrespondingSideInterfaces(querySideAspect) }
            .flatten()
            .getCorrespondingSideOperations(querySideAspect)

        // Check if type-compatible command side operation exists for each query side operation
        querySideOperations.forEach { querySideOperation ->
            val existsCompatibleCommandSideSender = commandSideOperations.any { commandSideOperation ->
                val kafkaAlias = commandSideOperation.`interface`.microservice.kafkaAlias
                if (kafkaAlias != null && commandSideOperation.hasServiceAspect(kafkaAlias, "AvroParticipant"))
                    querySideOperation.canReceiveParametersWithKafka(commandSideOperation, "AvroParticipant")
                else
                    querySideOperation.canReceiveParametersWithKafka(commandSideOperation, "Participant")
            }

            if (!existsCompatibleCommandSideSender)
                warning("No compatible command side sender found for query side receiver", querySideOperation,
                    ServicePackage.Literals.OPERATION__NAME)
        }
    }

    /**
     * Get side interfaces of this [Microservice]. The side is represented by the given [sideAspect].
     */
    private fun Microservice.getSideInterfaces(sideAspect: ImportedServiceAspect)
        = getSideInterfaces(sideAspect.importedAspect.name)

    /**
     * Get all interfaces of this [Microservice], which have a CQRS aspect with the given [sideAspectName]
     */
    private fun Microservice.getSideInterfaces(sideAspectName: String)
        = interfaces.filter { it.hasServiceAspect(cqrsAlias!!, sideAspectName) }

    /**
     * Get side operations from this list of [Interface] instances. The side is represented by the given [sideAspect].
     */
    private fun List<Interface>.getSideOperations(sideAspect: ImportedServiceAspect)
        = getSideOperations(sideAspect.importedAspect.name)

    /**
     * Get side operations from this list of [Interface] instances. Command side operations must exhibit asynchronous
     * result parameters and query side operations must exhibit asynchronous input parameters. The side is represented
     * by the given [sideAspectName].
     */
    private fun List<Interface>.getSideOperations(sideAspectName: String) : List<Operation> {
        val sideFilter: (Operation) -> Boolean = when(sideAspectName) {
            "CommandSide" -> { { it.hasResultParameters(CommunicationType.ASYNCHRONOUS) } }
            "QuerySide" -> { { it.hasInputParameters(CommunicationType.ASYNCHRONOUS) } }
            else -> throw IllegalArgumentException("Unsupported side aspect $sideAspectName")
        }

        return map { it.operations }.flatten().filter(sideFilter)
    }

    /**
     * Check if this [Microservice] is the corresponding side of the side identified by the [sideAspect]. For example,
     * the corresponding side microservice for the QuerySide aspect would the microservice with the CommandSide aspect.
     * Furthermore, for two sides to correspond the logicalService property of the QuerySide and CommandSide aspects
     * must be equal.
     */
    private fun Microservice.isCorrespondingSide(sideAspect: ImportedServiceAspect) : Boolean {
        if (cqrsAlias == null)
            return false

        val correspondingAspectName = sideAspect.getCorrespondingSideAspectName()
        val logicalService = sideAspect.getPropertyValue("logicalService")
        val correspondingSideAspect = getServiceAspect(cqrsAlias!!, correspondingAspectName) ?: return false
        val correspondingSideLogicalService = correspondingSideAspect.getPropertyValue("logicalService")
        return logicalService == correspondingSideLogicalService
    }

    /**
     * Get side interfaces of this [Microservice], which correspond to the side represented by the given [sideAspect].
     * Returns, for example, all CommandSide interfaces of this [Microservice], if the [sideAspect] represents the
     * QuerySide aspect.
     */
    private fun Microservice.getCorrespondingSideInterfaces(sideAspect: ImportedServiceAspect)
        = getSideInterfaces(sideAspect.getCorrespondingSideAspectName())

    /**
     * Get corresponding side aspect name for this [ImportedServiceAspect]
     */
    private fun ImportedServiceAspect.getCorrespondingSideAspectName()
        = when(importedAspect.name) {
            "CommandSide" -> "QuerySide"
            "QuerySide" -> "CommandSide"
            else -> throw IllegalArgumentException("Unsupported side aspect ${importedAspect.name}")
        }

    /**
     * Get all operations from this list of [Interface] instances that correspond to the side represented by the
     * given [sideAspect]. If, for example, the [sideAspect] represents the QuerySide aspect, the returned operations
     * will exhibit the CommandSide aspect.
     */
    private fun List<Interface>.getCorrespondingSideOperations(sideAspect: ImportedServiceAspect)
        = getSideOperations(sideAspect.getCorrespondingSideAspectName())

    /**
     * Check if this [Operation] can receive parameters from the given [senderOperation] by means of Kafka
     */
    private fun Operation.canReceiveParametersWithKafka(senderOperation: Operation, aspectName: String) : Boolean {
        // Kafka aliases are required for sender and receiver
        val senderKafkaAlias = senderOperation.`interface`.microservice.kafkaAlias ?: return false
        val receiverKafkaAlias = `interface`.microservice.kafkaAlias ?: return false

        // Matching topics are required for sender and receiver
        val senderTopics = senderOperation.getAllServiceAspects(senderKafkaAlias, aspectName)
            .mapNotNull { it.getPropertyValue("topic") }
        if (senderTopics.isEmpty())
            return false

        val receiverTopics = getAllServiceAspects(receiverKafkaAlias, aspectName)
            .filter { it.getPropertyValue("consumerGroup") != null }
            .mapNotNull { it.getPropertyValue("topic") }
        if (receiverTopics.isEmpty())
            return false

        val existMatchingTopics = receiverTopics.any { it in senderTopics }
        if (!existMatchingTopics)
            return false

        // Result parameters of sender and input parameters of receiver must be partially type-compatible
        val senderParameters = senderOperation.parameters.filter {
            it.isResultParameter(CommunicationType.ASYNCHRONOUS)
        }
        val receiverParameters = parameters.filter { it.isInputParameter(CommunicationType.ASYNCHRONOUS) }
        return receiverParameters.any { receiverParam ->
            senderParameters.any { senderParam ->
                WrappedTypeChecker.typesCompatible(receiverParam.effectiveType, senderParam.effectiveType)
            }
        }
    }
}

/**
 * Helper Singleton that wraps LEMMA's type checker and provides convenience methods to access it.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private object WrappedTypeChecker {
    val typeChecker = TypeChecker()

    /**
     * Check if the given [receiverType] is type-compatible with the given [providerType]. That is, the [receiverType]
     * may receive type instances of the [providerType].
     */
    fun typesCompatible(receiverType: Type, providerType: Type)
        = try {
                typeChecker.checkTypeCompatibility(receiverType, providerType)
                true
            } catch (ex: TypesNotCompatibleException) {
                false
            }
}