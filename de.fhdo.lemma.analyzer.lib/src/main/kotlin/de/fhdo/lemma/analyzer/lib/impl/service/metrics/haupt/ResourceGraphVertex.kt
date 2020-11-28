@file:Suppress("CascadeIf")

package de.fhdo.lemma.analyzer.lib.impl.service.metrics.haupt

import de.fhdo.lemma.analyzer.lib.getDefiningModel
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataModel

/**
 * Class to represent a vertex in an [HttpResourceGraph].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("MemberVisibilityCanBePrivate")
class ResourceGraphVertex(val resourceType: IntermediateComplexType) {
    val modelFileUri: String = resourceType.getDefiningModel<IntermediateDataModel>().sourceModelUri
    val qualifiedName: String = resourceType.qualifiedName

    override fun hashCode() = "$modelFileUri::$qualifiedName".hashCode()

    override fun equals(other: Any?)
        = if (this === other)
                true
            else if (other == null)
                false
            else if (other is ResourceGraphVertex)
                modelFileUri == other.modelFileUri &&
                qualifiedName.javaClass == other.qualifiedName.javaClass
            else
                false

    override fun toString() = qualifiedName
}