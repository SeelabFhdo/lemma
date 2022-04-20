package de.fhdo.lemma.analyzer.lib.analyzers

import de.fhdo.lemma.analyzer.lib.AnalyzerI

/**
 * Perform basic analyses on service models.
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
interface MicroserviceNameAnalyzerI : AnalyzerI {
    /**
     * Print the name of a microservice
     */
    fun findMicroserviceNames(): List<String>
}