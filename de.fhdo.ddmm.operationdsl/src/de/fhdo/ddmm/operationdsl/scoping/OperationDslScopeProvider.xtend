package de.fhdo.ddmm.operationdsl.scoping

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import de.fhdo.ddmm.operation.OperationModel
import de.fhdo.ddmm.operation.OperationPackage
import de.fhdo.ddmm.operation.Container
import de.fhdo.ddmm.technology.Technology
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.scoping.Scopes
import de.fhdo.ddmm.utils.DdmmUtils
import org.eclipse.xtext.scoping.IScope
import de.fhdo.ddmm.service.Import
import org.eclipse.xtext.naming.QualifiedName
import de.fhdo.ddmm.operation.ImportedMicroservice
import de.fhdo.ddmm.service.ServiceModel
import de.fhdo.ddmm.operation.ServiceDeploymentSpecification
import de.fhdo.ddmm.operation.OperationNode
import de.fhdo.ddmm.operation.InfrastructureNode
import de.fhdo.ddmm.operation.ProtocolAndDataFormat
import de.fhdo.ddmm.technology.TechnologySpecificPropertyValueAssignment
import de.fhdo.ddmm.technology.TechnologyPackage
import de.fhdo.ddmm.technology.JoinPointType
import de.fhdo.ddmm.operation.ImportedOperationAspect
import de.fhdo.ddmm.operation.DeploymentTechnologyReference
import de.fhdo.ddmm.operation.InfrastructureTechnologyReference

/**
 * This class implements a custom scope provider for the Operation DSL.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class OperationDslScopeProvider extends AbstractOperationDslScopeProvider {
    /**
     * Build scope for a given context and a given reference
     */
    override getScope(EObject context, EReference reference) {
        val scope = switch (context) {
            /* Operation model */
            OperationModel: context.getScope(reference)

            /* Containers */
            Container: context.getScope(reference)

            /* Deployment technology references */
            DeploymentTechnologyReference: context.getScope(reference)

            /* Infrastructure nodes */
            InfrastructureNode: context.getScope(reference)

            /* Infrastructure technology references */
            InfrastructureTechnologyReference: context.getScope(reference)

            /* Imported microservice */
            ImportedMicroservice: context.getScope(reference)

            /*
             * Scope for service property values. The scope provider will delegate the scope
             * resolution with TechnologySpecificPropertyValueAssignment as the context, if its
             * property feature was set. Otherwise, the context will be an instance of OperationNode
             * (see below).
             */
            TechnologySpecificPropertyValueAssignment: context.getScope(reference)

            /* Scope for protocol and data format */
            ProtocolAndDataFormat: context.getScope(reference)

            /* Service deployment specifications */
            ServiceDeploymentSpecification: context.getScope(reference)

            /* Imported operation aspects */
            ImportedOperationAspect: context.getScope(reference)
        }

        if (scope !== null)
            return scope
        // Try default scope resolution, if no scope could be determined
        else if (scope === null)
            return super.getScope(context, reference)
    }

    /**
     * Build scope for operation model
     */
    private def getScope(OperationModel model, EReference reference) {
        switch (reference) {
            /*
             * Technologies. This is necessary because in the grammar file the technology
             * annotation comes before the initialization of the operation nodes' "name" feature.
             */
            case OperationPackage::Literals.OPERATION_NODE__TECHNOLOGIES:
                return model.getScopeForImportsOfType(Technology)
        }

        return null
    }

    /**
     * Build scope for Container-specific features
     */
    private def getScope(Container container, EReference reference) {
        switch (reference) {
            /* Operation environments */
            case OperationPackage::Literals.OPERATION_NODE__OPERATION_ENVIRONMENT:
                return container.getScopeForOperationEnvironment()

            /* Deployment technology imports */
            case OperationPackage::Literals.DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT:
                return container.getScopeForAnnotatedTechnologies()
        }

        // If the feature is not Container-specific, delegate scope resolution to superclass
        // OperationNode
        return (container as OperationNode).getScope(reference)
    }

    /**
     * Build scope for deployment technology references
     */
    private def getScope(DeploymentTechnologyReference deploymentTechnologyReference,
        EReference reference) {
        switch (reference) {
            /* Imports */
            case OperationPackage::Literals.DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT:
                return deploymentTechnologyReference.container.getScopeForAnnotatedTechnologies()

            /* Deployment technologies */
            case OperationPackage::Literals.DEPLOYMENT_TECHNOLOGY_REFERENCE__DEPLOYMENT_TECHNOLOGY:
                return deploymentTechnologyReference.getScopeForDeploymentTechnology()
        }

        return null
    }

    /**
     * Build scope for imported operation aspects used in containers and infrastructure nodes
     */
    private def getScope(ImportedOperationAspect importedAspect, EReference reference) {
        switch (reference) {
            /* Imported aspects */
            case OperationPackage.Literals.IMPORTED_OPERATION_ASPECT__ASPECT:
                return importedAspect.getScopeForImportedAspect()

            /* Properties */
            case TechnologyPackage.Literals.TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_ASSIGNMENT__PROPERTY:
                return importedAspect.getScopeForAspectProperty()
        }

        return null
    }

    /**
     * Build scope for imported operation aspects
     */
    private def getScopeForImportedAspect(ImportedOperationAspect importedAspect) {
        if (importedAspect.technology === null)
            return IScope.NULLSCOPE

        val joinPoint = switch(importedAspect.eContainer) {
            Container: JoinPointType.CONTAINERS
            InfrastructureNode: JoinPointType.INFRASTRUCTURE_NODES
        }

        return DdmmUtils.getScopeForPossiblyImportedConcept(
            importedAspect.technology,
            null,
            Technology,
            importedAspect.technology.importURI,
            [operationAspects.toList],
            [qualifiedNameParts],
            [joinPoints.contains(joinPoint)]
        )
    }

    /**
     * Build scope for aspect properties
     */
    private def getScopeForAspectProperty(EObject container) {
        if (!(container instanceof TechnologySpecificPropertyValueAssignment) &&
            !(container instanceof ImportedOperationAspect))
            return IScope.NULLSCOPE

        // If we're inside an assignment, we need to return all available properties. Otherwise a
        // cyclic link resolution exception will occur. However, this also gives rise to possible
        // duplicate specification of properties for several value assignments. These duplicates get
        // checked in addition by the validator.
        if (container instanceof TechnologySpecificPropertyValueAssignment) {
            val aspect = EcoreUtil2.getContainerOfType(container, ImportedOperationAspect)
            return Scopes::scopeFor(aspect.aspect.properties)

        // If we're inside the aspect itself, i.e., when the modeler _just_ begins to express a new
        // value assignment for a property, we only provide those properties that haven't received
        // values yet
        } else if (container instanceof ImportedOperationAspect) {
            val alreadyUsedProperties = <String> newHashSet
            container.values.forEach[
                if (value !== null)
                    alreadyUsedProperties.add(property.name)
            ]

            val availableProperties = container.aspect.properties
                .filter[!alreadyUsedProperties.contains(name)]
            return Scopes::scopeFor(availableProperties)
        }
    }

    /**
     * Build scope for InfrastructureNode-specific features
     */
    private def getScope(InfrastructureNode infrastructureNode, EReference reference) {
        switch (reference) {
            /* Operation environments */
            case OperationPackage::Literals.OPERATION_NODE__OPERATION_ENVIRONMENT:
                return infrastructureNode.getScopeForOperationEnvironment()

            /* Infrastructure technology imports */
            case OperationPackage::Literals.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__IMPORT:
                return infrastructureNode.getScopeForAnnotatedTechnologies()

            /* Other nodes using this node */
            case OperationPackage::Literals.INFRASTRUCTURE_NODE__USED_BY_NODES:
                return infrastructureNode.getScopeForUsedByNodes()
        }

        // If the feature is not InfrastructureNode-specific, delegate scope resolution to
        // superclass OperationNode
        return (infrastructureNode as OperationNode).getScope(reference)
    }

    /**
     * Build scope for infrastructure technology references
     */
    private def getScope(InfrastructureTechnologyReference infrastructureTechnologyReference,
        EReference reference) {
        switch (reference) {
            /* Imports */
            case OperationPackage::Literals.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__IMPORT:
                return infrastructureTechnologyReference.infrastructureNode
                    .getScopeForAnnotatedTechnologies()

            /* Infrastructure technologies */
            case OperationPackage::Literals
                .INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_TECHNOLOGY:
                return infrastructureTechnologyReference.getScopeForInfrastructureTechnology()
        }

        return null
    }

    /**
     * Build scope for operation nodes
     */
    private def getScope(OperationNode operationNode, EReference reference) {
        switch (reference) {
            /* Annotated technologies */
            case OperationPackage::Literals.OPERATION_NODE__TECHNOLOGIES:
                return operationNode.getScopeForImportsOfType(Technology)

            /* Import of ImportedMicroservices */
            case OperationPackage::Literals.IMPORTED_MICROSERVICE__IMPORT:
                return operationNode.getScopeForImportsOfType(ServiceModel)

            /* Service properties */
            case TechnologyPackage::Literals
                .TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_ASSIGNMENT__PROPERTY:
                return operationNode.getScopeForServiceProperties()

            /* Import of ServiceDeploymentSpecifications */
            case OperationPackage::Literals.SERVICE_DEPLOYMENT_SPECIFICATION__IMPORT:
                return operationNode.getScopeForServiceDeploymentImports()

            /* Protocols */
            case OperationPackage::Literals.PROTOCOL_AND_DATA_FORMAT__TECHNOLOGY:
                return operationNode.getScopeForAnnotatedTechnologies()

            /* Aspect technologies */
            case OperationPackage::Literals.IMPORTED_OPERATION_ASPECT__TECHNOLOGY:
                return operationNode.getScopeForAnnotatedTechnologies()
        }

        return null
    }

    /**
     * Build scope that comprises annotated technologies of an annotatable concept instance
     */
    private def getScopeForAnnotatedTechnologies(OperationNode operationNode) {
        return Scopes::scopeFor(operationNode.technologies)
    }

    /**
     * Build scope that comprises nodes that can use other nodes
     */
    private def getScopeForUsedByNodes(OperationNode operationNode) {
        // Currently we only allow infrastructure nodes to use other nodes
        return Scopes::scopeFor(EcoreUtil2.getSiblingsOfType(operationNode, InfrastructureNode))
    }

    /**
     * Get scope for deployment technology
     */
    private def getScopeForDeploymentTechnology(DeploymentTechnologyReference reference) {
        if (reference.import === null)
            return IScope.NULLSCOPE

        return DdmmUtils.getScopeForPossiblyImportedConcept(
            reference,
            null,
            Technology,
            reference.import.importURI,
            [deploymentTechnologies.toList],
            [qualifiedNameParts]
        )
    }

    /**
     * Get scope for infrastructure technology
     */
    private def getScopeForInfrastructureTechnology(InfrastructureTechnologyReference reference) {
        if (reference.import === null)
            return IScope.NULLSCOPE

        return DdmmUtils.getScopeForPossiblyImportedConcept(
            reference,
            null,
            Technology,
            reference.import.importURI,
            [infrastructureTechnologies.toList],
            [qualifiedNameParts]
        )
    }

    /**
     * Get scope for operation environment
     */
    private def getScopeForOperationEnvironment(OperationNode operationNode) {
        val operationTechnology =
            if (operationNode instanceof Container)
                operationNode.deploymentTechnology.deploymentTechnology
            else if (operationNode instanceof InfrastructureNode)
                operationNode.infrastructureTechnology.infrastructureTechnology

        if (operationTechnology === null)
            return IScope.NULLSCOPE

        return Scopes::scopeFor(operationTechnology.operationEnvironments,
            [QualifiedName.create(environmentName)], IScope.NULLSCOPE)
    }

    /**
     * Build scope for imported microservices
     */
    private def getScope(ImportedMicroservice microservice, EReference reference) {
        switch (reference) {
            /*
             * Scope for service imports. The scope provider will delegate the scope resolution with
             * ImportedMicroservice as the context, if its import feature was set. Otherwise, the
             * context will be an instance of OperationNode (see above).
             */
            case OperationPackage::Literals.IMPORTED_MICROSERVICE__IMPORT:
                return microservice.getScopeForImportsOfType(ServiceModel)

            /* Actual imported microservices */
            case OperationPackage::Literals.IMPORTED_MICROSERVICE__MICROSERVICE:
                return microservice.import.getScopeForImportedMicroservices()
        }

        return null
    }

    /**
     * Build scope for the actual microservices if the import was already specified
     */
    private def getScopeForImportedMicroservices(Import ^import) {
        if (import === null)
            return IScope.NULLSCOPE

        return DdmmUtils.getScopeForPossiblyImportedConcept(
            import,
            null,
            ServiceModel,
            import.importURI,
            [microservices.toList],
            [qualifiedNameParts]
        )
    }

    /**
     * Build scope for protocols and data formats
     */
    private def getScope(ProtocolAndDataFormat protocolAndDataFormat, EReference reference) {
        switch (reference) {
            /* Technologies */
            case OperationPackage::Literals.PROTOCOL_AND_DATA_FORMAT__TECHNOLOGY:
                return EcoreUtil2.getContainerOfType(protocolAndDataFormat, OperationNode)
                    .getScopeForAnnotatedTechnologies()

            /* Protocols */
            case OperationPackage::Literals.PROTOCOL_AND_DATA_FORMAT__PROTOCOL:
                return protocolAndDataFormat.getScopeForEndpointProtocols()

            /* Data formats */
            case OperationPackage::Literals.PROTOCOL_AND_DATA_FORMAT__DATA_FORMAT:
                return protocolAndDataFormat.getScopeForDataFormats()
        }

        return null
    }

    /**
     * Build scope for endpoint protocols
     */
    private def getScopeForEndpointProtocols(ProtocolAndDataFormat protocol) {
        if (protocol.technology === null)
            return IScope.NULLSCOPE

        return DdmmUtils.getScopeForPossiblyImportedConcept(
            protocol.technology,
            null,
            Technology,
            protocol.technology.importURI,
            [protocols.toList],
            [qualifiedNameParts]
        )
    }

    /**
     * Build scope for endpoint data formats
     */
    private def getScopeForDataFormats(ProtocolAndDataFormat protocolAndDataFormat) {
        if (protocolAndDataFormat.protocol === null)
            return IScope.NULLSCOPE

        // Return scope elements, i.e., defined data formats, that exist for the protocol
        val protocolName = protocolAndDataFormat.protocol.name
        if (protocolName === null)
            return IScope.NULLSCOPE

        val scopeElements = protocolAndDataFormat.protocol.technology.protocols
            // We can use the first protocol we find, as protocol names are unique (ensured by
            // validator of Technology DSL) independent of communication type
            .findFirst[name == protocolName]
            .dataFormats

        return Scopes::scopeFor(scopeElements, [QualifiedName.create(it.formatName)],
            IScope.NULLSCOPE)
    }

    /**
     * Build scope for service deployment specifications
     */
    private def getScope(ServiceDeploymentSpecification specification, EReference reference) {
        switch (reference) {
            /* Imports */
            case OperationPackage::Literals.SERVICE_DEPLOYMENT_SPECIFICATION__IMPORT:
                return specification.operationNode.getScopeForServiceDeploymentImports()

            /* Services */
            case OperationPackage::Literals.SERVICE_DEPLOYMENT_SPECIFICATION__SERVICE:
                return specification.getScopeForServiceDeploymentServices()

            /* Technologies */
            case OperationPackage::Literals.PROTOCOL_AND_DATA_FORMAT__TECHNOLOGY:
                /* Technologies */
                return EcoreUtil2.getContainerOfType(specification, OperationNode)
                    .getScopeForAnnotatedTechnologies()

            /* Service properties */
            case TechnologyPackage::Literals
                .TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_ASSIGNMENT__PROPERTY:
                return specification.getScopeForServiceProperties()
        }

        return null
    }

    /**
     * Build scope for imports within service deployment specifications
     */
    private def getScopeForServiceDeploymentImports(OperationNode operationNode) {
        val deployedServicesImports = newHashSet
        deployedServicesImports.addAll(operationNode.deployedServices.map[import])
        return Scopes::scopeFor(deployedServicesImports)
    }

    /**
     * Build scope for services within service deployment specifications
     */
    private def getScopeForServiceDeploymentServices(ServiceDeploymentSpecification specification) {
        return Scopes::scopeFor(specification.operationNode.deployedServices
            .filter[import.name !== null && import.name == specification.import.name],
            [QualifiedName.create(microservice.qualifiedNameParts)], IScope.NULLSCOPE
        )
    }

    /**
     * Build scope for property values
     */
    private def getScope(TechnologySpecificPropertyValueAssignment propertyValue,
        EReference reference) {
        if (reference !==
            TechnologyPackage::Literals.TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_ASSIGNMENT__PROPERTY)
            return IScope.NULLSCOPE

        return switch(propertyValue.eContainer) {
            ImportedOperationAspect:
                propertyValue.getScopeForAspectProperty()
            default:
                propertyValue.getScopeForServiceProperties()
        }
    }

    /**
     * Build scope for service properties
     */
    private def getScopeForServiceProperties(EObject context) {
        /*
         * Service properties may be specified in containers (within their deployment technology) or
         * in infrastructure nodes (within their infrastructure technology). In the following we try
         * to find service properties in the context, which may itself be a container or
         * infrastructure node or an EObject that is a child of a container or infrastructure node.
         */
        // Container (or part thereof)
        var Container container = if (context instanceof Container)
                context as Container
            else
                EcoreUtil2.getContainerOfType(context, Container)

        // Infrastructure node (or part thereof)
        var InfrastructureNode infrastructureNode
        if (container === null)
            infrastructureNode = if (context instanceof InfrastructureNode)
                    context as InfrastructureNode
                else
                    EcoreUtil2.getContainerOfType(context, InfrastructureNode)

        /* Get service properties from container or infrastructure node and build scope */
        if (container !== null &&
            container.deploymentTechnology !== null &&
            container.deploymentTechnology.deploymentTechnology !== null)
                return Scopes::scopeFor(
                    container.deploymentTechnology.deploymentTechnology.serviceProperties
                )
        else if (infrastructureNode !== null &&
            infrastructureNode.infrastructureTechnology !== null &&
            infrastructureNode.infrastructureTechnology.infrastructureTechnology !== null)
            return Scopes::scopeFor(
                infrastructureNode.infrastructureTechnology.infrastructureTechnology
                    .serviceProperties
            )
        else
            return IScope.NULLSCOPE
    }

    /**
     * Convenience method to create a scope for imports of certain types
     */
    private def getScopeForImportsOfType(EObject context, Class<? extends EObject>... types) {
        val allImports = EcoreUtil2.getContainerOfType(context, OperationModel).imports
        val validImports = DdmmUtils.getImportsOfModelTypes(allImports, [it.importURI], types)
        return Scopes::scopeFor(validImports)
    }
}