package de.fhdo.ddmm.intermediate.transformations;

import de.fhdo.ddmm.intermediate.transformations.AbstractIntermediateModelTransformationStrategy;
import de.fhdo.ddmm.intermediate.transformations.TransformationModelDescription;
import de.fhdo.ddmm.intermediate.transformations.TransformationModelDirection;
import de.fhdo.ddmm.intermediate.transformations.TransformationModelType;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.MapExtensions;

/**
 * Abstract strategy for model-to-model transformations relying on ATL's EMFTVM.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public abstract class AbstractEmftvmIntermediateModelTransformationStrategy extends AbstractIntermediateModelTransformationStrategy<Model, Model> {
  private EmftvmFactory emftvmFactory;
  
  private ExecEnv executionEnvironment;
  
  private ResourceSet resourceSet;
  
  private Map<TransformationModelDescription, Model> potentialOutputModels = CollectionLiterals.<TransformationModelDescription, Model>newHashMap();
  
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
    super();
    this.emftvmFactory = EmftvmFactory.eINSTANCE;
    this.executionEnvironment = this.emftvmFactory.createExecEnv();
    this.resourceSet = this.setupResourceSet();
  }
  
  /**
   * Helper to create the resource set used by the transformation
   */
  private ResourceSet setupResourceSet() {
    final ResourceSetImpl rs = new ResourceSetImpl();
    final Map<String, Object> extensionToFactoryMap = rs.getResourceFactoryRegistry().getExtensionToFactoryMap();
    XMIResourceFactoryImpl _xMIResourceFactoryImpl = new XMIResourceFactoryImpl();
    extensionToFactoryMap.put("xmi", _xMIResourceFactoryImpl);
    EMFTVMResourceFactoryImpl _eMFTVMResourceFactoryImpl = new EMFTVMResourceFactoryImpl();
    extensionToFactoryMap.put("emftvm", _eMFTVMResourceFactoryImpl);
    EcoreResourceFactoryImpl _ecoreResourceFactoryImpl = new EcoreResourceFactoryImpl();
    extensionToFactoryMap.put("ecore", _ecoreResourceFactoryImpl);
    return rs;
  }
  
  /**
   * Prepare model transformation
   */
  @Override
  protected void beforeTransformationHook(final Map<TransformationModelDescription, String> absoluteInputModelPaths) {
    final Set<TransformationModelDescription> modelDescriptions = absoluteInputModelPaths.keySet();
    final HashSet<String> registeredMetamodels = CollectionLiterals.<String>newHashSet();
    final Consumer<TransformationModelDescription> _function = (TransformationModelDescription it) -> {
      final TransformationModelType modelType = this.modelTypes.get(it);
      final String namespaceUri = modelType.getNamespaceUri();
      boolean _contains = registeredMetamodels.contains(namespaceUri);
      boolean _not = (!_contains);
      if (_not) {
        final Metamodel metamodel = EmftvmFactory.eINSTANCE.createMetamodel();
        metamodel.setResource(modelType.getEcorePackage().eResource());
        this.executionEnvironment.registerMetaModel(it.getReferenceModelName(), metamodel);
        registeredMetamodels.add(namespaceUri);
      }
    };
    modelDescriptions.forEach(_function);
  }
  
  /**
   * Create transformation-technology-specific input model instance
   */
  @Override
  protected Model createTransformationInputModel(final TransformationModelDescription modelDescription, final Resource resource) {
    final Model model = this.emftvmFactory.createModel();
    model.setResource(resource);
    TransformationModelDirection _direction = modelDescription.getDirection();
    boolean _tripleEquals = (_direction == TransformationModelDirection.INOUT);
    if (_tripleEquals) {
      this.potentialOutputModels.put(modelDescription, model);
    }
    return model;
  }
  
  /**
   * Create transformation-technology-specific output model instance
   */
  @Override
  protected Model createTransformationOutputModel(final TransformationModelDescription modelDescription, final String outputPath) {
    Model _xifexpression = null;
    boolean _containsKey = this.potentialOutputModels.containsKey(modelDescription);
    boolean _not = (!_containsKey);
    if (_not) {
      Model _xblockexpression = null;
      {
        final Model model = EmftvmFactory.eINSTANCE.createModel();
        model.setResource(this.resourceSet.createResource(URI.createURI(outputPath)));
        this.potentialOutputModels.put(modelDescription, model);
        _xblockexpression = model;
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  /**
   * Execute EMFTVM transformation
   */
  @Override
  protected Map<TransformationModelDescription, Resource> transformation(final Map<TransformationModelDescription, Model> transformationInputModels, final Map<TransformationModelDescription, Model> transformationOutputModels) {
    this.registerModels(transformationInputModels);
    this.registerModels(transformationOutputModels);
    String _modelTransformationFilePlatformFolder = this.getModelTransformationFilePlatformFolder();
    final DefaultModuleResolver moduleResolver = new DefaultModuleResolver(_modelTransformationFilePlatformFolder, 
      this.resourceSet);
    final TimingData timingData = new TimingData();
    this.executionEnvironment.loadModule(moduleResolver, this.getModelTransformationFileName());
    timingData.finishLoading();
    this.executionEnvironment.run(timingData);
    timingData.finish();
    final Function2<TransformationModelDescription, Model, Boolean> _function = (TransformationModelDescription description, Model model) -> {
      boolean _xifexpression = false;
      Resource _resource = model.getResource();
      EList<EObject> _contents = null;
      if (_resource!=null) {
        _contents=_resource.getContents();
      }
      boolean _tripleNotEquals = (_contents != null);
      if (_tripleNotEquals) {
        boolean _isEmpty = model.getResource().getContents().isEmpty();
        _xifexpression = (!_isEmpty);
      } else {
        _xifexpression = false;
      }
      return Boolean.valueOf(_xifexpression);
    };
    final Function1<Model, Resource> _function_1 = (Model it) -> {
      return it.getResource();
    };
    return MapExtensions.<TransformationModelDescription, Model, Resource>mapValues(MapExtensions.<TransformationModelDescription, Model>filter(this.potentialOutputModels, _function), _function_1);
  }
  
  /**
   * Helper to register models and their descriptions in EMFTVM's execution environment
   */
  private void registerModels(final Map<TransformationModelDescription, Model> models) {
    final BiConsumer<TransformationModelDescription, Model> _function = (TransformationModelDescription description, Model model) -> {
      this.registerModel(description.getNameInModelTransformation(), description.getDirection(), model);
    };
    models.forEach(_function);
  }
  
  /**
   * Helper to register a single model in EMFTVM's execution environment
   */
  private void registerModel(final String nameInModelTransformation, final TransformationModelDirection direction, final Model model) {
    if (direction != null) {
      switch (direction) {
        case IN:
          this.executionEnvironment.registerInputModel(nameInModelTransformation, model);
          break;
        case OUT:
          this.executionEnvironment.registerOutputModel(nameInModelTransformation, model);
          break;
        case INOUT:
          this.executionEnvironment.registerInOutModel(nameInModelTransformation, model);
          break;
        default:
          break;
      }
    }
  }
}
