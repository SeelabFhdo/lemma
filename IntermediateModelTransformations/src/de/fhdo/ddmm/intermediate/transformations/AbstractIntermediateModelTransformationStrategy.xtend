package de.fhdo.ddmm.intermediate.transformations

import org.eclipse.m2m.atl.core.emf.EMFInjector
import org.eclipse.m2m.atl.core.emf.EMFModelFactory
import org.eclipse.emf.ecore.EPackage
import org.eclipse.core.resources.IFile
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.m2m.atl.core.emf.EMFModel
import org.eclipse.m2m.atl.core.IModel
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.m2m.atl.core.launch.ILauncher
import java.util.Map
import com.google.common.base.Predicate
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import com.google.common.base.Function

/**
 * Abstract strategy for model-to-model transformations of DDMM-related source to intermediate
 * target models.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
abstract class AbstractIntermediateModelTransformationStrategy {
    var EMFInjector atlModelInjector
    var EMFModelFactory atlModelFactory
    var String targetModelUri
    var EPackage targetModelPackage

    /**
     * Get information like URI, EPackage, and root class of the target intermediate metamodel
     */
    abstract def TargetModelInfo getTargetModelInfo()

    /**
     * Before transformation hook (optional)
     */
    protected def void beforeTransformationHook(String absoluteSourceModelPath) {}

    /**
     * Prepare source model (optional)
     */
    protected def void prepareSourceModel(EObject modelRoot) {}

    /**
     * Get validator for source model. Optional, may return null.
     */
    protected def AbstractSourceModelValidator getSourceModelValidator() {
        return null
    }

    /**
     * Get project-relative path to compiled ATL model transformation file
     */
    abstract protected def String getCompiledModelTransformationFilePath()

    /**
     * Get namespace URI of the source metamodel's EPackage
     */
    abstract protected def String getSourcePackageNamespaceUri()

    /**
     * Get prefix of source model in ATL transformation file
     */
    abstract protected def String getTransformationSourceModelPrefix()

    /**
     * Get prefix of target model in ATL transformation file
     */
    abstract protected def String getTransformationTargetModelPrefix()

    /**
     * Add transformation target paths of imported model files to target model
     */
    abstract protected def void populateTargetModelWithImportTargetPaths(EMFModel targetModel,
        Map<String, String> targetPaths)

    /**
     * Modify target model (optional)
     */
    protected def void modifyTargetModel(EObject modelRoot) {}

    /**
     * After transformation hook (optional)
     */
    protected def void afterTransformationHook(String absoluteSourceModelPath) {}

    /**
     * Constructor
     */
    new() {
        atlModelFactory = new EMFModelFactory
        atlModelInjector = new EMFInjector

        targetModelUri = targetModelInfo.namespaceUri
        targetModelPackage = targetModelInfo.ecorePackage
        registerTargetModelEPackage()
    }

    /**
     * Flag to indicate if children's children of the current model file, i.e., models that are
     * imported by imported models of the current model, shall be considered when building the
     * target paths of imports for the subsequent call to mainTransformation().
     */
    def considerChildrensChildrenForImportTargetPaths() {
        return false
    }

    /**
     * Perform the model-to-model-transformation of a source model, being specified in a specific
     * DSL file, to an intermediate model in the form of an XMI file
     */
    def mainTransformation(IFile sourceModelFile, String targetModelFile,
        Map<String, String> targetPathsOfImports,
        Predicate<IntermediateTransformationException> warningCallback) {
        doTransformation(sourceModelFile, [loadDslSourceModel], targetModelFile,
            targetPathsOfImports, warningCallback)
    }

     /**
     * Perform a refining model transformation of a source XMI model to a more specific target XMI
     * model
     */
    def refiningTransformation(IFile sourceModelFile, String targetModelFile,
        Predicate<IntermediateTransformationException> warningCallback) {
        doTransformation(sourceModelFile, [loadXmiSourceModel], targetModelFile, null,
            warningCallback)
    }

    /**
     * Generic helper to perform a model transformation on the given source model file that gets
     * loaded by a model-format-specific loader
     */
    private def doTransformation(IFile sourceModelFile, Function<IFile, Resource> sourceModelLoader,
        String targetModelFile, Map<String, String> targetPathsOfImports,
        Predicate<IntermediateTransformationException> warningCallback) {
        /* Before transformation hook */
        val absoluteSourceModelPath = sourceModelFile.rawLocation.makeAbsolute.toString
        beforeTransformationHook(absoluteSourceModelPath)

        /* Prepare source model */
        val sourceModelResource = sourceModelLoader.apply(sourceModelFile)
        val sourceModelRoot = sourceModelResource.contents.get(0)
        prepareSourceModel(sourceModelRoot)

        /* Validate prepared source model */
        val sourceModelValidator = getSourceModelValidator()
        val continueWithTransformation = if (sourceModelValidator !== null)
                sourceModelValidator.validateSourceModel(absoluteSourceModelPath, sourceModelRoot,
                    warningCallback)
            else
                true
        if (!continueWithTransformation) {
            return
        }

        /* Perform transformation */
        val sourceTransformationModel = createTransformationSourceModel(sourceModelResource)
        val targetModel = createEmptyTargetModel
        launchTransformation(sourceTransformationModel, targetModel)
        if (targetModel.resource === null || targetModel.resource.contents.empty)
            throw new IntermediateTransformationException('''No elements created in ''' +
                '''transformation of "«sourceModelFile.location»". Target model file ''' +
                '''"«targetModelFile»" was not written.''',
                IntermediateTransformationExceptionKind.WARNING,
                IntermediateTransformationPhase.TRANSFORMATION_FINISHED)

        if (targetPathsOfImports !== null && !targetPathsOfImports.empty)
            populateTargetModelWithImportTargetPaths(targetModel, targetPathsOfImports)

        /* Modify target model */
        val targetModelRoot = targetModel.resource.contents.get(0)
        modifyTargetModel(targetModelRoot)

        /* After transformation hook */
        afterTransformationHook(targetModelFile)

        // Store transformation result in XMI file
        targetModel.resource.URI = URI.createURI(targetModelFile)
        targetModel.resource.save(emptyMap())
    }

    /**
     * Register the EPackage of the target metamodel. Otherwise, ATL won't find it, when the
     * transformation gets launched.
     */
    private def registerTargetModelEPackage() {
        if (EPackage.Registry.INSTANCE.containsKey(targetModelUri)) {
            return
        }

        EPackage.Registry.INSTANCE.put(targetModelUri, targetModelPackage)
    }

    /**
     * Load a source model from a DSL file
     */
    private def loadDslSourceModel(IFile dslFile) {
        val projectRelativeDslFilePath = dslFile.fullPath.toString
        val sourceDslFileUri = URI.createURI(projectRelativeDslFilePath)
        val sourceDslFileResourceSet = createResourceSetFor(sourceDslFileUri)
        val sourceDslFileResource = sourceDslFileResourceSet.getResource(sourceDslFileUri, true)
        return sourceDslFileResource
    }

    /**
     * Load a source model from an XMI file
     */
    private def loadXmiSourceModel(IFile modelFile) {
        val projectRelativeSourceModelFilePath = modelFile.fullPath.toString
        val sourceModelFileUri = URI.createURI(projectRelativeSourceModelFilePath)
        val resourceSet = new ResourceSetImpl()
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
            .put("xmi", new XMIResourceFactoryImpl())
        val resource = resourceSet.createResource(sourceModelFileUri);
        resource.load(null)
        return resource
    }

    /**
     * Helper to create ResourceSet for file
     */
    private static def createResourceSetFor(URI fileUri) {
        val resourceSetProviderRegistry = IResourceServiceProvider.Registry.INSTANCE
        val resourceSetProvider = resourceSetProviderRegistry.getResourceServiceProvider(fileUri)
        return resourceSetProvider.get(ResourceSet)
    }

    /**
     * Load a source model from a DSL file resource
     */
    private def createTransformationSourceModel(Resource sourceModelResource) {
        val sourceDslMetamodelReference = createSourceDslMetamodelReference()
        val sourceModel = atlModelFactory.newModel(sourceDslMetamodelReference)
        atlModelInjector.inject(sourceModel, sourceModelResource)
        return sourceModel
    }

    /**
     * Create an IReferenceModel instance for the Xcore metamodel of the source DSL leveraging
     * ATL's model factory
     */
    private def createSourceDslMetamodelReference() {
        val sourceDslMetamodelReference = atlModelFactory.newReferenceModel
        atlModelInjector.inject(sourceDslMetamodelReference, getSourcePackageNamespaceUri())
        return sourceDslMetamodelReference
    }

    /**
     * Create an EMFModel instance for the Xcore metamodel of the target models leveraging ATL's
     * model factory
     */
    private def createEmptyTargetModel() {
        val targetMetamodelReference = atlModelFactory.newReferenceModel
        atlModelInjector.inject(targetMetamodelReference, targetModelUri)
        val targetModel = atlModelFactory.newModel(targetMetamodelReference) as EMFModel
        return targetModel
    }

    /**
     * Internal launcher for the actual ATL transformation
     */
    private def launchTransformation(IModel sourceModel, IModel targetModel) {
        val atlLauncher = new EMFVMLauncher
        atlLauncher.initialize(emptyMap())
        atlLauncher.addInModel(sourceModel, "IN", transformationSourceModelPrefix)
        atlLauncher.addOutModel(targetModel, "OUT", transformationTargetModelPrefix)
        val launchOptions = #{"allowInterModelReferences" -> true as Object}
        atlLauncher.launch(ILauncher.RUN_MODE, new NullProgressMonitor(), launchOptions,
            loadCompiledTransformation)
    }

    /**
     * Load compiled ATL transformation, which is stored in a file with the ASM data format
     */
    private def loadCompiledTransformation() {
        return typeof(AbstractIntermediateModelTransformationStrategy)
            .getResourceAsStream(getCompiledModelTransformationFilePath())
    }
}