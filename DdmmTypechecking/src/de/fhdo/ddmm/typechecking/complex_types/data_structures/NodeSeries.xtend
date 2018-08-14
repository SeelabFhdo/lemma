package de.fhdo.ddmm.typechecking.complex_types.data_structures

import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Represents a series of node pairs.
 *
 * See the {@link NodePair} class for a detailed explanation on the semantics and usage of series.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de>Florian Rademacher</a>
 */
class NodeSeries {
    /* The parent node pair from which this series resulted */
    @Accessors
    var NodePair parentPair

    /* Index of the series in the parent pair's child series */
    @Accessors
    var int childIndex

    /* List of child pairs being part of the series */
    @Accessors(PUBLIC_GETTER)
    val childPairs = <NodePair> newArrayList

    /*
     * Flag to indicate whether all child pairs of the series (and hence the series itself) are
     * compatible or not. Initially, the flag is null, which communicates that the compatibility of
     * the series has not been decided yet. Hence, it is of the object type "Boolean" rather than
     * the primitive type "boolean".
     */
    var Boolean compatible

    /**
     * Convenience method to build all node series for a node pair (wrapper for
     * {@link NodeSeriesBuilder})
     */
    def static buildAllSeriesFor(NodePair nodePair) {
        NodeSeriesBuilder.buildNodeSeries(nodePair)
    }

    /**
     * Constructor
     */
    new() {}

    /**
     * Constructor with initial pair
     */
    new(NodePair initialPair, NodePair parentPair) {
        this.parentPair = parentPair
        addChildPair(initialPair)
    }

    /**
     * Add node pair to the series
     */
    def addChildPair(NodePair newPair) {
        newPair.parentSeries = this
        newPair.seriesIndex = childPairs.size
        childPairs.add(newPair)
    }

    /**
     * Is this series the last one in its parent node?
     */
    def isLastSeriesInPair() {
        val siblings = parentPair.childSeries
        return childIndex === siblings.size - 1
    }

    /**
     * Set compatibility of series.
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
     * Has node series's compatibility been decided?
     */
    def compatibilityUndecided() {
        return compatible === null
    }

    /**
     * Has the node series's compatibility been decided and is it compatible or not, eventually?
     */
    def isCompatible() {
        return !compatibilityUndecided && compatible === true
    }
}