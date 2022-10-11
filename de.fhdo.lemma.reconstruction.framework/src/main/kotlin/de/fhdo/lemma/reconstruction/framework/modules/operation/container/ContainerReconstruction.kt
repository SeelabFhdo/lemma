package de.fhdo.lemma.reconstruction.framework.modules.operation.container

import de.fhdo.lemma.reconstruction.framework.modules.AbstractReconstructionElement

/**
 * Data structure for reconstructing LEMMA's Container structure from a file, e.g., Docker-Compose or Kubernetes
 */
data class Container (
    val name : String,
    val deployedServices : MutableList<String> = mutableListOf(),
    val usedByServices : MutableList<String> = mutableListOf(),
    val dependsOnServices : MutableList<String> = mutableListOf()
) : AbstractReconstructionElement()

/**
 * Factory for creating containers.
 */

class ReconstructionContainerFactory() {
    /**
     * Create a container template based on the name of the container.
     */
    fun createContainer(name : String) = Container(name)
}