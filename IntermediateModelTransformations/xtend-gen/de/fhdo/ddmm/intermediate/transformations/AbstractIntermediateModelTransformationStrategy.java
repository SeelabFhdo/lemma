package de.fhdo.ddmm.intermediate.transformations;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import de.fhdo.ddmm.intermediate.transformations.AbstractSourceModelValidator;
import de.fhdo.ddmm.intermediate.transformations.IntermediateTransformationException;
import de.fhdo.ddmm.intermediate.transformations.TargetModelInfo;
import java.io.InputStream;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * Abstract strategy for model-to-model transformations of DDMM-related source to intermediate
 * target models.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public abstract class AbstractIntermediateModelTransformationStrategy {
  private /* EMFInjector */Object atlModelInjector;
  
  private /* EMFModelFactory */Object atlModelFactory;
  
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
  protected abstract void populateTargetModelWithImportTargetPaths(final /* EMFModel */Object targetModel, final Map<String, String> targetPaths);
  
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
    throw new Error("Unresolved compilation problems:"
      + "\nEMFModelFactory cannot be resolved."
      + "\nEMFInjector cannot be resolved."
      + "\nThe field AbstractIntermediateModelTransformationStrategy.atlModelFactory refers to the missing type EMFModelFactory"
      + "\nThe field AbstractIntermediateModelTransformationStrategy.atlModelInjector refers to the missing type EMFInjector");
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe method createTransformationSourceModel(Resource) from the type AbstractIntermediateModelTransformationStrategy refers to the missing type Object"
      + "\nThe method createEmptyTargetModel() from the type AbstractIntermediateModelTransformationStrategy refers to the missing type EMFModel"
      + "\nThe method launchTransformation(IModel, IModel) from the type AbstractIntermediateModelTransformationStrategy refers to the missing type Object"
      + "\nThe method populateTargetModelWithImportTargetPaths(EMFModel, Map<String, String>) from the type AbstractIntermediateModelTransformationStrategy refers to the missing type EMFModel"
      + "\nresource cannot be resolved"
      + "\n=== cannot be resolved"
      + "\n|| cannot be resolved"
      + "\nresource cannot be resolved"
      + "\ncontents cannot be resolved"
      + "\nempty cannot be resolved"
      + "\nresource cannot be resolved"
      + "\ncontents cannot be resolved"
      + "\nget cannot be resolved"
      + "\nresource cannot be resolved"
      + "\nURI cannot be resolved"
      + "\nresource cannot be resolved"
      + "\nsave cannot be resolved");
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
  private Object createTransformationSourceModel(final Resource sourceModelResource) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method createSourceDslMetamodelReference() from the type AbstractIntermediateModelTransformationStrategy refers to the missing type Object"
      + "\nThe field AbstractIntermediateModelTransformationStrategy.atlModelFactory refers to the missing type EMFModelFactory"
      + "\nThe field AbstractIntermediateModelTransformationStrategy.atlModelInjector refers to the missing type EMFInjector"
      + "\nnewModel cannot be resolved"
      + "\ninject cannot be resolved");
  }
  
  /**
   * Create an IReferenceModel instance for the Xcore metamodel of the source DSL leveraging
   * ATL's model factory
   */
  private Object createSourceDslMetamodelReference() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field AbstractIntermediateModelTransformationStrategy.atlModelFactory refers to the missing type EMFModelFactory"
      + "\nThe field AbstractIntermediateModelTransformationStrategy.atlModelInjector refers to the missing type EMFInjector"
      + "\nnewReferenceModel cannot be resolved"
      + "\ninject cannot be resolved");
  }
  
  /**
   * Create an EMFModel instance for the Xcore metamodel of the target models leveraging ATL's
   * model factory
   */
  private EMFModel createEmptyTargetModel() {
    throw new Error("Unresolved compilation problems:"
      + "\nEMFModel cannot be resolved to a type."
      + "\nThe field AbstractIntermediateModelTransformationStrategy.atlModelFactory refers to the missing type EMFModelFactory"
      + "\nThe field AbstractIntermediateModelTransformationStrategy.atlModelInjector refers to the missing type EMFInjector"
      + "\nThe field AbstractIntermediateModelTransformationStrategy.atlModelFactory refers to the missing type EMFModelFactory"
      + "\nnewReferenceModel cannot be resolved"
      + "\ninject cannot be resolved"
      + "\nnewModel cannot be resolved");
  }
  
  /**
   * Internal launcher for the actual ATL transformation
   */
  private Object launchTransformation(final /* IModel */Object sourceModel, final /* IModel */Object targetModel) {
    throw new Error("Unresolved compilation problems:"
      + "\nEMFVMLauncher cannot be resolved."
      + "\nThe method or field ILauncher is undefined"
      + "\ninitialize cannot be resolved"
      + "\naddInModel cannot be resolved"
      + "\naddOutModel cannot be resolved"
      + "\nlaunch cannot be resolved"
      + "\nRUN_MODE cannot be resolved");
  }
  
  /**
   * Load compiled ATL transformation, which is stored in a file with the ASM data format
   */
  private InputStream loadCompiledTransformation() {
    return AbstractIntermediateModelTransformationStrategy.class.getResourceAsStream(this.getCompiledModelTransformationFilePath());
  }
}
