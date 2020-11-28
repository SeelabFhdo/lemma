package de.fhdo.lemma.analyzer.lib.impl.service.metrics.hirzalla

import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel

/**
 * Class to communicate the result of the Service Composition Pattern (SCP) metric. It consists of the metrics result,
 * the intermediary results as described in the paper of
 * [Hirzalla et al.](https://link.springer.com/chapter/10.1007/978-3-642-01247-1_5), and the atomic services,
 * structurally composite services, and runtime composite services that contributed to the calculation of the metrics
 * result.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
data class ServiceCompositionResult(
    val scpResult: Double,
    val scpsResult: Double,
    val scpwfResult: Double,
    val atomicServices: Map<IntermediateServiceModel, List<IntermediateMicroservice>>,
    val structurallyCompositeServices: Map<IntermediateServiceModel, List<IntermediateMicroservice>>,
    val runtimeCompositeServices: Map<IntermediateServiceModel, List<IntermediateMicroservice>>,
)