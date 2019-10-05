package de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.stmt.BlockStmt
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.getRequiredInputParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CallableCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.isNullable
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.technology.CommunicationType

@CodeGenerationHandler
internal class CalledRequiredIntermediateOperationHandler(private val communicationType: CommunicationType)
    : CallableCodeGenerationHandlerI<IntermediateOperation, MethodDeclaration, ClassOrInterfaceDeclaration> {
    companion object {
        fun invoke(operation: IntermediateOperation, parentClass: ClassOrInterfaceDeclaration,
            communicationType: CommunicationType)
            = CalledRequiredIntermediateOperationHandler(communicationType).invoke(operation, parentClass)

        fun IntermediateOperation.buildCheckMethodName(communicationType: CommunicationType) : String {
            val prefix = if (communicationType == CommunicationType.ASYNCHRONOUS) "Async" else ""
            return "checkRequired${prefix}ParametersOf${name.capitalize()}"
        }
    }

    override fun handlesEObjectsOfInstance() = IntermediateOperation::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java
    override fun disableGenlets() = true

    override fun execute(operation: IntermediateOperation, parentClass: ClassOrInterfaceDeclaration?)
        : Pair<MethodDeclaration, String?>? {
        if (operation.isNotImplemented)
            return null

        val requiredParameters = operation.getRequiredInputParameters(communicationType)
        if (requiredParameters.isEmpty())
            return null

        val generatedMethod = MethodDeclaration()
        parentClass!!.addMember(generatedMethod)

        generatedMethod.isPrivate = true
        generatedMethod.setType("void")
        generatedMethod.setName(operation.buildCheckMethodName(communicationType))
        requiredParameters.forEach { CalledIntermediateParameterHandler.invoke(it, generatedMethod, true) }
        generatedMethod.addSerializationCharacteristic(SerializationCharacteristic.REMOVE_ON_RELOCATION)

        val methodBody = BlockStmt()
        if (requiredParameters.isNotEmpty())
            requiredParameters.filter { it.type.isNullable }.forEach {methodBody.addStatement(
                """
                    |if (${it.name} == null)
                    |   throw new IllegalArgumentException("Required parameter \"${it.name}\" must not be null");
                """.trimMargin()
            ) }
        else
            methodBody.addStatement("// NOOP: Operation ${operation.name} has no nullable parameters")

        generatedMethod.setBody(methodBody)
        return generatedMethod to null
    }
}