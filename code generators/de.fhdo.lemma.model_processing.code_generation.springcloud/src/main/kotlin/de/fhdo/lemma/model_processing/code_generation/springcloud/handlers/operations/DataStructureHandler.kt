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
    override fun execute(eObject: IntermediateDataOperation, node: MethodDeclaration, context: Nothing?)
        : GenletCodeGenerationHandlerResult<MethodDeclaration>? {
        if (!node.isTypeExpectedFromGenlet())
            return GenletCodeGenerationHandlerResult(node)

        val expectedType = node.getTypeExpectedFromGenlet()!!
        if (!existsTechnologySpecificMappingForType(expectedType))
            return GenletCodeGenerationHandlerResult(node)

        val (mappedType, _) = eObject.returnType.type.addTypeInformationTo(node) {
            addImport(it, ImportTargetElementType.METHOD)
        }!!
        node.setType(mappedType)
        return GenletCodeGenerationHandlerResult(node)
    }
}