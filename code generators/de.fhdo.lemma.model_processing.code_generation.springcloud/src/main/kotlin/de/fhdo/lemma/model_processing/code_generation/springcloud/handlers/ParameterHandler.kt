package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers

import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.*
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.service.intermediate.IntermediateParameter

@CodeGenerationHandler
internal class ParameterHandler
    : GenletCodeGenerationHandlerI<IntermediateParameter, MethodDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateParameter::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java

    override fun execute(intermediateParameter: IntermediateParameter, method: MethodDeclaration, context: Nothing?)
            : GenletCodeGenerationHandlerResult<MethodDeclaration>? {
        val apiOperationComment = intermediateParameter.operation.apiOperationComment ?: return null
        val apiParameterComment = apiOperationComment.parameterComments
            .find { it.parameter.name == intermediateParameter.name }
            ?: return null

        val methodParameter = method.getParameter(intermediateParameter.name)!!
        method.addImport("io.swagger.annotations.ApiParam", ImportTargetElementType.ANNOTATION,
            SerializationCharacteristic.REMOVE_ON_RELOCATION)
        val apiParamAnnotation = methodParameter.addAndGetAnnotation("ApiParam",
            SerializationCharacteristic.REMOVE_ON_RELOCATION)
        apiParamAnnotation.addPair("value", "\"${apiParameterComment.comment}\"")
        if (apiParameterComment.isRequired)
            apiParamAnnotation.addPair("required", "true")

        return GenletCodeGenerationHandlerResult(method)
    }
}