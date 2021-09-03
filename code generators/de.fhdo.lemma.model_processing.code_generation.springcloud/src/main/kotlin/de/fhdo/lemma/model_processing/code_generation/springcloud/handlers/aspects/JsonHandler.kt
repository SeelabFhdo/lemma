package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.aspects

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.FieldDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataField
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.java.ast.utils.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.dependencies.addDependency
import de.fhdo.lemma.model_processing.code_generation.java_base.getPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.combinations
import org.eclipse.emf.ecore.EObject

/**
 * Handler JSON-related aspects.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@AspectHandler
internal class JsonHandler : AspectHandlerI {
    override fun handlesAspects() = setOf(
        "java.JsonFormat",
        "java.JsonIgnore",
        "java.JsonProperty",
        "java.JsonUnwrapped",

        "Spring.JsonFormat",
        "Spring.JsonIgnore",
        "Spring.JsonProperty",
        "Spring.JsonUnwrapped"
    )

    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateDataField::class.java with FieldDeclaration::class.java
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        val generatedField = node as FieldDeclaration
        generatedField.addDependency("com.fasterxml.jackson.core:jackson-databind")
        generatedField.addImport("com.fasterxml.jackson.annotation.${aspect.name}", ImportTargetElementType.ANNOTATION)
        val annotation = generatedField.addAndGetAnnotation(aspect.name)

        when(aspect.name) {
            "JsonFormat" -> annotation.addPair("pattern", "\"${aspect.getPropertyValue("pattern")!!}\"")

            "JsonProperty" -> {
                val name = aspect.getPropertyValue("name")?: return node
                annotation.addPair("value", "\"$name\"")
            }
        }

        return node
    }
}