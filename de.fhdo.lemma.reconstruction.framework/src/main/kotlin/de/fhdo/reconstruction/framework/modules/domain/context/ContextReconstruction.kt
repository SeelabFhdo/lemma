package de.fhdo.reconstruction.framework.modules.domain.context

import de.fhdo.reconstruction.framework.modules.AbstractReconstructionElement
import de.fhdo.reconstruction.framework.modules.domain.ReconstructionDomainHandler.getReconstructedContexts
import de.fhdo.reconstruction.framework.modules.domain.datastructure.DataStructure
import de.fhdo.reconstruction.framework.modules.domain.datastructure.EnumType


/**
 * Data structure for reconstructing information regarding a domain driven design bounded context
 */
data class Context(
    val qualifiedName: String,
    val name: String,
    var version: String? = null,
    val dataStructures: MutableList<DataStructure> = mutableListOf(),
    val enums: MutableList<EnumType> = mutableListOf(),
): AbstractReconstructionElement()

/**
 * Factory for creating contexts
 */
class ReconstructionContextFactory() {
    /**
     * Create a context based on a given name
     */
    fun createContext(qualifiedName: String, name: String) = Context(qualifiedName, name)
}

/**
 * Helper function to determinate if a reconstructed bounded context already exists
 */
fun checkContextForExistence(context: Context): Boolean {
    val reconstructedContexts = getReconstructedContexts()
    reconstructedContexts.forEach {
        if (it.qualifiedName == context.qualifiedName)
            return true
    }
    return false
}