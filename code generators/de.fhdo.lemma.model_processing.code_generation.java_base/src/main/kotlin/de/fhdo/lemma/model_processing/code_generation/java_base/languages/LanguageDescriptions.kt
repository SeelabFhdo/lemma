package de.fhdo.lemma.model_processing.code_generation.java_base.languages

import de.fhdo.lemma.data.intermediate.IntermediatePackage as IntermediateDataPackage
import de.fhdo.lemma.ServiceDslStandaloneSetup
import de.fhdo.lemma.data.DataDslStandaloneSetup
import de.fhdo.lemma.data.DataPackage
import de.fhdo.lemma.service.intermediate.IntermediatePackage as IntermediateServicePackage
import de.fhdo.lemma.model_processing.annotations.LanguageDescriptionProvider
import de.fhdo.lemma.model_processing.languages.LanguageDescriptionProviderI
import de.fhdo.lemma.model_processing.languages.XmiLanguageDescription
import de.fhdo.lemma.model_processing.languages.XtextLanguageDescription
import de.fhdo.lemma.service.ServicePackage
import de.fhdo.lemma.technology.mapping.MappingPackage
import de.fhdo.lemma.technology.mappingdsl.MappingDslStandaloneSetup

/**
 * [LanguageDescriptionProvider] for the Java base generator as expected by LEMMA's model processing framework.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@LanguageDescriptionProvider
internal class DescriptionProvider : LanguageDescriptionProviderI {
    override fun getLanguageDescription(forLanguageNamespace : Boolean, forFileExtension : Boolean,
        languageNamespaceOrFileExtension : String) = when(languageNamespaceOrFileExtension) {
            DataPackage.eNS_URI, "data" -> DATA_DSL_LANGUAGE_DESCRIPTION
            MappingPackage.eNS_URI, "mapping" -> MAPPING_DSL_LANGUAGE_DESCRIPTION
            IntermediateDataPackage.eNS_URI -> INTERMEDIATE_DATA_MODEL_LANGUAGE_DESCRIPTION
            IntermediateServicePackage.eNS_URI -> INTERMEDIATE_SERVICE_MODEL_LANGUAGE_DESCRIPTION
            ServicePackage.eNS_URI, "services" -> SERVICE_DSL_LANGUAGE_DESCRIPTION
            else -> null
        }
}

/**
 * [XtextLanguageDescription] for the Data DSL.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val DATA_DSL_LANGUAGE_DESCRIPTION = XtextLanguageDescription(DataPackage.eINSTANCE, DataDslStandaloneSetup())

/**
 * [XtextLanguageDescription] for the Mapping DSL.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val MAPPING_DSL_LANGUAGE_DESCRIPTION
    = XtextLanguageDescription(MappingPackage.eINSTANCE, MappingDslStandaloneSetup())

/**
 * [XtextLanguageDescription] for the Service DSL.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val SERVICE_DSL_LANGUAGE_DESCRIPTION = XtextLanguageDescription(ServicePackage.eINSTANCE,
    ServiceDslStandaloneSetup())

/**
 * [XmiLanguageDescription] for intermediate data models.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val INTERMEDIATE_DATA_MODEL_LANGUAGE_DESCRIPTION = XmiLanguageDescription(IntermediateDataPackage.eINSTANCE)

/**
 * [XmiLanguageDescription] for intermediate service models.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val INTERMEDIATE_SERVICE_MODEL_LANGUAGE_DESCRIPTION
    = XmiLanguageDescription(IntermediateServicePackage.eINSTANCE)