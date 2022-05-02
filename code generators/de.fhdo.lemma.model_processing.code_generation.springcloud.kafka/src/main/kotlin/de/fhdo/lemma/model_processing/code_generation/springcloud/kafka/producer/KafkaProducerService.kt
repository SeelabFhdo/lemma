package de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.producer

import com.github.javaparser.StaticJavaParser
import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.FieldDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.type.ClassOrInterfaceType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSetter
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addStatements
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getImports
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.newJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedNode
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletPathSpecifier
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.addPropertyInjectedAttribute
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.addRelocatableImport
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.getTypeArg
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.setterExists
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.shared.buildTopicPropertyName
import de.fhdo.lemma.service.intermediate.IntermediateInterface
import java.io.File

/**
 * Class that represents a Kafka producer Spring Service.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class KafkaProducerService(packageName: String, genletHeap: MutableMap<String, Any?>,
    private val classname: String) {
    private var kafkaProducerService: ClassOrInterfaceDeclaration? = null

    /**
     * Constructor to retrieve the classname of the producer service from an [IntermediateInterface]
     */
    constructor(packageName: String, genletHeap: MutableMap<String, Any?>, iface: IntermediateInterface)
        : this(packageName, genletHeap, "${iface.name}Service")

    /**
     * Instance initializer
     */
    init {
        val fullyQualifiedName = "$packageName.${classname}"
        if (fullyQualifiedName in genletHeap)
            kafkaProducerService = genletHeap[fullyQualifiedName] as ClassOrInterfaceDeclaration
        else {
            // Create new Kafka producer service and store it in the Genlet heap to later reload it from there, after
            // other Genlet's were executed and the Java Base Generator delegates back to the Kafka Genlet
            kafkaProducerService = newJavaClassOrInterface(packageName, classname)
            kafkaProducerService!!.addAnnotation("Service", SerializationCharacteristic.DONT_RELOCATE)
            kafkaProducerService!!.addImport(
                "org.springframework.stereotype.Service",
                ImportTargetElementType.ANNOTATION,
                SerializationCharacteristic.DONT_RELOCATE
            )
            genletHeap[fullyQualifiedName] = kafkaProducerService
        }
    }

    /**
     * Add attribute that holds a producer instance, as well as a setter method that injects this instance
     */
    fun addProducerAttributeAndSetter(producerNamePrefix: String, type: ClassOrInterfaceType, typeImports: Set<String>)
        : FieldDeclaration {
        val producerAttribute = addOrGetProducerAttribute(producerNamePrefix, type, typeImports)
        addProducerAttributeSetter(producerAttribute, typeImports)
        return producerAttribute
    }

    /**
     * Add or get attribute that holds a producer instance
     */
    private fun addOrGetProducerAttribute(namePrefix: String, type: ClassOrInterfaceType, typeImports: Set<String>)
        : FieldDeclaration {
        val attributeName = "${namePrefix.decapitalize()}Producer"
        val existingAttribute = kafkaProducerService!!.fields.find { it.variables[0].nameAsString == attributeName }
        if (existingAttribute != null)
            return existingAttribute

        val attribute = kafkaProducerService!!.addField(type, attributeName, Modifier.Keyword.PRIVATE)
        attribute.addSerializationCharacteristic(SerializationCharacteristic.REMOVE_ON_RELOCATION)
        typeImports.forEach { attribute.addImport(it, ImportTargetElementType.METHOD) }
        return attribute
    }

    /**
     * Add setter method for the injection of a producer instance
     */
    private fun addProducerAttributeSetter(producerAttribute: FieldDeclaration, typeImports: Set<String>) {
        if (kafkaProducerService!!.setterExists(producerAttribute))
            return

        val (_, setter) = kafkaProducerService!!.addSetter(producerAttribute)
        setter.addSerializationCharacteristic(SerializationCharacteristic.REMOVE_ON_RELOCATION)
        typeImports.forEach { setter.addRelocatableImport(it, ImportTargetElementType.METHOD) }
        setter.addAnnotation("Autowired")
        setter.addImport("org.springframework.beans.factory.annotation.Autowired", ImportTargetElementType.ANNOTATION)
    }

    /**
     * Add method to send an event
     */
    fun addSendMethod(name: String, topic: String, producerMethod: MethodDeclaration,
        producerAttribute: FieldDeclaration, sendParameterWrapperType: String = "",
        bodyImports: Set<String> = emptySet()) {
        /* Get topic name and add an attribute for property injection for it */
        val topicAttributeName ="${topic.decapitalize()}Topic"
        kafkaProducerService!!.addPropertyInjectedAttribute(topicAttributeName, buildTopicPropertyName(topic))

        /* Create method */
        val method = kafkaProducerService!!.addMethod(name, Modifier.Keyword.PUBLIC)
        method.addSerializationCharacteristic(SerializationCharacteristic.REMOVE_ON_RELOCATION)
        producerMethod.getImports(setOf(ImportTargetElementType.METHOD))
            .forEach { method.addRelocatableImport(it, ImportTargetElementType.METHOD) }

        /* Set return type (ListenableFuture<SendResult<PRODUCER_KEY_TYPE, PRODUCER_VALUE_TYPE>) */
        val producerAttributeVariable = producerAttribute.variables[0]
        val producerKeyType = producerAttributeVariable.type.getTypeArg(0)!!
        val producerValueType = producerAttributeVariable.type.getTypeArg(1)!!

        val sendResultType = StaticJavaParser.parseClassOrInterfaceType("SendResult")
        sendResultType.setTypeArguments(producerKeyType, producerValueType)
        val returnType = StaticJavaParser.parseClassOrInterfaceType("ListenableFuture")
        returnType.setTypeArguments(sendResultType)
        method.type = returnType
        method.addRelocatableImport("org.springframework.util.concurrent.ListenableFuture",
            ImportTargetElementType.METHOD)
        method.addRelocatableImport("org.springframework.kafka.support.SendResult", ImportTargetElementType.METHOD)

        /* Create parameter for the value to be sent */
        val senderValueParameterName = producerValueType.asString().decapitalize()
        method.addParameter(producerValueType, senderValueParameterName)

        /* Create body */
        bodyImports.forEach { method.addRelocatableImport(it) }
        val senderAttributeName = producerAttributeVariable.nameAsString
        val sendParameter = if (sendParameterWrapperType.isEmpty())
                "$topicAttributeName, $senderValueParameterName"
            else
                // The parameter for the send() method may have an additional wrapper type, e.g., GenericRecord for
                // Avro senders
                "$sendParameterWrapperType($topicAttributeName, $senderValueParameterName)"
        method.addStatements("return $senderAttributeName.send($sendParameter);")
    }

    /**
     * Get [GenletGeneratedNode] for producer service
     */
    fun getGeneratedNode(pathSpecifier: GenletPathSpecifier, parentPackageName: String) : GenletGeneratedNode? {
        if (kafkaProducerService == null)
            return null

        return GenletGeneratedNode(pathSpecifier, "$parentPackageName${File.separator}$classname.java",
            kafkaProducerService!!)
    }
}