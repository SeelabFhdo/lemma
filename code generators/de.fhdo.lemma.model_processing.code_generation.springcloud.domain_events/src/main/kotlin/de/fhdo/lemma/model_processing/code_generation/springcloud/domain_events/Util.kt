package de.fhdo.lemma.model_processing.code_generation.springcloud.domain_events

import de.fhdo.lemma.model_processing.utils.findAliasForTechnology
import de.fhdo.lemma.service.Microservice
import de.fhdo.lemma.technology.mapping.ComplexTypeMapping

/**
 * Get alias of Domain Events technology model from [Microservice].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val Microservice.domainEventsAlias
    get() = technologyReferences.findAliasForTechnology("DomainEvents")

/**
 * Get alias of Domain Events technology model from [ComplexTypeMapping].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val ComplexTypeMapping.domainEventsAlias
    get() = technologyReferences.findAliasForTechnology("DomainEvents")