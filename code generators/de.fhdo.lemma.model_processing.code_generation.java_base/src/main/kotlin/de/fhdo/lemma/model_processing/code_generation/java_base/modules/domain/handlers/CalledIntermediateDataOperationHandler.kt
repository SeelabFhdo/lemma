package de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.handlers

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.body.Parameter
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataOperation
import de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependencies
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClassname
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CallableCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.getTypeMapping
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainContext.State as DomainState
import de.fhdo.lemma.model_processing.utils.trimToSingleLine

@CodeGenerationHandler
internal class CalledIntermediateDataOperationHandler :
    CallableCodeGenerationHandlerI<IntermediateDataOperation, MethodDeclaration, ClassOrInterfaceDeclaration> {
    private val currentDomainPackage: String by DomainState

    override fun handlesEObjectsOfInstance() = IntermediateDataOperation::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java
    override fun getAspects(operation: IntermediateDataOperation) = operation.aspects

    companion object {
        fun invoke(operation: IntermediateDataOperation, parentClass: ClassOrInterfaceDeclaration)
            = CalledIntermediateDataOperationHandler().invoke(operation, parentClass)
    }

    override fun execute(operation: IntermediateDataOperation, parentClass: ClassOrInterfaceDeclaration?)
        : Pair<MethodDeclaration, String?>? {
        val generatedMethod = parentClass!!.addMethod(operation.name)
        if (!operation.isInherited) {
            generatedMethod.setVisibility(operation)
            generatedMethod.setReturnType(operation, parentClass)
        } else if (operation.visibilitySubsequentlyConstrained)
            generatedMethod.addNotImplementedBody()

        operation.parameters.forEach { generatedMethod.addParameter(it, parentClass) }

        return generatedMethod to null
    }

    private fun MethodDeclaration.setVisibility(originalOperation: IntermediateDataOperation) {
        if (!originalOperation.isHidden)
            addModifier(Modifier.Keyword.PUBLIC)
        else
            addModifier(Modifier.Keyword.PRIVATE)
    }

    private fun MethodDeclaration.setReturnType(originalOperation: IntermediateDataOperation,
        parentClass: ClassOrInterfaceDeclaration) {
        val returnType = originalOperation.returnType?.type
        if (returnType == null) {
            setType("void")
            return
        }

        val typeMapping = returnType.getTypeMapping()
        if (typeMapping != null) {
            val (mappedTypeName, isComplexTypeMapping, imports, dependencies) = typeMapping
            imports.forEach { addImport(it, ImportTargetElementType.METHOD) }
            parentClass.addDependencies(dependencies)

            if (isComplexTypeMapping) {
                val fullyQualifiedClassname = (returnType as IntermediateComplexType).fullyQualifiedClassname
                val complexTypeFullyQualifiedName = "$currentDomainPackage.$fullyQualifiedClassname"
                addImport(complexTypeFullyQualifiedName, ImportTargetElementType.METHOD)
            }

            setType(mappedTypeName)
        } else
            setType("${returnType.name}_ExpectedFromGenlet")
    }

    private fun MethodDeclaration.addNotImplementedBody() {
        addAnnotation("Override")
        setBody(
            """
            throw new UnsupportedOperationException(
                "The method \"${nameAsString}\" is not visible on this type"
            );
            """.trimToSingleLine()
        )
    }

    private fun MethodDeclaration.addParameter(parameter: IntermediateDataOperationParameter,
        parentClass: ClassOrInterfaceDeclaration) {
        val generatedParameter = Parameter()
        generatedParameter.setName(parameter.name)

        val typeMapping = parameter.type.getTypeMapping()
        if (typeMapping != null) {
            val (mappedTypeName, isComplexTypeMapping, imports, dependencies) = typeMapping
            imports.forEach { addImport(it, ImportTargetElementType.METHOD) }
            parentClass.addDependencies(dependencies)

            if (isComplexTypeMapping) {
                val fullyQualifiedClassname = (parameter.type as IntermediateComplexType).fullyQualifiedClassname
                val complexTypeFullyQualifiedName = "$currentDomainPackage.$fullyQualifiedClassname"
                addImport(complexTypeFullyQualifiedName, ImportTargetElementType.METHOD)
            }

            generatedParameter.setType(mappedTypeName)
        } else
            generatedParameter.setType("${parameter.type.name}_ExpectedFromGenlet")

        addParameter(generatedParameter)
    }

    private val IntermediateDataOperation.visibilitySubsequentlyConstrained get() = isInherited && isHidden
}