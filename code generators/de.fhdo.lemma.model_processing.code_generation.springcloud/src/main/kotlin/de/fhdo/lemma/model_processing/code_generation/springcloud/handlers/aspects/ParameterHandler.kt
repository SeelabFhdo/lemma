package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.aspects

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.expr.NormalAnnotationExpr
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getParameter
import de.fhdo.lemma.model_processing.code_generation.java_base.getPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.combinations
import de.fhdo.lemma.model_processing.code_generation.springcloud.spring.addResponseStatusAnnotation
import de.fhdo.lemma.service.intermediate.IntermediateParameter
import org.eclipse.emf.ecore.EObject

/**
 * Handler for [IntermediateParameter] aspects.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@AspectHandler
internal class ParameterHandler : AspectHandlerI {
    private val aspectNodeTypeCombinations = mapOf<String, List<Class<out Node>>>(
        "java.ResponseStatus" to listOf(ClassOrInterfaceDeclaration::class.java),
        "java.PathVariable" to listOf(MethodDeclaration::class.java),
        "java.RequestBody" to listOf(MethodDeclaration::class.java),
        "java.RequestParam" to listOf(MethodDeclaration::class.java),
        "java.Valid" to listOf(MethodDeclaration::class.java),

        "Spring.ResponseStatus" to listOf(ClassOrInterfaceDeclaration::class.java),
        "Spring.PathVariable" to listOf(MethodDeclaration::class.java),
        "Spring.RequestBody" to listOf(MethodDeclaration::class.java),
        "Spring.RequestParam" to listOf(MethodDeclaration::class.java),
        "Spring.Valid" to listOf(MethodDeclaration::class.java)
    )

    override fun handlesAspects() = aspectNodeTypeCombinations.keys

    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateParameter::class.java with MethodDeclaration::class.java
        IntermediateParameter::class.java with ClassOrInterfaceDeclaration::class.java
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        val supportedNodeTypes = aspectNodeTypeCombinations[aspect.qualifiedName]!!
        if (node::class.java !in supportedNodeTypes)
            return node

        return when(node) {
            is ClassOrInterfaceDeclaration -> execute(node, aspect)
            is MethodDeclaration -> execute(eObject as IntermediateParameter, node, aspect)
            else -> node
        }
    }

    /**
     * Execution logic for when the generated Node is a [ClassOrInterfaceDeclaration]
     */
    private fun execute(generatedClass: ClassOrInterfaceDeclaration, aspect: IntermediateImportedAspect) : Node {
        /* The aspect must be ResponseStatus according to handlesEObjectNodeCombinations() */
        generatedClass.addResponseStatusAnnotation(aspect)
        return generatedClass
    }

    /**
     * Execution logic for when the generated Node is a [MethodDeclaration].
     */
    private fun execute(parameter: IntermediateParameter, generatedMethod: MethodDeclaration,
        aspect: IntermediateImportedAspect) : Node {
        /* Add annotation import */
        val import = if (aspect.name == "Valid")
                "javax.validation.Valid"
            else
                "org.springframework.web.bind.annotation.${aspect.name}"

        generatedMethod.addImport(import, ImportTargetElementType.ANNOTATION)

        /* Add annotation to the method */
        val generatedParameter = generatedMethod.getParameter(parameter.name)!!
        val annotation = generatedParameter.addAndGetAnnotation(aspect.name)
        if (aspect.name == "RequestParam")
            annotation.addRequestParamInformation(parameter, aspect)
        return generatedMethod
    }

    /**
     * Helper to add property values to this [NormalAnnotationExpr] from the RequestParam [requestParamAspect]
     */
    private fun NormalAnnotationExpr.addRequestParamInformation(parameter: IntermediateParameter,
        requestParamAspect: IntermediateImportedAspect) {
        if (parameter.isOptional)
            addPair("required", "false")

        val value = requestParamAspect.getPropertyValue("value")
        if (value != null)
            addPair("value", "\"$value\"")

        val defaultValue = requestParamAspect.getPropertyValue("defaultValue")
        if (defaultValue != null)
            addPair("defaultValue", "\"$defaultValue\"")
    }
}