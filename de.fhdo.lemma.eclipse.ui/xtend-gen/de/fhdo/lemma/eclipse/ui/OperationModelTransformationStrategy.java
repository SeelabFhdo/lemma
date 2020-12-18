package de.fhdo.lemma.eclipse.ui;

import com.google.common.base.Function;
import de.fhdo.lemma.eclipse.ui.AbstractUiModelTransformationStrategy;
import de.fhdo.lemma.eclipse.ui.ModelFile;
import de.fhdo.lemma.eclipse.ui.ModelFileTypeDescription;
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils;
import de.fhdo.lemma.intermediate.transformations.AbstractIntermediateModelTransformationStrategy;
import de.fhdo.lemma.intermediate.transformations.operation.IntermediateOperationModelTransformation;
import de.fhdo.lemma.intermediate.transformations.service.IntermediateServiceModelTransformation;
import de.fhdo.lemma.operation.OperationModel;
import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.ImportType;
import de.fhdo.lemma.service.ServiceModel;
import de.fhdo.lemma.utils.LemmaUtils;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import org.eclipse.core.resources.IFile;
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
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * UI-specific intermediate model transformation strategy for models related to the Operation
 * Modeling Viewpoint.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class OperationModelTransformationStrategy extends AbstractUiModelTransformationStrategy {
  public static final String OPERATION_MODEL_FILE_TYPE_ID = "OPERATION";
  
  public static final String SERVICE_MODEL_FILE_TYPE_ID = "SERVICE";
  
  private static final String OPERATION_DSL_EDITOR_ID = "de.fhdo.lemma.operationdsl.OperationDsl";
  
  private static final String SERVICE_DSL_EDITOR_ID = "de.fhdo.lemma.ServiceDsl";
  
  private static final List<String> OPERATION_MODEL_FILE_EXTENSIONS = CollectionLiterals.<String>newArrayList();
  
  private static final List<String> SERVICE_MODEL_FILE_EXTENSIONS = CollectionLiterals.<String>newArrayList();
  
  private static final String MODEL_TYPE_PREFIX = "operation";
  
  private static final ResourceManager RESOURCE_MANAGER = new LocalResourceManager(JFaceResources.getResources());
  
  private LinkedHashMap<String, ModelFileTypeDescription> modelFileTypeDescriptions;
  
  /**
   * Constructor
   */
  public OperationModelTransformationStrategy() {
    boolean _isEmpty = OperationModelTransformationStrategy.SERVICE_MODEL_FILE_EXTENSIONS.isEmpty();
    if (_isEmpty) {
      OperationModelTransformationStrategy.SERVICE_MODEL_FILE_EXTENSIONS.addAll(
        LemmaUiUtils.getFileExtensions(OperationModelTransformationStrategy.SERVICE_DSL_EDITOR_ID));
    }
    boolean _isEmpty_1 = OperationModelTransformationStrategy.OPERATION_MODEL_FILE_EXTENSIONS.isEmpty();
    if (_isEmpty_1) {
      OperationModelTransformationStrategy.OPERATION_MODEL_FILE_EXTENSIONS.addAll(
        LemmaUiUtils.getFileExtensions(OperationModelTransformationStrategy.OPERATION_DSL_EDITOR_ID));
    }
    this.setupModelFileTypeDescriptions();
  }
  
  /**
   * Helper to setup the map of model file type descriptions
   */
  private LinkedHashMap<String, ModelFileTypeDescription> setupModelFileTypeDescriptions() {
    Image _createImage = LemmaUiUtils.createImage(OperationModelTransformationStrategy.RESOURCE_MANAGER, this.getClass(), "operationModelFile.png");
    ModelFileTypeDescription _modelFileTypeDescription = new ModelFileTypeDescription(
      OperationModelTransformationStrategy.OPERATION_MODEL_FILE_TYPE_ID, _createImage, 
      "Operation Model", 
      OperationModelTransformationStrategy.OPERATION_MODEL_FILE_EXTENSIONS, 
      IntermediateOperationModelTransformation.class);
    Pair<String, ModelFileTypeDescription> _mappedTo = Pair.<String, ModelFileTypeDescription>of(OperationModelTransformationStrategy.OPERATION_MODEL_FILE_TYPE_ID, _modelFileTypeDescription);
    Image _createImage_1 = LemmaUiUtils.createImage(OperationModelTransformationStrategy.RESOURCE_MANAGER, this.getClass(), "serviceModelFile.gif");
    ModelFileTypeDescription _modelFileTypeDescription_1 = new ModelFileTypeDescription(
      OperationModelTransformationStrategy.SERVICE_MODEL_FILE_TYPE_ID, _createImage_1, 
      "Service Model", 
      OperationModelTransformationStrategy.SERVICE_MODEL_FILE_EXTENSIONS, 
      IntermediateServiceModelTransformation.class);
    Pair<String, ModelFileTypeDescription> _mappedTo_1 = Pair.<String, ModelFileTypeDescription>of(OperationModelTransformationStrategy.SERVICE_MODEL_FILE_TYPE_ID, _modelFileTypeDescription_1);
    return this.modelFileTypeDescriptions = CollectionLiterals.<String, ModelFileTypeDescription>newLinkedHashMap(_mappedTo, _mappedTo_1);
  }
  
  /**
   * Get string prefix of model type
   */
  @Override
  public String getModelTypePrefix() {
    return OperationModelTransformationStrategy.MODEL_TYPE_PREFIX;
  }
  
  /**
   * Get model types' ordering for displaying purposes
   */
  @Override
  public LinkedList<String> getModelTypeDisplayOrdering() {
    return CollectionLiterals.<String>newLinkedList(
      OperationModelTransformationStrategy.OPERATION_MODEL_FILE_TYPE_ID, 
      OperationModelTransformationStrategy.SERVICE_MODEL_FILE_TYPE_ID);
  }
  
  /**
   * Get model types' ordering for transformation
   */
  @Override
  public LinkedList<String> getModelTypeTransformationOrdering() {
    return CollectionLiterals.<String>newLinkedList(
      OperationModelTransformationStrategy.OPERATION_MODEL_FILE_TYPE_ID, 
      OperationModelTransformationStrategy.SERVICE_MODEL_FILE_TYPE_ID);
  }
  
  /**
   * Get file extensions of the model type
   */
  @Override
  public List<String> getModelFileTypeExtensions() {
    final ArrayList<String> modelTypeFileExtensions = CollectionLiterals.<String>newArrayList();
    modelTypeFileExtensions.addAll(OperationModelTransformationStrategy.OPERATION_MODEL_FILE_EXTENSIONS);
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
  public AbstractIntermediateModelTransformationStrategy getTransformationStrategyInternal() {
    return new IntermediateOperationModelTransformation();
  }
  
  /**
   * Get files being import by a given model file in the form of IFile instances
   */
  @Override
  public Map<String, IFile> getImportedModelFiles(final ModelFile modelFile) {
    boolean _isEmpty = modelFile.getXtextResource().getContents().isEmpty();
    if (_isEmpty) {
      return Collections.EMPTY_MAP;
    }
    Map<String, String> importAliasesAndUris = null;
    boolean _isEmpty_1 = modelFile.getXtextResource().getContents().isEmpty();
    boolean _not = (!_isEmpty_1);
    if (_not) {
      boolean _hasExtension = LemmaUiUtils.hasExtension(modelFile.getFile(), ((String[])Conversions.unwrapArray(OperationModelTransformationStrategy.SERVICE_MODEL_FILE_EXTENSIONS, String.class)));
      if (_hasExtension) {
        EObject _get = modelFile.getXtextResource().getContents().get(0);
        final ServiceModel modelRoot = ((ServiceModel) _get);
        final Function1<Import, Boolean> _function = (Import it) -> {
          ImportType _importType = it.getImportType();
          return Boolean.valueOf((_importType == ImportType.MICROSERVICES));
        };
        final Function1<Import, String> _function_1 = (Import it) -> {
          return it.getName();
        };
        final Function1<Import, String> _function_2 = (Import it) -> {
          return it.getImportURI();
        };
        importAliasesAndUris = IterableExtensions.<Import, String, String>toMap(IterableExtensions.<Import>filter(modelRoot.getImports(), _function), _function_1, _function_2);
      } else {
        boolean _hasExtension_1 = LemmaUiUtils.hasExtension(modelFile.getFile(), ((String[])Conversions.unwrapArray(OperationModelTransformationStrategy.OPERATION_MODEL_FILE_EXTENSIONS, String.class)));
        if (_hasExtension_1) {
          EObject _get_1 = modelFile.getXtextResource().getContents().get(0);
          final OperationModel modelRoot_1 = ((OperationModel) _get_1);
          final Function1<Import, Boolean> _function_3 = (Import it) -> {
            return Boolean.valueOf(((it.getImportType() == ImportType.MICROSERVICES) || 
              (it.getImportType() == ImportType.OPERATION_NODES)));
          };
          final Function1<Import, String> _function_4 = (Import it) -> {
            return it.getName();
          };
          final Function1<Import, String> _function_5 = (Import it) -> {
            return it.getImportURI();
          };
          importAliasesAndUris = IterableExtensions.<Import, String, String>toMap(IterableExtensions.<Import>filter(modelRoot_1.getImports(), _function_3), _function_4, _function_5);
        }
      }
    } else {
      return Collections.EMPTY_MAP;
    }
    final HashMap<String, IFile> importedModelFiles = CollectionLiterals.<String, IFile>newHashMap();
    final BiConsumer<String, String> _function_6 = (String alias, String importUri) -> {
      final String modelFileFullPath = modelFile.getFile().getLocation().toString();
      final String absoluteImportPath = LemmaUtils.convertToAbsolutePath(importUri, modelFileFullPath);
      final URI absoluteImportUri = URI.create(
        LemmaUtils.convertToFileUri(absoluteImportPath).replaceAll("\\s", "%20"));
      final IFile[] files = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(absoluteImportUri);
      boolean _isEmpty_2 = ((List<IFile>)Conversions.doWrapArray(files)).isEmpty();
      boolean _not_1 = (!_isEmpty_2);
      if (_not_1) {
        importedModelFiles.put(alias, files[0]);
      }
    };
    importAliasesAndUris.forEach(_function_6);
    return importedModelFiles;
  }
  
  /**
   * Return default target path for intermediate model transformation for a given file
   */
  @Override
  public String getDefaultTransformationTargetPath(final IFile file) {
    String _xifexpression = null;
    boolean _hasExtension = LemmaUiUtils.hasExtension(file, ((String[])Conversions.unwrapArray(OperationModelTransformationStrategy.OPERATION_MODEL_FILE_EXTENSIONS, String.class)));
    if (_hasExtension) {
      _xifexpression = "operation models";
    } else {
      String _xifexpression_1 = null;
      boolean _hasExtension_1 = LemmaUiUtils.hasExtension(file, ((String[])Conversions.unwrapArray(OperationModelTransformationStrategy.SERVICE_MODEL_FILE_EXTENSIONS, String.class)));
      if (_hasExtension_1) {
        _xifexpression_1 = "service models";
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
