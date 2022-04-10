package de.fhdo.lemma.model_processing.code_generation.springcloud.domain_events

import de.fhdo.lemma.model_processing.code_generation.java_base.forTechnologies
import de.fhdo.lemma.model_processing.utils.findAliasForTechnology
import de.fhdo.lemma.service.Microservice
import de.fhdo.lemma.technology.mapping.ComplexTypeMapping

/**
 * Get alias of Domain Events technology model from [Microservice].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val Microservice.domainEventsAlias
    get() = technologyReferences.findAliasForTechnology(DOMAIN_EVENTS_TECHNOLOGY_NAMES)

/**
 * Get alias of Domain Events technology model from [ComplexTypeMapping].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val ComplexTypeMapping.domainEventsAlias
    get() = technologyReferences.findAliasForTechnology(DOMAIN_EVENTS_TECHNOLOGY_NAMES)

/**
 * Build the [Set] of qualified aspect names for the DomainEvents technology from this [String] representing a simple
 * aspect name. For instance, for the simple name "EventGroup" this function returns the [Set]
 * {"DomainEvents.EventGroup", "domainEvents.EventGroup"}.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun String.forDomainEventsTechnology() = forTechnologies(DOMAIN_EVENTS_TECHNOLOGY_NAMES)