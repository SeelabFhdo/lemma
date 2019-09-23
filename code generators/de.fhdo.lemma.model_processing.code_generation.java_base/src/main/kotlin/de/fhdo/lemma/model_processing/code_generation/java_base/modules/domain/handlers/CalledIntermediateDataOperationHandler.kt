package de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.handlers

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataOperation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CallableCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.DomainContext.State as DomainState
import de.fhdo.lemma.model_processing.utils.trimToSingleLine

@CodeGenerationHandler
internal class CalledIntermediateDataOperationHandler :
    CallableCodeGenerationHandlerI<IntermediateDataOperation, MethodDeclaration, ClassOrInterfaceDeclaration> {
    private val currentDomainPackage: String by DomainState

    override fun handlesEObjectsOfInstance() = IntermediateDataOperation::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java
    override fun getAspects(operation: IntermediateDataOperation) = operation.aspects!!

    companion object {
        fun invoke(operation: IntermediateDataOperation, parentClass: ClassOrInterfaceDeclaration)
            = CalledIntermediateDataOperationHandler().invoke(operation, parentClass)
    }

    override fun execute(operation: IntermediateDataOperation, parentClass: ClassOrInterfaceDeclaration?)
        : Pair<MethodDeclaration, String?>? {
        var generatedMethod = parentClass!!.addMethod(operation.name)
        if (!operation.isInherited) {
            generatedMethod.setVisibility(operation)
            generatedMethod = CalledIntermediateDataOperationReturnTypeHandler.invoke(
                operation.returnType,
                generatedMethod
            )!!.first
        } else if (operation.visibilitySubsequentlyConstrained)
            generatedMethod.addNotImplementedBody()

        operation.parameters.forEach {
            generatedMethod = CalledIntermediateDataOperationParameterHandler.invoke(it, generatedMethod)!!.first
        }

        return generatedMethod to null
    }

    private fun MethodDeclaration.setVisibility(originalOperation: IntermediateDataOperation) {
        if (!originalOperation.isHidden)
            addModifier(Modifier.Keyword.PUBLIC)
        else
            addModifier(Modifier.Keyword.PRIVATE)
    }

    private fun MethodDeclaration.addNotImplementedBody() {
        addAnnotation("Override")
        setBody(
            """
            throw new UnsupportedOperationException(
                "The method \"${nameAsString}\" is not visible on this type"
            );
            """.trimToSingleLine()
        )
    }

    private val IntermediateDataOperation.visibilitySubsequentlyConstrained get() = isInherited && isHidden
}