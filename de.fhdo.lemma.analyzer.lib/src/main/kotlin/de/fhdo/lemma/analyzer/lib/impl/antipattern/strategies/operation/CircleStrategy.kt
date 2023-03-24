package de.fhdo.lemma.analyzer.lib.impl.antipattern.strategies.operation

import de.fhdo.lemma.analyzer.lib.impl.antipattern.Antipattern
import de.fhdo.lemma.analyzer.lib.impl.antipattern.AntipatternType
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode

class CircleStrategy : AntipatternOperationAnalyzerStrategy {
    override fun analyzeOperationNodes(allOperationNodes: Iterable<IntermediateOperationNode>): Collection<Antipattern> {
        val operationNodeMap = getOperationNodeMap(allOperationNodes)
        val setOfOperationNodeLists = mutableSetOf<List<String>>() //Hier sind die Loops drin
        for (key in operationNodeMap.keys) {
            recursiveCall(key, key, listOf(key), setOfOperationNodeLists, mutableSetOf(),operationNodeMap)
        }
        val result = mutableSetOf<Antipattern>()
        setOfOperationNodeLists.forEach{result.add(Antipattern(AntipatternType.CYCLIC_DEPENDENCY, "A cyclic dependency was detected. The cyclic dependency consists of $it"))}
        return result
    }

    private fun recursiveCall(
        parentKey: String,
        checkedKey: String,
        viewedElements: List<String>,
        setOfLoopLists: MutableSet<List<String>>,
        alreadyViewedElements: MutableSet<String>,
        operationNodeMap: MutableMap<String, IntermediateOperationNode>
    ) {
        val operationNode = operationNodeMap[checkedKey]
        for (requiredNode in operationNode!!.dependsOnNodes) {//TODO hier kombinieren depends on und requiredBy
            if(alreadyViewedElements.contains(requiredNode.name)){
                continue
            }
            if(requiredNode.name.equals(parentKey)){
                viewedElementsAddToSetIfNoEquivalentInSet(setOfLoopLists, viewedElements)
                continue
            }
            alreadyViewedElements.add(requiredNode.name)
            val list = viewedElements + listOf(requiredNode.name)
            recursiveCall(parentKey, requiredNode.name, list, setOfLoopLists, alreadyViewedElements, operationNodeMap)
        }
    }

    private fun viewedElementsAddToSetIfNoEquivalentInSet(
        setOfLoopLists: MutableSet<List<String>>,
        viewedElements: List<String>
    ) {
        for (existingList in setOfLoopLists) {
            if(existingList.size != viewedElements.size){
                continue
            }
            var cont = false
            for (viewedElement in viewedElements) {
                if(!existingList.contains(viewedElement)){
                    cont=true
                }
            }
            if(cont){
                continue
            }
            return
        }
        setOfLoopLists.add(viewedElements)
    }

    private fun getOperationNodeMap(operationNodes: Iterable<IntermediateOperationNode>): MutableMap<String, IntermediateOperationNode> {
        val map = mutableMapOf<String, IntermediateOperationNode>()
        operationNodes.forEach { map[it.name] = it }
        return map
    }
}