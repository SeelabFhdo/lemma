package de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.handlers.aspects

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAndGetAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependency
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedFileContent
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletPathSpecifier
import de.fhdo.lemma.model_processing.code_generation.java_base.getAllAspects
import de.fhdo.lemma.model_processing.code_generation.java_base.getAspectPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.hasApiComments
import de.fhdo.lemma.model_processing.code_generation.java_base.hasAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.qualifiedName
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.PropertyFile
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.property_files.openPropertyFile
import de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.Context
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.Context.State as State
import org.eclipse.emf.ecore.EObject
import org.eclipse.equinox.internal.app.Messages

@CodeGenerationHandler
internal class TestCAHandlerInterface
    : GenletCodeGenerationHandlerI<IntermediateMicroservice,ClassOrInterfaceDeclaration, Nothing>{
    override fun handlesEObjectsOfInstance() = IntermediateMicroservice::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java

    override fun execute(
        eObject: IntermediateMicroservice,
        node: ClassOrInterfaceDeclaration,
        context: Nothing?
    ): GenletCodeGenerationHandlerResult<ClassOrInterfaceDeclaration>? {
        if (!eObject.hasAspect("mTLS.Keystore", "mTLS.TestKeystore"))
            return GenletCodeGenerationHandlerResult(node)
        var currentApplicationPropertiesFile = openPropertyFile(GenletPathSpecifier.CURRENT_MICROSERVICE_RESOURCES_PATH, "application-dev.properties")
        var currentApplicationPropertiesFile1 = openPropertyFile(GenletPathSpecifier.CURRENT_DOMAIN_GENERATION_TARGET_PATH, "application-dev.properties")
        var currentApplicationPropertiesFile2 = openPropertyFile(GenletPathSpecifier.CURRENT_MICROSERVICE_GENERATION_TARGET_PATH, "application-dev.properties")
        var currentApplicationPropertiesFile3 = openPropertyFile(GenletPathSpecifier.CURRENT_INTERFACE_GENERATION_TARGET_PATH, "application-dev.properties")
        var currentApplicationPropertiesFile4 = openPropertyFile(GenletPathSpecifier.CURRENT_MICROSERVICE_JAVA_ROOT_PATH, "application-dev.properties")


        println("GenletPathSpecifier.CURRENT_MICROSERVICE_RESOURCES_PATH ${currentApplicationPropertiesFile.filePath}" )
        println("GenletPathSpecifier.CURRENT_DOMAIN_GENERATION_TARGET_PATH ${currentApplicationPropertiesFile1.filePath}" )
        println("GenletPathSpecifier.CURRENT_MICROSERVICE_GENERATION_TARGET_PATH ${currentApplicationPropertiesFile2.filePath}" )
        println("GenletPathSpecifier.CURRENT_INTERFACE_GENERATION_TARGET_PATH ${currentApplicationPropertiesFile3.filePath}" )
        println("GenletPathSpecifier.CURRENT_MICROSERVICE_JAVA_ROOT_PATH ${currentApplicationPropertiesFile4.filePath}" )

        GenletPathSpecifier.CURRENT_MICROSERVICE_RESOURCES_PATH
        GenletPathSpecifier.CURRENT_DOMAIN_GENERATION_TARGET_PATH
        GenletPathSpecifier.CURRENT_MICROSERVICE_GENERATION_TARGET_PATH
        GenletPathSpecifier.CURRENT_INTERFACE_GENERATION_TARGET_PATH
        GenletPathSpecifier.CURRENT_MICROSERVICE_JAVA_ROOT_PATH

        /* Each modeled microservice becomes a SpringBoot application */
        node.addSerializationCharacteristic(SerializationCharacteristic.NO_CONSTRUCTORS)
        node.addImport("org.springframework.context.annotation.Configuration", ImportTargetElementType.METHOD_BODY,
            SerializationCharacteristic.DONT_RELOCATE)
        node.addImport("org.springframework.context.annotation.Profile",
            ImportTargetElementType.ANNOTATION, SerializationCharacteristic.DONT_RELOCATE)
        node.addImport("import javax.net.ssl.HttpsURLConnection",
            ImportTargetElementType.ANNOTATION, SerializationCharacteristic.DONT_RELOCATE)
        // Add main method to invoke the SpringBoot application
        val currentMicroservicePackage: String by state()
        node.addAndGetAnnotation("Configuration", SerializationCharacteristic.DONT_RELOCATE)
        node.addAndGetAnnotation("Configuration", SerializationCharacteristic.DONT_RELOCATE)


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


        println(eObject.qualifiedName)
        var aspects = eObject.getAllAspects(
            "mTLS.Keystore", "mTLS.TestKeystore", "mTLS.Truststore", "mTLS.TestTruststore")
        println(eObject.qualifiedName)
        aspects.forEach {
            println("Aspectname: ${it.name} ")
        }
        println("path:${eObject.getAspectPropertyValue("mTLS.Keystore","path")}")
        println("password:${eObject.getAspectPropertyValue("mTLS.Keystore","password")}")
        println("validityInDays:${eObject.getAspectPropertyValue("mTLS.Keystore","validityInDays")}")
        println("hostnameVerifierBypass:${eObject.getAspectPropertyValue("mTLS.Keystore","hostnameVerifierBypass").toBoolean()}")
//        println(propertyFileDev.filePath)
//        propertyFileDev.forEach { key, value -> println(" DEV key ${key} value ${value}") }
        println(currentApplicationPropertiesFile.filePath)
        currentApplicationPropertiesFile["spring.test"] = "huhu1"

        currentApplicationPropertiesFile.forEach { key, value -> println("DEFAULT key ${key} value ${value}") }

        return GenletCodeGenerationHandlerResult(node, generatedApplicationPropertiesFile(currentApplicationPropertiesFile))
    }


    /**
     * Helper to create a [GenletGeneratedFileContent] instance from the current application properties file, in case
     * new properties were added during the generation of the current microservice
     */
    private fun generatedApplicationPropertiesFile(currentApplicationPropertiesFile: PropertyFile) : MutableSet<GenletGeneratedFileContent> {
        return mutableSetOf(GenletGeneratedFileContent(currentApplicationPropertiesFile))
    }
}