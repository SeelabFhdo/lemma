package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.FieldDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAndGetAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependency
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addPrivateAttribute
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addStatements
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.newJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.classname
import de.fhdo.lemma.model_processing.code_generation.java_base.forEachAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedFileContent
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedNode
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletPathSpecifier
import de.fhdo.lemma.model_processing.code_generation.java_base.getAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.getPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.hasApiComments
import de.fhdo.lemma.model_processing.code_generation.java_base.hasInputParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.PropertyFile
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.openPropertyFile
import de.fhdo.lemma.model_processing.code_generation.java_base.usesProtocol
import de.fhdo.lemma.model_processing.code_generation.springcloud.AsynchronousOperationInfo
import de.fhdo.lemma.model_processing.code_generation.springcloud.Context.State as State
import de.fhdo.lemma.model_processing.utils.trimToSingleLine
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.technology.CommunicationType

@CodeGenerationHandler
internal class MicroserviceHandler
    : GenletCodeGenerationHandlerI<IntermediateMicroservice, ClassOrInterfaceDeclaration, Nothing> {
    companion object {
        fun handleMicroserviceGenerationFinished(microserviceClass: ClassOrInterfaceDeclaration)
            : Pair<Set<GenletGeneratedNode>, Set<GenletGeneratedFileContent>>? {
            val currentIntermediateMicroservice: IntermediateMicroservice by State
            if (!currentIntermediateMicroservice.usesProtocol("amqp"))
                return null

            val asynchronousCompositeClasses = State.getAsynchronousCompositeClasses("amqp")
            val classMappingStatements = mutableListOf<String>()
            asynchronousCompositeClasses.forEach {
                val classname = it.substringAfterLast(".").decapitalize()
                classMappingStatements.add("""classMapping.put("$classname", $it.class);""")
            }

            microserviceClass.addProtectedBeanMethod(
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
            val generatedFileContents = mutableSetOf(GenletGeneratedFileContent(
                    GenletPathSpecifier.CURRENT_MICROSERVICE_GENERATION_TARGET_PATH,
                    "${microserviceClass.nameAsString}.java",
                    microserviceClass
                ))

            val generatedNodes = mutableSetOf<GenletGeneratedNode>()
            val asynchronousOperationInputInfo = State.getAsynchronousOperationInputInfo("amqp")
            if (asynchronousOperationInputInfo.isNotEmpty()) {
                val messageDistributorClass = generateMessageDistributor(microserviceClass,
                    asynchronousOperationInputInfo)

                generatedNodes.add(
                    GenletGeneratedNode(
                        GenletPathSpecifier.CURRENT_MICROSERVICE_GENERATION_TARGET_PATH,
                        "${messageDistributorClass.nameAsString}.java",
                        messageDistributorClass
                    )
                )
            }

            return generatedNodes to generatedFileContents
        }

        private fun ClassOrInterfaceDeclaration.addProtectedBeanMethod(name: String, returnType: String,
            parameters: Map<String, String> = emptyMap(), methodImports: Set<String> = emptySet(), body: String,
            bodyImports: Set<String> = emptySet()) : MethodDeclaration {
            val beanMethod = addMethod(name, Modifier.Keyword.PROTECTED)
            beanMethod.addImport("org.springframework.context.annotation.Bean", ImportTargetElementType.ANNOTATION,
                SerializationCharacteristic.DONT_RELOCATE)
            beanMethod.addAnnotation("Bean", SerializationCharacteristic.DONT_RELOCATE)
            beanMethod.addSerializationCharacteristic(SerializationCharacteristic.DONT_RELOCATE)

            beanMethod.setType(returnType)
            parameters.forEach { (name, type) -> beanMethod.addParameter(type, name) }
            methodImports.forEach {
                beanMethod.addImport(it, ImportTargetElementType.METHOD, SerializationCharacteristic.DONT_RELOCATE)
            }

            beanMethod.addStatements(body)
            bodyImports.forEach {
                beanMethod.addImport(it, ImportTargetElementType.METHOD_BODY, SerializationCharacteristic.DONT_RELOCATE)
            }

            return beanMethod
        }

        private fun generateMessageDistributor(microserviceClass: ClassOrInterfaceDeclaration,
            asynchronousOperationInputInfo: Set<AsynchronousOperationInfo>) : ClassOrInterfaceDeclaration {
            val clazz = newJavaClassOrInterface(microserviceClass.getPackageName(), "RabbitMqMessageDistributor")
            clazz.addSerializationCharacteristic(SerializationCharacteristic.NO_CONSTRUCTORS)
            clazz.addImport(
                "org.springframework.stereotype.Component",
                ImportTargetElementType.ANNOTATION,
                SerializationCharacteristic.DONT_RELOCATE
            )
            clazz.addAnnotation("Component", SerializationCharacteristic.DONT_RELOCATE)

            clazz.addImport(
                "org.springframework.amqp.rabbit.annotation.RabbitListener",
                ImportTargetElementType.ANNOTATION,
                SerializationCharacteristic.DONT_RELOCATE
            )
            val rabbitListenerAnnotation = clazz.addAndGetAnnotation("RabbitListener",
                SerializationCharacteristic.DONT_RELOCATE)
            rabbitListenerAnnotation.addPair("queues", "${microserviceClass.nameAsString}.QUEUE_NAME")

            val receiverClasses = State.getAsynchronousReceiverClasses("amqp").toList()
            val receiverClassesToFieldnames = mutableMapOf<String, String>()
            for (i in receiverClasses.indices) {
                val receiverClass = receiverClasses[i]
                val fieldname = receiverClass.substringAfterLast(".").decapitalize()
                receiverClassesToFieldnames[receiverClass] = "$fieldname$i"
            }

            if (receiverClassesToFieldnames.isNotEmpty()) {
                clazz.addImport(
                    "org.springframework.beans.factory.annotation.Autowired",
                    ImportTargetElementType.ATTRIBUTE,
                    SerializationCharacteristic.DONT_RELOCATE
                )

                clazz.addImport(
                    "org.springframework.amqp.rabbit.annotation.RabbitHandler",
                    ImportTargetElementType.METHOD,
                    SerializationCharacteristic.DONT_RELOCATE
                )
            }

            receiverClassesToFieldnames.forEach { (receiverClass, fieldname) ->
                val receiverField = clazz.addField(receiverClass, fieldname)
                receiverField.addSerializationCharacteristic(SerializationCharacteristic.DONT_RELOCATE)
                receiverField.addAnnotation("Autowired", SerializationCharacteristic.DONT_RELOCATE)
            }

            for (inputOperationInfo in asynchronousOperationInputInfo) {
                val compositeInputClassName = inputOperationInfo.compositeInputClass!!.substringAfterLast(".")
                val generatedMethod = inputOperationInfo.generatedMethod
                val hasCompositeInputParameter = generatedMethod!!.parameters
                    .any { it.typeAsString == compositeInputClassName }
                if (!hasCompositeInputParameter)
                    continue

                val receiverClassFieldname = receiverClassesToFieldnames[inputOperationInfo.receiverClassName]
                val receiverMethod = clazz.addMethod("${receiverClassFieldname}MessageHandler")
                receiverMethod.setType("void")
                receiverMethod.addAnnotation("RabbitHandler")
                receiverMethod.addSerializationCharacteristic(SerializationCharacteristic.DONT_RELOCATE)

                val parameterName = compositeInputClassName.decapitalize()
                receiverMethod.addParameter(inputOperationInfo.compositeInputClass, parameterName)

                receiverMethod.setBody("$receiverClassFieldname.${generatedMethod.nameAsString}($parameterName)")
            }

            return clazz
        }
    }

    private lateinit var applicationPropertiesFile: PropertyFile

    override fun handlesEObjectsOfInstance() = IntermediateMicroservice::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java

    override fun execute(intermediateService: IntermediateMicroservice, serviceClass: ClassOrInterfaceDeclaration,
        context: Nothing?) : GenletCodeGenerationHandlerResult<ClassOrInterfaceDeclaration>? {
        serviceClass.addSerializationCharacteristic(SerializationCharacteristic.NO_CONSTRUCTORS)
        serviceClass.addImport("org.springframework.boot.SpringApplication", ImportTargetElementType.METHOD_BODY,
            SerializationCharacteristic.DONT_RELOCATE)
        serviceClass.addImport("org.springframework.boot.autoconfigure.SpringBootApplication",
            ImportTargetElementType.ANNOTATION, SerializationCharacteristic.DONT_RELOCATE)

        if (intermediateService.hasApiComments) {
            serviceClass.addDependency("io.springfox:springfox-swagger2:2.9.2")
            serviceClass.addImport("springfox.documentation.swagger2.annotations.EnableSwagger2",
                ImportTargetElementType.ANNOTATION, SerializationCharacteristic.DONT_RELOCATE)
            serviceClass.addAnnotation("EnableSwagger2", SerializationCharacteristic.DONT_RELOCATE)
        }

        serviceClass.addAnnotation("SpringBootApplication", SerializationCharacteristic.DONT_RELOCATE)
        val mainMethod = serviceClass.addMethod("main", Modifier.Keyword.PUBLIC, Modifier.Keyword.STATIC)
        mainMethod.addParameter("String[]", "args")
        mainMethod.setBody(
            """
                SpringApplication.run(${serviceClass.nameAsString}.class, args)
            """.trimToSingleLine()
        )
        mainMethod.addSerializationCharacteristic(SerializationCharacteristic.DONT_RELOCATE)

        // Do this here to prevent custom properties overriding built-in ones (see below)
        handleCustomPropertyAspect(intermediateService)

        handleApplicationNameAspect(intermediateService)
        handleJacksonConfigurationAspect(intermediateService)
        handleDatasourceConfigurationAspect(intermediateService, serviceClass)
        handleHibernateConfigurationAspect(intermediateService)
        handleJpaShowSqlAspect(intermediateService)

        configureForAsynchronousInteractionIfNecessary(intermediateService, serviceClass)

        State.setCurrentIntermediateMicroservice(intermediateService)
        return GenletCodeGenerationHandlerResult(serviceClass, generateApplicationPropertiesFileIfNecessary())
    }

    private fun handleCustomPropertyAspect(intermediateService: IntermediateMicroservice)
        = intermediateService.forEachAspect("java.CustomProperty") {
            val customPropertyName = it.getPropertyValue("name")!!
            it.valueToProperty(customPropertyName, customPropertyName)
        }

    private fun IntermediateImportedAspect.valueToProperty(aspectPropertyName: String, targetPropertyName: String)
        : String? {
        val propertyValue = getPropertyValue(aspectPropertyName) ?: return null
        getApplicationProperties()[targetPropertyName] = propertyValue
        return propertyValue
    }

    private fun getApplicationProperties() : PropertyFile {
        if (!::applicationPropertiesFile.isInitialized)
            applicationPropertiesFile = openPropertyFile(GenletPathSpecifier.CURRENT_MICROSERVICE_RESOURCES_PATH,
                "application.properties")

        return applicationPropertiesFile
    }

    private fun handleApplicationNameAspect(intermediateService: IntermediateMicroservice)
        = intermediateService.getAspect("java.ApplicationName")?.valueToProperty("value", "spring.application.name")

    private fun handleJacksonConfigurationAspect(intermediateService: IntermediateMicroservice) {
        val aspect = intermediateService.getAspect("java.JacksonConfiguration") ?: return
        aspect.valueToProperty("INDENT_OUTPUT", "spring.jackson.serialization.INDENT_OUTPUT")
        aspect.valueToProperty("defaultPropertyInclusion", "spring.jackson.default-property-inclusion")
    }

    private fun handleDatasourceConfigurationAspect(intermediateService: IntermediateMicroservice,
        serviceClass: ClassOrInterfaceDeclaration) {
        val aspect = intermediateService.getAspect("java.DatasourceConfiguration") ?: return
        aspect.valueToProperty("url", "spring.datasource.url")
        aspect.valueToProperty("username", "spring.datasource.username")
        aspect.valueToProperty("password", "spring.datasource.password")

        val driverClassName = aspect.valueToProperty("driverClassName", "spring.datasource.driverClassName") ?: return
        if (driverClassName == "org.h2.Driver")
            serviceClass.addDependency("com.h2database:h2")
    }

    private fun handleHibernateConfigurationAspect(intermediateService: IntermediateMicroservice) {
        val aspect = intermediateService.getAspect("java.HibernateConfiguration") ?: return
        aspect.valueToProperty("ddlAuto", "spring.jpa.hibernate.ddl-auto")
    }

    private fun handleJpaShowSqlAspect(intermediateService: IntermediateMicroservice) {
        val aspect = intermediateService.getAspect("java.JpaShowSql") ?: return
        aspect.valueToProperty("showSql", "spring.jpa.show-sql")
    }

    private fun generateApplicationPropertiesFileIfNecessary() : MutableSet<GenletGeneratedFileContent> {
        return if (applicationPropertiesFile != null)
            mutableSetOf(GenletGeneratedFileContent(applicationPropertiesFile))
        else
            mutableSetOf()
    }

    private fun configureForAsynchronousInteractionIfNecessary(intermediateService: IntermediateMicroservice,
        serviceClass: ClassOrInterfaceDeclaration) {
        if (!intermediateService.usesProtocol("amqp"))
            return

        serviceClass.addDependency("org.springframework.boot:spring-boot-starter-amqp")
        serviceClass.addDependency("com.fasterxml.jackson.core:jackson-databind")
        val hasAsynchronousReceivers = intermediateService.interfaces
            .map { it.operations }.flatten()
            .any { it.hasInputParameters(CommunicationType.ASYNCHRONOUS) }
        if (hasAsynchronousReceivers)
            configureForAsynchronousReceiving(intermediateService, serviceClass)
    }

    private fun configureForAsynchronousReceiving(intermediateService: IntermediateMicroservice,
        serviceClass: ClassOrInterfaceDeclaration) {
        serviceClass.addPrivateConstant("QUEUE_NAME", "String", """"${intermediateService.classname}-queue"""")
        serviceClass.addPrivateConstant("TOPIC_NAME", "String", """"${intermediateService.classname}-topic"""")

        serviceClass.addProtectedBeanMethod(
            "queue",
            "Queue",
            methodImports = setOf("org.springframework.amqp.core.Queue"),
            body = "return new Queue(QUEUE_NAME, false)"
        )

        serviceClass.addProtectedBeanMethod(
            "topicExchange",
            "TopicExchange",
            methodImports = setOf("org.springframework.amqp.core.TopicExchange"),
            body = "return new TopicExchange(TOPIC_NAME)"
        )

        serviceClass.addProtectedBeanMethod(
            "bindQueueToTopic",
            "Binding",
            mapOf("queue" to "Queue", "topic" to "TopicExchange"),
            setOf("org.springframework.amqp.core.Binding"),
            """
                return BindingBuilder.bind(queue).to(topic).with("${intermediateService.classname}-route.#")
            """.trimToSingleLine(),
            setOf("org.springframework.amqp.core.BindingBuilder")
        )

        serviceClass.addProtectedBeanMethod(
            "connectionFactory",
            "ConnectionFactory",
            methodImports = setOf("org.springframework.amqp.rabbit.connection.ConnectionFactory"),
            body = "return new CachingConnectionFactory()",
            bodyImports = setOf("org.springframework.amqp.rabbit.connection.CachingConnectionFactory")
        )

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

    private fun ClassOrInterfaceDeclaration.addPrivateConstant(name: String, type: String, initializer: String ? = null)
        : FieldDeclaration {
        val newConstant = addPrivateAttribute(name, type, Modifier.Keyword.STATIC, Modifier.Keyword.FINAL,
            initializer = initializer)
        newConstant.addSerializationCharacteristic(SerializationCharacteristic.DONT_RELOCATE)
        return newConstant
    }
}