package de.fhdo.lemma.eclipse.ui;

import de.fhdo.lemma.intermediate.transformations.AbstractIntermediateModelTransformationStrategy;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Abstract strategy for preparing, displaying and controlling intermediate models' transformation
 * in the UI.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public abstract class AbstractUiModelTransformationStrategy {
  private AbstractIntermediateModelTransformationStrategy transformationStrategy;
  
  /**
   * Return the transformation strategy of the concrete subclass. Note, that this method mimics
   * the behavior of a Singleton. That is, the instance of the transformation strategy is created
   * only once to increase performance.
   */
  public AbstractIntermediateModelTransformationStrategy getTransformationStrategy() {
    if ((this.transformationStrategy == null)) {
      this.transformationStrategy = this.getTransformationStrategyInternal();
    }
    return this.transformationStrategy;
  }
  
  /**
   * Get string prefix of the model type, e.g., "service" or "operation"
   */
  public abstract String getModelTypePrefix();
  
  /**
   * Get model types' ordering for displaying purposes
   */
  public abstract LinkedList<String> getModelTypeDisplayOrdering();
  
  /**
   * Sort a list of model files according to their ordering intended for transformation. The
   * result will be a new list, i.e., the given list of model files will not be changed.
   */
  public final LinkedList<ModelFile> sortByTransformationOrder(final List<ModelFile> modelFiles) {
    final LinkedList<ModelFile> orderedModelFiles = CollectionLiterals.<ModelFile>newLinkedList();
    orderedModelFiles.addAll(modelFiles);
    Collections.<ModelFile>sort(orderedModelFiles, new Comparator() {
      @Override
      public int compare(final Object o1, final Object o2) {
        final ModelFile file1 = ((ModelFile) o1);
        final int fileTypeIndex1 = AbstractUiModelTransformationStrategy.this.getModelTypeTransformationOrdering().indexOf(file1.getFileTypeDescription().getFileType());
        final ModelFile file2 = ((ModelFile) o2);
        final int fileTypeIndex2 = AbstractUiModelTransformationStrategy.this.getModelTypeTransformationOrdering().indexOf(file2.getFileTypeDescription().getFileType());
        return Integer.compare(fileTypeIndex1, fileTypeIndex2);
      }
    });
    return orderedModelFiles;
  }
  
  /**
   * Get model types' ordering for transformation
   */
  public abstract LinkedList<String> getModelTypeTransformationOrdering();
  
  /**
   * Get file extensions of the model type. Files being found in the workspace that exhibit one of
   * the extensions are treated as source files for the model transformations.
   */
  public abstract List<String> getModelFileTypeExtensions();
  
  /**
   * Get descriptions of all relevant model file types including icon, description string, and
   * extensions. Note, that the descriptions may contain additional file types compared to the
   * model type file extensions (see above). Each description is identified by a string
   * identifier (the map key).
   */
  public abstract LinkedHashMap<String, ModelFileTypeDescription> getModelFileTypeDescriptions();
  
  /**
   * Get model file type identifier and description by extension
   */
  public abstract Pair<String, ModelFileTypeDescription> getModelFileTypeIdentifierAndDescription(final String fileExtension);
  
  /**
   * Get model file type description by extension
   */
  public abstract ModelFileTypeDescription getModelFileTypeDescription(final String fileExtension);
  
  /**
   * Get title of model selection dialog
   */
  public abstract String getModelSelectionDialogTitle();
  
  /**
   * Get message of model selection dialog
   */
  public abstract String getModelSelectionDialogMessage();
  
  /**
   * Get title of dialog for specifying transformation paths
   */
  public abstract String getSpecifyPathsDialogTitle();
  
  /**
   * Get message of dialog for specifying transformation paths
   */
  public abstract String getSpecifyPathsDialogMessage();
  
  /**
   * Get imported files of a model in their import order and mapped to their import aliases
   */
  public abstract LinkedHashMap<String, IFile> getImportedModelFiles(final ModelFile modelFile);
  
  /**
   * Get default transformation target path for file
   */
  public abstract String getDefaultTransformationTargetPath(final IFile file);
  
  /**
   * Get a new instance of the transformation strategy
   */
  protected abstract AbstractIntermediateModelTransformationStrategy getTransformationStrategyInternal();
}
