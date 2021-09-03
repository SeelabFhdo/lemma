package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.aspects

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.java.ast.utils.ImportTargetElementType
import de.fhdo.lemma.java.ast.utils.isGenericType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.combinations
import org.eclipse.emf.ecore.EObject

/**
 * Handler for the ResponseEntity aspect.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@AspectHandler
internal class ResponseEntityHandler : AspectHandlerI {
    override fun handlesAspects() = setOf("java.ResponseEntity", "Spring.ResponseEntity")
    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateDataOperationReturnType::class.java with MethodDeclaration::class.java
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        val generatedMethod = node as MethodDeclaration

        // Add ResponseEntity return type to method if it does not have a generic return type yet
        if (!generatedMethod.type.isGenericType()) {
            generatedMethod.addImport("org.springframework.http.ResponseEntity", ImportTargetElementType.METHOD)
            generatedMethod.setType("ResponseEntity<${generatedMethod.typeAsString}>")
        }

        return node
    }
}