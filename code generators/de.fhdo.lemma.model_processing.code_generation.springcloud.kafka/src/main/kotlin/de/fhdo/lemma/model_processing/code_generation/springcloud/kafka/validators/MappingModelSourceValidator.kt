package de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.validators

import de.fhdo.lemma.data.DataStructure
import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.SourceModelValidator
import de.fhdo.lemma.model_processing.builtin_phases.source_model_validation.AbstractXtextSourceModelValidator
import de.fhdo.lemma.model_processing.builtin_phases.source_model_validation.SourceModelValidationMode
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.isAvroProtocolFile
import de.fhdo.lemma.model_processing.code_generation.springcloud.kafka.kafkaAlias
import de.fhdo.lemma.model_processing.languages.convertToAbsoluteFileUrisInPlace
import de.fhdo.lemma.model_processing.utils.getMappingAspect
import de.fhdo.lemma.model_processing.utils.getPropertyValue
import de.fhdo.lemma.technology.mapping.ComplexTypeMapping
import de.fhdo.lemma.technology.mapping.MappingPackage
import de.fhdo.lemma.technology.mapping.TechnologyMapping
import de.fhdo.lemma.technology.mapping.TechnologySpecificFieldMapping
import de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.validation.Check

/**
 * Validator for mapping models. We implement the validation as an Xtext source model validator to take advantage of
 * LEMMA's Live Validation capabilities.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@SourceModelValidator(
    validationMode = SourceModelValidationMode.XTEXT,
    supportedFileExtensions = ["mapping"]
)
internal class MappingModelSourceValidator : AbstractXtextSourceModelValidator() {
    override fun getLanguageNamespace() = MappingPackage.eNS_URI

    /**
     * Prepare import model paths before validation
     */
    @Before
    private fun prepareImportModelPaths(resource: Resource) {
        val sm = resource.contents[0] as TechnologyMapping
        sm.imports.convertToAbsoluteFileUrisInPlace(resource)
    }

    /**
     * Check correct application of AvroSchema aspect on [ComplexTypeMapping]
     */
    @Check
    private fun checkAvroSchema(mapping: ComplexTypeMapping) {
        val kafkaAlias = mapping.kafkaAlias ?: return
        val avroSchemaAspect = mapping.getMappingAspect(kafkaAlias, "AvroSchema") ?: return

        if (mapping.type.type !is DataStructure)
            error("Avro schemas may only be specified for data structures",
                MappingPackage.Literals.COMPLEX_TYPE_MAPPING__ASPECTS)

        checkAvroSchemaProperties(avroSchemaAspect)
    }

    /**
     * Reusable helper to check AvroSchema aspect properties
     */
    private fun checkAvroSchemaProperties(avroSchemaAspect: TechnologySpecificImportedServiceAspect) {
        val isAvroProtocol = avroSchemaAspect.getPropertyValue("file")!!.isAvroProtocolFile()
        val schemaType = avroSchemaAspect.getPropertyValue("type")
        if (isAvroProtocol && schemaType == null)
            error("""Missing "type" property for Avro protocol file""", avroSchemaAspect,
                MappingPackage.Literals.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__ASPECT)
        else if (!isAvroProtocol && schemaType != null)
            warning("""Specification of "type" property without Avro protocol file""", avroSchemaAspect,
                MappingPackage.Literals.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__ASPECT)
    }

    /**
     * Check correct application of AvroSchema aspect on [TechnologySpecificFieldMapping]
     */
    @Check
    private fun checkAvroSchema(mapping: TechnologySpecificFieldMapping) {
        val kafkaAlias = mapping.typeMapping?.kafkaAlias ?: return
        val avroSchemaAspect = mapping.getMappingAspect(kafkaAlias, "AvroSchema") ?: return

        if (mapping.dataField == null || mapping.dataField.effectiveType !is DataStructure)
            error("Avro schemas may only be specified for data fields with domain-specific structure types",
                MappingPackage.Literals.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__ASPECTS)

        checkAvroSchemaProperties(avroSchemaAspect)
    }
}