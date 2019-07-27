package de.fhdo.lemma.utils

import java.util.List

/**
 * This class enables the creation of distinct series of element pairs from two lists. Specifically,
 * it will create series of element pairs, in which each pair does not contain an element of either
 * list more than once. Take for example two lists of elements [E1, E2, E3] and [E4, E5, E6]. The
 * class returns a list of series of element pairs that looks like this:
 * [
 * 	 [[E1, E4], [E2, E5], [E3, E6]],
 * 	 [[E1, E4], [E2, E6], [E3, E5]],
 *   [[E1, E5], [E2, E4], [E3, E6]],
 *   [[E1, E5], [E2, E6], [E3, E4]],
 *   [[E1, E6], [E2, E4], [E3, E5]],
 *   [[E1, E6], [E2, E5], [E3, E4]]
 * ]
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class DistinctPairSeriesBuilder<T> {
    /**
     * Build distinct pairs series. An optional list of mandatory pairs of elements from list1 and
     * list2 may be given. If this list is not null and not empty only series that contain all of
     * the mandatory pairs will be created. If for example, the list of mandatory pairs is
     * [[E1, E4]] then only the first two series of the example with be returned.
     */
    def buildPairSeries(List<T> list1, List<T> list2, Pairs<T> mandatoryPairs) {
        if (list1 === null || list1.empty || list2 === null || list2.empty)
            throw new IllegalArgumentException("Lists must not be null or empty")

        if (list1.size !== list2.size)
            throw new IllegalArgumentException("Lists must have same size")

        /*
         * Build cartesian pairs of both lists. If both lists have n elements this will result in n
         * pairs.
         */
        val List<Pairs<T>> cartesianPairsSeries =
            buildCartesianPairsSeries(list1, list2)

        /*
         * Create distinct series of Pairs from series of distinct indices. If both lists have n
         * elements, the result of the method will be n^2 - n series with n Pairs each.
         */
        val distinctPairsSeries = <Pairs<T>> newArrayList
        val distinctIndicesSeries = calculateDistinctIndexSeries(list1.size)
        for (indices : distinctIndicesSeries) {
            val distinctPairs = new Pairs

            for (pairIndex : 0..<cartesianPairsSeries.size) {
                val currentPairs = cartesianPairsSeries.get(pairIndex)
                val currentPairsIndex = indices.get(pairIndex)
                val newPair = currentPairs.getPair(currentPairsIndex)
                if (newPair.isMandatory(mandatoryPairs))
                    distinctPairs.addPair(newPair)
            }

            distinctPairsSeries.add(distinctPairs)
        }

        return distinctPairsSeries
    }

    /**
     * Build distinct pairs series without mandatory pairs
     */
    def buildPairSeries(List<T> list1, List<T> list2) {
        return buildPairSeries(list1, list2, null)
    }

    /**
     * Check if a Pair is mandatory
     */
    private def isMandatory(Pair<T> pair, Pairs<T> mandatoryPairs) {
        if (mandatoryPairs === null || mandatoryPairs.empty)
            return true

        return mandatoryPairs.exists[
            it.get(0) == pair.get(0) &&
            it.get(1) == pair.get(1)
        ]
    }

    /**
     * Create a series of cartesian Pairs from two lists. For lists [E1, E2, E3] and [E4, E5, E6]
     * this will produce a list of the following cartesian Pairs instances (each row is a Pairs
     * instance with the first element being the same in the row):
     * [
     *   [[E1, E4], [E1, E5], [E1, E6]],
     *   [[E2, E4], [E2, E5], [E2, E6]],
     *   [[E3, E4], [E3, E5], [E3, E6]]
     * ]
     */
    private def <T> buildCartesianPairsSeries(List<T> list1, List<T> list2) {
        val List<Pairs<T>> pairsList = newArrayList

        for (element1 : list1) {
            val newPairsForElement1 = new Pairs
            for(element2 : list2)
                newPairsForElement1.addPair(element1, element2)
            pairsList.add(newPairsForElement1)
        }

        return pairsList
    }

    /**
     * Calculate series of list indices, in which all indices are distinct. For a list with 3
     * elements this will produce the following list of index series:
     * [
     *   [0, 1, 2],
     *   [0, 2, 1],
     *   [1, 0, 2],
     *   [1, 2, 0],
     *   [2, 0, 1],
     *   [2, 1, 0]
     * ]
     */
    private def calculateDistinctIndexSeries(int elementCount) {
        val List<List<Integer>> series = newArrayList

        /*
         * Handle special case for one element for which other indices do not exist and hence
         * rotating them is not necessary.
         */
        if (elementCount == 1) {
            val singleIndexSeries = <Integer> newArrayList
            singleIndexSeries.add(0)
            series.add(singleIndexSeries)
            return series
        }

        /* The current index is the first one in the series to be currently produced */
        for (currentIndex : 0..<elementCount) {
            /* Determine indices being distinct from the current one */
            val otherIndices = <Integer> newArrayList
            for (index : 0..<elementCount)
                if (index !== currentIndex)
                    otherIndices.add(index)

            /*
             * Produce current series by putting the current index in the first position and then
             * rotating the list of n other indices n times. For example, when assuming an element
             * count of 2 and the current index being 0, this will lead to the list of other indices
             * than the current one, i.e., [1, 2], being rotated twice:
             *   1) [1, 2] (rotating window number = 1)
             *   2) [2, 1] (rotating window number = 2)
             */
            val otherIndexCount = otherIndices.size
            val indicesRotation = new RotatingWindowList(otherIndices, otherIndexCount)
            var currentWindow = 1
            while(currentWindow <= otherIndexCount) {
                val currentIndicesSeries = <Integer> newArrayList
                /*
                 * Add current indices series elements. In the example, the current index will be 0
                 * for the first run of the method's outer loop. For the first and second run of
                 * this inner loop, the rotated other indices will be added to the "0" element,
                 * which in the first run result in a distinct indices series of [0, 1, 2] and in
                 * the second run in series [0, 2, 1].
                 */
                currentIndicesSeries.add(currentIndex)
                currentIndicesSeries.addAll(indicesRotation.getWindow(currentWindow))
                series.add(currentIndicesSeries)

                currentWindow++
            }
        }

        return series
    }
}

/**
 * Class representing a pair of two arbitrary elements
 */
class Pair<T> {
    var List<T> elements = newArrayList

    /**
     * Constructor
     */
    new(T element1, T element2) {
        elements.add(element1)
        elements.add(element2)
    }

    /**
     * Get element at index
     */
    def get(int index) {
        return elements.get(index)
    }
}

/**
 * Class representing a list of element Pairs
 */
class Pairs<T> implements Iterable<Pair<T>> {
    var List<Pair<T>> pairs = newArrayList

    /**
     * Add two elements as Pair instance to the list
     */
    def addPair(T element1, T element2) {
        addPair(new Pair(element1, element2))
    }

    /**
     * Add a pair to the list
     */
    def addPair(Pair<T> pair) {
        pairs.add(pair)
    }

    /**
     * Size of pair list
     */
    def size() {
        return pairs.size
    }

    /**
     * Get pair element at given index
     */
    def getPair(int index) {
        return pairs.get(index)
    }

    /**
     * Enable callers to iterate over all pairs
     */
    override iterator() {
        return pairs.iterator
    }

}