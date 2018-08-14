package de.fhdo.ddmm.data.typechecking.complex_types

import de.fhdo.ddmm.data.ComplexType
import java.util.List
import de.fhdo.ddmm.data.DataStructure
import de.fhdo.ddmm.data.PrimitiveType
import de.fhdo.ddmm.data.DataField
import de.fhdo.ddmm.data.ListType
import de.fhdo.ddmm.data.typechecking.TypeCheckerI
import de.fhdo.ddmm.data.typechecking.complex_types.data_structures.NodeSeries
import de.fhdo.ddmm.data.typechecking.complex_types.data_structures.TypeGraph
import de.fhdo.ddmm.data.typechecking.complex_types.data_structures.NodePair
import de.fhdo.ddmm.data.typechecking.complex_types.data_structures.DataFieldComparator
import de.fhdo.ddmm.data.typechecking.complex_types.data_structures.DataFieldComparator.ORDERING

/**
 * TypeChecker implementation for ComplexTypes.
 *
 * It basically works as follows:
 *   (1) Convert both passed complex types into type graphs.
 *   (2) Iterate over the nodes (in the form of node pairs) of the graphs until the compatibility of
 *       the pair of the passed complex types got decided.
 *   (3) The actual decision if the currently iterated node pair is compatible is based on the
 *       pair's nodes' types (structure, list with primitive type, structured list with named and
 *       typed fields), which all have different compatibility requirements.
 *   (4) Add new series of node pairs to check, resulting from the currently iterated one.
 *   (5) Get the next pair to check from the accompanying iterator, if the root node pair's
 *       compatibility did not get decided along the way. Goto (iii)
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de>Florian Rademacher</a>
 */
class ComplexTypeChecker implements TypeCheckerI<ComplexType> {
    /**
     * Check if type to check is compatible, i.e., assignable, to basic type
     */
    override compatible(ComplexType initialBasicType, ComplexType initialTypeToCheck) {
        /* Create type graphs for basic type and the type to check */
        val basicGraph = new TypeGraph(initialBasicType)
        val graphToCheck = new TypeGraph(initialTypeToCheck)

        /* Setup node pair iterator */
        var rootNodePair = new NodePair(basicGraph.rootNode, graphToCheck.rootNode)
        var iterator = new ComplexTypeCheckingIterator(rootNodePair)

        while (rootNodePair.compatibilityUndecided) {
            val iterPair = iterator.next

            /*
             * Perform compatibility check and marking, if the current node pairs
             * compatibility wasn't already checked
             */
            if (!checkAndMarkAlreadyDecided(iterator))
                checkAndMarkCompatibility(iterPair, iterator)

            /*
             * Add new node series to check and set current pair to being compatible if possible
             * (i.e., if no new undecided series get added)
             */
            if (iterator.currentPairCompatibilityUndecided) {
                val newNodeSeriesToCheck = NodeSeries.buildAllSeriesFor(iterPair)
                iterator.addAllSeries(newNodeSeriesToCheck)
                iterator.markCurrentPairCompatible()
            }
        }

        return rootNodePair.compatible
    }

    /**
     * Mark a current node pair as being compatible it this decision was already made in a previous
     * run. That is, further type checks are superfluous.
     */
    private def checkAndMarkAlreadyDecided(ComplexTypeCheckingIterator iterator) {
        val alreadyDecided = iterator.currentPairTypeCompatibilityAlreadyDecided

        if (alreadyDecided !== null) {
            if (alreadyDecided)
                iterator.markCurrentPairCompatible(true)
            else
                iterator.markCurrentPairIncompatible()

            return true
        } else
            return false
    }

    /**
     * Perform type checking of the current node pair and handle its results and directly mark its
     * compatibility
     */
    private def checkAndMarkCompatibility(NodePair iterPair, ComplexTypeCheckingIterator iterator) {
        val basicNode = iterPair.basicNode
        val basicType = basicNode.type

        val nodeToCheck = iterPair.nodeToCheck
        val typeToCheck = nodeToCheck.type

        /* Perform type-specific compatibility checking */
        val typesEqual = basicType == typeToCheck
        val structureCheck = basicType.isStructure && typeToCheck.isStructure
        val primitiveListCheck = basicType.isPrimitiveList && typeToCheck.isPrimitiveList
        val structuredListCheck = basicType.isStructuredList && typeToCheck.isStructuredList
        val nodeTypeKindsEqual = structureCheck || primitiveListCheck || structuredListCheck

        // The current pair is immediately compatible if its nodes encapsulate the same types
        if (typesEqual)
            iterator.markCurrentPairCompatible(true)

        // The node pair is incompatible if the kinds of both node types are not equal
        else if (!nodeTypeKindsEqual)
            iterator.markCurrentPairIncompatible()

        // The node pair is incompatible if its nodes encapsulate incompatible structures
        else if (structureCheck &&
            !structuresCompatible(basicType as DataStructure, typeToCheck as DataStructure))
            iterator.markCurrentPairIncompatible()

        // The node pair is incompatible if its nodes encapsulate incompatible primitive lists
        else if (primitiveListCheck&&
            !primitiveListsCompatible(basicType as ListType, typeToCheck as ListType))
            iterator.markCurrentPairIncompatible()

        // The node pair is incompatible if its nodes encapsulate incompatible structured lists
        else if (structuredListCheck &&
            !structuredListsCompatible(basicType as ListType, typeToCheck as ListType))
            iterator.markCurrentPairIncompatible()
    }
    /**
     * Check if two DataStructures are compatible
     */
    private def structuresCompatible(DataStructure basicStructure, DataStructure structureToCheck) {
        /*
         * Check if extension relationship between basic node and node to check is invalid. For an
         * assignment, node to check may be a specialization of the basic node, but not vice versa,
         * For example, a Car is a Vehicle and a variable of type Vehicle may hold a Car instance.
         * On the other hand, a Vehicle is not a Car and a variable of type Car may not hold a
         * Vehicle instance.
         *
         * This follows Java semantics and constrains type assignment. However, if there is no
         * extension relationship between two complex types, they might be assigned anyway, if the
         * basic type "extends" the type to check, i.e., if it exhibits more data fields. The
         * semantics of an inheritance extension may hence be circumvented, which is intentional.
         */
        if (basicStructure.isExtensionOf(structureToCheck))
            return false

        /* Is basic type smaller than type to check? */
        val basicTypeIsSmaller = basicStructure.compareFieldCounts(structureToCheck) == -1
        if (!structureToCheck.isExtensionOf(basicStructure) && basicTypeIsSmaller)
            return false

        /* Check compatibility of primitively typed effective fields */
        val basicPrimitiveFields = basicStructure.effectiveFields
            .filter[effectiveType instanceof PrimitiveType].toList

        val primitiveFieldsToCheck = structureToCheck.effectiveFields
            .filter[effectiveType instanceof PrimitiveType].toList

        if (!primitiveFieldsCompatible(basicPrimitiveFields, primitiveFieldsToCheck))
            return false

        return true
    }

    /**
     * Check if two primitively typed lists are compatible
     */
    private def primitiveListsCompatible(ListType basicList, ListType listToCheck) {
        /* The lists are compatible if the primitive types are compatible */
        val basicPrimitiveType = basicList.primitiveType
        val primitiveTypeToCheck = listToCheck.primitiveType
        return basicPrimitiveType.isCompatibleWith(primitiveTypeToCheck)
    }

    /**
     * Check if two structured lists are compatible
     */
    private def structuredListsCompatible(ListType basicList, ListType listToCheck) {
        /* Is basic list smaller than list to check? */
        val basicListIsSmaller = basicList.compareFieldCounts(listToCheck) == -1
        if (basicListIsSmaller)
            return false

        /* Check primitive type compatibility of the lists' fields */
        val basicPrimitiveFields = basicList.dataFields
            .filter[effectiveType instanceof PrimitiveType].toList

        val primitiveFieldsToCheck = listToCheck.dataFields
            .filter[effectiveType instanceof PrimitiveType].toList

        if (!primitiveFieldsCompatible(basicPrimitiveFields, primitiveFieldsToCheck))
            return false

        return true
    }

    /**
     * Check compatibility of primitive types of lists of primtively typed DataFields
     */
    private def primitiveFieldsCompatible(List<DataField> basicPrimitiveFields,
        List<DataField> toCheckPrimitiveFields) {
        /*
         * The checking algorithm is based on two lists:
         * - The first list contains the primitively typed fields of the basic node. That is the
         *   node that may "receive" the other node, i.e., the typed field to which another field of
         *   another type (the "to check node") gets assigned. In the list, the primtive types are
         *   ordered ascending, based on their sizes in bits as determined by
         *   PrimitiveType.sizeCompare(). The first list acts as an "availability list" that
         *   contains the fields being available to "receive" the remaining primitively typed fields
         *   of the node to check.
         * - The second list corresponds to the primitive typed fields of the node to check but in
         *   descending order.
         *
         * The algorithm now iterates over the second ("to check") list and tries to find a
         * compatible field in the first ("basic" or "availability") list. If a compatible field was
         * found, this is removed from the first list, hence not being "available" in any further
         * iterations. If no compatible field could be found, the nodes are not compatible as not
         * all of their primitively typed fields are compatible.
         *
         * The ordering of the lists ensures that the field that takes the most place is assigned to
         * the smallest possible field that is compatible and hence can hold its value. Take for
         * example two type graphs with the following fields (order according to the definition of
         * the corresponding complex types):
         *   "basic"                "to check"
         *     - string               - int
         *     - int                  - char
         *     - string               - float
         *     - double               - char
         * Within the type graphs, the default ordering is ascending based on the type sizes in
         * bits, i.e.
         *   "basic"                "to check"
         *     - int                  - char
         *     - double               - char
         *     - string               - float
         *     - string               - int
         * This leads to the type checker stating that the types are not compatible, because int and
         * double may hold both chars, but string may not hold float. Ordering the second list
         * descending by type size solves the problem:
         *   "basic"                "to check"
         *     - int                  - int
         *     - double               - float
         *     - string               - char
         *     - string               - char
         */
        val basicTypedFieldsAvailable = <DataField> newArrayList
        basicTypedFieldsAvailable.addAll(basicPrimitiveFields)
        basicTypedFieldsAvailable.sortWith(new DataFieldComparator(ORDERING.ASCENDING))

        val toCheckPrimitiveFieldsSorted = toCheckPrimitiveFields
            .sortWith(new DataFieldComparator(ORDERING.DESCENDING))
        for (fieldToCheck : toCheckPrimitiveFieldsSorted) {
            val toCheckType = fieldToCheck.primitiveType
            var compatibleFieldIsAvailable = false
            var availableCompatibleFieldIndex = 0
            var i = 0
            while (!compatibleFieldIsAvailable && i < basicTypedFieldsAvailable.size) {
                val correspondingType = basicTypedFieldsAvailable.get(i).primitiveType
                compatibleFieldIsAvailable = correspondingType.isCompatibleWith(toCheckType)
                availableCompatibleFieldIndex = i
                i++
            }

            if (compatibleFieldIsAvailable)
                basicTypedFieldsAvailable.remove(availableCompatibleFieldIndex)
            else
                return false
        }

        return true
    }

    /**
     * Get name of a ComplexType
     */
    override typeName(ComplexType type) {
        return type.name
    }
}