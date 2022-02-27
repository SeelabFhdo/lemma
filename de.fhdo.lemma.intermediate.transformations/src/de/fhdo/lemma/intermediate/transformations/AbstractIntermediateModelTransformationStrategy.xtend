package de.fhdo.lemma.intermediate.transformations

import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.core.resources.IFile
import java.util.Set
import com.google.common.base.Predicate
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.EPackage
import java.util.List
import java.util.LinkedHashMap
import org.eclipse.xtend.lib.annotations.Accessors
import de.fhdo.lemma.utils.LemmaUtils

/**
 * Abstract strategy for model-to-model transformations of input to intermediate output models. The
 * type parameters are dependent on the concrete transformation technology.
 *   - TIM_TYPE: Type of input models in the employed transformation technology, e.g.,
 *               org.eclipse.m2m.atl.emftvm.Model for ATL transformations based on EMFTVM.
 *   - TOM_TYPE: Type of output models in the employed transformation technology, e.g.,
 *               org.eclipse.m2m.atl.emftvm.Model for ATL transformations based on EMFTVM.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
abstract class AbstractIntermediateModelTransformationStrategy<TIM_TYPE, TOM_TYPE> {
    protected LinkedHashMap<TransformationModelDescription, TransformationModelType> modelTypes

    /**
     * Register model types, i.e., URIs, EPackages, and root classes, together with their
     * transformation-specific descriptions, i.e., names in model transformations and directions
     */
    abstract def LinkedHashMap<TransformationModelDescription, TransformationModelType>
        registerModelTypes()

    /**
     * Before transformation hook (optional)
     */
    protected def void beforeTransformationHook(
        Map<TransformationModelDescription, IFile> inputModelFiles,
        Map<TransformationModelDescription, String> outputModelPaths
    ) {}

    /**
     * Prepare an input model (optional)
     */
    protected def void prepareInputModel(TransformationModelDescription modelDescription,
        EObject modelRoot) {}

    /**
     * Get validator for input model (optional)
     */
    protected def AbstractInputModelValidator getInputModelValidator(
        TransformationModelDescription modelDescription
    ) {
        return null
    }

    /**
     * Create transformation-technology-specific input model instance
     */
    abstract protected def TIM_TYPE createTransformationInputModel(
        TransformationModelDescription modelDescription,
        Resource resource
    )

    /**
     * Create transformation-technology-specific output model instance
     */
    abstract protected def TOM_TYPE createTransformationOutputModel(
        TransformationModelDescription modelDescription,
        String outputPath
    )

    /**
     * Execute transformation leveraging a certain transformation technology
     */
    abstract protected def Map<TransformationModelDescription, Resource> transformation(
        Map<TransformationModelDescription, TIM_TYPE> transformationInputModels,
        Map<TransformationModelDescription, TOM_TYPE> transformationOutputModels
    )

    /**
     * Flag to indicate if children's children of the current model file, i.e., models that are
     * imported by imported models of the current model, shall be considered when building the
     * target paths of imports for the subsequent call to transformation().
     */
    def boolean considerChildrensChildrenForImportTargetPaths() {
        return false
    }

    /**
     * Add transformation target paths of imported model files to output model
     */
    protected def void populateOutputModelWithImportTargetPaths(
        TransformationModelDescription modelDescription,
        EObject modelRoot,
        Map<String, String> targetPaths
    ) {}

    /**
     * Modify an output model (optional)
     */
    protected def void modifyOutputModel(
        TransformationModelDescription modelDescription,
        EObject modelRoot
    ) {}

    /**
     * After transformation hook (optional)
     */
    protected def void afterTransformationHook(
        Map<TransformationModelDescription, String> outputModelPaths
    ) {}

    /**
     * Register a listener to be invoked after all transformations of a transformation run triggered
     * by the user were done. This enables a transformation strategy to refer to all results of a
     * transformation run. This can for instance be helpful, if subsequent refining transformations
     * need to be run that also depend on other models produced during the transformation run.
     *
     * A listener is a function of the following form:
     *   Void listener(List<TransformationResult>, Predicate<IntermediateTransformationException>)
     * It takes all results produced by the transformation run as input, as well as a callback
     * predicate for warnings that may occur within the listener.
     *
     * See MappingModelTransformation for a usage example of a listener.
     */
    def (List<TransformationResult>, Predicate<IntermediateTransformationException>)
        =>List<TransformationResult>
    registerTransformationsFinishedListener() {
        return null
    }

    /**
     * Convert URIs in a transformation result to relative ones (optional)
     */
    def void makeUrisRelative(TransformationResult result) {}

    /**
     * Constructor
     */
    new() {
        modelTypes = registerModelTypes
        if (modelTypes === null || modelTypes.empty)
            throw new IllegalStateException("Model types must not be empty")

        // Register EPackages of output models
        val outputModelTypes = modelTypes.filter [ description, value |
            description.direction == TransformationModelDirection.INOUT ||
                description.direction == TransformationModelDirection.OUT
        ].values.toList()
        registerEPackages(outputModelTypes)
    }

    /**
     * Helper to register EPackages of a given list of model types
     */
    private def registerEPackages(List<TransformationModelType> modelTypes) {
        modelTypes.forEach [
            if (!EPackage.Registry.INSTANCE.containsKey(namespaceUri))
                EPackage.Registry.INSTANCE.put(namespaceUri, ecorePackage)
        ]
    }

    /**
     * Get registered output model types
     */
    final def List<TransformationModelType> getOutputModelTypes() {
        return modelTypes.filter [ description, type |
            description.direction === TransformationModelDirection.OUT ||
                description.direction === TransformationModelDirection.INOUT
        ].values.toList()
    }

    /**
     * Run a model-to-model transformation on a list of input models expressed as instances of
     * org.eclipse.core.resources.IFile. To this end, the transformation model description for each
     * input model is also passed by the caller.
     */
    final def Map<TransformationModelDescription, TransformationResult> doTransformationFromFiles(
        Map<TransformationModelDescription, IFile> inputModelFiles,
        Map<TransformationModelDescription, String> outputModelPaths,
        Map<String, Map<String, String>> targetPathsOfImports,
        Predicate<IntermediateTransformationException> warningCallback
    ) {
        val inputModelResources = loadModelResources(inputModelFiles)
        return doTransformation(inputModelFiles, inputModelResources, outputModelPaths,
            targetPathsOfImports, warningCallback)
    }

    /**
     * Helper to load Resource instances of models being expressed as IFile instances
     */
    private def Map<TransformationModelDescription, Resource> loadModelResources(
        Map<TransformationModelDescription, IFile> models
    ) {
        val loadedModels = <TransformationModelDescription, Resource>newHashMap

        models.forEach [ description, file |
            val fileExtension = file.fileExtension?.toLowerCase
            if (fileExtension === null || fileExtension.isEmpty)
                throw new IllegalArgumentException(
                    '''File «LemmaUtils.getAbsolutePath(file)» does not have a file extension. ''' +
                        "It can thus not be loaded as a model Resource. Model transformation not " +
                        "possible.")

            val modelResource = if ("xmi".equals(fileExtension))
                    loadModelResourceFromXmiFile(file)
                else
                    loadModelResourceFromDslFile(file)

            loadedModels.put(description, modelResource)
        ]

        return loadedModels
    }

    /**
     * Helper to load a model Resource from an XMI file
     */
    private def loadModelResourceFromXmiFile(IFile modelFile) {
        val projectRelativeModelFilePath = modelFile.fullPath.toString
        val modelFileUri = URI.createURI(projectRelativeModelFilePath)
        val resourceSet = new ResourceSetImpl()
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
            .put("xmi", new XMIResourceFactoryImpl())
        val resource = resourceSet.createResource(modelFileUri);
        resource.load(null)
        return resource
    }

    /**
     * Helper to load a model Resource from a DSL file
     */
    private def loadModelResourceFromDslFile(IFile modelFile) {
        val projectRelativeDslFilePath = modelFile.fullPath.toString
        val inputDslFileUri = URI.createURI(projectRelativeDslFilePath)
        val resourceSetProvider = IResourceServiceProvider.Registry.INSTANCE
            .getResourceServiceProvider(inputDslFileUri)
        return resourceSetProvider.get(ResourceSet).getResource(inputDslFileUri, true)
    }

    /**
     * Run a model-to-model transformation on a list of input models expressed as instances of
     * org.eclipse.core.resources.IFile and a list of output paths. The transformation model
     * descriptions are assigned to input files and output paths in the order they were registered
     * in the implementation of registerModelTypes().
     */
    final def Map<TransformationModelDescription, TransformationResult> doTransformationFromFiles(
        List<IFile> inputModels,
        List<String> outputModelPaths,
        Map<String, Map<String, String>> targetPathsOfImports,
        Predicate<IntermediateTransformationException> warningCallback
    ) {
        val inputModelsWithDescriptions = mapValuesToModelTypeDescriptions(inputModels,
            "input model", TransformationModelDirection.IN, TransformationModelDirection.INOUT)

        val outputModelsWithDescriptions = mapValuesToModelTypeDescriptions(outputModelPaths,
            "output model", TransformationModelDirection.OUT, TransformationModelDirection.INOUT)

        return doTransformationFromFiles(inputModelsWithDescriptions, outputModelsWithDescriptions,
            targetPathsOfImports, warningCallback)
    }

    /**
     * Helper to assign input or output models/paths to registered transformation model descriptions
     * of a given set of directions
     */
    private def <T> Map<TransformationModelDescription, T> mapValuesToModelTypeDescriptions(
        List<T> values,
        String valueTypeName,
        TransformationModelDirection... filterDirections
    ) {
        val registeredDescriptions = modelTypes.keySet.filter[filterDirections.contains(direction)]
        if (values.size != registeredDescriptions.size)
            throw new IllegalArgumentException('''«valueTypeName.toFirstUpper» count must be ''' +
                '''equal to «valueTypeName.toFirstLower» description count''')

        val valuesToDescriptions = <TransformationModelDescription, T>newHashMap
        for (var i = 0; i < registeredDescriptions.size; i++)
            valuesToDescriptions.put(registeredDescriptions.get(i), values.get(i))

        return valuesToDescriptions
    }

    /**
     * Run a model-to-model transformation on a list of input models expressed as instances of
     * org.eclipse.emf.ecore.resource.Resource. To this end, the transformation model description
     * for each input model is also passed by the caller.
     */
    final def Map<TransformationModelDescription, TransformationResult>
    doTransformationFromResources(
        Map<TransformationModelDescription, Resource> inputModelResources,
        Map<TransformationModelDescription, String> outputModelPaths,
        Map<String, Map<String, String>> targetPathsOfImports,
        Predicate<IntermediateTransformationException> warningCallback
    ) {
        val inputModelFiles = inputModelResources.mapValues[LemmaUtils.getFileForResource(it)]
        return doTransformation(inputModelFiles, inputModelResources, outputModelPaths,
            targetPathsOfImports, warningCallback)
    }

    /**
     * Generic method for running a model-to-model transformation. The input models are expressed
     * on the basis of two maps that assign the transformation model descriptions to the input model
     * files and resources, respectively.
     */
    private def Map<TransformationModelDescription, TransformationResult> doTransformation(
        Map<TransformationModelDescription, IFile> inputModelFiles,
        Map<TransformationModelDescription, Resource> inputModelResources,
        Map<TransformationModelDescription, String> outputModelPaths,
        Map<String, Map<String, String>> targetPathsOfImports,
        Predicate<IntermediateTransformationException> warningCallback
    ) {
        beforeTransformationChecks(inputModelFiles, outputModelPaths)

        beforeTransformationHook(inputModelFiles, outputModelPaths)

        val preparedInputModels = prepareInputModels(inputModelResources)

        if (!validateInputModels(inputModelFiles, preparedInputModels, warningCallback))
            return null

        val transformationResultResources = executeTransformation(preparedInputModels,
            outputModelPaths)

        if (targetPathsOfImports !== null)
            populateOutputModelsWithImportTargetPaths(
                transformationResultResources,
                outputModelPaths,
                targetPathsOfImports
            )

        modifyOutputModels(transformationResultResources)

        afterTransformationHook(outputModelPaths)

        saveOutputModels(transformationResultResources, outputModelPaths)

        return createTransformationResults(inputModelFiles, transformationResultResources,
            outputModelPaths)
    }

    /**
     * Helper to perform generic checks on input and output models/paths
     */
    private def beforeTransformationChecks(Map<TransformationModelDescription, IFile> inputModels,
        Map<TransformationModelDescription, String> outputModelPaths) {
        inputModels.keySet.checkContainsDescriptionsForAllRegisteredModelTypesOfDirection(
            TransformationModelDirection.IN
        )

        outputModelPaths.keySet.checkContainsDescriptionsForAllRegisteredModelTypesOfDirection(
            TransformationModelDirection.OUT
        )

        // Inout models may be specified in input or output models
        try {
            inputModels.keySet.checkContainsDescriptionsForAllRegisteredModelTypesOfDirection(
                TransformationModelDirection.INOUT
            )
        } catch (IllegalArgumentException ex) {
            outputModelPaths.keySet.checkContainsDescriptionsForAllRegisteredModelTypesOfDirection(
                TransformationModelDirection.INOUT
            )
        }
    }

    /**
     * Helper to check that a set of transformation model descriptions contains a description for
     * each registered model type of a certain direction
     */
    private def checkContainsDescriptionsForAllRegisteredModelTypesOfDirection(
        Set<TransformationModelDescription> descriptions,
        TransformationModelDirection direction
    ) {
        val registeredModelDescriptions = modelTypes.keySet.filter[it.direction == direction].toSet
        if (!descriptions.containsAll(registeredModelDescriptions))
            throw new IllegalArgumentException("Missing values for registered model types of " +
                '''direction «direction»''')
    }

    /**
     * Helper to iteratively trigger preparation on a set of input models
     */
    private def Map<TransformationModelDescription, Resource> prepareInputModels(
        Map<TransformationModelDescription, Resource> inputModels
    ) {
        val preparedModels = <TransformationModelDescription, Resource>newHashMap

        inputModels.forEach [ description, resource |
            val modelRoot = resource.contents.get(0)
            prepareInputModel(description, modelRoot)
            preparedModels.put(description, resource)
        ]

        return preparedModels
    }

    /**
     * Helper to iteratively validate a set of input models
     */
    private def boolean validateInputModels(
        Map<TransformationModelDescription, IFile> inputModelDescriptions,
        Map<TransformationModelDescription, Resource> inputModelResources,
        Predicate<IntermediateTransformationException> warningCallback
    ) {
        var continueTransformation = true
        for (var i = 0; i < inputModelDescriptions.size && continueTransformation; i++) {
            val description = inputModelDescriptions.keySet.get(i)
            val file = inputModelDescriptions.get(description)
            val resource = inputModelResources.get(description)
            val modelRoot = resource.contents.get(0)
            val modelValidator = getInputModelValidator(description)

            continueTransformation = if (modelValidator !== null)
                modelValidator.validateInputModel(LemmaUtils.getAbsolutePath(file), modelRoot,
                    warningCallback)
            else
                true
        }

        return continueTransformation
    }

    /**
     * Helper to execute a model-to-model-transformation
     */
    private def Map<TransformationModelDescription, Resource> executeTransformation(
        Map<TransformationModelDescription, Resource> inputModelResources,
        Map<TransformationModelDescription, String> outputModelPaths
    ) {
        /* Create transformation-technology-specific input and output models */
        val transformationInputModels = <TransformationModelDescription, TIM_TYPE>newHashMap
        inputModelResources.forEach [ description, resource |
            val inputModel = createTransformationInputModel(description, resource)
            if (inputModel !== null)
                transformationInputModels.put(description, inputModel)
        ]

        val transformationOutputModels = <TransformationModelDescription, TOM_TYPE>newHashMap
        outputModelPaths.forEach [ description, path |
            val outputModel = createTransformationOutputModel(description, path)
            if (outputModel !== null)
                transformationOutputModels.put(description, outputModel)
        ]

        /*
         * Invoke technology-specific transformation of an implemented model-to-model transformation
         * strategy
         */
        val transformationResultResources = transformation(
            transformationInputModels,
            transformationOutputModels
        )

        // Warn if the transformation did not produce any result
        if (transformationResultResources.empty)
            throw new IntermediateTransformationException("No elements were created during " +
                "model transformation", IntermediateTransformationExceptionKind.WARNING,
                IntermediateTransformationPhase.TRANSFORMATION_FINISHED)

        // Warn if one of the expected output models is empty
        val emptyOutputModel = transformationResultResources.entrySet.findFirst [
            value === null || value.contents.empty
        ]
        if (emptyOutputModel !== null) {
            val outputModelPath = outputModelPaths.get(emptyOutputModel.key)
            throw new IntermediateTransformationException("No elements were created in output " +
                '''model file «outputModelPath».''', IntermediateTransformationExceptionKind.WARNING,
                IntermediateTransformationPhase.TRANSFORMATION_FINISHED)
        }

        return transformationResultResources
    }

    /**
     * Helper to add transformation target paths of imported model files to all output models
     */
    private def populateOutputModelsWithImportTargetPaths(
        Map<TransformationModelDescription, Resource> outputModelResources,
        Map<TransformationModelDescription, String> outputModelPaths,
        Map<String, Map<String, String>> targetPathsOfImports
    ) {
        outputModelResources.forEach[description, resource |
            val outputPath = outputModelPaths.get(description)
            val targetPaths = targetPathsOfImports.get(outputPath)
            if (targetPaths !== null)
                populateOutputModelWithImportTargetPaths(description, resource.contents.get(0),
                    targetPaths)
        ]
    }

    /**
     * Helper to iteratively trigger modifications of output models
     */
    private def modifyOutputModels(
        Map<TransformationModelDescription, Resource> outputModelResources
    ) {
        outputModelResources.forEach[description, resource |
            val modelRoot = resource.contents.get(0)
            modifyOutputModel(description, modelRoot)
        ]
    }

    /**
     * Serialize all output model resources into XMI files
     */
    private def void saveOutputModels(
        Map<TransformationModelDescription, Resource> outputModelResources,
        Map<TransformationModelDescription, String> outputModelPaths
    ) {
        outputModelResources.forEach[description, resource |
            val outputPath = outputModelPaths.get(description)
            resource.URI = URI.createURI(outputPath)
            resource.save(emptyMap())
        ]
    }

    /**
     * Create TransformationResult instances from transformation parameters. For each output model
     * resource, a TransformationResult is created.
     */
    private def Map<TransformationModelDescription, TransformationResult>
    createTransformationResults(
        Map<TransformationModelDescription, IFile> inputModels,
        Map<TransformationModelDescription, Resource> outputModelResources,
        Map<TransformationModelDescription, String> outputModelPaths
    ) {
        val resultMap = <TransformationModelDescription, TransformationResult>newHashMap

        outputModelResources.forEach[description, resource |
            val outputPath = outputModelPaths.get(description)
            val transformationResult = createTransformationResult(inputModels, outputPath,
                description, resource)
            resultMap.put(description, transformationResult)
        ]

        return resultMap
    }

    /**
     * Helper to create a TransformationResult instance
     */
    private def TransformationResult createTransformationResult(
        Map<TransformationModelDescription, IFile> inputModels,
        String outputPath,
        TransformationModelDescription outputModelDescription,
        Resource outputResource
    ) {
        val resultInputModels = inputModels.entrySet.map [
            new InputModel(LemmaUtils.getAbsolutePath(value), modelTypes.get(key).namespaceUri,
                value)
        ].toList

        val outputModel = new OutputModel(
            outputPath,
            modelTypes.get(outputModelDescription).namespaceUri,
            outputResource
        )

        return new TransformationResult(resultInputModels, outputModel)
    }

    /**
     * Class representing a result of a model-to-model transformation. It maps input models to a
     * certain output model.
     */
    static class TransformationResult {
        @Accessors
        List<InputModel> inputModels

        @Accessors
        OutputModel outputModel

        new(List<InputModel> inputModels, OutputModel outputModel) {
            this.inputModels = inputModels
            this.outputModel = outputModel
        }
    }

    /**
     * Class representing an input model of a model-to-model transformation
     */
    static class InputModel {
        @Accessors
        String inputPath

        @Accessors
        String namespaceUri

        @Accessors
        IFile file

        new(String inputPath, String namespaceUri, IFile file) {
            this.inputPath = inputPath
            this.namespaceUri = namespaceUri
            this.file = file
        }
    }

    /**
     * Class representing an output model of a model-to-model transformation
     */
    static class OutputModel {
        @Accessors
        String outputPath

        @Accessors
        String namespaceUri

        @Accessors
        Resource resource

        new(String outputPath, String namespaceUri, Resource resource) {
            this.outputPath = outputPath
            this.namespaceUri = namespaceUri
            this.resource = resource
        }
    }
}
