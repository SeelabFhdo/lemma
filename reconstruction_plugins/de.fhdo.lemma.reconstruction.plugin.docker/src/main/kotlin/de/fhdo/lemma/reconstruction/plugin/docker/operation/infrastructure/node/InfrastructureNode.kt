package de.fhdo.lemma.reconstruction.plugin.docker.operation.infrastructure.node

import de.fhdo.lemma.reconstruction.framework.modules.AbstractReconstructionElement

/**
 * Reconstruction element for restoring information about the architecture design from deployment
 * artifacts for infrastructure nodes, e.g., databases or service registries.
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
class InfrastructureNode(
    val name: String
    //todo: Extend with additional attributes for capering information about the architecture design
) : AbstractReconstructionElement()