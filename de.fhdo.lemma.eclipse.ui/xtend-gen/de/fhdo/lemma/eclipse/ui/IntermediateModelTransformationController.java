package de.fhdo.lemma.eclipse.ui;

import com.google.common.base.Objects;
import de.fhdo.lemma.eclipse.ui.AbstractUiModelTransformationStrategy;
import de.fhdo.lemma.eclipse.ui.ModelFile;
import de.fhdo.lemma.eclipse.ui.ServiceModelTransformationStrategy;
import de.fhdo.lemma.eclipse.ui.select_models_dialog.commands.SelectModelsHandler;
import de.fhdo.lemma.eclipse.ui.specify_paths_dialog.commands.SpecifyPathsHandler;
import de.fhdo.lemma.eclipse.ui.transformation_dialog.commands.TransformationDialogHandler;
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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Controller for handling the intermediate model transformation in the UI.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class IntermediateModelTransformationController extends AbstractHandler {
  private final Shell SHELL = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
  
  private AbstractUiModelTransformationStrategy modelTransformationStrategy;
  
  private List<String> modelFileTypeExtensions;
  
  private String modelTypePrefix;
  
  /**
   * Execute controller handler
   */
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    try {
      ServiceModelTransformationStrategy _serviceModelTransformationStrategy = new ServiceModelTransformationStrategy();
      this.modelTransformationStrategy = _serviceModelTransformationStrategy;
      this.modelFileTypeExtensions = this.modelTransformationStrategy.getModelFileTypeExtensions();
      this.modelTypePrefix = this.modelTransformationStrategy.getModelTypePrefix();
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
        ex.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    if (((this.modelFileTypeExtensions == null) || this.modelFileTypeExtensions.isEmpty())) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("No ");
      _builder.append(this.modelTypePrefix);
      _builder.append(" models found");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("No ");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append(this.modelTypePrefix);
      _builder_2.append(" model files could be found, because there were no editors ");
      String _plus = (_builder_1.toString() + _builder_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("associated with the respective file types. Do you have the editor plugins ");
      String _plus_1 = (_plus + _builder_3);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("for creating ");
      _builder_4.append(this.modelTypePrefix);
      _builder_4.append(" models installed?");
      String _plus_2 = (_plus_1 + _builder_4);
      MessageDialog.openError(this.SHELL, _builder.toString(), _plus_2);
    }
    Map<IProject, List<IFile>> _inputModelFiles = this.getInputModelFiles(event);
    final SelectModelsHandler selectModelsHandler = new SelectModelsHandler(this.modelTransformationStrategy, _inputModelFiles);
    final Object selectModelsHandlerResult = selectModelsHandler.execute(event);
    if ((selectModelsHandlerResult == null)) {
      return null;
    }
    final List<ModelFile> selectedModelFiles = ((List<ModelFile>) selectModelsHandlerResult);
    final SpecifyPathsHandler specifyPathsHandler = new SpecifyPathsHandler(selectedModelFiles, 
      this.modelTransformationStrategy);
    final Object specifyPathsRawResult = specifyPathsHandler.execute(event);
    if ((specifyPathsRawResult == null)) {
      return null;
    }
    final Pair<List<ModelFile>, Boolean> specifyPathsResult = ((Pair<List<ModelFile>, Boolean>) specifyPathsRawResult);
    final List<ModelFile> selectedModelFilesWithChildPaths = specifyPathsResult.getKey();
    final Boolean outputRefinementModels = specifyPathsResult.getValue();
    final TransformationDialogHandler transformationHandler = new TransformationDialogHandler(selectedModelFilesWithChildPaths, (outputRefinementModels).booleanValue(), 
      this.modelTransformationStrategy);
    transformationHandler.execute(event);
    return null;
  }
  
  /**
   * Get input files for model transformations
   */
  private Map<IProject, List<IFile>> getInputModelFiles(final ExecutionEvent event) {
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
