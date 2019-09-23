package de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.handlers

import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.body.Parameter
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependencies
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClassname
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CallableCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.getTypeMapping
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainContext.State as DomainState

@CodeGenerationHandler
internal class CalledIntermediateDataOperationParameterHandler
    : CallableCodeGenerationHandlerI<IntermediateDataOperationParameter, MethodDeclaration, MethodDeclaration> {
    private val currentDomainPackage: String by DomainState

    override fun handlesEObjectsOfInstance() = IntermediateDataOperationParameter::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java
    override fun getAspects(parameter: IntermediateDataOperationParameter) = parameter.aspects!!

    companion object {
        fun invoke(parameter: IntermediateDataOperationParameter, parentMethod: MethodDeclaration)
            = CalledIntermediateDataOperationParameterHandler().invoke(parameter, parentMethod)
    }

    override fun execute(parameter: IntermediateDataOperationParameter, parentMethod: MethodDeclaration?)
        : Pair<MethodDeclaration, String?>? {
        require(parentMethod != null) { "Parent method must not be null" }

        val generatedParameter = Parameter()
        generatedParameter.setName(parameter.name)

        val typeMapping = parameter.type.getTypeMapping()
        if (typeMapping != null) {
            val (mappedTypeName, isComplexTypeMapping, imports, dependencies) = typeMapping
            imports.forEach { parentMethod.addImport(it, ImportTargetElementType.METHOD) }
            parentMethod.addDependencies(dependencies)

            if (isComplexTypeMapping) {
                val fullyQualifiedClassname = (parameter.type as IntermediateComplexType).fullyQualifiedClassname
                val complexTypeFullyQualifiedName = "$currentDomainPackage.$fullyQualifiedClassname"
                parentMethod.addImport(complexTypeFullyQualifiedName, ImportTargetElementType.METHOD)
            }

            generatedParameter.setType(mappedTypeName)
        } else
            generatedParameter.setType("${parameter.type.name}_ExpectedFromGenlet")

        parentMethod.addParameter(generatedParameter)
        return parentMethod to null
    }
}