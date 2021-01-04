package de.fhdo.lemma.model_processing.code_generation.springcloud.zuul

import de.fhdo.lemma.model_processing.annotations.LanguageDescriptionProvider
import de.fhdo.lemma.model_processing.languages.LanguageDescriptionProviderI
import de.fhdo.lemma.operation.OperationPackage
import de.fhdo.lemma.model_processing.languages.XtextLanguageDescription
import de.fhdo.lemma.operationdsl.OperationDslStandaloneSetup
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import de.fhdo.lemma.model_processing.languages.LanguageDescription
import org.eclipse.xtext.util.internal.Nullable

/**
 * This class contains the language description for LEMMA's modeling languages.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@LanguageDescriptionProvider
class ZuulLanguageDescriptionProvider implements LanguageDescriptionProviderI {
    /**
     * Receive language description for LEMMA's operation model and intermediate operation model
     * modules.
     */
    @Nullable
    override getLanguageDescription(String namespace) {
        switch namespace {
            case OperationPackage.eNS_URI :
                return new XtextLanguageDescription(OperationPackage.eINSTANCE,
                    new OperationDslStandaloneSetup)
            case IntermediatePackage.eNS_URI :
                return new LanguageDescription(IntermediatePackage.eINSTANCE)
            default :
                return null
        }
    }
}