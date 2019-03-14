package de.fhdo.ddmm.eclipse.ui.transformation_dialog;

import com.google.common.base.Predicate;
import de.fhdo.ddmm.eclipse.ui.ModelFile;
import de.fhdo.ddmm.eclipse.ui.ModelFileTypeDescription;
import de.fhdo.ddmm.intermediate.transformations.AbstractIntermediateModelTransformationStrategy;
import de.fhdo.ddmm.intermediate.transformations.IntermediateTransformationException;
import de.fhdo.ddmm.intermediate.transformations.IntermediateTransformationExceptionKind;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.xbase.lib.Exceptions;
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
  public TransformationThread(final List<ModelFile> modelFiles, final Display display, final Predicate<ModelFile> nextTransformationCallback, final Predicate<IntermediateTransformationException> transformationWarningCallback, final Predicate<Exception> transformationExceptionCallback, final Predicate<Void> currentTransformationFinishedCallback, final Predicate<Void> transformationsFinishedCallback) {
    super();
    if (((modelFiles == null) || modelFiles.isEmpty())) {
      throw new IllegalArgumentException("Input models must not be null or empty");
    }
    this.modelFiles = modelFiles;
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
      final String targetPath = modelFile.getTransformationTargetPath();
      final ModelFileTypeDescription fileTypeDescription = modelFile.getFileTypeDescription();
      final AbstractIntermediateModelTransformationStrategy mainTransformationStrategy = fileTypeDescription.getMainTransformationStrategy();
      final Function1<ModelFile, String> _function = new Function1<ModelFile, String>() {
        public String apply(final ModelFile it) {
          return it.getImportAlias();
        }
      };
      final Function1<ModelFile, String> _function_1 = new Function1<ModelFile, String>() {
        public String apply(final ModelFile it) {
          return it.getTransformationTargetPath();
        }
      };
      final Map<String, String> importTargetPaths = IterableExtensions.<ModelFile, String, String>toMap(modelFile.getChildren(), _function, _function_1);
      final Predicate<IntermediateTransformationException> _function_2 = new Predicate<IntermediateTransformationException>() {
        public boolean apply(final IntermediateTransformationException it) {
          return TransformationThread.this.internalTransformationWarningCallback(it);
        }
      };
      mainTransformationStrategy.mainTransformation(sourceModelFile, targetPath, importTargetPaths, _function_2);
      final Consumer<AbstractIntermediateModelTransformationStrategy> _function_3 = new Consumer<AbstractIntermediateModelTransformationStrategy>() {
        public void accept(final AbstractIntermediateModelTransformationStrategy it) {
          final Path sourceFilePath = new Path(targetPath);
          final IFile sourceFile = ResourcesPlugin.getWorkspace().getRoot().getFile(sourceFilePath);
          final Predicate<IntermediateTransformationException> _function = new Predicate<IntermediateTransformationException>() {
            public boolean apply(final IntermediateTransformationException it) {
              return TransformationThread.this.internalTransformationWarningCallback(it);
            }
          };
          it.refiningTransformation(sourceFile, targetPath, _function);
        }
      };
      fileTypeDescription.getRefiningTransformationStrategies().forEach(_function_3);
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
   * Internal transformation warning callback
   */
  private boolean internalTransformationWarningCallback(final IntermediateTransformationException warning) {
    boolean _xifexpression = false;
    if ((this.transformationWarningCallback != null)) {
      boolean _xblockexpression = false;
      {
        this.display.syncExec(new Runnable() {
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
      public void run() {
        boolean _apply = function.apply(null);
        boolean _not = (!_apply);
        TransformationThread.this.stopTransformations = _not;
      }
    });
  }
}
