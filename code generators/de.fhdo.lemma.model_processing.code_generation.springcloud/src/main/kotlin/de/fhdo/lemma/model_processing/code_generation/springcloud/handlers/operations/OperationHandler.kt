package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.operations

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
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
import de.fhdo.lemma.model_processing.code_generation.java_base.getAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.getInputParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.hasAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.hasInputParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.isResultParameter
import de.fhdo.lemma.model_processing.code_generation.springcloud.forSpringTechnology
import de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.aspects.ResponseEntityHandler.Companion.RESPONSE_ENTITY_ASPECT_NAMES
import de.fhdo.lemma.model_processing.code_generation.springcloud.spring.addResponseStatusAnnotation
import de.fhdo.lemma.model_processing.code_generation.springcloud.Context.State as State
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.technology.CommunicationType

/**
 * Code generation handler for IntermediateOperation instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class OperationHandler
    : GenletCodeGenerationHandlerI<IntermediateOperation, MethodDeclaration, ClassOrInterfaceDeclaration> {
    companion object {
        private val RESPONSE_STATUS_ASPECT_NAMES = "ResponseStatus".forSpringTechnology()
    }

    override fun handlesEObjectsOfInstance() = IntermediateOperation::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: IntermediateOperation, node: MethodDeclaration, context: ClassOrInterfaceDeclaration?)
        : GenletCodeGenerationHandlerResult<MethodDeclaration>? {
        /* Add imports and annotations related to API comments */
        if (eObject.apiOperationComment != null) {
            node.addImport(
                "io.swagger.annotations.ApiOperation", ImportTargetElementType.ANNOTATION,
                SerializationCharacteristic.REMOVE_ON_RELOCATION
            )
            val apiOperationAnnotation = node.addAndGetAnnotation(
                "ApiOperation",
                SerializationCharacteristic.REMOVE_ON_RELOCATION
            )
            apiOperationAnnotation.addPair("value", "\"${eObject.apiOperationComment.comment}\"")
        }

        /*
         * In case any of the operation's parameters exhibits the ResponseEntity aspect, the return type of the
         * generated method will be adapted to be ResponseEntity with the current return type as type argument. This,
         * however, is only possible when the return type is a ClassOrInterfaceType.
         */
        val hasResponseEntityParameter = eObject.parameters.any { it.hasAspect(RESPONSE_ENTITY_ASPECT_NAMES) }
        if (hasResponseEntityParameter && node.type is ClassOrInterfaceType) {
            val currentReturnType = (node.type as ClassOrInterfaceType).nameAsString
            if (currentReturnType != "ResponseEntity") {
                node.addImport("org.springframework.http.ResponseEntity", ImportTargetElementType.METHOD)
                node.setType("ResponseEntity<${node.typeAsString}>")
            }
        }

        /*
         * Handle ResponseStatus aspect on parameters. In case a synchronous outgoing parameter exhibits the aspect, we
         * add the corresponding annotation to the generated Java method. Note that if two outgoing parameters have the
         * aspect, only the status of the first one will be considered.
         */
        val responseStatusAnnotation = eObject.parameters.firstOrNull {
            it.isResultParameter &&
            it.communicationType == CommunicationType.SYNCHRONOUS.name &&
            it.hasAspect(RESPONSE_STATUS_ASPECT_NAMES)
        }?.getAspect(RESPONSE_STATUS_ASPECT_NAMES)
        if (responseStatusAnnotation != null)
            node.addResponseStatusAnnotation(responseStatusAnnotation)

        /*
         * Gather asynchronous input parameters in the Genlet's state to later handle them after generation of the
         * current microservice has been finished (cf. MicroserviceHandler)
         */
        if (eObject.hasInputParameters(CommunicationType.ASYNCHRONOUS)) {
            // Asynchronous input parameters will be condensed into a single composite class by the Java base
            // generator
            val asynchronousParameter = eObject.getInputParameters(CommunicationType.ASYNCHRONOUS)[0].type
            val compositeClass = (asynchronousParameter as? IntermediateComplexType)?.fullyQualifiedClassname
            if (compositeClass != null)
                State.addOrUpdateAsynchronousOperationInfo(eObject, node, compositeClass)
        }

        return GenletCodeGenerationHandlerResult(node)
    }
}