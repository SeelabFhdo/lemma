package de.fhdo.lemma.examples.model_processing.latest;

import de.fhdo.lemma.model_processing.annotations.Before;
import de.fhdo.lemma.model_processing.annotations.SourceModelValidator;
import de.fhdo.lemma.model_processing.phases.validation.AbstractXtextModelValidator;
import de.fhdo.lemma.service.Microservice;
import de.fhdo.lemma.service.ServiceModel;
import de.fhdo.lemma.service.ServicePackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.validation.Check;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static de.fhdo.lemma.model_processing.languages.XtextImportUriConverterKt.convertToAbsoluteFileUrisInPlace;

/**
 * This class implements a LEMMA model validator. More specifically, it realizes a validator that can check LEMMA
 * service models in their source form, i.e., files with the ".services" extension. To this end, the class has the
 * {@link de.fhdo.lemma.model_processing.annotations.SourceModelValidator} annotation and extends
 * {@link de.fhdo.lemma.model_processing.phases.validation.AbstractXtextModelValidator}. Consequently, the model
 * processing framework will invoke the class when a source model is passed to the processor using the "--source_model"
 * commandline option (cf. the "run.sh" script).
 *
 * Note that source model validation is optional and not required for code generation purposes. However, in case you
 * need to make sure that an input model conforms to the expectations of one or more code generation modules, a source
 * model validator or an intermediate model validator (cf. {@link IntermediateServiceModelValidator}) probably makes
 * sense. Both kinds of LEMMA model validation differ as follows:
 *  - Source model validation: Implementers can report model issues with a direct reference to the issue position in the
 *      constructed model. However, this kind of validation cannot take advantage of LEMMA's intermediate model
 *      specifications.
 *  - Intermediate model validation: Implementers can take advantage of LEMMA's intermediate model specifications, which
 *      facilitate model processing. However, this kind of validation cannot report model issues with a direct reference
 *      to the issue position in the original source model.
 */
@SourceModelValidator
public class SourceServiceModelValidator extends AbstractXtextModelValidator {
    /**
     * Return the file extensions of the modeling language, whose models can be validated
     */
    @NotNull
    @Override
    public Set<String> getSupportedFileExtensions() {
        // File extension of the Service Modeling Language (cf. the provider implementation in the
        // {@link LanguageDescriptions} class)
        HashSet<String> supportedFileExtensions = new HashSet<>();
        supportedFileExtensions.add("services");
        return supportedFileExtensions;
    }

    /**
     * LEMMA's model processing framework will invoke methods with the
     * {@link de.fhdo.lemma.model_processing.annotations.Before} annotation before the actual validation starts. This
     * method is specifically responsible for converting relative paths in input models to absolute paths as otherwise
     * parsing will fail. Methods with the {@link de.fhdo.lemma.model_processing.annotations.Before} annotation receive
     * the "raw" Eclipse {@link org.eclipse.emf.ecore.resource.Resource} of the parsed model as argument.
     */
    @Before
    private void makeImportModelPathsAbsolute(Resource resource) {
        // Get the root of a non-empty input model from the Resource instance
        List<EObject> modelContents = resource.getContents();
        if (modelContents.isEmpty())
            return;
        ServiceModel sm = (ServiceModel) modelContents.get(0);

        // We can use the
        // {@link de.fhdo.lemma.model_processing.languages.XtextImportUriConverterKt#convertToAbsoluteFileUrisInPlace}
        // helper method from LEMMA's model processing framework to do the actual path conversion
        convertToAbsoluteFileUrisInPlace(sm.getImports(), resource);
    }

    /**
     * For Xtext-based source model validators, i.e., classes with the
     * {@link de.fhdo.lemma.model_processing.annotations.SourceModelValidator} annotation that extend
     * {@link de.fhdo.lemma.model_processing.phases.validation.AbstractXtextModelValidator}, LEMMA's model processing
     * framework supports Xtext's annotation-driven Custom Model Validation. That is, the framework will iterate over
     * all elements in an input model and invoke validation methods with Xtext's
     * {@link org.eclipse.xtext.validation.Check} annotation in case the type of their parameter matches the type of the
     * iterated element. Thus, this method will be invoked on all {@link de.fhdo.lemma.service.Microservice}s contained
     * in a given source model.
     *
     * @see <a href="https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#custom-validation">
     *  Xtext Custom Model Validation</a>.
     */
    @Check
    private void checkMicroservice(Microservice microservice) {
        // Xtext provides methods like {@link org.eclipse.xtext.validation.AbstractDeclarativeValidator#info()},
        // {@link org.eclipse.xtext.validation.AbstractDeclarativeValidator#warning()} and
        // {@link org.eclipse.xtext.validation.AbstractDeclarativeValidator#error()} to communicate issues detected in
        // an input model. LEMMA's model processing framework collects all detected issues and reports them to the
        // model processor user.
        info("Source model contains a microservice named " + microservice.buildQualifiedName("."),
            ServicePackage.Literals.MICROSERVICE__NAME);
    }
}
