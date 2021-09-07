package de.fhdo.reconstruction.framework.modules.service.`interface`

import de.fhdo.reconstruction.framework.modules.AbstractReconstructionElement
import de.fhdo.reconstruction.framework.modules.service.ReconstructionServiceHandler
import de.fhdo.reconstruction.framework.modules.service.operation.ReconstructedOperation

open class Interface(
    val name: String,
    var microserviceName: String? = null,
    var version: String? = null,
    var visibility: String? = null
): AbstractReconstructionElement()

data class InterfaceWithOperations(
    val operations: MutableList<ReconstructedOperation>? = mutableListOf(),
    val interFace: Interface
)

data class ReconstructedInterface(
    val name: String,
    val version: String?,
    val visibility: String?,
    val operations: MutableList<ReconstructedOperation>? = mutableListOf()
)

/**
 * Helper function to create a [ReconstructedInterface] based on an [Interface]
 */
internal fun getReconstructedInterfaceFromInterface(interFace: InterfaceWithOperations): ReconstructedInterface
    = ReconstructedInterface(interFace.interFace.name, interFace.interFace.version,
        interFace.interFace.visibility, interFace.operations)

/**
 * Function to receive reconstructed interfaces for identifying corresponding parts.
 */
fun getReconstructedInterfaces(): MutableList<Interface> {
    val interfaces = mutableListOf<Interface>()
    ReconstructionServiceHandler.reconstructedInterfaces.forEach {
        interfaces.add(it.interFace)
    }
    return interfaces
}

/**
 * Factory for creating interface templates
 */
class ReconstructionInterfaceFactory() {
    /**
     * Create an Interface based on a given name
     */
    fun createInterface(name: String) = Interface(name)
}