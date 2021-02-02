package de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers.parameters

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.body.Parameter
import com.github.javaparser.ast.stmt.BlockStmt
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getImportsInfo
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.isGenericType
import de.fhdo.lemma.model_processing.code_generation.java_base.buildRequiredInputParameterGuardName
import de.fhdo.lemma.model_processing.code_generation.java_base.getRequiredInputParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CallableCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.invokeCodeGenerationHandler
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
            = invokeCodeGenerationHandler(RequiredInputParametersHandler(communicationType), operation, parentClass)
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: IntermediateOperation, context: ClassOrInterfaceDeclaration?)
        : Pair<MethodDeclaration, String?>? {
        /*
         * In case the operation is not implemented or does not have required input parameters of the given
         * communication type, no guard methods for checking required parameters will be generated and called
         */
        if (eObject.isNotImplemented)
            return null

        val requiredParameters = eObject.getRequiredInputParameters(communicationType)
        if (requiredParameters.isEmpty())
            return null

        /*
         * For the required input parameters of the given communication type, a single, private guard method will be
         * generated in the parent class of the operation. This guard method will check all nullable parameters for
         * their value. In case one of them is null, an exception is thrown.
         */
        val guardMethod = MethodDeclaration()
        context!!.addMember(guardMethod)

        // Generate the guard's signature, including its parameters
        guardMethod.isPrivate = true
        guardMethod.setType("void")
        guardMethod.setName(eObject.buildRequiredInputParameterGuardName(communicationType))
        val nullableRequiredParameters = mutableListOf<IntermediateParameter>()
        requiredParameters.forEach {
            guardMethod.addGuardParameterFor(it)

            if (it.type.isNullable)
                nullableRequiredParameters.add(it)
        }

        // The guard is to be removed upon relocation, i.e., won't be contained in custom implementation classes but
        // only their ("regenarable") superclasses
        guardMethod.addSerializationCharacteristic(SerializationCharacteristic.REMOVE_ON_RELOCATION)

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
            methodBody.addStatement("// NOOP: Operation ${eObject.name} has no nullable parameters")

        guardMethod.setBody(methodBody)
        return guardMethod to null
    }

    /**
     * Helper to add a parameter to this [MethodDeclaration], which represents a guard method
     */
    private fun MethodDeclaration.addGuardParameterFor(intermediateParameter: IntermediateParameter) {
        /*
         * In order to retrieve the possible Genlet-specific type of the given intermediate parameter, we create a fake
         * guard method from this guard. It is passed to the ParameterHandler together with the given intermediate
         * parameter, which then produces a parameter with a type that may be Genlet-specific, because ParameterHandler
         * eventually delegates generation to Genlets. We leverage a fake guard for this purpose, because we don't want
         * this guard to be bloated by additional Genlet-specific imports that may target parameter annotations, which
         * are irrelevant for a simple guard method.
         */
        val fakeGuard = MethodDeclaration()
        fakeGuard.isPrivate = isPrivate
        fakeGuard.setType(typeAsString)
        fakeGuard.setName(nameAsString)
        val (generatedFakeGuard, _) = ParameterHandler.invoke(intermediateParameter, fakeGuard)!!
        val generatedFakeParameter = generatedFakeGuard.parameters.first {
            it.nameAsString == intermediateParameter.name
        }

        /*
         * From the generated fake parameter, which might have a Genlet-specific type, we retrieve the main type and
         * possible type arguments (in case the main type is a generic type)
         */
        val generatedFakeParameterType = generatedFakeParameter.type
        val (parameterType, typeArguments) = if (generatedFakeParameterType.isGenericType()) {
                val mainType = generatedFakeParameterType.toClassOrInterfaceType().get()
                mainType.nameAsString to mainType.typeArguments.get().map { it.asString() }
            } else
                generatedFakeParameterType.asString() to emptyList()

        /*
         * Add all imports related to the parameter's main type and its type arguments to this guard. That is, all
         * other imports of the parameter, which are not directly related to its type, are ignored.
         */
        generatedFakeGuard.getImportsInfo().forEach {
            val importedElement = it.import.substringAfterLast(".")
            if (importedElement == parameterType || importedElement in typeArguments)
                addImport(it.import, ImportTargetElementType.METHOD)
        }

        /* Generate guard parameter from the fake parameter that only has a name and type */
        addParameter(Parameter(generatedFakeParameterType, generatedFakeParameter.name))
    }
}