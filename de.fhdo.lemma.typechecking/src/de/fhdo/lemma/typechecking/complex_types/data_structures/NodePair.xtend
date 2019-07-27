package de.fhdo.lemma.typechecking.complex_types.data_structures

import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Represents an ordered pair of TypeGraphNodes.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 *
 * NodePairs and NodeSeries may represent their own kind of "graph", which has the following
 * properties:
 *     (1) The graph's root is always a NodePair.
 *     (2) After a NodePair, a level of NodeSeries (the NodePairs "children") follows.
 *     (3) After a NodeSeries, a level of NodePairs (the NodeSeries "children") follows.
 *
 * This (next to the TypeGraph) additional graph-like structure is used by the ComplexTypeChecker to
 * keep track of type nodes' compatibility and how it might be determined by child nodes.
 *
 * Take for example the following structures (and ignore that an inheritance relationship would make
 * sense; if the data models are distributed, there might not necessarily exist such a
 * relationship):
 *   structure Person {
 *     string firstname,
 *     string lastname
 *   }
 *
 *   structure Vehicle {
 *     string marque,
 *     Person owner
 *   }
 *
 *   structure CarOwner {
 *     string forename,
 *     string secondName,
 *     string surname,
 *     int age
 *   }
 *
 *   structure MotorDescription {
 *     int capacity,
 *     int valveCount
 *   }
 *
 *   structure Car {
 *     string marque,
 *     MotorDescription motorDescription,
 *     CarOwner carOwner
 *   }
 *
 * The question is now, might an instance of Car be assigned to an instance of Vehicle (vehicle =
 * car) and how to actually check that? The answer is yes. Why? Because there are "assignment
 * relationships" between all properties of Vehicle and selected properties of Car, which are valid
 * from the perspective of the underlying primitively typed fields:
 *   Vehicle.marque = Car.marque
 *   Vehicle.owner.firstname = Car.carOwner.forename,
 *   Vehicle.owner.lastname = Car.carOwner.surname (or secondName; both are strings)
 *
 * How are these relationships checked for complex types that do not have an inheritance
 * relationship? On the basis of a NodePair-NodeSeries graph that looks like the following:
 *     0 (Pair):      (Vehicle [children: Person], Car [children: CarOwner, MotorDescription])
 *                                                       |
 *     1 (Series):                               (Series1, Series2)
 *                                                  /       \
 *     2 (Pair):               ((Person, MotorDescription)) ((Person, CarOwner))
 * For each pair on level 2 that is part of a series on level 1 a type check will be performed. If
 * all pairs of a series have valid assignment relationships, the whole series consists of valid
 * assignments and is hence compatible. Following, the pair that this series belongs to (and hence
 * the assignment of "to check node" to "basic node" (see below) is valid. This property will be
 * propagated up to the root pair if possible marking it compatible (or incompatible) based on the
 * validity of assignments in the end.
 *
 */
class NodePair {
    /* "Basic node", i.e., the node that needs to receive an instance of the "node to check" */
    @Accessors(PUBLIC_GETTER)
    var TypeGraphNode basicNode

    /* "Node to check" if it's compatible, i.e., assignable, to the "basic node" */
    @Accessors(PUBLIC_GETTER)
    var TypeGraphNode nodeToCheck

    /*
     * Flag to indicate whether both nodes are compatible or not. Initially, the flag is null, which
     * communicates that the compatibility of the nodes has not been decided yet. Hence, it is of
     * the object type "Boolean" rather than the primitive type "boolean".
     */
    var Boolean compatible

    /* Series to which this pair belongs. Might be null for root pairs. */
    @Accessors
    var NodeSeries parentSeries

    /*
     * The node's index in its parent series. Starts with 1. In case this is a root node, the index
     * is zero. The field will be set by the parent NodeSeries object of the pair.
     */
    @Accessors
    var int seriesIndex

    /* Child node series */
    @Accessors(PUBLIC_GETTER)
    val childSeries = <NodeSeries> newArrayList

    /**
     * Constructor
     */
    new(TypeGraphNode basicNode, TypeGraphNode nodeToCheck) {
        this.basicNode = basicNode
        this.nodeToCheck = nodeToCheck
    }

    /**
     * Add a new child series to the pair
     */
    def addChildSeries(NodeSeries newChildSeries) {
        newChildSeries.parentPair = this
        newChildSeries.childIndex = childSeries.size
        childSeries.add(newChildSeries)
    }

    /**
     * Is this pair the last one in its parent series? Returns false for root node pairs.
     */
    def isLastPairInSeries() {
        if (rootPair)
            return false

        val siblings = parentSeries.childPairs
        return seriesIndex === siblings.size - 1
    }

    /**
     * Set compatibility of pair.
     *
     * Note that the parameter is the object type "Boolean", even if only true or false (and not
     * null) are allowed to be passed to this method (null will result in an
     * IllegalArgumentException). The reason for still having "Boolean" and not "boolean" is a
     * strange behavior of Xtend's code generation in case of object types. When "boolean" is used
     * as the parameter's type
     *     this.compatible = compatible
     * will be generated into
     *     setCompatible(compatible)
     * resulting in the setter being called recursively forever.
     */
    def void setCompatible(Boolean compatible) {
        if (compatible === null)
            throw new IllegalArgumentException("Compatibility flag must not be null")

        this.compatible = compatible
    }

    /**
     * Has node pair's compatibility been decided?
     */
    def compatibilityUndecided() {
        return compatible === null
    }

    /**
     * Has the node pair's compatibility been decided and is it compatible or not, eventually?
     */
    def isCompatible() {
        return !compatibilityUndecided && compatible === true
    }

    /**
     * Is this a root node pair?
     */
    def isRootPair() {
        return parentSeries === null
    }

    /**
     * Check for equality with other object based on the types encapsulated by the pair's nodes
     */
    override equals(Object object) {
        if (object === null || !(object instanceof NodePair))
            return false

        val otherPair = object as NodePair

        /* Get name of other's basic node */
        val otherBasicNode = otherPair.basicNode
        val otherBasicName = if (otherBasicNode !== null && otherBasicNode.type !== null)
            otherBasicNode.type.name
        else
            null

        /* Get name of other's node to check */
        val otherNodeToCheck = otherPair.nodeToCheck
        val otherToCheckName = if (otherNodeToCheck !== null && otherNodeToCheck.type !== null)
            otherNodeToCheck.type.name
        else
            null

        /* Get name of this basic node */
        val thisBasicName = if (basicNode !== null && basicNode.type !== null)
            basicNode.type.name
        else
            null

        /* Get name of this node to check */
        val thisToCheckName = if (nodeToCheck !== null && nodeToCheck.type !== null)
            nodeToCheck.type.name
        else
            null

        /* Compare for null */
        if (otherBasicName === null && thisBasicName === null &&
            otherToCheckName === null && thisToCheckName === null)
            return true
        else if (otherBasicName !== null && thisBasicName === null ||
            otherBasicName === null && thisBasicName !== null)
            return false
        else if (otherToCheckName !== null && thisToCheckName === null ||
            otherToCheckName === null && thisToCheckName !== null)
            return false

        /* Compare objects whose nodes both have names */
        return thisBasicName.equals(otherBasicName) && thisToCheckName.equals(otherToCheckName)
    }

    /**
     * Calculate hash code based on this node pair's types
     */
    override hashCode() {
        var hashCode = 0

        /* Add hash of name of this basic node */
        if (basicNode !== null &&
            basicNode.type !== null &&
            basicNode.type.name !== null)
            hashCode += basicNode.type.name.hashCode

        /* Add hash of name of this node to check */
        if (nodeToCheck !== null &&
            nodeToCheck.type !== null &&
            nodeToCheck.type.name !== null)
            hashCode += nodeToCheck.type.name.hashCode

        return hashCode
    }
}