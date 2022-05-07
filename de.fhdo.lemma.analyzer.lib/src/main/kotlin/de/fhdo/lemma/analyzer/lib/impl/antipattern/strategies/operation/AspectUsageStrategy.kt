package de.fhdo.lemma.analyzer.lib.impl.antipattern.strategies.operation

import de.fhdo.lemma.analyzer.lib.impl.antipattern.Antipattern
import de.fhdo.lemma.analyzer.lib.impl.antipattern.AntipatternType
import de.fhdo.lemma.analyzer.lib.impl.antipattern.AspectExtractor
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode

class AspectUsageStrategy(val architecturePatternName: String, val antipatternType: AntipatternType, val description: String) : AntipatternOperationAnalyzerStrategy {
    override fun analyzeOperationNodes(allOperationNodes: Iterable<IntermediateOperationNode>): Collection<Antipattern> {
        val antipatterns = mutableListOf<Antipattern>()
        for (node in allOperationNodes) {
            if(AspectExtractor.isArchitecturePatternDefined(node.aspects,architecturePatternName)){
                val (connectedElements, tooManyDependent) = getConnectedElements(node, allOperationNodes)
                if(tooManyDependent){
                    antipatterns.add(Antipattern(antipatternType, "$description. Nodes $connectedElements are dependend on ${node.name} with ArchitecturePattern $architecturePatternName."))
                }
            }
        }
        return antipatterns
    }

    private fun getConnectedElements(node: IntermediateOperationNode, allOperationNodes: Iterable<IntermediateOperationNode>): Pair<MutableSet<String>, Boolean> {
        val mutableSet = mutableSetOf<String>()
        mutableSet.addAll(node.usedByNodes.map { it.name }.toList())
        for (operationNode in allOperationNodes) {
            val dependonnodes = operationNode.dependsOnNodes
            for (dependonnode in dependonnodes) {
                if(dependonnode.name.equals(node.name)){
                    mutableSet.add(node.name)
                }
            }
        }
        val dependendOnMoreThan1 = mutableSet.size > 1
        return mutableSet to dependendOnMoreThan1

    }
}