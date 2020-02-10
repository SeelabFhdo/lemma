package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependency
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setBody
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
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.PropertyFile
import de.fhdo.lemma.model_processing.code_generation.java_base.usesProtocol
import de.fhdo.lemma.model_processing.code_generation.springcloud.spring.amqp.addClassMappingBeanMethod
import de.fhdo.lemma.model_processing.code_generation.springcloud.spring.amqp.configureForAsynchronousInteraction
import de.fhdo.lemma.model_processing.code_generation.springcloud.spring.amqp.generateMessageDistributor
import de.fhdo.lemma.model_processing.code_generation.springcloud.toApplicationProperty
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
    override fun execute(intermediateService: IntermediateMicroservice, serviceClass: ClassOrInterfaceDeclaration,
        context: Nothing?) : GenletCodeGenerationHandlerResult<ClassOrInterfaceDeclaration>? {
        State.initialize(intermediateService)

        /* Each modeled microservice becomes a SpringBoot application */
        serviceClass.addSerializationCharacteristic(SerializationCharacteristic.NO_CONSTRUCTORS)
        serviceClass.addImport("org.springframework.boot.SpringApplication", ImportTargetElementType.METHOD_BODY,
            SerializationCharacteristic.DONT_RELOCATE)
        serviceClass.addImport("org.springframework.boot.autoconfigure.SpringBootApplication",
            ImportTargetElementType.ANNOTATION, SerializationCharacteristic.DONT_RELOCATE)

        // Add main method to invoke the SpringBoot application
        serviceClass.addAnnotation("SpringBootApplication", SerializationCharacteristic.DONT_RELOCATE)
        val mainMethod = serviceClass.addMethod("main", Modifier.Keyword.PUBLIC, Modifier.Keyword.STATIC)
        mainMethod.addParameter("String[]", "args")
        mainMethod.setBody("SpringApplication.run(${serviceClass.nameAsString}.class, args)")
        mainMethod.addSerializationCharacteristic(SerializationCharacteristic.DONT_RELOCATE)

        /* Add dependencies and annotations for API comments if necessary */
        if (intermediateService.hasApiComments) {
            serviceClass.addDependency("io.springfox:springfox-swagger2:2.9.2")
            serviceClass.addImport("springfox.documentation.swagger2.annotations.EnableSwagger2",
                ImportTargetElementType.ANNOTATION, SerializationCharacteristic.DONT_RELOCATE)
            serviceClass.addAnnotation("EnableSwagger2", SerializationCharacteristic.DONT_RELOCATE)
        }

        /* Handle aspects */
        // Do this here to prevent custom properties overriding built-in ones (see below)
        handleCustomPropertyAspect(intermediateService)

        handleApplicationNameAspect(intermediateService)
        handleJacksonConfigurationAspect(intermediateService)
        handleDatasourceConfigurationAspect(intermediateService, serviceClass)
        handleHibernateConfigurationAspect(intermediateService)
        handleJpaShowSqlAspect(intermediateService)

        /* Configure service for asynchronous interaction */
        intermediateService.configureForAsynchronousInteraction(serviceClass)

        return GenletCodeGenerationHandlerResult(serviceClass, generatedApplicationPropertiesFile())
    }

    /**
     * Handle java.CustomProperty aspect
     */
    private fun handleCustomPropertyAspect(intermediateService: IntermediateMicroservice)
        = intermediateService.forEachAspect("java.CustomProperty") {
            val customPropertyName = it.getPropertyValue("name")!!
            it.newApplicationProperty(customPropertyName, customPropertyName)
        }

    /**
     * Convenience function that calls [toApplicationProperty] and sets [addedNewProperties] to true, if the new
     * property could be added
     */
    private fun IntermediateImportedAspect.newApplicationProperty(aspectPropertyName: String,
        targetPropertyName: String) : String? {
        val newPropertyValue = toApplicationProperty(aspectPropertyName, targetPropertyName)
        if (newPropertyValue != null)
            addedNewProperties = true
        return newPropertyValue
    }

    /**
     * Handle java.ApplicationName aspect
     */
    private fun handleApplicationNameAspect(intermediateService: IntermediateMicroservice)
        = intermediateService.getAspect("java.ApplicationName")
            ?.newApplicationProperty("value", "spring.application.name")

    /**
     * Handle java.JacksonConfiguration aspect
     */
    private fun handleJacksonConfigurationAspect(intermediateService: IntermediateMicroservice) {
        val aspect = intermediateService.getAspect("java.JacksonConfiguration") ?: return
        aspect.newApplicationProperty("INDENT_OUTPUT", "spring.jackson.serialization.INDENT_OUTPUT")
        aspect.newApplicationProperty("defaultPropertyInclusion", "spring.jackson.default-property-inclusion")
    }

    /**
     * Handle java.DatasourceConfiguration aspect
     */
    private fun handleDatasourceConfigurationAspect(intermediateService: IntermediateMicroservice,
        serviceClass: ClassOrInterfaceDeclaration) {
        val aspect = intermediateService.getAspect("java.DatasourceConfiguration") ?: return
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
        val aspect = intermediateService.getAspect("java.HibernateConfiguration") ?: return
        aspect.newApplicationProperty("ddlAuto", "spring.jpa.hibernate.ddl-auto")
    }

    /**
     * Handle java.JpaShowSql aspect
     */
    private fun handleJpaShowSqlAspect(intermediateService: IntermediateMicroservice) {
        val aspect = intermediateService.getAspect("java.JpaShowSql") ?: return
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