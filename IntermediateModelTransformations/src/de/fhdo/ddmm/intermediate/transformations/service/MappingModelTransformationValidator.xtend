package de.fhdo.ddmm.intermediate.transformations.service

import de.fhdo.ddmm.technology.mapping.TechnologyMapping
import de.fhdo.ddmm.utils.DdmmUtils
import de.fhdo.ddmm.service.ServiceModel
import de.fhdo.ddmm.service.ImportType
import java.util.ArrayDeque
import de.fhdo.ddmm.service.Import
import de.fhdo.ddmm.intermediate.transformations.AbstractInputModelValidator
import de.fhdo.ddmm.intermediate.transformations.IntermediateTransformationException
import de.fhdo.ddmm.service.Endpoint
import org.eclipse.xtext.EcoreUtil2
import de.fhdo.ddmm.service.Microservice

/**
 * Validator for technology mapping models that shall be transformed.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class MappingModelTransformationValidator
    extends AbstractInputModelValidator<TechnologyMapping> {
    /**
     * Validate input models for errors
     */
    override checkInputModelForErrors(TechnologyMapping mappingModel)
        throws IntermediateTransformationException {
        if (mappingModel === null)
            error("Mapping model is empty")

        if (mappingModel.eAllContents.empty)
            error("Mapping model is empty")

        checkImportsInServiceModelsForDuplicateAliases(mappingModel)
        checkServiceModelsForDuplicateEndpointAddresses(mappingModel)
    }

    /**
     * Register warning functions
     */
    override registerWarningFunctions() {
        return #[
            [warnReferredMicroserviceTechnologies]
        ]
    }

    /**
     * Warn if microservices with technologies refer to microservices without technologies
     */
    private def Void warnReferredMicroserviceTechnologies(TechnologyMapping mappingModel) {
        val referencesToMicroservicesWithoutTechnologies = mappingModel.serviceMappings
            .exists[
                microservice.microservice.allRequiredMicroservices.keySet.exists[technologies.empty]
            ]

        if (referencesToMicroservicesWithoutTechnologies)
            warning("The model maps microservices, which refer to services without " +
                "technology assignments. For the services without technology assignments, a code " +
                "generation involving explicit technology specifications would have to be " +
                "performed.")
    }

    /**
     * Check imported service models for duplicate aliases of imported data and service models
     */
    private def checkImportsInServiceModelsForDuplicateAliases(TechnologyMapping mappingModel) {
        // The imported service models also import data models and other service models, e.g., to
        // specify dependencies between services. However, as the imports within the imported models
        // are directly mapped to imports in the resulting intermediate service model, this might
        // result in duplicate, ambiguous aliases in the resulting intermediate service model. We
        // prevent such situations in that we throw a transformation validation error if within
        // imported service models duplicate aliases that point to different files were detected.
        var importsTodo = new ArrayDeque<Import>(mappingModel.imports.filter[
                importType === ImportType.DATATYPES || importType === ImportType.MICROSERVICES
            ].toList)

        val urisDone = <String> newHashSet
        val aliasesToUris = <String, String> newHashMap
        while (!importsTodo.empty) {
            val currentImport = importsTodo.pop
            val importContainingModelFile = DdmmUtils.getFileForResource(currentImport.eResource)
            val currentAbsoluteUri = DdmmUtils.convertToAbsoluteFileUri(currentImport.importURI,
                importContainingModelFile.rawLocation.makeAbsolute.toString)

            val existingUri = aliasesToUris.putIfAbsent(currentImport.name, currentAbsoluteUri)
            if (existingUri !== null && existingUri != currentAbsoluteUri)
                error('''Alias «currentImport.name» was detected more than once in different ''' +
                    '''imported service models. Moreover, it points to different resources ''' +
                    '''within the imported models. Duplicate aliases in imported models are, ''' +
                    '''however, only allowed if they point to the same resource.'''
                )

            if (!urisDone.contains(currentAbsoluteUri)) {
                if (currentImport.importType === ImportType.MICROSERVICES) {
                    val importedServiceModel = DdmmUtils.getImportedModelRoot(
                        currentImport.eResource,
                        currentAbsoluteUri,
                        ServiceModel
                    )

                    importsTodo.addAll(importedServiceModel.imports)
                }

                urisDone.add(currentAbsoluteUri)
            }
        }
    }

    /**
     * Check duplicate microservice endpoint addresses across service models
     */
    private def checkServiceModelsForDuplicateEndpointAddresses(TechnologyMapping mappingModel) {
        val allImportedServiceModels = mappingModel.imports
            .filter[importType === ImportType.MICROSERVICES]
            .toMap(
                [
                    val serviceModelFile = DdmmUtils.getFileForResource(eResource)
                    val modelFileUri = DdmmUtils.convertToAbsoluteFileUri(
                        importURI,
                        serviceModelFile.rawLocation.makeAbsolute.toString
                    )
                    DdmmUtils.getImportedModelRoot(eResource, modelFileUri, ServiceModel)
                ],[
                    DdmmUtils.getFileForResource(eResource).rawLocation.makeAbsolute.toString
                ]
            )
        val allMicroserviceEndpoints = allImportedServiceModels.keySet
            .map[microservices].flatten
            .map[endpoints].flatten
            .toList

        val endpointAddresses = <String, Endpoint>newHashMap
        allMicroserviceEndpoints.forEach[endpoint | endpoint.addresses.forEach[address |
            endpoint.protocols.forEach[protocol |
                var protocolName = protocol.import.name + "::" + protocol.importedProtocol.name
                val dataFormat = protocol.dataFormat
                if (dataFormat !== null && dataFormat.formatName !== null)
                    protocolName += "/" + dataFormat.formatName
                val addressPrefixedByProtocol = protocolName + address

                val duplicateEndpoint = endpointAddresses.get(addressPrefixedByProtocol)
                if (duplicateEndpoint !== null) {
                    val microservice = EcoreUtil2.getContainerOfType(endpoint, Microservice)
                    val duplicateMicroservice = EcoreUtil2.getContainerOfType(duplicateEndpoint,
                        Microservice)
                    if (duplicateMicroservice != microservice)
                        error('''Address «address» is already specified for microservice ''' +
                            '''«microservice.buildQualifiedName(".")» in  service model ''' +
                            '''«allImportedServiceModels.get(microservice.serviceModel)».''')
                } else
                    endpointAddresses.put(addressPrefixedByProtocol, endpoint)
            ]
        ]]
    }
}