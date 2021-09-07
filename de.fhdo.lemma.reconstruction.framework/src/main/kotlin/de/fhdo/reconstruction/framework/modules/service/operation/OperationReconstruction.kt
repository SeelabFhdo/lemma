package de.fhdo.reconstruction.framework.modules.service.operation

import de.fhdo.reconstruction.framework.modules.AbstractReconstructionElement

data class Operation(
    val name: String,
    var interfaceName: String? = null
): AbstractReconstructionElement()

data class ReconstructedOperation(
    val name: String
)

/**
 * Helper function to create an [Operation] for a [ReconstructedInterface]
 */
fun createOperation(interfaceName: String, name: String)
    = Operation(interfaceName, name)

/**
 * Helper function to create a [ReconstructedOperation] from an [Operation]
 */
fun getReconstructedOperationFromOperation(operation: Operation) = ReconstructedOperation(operation.name)

/**
 * Factory for creating operations
 */
class ReconstructionOperationFactory() {
    /**
     * Create an interface based on a given name
     */
    fun createOperation(name: String) = Operation(name)
}