package de.fhdo.lemma.examples.model_processing.latest;

import de.fhdo.lemma.ServiceDslStandaloneSetup;
import de.fhdo.lemma.model_processing.annotations.LanguageDescriptionProvider;
import de.fhdo.lemma.model_processing.languages.LanguageDescription;
import de.fhdo.lemma.model_processing.languages.LanguageDescriptionProviderI;
import de.fhdo.lemma.model_processing.languages.XmiLanguageDescription;
import de.fhdo.lemma.model_processing.languages.XtextLanguageDescription;
import de.fhdo.lemma.service.ServicePackage;
import de.fhdo.lemma.service.intermediate.IntermediatePackage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * LEMMA's model processing framework expects a language description provider in the search package specified by the
 * constructor of the entrypoint class (cf. {@link ExampleModelProcessor}). A language description provider is a Java
 * class that has the
 * {@link de.fhdo.lemma.model_processing.annotations.LanguageDescriptionProvider} annotation and additionally implements
 * the {@link de.fhdo.lemma.model_processing.languages.LanguageDescriptionProviderI} interface. At runtime, a language
 * description provider informs the model processing framework about the modeling languages of the input models to
 * process. Among others, these information allow the framework to parse the input models and hide the related
 * complexity from the model processor implementer.
 */
@LanguageDescriptionProvider
public class LanguageDescriptions implements LanguageDescriptionProviderI {
    /**
     * The {@link de.fhdo.lemma.model_processing.languages.LanguageDescriptionProviderI} interface defines the
     * {@link de.fhdo.lemma.model_processing.languages.LanguageDescriptionProviderI#getLanguageDescription} method. At
     * runtime, the model processing framework invokes the method with a namespace (for XMI-based models) or file
     * extension (for models that do not contain directly extractable information about their namespace, e.g.,
     * Xtext-based models in their textual form) that identify an Eclipse-based modeling language. The flags
     * {@code forLanguageNamespace} and {@code forFileExtension} flags inform model processors about whether the
     * {@code languageNamespaceOrFileExtension} parameter contains a namespace or file extension. The model processing
     * framework then expects the
     * {@link de.fhdo.lemma.model_processing.languages.LanguageDescriptionProviderI#getLanguageDescription} method to
     * return an instance of {@link de.fhdo.lemma.model_processing.languages.LanguageDescription}, which comprises all
     * relevant information for the framework to, e.g., parse an input model.
     */
    @Nullable
    @Override
    public LanguageDescription getLanguageDescription(boolean forLanguageNamespace, boolean forFileExtension,
        @NotNull String languageNamespaceOrFileExtension) {
        switch(languageNamespaceOrFileExtension) {
            // Handle input service models in their source form (files with the ".services" extension)
            case "services":
                // We return an instance of {@link de.fhdo.lemma.model_processing.languages.XtextLanguageDescription}
                // to the framework as the source input model constitutes a source model in an Xtext-based modeling
                // language (i.e., LEMMA's Service Modeling Language)
                return new XtextLanguageDescription(ServicePackage.eINSTANCE, new ServiceDslStandaloneSetup());
            // Handle input service models in their intermediate form (XMI files with the
            // "http://www.fhdo.de/lemma/service/intermediate" namespace contained in IntermediatePackage.eNS_URI)
            case IntermediatePackage.eNS_URI:
                // We return an instance of {@link de.fhdo.lemma.model_processing.languages.XmiLanguageDescription}
                // to the framework as the input intermediate model constitutes an intermediate service model in the XMI
                // format
                return new XmiLanguageDescription(IntermediatePackage.eINSTANCE);
            case de.fhdo.lemma.data.intermediate.IntermediatePackage.eNS_URI:
                // We also need to return an instance of
                // {@link de.fhdo.lemma.model_processing.languages.XmiLanguageDescription} for intermediate domain
                // models, because the intermediate specification for LEMMA service models depends on that for LEMMA
                // domain models. This language description is necessary for the {@link ExampleCodeGenerationModule}
                // class for which LEMMA's model processing framework will enable code generation from a given
                // intermediate service model.
                return new XmiLanguageDescription(de.fhdo.lemma.data.intermediate.IntermediatePackage.eINSTANCE);
            default:
                return null;
        }
    }
}
