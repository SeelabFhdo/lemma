package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.handlers.aspects

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.getEndpoint
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.hasAspect
import de.fhdo.lemma.service.intermediate.IntermediateOperation

@CodeGenerationHandler
internal class OperationHandler
    : GenletCodeGenerationHandlerI<IntermediateOperation, MethodDeclaration, ClassOrInterfaceDeclaration> {
    override fun handlesEObjectsOfInstance() = IntermediateOperation::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java

    private fun handlesAspects() = setOf("role")

    override fun execute(
        eObject: IntermediateOperation,
        node: MethodDeclaration,
        context: ClassOrInterfaceDeclaration?
    ): GenletCodeGenerationHandlerResult<MethodDeclaration> {
//        if (!eObject.hasAspect(*handlesAspects().toTypedArray()))
//            return GenletCodeGenerationHandlerResult(node)

        val endpoint = eObject.getEndpoint("rest")

        eObject.endpoints.forEach { endpoint ->
            endpoint.addresses.forEach { address ->
                println("Operation: ${eObject.qualifiedName} -> Endpoint: $address")
            }
        }

        return GenletCodeGenerationHandlerResult(node)
    }
}

