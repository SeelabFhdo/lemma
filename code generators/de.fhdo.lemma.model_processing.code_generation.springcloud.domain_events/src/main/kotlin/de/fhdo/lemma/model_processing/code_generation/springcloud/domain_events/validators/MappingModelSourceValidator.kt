package de.fhdo.lemma.model_processing.code_generation.springcloud.domain_events.validators

import de.fhdo.lemma.data.ComplexTypeFeature
import de.fhdo.lemma.data.DataStructure
import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.SourceModelValidator
import de.fhdo.lemma.model_processing.phases.validation.AbstractXtextModelValidator
import de.fhdo.lemma.model_processing.code_generation.springcloud.domain_events.domainEventsAlias
import de.fhdo.lemma.model_processing.languages.convertToAbsoluteFileUrisInPlace
import de.fhdo.lemma.model_processing.utils.hasMappingAspect
import de.fhdo.lemma.technology.mapping.ComplexTypeMapping
import de.fhdo.lemma.technology.mapping.MappingPackage
import de.fhdo.lemma.technology.mapping.TechnologyMapping
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.validation.Check

/**
 * Validator for mapping models. We implement the validation as an Xtext source model validator to take advantage of
 * LEMMA's Live Validation capabilities.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@SourceModelValidator
internal class MappingModelSourceValidator : AbstractXtextModelValidator() {
    override fun getSupportedFileExtensions() = setOf("mapping")

    /**
     * Prepare import model paths before validation
     */
    @Before
    private fun prepareImportModelPaths(resource: Resource) {
        val sm = resource.contents[0] as TechnologyMapping
        sm.imports.convertToAbsoluteFileUrisInPlace(resource)
    }

    /**
     * Check event group specification
     */
    @Check
    private fun checkGroup(mapping: ComplexTypeMapping) {
        val dataStructure = mapping.type.type as? DataStructure ?: return
        val domainEventsAlias = mapping.domainEventsAlias ?: return
        if (!mapping.hasMappingAspect(domainEventsAlias, "EventGroup"))
            return

        // The EventGroup aspect may only be applied to domain concepts with the domainEvent feature
        if (!dataStructure.hasFeature(ComplexTypeFeature.DOMAIN_EVENT))
            error("EventGroup aspect is only applicable to domain events",
                MappingPackage.Literals.COMPLEX_TYPE_MAPPING__TYPE)
    }
}