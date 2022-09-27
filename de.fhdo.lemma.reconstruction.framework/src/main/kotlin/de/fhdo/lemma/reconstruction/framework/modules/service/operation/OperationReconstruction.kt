package de.fhdo.lemma.reconstruction.framework.modules.service.operation

import de.fhdo.lemma.reconstruction.framework.modules.AbstractReconstructionElement
import de.fhdo.lemma.reconstruction.framework.modules.common.MetaData
import de.fhdo.lemma.reconstruction.framework.modules.domain.datastructure.ComplexType
import de.fhdo.lemma.reconstruction.framework.modules.domain.datastructure.PrimitiveType

data class Operation(
    val name: String,
    @Transient
    var interfaceName: String? = null,
    val parameters: MutableList<Parameter> = mutableListOf(),
    val metaData: MutableList<MetaData> = mutableListOf()

): AbstractReconstructionElement()

/**
 * Factory for creating operations
 */
class ReconstructionOperationFactory() {
    /**
     * Create an interface based on a given name
     */
    fun createOperation(name: String) = Operation(name)
}

data class Parameter(
    val name: String,
    val communicationType: CommunicationType,
    val exchangePattern: ExchangePattern,
    var primitiveType: PrimitiveType? = null,
    var complexType: ComplexType? = null,
    val metaData: MutableList<MetaData> = mutableListOf()
)

enum class CommunicationType {
    SYNCHRONOUS,
    ASYNCHRONOUS
}

enum class ExchangePattern {
    IN,
    OUT,
    INOUT
}

/**
 * Factory for creating parameters
 */
class ReconstructionParameterFactory() {
    /**
     * Create an interface based on a given name
     */
    fun createParameter(name: String, communicationType: CommunicationType, exchangePattern: ExchangePattern)
        = Parameter(name, communicationType, exchangePattern)
}