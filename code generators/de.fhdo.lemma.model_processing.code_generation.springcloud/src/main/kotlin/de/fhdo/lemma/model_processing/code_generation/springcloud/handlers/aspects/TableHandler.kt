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
import de.fhdo.lemma.model_processing.code_generation.java_base.hasFeature
import org.eclipse.emf.ecore.EObject

/**
 * Handler for the java.Table aspect.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@AspectHandler
internal class TableHandler : AspectHandlerI {
    override fun handlesAspects() = setOf("java.Table")
    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateDataStructure::class.java with ClassOrInterfaceDeclaration::class.java
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        /* Add JPA import */
        val generatedClass = (node as ClassOrInterfaceDeclaration)
        generatedClass.addDependency("org.springframework.boot:spring-boot-starter-data-jpa")

        /* Each Table automatically becomes an Entity, too */
        generatedClass.addAnnotation("Entity")
        generatedClass.addImport("javax.persistence.Entity", ImportTargetElementType.ANNOTATION)

        /* Add the Table annotation together with its "name" value if specified for the aspect */
        val tableAnnotation = generatedClass.addAndGetAnnotation("Table")
        val tableName = aspect.getPropertyValue("name")
        if (tableName != null)
            tableAnnotation.addPair("name", "\"$tableName\"")
        generatedClass.addImport("javax.persistence.Table", ImportTargetElementType.ANNOTATION)

        /*
         * Add Id annotation to all attributes of the generated class whose corresponding data structure fields are
         * identifiers
         */
        val dataStructure = (eObject as IntermediateDataStructure)
        val generatedIdentifierAttributes = generatedClass.fields.filter { generatedField ->
            val dataField = dataStructure.dataFields.find { it.name == generatedField.variables[0].nameAsString }!!
            dataField.hasFeature("IDENTIFIER")
        }
        if (generatedIdentifierAttributes.isNotEmpty())
            generatedClass.addImport("javax.persistence.Id", ImportTargetElementType.ATTRIBUTE)
        generatedIdentifierAttributes.forEach { it.addAnnotation("Id") }

        return node
    }
}