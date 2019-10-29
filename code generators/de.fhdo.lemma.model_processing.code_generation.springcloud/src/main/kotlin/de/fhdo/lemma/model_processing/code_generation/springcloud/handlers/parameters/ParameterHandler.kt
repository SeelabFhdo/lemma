package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.parameters

import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAndGetAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getParameter
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.getTypeExpectedFromGenlet
import de.fhdo.lemma.model_processing.code_generation.springcloud.addTypeInformationTo
import de.fhdo.lemma.model_processing.code_generation.springcloud.languages.existsTechnologySpecificMappingForType
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
    override fun execute(parameter: IntermediateParameter, method: MethodDeclaration, context: Nothing?)
        : GenletCodeGenerationHandlerResult<MethodDeclaration>? {
        val generatedParameter = method.getParameter(parameter.name)!!

        /* Do Genlet-specific type mapping if necessary */
        val typeExpectedFromGenlet = generatedParameter.getTypeExpectedFromGenlet()
        if (typeExpectedFromGenlet != null && existsTechnologySpecificMappingForType(typeExpectedFromGenlet)) {
            val (mappedType, _) = parameter.type.addTypeInformationTo(method) {
                addImport(it, ImportTargetElementType.METHOD)
            }!!

            generatedParameter.setType(mappedType)
        }

        /* Handle API comments of the parameter if any */
        val apiComment = parameter.operation.apiOperationComment ?: return GenletCodeGenerationHandlerResult(method)
        val parameterComment = apiComment.parameterComments.find { it.parameter.name == parameter.name } ?: return null

        // Add imports and annotations related to API comments to parameter
        method.addImport("io.swagger.annotations.ApiParam", ImportTargetElementType.ANNOTATION,
            SerializationCharacteristic.REMOVE_ON_RELOCATION)
        val annotation = generatedParameter.addAndGetAnnotation("ApiParam",
            SerializationCharacteristic.REMOVE_ON_RELOCATION)
        annotation.addPair("value", "\"${parameterComment.comment}\"")
        if (parameterComment.isRequired)
            annotation.addPair("required", "true")

        return GenletCodeGenerationHandlerResult(method)
    }
}