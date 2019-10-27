package de.fhdo.lemma.model_processing.code_generation.java_base.modules.services.handlers.parameters

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.getResultParameters
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.CodeGenerationHandler
import de.fhdo.lemma.model_processing.code_generation.java_base.handlers.VisitingCodeGenerationHandlerI
import de.fhdo.lemma.model_processing.code_generation.java_base.toCompositeClass
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.technology.CommunicationType

/**
 * Code generation handler targeting composite, synchronous result parameters of IntermediateOperation instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class CompositeResultParametersHandler : CompositeResultParametersHandlerBase(CommunicationType.SYNCHRONOUS)

/**
 * Code generation handler targeting composite, asynchronous result parameters of IntermediateOperation instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CodeGenerationHandler
internal class AsynchronousCompositeResultParametersHandler
    : CompositeResultParametersHandlerBase(CommunicationType.ASYNCHRONOUS)

/**
 * Base class for composite result parameters' code generation handlers.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal open class CompositeResultParametersHandlerBase(private val communicationType: CommunicationType)
    : VisitingCodeGenerationHandlerI<IntermediateOperation, ClassOrInterfaceDeclaration, Nothing> {
    override fun handlesEObjectsOfInstance() = IntermediateOperation::class.java
    override fun generatesNodesOfInstance() = ClassOrInterfaceDeclaration::class.java

    /**
     * Execution logic of the handler
     */
    override fun execute(operation: IntermediateOperation, context: Nothing?)
        : Pair<ClassOrInterfaceDeclaration, String?>? {
        /*
         * If an operation has more than one result parameter, a composite result POJO will be generated. For
         * synchronous parameters this happens only, if the operation has more than one synchronous result parameter.
         * For asynchronous parameters, this happens as they exist.
         */
        val resultParameters = operation.getResultParameters(communicationType)
        val generateCompositeClass = when(communicationType) {
            CommunicationType.SYNCHRONOUS -> resultParameters.size > 1
            CommunicationType.ASYNCHRONOUS -> resultParameters.isNotEmpty()
        }

        /* Generate composite result POJO if necessary */
        return if (generateCompositeClass) resultParameters.toCompositeClass(communicationType, true) else null
    }
}