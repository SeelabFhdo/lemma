package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.aspects

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.expr.NameExpr
import com.github.javaparser.ast.expr.NormalAnnotationExpr
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.*
import de.fhdo.lemma.model_processing.code_generation.java_base.getEndpoint
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.combinations
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import org.eclipse.emf.ecore.EObject

@AspectHandler
internal class OperationRestMappingsHandler : AspectHandlerI {
    override fun handlesAspects() = setOf(
        "java.GetMapping",
        "java.PostMapping",
        "java.PutMapping",
        "java.DeleteMapping",
        "java.PatchMapping"
    )

    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateOperation::class.java with MethodDeclaration::class.java
    }

    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        val generatedMethod = node as MethodDeclaration
        generatedMethod.addImport(
            "org.springframework.web.bind.annotation.${aspect.name}",
            ImportTargetElementType.ANNOTATION,
            SerializationCharacteristic.REMOVE_ON_RELOCATION
        )

        val operation = eObject as IntermediateOperation
        val existingAnnotation = generatedMethod.getAnnotation<NormalAnnotationExpr>(aspect.name)
        val targetAnnotation = existingAnnotation ?: generatedMethod.addAndGetAnnotation(aspect.name,
            SerializationCharacteristic.REMOVE_ON_RELOCATION)

        operation.getEndpoint("rest")?.addresses?.forEach {
            if (!targetAnnotation.hasStringValue("value", it))
                targetAnnotation.addStringValue("value", it)
        }

        return generatedMethod
    }

    private fun NormalAnnotationExpr.hasStringValue(valueName: String, checkValue: String) : Boolean {
        val annotationValue = getValueAsString(valueName) ?: return false
        val values = parseMultipleAnnotationStringValue(annotationValue)
        return if (values != null)
            checkValue in values
        else
            checkValue == annotationValue
    }

    private fun parseMultipleAnnotationStringValue(value: String) : List<String>? {
        if (!value.startsWith("{") && !value.endsWith("}"))
            return null

        val containedValues = value.trimStart('}').trimEnd('}').split(",")
        val allContainedValuesAreStrings = !containedValues.any { !it.startsWith("\"") && !it.endsWith("\"") }
        return if (allContainedValuesAreStrings)
            containedValues
        else
            null
    }

    private fun NormalAnnotationExpr.addStringValue(valueName: String, value: String) {
        val existingValue = getValueAsString(valueName)
        val existingMultipleValues = if (existingValue != null)
            parseMultipleAnnotationStringValue(existingValue)
        else
            null

        val valueToAdd = when {
            existingMultipleValues != null -> "{" + existingMultipleValues.joinToString(",") + ", \"$value\"" + "}"
            existingValue != null -> "{$existingValue, \"$value\"}"
            else -> "\"$value\""
        }

        val existingPair = pairs.find { it.nameAsString == valueName }
        if (existingPair == null)
            addPair(valueName, valueToAdd)
        else
            existingPair.value = NameExpr(valueToAdd)
    }
}