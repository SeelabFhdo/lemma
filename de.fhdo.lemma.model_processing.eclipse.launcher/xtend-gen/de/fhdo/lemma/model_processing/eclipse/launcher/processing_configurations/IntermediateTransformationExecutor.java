package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations;

import com.google.common.base.Predicate;
import de.fhdo.lemma.eclipse.ui.ModelFile;
import de.fhdo.lemma.eclipse.ui.ProgrammaticIntermediateModelTransformation;
import de.fhdo.lemma.model_processing.eclipse.launcher.Utils;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

/**
 * Class to execute intermediate model transformations from a given model processing launch
 * configuration. Basically, the executor is a wrapper for programmatic intermediate transformations
 * on LEMMA models to let them run using Eclipse's Job Framework.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class IntermediateTransformationExecutor {
  private final ProcessingConfiguration configuration;
  
  private final MessageConsoleStream infoStream;
  
  private final MessageConsoleStream errorStream;
  
  private final Procedure0 successfulCallback;
  
  private final Procedure0 errorOrCancelCallback;
  
  private IProgressMonitor monitor;
  
  private boolean stopTransformations;
  
  /**
   * Constructor. The successfulCallback will be invoked when all transformations were executed
   * without a single error and the user canceling transformation execution. The
   * errorOrCancelCallback will be invoked when a transformation occurred or the user canceled
   * transformation execution.
   */
  public IntermediateTransformationExecutor(final ProcessingConfiguration configuration, final MessageConsoleStream infoStream, final MessageConsoleStream errorStream, final Procedure0 successfulCallback, final Procedure0 errorOrCancelCallback) {
    this.configuration = configuration;
    this.infoStream = infoStream;
    this.errorStream = errorStream;
    this.successfulCallback = successfulCallback;
    this.errorOrCancelCallback = errorOrCancelCallback;
  }
  
  /**
   * Run the intermediate model transformation in a new Eclipse Job
   */
  public final void run() {
    final Job job = new Job("LEMMA intermediate transformation") {
      @Override
      public IStatus run(final IProgressMonitor monitor) {
        final SubMonitor subMonitor = SubMonitor.convert(monitor, 1);
        IntermediateTransformationExecutor.this.monitor = subMonitor;
        IFile _sourceModelFile = IntermediateTransformationExecutor.this.configuration.getSourceModelFile();
        final Predicate<ModelFile> _function = (ModelFile it) -> {
          return IntermediateTransformationExecutor.this.nextIntermediateTransformation(it);
        };
        final Predicate<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationException> _function_1 = (ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationException it) -> {
          return IntermediateTransformationExecutor.this.intermediateTransformationException(it);
        };
        final Predicate<List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult>> _function_2 = (List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult> it) -> {
          return IntermediateTransformationExecutor.this.transformationSuccessful(it);
        };
        final Function2<List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult>, List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationException>, Boolean> _function_3 = (List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult> results, List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationException> exceptions) -> {
          return Boolean.valueOf(IntermediateTransformationExecutor.this.transformationsFinished(results, exceptions));
        };
        new ProgrammaticIntermediateModelTransformation(_sourceModelFile).run(
          "PROCESSING_CONFIGURATION_EXECUTION", 
          null, 
          null, 
          true, _function, _function_1, _function_2, _function_3);
        IStatus _xifexpression = null;
        boolean _isCanceled = subMonitor.isCanceled();
        boolean _not = (!_isCanceled);
        if (_not) {
          _xifexpression = Status.OK_STATUS;
        } else {
          _xifexpression = Status.CANCEL_STATUS;
        }
        return _xifexpression;
      }
    };
    job.schedule();
  }
  
  /**
   * Callback when the next intermediate transformation is about to start
   */
  private boolean nextIntermediateTransformation(final ModelFile modelFile) {
    boolean _stopTransformations = this.stopTransformations();
    if (_stopTransformations) {
      return false;
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"");
    IPath _fullPath = modelFile.getFile().getProject().getFullPath();
    _builder.append(_fullPath);
    _builder.append("/");
    IPath _projectRelativePath = modelFile.getFile().getProjectRelativePath();
    _builder.append(_projectRelativePath);
    _builder.append("\"");
    String _plus = ("Running intermediate transformation of model file " + _builder);
    this.infoStream.println(_plus);
    boolean _canceledByUser = this.canceledByUser();
    return (!_canceledByUser);
  }
  
  /**
   * Indicate whether all transformations shall be stopped which is the case when either the
   * stopTransformations flag was set or the user actively canceled the transformations
   */
  private boolean stopTransformations() {
    if (this.stopTransformations) {
      return true;
    } else {
      boolean _canceledByUser = this.canceledByUser();
      if (_canceledByUser) {
        this.stopTransformations = true;
        return true;
      } else {
        return false;
      }
    }
  }
  
  /**
   * Check whether the user actively canceled the transformations. If so, also print a message to
   * the error stream.
   */
  private boolean canceledByUser() {
    boolean _isCanceled = this.monitor.isCanceled();
    if (_isCanceled) {
      this.errorStream.println("Transformations aborted by user");
      this.errorOrCancelCallback.apply();
    }
    return this.monitor.isCanceled();
  }
  
  /**
   * Callback for transformation exceptions. The occurrence of an exception leads to a stop of all
   * transformations.
   */
  private boolean intermediateTransformationException(final ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationException ex) {
    boolean _stopTransformations = this.stopTransformations();
    boolean _not = (!_stopTransformations);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Error: ");
      String _message = ex.getMessage();
      _builder.append(_message);
      String _plus = ("\t" + _builder);
      String _plus_1 = (_plus + "\n\tTransformations aborted.");
      this.errorStream.println(_plus_1);
      this.stopTransformations = true;
    }
    this.monitor.worked(1);
    this.errorOrCancelCallback.apply();
    return false;
  }
  
  /**
   * Callback for a successful transformation
   */
  private boolean transformationSuccessful(final List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult> results) {
    boolean _stopTransformations = this.stopTransformations();
    if (_stopTransformations) {
      return false;
    }
    Utils.printlnIndent(this.infoStream, "Successful.");
    this.infoStream.println();
    boolean _canceledByUser = this.canceledByUser();
    return (!_canceledByUser);
  }
  
  /**
   * Callback after all transformations were finished
   */
  private boolean transformationsFinished(final List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult> allResults, final List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationException> allExceptions) {
    boolean _stopTransformations = this.stopTransformations();
    if (_stopTransformations) {
      return false;
    }
    final int errorCount = allExceptions.size();
    String _xifexpression = null;
    if ((errorCount == 1)) {
      _xifexpression = "error";
    } else {
      _xifexpression = "errors";
    }
    final String errorsSuffix = _xifexpression;
    final int resultCount = this.getUniqueOutputPaths(allResults).size();
    String _xifexpression_1 = null;
    if ((resultCount == 1)) {
      _xifexpression_1 = "result file";
    } else {
      _xifexpression_1 = "result files";
    }
    final String resultsSuffix = _xifexpression_1;
    boolean _isEmpty = allExceptions.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Transformations finished (");
      _builder.append(errorCount);
      _builder.append(" ");
      _builder.append(errorsSuffix);
      _builder.append(", ");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append(resultCount);
      _builder_1.append(" ");
      _builder_1.append(resultsSuffix);
      _builder_1.append(" from successful transformations)");
      String _plus = (_builder.toString() + _builder_1);
      this.infoStream.println(_plus);
    } else {
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("All transformations finished successfully (");
      _builder_2.append(resultCount);
      _builder_2.append(" ");
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append(resultsSuffix);
      _builder_3.append(")");
      String _plus_1 = (_builder_2.toString() + _builder_3);
      this.infoStream.println(_plus_1);
    }
    boolean _isEmpty_1 = allResults.isEmpty();
    boolean _not_1 = (!_isEmpty_1);
    if (_not_1) {
      Utils.printlnIndent(this.infoStream, "Resulting model files:");
      final Consumer<String> _function = (String it) -> {
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("- ");
        _builder_4.append(it);
        Utils.printlnIndent(this.infoStream, _builder_4.toString(), 2);
      };
      IterableExtensions.<String>sort(this.getUniqueOutputPaths(allResults)).forEach(_function);
    }
    if ((allExceptions.isEmpty() && (!this.canceledByUser()))) {
      this.successfulCallback.apply();
    }
    this.monitor.worked(1);
    return true;
  }
  
  /**
   * Helper to filter duplicate output paths of intermediate models from a given list of
   * ProgrammaticIntermediateModelTransformationResult instances. The result will be a Set of
   * Strings comprising the output paths.
   */
  private Set<String> getUniqueOutputPaths(final List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult> results) {
    final Function1<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult, String> _function = (ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult it) -> {
      return it.getResult().getOutputModel().getOutputPath();
    };
    return IterableExtensions.<String>toSet(ListExtensions.<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult, String>map(results, _function));
  }
}
