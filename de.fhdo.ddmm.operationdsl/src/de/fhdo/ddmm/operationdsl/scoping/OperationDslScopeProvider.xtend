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
import de.fhdo.ddmm.operation.ServicePropertyValue
import de.fhdo.ddmm.operation.ServiceDeploymentSpecification
import de.fhdo.ddmm.operation.OperationNode
import de.fhdo.ddmm.operation.InfrastructureNode
import de.fhdo.ddmm.operation.ProtocolAndDataFormat
import de.fhdo.ddmm.operation.BasicEndpoint

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
            /* Containers */
            Container: context.getScope(reference)

            /* Infrastructure nodes */
            InfrastructureNode: context.getScope(reference)

            /* All kinds of operation nodes (i.e., containers and infrastructure nodes) */
            OperationNode: context.getScope(reference)

            /* Imported microservice */
            ImportedMicroservice: context.getScope(reference)

            /*
             * Scope for service property values. The scope provider will delegate the scope
             * resolution with ServicePropertyValue as the context, if its serviceProperty feature
             * was set. Otherwise, the context will be an instance of OperationNode (see below).
             */
            ServicePropertyValue: context.getScope(reference)

            /* Scope for basic endpoints */
            BasicEndpoint: context.getScope(reference)

            /* Scope for protocol and data format */
            ProtocolAndDataFormat: context.getScope(reference)

            /* Service deployment specifications */
            ServiceDeploymentSpecification: context.getScope(reference)
        }

        if (scope !== null)
            return scope
        // Try default scope resolution, if no scope could be determined
        else if (scope === null)
            return super.getScope(context, reference)
    }

    /**
     * Build scope for Container-specific features
     */
    private def getScope(Container container, EReference reference) {
        switch (reference) {
            /* Operation environments */
            case OperationPackage::Literals.OPERATION_NODE__OPERATION_ENVIRONMENT:
                return container.getScopeForOperationEnvironment()

            /* Deployment technologies */
            case OperationPackage::Literals.CONTAINER__DEPLOYMENT_TECHNOLOGY:
                return container.getScopeForDeploymentTechnology()
        }

        // If the feature is not Container-specific, delegate scope resolution to superclass
        // OperationNode
        return (container as OperationNode).getScope(reference)
    }

    /**
     * Build scope for InfrastructureNode-specific features
     */
    private def getScope(InfrastructureNode infrastructureNode, EReference reference) {
        switch (reference) {
            /* Operation environments */
            case OperationPackage::Literals.OPERATION_NODE__OPERATION_ENVIRONMENT:
                return infrastructureNode.getScopeForOperationEnvironment()

            /* Deployment technologies */
            case OperationPackage::Literals.INFRASTRUCTURE_NODE__INFRASTRUCTURE_TECHNOLOGY:
                return infrastructureNode.getScopeForInfrastructureTechnology()
        }

        // If the feature is not InfrastructureNode-specific, delegate scope resolution to
        // superclass OperationNode
        return (infrastructureNode as OperationNode).getScope(reference)
    }

    /**
     * Build scope for operation nodes
     */
    private def getScope(OperationNode operationNode, EReference reference) {
        switch (reference) {
            /* Annotated technologies */
            case OperationPackage::Literals.OPERATION_NODE__TECHNOLOGY:
                return operationNode.getScopeForImportsOfType(Technology)

            /* Import of ImportedMicroservices */
            case OperationPackage::Literals.IMPORTED_MICROSERVICE__IMPORT:
                return operationNode.getScopeForImportsOfType(ServiceModel)

            /* Service properties */
            case OperationPackage::Literals.SERVICE_PROPERTY_VALUE__SERVICE_PROPERTY:
                return operationNode.getScopeForServiceProperties()

            /* Import of ServiceDeploymentSpecifications */
            case OperationPackage::Literals.SERVICE_DEPLOYMENT_SPECIFICATION__IMPORT:
                return operationNode.getScopeForServiceDeploymentImports()
        }

        return null
    }

    /**
     * Get scope for deployment technology
     */
    private def getScopeForDeploymentTechnology(Container container) {
        if (container.technology === null)
            return IScope.NULLSCOPE

        return DdmmUtils.getScopeForPossiblyImportedConcept(
            container,
            null,
            Technology,
            container.technology.importURI,
            [deploymentTechnologies.toList],
            [#[name]]
        )
    }

    /**
     * Get scope for infrastructure technology
     */
    private def getScopeForInfrastructureTechnology(InfrastructureNode infrastructureNode) {
        if (infrastructureNode.technology === null)
            return IScope.NULLSCOPE

        return DdmmUtils.getScopeForPossiblyImportedConcept(
            infrastructureNode,
            null,
            Technology,
            infrastructureNode.technology.importURI,
            [infrastructureTechnologies.toList],
            [#[name]]
        )
    }

    /**
     * Get scope for operation environment
     */
    private def getScopeForOperationEnvironment(OperationNode operationNode) {
        val operationTechnology =
            if (operationNode instanceof Container)
                operationNode.deploymentTechnology
            else if (operationNode instanceof InfrastructureNode)
                operationNode.infrastructureTechnology

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
     * Build scope for basic endpoints
     */
    private def getScope(BasicEndpoint basicEndpoint, EReference reference) {
        switch (reference) {
            /* Protocols */
            case OperationPackage::Literals.PROTOCOL_AND_DATA_FORMAT__PROTOCOL:
                return basicEndpoint.getScopeForEndpointProtocols()
        }

        return null
    }

    /**
     * Build scope for protocols and data formats
     */
    private def getScope(ProtocolAndDataFormat protocolAndDataFormat, EReference reference) {
        switch (reference) {
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
    private def getScopeForEndpointProtocols(EObject context) {
        var OperationNode operationNode = null

        if (context instanceof OperationNode)
            operationNode = context
        else
            operationNode = EcoreUtil2.getContainerOfType(context, OperationNode)

        if (operationNode === null || operationNode.technology === null)
            return IScope.NULLSCOPE

        return DdmmUtils.getScopeForPossiblyImportedConcept(
            operationNode.technology,
            null,
            Technology,
            operationNode.technology.importURI,
            [protocols.toList],
            [#[name]]
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

            /* Service properties */
            case OperationPackage::Literals.SERVICE_PROPERTY_VALUE__SERVICE_PROPERTY:
                return specification.getScopeForServiceProperties()

            /* Protocols */
            case OperationPackage::Literals.PROTOCOL_AND_DATA_FORMAT__PROTOCOL:
                return specification.getScopeForEndpointProtocols()
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
            .filter[import.name == specification.import.name],
            [QualifiedName.create(microservice.qualifiedNameParts)], IScope.NULLSCOPE
        )
    }

    /**
     * Build scope for service property values
     */
    private def getScope(ServicePropertyValue servicePropertyValue, EReference reference) {
        switch (reference) {
            case OperationPackage::Literals.SERVICE_PROPERTY_VALUE__SERVICE_PROPERTY:
                return servicePropertyValue.getScopeForServiceProperties()
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

        if (container === null && infrastructureNode === null)
            return IScope.NULLSCOPE

        /* Get service properties from container or infrastructure node and build scope */
        val serviceProperties = if (container !== null)
                container.deploymentTechnology.serviceProperties
            else
                infrastructureNode.infrastructureTechnology.serviceProperties

        return Scopes::scopeFor(serviceProperties)
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