package de.fhdo.ddmm.typechecking.complex_types

import java.util.Iterator
import de.fhdo.ddmm.typechecking.complex_types.data_structures.NodePair
import java.util.NoSuchElementException
import de.fhdo.ddmm.typechecking.complex_types.data_structures.NodeSeries
import java.util.List

/**
 * Iterator that finds the next pair of nodes, whose compatibility shall be checked by the
 * {@link ComplexTypeChecker}.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de>Florian Rademacher</a>
 */
class ComplexTypeCheckingIterator implements Iterator<NodePair> {
    var NodePair rootPair
    var NodePair currentPair
    var decisionHistory = <NodePair, Boolean> newHashMap

    /**
     * Constructor
     */
    new(NodePair rootPair) {
        this.rootPair = rootPair
    }

    /**
     * Return whether there is a pair to be checked or not. In case the compatibility of the initial
     * root pair has been determined, this returns false.
     *
     * Note that hasNext() has the same runtime complexity as next(), i.e., there are optimizations
     * like caching the next element. It might therefore be advisable, for performance reasons, to
     * just use next() and catch the resulting exception.
     */
    override hasNext() {
        if (!rootPair.compatibilityUndecided)
            return false

        return nextUndecidedPair !== null
    }

    /**
     * Get next node pair whose compatibility is yet undecided. Throws NoSuchElementException in
     * case the compatibility of the initial root pair has been determined or if there exists no
     * undecided pair anymore.
     *
     * Note that this method also assigns the determined next pair to an internal "currentPair"
     * field. This makes the use of methods such as markCurrentPairCompatible() more convenient and
     * consistent, as no node pair needs to be passed because they directly operate on the iterators
     * current state represented by the nodePair field.
     */
    override next() {
        if (!rootPair.compatibilityUndecided)
            throw new NoSuchElementException

        if (currentPair === null)
            currentPair = rootPair
        else
            currentPair = nextUndecidedPair

        if (currentPair === null)
            throw new NoSuchElementException

        return currentPair
    }

    /**
     * Helper method to find next undecided pair
     */
    private def nextUndecidedPair() {
        var iterPair = currentPair

        // Perform a breadth-first search for the next undecided node pair by iterating over the
        // child NodeSeries and the grandchild NodePairs of the current node pair (see the
        // implementation of the NodePair class for details)
        while (iterPair !== null) {
            var childSeries = iterPair.childSeries
            val undecidedSeries = childSeries.findFirst[compatibilityUndecided]

            if (undecidedSeries !== null) {
                val undecidedPair = undecidedSeries.childPairs.findFirst[compatibilityUndecided]

                if (undecidedPair !== null)
                    return undecidedPair
            }

            // If all grandchild node pairs were decided, go a level upwards to the great
            // grandfather NodePair (i.e., the NodePair that yielded the current iterPair's parent
            // series)
            if (iterPair.parentSeries !== null)
                iterPair = iterPair.parentSeries.parentPair
            else
                iterPair = null
        }

        return null
    }

    /**
     * Return the compatibility of the current node pair's types if it was already decided or null
     * if it has not been decided yet
     */
    def currentPairTypeCompatibilityAlreadyDecided() {
        return decisionHistory.get(currentPair)
    }

    /**
     * Return the compatibility decision status of the currently iterated pair
     */
    def currentPairCompatibilityUndecided() {
        return currentPair.compatibilityUndecided
    }

    /**
     * Mark the current node pair being compatible and propagate that decision through the
     * NodePair-NodeSeries graph.
     *
     * The boolean parameter determines if for the compatibility decision the compatibility of the
     * current pair's children should be considered. Deactivating this check will lead to setting
     * the current pair's compatibility to true and propagating that change directly through the
     * graph. This might makes sense in cases where it is obvious that a node pair is compatible,
     * e.g., when both nodes have the same type.
     */
    def markCurrentPairCompatible(boolean bypassChildSeriesCompatibilityCheck) {
        /*
         * Perform children check: If there isn't a child series for the current pair that is
         * compatible (which makes the pair itself compatible) abort. This is the normal behavior,
         * as a node pair can normally only be compatible if at least one of its child series is
         * compatible.
         */
        if (!bypassChildSeriesCompatibilityCheck && !currentPair.childSeries.empty)
            if (!currentPair.childSeries.exists[compatible]) {
                return
            }

        /*
         * Set current pair to being compatible and propagate that compatibility to all parent
         * series and node pairs.
         *
         * The parent series is also set to being compatible if all of its child node pairs are
         * marked as being compatible. This automatically leads to the series parent node pair being
         * compatible and so on.
         */
        var propagationPair = currentPair

        do {
            propagationPair.compatible = true
            addToHistory(propagationPair)

            val parentSeries = propagationPair.parentSeries
            val allPairsOfParentSeriesCompatible = if (parentSeries !== null)
                !parentSeries.childPairs.exists[!compatible]
            else
                false

            if (allPairsOfParentSeriesCompatible) {
                parentSeries.compatible = true
                propagationPair = parentSeries.parentPair
            } else
                propagationPair = null
        } while (propagationPair !== null)
    }

    /**
     * Convenience method to mark the current node pair being compatible with taking its children's
     * compatibility into account
     */
    def markCurrentPairCompatible() {
        markCurrentPairCompatible(false)
    }

    /**
     * Mark the current node pair being incompatible and propagate that decision through the
     * NodePair-NodeSeries graph.
     */
    def markCurrentPairIncompatible() {
        currentPair.compatible = false
        var parentSeries = currentPair.parentSeries

        // If a pair is incompatible then its parent series is also incompatible, i.e., to be
        // compatible a series must only contain compatible pairs
        if (parentSeries !== null)
            currentPair.parentSeries.compatible = false

        // Propagate incompatibility through the rest of the graph: The grandfather node pair the
        // current pair is incompatible if all of its series are incompatible (or more specifically,
        // if there exists no series that is compatible or whose compatibility has not yet been
        // decided). If the grandfather pair is incompatible so is its parent series and so on.
        var propagationPair = if (parentSeries !== null) currentPair.parentSeries.parentPair

        while (propagationPair !== null) {
            val allSeriesOfPairIncompatible = !propagationPair.childSeries
                .exists[compatible || compatibilityUndecided]

            if (allSeriesOfPairIncompatible) {
                propagationPair.compatible = false
                addToHistory(propagationPair)
            }

            parentSeries = propagationPair.parentSeries
            if (allSeriesOfPairIncompatible && parentSeries !== null) {
                parentSeries.compatible = false
                propagationPair = parentSeries.parentPair
            } else
                propagationPair = null
        }
    }

    /**
     * Add node series to the current node pair to be eventually iterated if necessary, i.e., if the
     * root node pair doesn't get decided before
     */
    def addSeries(NodeSeries series) {
        currentPair.addChildSeries(series)
    }

    /**
     * Convenience method to add a list of series all at once
     */
    def addAllSeries(List<NodeSeries> series) {
        series.forEach[addSeries(it)]
    }

    /**
     * Add a decided node pair to the decision history
     */
    private def addToHistory(NodePair nodePair) {
        decisionHistory.put(nodePair, nodePair.compatible)
    }
}