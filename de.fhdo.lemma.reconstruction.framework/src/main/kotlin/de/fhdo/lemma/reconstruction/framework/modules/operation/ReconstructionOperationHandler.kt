package de.fhdo.lemma.reconstruction.framework.modules.operation

import de.fhdo.lemma.reconstruction.framework.modules.AbstractReconstructionHandler
import de.fhdo.lemma.reconstruction.framework.modules.AbstractReconstructionModule
import de.fhdo.lemma.reconstruction.framework.modules.operation.container.Container
import de.fhdo.lemma.reconstruction.framework.modules.service.ReconstructionServiceHandler
import de.fhdo.lemma.reconstruction.framework.modules.service.microservice.Microservice
import de.fhdo.lemma.reconstruction.framework.plugins.AbstractParseTree

/**
 * Main module of the reconstruction framework. The module deals with the handling of the plugins and reconstruction
 * phases.
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
internal object ReconstructionOperationHandler : AbstractReconstructionHandler(){
    private val reconstructedContainer = mutableListOf<Container>()

    /**
     * Initialize the state of the main reconstruction module
     */
    override fun init() {
        println("Init: ${ReconstructionOperationHandler.javaClass.name}")
    }

    override fun reconstructFromPassTree(tree: AbstractParseTree, module: AbstractReconstructionModule) {
        val reconstruction = module.execute(tree)

        reconstruction.forEach {
            when (it) {
                is Container -> reconstructedContainer.add(it)
            }
        }
    }

    internal fun stop() {
        println()
    }
}