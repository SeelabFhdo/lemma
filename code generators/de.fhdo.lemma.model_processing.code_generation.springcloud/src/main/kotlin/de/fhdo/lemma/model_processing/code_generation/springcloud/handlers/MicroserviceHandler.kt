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
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletPathSpecifier
import de.fhdo.lemma.model_processing.code_generation.java_base.getAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.getPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.hasApiComments
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.PropertyFile
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.openPropertyFile
import de.fhdo.lemma.model_processing.utils.trimToSingleLine
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice

@CodeGenerationHandler
internal class MicroserviceHandler
    : GenletCodeGenerationHandlerI<IntermediateMicroservice, ClassOrInterfaceDeclaration, Nothing> {
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
                SpringApplication.run(${serviceClass.nameAsString}.class, args);
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
}