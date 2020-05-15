package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.parameters

import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAndGetAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependencies
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addThrownException
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getParameter
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.getTypeExpectedFromGenlet
import de.fhdo.lemma.model_processing.code_generation.springcloud.addTypeInformationTo
import de.fhdo.lemma.model_processing.code_generation.springcloud.languages.existsTechnologySpecificMappingForType
import de.fhdo.lemma.model_processing.code_generation.springcloud.languages.getTechnologySpecificMappingForType
import de.fhdo.lemma.service.intermediate.IntermediateParameter

/**
 * Code generation handler for IntermediateParameter instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class ParameterHandler : GenletCodeGenerationHandlerI<IntermediateParameter, MethodDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateParameter::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: IntermediateParameter, node: MethodDeclaration, context: Nothing?)
        : GenletCodeGenerationHandlerResult<MethodDeclaration>? {
        /* Handle Exception type if the parameter communicates a fault */
        if (eObject.isCommunicatesFault) {
            val (exception, _, imports, dependencies) = getTechnologySpecificMappingForType(eObject.type.name)
                ?: return GenletCodeGenerationHandlerResult(node)

            node.addDependencies(dependencies)
            imports.forEach { node.addImport(it, ImportTargetElementType.METHOD) }
            node.addThrownException(exception)
            return GenletCodeGenerationHandlerResult(node)
        }

        /* Do Genlet-specific type mapping if necessary */
        val generatedParameter = node.getParameter(eObject.name)!!
        val typeExpectedFromGenlet = generatedParameter.getTypeExpectedFromGenlet()
        if (typeExpectedFromGenlet != null && existsTechnologySpecificMappingForType(typeExpectedFromGenlet)) {
            val (mappedType, _) = eObject.type.addTypeInformationTo(node) {
                addImport(it, ImportTargetElementType.METHOD)
            }!!

            generatedParameter.setType(mappedType)
        }

        /* Handle API comments of the parameter if any */
        val apiComment = eObject.operation.apiOperationComment ?: return GenletCodeGenerationHandlerResult(node)
        val parameterComment = apiComment.parameterComments.find { it.parameter.name == eObject.name } ?: return null

        // Add imports and annotations related to API comments to parameter
        node.addImport("io.swagger.annotations.ApiParam", ImportTargetElementType.ANNOTATION,
            SerializationCharacteristic.REMOVE_ON_RELOCATION)
        val annotation = generatedParameter.addAndGetAnnotation("ApiParam",
            SerializationCharacteristic.REMOVE_ON_RELOCATION)
        annotation.addPair("value", "\"${parameterComment.comment}\"")
        if (parameterComment.isRequired)
            annotation.addPair("required", "true")

        return GenletCodeGenerationHandlerResult(node)
    }
}