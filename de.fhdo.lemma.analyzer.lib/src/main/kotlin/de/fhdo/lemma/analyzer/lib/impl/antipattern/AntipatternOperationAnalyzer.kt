package de.fhdo.lemma.analyzer.lib.impl.antipattern

import de.fhdo.lemma.analyzer.lib.analyzers.AntipatternOperationAnalyzerI
import de.fhdo.lemma.analyzer.lib.impl.AbstractSingleModelTypeAnalyzer
import de.fhdo.lemma.analyzer.lib.impl.Cache
import de.fhdo.lemma.analyzer.lib.impl.antipattern.strategies.operation.AntipatternOperationAnalyzerStrategy
import de.fhdo.lemma.analyzer.lib.impl.antipattern.strategies.operation.WrongAspectStrategy
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel

internal class AntipatternOperationAnalyzer : AbstractSingleModelTypeAnalyzer<IntermediateOperationModel>(IntermediateOperationModel::class.java), AntipatternOperationAnalyzerI {
    private var strategies = listOf<AntipatternOperationAnalyzerStrategy>(WrongAspectStrategy("ESB"))

    override fun checkExistingAntipattern(): Collection<Antipattern> {
        val allMicroservices = Cache.allMicroservices()
        val allOperations = Cache.allOperations()
        println(allOperations)
        val allOperationNodes = Cache.allOperationNodes()
        val result = mutableListOf<Antipattern>()
        strategies.forEach { result.addAll(it.analyzeOperationNodes(allOperationNodes)) }
        return result
    }
}