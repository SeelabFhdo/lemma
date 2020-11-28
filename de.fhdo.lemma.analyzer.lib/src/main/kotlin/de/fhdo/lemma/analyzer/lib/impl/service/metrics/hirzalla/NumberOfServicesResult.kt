package de.fhdo.lemma.analyzer.lib.impl.service.metrics.hirzalla

import de.fhdo.lemma.service.intermediate.IntermediateServiceModel

/**
 * Class to communicate the result of the number of microservices metric, which consists of the number of services and
 * also identifies the number of services per [IntermediateServiceModel].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
data class NumberOfServicesResult(val numberOfServices: Int,
    val numberOfServicesPerModel: Map<IntermediateServiceModel, Int>)