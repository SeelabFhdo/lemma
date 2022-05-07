package de.fhdo.lemma.analyzer.lib.impl.antipattern.strategies.service

import de.fhdo.lemma.analyzer.lib.impl.antipattern.Antipattern
import de.fhdo.lemma.analyzer.lib.impl.antipattern.AntipatternType
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice

class APIVersionStrategy : AntipatternServiceAnalyzerStrategy {
    override fun analyzeOperationNodes(microservices: Iterable<IntermediateMicroservice>): Collection<Antipattern> {
        val antipatterns = mutableSetOf<Antipattern>()
        for (microservice in microservices) {
            if (microservice.endpoints.size>0 && microservice.version==null){
                antipatterns.add(Antipattern(AntipatternType.API_VERSIONING, "${microservice.name} has open endpoints, but no version. API-Changes wouldn't be noticed."))
            }
        }
        return antipatterns
    }
}