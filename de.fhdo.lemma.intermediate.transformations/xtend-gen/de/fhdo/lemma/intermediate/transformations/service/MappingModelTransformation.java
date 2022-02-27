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
import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.ImportType;
import de.fhdo.lemma.service.MappedComplexType;
import de.fhdo.lemma.service.ServiceModel;
import de.fhdo.lemma.service.ServicePackage;
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel;
import de.fhdo.lemma.technology.mapping.ComplexParameterMapping;
import de.fhdo.lemma.technology.mapping.ComplexTypeMapping;
import de.fhdo.lemma.technology.mapping.ImportedComplexTypeToMap;
import de.fhdo.lemma.technology.mapping.MappingPackage;
import de.fhdo.lemma.technology.mapping.MicroserviceMapping;
import de.fhdo.lemma.technology.mapping.TechnologyMapping;
import de.fhdo.lemma.technology.mapping.TechnologySpecificFieldMapping;
import de.fhdo.lemma.utils.LemmaUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
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
    private static List<AbstractIntermediateModelTransformationStrategy.TransformationResult> executeRefinements(final TechnologyMapping inputMappingModel, final String absoluteInputModelPath, final List<AbstractIntermediateModelTransformationStrategy.TransformationResult> results, final Predicate<IntermediateTransformationException> warningCallback) {
      final HashMap<AbstractIntermediateModelTransformationStrategy.OutputModel, Map<AbstractIntermediateModelTransformationStrategy.OutputModel, AbstractIntermediateModelTransformationStrategy.OutputModel>> refinedModelsPerServiceModel = CollectionLiterals.<AbstractIntermediateModelTransformationStrategy.OutputModel, Map<AbstractIntermediateModelTransformationStrategy.OutputModel, AbstractIntermediateModelTransformationStrategy.OutputModel>>newHashMap();
      final ArrayList<AbstractIntermediateModelTransformationStrategy.TransformationResult> unrefinedIntermediateDataModels = CollectionLiterals.<AbstractIntermediateModelTransformationStrategy.TransformationResult>newArrayList();
      final Map<AbstractIntermediateModelTransformationStrategy.OutputModel, Set<AbstractIntermediateModelTransformationStrategy.TransformationResult>> intermediateDataModelsPerServiceModel = MappingModelTransformation.MappingModelRefinementExecutor.intermediateDataModelsPerServiceModelFor(results, inputMappingModel, absoluteInputModelPath);
      Set<Map.Entry<AbstractIntermediateModelTransformationStrategy.OutputModel, Set<AbstractIntermediateModelTransformationStrategy.TransformationResult>>> _entrySet = intermediateDataModelsPerServiceModel.entrySet();
      for (final Map.Entry<AbstractIntermediateModelTransformationStrategy.OutputModel, Set<AbstractIntermediateModelTransformationStrategy.TransformationResult>> entry : _entrySet) {
        {
          final AbstractIntermediateModelTransformationStrategy.OutputModel serviceModel = entry.getKey();
          final Set<AbstractIntermediateModelTransformationStrategy.TransformationResult> intermediateDataModels = entry.getValue();
          MappingModelTransformation.MappingModelRefinementExecutor.linkTechnologyModels(serviceModel, inputMappingModel);
          final HashMap<AbstractIntermediateModelTransformationStrategy.OutputModel, AbstractIntermediateModelTransformationStrategy.TransformationResult> refinedModels = CollectionLiterals.<AbstractIntermediateModelTransformationStrategy.OutputModel, AbstractIntermediateModelTransformationStrategy.TransformationResult>newHashMap();
          final Consumer<AbstractIntermediateModelTransformationStrategy.TransformationResult> _function = (AbstractIntermediateModelTransformationStrategy.TransformationResult it) -> {
            List<AbstractIntermediateModelTransformationStrategy.InputModel> _inputModels = it.getInputModels();
            String _outputPath = it.getOutputModel().getOutputPath();
            String _namespaceUri = it.getOutputModel().getNamespaceUri();
            Resource _loadXmiResource = MappingModelTransformation.MappingModelRefinementExecutor.loadXmiResource(it.getOutputModel().getOutputPath());
            AbstractIntermediateModelTransformationStrategy.OutputModel _outputModel = new AbstractIntermediateModelTransformationStrategy.OutputModel(_outputPath, _namespaceUri, _loadXmiResource);
            AbstractIntermediateModelTransformationStrategy.TransformationResult _transformationResult = new AbstractIntermediateModelTransformationStrategy.TransformationResult(_inputModels, _outputModel);
            unrefinedIntermediateDataModels.add(_transformationResult);
            refinedModels.put(
              it.getOutputModel(), 
              MappingModelTransformation.MappingModelRefinementExecutor.runRefininingTransformation(results, serviceModel, it.getOutputModel(), warningCallback));
          };
          intermediateDataModels.forEach(_function);
          final Function2<AbstractIntermediateModelTransformationStrategy.OutputModel, AbstractIntermediateModelTransformationStrategy.TransformationResult, Boolean> _function_1 = (AbstractIntermediateModelTransformationStrategy.OutputModel path, AbstractIntermediateModelTransformationStrategy.TransformationResult model) -> {
            return Boolean.valueOf((model != null));
          };
          final BiConsumer<AbstractIntermediateModelTransformationStrategy.OutputModel, AbstractIntermediateModelTransformationStrategy.TransformationResult> _function_2 = (AbstractIntermediateModelTransformationStrategy.OutputModel originalOutputModel, AbstractIntermediateModelTransformationStrategy.TransformationResult refinedModel) -> {
            AbstractIntermediateModelTransformationStrategy.OutputModel _outputModel = refinedModel.getOutputModel();
            Pair<AbstractIntermediateModelTransformationStrategy.OutputModel, AbstractIntermediateModelTransformationStrategy.OutputModel> _mappedTo = Pair.<AbstractIntermediateModelTransformationStrategy.OutputModel, AbstractIntermediateModelTransformationStrategy.OutputModel>of(originalOutputModel, _outputModel);
            Map<AbstractIntermediateModelTransformationStrategy.OutputModel, AbstractIntermediateModelTransformationStrategy.OutputModel> _putIfAbsent = refinedModelsPerServiceModel.putIfAbsent(serviceModel, 
              CollectionLiterals.<AbstractIntermediateModelTransformationStrategy.OutputModel, AbstractIntermediateModelTransformationStrategy.OutputModel>newHashMap(_mappedTo));
            if (_putIfAbsent!=null) {
              _putIfAbsent.put(originalOutputModel, refinedModel.getOutputModel());
            }
          };
          MapExtensions.<AbstractIntermediateModelTransformationStrategy.OutputModel, AbstractIntermediateModelTransformationStrategy.TransformationResult>filter(refinedModels, _function_1).forEach(_function_2);
        }
      }
      final BiConsumer<AbstractIntermediateModelTransformationStrategy.OutputModel, Map<AbstractIntermediateModelTransformationStrategy.OutputModel, AbstractIntermediateModelTransformationStrategy.OutputModel>> _function = (AbstractIntermediateModelTransformationStrategy.OutputModel serviceModel, Map<AbstractIntermediateModelTransformationStrategy.OutputModel, AbstractIntermediateModelTransformationStrategy.OutputModel> refinedDataModels) -> {
        final AbstractIntermediateModelTransformationStrategy.OutputModel intermediateServiceModel = MappingModelTransformation.MappingModelRefinementExecutor.findIntermediateServiceModel(results, serviceModel);
        final Function<EObject, List<IntermediateImport>> _function_1 = (EObject it) -> {
          return ((IntermediateServiceModel) it).getImports();
        };
        MappingModelTransformation.MappingModelRefinementExecutor.adaptImportPaths(intermediateServiceModel, _function_1, refinedDataModels);
        final Consumer<AbstractIntermediateModelTransformationStrategy.OutputModel> _function_2 = (AbstractIntermediateModelTransformationStrategy.OutputModel it) -> {
          final Function<EObject, List<IntermediateImport>> _function_3 = (EObject it_1) -> {
            return ((IntermediateDataModel) it_1).getImports();
          };
          MappingModelTransformation.MappingModelRefinementExecutor.adaptImportPaths(it, _function_3, refinedDataModels);
        };
        refinedDataModels.values().forEach(_function_2);
        final BiConsumer<AbstractIntermediateModelTransformationStrategy.OutputModel, AbstractIntermediateModelTransformationStrategy.OutputModel> _function_3 = (AbstractIntermediateModelTransformationStrategy.OutputModel outputModel, AbstractIntermediateModelTransformationStrategy.OutputModel refinedModel) -> {
          outputModel.setOutputPath(refinedModel.getOutputPath());
        };
        refinedDataModels.forEach(_function_3);
      };
      refinedModelsPerServiceModel.forEach(_function);
      return unrefinedIntermediateDataModels;
    }
    
    /**
     * Parse an XMI file with from the given URI
     */
    private static Resource loadXmiResource(final String fileUri) {
      try {
        final ResourceSetImpl resourceSet = new ResourceSetImpl();
        Map<String, Object> _extensionToFactoryMap = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
        XMIResourceFactoryImpl _xMIResourceFactoryImpl = new XMIResourceFactoryImpl();
        _extensionToFactoryMap.put("xmi", _xMIResourceFactoryImpl);
        final Resource resource = resourceSet.createResource(URI.createURI(fileUri));
        resource.load(null);
        return resource;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
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
     * models produced from the input mapping model. Note that the helper maps the original
     * service model of the intermediate service model in a mapping model transformation to the
     * TransformationResult instances of found intermediate data models. The reason for this is,
     * that the service model does comprise complex type mappings expressed in mapping models,
     * while the intermediate service model does not.
     */
    private static Map<AbstractIntermediateModelTransformationStrategy.OutputModel, Set<AbstractIntermediateModelTransformationStrategy.TransformationResult>> intermediateDataModelsPerServiceModelFor(final List<AbstractIntermediateModelTransformationStrategy.TransformationResult> results, final TechnologyMapping inputMappingModel, final String absoluteInputModelPath) {
      final String inputMappingModelPath = LemmaUtils.convertToFileUri(absoluteInputModelPath);
      final Function1<AbstractIntermediateModelTransformationStrategy.TransformationResult, Boolean> _function = (AbstractIntermediateModelTransformationStrategy.TransformationResult it) -> {
        final Function1<AbstractIntermediateModelTransformationStrategy.InputModel, Boolean> _function_1 = (AbstractIntermediateModelTransformationStrategy.InputModel it_1) -> {
          return Boolean.valueOf((Objects.equal(it_1.getNamespaceUri(), MappingPackage.eNS_URI) && 
            Objects.equal(it_1.getInputPath(), inputMappingModelPath)));
        };
        return Boolean.valueOf(IterableExtensions.<AbstractIntermediateModelTransformationStrategy.InputModel>exists(it.getInputModels(), _function_1));
      };
      final Function1<AbstractIntermediateModelTransformationStrategy.TransformationResult, AbstractIntermediateModelTransformationStrategy.OutputModel> _function_1 = (AbstractIntermediateModelTransformationStrategy.TransformationResult it) -> {
        return it.getOutputModel();
      };
      final Iterable<AbstractIntermediateModelTransformationStrategy.OutputModel> serviceModelsCreatedFromMappingModel = IterableExtensions.<AbstractIntermediateModelTransformationStrategy.TransformationResult, AbstractIntermediateModelTransformationStrategy.OutputModel>map(IterableExtensions.<AbstractIntermediateModelTransformationStrategy.TransformationResult>filter(results, _function), _function_1);
      final Function1<AbstractIntermediateModelTransformationStrategy.OutputModel, AbstractIntermediateModelTransformationStrategy.OutputModel> _function_2 = (AbstractIntermediateModelTransformationStrategy.OutputModel it) -> {
        return it;
      };
      final Function1<AbstractIntermediateModelTransformationStrategy.OutputModel, EList<MappedComplexType>> _function_3 = (AbstractIntermediateModelTransformationStrategy.OutputModel it) -> {
        EObject _get = it.getResource().getContents().get(0);
        return ((ServiceModel) _get).getMappedComplexTypes();
      };
      final Map<AbstractIntermediateModelTransformationStrategy.OutputModel, EList<MappedComplexType>> mappedComplexTypesPerServiceModel = IterableExtensions.<AbstractIntermediateModelTransformationStrategy.OutputModel, AbstractIntermediateModelTransformationStrategy.OutputModel, EList<MappedComplexType>>toMap(serviceModelsCreatedFromMappingModel, _function_2, _function_3);
      final HashMap<AbstractIntermediateModelTransformationStrategy.OutputModel, Set<AbstractIntermediateModelTransformationStrategy.TransformationResult>> resultMap = CollectionLiterals.<AbstractIntermediateModelTransformationStrategy.OutputModel, Set<AbstractIntermediateModelTransformationStrategy.TransformationResult>>newHashMap();
      final BiConsumer<AbstractIntermediateModelTransformationStrategy.OutputModel, EList<MappedComplexType>> _function_4 = (AbstractIntermediateModelTransformationStrategy.OutputModel serviceModel, EList<MappedComplexType> mappedComplexTypes) -> {
        final Consumer<MappedComplexType> _function_5 = (MappedComplexType mappedComplexType) -> {
          final Function1<AbstractIntermediateModelTransformationStrategy.TransformationResult, Boolean> _function_6 = (AbstractIntermediateModelTransformationStrategy.TransformationResult it) -> {
            return Boolean.valueOf((Objects.equal(it.getOutputModel().getNamespaceUri(), IntermediatePackage.eNS_URI) && 
              (Objects.equal(it.getOutputModel().getOutputPath(), mappedComplexType.getType().getImport().getImportURI()) || 
                Objects.equal(it.getInputModels().get(0).getInputPath(), mappedComplexType.getT_sourceModelUri()))));
          };
          final Consumer<AbstractIntermediateModelTransformationStrategy.TransformationResult> _function_7 = (AbstractIntermediateModelTransformationStrategy.TransformationResult it) -> {
            Set<AbstractIntermediateModelTransformationStrategy.TransformationResult> _putIfAbsent = resultMap.putIfAbsent(serviceModel, CollectionLiterals.<AbstractIntermediateModelTransformationStrategy.TransformationResult>newHashSet(it));
            if (_putIfAbsent!=null) {
              _putIfAbsent.add(it);
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
    private static void adaptImportPaths(final AbstractIntermediateModelTransformationStrategy.OutputModel intermediateModel, final Function<EObject, List<IntermediateImport>> getImportsFromModelRoot, final Map<AbstractIntermediateModelTransformationStrategy.OutputModel, AbstractIntermediateModelTransformationStrategy.OutputModel> refinedDataModels) {
      try {
        final EObject modelRoot = intermediateModel.getResource().getContents().get(0);
        final List<IntermediateImport> imports = getImportsFromModelRoot.apply(modelRoot);
        final HashMap<String, AbstractIntermediateModelTransformationStrategy.OutputModel> refinedModelPerOriginalPaths = CollectionLiterals.<String, AbstractIntermediateModelTransformationStrategy.OutputModel>newHashMap();
        final BiConsumer<AbstractIntermediateModelTransformationStrategy.OutputModel, AbstractIntermediateModelTransformationStrategy.OutputModel> _function = (AbstractIntermediateModelTransformationStrategy.OutputModel originalModel, AbstractIntermediateModelTransformationStrategy.OutputModel refinedModel) -> {
          refinedModelPerOriginalPaths.put(originalModel.getOutputPath(), refinedModel);
        };
        refinedDataModels.forEach(_function);
        final Function1<IntermediateImport, Boolean> _function_1 = (IntermediateImport it) -> {
          String _importTypeName = it.getImportTypeName();
          String _importTypeNameForDatatypes = it.getImportTypeNameForDatatypes();
          return Boolean.valueOf(Objects.equal(_importTypeName, _importTypeNameForDatatypes));
        };
        final Consumer<IntermediateImport> _function_2 = (IntermediateImport dataModelImport) -> {
          final String importUri = dataModelImport.getImportUri();
          AbstractIntermediateModelTransformationStrategy.OutputModel _get = refinedModelPerOriginalPaths.get(importUri);
          String _outputPath = null;
          if (_get!=null) {
            _outputPath=_get.getOutputPath();
          }
          String refinedDataModelUri = _outputPath;
          if ((refinedDataModelUri == null)) {
            final Function1<AbstractIntermediateModelTransformationStrategy.OutputModel, Boolean> _function_3 = (AbstractIntermediateModelTransformationStrategy.OutputModel it) -> {
              EObject _get_1 = it.getResource().getContents().get(0);
              String _sourceModelUri = ((IntermediateDataModel) _get_1).getSourceModelUri();
              return Boolean.valueOf(Objects.equal(_sourceModelUri, importUri));
            };
            AbstractIntermediateModelTransformationStrategy.OutputModel _findFirst = IterableExtensions.<AbstractIntermediateModelTransformationStrategy.OutputModel>findFirst(refinedDataModels.values(), _function_3);
            String _outputPath_1 = null;
            if (_findFirst!=null) {
              _outputPath_1=_findFirst.getOutputPath();
            }
            refinedDataModelUri = _outputPath_1;
          }
          if ((refinedDataModelUri != null)) {
            dataModelImport.setImportUri(refinedDataModelUri);
          }
        };
        IterableExtensions.<IntermediateImport>filter(imports, _function_1).forEach(_function_2);
        intermediateModel.getResource().save(CollectionLiterals.<Object, Object>emptyMap());
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
    
    /**
     * Run refining transformation on an intermediate data model
     */
    private static AbstractIntermediateModelTransformationStrategy.TransformationResult runRefininingTransformation(final List<AbstractIntermediateModelTransformationStrategy.TransformationResult> results, final AbstractIntermediateModelTransformationStrategy.OutputModel serviceModel, final AbstractIntermediateModelTransformationStrategy.OutputModel intermediateDataModel, final Predicate<IntermediateTransformationException> warningCallback) {
      Resource _resource = intermediateDataModel.getResource();
      Pair<TransformationModelDescription, Resource> _mappedTo = Pair.<TransformationModelDescription, Resource>of(IntermediateDataModelRefinement.IN_MODEL_DESCRIPTION, _resource);
      Resource _resource_1 = serviceModel.getResource();
      Pair<TransformationModelDescription, Resource> _mappedTo_1 = Pair.<TransformationModelDescription, Resource>of(IntermediateDataModelRefinement.SERVICE_MODEL_DESCRIPTION, _resource_1);
      final HashMap<TransformationModelDescription, Resource> inputModelResources = CollectionLiterals.<TransformationModelDescription, Resource>newHashMap(_mappedTo, _mappedTo_1);
      String _buildOutputPathForRefiningTransformation = MappingModelTransformation.MappingModelRefinementExecutor.buildOutputPathForRefiningTransformation(results, serviceModel, intermediateDataModel);
      Pair<TransformationModelDescription, String> _mappedTo_2 = Pair.<TransformationModelDescription, String>of(IntermediateDataModelRefinement.IN_MODEL_DESCRIPTION, _buildOutputPathForRefiningTransformation);
      final HashMap<TransformationModelDescription, String> outputModelPaths = CollectionLiterals.<TransformationModelDescription, String>newHashMap(_mappedTo_2);
      final IntermediateDataModelRefinement refiningTransformation = new IntermediateDataModelRefinement();
      final AbstractIntermediateModelTransformationStrategy.TransformationResult refiningResult = refiningTransformation.doTransformationFromResources(inputModelResources, outputModelPaths, 
        null, warningCallback).get(IntermediateDataModelRefinement.IN_MODEL_DESCRIPTION);
      final Iterator<EObject> iter = refiningResult.getOutputModel().getResource().getContents().iterator();
      while (iter.hasNext()) {
        EObject _next = iter.next();
        boolean _not = (!(_next instanceof IntermediateDataModel));
        if (_not) {
          iter.remove();
        }
      }
      return refiningResult;
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
    private static String buildOutputPathForRefiningTransformation(final List<AbstractIntermediateModelTransformationStrategy.TransformationResult> results, final AbstractIntermediateModelTransformationStrategy.OutputModel serviceModel, final AbstractIntermediateModelTransformationStrategy.OutputModel intermediateDataModel) {
      EObject _get = serviceModel.getResource().getContents().get(0);
      final ServiceModel serviceModelRoot = ((ServiceModel) _get);
      final Function1<Import, Boolean> _function = (Import it) -> {
        String _importURI = it.getImportURI();
        String _outputPath = intermediateDataModel.getOutputPath();
        return Boolean.valueOf(Objects.equal(_importURI, _outputPath));
      };
      Import dataModelImport = IterableExtensions.<Import>findFirst(serviceModelRoot.getImports(), _function);
      if ((dataModelImport == null)) {
        final AbstractIntermediateModelTransformationStrategy.InputModel inputServiceModel = MappingModelTransformation.findInputModelFor(results, serviceModel);
        final AbstractIntermediateModelTransformationStrategy.InputModel inputDataModel = MappingModelTransformation.findInputModelFor(results, intermediateDataModel);
        final Function1<Import, Boolean> _function_1 = (Import it) -> {
          boolean _xifexpression = false;
          ImportType _importType = it.getImportType();
          boolean _equals = Objects.equal(_importType, ImportType.DATATYPES);
          if (_equals) {
            boolean _xblockexpression = false;
            {
              final String absoluteDataModelImportUri = LemmaUtils.convertToAbsoluteFileUri(
                it.getImportURI(), 
                LemmaUtils.getAbsolutePath(inputServiceModel.getFile()));
              String _inputPath = inputDataModel.getInputPath();
              _xblockexpression = Objects.equal(absoluteDataModelImportUri, _inputPath);
            }
            _xifexpression = _xblockexpression;
          } else {
            _xifexpression = false;
          }
          return Boolean.valueOf(_xifexpression);
        };
        dataModelImport = IterableExtensions.<Import>findFirst(serviceModelRoot.getImports(), _function_1);
      }
      final String refinedModelTargetFolder = LemmaUtils.removeExtension(serviceModel.getOutputPath());
      String _outputPath = intermediateDataModel.getOutputPath();
      final String refinedModelName = new File(_outputPath).getName();
      StringConcatenation _builder = new StringConcatenation();
      String _name = dataModelImport.getName();
      _builder.append(_name);
      _builder.append("_");
      _builder.append(refinedModelName);
      final String prefixedRefinedModelName = _builder.toString();
      return LemmaUtils.joinPathSegments(refinedModelTargetFolder, prefixedRefinedModelName);
    }
  }
  
  private String absoluteInputModelFilePath;
  
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
   * Fetch input model and output model file prior to transformation execution
   */
  @Override
  public void beforeTransformationHook(final Map<TransformationModelDescription, IFile> inputModelFiles, final Map<TransformationModelDescription, String> outputModelPaths) {
    this.absoluteInputModelFilePath = LemmaUtils.getAbsolutePath(((IFile[])Conversions.unwrapArray(inputModelFiles.values(), IFile.class))[0]);
  }
  
  /**
   * Prepare input model
   */
  @Override
  public void prepareInputModel(final TransformationModelDescription modelDescription, final EObject modelRoot) {
    this.inputMappingModel = ((TechnologyMapping) modelRoot);
    this.convertImportUrisToAbsoluteFileUris(this.inputMappingModel.getImports(), this.absoluteInputModelFilePath);
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
    ImportedComplexTypeToMap _type = null;
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
    final BiConsumer<String, String> _function = (String importName, String targetPath) -> {
      final Function1<Import, Boolean> _function_1 = (Import it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, importName));
      };
      final Import import_ = IterableExtensions.<Import>findFirst(serviceModelRoot.getImports(), _function_1);
      if ((import_ != null)) {
        import_.setImportURI(LemmaUtils.convertProjectPathToAbsoluteFileUri(targetPath));
      }
    };
    targetPaths.forEach(_function);
    final Function1<Import, Boolean> _function_1 = (Import it) -> {
      return Boolean.valueOf(((!LemmaUtils.isFileUri(it.getImportURI())) && 
        Objects.equal(it.getImportType(), ImportType.DATATYPES)));
    };
    final Consumer<Import> _function_2 = (Import targetImport) -> {
      final Function1<MappedComplexType, Boolean> _function_3 = (MappedComplexType it) -> {
        String _name = it.getType().getImport().getName();
        String _name_1 = targetImport.getName();
        return Boolean.valueOf(Objects.equal(_name, _name_1));
      };
      final MappedComplexType mappedComplexTypeWithTargetImport = IterableExtensions.<MappedComplexType>findFirst(serviceModelRoot.getMappedComplexTypes(), _function_3);
      if ((mappedComplexTypeWithTargetImport != null)) {
        targetImport.setImportURI(mappedComplexTypeWithTargetImport.getT_sourceModelUri());
      }
      boolean _isFileUri = LemmaUtils.isFileUri(targetImport.getImportURI());
      boolean _not = (!_isFileUri);
      if (_not) {
        targetImport.setImportURI(this.findSourceModelUriOfDataModel(serviceModelRoot, targetImport));
      }
    };
    IterableExtensions.<Import>filter(serviceModelRoot.getImports(), _function_1).forEach(_function_2);
  }
  
  /**
   * Find URI of a data model via the import relationships service model --> intermediate service
   * model --> intermediate data model.
   */
  private String findSourceModelUriOfDataModel(final ServiceModel serviceModel, final Import targetImport) {
    final String intermediateServiceModelAlias = targetImport.getT_relatedImportAlias();
    if (((intermediateServiceModelAlias == null) || intermediateServiceModelAlias.isEmpty())) {
      return targetImport.getImportURI();
    }
    final Function1<Import, Boolean> _function = (Import it) -> {
      String _name = it.getName();
      return Boolean.valueOf(Objects.equal(_name, intermediateServiceModelAlias));
    };
    final Import intermediateServiceModelImport = IterableExtensions.<Import>findFirst(serviceModel.getImports(), _function);
    final IntermediateServiceModel intermediateServiceModel = LemmaUtils.<IntermediateServiceModel>getImportedModelRoot(
      intermediateServiceModelImport.eResource(), 
      intermediateServiceModelImport.getImportURI(), 
      IntermediateServiceModel.class);
    final Function1<IntermediateImport, Boolean> _function_1 = (IntermediateImport it) -> {
      String _name = it.getName();
      String _name_1 = targetImport.getName();
      return Boolean.valueOf(Objects.equal(_name, _name_1));
    };
    final IntermediateImport intermediateDataModelImport = IterableExtensions.<IntermediateImport>findFirst(intermediateServiceModel.getImports(), _function_1);
    final IntermediateDataModel intermediateDataModel = LemmaUtils.<IntermediateDataModel>getImportedModelRoot(
      intermediateDataModelImport.eResource(), 
      intermediateDataModelImport.getImportUri(), 
      IntermediateDataModel.class);
    return intermediateDataModel.getSourceModelUri();
  }
  
  /**
   * Register listener to be invoked after all transformations of a transformation run were
   * finished
   */
  @Override
  public Function2<? super List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, ? super Predicate<IntermediateTransformationException>, ? extends List<AbstractIntermediateModelTransformationStrategy.TransformationResult>> registerTransformationsFinishedListener() {
    final Function2<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, List<AbstractIntermediateModelTransformationStrategy.TransformationResult>> _function = (List<AbstractIntermediateModelTransformationStrategy.TransformationResult> results, Predicate<IntermediateTransformationException> warningCallback) -> {
      return MappingModelTransformation.MappingModelRefinementExecutor.executeRefinements(this.inputMappingModel, 
        this.absoluteInputModelFilePath, results, warningCallback);
    };
    return _function;
  }
  
  /**
   * Convert URIs in intermediate models that occurred from the transformation of a mapping model
   * to relative ones
   */
  @Override
  public void makeUrisRelative(final AbstractIntermediateModelTransformationStrategy.TransformationResult result) {
    final EObject modelRoot = result.getOutputModel().getResource().getContents().get(0);
    boolean _matched = false;
    if (modelRoot instanceof IntermediateDataModel) {
      _matched=true;
      IntermediateDataModelTransformation.performUriRelativization(result);
    }
    if (!_matched) {
      if (modelRoot instanceof IntermediateServiceModel) {
        _matched=true;
        IntermediateServiceModelTransformation.performUriRelativization(result);
      }
    }
  }
  
  /**
   * Helper to find the input model, which resulted in the given output model from the list of
   * transformation results
   */
  private static AbstractIntermediateModelTransformationStrategy.InputModel findInputModelFor(final List<AbstractIntermediateModelTransformationStrategy.TransformationResult> results, final AbstractIntermediateModelTransformationStrategy.OutputModel outputModel) {
    final Function1<AbstractIntermediateModelTransformationStrategy.TransformationResult, Boolean> _function = (AbstractIntermediateModelTransformationStrategy.TransformationResult it) -> {
      AbstractIntermediateModelTransformationStrategy.OutputModel _outputModel = it.getOutputModel();
      return Boolean.valueOf(Objects.equal(_outputModel, outputModel));
    };
    Iterable<AbstractIntermediateModelTransformationStrategy.TransformationResult> _filter = IterableExtensions.<AbstractIntermediateModelTransformationStrategy.TransformationResult>filter(results, _function);
    AbstractIntermediateModelTransformationStrategy.TransformationResult _get = null;
    if (((AbstractIntermediateModelTransformationStrategy.TransformationResult[])Conversions.unwrapArray(_filter, AbstractIntermediateModelTransformationStrategy.TransformationResult.class))!=null) {
      _get=(((AbstractIntermediateModelTransformationStrategy.TransformationResult[])Conversions.unwrapArray(_filter, AbstractIntermediateModelTransformationStrategy.TransformationResult.class))[0]);
    }
    List<AbstractIntermediateModelTransformationStrategy.InputModel> _inputModels = null;
    if (_get!=null) {
      _inputModels=_get.getInputModels();
    }
    AbstractIntermediateModelTransformationStrategy.InputModel _get_1 = null;
    if (_inputModels!=null) {
      _get_1=_inputModels.get(0);
    }
    return _get_1;
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
