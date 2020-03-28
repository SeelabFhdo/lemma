package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.operations

import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataOperation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.getTypeExpectedFromGenlet
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.isTypeExpectedFromGenlet
import de.fhdo.lemma.model_processing.code_generation.springcloud.addTypeInformationTo
import de.fhdo.lemma.model_processing.code_generation.springcloud.languages.existsTechnologySpecificMappingForType

/**
 * Code generation handler for IntermediateDataOperation instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class DataStructureHandler
    : GenletCodeGenerationHandlerI<IntermediateDataOperation, MethodDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateDataOperation::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java

    /**
     * Execution logic of the handler
     */
    override fun execute(operation: IntermediateDataOperation, generatedMethod: MethodDeclaration,
        context: Nothing?) : GenletCodeGenerationHandlerResult<MethodDeclaration>? {
        if (!generatedMethod.isTypeExpectedFromGenlet())
            return GenletCodeGenerationHandlerResult(generatedMethod)

        val expectedType = generatedMethod.getTypeExpectedFromGenlet()!!
        if (!existsTechnologySpecificMappingForType(expectedType))
            return GenletCodeGenerationHandlerResult(generatedMethod)

        val (mappedType, _) = operation.returnType.type.addTypeInformationTo(generatedMethod) {
            addImport(it, ImportTargetElementType.METHOD)
        }!!
        generatedMethod.setType(mappedType)
        return GenletCodeGenerationHandlerResult(generatedMethod)
    }
}