package de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.handlers

import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependencies
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClassname
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CallableCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.getTypeMapping
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainContext.State as DomainState

@CodeGenerationHandler
internal class CalledIntermediateDataOperationReturnTypeHandler
    : CallableCodeGenerationHandlerI<IntermediateDataOperationReturnType, MethodDeclaration, MethodDeclaration> {
    private val currentDomainPackage: String by DomainState

    override fun handlesEObjectsOfInstance() = IntermediateDataOperationReturnType::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java
    override fun getAspects(returnType: IntermediateDataOperationReturnType) = returnType.aspects!!

    companion object {
        fun invoke(returnType : IntermediateDataOperationReturnType?, parentMethod: MethodDeclaration)
            : Pair<MethodDeclaration, String?>? {
            return if (returnType == null) {
                parentMethod.setType("void")
                parentMethod to null
            } else
                CalledIntermediateDataOperationReturnTypeHandler().invoke(returnType, parentMethod)
        }
    }

    override fun execute(intermediateReturnType: IntermediateDataOperationReturnType, parentMethod: MethodDeclaration?)
        : Pair<MethodDeclaration, String?>? {
        require(parentMethod != null) { "Parent method must not be null" }

        val returnType = intermediateReturnType.type
        if (returnType == null) {
            parentMethod.setType("void")
            return parentMethod to null
        }

        val typeMapping = returnType.getTypeMapping()
        if (typeMapping != null) {
            val (mappedTypeName, isComplexTypeMapping, imports, dependencies) = typeMapping
            imports.forEach { parentMethod.addImport(it, ImportTargetElementType.METHOD) }
            parentMethod.addDependencies(dependencies)

            if (isComplexTypeMapping) {
                val fullyQualifiedClassname = (returnType as IntermediateComplexType).fullyQualifiedClassname
                val complexTypeFullyQualifiedName = "$currentDomainPackage.$fullyQualifiedClassname"
                parentMethod.addImport(complexTypeFullyQualifiedName, ImportTargetElementType.METHOD)
            }

            parentMethod.setType(mappedTypeName)
        } else
            parentMethod.setType("${returnType.name}_ExpectedFromGenlet")

        return parentMethod to null
    }
}