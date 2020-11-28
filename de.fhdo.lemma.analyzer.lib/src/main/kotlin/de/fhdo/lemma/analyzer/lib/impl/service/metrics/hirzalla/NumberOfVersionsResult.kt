package de.fhdo.lemma.analyzer.lib.impl.service.metrics.hirzalla

import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel

typealias VersionsPerMicroservice = Map<IntermediateMicroservice, Set<String>>
typealias VersionsPerServiceModelAndMicroservice = Map<IntermediateServiceModel, VersionsPerMicroservice>

/**
 * Class to communicate the result of the number of versions metric, which consists of the average number of versions
 * per service and also identifies the number of versions per [IntermediateServiceModel].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
data class NumberOfVersionsResult(val averageVersionsPerMicroservice: Double,
    val versionsPerModelAndMicroservice: VersionsPerServiceModelAndMicroservice)