package de.fhdo.lemma.analyzer.lib.impl.antipattern.strategies.operation

import de.fhdo.lemma.analyzer.lib.impl.antipattern.Antipattern
import de.fhdo.lemma.analyzer.lib.impl.antipattern.AntipatternType
import de.fhdo.lemma.analyzer.lib.impl.antipattern.AspectExtractor
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNodeReference

class MissingAspectStrategy(val architecturePatternName: String, val antipatternType: AntipatternType, val description: String, val endpointsRelevant: Boolean = false) : AntipatternOperationAnalyzerStrategy {
    override fun analyzeOperationNodes(allOperationNodes: Iterable<IntermediateOperationNode>): Collection<Antipattern> {
        val result = mutableSetOf<Antipattern>()
        for (node in allOperationNodes) {
            var skip = false
            if(endpointsRelevant && node.endpoints.size == 0){
                continue
            }
            if(AspectExtractor.isArchitecturePatternDefined(node.aspects, architecturePatternName)){
                continue
            }

            for(dependendOnNodeReference in node.dependsOnNodes) {
                val analyzedNode = getNodeWithName(dependendOnNodeReference, allOperationNodes)
                if(AspectExtractor.isArchitecturePatternDefined(analyzedNode.aspects, architecturePatternName)){
                    skip = true
                }
            }
            if (skip)continue
            for(usedByNodeReference in node.usedByNodes) {
                val analyzedNode = getNodeWithName(usedByNodeReference, allOperationNodes)
                if(AspectExtractor.isArchitecturePatternDefined(analyzedNode.aspects,architecturePatternName)){
                    skip=true
                }
            }
            if (skip)continue
            result.add(Antipattern(antipatternType, "$description. Object ${node.name} has no connection to a Operation-Node with ArchitecturePattern-Aspect and name '$architecturePatternName'"))
        }
        return result
    }

    private fun getNodeWithName(
        nodeReference: IntermediateOperationNodeReference,
        allOperationNodes: Iterable<IntermediateOperationNode>
    ): IntermediateOperationNode{
        for (node in allOperationNodes) {
            if(node.name.equals(nodeReference.name)){
                return node
            }
        }
        throw RuntimeException("This should never happen")
    }
}