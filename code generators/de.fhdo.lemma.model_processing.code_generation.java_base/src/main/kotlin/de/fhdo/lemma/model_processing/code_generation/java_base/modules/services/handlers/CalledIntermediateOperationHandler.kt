package de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.getInputParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.getRequiredInputParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.getResultParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CallableCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.hasParametersOfCommunicationType
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers.CalledRequiredIntermediateOperationHandler.Companion.buildCheckMethodName
import de.fhdo.lemma.model_processing.utils.trimToSingleLine
import de.fhdo.lemma.service.Visibility
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.technology.CommunicationType

@CodeGenerationHandler
internal class CalledIntermediateOperationHandlerSync {
    companion object {
        fun invoke(operation: IntermediateOperation, parentClass: ClassOrInterfaceDeclaration)
            = CalledIntermediateOperationHandlerBase(CommunicationType.SYNCHRONOUS).invoke(operation, parentClass)
    }
}

@CodeGenerationHandler
internal class CalledIntermediateOperationHandlerAsync {
    companion object {
        fun invoke(operation: IntermediateOperation, parentClass: ClassOrInterfaceDeclaration)
            = CalledIntermediateOperationHandlerBase(CommunicationType.ASYNCHRONOUS).invoke(operation, parentClass)
    }
}

@CodeGenerationHandler
internal class CalledIntermediateOperationHandlerBase(private val communicationType: CommunicationType)
    : CallableCodeGenerationHandlerI<IntermediateOperation, MethodDeclaration, ClassOrInterfaceDeclaration> {
    override fun handlesEObjectsOfInstance() = IntermediateOperation::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java
    override fun getAspects(operation: IntermediateOperation) = operation.aspects!!

    override fun execute(operation: IntermediateOperation, parentClass: ClassOrInterfaceDeclaration?)
        : Pair<MethodDeclaration, String?>? {
        if (communicationType == CommunicationType.ASYNCHRONOUS &&
            !operation.hasParametersOfCommunicationType(CommunicationType.ASYNCHRONOUS))
            return null

        val generatedMethod = MethodDeclaration()
        parentClass!!.addMember(generatedMethod)

        val resultParametersHandler = when(communicationType) {
            CommunicationType.ASYNCHRONOUS -> {
                generatedMethod.setName("${operation.name}Async")
                CalledIntermediateOperationResultParametersHandlerAsync()
            }

            CommunicationType.SYNCHRONOUS -> {
                generatedMethod.setName(operation.name)
                CalledIntermediateOperationResultParametersHandlerSync()
            }
        }

        operation.getResultParameters(communicationType).forEach {
            resultParametersHandler.invoke(it, operation to generatedMethod)
        }

        when(operation.visibility) {
            Visibility.NONE, Visibility.PUBLIC -> generatedMethod.isPublic = true
            Visibility.ARCHITECTURE -> generatedMethod.isProtected = true
            Visibility.INTERNAL -> generatedMethod.isPrivate = true
        }

        operation.getInputParameters(communicationType).forEach {
            CalledIntermediateParameterHandler.invoke(it, generatedMethod)
        }

        if (!generatedMethod.isPrivate && operation.isNotImplemented) {
            generatedMethod.isFinal = true
            generatedMethod.setBody(
                """
                    throw new UnsupportedOperationException("This service operation is not implemented");
                """.trimToSingleLine()
            )
        } else {
            val requiredParameters = operation.getRequiredInputParameters(CommunicationType.SYNCHRONOUS)
            if (requiredParameters.isNotEmpty()) {
                val requiredParametersCheckMethod = operation.buildCheckMethodName()
                val requiredParametersString = requiredParameters.joinToString() { it.name }
                generatedMethod.setBody(
                    """
                        $requiredParametersCheckMethod($requiredParametersString);
                    """.trimToSingleLine(),
                    characteristics = *arrayOf(SerializationCharacteristic.MERGE_ON_RELOCATION)
                )
            }
        }

        return generatedMethod to null
    }
}