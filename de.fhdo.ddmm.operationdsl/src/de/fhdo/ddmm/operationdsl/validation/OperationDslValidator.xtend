package de.fhdo.ddmm.operationdsl.validation

import org.eclipse.xtext.validation.Check
import de.fhdo.ddmm.operation.OperationModel
import de.fhdo.ddmm.operation.OperationPackage
import de.fhdo.ddmm.operation.Container
import java.util.List
import de.fhdo.ddmm.utils.DdmmUtils
import de.fhdo.ddmm.operation.ServiceDeploymentSpecification
import de.fhdo.ddmm.operation.BasicEndpoint
import org.eclipse.xtext.naming.QualifiedName
import de.fhdo.ddmm.technology.Protocol
import de.fhdo.ddmm.technology.Technology
import de.fhdo.ddmm.operation.OperationNode
import de.fhdo.ddmm.operation.InfrastructureNode
import de.fhdo.ddmm.service.Microservice
import de.fhdo.ddmm.operation.ImportedMicroservice
import de.fhdo.ddmm.service.ServicePackage
import com.google.common.base.Function
import de.fhdo.ddmm.technology.TechnologySpecificPropertyValueAssignment
import de.fhdo.ddmm.technology.TechnologyPackage
import de.fhdo.ddmm.operation.ImportedOperationAspect
import org.eclipse.xtext.EcoreUtil2
import de.fhdo.ddmm.service.Import

/**
 * This class contains validation rules for the Operation DSL.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
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
     * Check that imported file is imported exactly once
     */
    @Check
    def checkImportFileUniqueness(OperationModel operationModel) {
        val duplicateIndex = DdmmUtils.getDuplicateIndex(operationModel.imports, [importURI])
        if (duplicateIndex === -1) {
            return
        }

        val duplicate = operationModel.imports.get(duplicateIndex)
        error("File is already being imported", duplicate,
            ServicePackage::Literals.IMPORT__IMPORT_URI)
    }

    /**
     * Check import aliases for uniqueness
     */
    @Check
    def checkImportAlias(OperationModel operationModel) {
        val duplicateIndex = DdmmUtils.getDuplicateIndex(operationModel.imports, [name])
        if (duplicateIndex === -1) {
            return
        }

        val duplicate = operationModel.imports.get(duplicateIndex)
        error('''Duplicate import alias «duplicate.name»''', duplicate,
            ServicePackage::Literals.IMPORT__NAME)
    }

    /**
     * Check that the assigned value of a service property matches its type
     */
    @Check
    def override checkPropertyValueType(TechnologySpecificPropertyValueAssignment propertyValue) {
        if (propertyValue.property === null || propertyValue.value === null) {
            return
        }

        val serviceProperty = propertyValue.property
        val servicePropertyType = serviceProperty.type
        if (!propertyValue.value.isOfType(servicePropertyType))
            error('''Value is not of type «servicePropertyType.typeName» ''', propertyValue,
                TechnologyPackage::Literals.TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_ASSIGNMENT__VALUE)
    }

    /**
     * Check that technology is assigned only once to an operation node
     */
    @Check
    def checkTechnologyUniqueness(OperationNode operationNode) {
        val duplicateIndex = DdmmUtils.getDuplicateIndex(operationNode.technologies, [it])
        if (duplicateIndex > -1) {
            error('''Duplicate technology assignment for «operationNode.name»''',
                OperationPackage::Literals.OPERATION_NODE__TECHNOLOGIES, duplicateIndex)
        }
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
    private def checkServicePropertiesUniqueNames(
        List<TechnologySpecificPropertyValueAssignment> propertyValues) {
        val duplicateIndex = DdmmUtils.getDuplicateIndex(propertyValues, [property.name])
        if (duplicateIndex > -1) {
            val duplicatePropertyValue = propertyValues.get(duplicateIndex)
            val duplicateProperty = duplicatePropertyValue.property
            error('''Duplicate value assigment to service property «duplicateProperty.name»''',
                duplicatePropertyValue,
                TechnologyPackage::Literals.TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_ASSIGNMENT__PROPERTY)
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
    private def checkUniqueEndpoints(List<BasicEndpoint> endpoints) {
        val protocolSet = <String> newHashSet
        endpoints.forEach[endpoint |
            for (i : 0..<endpoint.protocols.size) {
                val protocolAndDataFormat = endpoint.protocols.get(i)
                var protocolId = protocolAndDataFormat.protocol.name
                if (protocolAndDataFormat.dataFormat !== null)
                    protocolId += "/" + protocolAndDataFormat.dataFormat.formatName
                val isDuplicate = !protocolSet.add(protocolId)
                if (isDuplicate)
                    error('''Duplicate endpoint for protocol «protocolId»''', protocolAndDataFormat,
                        OperationPackage::Literals.PROTOCOL_AND_DATA_FORMAT__PROTOCOL, i)
            }
        ]
    }

    /**
     * Check uniqueness of an endpoint's addresses
     */
    @Check
    def checkUniqueEndpointAddresses(BasicEndpoint endpoint) {
        val duplicateIndex = DdmmUtils.getDuplicateIndex(endpoint.addresses, [it])
        if (duplicateIndex > -1) {
            val duplicate = endpoint.addresses.get(duplicateIndex)
            error('''Duplicate address «duplicate»''', endpoint,
                OperationPackage::Literals.BASIC_ENDPOINT__ADDRESSES, duplicateIndex)
        }
    }

    /**
     * Check if addresses occur more than once for different endpoints
     */
    @Check
    def checkNonUniqueEndpointAddressesInModel(OperationModel model) {
        val addressToEndpoint = <String, BasicEndpoint> newHashMap

        /*
         * Setup function to build error message depending on where the original endpoint is defined
         */
        val Function<BasicEndpoint, String> buildErrorMessage = [
            // Default basic endpoint of container
            if (container !== null)
                return "Address is also specified for basic endpoint of container " +
                    container.name
            // Endpoints of infrastructure node
            else if (infrastructureNode !== null)
                return "Address is also specified for endpoint of infrastructure node " +
                    infrastructureNode.name
            // Deployment specification inside a container or infrastructure node
            else if (deploymentSpecification !== null) {
                val deployedService = deploymentSpecification.service.microservice
                return "Address is also specified for deployment of service " +
                    deploymentSpecification.import.name + "::" +
                    QualifiedName.create(deployedService.qualifiedNameParts).toString
            }
        ]

        /* Perform the actual duplicate check */
        for (i : 0..<4) {
            var Iterable<BasicEndpoint> endpoints
            switch (i) {
                // Include default basic endpoints of containers
                case 0: endpoints = model.containers.map[defaultBasicEndpoints].flatten

                // Include endpoints of containers' deployment specifications
                case 1: endpoints = model.containers
                    .map[deploymentSpecifications].flatten
                    .map[basicEndpoints].flatten

                // Include endpoints of infrastructure nodes
                case 2: endpoints = model.infrastructureNodes.map[it.endpoints].flatten

                // Include endpoints of infrastructure nodes' deployment specifications
                case 3: endpoints = model.infrastructureNodes
                    .map[deploymentSpecifications].flatten
                    .map[basicEndpoints].flatten
            }

            // Duplicate check
            endpoints.forEach[endpoint |
                for (n : 0..<endpoint.addresses.size) {
                    val address = endpoint.addresses.get(n)
                    val duplicateEndpoint = addressToEndpoint.putIfAbsent(address, endpoint)

                    // We do not show an error if the duplicate address was detected within the same
                    // endpoint as this shall result in an error and is therefore separately checked
                    // by checkUniqueEndpointAddresses()
                    if (duplicateEndpoint !== null && duplicateEndpoint !== endpoint)
                        error(buildErrorMessage.apply(duplicateEndpoint), endpoint,
                            OperationPackage::Literals.BASIC_ENDPOINT__ADDRESSES, n)
                }
            ]
        }
    }

    /**
     * Check that mandatory service properties have values assigned
     */
    @Check
    def checkMandatoryPropertiesHaveValues(OperationNode operationNode) {
        val operationTechnology =
            if (operationNode instanceof Container)
                operationNode.deploymentTechnology.deploymentTechnology
            else if (operationNode instanceof InfrastructureNode)
                operationNode.infrastructureTechnology.infrastructureTechnology

        if (operationTechnology === null) {
            return
        }

        // Get mandatory properties that are not set as default properties and thus must be set
        // service-specific within service deployment specifications
        val mandatoryNonDefaultProperties = operationTechnology.serviceProperties
            .filter[technologyProperty |
                technologyProperty.mandatory && !operationNode.defaultServicePropertyValues
                    .exists[defaultProperty |
                        defaultProperty.property.name == technologyProperty.name
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
                if (!servicePropertyValues.exists[property.name == property.name]) {
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
     * from each assigned technology
     */
    @Check
    def checkServicesForBasicEndpoints(Container container) {
        if (container.technologies === null || container.technologies.empty) {
            return
        }

        container.technologies.forEach[
            checkServicesForBasicEndpoints(container,  it)
        ]
    }

    /**
     * Helper to check that each service of a given container has a basic endpoint assigned for each
     * protocol/format combination from the given technology
     */
    private def checkServicesForBasicEndpoints(Container container, Import technologyImport) {
        val technologyModel = DdmmUtils.getImportedModelContents(technologyImport.eResource,
            technologyImport.importURI)
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

        container.defaultBasicEndpoints.forEach[endpoint |
            endpoint.protocols.forEach[protocolAndDataFormat |
                val protocol = protocolAndDataFormat.protocol
                val dataFormat = protocolAndDataFormat.dataFormat
                if (dataFormat !== null) {
                    val remainingDataFormats = protocolsWithoutDefaultEndpoint.get(protocol.name)
                    if (remainingDataFormats.size == 1)
                        protocolsWithoutDefaultEndpoint.remove(protocol.name)
                    else
                        remainingDataFormats.remove(dataFormat)
                } else
                    protocolsWithoutDefaultEndpoint.remove(protocol.name)
            ]
        ]

        protocolsWithoutDefaultEndpoint.forEach[protocol, dataFormats |
            if (container.deploymentSpecifications.empty) {
                error('''Basic endpoint for protocol «protocol» needs to be ''' +
                    '''specified for all services''', container,
                    OperationPackage::Literals.OPERATION_NODE__NAME)
            }

            dataFormats.forEach[format | container.deploymentSpecifications.forEach[
                val specifiedByBasicEndpoint = !basicEndpoints.empty &&
                    basicEndpoints.map[protocols].flatten.exists[
                        it.protocol.name == protocol &&
                        if (it.dataFormat !== null) it.dataFormat.formatName == format else true
                    ]

                if (!specifiedByBasicEndpoint) {
                    error('''Basic endpoint for protocol «protocol»/«format» needs to be ''' +
                        '''specified for all services''', container,
                        OperationPackage::Literals.OPERATION_NODE__NAME)
                }
            ]]
        ]
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
            deployedService.allRequiredMicroservices.forEach[microservice, import |
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

    /**
     * Check uniqueness of aspects
     */
    @Check
    def checkAspectUniqueness(ImportedOperationAspect importedAspect) {
        val allAspectsOfContainer = EcoreUtil2.getAllContentsOfType(importedAspect.eContainer,
            ImportedOperationAspect)
        val duplicateIndex = DdmmUtils.getDuplicateIndex(allAspectsOfContainer, [aspect.name])
        if (duplicateIndex > -1) {
            val duplicateAspect = allAspectsOfContainer.get(duplicateIndex)
            error("Aspect was already specified", duplicateAspect,
                OperationPackage.Literals::IMPORTED_OPERATION_ASPECT__ASPECT)
        }
    }

    /**
     * Check uniqueness of aspect properties in value assignments
     */
    @Check
    def checkUniqueValueAssignments(ImportedOperationAspect importedAspect) {
        if (importedAspect.values.empty || importedAspect.aspect.properties.size <= 1) {
            return
        }

        val duplicateIndex = DdmmUtils.getDuplicateIndex(importedAspect.values, [property.name])
        if (duplicateIndex > -1)
            error("Duplicate value assignment to property",
                OperationPackage.Literals::IMPORTED_OPERATION_ASPECT__VALUES, duplicateIndex)
    }

    /**
     * Check that aspect has only one property, if only a single value is specified, and that the
     * specified value matches the property's type
     */
    @Check
    def checkSingleAspectProperty(ImportedOperationAspect importedAspect) {
        val propertyValue = importedAspect.singlePropertyValue
        if (propertyValue === null) {
            return
        }

        val propertyCount = importedAspect.aspect.properties.size
        if (propertyCount > 1)
            error("Ambiguous value assignment", importedAspect,
                OperationPackage.Literals::IMPORTED_OPERATION_ASPECT__SINGLE_PROPERTY_VALUE)
        else if (propertyCount === 1) {
            val targetProperty = importedAspect.aspect.properties.get(0)
            val targetPropertyType = targetProperty.type
            if (!propertyValue.isOfType(targetPropertyType))
                error('''Value is not of type «targetPropertyType.typeName» as expected by ''' +
                '''property «targetProperty.name»''', importedAspect,
                OperationPackage.Literals::IMPORTED_OPERATION_ASPECT__SINGLE_PROPERTY_VALUE)
        }
    }

    /**
     * Check that mandatory properties of aspects have values
     */
    @Check
    def checkMandatoryAspectProperties(ImportedOperationAspect importedAspect) {
        val aspectProperties = importedAspect.aspect.properties
        val mandatoryProperties = aspectProperties.filter[mandatory]
        val mandatoryPropertiesWithoutValues = mandatoryProperties.filter[
            !importedAspect.values.map[property].contains(it)
        ]
        val allMandatoryPropertiesHaveValues = mandatoryPropertiesWithoutValues.empty

        val aspectHasExactlyOneMandatoryProperty = aspectProperties.size === 1 &&
            !mandatoryProperties.empty
        if (aspectHasExactlyOneMandatoryProperty) {
            if (importedAspect.singlePropertyValue === null && !allMandatoryPropertiesHaveValues) {
                val mandatoryProperty = mandatoryProperties.get(0)
                error('''Mandatory property «mandatoryProperty.name» does not have value''',
                    importedAspect,
                    OperationPackage.Literals::IMPORTED_OPERATION_ASPECT__ASPECT)
            }
        } else if (!allMandatoryPropertiesHaveValues) {
            mandatoryPropertiesWithoutValues.forEach[
               error('''Mandatory property «name» does not have value''', importedAspect,
                    OperationPackage.Literals::IMPORTED_OPERATION_ASPECT__ASPECT)
            ]
        }
    }
}