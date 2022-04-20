package de.fhdo.lemma.analyzer.lib.impl.service

import de.fhdo.lemma.analyzer.lib.analyzers.MicroserviceNameAnalyzerI
import de.fhdo.lemma.analyzer.lib.impl.AbstractSingleModelTypeAnalyzer
import de.fhdo.lemma.analyzer.lib.impl.Cache
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel

/**
 * Analyses microservices and returns their name
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
internal class MicroserviceNameAnalyzer
    : AbstractSingleModelTypeAnalyzer<IntermediateServiceModel>(IntermediateServiceModel::class.java),
    MicroserviceNameAnalyzerI {
    /**
     * Return the name of a IntermediateMicroservice
     */
    override fun findMicroserviceNames(): List<String> {
        val microserviceNameList = mutableListOf<String>()
        Cache.allMicroservices().forEach{microserviceNameList.add(it.qualifiedName)}
        return microserviceNameList
    }
}