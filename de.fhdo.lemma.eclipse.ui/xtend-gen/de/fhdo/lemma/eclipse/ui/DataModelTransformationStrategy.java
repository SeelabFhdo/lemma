package de.fhdo.lemma.eclipse.ui;

import com.google.common.base.Function;
import de.fhdo.lemma.data.ComplexTypeImport;
import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils;
import de.fhdo.lemma.intermediate.transformations.AbstractIntermediateModelTransformationStrategy;
import de.fhdo.lemma.intermediate.transformations.service.IntermediateDataModelTransformation;
import de.fhdo.lemma.intermediate.transformations.service.IntermediateServiceModelTransformation;
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
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * UI-specific intermediate model transformation strategy for models related to the Domain Modeling
 * Viewpoint.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class DataModelTransformationStrategy extends AbstractUiModelTransformationStrategy {
  public static final String DATA_MODEL_FILE_TYPE_ID = "DATA";

  public static final List<String> DATA_MODEL_FILE_EXTENSIONS = LemmaUiUtils.getFileExtensions(LemmaUiUtils.DATA_DSL_EDITOR_ID);

  private static final String MODEL_TYPE_PREFIX = "data";

  private final LinkedHashMap<String, ModelFileTypeDescription> modelFileTypeDescriptions;

  public DataModelTransformationStrategy() {
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
      DataModelTransformationStrategy.DATA_MODEL_FILE_TYPE_ID, _loadImageIfPossible, 
      "Data Model", 
      DataModelTransformationStrategy.DATA_MODEL_FILE_EXTENSIONS, 
      IntermediateDataModelTransformation.class);
    Pair<String, ModelFileTypeDescription> _mappedTo = Pair.<String, ModelFileTypeDescription>of(DataModelTransformationStrategy.DATA_MODEL_FILE_TYPE_ID, _modelFileTypeDescription);
    this.modelFileTypeDescriptions = CollectionLiterals.<String, ModelFileTypeDescription>newLinkedHashMap(_mappedTo);
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
    return DataModelTransformationStrategy.MODEL_TYPE_PREFIX;
  }

  /**
   * Get model types' ordering for displaying purposes
   */
  @Override
  public LinkedList<String> getModelTypeDisplayOrdering() {
    return CollectionLiterals.<String>newLinkedList(
      DataModelTransformationStrategy.DATA_MODEL_FILE_TYPE_ID);
  }

  /**
   * Get model types' ordering for transformation
   */
  @Override
  public LinkedList<String> getModelTypeTransformationOrdering() {
    return CollectionLiterals.<String>newLinkedList(
      DataModelTransformationStrategy.DATA_MODEL_FILE_TYPE_ID);
  }

  /**
   * Get file extensions of the model type
   */
  @Override
  public List<String> getModelFileTypeExtensions() {
    final ArrayList<String> modelTypeFileExtensions = CollectionLiterals.<String>newArrayList();
    modelTypeFileExtensions.addAll(DataModelTransformationStrategy.DATA_MODEL_FILE_EXTENSIONS);
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
    EObject _get = modelFile.getXtextResource().getContents().get(0);
    final DataModel modelRoot = ((DataModel) _get);
    final Consumer<ComplexTypeImport> _function = (ComplexTypeImport it) -> {
      importAliasesAndUris.put(it.getName(), it.getImportURI());
    };
    modelRoot.getComplexTypeImports().forEach(_function);
    final LinkedHashMap<String, IFile> importedModelFiles = CollectionLiterals.<String, IFile>newLinkedHashMap();
    final BiConsumer<String, String> _function_1 = (String alias, String importUri) -> {
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
    importAliasesAndUris.forEach(_function_1);
    return importedModelFiles;
  }

  /**
   * Return default target path for intermediate model transformation for a given file
   */
  @Override
  public String getDefaultTransformationTargetPath(final IFile file) {
    final Function<IFile, String> _function = (IFile it) -> {
      return it.getName();
    };
    final String filenameWithoutExtension = LemmaUiUtils.removeExtension(file, _function);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/intermediate/data models/");
    _builder.append(filenameWithoutExtension);
    _builder.append(".xmi");
    return _builder.toString();
  }
}
