package de.fhdo.lemma.analyzer.lib.impl.service.metrics.hirzalla

import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel

/**
 * Class to communicate the result of the stateless services metric, which consists of the metrics result, as well as
 * the stateless and stateful services per [IntermediateServiceModel].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
data class StatelessServicesResult(
    val result: Double,
    val statelessServicesPerModel: Map<IntermediateServiceModel, List<IntermediateMicroservice>>,
    val statefulServicesPerModel: Map<IntermediateServiceModel, List<IntermediateMicroservice>>
)