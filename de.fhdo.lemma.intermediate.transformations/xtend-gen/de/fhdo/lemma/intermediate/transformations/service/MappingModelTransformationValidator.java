package de.fhdo.lemma.intermediate.transformations.service;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import de.fhdo.lemma.intermediate.transformations.AbstractInputModelValidator;
import de.fhdo.lemma.intermediate.transformations.IntermediateTransformationException;
import de.fhdo.lemma.service.Endpoint;
import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.ImportType;
import de.fhdo.lemma.service.ImportedProtocolAndDataFormat;
import de.fhdo.lemma.service.Microservice;
import de.fhdo.lemma.service.ServiceModel;
import de.fhdo.lemma.technology.DataFormat;
import de.fhdo.lemma.technology.mapping.MicroserviceMapping;
import de.fhdo.lemma.technology.mapping.TechnologyMapping;
import de.fhdo.lemma.utils.LemmaUtils;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
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
public class MappingModelTransformationValidator extends AbstractInputModelValidator<TechnologyMapping> {
  /**
   * Validate input models for errors
   */
  @Override
  public void checkInputModelForErrors(final TechnologyMapping mappingModel) throws IntermediateTransformationException {
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
        final IFile importContainingModelFile = LemmaUtils.getFileForResource(currentImport.eResource());
        final String currentAbsoluteUri = LemmaUtils.convertToAbsoluteFileUri(currentImport.getImportURI(), 
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
            final ServiceModel importedServiceModel = LemmaUtils.<ServiceModel>getImportedModelRoot(
              currentImport.eResource(), currentAbsoluteUri, 
              ServiceModel.class);
            importsTodo.addAll(importedServiceModel.getImports());
          }
          urisDone.add(currentAbsoluteUri);
        }
      }
    }
  }
  
  /**
   * Register warning functions
   */
  @Override
  public List<Function<TechnologyMapping, Void>> registerWarningFunctions() {
    final Function<TechnologyMapping, Void> _function = (TechnologyMapping it) -> {
      return this.warnReferredMicroserviceTechnologies(it);
    };
    final Function<TechnologyMapping, Void> _function_1 = (TechnologyMapping it) -> {
      return this.warnServiceModelsForDuplicateEndpointAddresses(it);
    };
    return Collections.<Function<TechnologyMapping, Void>>unmodifiableList(CollectionLiterals.<Function<TechnologyMapping, Void>>newArrayList(_function, _function_1));
  }
  
  /**
   * Warn if microservices with technologies refer to microservices without technologies
   */
  private Void warnReferredMicroserviceTechnologies(final TechnologyMapping mappingModel) {
    Void _xblockexpression = null;
    {
      final Function1<MicroserviceMapping, Boolean> _function = (MicroserviceMapping it) -> {
        final Function1<Microservice, Boolean> _function_1 = (Microservice it_1) -> {
          return Boolean.valueOf(it_1.getTechnologyReferences().isEmpty());
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
   * Warn about duplicate microservice endpoint addresses across service models
   */
  private Void warnServiceModelsForDuplicateEndpointAddresses(final TechnologyMapping mappingModel) {
    final Function1<Import, Boolean> _function = (Import it) -> {
      ImportType _importType = it.getImportType();
      return Boolean.valueOf((_importType == ImportType.MICROSERVICES));
    };
    final Function1<Import, ServiceModel> _function_1 = (Import it) -> {
      ServiceModel _xblockexpression = null;
      {
        final IFile serviceModelFile = LemmaUtils.getFileForResource(it.eResource());
        final String modelFileUri = LemmaUtils.convertToAbsoluteFileUri(
          it.getImportURI(), 
          serviceModelFile.getRawLocation().makeAbsolute().toString());
        _xblockexpression = LemmaUtils.<ServiceModel>getImportedModelRoot(it.eResource(), modelFileUri, ServiceModel.class);
      }
      return _xblockexpression;
    };
    final Function1<Import, String> _function_2 = (Import it) -> {
      return LemmaUtils.getFileForResource(it.eResource()).getRawLocation().makeAbsolute().toString();
    };
    final Map<ServiceModel, String> allImportedServiceModels = IterableExtensions.<Import, ServiceModel, String>toMap(IterableExtensions.<Import>filter(mappingModel.getImports(), _function), _function_1, _function_2);
    final Function1<ServiceModel, EList<Microservice>> _function_3 = (ServiceModel it) -> {
      return it.getMicroservices();
    };
    final Function1<Microservice, EList<Endpoint>> _function_4 = (Microservice it) -> {
      return it.getEndpoints();
    };
    final List<Endpoint> allMicroserviceEndpoints = IterableExtensions.<Endpoint>toList(Iterables.<Endpoint>concat(IterableExtensions.<Microservice, EList<Endpoint>>map(Iterables.<Microservice>concat(IterableExtensions.<ServiceModel, EList<Microservice>>map(allImportedServiceModels.keySet(), _function_3)), _function_4)));
    final HashMap<String, Endpoint> endpointAddresses = CollectionLiterals.<String, Endpoint>newHashMap();
    final Consumer<Endpoint> _function_5 = (Endpoint endpoint) -> {
      final Consumer<String> _function_6 = (String address) -> {
        final Consumer<ImportedProtocolAndDataFormat> _function_7 = (ImportedProtocolAndDataFormat protocol) -> {
          String _name = protocol.getImport().getName();
          String _plus = (_name + "::");
          String _name_1 = protocol.getImportedProtocol().getName();
          String protocolName = (_plus + _name_1);
          final DataFormat dataFormat = protocol.getDataFormat();
          if (((dataFormat != null) && (dataFormat.getFormatName() != null))) {
            String _protocolName = protocolName;
            String _formatName = dataFormat.getFormatName();
            String _plus_1 = ("/" + _formatName);
            protocolName = (_protocolName + _plus_1);
          }
          final String addressPrefixedByProtocol = (protocolName + address);
          final Endpoint duplicateEndpoint = endpointAddresses.get(addressPrefixedByProtocol);
          if ((duplicateEndpoint != null)) {
            final Microservice microservice = EcoreUtil2.<Microservice>getContainerOfType(endpoint, Microservice.class);
            final Microservice duplicateMicroservice = EcoreUtil2.<Microservice>getContainerOfType(duplicateEndpoint, 
              Microservice.class);
            boolean _notEquals = (!Objects.equal(duplicateMicroservice, microservice));
            if (_notEquals) {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("Address ");
              _builder.append(address);
              _builder.append(" is already specified for microservice ");
              StringConcatenation _builder_1 = new StringConcatenation();
              String _buildQualifiedName = microservice.buildQualifiedName(".");
              _builder_1.append(_buildQualifiedName);
              _builder_1.append(" in  service model ");
              String _plus_2 = (_builder.toString() + _builder_1);
              StringConcatenation _builder_2 = new StringConcatenation();
              String _get = allImportedServiceModels.get(microservice.getServiceModel());
              _builder_2.append(_get);
              _builder_2.append(".");
              String _plus_3 = (_plus_2 + _builder_2);
              this.warning(_plus_3);
            }
          } else {
            endpointAddresses.put(addressPrefixedByProtocol, endpoint);
          }
        };
        endpoint.getProtocols().forEach(_function_7);
      };
      endpoint.getAddresses().forEach(_function_6);
    };
    allMicroserviceEndpoints.forEach(_function_5);
    return null;
  }
}
