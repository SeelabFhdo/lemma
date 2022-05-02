package de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.shared

import com.github.javaparser.StaticJavaParser
import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.FieldDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.type.ClassOrInterfaceType
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.data.intermediate.IntermediateImportedComplexType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addStatements
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getImports
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.newJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedNode
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletPathSpecifier
import de.fhdo.lemma.model_processing.code_generation.java_base.getAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.getFirstMatchingAspectPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.getPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.hasAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.qualifiedName
import de.fhdo.lemma.model_processing.code_generation.java_base.resolve
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.addBeanMethod
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.addPropertyInjectedAttribute
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.addRelocatableImport
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.avro.AvroConversionTypeManager
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.booleanAspectPropertyValueOrFalse
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.classOrInterfaceType
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.consumer.KafkaListeners
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.consumer.KafkaListeners.adaptToErrorHandlerIfRequired
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.countMethodsWithPrefix
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.findMethod
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.forDomainEventsTechnology
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.forKafkaTechnology
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.getTypeArg
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.methodExists
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.producer.KafkaProducerService
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.toGenericTypeWithStringKey
import de.fhdo.lemma.model_processing.utils.trimToSingleLine
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.service.intermediate.IntermediateParameter
import java.io.File

internal fun buildTopicPropertyName(topicName: String) = "kafka.topic.$topicName"
internal fun buildConsumerGroupPropertyName(consumerGroupName: String) = "kafka.group.$consumerGroupName"

/**
 * Singleton that represents the contents of the KafkaConfiguration Java class, which initializes Kafka within the
 * generated microservice, and registers Kafka consumers and listeners.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object KafkaConfiguration {
    private const val PARENT_PACKAGE_NAME = "kafka"
    private const val CLASSNAME = "KafkaConfiguration"
    private const val BOOTSTRAP_ADDRESS_ATTRIBUTE_NAME = "bootstrapAddress"
    private const val BOOTSTRAP_ADDRESS_METHOD_NAME = "kafkaAdmin"
    private const val AVRO_PREFIX = "avro"
    private const val AVRO_REGISTRY_ADDRESS_ATTRIBUTE_NAME = "${AVRO_PREFIX}SchemaRegistryAddress"
    private val relativeFilepath = "$PARENT_PACKAGE_NAME${File.separator}$CLASSNAME"

    private var packageName: String? = null
    private var genletHeap: MutableMap<String, Any?>? = null
    private var kafkaConfiguration: ClassOrInterfaceDeclaration? = null
    private val AVRO_SUFFIX = AVRO_PREFIX.capitalize()
    private val AVRO_GENERIC_RECORD_TYPE = StaticJavaParser.parseClassOrInterfaceType("GenericRecord")
    private val AVRO_GENERIC_RECORD_TYPE_IMPORTS = setOf("org.apache.avro.generic.GenericRecord")
    private var genericAvroProducer: MethodDeclaration? = null
    private val producerServices = mutableMapOf<String?, KafkaProducerService>()

    /**
     * Initialize KafkaConfiguration
     */
    fun initialize(currentMicroservicePackage: String, currentDomainPackage: String,
        genletHeap: MutableMap<String, Any?>) {
        packageName = "$currentMicroservicePackage.$PARENT_PACKAGE_NAME"
        this.genletHeap = genletHeap
        val fullyQualifiedName = "$packageName.$CLASSNAME"
        if (fullyQualifiedName in genletHeap)
            kafkaConfiguration = genletHeap[fullyQualifiedName] as ClassOrInterfaceDeclaration
        else {
            // Create the KafkaConfiguration Java class together with its @Configuration annotation
            kafkaConfiguration = newJavaClassOrInterface(packageName!!, CLASSNAME)
            kafkaConfiguration!!.addAnnotation("Configuration", SerializationCharacteristic.DONT_RELOCATE)
            kafkaConfiguration!!.addImport(
                "org.springframework.context.annotation.Configuration",
                ImportTargetElementType.ANNOTATION,
                SerializationCharacteristic.DONT_RELOCATE
            )
            genletHeap[fullyQualifiedName] = kafkaConfiguration
        }

        // Initialize the KafkaListeners class
        KafkaListeners.initialize(packageName!!, currentDomainPackage, genletHeap)
    }

    /**
     * Reset KafkaConfiguration
     */
    fun reset() {
        packageName = null
        genletHeap = null
        kafkaConfiguration = null
        producerServices.clear()
        genericAvroProducer = null
    }

    /**
     * Add elements related to registering the Kafka bootstrap address to KafkaConfiguration
     */
    fun addBootstrapAddressElements(bootstrapAddressPropertyName: String) {
        kafkaConfiguration!!.addPropertyInjectedAttribute(BOOTSTRAP_ADDRESS_ATTRIBUTE_NAME,
            bootstrapAddressPropertyName)
        addBootstrapAddressMethod()
    }

    /**
     * Add method to register the Kafka bootstrap address with Kafka's admin configuration
     */
    private fun addBootstrapAddressMethod() {
        if (kafkaConfiguration!!.methodExists(BOOTSTRAP_ADDRESS_METHOD_NAME))
            return

        // Create method
        val method = kafkaConfiguration!!.addBeanMethod(BOOTSTRAP_ADDRESS_METHOD_NAME)
        method.setType("KafkaAdmin")
        method.addRelocatableImport("org.springframework.kafka.core.KafkaAdmin", ImportTargetElementType.METHOD)

        // Create method body
        method.addStatements(
            """
                |Map<String, Object> configs = new HashMap<>();
                |configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, $BOOTSTRAP_ADDRESS_ATTRIBUTE_NAME);
                |return new KafkaAdmin(configs);
            """.trimMargin()
        )
        method.addRelocatableImport("java.util.Map")
        method.addRelocatableImport("java.util.HashMap")
        method.addRelocatableImport("org.apache.kafka.clients.admin.AdminClientConfig")
    }

    /**
     * Add Kafka producer for [topic] and from asynchronous input [IntermediateParameter] to KafkaConfiguration and
     * producer service
     */
    fun addProducerElements(topic: String, parameter: IntermediateParameter) {
        val producerMethod = addOrGetProducerMethod(topic, parameter)
        val operation = parameter.operation
        val (producerService, producerAttribute) = addElementsToProducerService(operation, producerMethod, topic)
        producerService.addSendMethod(operation.name, topic, producerMethod, producerAttribute)

        addProducerElementsForDomainEventGroup(topic, parameter)
    }

    /**
     * Add a Kafka producer method to the KafkaConfiguration class, if does not exist already. The given [topic] will
     * be used as the prefix of the producer method and the value type of the producer is determined by the type of the
     * given [parameter].
     */
    private fun addOrGetProducerMethod(topic: String, parameter: IntermediateParameter) : MethodDeclaration {
        val (valueType, valueTypeImports) = parameter.classOrInterfaceType()!!
        return addOrGetProducerMethod(topic.decapitalize(), valueType, valueTypeImports)
    }

    /**
     * Add a Kafka producer method to the KafkaConfiguration class, if does not exist already. A Kafka producer is a
     * Spring Bean that returns a KafkaTemplate for the corresponding producer factory.
     */
    private fun addOrGetProducerMethod(prefix: String, valueType: ClassOrInterfaceType, valueTypeImports: Set<String>,
        producerFactoryGenerator: (prefix: String, type: ClassOrInterfaceType, typeImports: Set<String>) -> String
            = KafkaConfiguration::addProducerFactory) : MethodDeclaration {
        val methodName = "${prefix}Producer"
        var method = kafkaConfiguration!!.findMethod(methodName)
        if (method != null)
            return method

        /* Add corresponding producer factory to KafkaConfiguration */
        val factoryName = producerFactoryGenerator(prefix, valueType, valueTypeImports)

        /* Create method */
        method = kafkaConfiguration!!.addBeanMethod(methodName)
        method.type = "KafkaTemplate".toGenericTypeWithStringKey(valueType)
        method.addRelocatableImport("org.springframework.kafka.core.KafkaTemplate", ImportTargetElementType.METHOD)
        valueTypeImports.forEach { method.addRelocatableImport(it, ImportTargetElementType.METHOD) }

        /* Create method body */
        method.setBody("return new KafkaTemplate<>($factoryName())")

        return method
    }

    /**
     * Add Kafka producer factory to KafkaConfiguration
     */
    private fun addProducerFactory(factoryPrefix: String, type: ClassOrInterfaceType, typeImports: Set<String>)
        = addFactory(
            "${factoryPrefix}ProducerFactory",
            "ProducerFactory".toGenericTypeWithStringKey(type),
            typeImports,
            """
                |Map<String, Object> configProps = new HashMap<>();
                |configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, $BOOTSTRAP_ADDRESS_ATTRIBUTE_NAME);
                |configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
                |configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
                |return new DefaultKafkaProducerFactory<>(configProps);
            """.trimMargin(),
            setOf(
                "java.util.Map",
                "java.util.HashMap",
                "org.apache.kafka.clients.producer.ProducerConfig",
                "org.apache.kafka.common.serialization.StringSerializer",
                "org.springframework.kafka.support.serializer.JsonSerializer",
                "org.springframework.kafka.core.DefaultKafkaProducerFactory"
            )
        ).nameAsString

    /**
     * Add Kafka factory with the given [returnType] to KafkaConfiguration
     */
    private fun addFactory(name: String, returnType: ClassOrInterfaceType, signatureImports: Set<String>, body: String,
        bodyImports: Set<String>) : MethodDeclaration {
        /* Check if factory already exists */
        var method = kafkaConfiguration!!.findMethod(name)
        if (method != null)
            return method

        /* Create factory method */
        method = kafkaConfiguration!!.addMethod(name, Modifier.Keyword.PUBLIC)
        method.addSerializationCharacteristic(SerializationCharacteristic.REMOVE_ON_RELOCATION)

        // Create method signature
        method.type = returnType
        val factoryTypeName = returnType.nameAsString
        method.addRelocatableImport("org.springframework.kafka.core.$factoryTypeName", ImportTargetElementType.METHOD)
        signatureImports.forEach { method.addRelocatableImport(it, ImportTargetElementType.METHOD) }

        // Create method body
        method.addStatements(body)
        bodyImports.forEach { method.addRelocatableImport(it) }

        return method
    }

    /**
     * Add producer instance attribute and injecting setter to the [KafkaProducerService] for the given [operation]
     * and [producerMethod]
     */
    private fun addElementsToProducerService(operation: IntermediateOperation, producerMethod: MethodDeclaration,
        producerNamePrefix: String) : Pair<KafkaProducerService, FieldDeclaration> {
        val producerService = addOrGetProducerService(operation)
        val attributeType = producerMethod.type.asClassOrInterfaceType()
        val producerImports = producerMethod.getImports(setOf(ImportTargetElementType.METHOD))
        val producerAttribute = producerService.addProducerAttributeAndSetter(producerNamePrefix, attributeType,
            producerImports)
        return producerService to producerAttribute
    }

    /**
     * Add [KafkaProducerService] for this [operation], if it does not exist already
     */
    private fun addOrGetProducerService(operation: IntermediateOperation) : KafkaProducerService {
        // The producer service name may be adapted by means of the DomainEvents.Producer aspect and its handlerName
        // property
        val producerServiceName = operation.getFirstMatchingAspectPropertyValue("Producer".forDomainEventsTechnology(),
            "handlerName")
        var producerService = producerServices[producerServiceName]
        if (producerService != null)
            return producerService

        producerService = if (producerServiceName != null)
            KafkaProducerService(packageName!!, genletHeap!!, producerServiceName)
        else
            KafkaProducerService(packageName!!, genletHeap!!, operation.`interface`)
        producerServices[producerServiceName] = producerService
        return producerService
    }

    /**
     * Add Kafka producer for [topic] and the event group, if any, of asynchronous input [IntermediateParameter] to
     * producer service
     */
    private fun addProducerElementsForDomainEventGroup(topic: String, parameter: IntermediateParameter) {
        val (groupName, groupType, groupTypeName) = parameter.getDomainEventInfo() ?: return
        if (EventGroupInterfaceTypes.existProducerElementsForGroup(groupName))
            return

        val producerMethodPrefix = groupName.decapitalize()
        // The event group's interface type becomes the value type of the producer method
        val producerMethod = addOrGetProducerMethod(producerMethodPrefix, groupType, setOf(groupTypeName))

        val operation = parameter.operation
        val (producerService, producerAttribute) = addElementsToProducerService(operation, producerMethod, groupName)
        producerService.addSendMethod(operation.name, topic, producerMethod, producerAttribute)

        // Signal creation of producer elements for event group
        EventGroupInterfaceTypes.producerElementsCreatedForGroup(groupName)
    }

    /**
     * Get possible domain event information of this [IntermediateParameter]
     */
    private fun IntermediateParameter.getDomainEventInfo() : DomainEventInfo? {
        val importedComplexType = type as? IntermediateImportedComplexType ?: return null
        val dataStructure = importedComplexType.resolve() as? IntermediateDataStructure ?: return null
        val domainEventGroup = EventGroupInterfaceTypes[dataStructure] ?: return null
        val (eventGroupType, fullyQualifiedName) = EventGroupInterfaceTypes[domainEventGroup]!!
        return DomainEventInfo(domainEventGroup, eventGroupType, fullyQualifiedName)
    }

    /**
     * Helper class to describe domain event information
     */
    private class DomainEventInfo(val eventGroupName: String, val eventGroupType: ClassOrInterfaceType,
        val fullyQualifiedTypeName: String) {
        operator fun component1() = eventGroupName
        operator fun component2() = eventGroupType
        operator fun component3() = fullyQualifiedTypeName
    }

    /**
     * Add Kafka consumer for [topic], [consumerGroup], and from asynchronous input [IntermediateParameter] to
     * KafkaConfiguration, Listeners class, and corresponding consumer service
     */
    fun addConsumerElements(topic: String, consumerGroup: String, parameter: IntermediateParameter) {
        val consumerGroupAttributeName = addConsumerGroupAttribute(consumerGroup)

        val groupEventsOnly = parameter.operation.booleanAspectPropertyValueOrFalse(
            "Consumer".forDomainEventsTechnology(),
            "groupEventsOnly"
        )
        if (!groupEventsOnly) {
            val factoryPrefix = topic.decapitalize() + consumerGroup.capitalize()
            val (valueType, valueTypeImports) = parameter.classOrInterfaceType()!!
            val listenerFactoryName = addListenerContainerFactory(factoryPrefix, consumerGroupAttributeName, valueType,
                valueTypeImports, parameter)
            addElementsToConsumerService(topic, consumerGroup, parameter, listenerFactoryName)
        }

        addConsumerElementsForDomainEventGroup(topic, consumerGroup, parameter, consumerGroupAttributeName)
    }

    /**
     * Add consumer group attribute as property injected attribute to KafkaConfiguration
     */
    private fun addConsumerGroupAttribute(group: String, prefix: String = "") : String {
        val attributeName = if (prefix.isNotEmpty())
            "${prefix.decapitalize()}${group.capitalize()}ConsumerGroupId"
        else
            "${group.decapitalize()}ConsumerGroupId"
        kafkaConfiguration!!.addPropertyInjectedAttribute(attributeName, buildConsumerGroupPropertyName(group))
        return attributeName
    }

    /**
     * Add Kafka consumer elements for [topic], [consumerGroup], and from asynchronous input [IntermediateParameter] to
     * KafkaConfiguration, Listeners class, and corresponding consumer service
     */
    private fun addElementsToConsumerService(topic: String, consumerGroup: String, parameter: IntermediateParameter,
        listenerFactoryName: String) {
        val (valueType, valueTypeImports) = parameter.classOrInterfaceType()!!
        val consumerElements = KafkaListeners.addConsumerElements(parameter, valueType, valueTypeImports)
        val listenerMethod = KafkaListeners.addOrGetListenerMethod(parameter.operation.name, consumerElements, topic,
            consumerGroup, listenerFactoryName)
        listenerMethod.adaptToErrorHandlerIfRequired(parameter, consumerElements)
    }

    /**
     * Add listener container factory for Kafka consumers from asynchronous input [IntermediateParameter] to
     * KafkaConfiguration
     */
    private fun addListenerContainerFactory(prefix: String, groupAttributeName: String, valueType: ClassOrInterfaceType,
        valueTypeImports: Set<String>, parameter: IntermediateParameter,
        factoryGenerator: (String, ClassOrInterfaceType, Set<String>, String) -> MethodDeclaration
            = KafkaConfiguration::addJsonConsumerFactory
    ) : String {
        // Check if listener factory already exists
        val factoryName = "${prefix}KafkaListenerContainerFactory"
        if (kafkaConfiguration!!.methodExists(factoryName))
            return factoryName

        // Add corresponding consumer factory
        val consumerFactory = factoryGenerator(prefix, valueType, valueTypeImports, groupAttributeName)

        // Create method as a Spring Bean
        val method = kafkaConfiguration!!.addBeanMethod(factoryName)

        method.type = "ConcurrentKafkaListenerContainerFactory".toGenericTypeWithStringKey(valueType)
        method.addRelocatableImport("org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory",
            ImportTargetElementType.METHOD)
        valueTypeImports.forEach { method.addRelocatableImport(it, ImportTargetElementType.METHOD) }

        // Create method body
        val consumerFactoryName = consumerFactory.nameAsString
        val factoryValueTypeName = consumerFactory.type.getTypeArg(1)!!.asString()
        method.addStatements(
            """
                ConcurrentKafkaListenerContainerFactory<String, $factoryValueTypeName> factory 
                    = new ConcurrentKafkaListenerContainerFactory<>();
            """.trimToSingleLine(true) +
            """
                |
                |factory.setConsumerFactory($consumerFactoryName()); 
            """.trimMargin()
        )

        // Adapt to error handler if required (includes adding an error handling statement after the current body)
        method.adaptToErrorHandlerIfRequired(parameter, "factory")

        // Add return statement
        method.addStatements("return factory;")

        return factoryName
    }

    /**
     * Add JSON-specific Kafka consumer factory from asynchronous input [IntermediateParameter] to KafkaConfiguration
     */
    private fun addJsonConsumerFactory(factoryPrefix: String, type: ClassOrInterfaceType, typeImports: Set<String>,
        groupAttributeName: String) : MethodDeclaration {
        val consumerFactory = addFactory(
            "${factoryPrefix}ConsumerFactory",
            "ConsumerFactory".toGenericTypeWithStringKey(type),
            typeImports,
            """
                |Map<String, Object> configProps = new HashMap<>();
                |configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, $BOOTSTRAP_ADDRESS_ATTRIBUTE_NAME);
                |configProps.put(ConsumerConfig.GROUP_ID_CONFIG, $groupAttributeName);
                |configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
                |configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
            """.trimMargin(),
            setOf(
                "java.util.Map",
                "java.util.HashMap",
                "org.apache.kafka.clients.consumer.ConsumerConfig",
                "org.apache.kafka.common.serialization.StringDeserializer",
                "org.springframework.kafka.support.serializer.JsonDeserializer",
                "org.springframework.kafka.core.DefaultKafkaConsumerFactory"
            )
        )

        val factoryValueTypeName = consumerFactory.type.getTypeArg(1)!!.asString()
        consumerFactory.addStatements("return new DefaultKafkaConsumerFactory<>(configProps, " +
            "new StringDeserializer(), new JsonDeserializer<>($factoryValueTypeName.class));")

        return consumerFactory
    }

    /**
     * Adapt this listener container factory to an error handler, if prescribed by the Kafka.ErrorHandlingConfiguration
     * aspect and error handling was not disabled by means of the DomainEvents.Consumer aspect
     */
    private fun MethodDeclaration.adaptToErrorHandlerIfRequired(parameter: IntermediateParameter,
        listenerFactoryName: String) {
        val operation = parameter.operation
        /* Check if error handling is enabled at all */
        val disableErrorHandling = operation.booleanAspectPropertyValueOrFalse("Consumer".forDomainEventsTechnology(),
            "disableErrorHandling")
        if (disableErrorHandling)
            return

        /* Check for error handling configuration and get configuration properties */
        val errorHandlingAspect = operation.getAspect("ErrorHandlingConfiguration".forKafkaTechnology())
        val (retriesUponError, retryInterval) = if (errorHandlingAspect != null) {
            errorHandlingAspect.getPropertyValue("retriesUponError")?.toLong() to
                    errorHandlingAspect.getPropertyValue("retryInterval")?.toLong()
        } else
            null to null

        /* Add imports and statements to listener container factory depending on error handling configuration */
        addRelocatableImport("org.springframework.kafka.listener.SeekToCurrentErrorHandler",
            ImportTargetElementType.METHOD_BODY)
        // TODO Future support for retryInterval property
        //addRelocatableImport("org.springframework.kafka.listener.SeekToCurrentErrorHandler",
        //    ImportTargetElementType.METHOD_BODY)
        //addRelocatableImport("org.springframework.util.backoff.FixedBackOff", ImportTargetElementType.METHOD_BODY)
        val errorHandlerConstructionStatement = if (retriesUponError != null && retryInterval != null) {
            val maxFailures = retriesUponError + 1
            "new SeekToCurrentErrorHandler(null, $maxFailures)"
            // TODO Future support for retryInterval property
            // "new SeekToCurrentErrorHandler(new FixedBackOff(${retryInterval}L, ${retriesUponError}L))"
        } else if (retriesUponError != null) {
            val maxFailures = retriesUponError + 1
            "new SeekToCurrentErrorHandler(null, $maxFailures)"
            // TODO Future support for retryInterval property
            //"new SeekToCurrentErrorHandler(new FixedBackOff(${retryInterval}L, FixedBackOff.UNLIMITED_ATTEMPTS))"
        } else
            "new SeekToCurrentErrorHandler()"
            // TODO Future support for retryInterval property
            //"new SeekToCurrentErrorHandler(new FixedBackOff(FixedBackOff.DEFAULT_INTERVAL, ${retriesUponError}L))"

        addStatements("${listenerFactoryName}.setErrorHandler($errorHandlerConstructionStatement);")
    }

    /**
     * Add Kafka consumer targeting domain event group for [topic], [consumerGroup], and from asynchronous input
     * [IntermediateParameter] to KafkaConfiguration, Listeners class, and corresponding consumer service
     */
    private fun addConsumerElementsForDomainEventGroup(topic: String, consumerGroup: String,
        parameter: IntermediateParameter, consumerGroupAttributeName: String) {
        // Get domain event group information, if any
        val (domainEventGroup, eventGroupType, eventGroupTypeName) = parameter.getDomainEventInfo() ?: return
        if (EventGroupInterfaceTypes.existConsumerElementsForGroup(domainEventGroup))
            return

        // Add listener container factory to KafkaConfiguration
        val factoryName = addListenerContainerFactory(domainEventGroup.decapitalize(), consumerGroupAttributeName,
            eventGroupType, setOf(eventGroupTypeName), parameter)

        // Add elements to Listeners class
        val consumerElements = KafkaListeners.addConsumerElements(parameter, eventGroupType, setOf(eventGroupTypeName))
        val listenerMethod = KafkaListeners.addOrGetListenerMethod(parameter.operation.name, consumerElements, topic,
            consumerGroup, factoryName)
        listenerMethod.adaptToErrorHandlerIfRequired(parameter, consumerElements)

        // Signal elements creation for event group
        EventGroupInterfaceTypes.consumerElementsCreatedForGroup(domainEventGroup)
    }

    /**
     * Add Avro registry address as value-injected property to KafkaConfiguration
     */
    fun addAvroRegistryAddressProperty(avroRegistryAddressPropertyName: String) {
        kafkaConfiguration!!.addPropertyInjectedAttribute(AVRO_REGISTRY_ADDRESS_ATTRIBUTE_NAME,
            avroRegistryAddressPropertyName)
    }

    /**
     * Add Avro producer for [topic] and from asynchronous input [IntermediateParameter] to KafkaConfiguration and
     * producer service
     */
    fun addAvroProducerElements(topic: String, parameter: IntermediateParameter) {
        addGenericAvroProducerElements(topic, parameter)
        addSchemaSpecificAvroProducerElements(topic, parameter)
    }

    private fun addGenericAvroProducerElements(topic: String, parameter: IntermediateParameter) {
        if (genericAvroProducer == null)
            genericAvroProducer = addOrGetProducerMethod(
                "generic$AVRO_SUFFIX",
                AVRO_GENERIC_RECORD_TYPE,
                AVRO_GENERIC_RECORD_TYPE_IMPORTS,
                KafkaConfiguration::addGenericAvroProducerFactory
            )

        val operation = parameter.operation
        val (producerService, producerAttribute) = addElementsToProducerService(operation, genericAvroProducer!!,
            "generic$AVRO_SUFFIX")
        producerService.addSendMethod(operation.name, topic, genericAvroProducer!!, producerAttribute,
            "new ProducerRecord<>", setOf("org.apache.kafka.clients.producer.ProducerRecord"))
    }

    /**
     * Add Avro producer factory for GenericRecords to KafkaConfiguration
     */
    private fun addGenericAvroProducerFactory(factoryPrefix: String, producerType: ClassOrInterfaceType,
        typeImports: Set<String>)
        = addFactory(
            "${factoryPrefix}ProducerFactory".toUniqueMethodName(),
            "ProducerFactory".toGenericTypeWithStringKey(producerType),
            typeImports,
            """
                |Map<String, Object> configProps = new HashMap<>();
                |configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, $BOOTSTRAP_ADDRESS_ATTRIBUTE_NAME);
                |configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
                |configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
                |configProps.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, $AVRO_REGISTRY_ADDRESS_ATTRIBUTE_NAME);
                |return new DefaultKafkaProducerFactory<>(configProps);
            """.trimMargin(),
            setOf(
                "java.util.Map",
                "java.util.HashMap",
                "org.apache.kafka.clients.producer.ProducerConfig",
                "org.apache.kafka.common.serialization.StringSerializer",
                "io.confluent.kafka.serializers.KafkaAvroSerializerConfig",
                "io.confluent.kafka.serializers.KafkaAvroSerializer",
                "org.springframework.kafka.core.DefaultKafkaProducerFactory"
            )
        ).nameAsString

    /**
     * Helper to retrieve a unique method name from this prefix String within the given [clazz]. By default, [clazz] is
     * [KafkaConfiguration]. If methods with this prefix String exist in the [clazz], the unique name will correspond to
     * this prefix String with the incremented count of existing prefixed methods attached.
     */
    private fun String.toUniqueMethodName(clazz: ClassOrInterfaceDeclaration = kafkaConfiguration!!) : String {
        val existingMethodsCount = clazz.countMethodsWithPrefix(this)
        return if (existingMethodsCount == 0)
            this
        else
            this + (existingMethodsCount + 1)
    }

    private fun addSchemaSpecificAvroProducerElements(topic: String, parameter: IntermediateParameter) {
        val avroSchemaRootClass = parameter.getAvroSchemaRootClass() ?: return

        val producerMethod = addOrGetProducerMethod(
            "${parameter.type.name.decapitalize()}$AVRO_SUFFIX",
            StaticJavaParser.parseClassOrInterfaceType(parameter.type.name),
            setOf(avroSchemaRootClass.fullyQualifiedName.get()),
            KafkaConfiguration::addSchemaSpecificAvroProducerFactory
        )

        val operation = parameter.operation
        val (producerService, producerAttribute) = addElementsToProducerService(operation, producerMethod,
            "${parameter.type.name.decapitalize()}$AVRO_SUFFIX")
        producerService.addSendMethod(operation.name, topic, producerMethod, producerAttribute,
            "new ProducerRecord<>", setOf("org.apache.kafka.clients.producer.ProducerRecord"))
    }

    private fun IntermediateParameter.getAvroSchemaRootClass() : ClassOrInterfaceDeclaration? {
        val importedType = type as? IntermediateImportedComplexType ?: return null
        return AvroConversionTypeManager.getRootType(importedType.qualifiedName)
    }

    private fun addSchemaSpecificAvroProducerFactory(factoryPrefix: String, producerType: ClassOrInterfaceType,
        typeImports: Set<String>)
        = addFactory(
            "${factoryPrefix}ProducerFactory".toUniqueMethodName(),
            "ProducerFactory".toGenericTypeWithStringKey(producerType),
            typeImports,
            """
                |Map<String, Object> configProps = new HashMap<>();
                |configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, $BOOTSTRAP_ADDRESS_ATTRIBUTE_NAME);
                |configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
                |configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
                |configProps.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG, $AVRO_REGISTRY_ADDRESS_ATTRIBUTE_NAME);
                |return new DefaultKafkaProducerFactory<>(configProps);
            """.trimMargin(),
            setOf(
                "java.util.Map",
                "java.util.HashMap",
                "org.apache.kafka.clients.producer.ProducerConfig",
                "org.apache.kafka.common.serialization.StringSerializer",
                "io.confluent.kafka.serializers.KafkaAvroSerializerConfig",
                "io.confluent.kafka.serializers.KafkaAvroSerializer",
                "org.springframework.kafka.core.DefaultKafkaProducerFactory"
            )
        ).nameAsString

    /**
     * Add Avro consumer for [topic], [consumerGroup], and from asynchronous input [IntermediateParameter] to
     * KafkaConfiguration, Listeners class, and corresponding consumer service
     */
    fun addAvroConsumerElements(topic: String, consumerGroup: String, parameter: IntermediateParameter) {
        // Add consumer group attribute
        val consumerGroupAttributeName = addConsumerGroupAttribute(consumerGroup, AVRO_PREFIX)

        // Add listener container factory
        val avroSchemaRootClass = parameter.getAvroSchemaRootClass()
        if (avroSchemaRootClass != null) {
            addAvroConsumerListenerElements(
                topic,
                consumerGroup,
                consumerGroupAttributeName,
                parameter,
                avroSchemaRootClass.nameAsString,
                setOf(avroSchemaRootClass.fullyQualifiedName.get()),
                KafkaConfiguration::addSpecificReaderAvroConsumerFactory
            )

            /*addAvroConsumerListenerElements(
                topic,
                consumerGroup,
                consumerGroupAttributeName,
                parameter,
                AVRO_GENERIC_RECORD_TYPE.nameAsString,
                AVRO_GENERIC_RECORD_TYPE_IMPORTS,
                KafkaConfiguration::addUnspecificReaderAvroConsumerFactory,
                AVRO_PREFIX.decapitalize() + AVRO_GENERIC_RECORD_TYPE.nameAsString + topic.capitalize(),
                AVRO_PREFIX.decapitalize() + AVRO_GENERIC_RECORD_TYPE.nameAsString +
                    parameter.operation.name.capitalize()
            )*/
        } else
            addAvroConsumerListenerElements(topic, consumerGroup, consumerGroupAttributeName, parameter, "Object",
                emptySet())
    }

    private fun addAvroConsumerListenerElements(
        topic: String,
        consumerGroup: String,
        consumerGroupAttributeName: String,
        parameter: IntermediateParameter,
        factoryTypeName: String,
        typeImports: Set<String>,
        factoryGenerator: (String, ClassOrInterfaceType, Set<String>, String) -> MethodDeclaration
            = KafkaConfiguration::addGenericAvroConsumerFactory,
        factoryName: String = AVRO_PREFIX.decapitalize() + topic.capitalize(),
        listenerPrefix: String = AVRO_PREFIX.decapitalize() + parameter.operation.name.capitalize()
    ) {
        val factoryType = StaticJavaParser.parseClassOrInterfaceType(factoryTypeName)
        val listenerFactoryName = addListenerContainerFactory(
            factoryName,
            consumerGroupAttributeName,
            factoryType,
            typeImports,
            parameter,
            factoryGenerator
        )

        // Add Listeners elements
        val consumerElements = KafkaListeners.addConsumerElements(parameter, factoryType, typeImports, AVRO_PREFIX)
        val listenerMethod = KafkaListeners.addOrGetListenerMethod(listenerPrefix, consumerElements, topic,
            consumerGroup, listenerFactoryName)

        // Adapt to error handler, if required
        listenerMethod.adaptToErrorHandlerIfRequired(parameter, consumerElements)
    }

    private fun addSpecificReaderAvroConsumerFactory(factoryPrefix: String, type: ClassOrInterfaceType,
        typeImports: Set<String>, groupAttributeName: String)
        = addReaderAvroConsumerFactory(factoryPrefix, type, typeImports, groupAttributeName, true)

    /**
     * Add Avro consumer factory with explicitly activated or deactivated specific-reader feature from asynchronous
     * input [IntermediateParameter] to KafkaConfiguration
     */
    private fun addReaderAvroConsumerFactory(factoryPrefix: String, type: ClassOrInterfaceType,
        typeImports: Set<String>, groupAttributeName: String, specificAvroReaderConfig: Boolean)
        = addFactory(
            "${factoryPrefix}ConsumerFactory".toUniqueMethodName(),
            "ConsumerFactory".toGenericTypeWithStringKey(type),
            typeImports,
            """
                |Map<String, Object> configProps = new HashMap<>();
                |configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, $BOOTSTRAP_ADDRESS_ATTRIBUTE_NAME);
                |configProps.put(ConsumerConfig.GROUP_ID_CONFIG, $groupAttributeName);
                |configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
                |configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
                |configProps.put(KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, $AVRO_REGISTRY_ADDRESS_ATTRIBUTE_NAME);
                |configProps.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true);
                |return new DefaultKafkaConsumerFactory<>(configProps);
            """.trimMargin(),
            setOf(
                "java.util.Map",
                "java.util.HashMap",
                "org.apache.kafka.clients.consumer.ConsumerConfig",
                "org.apache.kafka.common.serialization.StringDeserializer",
                "io.confluent.kafka.serializers.KafkaAvroDeserializer",
                "io.confluent.kafka.serializers.KafkaAvroDeserializerConfig",
                "org.springframework.kafka.core.DefaultKafkaConsumerFactory"
            )
        )

    private fun addUnspecificReaderAvroConsumerFactory(factoryPrefix: String, type: ClassOrInterfaceType,
        typeImports: Set<String>, groupAttributeName: String)
        = addReaderAvroConsumerFactory(factoryPrefix, type, typeImports, groupAttributeName, false)

    /**
     * Add generic Avro consumer factory from asynchronous input [IntermediateParameter] to KafkaConfiguration. In
     * particular, this kind of Avro consumer factory doesn't have the specific-reader feature activated.
     */
    private fun addGenericAvroConsumerFactory(factoryPrefix: String, type: ClassOrInterfaceType,
        typeImports: Set<String>, groupAttributeName: String)
        = addFactory(
            "${factoryPrefix}ConsumerFactory".toUniqueMethodName(),
            "ConsumerFactory".toGenericTypeWithStringKey(type),
            typeImports,
            """
                |KafkaAvroDeserializer deserializer = new KafkaAvroDeserializer();
                |Map<String, Object> configProps = new HashMap<>();
                |configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, $BOOTSTRAP_ADDRESS_ATTRIBUTE_NAME);
                |configProps.put(ConsumerConfig.GROUP_ID_CONFIG, $groupAttributeName);
                |configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
                |configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
                |configProps.put(KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, $AVRO_REGISTRY_ADDRESS_ATTRIBUTE_NAME);
                |deserializer.configure(configProps, false);
                |return new DefaultKafkaConsumerFactory<>(configProps, new StringDeserializer(), deserializer);
            """.trimMargin(),
            setOf(
                "java.util.Map",
                "java.util.HashMap",
                "org.apache.kafka.clients.consumer.ConsumerConfig",
                "org.apache.kafka.common.serialization.StringDeserializer",
                "io.confluent.kafka.serializers.KafkaAvroDeserializer",
                "io.confluent.kafka.serializers.KafkaAvroDeserializerConfig",
                "org.springframework.kafka.core.DefaultKafkaConsumerFactory"
            )
        )

    private fun buildGenericAvroConsumerFactoryName(topic: String)
        = AVRO_PREFIX.decapitalize() + AVRO_GENERIC_RECORD_TYPE.nameAsString + topic.capitalize()

    /**
     * Get the KafkaConfiguration, producer service, and consumer service classes as JavaParser AST nodes
     */
    fun getGeneratedNodes() : Set<GenletGeneratedNode> {
        val generatedNodes = mutableSetOf<GenletGeneratedNode>()

        // Get KafkaConfiguration node. The Java class will be located in the Java root path of the microservice being
        // currently handled by the Java Base Generator.
        if (kafkaConfiguration != null)
            generatedNodes.add(GenletGeneratedNode(
                GenletPathSpecifier.CURRENT_MICROSERVICE_JAVA_ROOT_PATH,
                "$relativeFilepath.java",
                kafkaConfiguration!!
            ))

        // Get producer service nodes
        generatedNodes.addAll(
            producerServices.values.mapNotNull {
                it.getGeneratedNode(
                    GenletPathSpecifier.CURRENT_MICROSERVICE_JAVA_ROOT_PATH,
                    PARENT_PACKAGE_NAME
                )
            }
        )

        // Get consumer service nodes
        generatedNodes.addAll(KafkaListeners.getGeneratedNodes(GenletPathSpecifier.CURRENT_MICROSERVICE_JAVA_ROOT_PATH,
            PARENT_PACKAGE_NAME))

        return generatedNodes
    }
}