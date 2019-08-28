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

@AspectHandler
class TableHandler : AspectHandlerI {
    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateDataStructure::class.java with ClassOrInterfaceDeclaration::class.java
    }

    override fun handlesAspects() = setOf("java.Table")

    override fun execute(eObject : EObject, node : Node, aspect : IntermediateImportedAspect) : Node {
        val generatedClass = (node as ClassOrInterfaceDeclaration)
        generatedClass.addAnnotation("Entity")
        generatedClass.addImport("javax.persistence.Entity", ImportTargetElementType.ANNOTATION)

        val tableAnnotation = generatedClass.addAndGetAnnotation("Table")
        val tableName = aspect.getPropertyValue("name")
        if (tableName !== null)
            tableAnnotation.addPair("name", "\"$tableName\"")
        generatedClass.addImport("javax.persistence.Table", ImportTargetElementType.ANNOTATION)

        val dataStructure = (eObject as IntermediateDataStructure)
        val identifierMembers = generatedClass.fields.filter { generatedField ->
            dataStructure.dataFields.find{ it.name == generatedField.variables[0].nameAsString }!!
                .hasFeature("IDENTIFIER")
        }
        identifierMembers.forEach {
            println(it)
            generatedClass.addImport("javax.persistence.Id", ImportTargetElementType.FIELD)
            it.addAnnotation("Id")
        }

        generatedClass.addDependency("org.springframework.boot:spring-boot-starter-data-jpa")

        return node
    }
}