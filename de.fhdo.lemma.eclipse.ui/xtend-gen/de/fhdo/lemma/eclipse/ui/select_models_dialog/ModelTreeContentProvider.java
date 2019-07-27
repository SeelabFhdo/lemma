package de.fhdo.lemma.eclipse.ui.select_models_dialog;

import de.fhdo.lemma.eclipse.ui.AbstractUiModelTransformationStrategy;
import de.fhdo.lemma.eclipse.ui.ModelFile;
import de.fhdo.lemma.eclipse.ui.ModelFileTypeDescription;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Tree content provider for model files from which intermediate models could be transformed.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ModelTreeContentProvider implements ITreeContentProvider {
  private Map<IProject, List<ModelFile>> inputModelFilesWithProjects;
  
  private AbstractUiModelTransformationStrategy strategy;
  
  /**
   * Constructor
   */
  public ModelTreeContentProvider(final Map<IProject, List<ModelFile>> inputModelFilesWithProjects, final AbstractUiModelTransformationStrategy strategy) {
    if ((inputModelFilesWithProjects == null)) {
      throw new IllegalArgumentException("Input model files must not be null");
    } else {
      if ((strategy == null)) {
        throw new IllegalArgumentException("Transformation strategy must not be null");
      }
    }
    this.inputModelFilesWithProjects = inputModelFilesWithProjects;
    this.strategy = strategy;
  }
  
  /**
   * Get children of parent element
   */
  @Override
  public Object[] getChildren(final Object parentElement) {
    boolean _hasChildren = this.hasChildren(parentElement);
    boolean _not = (!_hasChildren);
    if (_not) {
      return new Object[0];
    }
    List<ModelFile> _switchResult = null;
    boolean _matched = false;
    if (parentElement instanceof IProject) {
      _matched=true;
      _switchResult = this.inputModelFilesWithProjects.get(parentElement);
    }
    if (!_matched) {
      if (parentElement instanceof ModelFile) {
        _matched=true;
        _switchResult = IterableExtensions.<ModelFile>sort(((ModelFile)parentElement).getChildren());
      }
    }
    final List<ModelFile> children = _switchResult;
    final Function1<ModelFile, Boolean> _function = (ModelFile it) -> {
      Boolean _hasErrors = it.hasErrors();
      return Boolean.valueOf((!(_hasErrors).booleanValue()));
    };
    return IterableExtensions.<ModelFile>toList(IterableExtensions.<ModelFile>filter(children, _function)).toArray();
  }
  
  /**
   * Get root elements
   */
  @Override
  public Object[] getElements(final Object inputElement) {
    Set<IProject> _keySet = this.inputModelFilesWithProjects.keySet();
    return ((Object[])Conversions.unwrapArray(IterableExtensions.<IProject>sortWith(_keySet, new Comparator<IProject>() {
      @Override
      public int compare(final IProject p1, final IProject p2) {
        return p1.getFullPath().toString().compareTo(p2.getFullPath().toString());
      }
    }), Object.class));
  }
  
  /**
   * Get parent of an element
   */
  @Override
  public Object getParent(final Object element) {
    Object _xifexpression = null;
    if ((element instanceof ModelFile)) {
      _xifexpression = ((ModelFile)element).getParent();
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  /**
   * Determine if the given element has children
   */
  @Override
  public boolean hasChildren(final Object element) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (element instanceof IProject) {
      _matched=true;
      _switchResult = ((this.inputModelFilesWithProjects.get(element) != null) && 
        (!this.inputModelFilesWithProjects.get(element).isEmpty()));
    }
    if (!_matched) {
      if (element instanceof ModelFile) {
        _matched=true;
        boolean _xblockexpression = false;
        {
          boolean _isScannedForChildren = ((ModelFile)element).isScannedForChildren();
          boolean _not = (!_isScannedForChildren);
          if (_not) {
            final Map<String, IFile> importedModelFiles = this.strategy.getImportedModelFiles(((ModelFile)element));
            final BiConsumer<String, IFile> _function = (String importAlias, IFile file) -> {
              final ModelFile modelFile = this.createModelFile(file, ((ModelFile)element), importAlias);
              Boolean _hasErrors = modelFile.hasErrors();
              boolean _not_1 = (!(_hasErrors).booleanValue());
              if (_not_1) {
                ((ModelFile)element).getChildren().add(modelFile);
              }
            };
            importedModelFiles.forEach(_function);
            ((ModelFile)element).setScannedForChildren(true);
          }
          boolean _isEmpty = ((ModelFile)element).getChildren().isEmpty();
          _xblockexpression = (!_isEmpty);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
  
  /**
   * Helper to create a ModelFile instance
   */
  private ModelFile createModelFile(final IFile file, final ModelFile parent, final String importAlias) {
    ModelFileTypeDescription _modelFileTypeDescription = this.strategy.getModelFileTypeDescription(file.getFileExtension());
    return new ModelFile(file, _modelFileTypeDescription, parent, importAlias);
  }
}
