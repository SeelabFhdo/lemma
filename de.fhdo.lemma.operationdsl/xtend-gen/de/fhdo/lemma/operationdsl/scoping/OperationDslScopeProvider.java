package de.fhdo.lemma.operationdsl.scoping;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import de.fhdo.lemma.data.PrimitiveValue;
import de.fhdo.lemma.operation.Container;
import de.fhdo.lemma.operation.DeploymentTechnologyReference;
import de.fhdo.lemma.operation.ImportedMicroservice;
import de.fhdo.lemma.operation.ImportedOperationAspect;
import de.fhdo.lemma.operation.InfrastructureNode;
import de.fhdo.lemma.operation.InfrastructureTechnologyReference;
import de.fhdo.lemma.operation.OperationModel;
import de.fhdo.lemma.operation.OperationNode;
import de.fhdo.lemma.operation.OperationPackage;
import de.fhdo.lemma.operation.ProtocolAndDataFormat;
import de.fhdo.lemma.operation.ServiceDeploymentSpecification;
import de.fhdo.lemma.operationdsl.scoping.AbstractOperationDslScopeProvider;
import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.Microservice;
import de.fhdo.lemma.service.ServiceModel;
import de.fhdo.lemma.technology.DataFormat;
import de.fhdo.lemma.technology.DeploymentTechnology;
import de.fhdo.lemma.technology.InfrastructureTechnology;
import de.fhdo.lemma.technology.JoinPointType;
import de.fhdo.lemma.technology.OperationAspect;
import de.fhdo.lemma.technology.OperationEnvironment;
import de.fhdo.lemma.technology.OperationTechnology;
import de.fhdo.lemma.technology.Protocol;
import de.fhdo.lemma.technology.Technology;
import de.fhdo.lemma.technology.TechnologyPackage;
import de.fhdo.lemma.technology.TechnologySpecificProperty;
import de.fhdo.lemma.technology.TechnologySpecificPropertyValueAssignment;
import de.fhdo.lemma.utils.LemmaUtils;
import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;
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
    if (context instanceof OperationModel) {
      _matched=true;
      _switchResult = this.getScope(((OperationModel)context), reference);
    }
    if (!_matched) {
      if (context instanceof Container) {
        _matched=true;
        _switchResult = this.getScope(((Container)context), reference);
      }
    }
    if (!_matched) {
      if (context instanceof DeploymentTechnologyReference) {
        _matched=true;
        _switchResult = this.getScope(((DeploymentTechnologyReference)context), reference);
      }
    }
    if (!_matched) {
      if (context instanceof InfrastructureNode) {
        _matched=true;
        _switchResult = this.getScope(((InfrastructureNode)context), reference);
      }
    }
    if (!_matched) {
      if (context instanceof InfrastructureTechnologyReference) {
        _matched=true;
        _switchResult = this.getScope(((InfrastructureTechnologyReference)context), reference);
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
   * Build scope for operation model
   */
  private IScope getScope(final OperationModel model, final EReference reference) {
    boolean _matched = false;
    if (Objects.equal(reference, OperationPackage.Literals.OPERATION_NODE__TECHNOLOGIES)) {
      _matched=true;
      return this.getScopeForImportsOfType(model, Technology.class);
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
      if (Objects.equal(reference, OperationPackage.Literals.DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT)) {
        _matched=true;
        return this.getScopeForAnnotatedTechnologies(container);
      }
    }
    return this.getScope(((OperationNode) container), reference);
  }
  
  /**
   * Build scope for deployment technology references
   */
  private IScope getScope(final DeploymentTechnologyReference deploymentTechnologyReference, final EReference reference) {
    boolean _matched = false;
    if (Objects.equal(reference, OperationPackage.Literals.DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT)) {
      _matched=true;
      return this.getScopeForAnnotatedTechnologies(deploymentTechnologyReference.getContainer());
    }
    if (!_matched) {
      if (Objects.equal(reference, OperationPackage.Literals.DEPLOYMENT_TECHNOLOGY_REFERENCE__DEPLOYMENT_TECHNOLOGY)) {
        _matched=true;
        return this.getScopeForDeploymentTechnology(deploymentTechnologyReference);
      }
    }
    return null;
  }
  
  /**
   * Build scope for imported operation aspects used in containers and infrastructure nodes
   */
  private IScope getScope(final ImportedOperationAspect importedAspect, final EReference reference) {
    boolean _matched = false;
    if (Objects.equal(reference, OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__TECHNOLOGY)) {
      _matched=true;
      return this.getScopeForAnnotatedTechnologies(EcoreUtil2.<OperationNode>getContainerOfType(importedAspect, OperationNode.class));
    }
    if (!_matched) {
      if (Objects.equal(reference, OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__ASPECT)) {
        _matched=true;
        return this.getScopeForImportedAspect(importedAspect);
      }
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
  private IScope getScopeForImportedAspect(final ImportedOperationAspect importedAspect) {
    Import _technology = importedAspect.getTechnology();
    boolean _tripleEquals = (_technology == null);
    if (_tripleEquals) {
      return IScope.NULLSCOPE;
    }
    final EObject aspectContainer = importedAspect.eContainer();
    JoinPointType _switchResult = null;
    boolean _matched = false;
    if (aspectContainer instanceof Container) {
      _matched=true;
      _switchResult = JoinPointType.CONTAINERS;
    }
    if (!_matched) {
      if (aspectContainer instanceof InfrastructureNode) {
        _matched=true;
        _switchResult = JoinPointType.INFRASTRUCTURE_NODES;
      }
    }
    final JoinPointType joinPoint = _switchResult;
    OperationTechnology _xifexpression = null;
    if ((aspectContainer instanceof Container)) {
      DeploymentTechnology _xifexpression_1 = null;
      Import _technology_1 = importedAspect.getTechnology();
      Import _import = ((Container)aspectContainer).getDeploymentTechnology().getImport();
      boolean _equals = Objects.equal(_technology_1, _import);
      if (_equals) {
        _xifexpression_1 = ((Container)aspectContainer).getDeploymentTechnology().getDeploymentTechnology();
      }
      _xifexpression = _xifexpression_1;
    } else {
      InfrastructureTechnology _xifexpression_2 = null;
      if ((aspectContainer instanceof InfrastructureNode)) {
        InfrastructureTechnology _xifexpression_3 = null;
        Import _technology_2 = importedAspect.getTechnology();
        Import _import_1 = ((InfrastructureNode)aspectContainer).getInfrastructureTechnology().getImport();
        boolean _equals_1 = Objects.equal(_technology_2, _import_1);
        if (_equals_1) {
          _xifexpression_3 = ((InfrastructureNode)aspectContainer).getInfrastructureTechnology().getInfrastructureTechnology();
        }
        _xifexpression_2 = _xifexpression_3;
      }
      _xifexpression = _xifexpression_2;
    }
    final OperationTechnology technology = _xifexpression;
    final Function<Technology, List<OperationAspect>> _function = (Technology it) -> {
      return IterableExtensions.<OperationAspect>toList(it.getOperationAspects());
    };
    final Function<OperationAspect, List<String>> _function_1 = (OperationAspect it) -> {
      return it.getQualifiedNameParts();
    };
    final Predicate<OperationAspect> _function_2 = (OperationAspect it) -> {
      return (it.getJoinPoints().contains(joinPoint) && 
        it.hasMatchingSelector(technology));
    };
    return LemmaUtils.<Import, Technology, OperationAspect>getScopeForPossiblyImportedConcept(
      importedAspect.getTechnology(), 
      null, 
      Technology.class, 
      importedAspect.getTechnology().getImportURI(), _function, _function_1, _function_2);
  }
  
  /**
   * Build scope for aspect properties
   */
  private IScope getScopeForAspectProperty(final EObject container) {
    if (((!(container instanceof TechnologySpecificPropertyValueAssignment)) && 
      (!(container instanceof ImportedOperationAspect)))) {
      return IScope.NULLSCOPE;
    }
    if ((container instanceof TechnologySpecificPropertyValueAssignment)) {
      final ImportedOperationAspect aspect = EcoreUtil2.<ImportedOperationAspect>getContainerOfType(container, ImportedOperationAspect.class);
      return Scopes.scopeFor(aspect.getAspect().getProperties());
    } else {
      if ((container instanceof ImportedOperationAspect)) {
        final HashSet<String> alreadyUsedProperties = CollectionLiterals.<String>newHashSet();
        final Consumer<TechnologySpecificPropertyValueAssignment> _function = (TechnologySpecificPropertyValueAssignment it) -> {
          PrimitiveValue _value = it.getValue();
          boolean _tripleNotEquals = (_value != null);
          if (_tripleNotEquals) {
            alreadyUsedProperties.add(it.getProperty().getName());
          }
        };
        ((ImportedOperationAspect)container).getValues().forEach(_function);
        final Function1<TechnologySpecificProperty, Boolean> _function_1 = (TechnologySpecificProperty it) -> {
          boolean _contains = alreadyUsedProperties.contains(it.getName());
          return Boolean.valueOf((!_contains));
        };
        final Iterable<TechnologySpecificProperty> availableProperties = IterableExtensions.<TechnologySpecificProperty>filter(((ImportedOperationAspect)container).getAspect().getProperties(), _function_1);
        return Scopes.scopeFor(availableProperties);
      }
    }
    return null;
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
      if (Objects.equal(reference, OperationPackage.Literals.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__IMPORT)) {
        _matched=true;
        return this.getScopeForAnnotatedTechnologies(infrastructureNode);
      }
    }
    if (!_matched) {
      if (Objects.equal(reference, OperationPackage.Literals.INFRASTRUCTURE_NODE__USED_BY_NODES)) {
        _matched=true;
        return this.getScopeForOtherNodes(infrastructureNode);
      }
    }
    if (!_matched) {
      if (Objects.equal(reference, OperationPackage.Literals.INFRASTRUCTURE_NODE__DEPENDS_ON_NODES)) {
        _matched=true;
        return this.getScopeForOtherNodes(infrastructureNode);
      }
    }
    return this.getScope(((OperationNode) infrastructureNode), reference);
  }
  
  /**
   * Build scope for infrastructure technology references
   */
  private IScope getScope(final InfrastructureTechnologyReference infrastructureTechnologyReference, final EReference reference) {
    boolean _matched = false;
    if (Objects.equal(reference, OperationPackage.Literals.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__IMPORT)) {
      _matched=true;
      return this.getScopeForAnnotatedTechnologies(infrastructureTechnologyReference.getInfrastructureNode());
    }
    if (!_matched) {
      if (Objects.equal(reference, OperationPackage.Literals.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_TECHNOLOGY)) {
        _matched=true;
        return this.getScopeForInfrastructureTechnology(infrastructureTechnologyReference);
      }
    }
    return null;
  }
  
  /**
   * Build scope for operation nodes
   */
  private IScope getScope(final OperationNode operationNode, final EReference reference) {
    boolean _matched = false;
    if (Objects.equal(reference, OperationPackage.Literals.OPERATION_NODE__TECHNOLOGIES)) {
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
      if (Objects.equal(reference, OperationPackage.Literals.PROTOCOL_AND_DATA_FORMAT__TECHNOLOGY)) {
        _matched=true;
        return this.getScopeForAnnotatedTechnologies(operationNode);
      }
    }
    if (!_matched) {
      if (Objects.equal(reference, OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__TECHNOLOGY)) {
        _matched=true;
        return this.getScopeForAnnotatedTechnologies(operationNode);
      }
    }
    return null;
  }
  
  /**
   * Build scope that comprises annotated technologies of an annotatable concept instance
   */
  private IScope getScopeForAnnotatedTechnologies(final OperationNode operationNode) {
    return Scopes.scopeFor(operationNode.getTechnologies());
  }
  
  /**
   * Build scope that comprises all nodes of the model except a given one
   */
  private IScope getScopeForOtherNodes(final OperationNode operationNode) {
    final OperationModel modelRoot = EcoreUtil2.<OperationModel>getContainerOfType(operationNode, OperationModel.class);
    final Function1<Container, Boolean> _function = (Container it) -> {
      return Boolean.valueOf((!Objects.equal(it, operationNode)));
    };
    Iterable<Container> _filter = IterableExtensions.<Container>filter(modelRoot.getContainers(), _function);
    final Function1<InfrastructureNode, Boolean> _function_1 = (InfrastructureNode it) -> {
      return Boolean.valueOf((!Objects.equal(it, operationNode)));
    };
    Iterable<InfrastructureNode> _filter_1 = IterableExtensions.<InfrastructureNode>filter(modelRoot.getInfrastructureNodes(), _function_1);
    Iterable<OperationNode> _plus = Iterables.<OperationNode>concat(_filter, _filter_1);
    return Scopes.scopeFor(_plus);
  }
  
  /**
   * Get scope for deployment technology
   */
  private IScope getScopeForDeploymentTechnology(final DeploymentTechnologyReference reference) {
    Import _import = reference.getImport();
    boolean _tripleEquals = (_import == null);
    if (_tripleEquals) {
      return IScope.NULLSCOPE;
    }
    final Function<Technology, List<DeploymentTechnology>> _function = (Technology it) -> {
      return IterableExtensions.<DeploymentTechnology>toList(it.getDeploymentTechnologies());
    };
    final Function<DeploymentTechnology, List<String>> _function_1 = (DeploymentTechnology it) -> {
      return it.getQualifiedNameParts();
    };
    return LemmaUtils.<DeploymentTechnologyReference, Technology, DeploymentTechnology>getScopeForPossiblyImportedConcept(reference, 
      null, 
      Technology.class, 
      reference.getImport().getImportURI(), _function, _function_1);
  }
  
  /**
   * Get scope for infrastructure technology
   */
  private IScope getScopeForInfrastructureTechnology(final InfrastructureTechnologyReference reference) {
    Import _import = reference.getImport();
    boolean _tripleEquals = (_import == null);
    if (_tripleEquals) {
      return IScope.NULLSCOPE;
    }
    final Function<Technology, List<InfrastructureTechnology>> _function = (Technology it) -> {
      return IterableExtensions.<InfrastructureTechnology>toList(it.getInfrastructureTechnologies());
    };
    final Function<InfrastructureTechnology, List<String>> _function_1 = (InfrastructureTechnology it) -> {
      return it.getQualifiedNameParts();
    };
    return LemmaUtils.<InfrastructureTechnologyReference, Technology, InfrastructureTechnology>getScopeForPossiblyImportedConcept(reference, 
      null, 
      Technology.class, 
      reference.getImport().getImportURI(), _function, _function_1);
  }
  
  /**
   * Get scope for operation environment
   */
  private IScope getScopeForOperationEnvironment(final OperationNode operationNode) {
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
    return LemmaUtils.<Import, ServiceModel, Microservice>getScopeForPossiblyImportedConcept(import_, 
      null, 
      ServiceModel.class, 
      import_.getImportURI(), _function, _function_1);
  }
  
  /**
   * Build scope for protocols and data formats
   */
  private IScope getScope(final ProtocolAndDataFormat protocolAndDataFormat, final EReference reference) {
    boolean _matched = false;
    if (Objects.equal(reference, OperationPackage.Literals.PROTOCOL_AND_DATA_FORMAT__TECHNOLOGY)) {
      _matched=true;
      return this.getScopeForAnnotatedTechnologies(EcoreUtil2.<OperationNode>getContainerOfType(protocolAndDataFormat, OperationNode.class));
    }
    if (!_matched) {
      if (Objects.equal(reference, OperationPackage.Literals.PROTOCOL_AND_DATA_FORMAT__PROTOCOL)) {
        _matched=true;
        return this.getScopeForEndpointProtocols(protocolAndDataFormat);
      }
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
  private IScope getScopeForEndpointProtocols(final ProtocolAndDataFormat protocol) {
    Import _technology = protocol.getTechnology();
    boolean _tripleEquals = (_technology == null);
    if (_tripleEquals) {
      return IScope.NULLSCOPE;
    }
    final Function<Technology, List<Protocol>> _function = (Technology it) -> {
      return IterableExtensions.<Protocol>toList(it.getProtocols());
    };
    final Function<Protocol, List<String>> _function_1 = (Protocol it) -> {
      return it.getQualifiedNameParts();
    };
    return LemmaUtils.<Import, Technology, Protocol>getScopeForPossiblyImportedConcept(
      protocol.getTechnology(), 
      null, 
      Technology.class, 
      protocol.getTechnology().getImportURI(), _function, _function_1);
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
      if (Objects.equal(reference, OperationPackage.Literals.PROTOCOL_AND_DATA_FORMAT__TECHNOLOGY)) {
        _matched=true;
        return this.getScopeForAnnotatedTechnologies(EcoreUtil2.<OperationNode>getContainerOfType(specification, OperationNode.class));
      }
    }
    if (!_matched) {
      if (Objects.equal(reference, TechnologyPackage.Literals.TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_ASSIGNMENT__PROPERTY)) {
        _matched=true;
        return this.getScopeForServiceProperties(specification);
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
      return Boolean.valueOf(((it.getImport().getName() != null) && Objects.equal(it.getImport().getName(), specification.getImport().getName())));
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
      _switchResult = this.getScopeForAspectProperty(propertyValue);
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
    if ((((container != null) && 
      (container.getDeploymentTechnology() != null)) && 
      (container.getDeploymentTechnology().getDeploymentTechnology() != null))) {
      return Scopes.scopeFor(
        container.getDeploymentTechnology().getDeploymentTechnology().getServiceProperties());
    } else {
      if ((((infrastructureNode != null) && 
        (infrastructureNode.getInfrastructureTechnology() != null)) && 
        (infrastructureNode.getInfrastructureTechnology().getInfrastructureTechnology() != null))) {
        return Scopes.scopeFor(
          infrastructureNode.getInfrastructureTechnology().getInfrastructureTechnology().getServiceProperties());
      } else {
        return IScope.NULLSCOPE;
      }
    }
  }
  
  /**
   * Convenience method to create a scope for imports of certain types
   */
  private IScope getScopeForImportsOfType(final EObject context, final Class<? extends EObject>... types) {
    final EList<Import> allImports = EcoreUtil2.<OperationModel>getContainerOfType(context, OperationModel.class).getImports();
    final Function<Import, String> _function = (Import it) -> {
      return it.getImportURI();
    };
    final Iterable<Import> validImports = LemmaUtils.<Import>getImportsOfModelTypes(allImports, _function, types);
    return Scopes.scopeFor(validImports);
  }
}
