package de.fhdo.lemma.typechecking.complex_types.data_structures

import de.fhdo.lemma.data.ComplexType
import java.util.Deque
import java.util.ArrayDeque
import java.util.Set
import org.eclipse.emf.common.util.EList
import de.fhdo.lemma.data.DataField
import de.fhdo.lemma.data.DataStructure
import de.fhdo.lemma.data.CollectionType
import org.eclipse.xtext.naming.QualifiedName
import java.util.Iterator
import java.util.NoSuchElementException
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Represents the structure of a complex type as a directed multigraph. Each node in the graph
 * corresponds to a complex type.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class TypeGraph {
    /* Root node */
    @Accessors(PUBLIC_GETTER)
    var TypeGraphNode rootNode

    /* Height of the graph */
    var height = 0

    /**
     * Constructor with the root type as parameter. The constructor will traverse the complex type
     * and directly build the graph.
     */
    new(ComplexType type) {
        /* Create root node */
        rootNode = addNode(type, "", null)

        /*
         * Create the graph by traversing the root type
         */
        val Deque<TypeGraphNode> nodesToVisit = new ArrayDeque()
        nodesToVisit.push(rootNode)

        // Store types already visited to prevent infinite loops
        val Set<ComplexType> visitedComplexTypes = newHashSet

        // Traverse root type using a stack (non-recursive)
        do {
            val currentNode = nodesToVisit.pop
            val currentType = currentNode.type
            val notVisited = visitedComplexTypes.add(currentType)

            /*
             * Create new nodes for complex types: Complex types of fields become nodes in the graph
             * if the type hasn't been already visited. Each new node points to the currently
             * traversed type as its parent.
             */
            var EList<DataField> currentTypeFields = null

            if (currentType.isStructure)
                currentTypeFields = (currentType as DataStructure).effectiveFields
            else if (currentType.isStructuredCollection) {
                val currentCollectionType = currentType as CollectionType
                currentTypeFields = currentCollectionType.dataFields
            }

            if (currentTypeFields !== null)
                currentTypeFields
                    .filter[it.effectiveType instanceof ComplexType]
                    .forEach[
                        if (notVisited) {
                            val complexType = it.effectiveType as ComplexType
                            val qualifiedName = QualifiedName.create(it.qualifiedNameParts).toString
                            val newNode = addNode(complexType, qualifiedName, currentNode)
                            nodesToVisit.add(newNode)
                        }
                    ]
        } while (!nodesToVisit.empty)
    }

    /**
     * Add a new type node to the graph
     */
    private def addNode(ComplexType type, String fieldName, TypeGraphNode parentNode) {
        var newNode = new TypeGraphNode(type, fieldName, parentNode)
        newNode.setRecursive(isRecursive(newNode))

        if (parentNode !== null)
            parentNode.children.add(newNode)

        if (newNode.isRecursive)
            setParentsRecursive(newNode)

        if (newNode.getDepth() > height)
            height = newNode.getDepth()

        return newNode
    }

    /**
     * Check if a node is recursive, i.e., if a complex type refers to itself
     */
    private def isRecursive(TypeGraphNode node) {
        var parentNode = node.parent
        while (parentNode !== null) {
            if (parentNode.type == node.type)
                return true

            parentNode = parentNode.parent
        }

        return false
    }

    /**
     * Flag parents of a recursive node, that have the same type as the node (i.e. are recursive),
     * as being recursive
     */
    private def setParentsRecursive(TypeGraphNode node) {
        if (!node.isRecursive) {
            return
        }

        /* Collect parents that need to be flagged */
        val parentNodesTodo = <TypeGraphNode> newArrayList
        var currentParent = node.parent
        while (currentParent !== null) {
            if (currentParent.type == node.type)
                parentNodesTodo.add(currentParent)

            currentParent = currentParent.parent
        }

        /*
         * Set collected parents to recursive, except first one, which is the root of the recursion.
         */
        val lastLevelIndex = parentNodesTodo.size - 1
        for (i : 0..<lastLevelIndex)
            parentNodesTodo.get(i).setRecursive(true)
    }

    /**
     * Return an Iterator for the graph
     */
    def iterator() {
        return new BreadthFirstTypeGraphIterator(this)
    }

    /**
     * Build string representation of graph
     */
    override toString() {
        val buffer = new StringBuffer

        buffer.append("Height: " + height + "\n")

        val iter = iterator()
        while (iter.hasNext) {
            val node = iter.next

            for (i : 1..< node.depth)
                buffer.append("\t")

            buffer.append(node.depth + " " + node.type.name)

            if (node.isRecursive)
                buffer.append(" (recursive)")

            val primitiveFieldInfo = node.primitiveTypeFields

            if (!primitiveFieldInfo.empty)
                buffer.append(": ")

            val lastPrimitiveFieldIndex = primitiveFieldInfo.size - 1
            var currentPrimitiveFieldIndex = 0
            for (fieldInfo : primitiveFieldInfo.entrySet) {
                val fieldName = fieldInfo.key
                val fieldType = fieldInfo.value.typeName

                buffer.append(fieldType)
                if (!fieldName.empty)
                    buffer.append(" (" + fieldName + ")")

                if (currentPrimitiveFieldIndex < lastPrimitiveFieldIndex)
                    buffer.append(", ")

                currentPrimitiveFieldIndex++
            }

            buffer.append("\n")

            if (!node.children.empty) {
                for (i : 1..< node.depth)
                    buffer.append("\t")
                buffer.append("--> ")
            }

            val lastChildIndex = node.children.size - 1
            for (i : 0..<node.children.size) {
                val currentChild = node.children.get(i)
                buffer.append(currentChild.type.name)

                if (currentChild.isRecursive)
                    buffer.append(" (recursive)")

                if (i < lastChildIndex)
                    buffer.append(", ")
            }

            if (!node.children.empty)
                buffer.append("\n")
        }

        buffer.append("\n")
        return buffer.toString
    }

    /**
      * Iterator implementation for type graphs that traverses the graph using breadth-first search
      */
    static class BreadthFirstTypeGraphIterator implements Iterator<TypeGraphNode> {
        var TypeGraph typeGraph
        val nodesToVisit = <TypeGraphNode> newArrayList

        new(TypeGraph typeGraph) {
            this.typeGraph = typeGraph
            nodesToVisit.add(typeGraph.rootNode)
        }

        override hasNext() {
            return !nodesToVisit.empty
        }

        override next() {
            if (!hasNext())
                throw new NoSuchElementException

            val next = nodesToVisit.remove(0)
            nodesToVisit.addAll(next.children)
            return next
        }
}
}