package de.fhdo.lemma.analyzer.lib.analyzers

import de.fhdo.lemma.analyzer.lib.AnalyzerI
import de.fhdo.lemma.analyzer.lib.impl.service.metrics.athanasopoulos.InterfaceLevelGraph
import de.fhdo.lemma.service.intermediate.IntermediateInterface
import de.fhdo.lemma.technology.CommunicationType

/**
 * Calculate metrics from the suite of [Athanasopoulos et al.](https://ieeexplore.ieee.org/document/6763104).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
interface AthanasopoulosMetricsAnalyzerI : AnalyzerI {
    /**
     * Calculate [InterfaceLevelGraph] that identifies message-level cohesion lack
     */
    fun calculateMessageLevelCohesionLack(iface: IntermediateInterface, communicationType: CommunicationType)
        : InterfaceLevelGraph

    /**
     * Calculate [InterfaceLevelGraph] that identifies conversation-level cohesion lack
     */
    fun calculateConversationLevelCohesionLack(iface: IntermediateInterface, communicationType: CommunicationType)
        : InterfaceLevelGraph

    /**
     * Calculate [InterfaceLevelGraph] that identifies domain-level cohesion lack
     */
    fun calculateDomainLevelCohesionLack(iface: IntermediateInterface) : InterfaceLevelGraph
}