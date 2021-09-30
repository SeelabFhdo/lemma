package de.fhdo.lemma.intermediate.transformations.ui.select_models_dialog.commands;

import de.fhdo.lemma.intermediate.transformations.ui.AbstractUiModelTransformationStrategy;
import de.fhdo.lemma.intermediate.transformations.ui.ModelFile;
import de.fhdo.lemma.intermediate.transformations.ui.ModelFileTypeDescription;
import de.fhdo.lemma.intermediate.transformations.ui.select_models_dialog.SelectModelsDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * Handler for selecting models for intermediate model transformation.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class SelectModelsHandler extends AbstractHandler {
  private final Shell SHELL = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
  
  private AbstractUiModelTransformationStrategy transformationStrategy;
  
  private Map<IProject, List<IFile>> inputModelFiles;
  
  /**
   * Constructor
   */
  public SelectModelsHandler(final AbstractUiModelTransformationStrategy transformationStrategy, final Map<IProject, List<IFile>> inputModelFiles) {
    if ((transformationStrategy == null)) {
      throw new IllegalArgumentException("Transformation strategy must not be null");
    }
    this.transformationStrategy = transformationStrategy;
    this.inputModelFiles = inputModelFiles;
  }
  
  /**
   * Execute handler
   */
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    if (((this.inputModelFiles == null) || this.inputModelFiles.isEmpty())) {
      final String modelTypePrefix = this.transformationStrategy.getModelTypePrefix();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("No ");
      _builder.append(modelTypePrefix);
      _builder.append(" models found");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("No ");
      _builder_1.append(modelTypePrefix);
      _builder_1.append(" model files found. Transformation not possible.");
      MessageDialog.openInformation(this.SHELL, _builder.toString(), _builder_1.toString());
      return null;
    }
    final HashMap<IProject, List<ModelFile>> modelFiles = this.convertToModelFiles(this.inputModelFiles);
    final SelectModelsDialog dialog = new SelectModelsDialog(this.SHELL, this.transformationStrategy, modelFiles);
    dialog.create();
    final int dialogResult = dialog.open();
    if ((dialogResult == Window.CANCEL)) {
      return null;
    }
    List<ModelFile> _xifexpression = null;
    if ((dialogResult == Window.OK)) {
      _xifexpression = dialog.getSelectedModelFiles();
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  /**
   * Helper to convert the values of a map of source model files to ModelFile instances
   */
  private HashMap<IProject, List<ModelFile>> convertToModelFiles(final Map<IProject, List<IFile>> sourceModelFiles) {
    final HashMap<IProject, List<ModelFile>> convertedSourceModelFiles = CollectionLiterals.<IProject, List<ModelFile>>newHashMap();
    final BiConsumer<IProject, List<IFile>> _function = (IProject project, List<IFile> files) -> {
      final ArrayList<ModelFile> modelFiles = CollectionLiterals.<ModelFile>newArrayList();
      final Consumer<IFile> _function_1 = (IFile file) -> {
        final ModelFileTypeDescription modelFileTypeDescription = this.transformationStrategy.getModelFileTypeDescription(file.getFileExtension());
        final ModelFile modelFile = new ModelFile(file, modelFileTypeDescription, project, null);
        modelFiles.add(modelFile);
      };
      files.forEach(_function_1);
      convertedSourceModelFiles.put(project, modelFiles);
    };
    sourceModelFiles.forEach(_function);
    return convertedSourceModelFiles;
  }
}
