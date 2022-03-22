package de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.handlers.aspects

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
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
        val currentApplicationPropertiesFile: PropertyFile by State


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
        currentApplicationPropertiesFile["spring.test"] = "huhu"

        currentApplicationPropertiesFile.forEach { key, value -> println("DEFAULT key ${key} value ${value}") }


        return GenletCodeGenerationHandlerResult(node, generatedApplicationPropertiesFile())

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