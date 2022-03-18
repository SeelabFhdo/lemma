package de.fhdo.reconstruction.framework.modules.service.microservice

import de.fhdo.reconstruction.framework.modules.AbstractReconstructionElement
import de.fhdo.reconstruction.framework.modules.common.MetaData
import de.fhdo.reconstruction.framework.modules.service.`interface`.Interface

/**
 * Data structure for reconstructing LEMMA's Microservice from a file, e.g., a Java or Kotlin file.
 */
data class Microservice(
    val name: String,
    var version: String? = null,
    var type: String? = null,
    var visibility: String? = null,
    val interfaces: MutableList<Interface> = mutableListOf(),
    val metaData: MutableList<MetaData> = mutableListOf()
) : AbstractReconstructionElement()

/**
 * Factory for creating microservices.
 */
class ReconstructionMicroserviceFactory() {
    /**
     * Create microservice template based on the microservice name.
     */
    fun createMicroservice(name: String) = Microservice(name)
}