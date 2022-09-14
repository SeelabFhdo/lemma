package de.fhdo.lemma.analyzer.lib.impl.service.metrics.engel

import de.fhdo.lemma.analyzer.lib.impl.Cache
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.data.intermediate.IntermediateEnumeration
import de.fhdo.lemma.data.intermediate.IntermediateCollectionType
import de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType
import de.fhdo.lemma.data.intermediate.IntermediateType

/**
 * Calculate the size in bits of this [IntermediateType], which may represent an [IntermediateComplexType] or
 * [IntermediatePrimitiveType]. The [useOriginalTypes] flag indicates whether to use the original (i.e., non-mapped)
 * types of data fields in data structure and collection types. The [collectionFieldMultiplier] will be used to simulate
 * the size of collections and may act as an approximation of the influence of collection sizes on a calculated type
 * size. By default, the [collectionFieldMultiplier] is 1 and thus the weight of a collection's size in a calculated
 * type size will also be 1.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateType.calculateSizeInBits(useOriginalTypes: Boolean, collectionFieldMultiplier: Int = 1)
    = when(this) {
        is IntermediateComplexType -> calculateSizeInBits(useOriginalTypes, collectionFieldMultiplier)
        is IntermediatePrimitiveType -> calculateSizeInBits()
        else -> 0  // Type is probably a technology-specific type, for which no type calculation is possible
    }

/**
 * Calculate the size in bits of this [IntermediateComplexType], which may be an [IntermediateDataStructure],
 * [IntermediateEnumeration], or [IntermediateCollectionType].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateComplexType.calculateSizeInBits(useOriginalTypes: Boolean, collectionFieldMultiplier: Int)
    = when (val resolvedType = Cache.getResolvedType(this)) {
        is IntermediateDataStructure -> resolvedType.calculateSizeInBits(useOriginalTypes)
        is IntermediateEnumeration -> resolvedType.calculateSizeInBits()
        else -> (resolvedType as IntermediateCollectionType)
            .calculateSizeInBits(useOriginalTypes, collectionFieldMultiplier)
    }

/**
 * Calculate the size in bits of this [IntermediateDataStructure]. The types of the structure's data fields determine
 * the size of the structure.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateDataStructure.calculateSizeInBits(useOriginalTypes: Boolean) : Int {
    var typeSize = 0

    for (field in dataFields) {
        val currentType = if (useOriginalTypes) field.originalType else field.type
        if (currentType is IntermediateComplexType && currentType == this)
            continue

        typeSize += currentType.calculateSizeInBits(useOriginalTypes)
    }

    return typeSize
}

/**
 * Calculate the size in bits of this [IntermediateEnumeration]. The initialization values of the enumeration's fields
 * determine the size of the enumeration. In case an enumeration field does not have an initialization value, its size
 * is 0.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateEnumeration.calculateSizeInBits()
    = fields.sumBy { field ->
        field.initializationValueCompatibleTypes
            .maxByOrNull { it.calculateSizeInBits() }
            ?.calculateSizeInBits()
            ?: 0
    }

/**
 * Calculate the size in bits of this [IntermediateCollectionType]. In case the collection is a primitive collection,
 * its size equals the size of its primitive type. In case the collection is a structured type, its size is determined
 * by the types of the data fields of the collection. The calculated size of a collection will be multiplied with the
 * argument for the [collectionFieldMultiplier] parameter. It may thus act as an approximation of the influence of
 * collection sizes on a calculated type size.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateCollectionType.calculateSizeInBits(useOriginalTypes: Boolean, collectionFieldMultiplier: Int)
    : Int {
    if (isPrimitiveCollection)
        return primitiveType.calculateSizeInBits()

    var typeSize = 0
    for (field in dataFields) {
        val currentType = if (useOriginalTypes) field.originalType else field.type
        if (currentType is IntermediateComplexType && currentType == this)
            continue

        typeSize += currentType.calculateSizeInBits(useOriginalTypes)
    }

    return collectionFieldMultiplier * typeSize
}

/**
 * Calculate the size in bits of this [IntermediatePrimitiveType]. For primitive types without fixed sizes, e.g., string
 * and date, this method will return the maximum type size of 64.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediatePrimitiveType.calculateSizeInBits() = size ?: 64