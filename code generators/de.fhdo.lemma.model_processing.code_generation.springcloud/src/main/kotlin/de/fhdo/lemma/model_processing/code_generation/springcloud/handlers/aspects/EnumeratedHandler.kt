package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.aspects

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.FieldDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataField
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependency
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.getPropertyValue
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.combinations
import de.fhdo.lemma.model_processing.code_generation.springcloud.addValue
import org.eclipse.emf.ecore.EObject

/**
 * Handler for the java.Enumerated aspect.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@AspectHandler
internal class EnumeratedHandler : AspectHandlerI {
    override fun handlesAspects() = setOf("java.Enumerated")
    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateDataField::class.java with FieldDeclaration::class.java
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        /* Add JPA import */
        val generatedClass = node as FieldDeclaration
        generatedClass.addDependency("org.springframework.boot:spring-boot-starter-data-jpa")

        /* Add Enumerated annotation */
        generatedClass.addImport("javax.persistence.Enumerated", ImportTargetElementType.ANNOTATION)
        val enumeratedAnnotation = generatedClass.addAndGetAnnotation("Enumerated")

        /* Add EnumType to annotation, if aspect's value differs from default EnumType of Enumerated */
        val enumType = when(aspect.getPropertyValue("value")) {
            "STRING" -> "STRING"
            else -> "ORDINAL"
        }

        if (enumType != "ORDINAL") {  // ORDINAL is the default EnumType
            generatedClass.addImport("javax.persistence.EnumType", ImportTargetElementType.ANNOTATION)
            enumeratedAnnotation!!.addValue("value", "EnumType.$enumType")
        }

        return node
    }
}