package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.aspects

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.expr.NormalAnnotationExpr
import com.github.javaparser.ast.type.ClassOrInterfaceType
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.*
import de.fhdo.lemma.model_processing.code_generation.java_base.getPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.combinations
import de.fhdo.lemma.model_processing.code_generation.springcloud.spring.HttpStatus
import de.fhdo.lemma.service.intermediate.IntermediateParameter
import org.eclipse.emf.ecore.EObject
import java.lang.IllegalArgumentException

@AspectHandler
internal class ParameterHandler : AspectHandlerI {
    private val aspectNodeTypeCombinations = mapOf<String, List<Class<out Node>>>(
        "java.ResponseStatus" to listOf(ClassOrInterfaceDeclaration::class.java),

        "java.PathVariable" to listOf(MethodDeclaration::class.java),
        "java.RequestBody" to listOf(MethodDeclaration::class.java),
        "java.RequestParam" to listOf(MethodDeclaration::class.java),
        "java.ResponseEntity" to listOf(MethodDeclaration::class.java),
        "java.Valid" to listOf(MethodDeclaration::class.java)
    )

    override fun handlesAspects() = aspectNodeTypeCombinations.keys

    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateParameter::class.java with MethodDeclaration::class.java
        IntermediateParameter::class.java with ClassOrInterfaceDeclaration::class.java
    }

    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        val supportedNodeTypes = aspectNodeTypeCombinations[aspect.qualifiedName]!!
        if (node::class.java !in supportedNodeTypes)
            return node

        return when(node) {
            is ClassOrInterfaceDeclaration -> execute(eObject as IntermediateParameter, node, aspect)
            is MethodDeclaration -> execute(eObject as IntermediateParameter, node, aspect)
            else -> node
        }
    }

    private fun execute(parameter: IntermediateParameter, generatedClass: ClassOrInterfaceDeclaration,
        aspect: IntermediateImportedAspect) : Node {
        generatedClass.addImport("org.springframework.http.HttpStatus", ImportTargetElementType.ANNOTATION)
        generatedClass.addImport("org.springframework.web.bind.annotation.ResponseStatus",
            ImportTargetElementType.ANNOTATION)

        val aspectStatus = aspect.getPropertyValue("status")
        val statusName = try {
            HttpStatus.valueOf(aspectStatus!!).toString()
        } catch (ex: IllegalArgumentException) {
            HttpStatus.values()
                .firstOrNull { it.value.toString() == aspectStatus || it.reasonPhrase == aspectStatus }
                ?.toString()
                ?: HttpStatus.INTERNAL_SERVER_ERROR.toString()
        }

        val responseStatusAnnotation = generatedClass.addAndGetAnnotation("ResponseStatus")
        responseStatusAnnotation.addPair("value", "HttpStatus.$statusName")
        return generatedClass
    }

    private fun execute(parameter: IntermediateParameter, generatedMethod: MethodDeclaration,
        aspect: IntermediateImportedAspect) : Node {
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