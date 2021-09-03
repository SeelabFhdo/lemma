package de.fhdo.lemma.model_processing.code_generation.springcloud.spring.amqp

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.classname
import de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.addDependency
import de.fhdo.lemma.model_processing.code_generation.java_base.hasInputParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.usesProtocol
import de.fhdo.lemma.model_processing.code_generation.springcloud.addPrivateConstant
import de.fhdo.lemma.model_processing.code_generation.springcloud.addProtectedBeanMethod
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.technology.CommunicationType

internal const val QUEUE_CONSTANT_NAME = "QUEUE_NAME"

/**
 * Helper to basically configure the [serviceClass] of this [IntermediateMicroservice] for asynchronous interaction with
 * other services.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateMicroservice.configureForAsynchronousInteraction(serviceClass: ClassOrInterfaceDeclaration) {
    if (!usesProtocol("amqp"))
        return

    /* Add basic dependencies */
    serviceClass.addDependency("org.springframework.boot:spring-boot-starter-amqp")
    serviceClass.addDependency("com.fasterxml.jackson.core:jackson-databind")

    /* Configure also for message receiving if asynchronous input parameters were modeled */
    val hasAsynchronousReceivers = interfaces
        .map { it.operations }.flatten()
        .any { it.hasInputParameters(CommunicationType.ASYNCHRONOUS) }
    if (hasAsynchronousReceivers)
        configureForReceiving(serviceClass)
}

/**
 * Helper to configure the [serviceClass] of this [IntermediateMicroservice] for receiving asynchronous messages from
 * other services.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun IntermediateMicroservice.configureForReceiving(serviceClass: ClassOrInterfaceDeclaration) {
    // Add queue and topic constants
    serviceClass.addPrivateConstant(QUEUE_CONSTANT_NAME, "String", """"$classname-queue"""")
    serviceClass.addPrivateConstant("TOPIC_NAME", "String", """"$classname-topic"""")

    // Add Queue instance creation bean method
    serviceClass.addProtectedBeanMethod(
        "queue",
        "Queue",
        methodImports = setOf("org.springframework.amqp.core.Queue"),
        body = "return new Queue(QUEUE_NAME, false)"
    )

    // Add TopicExchange instance creation bean method
    serviceClass.addProtectedBeanMethod(
        "topicExchange",
        "TopicExchange",
        methodImports = setOf("org.springframework.amqp.core.TopicExchange"),
        body = "return new TopicExchange(TOPIC_NAME)"
    )

    // Add Binding creation bean method
    serviceClass.addProtectedBeanMethod(
        "bindQueueToTopic",
        "Binding",
        mapOf("queue" to "Queue", "topic" to "TopicExchange"),
        setOf("org.springframework.amqp.core.Binding"),
        """return BindingBuilder.bind(queue).to(topic).with("$classname-route.#")""",
        setOf("org.springframework.amqp.core.BindingBuilder")
    )

    // Add ConnectionFactory creation bean method
    serviceClass.addProtectedBeanMethod(
        "connectionFactory",
        "ConnectionFactory",
        methodImports = setOf("org.springframework.amqp.rabbit.connection.ConnectionFactory"),
        body = "return new CachingConnectionFactory()",
        bodyImports = setOf("org.springframework.amqp.rabbit.connection.CachingConnectionFactory")
    )

    // Add ContainerFactory creation bean method
    serviceClass.addProtectedBeanMethod(
        "rabbitListenerContainerFactory",
        "SimpleRabbitListenerContainerFactory",
        methodImports = setOf("org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory"),
        body =
        """
            SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory()
            factory.setConnectionFactory(connectionFactory());
            factory.setConcurrentConsumers(3);
            factory.setMaxConcurrentConsumers(10);
            factory.setMessageConverter(jsonMessageConverter());
            return factory;
        """.trimIndent(),
        bodyImports = setOf("org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory")
    )

    // JSON message converter creation bean method. This is necessary for basic message serialization.
    serviceClass.addProtectedBeanMethod(
        "jsonMessageConverter",
        "Jackson2JsonMessageConverter",
        methodImports = setOf("org.springframework.amqp.support.converter.Jackson2JsonMessageConverter"),
        body =
        """
            Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter()
            converter.setClassMapper(defaultClassMapper());
            converter.setTypePrecedence(Jackson2JavaTypeMapper.TypePrecedence.TYPE_ID);
            return converter;
        """.trimIndent(),
        bodyImports = setOf(
            "org.springframework.amqp.support.converter.Jackson2JsonMessageConverter",
            "org.springframework.amqp.support.converter.Jackson2JavaTypeMapper"
        )
    )
}