package de.fhdo.ddmm.intermediate.transformations.service

import de.fhdo.ddmm.technology.mapping.TechnologyMapping
import de.fhdo.ddmm.utils.DdmmUtils
import de.fhdo.ddmm.service.ServiceModel
import de.fhdo.ddmm.service.ImportType
import java.util.ArrayDeque
import de.fhdo.ddmm.service.Import
import de.fhdo.ddmm.intermediate.transformations.AbstractInputModelValidator
import de.fhdo.ddmm.intermediate.transformations.IntermediateTransformationException

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
}