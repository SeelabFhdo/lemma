package de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.consumer

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.FieldDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.body.Parameter
import com.github.javaparser.ast.type.ClassOrInterfaceType
import de.fhdo.lemma.java.ast.utils.ImportTargetElementType
import de.fhdo.lemma.java.ast.utils.addPrivateAttribute
import de.fhdo.lemma.java.ast.utils.addSetter
import de.fhdo.lemma.java.ast.utils.addStatements
import de.fhdo.lemma.java.ast.utils.newJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAndGetAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addPrivateAttribute
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getImports
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedNode
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletPathSpecifier
import de.fhdo.lemma.model_processing.code_generation.java_base.getAspectPropertyValue
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.addBeanMethod
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.addRelocatableImport
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.booleanAspectPropertyValueOrFalse
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.findMethod
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.setterExists
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.shared.buildConsumerGroupPropertyName
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.shared.buildTopicPropertyName
import de.fhdo.lemma.service.intermediate.IntermediateParameter
import java.io.File

/**
 * Singleton that represents the Kafka Listeners class (Spring Component class). This is the technical class, which
 * first consumes all incoming Kafka messages and forwards them to domain-specific, customizable handlers. Therefore,
 * the Singleton acts as a facade for [KafkaConsumerService].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object KafkaListeners {
    private const val CLASSNAME = "Listeners"

    private var classPackage: String? = null
    private var domainPackage: String? = null
    private var genletHeap: MutableMap<String, Any?>? = null
    private var kafkaListenersClass: ClassOrInterfaceDeclaration? = null
    private val consumerServices = mutableMapOf<String?, KafkaConsumerService>()

    /**
     * Initialize Singleton
     */
    fun initialize(classPackage: String, domainPackage: String, genletHeap: MutableMap<String, Any?>) {
        KafkaListeners.classPackage = classPackage
        KafkaListeners.domainPackage = domainPackage
        KafkaListeners.genletHeap = genletHeap
        val fullyQualifiedName = "$classPackage.$CLASSNAME"
        if (fullyQualifiedName in genletHeap)
            kafkaListenersClass = genletHeap[fullyQualifiedName] as ClassOrInterfaceDeclaration
        else {
            // Create or get the Listeners class from the Genlet's heap. By means of the heap, the instance can be
            // preserved, even if subsequent Genlets get called for an AST node.
            kafkaListenersClass = newJavaClassOrInterface(classPackage, CLASSNAME)
            kafkaListenersClass!!.addAnnotation("Component", SerializationCharacteristic.DONT_RELOCATE)
            kafkaListenersClass!!.addImport(
                "org.springframework.stereotype.Component",
                ImportTargetElementType.ANNOTATION,
                SerializationCharacteristic.DONT_RELOCATE
            )
            genletHeap[fullyQualifiedName] = kafkaListenersClass
        }
    }

    /**
     * Reset Singleton
     */
    fun reset() {
        classPackage = null
        domainPackage = null
        genletHeap = null
        kafkaListenersClass = null
        consumerServices.clear()
    }

    /**
     * Add elements to [KafkaConsumerService] as required by the Listeners class to consume Kafka messages. Convenience
     * method without prefix parameter.
     */
    fun addConsumerElements(parameter: IntermediateParameter, handlerType: ClassOrInterfaceType,
        handlerTypeImports: Set<String>) = addConsumerElements(parameter, handlerType, handlerTypeImports, "")

    /**
     * Add elements to [KafkaConsumerService] as required by the Listeners class to consume Kafka messages
     */
    private fun addConsumerElements(parameter: IntermediateParameter, handlerType: ClassOrInterfaceType,
        handlerTypeImports: Set<String>, prefix: String) : Pair<MethodDeclaration, FieldDeclaration> {
        // A new KafkaConsumerService is created, if it does not exist, based on the given parameter
        val consumerService = addOrGetConsumerService(parameter)

        // Add new attribute to the Listeners class, which holds an instance to a consumer service at runtime, in case
        // it does not exist already. The consumer service instance is injected by means of a Spring Autowired setter.
        val (consumerAttribute, attributeTypeImport) = addOrGetConsumerServiceAttribute(consumerService)
        addConsumerServiceAttributeSetter(consumerAttribute, attributeTypeImport)

        // Add method for handling incoming messages to the consumer service
        val consumerMethod = consumerService.addHandlerMethod(parameter, handlerType, handlerTypeImports, prefix)

        return consumerMethod to consumerAttribute
    }

    /**
     * Add a new [KafkaConsumerService], if it does not exist. The given [parameter] may alter the name of the consumer
     * service by means of the value of the handlerName property of a potential DomainEvents.Consumer aspect
     * application.
     */
    private fun addOrGetConsumerService(parameter: IntermediateParameter) : KafkaConsumerService {
        val consumerServiceName = parameter.operation.getAspectPropertyValue("DomainEvents.Consumer", "handlerName")
        if (consumerServiceName !in consumerServices)
            consumerServices[consumerServiceName] = if (consumerServiceName != null)
                KafkaConsumerService(domainPackage!!, genletHeap!!, consumerServiceName)
            else
                KafkaConsumerService(domainPackage!!, genletHeap!!, parameter.operation.`interface`)

        return consumerServices[consumerServiceName]!!
    }

    /**
     * Add attribute to the Listeners class, which may hold a consumer service instance at runtime
     */
    private fun addOrGetConsumerServiceAttribute(consumerService: KafkaConsumerService)
        : Pair<FieldDeclaration, String?> {
        /* Determine import for consumer service, which may reside in a different package than the Listeners class */
        val consumerServiceImport = if (classPackage != consumerService.packageName)
            "${consumerService.packageName}.${consumerService.classname}"
        else
            null

        /* Get or create attribute */
        val attributeName = consumerService.classname.decapitalize()
        var attribute = kafkaListenersClass!!.fields.find { it.variables[0].nameAsString == attributeName }
        if (attribute != null)
            return attribute to consumerServiceImport

        attribute = kafkaListenersClass!!.addPrivateAttribute(attributeName, consumerService.classname)
        attribute.addSerializationCharacteristic(SerializationCharacteristic.REMOVE_ON_RELOCATION)

        if (consumerServiceImport != null)
            kafkaListenersClass!!.addImport(consumerServiceImport, ImportTargetElementType.ATTRIBUTE_TYPE,
                SerializationCharacteristic.REMOVE_ON_RELOCATION)

        return attribute to consumerServiceImport
    }

    /**
     * Add a Spring Autowired setter to the Listeners class for the [consumerServiceAttribute], if does not exist
     * already
     */
    private fun addConsumerServiceAttributeSetter(consumerServiceAttribute: FieldDeclaration, typeImport: String?) {
        if (kafkaListenersClass!!.setterExists(consumerServiceAttribute))
            return

        val (_, setter) = kafkaListenersClass!!.addSetter(consumerServiceAttribute)
        setter.addSerializationCharacteristic(SerializationCharacteristic.REMOVE_ON_RELOCATION)
        if (typeImport != null)
            setter.addRelocatableImport(typeImport, ImportTargetElementType.METHOD)
        setter.addAnnotation("Autowired")
        setter.addImport("org.springframework.beans.factory.annotation.Autowired", ImportTargetElementType.ANNOTATION)
    }

    /**
     * Add elements to [KafkaConsumerService] as required by the Listeners class to consume Kafka messages. Convenience
     * method without handlerTypeImports parameter.
     */
    fun addConsumerElements(parameter: IntermediateParameter, handlerType: ClassOrInterfaceType,
        prefix: String) = addConsumerElements(parameter, handlerType, emptySet(), prefix)

    /**
     * Add a new listener method to the Listeners class, if it does not exist already. The method's will name consist
     * of the given [prefix] and the suffix "Listener". Furthermore, it will delegate to the consumer handler method,
     * contained in the [consumerElements] pair, which allows for the implementation of domain-specific Kafka message
     * handling logic. To this end, the attribute in the [consumerElements] pair must point to the injected attribute
     * for the corresponding consumer service.
     *
     * The listener will intercept messages for the given [topic] and consumer [group] by means of the specified
     * [listenerFactoryName]. All three information are used in the KafkaListener annotation that is added to the
     * listener method.
     */
    fun addOrGetListenerMethod(prefix: String, consumerElements: Pair<MethodDeclaration, FieldDeclaration>,
        topic: String, group: String, listenerFactoryName: String) : MethodDeclaration {
        val methodName = "${prefix}Listener"
        val consumerMethod = consumerElements.first
        val handlerType = consumerMethod.parameters[0].type
        var method = kafkaListenersClass!!.findMethod(methodName, listOf(handlerType))
        if (method != null)
            return method

        /* Create method and signature */
        method = kafkaListenersClass!!.addMethod(methodName, Modifier.Keyword.PUBLIC)
        method.setType("void")
        method.addSerializationCharacteristic(SerializationCharacteristic.REMOVE_ON_RELOCATION)

        val parameter = Parameter(handlerType, handlerType.asString().decapitalize())
        method.addParameter(parameter)
        consumerMethod.getImports(setOf(ImportTargetElementType.METHOD)).forEach {
            method.addRelocatableImport(it, ImportTargetElementType.METHOD)
        }

        /* Create KafkaListener annotation */
        val annotation = method.addAndGetAnnotation("KafkaListener", SerializationCharacteristic.REMOVE_ON_RELOCATION)
        method.addImport("org.springframework.kafka.annotation.KafkaListener", ImportTargetElementType.ANNOTATION,
            SerializationCharacteristic.REMOVE_ON_RELOCATION)
        annotation.addPair("topics", "\"\${${buildTopicPropertyName(topic)}}\"")
        annotation.addPair("groupId", "\"\${${buildConsumerGroupPropertyName(group)}}\"")
        annotation.addPair("containerFactory", "\"$listenerFactoryName\"")

        /* Create method body */
        val consumerAttribute = consumerElements.second
        val consumerAttributeName = consumerAttribute.variables[0].nameAsString
        val consumerMethodName = consumerMethod.nameAsString
        val parameterName = parameter.nameAsString
        method.addStatements("$consumerAttributeName.$consumerMethodName($parameterName);")

        return method
    }

    /**
     * Adapt this [MethodDeclaration], which must be a KafkaListener, to a Kafka error handler, if error handling is not
     * disabled on the given [parameter] by means of the DomainEvents.Consumer aspect and its disableErrorHandling
     * property.
     */
    fun MethodDeclaration.adaptToErrorHandlerIfRequired(parameter: IntermediateParameter,
        consumerElements: Pair<MethodDeclaration, FieldDeclaration>) {
        val disableErrorHandling = parameter.operation.booleanAspectPropertyValueOrFalse("DomainEvents.Consumer",
            "disableErrorHandling")
        if (disableErrorHandling)
            return

        // Get KafkaListener annotation. If it is not present return.
        val listenerAnnotation = getAnnotationByName("KafkaListener").orElse(null)?.asNormalAnnotationExpr() ?: return

        // Add error handler method to consumer service
        addOrGetConsumerService(parameter).addErrorHandlerMethod(parameter)

        // Add ConsumerAwareListenerErrorHandler Bean method for parameter
        val consumerAttribute = consumerElements.second
        val errorHandlerMethod = addConsumerAwareListenerErrorHandlerMethod(parameter, consumerAttribute)

        // Add errorHandler element to KafkaListener annotation
        if (!listenerAnnotation.pairs.any { it.nameAsString == "errorHandler" })
            listenerAnnotation.addPair("errorHandler", "\"${errorHandlerMethod.nameAsString}\"")
    }

    /**
     * Add ConsumerAwareListenerErrorHandler method to the Listeners class, if it does not exist already. The method
     * delegates to the domain-specific error handler method in a consumer service.
     */
    private fun addConsumerAwareListenerErrorHandlerMethod(intermediateParameter: IntermediateParameter,
        consumerServiceAttribute: FieldDeclaration) : MethodDeclaration {
        val errorHandlerName = "${intermediateParameter.operation.name}ErrorHandler"
        val existingMethod = kafkaListenersClass!!.findMethod(errorHandlerName)
        if (existingMethod != null)
            return existingMethod

        // Create Bean method for error handler
        val errorHandler = kafkaListenersClass!!.addBeanMethod(errorHandlerName)
        errorHandler.setType("ConsumerAwareListenerErrorHandler")
        errorHandler.addImport("org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler",
            ImportTargetElementType.METHOD, SerializationCharacteristic.REMOVE_ON_RELOCATION)

        // Create method body
        val consumerServiceAttributeName = consumerServiceAttribute.variables[0].nameAsString
        val consumerServiceErrorHandlerName = buildConsumerServiceErrorHandlerName(intermediateParameter)
        errorHandler.addStatements("return (message, exception, consumer) -> " +
            "$consumerServiceAttributeName.$consumerServiceErrorHandlerName(message, exception, consumer);")

        return errorHandler
    }

    /**
     * Get [GenletGeneratedNode] for Listeners class and all associated domain-specific consumer services
     */
    fun getGeneratedNodes(pathSpecifier: GenletPathSpecifier, parentPackageName: String) : Set<GenletGeneratedNode> {
        val generatedNodes = mutableSetOf<GenletGeneratedNode>()
        if (kafkaListenersClass != null && kafkaListenersClass!!.members.isNotEmpty())
            generatedNodes.add(GenletGeneratedNode(pathSpecifier, "$parentPackageName${File.separator}$CLASSNAME.java",
                kafkaListenersClass!!))

        generatedNodes.addAll(consumerServices.values.mapNotNull { it.getGeneratedNode(pathSpecifier) })

        return generatedNodes
    }
}