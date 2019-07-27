package de.fhdo.lemma.eclipse.ui;

import com.google.common.base.Function;
import de.fhdo.lemma.data.ComplexTypeImport;
import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.eclipse.ui.AbstractUiModelTransformationStrategy;
import de.fhdo.lemma.eclipse.ui.ModelFile;
import de.fhdo.lemma.eclipse.ui.ModelFileTypeDescription;
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils;
import de.fhdo.lemma.intermediate.transformations.AbstractIntermediateModelTransformationStrategy;
import de.fhdo.lemma.intermediate.transformations.service.IntermediateDataModelTransformation;
import de.fhdo.lemma.intermediate.transformations.service.IntermediateServiceModelTransformation;
import de.fhdo.lemma.intermediate.transformations.service.MappingModelTransformation;
import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.ImportType;
import de.fhdo.lemma.service.ServiceModel;
import de.fhdo.lemma.technology.mapping.TechnologyMapping;
import de.fhdo.lemma.utils.LemmaUtils;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * UI-specific intermediate model transformation strategy for models related to the Service Modeling
 * Viewpoint.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ServiceModelTransformationStrategy extends AbstractUiModelTransformationStrategy {
  public static final String DATA_MODEL_FILE_TYPE_ID = "DATA";
  
  public static final String MAPPING_MODEL_FILE_TYPE_ID = "MAPPING";
  
  public static final String SERVICE_MODEL_FILE_TYPE_ID = "SERVICE";
  
  private static final String DATA_DSL_EDITOR_ID = "de.fhdo.lemma.data.DataDsl";
  
  private static final String SERVICE_DSL_EDITOR_ID = "de.fhdo.lemma.ServiceDsl";
  
  private static final String MAPPING_DSL_EDITOR_ID = "de.fhdo.lemma.technology.mappingdsl.MappingDsl";
  
  private static final List<String> DATA_MODEL_FILE_EXTENSIONS = CollectionLiterals.<String>newArrayList();
  
  private static final List<String> SERVICE_MODEL_FILE_EXTENSIONS = CollectionLiterals.<String>newArrayList();
  
  private static final List<String> MAPPING_MODEL_FILE_EXTENSIONS = CollectionLiterals.<String>newArrayList();
  
  private static final String MODEL_TYPE_PREFIX = "service";
  
  private static final ResourceManager RESOURCE_MANAGER = new LocalResourceManager(JFaceResources.getResources());
  
  private LinkedHashMap<String, ModelFileTypeDescription> modelFileTypeDescriptions;
  
  /**
   * Constructor
   */
  public ServiceModelTransformationStrategy() {
    boolean _isEmpty = ServiceModelTransformationStrategy.SERVICE_MODEL_FILE_EXTENSIONS.isEmpty();
    if (_isEmpty) {
      ServiceModelTransformationStrategy.SERVICE_MODEL_FILE_EXTENSIONS.addAll(
        LemmaUiUtils.getFileExtensions(ServiceModelTransformationStrategy.SERVICE_DSL_EDITOR_ID));
    }
    boolean _isEmpty_1 = ServiceModelTransformationStrategy.MAPPING_MODEL_FILE_EXTENSIONS.isEmpty();
    if (_isEmpty_1) {
      ServiceModelTransformationStrategy.MAPPING_MODEL_FILE_EXTENSIONS.addAll(
        LemmaUiUtils.getFileExtensions(ServiceModelTransformationStrategy.MAPPING_DSL_EDITOR_ID));
    }
    boolean _isEmpty_2 = ServiceModelTransformationStrategy.DATA_MODEL_FILE_EXTENSIONS.isEmpty();
    if (_isEmpty_2) {
      ServiceModelTransformationStrategy.DATA_MODEL_FILE_EXTENSIONS.addAll(LemmaUiUtils.getFileExtensions(ServiceModelTransformationStrategy.DATA_DSL_EDITOR_ID));
    }
    this.setupModelFileTypeDescriptions();
  }
  
  /**
   * Helper to setup the map of model file type descriptions
   */
  private LinkedHashMap<String, ModelFileTypeDescription> setupModelFileTypeDescriptions() {
    Image _createImage = LemmaUiUtils.createImage(ServiceModelTransformationStrategy.RESOURCE_MANAGER, this.getClass(), "dataModelFile.gif");
    IntermediateDataModelTransformation _intermediateDataModelTransformation = new IntermediateDataModelTransformation();
    ModelFileTypeDescription _modelFileTypeDescription = new ModelFileTypeDescription(_createImage, 
      "Data Model", 
      ServiceModelTransformationStrategy.DATA_MODEL_FILE_EXTENSIONS, _intermediateDataModelTransformation);
    Pair<String, ModelFileTypeDescription> _mappedTo = Pair.<String, ModelFileTypeDescription>of(ServiceModelTransformationStrategy.DATA_MODEL_FILE_TYPE_ID, _modelFileTypeDescription);
    Image _createImage_1 = LemmaUiUtils.createImage(ServiceModelTransformationStrategy.RESOURCE_MANAGER, this.getClass(), "mappingModelFile.gif");
    MappingModelTransformation _mappingModelTransformation = new MappingModelTransformation();
    IntermediateServiceModelTransformation _intermediateServiceModelTransformation = new IntermediateServiceModelTransformation();
    ModelFileTypeDescription _modelFileTypeDescription_1 = new ModelFileTypeDescription(_createImage_1, 
      "Mapping Model", 
      ServiceModelTransformationStrategy.MAPPING_MODEL_FILE_EXTENSIONS, _mappingModelTransformation, _intermediateServiceModelTransformation);
    Pair<String, ModelFileTypeDescription> _mappedTo_1 = Pair.<String, ModelFileTypeDescription>of(ServiceModelTransformationStrategy.MAPPING_MODEL_FILE_TYPE_ID, _modelFileTypeDescription_1);
    Image _createImage_2 = LemmaUiUtils.createImage(ServiceModelTransformationStrategy.RESOURCE_MANAGER, this.getClass(), "serviceModelFile.gif");
    IntermediateServiceModelTransformation _intermediateServiceModelTransformation_1 = new IntermediateServiceModelTransformation();
    ModelFileTypeDescription _modelFileTypeDescription_2 = new ModelFileTypeDescription(_createImage_2, 
      "Service Model", 
      ServiceModelTransformationStrategy.SERVICE_MODEL_FILE_EXTENSIONS, _intermediateServiceModelTransformation_1);
    Pair<String, ModelFileTypeDescription> _mappedTo_2 = Pair.<String, ModelFileTypeDescription>of(ServiceModelTransformationStrategy.SERVICE_MODEL_FILE_TYPE_ID, _modelFileTypeDescription_2);
    return this.modelFileTypeDescriptions = CollectionLiterals.<String, ModelFileTypeDescription>newLinkedHashMap(_mappedTo, _mappedTo_1, _mappedTo_2);
  }
  
  /**
   * Get string prefix of model type
   */
  @Override
  public String getModelTypePrefix() {
    return ServiceModelTransformationStrategy.MODEL_TYPE_PREFIX;
  }
  
  /**
   * Get model types' ordering
   */
  @Override
  public List<String> getModelTypeOrdering() {
    return Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(ServiceModelTransformationStrategy.DATA_MODEL_FILE_TYPE_ID, ServiceModelTransformationStrategy.MAPPING_MODEL_FILE_TYPE_ID, ServiceModelTransformationStrategy.SERVICE_MODEL_FILE_TYPE_ID));
  }
  
  /**
   * Get file extensions of the model type
   */
  @Override
  public List<String> getModelFileTypeExtensions() {
    final ArrayList<String> modelTypeFileExtensions = CollectionLiterals.<String>newArrayList();
    modelTypeFileExtensions.addAll(ServiceModelTransformationStrategy.SERVICE_MODEL_FILE_EXTENSIONS);
    modelTypeFileExtensions.addAll(ServiceModelTransformationStrategy.MAPPING_MODEL_FILE_EXTENSIONS);
    return modelTypeFileExtensions;
  }
  
  /**
   * Find project-specific model files
   */
  @Override
  public Map<IProject, List<IFile>> findProjectSpecificModelFiles() {
    final Function2<IProject, List<IFile>, Boolean> _function = (IProject project, List<IFile> files) -> {
      boolean _isEmpty = files.isEmpty();
      return Boolean.valueOf((!_isEmpty));
    };
    return MapExtensions.<IProject, List<IFile>>filter(LemmaUiUtils.findFilesInWorkspaceProjects(((String[])Conversions.unwrapArray(this.getModelFileTypeExtensions(), String.class))), _function);
  }
  
  /**
   * Get descriptions of all relevant model file types
   */
  @Override
  public LinkedHashMap<String, ModelFileTypeDescription> getModelFileTypeDescriptions() {
    return this.modelFileTypeDescriptions;
  }
  
  /**
   * Get model file type description by extension
   */
  @Override
  public ModelFileTypeDescription getModelFileTypeDescription(final String fileExtension) {
    final Pair<String, ModelFileTypeDescription> typeIdentifierAndDescription = this.getModelFileTypeIdentifierAndDescription(fileExtension);
    if ((typeIdentifierAndDescription == null)) {
      return null;
    }
    return typeIdentifierAndDescription.getValue();
  }
  
  /**
   * Get model file type identifier and description by extension
   */
  @Override
  public Pair<String, ModelFileTypeDescription> getModelFileTypeIdentifierAndDescription(final String fileExtension) {
    if (((fileExtension != null) && (!fileExtension.isEmpty()))) {
      Set<Map.Entry<String, ModelFileTypeDescription>> _entrySet = this.modelFileTypeDescriptions.entrySet();
      for (final Map.Entry<String, ModelFileTypeDescription> entry : _entrySet) {
        boolean _contains = entry.getValue().getExtensions().contains(fileExtension);
        if (_contains) {
          String _key = entry.getKey();
          ModelFileTypeDescription _value = entry.getValue();
          return Pair.<String, ModelFileTypeDescription>of(_key, _value);
        }
      }
    }
    return null;
  }
  
  /**
   * Get title of model selection dialog
   */
  @Override
  public String getModelSelectionDialogTitle() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Select ");
    String _firstUpper = StringExtensions.toFirstUpper(this.getModelTypePrefix());
    _builder.append(_firstUpper);
    _builder.append(" Models for Intermediate Model ");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Transformation");
    return (_builder.toString() + _builder_1);
  }
  
  /**
   * Get message of model selection dialog
   */
  @Override
  public String getModelSelectionDialogMessage() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Determine ");
    String _modelTypePrefix = this.getModelTypePrefix();
    _builder.append(_modelTypePrefix);
    _builder.append(" models for intermediate model transformation by ");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("selecting the files in the project tree and clicking OK.");
    return (_builder.toString() + _builder_1);
  }
  
  /**
   * Get title of dialog for specifying transformation paths
   */
  @Override
  public String getSpecifyPathsDialogTitle() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Specify Paths for Intermediate ");
    String _firstUpper = StringExtensions.toFirstUpper(this.getModelTypePrefix());
    _builder.append(_firstUpper);
    _builder.append(" Models");
    return _builder.toString();
  }
  
  /**
   * Get message of dialog for specifying transformation paths
   */
  @Override
  public String getSpecifyPathsDialogMessage() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Specify target paths for the transformation of ");
    String _modelTypePrefix = this.getModelTypePrefix();
    _builder.append(_modelTypePrefix);
    _builder.append(" models to ");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("intermediate models in the table. Click OK to invoke the intermediate model ");
    String _plus = (_builder.toString() + _builder_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("transformations.");
    return (_plus + _builder_2);
  }
  
  /**
   * Get transformation strategy
   */
  @Override
  public AbstractIntermediateModelTransformationStrategy getTransformationStrategyInternal() {
    return new IntermediateServiceModelTransformation();
  }
  
  /**
   * Get files being import by a given model file in the form of IFile instances
   */
  @Override
  public Map<String, IFile> getImportedModelFiles(final ModelFile modelFile) {
    Map<String, String> importAliasesAndUris = null;
    boolean _isEmpty = modelFile.getXtextResource().getContents().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      boolean _hasExtension = LemmaUiUtils.hasExtension(modelFile.getFile(), ((String[])Conversions.unwrapArray(ServiceModelTransformationStrategy.SERVICE_MODEL_FILE_EXTENSIONS, String.class)));
      if (_hasExtension) {
        EObject _get = modelFile.getXtextResource().getContents().get(0);
        final ServiceModel modelRoot = ((ServiceModel) _get);
        final Function1<Import, Boolean> _function = (Import it) -> {
          return Boolean.valueOf(((it.getImportType() == ImportType.DATATYPES) || 
            (it.getImportType() == ImportType.MICROSERVICES)));
        };
        final Function1<Import, String> _function_1 = (Import it) -> {
          return it.getName();
        };
        final Function1<Import, String> _function_2 = (Import it) -> {
          return it.getImportURI();
        };
        importAliasesAndUris = IterableExtensions.<Import, String, String>toMap(IterableExtensions.<Import>filter(modelRoot.getImports(), _function), _function_1, _function_2);
      } else {
        boolean _hasExtension_1 = LemmaUiUtils.hasExtension(modelFile.getFile(), ((String[])Conversions.unwrapArray(ServiceModelTransformationStrategy.MAPPING_MODEL_FILE_EXTENSIONS, String.class)));
        if (_hasExtension_1) {
          EObject _get_1 = modelFile.getXtextResource().getContents().get(0);
          final TechnologyMapping modelRoot_1 = ((TechnologyMapping) _get_1);
          final Function1<Import, Boolean> _function_3 = (Import it) -> {
            ImportType _importType = it.getImportType();
            return Boolean.valueOf((_importType == ImportType.MICROSERVICES));
          };
          final Function1<Import, String> _function_4 = (Import it) -> {
            return it.getName();
          };
          final Function1<Import, String> _function_5 = (Import it) -> {
            return it.getImportURI();
          };
          importAliasesAndUris = IterableExtensions.<Import, String, String>toMap(IterableExtensions.<Import>filter(modelRoot_1.getImports(), _function_3), _function_4, _function_5);
        } else {
          boolean _hasExtension_2 = LemmaUiUtils.hasExtension(modelFile.getFile(), ((String[])Conversions.unwrapArray(ServiceModelTransformationStrategy.DATA_MODEL_FILE_EXTENSIONS, String.class)));
          if (_hasExtension_2) {
            EObject _get_2 = modelFile.getXtextResource().getContents().get(0);
            final DataModel modelRoot_2 = ((DataModel) _get_2);
            final Function1<ComplexTypeImport, String> _function_6 = (ComplexTypeImport it) -> {
              return it.getName();
            };
            final Function1<ComplexTypeImport, String> _function_7 = (ComplexTypeImport it) -> {
              return it.getImportURI();
            };
            importAliasesAndUris = IterableExtensions.<ComplexTypeImport, String, String>toMap(modelRoot_2.getComplexTypeImports(), _function_6, _function_7);
          }
        }
      }
    } else {
      return Collections.EMPTY_MAP;
    }
    final HashMap<String, IFile> importedModelFiles = CollectionLiterals.<String, IFile>newHashMap();
    final BiConsumer<String, String> _function_8 = (String alias, String importUri) -> {
      final String modelFileFullPath = modelFile.getFile().getLocation().toString();
      final String absoluteImportPath = LemmaUtils.convertToAbsolutePath(importUri, modelFileFullPath);
      final URI absoluteImportUri = URI.create(
        LemmaUtils.convertToFileUri(absoluteImportPath).replaceAll("\\s", "%20"));
      final IFile[] files = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(absoluteImportUri);
      boolean _isEmpty_1 = ((List<IFile>)Conversions.doWrapArray(files)).isEmpty();
      boolean _not_1 = (!_isEmpty_1);
      if (_not_1) {
        importedModelFiles.put(alias, files[0]);
      }
    };
    importAliasesAndUris.forEach(_function_8);
    return importedModelFiles;
  }
  
  /**
   * Return default target path for intermediate model transformation for a given file
   */
  @Override
  public String getDefaultTransformationTargetPath(final IFile file) {
    String _xifexpression = null;
    boolean _hasExtension = LemmaUiUtils.hasExtension(file, ((String[])Conversions.unwrapArray(ServiceModelTransformationStrategy.DATA_MODEL_FILE_EXTENSIONS, String.class)));
    if (_hasExtension) {
      _xifexpression = "data models";
    } else {
      String _xifexpression_1 = null;
      boolean _hasExtension_1 = LemmaUiUtils.hasExtension(file, ((String[])Conversions.unwrapArray(ServiceModelTransformationStrategy.SERVICE_MODEL_FILE_EXTENSIONS, String.class)));
      if (_hasExtension_1) {
        _xifexpression_1 = "service models";
      } else {
        String _xifexpression_2 = null;
        boolean _hasExtension_2 = LemmaUiUtils.hasExtension(file, ((String[])Conversions.unwrapArray(ServiceModelTransformationStrategy.MAPPING_MODEL_FILE_EXTENSIONS, String.class)));
        if (_hasExtension_2) {
          _xifexpression_2 = "mapping models";
        }
        _xifexpression_1 = _xifexpression_2;
      }
      _xifexpression = _xifexpression_1;
    }
    final String modelFileTypePathPart = _xifexpression;
    final Function<IFile, String> _function = (IFile it) -> {
      return it.getName();
    };
    final String filenameWithoutExtension = LemmaUiUtils.removeExtension(file, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/intermediate/");
    _builder.append(modelFileTypePathPart);
    _builder.append("/");
    _builder.append(filenameWithoutExtension);
    _builder.append(".xmi");
    return _builder.toString();
  }
}
