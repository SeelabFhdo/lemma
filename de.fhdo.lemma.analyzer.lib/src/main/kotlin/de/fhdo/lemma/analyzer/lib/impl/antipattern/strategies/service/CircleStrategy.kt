package de.fhdo.lemma.analyzer.lib.impl.antipattern.strategies.service

import de.fhdo.lemma.analyzer.lib.impl.antipattern.Antipattern
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice

class CircleStrategy : AntipatternServiceAnalyzerStrategy {
    override fun analyzeOperationNodes(microservices: Iterable<IntermediateMicroservice>): Collection<Antipattern> {
        val microserviceMap = getMicroserviceMap(microservices)
        for (key in microserviceMap.keys) {
            // TODO Circle
        }
        return listOf()
    }

    private fun getMicroserviceMap(microservices: Iterable<IntermediateMicroservice>): MutableMap<String, IntermediateMicroservice> {
        val map = mutableMapOf<String, IntermediateMicroservice>()
        microservices.forEach { map[it.qualifiedName] = it }
        return map
    }
}