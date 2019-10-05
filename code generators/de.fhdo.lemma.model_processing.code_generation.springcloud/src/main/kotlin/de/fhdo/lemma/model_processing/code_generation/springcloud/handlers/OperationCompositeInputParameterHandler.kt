package de.fhdo.lemma.model_processing.code_generation.springcloud.handlers

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.buildFullyQualifiedCompositeClassName
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletCodeGenerationHandlerResult
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.springcloud.Context.State as State
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.technology.CommunicationType

@CodeGenerationHandler
internal class OperationCompositeInputParameterHandler
    : GenletCodeGenerationHandlerI<IntermediateOperation, ClassOrInterfaceDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateOperation::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java

    override fun execute(operation: IntermediateOperation, compositeClass: ClassOrInterfaceDeclaration,
        context: Nothing?) : GenletCodeGenerationHandlerResult<ClassOrInterfaceDeclaration>? {
        if (compositeClass.isAsynchronousCompositeInputClassFor(operation))
            State.addOrUpdateAsynchronousOperationInfo(
                operation,
                compositeInputClass = compositeClass.fullyQualifiedName.get()
            )
        else if (compositeClass.isAsynchronousCompositeResultClassFor(operation))
            State.addOrUpdateAsynchronousOperationInfo(
                operation,
                compositeResultClass = compositeClass.fullyQualifiedName.get()
            )

        return GenletCodeGenerationHandlerResult(compositeClass)
    }

    private fun ClassOrInterfaceDeclaration.isAsynchronousCompositeInputClassFor(operation: IntermediateOperation)
        = operation.buildFullyQualifiedCompositeClassName(CommunicationType.ASYNCHRONOUS) == fullyQualifiedName.get()

    private fun ClassOrInterfaceDeclaration.isAsynchronousCompositeResultClassFor(operation: IntermediateOperation)
            = operation.buildFullyQualifiedCompositeClassName(CommunicationType.ASYNCHRONOUS, true) ==
                fullyQualifiedName.get()
}