package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.aspects

import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataOperation
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.data.intermediate.IntermediateCollectionType
import de.fhdo.lemma.data.intermediate.IntermediateType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependency
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.removeImport
import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClassname
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletStateAccess
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.AspectHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.combinations
import de.fhdo.lemma.model_processing.code_generation.java_base.resolve
import de.fhdo.lemma.model_processing.code_generation.springcloud.addTypeInformationTo
import org.eclipse.emf.ecore.EObject

/**
 * Handler for the java.Multimap aspect.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@AspectHandler
internal class MultimapHandler : AspectHandlerI {
    override fun handlesAspects() = setOf("java.Multimap")
    override fun handlesEObjectNodeCombinations() = combinations {
        IntermediateDataOperation::class.java with MethodDeclaration::class.java
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: EObject, node: Node, aspect: IntermediateImportedAspect) : Node {
        /*
         * The aspect is only applicable to data operations whose return type is a structured collection with exactly
         * two data fields
         */
        val dataOperation = eObject as IntermediateDataOperation
        val returnType = (dataOperation.returnType.type as? IntermediateComplexType)?.resolve() ?: return node
        val collectionReturnType = returnType as? IntermediateCollectionType ?: return node
        if (!collectionReturnType.isStructuredCollection || collectionReturnType.dataFields.size != 2)
            return node

        /*
         * Resolve type information concerning the Multimap's type parameters, i.e., both data fields of the collection
         * return type and add them to the generated method
         */
        val generatedMethod = node as MethodDeclaration
        val (typeParameter1, _) = generatedMethod.addTypeInformation(collectionReturnType.dataFields[0].type)
            ?: return node
        val (typeParameter2, _) = generatedMethod.addTypeInformation(collectionReturnType.dataFields[1].type)
            ?: return node

        /*
         * Remove the import of the collection return type, if it is not used as type of an input parameter, too. It
         * will be  replaced by Multimap with the type parameters.
         */
        val generatedTypeName = generatedMethod.type.asClassOrInterfaceType().nameAsString
        if (generatedTypeName !in generatedMethod.parameters.map { it.nameAsString }) {
            val currentDomainPackage: String by GenletStateAccess
            val returnTypeImport = "$currentDomainPackage.${returnType.fullyQualifiedClassname}"
            generatedMethod.removeImport(returnTypeImport, ImportTargetElementType.METHOD)
        }

        /* Add Multimap import and dependency. Also, set the return type of the generated method to be a Multimap. */
        generatedMethod.addImport("com.google.common.collect.Multimap", ImportTargetElementType.METHOD)
        generatedMethod.addDependency("org.springframework.boot:spring-boot-starter-web")
        generatedMethod.setType("Multimap<$typeParameter1, $typeParameter2>")
        return generatedMethod
    }

    /**
     * Convenience function to add type information to this [MethodDeclaration]. Returns the result of
     * [addTypeInformationTo].
     */
    private fun MethodDeclaration.addTypeInformation(type: IntermediateType)
        = type.addTypeInformationTo(this) { addImport(it, ImportTargetElementType.METHOD) }
}