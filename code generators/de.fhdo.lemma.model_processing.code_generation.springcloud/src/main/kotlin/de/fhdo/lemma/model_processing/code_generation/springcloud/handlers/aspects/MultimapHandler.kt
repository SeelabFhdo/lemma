package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.aspects

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.data.intermediate.*
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.*
import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClassname
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletStateAccess
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.combinations
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.getTypeMapping
import de.fhdo.lemma.model_processing.code_generation.java_base.resolve
import org.eclipse.emf.ecore.EObject

@AspectHandler
internal class MultimapHandler : AspectHandlerI {
    override fun handlesAspects() = setOf("java.Multimap")

    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateDataOperation::class.java with MethodDeclaration::class.java
    }

    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        val dataOperation = eObject as IntermediateDataOperation
        val returnType = (dataOperation.returnType.type as? IntermediateComplexType)?.resolve() ?: return node
        val listReturnType = returnType as? IntermediateListType ?: return node
        if (!listReturnType.isStructuredList || listReturnType.dataFields.size != 2)
            return node

        val generatedMethod = node as MethodDeclaration
        val typeParameter1 = doTypeMapping(listReturnType.dataFields[0].type, generatedMethod) ?: return node
        val typeParameter2 = doTypeMapping(listReturnType.dataFields[1].type, generatedMethod) ?: return node

        val generatedTypeName = generatedMethod.type.asClassOrInterfaceType().nameAsString
        if (generatedTypeName !in generatedMethod.parameters.map { it.nameAsString })
            generatedMethod.removeImport(returnType.getImportPackage(), ImportTargetElementType.METHOD)

        generatedMethod.addImport("com.google.common.collect.Multimap", ImportTargetElementType.METHOD)
        generatedMethod.setType("Multimap<$typeParameter1, $typeParameter2>")
        generatedMethod.addDependency("org.springframework.boot:spring-boot-starter-web")
        return generatedMethod
    }

    private fun doTypeMapping(type: IntermediateType, generatedMethod: MethodDeclaration) : String? {
        val typeMapping = type.getTypeMapping() ?: return null
        val (mappedTypeName, isComplexTypeMapping, imports, dependencies) = typeMapping
        imports.forEach { generatedMethod.addImport(it, ImportTargetElementType.METHOD) }
        generatedMethod.addDependencies(dependencies)

        if (isComplexTypeMapping) {
            val fullyQualifiedClassname = (type as IntermediateComplexType).fullyQualifiedClassname
            val currentDomainPackage: String by GenletStateAccess
            val complexTypeFullyQualifiedName = "$currentDomainPackage.$fullyQualifiedClassname"
            generatedMethod.addImport(complexTypeFullyQualifiedName, ImportTargetElementType.ATTRIBUTE_TYPE)
        }

        return mappedTypeName
    }

    private fun IntermediateComplexType.getImportPackage() : String {
        val currentDomainPackage: String by GenletStateAccess
        return "$currentDomainPackage.$fullyQualifiedClassname"
    }
}