package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.aspects

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.FieldDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataField
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.java.ast.utils.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.combinations
import org.eclipse.emf.ecore.EObject

/**
 * Handler for the java.NotNull aspect.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@AspectHandler
internal class NotNullHandler : AspectHandlerI {
    override fun handlesAspects() = setOf("java.NotNull")
    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateDataField::class.java with FieldDeclaration::class.java
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        val generatedField = node as FieldDeclaration
        generatedField.addImport("javax.validation.constraints.NotNull", ImportTargetElementType.ANNOTATION)
        generatedField.addAnnotation("NotNull")
        return node
    }
}