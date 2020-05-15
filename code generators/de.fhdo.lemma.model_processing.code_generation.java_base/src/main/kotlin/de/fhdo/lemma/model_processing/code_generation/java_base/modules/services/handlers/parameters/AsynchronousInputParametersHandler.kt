package de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers.parameters

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.getInputParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.VisitingCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.hasInputParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.toCompositeClass
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.technology.CommunicationType

/**
 * Code generation handler for creating a composite class from asynchronous input parameters of an
 * IntermediateOperation.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class AsynchronousInputParametersHandler()
    : VisitingCodeGenerationHandlerI<IntermediateOperation, ClassOrInterfaceDeclaration, Any> {
    override fun handlesEObjectsOfInstance() = IntermediateOperation::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java

    /**
     * Execution logic of the handler
     */
    override fun execute(eObject: IntermediateOperation, context: Any?) : Pair<ClassOrInterfaceDeclaration, String?>? {
        // Do nothing when operation has no asynchronous input parameters at all
        if (!eObject.hasInputParameters(CommunicationType.ASYNCHRONOUS))
            return null

        // Also do nothing when operation has only a single asynchronous and no synchronous input parameter
        val asynchronousInputParameters = eObject.getInputParameters(CommunicationType.ASYNCHRONOUS)
        if (asynchronousInputParameters.size == 1 && !eObject.hasInputParameters(CommunicationType.SYNCHRONOUS))
            return null

        // If the operation has more than one asynchronous input parameter or a synchronous parameter, create a
        // composite class for the asynchronous input parameter(s). This behavior is consistent with the expectations of
        // the OperationHandler (and also explained there).
        return asynchronousInputParameters.toCompositeClass(CommunicationType.ASYNCHRONOUS)
    }
}