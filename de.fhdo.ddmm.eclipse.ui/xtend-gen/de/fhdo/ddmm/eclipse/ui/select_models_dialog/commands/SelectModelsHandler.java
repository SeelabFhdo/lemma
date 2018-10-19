package de.fhdo.ddmm.eclipse.ui.select_models_dialog.commands;

import de.fhdo.ddmm.eclipse.ui.AbstractUiModelTransformationStrategy;
import de.fhdo.ddmm.eclipse.ui.ModelFile;
import de.fhdo.ddmm.eclipse.ui.ModelFileTypeDescription;
import de.fhdo.ddmm.eclipse.ui.select_models_dialog.SelectModelsDialog;
import de.fhdo.ddmm.eclipse.ui.utils.DdmmUiUtils;
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
  
  /**
   * Constructor
   */
  public SelectModelsHandler(final AbstractUiModelTransformationStrategy transformationStrategy) {
    if ((transformationStrategy == null)) {
      throw new IllegalArgumentException("Transformation strategy must not be null");
    }
    this.transformationStrategy = transformationStrategy;
  }
  
  /**
   * Execute handler
   */
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    final Map<IProject, List<IFile>> projectSpecificModelFiles = this.findProjectSpecificModelFiles();
    if (((projectSpecificModelFiles == null) || projectSpecificModelFiles.isEmpty())) {
      final String modelTypePrefix = this.transformationStrategy.getModelTypePrefix();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("No ");
      _builder.append(modelTypePrefix);
      _builder.append(" models found");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("No ");
      _builder_1.append(modelTypePrefix);
      _builder_1.append(" model files found in the wokspace. Transformation not ");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("possible");
      String _plus = (_builder_1.toString() + _builder_2);
      MessageDialog.openInformation(this.SHELL, _builder.toString(), _plus);
      return null;
    }
    final HashMap<IProject, List<ModelFile>> modelFiles = this.convertToModelFiles(projectSpecificModelFiles);
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
   * Find model files according to strategy
   */
  private Map<IProject, List<IFile>> findProjectSpecificModelFiles() {
    final String modelTypePrefix = this.transformationStrategy.getModelTypePrefix();
    final List<String> modelTypeFileExtensions = this.transformationStrategy.getModelFileTypeExtensions();
    if (((modelTypeFileExtensions == null) || modelTypeFileExtensions.isEmpty())) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("No ");
      _builder.append(modelTypePrefix);
      _builder.append(" models found");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("No ");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append(modelTypePrefix);
      _builder_2.append(" model files could be found, because there were no editors ");
      String _plus = (_builder_1.toString() + _builder_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("associated with the respective file types. Do you have the editor plugins ");
      String _plus_1 = (_plus + _builder_3);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("for creating ");
      _builder_4.append(modelTypePrefix);
      _builder_4.append(" models installed?");
      String _plus_2 = (_plus_1 + _builder_4);
      MessageDialog.openError(this.SHELL, _builder.toString(), _plus_2);
      return null;
    }
    final Map<IProject, List<IFile>> modelFiles = this.transformationStrategy.findProjectSpecificModelFiles();
    if (((modelFiles == null) || modelFiles.isEmpty())) {
      final Object extensionEnumeration = DdmmUiUtils.createEnumerationText(modelTypeFileExtensions);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("No ");
      _builder_5.append(modelTypePrefix);
      _builder_5.append(" models found");
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("No ");
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append(modelTypePrefix);
      _builder_7.append(" model files with extensions ");
      _builder_7.append(extensionEnumeration);
      _builder_7.append(" could ");
      String _plus_3 = (_builder_6.toString() + _builder_7);
      StringConcatenation _builder_8 = new StringConcatenation();
      _builder_8.append(" ");
      _builder_8.append("be found in the workspace\'s projects.");
      String _plus_4 = (_plus_3 + _builder_8);
      MessageDialog.openError(this.SHELL, _builder_5.toString(), _plus_4);
      return null;
    }
    return modelFiles;
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
