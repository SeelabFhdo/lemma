package de.fhdo.ddmm.model_processing.phases

import java.lang.ClassCastException

/**
 * Singleton that represents a memory area with which model processing phases can share data, e.g., in the form of
 * return parameters.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
object PhaseHeap {
    // The heap is a map that stores the data, e.g., a parameter's return value, of a certain model processing phase at
    // a given named address, e.g., a return parameter's name. Stored data can be null.
    private val heapEntries: MutableMap<String, MutableMap<String, Any?>> = mutableMapOf()

    /**
     * Setter operator function
     */
    operator fun set(phaseId: String, entryPair: Pair<String, Any?>) {
        val existingEntryMap = heapEntries.putIfAbsent(phaseId, mutableMapOf(entryPair))
        if (existingEntryMap != null)
            existingEntryMap[entryPair.first] = entryPair.second
    }

    /**
     * Check if the heap contains a given named address
     */
    fun contains(phaseId: String, entryKey: String)
        // We don't do "get(phaseId, entryKey) != null" to check if the entry is contained in the phase's entry map,
        // because we want to allow phases to store null values to communicate that an expected value was not
        // determinable
        = heapEntries.contains(phaseId) && heapEntries[phaseId]!!.contains(entryKey)

    /**
     * Getter operation function
     */
    operator fun get(phaseId: String, entryKey: String) : Any? = heapEntries[phaseId]?.get(entryKey)

    /**
     * Getter operation function with a [Class] argument to which the stored data shall be cast
     */
    operator fun <T: Any> get(phaseId: String, entryKey: String, clazz: Class<T>) : T? {
        return try {
            clazz.cast(get(phaseId, entryKey))
        } catch (ex: ClassCastException) {
            null
        }
    }

    /**
     * Check if the data of a certain phase at a given named address is the null value
     */
    fun isNull(phaseId: String, entryKey: String) : Boolean = get(phaseId, entryKey) == null

    /**
     * Check if the data of a certain phase at a given named address is not the null value
     */
    fun isNotNull(phaseId: String, entryKey: String) : Boolean = !isNull(phaseId, entryKey)

    /**
     * Check if the data of a certain phase at a given named address has the given type
     */
    fun <T: Any> isEntryOfType(phaseId: String, entryKey: String, clazz: Class<T>) : Boolean
        = clazz.isInstance(get(phaseId, entryKey))

    /**
     * Remove the data of a certain phase at a given named address
     */
    fun remove(phaseId: String, entryKey: String) = heapEntries[phaseId]?.remove(entryKey)
}