package de.fhdo.lemma.intermediate.transformations.service

import de.fhdo.lemma.service.ServicePackage
import de.fhdo.lemma.service.ServiceModel
import de.fhdo.lemma.technology.mapping.MappingPackage
import de.fhdo.lemma.technology.mapping.TechnologyMapping
import de.fhdo.lemma.intermediate.transformations.TransformationModelDescription
import java.util.Map
import org.eclipse.emf.ecore.EObject
import de.fhdo.lemma.service.Import
import java.util.List
import org.eclipse.xtext.EcoreUtil2
import de.fhdo.lemma.technology.mapping.ComplexTypeMapping
import org.eclipse.core.resources.ResourcesPlugin
import de.fhdo.lemma.data.intermediate.IntermediatePackage
import org.eclipse.emf.ecore.resource.Resource
import com.google.common.base.Predicate
import java.io.File
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import de.fhdo.lemma.data.intermediate.IntermediateDataModel
import de.fhdo.lemma.intermediate.transformations.IntermediateTransformationException
import de.fhdo.lemma.intermediate.transformations.TransformationModelType
import de.fhdo.lemma.intermediate.transformations.AbstractAtlInputOutputIntermediateModelTransformationStrategy
import com.google.common.base.Function
import de.fhdo.lemma.data.intermediate.IntermediateImport
import de.fhdo.lemma.technology.mapping.TechnologySpecificFieldMapping
import de.fhdo.lemma.technology.mapping.MicroserviceMapping
import java.util.Set
import de.fhdo.lemma.utils.LemmaUtils

/**
 * Implementation of the ATL-based model-to-model transformation of mapping models to intermediate
 * service models.
 *
 * It also comprises the possible refinement of intermediate data models being produced during the
 * same transformation run in case the mapping model specifies complex type mappings. Refined
 * intermediate data models are then stored in a sub-directory of the directory that contains the
 * intermediate service model resulting from the mapping model. The name of the sub-directory
 * corresponds to the name of the intermediate service model without the ".xmi" extension. The
 * import paths in the intermediate service model as well as intermediate data models being produced
 * during the same run and for the same mapping model are adapted to those of the refined
 * intermediate data models.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class MappingModelTransformation
    extends AbstractAtlInputOutputIntermediateModelTransformationStrategy {
    String absoluteInputModelPath
    TechnologyMapping inputMappingModel

    /**
     * Specify reference name and transformation model type of input model
     */
    override getInputModelReferenceNameAndType() {
        return "Mapping" ->
            new TransformationModelType(MappingPackage.eNS_URI, MappingPackage.eINSTANCE,
                TechnologyMapping)
    }

    /**
     * Specify reference name and transformation model type of output model
     */
    override getOutputModelReferenceNameAndType() {
        return "Service" ->
            new TransformationModelType(ServicePackage.eNS_URI, ServicePackage.eINSTANCE,
                ServiceModel)
    }

    /**
     * Specify path to the compiled ATL transformation file
     */
    override getCompiledModelTransformationFilePath() {
        return "/MappingModelTransformation.asm"
    }

    /**
     * Fetch path of input model prior to transformation execution
     */
    override beforeTransformationHook(
        Map<TransformationModelDescription, String> absoluteInputModelPaths
    ) {
        this.absoluteInputModelPath = absoluteInputModelPaths.values.get(0)
    }

    /**
     * Prepare input model
     */
    override prepareInputModel(TransformationModelDescription modelDescription, EObject modelRoot) {
        inputMappingModel = modelRoot as TechnologyMapping

        // Convert import URIs to absolute URIs
        convertImportUrisToAbsoluteFileUris(inputMappingModel.imports, absoluteInputModelPath)

        // Set source model URIs on complex type mappings so that the mapped fields are identifiable
        // by their fully-qualified names in the context of the data models that define them
        inputMappingModel.setSourceModelUris
    }

    /**
     * Transformation preparation: Convert import URIs of imported model files to absolute file
     * URIs. Otherwise the transformation won't have access to them and the contained model
     * elements.
     */
    private def convertImportUrisToAbsoluteFileUris(List<Import> imports, String modelFilePath) {
        imports.forEach[
            if (!LemmaUtils.isFileUri(importURI))
                importURI = LemmaUtils.convertToFileUri(
                    LemmaUtils.convertToAbsolutePath(importURI, modelFilePath)
                )
        ]
    }

    /**
     * Transformation preparation: Set source model URIs on complex type and technology-specific
     * field mappings. They are later used to distinguish eponymous mapped fields defined in
     * different data models.
     */
    private def setSourceModelUris(TechnologyMapping mappingModelRoot) {
        val typeMappings =
            EcoreUtil2.getAllContentsOfType(mappingModelRoot, typeof(ComplexTypeMapping)) +
            mappingModelRoot.complexParameterMappings.map[fieldMappings].flatten
        typeMappings.forEach[
            val serviceModelUri = LemmaUtils.removeFileUri(it.serviceModelUri)
            val dataModelUri = LemmaUtils.removeFileUri(it.dataModelUri)

            var absoluteDataModelUri = LemmaUtils.convertToFileUri(
                new File(LemmaUtils.convertToAbsolutePath(dataModelUri, serviceModelUri))
                    .canonicalPath
            )

            switch (it) {
                ComplexTypeMapping: it.t_sourceModelUri = absoluteDataModelUri
            }
        ]
    }

    /**
     * Get service model URI of complex type mapping
     */
    private def dispatch getServiceModelUri(ComplexTypeMapping complexTypeMapping) {
        return complexTypeMapping.type.serviceModelImport.importURI
    }

    /**
     * Get service model URI of technology-specific field mapping
     */
    private def dispatch getServiceModelUri(TechnologySpecificFieldMapping mapping) {
        val serviceModelImport =
            EcoreUtil2.getContainerOfType(mapping, ComplexTypeMapping)?.type?.serviceModelImport
                ?: EcoreUtil2.getContainerOfType(mapping, MicroserviceMapping).microservice.import
        return serviceModelImport.importURI
    }

    /**
     * Get data model URI of complex type mapping
     */
    private def dispatch getDataModelUri(ComplexTypeMapping complexTypeMapping) {
        return complexTypeMapping.type.dataModelImport.importURI
    }

    /**
     * Get data model URI of technology-specific field mapping
     */
    private def dispatch getDataModelUri(TechnologySpecificFieldMapping mapping) {
        mapping.originalTypeOfMappedElement.eResource.URI.toString
    }

    /**
     * Specify validator for input model
     */
    override getInputModelValidator(TransformationModelDescription modelDescription) {
        return new MappingModelTransformationValidator
    }

    /**
     * Consider imports of imported service models to build import target paths. Otherwise the paths
     * of domain models imported by mapped service models will point to their original destination
     * instead of those of the intermediate models they get possibly transformed to within the
     * transformation process.
     */
    override considerChildrensChildrenForImportTargetPaths() {
        return true
    }

    /**
     * Add transformation target paths of imported model files to target model
     */
    override populateOutputModelWithImportTargetPaths(
        TransformationModelDescription modelDescription,
        EObject modelRoot,
        Map<String, String> targetPaths
    ) {
        val serviceModelRoot = modelRoot as ServiceModel
        val workspacePath = ResourcesPlugin.workspace.root.location.toString
        targetPaths.forEach[importName, targetPath |
            val import = serviceModelRoot.imports.findFirst[name == importName]
            import.importURI = LemmaUtils.convertToFileUri(workspacePath + targetPath)
        ]
    }

    /**
     * Register listener to be invoked after all transformations of a transformation run were
     * finished
     */
    override registerTransformationsFinishedListener() {
        return [
            results, warningCallback |
            MappingModelRefinementExecutor.executeRefinements(inputMappingModel, results,
                warningCallback)
        ]
    }

    /**
     * This class clusters all functionalities related to the refining of intermediate data models.
     * The refining of intermediate data models being produced during the same transformation run
     * becomes necessary in case the mapping model comprises complex type mappings. In that case,
     * the intermediate data models that hold the mapped complex types are refined with the
     * technology-specific types and aspects used in the mapping.
     *
     * Refined data models are collected in a sub-directory of the directory that holds the
     * intermediate service model resulting from the mapping model. All import paths in the
     * intermediate service model or intermediate data models being refined during the same run are
     * adapted to point to the refined intermediate data models. Note that the name of a refined
     * intermediate data model gets prefixed with the alias of the import in the service model to
     * prevent refined intermediate data models to be overwritten when their source models have the
     * same name but originate from different directories.
     */
    private static final class MappingModelRefinementExecutor {
        /**
         * Execute the refinements
         */
        private static def Void executeRefinements(
            TechnologyMapping inputMappingModel,
            List<TransformationResult> results,
            Predicate<IntermediateTransformationException> warningCallback
        ) {
            /*
             * Execute refinements and collect refined models in a map that assigns the path of
             * the original intermediate data model to its refined version. This map is then
             * assigned to the service model that triggered the model refinements. That is, in the
             * end we have a map that clusters information about which service models produced which
             * intermediate data model refinements from which non-refined intermediate data models.
             */
            val refinedModelsPerServiceModel = <OutputModel, Map<String, OutputModel>>newHashMap
            results.intermediateDataModelsPerServiceModel.forEach[
                serviceModel, intermediateDataModels |
                linkTechnologyModels(serviceModel, inputMappingModel)

                val refinedModels = intermediateDataModels.toMap(
                    [outputPath],
                    [runRefininingTransformation(serviceModel, it, warningCallback)]
                )

                refinedModels.filter[path, model | model !== null].forEach[
                    originalModelPath, refinedModel |
                    refinedModelsPerServiceModel
                        .putIfAbsent(
                            serviceModel,
                            newHashMap(originalModelPath -> refinedModel.outputModel)
                        )
                        ?.put(originalModelPath, refinedModel.outputModel)
                ]
            ]

            /*
             * Adapt the import paths in intermediate service models and intermediate data models
             * being produced during the same transformation run. That is, import relationships
             * between intermediate service and data models, as well as between intermediate data
             * models, will be kept consistent in that they point to refined intermediate data
             * models if they were produced during a mapping transformation.
             */
            refinedModelsPerServiceModel.forEach[serviceModel, refinedDataModels |
                // Adapt import paths in intermediate service model
                val intermediateServiceModel = results.findIntermediateServiceModel(serviceModel)
                intermediateServiceModel.adaptImportPaths(
                    [(it as IntermediateServiceModel).imports], refinedDataModels
                )

                // Adapt import paths in intermediate data models produced during the same
                // transformation run
                refinedDataModels.values.forEach[
                    it.adaptImportPaths([(it as IntermediateDataModel).imports], refinedDataModels)
                ]
            ]

            return null
        }

        /**
         * Link technology models to MappedComplexType instances in service models. This would
         * normally be done by the transformation strategy implementation, i.e., the
         * IntermediateDataModelRefinement class in this case. However,
         * MappedComplexType.getTypeDefinitionTechnology() passes the eResource of the result of
         * MappedComplexType.getTypeDefinitionTechnologyImport() to
         * LemmaUtils.getImportedModelRoot(), which returns null when the input model is in the XMI
         * format as is the case for the refining transformation of intermediate data models.
         */
        private static def linkTechnologyModels(OutputModel serviceModel,
            TechnologyMapping inputMappingModel) {
            val serviceModelRoot = serviceModel.resource.contents.get(0) as ServiceModel
            serviceModelRoot.mappedComplexTypes.forEach[mappedType |
                val sourceMapping = inputMappingModel.typeMappings.findFirst[mapping |
                    mapping.type.dataModelImport.name == mappedType.type.import.name &&
                    mapping.type.type == mappedType.type.type
                ]

                mappedType.t_typeDefinitionTechnology = sourceMapping.typeDefinitionTechnology
                mappedType.t_typeDefinitionTechnologyImport
                    = sourceMapping.typeDefinitionTechnologyImport
            ]
        }

        /**
         * Helper to retrieve intermediate data models that are imported by intermediate service
         * models produced from a mapping model. Note that the helper maps the service model that
         * precedes the intermediate service model in a mapping model transformation to the found
         * intermediate data models. The reason for this is, that the service model does comprise
         * complex type mappings expressed in mapping models, while the intermediate service model
         * does not.
         */
        private static def Map<OutputModel, Set<OutputModel>>
        intermediateDataModelsPerServiceModel(List<TransformationResult> results) {
            val serviceModelsCreatedFromMappingModels = results
                .filter[inputModels.exists[namespaceUri == MappingPackage.eNS_URI]]
                .map[outputModel]

            val mappedComplexTypesPerServiceModel = serviceModelsCreatedFromMappingModels
                .toMap([it], [(resource.contents.get(0) as ServiceModel).mappedComplexTypes])

            val resultMap = <OutputModel, Set<OutputModel>>newHashMap
            mappedComplexTypesPerServiceModel.forEach[serviceModel, mappedComplexTypes |
                mappedComplexTypes.forEach[mappedComplexType |
                    // Filter transformation results for intermediate data models that are imported
                    // by intermediate service models produced from service models in a mapping
                    // model transformation
                    results.filter[
                        outputModel.namespaceUri == IntermediatePackage.eNS_URI &&
                        outputModel.outputPath == mappedComplexType.type.import.importURI
                    ].forEach[
                        // Assign intermediate data models to those service models, whose derived
                        // intermediate service models import the data models
                        resultMap
                            .putIfAbsent(serviceModel, newHashSet(outputModel))
                            ?.add(outputModel)
                    ]
                ]
            ]
            return resultMap
        }

        /**
         * Helper to find the intermediate service model created from a service model in the list of
         * transformation results
         */
        private static def OutputModel findIntermediateServiceModel(
            List<TransformationResult> results,
            OutputModel serviceModel
        ) {
            return results
                .findFirst[
                    outputModel.namespaceUri
                        == de.fhdo.lemma.service.intermediate.IntermediatePackage.eNS_URI &&
                    inputModels.exists[inputPath == serviceModel.outputPath]
                ]?.outputModel
        }

        /**
         * Helper to adapt import paths in an intermediate model to the paths of refined
         * intermediate data models. This helper also saves the resource of the intermediate model
         * after it has been adapted.
         */
        private static def adaptImportPaths(
            OutputModel intermediateModel,
            Function<EObject, List<IntermediateImport>> getImportsFromModelRoot,
            Map<String, OutputModel> refinedDataModels
        ) {
            val modelRoot = intermediateModel.resource.contents.get(0)
            val imports = getImportsFromModelRoot.apply(modelRoot)

            imports.filter[importTypeName == importTypeNameForDatatypes].forEach[
                val refinedDataModelUri = refinedDataModels.get(importUri)?.outputPath
                if (refinedDataModelUri !== null)
                    importUri = refinedDataModelUri
            ]

            intermediateModel.resource.save(emptyMap())
        }

        /**
         * Run refining transformation on an intermediate data model
         */
        private static def TransformationResult runRefininingTransformation(
            OutputModel serviceModel,
            OutputModel intermediateDataModel,
            Predicate<IntermediateTransformationException> warningCallback
        ) {
            val inputModelResources = <TransformationModelDescription, Resource>newHashMap(
                IntermediateDataModelRefinement.IN_MODEL_DESCRIPTION ->
                    intermediateDataModel.resource,
                IntermediateDataModelRefinement.SERVICE_MODEL_DESCRIPTION ->
                    serviceModel.resource
            )

            val outputModelPaths = <TransformationModelDescription, String>newHashMap(
                // The "IN" model in the refinement transformation is effectively an inout model
                IntermediateDataModelRefinement.IN_MODEL_DESCRIPTION ->
                    buildOutputPathForRefiningTransformation(serviceModel, intermediateDataModel)
            )

            val refiningTransformation = new IntermediateDataModelRefinement()
            return refiningTransformation.doTransformationFromResources(
                    inputModelResources,
                    outputModelPaths,
                    null,
                    warningCallback
                ).get(IntermediateDataModelRefinement.IN_MODEL_DESCRIPTION)
        }

        /**
         * Helper to build the output path of an intermediate model's refining transformation. It
         * consists of the path to the input service model of the transformation with its extension
         * removed, the alias of the import of the data model in the service model and the name of
         * the intermediate data model.
         *
         * For instance, for the service model "/foo/bar/ServiceModel.xmi" that imports a data model
         * "DataModel.xmi" under the alias "domain" the resulting output path will be
         * "/foo/bar/ServiceModel/domain_DataModel.xmi". Note, that the name of the service models
         * becomes a folder to host the refined models.
         */
        private static def String buildOutputPathForRefiningTransformation(
            OutputModel serviceModel,
            OutputModel intermediateDataModel
        ) {
            val serviceModelRoot = serviceModel.resource.contents.get(0) as ServiceModel
            val dataModelAlias = serviceModelRoot.imports
                .findFirst[importURI == intermediateDataModel.outputPath]
                .name

            val refinedModelTargetFolder = LemmaUtils.removeExtension(serviceModel.outputPath)
            val refinedModelName = new File(intermediateDataModel.outputPath).name
            val prefixedRefinedModelName = '''«dataModelAlias»_«refinedModelName»'''
            return LemmaUtils.joinPathSegments(refinedModelTargetFolder, prefixedRefinedModelName)
        }
    }
}