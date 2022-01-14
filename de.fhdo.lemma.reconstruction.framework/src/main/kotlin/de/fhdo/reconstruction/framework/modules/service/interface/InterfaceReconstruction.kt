package de.fhdo.reconstruction.framework.modules.service.`interface`

import de.fhdo.reconstruction.framework.modules.AbstractReconstructionElement
import de.fhdo.reconstruction.framework.modules.common.MetaData
import de.fhdo.reconstruction.framework.modules.service.operation.Operation

open class Interface(
    val name: String,
    @Transient
    var microserviceName: String? = null,
    var version: String? = null,
    var visibility: String? = null,
    val operations: MutableList<Operation>? = mutableListOf(),
    val metaData: MutableList<MetaData> = mutableListOf()
): AbstractReconstructionElement()

/**
 * Factory for creating interface templates
 */
class ReconstructionInterfaceFactory() {
    /**
     * Create an Interface based on a given name
     */
    fun createInterface(name: String) = Interface(name)
}