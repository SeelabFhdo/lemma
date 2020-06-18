package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.aspects

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
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
 * Handler for the java.Access aspect.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@AspectHandler
internal class AccessHandler : AspectHandlerI {
    override fun handlesAspects() = setOf("java.Access")
    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateDataStructure::class.java with ClassOrInterfaceDeclaration::class.java
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        /* Add JPA import */
        val generatedClass = node as ClassOrInterfaceDeclaration
        generatedClass.addDependency("org.springframework.boot:spring-boot-starter-data-jpa")

        /* Add Access annotation */
        generatedClass.addImport("javax.persistence.Access", ImportTargetElementType.ANNOTATION)
        val accessAnnotation = generatedClass.addAndGetAnnotation("Access")

        /* Add AccessType to annotation */
        generatedClass.addImport("javax.persistence.AccessType", ImportTargetElementType.ANNOTATION)
        val accessType = when(aspect.getPropertyValue("value")) {
            "PROPERTY" -> "PROPERTY"
            else -> "FIELD"
        }
        accessAnnotation!!.addValue("value", "AccessType.$accessType")

        return node
    }
}