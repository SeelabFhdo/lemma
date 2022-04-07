package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.aspects

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAndGetAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.findParentNode
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.hasAnnotation
import de.fhdo.lemma.model_processing.code_generation.java_base.getPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.combinations
import de.fhdo.lemma.model_processing.code_generation.springcloud.forSpringTechnology
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import org.eclipse.emf.ecore.EObject

/**
 * Handler for the MessageMapping and SendTo aspects.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@AspectHandler
internal class OperationMessageMappingHandler : AspectHandlerI {
    override fun handlesAspects() = setOf("MessageMapping", "SendTo").forSpringTechnology()
    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateOperation::class.java with MethodDeclaration::class.java
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        /*
         * Add aspect-dependent import to the generated method. In case of a relocation, this import sticks to the
         * method as the aspect-dependent annotation does.
         */
        val generatedMethod = node as MethodDeclaration
        val importClassname = "org.springframework.messaging.handler.annotation.${aspect.name}"
        generatedMethod.addImport(importClassname, ImportTargetElementType.ANNOTATION,
            SerializationCharacteristic.REMOVE_ON_RELOCATION)

        /* Add aspect-dependent annotation with value to the generated method */
        val annotation = generatedMethod.addAndGetAnnotation(aspect.name,
            SerializationCharacteristic.REMOVE_ON_RELOCATION)
        annotation.addPair("value", "\"${aspect.getPropertyValue("value")!!}\"")

        /* Add the Controller annotation to the class, if it is not present already */
        val parentClass = generatedMethod.findParentNode<ClassOrInterfaceDeclaration>()!!
        if (parentClass.isInterface || parentClass.hasAnnotation("Controller"))
            return generatedMethod

        parentClass.addImport("org.springframework.stereotype.Controller", ImportTargetElementType.ANNOTATION,
            SerializationCharacteristic.DONT_RELOCATE)
        parentClass.addAnnotation("Controller", SerializationCharacteristic.DONT_RELOCATE)

        return generatedMethod
    }
}