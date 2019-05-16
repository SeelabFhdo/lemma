package de.fhdo.ddmm.intermediate.transformations;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import de.fhdo.ddmm.intermediate.transformations.AbstractSourceModelValidator;
import de.fhdo.ddmm.intermediate.transformations.IntermediateTransformationException;
import de.fhdo.ddmm.intermediate.transformations.IntermediateTransformationExceptionKind;
import de.fhdo.ddmm.intermediate.transformations.IntermediateTransformationPhase;
import de.fhdo.ddmm.intermediate.transformations.TargetModelInfo;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Abstract strategy for model-to-model transformations of DDMM-related source to intermediate
 * target models.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public abstract class AbstractIntermediateModelTransformationStrategy {
  private EMFInjector atlModelInjector;
  
  private EMFModelFactory atlModelFactory;
  
  private String targetModelUri;
  
  private EPackage targetModelPackage;
  
  /**
   * Get information like URI, EPackage, and root class of the target intermediate metamodel
   */
  public abstract TargetModelInfo getTargetModelInfo();
  
  /**
   * Before transformation hook (optional)
   */
  protected void beforeTransformationHook(final String absoluteSourceModelPath) {
  }
  
  /**
   * Prepare source model (optional)
   */
  protected void prepareSourceModel(final EObject modelRoot) {
  }
  
  /**
   * Get validator for source model. Optional, may return null.
   */
  protected AbstractSourceModelValidator getSourceModelValidator() {
    return null;
  }
  
  /**
   * Get project-relative path to compiled ATL model transformation file
   */
  protected abstract String getCompiledModelTransformationFilePath();
  
  /**
   * Get namespace URI of the source metamodel's EPackage
   */
  protected abstract String getSourcePackageNamespaceUri();
  
  /**
   * Get prefix of source model in ATL transformation file
   */
  protected abstract String getTransformationSourceModelPrefix();
  
  /**
   * Get prefix of target model in ATL transformation file
   */
  protected abstract String getTransformationTargetModelPrefix();
  
  /**
   * Add transformation target paths of imported model files to target model
   */
  protected abstract void populateTargetModelWithImportTargetPaths(final EMFModel targetModel, final Map<String, String> targetPaths);
  
  /**
   * Modify target model (optional)
   */
  protected void modifyTargetModel(final EObject modelRoot) {
  }
  
  /**
   * After transformation hook (optional)
   */
  protected void afterTransformationHook(final String absoluteSourceModelPath) {
  }
  
  /**
   * Constructor
   */
  public AbstractIntermediateModelTransformationStrategy() {
    EMFModelFactory _eMFModelFactory = new EMFModelFactory();
    this.atlModelFactory = _eMFModelFactory;
    EMFInjector _eMFInjector = new EMFInjector();
    this.atlModelInjector = _eMFInjector;
    this.targetModelUri = this.getTargetModelInfo().getNamespaceUri();
    this.targetModelPackage = this.getTargetModelInfo().getEcorePackage();
    this.registerTargetModelEPackage();
  }
  
  /**
   * Flag to indicate if children's children of the current model file, i.e., models that are
   * imported by imported models of the current model, shall be considered when building the
   * target paths of imports for the subsequent call to mainTransformation().
   */
  public boolean considerChildrensChildrenForImportTargetPaths() {
    return false;
  }
  
  /**
   * Perform the model-to-model-transformation of a source model, being specified in a specific
   * DSL file, to an intermediate model in the form of an XMI file
   */
  public void mainTransformation(final IFile sourceModelFile, final String targetModelFile, final Map<String, String> targetPathsOfImports, final Predicate<IntermediateTransformationException> warningCallback) {
    final Function<IFile, Resource> _function = (IFile it) -> {
      return this.loadDslSourceModel(it);
    };
    this.doTransformation(sourceModelFile, _function, targetModelFile, targetPathsOfImports, warningCallback);
  }
  
  /**
   * Perform a refining model transformation of a source XMI model to a more specific target XMI
   * model
   */
  public void refiningTransformation(final IFile sourceModelFile, final String targetModelFile, final Predicate<IntermediateTransformationException> warningCallback) {
    final Function<IFile, Resource> _function = (IFile it) -> {
      return this.loadXmiSourceModel(it);
    };
    this.doTransformation(sourceModelFile, _function, targetModelFile, null, warningCallback);
  }
  
  /**
   * Generic helper to perform a model transformation on the given source model file that gets
   * loaded by a model-format-specific loader
   */
  private void doTransformation(final IFile sourceModelFile, final Function<IFile, Resource> sourceModelLoader, final String targetModelFile, final Map<String, String> targetPathsOfImports, final Predicate<IntermediateTransformationException> warningCallback) {
    try {
      final String absoluteSourceModelPath = sourceModelFile.getRawLocation().makeAbsolute().toString();
      this.beforeTransformationHook(absoluteSourceModelPath);
      final Resource sourceModelResource = sourceModelLoader.apply(sourceModelFile);
      final EObject sourceModelRoot = sourceModelResource.getContents().get(0);
      this.prepareSourceModel(sourceModelRoot);
      final AbstractSourceModelValidator sourceModelValidator = this.getSourceModelValidator();
      boolean _xifexpression = false;
      if ((sourceModelValidator != null)) {
        _xifexpression = sourceModelValidator.validateSourceModel(absoluteSourceModelPath, sourceModelRoot, warningCallback);
      } else {
        _xifexpression = true;
      }
      final boolean continueWithTransformation = _xifexpression;
      if ((!continueWithTransformation)) {
        return;
      }
      final IModel sourceTransformationModel = this.createTransformationSourceModel(sourceModelResource);
      final EMFModel targetModel = this.createEmptyTargetModel();
      this.launchTransformation(sourceTransformationModel, targetModel);
      if (((targetModel.getResource() == null) || targetModel.getResource().getContents().isEmpty())) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("No elements created in ");
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("transformation of \"");
        IPath _location = sourceModelFile.getLocation();
        _builder_1.append(_location);
        _builder_1.append("\". Target model file ");
        String _plus = (_builder.toString() + _builder_1);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("\"");
        _builder_2.append(targetModelFile);
        _builder_2.append("\" was not written.");
        String _plus_1 = (_plus + _builder_2);
        throw new IntermediateTransformationException(_plus_1, 
          IntermediateTransformationExceptionKind.WARNING, 
          IntermediateTransformationPhase.TRANSFORMATION_FINISHED);
      }
      if (((targetPathsOfImports != null) && (!targetPathsOfImports.isEmpty()))) {
        this.populateTargetModelWithImportTargetPaths(targetModel, targetPathsOfImports);
      }
      final EObject targetModelRoot = targetModel.getResource().getContents().get(0);
      this.modifyTargetModel(targetModelRoot);
      this.afterTransformationHook(targetModelFile);
      Resource _resource = targetModel.getResource();
      _resource.setURI(URI.createURI(targetModelFile));
      targetModel.getResource().save(CollectionLiterals.<Object, Object>emptyMap());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Register the EPackage of the target metamodel. Otherwise, ATL won't find it, when the
   * transformation gets launched.
   */
  private void registerTargetModelEPackage() {
    boolean _containsKey = EPackage.Registry.INSTANCE.containsKey(this.targetModelUri);
    if (_containsKey) {
      return;
    }
    EPackage.Registry.INSTANCE.put(this.targetModelUri, this.targetModelPackage);
  }
  
  /**
   * Load a source model from a DSL file
   */
  private Resource loadDslSourceModel(final IFile dslFile) {
    final String projectRelativeDslFilePath = dslFile.getFullPath().toString();
    final URI sourceDslFileUri = URI.createURI(projectRelativeDslFilePath);
    final ResourceSet sourceDslFileResourceSet = AbstractIntermediateModelTransformationStrategy.createResourceSetFor(sourceDslFileUri);
    final Resource sourceDslFileResource = sourceDslFileResourceSet.getResource(sourceDslFileUri, true);
    return sourceDslFileResource;
  }
  
  /**
   * Load a source model from an XMI file
   */
  private Resource loadXmiSourceModel(final IFile modelFile) {
    try {
      final String projectRelativeSourceModelFilePath = modelFile.getFullPath().toString();
      final URI sourceModelFileUri = URI.createURI(projectRelativeSourceModelFilePath);
      final ResourceSetImpl resourceSet = new ResourceSetImpl();
      Map<String, Object> _extensionToFactoryMap = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
      XMIResourceFactoryImpl _xMIResourceFactoryImpl = new XMIResourceFactoryImpl();
      _extensionToFactoryMap.put("xmi", _xMIResourceFactoryImpl);
      final Resource resource = resourceSet.createResource(sourceModelFileUri);
      resource.load(null);
      return resource;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Helper to create ResourceSet for file
   */
  private static ResourceSet createResourceSetFor(final URI fileUri) {
    final IResourceServiceProvider.Registry resourceSetProviderRegistry = IResourceServiceProvider.Registry.INSTANCE;
    final IResourceServiceProvider resourceSetProvider = resourceSetProviderRegistry.getResourceServiceProvider(fileUri);
    return resourceSetProvider.<ResourceSet>get(ResourceSet.class);
  }
  
  /**
   * Load a source model from a DSL file resource
   */
  private IModel createTransformationSourceModel(final Resource sourceModelResource) {
    final IReferenceModel sourceDslMetamodelReference = this.createSourceDslMetamodelReference();
    final IModel sourceModel = this.atlModelFactory.newModel(sourceDslMetamodelReference);
    this.atlModelInjector.inject(sourceModel, sourceModelResource);
    return sourceModel;
  }
  
  /**
   * Create an IReferenceModel instance for the Xcore metamodel of the source DSL leveraging
   * ATL's model factory
   */
  private IReferenceModel createSourceDslMetamodelReference() {
    try {
      final IReferenceModel sourceDslMetamodelReference = this.atlModelFactory.newReferenceModel();
      this.atlModelInjector.inject(sourceDslMetamodelReference, this.getSourcePackageNamespaceUri());
      return sourceDslMetamodelReference;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Create an EMFModel instance for the Xcore metamodel of the target models leveraging ATL's
   * model factory
   */
  private EMFModel createEmptyTargetModel() {
    try {
      final IReferenceModel targetMetamodelReference = this.atlModelFactory.newReferenceModel();
      this.atlModelInjector.inject(targetMetamodelReference, this.targetModelUri);
      IModel _newModel = this.atlModelFactory.newModel(targetMetamodelReference);
      final EMFModel targetModel = ((EMFModel) _newModel);
      return targetModel;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Internal launcher for the actual ATL transformation
   */
  private Object launchTransformation(final IModel sourceModel, final IModel targetModel) {
    Object _xblockexpression = null;
    {
      final EMFVMLauncher atlLauncher = new EMFVMLauncher();
      atlLauncher.initialize(CollectionLiterals.<String, Object>emptyMap());
      atlLauncher.addInModel(sourceModel, "IN", this.getTransformationSourceModelPrefix());
      atlLauncher.addOutModel(targetModel, "OUT", this.getTransformationTargetModelPrefix());
      Pair<String, Object> _mappedTo = Pair.<String, Object>of("allowInterModelReferences", ((Object) Boolean.valueOf(true)));
      final Map<String, Object> launchOptions = Collections.<String, Object>unmodifiableMap(CollectionLiterals.<String, Object>newHashMap(_mappedTo));
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      _xblockexpression = atlLauncher.launch(ILauncher.RUN_MODE, _nullProgressMonitor, launchOptions, 
        this.loadCompiledTransformation());
    }
    return _xblockexpression;
  }
  
  /**
   * Load compiled ATL transformation, which is stored in a file with the ASM data format
   */
  private InputStream loadCompiledTransformation() {
    return AbstractIntermediateModelTransformationStrategy.class.getResourceAsStream(this.getCompiledModelTransformationFilePath());
  }
}
