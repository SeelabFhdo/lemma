package de.fhdo.lemma.model_processing.code_generation.springcloud.languages

import de.fhdo.lemma.ServiceDslStandaloneSetup
import de.fhdo.lemma.data.intermediate.IntermediatePackage as IntermediateDataPackage
import de.fhdo.lemma.service.intermediate.IntermediatePackage as IntermediateServicePackage
import de.fhdo.lemma.model_processing.annotations.LanguageDescriptionProvider
import de.fhdo.lemma.model_processing.languages.LanguageDescription
import de.fhdo.lemma.model_processing.languages.LanguageDescriptionProviderI
import de.fhdo.lemma.model_processing.languages.XtextLanguageDescription
import de.fhdo.lemma.service.ServicePackage

/**
 * [LanguageDescriptionProvider] for the Spring Cloud generator as expected by LEMMA's model processing framework.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@LanguageDescriptionProvider
internal class DescriptionProvider : LanguageDescriptionProviderI {
    override fun getLanguageDescription(forLanguageNamespace: String) : LanguageDescription? {
        return when(forLanguageNamespace) {
            IntermediateDataPackage.eNS_URI -> INTERMEDIATE_DATA_MODEL_LANGUAGE_DESCRIPTION
            IntermediateServicePackage.eNS_URI -> INTERMEDIATE_SERVICE_MODEL_LANGUAGE_DESCRIPTION
            ServicePackage.eNS_URI -> SERVICE_DSL_LANGUAGE_DESCRIPTION
            else -> null
        }
    }
}

/**
 * [XtextLanguageDescription] for the Service DSL.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val SERVICE_DSL_LANGUAGE_DESCRIPTION = XtextLanguageDescription(ServicePackage.eINSTANCE,
    ServiceDslStandaloneSetup())

/**
 * [LanguageDescription] for intermediate data models.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val INTERMEDIATE_DATA_MODEL_LANGUAGE_DESCRIPTION = LanguageDescription(IntermediateDataPackage.eINSTANCE)

/**
 * [LanguageDescription] for intermediate service models.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val INTERMEDIATE_SERVICE_MODEL_LANGUAGE_DESCRIPTION = LanguageDescription(IntermediateServicePackage.eINSTANCE)