package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.aspects

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.*
import de.fhdo.lemma.model_processing.code_generation.java_base.getPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.combinations
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import org.eclipse.emf.ecore.EObject

@AspectHandler
internal class OperationMessageMappingHandler : AspectHandlerI {
    override fun handlesAspects() = setOf("java.MessageMapping", "java.SendTo")

    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateOperation::class.java with MethodDeclaration::class.java
    }

    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        val generatedMethod = node as MethodDeclaration
        generatedMethod.addImport(
            "org.springframework.messaging.handler.annotation.${aspect.name}",
            ImportTargetElementType.ANNOTATION,
            SerializationCharacteristic.REMOVE_ON_RELOCATION
        )
        val annotation = generatedMethod.addAndGetAnnotation(aspect.name,
            SerializationCharacteristic.REMOVE_ON_RELOCATION)
        annotation.addPair("value", aspect.getPropertyValue("value")!!)

        val parentClass = generatedMethod.findParentNode<ClassOrInterfaceDeclaration>()!!
        if (parentClass.isInterface)
            return generatedMethod
        if (!parentClass.hasAnnotation("Controller")) {
            parentClass.addImport("org.springframework.stereotype.Controller", ImportTargetElementType.ANNOTATION,
                SerializationCharacteristic.DONT_RELOCATE)
            parentClass.addAnnotation("Controller")
        }

        return generatedMethod
    }
}