package de.fhdo.ddmm.operationdsl.validation

import org.eclipse.xtext.validation.Check
import de.fhdo.ddmm.operation.OperationModel
import de.fhdo.ddmm.operation.OperationPackage
import de.fhdo.ddmm.operation.ServicePropertyValue
import de.fhdo.ddmm.operation.Container
import java.util.List
import de.fhdo.ddmm.utils.DdmmUtils
import de.fhdo.ddmm.operation.ServiceDeploymentSpecification
import de.fhdo.ddmm.operation.TechnologySpecificEndpoint
import org.eclipse.xtext.naming.QualifiedName
import de.fhdo.ddmm.technology.Protocol
import de.fhdo.ddmm.technology.Technology
import de.fhdo.ddmm.operation.OperationNode
import de.fhdo.ddmm.operation.InfrastructureNode
import de.fhdo.ddmm.service.Microservice
import de.fhdo.ddmm.operation.ImportedMicroservice

/**
 * This class contains validation rules for the Operation DSL.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de>Florian Rademacher</a>
 */
class OperationDslValidator extends AbstractOperationDslValidator {
    /**
     * Check that the model is not empty
     */
    @Check
    def checkModelNotEmpty(OperationModel operationModel) {
        if (operationModel.containers.empty && operationModel.infrastructureNodes.empty) {
            error("Model must contain at least one container or infrastructure node",
                operationModel, OperationPackage::Literals.OPERATION_MODEL__CONTAINERS)
        }
    }

    /**
     * Check that the assigned value of a service property matches its type
     */
    @Check
    def checkDefaultValueType(ServicePropertyValue propertyValue) {
        val serviceProperty = propertyValue.serviceProperty
        val servicePropertyType = serviceProperty.type
        if (!propertyValue.value.isOfType(servicePropertyType))
            error('''Value is not of type «servicePropertyType.typeName» ''', propertyValue,
                OperationPackage::Literals.SERVICE_PROPERTY_VALUE__VALUE)
    }

    /**
     * Check uniqueness of service property values on containers
     */
    @Check
    def checkServicePropertiesUniqueNames(Container container) {
        checkServicePropertiesUniqueNames(container.defaultServicePropertyValues)
    }

    /**
     * Check uniqueness of service property values on service deployment specifications
     */
    @Check
    def checkServicePropertiesUniqueNames(ServiceDeploymentSpecification deploymentSpecification) {
        checkServicePropertiesUniqueNames(deploymentSpecification.servicePropertyValues)
    }

    /**
     * Convenience method to check uniqueness of service property values in a list of service
     * property values
     */
    private def checkServicePropertiesUniqueNames(List<ServicePropertyValue> propertyValues) {
        val duplicateIndex = DdmmUtils.getDuplicateIndex(propertyValues, [serviceProperty.name])
        if (duplicateIndex > -1) {
            val duplicatePropertyValue = propertyValues.get(duplicateIndex)
            val duplicateProperty = duplicatePropertyValue.serviceProperty
            error('''Duplicate value assigment to service property «duplicateProperty.name»''',
                duplicatePropertyValue,
                OperationPackage::Literals.SERVICE_PROPERTY_VALUE__SERVICE_PROPERTY)
        }
    }

    /**
     * Check unique endpoints on containers
     */
    @Check
    def checkUniqueEndpoints(Container container) {
        checkUniqueEndpoints(container.defaultBasicEndpoints)
    }

    /**
     * Check unique endpoints on infrastructure nodes
     */
    @Check
    def checkUniqueEndpoints(InfrastructureNode infrastructureNode) {
        checkUniqueEndpoints(infrastructureNode.endpoints)
    }

    /**
     * Check unique endpoints on service deployment specification
     */
    @Check
    def checkUniqueEndpoints(ServiceDeploymentSpecification deploymentSpecification) {
        checkUniqueEndpoints(deploymentSpecification.basicEndpoints)
    }

    /**
     * Convenience method to check endpoint uniqueness in a list of endpoints
     */
    private def checkUniqueEndpoints(List<TechnologySpecificEndpoint> endpoints) {
        val duplicateIndex = DdmmUtils.getDuplicateIndex(endpoints,
            [protocol.name + if (dataFormat !== null) dataFormat.formatName else ""])
        if (duplicateIndex == -1) {
            return
        }

        val duplicate = endpoints.get(duplicateIndex)
        error('''Duplicate endpoint for «duplicate.protocol.name»''' +
            '''«IF duplicate.dataFormat !== null»/«duplicate.dataFormat.formatName»«ENDIF»''',
            duplicate, OperationPackage::Literals.TECHNOLOGY_SPECIFIC_ENDPOINT__PROTOCOL,
            duplicateIndex)
    }

    /**
     * Check uniqueness of an endpoint's addresses
     */
    @Check
    def checkUniqueEndpointAddresses(TechnologySpecificEndpoint endpoint) {
        val duplicateIndex = DdmmUtils.getDuplicateIndex(endpoint.addresses, [it])
        if (duplicateIndex > -1) {
            val duplicate = endpoint.addresses.get(duplicateIndex)
            error('''Duplicate address «duplicate»''', endpoint,
                OperationPackage::Literals.TECHNOLOGY_SPECIFIC_ENDPOINT__ADDRESSES, duplicateIndex)
        }
    }

    /**
     * Check that mandatory service properties have values assigned
     */
    @Check
    def checkMandatoryPropertiesHaveValues(OperationNode operationNode) {
        val operationTechnology =
            if (operationNode instanceof Container)
                operationNode.deploymentTechnology
            else if (operationNode instanceof InfrastructureNode)
                operationNode.infrastructureTechnology

        if (operationTechnology === null) {
            return
        }

        // Get mandatory properties that are not set as default properties and thus must be set
        // service-specific within service deployment specifications
        val mandatoryNonDefaultProperties = operationTechnology.serviceProperties
            .filter[technologyProperty |
                technologyProperty.mandatory && !operationNode.defaultServicePropertyValues
                    .exists[defaultProperty |
                        defaultProperty.serviceProperty.name == technologyProperty.name
                    ]
            ]

        // If there are mandatory properties without an assigned default value, check if there are
        // also deployed services that do not have a specification. If those exist, this is a safe
        // indicator that not all mandatory properties have a value assigned, as non-default
        // mandatory properties need to be set in service specifications (which are not complete in
        // the described case).
        val hasMissingSpecifications = operationNode.deploymentSpecifications.size <
            operationNode.deployedServices.size
        if (!mandatoryNonDefaultProperties.empty && hasMissingSpecifications) {
            val firstMissingPropertyName = mandatoryNonDefaultProperties.get(0).name
            error('''All deployed services must specify a value for mandatory property '''+
                    '''«firstMissingPropertyName»''', operationNode,
                    OperationPackage::Literals.OPERATION_NODE__NAME)
            return
        }

        // Check for all existing deployment specifications if mandatory value is set
        mandatoryNonDefaultProperties.forEach[property |
            operationNode.deploymentSpecifications.forEach[
                if (!servicePropertyValues.exists[serviceProperty.name == property.name]) {
                    error('''All deployed services must specify a value for mandatory property '''+
                        '''«property.name»''', operationNode,
                        OperationPackage::Literals.OPERATION_NODE__NAME)
                    return
                }
            ]
        ]
    }

    /**
     * Check that each service has a basic endpoint assigned for each protocol/format combination
     * from the defining technology
     */
    @Check
    def checkServicesForBasicEndpoints(Container container) {
        if (container.technology === null) {
            return
        }

        val technologyModel = DdmmUtils.getImportedModelContents(container.technology.eResource,
            container.technology.importURI)
        if (technologyModel === null || technologyModel.empty) {
            return
        }

        if (!(technologyModel.get(0) instanceof Technology)) {
            return
        }

        val protocolsWithoutDefaultEndpoint = <String, List<String>> newHashMap
        val technology = technologyModel.get(0) as Technology
        technology.protocols.forEach[
            val protocol = it as Protocol
            protocolsWithoutDefaultEndpoint.putIfAbsent(protocol.name, newArrayList)
            protocolsWithoutDefaultEndpoint.get(protocol.name)
                .addAll(protocol.dataFormats.map[formatName])
        ]

        container.defaultBasicEndpoints.forEach[
            if (dataFormat !== null) {
                val remainingDataFormats = protocolsWithoutDefaultEndpoint.get(protocol.name)
                if (remainingDataFormats.size == 1)
                    protocolsWithoutDefaultEndpoint.remove(protocol.name)
                else
                    remainingDataFormats.remove(dataFormat)
            } else
                protocolsWithoutDefaultEndpoint.remove(protocol.name)
        ]

        protocolsWithoutDefaultEndpoint.forEach[protocol, dataFormats | dataFormats.forEach[format |
            container.deploymentSpecifications.forEach[
                val specifiedByBasicEndpoint = basicEndpoints.exists[
                    it.protocol.name == protocol &&
                    if (it.dataFormat !== null) it.dataFormat.formatName == format else true
                ]

                if (!specifiedByBasicEndpoint) {
                    error('''Basic endpoint for protocol «protocol»/«format» needs to be ''' +
                        '''specified for all services''', container,
                        OperationPackage::Literals.OPERATION_NODE__NAME)
                    return
                }
            ]
        ]]
    }

    /**
     * Check uniqueness of service deployment specifications
     */
    @Check
    def checkDeploymentSpecificationsUniqueness(OperationNode operationNode) {
        // We need to check for duplicate specifications leveraging the qualified names of the
        // services and their import aliases. The combination of both information unambiguously
        // identifies a service within the current model.
        val duplicateIndex = DdmmUtils.getDuplicateIndex(operationNode.deploymentSpecifications,
            [import.name + QualifiedName.create(service.microservice.qualifiedNameParts)])
        if (duplicateIndex > -1)
            error('''Duplicate deployment specification''', operationNode,
                OperationPackage::Literals.OPERATION_NODE__DEPLOYMENT_SPECIFICATIONS,
                duplicateIndex)
    }

    /**
     * Check uniqueness of deployed services
     */
    @Check
    def checkDeployedServicesUniqueness(OperationNode operationNode) {
        // We need to check for duplicate deployed services leveraging the qualified names of the
        // services and their import aliases. The combination of both information unambiguously
        // identifies a service within the current model.
        val duplicateIndex = DdmmUtils.getDuplicateIndex(operationNode.deployedServices,
            [import.name + QualifiedName.create(microservice.qualifiedNameParts)])
        if (duplicateIndex > -1)
            error('''Duplicate deployed service''', operationNode,
                OperationPackage::Literals.OPERATION_NODE__DEPLOYED_SERVICES, duplicateIndex)
    }

    /**
     * Warn, if required microservices are not deployed in the same model
     */
    @Check
    def checkRequiredMicroservicesAreDeployed(OperationModel operationModel) {
        /* Collect all Microservice instances that the model specifies for container deployment */
        val allDeployedServices = <Microservice> newHashSet
        allDeployedServices.addAll(operationModel.containers
            .map[deployedServices]
            .flatten
            .map[microservice])

        /*
         * Iterate over all _imported microservices_ that the model specifies for container
         * deployment. Collect the services being required for each imported microservice and check
         * if each required microservice is also specified for container deployment in the model.
         */
        operationModel.containers.map[deployedServices].flatten.forEach[importedService |
            val deployedService = importedService.microservice
            val deployedName = importedService.import.name + "::" +
                QualifiedName.create(deployedService.qualifiedNameParts).toString

            /*
             * Collect required microservices and their full qualified names including possible
             * import aliases from the deployed imported microservice's service model
             */
            val requiredServices = <Microservice, String> newHashMap
            deployedService.allRequiredMicroservices.forEach[
                var requiredName = if (import !== null) import.name + "::" else ""
                requiredName += QualifiedName.create(microservice.qualifiedNameParts).toString
                requiredServices.put(microservice, requiredName)
            ]

            /*
             * Check for each required service if its also in the set of deployed services and warn,
             * if that is not the case
             */
            requiredServices.forEach[requiredService, requiredName |
                if (!allDeployedServices.contains(requiredService))
                    warning('''Service «deployedName» requires service «requiredName», which ''' +
                        '''is not deployed by this model''', importedService,
                        OperationPackage::Literals.IMPORTED_MICROSERVICE__OPERATION_NODE)
            ]
        ]
    }

    /**
     * Warn, if services deployed to infrastructure nodes are not also deployed to containers
     */
    @Check
    def warnInfrastructureDeployments(OperationModel operationModel) {
        /*
         * Collect all services deployed to infrastructure nodes in a map that associates the
         * Microservice instance with the ImportedMicroservice instances. The first will be used
         * for the comparison with the container deployments, the latter will be used to place the
         * warnings in the editor.
         */
        val infrastructureServices = <Microservice, List<ImportedMicroservice>> newHashMap
        operationModel.infrastructureNodes.map[deployedServices].flatten.forEach[
            var associatedImportedServices = infrastructureServices.get(microservice)
            if (associatedImportedServices === null) {
                associatedImportedServices = <ImportedMicroservice> newArrayList
                infrastructureServices.put(microservice, associatedImportedServices)
            }
            associatedImportedServices.add(it)
        ]

        /* Collect all Microservice instances that denote container deployments in a set */
        val containerServices = <Microservice> newHashSet
        containerServices.addAll(operationModel.containers
            .map[deployedServices]
            .flatten
            .map[microservice])

        /*
         * Iterate over all infrastructure services an check, if they are contained in the
         * container deployment set. If not, place a warning on the ImportedMicroservice instances
         * associated with the infrastructure Microservice instances.
         */
        infrastructureServices.forEach[infrastructureService, associatedImportedServices |
            if (!containerServices.contains(infrastructureService))
                associatedImportedServices.forEach[
                    warning("Service is only deployed to infrastructure node but not to container",
                        it, OperationPackage::Literals.IMPORTED_MICROSERVICE__OPERATION_NODE)
                ]
        ]
    }
}