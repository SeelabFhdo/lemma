package de.fhdo.lemma.model_processing.code_generation.mtls_operation.languages

import de.fhdo.lemma.model_processing.annotations.LanguageDescriptionProvider
import de.fhdo.lemma.model_processing.languages.LanguageDescription
import de.fhdo.lemma.model_processing.languages.LanguageDescriptionProviderI
import de.fhdo.lemma.model_processing.languages.XmiLanguageDescription
import de.fhdo.lemma.model_processing.languages.XtextLanguageDescription
import de.fhdo.lemma.operation.OperationPackage
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import de.fhdo.lemma.operationdsl.OperationDslStandaloneSetup

@LanguageDescriptionProvider
class MTLSOperationsLanguageDescriptionProvider : LanguageDescriptionProviderI {

    override fun getLanguageDescription(
        forLanguageNamespace: Boolean,
        forFileExtension: Boolean,
        languageNamespaceOrFileExtension: String
    ): LanguageDescription? {
        return when (languageNamespaceOrFileExtension) {
            IntermediatePackage.eNS_URI -> XmiLanguageDescription(IntermediatePackage.eINSTANCE)
            "operation" -> OPERATION_DSL_LANGUAGE_DESCRIPTION
            else -> null
        }
    }
}

/**
 * [XtextLanguageDescription] for the Operation DSL.
 *
 */
internal val OPERATION_DSL_LANGUAGE_DESCRIPTION = XtextLanguageDescription(
    OperationPackage.eINSTANCE, OperationDslStandaloneSetup()
)