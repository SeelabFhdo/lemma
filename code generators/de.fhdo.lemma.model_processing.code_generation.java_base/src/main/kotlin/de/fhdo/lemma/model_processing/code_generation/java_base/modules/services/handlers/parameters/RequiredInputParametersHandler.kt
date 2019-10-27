package de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers.parameters

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.stmt.BlockStmt
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.buildRequiredInputParameterGuardName
import de.fhdo.lemma.model_processing.code_generation.java_base.getRequiredInputParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CallableCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.isNullable
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.service.intermediate.IntermediateParameter
import de.fhdo.lemma.technology.CommunicationType

/**
 * Called code generation handler for handling required input parameters of IntermediateOperation instances and the
 * specified [communicationType].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class RequiredInputParametersHandler(private val communicationType: CommunicationType)
    : CallableCodeGenerationHandlerI<IntermediateOperation, MethodDeclaration, ClassOrInterfaceDeclaration> {
    override fun handlesEObjectsOfInstance() = IntermediateOperation::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java
    override fun disableGenlets() = true

    companion object {
        /**
         * Convenience companion method to invoke the handler
         */
        fun invoke(operation: IntermediateOperation, parentClass: ClassOrInterfaceDeclaration,
            communicationType: CommunicationType)
            = RequiredInputParametersHandler(
            communicationType).invoke(operation, parentClass)
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(operation: IntermediateOperation, parentClass: ClassOrInterfaceDeclaration?)
        : Pair<MethodDeclaration, String?>? {
        /*
         * In case the operation is not implemented or does not have required input parameters of the given
         * communication type, no guard methods for checking required parameters will be generated and called
         */
        if (operation.isNotImplemented)
            return null

        val requiredParameters = operation.getRequiredInputParameters(communicationType)
        if (requiredParameters.isEmpty())
            return null

        /*
         * For the required input parameters of the given communication type, a single, private guard method will be
         * generated in the parent class of the operation. This guard method will check all nullable parameters for
         * their value. In case one of them is null, an exception is thrown.
         */
        val generatedMethod = MethodDeclaration()
        parentClass!!.addMember(generatedMethod)

        // Generate the guard's signature, including its parameters
        generatedMethod.isPrivate = true
        generatedMethod.setType("void")
        generatedMethod.setName(operation.buildRequiredInputParameterGuardName(communicationType))
        val nullableRequiredParameters = mutableListOf<IntermediateParameter>()
        requiredParameters.forEach {
            ParameterHandler.invoke(it, generatedMethod, true)
            if (it.type.isNullable)
                nullableRequiredParameters.add(it)
        }

        // The guard is to be removed upon relocation, i.e., won't be contained in custom implementation classes but
        // only their ("regenarable") superclasses
        generatedMethod.addSerializationCharacteristic(SerializationCharacteristic.REMOVE_ON_RELOCATION)

        // Generate the guard's body
        val methodBody = BlockStmt()
        if (nullableRequiredParameters.isNotEmpty())
            nullableRequiredParameters.forEach { methodBody.addStatement(
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