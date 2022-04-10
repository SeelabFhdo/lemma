package de.fhdo.lemma.model_processing.code_generation.springcloud.cqrs

import de.fhdo.lemma.model_processing.utils.findAliasForTechnology
import de.fhdo.lemma.service.Microservice

/**
 * Get alias of CQRS technology model from [Microservice].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun Microservice.cqrsAlias() = technologyReferences.findAliasForTechnology(CQRS_TECHNOLOGY_NAMES)