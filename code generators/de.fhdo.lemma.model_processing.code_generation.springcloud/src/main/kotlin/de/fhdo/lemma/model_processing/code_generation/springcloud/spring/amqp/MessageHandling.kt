package de.fhdo.lemma.model_processing.code_generation.springcloud.spring.amqp

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAndGetAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.newJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setBody
import de.fhdo.lemma.model_processing.code_generation.springcloud.Context.State as State
import de.fhdo.lemma.model_processing.code_generation.springcloud.addProtectedBeanMethod

/**
 * Helper to add a bean method to this [ClassOrInterfaceDeclaration] for mapping classnames to Class types as expected
 * by RabbitMQ.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ClassOrInterfaceDeclaration.addClassMappingBeanMethod() {
    val asynchronousCompositeClasses = State.getAsynchronousCompositeClasses("amqp")
    if (asynchronousCompositeClasses.isEmpty())
        return

    val classMappingStatements = asynchronousCompositeClasses.map {
        val classname = it.substringAfterLast(".").decapitalize()
        """classMapping.put("$classname", $it.class);"""
    }

    addProtectedBeanMethod(
        "defaultClassMapper",
        "DefaultClassMapper",
        methodImports = setOf("org.springframework.amqp.support.converter.DefaultClassMapper"),
        body =
        """
            DefaultClassMapper classMapper = new DefaultClassMapper()
            Map<String , Class<?>> classMapping = new HashMap<String , Class<?>>();
            ${classMappingStatements.joinToString("\n")}
            classMapper.setIdClassMapping(classMapping);
            return classMapper;
        """.trimIndent(),
        bodyImports = setOf(
            "org.springframework.amqp.support.converter.DefaultClassMapper",
            "java.util.Map",
            "java.util.HashMap"
        )
    )
}

/**
 * Helper to generate a message distributor Component that receives asynchronous RabbitMQ messages and forwards them to
 * other Components in order to handle the messages.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun generateMessageDistributor(microserviceClass: ClassOrInterfaceDeclaration) : ClassOrInterfaceDeclaration? {
    val asynchronousOperationInputInfo = State.getAsynchronousOperationInputInfoSet("amqp")
    if (asynchronousOperationInputInfo.isEmpty())
        return null

    /* Generate class and add Component annotation */
    val messageDistributor = newJavaClassOrInterface(microserviceClass.getPackageName(), "RabbitMqMessageDistributor")
    messageDistributor.addSerializationCharacteristic(SerializationCharacteristic.NO_CONSTRUCTORS)
    messageDistributor.addImport("org.springframework.stereotype.Component", ImportTargetElementType.ANNOTATION,
        SerializationCharacteristic.DONT_RELOCATE)
    messageDistributor.addAnnotation("Component", SerializationCharacteristic.DONT_RELOCATE)

    /* Turn the class into a RabbitMQ listener */
    messageDistributor.addImport(
        "org.springframework.amqp.rabbit.annotation.RabbitListener",
        ImportTargetElementType.ANNOTATION,
        SerializationCharacteristic.DONT_RELOCATE
    )
    val rabbitListenerAnnotation = messageDistributor.addAndGetAnnotation("RabbitListener",
        SerializationCharacteristic.DONT_RELOCATE)
    rabbitListenerAnnotation.addPair("queues", "${microserviceClass.nameAsString}.$QUEUE_CONSTANT_NAME")

    /* Inject receiver classes to which incoming messages shall be distributed */
    val receiverClasses = State.getAsynchronousReceiverClasses("amqp").toList()
    val receiverClassesToFieldnames = mutableMapOf<String, String>()
    for (i in receiverClasses.indices) {
        val receiverClass = receiverClasses[i]
        val fieldname = receiverClass.substringAfterLast(".").decapitalize()
        receiverClassesToFieldnames[receiverClass] = "$fieldname$i"
    }

    if (receiverClassesToFieldnames.isNotEmpty()) {
        messageDistributor.addImport(
            "org.springframework.beans.factory.annotation.Autowired",
            ImportTargetElementType.ATTRIBUTE,
            SerializationCharacteristic.DONT_RELOCATE
        )

        messageDistributor.addImport(
            "org.springframework.amqp.rabbit.annotation.RabbitHandler",
            ImportTargetElementType.METHOD,
            SerializationCharacteristic.DONT_RELOCATE
        )
    }

    receiverClassesToFieldnames.forEach { (receiverClass, fieldname) ->
        val receiverField = messageDistributor.addField(receiverClass, fieldname)
        receiverField.addSerializationCharacteristic(SerializationCharacteristic.DONT_RELOCATE)
        receiverField.addAnnotation("Autowired", SerializationCharacteristic.DONT_RELOCATE)
    }

    /* Add listener methods to message distributor that effectively distribute incoming messages to receiver classes */
    for (inputOperationInfo in asynchronousOperationInputInfo) {
        val compositeInputClassName = inputOperationInfo.compositeInputClass!!.substringAfterLast(".")
        val generatedMethod = inputOperationInfo.generatedMethod
        val hasCompositeInputParameter = generatedMethod!!.parameters.any { it.typeAsString == compositeInputClassName }
        if (!hasCompositeInputParameter)
            continue

        val receiverClassFieldname = receiverClassesToFieldnames[inputOperationInfo.receiverClassName]
        val receiverMethod = messageDistributor.addMethod("${receiverClassFieldname}MessageHandler")
        receiverMethod.setType("void")
        receiverMethod.addAnnotation("RabbitHandler")
        receiverMethod.addSerializationCharacteristic(SerializationCharacteristic.DONT_RELOCATE)

        val parameterName = compositeInputClassName.decapitalize()
        receiverMethod.addParameter(inputOperationInfo.compositeInputClass, parameterName)
        receiverMethod.setBody("$receiverClassFieldname.${generatedMethod.nameAsString}($parameterName)")
    }

    return messageDistributor
}