package de.fhdo.lemma.operationdsl.validation;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import de.fhdo.lemma.data.PrimitiveType;
import de.fhdo.lemma.data.PrimitiveValue;
import de.fhdo.lemma.operation.BasicEndpoint;
import de.fhdo.lemma.operation.Container;
import de.fhdo.lemma.operation.ImportedMicroservice;
import de.fhdo.lemma.operation.ImportedOperationAspect;
import de.fhdo.lemma.operation.InfrastructureNode;
import de.fhdo.lemma.operation.OperationModel;
import de.fhdo.lemma.operation.OperationNode;
import de.fhdo.lemma.operation.OperationPackage;
import de.fhdo.lemma.operation.PossiblyImportedOperationNode;
import de.fhdo.lemma.operation.ProtocolAndDataFormat;
import de.fhdo.lemma.operation.ServiceDeploymentSpecification;
import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.ImportType;
import de.fhdo.lemma.service.Microservice;
import de.fhdo.lemma.service.ServiceModel;
import de.fhdo.lemma.service.ServicePackage;
import de.fhdo.lemma.technology.DataFormat;
import de.fhdo.lemma.technology.InfrastructureTechnology;
import de.fhdo.lemma.technology.OperationTechnology;
import de.fhdo.lemma.technology.PropertyFeature;
import de.fhdo.lemma.technology.Protocol;
import de.fhdo.lemma.technology.Technology;
import de.fhdo.lemma.technology.TechnologyPackage;
import de.fhdo.lemma.technology.TechnologySpecificProperty;
import de.fhdo.lemma.technology.TechnologySpecificPropertyValueAssignment;
import de.fhdo.lemma.utils.LemmaUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * This class contains validation rules for the Operation DSL.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class OperationDslValidator extends AbstractOperationDslValidator {
  /**
   * Check that the model is not empty
   */
  @Check
  public void checkModelNotEmpty(final OperationModel operationModel) {
    if ((operationModel.getContainers().isEmpty() && operationModel.getInfrastructureNodes().isEmpty())) {
      this.error("Model must contain at least one container or infrastructure node", operationModel, OperationPackage.Literals.OPERATION_MODEL__CONTAINERS);
    }
  }
  
  /**
   * Check that imported file is imported exactly once
   */
  @Check
  public void checkImportFileUniqueness(final OperationModel operationModel) {
    final String absolutePath = LemmaUtils.absolutePath(operationModel.eResource());
    final Function1<Import, String> _function = (Import it) -> {
      return LemmaUtils.convertToAbsolutePath(it.getImportURI(), absolutePath);
    };
    final List<String> absoluteImportPaths = ListExtensions.<Import, String>map(operationModel.getImports(), _function);
    final Function<String, String> _function_1 = (String it) -> {
      return it;
    };
    final Integer duplicateIndex = LemmaUtils.<String, String>getDuplicateIndex(absoluteImportPaths, _function_1);
    if (((duplicateIndex).intValue() == (-1))) {
      return;
    }
    final Import duplicate = operationModel.getImports().get((duplicateIndex).intValue());
    this.error("File is already being imported", duplicate, 
      ServicePackage.Literals.IMPORT__IMPORT_URI);
  }
  
  /**
   * Check import aliases for uniqueness
   */
  @Check
  public void checkImportAlias(final OperationModel operationModel) {
    final Function<Import, String> _function = (Import it) -> {
      return it.getName();
    };
    final Integer duplicateIndex = LemmaUtils.<Import, String>getDuplicateIndex(operationModel.getImports(), _function);
    if (((duplicateIndex).intValue() == (-1))) {
      return;
    }
    final Import duplicate = operationModel.getImports().get((duplicateIndex).intValue());
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Duplicate import alias ");
    String _name = duplicate.getName();
    _builder.append(_name);
    this.error(_builder.toString(), duplicate, 
      ServicePackage.Literals.IMPORT__NAME);
  }
  
  /**
   * Check that imported file defines a model that fits the given import type
   */
  @Check
  @Override
  public void checkImportType(final Import import_) {
    Class<? extends EObject> expectedModelType = null;
    String expectedModelTypeName = null;
    ImportType _importType = import_.getImportType();
    if (_importType != null) {
      switch (_importType) {
        case MICROSERVICES:
          expectedModelType = ServiceModel.class;
          expectedModelTypeName = "service";
          break;
        case TECHNOLOGY:
          expectedModelType = Technology.class;
          expectedModelTypeName = "technology";
          break;
        case OPERATION_NODES:
          expectedModelType = OperationModel.class;
          expectedModelTypeName = "operation";
          break;
        default:
          return;
      }
    } else {
      return;
    }
    boolean _isImportOfType = LemmaUtils.isImportOfType(import_.eResource(), import_.getImportURI(), expectedModelType);
    boolean _not = (!_isImportOfType);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("File does not contain a ");
      _builder.append(expectedModelTypeName);
      _builder.append(" model definition");
      this.error(_builder.toString(), import_, 
        ServicePackage.Literals.IMPORT__IMPORT_URI);
    }
  }
  
  /**
   * Check that annotated technologies define not only service-related concepts
   */
  @Check
  public void checkTechnologiesForDeploymentConcepts(final OperationNode operationNode) {
    int _size = operationNode.getTechnologies().size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        final Import technologyImport = operationNode.getTechnologies().get((i).intValue());
        final Technology technologyModel = LemmaUtils.<Technology>getImportedModelRoot(technologyImport.eResource(), 
          technologyImport.getImportURI(), Technology.class);
        if ((((technologyModel.getProtocols().isEmpty() && 
          technologyModel.getDeploymentTechnologies().isEmpty()) && 
          technologyModel.getInfrastructureTechnologies().isEmpty()) && 
          technologyModel.getOperationAspects().isEmpty())) {
          this.error("Technology does not specify operation-related concepts", 
            OperationPackage.Literals.OPERATION_NODE__TECHNOLOGIES, (i).intValue());
        }
      }
    }
  }
  
  /**
   * Check that the assigned value of a service property matches its type
   */
  @Check
  @Override
  public void checkPropertyValueType(final TechnologySpecificPropertyValueAssignment propertyValue) {
    if (((propertyValue.getProperty() == null) || (propertyValue.getValue() == null))) {
      return;
    }
    final TechnologySpecificProperty serviceProperty = propertyValue.getProperty();
    final PrimitiveType servicePropertyType = serviceProperty.getType();
    boolean _isOfType = propertyValue.getValue().isOfType(servicePropertyType);
    boolean _not = (!_isOfType);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Value is not of type ");
      String _typeName = servicePropertyType.getTypeName();
      _builder.append(_typeName);
      _builder.append(" ");
      this.error(_builder.toString(), propertyValue, 
        TechnologyPackage.Literals.TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_ASSIGNMENT__VALUE);
    }
  }
  
  /**
   * Check that technology is assigned only once to an operation node
   */
  @Check
  public void checkTechnologyUniqueness(final OperationNode operationNode) {
    final Function<Import, Import> _function = (Import it) -> {
      return it;
    };
    final Integer duplicateIndex = LemmaUtils.<Import, Import>getDuplicateIndex(operationNode.getTechnologies(), _function);
    if (((duplicateIndex).intValue() > (-1))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Duplicate technology assignment for ");
      String _name = operationNode.getName();
      _builder.append(_name);
      this.error(_builder.toString(), 
        OperationPackage.Literals.OPERATION_NODE__TECHNOLOGIES, (duplicateIndex).intValue());
    }
  }
  
  /**
   * Check multiplicities of service property values on containers
   */
  @Check
  public void checkServicePropertyMultiplicities(final Container container) {
    this.checkMultiplicities(container.getDefaultServicePropertyValues());
  }
  
  /**
   * Check multiplicities of service property values on service deployment specifications
   */
  @Check
  public void checkServicePropertyMultiplicities(final ServiceDeploymentSpecification deploymentSpecification) {
    this.checkMultiplicities(deploymentSpecification.getServicePropertyValues());
  }
  
  /**
   * Convenience method to multiplicities of property values
   */
  private void checkMultiplicities(final List<TechnologySpecificPropertyValueAssignment> values) {
    final Function1<TechnologySpecificPropertyValueAssignment, Boolean> _function = (TechnologySpecificPropertyValueAssignment it) -> {
      return Boolean.valueOf(it.getProperty().getFeatures().contains(PropertyFeature.SINGLE_VALUED));
    };
    final List<TechnologySpecificPropertyValueAssignment> valuesOfSingleValuedProperties = IterableExtensions.<TechnologySpecificPropertyValueAssignment>toList(IterableExtensions.<TechnologySpecificPropertyValueAssignment>filter(values, _function));
    int _size = valuesOfSingleValuedProperties.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final Integer i : _doubleDotLessThan) {
      {
        final List<TechnologySpecificPropertyValueAssignment> remainingList = valuesOfSingleValuedProperties.subList((i).intValue(), valuesOfSingleValuedProperties.size());
        final Function<TechnologySpecificPropertyValueAssignment, String> _function_1 = (TechnologySpecificPropertyValueAssignment it) -> {
          return it.getProperty().getName();
        };
        final Integer duplicateIndex = LemmaUtils.<TechnologySpecificPropertyValueAssignment, String>getDuplicateIndex(remainingList, _function_1);
        if (((duplicateIndex).intValue() > (-1))) {
          final TechnologySpecificPropertyValueAssignment duplicate = remainingList.get((duplicateIndex).intValue());
          String _name = duplicate.getProperty().getName();
          String _plus = ("Duplicate value assignment to single-value service property " + _name);
          this.error(_plus, duplicate, 
            TechnologyPackage.Literals.TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_ASSIGNMENT__PROPERTY);
        }
      }
    }
  }
  
  /**
   * Check unique endpoints on containers
   */
  @Check
  public void checkUniqueEndpoints(final Container container) {
    this.checkUniqueEndpoints(container.getDefaultBasicEndpoints());
  }
  
  /**
   * Check unique endpoints on infrastructure nodes
   */
  @Check
  public void checkUniqueEndpoints(final InfrastructureNode infrastructureNode) {
    this.checkUniqueEndpoints(infrastructureNode.getEndpoints());
  }
  
  /**
   * Check unique endpoints on service deployment specification
   */
  @Check
  public void checkUniqueEndpoints(final ServiceDeploymentSpecification deploymentSpecification) {
    this.checkUniqueEndpoints(deploymentSpecification.getBasicEndpoints());
  }
  
  /**
   * Convenience method to check endpoint uniqueness in a list of endpoints
   */
  private void checkUniqueEndpoints(final List<BasicEndpoint> endpoints) {
    final HashSet<String> protocolSet = CollectionLiterals.<String>newHashSet();
    final Consumer<BasicEndpoint> _function = (BasicEndpoint endpoint) -> {
      int _size = endpoint.getProtocols().size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for (final Integer i : _doubleDotLessThan) {
        {
          final ProtocolAndDataFormat protocolAndDataFormat = endpoint.getProtocols().get((i).intValue());
          String protocolId = protocolAndDataFormat.getProtocol().getName();
          DataFormat _dataFormat = protocolAndDataFormat.getDataFormat();
          boolean _tripleNotEquals = (_dataFormat != null);
          if (_tripleNotEquals) {
            String _protocolId = protocolId;
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("(");
            String _formatName = protocolAndDataFormat.getDataFormat().getFormatName();
            _builder.append(_formatName);
            _builder.append(")");
            protocolId = (_protocolId + _builder);
          } else {
            String _protocolId_1 = protocolId;
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("(");
            String _formatName_1 = protocolAndDataFormat.getProtocol().getDefaultFormat().getFormatName();
            _builder_1.append(_formatName_1);
            _builder_1.append(")");
            protocolId = (_protocolId_1 + _builder_1);
          }
          boolean _add = protocolSet.add(protocolId);
          final boolean isDuplicate = (!_add);
          if (isDuplicate) {
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("Duplicate endpoint for protocol ");
            _builder_2.append(protocolId);
            this.error(_builder_2.toString(), protocolAndDataFormat, 
              OperationPackage.Literals.PROTOCOL_AND_DATA_FORMAT__PROTOCOL, (i).intValue());
          }
        }
      }
    };
    endpoints.forEach(_function);
  }
  
  /**
   * Check uniqueness of an endpoint's addresses
   */
  @Check
  public void checkUniqueEndpointAddresses(final BasicEndpoint endpoint) {
    final Function<String, String> _function = (String it) -> {
      return it;
    };
    final Integer duplicateIndex = LemmaUtils.<String, String>getDuplicateIndex(endpoint.getAddresses(), _function);
    if (((duplicateIndex).intValue() > (-1))) {
      final String duplicate = endpoint.getAddresses().get((duplicateIndex).intValue());
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Duplicate address ");
      _builder.append(duplicate);
      this.error(_builder.toString(), endpoint, 
        OperationPackage.Literals.BASIC_ENDPOINT__ADDRESSES, (duplicateIndex).intValue());
    }
  }
  
  /**
   * Warn if endpoint addresses occur more than once when the same microservice is deployed to
   * different containers. Node that containers may exhibit the same endpoint addresses for
   * different microservices, because typically the microservice determines additional endpoint
   * address parts, e.g., the path fragment of a URI, while containers determine the physical
   * endpoint parts, e.g., the scheme and authority of a URI.
   */
  @Check
  public void warnSameAddressOnDifferentContainers(final Container containerToCheck) {
    final Function1<Container, Boolean> _function = (Container otherContainer) -> {
      return Boolean.valueOf(((!Objects.equal(otherContainer, containerToCheck)) && 
        IterableExtensions.<ImportedMicroservice>exists(otherContainer.getDeployedServices(), 
          ((Function1<ImportedMicroservice, Boolean>) (ImportedMicroservice it) -> {
            final Function1<ImportedMicroservice, Microservice> _function_1 = (ImportedMicroservice it_1) -> {
              return it_1.getMicroservice();
            };
            return Boolean.valueOf(ListExtensions.<ImportedMicroservice, Microservice>map(containerToCheck.getDeployedServices(), _function_1).contains(it.getMicroservice()));
          }))));
    };
    final Iterable<Container> otherContainersWithSameMicroservices = IterableExtensions.<Container>filter(containerToCheck.getOperationModel().getContainers(), _function);
    boolean _isEmpty = IterableExtensions.isEmpty(otherContainersWithSameMicroservices);
    if (_isEmpty) {
      return;
    }
    final BiConsumer<String, Pair<BasicEndpoint, Integer>> _function_1 = (String addressToCheck, Pair<BasicEndpoint, Integer> addressEndpointAndIndex) -> {
      final Consumer<Container> _function_2 = (Container it) -> {
        final Function1<BasicEndpoint, EList<String>> _function_3 = (BasicEndpoint it_1) -> {
          return it_1.getAddresses();
        };
        boolean _contains = IterableExtensions.<String>toList(Iterables.<String>concat(ListExtensions.<BasicEndpoint, EList<String>>map(it.getDefaultBasicEndpoints(), _function_3))).contains(addressToCheck);
        if (_contains) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Address ");
          _builder.append(addressToCheck);
          _builder.append(" is already specified on a container ");
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("that deploys the same microservices");
          String _plus = (_builder.toString() + _builder_1);
          this.warning(_plus, addressEndpointAndIndex.getKey(), 
            OperationPackage.Literals.BASIC_ENDPOINT__ADDRESSES, 
            (addressEndpointAndIndex.getValue()).intValue());
        }
        final Consumer<ServiceDeploymentSpecification> _function_4 = (ServiceDeploymentSpecification it_1) -> {
          final Function1<BasicEndpoint, EList<String>> _function_5 = (BasicEndpoint it_2) -> {
            return it_2.getAddresses();
          };
          boolean _contains_1 = IterableExtensions.<String>toList(Iterables.<String>concat(ListExtensions.<BasicEndpoint, EList<String>>map(it_1.getBasicEndpoints(), _function_5))).contains(addressToCheck);
          if (_contains_1) {
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append("Address ");
            _builder_2.append(addressToCheck);
            _builder_2.append(" is already specified on a container ");
            StringConcatenation _builder_3 = new StringConcatenation();
            _builder_3.append("that deploys the same microservices");
            String _plus_1 = (_builder_2.toString() + _builder_3);
            this.warning(_plus_1, addressEndpointAndIndex.getKey(), 
              OperationPackage.Literals.BASIC_ENDPOINT__ADDRESSES, 
              (addressEndpointAndIndex.getValue()).intValue());
          }
        };
        it.getDeploymentSpecifications().forEach(_function_4);
      };
      otherContainersWithSameMicroservices.forEach(_function_2);
    };
    this.getAddressesAndEndpoints(containerToCheck).forEach(_function_1);
  }
  
  /**
   * Check if addresses occur more than once for between infrastructure nodes and other
   * infrastructure nodes or containers
   */
  @Check
  public void checkDuplicateEndpointAddresses(final OperationModel model) {
    final HashMap<String, Pair<BasicEndpoint, Integer>> infrastructureNodeAddresses = CollectionLiterals.<String, Pair<BasicEndpoint, Integer>>newHashMap();
    final Consumer<InfrastructureNode> _function = (InfrastructureNode it) -> {
      final BiConsumer<String, Pair<BasicEndpoint, Integer>> _function_1 = (String address, Pair<BasicEndpoint, Integer> endpointAndIndex) -> {
        boolean _containsKey = infrastructureNodeAddresses.containsKey(address);
        boolean _not = (!_containsKey);
        if (_not) {
          infrastructureNodeAddresses.put(address, endpointAndIndex);
        } else {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Address ");
          _builder.append(address);
          _builder.append(" is already specified for an endpoint of ");
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("another infrastructure node");
          String _plus = (_builder.toString() + _builder_1);
          this.error(_plus, endpointAndIndex.getKey(), 
            OperationPackage.Literals.BASIC_ENDPOINT__ADDRESSES, 
            (endpointAndIndex.getValue()).intValue());
        }
      };
      this.getAddressesAndEndpoints(it).forEach(_function_1);
    };
    model.getInfrastructureNodes().forEach(_function);
    final Consumer<Container> _function_1 = (Container it) -> {
      final BiConsumer<String, Pair<BasicEndpoint, Integer>> _function_2 = (String address, Pair<BasicEndpoint, Integer> endpointAndIndex) -> {
        boolean _containsKey = infrastructureNodeAddresses.containsKey(address);
        if (_containsKey) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Address ");
          _builder.append(address);
          _builder.append(" is already specified for an endpoint of ");
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("an infrastructure node");
          String _plus = (_builder.toString() + _builder_1);
          this.error(_plus, endpointAndIndex.getKey(), 
            OperationPackage.Literals.BASIC_ENDPOINT__ADDRESSES, 
            (endpointAndIndex.getValue()).intValue());
        }
      };
      this.getAddressesAndEndpoints(it).forEach(_function_2);
    };
    model.getContainers().forEach(_function_1);
  }
  
  /**
   * Helper to get all addresses, their endpoints, and endpoint indexes of an operation node
   */
  private Map<String, Pair<BasicEndpoint, Integer>> getAddressesAndEndpoints(final OperationNode node) {
    final HashMap<String, Pair<BasicEndpoint, Integer>> addressesAndEndpoint = CollectionLiterals.<String, Pair<BasicEndpoint, Integer>>newHashMap();
    if ((node instanceof Container)) {
      final Consumer<BasicEndpoint> _function = (BasicEndpoint endpoint) -> {
        int _size = endpoint.getAddresses().size();
        ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
        for (final Integer n : _doubleDotLessThan) {
          {
            final String address = endpoint.getAddresses().get((n).intValue());
            addressesAndEndpoint.put(address, Pair.<BasicEndpoint, Integer>of(endpoint, n));
          }
        }
      };
      ((Container)node).getDefaultBasicEndpoints().forEach(_function);
    } else {
      if ((node instanceof InfrastructureNode)) {
        final Consumer<BasicEndpoint> _function_1 = (BasicEndpoint endpoint) -> {
          int _size = endpoint.getAddresses().size();
          ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
          for (final Integer n : _doubleDotLessThan) {
            {
              final String address = endpoint.getAddresses().get((n).intValue());
              addressesAndEndpoint.put(address, Pair.<BasicEndpoint, Integer>of(endpoint, n));
            }
          }
        };
        ((InfrastructureNode)node).getEndpoints().forEach(_function_1);
      }
    }
    final Consumer<ServiceDeploymentSpecification> _function_2 = (ServiceDeploymentSpecification it) -> {
      final Consumer<BasicEndpoint> _function_3 = (BasicEndpoint endpoint) -> {
        int _size = endpoint.getAddresses().size();
        ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
        for (final Integer n : _doubleDotLessThan) {
          {
            final String address = endpoint.getAddresses().get((n).intValue());
            addressesAndEndpoint.put(address, Pair.<BasicEndpoint, Integer>of(endpoint, n));
          }
        }
      };
      it.getBasicEndpoints().forEach(_function_3);
    };
    node.getDeploymentSpecifications().forEach(_function_2);
    return addressesAndEndpoint;
  }
  
  /**
   * Check that mandatory service properties have values assigned
   */
  @Check
  public void checkMandatoryPropertiesHaveValues(final OperationNode operationNode) {
    OperationTechnology _xifexpression = null;
    if ((operationNode instanceof Container)) {
      _xifexpression = ((Container)operationNode).getDeploymentTechnology().getDeploymentTechnology();
    } else {
      InfrastructureTechnology _xifexpression_1 = null;
      if ((operationNode instanceof InfrastructureNode)) {
        _xifexpression_1 = ((InfrastructureNode)operationNode).getInfrastructureTechnology().getInfrastructureTechnology();
      }
      _xifexpression = _xifexpression_1;
    }
    final OperationTechnology operationTechnology = _xifexpression;
    if ((operationTechnology == null)) {
      return;
    }
    final Function1<TechnologySpecificProperty, Boolean> _function = (TechnologySpecificProperty technologyProperty) -> {
      return Boolean.valueOf((technologyProperty.isIsMandatory() && (!IterableExtensions.<TechnologySpecificPropertyValueAssignment>exists(operationNode.getDefaultServicePropertyValues(), ((Function1<TechnologySpecificPropertyValueAssignment, Boolean>) (TechnologySpecificPropertyValueAssignment defaultProperty) -> {
        String _name = defaultProperty.getProperty().getName();
        String _name_1 = technologyProperty.getName();
        return Boolean.valueOf(Objects.equal(_name, _name_1));
      })))));
    };
    final Iterable<TechnologySpecificProperty> mandatoryNonDefaultProperties = IterableExtensions.<TechnologySpecificProperty>filter(operationTechnology.getServiceProperties(), _function);
    boolean _isEmpty = IterableExtensions.isEmpty(mandatoryNonDefaultProperties);
    if (_isEmpty) {
      return;
    }
    int _size = operationNode.getDeploymentSpecifications().size();
    int _size_1 = operationNode.getDeployedServices().size();
    final boolean hasMissingSpecifications = (_size < _size_1);
    if (hasMissingSpecifications) {
      final String firstMissingPropertyName = (((TechnologySpecificProperty[])Conversions.unwrapArray(mandatoryNonDefaultProperties, TechnologySpecificProperty.class))[0]).getName();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("All deployed services must specify a value for mandatory property ");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(firstMissingPropertyName);
      String _plus = (_builder.toString() + _builder_1);
      this.error(_plus, operationNode, 
        OperationPackage.Literals.OPERATION_NODE__NAME);
      return;
    }
    final Consumer<TechnologySpecificProperty> _function_1 = (TechnologySpecificProperty property) -> {
      final Consumer<ServiceDeploymentSpecification> _function_2 = (ServiceDeploymentSpecification it) -> {
        final Function1<TechnologySpecificPropertyValueAssignment, Boolean> _function_3 = (TechnologySpecificPropertyValueAssignment it_1) -> {
          String _name = property.getName();
          String _name_1 = property.getName();
          return Boolean.valueOf(Objects.equal(_name, _name_1));
        };
        boolean _exists = IterableExtensions.<TechnologySpecificPropertyValueAssignment>exists(it.getServicePropertyValues(), _function_3);
        boolean _not = (!_exists);
        if (_not) {
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("All deployed services must specify a value for mandatory property ");
          StringConcatenation _builder_3 = new StringConcatenation();
          String _name = property.getName();
          _builder_3.append(_name);
          String _plus_1 = (_builder_2.toString() + _builder_3);
          this.error(_plus_1, operationNode, 
            OperationPackage.Literals.OPERATION_NODE__NAME);
          return;
        }
      };
      operationNode.getDeploymentSpecifications().forEach(_function_2);
    };
    mandatoryNonDefaultProperties.forEach(_function_1);
    if (((operationNode instanceof InfrastructureNode) && operationNode.getDeployedServices().isEmpty())) {
      final String firstMissingPropertyName_1 = (((TechnologySpecificProperty[])Conversions.unwrapArray(mandatoryNonDefaultProperties, TechnologySpecificProperty.class))[0]).getName();
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("Mandatory property ");
      _builder_2.append(firstMissingPropertyName_1);
      _builder_2.append(" must receive a value");
      this.error(_builder_2.toString(), operationNode, OperationPackage.Literals.OPERATION_NODE__NAME);
    }
  }
  
  /**
   * Warn in case not each service deployed to a container has a basic endpoint assigned for each
   * protocol/format combination from each assigned technology of the container
   */
  @Check
  public void warnServicesForBasicEndpoints(final Container container) {
    if (((container.getTechnologies() == null) || container.getTechnologies().isEmpty())) {
      return;
    }
    final Consumer<Import> _function = (Import it) -> {
      this.warnServicesForBasicEndpoints(container, it);
    };
    container.getTechnologies().forEach(_function);
  }
  
  /**
   * Helper to warn if a service deployed to a given container does not have a basic endpoint
   * for each protocol/format combination in the given technology of the container
   */
  private void warnServicesForBasicEndpoints(final Container container, final Import technologyImport) {
    final List<EObject> technologyModel = LemmaUtils.getImportedModelContents(technologyImport.eResource(), 
      technologyImport.getImportURI());
    if (((technologyModel == null) || technologyModel.isEmpty())) {
      return;
    }
    EObject _get = technologyModel.get(0);
    boolean _not = (!(_get instanceof Technology));
    if (_not) {
      return;
    }
    final HashMap<String, List<String>> protocolsWithoutDefaultEndpoint = CollectionLiterals.<String, List<String>>newHashMap();
    EObject _get_1 = technologyModel.get(0);
    final Technology technology = ((Technology) _get_1);
    final Consumer<Protocol> _function = (Protocol it) -> {
      final Protocol protocol = ((Protocol) it);
      protocolsWithoutDefaultEndpoint.putIfAbsent(protocol.getName(), CollectionLiterals.<String>newArrayList());
      final Function1<DataFormat, String> _function_1 = (DataFormat it_1) -> {
        return it_1.getFormatName();
      };
      protocolsWithoutDefaultEndpoint.get(protocol.getName()).addAll(ListExtensions.<DataFormat, String>map(protocol.getDataFormats(), _function_1));
    };
    technology.getProtocols().forEach(_function);
    final Consumer<BasicEndpoint> _function_1 = (BasicEndpoint endpoint) -> {
      final Consumer<ProtocolAndDataFormat> _function_2 = (ProtocolAndDataFormat protocolAndDataFormat) -> {
        final Protocol protocol = protocolAndDataFormat.getProtocol();
        final DataFormat dataFormat = protocolAndDataFormat.getDataFormat();
        if ((dataFormat != null)) {
          final List<String> remainingDataFormats = protocolsWithoutDefaultEndpoint.get(protocol.getName());
          int _size = remainingDataFormats.size();
          boolean _equals = (_size == 1);
          if (_equals) {
            protocolsWithoutDefaultEndpoint.remove(protocol.getName());
          } else {
            remainingDataFormats.remove(dataFormat);
          }
        } else {
          protocolsWithoutDefaultEndpoint.remove(protocol.getName());
        }
      };
      endpoint.getProtocols().forEach(_function_2);
    };
    container.getDefaultBasicEndpoints().forEach(_function_1);
    final BiConsumer<String, List<String>> _function_2 = (String protocol, List<String> dataFormats) -> {
      boolean _isEmpty = container.getDeploymentSpecifications().isEmpty();
      if (_isEmpty) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("No basic endpoint specified for protocol ");
        _builder.append(protocol);
        this.warning(_builder.toString(), container, 
          OperationPackage.Literals.OPERATION_NODE__NAME);
      }
      final Consumer<String> _function_3 = (String format) -> {
        final Consumer<ServiceDeploymentSpecification> _function_4 = (ServiceDeploymentSpecification it) -> {
          final boolean specifiedByBasicEndpoint = ((!it.getBasicEndpoints().isEmpty()) && 
            IterableExtensions.<ProtocolAndDataFormat>exists(Iterables.<ProtocolAndDataFormat>concat(ListExtensions.<BasicEndpoint, EList<ProtocolAndDataFormat>>map(it.getBasicEndpoints(), ((Function1<BasicEndpoint, EList<ProtocolAndDataFormat>>) (BasicEndpoint it_1) -> {
              return it_1.getProtocols();
            }))), 
              ((Function1<ProtocolAndDataFormat, Boolean>) (ProtocolAndDataFormat it_1) -> {
                boolean _and = false;
                String _name = it_1.getProtocol().getName();
                boolean _equals = Objects.equal(_name, protocol);
                if (!_equals) {
                  _and = false;
                } else {
                  boolean _xifexpression = false;
                  DataFormat _dataFormat = it_1.getDataFormat();
                  boolean _tripleNotEquals = (_dataFormat != null);
                  if (_tripleNotEquals) {
                    String _formatName = it_1.getDataFormat().getFormatName();
                    _xifexpression = Objects.equal(_formatName, format);
                  } else {
                    _xifexpression = true;
                  }
                  _and = _xifexpression;
                }
                return Boolean.valueOf(_and);
              })));
          if ((!specifiedByBasicEndpoint)) {
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("No basic endpoint specified for protocol ");
            _builder_1.append(protocol);
            _builder_1.append("/");
            _builder_1.append(format);
            _builder_1.append(" ");
            this.warning(_builder_1.toString(), container, OperationPackage.Literals.OPERATION_NODE__NAME);
          }
        };
        container.getDeploymentSpecifications().forEach(_function_4);
      };
      dataFormats.forEach(_function_3);
    };
    protocolsWithoutDefaultEndpoint.forEach(_function_2);
  }
  
  /**
   * Check uniqueness of service deployment specifications
   */
  @Check
  public void checkDeploymentSpecificationsUniqueness(final OperationNode operationNode) {
    final Function<ServiceDeploymentSpecification, String> _function = (ServiceDeploymentSpecification it) -> {
      String _name = it.getImport().getName();
      QualifiedName _create = QualifiedName.create(it.getService().getMicroservice().getQualifiedNameParts());
      return (_name + _create);
    };
    final Integer duplicateIndex = LemmaUtils.<ServiceDeploymentSpecification, String>getDuplicateIndex(operationNode.getDeploymentSpecifications(), _function);
    if (((duplicateIndex).intValue() > (-1))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Duplicate deployment specification");
      this.error(_builder.toString(), operationNode, 
        OperationPackage.Literals.OPERATION_NODE__DEPLOYMENT_SPECIFICATIONS, (duplicateIndex).intValue());
    }
  }
  
  /**
   * Check uniqueness of deployed services
   */
  @Check
  public void checkDeployedServicesUniqueness(final OperationNode operationNode) {
    final Function<ImportedMicroservice, String> _function = (ImportedMicroservice it) -> {
      String _name = it.getImport().getName();
      QualifiedName _create = QualifiedName.create(it.getMicroservice().getQualifiedNameParts());
      return (_name + _create);
    };
    final Integer duplicateIndex = LemmaUtils.<ImportedMicroservice, String>getDuplicateIndex(operationNode.getDeployedServices(), _function);
    if (((duplicateIndex).intValue() > (-1))) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Duplicate deployed service");
      this.error(_builder.toString(), operationNode, 
        OperationPackage.Literals.OPERATION_NODE__DEPLOYED_SERVICES, (duplicateIndex).intValue());
    }
  }
  
  /**
   * Warn if an infrastructure node does seemingly not fulfill an actual purpose, i.e., when it
   * does not have deployed services assigned, is not used by other nodes, and no other nodes
   * depend on it
   */
  @Check
  public void warnNodeHasPurpose(final InfrastructureNode infrastructureNode) {
    if (((!infrastructureNode.getDeployedServices().isEmpty()) || (!infrastructureNode.getUsedByNodes().isEmpty()))) {
      return;
    }
    final Function1<InfrastructureNode, Boolean> _function = (InfrastructureNode it) -> {
      return Boolean.valueOf(it.getDependsOnNodes().contains(infrastructureNode));
    };
    final boolean dependentNodesExist = IterableExtensions.<InfrastructureNode>exists(EcoreUtil2.<InfrastructureNode>getSiblingsOfType(infrastructureNode, InfrastructureNode.class), _function);
    if ((!dependentNodesExist)) {
      this.warning("Node is not used by services or nodes, and no other node depends on it", infrastructureNode, OperationPackage.Literals.OPERATION_NODE__NAME);
    }
  }
  
  /**
   * Check that node is used by unique nodes
   */
  @Check
  public void checkUsingNodesUniqueness(final OperationNode operationNode) {
    final Function<PossiblyImportedOperationNode, String> _function = (PossiblyImportedOperationNode it) -> {
      return it.getNode().getName();
    };
    final Integer duplicateIndex = LemmaUtils.<PossiblyImportedOperationNode, String>getDuplicateIndex(operationNode.getUsedByNodes(), _function);
    if (((duplicateIndex).intValue() > (-1))) {
      this.error("Duplicate node", operationNode, 
        OperationPackage.Literals.OPERATION_NODE__USED_BY_NODES, (duplicateIndex).intValue());
    }
  }
  
  /**
   * Check that node depends on unique nodes
   */
  @Check
  public void checkDependingNodesUniqueness(final OperationNode operationNode) {
    final Function<PossiblyImportedOperationNode, String> _function = (PossiblyImportedOperationNode it) -> {
      return it.getNode().getName();
    };
    final Integer duplicateIndex = LemmaUtils.<PossiblyImportedOperationNode, String>getDuplicateIndex(operationNode.getDependsOnNodes(), _function);
    if (((duplicateIndex).intValue() > (-1))) {
      this.error("Duplicate node", operationNode, 
        OperationPackage.Literals.OPERATION_NODE__DEPENDS_ON_NODES, (duplicateIndex).intValue());
    }
  }
  
  /**
   * Warn, if required microservices are not deployed in the same model
   */
  @Check
  public void warnRequiredMicroservicesAreNotDeployed(final OperationModel operationModel) {
    final HashSet<Microservice> allDeployedServices = CollectionLiterals.<Microservice>newHashSet();
    final Function1<Container, EList<ImportedMicroservice>> _function = (Container it) -> {
      return it.getDeployedServices();
    };
    final Function1<ImportedMicroservice, Microservice> _function_1 = (ImportedMicroservice it) -> {
      return it.getMicroservice();
    };
    Iterables.<Microservice>addAll(allDeployedServices, 
      IterableExtensions.<ImportedMicroservice, Microservice>map(Iterables.<ImportedMicroservice>concat(ListExtensions.<Container, EList<ImportedMicroservice>>map(operationModel.getContainers(), _function)), _function_1));
    final Function1<Container, EList<ImportedMicroservice>> _function_2 = (Container it) -> {
      return it.getDeployedServices();
    };
    final Consumer<ImportedMicroservice> _function_3 = (ImportedMicroservice importedService) -> {
      final Microservice deployedService = importedService.getMicroservice();
      String _name = importedService.getImport().getName();
      String _plus = (_name + "::");
      String _string = QualifiedName.create(deployedService.getQualifiedNameParts()).toString();
      final String deployedName = (_plus + _string);
      final HashMap<Microservice, String> requiredServices = CollectionLiterals.<Microservice, String>newHashMap();
      final BiConsumer<Microservice, Import> _function_4 = (Microservice microservice, Import import_) -> {
        String _xifexpression = null;
        if ((import_ != null)) {
          String _name_1 = import_.getName();
          _xifexpression = (_name_1 + "::");
        } else {
          _xifexpression = "";
        }
        String requiredName = _xifexpression;
        String _requiredName = requiredName;
        String _string_1 = QualifiedName.create(microservice.getQualifiedNameParts()).toString();
        requiredName = (_requiredName + _string_1);
        requiredServices.put(microservice, requiredName);
      };
      deployedService.getAllRequiredMicroservices().forEach(_function_4);
      final BiConsumer<Microservice, String> _function_5 = (Microservice requiredService, String requiredName) -> {
        boolean _contains = allDeployedServices.contains(requiredService);
        boolean _not = (!_contains);
        if (_not) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Service ");
          _builder.append(deployedName);
          _builder.append(" requires service ");
          _builder.append(requiredName);
          _builder.append(", which ");
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("is not deployed by this model");
          String _plus_1 = (_builder.toString() + _builder_1);
          this.warning(_plus_1, importedService, 
            OperationPackage.Literals.IMPORTED_MICROSERVICE__OPERATION_NODE);
        }
      };
      requiredServices.forEach(_function_5);
    };
    Iterables.<ImportedMicroservice>concat(ListExtensions.<Container, EList<ImportedMicroservice>>map(operationModel.getContainers(), _function_2)).forEach(_function_3);
  }
  
  /**
   * Warn, if services deployed to infrastructure nodes are not also deployed to containers
   */
  @Check
  public void warnInfrastructureDeployments(final OperationModel operationModel) {
    final HashMap<Microservice, List<ImportedMicroservice>> infrastructureServices = CollectionLiterals.<Microservice, List<ImportedMicroservice>>newHashMap();
    final Function1<InfrastructureNode, EList<ImportedMicroservice>> _function = (InfrastructureNode it) -> {
      return it.getDeployedServices();
    };
    final Consumer<ImportedMicroservice> _function_1 = (ImportedMicroservice it) -> {
      List<ImportedMicroservice> associatedImportedServices = infrastructureServices.get(it.getMicroservice());
      if ((associatedImportedServices == null)) {
        associatedImportedServices = CollectionLiterals.<ImportedMicroservice>newArrayList();
        infrastructureServices.put(it.getMicroservice(), associatedImportedServices);
      }
      associatedImportedServices.add(it);
    };
    Iterables.<ImportedMicroservice>concat(ListExtensions.<InfrastructureNode, EList<ImportedMicroservice>>map(operationModel.getInfrastructureNodes(), _function)).forEach(_function_1);
    final HashSet<Microservice> containerServices = CollectionLiterals.<Microservice>newHashSet();
    final Function1<Container, EList<ImportedMicroservice>> _function_2 = (Container it) -> {
      return it.getDeployedServices();
    };
    final Function1<ImportedMicroservice, Microservice> _function_3 = (ImportedMicroservice it) -> {
      return it.getMicroservice();
    };
    Iterables.<Microservice>addAll(containerServices, 
      IterableExtensions.<ImportedMicroservice, Microservice>map(Iterables.<ImportedMicroservice>concat(ListExtensions.<Container, EList<ImportedMicroservice>>map(operationModel.getContainers(), _function_2)), _function_3));
    final BiConsumer<Microservice, List<ImportedMicroservice>> _function_4 = (Microservice infrastructureService, List<ImportedMicroservice> associatedImportedServices) -> {
      boolean _contains = containerServices.contains(infrastructureService);
      boolean _not = (!_contains);
      if (_not) {
        final Consumer<ImportedMicroservice> _function_5 = (ImportedMicroservice it) -> {
          this.warning("Service is not deployed to container", it, 
            OperationPackage.Literals.IMPORTED_MICROSERVICE__OPERATION_NODE);
        };
        associatedImportedServices.forEach(_function_5);
      }
    };
    infrastructureServices.forEach(_function_4);
  }
  
  /**
   * Check uniqueness of aspects
   */
  @Check
  public void checkAspectUniqueness(final ImportedOperationAspect importedAspect) {
    boolean _isIsSingleValued = importedAspect.getAspect().isIsSingleValued();
    boolean _not = (!_isIsSingleValued);
    if (_not) {
      return;
    }
    final Function1<ImportedOperationAspect, Boolean> _function = (ImportedOperationAspect it) -> {
      return Boolean.valueOf(((!Objects.equal(it, it.getAspect())) && 
        Objects.equal(it.getAspect().getName(), importedAspect.getAspect().getName())));
    };
    final Iterable<ImportedOperationAspect> eponymousAspectsOfContainer = IterableExtensions.<ImportedOperationAspect>filter(EcoreUtil2.<ImportedOperationAspect>getSiblingsOfType(importedAspect, 
      ImportedOperationAspect.class), _function);
    boolean _isEmpty = IterableExtensions.isEmpty(eponymousAspectsOfContainer);
    boolean _not_1 = (!_isEmpty);
    if (_not_1) {
      final ImportedOperationAspect duplicateAspect = ((ImportedOperationAspect[])Conversions.unwrapArray(eponymousAspectsOfContainer, ImportedOperationAspect.class))[0];
      this.error("Aspect may be specified at most once", duplicateAspect, 
        OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__ASPECT);
    }
  }
  
  /**
   * Check uniqueness of aspect properties in value assignments
   */
  @Check
  public void checkUniqueValueAssignments(final ImportedOperationAspect importedAspect) {
    if ((importedAspect.getValues().isEmpty() || (importedAspect.getAspect().getProperties().size() <= 1))) {
      return;
    }
    final Function<TechnologySpecificPropertyValueAssignment, String> _function = (TechnologySpecificPropertyValueAssignment it) -> {
      return it.getProperty().getName();
    };
    final Integer duplicateIndex = LemmaUtils.<TechnologySpecificPropertyValueAssignment, String>getDuplicateIndex(importedAspect.getValues(), _function);
    if (((duplicateIndex).intValue() > (-1))) {
      this.error("Duplicate value assignment to property", 
        OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__VALUES, (duplicateIndex).intValue());
    }
  }
  
  /**
   * Check that aspect has only one property, if only a single value is specified, and that the
   * specified value matches the property's type
   */
  @Check
  public void checkSingleAspectProperty(final ImportedOperationAspect importedAspect) {
    final PrimitiveValue propertyValue = importedAspect.getSinglePropertyValue();
    if ((propertyValue == null)) {
      return;
    }
    final int propertyCount = importedAspect.getAspect().getProperties().size();
    if ((propertyCount == 0)) {
      this.error("Aspect does not define properties", importedAspect, 
        OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__SINGLE_PROPERTY_VALUE);
    } else {
      if ((propertyCount > 1)) {
        this.error("Ambiguous value assignment", importedAspect, 
          OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__SINGLE_PROPERTY_VALUE);
      } else {
        if ((propertyCount == 1)) {
          final TechnologySpecificProperty targetProperty = importedAspect.getAspect().getProperties().get(0);
          final PrimitiveType targetPropertyType = targetProperty.getType();
          boolean _isOfType = propertyValue.isOfType(targetPropertyType);
          boolean _not = (!_isOfType);
          if (_not) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("Value is not of type ");
            String _typeName = targetPropertyType.getTypeName();
            _builder.append(_typeName);
            _builder.append(" as expected by ");
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append("property ");
            String _name = targetProperty.getName();
            _builder_1.append(_name);
            String _plus = (_builder.toString() + _builder_1);
            this.error(_plus, importedAspect, 
              OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__SINGLE_PROPERTY_VALUE);
          }
        }
      }
    }
  }
  
  /**
   * Check that mandatory properties of aspects have values
   */
  @Check
  public void checkMandatoryAspectProperties(final ImportedOperationAspect importedAspect) {
    final EList<TechnologySpecificProperty> aspectProperties = importedAspect.getAspect().getProperties();
    final Function1<TechnologySpecificProperty, Boolean> _function = (TechnologySpecificProperty it) -> {
      return Boolean.valueOf(it.isIsMandatory());
    };
    final Iterable<TechnologySpecificProperty> mandatoryProperties = IterableExtensions.<TechnologySpecificProperty>filter(aspectProperties, _function);
    final Function1<TechnologySpecificProperty, Boolean> _function_1 = (TechnologySpecificProperty it) -> {
      final Function1<TechnologySpecificPropertyValueAssignment, TechnologySpecificProperty> _function_2 = (TechnologySpecificPropertyValueAssignment it_1) -> {
        return it_1.getProperty();
      };
      boolean _contains = ListExtensions.<TechnologySpecificPropertyValueAssignment, TechnologySpecificProperty>map(importedAspect.getValues(), _function_2).contains(it);
      return Boolean.valueOf((!_contains));
    };
    final Iterable<TechnologySpecificProperty> mandatoryPropertiesWithoutValues = IterableExtensions.<TechnologySpecificProperty>filter(mandatoryProperties, _function_1);
    final boolean allMandatoryPropertiesHaveValues = IterableExtensions.isEmpty(mandatoryPropertiesWithoutValues);
    final boolean aspectHasExactlyOneMandatoryProperty = ((aspectProperties.size() == 1) && 
      (!IterableExtensions.isEmpty(mandatoryProperties)));
    if (aspectHasExactlyOneMandatoryProperty) {
      if (((importedAspect.getSinglePropertyValue() == null) && (!allMandatoryPropertiesHaveValues))) {
        final TechnologySpecificProperty mandatoryProperty = ((TechnologySpecificProperty[])Conversions.unwrapArray(mandatoryProperties, TechnologySpecificProperty.class))[0];
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Mandatory property ");
        String _name = mandatoryProperty.getName();
        _builder.append(_name);
        _builder.append(" does not have value");
        this.error(_builder.toString(), importedAspect, 
          OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__ASPECT);
      }
    } else {
      if ((!allMandatoryPropertiesHaveValues)) {
        final Consumer<TechnologySpecificProperty> _function_2 = (TechnologySpecificProperty it) -> {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("Mandatory property ");
          String _name_1 = it.getName();
          _builder_1.append(_name_1);
          _builder_1.append(" does not have value");
          this.error(_builder_1.toString(), importedAspect, 
            OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__ASPECT);
        };
        mandatoryPropertiesWithoutValues.forEach(_function_2);
      }
    }
  }
  
  /**
   * Check if node is either used by or dependent on the same node
   */
  @Check
  public void checkDuplicatedOperationNodeDependenciesForUsedByNodes(final OperationNode node) {
    final Consumer<PossiblyImportedOperationNode> _function = (PossiblyImportedOperationNode dependsOnNode) -> {
      final Procedure2<PossiblyImportedOperationNode, Integer> _function_1 = (PossiblyImportedOperationNode usedByNode, Integer index) -> {
        OperationNode _node = usedByNode.getNode();
        OperationNode _node_1 = dependsOnNode.getNode();
        boolean _equals = Objects.equal(_node, _node_1);
        if (_equals) {
          StringConcatenation _builder = new StringConcatenation();
          String _name = node.getName();
          _builder.append(_name);
          _builder.append(" may only depend on or being used by the same ");
          StringConcatenation _builder_1 = new StringConcatenation();
          String _name_1 = usedByNode.getNode().getName();
          _builder_1.append(_name_1);
          _builder_1.append(" node");
          String _plus = (_builder.toString() + _builder_1);
          this.error(_plus, node, 
            OperationPackage.Literals.OPERATION_NODE__USED_BY_NODES, (index).intValue());
        }
      };
      IterableExtensions.<PossiblyImportedOperationNode>forEach(node.getUsedByNodes(), _function_1);
    };
    node.getDependsOnNodes().forEach(_function);
  }
  
  /**
   * Check cyclic depends on relationships between operation nodes
   */
  @Check
  public void checkConflictingDependenciesBetweenDependsOnOperationNodes(final OperationNode node) {
    final Consumer<PossiblyImportedOperationNode> _function = (PossiblyImportedOperationNode dependsOnNode) -> {
      final Function1<PossiblyImportedOperationNode, Boolean> _function_1 = (PossiblyImportedOperationNode n) -> {
        OperationNode _node = n.getNode();
        return Boolean.valueOf(Objects.equal(_node, node));
      };
      final PossiblyImportedOperationNode conflictingNode = IterableExtensions.<PossiblyImportedOperationNode>findFirst(dependsOnNode.getNode().getDependsOnNodes(), _function_1);
      if ((conflictingNode != null)) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Cyclic dependency between ");
        String _name = node.getName();
        _builder.append(_name);
        _builder.append(" and ");
        String _name_1 = dependsOnNode.getNode().getName();
        _builder.append(_name_1);
        _builder.append(".");
        this.error(_builder.toString(), node, OperationPackage.Literals.OPERATION_NODE__DEPENDS_ON_NODES);
      }
    };
    node.getDependsOnNodes().forEach(_function);
  }
  
  /**
   * Check cyclic used by relationships between operation nodes
   */
  @Check
  public void checkConflictingDependenciesBetweenUsedByOperationNodes(final OperationNode node) {
    final Consumer<PossiblyImportedOperationNode> _function = (PossiblyImportedOperationNode usedBynode) -> {
      final Function1<PossiblyImportedOperationNode, Boolean> _function_1 = (PossiblyImportedOperationNode n) -> {
        OperationNode _node = n.getNode();
        return Boolean.valueOf(Objects.equal(_node, node));
      };
      final PossiblyImportedOperationNode conflictingNode = IterableExtensions.<PossiblyImportedOperationNode>findFirst(usedBynode.getNode().getUsedByNodes(), _function_1);
      if ((conflictingNode != null)) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Cyclic dependency between ");
        String _name = node.getName();
        _builder.append(_name);
        _builder.append(" and ");
        String _name_1 = usedBynode.getNode().getName();
        _builder.append(_name_1);
        _builder.append(".");
        this.error(_builder.toString(), node, OperationPackage.Literals.OPERATION_NODE__USED_BY_NODES);
      }
    };
    node.getUsedByNodes().forEach(_function);
  }
}
