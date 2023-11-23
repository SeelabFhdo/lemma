package de.fhdo.lemma.intermediate.transformations;

import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Abstract strategy for model-to-model transformations with one input and one output model relying
 * on ATL.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public abstract class AbstractAtlInputOutputIntermediateModelTransformationStrategy extends AbstractIntermediateModelTransformationStrategy<IModel, EMFModel> {
  private EMFInjector atlModelInjector;

  private EMFModelFactory atlModelFactory;

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
    super();
    EMFModelFactory _eMFModelFactory = new EMFModelFactory();
    this.atlModelFactory = _eMFModelFactory;
    EMFInjector _eMFInjector = new EMFInjector();
    this.atlModelInjector = _eMFInjector;
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
    try {
      final String inputModelNamespaceUri = this.inputModelTypeDescription.getValue().getNamespaceUri();
      final IReferenceModel inputMetamodel = this.atlModelFactory.newReferenceModel();
      this.atlModelInjector.inject(inputMetamodel, inputModelNamespaceUri);
      final IModel inputModel = this.atlModelFactory.newModel(inputMetamodel);
      this.atlModelInjector.inject(inputModel, resource);
      return inputModel;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Create transformation-technology-specific output model instance
   */
  @Override
  protected EMFModel createTransformationOutputModel(final TransformationModelDescription modelDescription, final String outputPath) {
    try {
      final String outputModelNamespaceUri = this.outputModelTypeDescription.getValue().getNamespaceUri();
      final IReferenceModel outputMetamodel = this.atlModelFactory.newReferenceModel();
      this.atlModelInjector.inject(outputMetamodel, outputModelNamespaceUri);
      IModel _newModel = this.atlModelFactory.newModel(outputMetamodel);
      return ((EMFModel) _newModel);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Execute ATL transformation
   */
  @Override
  protected Map<TransformationModelDescription, Resource> transformation(final Map<TransformationModelDescription, IModel> transformationInputModels, final Map<TransformationModelDescription, EMFModel> transformationOutputModels) {
    final EMFVMLauncher atlLauncher = new EMFVMLauncher();
    atlLauncher.initialize(CollectionLiterals.<String, Object>emptyMap());
    final IModel inputModel = ((IModel[])Conversions.unwrapArray(transformationInputModels.values(), IModel.class))[0];
    final TransformationModelDescription inputModelDescription = this.inputModelTypeDescription.getKey();
    atlLauncher.addInModel(inputModel, 
      inputModelDescription.getNameInModelTransformation(), 
      inputModelDescription.getReferenceModelName());
    final EMFModel outputModel = ((EMFModel[])Conversions.unwrapArray(transformationOutputModels.values(), EMFModel.class))[0];
    final TransformationModelDescription outputModelDescription = this.outputModelTypeDescription.getKey();
    atlLauncher.addOutModel(outputModel, 
      outputModelDescription.getNameInModelTransformation(), 
      outputModelDescription.getReferenceModelName());
    Pair<String, Object> _mappedTo = Pair.<String, Object>of("allowInterModelReferences", ((Object) Boolean.valueOf(true)));
    final Map<String, Object> launchOptions = Collections.<String, Object>unmodifiableMap(CollectionLiterals.<String, Object>newHashMap(_mappedTo));
    final InputStream compiledModelTransformation = AbstractAtlInputOutputIntermediateModelTransformationStrategy.class.getResourceAsStream(this.getCompiledModelTransformationFilePath());
    NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
    atlLauncher.launch(
      ILauncher.RUN_MODE, _nullProgressMonitor, launchOptions, compiledModelTransformation);
    Resource _resource = outputModel.getResource();
    Pair<TransformationModelDescription, Resource> _mappedTo_1 = Pair.<TransformationModelDescription, Resource>of(outputModelDescription, _resource);
    return Collections.<TransformationModelDescription, Resource>unmodifiableMap(CollectionLiterals.<TransformationModelDescription, Resource>newHashMap(_mappedTo_1));
  }
}
