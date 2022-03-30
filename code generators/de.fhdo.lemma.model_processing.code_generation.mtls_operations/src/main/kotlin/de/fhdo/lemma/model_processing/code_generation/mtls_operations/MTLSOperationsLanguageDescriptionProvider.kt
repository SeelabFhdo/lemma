package de.fhdo.lemma.model_processing.code_generation.mtls_operations

import de.fhdo.lemma.model_processing.annotations.LanguageDescriptionProvider
import de.fhdo.lemma.model_processing.languages.LanguageDescriptionProviderI
import de.fhdo.lemma.model_processing.languages.XmiLanguageDescription
import de.fhdo.lemma.operation.intermediate.IntermediatePackage

@LanguageDescriptionProvider
class MTLSOperationsLanguageDescriptionProvider : LanguageDescriptionProviderI {

    override fun getLanguageDescription(
        forLanguageNamespace: Boolean,
        forFileExtension: Boolean,
        languageNamespaceOrFileExtension: String
    ) = when (languageNamespaceOrFileExtension) {
        IntermediatePackage.eNS_URI -> XmiLanguageDescription(IntermediatePackage.eINSTANCE)
        else -> null
    }
}