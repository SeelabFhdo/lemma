package de.fhdo.lemma.intermediate.transformations;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import de.fhdo.lemma.utils.LemmaUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.xbase.lib.ArrayExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;

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
@SuppressWarnings("all")
public abstract class AbstractIntermediateModelTransformationStrategy<TIM_TYPE extends Object, TOM_TYPE extends Object> {
  /**
   * Class representing a result of a model-to-model transformation. It maps input models to a
   * certain output model.
   */
  public static class TransformationResult {
    @Accessors
    private List<AbstractIntermediateModelTransformationStrategy.InputModel> inputModels;

    @Accessors
    private AbstractIntermediateModelTransformationStrategy.OutputModel outputModel;

    public TransformationResult(final List<AbstractIntermediateModelTransformationStrategy.InputModel> inputModels, final AbstractIntermediateModelTransformationStrategy.OutputModel outputModel) {
      this.inputModels = inputModels;
      this.outputModel = outputModel;
    }

    @Pure
    public List<AbstractIntermediateModelTransformationStrategy.InputModel> getInputModels() {
      return this.inputModels;
    }

    public void setInputModels(final List<AbstractIntermediateModelTransformationStrategy.InputModel> inputModels) {
      this.inputModels = inputModels;
    }

    @Pure
    public AbstractIntermediateModelTransformationStrategy.OutputModel getOutputModel() {
      return this.outputModel;
    }

    public void setOutputModel(final AbstractIntermediateModelTransformationStrategy.OutputModel outputModel) {
      this.outputModel = outputModel;
    }
  }

  /**
   * Class representing an input model of a model-to-model transformation
   */
  public static class InputModel {
    @Accessors
    private String inputPath;

    @Accessors
    private String namespaceUri;

    @Accessors
    private IFile file;

    public InputModel(final String inputPath, final String namespaceUri, final IFile file) {
      this.inputPath = inputPath;
      this.namespaceUri = namespaceUri;
      this.file = file;
    }

    @Pure
    public String getInputPath() {
      return this.inputPath;
    }

    public void setInputPath(final String inputPath) {
      this.inputPath = inputPath;
    }

    @Pure
    public String getNamespaceUri() {
      return this.namespaceUri;
    }

    public void setNamespaceUri(final String namespaceUri) {
      this.namespaceUri = namespaceUri;
    }

    @Pure
    public IFile getFile() {
      return this.file;
    }

    public void setFile(final IFile file) {
      this.file = file;
    }
  }

  /**
   * Class representing an output model of a model-to-model transformation
   */
  public static class OutputModel {
    @Accessors
    private String outputPath;

    @Accessors
    private String namespaceUri;

    @Accessors
    private Resource resource;

    public OutputModel(final String outputPath, final String namespaceUri, final Resource resource) {
      this.outputPath = outputPath;
      this.namespaceUri = namespaceUri;
      this.resource = resource;
    }

    @Pure
    public String getOutputPath() {
      return this.outputPath;
    }

    public void setOutputPath(final String outputPath) {
      this.outputPath = outputPath;
    }

    @Pure
    public String getNamespaceUri() {
      return this.namespaceUri;
    }

    public void setNamespaceUri(final String namespaceUri) {
      this.namespaceUri = namespaceUri;
    }

    @Pure
    public Resource getResource() {
      return this.resource;
    }

    public void setResource(final Resource resource) {
      this.resource = resource;
    }
  }

  protected LinkedHashMap<TransformationModelDescription, TransformationModelType> modelTypes;

  /**
   * Register model types, i.e., URIs, EPackages, and root classes, together with their
   * transformation-specific descriptions, i.e., names in model transformations and directions
   */
  public abstract LinkedHashMap<TransformationModelDescription, TransformationModelType> registerModelTypes();

  /**
   * Before transformation hook (optional)
   */
  protected void beforeTransformationHook(final Map<TransformationModelDescription, IFile> inputModelFiles, final Map<TransformationModelDescription, String> outputModelPaths) {
  }

  /**
   * Prepare an input model (optional)
   */
  protected void prepareInputModel(final TransformationModelDescription modelDescription, final EObject modelRoot) {
  }

  /**
   * Get validator for input model (optional)
   */
  protected AbstractInputModelValidator getInputModelValidator(final TransformationModelDescription modelDescription) {
    return null;
  }

  /**
   * Create transformation-technology-specific input model instance
   */
  protected abstract TIM_TYPE createTransformationInputModel(final TransformationModelDescription modelDescription, final Resource resource);

  /**
   * Create transformation-technology-specific output model instance
   */
  protected abstract TOM_TYPE createTransformationOutputModel(final TransformationModelDescription modelDescription, final String outputPath);

  /**
   * Execute transformation leveraging a certain transformation technology
   */
  protected abstract Map<TransformationModelDescription, Resource> transformation(final Map<TransformationModelDescription, TIM_TYPE> transformationInputModels, final Map<TransformationModelDescription, TOM_TYPE> transformationOutputModels);

  /**
   * Flag to indicate if children's children of the current model file, i.e., models that are
   * imported by imported models of the current model, shall be considered when building the
   * target paths of imports for the subsequent call to transformation().
   */
  public boolean considerChildrensChildrenForImportTargetPaths() {
    return false;
  }

  /**
   * Add transformation target paths of imported model files to output model
   */
  protected void populateOutputModelWithImportTargetPaths(final TransformationModelDescription modelDescription, final EObject modelRoot, final Map<String, String> targetPaths) {
  }

  /**
   * Modify an output model (optional)
   */
  protected void modifyOutputModel(final TransformationModelDescription modelDescription, final EObject modelRoot) {
  }

  /**
   * After transformation hook (optional)
   */
  protected void afterTransformationHook(final Map<TransformationModelDescription, String> outputModelPaths) {
  }

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
  public Function2<? super List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, ? super Predicate<IntermediateTransformationException>, ? extends List<AbstractIntermediateModelTransformationStrategy.TransformationResult>> registerTransformationsFinishedListener() {
    return null;
  }

  /**
   * Convert URIs in a transformation result to relative ones (optional)
   */
  public void makeUrisRelative(final AbstractIntermediateModelTransformationStrategy.TransformationResult result) {
  }

  /**
   * Constructor
   */
  public AbstractIntermediateModelTransformationStrategy() {
    this.modelTypes = this.registerModelTypes();
    if (((this.modelTypes == null) || this.modelTypes.isEmpty())) {
      throw new IllegalStateException("Model types must not be empty");
    }
    final Function2<TransformationModelDescription, TransformationModelType, Boolean> _function = (TransformationModelDescription description, TransformationModelType value) -> {
      return Boolean.valueOf((Objects.equal(description.getDirection(), TransformationModelDirection.INOUT) || 
        Objects.equal(description.getDirection(), TransformationModelDirection.OUT)));
    };
    final List<TransformationModelType> outputModelTypes = IterableExtensions.<TransformationModelType>toList(MapExtensions.<TransformationModelDescription, TransformationModelType>filter(this.modelTypes, _function).values());
    this.registerEPackages(outputModelTypes);
  }

  /**
   * Helper to register EPackages of a given list of model types
   */
  private void registerEPackages(final List<TransformationModelType> modelTypes) {
    final Consumer<TransformationModelType> _function = (TransformationModelType it) -> {
      boolean _containsKey = EPackage.Registry.INSTANCE.containsKey(it.getNamespaceUri());
      boolean _not = (!_containsKey);
      if (_not) {
        EPackage.Registry.INSTANCE.put(it.getNamespaceUri(), it.getEcorePackage());
      }
    };
    modelTypes.forEach(_function);
  }

  /**
   * Get registered output model types
   */
  public final List<TransformationModelType> getOutputModelTypes() {
    final Function2<TransformationModelDescription, TransformationModelType, Boolean> _function = (TransformationModelDescription description, TransformationModelType type) -> {
      return Boolean.valueOf(((description.getDirection() == TransformationModelDirection.OUT) || 
        (description.getDirection() == TransformationModelDirection.INOUT)));
    };
    return IterableExtensions.<TransformationModelType>toList(MapExtensions.<TransformationModelDescription, TransformationModelType>filter(this.modelTypes, _function).values());
  }

  /**
   * Run a model-to-model transformation on a list of input models expressed as instances of
   * org.eclipse.core.resources.IFile. To this end, the transformation model description for each
   * input model is also passed by the caller.
   */
  public final Map<TransformationModelDescription, AbstractIntermediateModelTransformationStrategy.TransformationResult> doTransformationFromFiles(final Map<TransformationModelDescription, IFile> inputModelFiles, final Map<TransformationModelDescription, String> outputModelPaths, final Map<String, Map<String, String>> targetPathsOfImports, final Predicate<IntermediateTransformationException> warningCallback) {
    final Map<TransformationModelDescription, Resource> inputModelResources = this.loadModelResources(inputModelFiles);
    return this.doTransformation(inputModelFiles, inputModelResources, outputModelPaths, targetPathsOfImports, warningCallback);
  }

  /**
   * Helper to load Resource instances of models being expressed as IFile instances
   */
  private Map<TransformationModelDescription, Resource> loadModelResources(final Map<TransformationModelDescription, IFile> models) {
    final HashMap<TransformationModelDescription, Resource> loadedModels = CollectionLiterals.<TransformationModelDescription, Resource>newHashMap();
    final BiConsumer<TransformationModelDescription, IFile> _function = (TransformationModelDescription description, IFile file) -> {
      String _fileExtension = file.getFileExtension();
      String _lowerCase = null;
      if (_fileExtension!=null) {
        _lowerCase=_fileExtension.toLowerCase();
      }
      final String fileExtension = _lowerCase;
      if (((fileExtension == null) || fileExtension.isEmpty())) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("File ");
        String _absolutePath = LemmaUtils.getAbsolutePath(file);
        _builder.append(_absolutePath);
        _builder.append(" does not have a file extension. ");
        String _plus = (_builder.toString() + 
          "It can thus not be loaded as a model Resource. Model transformation not ");
        String _plus_1 = (_plus + 
          "possible.");
        throw new IllegalArgumentException(_plus_1);
      }
      Resource _xifexpression = null;
      boolean _equals = "xmi".equals(fileExtension);
      if (_equals) {
        _xifexpression = this.loadModelResourceFromXmiFile(file);
      } else {
        _xifexpression = this.loadModelResourceFromDslFile(file);
      }
      final Resource modelResource = _xifexpression;
      loadedModels.put(description, modelResource);
    };
    models.forEach(_function);
    return loadedModels;
  }

  /**
   * Helper to load a model Resource from an XMI file
   */
  private Resource loadModelResourceFromXmiFile(final IFile modelFile) {
    try {
      final String projectRelativeModelFilePath = modelFile.getFullPath().toString();
      final URI modelFileUri = URI.createURI(projectRelativeModelFilePath);
      final ResourceSetImpl resourceSet = new ResourceSetImpl();
      Map<String, Object> _extensionToFactoryMap = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
      XMIResourceFactoryImpl _xMIResourceFactoryImpl = new XMIResourceFactoryImpl();
      _extensionToFactoryMap.put("xmi", _xMIResourceFactoryImpl);
      final Resource resource = resourceSet.createResource(modelFileUri);
      resource.load(null);
      return resource;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Helper to load a model Resource from a DSL file
   */
  private Resource loadModelResourceFromDslFile(final IFile modelFile) {
    final String projectRelativeDslFilePath = modelFile.getFullPath().toString();
    final URI inputDslFileUri = URI.createURI(projectRelativeDslFilePath);
    final IResourceServiceProvider resourceSetProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(inputDslFileUri);
    return resourceSetProvider.<ResourceSet>get(ResourceSet.class).getResource(inputDslFileUri, true);
  }

  /**
   * Run a model-to-model transformation on a list of input models expressed as instances of
   * org.eclipse.core.resources.IFile and a list of output paths. The transformation model
   * descriptions are assigned to input files and output paths in the order they were registered
   * in the implementation of registerModelTypes().
   */
  public final Map<TransformationModelDescription, AbstractIntermediateModelTransformationStrategy.TransformationResult> doTransformationFromFiles(final List<IFile> inputModels, final List<String> outputModelPaths, final Map<String, Map<String, String>> targetPathsOfImports, final Predicate<IntermediateTransformationException> warningCallback) {
    final Map<TransformationModelDescription, IFile> inputModelsWithDescriptions = this.<IFile>mapValuesToModelTypeDescriptions(inputModels, 
      "input model", TransformationModelDirection.IN, TransformationModelDirection.INOUT);
    final Map<TransformationModelDescription, String> outputModelsWithDescriptions = this.<String>mapValuesToModelTypeDescriptions(outputModelPaths, 
      "output model", TransformationModelDirection.OUT, TransformationModelDirection.INOUT);
    return this.doTransformationFromFiles(inputModelsWithDescriptions, outputModelsWithDescriptions, targetPathsOfImports, warningCallback);
  }

  /**
   * Helper to assign input or output models/paths to registered transformation model descriptions
   * of a given set of directions
   */
  private <T extends Object> Map<TransformationModelDescription, T> mapValuesToModelTypeDescriptions(final List<T> values, final String valueTypeName, final TransformationModelDirection... filterDirections) {
    final Function1<TransformationModelDescription, Boolean> _function = (TransformationModelDescription it) -> {
      return Boolean.valueOf(ArrayExtensions.contains(filterDirections, it.getDirection()));
    };
    final Iterable<TransformationModelDescription> registeredDescriptions = IterableExtensions.<TransformationModelDescription>filter(this.modelTypes.keySet(), _function);
    int _size = values.size();
    int _size_1 = IterableExtensions.size(registeredDescriptions);
    boolean _notEquals = (_size != _size_1);
    if (_notEquals) {
      StringConcatenation _builder = new StringConcatenation();
      String _firstUpper = StringExtensions.toFirstUpper(valueTypeName);
      _builder.append(_firstUpper);
      _builder.append(" count must be ");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("equal to ");
      String _firstLower = StringExtensions.toFirstLower(valueTypeName);
      _builder_1.append(_firstLower);
      _builder_1.append(" description count");
      String _plus = (_builder.toString() + _builder_1);
      throw new IllegalArgumentException(_plus);
    }
    final HashMap<TransformationModelDescription, T> valuesToDescriptions = CollectionLiterals.<TransformationModelDescription, T>newHashMap();
    for (int i = 0; (i < IterableExtensions.size(registeredDescriptions)); i++) {
      valuesToDescriptions.put(((TransformationModelDescription[])Conversions.unwrapArray(registeredDescriptions, TransformationModelDescription.class))[i], values.get(i));
    }
    return valuesToDescriptions;
  }

  /**
   * Run a model-to-model transformation on a list of input models expressed as instances of
   * org.eclipse.emf.ecore.resource.Resource. To this end, the transformation model description
   * for each input model is also passed by the caller.
   */
  public final Map<TransformationModelDescription, AbstractIntermediateModelTransformationStrategy.TransformationResult> doTransformationFromResources(final Map<TransformationModelDescription, Resource> inputModelResources, final Map<TransformationModelDescription, String> outputModelPaths, final Map<String, Map<String, String>> targetPathsOfImports, final Predicate<IntermediateTransformationException> warningCallback) {
    final Function1<Resource, IFile> _function = (Resource it) -> {
      return LemmaUtils.getFileForResource(it);
    };
    final Map<TransformationModelDescription, IFile> inputModelFiles = MapExtensions.<TransformationModelDescription, Resource, IFile>mapValues(inputModelResources, _function);
    return this.doTransformation(inputModelFiles, inputModelResources, outputModelPaths, targetPathsOfImports, warningCallback);
  }

  /**
   * Generic method for running a model-to-model transformation. The input models are expressed
   * on the basis of two maps that assign the transformation model descriptions to the input model
   * files and resources, respectively.
   */
  private Map<TransformationModelDescription, AbstractIntermediateModelTransformationStrategy.TransformationResult> doTransformation(final Map<TransformationModelDescription, IFile> inputModelFiles, final Map<TransformationModelDescription, Resource> inputModelResources, final Map<TransformationModelDescription, String> outputModelPaths, final Map<String, Map<String, String>> targetPathsOfImports, final Predicate<IntermediateTransformationException> warningCallback) {
    this.beforeTransformationChecks(inputModelFiles, outputModelPaths);
    this.beforeTransformationHook(inputModelFiles, outputModelPaths);
    final Map<TransformationModelDescription, Resource> preparedInputModels = this.prepareInputModels(inputModelResources);
    boolean _validateInputModels = this.validateInputModels(inputModelFiles, preparedInputModels, warningCallback);
    boolean _not = (!_validateInputModels);
    if (_not) {
      return null;
    }
    final Map<TransformationModelDescription, Resource> transformationResultResources = this.executeTransformation(preparedInputModels, outputModelPaths);
    if ((targetPathsOfImports != null)) {
      this.populateOutputModelsWithImportTargetPaths(transformationResultResources, outputModelPaths, targetPathsOfImports);
    }
    this.modifyOutputModels(transformationResultResources);
    this.afterTransformationHook(outputModelPaths);
    this.saveOutputModels(transformationResultResources, outputModelPaths);
    return this.createTransformationResults(inputModelFiles, transformationResultResources, outputModelPaths);
  }

  /**
   * Helper to perform generic checks on input and output models/paths
   */
  private void beforeTransformationChecks(final Map<TransformationModelDescription, IFile> inputModels, final Map<TransformationModelDescription, String> outputModelPaths) {
    this.checkContainsDescriptionsForAllRegisteredModelTypesOfDirection(inputModels.keySet(), 
      TransformationModelDirection.IN);
    this.checkContainsDescriptionsForAllRegisteredModelTypesOfDirection(outputModelPaths.keySet(), 
      TransformationModelDirection.OUT);
    try {
      this.checkContainsDescriptionsForAllRegisteredModelTypesOfDirection(inputModels.keySet(), 
        TransformationModelDirection.INOUT);
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
        this.checkContainsDescriptionsForAllRegisteredModelTypesOfDirection(outputModelPaths.keySet(), 
          TransformationModelDirection.INOUT);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }

  /**
   * Helper to check that a set of transformation model descriptions contains a description for
   * each registered model type of a certain direction
   */
  private void checkContainsDescriptionsForAllRegisteredModelTypesOfDirection(final Set<TransformationModelDescription> descriptions, final TransformationModelDirection direction) {
    final Function1<TransformationModelDescription, Boolean> _function = (TransformationModelDescription it) -> {
      TransformationModelDirection _direction = it.getDirection();
      return Boolean.valueOf(Objects.equal(_direction, direction));
    };
    final Set<TransformationModelDescription> registeredModelDescriptions = IterableExtensions.<TransformationModelDescription>toSet(IterableExtensions.<TransformationModelDescription>filter(this.modelTypes.keySet(), _function));
    boolean _containsAll = descriptions.containsAll(registeredModelDescriptions);
    boolean _not = (!_containsAll);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("direction ");
      _builder.append(direction);
      String _plus = ("Missing values for registered model types of " + _builder);
      throw new IllegalArgumentException(_plus);
    }
  }

  /**
   * Helper to iteratively trigger preparation on a set of input models
   */
  private Map<TransformationModelDescription, Resource> prepareInputModels(final Map<TransformationModelDescription, Resource> inputModels) {
    final HashMap<TransformationModelDescription, Resource> preparedModels = CollectionLiterals.<TransformationModelDescription, Resource>newHashMap();
    final BiConsumer<TransformationModelDescription, Resource> _function = (TransformationModelDescription description, Resource resource) -> {
      final EObject modelRoot = resource.getContents().get(0);
      this.prepareInputModel(description, modelRoot);
      preparedModels.put(description, resource);
    };
    inputModels.forEach(_function);
    return preparedModels;
  }

  /**
   * Helper to iteratively validate a set of input models
   */
  private boolean validateInputModels(final Map<TransformationModelDescription, IFile> inputModelDescriptions, final Map<TransformationModelDescription, Resource> inputModelResources, final Predicate<IntermediateTransformationException> warningCallback) {
    boolean continueTransformation = true;
    for (int i = 0; ((i < inputModelDescriptions.size()) && continueTransformation); i++) {
      {
        final TransformationModelDescription description = ((TransformationModelDescription[])Conversions.unwrapArray(inputModelDescriptions.keySet(), TransformationModelDescription.class))[i];
        final IFile file = inputModelDescriptions.get(description);
        final Resource resource = inputModelResources.get(description);
        final EObject modelRoot = resource.getContents().get(0);
        final AbstractInputModelValidator modelValidator = this.getInputModelValidator(description);
        boolean _xifexpression = false;
        if ((modelValidator != null)) {
          _xifexpression = modelValidator.validateInputModel(LemmaUtils.getAbsolutePath(file), modelRoot, warningCallback);
        } else {
          _xifexpression = true;
        }
        continueTransformation = _xifexpression;
      }
    }
    return continueTransformation;
  }

  /**
   * Helper to execute a model-to-model-transformation
   */
  private Map<TransformationModelDescription, Resource> executeTransformation(final Map<TransformationModelDescription, Resource> inputModelResources, final Map<TransformationModelDescription, String> outputModelPaths) {
    try {
      final HashMap<TransformationModelDescription, TIM_TYPE> transformationInputModels = CollectionLiterals.<TransformationModelDescription, TIM_TYPE>newHashMap();
      final BiConsumer<TransformationModelDescription, Resource> _function = (TransformationModelDescription description, Resource resource) -> {
        final TIM_TYPE inputModel = this.createTransformationInputModel(description, resource);
        if ((inputModel != null)) {
          transformationInputModels.put(description, inputModel);
        }
      };
      inputModelResources.forEach(_function);
      final HashMap<TransformationModelDescription, TOM_TYPE> transformationOutputModels = CollectionLiterals.<TransformationModelDescription, TOM_TYPE>newHashMap();
      final BiConsumer<TransformationModelDescription, String> _function_1 = (TransformationModelDescription description, String path) -> {
        final TOM_TYPE outputModel = this.createTransformationOutputModel(description, path);
        if ((outputModel != null)) {
          transformationOutputModels.put(description, outputModel);
        }
      };
      outputModelPaths.forEach(_function_1);
      final Map<TransformationModelDescription, Resource> transformationResultResources = this.transformation(transformationInputModels, transformationOutputModels);
      boolean _isEmpty = transformationResultResources.isEmpty();
      if (_isEmpty) {
        throw new IntermediateTransformationException(("No elements were created during " + 
          "model transformation"), IntermediateTransformationExceptionKind.WARNING, 
          IntermediateTransformationPhase.TRANSFORMATION_FINISHED);
      }
      final Function1<Map.Entry<TransformationModelDescription, Resource>, Boolean> _function_2 = (Map.Entry<TransformationModelDescription, Resource> it) -> {
        return Boolean.valueOf(((it.getValue() == null) || it.getValue().getContents().isEmpty()));
      };
      final Map.Entry<TransformationModelDescription, Resource> emptyOutputModel = IterableExtensions.<Map.Entry<TransformationModelDescription, Resource>>findFirst(transformationResultResources.entrySet(), _function_2);
      if ((emptyOutputModel != null)) {
        final String outputModelPath = outputModelPaths.get(emptyOutputModel.getKey());
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("model file ");
        _builder.append(outputModelPath);
        _builder.append(".");
        String _plus = ("No elements were created in output " + _builder);
        throw new IntermediateTransformationException(_plus, IntermediateTransformationExceptionKind.WARNING, 
          IntermediateTransformationPhase.TRANSFORMATION_FINISHED);
      }
      return transformationResultResources;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Helper to add transformation target paths of imported model files to all output models
   */
  private void populateOutputModelsWithImportTargetPaths(final Map<TransformationModelDescription, Resource> outputModelResources, final Map<TransformationModelDescription, String> outputModelPaths, final Map<String, Map<String, String>> targetPathsOfImports) {
    final BiConsumer<TransformationModelDescription, Resource> _function = (TransformationModelDescription description, Resource resource) -> {
      final String outputPath = outputModelPaths.get(description);
      final Map<String, String> targetPaths = targetPathsOfImports.get(outputPath);
      if ((targetPaths != null)) {
        this.populateOutputModelWithImportTargetPaths(description, resource.getContents().get(0), targetPaths);
      }
    };
    outputModelResources.forEach(_function);
  }

  /**
   * Helper to iteratively trigger modifications of output models
   */
  private void modifyOutputModels(final Map<TransformationModelDescription, Resource> outputModelResources) {
    final BiConsumer<TransformationModelDescription, Resource> _function = (TransformationModelDescription description, Resource resource) -> {
      final EObject modelRoot = resource.getContents().get(0);
      this.modifyOutputModel(description, modelRoot);
    };
    outputModelResources.forEach(_function);
  }

  /**
   * Serialize all output model resources into XMI files
   */
  private void saveOutputModels(final Map<TransformationModelDescription, Resource> outputModelResources, final Map<TransformationModelDescription, String> outputModelPaths) {
    final BiConsumer<TransformationModelDescription, Resource> _function = (TransformationModelDescription description, Resource resource) -> {
      try {
        final String outputPath = outputModelPaths.get(description);
        resource.setURI(URI.createURI(outputPath));
        resource.save(CollectionLiterals.<Object, Object>emptyMap());
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    outputModelResources.forEach(_function);
  }

  /**
   * Create TransformationResult instances from transformation parameters. For each output model
   * resource, a TransformationResult is created.
   */
  private Map<TransformationModelDescription, AbstractIntermediateModelTransformationStrategy.TransformationResult> createTransformationResults(final Map<TransformationModelDescription, IFile> inputModels, final Map<TransformationModelDescription, Resource> outputModelResources, final Map<TransformationModelDescription, String> outputModelPaths) {
    final HashMap<TransformationModelDescription, AbstractIntermediateModelTransformationStrategy.TransformationResult> resultMap = CollectionLiterals.<TransformationModelDescription, AbstractIntermediateModelTransformationStrategy.TransformationResult>newHashMap();
    final BiConsumer<TransformationModelDescription, Resource> _function = (TransformationModelDescription description, Resource resource) -> {
      final String outputPath = outputModelPaths.get(description);
      final AbstractIntermediateModelTransformationStrategy.TransformationResult transformationResult = this.createTransformationResult(inputModels, outputPath, description, resource);
      resultMap.put(description, transformationResult);
    };
    outputModelResources.forEach(_function);
    return resultMap;
  }

  /**
   * Helper to create a TransformationResult instance
   */
  private AbstractIntermediateModelTransformationStrategy.TransformationResult createTransformationResult(final Map<TransformationModelDescription, IFile> inputModels, final String outputPath, final TransformationModelDescription outputModelDescription, final Resource outputResource) {
    final Function1<Map.Entry<TransformationModelDescription, IFile>, AbstractIntermediateModelTransformationStrategy.InputModel> _function = (Map.Entry<TransformationModelDescription, IFile> it) -> {
      String _absolutePath = LemmaUtils.getAbsolutePath(it.getValue());
      String _namespaceUri = this.modelTypes.get(it.getKey()).getNamespaceUri();
      IFile _value = it.getValue();
      return new AbstractIntermediateModelTransformationStrategy.InputModel(_absolutePath, _namespaceUri, _value);
    };
    final List<AbstractIntermediateModelTransformationStrategy.InputModel> resultInputModels = IterableExtensions.<AbstractIntermediateModelTransformationStrategy.InputModel>toList(IterableExtensions.<Map.Entry<TransformationModelDescription, IFile>, AbstractIntermediateModelTransformationStrategy.InputModel>map(inputModels.entrySet(), _function));
    String _namespaceUri = this.modelTypes.get(outputModelDescription).getNamespaceUri();
    final AbstractIntermediateModelTransformationStrategy.OutputModel outputModel = new AbstractIntermediateModelTransformationStrategy.OutputModel(outputPath, _namespaceUri, outputResource);
    return new AbstractIntermediateModelTransformationStrategy.TransformationResult(resultInputModels, outputModel);
  }
}
