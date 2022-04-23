package de.fhdo.lemma.analyzer.lib.impl.antipattern.strategies.service

import de.fhdo.lemma.analyzer.lib.impl.antipattern.Antipattern
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice

interface AntipatternServiceAnalyzerStrategy {
    fun analyzeOperationNodes(microservices: Iterable<IntermediateMicroservice>): Collection<Antipattern>
}
