package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers

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
    : GenletCodeGenerationHandlerI<IntermediateDataField, FieldDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateDataField::class.java
    override fun generatesNodesOfInstance() = FieldDeclaration::class.java

    /**
     * Execution logic of the handler
     */
    override fun execute(field: IntermediateDataField, generatedField: FieldDeclaration, context: Nothing?)
        : GenletCodeGenerationHandlerResult<FieldDeclaration>? {
        if (generatedField.variables.isEmpty() || !generatedField.variables[0].isTypeExpectedFromGenlet())
            return GenletCodeGenerationHandlerResult(generatedField)

        val attribute = generatedField.variables[0]
        val expectedType = attribute.getTypeExpectedFromGenlet()!!
        if (!existsTechnologySpecificMappingForType(expectedType))
            return GenletCodeGenerationHandlerResult(generatedField)

        val (mappedType, _) = field.type.addTypeInformationTo(generatedField) {
            addImport(it, ImportTargetElementType.ATTRIBUTE_TYPE)
        }!!
        attribute.setType(mappedType)
        return GenletCodeGenerationHandlerResult(generatedField)
    }
}