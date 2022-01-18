package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.languages

import de.fhdo.lemma.ServiceDslStandaloneSetup
import de.fhdo.lemma.model_processing.annotations.LanguageDescriptionProvider
import de.fhdo.lemma.model_processing.languages.LanguageDescriptionProviderI
import de.fhdo.lemma.model_processing.languages.XmiLanguageDescription
import de.fhdo.lemma.model_processing.languages.XtextLanguageDescription
import de.fhdo.lemma.service.ServicePackage
import de.fhdo.lemma.data.intermediate.IntermediatePackage as IntermediateDataPackage
import de.fhdo.lemma.service.intermediate.IntermediatePackage as IntermediateServicePackage

@LanguageDescriptionProvider
internal class DescriptionProvider : LanguageDescriptionProviderI {
    override fun getLanguageDescription(forLanguageNamespace: Boolean, forFileExtension: Boolean,
                                        languageNamespaceOrFileExtension: String) = when(languageNamespaceOrFileExtension) {
        IntermediateDataPackage.eNS_URI -> INTERMEDIATE_DATA_MODEL_LANGUAGE_DESCRIPTION
        IntermediateServicePackage.eNS_URI -> INTERMEDIATE_SERVICE_MODEL_LANGUAGE_DESCRIPTION
        ServicePackage.eNS_URI -> SERVICE_DSL_LANGUAGE_DESCRIPTION
        else -> null
    }
}

internal val SERVICE_DSL_LANGUAGE_DESCRIPTION = XtextLanguageDescription(ServicePackage.eINSTANCE,
    ServiceDslStandaloneSetup()
)

internal val INTERMEDIATE_DATA_MODEL_LANGUAGE_DESCRIPTION = XmiLanguageDescription(IntermediateDataPackage.eINSTANCE)

internal val INTERMEDIATE_SERVICE_MODEL_LANGUAGE_DESCRIPTION
    = XmiLanguageDescription(IntermediateServicePackage.eINSTANCE)