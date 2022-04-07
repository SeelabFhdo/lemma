package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.aspects

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.FieldDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataField
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.getPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.combinations
import de.fhdo.lemma.model_processing.code_generation.springcloud.forAllTechnologies
import org.eclipse.emf.ecore.EObject

/**
 * Handler for aspects related to decimals specification.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@AspectHandler
internal class DecimalsHandler : AspectHandlerI {
    override fun handlesAspects() = setOf("DecimalMax", "DecimalMin").forAllTechnologies()
    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateDataField::class.java with FieldDeclaration::class.java
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        val generatedField = node as FieldDeclaration
        generatedField.addImport("javax.validation.constraints.${aspect.name}", ImportTargetElementType.ANNOTATION)
        val annotation = generatedField.addAndGetAnnotation(aspect.name)
        annotation.addPair("value", "\"${aspect.getPropertyValue("value")}\"")

        // Handle inclusive flag
        val inclusive = aspect.getPropertyValue("inclusive")?.toBoolean()?.toString() ?: return node
        annotation.addPair("inclusive", inclusive)

        return node
    }
}