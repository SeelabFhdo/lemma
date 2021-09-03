package de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers.operations

import com.github.javaparser.ast.DataKey
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.body.Parameter
import com.github.javaparser.ast.comments.LineComment
import de.fhdo.lemma.java.ast.utils.ImportTargetElementType
import de.fhdo.lemma.java.ast.utils.addBodyComment
import de.fhdo.lemma.java.ast.utils.addThrownException
import de.fhdo.lemma.java.ast.utils.hasEmptyBody
import de.fhdo.lemma.java.ast.utils.insertStatement
import de.fhdo.lemma.java.ast.utils.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addSerializationCharacteristics
import de.fhdo.lemma.model_processing.code_generation.java_base.buildCompositeClassName
import de.fhdo.lemma.model_processing.code_generation.java_base.buildExceptionClassName
import de.fhdo.lemma.model_processing.code_generation.java_base.buildFullyQualifiedCompositeClassName
import de.fhdo.lemma.model_processing.code_generation.java_base.buildFullyQualifiedExceptionClassName
import de.fhdo.lemma.model_processing.code_generation.java_base.buildRequiredInputParameterGuardName
import de.fhdo.lemma.model_processing.code_generation.java_base.getFaultParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.getInputParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.getRequiredInputParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.getResultParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CallableCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.invokeCodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.hasAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.hasCompositeResult
import de.fhdo.lemma.model_processing.code_generation.java_base.hasInputParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.hasRequiredInputParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.hasResultParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.getBasicType
import de.fhdo.lemma.model_processing.code_generation.java_base.languages.setJavaTypeFrom
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers.parameters.ParameterHandler
import de.fhdo.lemma.model_processing.utils.trimToSingleLine
import de.fhdo.lemma.service.Visibility
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.technology.CommunicationType

/**
 * Called code generation handler for IntermediateOperation instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class OperationHandler
    : CallableCodeGenerationHandlerI<IntermediateOperation, MethodDeclaration, ClassOrInterfaceDeclaration> {
    override fun handlesEObjectsOfInstance() = IntermediateOperation::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java
    override fun getAspects(eObject: IntermediateOperation) = eObject.aspects!!

    companion object {
        /**
         * Convenience companion method to invoke the handler
         */
        fun invoke(operation: IntermediateOperation, parentClass: ClassOrInterfaceDeclaration)
            = invokeCodeGenerationHandler(OperationHandler(), operation, parentClass)
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: IntermediateOperation, context: ClassOrInterfaceDeclaration?)
        : Pair<MethodDeclaration, String?>? {
        /* Each IntermediateOperation will become a method in the given parent class */
        val generatedMethod = MethodDeclaration()
        context!!.addMember(generatedMethod)
        generatedMethod.setName(eObject.name)
        generatedMethod.setVisibility(eObject.visibility)

        /* Generate method parameters from input IntermediateParameters */
        eObject.getInputParameters().forEach { ParameterHandler.invoke( it, generatedMethod) }

        /*
         * Handle asynchronous input parameters. If the method does not have additional synchronous input parameters, it
         * will keep a single asynchronous input parameter. In case the method has more than one asynchronous input
         * parameter, it will be replaced by a composite POJO that holds fields, getters, and setters for all
         * asynchronous input parameters.
         *
         * If the method has both, synchronous and asynchronous input parameters, the asynchronous parameters will be
         * removed from the signature. Semantically, this means that the method can only be invoked if all required
         * synchronous input parameters were passed and it has to fetch the asynchronous input parameter or the
         * composite class on its own during its execution.
         */
        if (eObject.hasInputParameters(CommunicationType.ASYNCHRONOUS))
            handleAsynchronousInputParameters(eObject, generatedMethod)

        /*
         * Handle synchronous fault parameters (currently we only support synchronous ones). For each fault parameter,
         * a thrown Exception will be added to the generated method. The Exception class itself is then generated by
         * the FaultParameterHandler.
         */
        handleSynchronousFaultParameters(eObject, generatedMethod)

        /* Handle non-fault result parameters */
        handleResultParameters(eObject, generatedMethod)

        /* Set the body of the generated method. This needs to be done here, because asynchronous parameters might have
         * been turned to composite ones (see above) and thus the original method signature might have been changed.
         */
        generatedMethod.generateBody(eObject)

        return generatedMethod to null
    }

    /**
     * Helper to set the visibility of the generated [MethodDeclaration] depending on the IntermediateOperation's
     * [visibility]
     */
    private fun MethodDeclaration.setVisibility(visibility: String)
        = when(visibility) {
            Visibility.NONE.name, Visibility.PUBLIC.name -> isPublic = true
            Visibility.ARCHITECTURE.name -> isProtected = true
            else -> isPrivate = true
        }

    /**
     * Helper to deal with asynchronous input parameters in the given intermediate [operation]
     */
    private fun handleAsynchronousInputParameters(operation: IntermediateOperation, method: MethodDeclaration) {
        /* Get all generated asynchronous input parameters from the generated method */
        val asynchronousInputParameters = operation.getInputParameters(CommunicationType.ASYNCHRONOUS)
            .map { p -> method.parameters.find { it.nameAsString == p.name }!! }

        /*
         * If the method is not meant to have asynchronous input parameters in its signature, remove the ones which
         * have already been generated
         */
        if (!operation.hasAsynchronousParametersInSignature()) {
            asynchronousInputParameters.forEach { method.remove(it) }
            val compositeClassName = operation.buildCompositeClassName(CommunicationType.ASYNCHRONOUS)
            method.addBodyComment(
                LineComment("TODO Method may asynchronously receive one or more instances of $compositeClassName")
            )

            return
        }

        /*
         * If the method is meant to have asynchronous input parameters in its signature and has only a single
         * asynchronous input parameters, this will simply stick to the method
         */
        if (asynchronousInputParameters.size == 1)
            return

        /*
         * The method is meant to have asynchronous input parameters in its signature and has several asynchronous
         * input parameters. In this case they will be replaced with a single parameter that is typed by a composite
         * POJO class generated from the parameters. The generation of this class is done by
         * AsynchronousInputParametersHandler.
         */
        // Add import for the composite class
        method.addImport(
            operation.buildFullyQualifiedCompositeClassName(CommunicationType.ASYNCHRONOUS),
            ImportTargetElementType.METHOD
        )

        // Replace asynchronous input parameters with composite parameter
        val compositeClassName = operation.buildCompositeClassName(CommunicationType.ASYNCHRONOUS)
        method.addCompositeParameter(compositeClassName, compositeClassName.decapitalize(),
            CommunicationType.ASYNCHRONOUS, asynchronousInputParameters)
    }

    /**
     * A method generated from this [IntermediateOperation] will have asynchronous parameters in its signature when it
     * comprises asynchronous and no synchronous input parameters. That is, service operations having both types of
     * input parameters will keep their synchronous ones, because the semantics goes that such a method needs to be
     * synchronously invoked and may receive data asynchronously while its being executed.
     */
    private fun IntermediateOperation.hasAsynchronousParametersInSignature()
        = hasInputParameters(CommunicationType.ASYNCHRONOUS) && !hasInputParameters(CommunicationType.SYNCHRONOUS)

    /**
     * Helper to handle synchronous fault parameters
     */
    private fun handleSynchronousFaultParameters(operation: IntermediateOperation, generatedMethod: MethodDeclaration) {
        operation.getFaultParameters(CommunicationType.SYNCHRONOUS).forEach {
            generatedMethod.addImport(it.buildFullyQualifiedExceptionClassName(), ImportTargetElementType.METHOD)
            generatedMethod.addThrownException(it.buildExceptionClassName())
        }

        // Fault parameters for which no custom Exception class is generated are to be treated by Genlets
        operation.getFaultParameters(CommunicationType.SYNCHRONOUS, withCustomExceptionClass = false).forEach {
            ParameterHandler.invoke(it, generatedMethod)
        }
    }

    /**
     * Helper to handle non-fault result parameters
     */
    private fun handleResultParameters(operation: IntermediateOperation, generatedMethod: MethodDeclaration) {
        /*
         * Asynchronous result parameters always become a composite class (cf.
         * AsynchronousCompositeResultParametersHandler)
         */
        if (operation.hasResultParameters(CommunicationType.ASYNCHRONOUS)) {
            val compositeResultClass = operation.buildCompositeClassName(CommunicationType.ASYNCHRONOUS, true)
            generatedMethod.addBodyComment(LineComment(
                "TODO Method should asynchronously return one or more instances of $compositeResultClass"
            ))
        }

        /*
         * Return type of method is void, in case no synchronous result parameters were modeled. Asynchronous result
         * parameters are never returned directly
         */
        if (!operation.hasResultParameters(CommunicationType.SYNCHRONOUS)) {
            generatedMethod.setType("void")
            return
        }

        /* Add import of java.util.Set in case one of the synchronous result parameters exhibits the java.Set aspect */
        val resultIsSet = operation.getResultParameters(CommunicationType.SYNCHRONOUS).any { it.hasAspect("java.Set") }
        if (resultIsSet)
            generatedMethod.addImport("java.util.Set", ImportTargetElementType.METHOD)

        /* Turn more than one synchronous result parameter into a composite return type */
        if (operation.hasCompositeResult(CommunicationType.SYNCHRONOUS)) {
            val returnType = operation.buildCompositeClassName(CommunicationType.SYNCHRONOUS, true)
            if (resultIsSet)
                generatedMethod.setType("Set<$returnType>")
            else
                generatedMethod.setType(returnType)

            generatedMethod.addImport(
                operation.buildFullyQualifiedCompositeClassName(CommunicationType.SYNCHRONOUS, true),
                ImportTargetElementType.METHOD
            )

            return
        }

        /* The operation has exactly one synchronous result parameter */
        val resultParameter = operation.getResultParameters(CommunicationType.SYNCHRONOUS)[0]

        // If the result is a Set, we use the basic type of the intermediate return type as the Sets type parameter
        val returnType = if (resultIsSet)
                resultParameter.type.getBasicType() ?: resultParameter.type
            else
                resultParameter.type

        generatedMethod.setJavaTypeFrom(returnType, generatedMethod) {
            generatedMethod.addImport(it, ImportTargetElementType.METHOD)
        }

        if (resultIsSet)
            generatedMethod.setType("Set<${generatedMethod.typeAsString}>")
    }

    /**
     * Generate the body of the method
     */
    private fun MethodDeclaration.generateBody(operation: IntermediateOperation) {
        /* Handle "not implemented" case */
        if (operation.isNotImplemented) {
            isFinal = !isPrivate
            setBody(
                """
                    throw new UnsupportedOperationException("This service operation is not implemented")
                """.trimToSingleLine()
            )
            return
        }

        /* Add guard call for required synchronous input parameters */
        addRequiredInputParametersCheck(operation, CommunicationType.SYNCHRONOUS)

        /*
         * A guard call for required asynchronous input parameters will only be added, if the signature of the
         * generated method actually comprises such parameters. If otherwise the original operation defines required
         * asynchronous input parameters, without those having been added to the signature of the generated method,
         * a hinting comment that still the guard method was generated and may be invoked on eventually received
         * asynchronous data.
         */
        if (operation.hasAsynchronousParametersInSignature())
            addRequiredInputParametersCheck(operation, CommunicationType.ASYNCHRONOUS)
        else if (operation.hasRequiredInputParameters(CommunicationType.ASYNCHRONOUS))
            addBodyComment(LineComment(" " +
                """
                    TODO Use ${operation.buildRequiredInputParameterGuardName(CommunicationType.ASYNCHRONOUS)} if you
                    want to check for the existence of mandatory asynchronous input parameters as soon as they are
                    available from asynchronous interactions
                """.trimToSingleLine(preserveTrailingWhitespaces = true)
            ))
    }

    /**
     * Helper to add a call to the guard method for checking the existence of required input parameters of the
     * given [communicationType] to this method's body
     */
    private fun MethodDeclaration.addRequiredInputParametersCheck(operation: IntermediateOperation,
        communicationType: CommunicationType) {
        if (!operation.hasRequiredInputParameters(communicationType))
            return

        val requiredParametersNames = operation.getRequiredInputParameters(communicationType).map { it.name }
        val parametersToCompositeParameters = getParametersToCompositeParameters(communicationType)
        val parametersString = requiredParametersNames.joinToString {
            val compositeParameterName = parametersToCompositeParameters[it]
            // In case the original parameter was replaced by a composite one, prefix it in the call to the guard with
            // the name of the composite class parameter and the call to the corresponding getter in the composite class
            compositeParameterName?.plus(".get${it.capitalize()}()") ?: it
        }

        val callStatement = "${operation.buildRequiredInputParameterGuardName(communicationType)}($parametersString)"
        if (hasEmptyBody) {
            //TODO: add new Body
            val characteristics = listOf<SerializationCharacteristic>(SerializationCharacteristic.MERGE_ON_RELOCATION)
            val body = setBody(callStatement)
            body.addSerializationCharacteristics(characteristics)
        }
        else
            insertStatement("$callStatement;", 1)
    }
}

/**
 * Replace the given list of parameters in the signature of this method with a composite [Parameter] of the specified
 * [type] and [name].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun MethodDeclaration.addCompositeParameter(type: String, name: String, communicationType: CommunicationType,
    replacedParameters: List<Parameter>) : Parameter {
    replacedParameters.forEach { remove(it) }
    val compositeParameter = addAndGetParameter(type, name)
    compositeParameter.markAsCompositeParameterFor(communicationType, replacedParameters)
    return compositeParameter
}

/**
 * Mark this [Parameter] as being a composite parameter that replaced the previously existing list of
 * [replacedParameters] in its defining method.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun Parameter.markAsCompositeParameterFor(communicationType: CommunicationType,
    replacedParameters: List<Parameter>)
        = setData(CompositeParameterDataKey, communicationType to replacedParameters.map { it.nameAsString })

/**
 * Data key for composite parameters of generated methods.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private object CompositeParameterDataKey : DataKey<Pair<CommunicationType, List<String>>>()

/**
 * Verify if this [Parameter] is a composite [Parameter] for the given [communicationType]. If no [communicationType] is
 * passed, this function returns true when the [Parameter] exhibits the [CompositeParameterDataKey], independent of its
 * assigned communication type.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun Parameter.isCompositeParameter(communicationType: CommunicationType? = null) : Boolean {
    if (!containsData(CompositeParameterDataKey))
        return false
    else if (communicationType == null)
        return true

    val (parameterCommunicationType, _) = getData(CompositeParameterDataKey)
    return parameterCommunicationType == communicationType
}

/**
 * Get all composite parameters of this [MethodDeclaration].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun MethodDeclaration.getCompositeParameters(communicationType: CommunicationType? = null)
    = parameters.filter {
        it.isCompositeParameter() &&
        (communicationType == null || it.getData(CompositeParameterDataKey).first == communicationType)
    }

/**
 * Get a map that assigns to each replaced parameter of this [MethodDeclaration] the name of the composite parameter by
 * which it was replaced.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun MethodDeclaration.getParametersToCompositeParameters(communicationType: CommunicationType? = null)
    : Map<String, String> {
    val compositeParameters = getCompositeParameters(communicationType)
    if (compositeParameters.isEmpty())
        return emptyMap()

    val resultMap = mutableMapOf<String, String>()
    compositeParameters.forEach { compositeParameter ->
        compositeParameter.getReplacedParameterNames().forEach { resultMap[it] = compositeParameter.nameAsString }
    }

    return resultMap
}

/**
 * If this [Parameter] is a composite parameter, retrieve a list of the names of the parameters it replaced. Returns an
 * empty list in case this [Parameter] is not a composite parameter.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun Parameter.getReplacedParameterNames()
    = if (isCompositeParameter())
            getData(CompositeParameterDataKey).second
        else
            emptyList()