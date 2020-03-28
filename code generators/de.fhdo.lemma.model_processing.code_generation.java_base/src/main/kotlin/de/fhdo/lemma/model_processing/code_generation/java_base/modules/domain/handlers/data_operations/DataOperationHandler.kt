package de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.handlers.data_operations

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataOperation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CallableCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.hasAspect

/**
 * Called code generation handler for IntermediateDataOperation instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class DataOperationHandler :
    CallableCodeGenerationHandlerI<IntermediateDataOperation, MethodDeclaration, ClassOrInterfaceDeclaration> {
    override fun handlesEObjectsOfInstance() = IntermediateDataOperation::class.java
    override fun generatesNodesOfInstance() = MethodDeclaration::class.java
    override fun getAspects(operation: IntermediateDataOperation) = operation.aspects!!

    companion object {
        /**
         * Convenience companion method to invoke the handler
         */
        fun invoke(operation: IntermediateDataOperation, parentClass: ClassOrInterfaceDeclaration)
            = DataOperationHandler().invoke(operation, parentClass)
    }

    /**
     * Execution logic of the handler
     */
    override fun execute(operation: IntermediateDataOperation, parentClass: ClassOrInterfaceDeclaration?)
        : Pair<MethodDeclaration, String?>? {
        /* Each service operation becomes a method of the given parent class */
        val method = parentClass!!.addMethod(operation.name)
        method.isStatic = operation.hasAspect("java.static")

        if (!operation.isInherited) {
            method.addModifier(if (operation.isHidden) Modifier.Keyword.PRIVATE else Modifier.Keyword.PUBLIC)
            method.setReturnTypeFrom(operation)
        // If the method is inherited and has subsequently been hidden, we adapt its body to throw an Exception, because
        // Java does not allow to constrain the visibility of an inherited element as LEMMA does
        } else if (operation.isHidden) {
            method.addAnnotation("Override")
            method.setBody("""throw new UnsupportedOperationException("The method is not visible on this type")""")
        }

        /* Handle parameters */
        operation.parameters.forEach { DataOperationParameterHandler.invoke(it, method) }

        return method to null
    }

    /**
     * Convenience method to set the return of this [MethodDeclaration] from the given [operation]
     */
    private fun MethodDeclaration.setReturnTypeFrom(operation: IntermediateDataOperation) {
        if (operation.returnType == null)
            setType("void")
        else
            DataOperationReturnTypeHandler.invoke(operation.returnType, this)
    }
}