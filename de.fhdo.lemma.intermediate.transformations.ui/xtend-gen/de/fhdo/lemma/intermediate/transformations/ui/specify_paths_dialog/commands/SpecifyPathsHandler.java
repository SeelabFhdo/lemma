package de.fhdo.lemma.intermediate.transformations.ui.specify_paths_dialog.commands;

import de.fhdo.lemma.intermediate.transformations.ui.AbstractUiModelTransformationStrategy;
import de.fhdo.lemma.intermediate.transformations.ui.ModelFile;
import de.fhdo.lemma.intermediate.transformations.ui.ModelFileTypeDescription;
import de.fhdo.lemma.intermediate.transformations.ui.specify_paths_dialog.SpecifyPathsDialog;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.BiConsumer;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Handler for specifying paths on selected models.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class SpecifyPathsHandler extends AbstractHandler {
  /**
   * Result of the invoked user dialog
   */
  public static class SpecifyPathsDialogResult {
    @Accessors(AccessorType.PUBLIC_GETTER)
    private List<ModelFile> selectedModelFiles;
    
    @Accessors(AccessorType.PUBLIC_GETTER)
    private boolean convertToRelativeUris;
    
    @Accessors(AccessorType.PUBLIC_GETTER)
    private boolean outputRefinementModels;
    
    public SpecifyPathsDialogResult(final List<ModelFile> selectedModelFiles, final boolean convertToRelativeUris, final boolean outputRefinementModels) {
      this.selectedModelFiles = selectedModelFiles;
      this.convertToRelativeUris = convertToRelativeUris;
      this.outputRefinementModels = outputRefinementModels;
    }
    
    @Pure
    public List<ModelFile> getSelectedModelFiles() {
      return this.selectedModelFiles;
    }
    
    @Pure
    public boolean isConvertToRelativeUris() {
      return this.convertToRelativeUris;
    }
    
    @Pure
    public boolean isOutputRefinementModels() {
      return this.outputRefinementModels;
    }
  }
  
  private final Shell SHELL = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
  
  private List<ModelFile> inputModelFiles;
  
  private AbstractUiModelTransformationStrategy strategy;
  
  /**
   * Constructor
   */
  public SpecifyPathsHandler(final List<ModelFile> inputModelFiles, final AbstractUiModelTransformationStrategy strategy) {
    if ((inputModelFiles == null)) {
      throw new IllegalArgumentException("Model files must not be null");
    } else {
      boolean _isEmpty = inputModelFiles.isEmpty();
      if (_isEmpty) {
        throw new IllegalArgumentException("Model files must not be empty");
      } else {
        if ((strategy == null)) {
          throw new IllegalArgumentException("Strategy must not be null");
        }
      }
    }
    this.inputModelFiles = inputModelFiles;
    this.strategy = strategy;
  }
  
  /**
   * Execute handler
   */
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    LinkedHashMap<String, List<ModelFile>> _createModelTableFiles = this.createModelTableFiles();
    final SpecifyPathsDialog dialog = new SpecifyPathsDialog(this.SHELL, this.strategy, _createModelTableFiles);
    dialog.create();
    final int dialogResult = dialog.open();
    SpecifyPathsHandler.SpecifyPathsDialogResult _xifexpression = null;
    if ((dialogResult == Window.OK)) {
      List<ModelFile> _selectedModelFiles = dialog.getSelectedModelFiles();
      boolean _isConvertToRelativeUris = dialog.isConvertToRelativeUris();
      boolean _isOutputRefinementModels = dialog.isOutputRefinementModels();
      _xifexpression = new SpecifyPathsHandler.SpecifyPathsDialogResult(_selectedModelFiles, _isConvertToRelativeUris, _isOutputRefinementModels);
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  /**
   * Create entries for the dialog's model file table. The result is a map that assigns model file
   * instances to their type identifiers. Thus, the dialog is able to display the model files in
   * the table according to the ordering of the model file types being specified in the current
   * UI-specific transformation strategy.
   */
  private LinkedHashMap<String, List<ModelFile>> createModelTableFiles() {
    final LinkedHashMap<String, List<ModelFile>> result = CollectionLiterals.<String, List<ModelFile>>newLinkedHashMap();
    final ArrayDeque<ModelFile> filesTodo = new ArrayDeque<ModelFile>(this.inputModelFiles);
    final HashSet<String> filesDone = CollectionLiterals.<String>newHashSet();
    while ((!filesTodo.isEmpty())) {
      {
        final ModelFile currentFile = this.prepareModelFile(filesTodo.pop());
        final String currentFileFullPath = currentFile.getFile().getLocation().toString();
        boolean _contains = filesDone.contains(currentFileFullPath);
        boolean _not = (!_contains);
        if (_not) {
          final String fileTypeId = this.strategy.getModelFileTypeIdentifierAndDescription(currentFile.getFile().getFileExtension()).getKey();
          List<ModelFile> resultModelFilesByTypeList = result.get(fileTypeId);
          if ((resultModelFilesByTypeList == null)) {
            resultModelFilesByTypeList = CollectionLiterals.<ModelFile>newArrayList();
            result.put(fileTypeId, resultModelFilesByTypeList);
          }
          resultModelFilesByTypeList.add(currentFile);
          final List<ModelFile> preparedImportedModelFiles = this.prepareImportedModelFiles(currentFile);
          boolean _isScannedForChildren = currentFile.isScannedForChildren();
          boolean _not_1 = (!_isScannedForChildren);
          if (_not_1) {
            currentFile.getChildren().addAll(preparedImportedModelFiles);
            currentFile.setScannedForChildren(true);
          }
          filesTodo.addAll(preparedImportedModelFiles);
          filesDone.add(currentFileFullPath);
        }
      }
    }
    return result;
  }
  
  /**
   * Get model files being imported by a given model file and prepare them for the model table
   */
  private List<ModelFile> prepareImportedModelFiles(final ModelFile modelFile) {
    List<ModelFile> _xifexpression = null;
    boolean _isScannedForChildren = modelFile.isScannedForChildren();
    if (_isScannedForChildren) {
      final Function1<ModelFile, ModelFile> _function = (ModelFile it) -> {
        return this.prepareModelFile(it);
      };
      _xifexpression = ListExtensions.<ModelFile, ModelFile>map(modelFile.getChildren(), _function);
    } else {
      ArrayList<ModelFile> _xblockexpression = null;
      {
        final ArrayList<ModelFile> preparedModelFiles = CollectionLiterals.<ModelFile>newArrayList();
        final BiConsumer<String, IFile> _function_1 = (String importAlias, IFile file) -> {
          ModelFileTypeDescription _modelFileTypeDescription = this.strategy.getModelFileTypeDescription(file.getFileExtension());
          final ModelFile newModelFile = new ModelFile(file, _modelFileTypeDescription, 
            null, importAlias);
          preparedModelFiles.add(this.prepareModelFile(newModelFile));
        };
        this.strategy.getImportedModelFiles(modelFile).forEach(_function_1);
        _xblockexpression = preparedModelFiles;
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  /**
   * Prepare model file for the table of model files
   */
  private ModelFile prepareModelFile(final ModelFile modelFile) {
    Boolean _hasErrors = modelFile.hasErrors();
    boolean _not = (!(_hasErrors).booleanValue());
    modelFile.setSelectedForTransformation(_not);
    modelFile.setTransformationTargetPath(
      this.strategy.getDefaultTransformationTargetPath(modelFile.getFile()));
    return modelFile;
  }
}
