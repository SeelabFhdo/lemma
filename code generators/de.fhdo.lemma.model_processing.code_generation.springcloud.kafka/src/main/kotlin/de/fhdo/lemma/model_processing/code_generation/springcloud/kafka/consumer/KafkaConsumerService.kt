package de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.consumer

import com.github.javaparser.StaticJavaParser
import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.body.Parameter
import com.github.javaparser.ast.type.ClassOrInterfaceType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.newJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedNode
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletPathSpecifier
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.findMethod
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.methodExists
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.nArgGenericWildcardType
import de.fhdo.lemma.service.intermediate.IntermediateInterface
import de.fhdo.lemma.service.intermediate.IntermediateParameter
import java.io.File

/**
 * Class that represents a Kafka consumer Spring Service.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class KafkaConsumerService(val packageName: String, genletHeap: MutableMap<String, Any?>,
    val classname: String) {
    private var kafkaConsumerService: ClassOrInterfaceDeclaration? = null

    /**
     * Constructor to retrieve the classname of the consumer service from an [IntermediateInterface]
     */
    constructor(packageName: String, genletHeap: MutableMap<String, Any?>, iface: IntermediateInterface)
        : this(packageName, genletHeap, "${iface.name}Service")

    /**
     * Instance initializer
     */
    init {
        val fullyQualifiedName = "$packageName.${classname}"
        if (fullyQualifiedName in genletHeap)
            kafkaConsumerService = genletHeap[fullyQualifiedName] as ClassOrInterfaceDeclaration
        else {
            // Create new Kafka consumer service and store it in the Genlet heap to later reload it from there, after
            // other Genlet's were executed and the Java Base Generator delegates back to the Kafka Genlet
            kafkaConsumerService = newJavaClassOrInterface(packageName, classname)
            kafkaConsumerService!!.addAnnotation("Service", SerializationCharacteristic.DONT_RELOCATE)
            kafkaConsumerService!!.addImport(
                "org.springframework.stereotype.Service",
                ImportTargetElementType.ANNOTATION,
                SerializationCharacteristic.DONT_RELOCATE
            )
            genletHeap[fullyQualifiedName] = kafkaConsumerService
        }
    }

    /**
     * Add or get method to the consumer service for handling incoming messages
     */
    fun addOrGetHandlerMethod(intermediateParameter: IntermediateParameter, handlerType: ClassOrInterfaceType,
        typeImports: Set<String>, prefix: String) : MethodDeclaration {
        val methodName = buildConsumerServiceHandlerName(intermediateParameter, prefix)
        var method = kafkaConsumerService!!.findMethod(methodName, listOf(handlerType))
        if (method != null)
            return method

        // Create method
        method = kafkaConsumerService!!.addMethod(methodName, Modifier.Keyword.PUBLIC)
        method.setType("void")
        method.addSerializationCharacteristic(SerializationCharacteristic.DONT_RELOCATE)

        // Create parameter
        val parameter = Parameter(handlerType, handlerType.asString().decapitalize())
        typeImports.forEach {
            method.addImport(it, ImportTargetElementType.METHOD, SerializationCharacteristic.DONT_RELOCATE)
        }
        method.addParameter(parameter)

        // Create body
        method.setBody("""throw new UnsupportedOperationException("Not implemented yet")""", "TODO: Implement handler")

        return method
    }

    /**
     * Add method to the consumer service for handling occurred errors
     */
    fun addErrorHandlerMethod(intermediateParameter: IntermediateParameter) {
        /* Create method, if it does not exist already */
        // The parameter types of the method are Message<?>, ListenerExecutionFailedException, and Consumer<?, ?>.
        val methodName = buildConsumerServiceErrorHandlerName(intermediateParameter)
        val types = mapOf<ClassOrInterfaceType, String>(
            "Message".nArgGenericWildcardType() to "org.springframework.messaging.Message",
            StaticJavaParser.parseClassOrInterfaceType("ListenerExecutionFailedException")
                    to "org.springframework.kafka.listener.ListenerExecutionFailedException",
            "Consumer".nArgGenericWildcardType(2) to "org.apache.kafka.clients.consumer.Consumer"
        )

        if (kafkaConsumerService!!.methodExists(methodName, types.keys.toList()))
            return

        val method = kafkaConsumerService!!.addMethod(methodName, Modifier.Keyword.PUBLIC)
        method.setType("Object")
        method.addSerializationCharacteristic(SerializationCharacteristic.DONT_RELOCATE)

        types.forEach { (type, import) ->
            method.addParameter(Parameter(type, type.nameAsString.decapitalize()))
            method.addImport(import, ImportTargetElementType.METHOD, SerializationCharacteristic.DONT_RELOCATE)
        }

        /* Create method body */
        method.setBody("""throw new UnsupportedOperationException("Not implemented yet")""",
            "TODO: Implement error handler")
    }

    /**
     * Get [GenletGeneratedNode] for consumer service
     */
    fun getGeneratedNode(pathSpecifier: GenletPathSpecifier) : GenletGeneratedNode? {
        if (kafkaConsumerService == null || kafkaConsumerService!!.members.isEmpty())
            return null

        val nodeFilePath = packageName.substringAfterLast(".") + File.separator + "$classname.java"
        return GenletGeneratedNode(pathSpecifier, nodeFilePath, kafkaConsumerService!!)
    }
}

/**
 * Build name of consumer service method for handling incoming messages from the given [IntermediateParameter] and with
 * the given [prefix].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun buildConsumerServiceHandlerName(parameter: IntermediateParameter, prefix: String)
    = if (prefix.isNotEmpty())
            prefix.decapitalize() + parameter.operation.name.capitalize()
        else
            parameter.operation.name

/**
 * Build name of consumer service method for handling occurred errors from the given [IntermediateParameter].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun buildConsumerServiceErrorHandlerName(parameter: IntermediateParameter)
    = "${parameter.operation.name}ErrorHandler"