package de.fhdo.lemma.analyzer.lib.impl.antipattern.strategies.operation

import de.fhdo.lemma.analyzer.lib.impl.antipattern.Antipattern
import de.fhdo.lemma.analyzer.lib.impl.antipattern.AntipatternType
import de.fhdo.lemma.analyzer.lib.impl.antipattern.AspectExtractor
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode

/**
 * This aspect describes a usage
 */
class WrongAspectStrategy(val architecturePatternName: String, val antipatternType: AntipatternType, val description: String) : AntipatternOperationAnalyzerStrategy {
    override fun analyzeOperationNodes(allOperationNodes: Iterable<IntermediateOperationNode>): Collection<Antipattern> {
        val result = mutableListOf<Antipattern>()
        for (operationNode in allOperationNodes) {
            if(AspectExtractor.isArchitecturePatternDefined(operationNode.aspects,architecturePatternName)){
                result.add(Antipattern(antipatternType, "${description}. The service with the aspect is ${operationNode.name}"))
            }
        }
        return result
    }
}