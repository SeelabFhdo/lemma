package de.fhdo.lemma.typechecking.complex_types.data_structures

import org.eclipse.xtend.lib.annotations.Accessors
import de.fhdo.lemma.data.ComplexType
import java.util.List
import de.fhdo.lemma.data.PrimitiveType
import de.fhdo.lemma.data.CollectionType
import org.eclipse.emf.common.util.EList
import de.fhdo.lemma.data.DataStructure
import de.fhdo.lemma.data.DataField
import de.fhdo.lemma.typechecking.complex_types.data_structures.DataFieldComparator.ORDERING

/**
 * Represents a node of a TypeGraph.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class TypeGraphNode {
    /* Complex type of the node */
    @Accessors(PUBLIC_GETTER)
    var ComplexType type

    /* Full-qualified name of the field of the node's type */
    @Accessors(PUBLIC_GETTER)
    var String fieldName

    /* Parent node (null for root nodes) */
    @Accessors(PUBLIC_GETTER)
    var TypeGraphNode parent

    /* Node depth beginning with 1 */
    @Accessors(PUBLIC_GETTER)
    int depth

    /* Flag to indicate that the type refers to itself */
    @Accessors
    boolean recursive

    /*
     * The node's children, i.e., the nodes representing the complex types that this complex type
     * refers to. Empty for recursive nodes.
     */
    @Accessors(PUBLIC_GETTER)
    val List<TypeGraphNode> children = newLinkedList

    /**
     * Constructor
     */
    new(ComplexType type, String fieldName, TypeGraphNode parent) {
        this.type = type
        this.fieldName = fieldName
        this.parent = parent

        if (parent !== null)
            depth = parent.depth + 1
        else
            depth = 1
    }

    /**
     * Is this node the root node of the graph?
     */
    def isRoot() {
        return depth === 1
    }

    /**
     * Get information about primitive types, depending on the node type, in the form of a map of
     * fields' names to their primitive types.
     *
     * Conceptually, each entry of the map corresponds to a DataField instance. However, as we
     * cannot instantiate this metamodel concept that easy, we just use a "simple" map for the
     * necessary information.
     */
    def getPrimitiveTypeFields(ORDERING ordering) {
        val primitiveTypeFieldInfo = <String, PrimitiveType> newHashMap

        if (!type.isPrimitiveCollection && !type.isStructure && !type.isStructuredCollection)
            return primitiveTypeFieldInfo

        /*
         * Type is a primitively typed collection. This means, that the collection exhibits one
         * "field" that has no name and whose type is the primitive collection type.
         */
        if (type.isPrimitiveCollection) {
            primitiveTypeFieldInfo.put("", (type as CollectionType).primitiveType)
            return primitiveTypeFieldInfo
        }

        /*
         * Type is data structure (and hence may have data fields) or structured collection, i.e., a
         * collection consisting of named and typed fields.
         */
        var EList<DataField> dataFields = null
        if (type.isStructure)
            // For structures resolve inheritance hierarchy and use the resulting "effective" data
            // fields
            dataFields = (type as DataStructure).effectiveFields
        else if (type.isStructuredCollection)
            dataFields = (type as CollectionType).dataFields

        val primitiveDataFields = dataFields
            .filter[it.effectiveType instanceof PrimitiveType]
            .toList

        if (ordering !== ORDERING.NONE)
            primitiveDataFields.sort(new DataFieldComparator(ordering))

        primitiveDataFields.forEach[primitiveTypeFieldInfo.put(name, primitiveType)]
        return primitiveTypeFieldInfo
    }

    /**
     * Convenience method that returns primitively typed fields of the node type without an ordering
     */
    def getPrimitiveTypeFields() {
        return getPrimitiveTypeFields(ORDERING.NONE)
    }

    /**
     * Add a new child node if this node is not recursive
     */
    def addChild(TypeGraphNode newChild) {
        if (isRecursive)
            return false

        return children.add(newChild)
    }
}