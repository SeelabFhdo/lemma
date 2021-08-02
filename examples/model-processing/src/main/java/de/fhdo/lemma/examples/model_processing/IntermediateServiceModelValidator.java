package de.fhdo.lemma.examples.model_processing;

import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator;
import de.fhdo.lemma.model_processing.builtin_phases.intermediate_model_validation.AbstractIntermediateDeclarativeValidator;
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice;
import de.fhdo.lemma.service.intermediate.IntermediatePackage;
import org.eclipse.xtext.validation.Check;
import org.jetbrains.annotations.NotNull;

/**
 * This class implements a LEMMA model validator. More specifically, it realizes a validator that can check LEMMA
 * service models in their *intermediate* form, i.e., files in the XML Metadata Interchange format (usually having the
 * ".xmi" extension). To this end, the class has the
 * {@link de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator} annotation and extends
 * {@link de.fhdo.lemma.model_processing.builtin_phases.intermediate_model_validation.AbstractIntermediateDeclarativeValidator}.
 * Consequently, the model processing framework will invoke the class when an intermediate model is passed to the
 * processor using the "--intermediate_model" commandline option (cf. the "run.sh" script).
 *
 * Note that intermediate model validation is optional and not required for code generation purposes. However, in case
 * you need to make sure that an input model conforms to the expectations of one or more code generation modules, an
 * intermediate model validator or a source model validator (cf. {@link SourceServiceModelValidator}) probably makes
 * sense. Both kinds of LEMMA model validation differ as follows:
 *  - Source model validation: Implementers can report model issues with a direct reference to the issue position in the
 *      constructed model. However, this kind of validation cannot take advantage of LEMMA's intermediate model
 *      specifications.
 *  - Intermediate model validation: Implementers can take advantage of LEMMA's intermediate model specifications, which
 *      facilitate model processing. However, this kind of validation cannot report model issues with a direct reference
 *      to the issue position in the original source model.
 *
 * @see <a href="https://www.omg.org/spec/XMI/2.5.1/About-XMI/">XML Metadata Interchange</a>.
 */
@IntermediateModelValidator
public class IntermediateServiceModelValidator extends AbstractIntermediateDeclarativeValidator {
    /**
     * Return the namespace of the modeling language, whose models can be validated
     */
    @NotNull
    @Override
    public String getLanguageNamespace() {
        // Namespace of the intermediate specification for the Service Modeling Language (cf. the provider
        // implementation in the {@link LanguageDescriptions} class)
        return IntermediatePackage.eNS_URI;
    }

    /**
     * For intermediate model validators, i.e., classes with the
     * {@link de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator} that extend
     * {@link de.fhdo.lemma.model_processing.builtin_phases.intermediate_model_validation.AbstractIntermediateDeclarativeValidator},
     * LEMMA's model processing framework supports Xtext's annotation-driven Custom Model Validation. That is, the
     * framework will iterate over all elements in an input model and invoke validation methods with
     * Xtext's {@link org.eclipse.xtext.validation.Check} annotation in case the type of their parameter matches
     * the type of the iterated element. Thus, this method will be invoked on all
     * {@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice}s contained in a given intermediate model.
     *
     * @see <a href="https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#custom-validation">
     *  Xtext Custom Model Validation</a>.
     */
    @Check
    private void checkMicroservice(IntermediateMicroservice intermediateMicroservice) {
        // Xtext provides methods like {@link org.eclipse.xtext.validation.AbstractDeclarativeValidator#info()},
        // {@link org.eclipse.xtext.validation.AbstractDeclarativeValidator#warning()} and
        // {@link org.eclipse.xtext.validation.AbstractDeclarativeValidator#error()} to communicate issues detected in
        // an input model. LEMMA's model processing framework collects all detected issues and reports them to the
        // model processor user.
        info("Intermediate model contains a microservice named " + intermediateMicroservice.getQualifiedName(),
            IntermediatePackage.Literals.INTERMEDIATE_MICROSERVICE__QUALIFIED_NAME);
    }
}
