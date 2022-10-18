package de.fhdo.lemma.model_processing.code_generation.deployment_base

import de.fhdo.lemma.model_processing.annotations.LanguageDescriptionProvider
import de.fhdo.lemma.model_processing.languages.LanguageDescriptionProviderI
import de.fhdo.lemma.operation.OperationPackage
import de.fhdo.lemma.model_processing.languages.XtextLanguageDescription
import de.fhdo.lemma.operationdsl.OperationDslStandaloneSetup
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import org.eclipse.xtext.util.internal.Nullable
import de.fhdo.lemma.model_processing.languages.XmiLanguageDescription

/**
 * This class contains the language description for LEMMA's modeling languages.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@LanguageDescriptionProvider
class DeploymentBaseLanguageDescriptionProvider implements LanguageDescriptionProviderI {
    /**
     * Provide language description for LEMMA's operation model and intermediate operation model
     * modules.
     */
    @Nullable
    override getLanguageDescription(boolean forLanguageNamespace, boolean forFileExtension,
        String languageNamespaceOrFileExtension) {
        return switch (languageNamespaceOrFileExtension) {
            case "operation",
            case OperationPackage.eNS_URI:
                new XtextLanguageDescription(OperationPackage.eINSTANCE,
                    new OperationDslStandaloneSetup)
            case IntermediatePackage.eNS_URI:
                new XmiLanguageDescription(IntermediatePackage.eINSTANCE)
            default: null
        }
    }
}