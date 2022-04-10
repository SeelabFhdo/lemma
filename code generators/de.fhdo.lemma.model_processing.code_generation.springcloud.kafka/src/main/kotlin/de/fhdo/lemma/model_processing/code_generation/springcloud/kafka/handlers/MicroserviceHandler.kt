package de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.handlers

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependency
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.getAllAspects
import de.fhdo.lemma.model_processing.code_generation.java_base.getAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.getPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.KAFKA_TECHNOLOGY_NAMES
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.forKafkaTechnology
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.genletHeap
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.shared.ApplicationProperties
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.shared.ApplicationProperties.newApplicationProperty
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.shared.KafkaConfiguration
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.shared.buildConsumerGroupPropertyName
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.shared.buildTopicPropertyName
import de.fhdo.lemma.model_processing.utils.hasTechnology
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice

private const val BOOTSTRAP_ADDRESS_PROPERTY = "kafka.bootstrapAddress"
private const val AVRO_REGISTRY_ADDRESS_PROPERTY = "kafka.avro.schemaRegistryAddress"

/**
 * Code generation handler for IntermediateMicroservice instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class MicroserviceHandler
    : GenletCodeGenerationHandlerI<IntermediateMicroservice, ClassOrInterfaceDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateMicroservice::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: IntermediateMicroservice, node: ClassOrInterfaceDeclaration, context: Nothing?)
        : GenletCodeGenerationHandlerResult<ClassOrInterfaceDeclaration>? {
        if (!eObject.hasTechnology(KAFKA_TECHNOLOGY_NAMES))
            return null

        /* Add Kafka dependency */
        node.addDependency("org.springframework.kafka:spring-kafka")

        ApplicationProperties.initialize()

        /* Initialize KafkaConfiguration Singleton, which represents the generated KafkaConfiguration Java class */
        val currentMicroservicePackage: String by state()
        val currentDomainPackage: String by state()
        KafkaConfiguration.initialize(currentMicroservicePackage, currentDomainPackage, genletHeap)

        // Add elements to KafkaConfiguration related to Kafka bootstrap address
        val bootstrapAddressAspect = eObject.getAspect("BootstrapAddress".forKafkaTechnology())!!
        bootstrapAddressAspect.newApplicationProperty("address", BOOTSTRAP_ADDRESS_PROPERTY)
        KafkaConfiguration.addBootstrapAddressElements(BOOTSTRAP_ADDRESS_PROPERTY)

        /*
         * Create Spring application properties for Kafka topics and consumer groups. Both are registered "on the fly"
         * as being found in the Participant aspects of the microservice's operations.
         */
        val allParticipantAspectNames = setOf("Participant", "AvroParticipant").forKafkaTechnology()
        eObject.interfaces
            .map { it.operations }
            .flatten()
            .mapNotNull { it.getAllAspects(*allParticipantAspectNames.toTypedArray()) }
            .flatten()
            .forEach {
                val topicName = it.getPropertyValue("topic")!!.decapitalize()
                it.newApplicationProperty("topic", buildTopicPropertyName(topicName))

                val consumerGroupName = it.getPropertyValue("consumerGroup")
                if (consumerGroupName != null)
                    it.newApplicationProperty("consumerGroup", buildConsumerGroupPropertyName(consumerGroupName))
            }

        /* Add dependencies, properties, and KafkaConfiguration elements for Avro, if it is used */
        val avroRegistryAddressAspect = eObject.getAspect("AvroRegistryAddress".forKafkaTechnology())
        if (avroRegistryAddressAspect != null) {
            node.addDependency("io.confluent:kafka-avro-serializer:5.5.0")
            node.addDependency("org.apache.avro:avro:1.9.2")
            avroRegistryAddressAspect.newApplicationProperty("address", AVRO_REGISTRY_ADDRESS_PROPERTY)
            KafkaConfiguration.addAvroRegistryAddressProperty(AVRO_REGISTRY_ADDRESS_PROPERTY)
        }

        return GenletCodeGenerationHandlerResult(node, ApplicationProperties.getGeneratedFile())
    }
}