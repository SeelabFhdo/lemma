package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.aspects

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.expr.NormalAnnotationExpr
import com.github.javaparser.ast.type.ClassOrInterfaceType
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.*
import de.fhdo.lemma.model_processing.code_generation.java_base.getPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.combinations
import de.fhdo.lemma.service.intermediate.IntermediateParameter
import org.eclipse.emf.ecore.EObject

@AspectHandler
internal class ParameterHandler : AspectHandlerI {
    override fun handlesAspects() = setOf(
        "java.PathVariable",
        "java.RequestBody",
        "java.RequestParam",
        "java.ResponseEntity",
        "java.Valid"
    )

    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateParameter::class.java with MethodDeclaration::class.java
    }

    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        val parameter = eObject as IntermediateParameter
        val generatedMethod = node as MethodDeclaration

        val (import, targetElementType) = when(aspect.name) {
            "Valid" -> "javax.validation.Valid" to ImportTargetElementType.ANNOTATION
            "ResponseEntity" -> "org.springframework.http.ResponseEntity" to ImportTargetElementType.METHOD
            else -> "org.springframework.web.bind.annotation.${aspect.name}" to ImportTargetElementType.ANNOTATION
        }
        generatedMethod.addImport(import, targetElementType)

        if (aspect.name != "ResponseEntity") {
            val generatedParameter = generatedMethod.getParameter(parameter.name)!!
            val annotation = generatedParameter.addAndGetAnnotation(aspect.name)
            annotation.refine(parameter, aspect)
        } else if (generatedMethod.type is ClassOrInterfaceType) {
            val currentType = (generatedMethod.type as ClassOrInterfaceType).nameAsString
            if (currentType != "ResponseEntity")
                generatedMethod.setType("ResponseEntity<$currentType>")
        }
        return generatedMethod
    }

    private fun NormalAnnotationExpr.refine(parameter: IntermediateParameter, aspect: IntermediateImportedAspect) {
        if (aspect.name != "RequestParam")
            return

        if (parameter.isOptional)
            addPair("required", "false")

        val value = aspect.getPropertyValue("value")
        if (value != null)
            addPair("value", "\"$value\"")

        val defaultValue = aspect.getPropertyValue("defaultValue")
        if (defaultValue != null)
            addPair("defaultValue", "\"$defaultValue\"")
    }
}