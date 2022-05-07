package de.fhdo.lemma.analyzer.lib.impl.antipattern

import de.fhdo.lemma.analyzer.lib.analyzers.AntipatternOperationAnalyzerI
import de.fhdo.lemma.analyzer.lib.impl.AbstractSingleModelTypeAnalyzer
import de.fhdo.lemma.analyzer.lib.impl.Cache
import de.fhdo.lemma.analyzer.lib.impl.antipattern.strategies.operation.*
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode

internal class AntipatternOperationAnalyzer : AbstractSingleModelTypeAnalyzer<IntermediateOperationModel>(IntermediateOperationModel::class.java), AntipatternOperationAnalyzerI {
    private var strategies = setOf(
        CircleStrategy(),
        WrongAspectStrategy("ESB", AntipatternType.USAGE_ESB, "Using an 'Enterprise Service Bus' can make a solution too complex"),
        MissingAspectStrategy("ServiceDiscovery", AntipatternType.HARDCODED_ENDPOINTS, "A service discovery should be used"),
        AspectUsageStrategy("Database", AntipatternType.SHARED_PERSISTENCE, "Only one Service should access a data storage. In case of data separation, like different tables this can be ignored"),
        MissingAspectStrategy("LogServer", AntipatternType.LOCAL_LOGGING, "Log-Data should be stored central"),
        MissingAspectStrategy("Monitoring", AntipatternType.NO_MONITORING, "Services should be monitored central"),
        MissingAspectStrategy("API-Gateway", AntipatternType.NO_API_GATEWAY, "Although the service has endpoints no API-Gateway is connected", true)
    )

    override fun checkExistingAntipattern(): Collection<Antipattern>{
        val allInfrastuctureNodes = Cache.allInfrastuctureNodes()
        val allContainer = Cache.allContainer()
        val operationNodes = mutableListOf<IntermediateOperationNode>()
        operationNodes.addAll(allContainer)
        operationNodes.addAll(allInfrastuctureNodes)
        val result = mutableListOf<Antipattern>()
        strategies.forEach { result.addAll(it.analyzeOperationNodes(operationNodes)) }
        return result
    }
}