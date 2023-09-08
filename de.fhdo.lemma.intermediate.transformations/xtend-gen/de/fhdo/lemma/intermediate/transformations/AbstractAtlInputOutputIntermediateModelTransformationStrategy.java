package de.fhdo.lemma.intermediate.transformations;

import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Abstract strategy for model-to-model transformations with one input and one output model relying
 * on ATL.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public abstract class AbstractAtlInputOutputIntermediateModelTransformationStrategy /* extends /* AbstractIntermediateModelTransformationStrategy<IModel, EMFModel> */  */{
  private /* EMFInjector */Object atlModelInjector;

  private /* EMFModelFactory */Object atlModelFactory;

  private Pair<TransformationModelDescription, TransformationModelType> inputModelTypeDescription;

  private Pair<TransformationModelDescription, TransformationModelType> outputModelTypeDescription;

  /**
   * Get reference name and transformation model type of input model
   */
  public abstract Pair<String, TransformationModelType> getInputModelReferenceNameAndType();

  /**
   * Get reference name and transformation model type of output model
   */
  public abstract Pair<String, TransformationModelType> getOutputModelReferenceNameAndType();

  /**
   * Get path to the compiled ATL transformation file
   */
  public abstract String getCompiledModelTransformationFilePath();

  /**
   * Constructor
   */
  public AbstractAtlInputOutputIntermediateModelTransformationStrategy() {
    throw new Error("Unresolved compilation problems:"
      + "\nEMFModelFactory cannot be resolved."
      + "\nEMFInjector cannot be resolved."
      + "\nThe field AbstractAtlInputOutputIntermediateModelTransformationStrategy.atlModelFactory refers to the missing type EMFModelFactory"
      + "\nThe field AbstractAtlInputOutputIntermediateModelTransformationStrategy.atlModelInjector refers to the missing type EMFInjector");
  }

  /**
   * Register input and output model types. This also creates the corresponding descriptions of
   * the model types with directions IN and OUT, respectively.
   */
  @Override
  public final LinkedHashMap<TransformationModelDescription, TransformationModelType> registerModelTypes() {
    String _key = this.getInputModelReferenceNameAndType().getKey();
    TransformationModelDescription _transformationModelDescription = new TransformationModelDescription(
      "IN", _key, 
      TransformationModelDirection.IN);
    TransformationModelType _value = this.getInputModelReferenceNameAndType().getValue();
    Pair<TransformationModelDescription, TransformationModelType> _mappedTo = Pair.<TransformationModelDescription, TransformationModelType>of(_transformationModelDescription, _value);
    this.inputModelTypeDescription = _mappedTo;
    String _key_1 = this.getOutputModelReferenceNameAndType().getKey();
    TransformationModelDescription _transformationModelDescription_1 = new TransformationModelDescription(
      "OUT", _key_1, 
      TransformationModelDirection.OUT);
    TransformationModelType _value_1 = this.getOutputModelReferenceNameAndType().getValue();
    Pair<TransformationModelDescription, TransformationModelType> _mappedTo_1 = Pair.<TransformationModelDescription, TransformationModelType>of(_transformationModelDescription_1, _value_1);
    this.outputModelTypeDescription = _mappedTo_1;
    final LinkedHashMap<TransformationModelDescription, TransformationModelType> descriptions = CollectionLiterals.<TransformationModelDescription, TransformationModelType>newLinkedHashMap();
    descriptions.put(this.inputModelTypeDescription.getKey(), this.inputModelTypeDescription.getValue());
    descriptions.put(this.outputModelTypeDescription.getKey(), this.outputModelTypeDescription.getValue());
    return descriptions;
  }

  /**
   * Create transformation-technology-specific input model instance
   */
  @Override
  protected IModel createTransformationInputModel(final TransformationModelDescription modelDescription, final Resource resource) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe field AbstractAtlInputOutputIntermediateModelTransformationStrategy.atlModelFactory refers to the missing type EMFModelFactory"
      + "\nThe field AbstractAtlInputOutputIntermediateModelTransformationStrategy.atlModelInjector refers to the missing type EMFInjector"
      + "\nThe field AbstractAtlInputOutputIntermediateModelTransformationStrategy.atlModelFactory refers to the missing type EMFModelFactory"
      + "\nThe field AbstractAtlInputOutputIntermediateModelTransformationStrategy.atlModelInjector refers to the missing type EMFInjector"
      + "\nnewReferenceModel cannot be resolved"
      + "\ninject cannot be resolved"
      + "\nnewModel cannot be resolved"
      + "\ninject cannot be resolved");
  }

  /**
   * Create transformation-technology-specific output model instance
   */
  @Override
  protected EMFModel createTransformationOutputModel(final TransformationModelDescription modelDescription, final String outputPath) {
    throw new Error("Unresolved compilation problems:"
      + "\nEMFModel cannot be resolved to a type."
      + "\nThe field AbstractAtlInputOutputIntermediateModelTransformationStrategy.atlModelFactory refers to the missing type EMFModelFactory"
      + "\nThe field AbstractAtlInputOutputIntermediateModelTransformationStrategy.atlModelInjector refers to the missing type EMFInjector"
      + "\nThe field AbstractAtlInputOutputIntermediateModelTransformationStrategy.atlModelFactory refers to the missing type EMFModelFactory"
      + "\nnewReferenceModel cannot be resolved"
      + "\ninject cannot be resolved"
      + "\nnewModel cannot be resolved");
  }

  /**
   * Execute ATL transformation
   */
  @Override
  protected Map<TransformationModelDescription, Resource> transformation(final /* Map<TransformationModelDescription, IModel> */Object transformationInputModels, final /* Map<TransformationModelDescription, EMFModel> */Object transformationOutputModels) {
    throw new Error("Unresolved compilation problems:"
      + "\nEMFVMLauncher cannot be resolved."
      + "\nThe method or field ILauncher is undefined"
      + "\ninitialize cannot be resolved"
      + "\naddInModel cannot be resolved"
      + "\naddOutModel cannot be resolved"
      + "\nlaunch cannot be resolved"
      + "\nRUN_MODE cannot be resolved"
      + "\nresource cannot be resolved");
  }
}
