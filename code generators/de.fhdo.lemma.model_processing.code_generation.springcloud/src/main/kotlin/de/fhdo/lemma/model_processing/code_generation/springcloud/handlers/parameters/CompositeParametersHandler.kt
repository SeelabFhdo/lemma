package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.parameters

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.buildFullyQualifiedCompositeClassName
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.springcloud.Context.State as State
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.technology.CommunicationType

/**
 * Code generation handler for composite input parameters of IntermediateOperation instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class CompositeParametersHandler
    : GenletCodeGenerationHandlerI<IntermediateOperation, ClassOrInterfaceDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateOperation::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java

    /**
     * Execution logic of the handler
     */
    override fun execute(operation: IntermediateOperation, compositeClass: ClassOrInterfaceDeclaration, ctx: Nothing?)
        : GenletCodeGenerationHandlerResult<ClassOrInterfaceDeclaration>? {
        /* Gather asynchronous composite input and result classes in Genlet state */
        val compositeClassName = compositeClass.fullyQualifiedName.get()
        if (compositeClass.isAsynchronousCompositeInputClassFor(operation))
            State.addOrUpdateAsynchronousOperationInfo(operation, compositeInputClass = compositeClassName)
        else if (compositeClass.isAsynchronousCompositeResultClassFor(operation))
            State.addOrUpdateAsynchronousOperationInfo(operation, compositeResultClass = compositeClassName)

        return GenletCodeGenerationHandlerResult(compositeClass)
    }

    /**
     * Helper to verify if this [ClassOrInterfaceDeclaration] is an asynchronous composite input class for the given
     * [operation]
     */
    private fun ClassOrInterfaceDeclaration.isAsynchronousCompositeInputClassFor(operation: IntermediateOperation)
        = fullyQualifiedName.get() == operation.buildFullyQualifiedCompositeClassName(CommunicationType.ASYNCHRONOUS)

    /**
     * Helper to verify if this [ClassOrInterfaceDeclaration] is an asynchronous composite result class for the given
     * [operation]
     */
    private fun ClassOrInterfaceDeclaration.isAsynchronousCompositeResultClassFor(operation: IntermediateOperation)
        : Boolean {
        val qualifiedName = fullyQualifiedName.get()
        return qualifiedName == operation.buildFullyQualifiedCompositeClassName(CommunicationType.ASYNCHRONOUS, true)
    }
}