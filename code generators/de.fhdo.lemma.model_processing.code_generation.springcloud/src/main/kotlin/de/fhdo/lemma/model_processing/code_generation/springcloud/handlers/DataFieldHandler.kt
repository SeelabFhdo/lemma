package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.FieldDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataField
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
 * Code generation handler for IntermediateDataField instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class DataFieldHandler
    : GenletCodeGenerationHandlerI<IntermediateDataField, FieldDeclaration, ClassOrInterfaceDeclaration> {
    override fun handlesEObjectsOfInstance() = IntermediateDataField::class.java
    override fun generatesNodesOfInstance() = FieldDeclaration::class.java

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: IntermediateDataField, node: FieldDeclaration, context: ClassOrInterfaceDeclaration?)
        : GenletCodeGenerationHandlerResult<FieldDeclaration>? {
        if (node.variables.isEmpty() || !node.variables[0].isTypeExpectedFromGenlet())
            return GenletCodeGenerationHandlerResult(node)

        val attribute = node.variables[0]
        val expectedType = attribute.getTypeExpectedFromGenlet()!!
        if (!existsTechnologySpecificMappingForType(expectedType))
            return GenletCodeGenerationHandlerResult(node)

        val (mappedType, _) = eObject.type.addTypeInformationTo(node) {
            addImport(it, ImportTargetElementType.ATTRIBUTE_TYPE)
        }!!
        attribute.setType(mappedType)
        return GenletCodeGenerationHandlerResult(node)
    }
}