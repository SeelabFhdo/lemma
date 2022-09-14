package de.fhdo.lemma.typechecking.complex_types

import de.fhdo.lemma.data.ComplexType
import java.util.List
import de.fhdo.lemma.data.DataStructure
import de.fhdo.lemma.data.PrimitiveType
import de.fhdo.lemma.data.DataField
import de.fhdo.lemma.data.CollectionType
import de.fhdo.lemma.typechecking.TypeCheckerI
import de.fhdo.lemma.typechecking.complex_types.data_structures.NodeSeries
import de.fhdo.lemma.typechecking.complex_types.data_structures.TypeGraph
import de.fhdo.lemma.typechecking.complex_types.data_structures.NodePair
import de.fhdo.lemma.typechecking.complex_types.data_structures.DataFieldComparator
import de.fhdo.lemma.typechecking.complex_types.data_structures.DataFieldComparator.ORDERING
import de.fhdo.lemma.typechecking.TypecheckingUtils
import de.fhdo.lemma.technology.TechnologySpecificDataStructure
import de.fhdo.lemma.technology.TechnologySpecificCollectionType
import de.fhdo.lemma.data.Enumeration
import com.google.common.base.Function
import de.fhdo.lemma.data.PrimitiveValue

/**
 * TypeChecker implementation for ComplexTypes.
 *
 * It basically works as follows:
 *   (1) Convert both passed complex types into type graphs.
 *   (2) Iterate over the nodes (in the form of node pairs) of the graphs until the compatibility of
 *       the pair of the passed complex types got decided.
 *   (3) The actual decision if the currently iterated node pair is compatible is based on the
 *       pair's nodes' types, which all have different compatibility requirements.
 *   (4) Add new series of node pairs to check, resulting from the currently iterated one.
 *   (5) Get the next pair to check from the accompanying iterator, if the root node pair's
 *       compatibility did not get decided along the way. Goto (iii)
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
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
        val typesEqual = typesEqual(basicType, typeToCheck)
        val structureCheck = basicType.isStructure && typeToCheck.isStructure
        val primitiveCollectionCheck = basicType.isPrimitiveCollection &&
            typeToCheck.isPrimitiveCollection
        val structuredCollectionCheck = basicType.isStructuredCollection &&
            typeToCheck.isStructuredCollection
        val enumerationCheck = basicType.isIsEnumeration && typeToCheck.isIsEnumeration
        val nodeTypeKindsEqual = structureCheck || primitiveCollectionCheck ||
            structuredCollectionCheck || enumerationCheck

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

        // The node pair is incompatible if its nodes encapsulate incompatible primitive collections
        else if (primitiveCollectionCheck &&
            !primitiveCollectionsCompatible(basicType as CollectionType,
                typeToCheck as CollectionType))
            iterator.markCurrentPairIncompatible()

        // The node pair is incompatible if its nodes encapsulate incompatible structured
        // collections
        else if (structuredCollectionCheck &&
            !structuredCollectionsCompatible(basicType as CollectionType,
                typeToCheck as CollectionType))
            iterator.markCurrentPairIncompatible()

        // The node pair is incompatible if its nodes encapsulate incompatible enumerations
        else if (enumerationCheck &&
            !enumerationsCompatible(basicType as Enumeration, typeToCheck as Enumeration))
            iterator.markCurrentPairIncompatible()
    }

    /**
     * Check if two types are equal
     */
    private def typesEqual(ComplexType basicType, ComplexType typeToCheck) {
        /* Types are equal and hence compatible */
        if (basicType == typeToCheck)
            return true

        /*
         * Perform technology-specific checks. The basic type is equal to the type to check if (i)
         * the latter is technology-specific and (ii) if the basic type has the same underlying type
         * kind as the type to check, i.e., is a structure type when the type to check is a
         * technology-specific structure type or is a collection type when the type to check is a
         * technology-specific collection type. That is, because technology-specific complex types
         * do not include data fields or primitive types (for primitive collections).
         */
        if (!TypecheckingUtils.isTechnologySpecific(typeToCheck))
            return false

        val basicStructure = basicType.isStructure ||
            basicType instanceof TechnologySpecificDataStructure
        if (basicStructure && typeToCheck instanceof TechnologySpecificDataStructure)
            return true

        val basicCollection = basicType.isPrimitiveCollection ||
            basicType instanceof TechnologySpecificCollectionType
        if (basicCollection && typeToCheck instanceof TechnologySpecificCollectionType)
            return true
    }

    /**
     * Check if two DataStructures are compatible
     */
    private def structuresCompatible(DataStructure basicStructure, DataStructure structureToCheck) {
        /*
         * Check if extension relationship between basic node and node to check is invalid. For an
         * assignment, node to check may be a specialization of the basic node, but not vice versa.
         * For example, a Car is a Vehicle and a variable of type Vehicle may hold a Car instance.
         * On the other hand, a Vehicle is not a Car and a variable of type Car may not hold a
         * Vehicle instance.
         *
         * This follows Java semantics and constrains type assignment. However, if there is no
         * extension relationship between two complex types, they might be assigned anyway, if the
         * basic type "extends" the type to check, i.e., if it exhibits more data fields. The
         * semantics of an inheritance extension may hence be circumvented, which is intentional.
         */
        if (structureToCheck.isExtensionOf(basicStructure))
            return true

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
     * Check if two primitively typed collections are compatible
     */
    private def primitiveCollectionsCompatible(CollectionType basicCollection,
        CollectionType collectionToCheck) {
        /* The collections are compatible if the primitive types are compatible */
        val basicPrimitiveType = basicCollection.primitiveType
        val primitiveTypeToCheck = collectionToCheck.primitiveType
        return basicPrimitiveType.isCompatibleWith(primitiveTypeToCheck)
    }

    /**
     * Check if two structured collections are compatible
     */
    private def structuredCollectionsCompatible(CollectionType basicCollection,
        CollectionType collectionToCheck) {
        /* Is basic collection smaller than collection to check? */
        val basicCollectionIsSmaller = basicCollection.compareFieldCounts(collectionToCheck) == -1
        if (basicCollectionIsSmaller)
            return false

        /* Check primitive type compatibility of the collections' fields */
        val basicPrimitiveFields = basicCollection.dataFields
            .filter[effectiveType instanceof PrimitiveType].toList

        val primitiveFieldsToCheck = collectionToCheck.dataFields
            .filter[effectiveType instanceof PrimitiveType].toList

        if (!primitiveFieldsCompatible(basicPrimitiveFields, primitiveFieldsToCheck))
            return false

        return true
    }

    /**
     * Check compatibility of primitive types of lists of primitively typed DataFields
     */
    private def primitiveFieldsCompatible(List<DataField> basicPrimitiveFields,
        List<DataField> toCheckPrimitiveFields) {
        /*
         * The checking algorithm is based on two lists:
         * - The first list contains the primitively typed fields of the basic node. That is the
         *   node that may "receive" the other node, i.e., the typed field to which another field of
         *   another type (the "to check node") gets assigned. In the list, the primitive types are
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
        // "Receiving" (basic) side needs to have at least as much fields as the "sending" (to
        // check) side
        if (basicPrimitiveFields.size < toCheckPrimitiveFields.size)
            return false

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
     * Check if two enumerations are compatible
     */
    private def enumerationsCompatible(Enumeration basicEnum, Enumeration enumToCheck) {
        /*
         * Check if all fields of the enumeration to check, i.e., the value-providing enumeration,
         * exhibit initialization values. That is, because we then check, if the basic enumeration,
         * i.e., the value-receiving enumeration exhibits all initialization values of the
         * enumeration to check. In this case, enumeration fields could be converted by mapping them
         * to their counterparts with the same initialization values in the basic enumeration.
         */
        if (enumToCheck.fields.exists[initializationValue === null])
            return false

        /*
         * Compare initialization values. The enumerations are compatible, if the basic enumeration
         * contains all initialization values of the other enumeration.
         */
        if (!containsAllInitializationValues(basicEnum, enumToCheck, [stringValue]) ||
            !containsAllInitializationValues(basicEnum, enumToCheck, [booleanValue]) ||
            !containsAllInitializationValues(basicEnum, enumToCheck, [numericValue]))
            return false

        return true
    }

    /**
     * Helper to check if an enumeration contains all initialization values of another enumeration.
     * Note, that this helper does not consider the types of the values. That is, the
     * "fieldValueGetter" parameter needs to take care that only values of the same type, e.g.,
     * string or numeric, are to be compared, in case this is desired.
     */
    private def <T> containsAllInitializationValues(Enumeration basicEnum, Enumeration enumToCheck,
        Function<PrimitiveValue, T> fieldValueGetter) {
        val basicValues = basicEnum.fields
            .filter[
                initializationValue !== null &&
                fieldValueGetter.apply(initializationValue) !== null
            ]
            .map[initializationValue.valueAsString]
            .toSet()

        val toCheckValues = enumToCheck.fields
            .filter[
                initializationValue !== null &&
                fieldValueGetter.apply(initializationValue) !== null
            ]
            .map[initializationValue.valueAsString]
            .toSet()

        return basicValues.containsAll(toCheckValues)
    }

    /**
     * Get name of a ComplexType
     */
    override typeName(ComplexType type) {
        return type.name
    }
}