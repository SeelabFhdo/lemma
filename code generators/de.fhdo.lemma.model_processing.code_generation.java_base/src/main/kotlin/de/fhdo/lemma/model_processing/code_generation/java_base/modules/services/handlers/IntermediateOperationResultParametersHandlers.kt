package de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.comments.LineComment
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addBodyComment
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependencies
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.buildCompositeClassName
import de.fhdo.lemma.model_processing.code_generation.java_base.buildFullyQualifiedCompositeClassName
import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClassname
import de.fhdo.lemma.model_processing.code_generation.java_base.getResultParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CallableCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.VisitingCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.hasCompositeResult
import de.fhdo.lemma.model_processing.code_generation.java_base.hasResultParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.getTypeMapping
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainContext.State as DomainState
import de.fhdo.lemma.model_processing.code_generation.java_base.toCompositeClass
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.technology.CommunicationType

@CodeGenerationHandler
internal open class CalledIntermediateOperationResultParametersHandler
    : CallableCodeGenerationHandlerI<IntermediateOperation, MethodDeclaration, MethodDeclaration> {
    companion object {
        fun invoke(operation: IntermediateOperation, generatedMethod: MethodDeclaration?)
            = CalledIntermediateOperationResultParametersHandler().invoke(operation, generatedMethod)
    }

    private val currentDomainPackage: String by DomainState

    override fun handlesEObjectsOfInstance() = IntermediateOperation::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java

    // Disable treatment of output parameters. They should be treated by Genlets targeting the EObject-node-combination
    // IntermediateOperation to MethodDeclaration, i.e., when the return type of the method was eventually determined.
    override fun disableGenlets() = true

    override fun execute(operation: IntermediateOperation, context: MethodDeclaration?)
        : Pair<MethodDeclaration, String?>? {
        val generatedMethod = context!!

        if (operation.hasResultParameters(CommunicationType.ASYNCHRONOUS)) {
            val compositeResultClass = operation.buildCompositeClassName(CommunicationType.ASYNCHRONOUS, true)
            generatedMethod.addBodyComment(LineComment(
                "TODO Method should asynchronously return one or more instances of $compositeResultClass"
            ))
        }

        if (!operation.hasResultParameters(CommunicationType.SYNCHRONOUS)) {
            // Asynchronous output parameters are never returned directly
            generatedMethod.setType("void")
            return generatedMethod to null
        }

        if (operation.hasCompositeResult(CommunicationType.SYNCHRONOUS)) {
            generatedMethod.setType(operation.buildCompositeClassName(CommunicationType.SYNCHRONOUS, true))
            generatedMethod.addImport(
                operation.buildFullyQualifiedCompositeClassName(CommunicationType.SYNCHRONOUS, true),
                ImportTargetElementType.METHOD
            )
        } else {
            val singleResultParameter = operation.getResultParameters(CommunicationType.SYNCHRONOUS)[0]
            generatedMethod.setType(determineType(singleResultParameter.type, generatedMethod))
        }

        return generatedMethod to null
    }

    private fun determineType(intermediateType: IntermediateType, generatedMethod: MethodDeclaration) : String {
        val typeMapping = intermediateType.getTypeMapping()
        return if (typeMapping != null) {
            val (mappedTypeName, isComplexTypeMapping, imports, dependencies) = typeMapping
            imports.forEach { generatedMethod.addImport(it, ImportTargetElementType.ATTRIBUTE_TYPE) }
            generatedMethod.addDependencies(dependencies)

            if (isComplexTypeMapping) {
                val fullyQualifiedClassname = (intermediateType as IntermediateComplexType).fullyQualifiedClassname
                val complexTypeFullyQualifiedName = "$currentDomainPackage.$fullyQualifiedClassname"
                generatedMethod.addImport(complexTypeFullyQualifiedName, ImportTargetElementType.METHOD)
            }

            mappedTypeName
        } else
            "${intermediateType.name}_ExpectedFromGenlet"
    }
}

@CodeGenerationHandler
internal class IntermediateOperationCompositeResultHandlerSync
    : IntermediateOperationCompositeResultHandlerBase(CommunicationType.SYNCHRONOUS)

@CodeGenerationHandler
internal class IntermediateOperationCompositeResultHandlerAsync
    : IntermediateOperationCompositeResultHandlerBase(CommunicationType.ASYNCHRONOUS)

internal open class IntermediateOperationCompositeResultHandlerBase(private val communicationType: CommunicationType)
    : VisitingCodeGenerationHandlerI<IntermediateOperation, ClassOrInterfaceDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateOperation::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java

    override fun execute(operation: IntermediateOperation, context: Nothing?)
        : Pair<ClassOrInterfaceDeclaration, String?>? {
        val generateCompositeClass = when(communicationType) {
            CommunicationType.SYNCHRONOUS -> operation.hasCompositeResult(CommunicationType.SYNCHRONOUS)

            // Always build result class for asynchronous output parameters
            CommunicationType.ASYNCHRONOUS -> operation.hasResultParameters(CommunicationType.ASYNCHRONOUS)
        }

        return if (generateCompositeClass)
                operation.getResultParameters(communicationType).toCompositeClass(communicationType, true)
            else
                null
    }
}