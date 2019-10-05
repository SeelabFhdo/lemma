package de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers

import com.github.javaparser.StaticJavaParser
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import com.github.javaparser.ast.comments.LineComment
import com.github.javaparser.ast.stmt.BlockStmt
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.ImportTargetElementType
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.SerializationCharacteristic
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addBodyComment
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addCompositeParameter
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.addImport
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.emptyBody
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getCompositeParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getParametersToCompositeParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.getReplacedParameterNames
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.insertStatement
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.isCompositeParameter
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.buildCompositeClassName
import de.fhdo.lemma.model_processing.code_generation.java_base.buildFullyQualifiedCompositeClassName
import de.fhdo.lemma.model_processing.code_generation.java_base.buildOperationPackageName
import de.fhdo.lemma.model_processing.code_generation.java_base.classname
import de.fhdo.lemma.model_processing.code_generation.java_base.getFaultParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.getInputParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.getRequiredInputParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.getResultParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CallableCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.VisitingCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.hasInputParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.hasRequiredInputParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers.CalledRequiredIntermediateOperationHandler.Companion.buildCheckMethodName
import de.fhdo.lemma.model_processing.code_generation.java_base.toCompositeClass
import de.fhdo.lemma.model_processing.utils.trimToSingleLine
import de.fhdo.lemma.service.Visibility
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.technology.CommunicationType
import de.fhdo.lemma.technology.ExchangePattern

@CodeGenerationHandler
internal class CalledIntermediateOperationHandler
    : CallableCodeGenerationHandlerI<IntermediateOperation, MethodDeclaration, ClassOrInterfaceDeclaration> {
    companion object {
        fun invoke(operation: IntermediateOperation, parentClass: ClassOrInterfaceDeclaration)
            = CalledIntermediateOperationHandler().invoke(operation, parentClass)
    }

    override fun handlesEObjectsOfInstance() = IntermediateOperation::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java
    override fun getAspects(operation: IntermediateOperation) = operation.aspects!!

    override fun execute(operation: IntermediateOperation, parentClass: ClassOrInterfaceDeclaration?)
        : Pair<MethodDeclaration, String?>? {
        val generatedMethod = MethodDeclaration()
        parentClass!!.addMember(generatedMethod)
        generatedMethod.setName(operation.name)

        when(operation.visibility) {
            Visibility.NONE, Visibility.PUBLIC -> generatedMethod.isPublic = true
            Visibility.ARCHITECTURE -> generatedMethod.isProtected = true
            Visibility.INTERNAL -> generatedMethod.isPrivate = true
        }

        operation.getInputParameters().forEach { CalledIntermediateParameterHandler.invoke(it, generatedMethod) }
        val hasAsyncParametersInSignature = handleAsyncInputParameters(operation, generatedMethod)
        // Currently we only support synchronous fault parameters
        handleSynchronousFaultParameters(operation, generatedMethod)
        CalledIntermediateOperationResultParametersHandler.invoke(operation, generatedMethod)
        //handleAsyncOutputParameters(operation, generatedMethod)
        // Needs to be done here, because asynchronous parameters might have been turned to composite ones and the
        // original method signature might have been changed
        generatedMethod.setBody(operation, hasAsyncParametersInSignature)

        return generatedMethod to null
    }

    private fun MethodDeclaration.setBody(operation: IntermediateOperation, hasAsyncParametersInSignature: Boolean) {
        if (!isPrivate && operation.isNotImplemented) {
            isFinal = true
            setBody(
                """
                    throw new UnsupportedOperationException("This service operation is not implemented")
                """.trimToSingleLine()
            )
        } else {
            addRequiredInputParametersCheck(operation, CommunicationType.SYNCHRONOUS)
            if (hasAsyncParametersInSignature)
                addRequiredInputParametersCheck(operation, CommunicationType.ASYNCHRONOUS)
            else if (operation.hasRequiredInputParameters(CommunicationType.ASYNCHRONOUS)) {
                // Add a comment that hints the user at the existence of the asynchronous check method in case
                // asynchronous got removed entirely from the method signature and thus calling the asynchronous
                // check method directly is not possible
                val checkMethod = operation.buildCheckMethodName(CommunicationType.ASYNCHRONOUS)
                addBodyComment(LineComment(" " +
                    """
                        TODO Use $checkMethod if you want to check for the existence of mandatory asynchronous input 
                        parameters as soon as they are available from asynchronous interactions
                    """.trimToSingleLine(preserveTrailingWhitespaces = true)
                ))
            }
        }
    }

    private fun MethodDeclaration.addRequiredInputParametersCheck(operation: IntermediateOperation,
        communicationType: CommunicationType) {
        val requiredParameters = operation.getRequiredInputParameters(communicationType).map { it.name }
        if (requiredParameters.isEmpty())
            return

        val parametersToCompositeParameters = getParametersToCompositeParameters(communicationType)
        val parametersString = requiredParameters.joinToString {
            val compositeParameterName = parametersToCompositeParameters[it]
            // In case the original parameter was replaced by a composite one, prefix it in the call to the
            // method, which checks the required input parameters to be existent, with the name of the composite
            // class parameter and the call to the corresponding getter in the composite class
            compositeParameterName?.plus(".get${it.capitalize()}()") ?: it
        }
        val requiredParametersCheckMethod = operation.buildCheckMethodName(communicationType)
        val callStatement = "$requiredParametersCheckMethod($parametersString)"

        if (emptyBody)
            setBody(callStatement, characteristics = *arrayOf(SerializationCharacteristic.MERGE_ON_RELOCATION))
        else
            insertStatement("$callStatement;", 1)
    }

    private fun handleAsyncInputParameters(operation: IntermediateOperation, generatedMethod: MethodDeclaration)
        : Boolean {
        val generatedAsyncInputParameters = operation.getInputParameters(CommunicationType.ASYNCHRONOUS)
            .map { intermediateInputParameter ->
                generatedMethod.parameters.find { it.nameAsString == intermediateInputParameter.name }!!
            }

        if (generatedAsyncInputParameters.isEmpty())
            return false

        val hasSynchronousInputParameters = operation.hasInputParameters(CommunicationType.SYNCHRONOUS)
        val (hasAsyncParametersInSignature, inputTypeName) = if (!hasSynchronousInputParameters) {
            // The method has no synchronous and more than one asynchronous input parameter. In this case, we replace
            // the asynchronous input parameters with one composite class. Note that a single asynchronous parameter
            // sticks to the method as is.
            val inputTypeName = if (generatedAsyncInputParameters.size > 1) {
                generatedMethod.addImport(
                    operation.buildFullyQualifiedCompositeClassName(CommunicationType.ASYNCHRONOUS),
                    ImportTargetElementType.METHOD
                )
                val compositeClassName = operation.buildCompositeClassName(CommunicationType.ASYNCHRONOUS)
                generatedMethod.addCompositeParameter(compositeClassName, compositeClassName.decapitalize(),
                    CommunicationType.ASYNCHRONOUS, generatedAsyncInputParameters)
                compositeClassName
            } else
                generatedAsyncInputParameters[0].typeAsString

            true to inputTypeName
        } else {
            // The method has synchronous input parameters. In this case, we generate a composite class for the
            // asynchronous input parameters and remove them from the method signature.
            generatedAsyncInputParameters.forEach { generatedMethod.remove(it) }
            false to operation.buildCompositeClassName(CommunicationType.ASYNCHRONOUS)
        }

        if (!hasAsyncParametersInSignature)
            generatedMethod.addBodyComment(LineComment(
                "TODO Method may asynchronously receive one or more instances of $inputTypeName"
            ))

        return hasAsyncParametersInSignature
    }

    private fun handleSynchronousFaultParameters(operation: IntermediateOperation, generatedMethod: MethodDeclaration)
        = operation.getFaultParameters(CommunicationType.SYNCHRONOUS).forEach {
            val exceptionClassImport = IntermediateFaultParameterHandler.buildExceptionClassFullyQualifiedName(it)
            val exceptionClassName = IntermediateFaultParameterHandler.buildExceptionClassName(it)
            generatedMethod.addImport(exceptionClassImport, ImportTargetElementType.METHOD)
            generatedMethod.addThrownException(StaticJavaParser.parseClassOrInterfaceType(exceptionClassName))
        }
}

@CodeGenerationHandler
internal class CompositeAsyncInputParametersHandler()
    : VisitingCodeGenerationHandlerI<IntermediateOperation, ClassOrInterfaceDeclaration, Any> {
    override fun handlesEObjectsOfInstance() = IntermediateOperation::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java

    override fun execute(operation: IntermediateOperation, context: Any?)
        : Pair<ClassOrInterfaceDeclaration, String?>? {
        val hasSynchronousInputParameters = operation.hasInputParameters(CommunicationType.SYNCHRONOUS)
        val asynchronousInputParameters = operation.getInputParameters(CommunicationType.ASYNCHRONOUS)
        return if (asynchronousInputParameters.isEmpty())
                null
            else if (asynchronousInputParameters.size == 1 && !hasSynchronousInputParameters)
                null
            else
                asynchronousInputParameters.toCompositeClass(CommunicationType.ASYNCHRONOUS)
    }
}