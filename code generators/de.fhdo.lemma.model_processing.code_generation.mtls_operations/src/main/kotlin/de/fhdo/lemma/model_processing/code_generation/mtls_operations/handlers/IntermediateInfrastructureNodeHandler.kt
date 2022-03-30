package de.fhdo.lemma.model_processing.code_generation.mtls_operations.handlers

import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode

@CodeGenerationHandler
class IntermediateInfrastructureNodeHandler : CodeGenerationHandlerI<IntermediateInfrastructureNode> {
    override fun getSourceInstanceType() = IntermediateInfrastructureNode::class.java

    override fun execute(eObject: IntermediateInfrastructureNode): String {
        println("IntermediateContextHandler")
        return "Hallo"
    }
}