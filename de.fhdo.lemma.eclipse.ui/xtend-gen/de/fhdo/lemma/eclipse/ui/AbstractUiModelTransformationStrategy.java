package de.fhdo.lemma.eclipse.ui;

import de.fhdo.lemma.eclipse.ui.ModelFile;
import de.fhdo.lemma.eclipse.ui.ModelFileTypeDescription;
import de.fhdo.lemma.intermediate.transformations.AbstractIntermediateModelTransformationStrategy;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
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
   * Get model types' ordering
   */
  public abstract List<String> getModelTypeOrdering();
  
  /**
   * Get file extensions of the model type. Files being found in the workspace that exhibit one of
   * the extensions are treated as source files for the model transformations.
   */
  public abstract List<String> getModelFileTypeExtensions();
  
  /**
   * Find project-specific model files, i.e., files in the workspace that exhibit one of the model
   * type's file extensions.
   */
  public abstract Map<IProject, List<IFile>> findProjectSpecificModelFiles();
  
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
   * Get files being imported into a model file mapped to their import aliases
   */
  public abstract Map<String, IFile> getImportedModelFiles(final ModelFile modelFile);
  
  /**
   * Get default transformation target path for file
   */
  public abstract String getDefaultTransformationTargetPath(final IFile file);
  
  /**
   * Get a new instance of the transformation strategy
   */
  protected abstract AbstractIntermediateModelTransformationStrategy getTransformationStrategyInternal();
}
