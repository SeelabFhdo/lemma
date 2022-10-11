package de.fhdo.lemma.reconstruction.plugin.docker.operation.container

import de.fhdo.lemma.reconstruction.framework.modules.AbstractReconstructionElement

/**
 * Reconstruction element for restoring information about the architecture design from deployment
 * artifacts for containers, responsible for microservices operations.
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
class Container(
    private val name: String
    //todo: Extend with additional attributes for capering information about the architecture design
) : AbstractReconstructionElement() {
    override fun toString(): String {
        return "Container(name='$name')"
    }
}