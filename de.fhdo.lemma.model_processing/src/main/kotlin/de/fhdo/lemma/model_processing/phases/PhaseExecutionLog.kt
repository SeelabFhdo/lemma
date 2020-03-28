package de.fhdo.lemma.model_processing.phases

import java.lang.IllegalStateException

/**
 * Singleton for phase execution logging.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object PhaseExecutionLog {
    // We use a [LinkedHashMap], because it preserves the insertion order of entries and can thus be used to represent
    // the order in which phases were executed (next to information about the execution)
    private val log = LinkedHashMap<String, PhaseExecutionInfo>()

    /**
     * Add execution information about a phase to the log
     */
    internal fun addEntry(phaseId: String, executionInfo: PhaseExecutionInfo) {
        if (log.containsKey(phaseId))
            throw IllegalStateException("Phase execution log already contains execution information about phase " +
                    "\"$phaseId\"")

        log[phaseId] = executionInfo
    }

    /**
     * Check if a phase was executed
     */
    internal fun phaseExecuted(phaseId: String) = log.containsKey(phaseId)

    /**
     * Check if a phase was executed successfully. Note, that this method returns false, both when the phase was not
     * executed successfully and when it never got executed.
     */
    internal fun phaseExecutedSuccessfully(phaseId: String) = log[phaseId]?.executionFinishedSuccessfully ?: false

    /**
     * Check if a phase execution failed for some reason, i.e., if the phase throw an [Exception]. Note, that this
     * method returns false, both when the phase was executed successfully and when it never got executed.
     */
    internal fun phaseExecutionFailed(phaseId: String) : Boolean {
        val executionFinishedSuccessfully = log[phaseId]?.executionFinishedSuccessfully
        return if (executionFinishedSuccessfully != null)
            !executionFinishedSuccessfully
        else
            false
    }
}

/**
 * Phase execution information.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class PhaseExecutionInfo(val executionFinishedSuccessfully: Boolean)