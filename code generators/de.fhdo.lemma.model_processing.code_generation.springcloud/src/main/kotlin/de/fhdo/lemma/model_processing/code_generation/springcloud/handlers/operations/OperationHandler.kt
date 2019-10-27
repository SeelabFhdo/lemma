package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.operations

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

/**
 * Code generation handler for IntermediateOperation instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class OperationHandler : GenletCodeGenerationHandlerI<IntermediateOperation, MethodDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateOperation::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java

    /**
     * Execution logic of the handler
     */
    override fun execute(operation: IntermediateOperation, method: MethodDeclaration, context: Nothing?)
        : GenletCodeGenerationHandlerResult<MethodDeclaration>? {
        /* Add imports and annotations related to API comments */
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

        /* In case any of the operation's parameters exhibits the java.ResponseEntity aspect, the return type of the
         * generated method will be adapted to be ResponseEntity with the current return type as type argument. This,
         * however, is only possible when the return type is a ClassOrInterfaceType.
         */
        if (operation.parameters.any { it.hasAspect("java.ResponseEntity") } && method.type is ClassOrInterfaceType) {
            val currentReturnType = (method.type as ClassOrInterfaceType).nameAsString
            if (currentReturnType != "ResponseEntity") {
                method.addImport("org.springframework.http.ResponseEntity", ImportTargetElementType.METHOD)
                method.setType("ResponseEntity<$currentReturnType>")
            }
        }

        /*
         * Gather asynchronous input parameters in the Genlet's state to later handle them after generation of the
         * current microservice has been finished (cf. MicroserviceHandler)
         */
        if (operation.hasInputParameters(CommunicationType.ASYNCHRONOUS)) {
            // Asynchronous input parameters will be condensed into a single composite class by the Java base
            // generator
            val asynchronousParameter = operation.getInputParameters(CommunicationType.ASYNCHRONOUS)[0].type
            val compositeClass = (asynchronousParameter as? IntermediateComplexType)?.fullyQualifiedClassname
            if (compositeClass != null)
                State.addOrUpdateAsynchronousOperationInfo(operation, method, compositeClass)
        }

        return GenletCodeGenerationHandlerResult(method)
    }
}