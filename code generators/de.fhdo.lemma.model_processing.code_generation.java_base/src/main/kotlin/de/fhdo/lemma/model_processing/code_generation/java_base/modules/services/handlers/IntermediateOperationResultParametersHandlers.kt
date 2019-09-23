package de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.data.intermediate.IntermediateType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addAttribute
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addDependencies
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addGetter
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSetter
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.newJavaClassOrInterface
import de.fhdo.lemma.model_processing.code_generation.java_base.classname
import de.fhdo.lemma.model_processing.code_generation.java_base.fullyQualifiedClassname
import de.fhdo.lemma.model_processing.code_generation.java_base.getResultParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CallableCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.VisitingCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.hasCompositeResult
import de.fhdo.lemma.model_processing.code_generation.java_base.hasSingleResult
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.getTypeMapping
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers.IntermediateOperationCompositeResultHandlerBase.Companion.buildCompositeResultClassFullyQualifiedName
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers.IntermediateOperationCompositeResultHandlerBase.Companion.buildCompositeResultClassName
import de.fhdo.lemma.model_processing.utils.packageToPath
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.ServicesContext.State as ServicesState
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainContext.State as DomainState
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.service.intermediate.IntermediateParameter
import de.fhdo.lemma.technology.CommunicationType
import java.io.File

@CodeGenerationHandler
internal class CalledIntermediateOperationResultParametersHandlerSync
    : CalledIntermediateOperationResultParametersHandlerBase(CommunicationType.SYNCHRONOUS)

@CodeGenerationHandler
internal class CalledIntermediateOperationResultParametersHandlerAsync
    : CalledIntermediateOperationResultParametersHandlerBase(CommunicationType.ASYNCHRONOUS)

internal open class CalledIntermediateOperationResultParametersHandlerBase
    (private val communicationType: CommunicationType)
    : CallableCodeGenerationHandlerI<IntermediateParameter, MethodDeclaration,
        Pair<IntermediateOperation, MethodDeclaration>> {
    private val currentDomainPackage: String by DomainState

    override fun handlesEObjectsOfInstance() = IntermediateParameter::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java
    override fun getAspects(resultParameter: IntermediateParameter) = resultParameter.aspects!!

    override fun execute(resultParameter: IntermediateParameter,
        methodGenerationInputOutput: Pair<IntermediateOperation, MethodDeclaration>?)
        : Pair<MethodDeclaration, String?>? {
        val (operation, generatedMethod) = methodGenerationInputOutput!!
        if (operation.hasCompositeResult(communicationType)) {
            generatedMethod.setType(buildCompositeResultClassName(operation, communicationType))
            generatedMethod.addImport(buildCompositeResultClassFullyQualifiedName(operation, communicationType),
                ImportTargetElementType.METHOD)
        } else if (operation.hasSingleResult(communicationType))
            generatedMethod.setType(determineType(resultParameter.type, generatedMethod))

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
    private val interfaceSubFolderName: String by ServicesState

    override fun handlesEObjectsOfInstance() = IntermediateOperation::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java

    companion object {
        private val currentInterfacesGenerationPackage: String by ServicesState
        private val currentDomainPackage: String by DomainState

        fun buildCompositeResultClassName(operation: IntermediateOperation, communicationType: CommunicationType)
            : String {
            val communicationTypeIdentifier = when(communicationType) {
                CommunicationType.ASYNCHRONOUS -> "Async"
                CommunicationType.SYNCHRONOUS -> ""
            }

            return "${operation.classname}${communicationTypeIdentifier}Result"
        }

        fun buildCompositeResultClassFullyQualifiedName(operation: IntermediateOperation,
            communicationType: CommunicationType) : String {
            return "${buildCompositeResultClassPackage(operation)}." +
                buildCompositeResultClassName(operation, communicationType)
        }

        fun buildCompositeResultClassPackage(operation: IntermediateOperation)
            = "$currentInterfacesGenerationPackage.${buildCompositeResultClassSubPackage(operation)}"

        private fun buildCompositeResultClassSubPackage(operation: IntermediateOperation) : String {
            val interfaceName = operation.`interface`.name
            return "operations.$interfaceName.${operation.name}"
        }
    }

    override fun execute(operation: IntermediateOperation, context: Nothing?)
        : Pair<ClassOrInterfaceDeclaration, String?>? {
        val packageName = buildCompositeResultClassPackage(operation)
        val classname = buildCompositeResultClassName(operation, communicationType)
        val generatedClass = newJavaClassOrInterface(packageName, classname)

        if (!operation.hasCompositeResult(communicationType))
            return generatedClass to null

        val compositeResultParameters = operation.getResultParameters(communicationType)
        compositeResultParameters.forEach { parameter ->
            val typeMapping = parameter.type.getTypeMapping()
            val parameterType = if (typeMapping != null) {
                val (mappedTypeName, isComplexTypeMapping, imports, dependencies) = typeMapping
                imports.forEach { generatedClass.addImport(it, ImportTargetElementType.ATTRIBUTE_TYPE) }
                generatedClass.addDependencies(dependencies)

                if (isComplexTypeMapping) {
                    val fullyQualifiedClassname = (parameter.type as IntermediateComplexType).fullyQualifiedClassname
                    val complexTypeFullyQualifiedName = "$currentDomainPackage.$fullyQualifiedClassname"
                    generatedClass.addImport(complexTypeFullyQualifiedName, ImportTargetElementType.METHOD)
                }

                mappedTypeName
            } else
                "${parameter.type.name}_ExpectedFromGenlet"

            val parameterAttribute = generatedClass.addAttribute(parameter.name, parameterType,
                Modifier.Keyword.PRIVATE)
            generatedClass.addSetter(parameterAttribute)
            generatedClass.addGetter(parameterAttribute)
        }

        val operationSubFolder = buildCompositeResultClassSubPackage(operation).packageToPath()
        val generatedFilePath = listOf(interfaceSubFolderName, operationSubFolder, "$classname.java")
            .joinToString(File.separator)
        return generatedClass to generatedFilePath
    }
}