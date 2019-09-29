package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers

import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAndGetAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.service.intermediate.IntermediateOperation

@CodeGenerationHandler
internal class OperationHandler
    : GenletCodeGenerationHandlerI<IntermediateOperation, MethodDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateOperation::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java

    override fun execute(operation: IntermediateOperation, method: MethodDeclaration, context: Nothing?)
        : GenletCodeGenerationHandlerResult<MethodDeclaration>? {
        if (operation.apiOperationComment == null)
            return null

        method.addImport("io.swagger.annotations.ApiOperation", ImportTargetElementType.ANNOTATION,
            SerializationCharacteristic.REMOVE_ON_RELOCATION)
        val apiOperationAnnotation = method.addAndGetAnnotation("ApiOperation",
            SerializationCharacteristic.REMOVE_ON_RELOCATION)
        apiOperationAnnotation.addPair("value", "\"${operation.apiOperationComment.comment}\"")

        return GenletCodeGenerationHandlerResult(method)
    }
}