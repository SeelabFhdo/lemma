package de.fhdo.lemma.eclipse.ui;

import com.google.common.base.Objects;
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Abstract Controller for handling the intermediate model transformation in the UI.
 * 
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
@SuppressWarnings("all")
public abstract class AbstractIntermediateModelTransformationController extends AbstractHandler {
  protected List<String> modelFileTypeExtensions;
  
  /**
   * Execute controller handler
   */
  @Override
  public abstract Object execute(final ExecutionEvent event) throws ExecutionException;
  
  /**
   * Get input files for model transformations
   */
  protected Map<IProject, List<IFile>> getInputModelFiles(final ExecutionEvent event) {
    boolean _transformationOnSelectedModelsOnly = this.transformationOnSelectedModelsOnly(event);
    boolean _not = (!_transformationOnSelectedModelsOnly);
    if (_not) {
      return this.allWorkspaceModelFiles();
    }
    final List<IResource> selectedResources = LemmaUiUtils.getSelectedResources(event);
    boolean _isEmpty = selectedResources.isEmpty();
    if (_isEmpty) {
      return this.allWorkspaceModelFiles();
    }
    final HashMap<IProject, List<IFile>> inputModelFiles = CollectionLiterals.<IProject, List<IFile>>newHashMap();
    final Consumer<IResource> _function = (IResource it) -> {
      final Pair<IProject, List<IFile>> projectAndFiles = this.findModelFiles(it);
      final IProject project = projectAndFiles.getKey();
      final List<IFile> files = projectAndFiles.getValue();
      if ((((project != null) && (files != null)) && (!files.isEmpty()))) {
        boolean _containsKey = inputModelFiles.containsKey(project);
        boolean _not_1 = (!_containsKey);
        if (_not_1) {
          inputModelFiles.put(project, files);
        } else {
          inputModelFiles.get(project).addAll(files);
        }
      }
    };
    selectedResources.forEach(_function);
    return inputModelFiles;
  }
  
  /**
   * Check if the transformation shall be executed for models in selected resources only
   */
  private boolean transformationOnSelectedModelsOnly(final ExecutionEvent event) {
    final String parameterValue = event.getParameter(("de.fhdo.lemma.eclipse.ui.commands.parameters" + 
      ".selectedModelsOnly"));
    return ((parameterValue != null) && Objects.equal(parameterValue.toLowerCase(), "true"));
  }
  
  /**
   * Get model files from all projects in the current workspace
   */
  private Map<IProject, List<IFile>> allWorkspaceModelFiles() {
    final Function2<IProject, List<IFile>, Boolean> _function = (IProject project, List<IFile> files) -> {
      boolean _isEmpty = files.isEmpty();
      return Boolean.valueOf((!_isEmpty));
    };
    return MapExtensions.<IProject, List<IFile>>filter(LemmaUiUtils.findFilesInWorkspaceProjects(((String[])Conversions.unwrapArray(this.modelFileTypeExtensions, String.class))), _function);
  }
  
  /**
   * Dispatcher: Find model files from IResource
   */
  private Pair<IProject, List<IFile>> _findModelFiles(final IResource project) {
    return Pair.<IProject, List<IFile>>of(null, null);
  }
  
  /**
   * Dispatcher: Find model files from IProject
   */
  private Pair<IProject, List<IFile>> _findModelFiles(final IProject project) {
    List<IFile> _findFilesInProject = LemmaUiUtils.findFilesInProject(project, ((String[])Conversions.unwrapArray(this.modelFileTypeExtensions, String.class)));
    return Pair.<IProject, List<IFile>>of(project, _findFilesInProject);
  }
  
  /**
   * Dispatcher: Find model files from IFolder
   */
  private Pair<IProject, List<IFile>> _findModelFiles(final IFolder folder) {
    final List<IFile> projectFiles = LemmaUiUtils.findFilesInProject(folder.getProject(), ((String[])Conversions.unwrapArray(this.modelFileTypeExtensions, String.class)));
    IProject _project = folder.getProject();
    final Function1<IFile, Boolean> _function = (IFile it) -> {
      return Boolean.valueOf(folder.getLocation().isPrefixOf(it.getLocation()));
    };
    List<IFile> _list = IterableExtensions.<IFile>toList(IterableExtensions.<IFile>filter(projectFiles, _function));
    return Pair.<IProject, List<IFile>>of(_project, _list);
  }
  
  /**
   * Dispatcher: Find model files from IFile
   */
  private Pair<IProject, List<IFile>> _findModelFiles(final IFile file) {
    IProject _project = file.getProject();
    List<IFile> _xifexpression = null;
    boolean _contains = this.modelFileTypeExtensions.contains(file.getFileExtension());
    if (_contains) {
      _xifexpression = CollectionLiterals.<IFile>newArrayList(file);
    } else {
      _xifexpression = CollectionLiterals.<IFile>emptyList();
    }
    return Pair.<IProject, List<IFile>>of(_project, _xifexpression);
  }
  
  private Pair<IProject, List<IFile>> findModelFiles(final IResource file) {
    if (file instanceof IFile) {
      return _findModelFiles((IFile)file);
    } else if (file instanceof IFolder) {
      return _findModelFiles((IFolder)file);
    } else if (file instanceof IProject) {
      return _findModelFiles((IProject)file);
    } else if (file != null) {
      return _findModelFiles(file);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(file).toString());
    }
  }
}
