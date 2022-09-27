package de.fhdo.lemma.reconstruction.framework.modules.domain.datastructure

import de.fhdo.lemma.reconstruction.framework.modules.AbstractReconstructionElement
import de.fhdo.lemma.reconstruction.framework.modules.common.MetaData

/**
 * Data structure for reconstructing information regarding a domain driven design entity
 */
class DataStructure(
    val qualifiedContextName: String,
    val name: String,
    val fields: MutableList<Field> = mutableListOf(),
    val metaData: MutableList<MetaData> = mutableListOf()

): AbstractReconstructionElement()

class EnumType(
    val qualifiedContextName: String,
    val name: String,
    val values: MutableList<String> = mutableListOf(),
    val metaData: MutableList<MetaData> = mutableListOf()
): AbstractReconstructionElement()


/**
 * Data structure for storing reconstruction information
 */
data class Field(
    val name: String,
    var primitiveType: PrimitiveType? = null,
    var complexType: ComplexType? = null,
    val metaData: MutableList<MetaData> = mutableListOf()
)

data class PrimitiveType (val name: String)

data class ComplexType (val name: String, val qualifiedName: String, val classType: ClassType)

enum class ClassType {
    COLLECTION,
    ENUMERATION,
    DATA_STRUCTURE,
    MAP,
    UNSPECIFIED
}

class ReconstructionFieldFactory {
    fun createField(name: String) = Field(name)
}

/**
 * Factory for creating an [DataStructureInformation]
 */
class ReconstructionDataStructureFactory {

    /**
     * Factory function for creating an entity
     */
    fun createDataStructure(qualifiedContextName: String, name: String)
        = DataStructure(qualifiedContextName, name)
}