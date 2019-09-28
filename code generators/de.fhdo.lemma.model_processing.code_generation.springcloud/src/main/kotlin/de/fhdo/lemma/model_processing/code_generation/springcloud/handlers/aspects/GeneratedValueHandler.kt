package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.aspects

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.FieldDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataField
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependency
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.combinations
import org.eclipse.emf.ecore.EObject

@AspectHandler
internal class GeneratedValueHandler : AspectHandlerI {
    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateDataField::class.java with FieldDeclaration::class.java
    }

    override fun handlesAspects() = setOf("java.GeneratedValue")

    override fun execute(eObject : EObject, node : Node, aspect : IntermediateImportedAspect) : Node {
        val generatedField = (node as FieldDeclaration)
        generatedField.addAnnotation("GeneratedValue")
        generatedField.addImport("javax.persistence.GeneratedValue", ImportTargetElementType.ATTRIBUTE)
        generatedField.addDependency("org.springframework.boot:spring-boot-starter-data-jpa")
        return node
    }
}