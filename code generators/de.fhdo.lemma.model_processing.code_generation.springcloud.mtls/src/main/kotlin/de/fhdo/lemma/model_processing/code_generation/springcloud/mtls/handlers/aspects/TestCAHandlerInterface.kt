package de.fhdo.lemma.model_processing.code_generation.springcloud.mtls.handlers.aspects

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.getAllAspects
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.hasApiComments
import de.fhdo.lemma.model_processing.code_generation.java_base.qualifiedName
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import org.eclipse.emf.ecore.EObject

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
//        if (eObject.aspects.any { it.qualifiedName !in setOf("mTLS.keystore", "mTLS.testKeystore")})
//            return GenletCodeGenerationHandlerResult(node)

        println(eObject.qualifiedName)
        eObject.aspects.filter { it.qualifiedName in setOf("mTLS.keystore", "mTLS.testKeystore") }.forEach {
            println("aspect name ${it.name}")
            it.properties.forEach {
                println("name ${it.name} defaultValue ${it.defaultValue}")
            }
        }
        return GenletCodeGenerationHandlerResult(node)
    }
}