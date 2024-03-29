package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.aspects

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.expr.NormalAnnotationExpr
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAndGetAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.getEndpoint
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.combinations
import de.fhdo.lemma.model_processing.code_generation.springcloud.addValue
import de.fhdo.lemma.model_processing.code_generation.springcloud.forSpringTechnology
import de.fhdo.lemma.model_processing.code_generation.springcloud.hasValue
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import org.eclipse.emf.ecore.EObject

/**
 * Handler for aspects related to REST mappings.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@AspectHandler
internal class OperationRestMappingsHandler : AspectHandlerI {
    private val aspectToAnnotationMapping = mapOf(
        "GetMapping" to "GetMapping",
        "PutMapping" to "PutMapping",
        "PostMapping" to "PostMapping",
        "DeleteMapping" to "DeleteMapping",
        "PatchMapping" to "PatchMapping",

        "Get" to "GetMapping",
        "Put" to "PutMapping",
        "Post" to "PostMapping",
        "Delete" to "DeleteMapping",
        "Patch" to "PatchMapping"
    )

    override fun handlesAspects() = aspectToAnnotationMapping.keys.forSpringTechnology()
    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateOperation::class.java with MethodDeclaration::class.java
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        val annotation = aspectToAnnotationMapping[aspect.name]!!

        /*
         * Add aspect-dependent import to the generated method. In case of a relocation, this import sticks to the
         * method as the aspect-dependent annotation does.
         */
        val generatedMethod = node as MethodDeclaration
        val importClassname = "org.springframework.web.bind.annotation.${annotation}"
        generatedMethod.addImport(importClassname, ImportTargetElementType.ANNOTATION,
            SerializationCharacteristic.REMOVE_ON_RELOCATION)

        /* Add REST mapping annotation to the operation, if it is not present already */
        val operation = eObject as IntermediateOperation
        val existingAnnotation = generatedMethod.getAnnotation<NormalAnnotationExpr>(annotation)
        val targetAnnotation = existingAnnotation ?: generatedMethod.addAndGetAnnotation(annotation,
            SerializationCharacteristic.REMOVE_ON_RELOCATION)

        /* Add missing endpoint addresses */
        operation.getEndpoint("rest")?.addresses?.forEach {
            if (!targetAnnotation.hasValue("value", "\"$it\""))
                targetAnnotation.addValue("value", "\"$it\"")
        }

        return generatedMethod
    }
}