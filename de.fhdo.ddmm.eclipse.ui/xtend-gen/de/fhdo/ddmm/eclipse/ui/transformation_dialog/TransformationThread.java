package de.fhdo.ddmm.eclipse.ui.transformation_dialog;

import com.google.common.base.Predicate;
import de.fhdo.ddmm.eclipse.ui.ModelFile;
import de.fhdo.ddmm.eclipse.ui.ModelFileTypeDescription;
import de.fhdo.ddmm.eclipse.ui.utils.DdmmUiUtils;
import de.fhdo.ddmm.intermediate.transformations.AbstractIntermediateModelTransformationStrategy;
import de.fhdo.ddmm.intermediate.transformations.IntermediateTransformationException;
import de.fhdo.ddmm.intermediate.transformations.IntermediateTransformationExceptionKind;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Thread to perform actual intermediate model transformations.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class TransformationThread extends Thread {
  private List<ModelFile> modelFiles;
  
  private boolean outputRefinementModels;
  
  private volatile boolean stopTransformations;
  
  private volatile boolean continueTransformationAfterWarning;
  
  private Predicate<ModelFile> nextTransformationCallback;
  
  private Predicate<IntermediateTransformationException> transformationWarningCallback;
  
  private Predicate<Exception> transformationExceptionCallback;
  
  private Predicate<Void> currentTransformationFinishedCallback;
  
  private Predicate<Void> transformationsFinishedCallback;
  
  private Display display;
  
  /**
   * Constructor
   */
  public TransformationThread(final List<ModelFile> modelFiles, final boolean outputRefinementModels, final Display display, final Predicate<ModelFile> nextTransformationCallback, final Predicate<IntermediateTransformationException> transformationWarningCallback, final Predicate<Exception> transformationExceptionCallback, final Predicate<Void> currentTransformationFinishedCallback, final Predicate<Void> transformationsFinishedCallback) {
    super();
    if (((modelFiles == null) || modelFiles.isEmpty())) {
      throw new IllegalArgumentException("Input models must not be null or empty");
    }
    this.modelFiles = modelFiles;
    this.outputRefinementModels = outputRefinementModels;
    this.nextTransformationCallback = nextTransformationCallback;
    this.transformationExceptionCallback = transformationExceptionCallback;
    this.transformationWarningCallback = transformationWarningCallback;
    this.currentTransformationFinishedCallback = currentTransformationFinishedCallback;
    this.transformationsFinishedCallback = transformationsFinishedCallback;
    this.display = display;
  }
  
  /**
   * Run model transformations on given files
   */
  @Override
  public void run() {
    int i = 0;
    while (((i < this.modelFiles.size()) && (!this.stopTransformations))) {
      {
        final ModelFile modelFile = this.modelFiles.get(i);
        this.invokeGuiCallbackIfSpecified(this.nextTransformationCallback, modelFile);
        this.doTransformation(modelFile);
        this.invokeGuiCallbackIfSpecified(this.currentTransformationFinishedCallback);
        i++;
      }
    }
    this.invokeGuiCallbackIfSpecified(this.transformationsFinishedCallback);
  }
  
  /**
   * Perform transformation on a model file
   */
  private Boolean doTransformation(final ModelFile modelFile) {
    boolean _xtrycatchfinallyexpression = false;
    try {
      final IFile sourceModelFile = modelFile.getFile();
      final ModelFileTypeDescription fileTypeDescription = modelFile.getFileTypeDescription();
      final Deque<String> targetPaths = this.buildTransformationTargetPaths(modelFile.getTransformationTargetPath(), fileTypeDescription, this.outputRefinementModels);
      final AbstractIntermediateModelTransformationStrategy mainTransformationStrategy = fileTypeDescription.getMainTransformationStrategy();
      final Function1<ModelFile, String> _function = (ModelFile it) -> {
        return it.getImportAlias();
      };
      final Function1<ModelFile, String> _function_1 = (ModelFile it) -> {
        return it.getTransformationTargetPath();
      };
      final Map<String, String> importTargetPaths = IterableExtensions.<ModelFile, String, String>toMap(modelFile.getChildren(), _function, _function_1);
      boolean _considerChildrensChildrenForImportTargetPaths = mainTransformationStrategy.considerChildrensChildrenForImportTargetPaths();
      if (_considerChildrensChildrenForImportTargetPaths) {
        final Consumer<ModelFile> _function_2 = (ModelFile it) -> {
          final Function1<ModelFile, String> _function_3 = (ModelFile it_1) -> {
            return it_1.getImportAlias();
          };
          final Function1<ModelFile, String> _function_4 = (ModelFile it_1) -> {
            return it_1.getTransformationTargetPath();
          };
          importTargetPaths.putAll(
            IterableExtensions.<ModelFile, String, String>toMap(it.getChildren(), _function_3, _function_4));
        };
        modelFile.getChildren().forEach(_function_2);
      }
      String targetPath = targetPaths.pop();
      final Predicate<IntermediateTransformationException> _function_3 = (IntermediateTransformationException it) -> {
        return this.internalTransformationWarningCallback(it);
      };
      mainTransformationStrategy.mainTransformation(sourceModelFile, targetPath, importTargetPaths, _function_3);
      String previousTargetPath = targetPath;
      int _size = fileTypeDescription.getRefiningTransformationStrategies().size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for (final Integer i : _doubleDotLessThan) {
        {
          if (this.outputRefinementModels) {
            targetPath = targetPaths.pop();
          }
          final Path sourceFilePath = new Path(previousTargetPath);
          final IFile sourceFile = ResourcesPlugin.getWorkspace().getRoot().getFile(sourceFilePath);
          final AbstractIntermediateModelTransformationStrategy refiningStrategy = fileTypeDescription.getRefiningTransformationStrategies().get((i).intValue());
          final Predicate<IntermediateTransformationException> _function_4 = (IntermediateTransformationException it) -> {
            return this.internalTransformationWarningCallback(it);
          };
          refiningStrategy.refiningTransformation(sourceFile, targetPath, _function_4);
          previousTargetPath = targetPath;
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof IntermediateTransformationException) {
        final IntermediateTransformationException ex = (IntermediateTransformationException)_t;
        boolean _xifexpression = false;
        IntermediateTransformationExceptionKind _kind = ex.getKind();
        boolean _tripleEquals = (_kind == IntermediateTransformationExceptionKind.WARNING);
        if (_tripleEquals) {
          _xifexpression = this.internalTransformationWarningCallback(ex);
        } else {
          this.invokeGuiCallbackIfSpecified(this.transformationExceptionCallback, ex);
        }
        _xtrycatchfinallyexpression = _xifexpression;
      } else if (_t instanceof Exception) {
        final Exception ex_1 = (Exception)_t;
        ex_1.printStackTrace();
        this.invokeGuiCallbackIfSpecified(this.transformationExceptionCallback, ex_1);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return Boolean.valueOf(_xtrycatchfinallyexpression);
  }
  
  /**
   * Build target paths for transformations by considering refining transformations
   */
  private Deque<String> buildTransformationTargetPaths(final String initialTargetPath, final ModelFileTypeDescription fileTypeDescription, final boolean outputRefinementModels) {
    final ArrayDeque<String> targetPaths = new ArrayDeque<String>();
    final int refiningStrategiesCount = fileTypeDescription.getRefiningTransformationStrategies().size();
    if (((refiningStrategiesCount > 0) && outputRefinementModels)) {
      final String basicFilename = DdmmUiUtils.removeExtension(initialTargetPath);
      final String ext = DdmmUiUtils.getExtension(initialTargetPath);
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, refiningStrategiesCount, true);
      for (final Integer i : _doubleDotLessThan) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("_");
        _builder.append(((i).intValue() + 1));
        _builder.append(".");
        _builder.append(ext);
        String _plus = (basicFilename + _builder);
        targetPaths.add(_plus);
      }
    }
    targetPaths.add(initialTargetPath);
    return targetPaths;
  }
  
  /**
   * Internal transformation warning callback
   */
  private boolean internalTransformationWarningCallback(final IntermediateTransformationException warning) {
    boolean _xifexpression = false;
    if ((this.transformationWarningCallback != null)) {
      boolean _xblockexpression = false;
      {
        this.display.syncExec(new Runnable() {
          @Override
          public void run() {
            TransformationThread.this.continueTransformationAfterWarning = TransformationThread.this.transformationWarningCallback.apply(warning);
          }
        });
        _xblockexpression = this.continueTransformationAfterWarning;
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = true;
    }
    return _xifexpression;
  }
  
  /**
   * Helper to invoke a callback function in sync with the current display, i.e., the GUI. May
   * lead to aborting all transformations.
   */
  private void invokeGuiCallbackIfSpecified(final Predicate<ModelFile> function, final ModelFile arg) {
    if ((function == null)) {
      return;
    }
    this.display.syncExec(new Runnable() {
      @Override
      public void run() {
        boolean _apply = function.apply(arg);
        boolean _not = (!_apply);
        TransformationThread.this.stopTransformations = _not;
      }
    });
  }
  
  /**
   * Helper to invoke a callback function in sync with the current display, i.e., the GUI. May
   * lead to aborting all transformations.
   */
  private void invokeGuiCallbackIfSpecified(final Predicate<Exception> function, final Exception arg) {
    if ((function == null)) {
      return;
    }
    this.display.syncExec(new Runnable() {
      @Override
      public void run() {
        boolean _apply = function.apply(arg);
        boolean _not = (!_apply);
        TransformationThread.this.stopTransformations = _not;
      }
    });
  }
  
  /**
   * Helper to invoke a callback function in sync with the current display, i.e., the GUI. May
   * lead to aborting all transformations.
   */
  private void invokeGuiCallbackIfSpecified(final Predicate<Void> function) {
    if ((function == null)) {
      return;
    }
    this.display.syncExec(new Runnable() {
      @Override
      public void run() {
        boolean _apply = function.apply(null);
        boolean _not = (!_apply);
        TransformationThread.this.stopTransformations = _not;
      }
    });
  }
}
