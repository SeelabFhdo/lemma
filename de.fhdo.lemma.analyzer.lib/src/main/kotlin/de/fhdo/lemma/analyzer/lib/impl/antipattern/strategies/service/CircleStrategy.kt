package de.fhdo.lemma.analyzer.lib.impl.antipattern.strategies.service

import de.fhdo.lemma.analyzer.lib.impl.antipattern.Antipattern
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice

class CircleStrategy : AntipatternServiceAnalyzerStrategy {
    override fun analyzeOperationNodes(microservices: Iterable<IntermediateMicroservice>): Collection<Antipattern> {
        val microserviceMap = getMicroserviceMap(microservices)
        val setOfServiceLists: Set<List<String>> = mutableSetOf()
        for (key in microserviceMap.keys) {

            //set Mit einzigartigen Loops füllen. Doppelte filtern
        }
        return listOf()
    }

    private fun getMicroserviceMap(microservices: Iterable<IntermediateMicroservice>): MutableMap<String, IntermediateMicroservice> {
        val map = mutableMapOf<String, IntermediateMicroservice>()
        microservices.forEach { map[it.qualifiedName] = it }
        return map
    }
}