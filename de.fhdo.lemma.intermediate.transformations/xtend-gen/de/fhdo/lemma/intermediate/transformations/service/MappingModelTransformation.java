package de.fhdo.lemma.intermediate.transformations.service;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import de.fhdo.lemma.data.intermediate.IntermediateDataModel;
import de.fhdo.lemma.data.intermediate.IntermediateImport;
import de.fhdo.lemma.data.intermediate.IntermediatePackage;
import de.fhdo.lemma.intermediate.transformations.AbstractAtlInputOutputIntermediateModelTransformationStrategy;
import de.fhdo.lemma.intermediate.transformations.AbstractInputModelValidator;
import de.fhdo.lemma.intermediate.transformations.AbstractIntermediateModelTransformationStrategy;
import de.fhdo.lemma.intermediate.transformations.IntermediateTransformationException;
import de.fhdo.lemma.intermediate.transformations.TransformationModelDescription;
import de.fhdo.lemma.intermediate.transformations.TransformationModelType;
import de.fhdo.lemma.intermediate.transformations.service.IntermediateDataModelRefinement;
import de.fhdo.lemma.intermediate.transformations.service.MappingModelTransformationValidator;
import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.MappedComplexType;
import de.fhdo.lemma.service.ServiceModel;
import de.fhdo.lemma.service.ServicePackage;
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel;
import de.fhdo.lemma.technology.mapping.ComplexParameterMapping;
import de.fhdo.lemma.technology.mapping.ComplexTypeMapping;
import de.fhdo.lemma.technology.mapping.ImportedComplexType;
import de.fhdo.lemma.technology.mapping.MappingPackage;
import de.fhdo.lemma.technology.mapping.MicroserviceMapping;
import de.fhdo.lemma.technology.mapping.TechnologyMapping;
import de.fhdo.lemma.technology.mapping.TechnologySpecificFieldMapping;
import de.fhdo.lemma.utils.LemmaUtils;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Implementation of the ATL-based model-to-model transformation of mapping models to intermediate
 * service models.
 * 
 * It also comprises the possible refinement of intermediate data models being produced during the
 * same transformation run in case the mapping model specifies complex type mappings. Refined
 * intermediate data models are then stored in a sub-directory of the directory that contains the
 * intermediate service model resulting from the mapping model. The name of the sub-directory
 * corresponds to the name of the intermediate service model without the ".xmi" extension. The
 * import paths in the intermediate service model as well as intermediate data models being produced
 * during the same run and for the same mapping model are adapted to those of the refined
 * intermediate data models.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class MappingModelTransformation extends AbstractAtlInputOutputIntermediateModelTransformationStrategy {
  /**
   * This class clusters all functionalities related to the refining of intermediate data models.
   * The refining of intermediate data models being produced during the same transformation run
   * becomes necessary in case the mapping model comprises complex type mappings. In that case,
   * the intermediate data models that hold the mapped complex types are refined with the
   * technology-specific types and aspects used in the mapping.
   * 
   * Refined data models are collected in a sub-directory of the directory that holds the
   * intermediate service model resulting from the mapping model. All import paths in the
   * intermediate service model or intermediate data models being refined during the same run are
   * adapted to point to the refined intermediate data models. Note that the name of a refined
   * intermediate data model gets prefixed with the alias of the import in the service model to
   * prevent refined intermediate data models to be overwritten when their source models have the
   * same name but originate from different directories.
   */
  private static final class MappingModelRefinementExecutor {
    /**
     * Execute the refinements
     */
    private static Void executeRefinements(final TechnologyMapping inputMappingModel, final List<AbstractIntermediateModelTransformationStrategy.TransformationResult> results, final Predicate<IntermediateTransformationException> warningCallback) {
      final HashMap<AbstractIntermediateModelTransformationStrategy.OutputModel, Map<String, AbstractIntermediateModelTransformationStrategy.OutputModel>> refinedModelsPerServiceModel = CollectionLiterals.<AbstractIntermediateModelTransformationStrategy.OutputModel, Map<String, AbstractIntermediateModelTransformationStrategy.OutputModel>>newHashMap();
      final BiConsumer<AbstractIntermediateModelTransformationStrategy.OutputModel, Set<AbstractIntermediateModelTransformationStrategy.OutputModel>> _function = (AbstractIntermediateModelTransformationStrategy.OutputModel serviceModel, Set<AbstractIntermediateModelTransformationStrategy.OutputModel> intermediateDataModels) -> {
        MappingModelTransformation.MappingModelRefinementExecutor.linkTechnologyModels(serviceModel, inputMappingModel);
        final Function1<AbstractIntermediateModelTransformationStrategy.OutputModel, String> _function_1 = (AbstractIntermediateModelTransformationStrategy.OutputModel it) -> {
          return it.getOutputPath();
        };
        final Function1<AbstractIntermediateModelTransformationStrategy.OutputModel, AbstractIntermediateModelTransformationStrategy.TransformationResult> _function_2 = (AbstractIntermediateModelTransformationStrategy.OutputModel it) -> {
          return MappingModelTransformation.MappingModelRefinementExecutor.runRefininingTransformation(serviceModel, it, warningCallback);
        };
        final Map<String, AbstractIntermediateModelTransformationStrategy.TransformationResult> refinedModels = IterableExtensions.<AbstractIntermediateModelTransformationStrategy.OutputModel, String, AbstractIntermediateModelTransformationStrategy.TransformationResult>toMap(intermediateDataModels, _function_1, _function_2);
        final Function2<String, AbstractIntermediateModelTransformationStrategy.TransformationResult, Boolean> _function_3 = (String path, AbstractIntermediateModelTransformationStrategy.TransformationResult model) -> {
          return Boolean.valueOf((model != null));
        };
        final BiConsumer<String, AbstractIntermediateModelTransformationStrategy.TransformationResult> _function_4 = (String originalModelPath, AbstractIntermediateModelTransformationStrategy.TransformationResult refinedModel) -> {
          AbstractIntermediateModelTransformationStrategy.OutputModel _outputModel = refinedModel.getOutputModel();
          Pair<String, AbstractIntermediateModelTransformationStrategy.OutputModel> _mappedTo = Pair.<String, AbstractIntermediateModelTransformationStrategy.OutputModel>of(originalModelPath, _outputModel);
          Map<String, AbstractIntermediateModelTransformationStrategy.OutputModel> _putIfAbsent = refinedModelsPerServiceModel.putIfAbsent(serviceModel, 
            CollectionLiterals.<String, AbstractIntermediateModelTransformationStrategy.OutputModel>newHashMap(_mappedTo));
          if (_putIfAbsent!=null) {
            _putIfAbsent.put(originalModelPath, refinedModel.getOutputModel());
          }
        };
        MapExtensions.<String, AbstractIntermediateModelTransformationStrategy.TransformationResult>filter(refinedModels, _function_3).forEach(_function_4);
      };
      MappingModelTransformation.MappingModelRefinementExecutor.intermediateDataModelsPerServiceModel(results).forEach(_function);
      final BiConsumer<AbstractIntermediateModelTransformationStrategy.OutputModel, Map<String, AbstractIntermediateModelTransformationStrategy.OutputModel>> _function_1 = (AbstractIntermediateModelTransformationStrategy.OutputModel serviceModel, Map<String, AbstractIntermediateModelTransformationStrategy.OutputModel> refinedDataModels) -> {
        final AbstractIntermediateModelTransformationStrategy.OutputModel intermediateServiceModel = MappingModelTransformation.MappingModelRefinementExecutor.findIntermediateServiceModel(results, serviceModel);
        final Function<EObject, List<IntermediateImport>> _function_2 = (EObject it) -> {
          return ((IntermediateServiceModel) it).getImports();
        };
        MappingModelTransformation.MappingModelRefinementExecutor.adaptImportPaths(intermediateServiceModel, _function_2, refinedDataModels);
        final Consumer<AbstractIntermediateModelTransformationStrategy.OutputModel> _function_3 = (AbstractIntermediateModelTransformationStrategy.OutputModel it) -> {
          final Function<EObject, List<IntermediateImport>> _function_4 = (EObject it_1) -> {
            return ((IntermediateDataModel) it_1).getImports();
          };
          MappingModelTransformation.MappingModelRefinementExecutor.adaptImportPaths(it, _function_4, refinedDataModels);
        };
        refinedDataModels.values().forEach(_function_3);
      };
      refinedModelsPerServiceModel.forEach(_function_1);
      return null;
    }
    
    /**
     * Link technology models to MappedComplexType instances in service models. This would
     * normally be done by the transformation strategy implementation, i.e., the
     * IntermediateDataModelRefinement class in this case. However,
     * MappedComplexType.getTypeDefinitionTechnology() passes the eResource of the result of
     * MappedComplexType.getTypeDefinitionTechnologyImport() to
     * LemmaUtils.getImportedModelRoot(), which returns null when the input model is in the XMI
     * format as is the case for the refining transformation of intermediate data models.
     */
    private static void linkTechnologyModels(final AbstractIntermediateModelTransformationStrategy.OutputModel serviceModel, final TechnologyMapping inputMappingModel) {
      EObject _get = serviceModel.getResource().getContents().get(0);
      final ServiceModel serviceModelRoot = ((ServiceModel) _get);
      final Consumer<MappedComplexType> _function = (MappedComplexType mappedType) -> {
        final Function1<ComplexTypeMapping, Boolean> _function_1 = (ComplexTypeMapping mapping) -> {
          return Boolean.valueOf((Objects.equal(mapping.getType().getDataModelImport().getName(), mappedType.getType().getImport().getName()) && 
            Objects.equal(mapping.getType().getType(), mappedType.getType().getType())));
        };
        final ComplexTypeMapping sourceMapping = IterableExtensions.<ComplexTypeMapping>findFirst(inputMappingModel.getTypeMappings(), _function_1);
        mappedType.setT_typeDefinitionTechnology(sourceMapping.getTypeDefinitionTechnology());
        mappedType.setT_typeDefinitionTechnologyImport(sourceMapping.getTypeDefinitionTechnologyImport());
      };
      serviceModelRoot.getMappedComplexTypes().forEach(_function);
    }
    
    /**
     * Helper to retrieve intermediate data models that are imported by intermediate service
     * models produced from a mapping model. Note that the helper maps the service model that
     * precedes the intermediate service model in a mapping model transformation to the found
     * intermediate data models. The reason for this is, that the service model does comprise
     * complex type mappings expressed in mapping models, while the intermediate service model
     * does not.
     */
    private static Map<AbstractIntermediateModelTransformationStrategy.OutputModel, Set<AbstractIntermediateModelTransformationStrategy.OutputModel>> intermediateDataModelsPerServiceModel(final List<AbstractIntermediateModelTransformationStrategy.TransformationResult> results) {
      final Function1<AbstractIntermediateModelTransformationStrategy.TransformationResult, Boolean> _function = (AbstractIntermediateModelTransformationStrategy.TransformationResult it) -> {
        final Function1<AbstractIntermediateModelTransformationStrategy.InputModel, Boolean> _function_1 = (AbstractIntermediateModelTransformationStrategy.InputModel it_1) -> {
          String _namespaceUri = it_1.getNamespaceUri();
          return Boolean.valueOf(Objects.equal(_namespaceUri, MappingPackage.eNS_URI));
        };
        return Boolean.valueOf(IterableExtensions.<AbstractIntermediateModelTransformationStrategy.InputModel>exists(it.getInputModels(), _function_1));
      };
      final Function1<AbstractIntermediateModelTransformationStrategy.TransformationResult, AbstractIntermediateModelTransformationStrategy.OutputModel> _function_1 = (AbstractIntermediateModelTransformationStrategy.TransformationResult it) -> {
        return it.getOutputModel();
      };
      final Iterable<AbstractIntermediateModelTransformationStrategy.OutputModel> serviceModelsCreatedFromMappingModels = IterableExtensions.<AbstractIntermediateModelTransformationStrategy.TransformationResult, AbstractIntermediateModelTransformationStrategy.OutputModel>map(IterableExtensions.<AbstractIntermediateModelTransformationStrategy.TransformationResult>filter(results, _function), _function_1);
      final Function1<AbstractIntermediateModelTransformationStrategy.OutputModel, AbstractIntermediateModelTransformationStrategy.OutputModel> _function_2 = (AbstractIntermediateModelTransformationStrategy.OutputModel it) -> {
        return it;
      };
      final Function1<AbstractIntermediateModelTransformationStrategy.OutputModel, EList<MappedComplexType>> _function_3 = (AbstractIntermediateModelTransformationStrategy.OutputModel it) -> {
        EObject _get = it.getResource().getContents().get(0);
        return ((ServiceModel) _get).getMappedComplexTypes();
      };
      final Map<AbstractIntermediateModelTransformationStrategy.OutputModel, EList<MappedComplexType>> mappedComplexTypesPerServiceModel = IterableExtensions.<AbstractIntermediateModelTransformationStrategy.OutputModel, AbstractIntermediateModelTransformationStrategy.OutputModel, EList<MappedComplexType>>toMap(serviceModelsCreatedFromMappingModels, _function_2, _function_3);
      final HashMap<AbstractIntermediateModelTransformationStrategy.OutputModel, Set<AbstractIntermediateModelTransformationStrategy.OutputModel>> resultMap = CollectionLiterals.<AbstractIntermediateModelTransformationStrategy.OutputModel, Set<AbstractIntermediateModelTransformationStrategy.OutputModel>>newHashMap();
      final BiConsumer<AbstractIntermediateModelTransformationStrategy.OutputModel, EList<MappedComplexType>> _function_4 = (AbstractIntermediateModelTransformationStrategy.OutputModel serviceModel, EList<MappedComplexType> mappedComplexTypes) -> {
        final Consumer<MappedComplexType> _function_5 = (MappedComplexType mappedComplexType) -> {
          final Function1<AbstractIntermediateModelTransformationStrategy.TransformationResult, Boolean> _function_6 = (AbstractIntermediateModelTransformationStrategy.TransformationResult it) -> {
            return Boolean.valueOf((Objects.equal(it.getOutputModel().getNamespaceUri(), IntermediatePackage.eNS_URI) && 
              Objects.equal(it.getOutputModel().getOutputPath(), mappedComplexType.getType().getImport().getImportURI())));
          };
          final Consumer<AbstractIntermediateModelTransformationStrategy.TransformationResult> _function_7 = (AbstractIntermediateModelTransformationStrategy.TransformationResult it) -> {
            Set<AbstractIntermediateModelTransformationStrategy.OutputModel> _putIfAbsent = resultMap.putIfAbsent(serviceModel, CollectionLiterals.<AbstractIntermediateModelTransformationStrategy.OutputModel>newHashSet(it.getOutputModel()));
            if (_putIfAbsent!=null) {
              _putIfAbsent.add(it.getOutputModel());
            }
          };
          IterableExtensions.<AbstractIntermediateModelTransformationStrategy.TransformationResult>filter(results, _function_6).forEach(_function_7);
        };
        mappedComplexTypes.forEach(_function_5);
      };
      mappedComplexTypesPerServiceModel.forEach(_function_4);
      return resultMap;
    }
    
    /**
     * Helper to find the intermediate service model created from a service model in the list of
     * transformation results
     */
    private static AbstractIntermediateModelTransformationStrategy.OutputModel findIntermediateServiceModel(final List<AbstractIntermediateModelTransformationStrategy.TransformationResult> results, final AbstractIntermediateModelTransformationStrategy.OutputModel serviceModel) {
      final Function1<AbstractIntermediateModelTransformationStrategy.TransformationResult, Boolean> _function = (AbstractIntermediateModelTransformationStrategy.TransformationResult it) -> {
        return Boolean.valueOf((Objects.equal(it.getOutputModel().getNamespaceUri(), de.fhdo.lemma.service.intermediate.IntermediatePackage.eNS_URI) && 
          IterableExtensions.<AbstractIntermediateModelTransformationStrategy.InputModel>exists(it.getInputModels(), ((Function1<AbstractIntermediateModelTransformationStrategy.InputModel, Boolean>) (AbstractIntermediateModelTransformationStrategy.InputModel it_1) -> {
            String _inputPath = it_1.getInputPath();
            String _outputPath = serviceModel.getOutputPath();
            return Boolean.valueOf(Objects.equal(_inputPath, _outputPath));
          }))));
      };
      AbstractIntermediateModelTransformationStrategy.TransformationResult _findFirst = IterableExtensions.<AbstractIntermediateModelTransformationStrategy.TransformationResult>findFirst(results, _function);
      AbstractIntermediateModelTransformationStrategy.OutputModel _outputModel = null;
      if (_findFirst!=null) {
        _outputModel=_findFirst.getOutputModel();
      }
      return _outputModel;
    }
    
    /**
     * Helper to adapt import paths in an intermediate model to the paths of refined
     * intermediate data models. This helper also saves the resource of the intermediate model
     * after it has been adapted.
     */
    private static void adaptImportPaths(final AbstractIntermediateModelTransformationStrategy.OutputModel intermediateModel, final Function<EObject, List<IntermediateImport>> getImportsFromModelRoot, final Map<String, AbstractIntermediateModelTransformationStrategy.OutputModel> refinedDataModels) {
      try {
        final EObject modelRoot = intermediateModel.getResource().getContents().get(0);
        final List<IntermediateImport> imports = getImportsFromModelRoot.apply(modelRoot);
        final Function1<IntermediateImport, Boolean> _function = (IntermediateImport it) -> {
          String _importTypeName = it.getImportTypeName();
          String _importTypeNameForDatatypes = it.getImportTypeNameForDatatypes();
          return Boolean.valueOf(Objects.equal(_importTypeName, _importTypeNameForDatatypes));
        };
        final Consumer<IntermediateImport> _function_1 = (IntermediateImport it) -> {
          AbstractIntermediateModelTransformationStrategy.OutputModel _get = refinedDataModels.get(it.getImportUri());
          String _outputPath = null;
          if (_get!=null) {
            _outputPath=_get.getOutputPath();
          }
          final String refinedDataModelUri = _outputPath;
          if ((refinedDataModelUri != null)) {
            it.setImportUri(refinedDataModelUri);
          }
        };
        IterableExtensions.<IntermediateImport>filter(imports, _function).forEach(_function_1);
        intermediateModel.getResource().save(CollectionLiterals.<Object, Object>emptyMap());
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
    
    /**
     * Run refining transformation on an intermediate data model
     */
    private static AbstractIntermediateModelTransformationStrategy.TransformationResult runRefininingTransformation(final AbstractIntermediateModelTransformationStrategy.OutputModel serviceModel, final AbstractIntermediateModelTransformationStrategy.OutputModel intermediateDataModel, final Predicate<IntermediateTransformationException> warningCallback) {
      Resource _resource = intermediateDataModel.getResource();
      Pair<TransformationModelDescription, Resource> _mappedTo = Pair.<TransformationModelDescription, Resource>of(IntermediateDataModelRefinement.IN_MODEL_DESCRIPTION, _resource);
      Resource _resource_1 = serviceModel.getResource();
      Pair<TransformationModelDescription, Resource> _mappedTo_1 = Pair.<TransformationModelDescription, Resource>of(IntermediateDataModelRefinement.SERVICE_MODEL_DESCRIPTION, _resource_1);
      final HashMap<TransformationModelDescription, Resource> inputModelResources = CollectionLiterals.<TransformationModelDescription, Resource>newHashMap(_mappedTo, _mappedTo_1);
      String _buildOutputPathForRefiningTransformation = MappingModelTransformation.MappingModelRefinementExecutor.buildOutputPathForRefiningTransformation(serviceModel, intermediateDataModel);
      Pair<TransformationModelDescription, String> _mappedTo_2 = Pair.<TransformationModelDescription, String>of(IntermediateDataModelRefinement.IN_MODEL_DESCRIPTION, _buildOutputPathForRefiningTransformation);
      final HashMap<TransformationModelDescription, String> outputModelPaths = CollectionLiterals.<TransformationModelDescription, String>newHashMap(_mappedTo_2);
      final IntermediateDataModelRefinement refiningTransformation = new IntermediateDataModelRefinement();
      return refiningTransformation.doTransformationFromResources(inputModelResources, outputModelPaths, 
        null, warningCallback).get(IntermediateDataModelRefinement.IN_MODEL_DESCRIPTION);
    }
    
    /**
     * Helper to build the output path of an intermediate model's refining transformation. It
     * consists of the path to the input service model of the transformation with its extension
     * removed, the alias of the import of the data model in the service model and the name of
     * the intermediate data model.
     * 
     * For instance, for the service model "/foo/bar/ServiceModel.xmi" that imports a data model
     * "DataModel.xmi" under the alias "domain" the resulting output path will be
     * "/foo/bar/ServiceModel/domain_DataModel.xmi". Note, that the name of the service models
     * becomes a folder to host the refined models.
     */
    private static String buildOutputPathForRefiningTransformation(final AbstractIntermediateModelTransformationStrategy.OutputModel serviceModel, final AbstractIntermediateModelTransformationStrategy.OutputModel intermediateDataModel) {
      EObject _get = serviceModel.getResource().getContents().get(0);
      final ServiceModel serviceModelRoot = ((ServiceModel) _get);
      final Function1<Import, Boolean> _function = (Import it) -> {
        String _importURI = it.getImportURI();
        String _outputPath = intermediateDataModel.getOutputPath();
        return Boolean.valueOf(Objects.equal(_importURI, _outputPath));
      };
      final String dataModelAlias = IterableExtensions.<Import>findFirst(serviceModelRoot.getImports(), _function).getName();
      final String refinedModelTargetFolder = LemmaUtils.removeExtension(serviceModel.getOutputPath());
      String _outputPath = intermediateDataModel.getOutputPath();
      final String refinedModelName = new File(_outputPath).getName();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(dataModelAlias);
      _builder.append("_");
      _builder.append(refinedModelName);
      final String prefixedRefinedModelName = _builder.toString();
      return LemmaUtils.joinPathSegments(refinedModelTargetFolder, prefixedRefinedModelName);
    }
  }
  
  private String absoluteInputModelPath;
  
  private TechnologyMapping inputMappingModel;
  
  /**
   * Specify reference name and transformation model type of input model
   */
  @Override
  public Pair<String, TransformationModelType> getInputModelReferenceNameAndType() {
    TransformationModelType _transformationModelType = new TransformationModelType(MappingPackage.eNS_URI, MappingPackage.eINSTANCE, 
      TechnologyMapping.class);
    return Pair.<String, TransformationModelType>of("Mapping", _transformationModelType);
  }
  
  /**
   * Specify reference name and transformation model type of output model
   */
  @Override
  public Pair<String, TransformationModelType> getOutputModelReferenceNameAndType() {
    TransformationModelType _transformationModelType = new TransformationModelType(ServicePackage.eNS_URI, ServicePackage.eINSTANCE, 
      ServiceModel.class);
    return Pair.<String, TransformationModelType>of("Service", _transformationModelType);
  }
  
  /**
   * Specify path to the compiled ATL transformation file
   */
  @Override
  public String getCompiledModelTransformationFilePath() {
    return "/MappingModelTransformation.asm";
  }
  
  /**
   * Fetch path of input model prior to transformation execution
   */
  @Override
  public void beforeTransformationHook(final Map<TransformationModelDescription, String> absoluteInputModelPaths) {
    this.absoluteInputModelPath = ((String[])Conversions.unwrapArray(absoluteInputModelPaths.values(), String.class))[0];
  }
  
  /**
   * Prepare input model
   */
  @Override
  public void prepareInputModel(final TransformationModelDescription modelDescription, final EObject modelRoot) {
    this.inputMappingModel = ((TechnologyMapping) modelRoot);
    this.convertImportUrisToAbsoluteFileUris(this.inputMappingModel.getImports(), this.absoluteInputModelPath);
    this.setSourceModelUris(this.inputMappingModel);
  }
  
  /**
   * Transformation preparation: Convert import URIs of imported model files to absolute file
   * URIs. Otherwise the transformation won't have access to them and the contained model
   * elements.
   */
  private void convertImportUrisToAbsoluteFileUris(final List<Import> imports, final String modelFilePath) {
    final Consumer<Import> _function = (Import it) -> {
      boolean _isFileUri = LemmaUtils.isFileUri(it.getImportURI());
      boolean _not = (!_isFileUri);
      if (_not) {
        it.setImportURI(LemmaUtils.convertToFileUri(
          LemmaUtils.convertToAbsolutePath(it.getImportURI(), modelFilePath)));
      }
    };
    imports.forEach(_function);
  }
  
  /**
   * Transformation preparation: Set source model URIs on complex type and technology-specific
   * field mappings. They are later used to distinguish eponymous mapped fields defined in
   * different data models.
   */
  private void setSourceModelUris(final TechnologyMapping mappingModelRoot) {
    List<ComplexTypeMapping> _allContentsOfType = EcoreUtil2.<ComplexTypeMapping>getAllContentsOfType(mappingModelRoot, ComplexTypeMapping.class);
    final Function1<ComplexParameterMapping, EList<TechnologySpecificFieldMapping>> _function = (ComplexParameterMapping it) -> {
      return it.getFieldMappings();
    };
    Iterable<TechnologySpecificFieldMapping> _flatten = Iterables.<TechnologySpecificFieldMapping>concat(ListExtensions.<ComplexParameterMapping, EList<TechnologySpecificFieldMapping>>map(mappingModelRoot.getComplexParameterMappings(), _function));
    final Iterable<EObject> typeMappings = Iterables.<EObject>concat(_allContentsOfType, _flatten);
    final Consumer<EObject> _function_1 = (EObject it) -> {
      try {
        final String serviceModelUri = LemmaUtils.removeFileUri(this.getServiceModelUri(it));
        final String dataModelUri = LemmaUtils.removeFileUri(this.getDataModelUri(it));
        String _convertToAbsolutePath = LemmaUtils.convertToAbsolutePath(dataModelUri, serviceModelUri);
        String absoluteDataModelUri = LemmaUtils.convertToFileUri(
          new File(_convertToAbsolutePath).getCanonicalPath());
        boolean _matched = false;
        if (it instanceof ComplexTypeMapping) {
          _matched=true;
          ((ComplexTypeMapping)it).setT_sourceModelUri(absoluteDataModelUri);
        }
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    typeMappings.forEach(_function_1);
  }
  
  /**
   * Get service model URI of complex type mapping
   */
  private String _getServiceModelUri(final ComplexTypeMapping complexTypeMapping) {
    return complexTypeMapping.getType().getServiceModelImport().getImportURI();
  }
  
  /**
   * Get service model URI of technology-specific field mapping
   */
  private String _getServiceModelUri(final TechnologySpecificFieldMapping mapping) {
    Import _elvis = null;
    ComplexTypeMapping _containerOfType = EcoreUtil2.<ComplexTypeMapping>getContainerOfType(mapping, ComplexTypeMapping.class);
    ImportedComplexType _type = null;
    if (_containerOfType!=null) {
      _type=_containerOfType.getType();
    }
    Import _serviceModelImport = null;
    if (_type!=null) {
      _serviceModelImport=_type.getServiceModelImport();
    }
    if (_serviceModelImport != null) {
      _elvis = _serviceModelImport;
    } else {
      Import _import = EcoreUtil2.<MicroserviceMapping>getContainerOfType(mapping, MicroserviceMapping.class).getMicroservice().getImport();
      _elvis = _import;
    }
    final Import serviceModelImport = _elvis;
    return serviceModelImport.getImportURI();
  }
  
  /**
   * Get data model URI of complex type mapping
   */
  private String _getDataModelUri(final ComplexTypeMapping complexTypeMapping) {
    return complexTypeMapping.getType().getDataModelImport().getImportURI();
  }
  
  /**
   * Get data model URI of technology-specific field mapping
   */
  private String _getDataModelUri(final TechnologySpecificFieldMapping mapping) {
    return mapping.getOriginalTypeOfMappedElement().eResource().getURI().toString();
  }
  
  /**
   * Specify validator for input model
   */
  @Override
  public AbstractInputModelValidator getInputModelValidator(final TransformationModelDescription modelDescription) {
    return new MappingModelTransformationValidator();
  }
  
  /**
   * Consider imports of imported service models to build import target paths. Otherwise the paths
   * of domain models imported by mapped service models will point to their original destination
   * instead of those of the intermediate models they get possibly transformed to within the
   * transformation process.
   */
  @Override
  public boolean considerChildrensChildrenForImportTargetPaths() {
    return true;
  }
  
  /**
   * Add transformation target paths of imported model files to target model
   */
  @Override
  public void populateOutputModelWithImportTargetPaths(final TransformationModelDescription modelDescription, final EObject modelRoot, final Map<String, String> targetPaths) {
    final ServiceModel serviceModelRoot = ((ServiceModel) modelRoot);
    final String workspacePath = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
    final BiConsumer<String, String> _function = (String importName, String targetPath) -> {
      final Function1<Import, Boolean> _function_1 = (Import it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, importName));
      };
      final Import import_ = IterableExtensions.<Import>findFirst(serviceModelRoot.getImports(), _function_1);
      import_.setImportURI(LemmaUtils.convertToFileUri((workspacePath + targetPath)));
    };
    targetPaths.forEach(_function);
  }
  
  /**
   * Register listener to be invoked after all transformations of a transformation run were
   * finished
   */
  @Override
  public BiFunction<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, Void> registerTransformationsFinishedListener() {
    final BiFunction<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, Void> _function = (List<AbstractIntermediateModelTransformationStrategy.TransformationResult> results, Predicate<IntermediateTransformationException> warningCallback) -> {
      return MappingModelTransformation.MappingModelRefinementExecutor.executeRefinements(this.inputMappingModel, results, warningCallback);
    };
    return _function;
  }
  
  private String getServiceModelUri(final EObject complexTypeMapping) {
    if (complexTypeMapping instanceof ComplexTypeMapping) {
      return _getServiceModelUri((ComplexTypeMapping)complexTypeMapping);
    } else if (complexTypeMapping instanceof TechnologySpecificFieldMapping) {
      return _getServiceModelUri((TechnologySpecificFieldMapping)complexTypeMapping);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(complexTypeMapping).toString());
    }
  }
  
  private String getDataModelUri(final EObject complexTypeMapping) {
    if (complexTypeMapping instanceof ComplexTypeMapping) {
      return _getDataModelUri((ComplexTypeMapping)complexTypeMapping);
    } else if (complexTypeMapping instanceof TechnologySpecificFieldMapping) {
      return _getDataModelUri((TechnologySpecificFieldMapping)complexTypeMapping);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(complexTypeMapping).toString());
    }
  }
}
