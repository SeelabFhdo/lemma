package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.aspects

import com.github.javaparser.StaticJavaParser
import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataOperation
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.data.intermediate.IntermediateListType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.combinations
import de.fhdo.lemma.model_processing.code_generation.java_base.hasFeature
import de.fhdo.lemma.model_processing.code_generation.java_base.resolve
import de.fhdo.lemma.model_processing.code_generation.springcloud.javaType
import org.eclipse.emf.ecore.EObject

/**
 * Handler for the CrudRepository aspect.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@AspectHandler
internal class CrudRepositoryHandler : AspectHandlerI {
    override fun handlesAspects() = setOf("java.CrudRepository", "Spring.CrudRepository")
    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateDataStructure::class.java with ClassOrInterfaceDeclaration::class.java
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        val repository = eObject as IntermediateDataStructure
        val repositoryInterface = node as ClassOrInterfaceDeclaration

        // Get the data structure being managed by this repository and its identifier field. The former's Java type
        // counterpart becomes the "T" type parameter of the CrudRepository interface, the latter's Java type
        // counterpart becomes the "ID" type parameter of the CrudRepository interface.
        val managedStructure = repository.getManagedStructure() ?: return node
        val managedIdField = managedStructure.dataFields.find { it.hasFeature("IDENTIFIER") } ?: return node

        val managedType = managedStructure.javaType {
            repositoryInterface.addImport(it, ImportTargetElementType.SUPER)
        }
        val managedIdType = managedIdField.type.javaType {
            repositoryInterface.addImport(it, ImportTargetElementType.SUPER)
        }

        // Remove all methods and attributes that haven't been defined in the original intermediate data structure,
        // e.g., constructors, setters, and getters. In addition, remove the bodies of the remaining methods, because
        // the repository becomes an interface.
        repositoryInterface.removeMethodsAndAllAttributes(repository.operations)
        repositoryInterface.members.forEach { (it as MethodDeclaration).removeBody() }
        repositoryInterface.isInterface = true

        // Extend repository interface with CrudRepository interface
        val crudRepositoryType = StaticJavaParser.parseClassOrInterfaceType("CrudRepository")
        repositoryInterface.addImport("org.springframework.data.repository.CrudRepository",
            ImportTargetElementType.SUPER)
        crudRepositoryType.setTypeArguments(
            StaticJavaParser.parseClassOrInterfaceType(managedType.asString()),
            StaticJavaParser.parseClassOrInterfaceType(managedIdType.asString())
        )
        repositoryInterface.addExtendedType(crudRepositoryType)

        return node
    }

    /**
     * Helper to remove a given list of [methods] and all attributes from this [ClassOrInterfaceDeclaration]
     */
    private fun ClassOrInterfaceDeclaration.removeMethodsAndAllAttributes(methods: List<IntermediateDataOperation>) {
        val originalMethodsNames = methods.map { it.name }
        members.removeAll { it !is MethodDeclaration || it.nameAsString !in originalMethodsNames }
    }

    /**
     * Helper to get the data structure being managed by this repository. The data structure is identified from the
     * first data field in the repository with an [IntermediateDataStructure] type or the first data field, whose type
     * is a structure list with only one field having an [IntermediateDataStructure] type.
     */
    private fun IntermediateDataStructure.getManagedStructure() : IntermediateDataStructure? {
        val managedField = dataFields.find { it.type is IntermediateComplexType } ?: return null
        val resolvedType = (managedField.type as IntermediateComplexType).resolve()
        return if (resolvedType is IntermediateDataStructure)
            resolvedType
        else if (resolvedType is IntermediateListType &&
            resolvedType.isStructuredList &&
            resolvedType.dataFields.size == 1) {
            val managedType = resolvedType.dataFields[0].type as IntermediateComplexType
            managedType.resolve() as IntermediateDataStructure
        } else
            null
    }
}