package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers

import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.type.ClassOrInterfaceType
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAndGetAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClassname
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.getInputParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.hasAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.hasInputParameters
import de.fhdo.lemma.model_processing.code_generation.springcloud.Context.State as State
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.technology.CommunicationType

@CodeGenerationHandler
internal class OperationHandler
    : GenletCodeGenerationHandlerI<IntermediateOperation, MethodDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateOperation::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java

    override fun execute(operation: IntermediateOperation, method: MethodDeclaration, context: Nothing?)
        : GenletCodeGenerationHandlerResult<MethodDeclaration>? {
        if (operation.apiOperationComment != null) {
            method.addImport(
                "io.swagger.annotations.ApiOperation", ImportTargetElementType.ANNOTATION,
                SerializationCharacteristic.REMOVE_ON_RELOCATION
            )
            val apiOperationAnnotation = method.addAndGetAnnotation(
                "ApiOperation",
                SerializationCharacteristic.REMOVE_ON_RELOCATION
            )
            apiOperationAnnotation.addPair("value", "\"${operation.apiOperationComment.comment}\"")
        }

        if (operation.parameters.any { it.hasAspect("java.ResponseEntity") } && method.type is ClassOrInterfaceType) {
            val currentType = (method.type as ClassOrInterfaceType).nameAsString
            if (currentType != "ResponseEntity") {
                method.addImport("org.springframework.http.ResponseEntity", ImportTargetElementType.METHOD)
                method.setType("ResponseEntity<$currentType>")
            }
        }

        if (operation.hasInputParameters(CommunicationType.ASYNCHRONOUS)) {
            val compositeInputClassName = if (!operation.hasInputParameters(CommunicationType.SYNCHRONOUS)) {
                    // There can only be one asynchronous parameter
                    val asynchronousParameter = operation.getInputParameters(CommunicationType.ASYNCHRONOUS)[0].type
                    (asynchronousParameter as? IntermediateComplexType)?.fullyQualifiedClassname ?: null
                } else
                    null

            State.addOrUpdateAsynchronousOperationInfo(operation, method, compositeInputClassName)
        }

        return GenletCodeGenerationHandlerResult(method)
    }
}