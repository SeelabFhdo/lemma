package de.fhdo.ddmm.intermediate.transformations

import org.eclipse.emf.ecore.resource.Resource
import java.util.Map
import org.eclipse.m2m.atl.core.emf.EMFInjector
import org.eclipse.m2m.atl.core.emf.EMFModelFactory
import org.eclipse.m2m.atl.core.IModel
import org.eclipse.m2m.atl.core.emf.EMFModel
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher
import org.eclipse.m2m.atl.core.launch.ILauncher
import org.eclipse.core.runtime.NullProgressMonitor

/**
 * Abstract strategy for model-to-model transformations with one input and one output model relying
 * on ATL.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
abstract class AbstractAtlInputOutputIntermediateModelTransformationStrategy
    extends AbstractIntermediateModelTransformationStrategy<IModel, EMFModel> {
    var EMFInjector atlModelInjector
    var EMFModelFactory atlModelFactory
    var Pair<TransformationModelDescription, TransformationModelType> inputModelTypeDescription
    var Pair<TransformationModelDescription, TransformationModelType> outputModelTypeDescription

    /**
     * Get reference name and transformation model type of input model
     */
    abstract def Pair<String, TransformationModelType> getInputModelReferenceNameAndType()

    /**
     * Get reference name and transformation model type of output model
     */
    abstract def Pair<String, TransformationModelType> getOutputModelReferenceNameAndType()

    /**
     * Get path to the compiled ATL transformation file
     */
    abstract def String getCompiledModelTransformationFilePath()

    /**
     * Constructor
     */
    new () {
        super()

        atlModelFactory = new EMFModelFactory
        atlModelInjector = new EMFInjector
    }

    /**
     * Register input and output model types. This also creates the corresponding descriptions of
     * the model types with directions IN and OUT, respectively.
     */
    final override registerModelTypes() {
        inputModelTypeDescription =
            new TransformationModelDescription(
                "IN",
                inputModelReferenceNameAndType.key,
                TransformationModelDirection.IN
            ) -> inputModelReferenceNameAndType.value

        outputModelTypeDescription =
            new TransformationModelDescription(
                "OUT",
                outputModelReferenceNameAndType.key,
                TransformationModelDirection.OUT
            ) -> outputModelReferenceNameAndType.value

        val descriptions = <TransformationModelDescription, TransformationModelType>newLinkedHashMap
        descriptions.put(inputModelTypeDescription.key, inputModelTypeDescription.value)
        descriptions.put(outputModelTypeDescription.key, outputModelTypeDescription.value)
        return descriptions
    }

    /**
     * Create transformation-technology-specific input model instance
     */
    override protected createTransformationInputModel(
        TransformationModelDescription modelDescription,
        Resource resource
    ) {
        val inputModelNamespaceUri = inputModelTypeDescription.value.namespaceUri
        val inputMetamodel = atlModelFactory.newReferenceModel
        atlModelInjector.inject(inputMetamodel, inputModelNamespaceUri)

        val inputModel = atlModelFactory.newModel(inputMetamodel)
        atlModelInjector.inject(inputModel, resource)
        return inputModel
    }

    /**
     * Create transformation-technology-specific output model instance
     */
    override protected createTransformationOutputModel(
        TransformationModelDescription modelDescription,
        String outputPath
    ) {
        val outputModelNamespaceUri = outputModelTypeDescription.value.namespaceUri
        val outputMetamodel = atlModelFactory.newReferenceModel
        atlModelInjector.inject(outputMetamodel, outputModelNamespaceUri)
        return atlModelFactory.newModel(outputMetamodel) as EMFModel
    }

    /**
     * Execute ATL transformation
     */
    override protected transformation(
        Map<TransformationModelDescription, IModel> transformationInputModels,
        Map<TransformationModelDescription, EMFModel> transformationOutputModels
    ) {
        val atlLauncher = new EMFVMLauncher
        atlLauncher.initialize(emptyMap())

        val inputModel = transformationInputModels.values.get(0)
        val inputModelDescription = inputModelTypeDescription.key
        atlLauncher.addInModel(
            inputModel,
            inputModelDescription.nameInModelTransformation,
            inputModelDescription.referenceModelName
        )

        val outputModel = transformationOutputModels.values.get(0)
        val outputModelDescription = outputModelTypeDescription.key
        atlLauncher.addOutModel(
            outputModel,
            outputModelDescription.nameInModelTransformation,
            outputModelDescription.referenceModelName
        )

        val launchOptions = #{"allowInterModelReferences" -> true as Object}
        val compiledModelTransformation =
            typeof(AbstractAtlInputOutputIntermediateModelTransformationStrategy)
                .getResourceAsStream(getCompiledModelTransformationFilePath())
        atlLauncher.launch(
            ILauncher.RUN_MODE,
            new NullProgressMonitor(),
            launchOptions,
            compiledModelTransformation
        )

        return #{outputModelDescription -> outputModel.resource}
    }
}