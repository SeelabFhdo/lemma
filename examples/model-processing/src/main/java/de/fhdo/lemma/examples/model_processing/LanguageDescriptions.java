package de.fhdo.lemma.examples.model_processing;

import de.fhdo.lemma.ServiceDslStandaloneSetup;
import de.fhdo.lemma.model_processing.annotations.LanguageDescriptionProvider;
import de.fhdo.lemma.model_processing.languages.LanguageDescription;
import de.fhdo.lemma.model_processing.languages.LanguageDescriptionProviderI;
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
     * runtime, the model processing invokes the method with a namespace that identifies an Eclipse-based modeling
     * language and expects the method to return an instance of
     * {@link de.fhdo.lemma.model_processing.languages.LanguageDescription}, which comprises all relevant information
     * for the framework to, e.g., parse an input model.
     */
    @Nullable
    @Override
    public LanguageDescription getLanguageDescription(@NotNull String forLanguageNamespace) {
        switch(forLanguageNamespace) {
            // Handle input service models in their source form (files with the ".services" extension
            case ServicePackage.eNS_URI:
                // We return an instance of {@link de.fhdo.lemma.model_processing.languages.XtextLanguageDescription}
                // to the framework as the source input model constitutes a source model in an Xtext-based modeling
                // language (i.e., LEMMA's Service Modeling Language)
                return new XtextLanguageDescription(ServicePackage.eINSTANCE, new ServiceDslStandaloneSetup());
            case IntermediatePackage.eNS_URI:
                // We return an instance of {@link de.fhdo.lemma.model_processing.languages.LanguageDescription}
                // to the framework as the input intermediate model constitutes an intermediate service model
                return new LanguageDescription(IntermediatePackage.eINSTANCE);
            case de.fhdo.lemma.data.intermediate.IntermediatePackage.eNS_URI:
                // We also need to return an instance of
                // {@link de.fhdo.lemma.model_processing.languages.LanguageDescription} for intermediate domain models,
                // because the intermediate specification for LEMMA service models depends on that for LEMMA domain
                // models. This language description is necessary for the {@link ExampleCodeGenerationModule} class for
                // which LEMMA's model processing framework will enable code generation from a given intermediate
                // service model.
                return new LanguageDescription(de.fhdo.lemma.data.intermediate.IntermediatePackage.eINSTANCE);
            default:
                throw new IllegalArgumentException("Unrecognized namespace " + forLanguageNamespace);
        }
    }
}
