package de.fhdo.lemma.utils

import java.util.List

/**
 * List that enables callers to retrieve sub lists in the form of a "rotating window". Suppose a
 * list [5, 6, 7, 8, 9] and a window size 3. When a caller retrieves the window number 4 from the
 * list leveraging this list class, the result will be [8, 9, 5].
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class RotatingWindowList<T> {
    var List<T> list
    var int windowSize

    /**
     * Constructor
     */
    new(List<T> list, int windowSize) {
        if (list === null)
            throw new IllegalArgumentException("List must not be null")

        if (windowSize <= 0)
            throw new IllegalArgumentException("Window size must be greater than zero")

        if (windowSize > list.size)
            throw new IllegalArgumentException("Window size must not be greater than list size")

        this.list = list
        this.windowSize = windowSize
    }

    /**
     * Get window with given number. Window numbers start at 1 and may theoretically be as big
     * as Integer.MAX_VALUE as the number will be calculated relatively to the list's upper
     * and lower indexes.
     */
    def getWindow(int windowNumber) {
        if (windowNumber <= 0)
            throw new IllegalArgumentException("Window number must be greater than zero")

        /*
         * Calculate lower index
         * As the window numbers start at 1, we first decrement the number by 1 to get a zero-based
         * index as expected by the List interface. Then we constrain the result to the actual size
         * of the list to not exceed the upper bound of the list.
         */
        var lowerIndex = (windowNumber - 1) % list.size

        /*
         * Calculate upper index
         * The upper index is the lower index plus the window size and constrained to the list size.
         * This may result in the upper index being lower or equal than the calculated lower index,
         * when the upper index plus the window size exceeds the list boundaries. This will be
         * corrected when the sub-list is built.
         */
        var upperIndex = (lowerIndex + windowSize) % list.size

        var List<T> resultList = null
        if (lowerIndex < upperIndex)
            resultList = list.subListCopy(lowerIndex, upperIndex)
        else {
            // Handle exceeded upper index
            resultList = list.subListCopy(lowerIndex, list.size)
            resultList.addAll(list.subListCopy(0, upperIndex))
        }

        return resultList
    }

    /**
     * Create a sub-list from a list as a shallow copy of its elements, i.e., don't create a
     * sub-list view that reflects changes to the original list
     */
    private def subListCopy(List<T> list, int lowerIndex, int upperIndex) {
        val resultList = <T> newArrayList
        for (index : lowerIndex..<upperIndex)
            resultList.add(list.get(index))
        return resultList
    }
}