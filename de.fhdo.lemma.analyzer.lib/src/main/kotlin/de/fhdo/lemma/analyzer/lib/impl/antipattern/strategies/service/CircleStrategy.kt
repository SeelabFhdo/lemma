package de.fhdo.lemma.analyzer.lib.impl.antipattern.strategies.service

import de.fhdo.lemma.analyzer.lib.impl.antipattern.Antipattern
import de.fhdo.lemma.analyzer.lib.impl.antipattern.AntipatternType
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice

class CircleStrategy : AntipatternServiceAnalyzerStrategy {
    override fun analyzeOperationNodes(microservices: Iterable<IntermediateMicroservice>): Collection<Antipattern> {
        val microserviceMap = getMicroserviceMap(microservices)
        val setOfServiceLists: MutableSet<List<String>> = mutableSetOf()
        for (key in microserviceMap.keys) {
            recursiveCall(key, key, listOf(key), setOfServiceLists, mutableSetOf<String>(), microserviceMap)

        }
        val result = mutableSetOf<Antipattern>()
        setOfServiceLists.forEach{result.add(Antipattern(AntipatternType.CYCLIC_DEPENDENCY, "A cyclic dependency was detected. The cyclic dependency consists of $it."))}
        return result
    }

    private fun recursiveCall(
        parentKey: String,
        checkedKey: String,
        viewedElements: List<String>,
        setOfLoopLists: MutableSet<List<String>>,
        alreadyViewedElements: MutableSet<String>,
        microserviceMap: MutableMap<String, IntermediateMicroservice>
    ) {
        val microservice = microserviceMap[checkedKey]
        for (requiredMicroservice in microservice!!.requiredMicroservices) {
            if(alreadyViewedElements.contains(requiredMicroservice.qualifiedName)){
                continue
            }
            if(requiredMicroservice.qualifiedName.equals(parentKey)){
                viewedElementsAddToSetIfNoEquivalentInSet(setOfLoopLists,viewedElements)
                continue
            }
            alreadyViewedElements.add(requiredMicroservice.qualifiedName)
            val list = viewedElements + listOf(requiredMicroservice.qualifiedName)
            recursiveCall(parentKey, requiredMicroservice.qualifiedName, list ,setOfLoopLists, alreadyViewedElements,microserviceMap)
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

    private fun getMicroserviceMap(microservices: Iterable<IntermediateMicroservice>): MutableMap<String, IntermediateMicroservice> {
        val map = mutableMapOf<String, IntermediateMicroservice>()
        microservices.forEach { map[it.qualifiedName] = it }
        return map
    }
}