package de.fhdo.lemma.model_processing.code_generation.springcloud.languages

import de.fhdo.lemma.ServiceDslStandaloneSetup
import de.fhdo.lemma.service.intermediate.IntermediatePackage
import de.fhdo.lemma.model_processing.annotations.LanguageDescriptionProvider
import de.fhdo.lemma.model_processing.languages.LanguageDescription
import de.fhdo.lemma.model_processing.languages.LanguageDescriptionProviderI
import de.fhdo.lemma.model_processing.languages.XtextLanguageDescription
import de.fhdo.lemma.service.ServicePackage

internal val SERVICE_DSL_LANGUAGE_DESCRIPTION = XtextLanguageDescription(ServicePackage.eINSTANCE,
    ServiceDslStandaloneSetup())

internal object IntermediateDataPackage {
    val eINSTANCE = de.fhdo.lemma.data.intermediate.IntermediatePackage.eINSTANCE!!
    val eNS_URI = de.fhdo.lemma.data.intermediate.IntermediatePackage.eNS_URI!!
}
internal val INTERMEDIATE_DATA_MODEL_LANGUAGE_DESCRIPTION = LanguageDescription(IntermediatePackage.eINSTANCE)

internal val INTERMEDIATE_SERVICE_MODEL_LANGUAGE_DESCRIPTION = LanguageDescription(IntermediatePackage.eINSTANCE)

@LanguageDescriptionProvider
internal class DescriptionProvider : LanguageDescriptionProviderI {
    override fun getLanguageDescription(forLanguageNamespace: String) : LanguageDescription? {
        return when(forLanguageNamespace) {
            IntermediateDataPackage.eNS_URI -> INTERMEDIATE_DATA_MODEL_LANGUAGE_DESCRIPTION
            IntermediatePackage.eNS_URI -> INTERMEDIATE_SERVICE_MODEL_LANGUAGE_DESCRIPTION
            ServicePackage.eNS_URI -> SERVICE_DSL_LANGUAGE_DESCRIPTION
            else -> null
        }
    }
}