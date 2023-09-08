package de.fhdo.lemma.eclipse.ui.transformation_dialog;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import de.fhdo.lemma.eclipse.ui.ModelFile;
import de.fhdo.lemma.eclipse.ui.ModelFileTypeDescription;
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils;
import de.fhdo.lemma.intermediate.transformations.AbstractIntermediateModelTransformationStrategy;
import de.fhdo.lemma.intermediate.transformations.IntermediateTransformationException;
import de.fhdo.lemma.intermediate.transformations.IntermediateTransformationExceptionKind;
import de.fhdo.lemma.intermediate.transformations.TransformationModelDescription;
import de.fhdo.lemma.utils.LemmaUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Thread to perform actual intermediate model transformations.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class TransformationThread extends Thread {
  /**
   * Type alias for
   * HashMap<AbstractIntermediateModelTransformationStrategy<?, ?>, List<TransformationResult>>
   */
  private static class TransformationResultsPerStrategy extends HashMap<AbstractIntermediateModelTransformationStrategy<?, ?>, List<AbstractIntermediateModelTransformationStrategy.TransformationResult>> {
  }

  private List<ModelFile> modelFiles;

  private boolean convertToRelativeUris;

  private boolean outputRefinementModels;

  private volatile boolean stopTransformations;

  private volatile boolean continueTransformationAfterWarning;

  private Predicate<ModelFile> nextTransformationCallback;

  private Predicate<IntermediateTransformationException> transformationWarningCallback;

  private Predicate<Exception> transformationExceptionCallback;

  private Predicate<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>> currentTransformationFinishedCallback;

  private Predicate<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>> transformationsFinishedCallback;

  private Display display;

  private LinkedHashMap<AbstractIntermediateModelTransformationStrategy<?, ?>, Function2<? super List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, ? super Predicate<IntermediateTransformationException>, ? extends List<AbstractIntermediateModelTransformationStrategy.TransformationResult>>> transformationsFinishedListeners;

  /**
   * Constructor
   */
  public TransformationThread(final LinkedList<ModelFile> modelFiles, final boolean convertToRelativeUris, final boolean outputRefinementModels, final Display display, final Predicate<ModelFile> nextTransformationCallback, final Predicate<IntermediateTransformationException> transformationWarningCallback, final Predicate<Exception> transformationExceptionCallback, final Predicate<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>> currentTransformationFinishedCallback, final Predicate<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>> transformationsFinishedCallback) {
    super();
    if (((modelFiles == null) || modelFiles.isEmpty())) {
      throw new IllegalArgumentException("Input models must not be null or empty");
    }
    this.modelFiles = modelFiles;
    this.convertToRelativeUris = convertToRelativeUris;
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
    this.transformationsFinishedListeners = CollectionLiterals.<AbstractIntermediateModelTransformationStrategy<?, ?>, Function2<? super List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, ? super Predicate<IntermediateTransformationException>, ? extends List<AbstractIntermediateModelTransformationStrategy.TransformationResult>>>newLinkedHashMap();
    final TransformationThread.TransformationResultsPerStrategy allTransformationStrategiesAndResults = new TransformationThread.TransformationResultsPerStrategy();
    for (int i = 0; ((i < this.modelFiles.size()) && (!this.stopTransformations)); i++) {
      {
        final ModelFile modelFile = this.modelFiles.get(i);
        this.invokeCallbackIfSpecified(this.nextTransformationCallback, modelFile);
        final Pair<AbstractIntermediateModelTransformationStrategy<?, ?>, List<AbstractIntermediateModelTransformationStrategy.TransformationResult>> transformationStrategyAndResults = this.executeTransformations(modelFile);
        if ((transformationStrategyAndResults != null)) {
          final AbstractIntermediateModelTransformationStrategy<?, ?> strategy = transformationStrategyAndResults.getKey();
          final List<AbstractIntermediateModelTransformationStrategy.TransformationResult> results = transformationStrategyAndResults.getValue();
          allTransformationStrategiesAndResults.put(strategy, results);
          this.invokeCallbackIfSpecified(this.currentTransformationFinishedCallback, 
            Collections.<AbstractIntermediateModelTransformationStrategy.TransformationResult>unmodifiableList(results));
        } else {
          this.invokeCallbackIfSpecified(this.currentTransformationFinishedCallback, CollectionLiterals.<AbstractIntermediateModelTransformationStrategy.TransformationResult>emptyList());
        }
      }
    }
    final List<AbstractIntermediateModelTransformationStrategy.TransformationResult> allTransformationResults = IterableExtensions.<AbstractIntermediateModelTransformationStrategy.TransformationResult>toList(Iterables.<AbstractIntermediateModelTransformationStrategy.TransformationResult>concat(allTransformationStrategiesAndResults.values()));
    this.convertModelPathsToAbsoluteFileUris(allTransformationResults);
    final TransformationThread.TransformationResultsPerStrategy additionalResults = this.executeTransformationsFinishedListeners(allTransformationResults);
    final BiConsumer<AbstractIntermediateModelTransformationStrategy<?, ?>, List<AbstractIntermediateModelTransformationStrategy.TransformationResult>> _function = (AbstractIntermediateModelTransformationStrategy<?, ?> strategy, List<AbstractIntermediateModelTransformationStrategy.TransformationResult> results) -> {
      List<AbstractIntermediateModelTransformationStrategy.TransformationResult> _putIfAbsent = allTransformationStrategiesAndResults.putIfAbsent(strategy, results);
      if (_putIfAbsent!=null) {
        _putIfAbsent.addAll(results);
      }
      allTransformationResults.addAll(results);
    };
    additionalResults.forEach(_function);
    this.invokeCallbackIfSpecified(this.transformationsFinishedCallback, 
      Collections.<AbstractIntermediateModelTransformationStrategy.TransformationResult>unmodifiableList(allTransformationResults));
    if (this.convertToRelativeUris) {
      final BiConsumer<AbstractIntermediateModelTransformationStrategy<?, ?>, List<AbstractIntermediateModelTransformationStrategy.TransformationResult>> _function_1 = (AbstractIntermediateModelTransformationStrategy<?, ?> strategy, List<AbstractIntermediateModelTransformationStrategy.TransformationResult> results) -> {
        final Consumer<AbstractIntermediateModelTransformationStrategy.TransformationResult> _function_2 = (AbstractIntermediateModelTransformationStrategy.TransformationResult it) -> {
          try {
            strategy.makeUrisRelative(it);
            it.getOutputModel().getResource().save(CollectionLiterals.<Object, Object>emptyMap());
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        };
        results.forEach(_function_2);
      };
      allTransformationStrategiesAndResults.forEach(_function_1);
    }
  }

  /**
   * Execute main and refining transformations on a model file
   */
  private Pair<AbstractIntermediateModelTransformationStrategy<?, ?>, List<AbstractIntermediateModelTransformationStrategy.TransformationResult>> executeTransformations(final ModelFile modelFile) {
    try {
      final ArrayList<AbstractIntermediateModelTransformationStrategy.TransformationResult> results = CollectionLiterals.<AbstractIntermediateModelTransformationStrategy.TransformationResult>newArrayList();
      final List<String> outputPaths = this.buildTransformationOutputPaths(modelFile.getTransformationTargetPath(), 
        modelFile.getFileTypeDescription(), this.outputRefinementModels);
      final String mainOutputPath = outputPaths.get(0);
      final Pair<AbstractIntermediateModelTransformationStrategy<?, ?>, AbstractIntermediateModelTransformationStrategy.TransformationResult> mainTransformationResultAndStrategy = this.mainTransformation(modelFile, mainOutputPath);
      final AbstractIntermediateModelTransformationStrategy<?, ?> maintransformationStrategy = mainTransformationResultAndStrategy.getKey();
      final AbstractIntermediateModelTransformationStrategy.TransformationResult mainTransformationResult = mainTransformationResultAndStrategy.getValue();
      if ((mainTransformationResult != null)) {
        results.add(mainTransformationResult);
      } else {
        return null;
      }
      final List<AbstractIntermediateModelTransformationStrategy.TransformationResult> refiningTransformationResults = this.refiningTransformations(modelFile, outputPaths);
      if ((refiningTransformationResults != null)) {
        results.addAll(refiningTransformationResults);
      } else {
        return null;
      }
      return Pair.<AbstractIntermediateModelTransformationStrategy<?, ?>, List<AbstractIntermediateModelTransformationStrategy.TransformationResult>>of(maintransformationStrategy, results);
    } catch (final Throwable _t) {
      if (_t instanceof IntermediateTransformationException) {
        final IntermediateTransformationException ex = (IntermediateTransformationException)_t;
        IntermediateTransformationExceptionKind _kind = ex.getKind();
        boolean _tripleEquals = (_kind == IntermediateTransformationExceptionKind.WARNING);
        if (_tripleEquals) {
          this.internalTransformationWarningCallback(ex);
        } else {
          this.invokeCallbackIfSpecified(this.transformationExceptionCallback, ex);
        }
        return null;
      } else if (_t instanceof Exception) {
        final Exception ex_1 = (Exception)_t;
        ex_1.printStackTrace();
        this.invokeCallbackIfSpecified(this.transformationExceptionCallback, ex_1);
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }

  /**
   * Build output paths for transformations by considering refining transformations
   */
  private List<String> buildTransformationOutputPaths(final String initialOutputPath, final ModelFileTypeDescription fileTypeDescription, final boolean outputRefinementModels) {
    final ArrayList<String> outputPaths = CollectionLiterals.<String>newArrayList();
    if (((fileTypeDescription.refiningStrategiesCount() > 0) && outputRefinementModels)) {
      final String basicFilename = LemmaUiUtils.removeExtension(initialOutputPath);
      final String ext = LemmaUiUtils.getExtension(initialOutputPath);
      int _refiningStrategiesCount = fileTypeDescription.refiningStrategiesCount();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _refiningStrategiesCount, true);
      for (final Integer i : _doubleDotLessThan) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("_");
        _builder.append(((i).intValue() + 1));
        _builder.append(".");
        _builder.append(ext);
        String _plus = (basicFilename + _builder);
        outputPaths.add(_plus);
      }
    }
    outputPaths.add(initialOutputPath);
    return outputPaths;
  }

  /**
   * Execute main transformation on a model file
   */
  private Pair<AbstractIntermediateModelTransformationStrategy<?, ?>, AbstractIntermediateModelTransformationStrategy.TransformationResult> mainTransformation(final ModelFile modelFile, final String outputPath) {
    final AbstractIntermediateModelTransformationStrategy<?, ?> strategy = modelFile.getFileTypeDescription().createMainTransformationStrategy();
    final Function1<ModelFile, String> _function = (ModelFile it) -> {
      return it.getImportAlias();
    };
    final Function1<ModelFile, String> _function_1 = (ModelFile it) -> {
      return it.getTransformationTargetPath();
    };
    final Map<String, String> importTargetPaths = IterableExtensions.<ModelFile, String, String>toMap(modelFile.getChildren(), _function, _function_1);
    boolean _considerChildrensChildrenForImportTargetPaths = strategy.considerChildrensChildrenForImportTargetPaths();
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
    Pair<String, Map<String, String>> _mappedTo = Pair.<String, Map<String, String>>of(outputPath, importTargetPaths);
    AbstractIntermediateModelTransformationStrategy.TransformationResult _executeTransformation = this.executeTransformation(modelFile.getFile(), strategy, outputPath, 
      Collections.<String, Map<String, String>>unmodifiableMap(CollectionLiterals.<String, Map<String, String>>newHashMap(_mappedTo)));
    return Pair.<AbstractIntermediateModelTransformationStrategy<?, ?>, AbstractIntermediateModelTransformationStrategy.TransformationResult>of(strategy, _executeTransformation);
  }

  /**
   * Execute a single transformation strategy on an input file
   */
  private AbstractIntermediateModelTransformationStrategy.TransformationResult executeTransformation(final IFile inputFile, final AbstractIntermediateModelTransformationStrategy<?, ?> strategy, final String outputPath, final Map<String, Map<String, String>> targetPathsOfImports) {
    final Predicate<IntermediateTransformationException> _function = (IntermediateTransformationException it) -> {
      return this.internalTransformationWarningCallback(it);
    };
    Map<TransformationModelDescription, AbstractIntermediateModelTransformationStrategy.TransformationResult> _doTransformationFromFiles = strategy.doTransformationFromFiles(
      Collections.<IFile>unmodifiableList(CollectionLiterals.<IFile>newArrayList(inputFile)), 
      Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(outputPath)), targetPathsOfImports, _function);
    Collection<AbstractIntermediateModelTransformationStrategy.TransformationResult> _values = null;
    if (_doTransformationFromFiles!=null) {
      _values=_doTransformationFromFiles.values();
    }
    AbstractIntermediateModelTransformationStrategy.TransformationResult _get = null;
    if (((AbstractIntermediateModelTransformationStrategy.TransformationResult[])Conversions.unwrapArray(_values, AbstractIntermediateModelTransformationStrategy.TransformationResult.class))!=null) {
      _get=((AbstractIntermediateModelTransformationStrategy.TransformationResult[])Conversions.unwrapArray(_values, AbstractIntermediateModelTransformationStrategy.TransformationResult.class))[0];
    }
    final AbstractIntermediateModelTransformationStrategy.TransformationResult transformationResult = ((AbstractIntermediateModelTransformationStrategy.TransformationResult) _get);
    final Function2<? super List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, ? super Predicate<IntermediateTransformationException>, ? extends List<AbstractIntermediateModelTransformationStrategy.TransformationResult>> finishedListener = strategy.registerTransformationsFinishedListener();
    if (((finishedListener != null) && (transformationResult != null))) {
      this.transformationsFinishedListeners.put(strategy, finishedListener);
    }
    return transformationResult;
  }

  /**
   * Execute refining transformations on a model file
   */
  private List<AbstractIntermediateModelTransformationStrategy.TransformationResult> refiningTransformations(final ModelFile modelFile, final List<String> outputPaths) {
    final ArrayList<AbstractIntermediateModelTransformationStrategy.TransformationResult> transformationResults = CollectionLiterals.<AbstractIntermediateModelTransformationStrategy.TransformationResult>newArrayList();
    int outputPathIndex = 0;
    final ModelFileTypeDescription fileTypeDescription = modelFile.getFileTypeDescription();
    int _refiningStrategiesCount = fileTypeDescription.refiningStrategiesCount();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _refiningStrategiesCount, true);
    for (final Integer strategyIndex : _doubleDotLessThan) {
      {
        Path inputFilePath = null;
        String outputFilePath = null;
        if (this.outputRefinementModels) {
          String _get = outputPaths.get(outputPathIndex);
          Path _path = new Path(_get);
          inputFilePath = _path;
          outputFilePath = outputPaths.get((outputPathIndex + 1));
          outputPathIndex++;
        } else {
          String _get_1 = outputPaths.get(0);
          Path _path_1 = new Path(_get_1);
          inputFilePath = _path_1;
          outputFilePath = outputPaths.get(0);
        }
        final AbstractIntermediateModelTransformationStrategy<?, ?> strategy = fileTypeDescription.createRefiningTransformationStrategy((strategyIndex).intValue());
        final IFile inputFile = ResourcesPlugin.getWorkspace().getRoot().getFile(inputFilePath);
        final AbstractIntermediateModelTransformationStrategy.TransformationResult transformationResult = this.executeTransformation(inputFile, strategy, outputFilePath, 
          null);
        if ((transformationResult != null)) {
          transformationResults.add(transformationResult);
        } else {
          return null;
        }
      }
    }
    return transformationResults;
  }

  /**
   * Convert the paths of input and output models in the given set of transformation results to
   * absolute file URIs
   */
  private void convertModelPathsToAbsoluteFileUris(final List<AbstractIntermediateModelTransformationStrategy.TransformationResult> results) {
    final Consumer<AbstractIntermediateModelTransformationStrategy.TransformationResult> _function = (AbstractIntermediateModelTransformationStrategy.TransformationResult it) -> {
      final Consumer<AbstractIntermediateModelTransformationStrategy.InputModel> _function_1 = (AbstractIntermediateModelTransformationStrategy.InputModel it_1) -> {
        it_1.setInputPath(LemmaUtils.convertToFileUri(it_1.getInputPath()));
      };
      it.getInputModels().forEach(_function_1);
      AbstractIntermediateModelTransformationStrategy.OutputModel _outputModel = it.getOutputModel();
      _outputModel.setOutputPath(LemmaUtils.convertProjectPathToAbsoluteFileUri(it.getOutputModel().getOutputPath()));
    };
    results.forEach(_function);
  }

  /**
   * Execute transformation finished listeners
   */
  private TransformationThread.TransformationResultsPerStrategy executeTransformationsFinishedListeners(final List<AbstractIntermediateModelTransformationStrategy.TransformationResult> results) {
    final TransformationThread.TransformationResultsPerStrategy additionalResultsPerStrategy = new TransformationThread.TransformationResultsPerStrategy();
    try {
      final BiConsumer<AbstractIntermediateModelTransformationStrategy<?, ?>, Function2<? super List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, ? super Predicate<IntermediateTransformationException>, ? extends List<AbstractIntermediateModelTransformationStrategy.TransformationResult>>> _function = (AbstractIntermediateModelTransformationStrategy<?, ?> strategy, Function2<? super List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, ? super Predicate<IntermediateTransformationException>, ? extends List<AbstractIntermediateModelTransformationStrategy.TransformationResult>> listener) -> {
        final Predicate<IntermediateTransformationException> _function_1 = (IntermediateTransformationException it) -> {
          return this.internalTransformationWarningCallback(it);
        };
        final List<AbstractIntermediateModelTransformationStrategy.TransformationResult> additionalResults = listener.apply(results, _function_1);
        if (((additionalResults != null) && (!additionalResults.isEmpty()))) {
          additionalResultsPerStrategy.put(strategy, additionalResults);
        }
      };
      this.transformationsFinishedListeners.forEach(_function);
    } catch (final Throwable _t) {
      if (_t instanceof IntermediateTransformationException) {
        final IntermediateTransformationException ex = (IntermediateTransformationException)_t;
        IntermediateTransformationExceptionKind _kind = ex.getKind();
        boolean _tripleEquals = (_kind == IntermediateTransformationExceptionKind.WARNING);
        if (_tripleEquals) {
          this.internalTransformationWarningCallback(ex);
        } else {
          this.invokeCallbackIfSpecified(this.transformationExceptionCallback, ex);
        }
      } else if (_t instanceof Exception) {
        final Exception ex_1 = (Exception)_t;
        ex_1.printStackTrace();
        this.invokeCallbackIfSpecified(this.transformationExceptionCallback, ex_1);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return additionalResultsPerStrategy;
  }

  /**
   * Internal transformation warning callback
   */
  private boolean internalTransformationWarningCallback(final IntermediateTransformationException warning) {
    if ((this.transformationWarningCallback == null)) {
      return true;
    }
    if ((this.display != null)) {
      this.display.syncExec(new Runnable() {
        @Override
        public void run() {
          TransformationThread.this.continueTransformationAfterWarning = TransformationThread.this.transformationWarningCallback.apply(warning);
        }
      });
    } else {
      this.continueTransformationAfterWarning = this.transformationWarningCallback.apply(warning);
    }
    return this.continueTransformationAfterWarning;
  }

  /**
   * Helper to invoke a callback function. In case a Display instance is available, i.e., we're in
   * a GUI thread, the function invocation will happen in sync with GUI thread.
   */
  private void invokeCallbackIfSpecified(final Predicate<ModelFile> function, final ModelFile modelFile) {
    if ((function == null)) {
      return;
    }
    if ((this.display != null)) {
      this.display.syncExec(new Runnable() {
        @Override
        public void run() {
          boolean _apply = function.apply(modelFile);
          boolean _not = (!_apply);
          TransformationThread.this.stopTransformations = _not;
        }
      });
    } else {
      boolean _apply = function.apply(modelFile);
      boolean _not = (!_apply);
      this.stopTransformations = _not;
    }
  }

  /**
   * Helper to invoke a callback function. In case a Display instance is available, i.e., we're in
   * a GUI thread, the function invocation will happen in sync with GUI thread.
   */
  private void invokeCallbackIfSpecified(final Predicate<Exception> function, final Exception exception) {
    if ((function == null)) {
      return;
    }
    if ((this.display != null)) {
      this.display.syncExec(new Runnable() {
        @Override
        public void run() {
          boolean _apply = function.apply(exception);
          boolean _not = (!_apply);
          TransformationThread.this.stopTransformations = _not;
        }
      });
    } else {
      boolean _apply = function.apply(exception);
      boolean _not = (!_apply);
      this.stopTransformations = _not;
    }
  }

  /**
   * Helper to invoke a callback function. In case a Display instance is available, i.e., we're in
   * a GUI thread, the function invocation will happen in sync with GUI thread.
   */
  private void invokeCallbackIfSpecified(final Predicate<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>> function, final List<AbstractIntermediateModelTransformationStrategy.TransformationResult> transformationResults) {
    if ((function == null)) {
      return;
    }
    if ((this.display != null)) {
      this.display.syncExec(new Runnable() {
        @Override
        public void run() {
          boolean _apply = function.apply(transformationResults);
          boolean _not = (!_apply);
          TransformationThread.this.stopTransformations = _not;
        }
      });
    } else {
      boolean _apply = function.apply(transformationResults);
      boolean _not = (!_apply);
      this.stopTransformations = _not;
    }
  }
}
