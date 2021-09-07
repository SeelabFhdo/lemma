package de.fhdo.reconstruction.framework.modules.service.microservice

import de.fhdo.reconstruction.framework.modules.AbstractReconstructionElement
import de.fhdo.reconstruction.framework.modules.service.ReconstructionServiceHandler
import de.fhdo.reconstruction.framework.modules.service.`interface`.ReconstructedInterface

/**
 * Data structure for reconstructing LEMMA's Microservice from a file, e.g., a Java or Kotlin file.
 */
data class Microservice(
    val name: String,
    var version: String? = null,
    var type: String? = null,
    var visibility: String? = null,
    val interfaces: MutableList<ReconstructedInterface>? = mutableListOf()
) : AbstractReconstructionElement()

/**
 * Data class for handling microservices, reconstructed from the plugins.
 */
data class ReconstructedMicroservice(
    val fullyQualifiedName: String,
    val microservice: Microservice
)

/**
 * Function to receive reconstructed microservices for identifying corresponding parts.
 */
fun getReconstructedMicroservices(): MutableList<ReconstructedMicroservice> {
    return ReconstructionServiceHandler.reconstructedMicroservices
}

/**
 * Helper function to create a [ReconstructedMicroservice] from a [Microservice]
 */
internal fun getReconstructedMicroserviceFromMicroservice(service: Microservice)
    = ReconstructedMicroservice(service.name, service)

/**
 * Factory for creating microservices.
 */
class ReconstructionMicroserviceFactory() {
    /**
     * Create microservice template based on the microservice name.
     */
    fun createMicroservice(name: String) = Microservice(name)
}