package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.handlers.aspects

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.getEndpoint
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.hasAspect
import de.fhdo.lemma.service.intermediate.IntermediateInterface

@CodeGenerationHandler
internal class InterfaceHandler
    : GenletCodeGenerationHandlerI<IntermediateInterface, ClassOrInterfaceDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateInterface::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java

    private fun handlesAspects() = setOf("role")

    override fun execute(
        eObject: IntermediateInterface,
        node: ClassOrInterfaceDeclaration,
        context: Nothing?
    ): GenletCodeGenerationHandlerResult<ClassOrInterfaceDeclaration> {
//        if (!eObject.hasAspect(*handlesAspects().toTypedArray()))
//            return GenletCodeGenerationHandlerResult(node)

        val endpoint = eObject.getEndpoint("rest")

        println("Interface: ${eObject.qualifiedName}")


        return GenletCodeGenerationHandlerResult(node)
    }
}

