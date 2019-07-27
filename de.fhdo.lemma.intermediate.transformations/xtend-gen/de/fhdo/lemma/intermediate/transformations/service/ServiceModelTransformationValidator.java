package de.fhdo.lemma.intermediate.transformations.service;

import com.google.common.base.Function;
import de.fhdo.lemma.intermediate.transformations.AbstractInputModelValidator;
import de.fhdo.lemma.intermediate.transformations.IntermediateTransformationException;
import de.fhdo.lemma.service.Microservice;
import de.fhdo.lemma.service.ServiceModel;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

/**
 * Validator for service models that shall be transformed.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ServiceModelTransformationValidator extends AbstractInputModelValidator<ServiceModel> {
  /**
   * Validate input models for errors
   */
  @Override
  public void checkInputModelForErrors(final ServiceModel serviceModel) throws IntermediateTransformationException {
    if ((serviceModel == null)) {
      this.error("Service model is empty");
    }
    boolean _isEmpty = IteratorExtensions.isEmpty(serviceModel.eAllContents());
    if (_isEmpty) {
      this.error("Service model is empty");
    }
  }
  
  /**
   * Register warning functions
   */
  @Override
  public List<Function<ServiceModel, Void>> registerWarningFunctions() {
    final Function<ServiceModel, Void> _function = (ServiceModel it) -> {
      return this.warnReferredMicroserviceTechnologies(it);
    };
    return Collections.<Function<ServiceModel, Void>>unmodifiableList(CollectionLiterals.<Function<ServiceModel, Void>>newArrayList(_function));
  }
  
  /**
   * Warn if microservices with technologies refer to microservices without technologies
   */
  private Void warnReferredMicroserviceTechnologies(final ServiceModel serviceModel) {
    Void _xblockexpression = null;
    {
      final Function1<Microservice, Boolean> _function = (Microservice it) -> {
        boolean _isEmpty = it.getTechnologyReferences().isEmpty();
        return Boolean.valueOf((!_isEmpty));
      };
      final Iterable<Microservice> microservicesWithTechnologies = IterableExtensions.<Microservice>filter(serviceModel.getMicroservices(), _function);
      final Function1<Microservice, Boolean> _function_1 = (Microservice it) -> {
        final Function1<Microservice, Boolean> _function_2 = (Microservice it_1) -> {
          return Boolean.valueOf(it_1.getTechnologyReferences().isEmpty());
        };
        return Boolean.valueOf(IterableExtensions.<Microservice>exists(it.getAllRequiredMicroservices().keySet(), _function_2));
      };
      final boolean referencesToMicroservicesWithoutTechnologies = IterableExtensions.<Microservice>exists(microservicesWithTechnologies, _function_1);
      Void _xifexpression = null;
      if (referencesToMicroservicesWithoutTechnologies) {
        _xifexpression = this.warning(((("The model contains microservices with technology assignments, which refer " + 
          "to services without technology assignments. For the services without ") + 
          "technology assignments, a code generation involving explicit technology ") + 
          "specifications would have to be performed."));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
