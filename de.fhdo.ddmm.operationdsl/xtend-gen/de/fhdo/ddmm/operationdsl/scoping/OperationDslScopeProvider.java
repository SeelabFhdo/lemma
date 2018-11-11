package de.fhdo.ddmm.operationdsl.scoping;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import de.fhdo.ddmm.operation.BasicEndpoint;
import de.fhdo.ddmm.operation.Container;
import de.fhdo.ddmm.operation.ImportedMicroservice;
import de.fhdo.ddmm.operation.ImportedOperationAspect;
import de.fhdo.ddmm.operation.InfrastructureNode;
import de.fhdo.ddmm.operation.OperationModel;
import de.fhdo.ddmm.operation.OperationNode;
import de.fhdo.ddmm.operation.OperationPackage;
import de.fhdo.ddmm.operation.ProtocolAndDataFormat;
import de.fhdo.ddmm.operation.ServiceDeploymentSpecification;
import de.fhdo.ddmm.operationdsl.scoping.AbstractOperationDslScopeProvider;
import de.fhdo.ddmm.service.Import;
import de.fhdo.ddmm.service.Microservice;
import de.fhdo.ddmm.service.ServiceModel;
import de.fhdo.ddmm.technology.DataFormat;
import de.fhdo.ddmm.technology.DeploymentTechnology;
import de.fhdo.ddmm.technology.InfrastructureTechnology;
import de.fhdo.ddmm.technology.JoinPointType;
import de.fhdo.ddmm.technology.OperationAspect;
import de.fhdo.ddmm.technology.OperationEnvironment;
import de.fhdo.ddmm.technology.OperationTechnology;
import de.fhdo.ddmm.technology.Protocol;
import de.fhdo.ddmm.technology.Technology;
import de.fhdo.ddmm.technology.TechnologyPackage;
import de.fhdo.ddmm.technology.TechnologySpecificProperty;
import de.fhdo.ddmm.technology.TechnologySpecificPropertyValueAssignment;
import de.fhdo.ddmm.utils.DdmmUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * This class implements a custom scope provider for the Operation DSL.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class OperationDslScopeProvider extends AbstractOperationDslScopeProvider {
  /**
   * Build scope for a given context and a given reference
   */
  @Override
  public IScope getScope(final EObject context, final EReference reference) {
    IScope _switchResult = null;
    boolean _matched = false;
    if (context instanceof Container) {
      _matched=true;
      _switchResult = this.getScope(((Container)context), reference);
    }
    if (!_matched) {
      if (context instanceof InfrastructureNode) {
        _matched=true;
        _switchResult = this.getScope(((InfrastructureNode)context), reference);
      }
    }
    if (!_matched) {
      if (context instanceof OperationNode) {
        _matched=true;
        _switchResult = this.getScope(((OperationNode)context), reference);
      }
    }
    if (!_matched) {
      if (context instanceof ImportedMicroservice) {
        _matched=true;
        _switchResult = this.getScope(((ImportedMicroservice)context), reference);
      }
    }
    if (!_matched) {
      if (context instanceof TechnologySpecificPropertyValueAssignment) {
        _matched=true;
        _switchResult = this.getScope(((TechnologySpecificPropertyValueAssignment)context), reference);
      }
    }
    if (!_matched) {
      if (context instanceof BasicEndpoint) {
        _matched=true;
        _switchResult = this.getScope(((BasicEndpoint)context), reference);
      }
    }
    if (!_matched) {
      if (context instanceof ProtocolAndDataFormat) {
        _matched=true;
        _switchResult = this.getScope(((ProtocolAndDataFormat)context), reference);
      }
    }
    if (!_matched) {
      if (context instanceof ServiceDeploymentSpecification) {
        _matched=true;
        _switchResult = this.getScope(((ServiceDeploymentSpecification)context), reference);
      }
    }
    if (!_matched) {
      if (context instanceof ImportedOperationAspect) {
        _matched=true;
        _switchResult = this.getScope(((ImportedOperationAspect)context), reference);
      }
    }
    final IScope scope = _switchResult;
    if ((scope != null)) {
      return scope;
    } else {
      if ((scope == null)) {
        return super.getScope(context, reference);
      }
    }
    return null;
  }
  
  /**
   * Build scope for Container-specific features
   */
  private IScope getScope(final Container container, final EReference reference) {
    boolean _matched = false;
    if (Objects.equal(reference, OperationPackage.Literals.OPERATION_NODE__OPERATION_ENVIRONMENT)) {
      _matched=true;
      return this.getScopeForOperationEnvironment(container);
    }
    if (!_matched) {
      if (Objects.equal(reference, OperationPackage.Literals.CONTAINER__DEPLOYMENT_TECHNOLOGY)) {
        _matched=true;
        return this.getScopeForDeploymentTechnology(container);
      }
    }
    if (!_matched) {
      if (Objects.equal(reference, OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__IMPORTED_ASPECT)) {
        _matched=true;
        return this.getScopeForImportedAspect(container);
      }
    }
    return this.getScope(((OperationNode) container), reference);
  }
  
  /**
   * Build scope for imported operation aspects used in containers and infrastructure nodes
   */
  private IScope getScope(final ImportedOperationAspect importedAspect, final EReference reference) {
    boolean _matched = false;
    if (Objects.equal(reference, OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__IMPORTED_ASPECT)) {
      _matched=true;
      EObject _eContainer = importedAspect.eContainer();
      return this.getScopeForImportedAspect(((OperationNode) _eContainer));
    }
    if (!_matched) {
      if (Objects.equal(reference, TechnologyPackage.Literals.TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_ASSIGNMENT__PROPERTY)) {
        _matched=true;
        return this.getScopeForAspectProperty(importedAspect);
      }
    }
    return null;
  }
  
  /**
   * Build scope for imported operation aspects
   */
  private IScope getScopeForImportedAspect(final OperationNode operationNode) {
    Import _technology = operationNode.getTechnology();
    boolean _tripleEquals = (_technology == null);
    if (_tripleEquals) {
      return IScope.NULLSCOPE;
    }
    JoinPointType _switchResult = null;
    boolean _matched = false;
    if (operationNode instanceof Container) {
      _matched=true;
      _switchResult = JoinPointType.CONTAINERS;
    }
    if (!_matched) {
      if (operationNode instanceof InfrastructureNode) {
        _matched=true;
        _switchResult = JoinPointType.INFRASTRUCTURE_NODES;
      }
    }
    final JoinPointType joinPoint = _switchResult;
    final Function<Technology, List<OperationAspect>> _function = (Technology it) -> {
      return IterableExtensions.<OperationAspect>toList(it.getOperationAspects());
    };
    final Function<OperationAspect, List<String>> _function_1 = (OperationAspect it) -> {
      String _name = it.getName();
      return Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_name));
    };
    final Predicate<OperationAspect> _function_2 = (OperationAspect it) -> {
      return it.getJoinPoints().contains(joinPoint);
    };
    return DdmmUtils.<Import, Technology, OperationAspect>getScopeForPossiblyImportedConcept(
      operationNode.getTechnology(), 
      null, 
      Technology.class, 
      operationNode.getTechnology().getImportURI(), _function, _function_1, _function_2);
  }
  
  /**
   * Build scope for aspect properties
   */
  private IScope getScopeForAspectProperty(final ImportedOperationAspect importedAspect) {
    return Scopes.scopeFor(importedAspect.getImportedAspect().getProperties());
  }
  
  /**
   * Build scope for InfrastructureNode-specific features
   */
  private IScope getScope(final InfrastructureNode infrastructureNode, final EReference reference) {
    boolean _matched = false;
    if (Objects.equal(reference, OperationPackage.Literals.OPERATION_NODE__OPERATION_ENVIRONMENT)) {
      _matched=true;
      return this.getScopeForOperationEnvironment(infrastructureNode);
    }
    if (!_matched) {
      if (Objects.equal(reference, OperationPackage.Literals.INFRASTRUCTURE_NODE__INFRASTRUCTURE_TECHNOLOGY)) {
        _matched=true;
        return this.getScopeForInfrastructureTechnology(infrastructureNode);
      }
    }
    return this.getScope(((OperationNode) infrastructureNode), reference);
  }
  
  /**
   * Build scope for operation nodes
   */
  private IScope getScope(final OperationNode operationNode, final EReference reference) {
    boolean _matched = false;
    if (Objects.equal(reference, OperationPackage.Literals.OPERATION_NODE__TECHNOLOGY)) {
      _matched=true;
      return this.getScopeForImportsOfType(operationNode, Technology.class);
    }
    if (!_matched) {
      if (Objects.equal(reference, OperationPackage.Literals.IMPORTED_MICROSERVICE__IMPORT)) {
        _matched=true;
        return this.getScopeForImportsOfType(operationNode, ServiceModel.class);
      }
    }
    if (!_matched) {
      if (Objects.equal(reference, TechnologyPackage.Literals.TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_ASSIGNMENT__PROPERTY)) {
        _matched=true;
        return this.getScopeForServiceProperties(operationNode);
      }
    }
    if (!_matched) {
      if (Objects.equal(reference, OperationPackage.Literals.SERVICE_DEPLOYMENT_SPECIFICATION__IMPORT)) {
        _matched=true;
        return this.getScopeForServiceDeploymentImports(operationNode);
      }
    }
    if (!_matched) {
      if (Objects.equal(reference, OperationPackage.Literals.PROTOCOL_AND_DATA_FORMAT__PROTOCOL)) {
        _matched=true;
        return this.getScopeForEndpointProtocols(operationNode);
      }
    }
    return null;
  }
  
  /**
   * Get scope for deployment technology
   */
  private IScope getScopeForDeploymentTechnology(final Container container) {
    Import _technology = container.getTechnology();
    boolean _tripleEquals = (_technology == null);
    if (_tripleEquals) {
      return IScope.NULLSCOPE;
    }
    final Function<Technology, List<DeploymentTechnology>> _function = (Technology it) -> {
      return IterableExtensions.<DeploymentTechnology>toList(it.getDeploymentTechnologies());
    };
    final Function<DeploymentTechnology, List<String>> _function_1 = (DeploymentTechnology it) -> {
      String _name = it.getName();
      return Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_name));
    };
    return DdmmUtils.<Container, Technology, DeploymentTechnology>getScopeForPossiblyImportedConcept(container, 
      null, 
      Technology.class, 
      container.getTechnology().getImportURI(), _function, _function_1);
  }
  
  /**
   * Get scope for infrastructure technology
   */
  private IScope getScopeForInfrastructureTechnology(final InfrastructureNode infrastructureNode) {
    Import _technology = infrastructureNode.getTechnology();
    boolean _tripleEquals = (_technology == null);
    if (_tripleEquals) {
      return IScope.NULLSCOPE;
    }
    final Function<Technology, List<InfrastructureTechnology>> _function = (Technology it) -> {
      return IterableExtensions.<InfrastructureTechnology>toList(it.getInfrastructureTechnologies());
    };
    final Function<InfrastructureTechnology, List<String>> _function_1 = (InfrastructureTechnology it) -> {
      String _name = it.getName();
      return Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_name));
    };
    return DdmmUtils.<InfrastructureNode, Technology, InfrastructureTechnology>getScopeForPossiblyImportedConcept(infrastructureNode, 
      null, 
      Technology.class, 
      infrastructureNode.getTechnology().getImportURI(), _function, _function_1);
  }
  
  /**
   * Get scope for operation environment
   */
  private IScope getScopeForOperationEnvironment(final OperationNode operationNode) {
    OperationTechnology _xifexpression = null;
    if ((operationNode instanceof Container)) {
      _xifexpression = ((Container)operationNode).getDeploymentTechnology();
    } else {
      InfrastructureTechnology _xifexpression_1 = null;
      if ((operationNode instanceof InfrastructureNode)) {
        _xifexpression_1 = ((InfrastructureNode)operationNode).getInfrastructureTechnology();
      }
      _xifexpression = _xifexpression_1;
    }
    final OperationTechnology operationTechnology = _xifexpression;
    if ((operationTechnology == null)) {
      return IScope.NULLSCOPE;
    }
    final Function<OperationEnvironment, QualifiedName> _function = (OperationEnvironment it) -> {
      return QualifiedName.create(it.getEnvironmentName());
    };
    return Scopes.<OperationEnvironment>scopeFor(operationTechnology.getOperationEnvironments(), _function, IScope.NULLSCOPE);
  }
  
  /**
   * Build scope for imported microservices
   */
  private IScope getScope(final ImportedMicroservice microservice, final EReference reference) {
    boolean _matched = false;
    if (Objects.equal(reference, OperationPackage.Literals.IMPORTED_MICROSERVICE__IMPORT)) {
      _matched=true;
      return this.getScopeForImportsOfType(microservice, ServiceModel.class);
    }
    if (!_matched) {
      if (Objects.equal(reference, OperationPackage.Literals.IMPORTED_MICROSERVICE__MICROSERVICE)) {
        _matched=true;
        return this.getScopeForImportedMicroservices(microservice.getImport());
      }
    }
    return null;
  }
  
  /**
   * Build scope for the actual microservices if the import was already specified
   */
  private IScope getScopeForImportedMicroservices(final Import import_) {
    if ((import_ == null)) {
      return IScope.NULLSCOPE;
    }
    final Function<ServiceModel, List<Microservice>> _function = (ServiceModel it) -> {
      return IterableExtensions.<Microservice>toList(it.getMicroservices());
    };
    final Function<Microservice, List<String>> _function_1 = (Microservice it) -> {
      return it.getQualifiedNameParts();
    };
    return DdmmUtils.<Import, ServiceModel, Microservice>getScopeForPossiblyImportedConcept(import_, 
      null, 
      ServiceModel.class, 
      import_.getImportURI(), _function, _function_1);
  }
  
  /**
   * Build scope for basic endpoints
   */
  private IScope getScope(final BasicEndpoint basicEndpoint, final EReference reference) {
    boolean _matched = false;
    if (Objects.equal(reference, OperationPackage.Literals.PROTOCOL_AND_DATA_FORMAT__PROTOCOL)) {
      _matched=true;
      return this.getScopeForEndpointProtocols(basicEndpoint);
    }
    return null;
  }
  
  /**
   * Build scope for protocols and data formats
   */
  private IScope getScope(final ProtocolAndDataFormat protocolAndDataFormat, final EReference reference) {
    boolean _matched = false;
    if (Objects.equal(reference, OperationPackage.Literals.PROTOCOL_AND_DATA_FORMAT__PROTOCOL)) {
      _matched=true;
      return this.getScopeForEndpointProtocols(protocolAndDataFormat);
    }
    if (!_matched) {
      if (Objects.equal(reference, OperationPackage.Literals.PROTOCOL_AND_DATA_FORMAT__DATA_FORMAT)) {
        _matched=true;
        return this.getScopeForDataFormats(protocolAndDataFormat);
      }
    }
    return null;
  }
  
  /**
   * Build scope for endpoint protocols
   */
  private IScope getScopeForEndpointProtocols(final EObject context) {
    OperationNode operationNode = null;
    if ((context instanceof OperationNode)) {
      operationNode = ((OperationNode)context);
    } else {
      operationNode = EcoreUtil2.<OperationNode>getContainerOfType(context, OperationNode.class);
    }
    if (((operationNode == null) || (operationNode.getTechnology() == null))) {
      return IScope.NULLSCOPE;
    }
    final Function<Technology, List<Protocol>> _function = (Technology it) -> {
      return IterableExtensions.<Protocol>toList(it.getProtocols());
    };
    final Function<Protocol, List<String>> _function_1 = (Protocol it) -> {
      String _name = it.getName();
      return Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_name));
    };
    return DdmmUtils.<Import, Technology, Protocol>getScopeForPossiblyImportedConcept(
      operationNode.getTechnology(), 
      null, 
      Technology.class, 
      operationNode.getTechnology().getImportURI(), _function, _function_1);
  }
  
  /**
   * Build scope for endpoint data formats
   */
  private IScope getScopeForDataFormats(final ProtocolAndDataFormat protocolAndDataFormat) {
    Protocol _protocol = protocolAndDataFormat.getProtocol();
    boolean _tripleEquals = (_protocol == null);
    if (_tripleEquals) {
      return IScope.NULLSCOPE;
    }
    final String protocolName = protocolAndDataFormat.getProtocol().getName();
    if ((protocolName == null)) {
      return IScope.NULLSCOPE;
    }
    final Function1<Protocol, Boolean> _function = (Protocol it) -> {
      String _name = it.getName();
      return Boolean.valueOf(Objects.equal(_name, protocolName));
    };
    final EList<DataFormat> scopeElements = IterableExtensions.<Protocol>findFirst(protocolAndDataFormat.getProtocol().getTechnology().getProtocols(), _function).getDataFormats();
    final Function<DataFormat, QualifiedName> _function_1 = (DataFormat it) -> {
      return QualifiedName.create(it.getFormatName());
    };
    return Scopes.<DataFormat>scopeFor(scopeElements, _function_1, 
      IScope.NULLSCOPE);
  }
  
  /**
   * Build scope for service deployment specifications
   */
  private IScope getScope(final ServiceDeploymentSpecification specification, final EReference reference) {
    boolean _matched = false;
    if (Objects.equal(reference, OperationPackage.Literals.SERVICE_DEPLOYMENT_SPECIFICATION__IMPORT)) {
      _matched=true;
      return this.getScopeForServiceDeploymentImports(specification.getOperationNode());
    }
    if (!_matched) {
      if (Objects.equal(reference, OperationPackage.Literals.SERVICE_DEPLOYMENT_SPECIFICATION__SERVICE)) {
        _matched=true;
        return this.getScopeForServiceDeploymentServices(specification);
      }
    }
    if (!_matched) {
      if (Objects.equal(reference, TechnologyPackage.Literals.TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_ASSIGNMENT__PROPERTY)) {
        _matched=true;
        return this.getScopeForServiceProperties(specification);
      }
    }
    if (!_matched) {
      if (Objects.equal(reference, OperationPackage.Literals.PROTOCOL_AND_DATA_FORMAT__PROTOCOL)) {
        _matched=true;
        return this.getScopeForEndpointProtocols(specification);
      }
    }
    return null;
  }
  
  /**
   * Build scope for imports within service deployment specifications
   */
  private IScope getScopeForServiceDeploymentImports(final OperationNode operationNode) {
    final HashSet<Import> deployedServicesImports = CollectionLiterals.<Import>newHashSet();
    final Function1<ImportedMicroservice, Import> _function = (ImportedMicroservice it) -> {
      return it.getImport();
    };
    deployedServicesImports.addAll(ListExtensions.<ImportedMicroservice, Import>map(operationNode.getDeployedServices(), _function));
    return Scopes.scopeFor(deployedServicesImports);
  }
  
  /**
   * Build scope for services within service deployment specifications
   */
  private IScope getScopeForServiceDeploymentServices(final ServiceDeploymentSpecification specification) {
    final Function1<ImportedMicroservice, Boolean> _function = (ImportedMicroservice it) -> {
      String _name = it.getImport().getName();
      String _name_1 = specification.getImport().getName();
      return Boolean.valueOf(Objects.equal(_name, _name_1));
    };
    final Function<ImportedMicroservice, QualifiedName> _function_1 = (ImportedMicroservice it) -> {
      return QualifiedName.create(it.getMicroservice().getQualifiedNameParts());
    };
    return Scopes.<ImportedMicroservice>scopeFor(
      IterableExtensions.<ImportedMicroservice>filter(specification.getOperationNode().getDeployedServices(), _function), _function_1, IScope.NULLSCOPE);
  }
  
  /**
   * Build scope for property values
   */
  private IScope getScope(final TechnologySpecificPropertyValueAssignment propertyValue, final EReference reference) {
    if ((reference != 
      TechnologyPackage.Literals.TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_ASSIGNMENT__PROPERTY)) {
      return IScope.NULLSCOPE;
    }
    IScope _switchResult = null;
    EObject _eContainer = propertyValue.eContainer();
    boolean _matched = false;
    if (_eContainer instanceof ImportedOperationAspect) {
      _matched=true;
      EObject _eContainer_1 = propertyValue.eContainer();
      _switchResult = this.getScopeForAspectProperty(((ImportedOperationAspect) _eContainer_1));
    }
    if (!_matched) {
      _switchResult = this.getScopeForServiceProperties(propertyValue);
    }
    return _switchResult;
  }
  
  /**
   * Build scope for service properties
   */
  private IScope getScopeForServiceProperties(final EObject context) {
    Container _xifexpression = null;
    if ((context instanceof Container)) {
      _xifexpression = ((Container) context);
    } else {
      _xifexpression = EcoreUtil2.<Container>getContainerOfType(context, Container.class);
    }
    Container container = _xifexpression;
    InfrastructureNode infrastructureNode = null;
    if ((container == null)) {
      InfrastructureNode _xifexpression_1 = null;
      if ((context instanceof InfrastructureNode)) {
        _xifexpression_1 = ((InfrastructureNode) context);
      } else {
        _xifexpression_1 = EcoreUtil2.<InfrastructureNode>getContainerOfType(context, InfrastructureNode.class);
      }
      infrastructureNode = _xifexpression_1;
    }
    if (((container == null) && (infrastructureNode == null))) {
      return IScope.NULLSCOPE;
    }
    EList<TechnologySpecificProperty> _xifexpression_2 = null;
    if ((container != null)) {
      _xifexpression_2 = container.getDeploymentTechnology().getServiceProperties();
    } else {
      _xifexpression_2 = infrastructureNode.getInfrastructureTechnology().getServiceProperties();
    }
    final EList<TechnologySpecificProperty> serviceProperties = _xifexpression_2;
    return Scopes.scopeFor(serviceProperties);
  }
  
  /**
   * Convenience method to create a scope for imports of certain types
   */
  private IScope getScopeForImportsOfType(final EObject context, final Class<? extends EObject>... types) {
    final EList<Import> allImports = EcoreUtil2.<OperationModel>getContainerOfType(context, OperationModel.class).getImports();
    final Function<Import, String> _function = (Import it) -> {
      return it.getImportURI();
    };
    final Iterable<Import> validImports = DdmmUtils.<Import>getImportsOfModelTypes(allImports, _function, types);
    return Scopes.scopeFor(validImports);
  }
}
