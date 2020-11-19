package de.fhdo.lemma.model_processing.code_generation.java_base.modules.domain.handlers.data_operations

import com.github.javaparser.ast.Modifier
import com.github.javaparser.ast.body.CallableDeclaration
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.ConstructorDeclaration
import com.github.javaparser.ast.body.MethodDeclaration
import de.fhdo.lemma.data.intermediate.IntermediateDataOperation
import de.fhdo.lemma.model_processing.code_generation.java_base.ast.setBody
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CallableCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.hasAspect
import de.fhdo.lemma.model_processing.code_generation.java_base.hasFeature

/**
 * Called code generation handler for IntermediateDataOperation instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class DataOperationHandler :
    CallableCodeGenerationHandlerI<IntermediateDataOperation, CallableDeclaration<*>, ClassOrInterfaceDeclaration> {
    override fun handlesEObjectsOfInstance() = IntermediateDataOperation::class.java
    override fun generatesNodesOfInstance() = CallableDeclaration::class.java
    override fun getAspects(eObject: IntermediateDataOperation) = eObject.aspects!!

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
    override fun execute(eObject: IntermediateDataOperation, context: ClassOrInterfaceDeclaration?)
        : Pair<CallableDeclaration<*>, String?>? {
        /* Add the basic callable, i.e., a constructor or method, for the intermediate operation to the class */
        val callable = if (eObject.hasAspect("java.constructor"))
                    context!!.addAsConstructor(eObject)
                else
                    context!!.addAsMethod(eObject)

        /* Handle parameters */
        eObject.parameters.forEach { DataOperationParameterHandler.invoke(it, callable) }

        return callable to null
    }

    /**
     * Add the given [IntermediateDataOperation] as a user-defined constructor to this [ClassOrInterfaceDeclaration] and
     * return the created [ConstructorDeclaration] as a [CallableDeclaration]
     */
    private fun ClassOrInterfaceDeclaration.addAsConstructor(operation : IntermediateDataOperation)
        : CallableDeclaration<ConstructorDeclaration> {
        // For a user-defined constructor with custom parameters, we generate a constructor that delegates to a
        // protected method. By contrast to constructors, this protected method is overridable by subclasses with custom
        // code.
        val constructor = addConstructor(operation.determineUserDefinedConstructorVisibility())
        val delegateCallParameters = operation.parameters.joinToString { it.name }
        constructor.setBody("userDefinedConstructorDelegate($delegateCallParameters);")

        val delegate = addMethod("userDefinedConstructorDelegate", Modifier.Keyword.PROTECTED)
        operation.parameters.forEach { DataOperationParameterHandler.invoke(it, delegate) }
        return constructor
    }

    /**
     * Determine visibility of a user-defined constructor represented by this [IntermediateDataOperation]
     */
    private fun IntermediateDataOperation.determineUserDefinedConstructorVisibility() : Modifier.Keyword
        // TODO Add package visibility, e.g., via additional aspect property?
        = if (isHidden)
                // We make hidden user-defined constructors protected instead of private, because otherwise it may not
                // be possible to extend the target Java class. Extension is however crucial as it enables the
                // integration of custom code.
                Modifier.Keyword.PROTECTED
            else
                Modifier.Keyword.PUBLIC

    /**
     * Add the given [IntermediateDataOperation] as method to this [ClassOrInterfaceDeclaration] and return the created
     * [MethodDeclaration]
     */
    private fun ClassOrInterfaceDeclaration.addAsMethod(operation : IntermediateDataOperation)
        : CallableDeclaration<MethodDeclaration> {
        val method = addMethod(operation.name)
        method.isStatic = operation.hasAspect("java.static") || operation.dataStructure.hasFeature("FACTORY")

        if (!operation.isInherited) {
            method.addModifier(if (operation.isHidden) Modifier.Keyword.PRIVATE else Modifier.Keyword.PUBLIC)
            method.setReturnTypeFrom(operation)
            // If the method is inherited and has subsequently been hidden, we adapt its body to throw an Exception,
            // because Java does not allow to constrain the visibility of an inherited element as LEMMA does
        } else if (operation.isHidden) {
            method.addAnnotation("Override")
            method.setBody("""throw new UnsupportedOperationException("The method is not visible on this type")""")
        }

        return method
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