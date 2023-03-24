package de.fhdo.lemma.analyzer.languages

import de.fhdo.lemma.data.intermediate.IntermediatePackage as IntermediateDataPackage
import de.fhdo.lemma.ServiceDslStandaloneSetup
import de.fhdo.lemma.data.DataDslStandaloneSetup
import de.fhdo.lemma.data.DataPackage
import de.fhdo.lemma.service.intermediate.IntermediatePackage as IntermediateServicePackage
import de.fhdo.lemma.operation.intermediate.IntermediatePackage as IntermediateOperationPackage
import de.fhdo.lemma.model_processing.annotations.LanguageDescriptionProvider
import de.fhdo.lemma.model_processing.languages.LanguageDescriptionProviderI
import de.fhdo.lemma.model_processing.languages.XmiLanguageDescription
import de.fhdo.lemma.model_processing.languages.XtextLanguageDescription
import de.fhdo.lemma.operation.OperationPackage
import de.fhdo.lemma.operationdsl.OperationDslStandaloneSetup
import de.fhdo.lemma.service.ServicePackage

/**
 * [LanguageDescriptionProvider] for the static analyzer as expected by LEMMA's model processing framework.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("unused")
@LanguageDescriptionProvider
internal class DescriptionProvider : LanguageDescriptionProviderI {
    override fun getLanguageDescription(forLanguageNamespace: Boolean, forFileExtension: Boolean,
        languageNamespaceOrFileExtension: String) = when(languageNamespaceOrFileExtension) {
            "data" -> DATA_DSL_LANGUAGE_DESCRIPTION
            IntermediateDataPackage.eNS_URI -> INTERMEDIATE_DATA_MODEL_LANGUAGE_DESCRIPTION
            IntermediateServicePackage.eNS_URI -> INTERMEDIATE_SERVICE_MODEL_LANGUAGE_DESCRIPTION
            "services" -> SERVICE_DSL_LANGUAGE_DESCRIPTION
            IntermediateOperationPackage.eNS_URI -> INTERMEDIATE_OPERATION_MODEL_LANGUAGE_DESCRIPTION
            "operation" -> OPERATION_DSL_LANGUAGE_DESCRIPTION
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
 * [XtextLanguageDescription] for the Service DSL.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal val SERVICE_DSL_LANGUAGE_DESCRIPTION = XtextLanguageDescription(ServicePackage.eINSTANCE,
    ServiceDslStandaloneSetup())

internal val OPERATION_DSL_LANGUAGE_DESCRIPTION = XtextLanguageDescription(
    OperationPackage.eINSTANCE,
    OperationDslStandaloneSetup()
)

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

internal val INTERMEDIATE_OPERATION_MODEL_LANGUAGE_DESCRIPTION
        = XmiLanguageDescription(IntermediateOperationPackage.eINSTANCE)