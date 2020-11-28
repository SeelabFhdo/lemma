@file:Suppress("CascadeIf")

package de.fhdo.lemma.analyzer.lib.impl.service.metrics.athanasopoulos

import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateImportedTechnologySpecificType
import de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType
import de.fhdo.lemma.data.intermediate.IntermediateType
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.service.intermediate.IntermediateParameter
import org.jgrapht.nio.DefaultAttribute
import java.lang.IllegalArgumentException

/**
 * Class for vertices in the various graphs kinds occurring in the metrics suite of
 * [Athanasopoulos et al.](https://ieeexplore.ieee.org/document/6763104).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class LevelGraphVertex(private var vertexObject: Any, var label: String, private var qualifiedName: String) {
    /**
     * Construct a [LevelGraphVertex] instance from a [String]. The [String] will become the [label] of the vertex.
     */
    constructor(s: String) : this(s, s, s)

    /**
     * Construct a [LevelGraphVertex] instance from an [IntermediateOperation]. The name of the operation will become
     * the [label] of the vertex.
     */
    constructor(operation: IntermediateOperation) : this(operation, operation.name, operation.qualifiedName)

    /**
     * Construct a [LevelGraphVertex] instance from an [IntermediateParameter]. The name of the parameter will become
     * the [label] of the vertex.
     */
    constructor(parameter: IntermediateParameter) : this(parameter, parameter.name, parameter.qualifiedName)

    /**
     * Construct a [LevelGraphVertex] instance from an [IntermediateType]. The name of the type will become the [label]
     * of the vertex.
     */
    constructor(type: IntermediateType) : this(type, type.name, "") {
        val qualifiedName = when(type) {
            is IntermediatePrimitiveType -> type.name
            is IntermediateComplexType -> type.qualifiedName
            is IntermediateImportedTechnologySpecificType -> type.qualifiedName
            else -> throw IllegalArgumentException("Vertex creation not supported for intermediate types of class " +
                type.javaClass.simpleName)
        }
        this.qualifiedName = qualifiedName
    }

    override fun hashCode() = "$qualifiedName::${vertexObject.javaClass.hashCode()}".hashCode()

    override fun equals(other: Any?)
        = if (this === other)
                true
            else if (other == null)
                false
            else if (other is LevelGraphVertex)
                qualifiedName == other.qualifiedName &&
                vertexObject.javaClass == other.vertexObject.javaClass
            else
                false

    /**
     * Return the [String] representation of the [LevelGraphVertex], i.e., its [label]
     */
    override fun toString() = label
}

/**
 * Reusable implementation of a vertex attribute provider for [String] serialization in graphs related to the metrics
 * suite of [Athanasopoulos et al.](https://ieeexplore.ieee.org/document/6763104).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun vertexAttributeProvider(vertex: LevelGraphVertex)
    = mapOf("label" to DefaultAttribute.createAttribute(vertex.label))