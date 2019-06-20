package de.fhdo.ddmm.intermediate.transformations

import org.eclipse.m2m.atl.emftvm.Model
import org.eclipse.emf.ecore.resource.Resource
import java.util.Map
import org.eclipse.m2m.atl.emftvm.ExecEnv
import org.eclipse.m2m.atl.emftvm.EmftvmFactory
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceFactoryImpl
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver
import org.eclipse.m2m.atl.emftvm.util.TimingData

/**
 * Abstract strategy for model-to-model transformations relying on ATL's EMFTVM.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
abstract class AbstractEmftvmIntermediateModelTransformationStrategy
    extends AbstractIntermediateModelTransformationStrategy<Model, Model> {
    EmftvmFactory emftvmFactory
    ExecEnv executionEnvironment
    ResourceSet resourceSet

    // With EMFTVM it is possible that refining transformations do not yield an output model as
    // specified in the preamble of the transformation model file. Instead, the output model is
    // created as a partial copy of the specified input model, i.e., in the form of an inout model.
    // That is, all output and inout model types are candidates for producing potential output
    // models.
    Map<TransformationModelDescription, Model> potentialOutputModels = newHashMap

    /**
     * Get the platform path to the folder that holds the transformation model file
     */
    abstract def String getModelTransformationFilePlatformFolder()

    /**
     * Get the name of the transformation model file
     */
    abstract def String getModelTransformationFileName()

    /**
     * Constructor
     */
    new() {
        super()

        emftvmFactory = EmftvmFactory.eINSTANCE
        executionEnvironment = emftvmFactory.createExecEnv()
        resourceSet = setupResourceSet
    }

    /**
     * Helper to create the resource set used by the transformation
     */
    private def ResourceSet setupResourceSet() {
        val rs = new ResourceSetImpl()

        val extensionToFactoryMap = rs.getResourceFactoryRegistry().getExtensionToFactoryMap()
        extensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl())
        extensionToFactoryMap.put("emftvm", new EMFTVMResourceFactoryImpl())
        extensionToFactoryMap.put("ecore", new EcoreResourceFactoryImpl())

        return rs
    }

    /**
     * Prepare model transformation
     */
    override protected beforeTransformationHook(
        Map<TransformationModelDescription, String> absoluteInputModelPaths
    ) {
        /*
         * Register metamodels of a concrete transformation's model types to EMFTVM's execution
         * environment
         */
        val modelDescriptions = absoluteInputModelPaths.keySet
        val registeredMetamodels = <String>newHashSet
        modelDescriptions.forEach[
            val modelType = modelTypes.get(it)
            val namespaceUri = modelType.namespaceUri

            if (!registeredMetamodels.contains(namespaceUri)) {
                val metamodel = EmftvmFactory.eINSTANCE.createMetamodel()
                metamodel.resource = modelType.ecorePackage.eResource
                executionEnvironment.registerMetaModel(referenceModelName, metamodel)
                registeredMetamodels.add(namespaceUri)
            }
        ]
    }

    /**
     * Create transformation-technology-specific input model instance
     */
    override protected createTransformationInputModel(
        TransformationModelDescription modelDescription,
        Resource resource
    ) {
        val model = emftvmFactory.createModel()
        model.setResource(resource)

        if (modelDescription.direction === TransformationModelDirection.INOUT)
            potentialOutputModels.put(modelDescription, model)

        return model
    }

    /**
     * Create transformation-technology-specific output model instance
     */
    override protected createTransformationOutputModel(
        TransformationModelDescription modelDescription,
        String outputPath
    ) {
        // The map of potential output models may already contain an entry in case of inout
        // transformation model descriptions
        return if (!potentialOutputModels.containsKey(modelDescription)) {
            val model = EmftvmFactory.eINSTANCE.createModel()
            model.setResource(resourceSet.createResource(URI.createURI(outputPath)))
            potentialOutputModels.put(modelDescription, model)
            model
        } else
            null
    }

    /**
     * Execute EMFTVM transformation
     */
    override protected transformation(
        Map<TransformationModelDescription, Model> transformationInputModels,
        Map<TransformationModelDescription, Model> transformationOutputModels
    ) {
        registerModels(transformationInputModels)
        registerModels(transformationOutputModels)

        val moduleResolver = new DefaultModuleResolver(modelTransformationFilePlatformFolder,
            resourceSet)
        val timingData = new TimingData()
        executionEnvironment.loadModule(moduleResolver, modelTransformationFileName)
        timingData.finishLoading()
        executionEnvironment.run(timingData)
        timingData.finish()

        // Return only non-empty output model resources
        return potentialOutputModels
            .filter[description, model |
                if (model.resource?.contents !== null) !model.resource.contents.empty else false
            ]
            .mapValues[resource]
    }

    /**
     * Helper to register models and their descriptions in EMFTVM's execution environment
     */
    private def registerModels(Map<TransformationModelDescription, Model> models) {
        models.forEach[description, model |
            registerModel(description.nameInModelTransformation, description.direction, model)
        ]
    }

    /**
     * Helper to register a single model in EMFTVM's execution environment
     */
    private def registerModel(
        String nameInModelTransformation,
        TransformationModelDirection direction,
        Model model
    ) {
        switch (direction) {
            case TransformationModelDirection.IN:
                executionEnvironment.registerInputModel(nameInModelTransformation, model)
            case TransformationModelDirection.OUT:
                executionEnvironment.registerOutputModel(nameInModelTransformation, model)
            case TransformationModelDirection.INOUT:
                executionEnvironment.registerInOutModel(nameInModelTransformation, model)
        }
    }
}