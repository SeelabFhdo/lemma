package de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.handlers

import com.github.javaparser.ast.body.EnumDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateEnumeration
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.avro.AvroConversionHelpersGenerator

/**
 * Code generation handler for IntermediateDataStructure instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class EnumerationHandler
    : GenletCodeGenerationHandlerI<IntermediateEnumeration, EnumDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateEnumeration::class.java
    override fun generatesNodesOfInstance() = EnumDeclaration::class.java

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: IntermediateEnumeration, node: EnumDeclaration, context: Nothing?)
        : GenletCodeGenerationHandlerResult<EnumDeclaration>? {
        AvroConversionHelpersGenerator.registerJavaTypeGeneratedFromComplexType(eObject, node)
        return null
    }
}