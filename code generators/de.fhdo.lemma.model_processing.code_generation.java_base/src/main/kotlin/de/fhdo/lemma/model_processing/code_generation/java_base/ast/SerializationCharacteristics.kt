package de.fhdo.lemma.model_processing.code_generation.java_base.ast

import com.github.javaparser.ast.CompilationUnit
import com.github.javaparser.ast.DataKey
import com.github.javaparser.ast.Node
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import com.github.javaparser.ast.body.EnumDeclaration
import com.github.javaparser.ast.expr.NormalAnnotationExpr
import com.github.javaparser.ast.nodeTypes.NodeWithAnnotations
import com.github.javaparser.printer.PrettyPrinter
import de.fhdo.lemma.java.ast.utils.ImportTargetElementType
import de.fhdo.lemma.java.ast.utils.ImportsInfo
import de.fhdo.lemma.java.ast.utils.SingleImportInfo
import de.fhdo.lemma.java.ast.utils.findParentNode
import de.fhdo.lemma.model_processing.code_generation.java_base.serialization.configuration.AbstractSerializationConfiguration

private class SingleImportInfoWithSerializationCharacteristics(import: String,
    targetElementType: ImportTargetElementType, vararg val characteristics: SerializationCharacteristic)
    : SingleImportInfo(import, targetElementType) {
    /**
     * Helper to determine if the single import exhibits the given serialization [characteristic]
     */
    fun hasSerializationCharacteristic(characteristic: SerializationCharacteristic) = characteristic in characteristics
}

/**
 * Enumeration to allow code generators to influence serialization of generated Java AST [Node] instances.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
enum class SerializationCharacteristic {
    // Do not relocate elements from their defining compilation unit. For instance, do not pull up methods to
    // interfaces.
    DONT_RELOCATE,

    // Merge method bodies on relocation
    MERGE_ON_RELOCATION,

    // Adapt method bodies to delegate to super methods on relocation
    DELEGATE_ON_RELOCATION,

    // Remove node on relocation
    REMOVE_ON_RELOCATION,

    // Do not generate additional constructors for the class exhibiting this characteristic
    NO_CONSTRUCTORS
}

private class ImportsInfoWithSerializationCharacteristics():
    ImportsInfo<SingleImportInfoWithSerializationCharacteristics>()

/**
 * Add a [SerializationCharacteristic] to a [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Node.addSerializationCharacteristic(characteristic: SerializationCharacteristic) {
    if (!containsData(SerializationCharacteristicDataKey))
        setData(SerializationCharacteristicDataKey, mutableSetOf(characteristic))
    else
        getData(SerializationCharacteristicDataKey).add(characteristic)
}

/**
 * Add [SerializationCharacteristic] instances to a [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Node.addSerializationCharacteristics(characteristics: Iterable<SerializationCharacteristic>)
    = characteristics.forEach { addSerializationCharacteristic(it) }

/**
 * Add [SerializationCharacteristic] instances represented as an [Array] to a [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Node.addSerializationCharacteristics(characteristics: Array<out SerializationCharacteristic>)
    = characteristics.forEach { addSerializationCharacteristic(it) }

/**
 * Data key for a set of [SerializationCharacteristic] instances on a [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private object SerializationCharacteristicDataKey : DataKey<MutableSet<SerializationCharacteristic>>()

/**
 * Verify if a [Node] exhibits a certain [SerializationCharacteristic].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Node.hasSerializationCharacteristic(characteristic: SerializationCharacteristic)
    = characteristic in getSerializationCharacteristics()

/**
 * Get all [SerializationCharacteristic] instances of a [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Node.getSerializationCharacteristics() : Set<SerializationCharacteristic>
    = if (containsData(SerializationCharacteristicDataKey))
        getData(SerializationCharacteristicDataKey)
    else
        emptySet()

/**
 * Clear the set of [SerializationCharacteristic] instances of a [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Node.clearSerializationCharacteristics() {
    if (containsData(SerializationCharacteristicDataKey))
        setData(SerializationCharacteristicDataKey, mutableSetOf())
}

/**
 * Helper to serialize an AST [Node].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Node.serialize(serializationConfiguration: AbstractSerializationConfiguration) : String {
    val compilationUnit = when(this) {
        is CompilationUnit -> this
        is ClassOrInterfaceDeclaration,
            is EnumDeclaration -> findParentNode()!!
        else -> throw IllegalArgumentException("Serialization of nodes of type ${this::class.java.name} is not " +
            "supported")
    }

    val prettyPrinter = PrettyPrinter(serializationConfiguration)
    return prettyPrinter.print(compilationUnit)
}

/**
 * Convenience function to add an annotation with the given [name] and serialization [characteristics] to this
 * [NodeWithAnnotations]. Returns the created annotation.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun NodeWithAnnotations<out Node>.addAndGetAnnotation(name: String,
    vararg characteristics: SerializationCharacteristic) : NormalAnnotationExpr {
    val annotation = this.addAndGetAnnotation(name)
    annotation.addSerializationCharacteristics(characteristics)
    return annotation
}

/**
 * Convenience function to add an annotation with the given [name] and serialization [characteristics] to this
 * [NodeWithAnnotations].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun NodeWithAnnotations<out Node>.addAnnotation(name: String,
                                                vararg characteristics: SerializationCharacteristic) : NodeWithAnnotations<out Node> {
    val annotation = this.addAndGetAnnotation(name)
    annotation.addSerializationCharacteristics(characteristics)
    return this
}