package de.fhdo.ddmm.intermediate.transformations.service;

import com.google.common.base.Function;
import de.fhdo.ddmm.intermediate.transformations.AbstractSourceModelValidator;
import de.fhdo.ddmm.intermediate.transformations.IntermediateTransformationException;
import de.fhdo.ddmm.service.Microservice;
import de.fhdo.ddmm.service.ServiceModel;
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
public class ServiceModelTransformationValidator extends AbstractSourceModelValidator<ServiceModel> {
  /**
   * Validate source models for errors
   */
  @Override
  public void checkSourceModelForErrors(final ServiceModel serviceModel) throws IntermediateTransformationException {
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
      return this.warnMissingTechnologies(it);
    };
    final Function<ServiceModel, Void> _function_1 = (ServiceModel it) -> {
      return this.warnReferredMicroserviceTechnologies(it);
    };
    return Collections.<Function<ServiceModel, Void>>unmodifiableList(CollectionLiterals.<Function<ServiceModel, Void>>newArrayList(_function, _function_1));
  }
  
  /**
   * Warn if microservices exist in the model without assigned technologies
   */
  private Void warnMissingTechnologies(final ServiceModel serviceModel) {
    Void _xblockexpression = null;
    {
      final Function1<Microservice, Boolean> _function = (Microservice it) -> {
        return Boolean.valueOf(it.getTechnologies().isEmpty());
      };
      final boolean missingTechnologies = IterableExtensions.<Microservice>exists(serviceModel.getMicroservices(), _function);
      Void _xifexpression = null;
      if (missingTechnologies) {
        _xifexpression = this.warning((("The service model contains microservices without a technology assignment. " + 
          "A technology would have to be explicitly chosen when generating source code for ") + 
          "them."));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  /**
   * Warn if microservices with technologies refer to microservices without technologies
   */
  private Void warnReferredMicroserviceTechnologies(final ServiceModel serviceModel) {
    Void _xblockexpression = null;
    {
      final Function1<Microservice, Boolean> _function = (Microservice it) -> {
        boolean _isEmpty = it.getTechnologies().isEmpty();
        return Boolean.valueOf((!_isEmpty));
      };
      final Iterable<Microservice> microservicesWithTechnologies = IterableExtensions.<Microservice>filter(serviceModel.getMicroservices(), _function);
      final Function1<Microservice, Boolean> _function_1 = (Microservice it) -> {
        final Function1<Microservice, Boolean> _function_2 = (Microservice it_1) -> {
          return Boolean.valueOf(it_1.getTechnologies().isEmpty());
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
