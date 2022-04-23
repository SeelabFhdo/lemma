package de.fhdo.lemma.analyzer.lib.impl.antipattern.strategies.operation

import de.fhdo.lemma.analyzer.lib.impl.antipattern.Antipattern
import de.fhdo.lemma.operation.intermediate.IntermediateContainer

/**
 * This aspect describes a usage
 */
class WrongAspectStrategy(val architecturePatternName: String) : AntipatternOperationAnalyzerStrategy {
    override fun analyzeOperationNodes(allOperationNodes: Iterable<IntermediateContainer>): Collection<Antipattern> {
        for (operationNode in allOperationNodes) {
            val first = operationNode.aspects.filter { it.name.equals("ArchitecturePattern") }.first()
            println(first)
        }
        return listOf()
    }
}