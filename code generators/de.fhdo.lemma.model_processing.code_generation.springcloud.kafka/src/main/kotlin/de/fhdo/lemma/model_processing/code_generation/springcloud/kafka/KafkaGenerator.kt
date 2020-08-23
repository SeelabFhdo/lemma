package de.fhdo.lemma.model_processing.code_generation.springcloud.kafka

import de.fhdo.lemma.model_processing.AbstractModelProcessor
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.Genlet
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletEvent
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletEventObject
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletEventType
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedFileContent
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedNode
import de.fhdo.lemma.model_processing.code_generation.java_base.getAllAspects
import de.fhdo.lemma.model_processing.code_generation.java_base.getPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.hasAspect
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.shared.ApplicationProperties
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.avro.AvroConverters
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.consumer.KafkaListeners
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.shared.EventGroupInterfaceTypes
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.shared.KafkaConfiguration
import de.fhdo.lemma.service.intermediate.IntermediateInterface
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.service.intermediate.IntermediateParameter
import de.fhdo.lemma.technology.CommunicationType
import org.eclipse.emf.ecore.EObject

private const val BASE_PACKAGE = "de.fhdo.lemma.model_processing.code_generation.springcloud.kafka"

/**
 * Heap for this Genlet.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal lateinit var genletHeap: MutableMap<String, Any?>

/**
 * Main class of the Spring Cloud Kafka generator realized on the basis of LEMMA's model processing framework as an
 * [AbstractModelProcessor].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class KafkaGenerator : AbstractModelProcessor(BASE_PACKAGE), Genlet {
    override fun nameOfCodeGenerationHandlerPackage() = "$BASE_PACKAGE.handlers"
    override fun nameOfAspectHandlerPackage() = "${nameOfCodeGenerationHandlerPackage()}.aspects"
    override fun nameOfDependencyFragmentProviderPackage() = "$BASE_PACKAGE.dependencies"

    /**
     * React to a code generation event
     */
    override fun onEvent(event: GenletEvent) : Pair<Set<GenletGeneratedNode>, Set<GenletGeneratedFileContent>>? {
        return when (event.type) {
            /* Genlet was loaded */
            GenletEventType.GENLET_LOADED -> {
                genletHeap = heap()
                null
            }

            /* Processing of next intermediate EObject starts */
            GenletEventType.INTERMEDIATE_EOBJECT_PROCESSING_STARTS -> {
                processIntermediateEObject(event[GenletEventObject.INTERMEDIATE_EOBJECT]!!)
                null
            }

            /* Overall code generation has finished */
            GenletEventType.OVERALL_GENERATION_FINISHED -> {
                val generatedNodes = KafkaConfiguration.getGeneratedNodes().toMutableSet()
                generatedNodes.addAll(AvroConverters.getGeneratedNodes())

                // Reset Singletons
                ApplicationProperties.reset()
                KafkaConfiguration.reset()
                KafkaListeners.reset()
                EventGroupInterfaceTypes.reset()
                AvroConverters.reset()

                return generatedNodes to emptySet()
            }

            else -> null
        }
    }

    /**
     * Handle start of the processing of the next intermediate EObject
     */
    private fun processIntermediateEObject(eObject: EObject) {
        when (eObject) {
            is IntermediateInterface -> processIntermediateInterface(eObject)
            is IntermediateOperation -> processIntermediateOperation(eObject)
        }
    }

    /**
     * Handle start of the processing of an [IntermediateInterface]
     */
    private fun processIntermediateInterface(iface: IntermediateInterface) {
        // Handle all "pure" Kafka operations of the interface. A pure Kafka operation is an operation with the
        // Participant aspect from the Kafka technology model and no synchronous parameter.
        val pureKafkaOperations = iface.operations.filter {
            it.hasAspect("Kafka.Participant") &&
            !it.hasParametersOfCommunicationType(CommunicationType.SYNCHRONOUS)
        }
        pureKafkaOperations.forEach { processIntermediateOperation(it) }

        // We remove all pure Kafka operations from the interface, because we do not want the Java Base Generator and
        // subsequent Genlets to process them. The Java Base Generator, for example, would otherwise create composite
        // classes for asynchronous parameters. These elements are, however, not necessary for Spring Cloud Kafka.
        iface.operations.removeAll(pureKafkaOperations)
    }

    /**
     * Handle start of the processing of an [IntermediateOperation]
     */
    private fun processIntermediateOperation(operation: IntermediateOperation) {
        val asynchronousParameters = operation.parameters.filter {
            it.communicationType == CommunicationType.ASYNCHRONOUS.name
        }

        // Add Kafka producer and consumer elements for all Kafka participant operations and their topics to the
        // KafkaConfiguration class
        operation.addProducerConsumerElementsToKafkaConfiguration(
            "Kafka.Participant",
            KafkaConfiguration::addProducerElements,
            KafkaConfiguration::addConsumerElements,
            asynchronousParameters
        )

        // Add Avro-specific Kafka producer and consumer elements for all Avro-specific Kafka participant operations and
        // their topics to the KafkaConfiguration class
        operation.addProducerConsumerElementsToKafkaConfiguration(
            "Kafka.AvroParticipant",
            KafkaConfiguration::addAvroProducerElements,
            KafkaConfiguration::addAvroConsumerElements,
            asynchronousParameters
        )

        // Remove all asynchronous parameters from the Kafka participant operation, because we do not want the Java Base
        // Generator and subsequent Genlets to process them. The Java Base Generator, for example, would otherwise
        // create composite classes etc. for the parameters. These elements are, however, not necessary for Spring
        // Kafka.
        operation.parameters.removeAll(asynchronousParameters)
    }

    /**
     * Generic helper to add Kafka producer and consumer elements for all Kafka participant operations and their topics
     * to the KafkaConfiguration class. The given [participantAspectName] identifies the concrete Kafka participant
     * aspect to use, and the [addProducerElements] and [addConsumerElements] lambdas identify the operations on the
     * [KafkaConfiguration] Singleton to be invoked to add the producer and consumer elements to the resulting Java
     * class. The producer and consumer elements are derived for each operation parameter in the given [parameters]
     * list.
     */
    private fun IntermediateOperation.addProducerConsumerElementsToKafkaConfiguration(
        participantAspectName: String,
        addProducerElements: (String, IntermediateParameter) -> Unit,
        addConsumerElements: (String, String, IntermediateParameter) -> Unit,
        parameters: List<IntermediateParameter>
    ) {
        val topicsAndGroups = getTopicsAndGroups(participantAspectName)
        parameters.forEach { parameter ->
            // For each input and result parameter, consumer and producer elements are added to the KafkaConfiguration
            // class. That is, an operation with both an input and result parameter, will result in two operations and
            // the corresponding attributes in the KafkaConfiguration class.
            topicsAndGroups.forEach { (topic, group) ->
                if (parameter.isInputParameter())
                    addConsumerElements(topic, group!!, parameter)

                if (parameter.isResultParameter())
                    addProducerElements(topic, parameter)
            }
        }
    }

    /**
     * Get topics and corresponding consumer groups, if any, from this [IntermediateOperation] and all of its aspects
     * with the given [participantAspectName]
     */
    private fun IntermediateOperation.getTopicsAndGroups(participantAspectName: String)
        = getAllAspects(participantAspectName).map {
                it.getPropertyValue("topic")!! to it.getPropertyValue("consumerGroup")
            }
}

/**
 * Entry point of the Spring Cloud Kafka generator.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun main(args: Array<String>) {
    KafkaGenerator().run(args)
}