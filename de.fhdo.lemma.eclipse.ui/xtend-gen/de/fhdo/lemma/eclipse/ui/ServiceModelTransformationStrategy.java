package de.fhdo.lemma.eclipse.ui;

import com.google.common.base.Function;
import de.fhdo.lemma.data.ComplexTypeImport;
import de.fhdo.lemma.data.DataModel;
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
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
  
  public static final List<String> DATA_MODEL_FILE_EXTENSIONS = LemmaUiUtils.getFileExtensions(LemmaUiUtils.DATA_DSL_EDITOR_ID);
  
  public static final List<String> SERVICE_MODEL_FILE_EXTENSIONS = LemmaUiUtils.getFileExtensions(LemmaUiUtils.SERVICE_DSL_EDITOR_ID);
  
  public static final List<String> MAPPING_MODEL_FILE_EXTENSIONS = LemmaUiUtils.getFileExtensions(LemmaUiUtils.MAPPING_DSL_EDITOR_ID);
  
  private static final String MODEL_TYPE_PREFIX = "service";
  
  private final LinkedHashMap<String, ModelFileTypeDescription> modelFileTypeDescriptions;
  
  public ServiceModelTransformationStrategy() {
    LocalResourceManager _xifexpression = null;
    Display _current = Display.getCurrent();
    boolean _tripleNotEquals = (_current != null);
    if (_tripleNotEquals) {
      ResourceManager _resources = JFaceResources.getResources();
      _xifexpression = new LocalResourceManager(_resources);
    } else {
      _xifexpression = null;
    }
    final LocalResourceManager resourceManager = _xifexpression;
    Image _loadImageIfPossible = this.loadImageIfPossible(resourceManager, "dataModelFile.gif");
    ModelFileTypeDescription _modelFileTypeDescription = new ModelFileTypeDescription(
      ServiceModelTransformationStrategy.DATA_MODEL_FILE_TYPE_ID, _loadImageIfPossible, 
      "Data Model", 
      ServiceModelTransformationStrategy.DATA_MODEL_FILE_EXTENSIONS, 
      IntermediateDataModelTransformation.class);
    Pair<String, ModelFileTypeDescription> _mappedTo = Pair.<String, ModelFileTypeDescription>of(ServiceModelTransformationStrategy.DATA_MODEL_FILE_TYPE_ID, _modelFileTypeDescription);
    Image _loadImageIfPossible_1 = this.loadImageIfPossible(resourceManager, "mappingModelFile.gif");
    ModelFileTypeDescription _modelFileTypeDescription_1 = new ModelFileTypeDescription(
      ServiceModelTransformationStrategy.MAPPING_MODEL_FILE_TYPE_ID, _loadImageIfPossible_1, 
      "Mapping Model", 
      ServiceModelTransformationStrategy.MAPPING_MODEL_FILE_EXTENSIONS, 
      MappingModelTransformation.class, 
      IntermediateServiceModelTransformation.class);
    Pair<String, ModelFileTypeDescription> _mappedTo_1 = Pair.<String, ModelFileTypeDescription>of(ServiceModelTransformationStrategy.MAPPING_MODEL_FILE_TYPE_ID, _modelFileTypeDescription_1);
    Image _loadImageIfPossible_2 = this.loadImageIfPossible(resourceManager, "serviceModelFile.gif");
    ModelFileTypeDescription _modelFileTypeDescription_2 = new ModelFileTypeDescription(
      ServiceModelTransformationStrategy.SERVICE_MODEL_FILE_TYPE_ID, _loadImageIfPossible_2, 
      "Service Model", 
      ServiceModelTransformationStrategy.SERVICE_MODEL_FILE_EXTENSIONS, 
      IntermediateServiceModelTransformation.class);
    Pair<String, ModelFileTypeDescription> _mappedTo_2 = Pair.<String, ModelFileTypeDescription>of(ServiceModelTransformationStrategy.SERVICE_MODEL_FILE_TYPE_ID, _modelFileTypeDescription_2);
    this.modelFileTypeDescriptions = CollectionLiterals.<String, ModelFileTypeDescription>newLinkedHashMap(_mappedTo, _mappedTo_1, _mappedTo_2);
  }
  
  /**
   * Helper to load an image file if a resource manager is available
   */
  private Image loadImageIfPossible(final ResourceManager resourceManager, final String filename) {
    Image _xifexpression = null;
    if ((resourceManager != null)) {
      _xifexpression = LemmaUiUtils.createImage(resourceManager, ServiceModelTransformationStrategy.class, filename);
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  /**
   * Get string prefix of model type
   */
  @Override
  public String getModelTypePrefix() {
    return ServiceModelTransformationStrategy.MODEL_TYPE_PREFIX;
  }
  
  /**
   * Get model types' ordering for displaying purposes
   */
  @Override
  public LinkedList<String> getModelTypeDisplayOrdering() {
    return CollectionLiterals.<String>newLinkedList(
      ServiceModelTransformationStrategy.DATA_MODEL_FILE_TYPE_ID, 
      ServiceModelTransformationStrategy.MAPPING_MODEL_FILE_TYPE_ID, 
      ServiceModelTransformationStrategy.SERVICE_MODEL_FILE_TYPE_ID);
  }
  
  /**
   * Get model types' ordering for transformation
   */
  @Override
  public LinkedList<String> getModelTypeTransformationOrdering() {
    return CollectionLiterals.<String>newLinkedList(
      ServiceModelTransformationStrategy.DATA_MODEL_FILE_TYPE_ID, 
      ServiceModelTransformationStrategy.SERVICE_MODEL_FILE_TYPE_ID, 
      ServiceModelTransformationStrategy.MAPPING_MODEL_FILE_TYPE_ID);
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
    return (_builder.toString() + 
      "Transformation");
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
    _builder_1.append("selecting the files in the project tree and clicking the \"Continue with ");
    String _plus = (_builder.toString() + _builder_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("selected models\" button. Alternatively, you may click on \"Select all models and ");
    String _plus_1 = (_plus + _builder_2);
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("continue\" to use all models for intermediate model transformation.");
    return (_plus_1 + _builder_3);
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
    String _plus = (_builder.toString() + 
      "intermediate models in the table. Click OK to invoke the intermediate model ");
    return (_plus + 
      "transformations.");
  }
  
  /**
   * Get transformation strategy
   */
  @Override
  public AbstractIntermediateModelTransformationStrategy<?, ?> getTransformationStrategyInternal() {
    return new IntermediateServiceModelTransformation();
  }
  
  /**
   * Get imported files of a given model file in the form of IFile instances
   */
  @Override
  public LinkedHashMap<String, IFile> getImportedModelFiles(final ModelFile modelFile) {
    boolean _isEmpty = modelFile.getXtextResource().getContents().isEmpty();
    if (_isEmpty) {
      return CollectionLiterals.<String, IFile>newLinkedHashMap();
    }
    final LinkedHashMap<String, String> importAliasesAndUris = CollectionLiterals.<String, String>newLinkedHashMap();
    boolean _hasExtension = LemmaUiUtils.hasExtension(modelFile.getFile(), ((String[])Conversions.unwrapArray(ServiceModelTransformationStrategy.SERVICE_MODEL_FILE_EXTENSIONS, String.class)));
    if (_hasExtension) {
      EObject _get = modelFile.getXtextResource().getContents().get(0);
      final ServiceModel modelRoot = ((ServiceModel) _get);
      final Function1<Import, Boolean> _function = (Import it) -> {
        return Boolean.valueOf(((it.getImportType() == ImportType.DATATYPES) || 
          (it.getImportType() == ImportType.MICROSERVICES)));
      };
      final Consumer<Import> _function_1 = (Import it) -> {
        importAliasesAndUris.put(it.getName(), it.getImportURI());
      };
      IterableExtensions.<Import>filter(modelRoot.getImports(), _function).forEach(_function_1);
    } else {
      boolean _hasExtension_1 = LemmaUiUtils.hasExtension(modelFile.getFile(), ((String[])Conversions.unwrapArray(ServiceModelTransformationStrategy.MAPPING_MODEL_FILE_EXTENSIONS, String.class)));
      if (_hasExtension_1) {
        EObject _get_1 = modelFile.getXtextResource().getContents().get(0);
        final TechnologyMapping modelRoot_1 = ((TechnologyMapping) _get_1);
        final Function1<Import, Boolean> _function_2 = (Import it) -> {
          ImportType _importType = it.getImportType();
          return Boolean.valueOf((_importType == ImportType.MICROSERVICES));
        };
        final Consumer<Import> _function_3 = (Import it) -> {
          importAliasesAndUris.put(it.getName(), it.getImportURI());
        };
        IterableExtensions.<Import>filter(modelRoot_1.getImports(), _function_2).forEach(_function_3);
      } else {
        boolean _hasExtension_2 = LemmaUiUtils.hasExtension(modelFile.getFile(), ((String[])Conversions.unwrapArray(ServiceModelTransformationStrategy.DATA_MODEL_FILE_EXTENSIONS, String.class)));
        if (_hasExtension_2) {
          EObject _get_2 = modelFile.getXtextResource().getContents().get(0);
          final DataModel modelRoot_2 = ((DataModel) _get_2);
          final Consumer<ComplexTypeImport> _function_4 = (ComplexTypeImport it) -> {
            importAliasesAndUris.put(it.getName(), it.getImportURI());
          };
          modelRoot_2.getComplexTypeImports().forEach(_function_4);
        }
      }
    }
    final LinkedHashMap<String, IFile> importedModelFiles = CollectionLiterals.<String, IFile>newLinkedHashMap();
    final BiConsumer<String, String> _function_5 = (String alias, String importUri) -> {
      final String modelFileFullPath = modelFile.getFile().getLocation().toString();
      final String absoluteImportPath = LemmaUtils.convertToAbsolutePath(importUri, modelFileFullPath);
      final URI absoluteImportUri = URI.create(
        LemmaUtils.convertToFileUri(absoluteImportPath).replaceAll("\\s", "%20"));
      final IFile[] files = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(absoluteImportUri);
      boolean _isEmpty_1 = ((List<IFile>)Conversions.doWrapArray(files)).isEmpty();
      boolean _not = (!_isEmpty_1);
      if (_not) {
        importedModelFiles.put(alias, files[0]);
      }
    };
    importAliasesAndUris.forEach(_function_5);
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
