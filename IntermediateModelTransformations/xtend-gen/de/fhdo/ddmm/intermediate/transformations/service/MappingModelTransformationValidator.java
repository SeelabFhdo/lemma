package de.fhdo.ddmm.intermediate.transformations.service;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import de.fhdo.ddmm.intermediate.transformations.AbstractSourceModelValidator;
import de.fhdo.ddmm.intermediate.transformations.IntermediateTransformationException;
import de.fhdo.ddmm.service.Import;
import de.fhdo.ddmm.service.ImportType;
import de.fhdo.ddmm.service.Microservice;
import de.fhdo.ddmm.service.ServiceModel;
import de.fhdo.ddmm.technology.mapping.MicroserviceMapping;
import de.fhdo.ddmm.technology.mapping.TechnologyMapping;
import de.fhdo.ddmm.utils.DdmmUtils;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

/**
 * Validator for technology mapping models that shall be transformed.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class MappingModelTransformationValidator extends AbstractSourceModelValidator<TechnologyMapping> {
  /**
   * Validate source models for errors
   */
  @Override
  public void checkSourceModelForErrors(final TechnologyMapping mappingModel) throws IntermediateTransformationException {
    if ((mappingModel == null)) {
      this.error("Mapping model is empty");
    }
    boolean _isEmpty = IteratorExtensions.isEmpty(mappingModel.eAllContents());
    if (_isEmpty) {
      this.error("Mapping model is empty");
    }
    this.checkImportsInServiceModelsForDuplicateAliases(mappingModel);
  }
  
  /**
   * Register warning functions
   */
  @Override
  public List<Function<TechnologyMapping, Void>> registerWarningFunctions() {
    final Function<TechnologyMapping, Void> _function = (TechnologyMapping it) -> {
      return this.warnReferredMicroserviceTechnologies(it);
    };
    return Collections.<Function<TechnologyMapping, Void>>unmodifiableList(CollectionLiterals.<Function<TechnologyMapping, Void>>newArrayList(_function));
  }
  
  /**
   * Warn if microservices with technologies refer to microservices without technologies
   */
  private Void warnReferredMicroserviceTechnologies(final TechnologyMapping mappingModel) {
    Void _xblockexpression = null;
    {
      final Function1<MicroserviceMapping, Boolean> _function = (MicroserviceMapping it) -> {
        final Function1<Microservice, Boolean> _function_1 = (Microservice it_1) -> {
          return Boolean.valueOf(it_1.getTechnologies().isEmpty());
        };
        return Boolean.valueOf(IterableExtensions.<Microservice>exists(it.getMicroservice().getMicroservice().getAllRequiredMicroservices().keySet(), _function_1));
      };
      final boolean referencesToMicroservicesWithoutTechnologies = IterableExtensions.<MicroserviceMapping>exists(mappingModel.getServiceMappings(), _function);
      Void _xifexpression = null;
      if (referencesToMicroservicesWithoutTechnologies) {
        _xifexpression = this.warning(((("The model maps microservices, which refer to services without " + 
          "technology assignments. For the services without technology assignments, a code ") + 
          "generation involving explicit technology specifications would have to be ") + 
          "performed."));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  /**
   * Check imported service models for duplicate aliases of imported data and service models
   */
  private void checkImportsInServiceModelsForDuplicateAliases(final TechnologyMapping mappingModel) {
    final Function1<Import, Boolean> _function = (Import it) -> {
      return Boolean.valueOf(((it.getImportType() == ImportType.DATATYPES) || (it.getImportType() == ImportType.MICROSERVICES)));
    };
    List<Import> _list = IterableExtensions.<Import>toList(IterableExtensions.<Import>filter(mappingModel.getImports(), _function));
    ArrayDeque<Import> importsTodo = new ArrayDeque<Import>(_list);
    final HashSet<String> urisDone = CollectionLiterals.<String>newHashSet();
    final HashMap<String, String> aliasesToUris = CollectionLiterals.<String, String>newHashMap();
    while ((!importsTodo.isEmpty())) {
      {
        final Import currentImport = importsTodo.pop();
        final IFile importContainingModelFile = DdmmUtils.getFileForResource(currentImport.eResource());
        final String currentAbsoluteUri = DdmmUtils.convertToAbsoluteFileUri(currentImport.getImportURI(), 
          importContainingModelFile.getRawLocation().makeAbsolute().toString());
        final String existingUri = aliasesToUris.putIfAbsent(currentImport.getName(), currentAbsoluteUri);
        if (((existingUri != null) && (!Objects.equal(existingUri, currentAbsoluteUri)))) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Alias ");
          String _name = currentImport.getName();
          _builder.append(_name);
          _builder.append(" was detected more than once in different ");
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("imported service models. Moreover, it points to different resources ");
          String _plus = (_builder.toString() + _builder_1);
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("within the imported models. Duplicate aliases in imported models are, ");
          String _plus_1 = (_plus + _builder_2);
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("however, only allowed if they point to the same resource.");
          String _plus_2 = (_plus_1 + _builder_3);
          this.error(_plus_2);
        }
        boolean _contains = urisDone.contains(currentAbsoluteUri);
        boolean _not = (!_contains);
        if (_not) {
          ImportType _importType = currentImport.getImportType();
          boolean _tripleEquals = (_importType == ImportType.MICROSERVICES);
          if (_tripleEquals) {
            final ServiceModel importedServiceModel = DdmmUtils.<ServiceModel>getImportedModelRoot(
              currentImport.eResource(), currentAbsoluteUri, 
              ServiceModel.class);
            importsTodo.addAll(importedServiceModel.getImports());
          }
          urisDone.add(currentAbsoluteUri);
        }
      }
    }
  }
}
