package de.fhdo.lemma.analyzer.lib.analyzers

import de.fhdo.lemma.analyzer.lib.AnalyzerI
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode

/**
 * Perform basic analyses on service models.
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
interface AntiPatternAnalyzerI : AnalyzerI {
    /**
     * Print the name of a container
     */
    fun findContainerName() : List<String>
}