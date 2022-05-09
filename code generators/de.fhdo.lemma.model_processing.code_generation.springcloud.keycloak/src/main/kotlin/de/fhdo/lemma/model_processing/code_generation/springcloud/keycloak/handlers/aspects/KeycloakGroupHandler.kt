package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.handlers.aspects

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedFileContent
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.hasAspect
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice

@CodeGenerationHandler
internal class KeycloakGroupHandler
    : GenletCodeGenerationHandlerI<IntermediateMicroservice, ClassOrInterfaceDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateMicroservice::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java

    private fun handlesAspects() = setOf("")

    override fun execute(
        eObject: IntermediateMicroservice,
        node: ClassOrInterfaceDeclaration,
        context: Nothing?
    ): GenletCodeGenerationHandlerResult<ClassOrInterfaceDeclaration> {
        if (!eObject.hasAspect(*handlesAspects().toTypedArray()))
            return GenletCodeGenerationHandlerResult(node)
        val fileSet = mutableSetOf<GenletGeneratedFileContent>()
        return GenletCodeGenerationHandlerResult(node, fileSet)
    }
}

