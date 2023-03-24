package de.fhdo.lemma.analyzer.lib.impl.antipattern

import de.fhdo.lemma.analyzer.lib.analyzers.AntipatternServiceAnalyzerI
import de.fhdo.lemma.analyzer.lib.impl.AbstractSingleModelTypeAnalyzer
import de.fhdo.lemma.analyzer.lib.impl.Cache
import de.fhdo.lemma.analyzer.lib.impl.antipattern.strategies.service.APIVersionStrategy
import de.fhdo.lemma.analyzer.lib.impl.antipattern.strategies.service.AntipatternServiceAnalyzerStrategy
import de.fhdo.lemma.analyzer.lib.impl.antipattern.strategies.service.CircleStrategy
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel

internal class AntipatternServiceAnalyzer : AbstractSingleModelTypeAnalyzer<IntermediateServiceModel>(
    IntermediateServiceModel::class.java), AntipatternServiceAnalyzerI {

    private var strategies = listOf<AntipatternServiceAnalyzerStrategy>(CircleStrategy(), APIVersionStrategy())

    override fun checkExistingAntipattern(): Collection<Antipattern> {
        val microservices = Cache.allMicroservices()
        val result = mutableListOf<Antipattern>()
        strategies.forEach { result.addAll(it.analyzeOperationNodes(microservices)) }
        return result
    }
}