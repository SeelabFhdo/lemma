package de.fhdo.lemma.intermediate.transformations;

import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * Abstract strategy for model-to-model transformations relying on ATL's EMFTVM.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public abstract class AbstractEmftvmIntermediateModelTransformationStrategy /* extends /* AbstractIntermediateModelTransformationStrategy<Model, Model> */  */{
  private /* EmftvmFactory */Object emftvmFactory;

  private /* ExecEnv */Object executionEnvironment;

  private ResourceSet resourceSet;

  private /* Map<TransformationModelDescription, Model> */Object potentialOutputModels = CollectionLiterals.<TransformationModelDescription, Model>newHashMap();

  /**
   * Get the platform path to the folder that holds the transformation model file
   */
  public abstract String getModelTransformationFilePlatformFolder();

  /**
   * Get the name of the transformation model file
   */
  public abstract String getModelTransformationFileName();

  /**
   * Constructor
   */
  public AbstractEmftvmIntermediateModelTransformationStrategy() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field EmftvmFactory is undefined"
      + "\nThe field AbstractEmftvmIntermediateModelTransformationStrategy.emftvmFactory refers to the missing type EmftvmFactory"
      + "\nThe field AbstractEmftvmIntermediateModelTransformationStrategy.executionEnvironment refers to the missing type ExecEnv"
      + "\nThe field AbstractEmftvmIntermediateModelTransformationStrategy.emftvmFactory refers to the missing type EmftvmFactory"
      + "\neINSTANCE cannot be resolved"
      + "\ncreateExecEnv cannot be resolved");
  }

  /**
   * Helper to create the resource set used by the transformation
   */
  private ResourceSet setupResourceSet() {
    throw new Error("Unresolved compilation problems:"
      + "\nEMFTVMResourceFactoryImpl cannot be resolved.");
  }

  /**
   * Prepare model transformation
   */
  @Override
  protected void beforeTransformationHook(final Map<TransformationModelDescription, IFile> inputModelFiles, final Map<TransformationModelDescription, String> outputModelPaths) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field EmftvmFactory is undefined"
      + "\nThe field AbstractEmftvmIntermediateModelTransformationStrategy.executionEnvironment refers to the missing type ExecEnv"
      + "\neINSTANCE cannot be resolved"
      + "\ncreateMetamodel cannot be resolved"
      + "\nresource cannot be resolved"
      + "\nregisterMetaModel cannot be resolved");
  }

  /**
   * Create transformation-technology-specific input model instance
   */
  @Override
  protected Model createTransformationInputModel(final TransformationModelDescription modelDescription, final Resource resource) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field AbstractEmftvmIntermediateModelTransformationStrategy.emftvmFactory refers to the missing type EmftvmFactory"
      + "\nThe field AbstractEmftvmIntermediateModelTransformationStrategy.potentialOutputModels refers to the missing type Model"
      + "\ncreateModel cannot be resolved"
      + "\nsetResource cannot be resolved");
  }

  /**
   * Create transformation-technology-specific output model instance
   */
  @Override
  protected Model createTransformationOutputModel(final TransformationModelDescription modelDescription, final String outputPath) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field EmftvmFactory is undefined"
      + "\nThe field AbstractEmftvmIntermediateModelTransformationStrategy.potentialOutputModels refers to the missing type Model"
      + "\nThe field AbstractEmftvmIntermediateModelTransformationStrategy.potentialOutputModels refers to the missing type Model"
      + "\neINSTANCE cannot be resolved"
      + "\ncreateModel cannot be resolved"
      + "\nsetResource cannot be resolved");
  }

  /**
   * Execute EMFTVM transformation
   */
  @Override
  protected Map<TransformationModelDescription, Resource> transformation(final /* Map<TransformationModelDescription, Model> */Object transformationInputModels, final /* Map<TransformationModelDescription, Model> */Object transformationOutputModels) {
    throw new Error("Unresolved compilation problems:"
      + "\nDefaultModuleResolver cannot be resolved."
      + "\nTimingData cannot be resolved."
      + "\nThe method or field resource is undefined"
      + "\nThe method registerModels(Map<TransformationModelDescription, Model>) from the type AbstractEmftvmIntermediateModelTransformationStrategy refers to the missing type Model"
      + "\nThe method registerModels(Map<TransformationModelDescription, Model>) from the type AbstractEmftvmIntermediateModelTransformationStrategy refers to the missing type Model"
      + "\nThe field AbstractEmftvmIntermediateModelTransformationStrategy.executionEnvironment refers to the missing type ExecEnv"
      + "\nThe field AbstractEmftvmIntermediateModelTransformationStrategy.executionEnvironment refers to the missing type ExecEnv"
      + "\nThe field AbstractEmftvmIntermediateModelTransformationStrategy.potentialOutputModels refers to the missing type Model"
      + "\nloadModule cannot be resolved"
      + "\nfinishLoading cannot be resolved"
      + "\nrun cannot be resolved"
      + "\nfinish cannot be resolved"
      + "\nresource cannot be resolved"
      + "\ncontents cannot be resolved"
      + "\n!== cannot be resolved"
      + "\nresource cannot be resolved"
      + "\ncontents cannot be resolved"
      + "\nempty cannot be resolved"
      + "\n! cannot be resolved");
  }

  /**
   * Helper to register models and their descriptions in EMFTVM's execution environment
   */
  private void registerModels(final /* Map<TransformationModelDescription, Model> */Object models) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method registerModel(String, TransformationModelDirection, Model) from the type AbstractEmftvmIntermediateModelTransformationStrategy refers to the missing type Object");
  }

  /**
   * Helper to register a single model in EMFTVM's execution environment
   */
  private Object registerModel(final String nameInModelTransformation, final TransformationModelDirection direction, final /* Model */Object model) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field AbstractEmftvmIntermediateModelTransformationStrategy.executionEnvironment refers to the missing type ExecEnv"
      + "\nThe field AbstractEmftvmIntermediateModelTransformationStrategy.executionEnvironment refers to the missing type ExecEnv"
      + "\nThe field AbstractEmftvmIntermediateModelTransformationStrategy.executionEnvironment refers to the missing type ExecEnv"
      + "\nregisterInputModel cannot be resolved"
      + "\nregisterOutputModel cannot be resolved"
      + "\nregisterInOutModel cannot be resolved");
  }
}
