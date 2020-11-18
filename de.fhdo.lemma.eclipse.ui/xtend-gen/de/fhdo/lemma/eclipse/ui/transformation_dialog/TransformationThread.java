package de.fhdo.lemma.eclipse.ui.transformation_dialog;

import com.google.common.base.Predicate;
import de.fhdo.lemma.eclipse.ui.ModelFile;
import de.fhdo.lemma.eclipse.ui.ModelFileTypeDescription;
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils;
import de.fhdo.lemma.intermediate.transformations.AbstractIntermediateModelTransformationStrategy;
import de.fhdo.lemma.intermediate.transformations.IntermediateTransformationException;
import de.fhdo.lemma.intermediate.transformations.IntermediateTransformationExceptionKind;
import de.fhdo.lemma.utils.LemmaUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
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
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;

/**
 * Thread to perform actual intermediate model transformations.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class TransformationThread extends Thread {
  private List<ModelFile> modelFiles;
  
  private boolean convertToRelativeUris;
  
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
  public TransformationThread(final LinkedList<ModelFile> modelFiles, final boolean convertToRelativeUris, final boolean outputRefinementModels, final Display display, final Predicate<ModelFile> nextTransformationCallback, final Predicate<IntermediateTransformationException> transformationWarningCallback, final Predicate<Exception> transformationExceptionCallback, final Predicate<Void> currentTransformationFinishedCallback, final Predicate<Void> transformationsFinishedCallback) {
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
    final LinkedHashSet<BiFunction<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, Void>> transformationsFinishedListeners = CollectionLiterals.<BiFunction<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, Void>>newLinkedHashSet();
    final ArrayList<AbstractIntermediateModelTransformationStrategy.TransformationResult> transformationResults = CollectionLiterals.<AbstractIntermediateModelTransformationStrategy.TransformationResult>newArrayList();
    for (int i = 0; ((i < this.modelFiles.size()) && (!this.stopTransformations)); i++) {
      {
        final ModelFile modelFile = this.modelFiles.get(i);
        this.invokeGuiCallbackIfSpecified(this.nextTransformationCallback, modelFile);
        final Pair<List<BiFunction<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, Void>>, List<AbstractIntermediateModelTransformationStrategy.TransformationResult>> transformationListenersAndResults = this.executeTransformations(modelFile);
        transformationsFinishedListeners.addAll(transformationListenersAndResults.getKey());
        transformationResults.addAll(transformationListenersAndResults.getValue());
        this.invokeGuiCallbackIfSpecified(this.currentTransformationFinishedCallback);
      }
    }
    this.executeTransformationsFinishedListeners(transformationsFinishedListeners, transformationResults);
    this.invokeGuiCallbackIfSpecified(this.transformationsFinishedCallback);
  }
  
  /**
   * Execute main and refining transformations on a model file
   */
  private Pair<List<BiFunction<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, Void>>, List<AbstractIntermediateModelTransformationStrategy.TransformationResult>> executeTransformations(final ModelFile modelFile) {
    final ArrayList<BiFunction<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, Void>> transformationsFinishedListeners = CollectionLiterals.<BiFunction<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, Void>>newArrayList();
    final ArrayList<AbstractIntermediateModelTransformationStrategy.TransformationResult> results = CollectionLiterals.<AbstractIntermediateModelTransformationStrategy.TransformationResult>newArrayList();
    boolean exceptionOccurred = false;
    try {
      final List<String> outputPaths = this.buildTransformationOutputPaths(modelFile.getTransformationTargetPath(), 
        modelFile.getFileTypeDescription(), this.outputRefinementModels);
      final AbstractIntermediateModelTransformationStrategy.TransformationResult mainTransformationResult = this.mainTransformation(modelFile, 
        outputPaths.get(0), transformationsFinishedListeners);
      if ((mainTransformationResult != null)) {
        results.add(mainTransformationResult);
      } else {
        List<BiFunction<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, Void>> _emptyList = CollectionLiterals.<BiFunction<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, Void>>emptyList();
        List<AbstractIntermediateModelTransformationStrategy.TransformationResult> _emptyList_1 = CollectionLiterals.<AbstractIntermediateModelTransformationStrategy.TransformationResult>emptyList();
        return Pair.<List<BiFunction<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, Void>>, List<AbstractIntermediateModelTransformationStrategy.TransformationResult>>of(_emptyList, _emptyList_1);
      }
      final List<AbstractIntermediateModelTransformationStrategy.TransformationResult> refiningTransformationResults = this.refiningTransformations(modelFile, outputPaths, transformationsFinishedListeners);
      if ((refiningTransformationResults != null)) {
        results.addAll(refiningTransformationResults);
      } else {
        List<BiFunction<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, Void>> _emptyList_2 = CollectionLiterals.<BiFunction<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, Void>>emptyList();
        List<AbstractIntermediateModelTransformationStrategy.TransformationResult> _emptyList_3 = CollectionLiterals.<AbstractIntermediateModelTransformationStrategy.TransformationResult>emptyList();
        return Pair.<List<BiFunction<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, Void>>, List<AbstractIntermediateModelTransformationStrategy.TransformationResult>>of(_emptyList_2, _emptyList_3);
      }
    } catch (final Throwable _t) {
      if (_t instanceof IntermediateTransformationException) {
        final IntermediateTransformationException ex = (IntermediateTransformationException)_t;
        IntermediateTransformationExceptionKind _kind = ex.getKind();
        boolean _tripleEquals = (_kind == IntermediateTransformationExceptionKind.WARNING);
        if (_tripleEquals) {
          this.internalTransformationWarningCallback(ex);
        } else {
          this.invokeGuiCallbackIfSpecified(this.transformationExceptionCallback, ex);
        }
        exceptionOccurred = true;
      } else if (_t instanceof Exception) {
        final Exception ex_1 = (Exception)_t;
        ex_1.printStackTrace();
        this.invokeGuiCallbackIfSpecified(this.transformationExceptionCallback, ex_1);
        exceptionOccurred = true;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    Pair<List<BiFunction<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, Void>>, List<AbstractIntermediateModelTransformationStrategy.TransformationResult>> _xifexpression = null;
    if ((!exceptionOccurred)) {
      _xifexpression = Pair.<List<BiFunction<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, Void>>, List<AbstractIntermediateModelTransformationStrategy.TransformationResult>>of(transformationsFinishedListeners, results);
    } else {
      List<BiFunction<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, Void>> _emptyList = CollectionLiterals.<BiFunction<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, Void>>emptyList();
      List<AbstractIntermediateModelTransformationStrategy.TransformationResult> _emptyList_1 = CollectionLiterals.<AbstractIntermediateModelTransformationStrategy.TransformationResult>emptyList();
      _xifexpression = Pair.<List<BiFunction<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, Void>>, List<AbstractIntermediateModelTransformationStrategy.TransformationResult>>of(_emptyList, _emptyList_1);
    }
    return _xifexpression;
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
   * Perform main transformation on a model file
   */
  private AbstractIntermediateModelTransformationStrategy.TransformationResult mainTransformation(final ModelFile modelFile, final String outputPath, final List<BiFunction<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, Void>> transformationsFinishedListeners) {
    final AbstractIntermediateModelTransformationStrategy strategy = modelFile.getFileTypeDescription().createMainTransformationStrategy();
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
    return this.executeTransformation(modelFile.getFile(), strategy, outputPath, 
      Collections.<String, Map<String, String>>unmodifiableMap(CollectionLiterals.<String, Map<String, String>>newHashMap(_mappedTo)), transformationsFinishedListeners);
  }
  
  /**
   * Perform refining transformations on a model file
   */
  private List<AbstractIntermediateModelTransformationStrategy.TransformationResult> refiningTransformations(final ModelFile modelFile, final List<String> outputPaths, final List<BiFunction<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, Void>> transformationsFinishedListeners) {
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
        final AbstractIntermediateModelTransformationStrategy strategy = fileTypeDescription.createRefiningTransformationStrategy((strategyIndex).intValue());
        final IFile inputFile = ResourcesPlugin.getWorkspace().getRoot().getFile(inputFilePath);
        final AbstractIntermediateModelTransformationStrategy.TransformationResult transformationResult = this.executeTransformation(inputFile, strategy, outputFilePath, 
          null, transformationsFinishedListeners);
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
   * Execute a single transformation strategy on an input file
   */
  private AbstractIntermediateModelTransformationStrategy.TransformationResult executeTransformation(final IFile inputFile, final AbstractIntermediateModelTransformationStrategy strategy, final String outputPath, final Map<String, Map<String, String>> targetPathsOfImports, final List<BiFunction<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, Void>> transformationsFinishedListeners) {
    final Predicate<IntermediateTransformationException> _function = (IntermediateTransformationException it) -> {
      return this.internalTransformationWarningCallback(it);
    };
    Map _doTransformationFromFiles = strategy.doTransformationFromFiles(
      Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(inputFile)), 
      Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList(outputPath)), targetPathsOfImports, 
      this.convertToRelativeUris, _function);
    Collection _values = null;
    if (_doTransformationFromFiles!=null) {
      _values=_doTransformationFromFiles.values();
    }
    Object _get = null;
    if (((Object[])Conversions.unwrapArray(_values, Object.class))!=null) {
      _get=((Object[])Conversions.unwrapArray(_values, Object.class))[0];
    }
    final AbstractIntermediateModelTransformationStrategy.TransformationResult transformationResult = ((AbstractIntermediateModelTransformationStrategy.TransformationResult) _get);
    final BiFunction finishedListener = strategy.registerTransformationsFinishedListener();
    if (((finishedListener != null) && (transformationResult != null))) {
      transformationsFinishedListeners.add(finishedListener);
    }
    return transformationResult;
  }
  
  /**
   * Execute transformation finished listeners
   */
  private Boolean executeTransformationsFinishedListeners(final LinkedHashSet<BiFunction<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, Void>> listeners, final List<AbstractIntermediateModelTransformationStrategy.TransformationResult> results) {
    boolean _xblockexpression = false;
    {
      final Consumer<AbstractIntermediateModelTransformationStrategy.TransformationResult> _function = (AbstractIntermediateModelTransformationStrategy.TransformationResult it) -> {
        final Consumer<AbstractIntermediateModelTransformationStrategy.InputModel> _function_1 = (AbstractIntermediateModelTransformationStrategy.InputModel it_1) -> {
          it_1.setInputPath(LemmaUtils.convertToFileUri(it_1.getInputPath()));
        };
        it.getInputModels().forEach(_function_1);
        AbstractIntermediateModelTransformationStrategy.OutputModel _outputModel = it.getOutputModel();
        _outputModel.setOutputPath(LemmaUtils.convertProjectPathToAbsoluteFileUri(it.getOutputModel().getOutputPath()));
      };
      results.forEach(_function);
      boolean _xtrycatchfinallyexpression = false;
      try {
        final Consumer<BiFunction<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, Void>> _function_1 = (BiFunction<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>, Predicate<IntermediateTransformationException>, Void> it) -> {
          final Predicate<IntermediateTransformationException> _function_2 = (IntermediateTransformationException it_1) -> {
            return this.internalTransformationWarningCallback(it_1);
          };
          it.apply(results, _function_2);
        };
        listeners.forEach(_function_1);
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
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return Boolean.valueOf(_xblockexpression);
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
