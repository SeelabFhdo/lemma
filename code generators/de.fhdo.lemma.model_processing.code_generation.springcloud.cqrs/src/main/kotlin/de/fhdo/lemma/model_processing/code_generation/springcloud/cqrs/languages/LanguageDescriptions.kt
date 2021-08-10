package de.fhdo.lemma.model_processing.code_generation.springcloud.cqrs.languages

import de.fhdo.lemma.ServiceDslStandaloneSetup
import de.fhdo.lemma.model_processing.annotations.LanguageDescriptionProvider
import de.fhdo.lemma.model_processing.languages.LanguageDescriptionProviderI
import de.fhdo.lemma.model_processing.languages.XtextLanguageDescription
import de.fhdo.lemma.service.ServicePackage

/**
 * [LanguageDescriptionProvider] for the CQRS Genlet as expected by LEMMA's model processing framework.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@LanguageDescriptionProvider
internal class DescriptionProvider : LanguageDescriptionProviderI {
    override fun getLanguageDescription(forLanguageNamespace: Boolean, forFileExtension: Boolean,
        languageNamespaceOrFileExtension: String) = when(languageNamespaceOrFileExtension) {
            "services" -> SERVICE_DSL_LANGUAGE_DESCRIPTION
            else -> null
        }
}

/**
 * [XtextLanguageDescription] for the Service DSL.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val SERVICE_DSL_LANGUAGE_DESCRIPTION = XtextLanguageDescription(ServicePackage.eINSTANCE,
    ServiceDslStandaloneSetup())