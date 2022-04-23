package de.fhdo.lemma.analyzer.lib.impl.antipattern.strategies.operation

import de.fhdo.lemma.analyzer.lib.impl.antipattern.Antipattern
import de.fhdo.lemma.operation.intermediate.IntermediateContainer

interface AntipatternOperationAnalyzerStrategy {
    fun analyzeOperationNodes(allOperationNodes: Iterable<IntermediateContainer>): Collection<Antipattern>
}
