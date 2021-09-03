package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.java.ast.utils.ImportTargetElementType
import de.fhdo.lemma.java.ast.utils.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAndGetAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.addDependency
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
import de.fhdo.lemma.model_processing.code_generation.java_base.hasAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.PropertyFile
import de.fhdo.lemma.model_processing.code_generation.java_base.toProperty
import de.fhdo.lemma.model_processing.code_generation.java_base.usesProtocol
import de.fhdo.lemma.model_processing.code_generation.springcloud.spring.amqp.addClassMappingBeanMethod
import de.fhdo.lemma.model_processing.code_generation.springcloud.spring.amqp.configureForAsynchronousInteraction
import de.fhdo.lemma.model_processing.code_generation.springcloud.spring.amqp.generateMessageDistributor
import de.fhdo.lemma.model_processing.code_generation.springcloud.Context.State as State
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice

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

    companion object {
        /**
         * Callback to react to the finish of the current microservice's Java generation
         */
        fun handleMicroserviceGenerationFinished(microserviceClass: ClassOrInterfaceDeclaration)
            : Pair<Set<GenletGeneratedNode>, Set<GenletGeneratedFileContent>>? {
            val currentIntermediateMicroservice: IntermediateMicroservice by State
            if (!currentIntermediateMicroservice.usesProtocol("amqp"))
                return null

            /* Add AMQP-related class mappings for serialization purposes */
            microserviceClass.addClassMappingBeanMethod()

            val adaptedMicroserviceClass = GenletGeneratedFileContent(
                GenletPathSpecifier.CURRENT_MICROSERVICE_GENERATION_TARGET_PATH,
                "${microserviceClass.nameAsString}.java",
                microserviceClass
            )

            /* Generate AMQP-related message distributor class */
            val generatedMessageDistributor = mutableSetOf<GenletGeneratedNode>()
            val messageDistributor = generateMessageDistributor(microserviceClass)

            if (messageDistributor != null)
                generatedMessageDistributor.add(
                    GenletGeneratedNode(
                        GenletPathSpecifier.CURRENT_MICROSERVICE_GENERATION_TARGET_PATH,
                        "${messageDistributor.nameAsString}.java",
                        messageDistributor
                    )
                )

            return generatedMessageDistributor to setOf(adaptedMicroserviceClass)
        }
    }

    private var addedNewProperties = false

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: IntermediateMicroservice, node: ClassOrInterfaceDeclaration, context: Nothing?)
        : GenletCodeGenerationHandlerResult<ClassOrInterfaceDeclaration>? {
        State.initialize(eObject)

        /* Each modeled microservice becomes a SpringBoot application */
        node.addSerializationCharacteristic(SerializationCharacteristic.NO_CONSTRUCTORS)
        node.addImport("org.springframework.boot.SpringApplication", ImportTargetElementType.METHOD_BODY,
            SerializationCharacteristic.DONT_RELOCATE)
        node.addImport("org.springframework.boot.autoconfigure.SpringBootApplication",
            ImportTargetElementType.ANNOTATION, SerializationCharacteristic.DONT_RELOCATE)
        node.addDependency("org.springframework.boot:spring-boot-starter-web")

        // Add main method to invoke the SpringBoot application
        val currentMicroservicePackage: String by state()
        node.addAndGetAnnotation("SpringBootApplication", SerializationCharacteristic.DONT_RELOCATE)
            .addPair("scanBasePackages", "\"$currentMicroservicePackage\"")

        val mainMethod = node.addMethod("main", Modifier.Keyword.PUBLIC, Modifier.Keyword.STATIC)
        mainMethod.addParameter("String[]", "args")
        mainMethod.setBody("SpringApplication.run(${node.nameAsString}.class, args)")
        mainMethod.addSerializationCharacteristic(SerializationCharacteristic.DONT_RELOCATE)

        /* Add dependencies and annotations for API comments if necessary */
        if (eObject.hasApiComments) {
            node.addDependency("io.springfox:springfox-swagger2:2.9.2")
            node.addDependency("io.springfox:springfox-swagger-ui:2.9.2")
            node.addImport("springfox.documentation.swagger2.annotations.EnableSwagger2",
                ImportTargetElementType.ANNOTATION, SerializationCharacteristic.DONT_RELOCATE)
            node.addAnnotation("EnableSwagger2", SerializationCharacteristic.DONT_RELOCATE)
        }

        /* Handle aspects */
        // Do this here to prevent custom properties overriding built-in ones (see below)
        handleCustomPropertyAspect(eObject)

        handleSpringApplicationAspect(eObject)
        handleApplicationNameAspect(eObject)
        handleJacksonConfigurationAspect(eObject)
        handleDatasourceConfigurationAspect(eObject, node)
        handleHibernateConfigurationAspect(eObject)
        handleJpaShowSqlAspect(eObject)

        /* Configure service for asynchronous interaction */
        eObject.configureForAsynchronousInteraction(node)

        return GenletCodeGenerationHandlerResult(node, generatedApplicationPropertiesFile())
    }

    /**
     * Handle CustomProperty aspect
     */
    private fun handleCustomPropertyAspect(intermediateService: IntermediateMicroservice)
        = intermediateService.forEachAspect(
            "java.ApplicationProperty",
            "java.CustomProperty",
            "Spring.ApplicationProperty",
            "Spring.CustomProperty"
        ) {
            val customPropertyName = it.getPropertyValue("name")!!
            it.newApplicationProperty("value", customPropertyName)
        }

    /**
     * Convenience function that calls [toProperty] and sets [addedNewProperties] to true, if the new property could be
     * added
     */
    private fun IntermediateImportedAspect.newApplicationProperty(aspectPropertyName: String,
        targetPropertyName: String) : String? {
        val currentApplicationPropertiesFile: PropertyFile by State
        val newPropertyValue = toProperty(aspectPropertyName, currentApplicationPropertiesFile, targetPropertyName)
        if (newPropertyValue != null)
            addedNewProperties = true
        return newPropertyValue
    }

    /**
     * Handle Spring Application aspect
     */
    private fun handleSpringApplicationAspect(intermediateService: IntermediateMicroservice) {
        val aspect = intermediateService.getAspect("Spring.Application") ?: return
        aspect.newApplicationProperty("name", "spring.application.name")
        aspect.newApplicationProperty("port", "server.port")
    }

    /**
     * Handle ApplicationName aspect
     */
    private fun handleApplicationNameAspect(intermediateService: IntermediateMicroservice) {
        if (intermediateService.hasAspect("Spring.Application"))
            return

        intermediateService.getAspect("java.ApplicationName", "Spring.ApplicationName")
            ?.newApplicationProperty("value", "spring.application.name")
    }

    /**
     * Handle JacksonConfiguration aspect
     */
    private fun handleJacksonConfigurationAspect(intermediateService: IntermediateMicroservice) {
        val aspect = intermediateService.getAspect("java.JacksonConfiguration", "Spring.JacksonConfiguration") ?: return
        aspect.newApplicationProperty("INDENT_OUTPUT", "spring.jackson.serialization.INDENT_OUTPUT")
        aspect.newApplicationProperty("defaultPropertyInclusion", "spring.jackson.default-property-inclusion")
    }

    /**
     * Handle java.DatasourceConfiguration aspect
     */
    private fun handleDatasourceConfigurationAspect(intermediateService: IntermediateMicroservice,
        serviceClass: ClassOrInterfaceDeclaration) {
        val aspect = intermediateService.getAspect("java.DatasourceConfiguration", "Spring.DatasourceConfiguration")
            ?: return
        aspect.newApplicationProperty("url", "spring.datasource.url")
        aspect.newApplicationProperty("username", "spring.datasource.username")
        aspect.newApplicationProperty("password", "spring.datasource.password")

        val driver = aspect.newApplicationProperty("driverClassName", "spring.datasource.driverClassName") ?: return
        if (driver == "org.h2.Driver")
            serviceClass.addDependency("com.h2database:h2")
    }

    /**
     * Handle java.HibernateConfiguration aspect
     */
    private fun handleHibernateConfigurationAspect(intermediateService: IntermediateMicroservice) {
        val aspect = intermediateService.getAspect("java.HibernateConfiguration", "Spring.HibernateConfiguration")
            ?: return
        aspect.newApplicationProperty("ddlAuto", "spring.jpa.hibernate.ddl-auto")
    }

    /**
     * Handle java.JpaShowSql aspect
     */
    private fun handleJpaShowSqlAspect(intermediateService: IntermediateMicroservice) {
        val aspect = intermediateService.getAspect("java.JpaShowSql", "Spring.JpaShowSql") ?: return
        aspect.newApplicationProperty("showSql", "spring.jpa.show-sql")
    }

    /**
     * Helper to create a [GenletGeneratedFileContent] instance from the current application properties file, in case
     * new properties were added during the generation of the current microservice
     */
    private fun generatedApplicationPropertiesFile() : MutableSet<GenletGeneratedFileContent> {
        val currentApplicationPropertiesFile: PropertyFile by State
        return if (addedNewProperties)
            mutableSetOf(GenletGeneratedFileContent(currentApplicationPropertiesFile))
        else
            mutableSetOf()
    }
}