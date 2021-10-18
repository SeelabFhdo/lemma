package de.fhdo.lemma.operationdsl.validation


import de.fhdo.lemma.operation.OperationModel
import de.fhdo.lemma.operation.OperationPackage
import de.fhdo.lemma.operation.Container
import de.fhdo.lemma.operation.ServiceDeploymentSpecification
import de.fhdo.lemma.operation.BasicEndpoint
import de.fhdo.lemma.technology.Protocol
import de.fhdo.lemma.technology.Technology
import de.fhdo.lemma.operation.OperationNode
import de.fhdo.lemma.operation.InfrastructureNode
import de.fhdo.lemma.service.Microservice
import de.fhdo.lemma.operation.ImportedMicroservice
import de.fhdo.lemma.service.ServicePackage
import de.fhdo.lemma.technology.TechnologySpecificPropertyValueAssignment
import de.fhdo.lemma.technology.TechnologyPackage
import de.fhdo.lemma.service.ServiceModel
import de.fhdo.lemma.operation.ImportedOperationAspect
import de.fhdo.lemma.service.Import
import de.fhdo.lemma.technology.PropertyFeature
import de.fhdo.lemma.utils.LemmaUtils
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.naming.QualifiedName
import java.util.Map
import java.util.List

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
        val absolutePath = LemmaUtils.absolutePath(operationModel.eResource)
        val absoluteImportPaths = operationModel.imports.map[
            LemmaUtils.convertToAbsolutePath(importURI, absolutePath)
        ]
        val duplicateIndex = LemmaUtils.getDuplicateIndex(absoluteImportPaths, [it])
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
        val duplicateIndex = LemmaUtils.getDuplicateIndex(operationModel.imports, [name])
        if (duplicateIndex === -1) {
            return
        }

        val duplicate = operationModel.imports.get(duplicateIndex)
        error('''Duplicate import alias «duplicate.name»''', duplicate,
            ServicePackage::Literals.IMPORT__NAME)
    }

    /**
     * Check that imported file defines a model that fits the given import type
     */
    @Check
    override checkImportType(Import ^import) {
        var Class<? extends EObject> expectedModelType
        var String expectedModelTypeName
        switch (import.importType) {
            case MICROSERVICES: {
                expectedModelType = ServiceModel
                expectedModelTypeName = "service"
            }
            case TECHNOLOGY: {
                expectedModelType = Technology
                expectedModelTypeName = "technology"
            }
            case OPERATION_NODES: {
                expectedModelType = OperationModel
                expectedModelTypeName = "operation"
            }
            default:
                return
        }

        if (!LemmaUtils.isImportOfType(import.eResource, import.importURI, expectedModelType))
            error('''File does not contain a «expectedModelTypeName» model definition''', import,
                ServicePackage::Literals.IMPORT__IMPORT_URI)
    }

    /**
     * Check that annotated technologies define not only service-related concepts
     */
    @Check
    def checkTechnologiesForDeploymentConcepts(OperationNode operationNode) {
        for (i : 0..<operationNode.technologies.size) {
            val technologyImport = operationNode.technologies.get(i)
            val technologyModel = LemmaUtils.getImportedModelRoot(technologyImport.eResource,
                technologyImport.importURI, Technology)
            if (technologyModel.protocols.empty &&
                technologyModel.deploymentTechnologies.empty &&
                technologyModel.infrastructureTechnologies.empty &&
                technologyModel.operationAspects.empty) {
                error("Technology does not specify operation-related concepts",
                    OperationPackage::Literals.OPERATION_NODE__TECHNOLOGIES, i)
            }
        }
    }

    /**
     * Check that the assigned value of a service property matches its type
     */
    @Check
    override checkPropertyValueType(TechnologySpecificPropertyValueAssignment propertyValue) {
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
        val duplicateIndex = LemmaUtils.getDuplicateIndex(operationNode.technologies, [it])
        if (duplicateIndex > -1) {
            error('''Duplicate technology assignment for «operationNode.name»''',
                OperationPackage::Literals.OPERATION_NODE__TECHNOLOGIES, duplicateIndex)
        }
    }

    /**
     * Check multiplicities of service property values on containers
     */
    @Check
    def checkServicePropertyMultiplicities(Container container) {
        checkMultiplicities(container.defaultServicePropertyValues)
    }

    /**
     * Check multiplicities of service property values on service deployment specifications
     */
    @Check
    def checkServicePropertyMultiplicities(ServiceDeploymentSpecification deploymentSpecification) {
        checkMultiplicities(deploymentSpecification.servicePropertyValues)
    }

    /**
     * Convenience method to multiplicities of property values
     */
    private def checkMultiplicities(List<TechnologySpecificPropertyValueAssignment> values) {
        val valuesOfSingleValuedProperties = values.filter[
            property.features.contains(PropertyFeature.SINGLE_VALUED)
        ].toList()

        for (i : 0..<valuesOfSingleValuedProperties.size) {
            val remainingList = valuesOfSingleValuedProperties
                .subList(i, valuesOfSingleValuedProperties.size)
            val duplicateIndex = LemmaUtils.getDuplicateIndex(remainingList, [property.name])
            if (duplicateIndex > -1) {
                val duplicate = remainingList.get(duplicateIndex)
                error("Duplicate value assignment to single-value service property " +
                    duplicate.property.name, duplicate,
                TechnologyPackage::Literals.TECHNOLOGY_SPECIFIC_PROPERTY_VALUE_ASSIGNMENT__PROPERTY)
            }
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
                    protocolId += '''(«protocolAndDataFormat.dataFormat.formatName»)'''
                else
                    protocolId += '''(«protocolAndDataFormat.protocol.defaultFormat.formatName»)'''

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
        val duplicateIndex = LemmaUtils.getDuplicateIndex(endpoint.addresses, [it])
        if (duplicateIndex > -1) {
            val duplicate = endpoint.addresses.get(duplicateIndex)
            error('''Duplicate address «duplicate»''', endpoint,
                OperationPackage::Literals.BASIC_ENDPOINT__ADDRESSES, duplicateIndex)
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
    def warnSameAddressOnDifferentContainers(Container containerToCheck) {
        val otherContainersWithSameMicroservices = containerToCheck.operationModel.containers
            .filter[otherContainer |
                otherContainer != containerToCheck &&
                otherContainer.deployedServices.exists[
                    containerToCheck.deployedServices.map[microservice].contains(it.microservice)
                ]
            ]

        if (otherContainersWithSameMicroservices.empty) {
            return
        }

        containerToCheck.addressesAndEndpoints.forEach[addressToCheck, addressEndpointAndIndex |
            otherContainersWithSameMicroservices.forEach[
                if (defaultBasicEndpoints.map[addresses].flatten.toList.contains(addressToCheck))
                    warning('''Address «addressToCheck» is already specified on a container ''' +
                        '''that deploys the same microservices''', addressEndpointAndIndex.key,
                        OperationPackage::Literals.BASIC_ENDPOINT__ADDRESSES,
                        addressEndpointAndIndex.value
                    )

                deploymentSpecifications.forEach[
                    if (basicEndpoints.map[addresses].flatten.toList.contains(addressToCheck))
                        warning('''Address «addressToCheck» is already specified on a container ''' +
                            '''that deploys the same microservices''', addressEndpointAndIndex.key,
                            OperationPackage::Literals.BASIC_ENDPOINT__ADDRESSES,
                            addressEndpointAndIndex.value
                        )
                ]
            ]
        ]
    }

    /**
     * Check if addresses occur more than once for between infrastructure nodes and other
     * infrastructure nodes or containers
     */
    @Check
    def checkDuplicateEndpointAddresses(OperationModel model) {
        /* Check duplicate addresses on endpoints of infrastructure nodes */
        val infrastructureNodeAddresses = <String, Pair<BasicEndpoint, Integer>> newHashMap
        model.infrastructureNodes.forEach[
            it.addressesAndEndpoints.forEach[address, endpointAndIndex |
                if (!infrastructureNodeAddresses.containsKey(address))
                    infrastructureNodeAddresses.put(address, endpointAndIndex)
                else
                    error('''Address «address» is already specified for an endpoint of ''' +
                        '''another infrastructure node''', endpointAndIndex.key,
                        OperationPackage::Literals.BASIC_ENDPOINT__ADDRESSES,
                        endpointAndIndex.value
                    )
            ]
        ]

        /* Check duplicate addresses between endpoints of infrastructure nodes and containers */
        model.containers.forEach[
            it.addressesAndEndpoints.forEach[address, endpointAndIndex |
                if (infrastructureNodeAddresses.containsKey(address))
                    error('''Address «address» is already specified for an endpoint of ''' +
                        '''an infrastructure node''', endpointAndIndex.key,
                        OperationPackage::Literals.BASIC_ENDPOINT__ADDRESSES,
                        endpointAndIndex.value
                    )
            ]
        ]
    }

    /**
     * Helper to get all addresses, their endpoints, and endpoint indexes of an operation node
     */
    private def Map<String, Pair<BasicEndpoint, Integer>>
        getAddressesAndEndpoints(OperationNode node) {
        val addressesAndEndpoint = <String, Pair<BasicEndpoint, Integer>> newHashMap

        /* Get node-specific endpoints depending on node's concrete type */
        if (node instanceof Container)
            node.defaultBasicEndpoints.forEach[endpoint |
                for (n : 0..<endpoint.addresses.size) {
                    val address = endpoint.addresses.get(n)
                    addressesAndEndpoint.put(address, {endpoint -> n})
                }
            ]
        else if (node instanceof InfrastructureNode)
            node.endpoints.forEach[endpoint |
                for (n : 0..<endpoint.addresses.size) {
                    val address = endpoint.addresses.get(n)
                    addressesAndEndpoint.put(address, {endpoint -> n})
                }
            ]

        /* Get endpoints of service-specific deployment specifications */
       node.deploymentSpecifications.forEach[basicEndpoints.forEach[endpoint |
            for (n : 0..<endpoint.addresses.size) {
                val address = endpoint.addresses.get(n)
                addressesAndEndpoint.put(address, {endpoint -> n})
            }
        ]]

        return addressesAndEndpoint
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
                technologyProperty.isMandatory && !operationNode.defaultServicePropertyValues
                    .exists[defaultProperty |
                        defaultProperty.property.name == technologyProperty.name
                    ]
            ]

        if (mandatoryNonDefaultProperties.empty)
            return

        // If there are mandatory properties without an assigned default value, check if there are
        // also deployed services that do not have a specification. If those exist, this is a safe
        // indicator that not all mandatory properties have a value assigned, as non-default
        // mandatory properties need to be set in service specifications (which are not complete in
        // the described case).
        val hasMissingSpecifications = operationNode.deploymentSpecifications.size <
            operationNode.deployedServices.size
        if (hasMissingSpecifications) {
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

        // If we're on an infrastructure node that does not deploy services, check that all
        // mandatory properties received default values
        if (operationNode instanceof InfrastructureNode && operationNode.deployedServices.empty) {
            val firstMissingPropertyName = mandatoryNonDefaultProperties.get(0).name
            error('''Mandatory property «firstMissingPropertyName» must receive a value''',
                operationNode, OperationPackage::Literals.OPERATION_NODE__NAME)
        }
    }

    /**
     * Warn in case not each service deployed to a container has a basic endpoint assigned for each
     * protocol/format combination from each assigned technology of the container
     */
    @Check
    def warnServicesForBasicEndpoints(Container container) {
        if (container.technologies === null || container.technologies.empty) {
            return
        }

        container.technologies.forEach[
            warnServicesForBasicEndpoints(container,  it)
        ]
    }

    /**
     * Helper to warn if a service deployed to a given container does not have a basic endpoint
     * for each protocol/format combination in the given technology of the container
     */
    private def warnServicesForBasicEndpoints(Container container, Import technologyImport) {
        val technologyModel = LemmaUtils.getImportedModelContents(technologyImport.eResource,
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
                warning('''No basic endpoint specified for protocol «protocol»''', container,
                    OperationPackage::Literals.OPERATION_NODE__NAME)
            }

            dataFormats.forEach[format | container.deploymentSpecifications.forEach[
                val specifiedByBasicEndpoint = !basicEndpoints.empty &&
                    basicEndpoints.map[protocols].flatten.exists[
                        it.protocol.name == protocol &&
                        if (it.dataFormat !== null) it.dataFormat.formatName == format else true
                    ]

                if (!specifiedByBasicEndpoint) {
                    warning('''No basic endpoint specified for protocol «protocol»/«format» ''',
                        container, OperationPackage::Literals.OPERATION_NODE__NAME)
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
        val duplicateIndex = LemmaUtils.getDuplicateIndex(operationNode.deploymentSpecifications,
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
        val duplicateIndex = LemmaUtils.getDuplicateIndex(operationNode.deployedServices,
            [import.name + QualifiedName.create(microservice.qualifiedNameParts)])
        if (duplicateIndex > -1)
            error('''Duplicate deployed service''', operationNode,
                OperationPackage::Literals.OPERATION_NODE__DEPLOYED_SERVICES, duplicateIndex)
    }

    /**
     * Warn if an infrastructure node does seemingly not fulfill an actual purpose, i.e., when it
     * does not have deployed services assigned, is not used by other nodes, and no other nodes
     * depend on it
     */
    @Check
    def warnNodeHasPurpose(InfrastructureNode infrastructureNode) {
        if (!infrastructureNode.deployedServices.empty || !infrastructureNode.usedByNodes.empty) {
            return
        }

        val dependentNodesExist = EcoreUtil2
            .getSiblingsOfType(infrastructureNode, InfrastructureNode)
            .exists[dependsOnNodes.contains(infrastructureNode)]
        if (!dependentNodesExist) {
            warning("Node is not used by services or nodes, and no other node depends on it",
                infrastructureNode, OperationPackage::Literals.OPERATION_NODE__NAME)
        }
    }

    /**
     * Check that node is used by unique nodes
     */
    @Check
    def checkUsingNodesUniqueness(OperationNode operationNode) {
        val duplicateIndex = LemmaUtils.getDuplicateIndex(operationNode.usedByNodes, [node.name])
        if (duplicateIndex > -1)
            error("Duplicate node", operationNode,
                OperationPackage::Literals.OPERATION_NODE__USED_BY_NODES, duplicateIndex)
    }

    /**
     * Check that node depends on unique nodes
     */
    @Check
    def checkDependingNodesUniqueness(OperationNode operationNode) {
        val duplicateIndex = LemmaUtils.getDuplicateIndex(operationNode.dependsOnNodes, [node.name])
        if (duplicateIndex > -1)
            error("Duplicate node", operationNode,
                OperationPackage::Literals.OPERATION_NODE__DEPENDS_ON_NODES, duplicateIndex)
    }

    /**
     * Warn, if required microservices are not deployed in the same model
     */
    @Check
    def warnRequiredMicroservicesAreNotDeployed(OperationModel operationModel) {
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
                    warning("Service is not deployed to container", it,
                        OperationPackage::Literals.IMPORTED_MICROSERVICE__OPERATION_NODE)
                ]
        ]
    }

    /**
     * Check uniqueness of aspects
     */
    @Check
    def checkAspectUniqueness(ImportedOperationAspect importedAspect) {
        if (!importedAspect.aspect.isSingleValued) {
            return
        }

        val eponymousAspectsOfContainer = EcoreUtil2.getSiblingsOfType(importedAspect,
            ImportedOperationAspect).filter[
                it != aspect &&
                it.aspect.name == importedAspect.aspect.name
            ]

        if (!eponymousAspectsOfContainer.empty) {
            val duplicateAspect = eponymousAspectsOfContainer.get(0)
            error("Aspect may be specified at most once", duplicateAspect,
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

        val duplicateIndex = LemmaUtils.getDuplicateIndex(importedAspect.values, [property.name])
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
        if (propertyCount === 0)
            error("Aspect does not define properties", importedAspect,
                OperationPackage.Literals::IMPORTED_OPERATION_ASPECT__SINGLE_PROPERTY_VALUE)
        else if (propertyCount > 1)
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
        val mandatoryProperties = aspectProperties.filter[isMandatory]
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

    /**
     * Check if node is either used by or dependent on the same node
     */
    @Check
    def checkDuplicatedOperationNodeDependenciesForUsedByNodes(OperationNode node) {
        node.dependsOnNodes.forEach[dependsOnNode |
            node.usedByNodes.forEach[usedByNode, index |
                if (usedByNode.node == dependsOnNode.node)
                    error('''«node.name» may only depend on or being used by the same ''' +
                        '''«usedByNode.node.name» node''', node,
                        OperationPackage.Literals::OPERATION_NODE__USED_BY_NODES, index)
            ]
        ]
    }

    /**
     * Check cyclic depends on relationships between operation nodes
     */
    @Check
    def checkConflictingDependenciesBetweenDependsOnOperationNodes(OperationNode node) {
        node.dependsOnNodes.forEach[dependsOnNode |
            val conflictingNode = dependsOnNode.node.dependsOnNodes.findFirst[n | n.node == node]

            if (conflictingNode !== null)
                error('''Cyclic dependency between «node.name» and «dependsOnNode.node.name».''',
                    node, OperationPackage.Literals::OPERATION_NODE__DEPENDS_ON_NODES)
        ]
    }

    /**
     * Check cyclic used by relationships between operation nodes
     */
    @Check
    def checkConflictingDependenciesBetweenUsedByOperationNodes(OperationNode node) {
        node.usedByNodes.forEach[usedBynode |
            val conflictingNode = usedBynode.node.usedByNodes.findFirst[n | n.node == node]

            if (conflictingNode !== null)
                error('''Cyclic dependency between «node.name» and «usedBynode.node.name».''',
                    node, OperationPackage.Literals::OPERATION_NODE__USED_BY_NODES)
        ]
    }
}