package de.fhdo.lemma.eclipse.ui;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import de.fhdo.lemma.eclipse.ui.transformation_dialog.TransformationThread;
import de.fhdo.lemma.intermediate.transformations.AbstractIntermediateModelTransformationStrategy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Helper to programmatically execute intermediate model transformations on a model file and its
 * children.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ProgrammaticIntermediateModelTransformation {
  /**
   * Class to bundle a transformation exception with transformation intent and data
   */
  public static class ProgrammaticIntermediateModelTransformationException extends Exception {
    @Accessors(AccessorType.PUBLIC_GETTER)
    private String intent;
    
    @Accessors(AccessorType.PUBLIC_GETTER)
    private Object data;
    
    public ProgrammaticIntermediateModelTransformationException(final Exception cause, final String intent, final Object data) {
      super(cause.getMessage(), cause);
      this.intent = intent;
      this.data = data;
    }
    
    @Pure
    public String getIntent() {
      return this.intent;
    }
    
    @Pure
    public Object getData() {
      return this.data;
    }
  }
  
  /**
   * Class to bundle a transformation result with transformation intent and data
   */
  public static class ProgrammaticIntermediateModelTransformationResult extends Exception {
    @Accessors(AccessorType.PUBLIC_GETTER)
    private AbstractIntermediateModelTransformationStrategy.TransformationResult result;
    
    @Accessors(AccessorType.PUBLIC_GETTER)
    private String intent;
    
    @Accessors(AccessorType.PUBLIC_GETTER)
    private Object data;
    
    public ProgrammaticIntermediateModelTransformationResult(final AbstractIntermediateModelTransformationStrategy.TransformationResult result, final String intent, final Object data) {
      this.result = result;
      this.intent = intent;
      this.data = data;
    }
    
    @Pure
    public AbstractIntermediateModelTransformationStrategy.TransformationResult getResult() {
      return this.result;
    }
    
    @Pure
    public String getIntent() {
      return this.intent;
    }
    
    @Pure
    public Object getData() {
      return this.data;
    }
  }
  
  private static final List<Function0<? extends AbstractUiModelTransformationStrategy>> AVAILABLE_TRANSFORMATION_STRATEGY_CONSTRUCTORS = Collections.<Function0<? extends AbstractUiModelTransformationStrategy>>unmodifiableList(CollectionLiterals.<Function0<? extends AbstractUiModelTransformationStrategy>>newArrayList(((Function0<AbstractUiModelTransformationStrategy>) () -> {
    return new DataModelTransformationStrategy();
  }), ((Function0<AbstractUiModelTransformationStrategy>) () -> {
    return new ServiceModelTransformationStrategy();
  }), ((Function0<AbstractUiModelTransformationStrategy>) () -> {
    return new OperationModelTransformationStrategy();
  })));
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final AbstractUiModelTransformationStrategy strategy;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final ModelFile rootModelFile;
  
  private final Set<ModelFile> resolvedChildren;
  
  private String intent;
  
  private Object data;
  
  private List<Predicate<ModelFile>> nextTransformationCallbacks;
  
  private List<Predicate<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationException>> transformationExceptionCallbacks;
  
  private List<Predicate<List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult>>> transformationSuccessfulCallbacks;
  
  private List<Function2<? super List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult>, ? super List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationException>, ? extends Boolean>> transformationsFinishedCallbacks;
  
  private boolean exceptionInCurrentTransformation;
  
  private List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationException> transformationExceptions;
  
  /**
   * Constructor
   */
  public ProgrammaticIntermediateModelTransformation(final IFile rootFile) {
    if ((rootFile == null)) {
      throw new IllegalArgumentException("Root file must not be null");
    }
    this.strategy = ProgrammaticIntermediateModelTransformation.getTransformationStrategy(rootFile.getFileExtension());
    if ((this.strategy == null)) {
      StringConcatenation _builder = new StringConcatenation();
      String _string = rootFile.getRawLocation().makeAbsolute().toString();
      _builder.append(_string);
      _builder.append(" of type *.");
      String _plus = ("No transformation strategy found for file " + _builder);
      String _fileExtension = rootFile.getFileExtension();
      String _plus_1 = (_plus + _fileExtension);
      throw new IllegalArgumentException(_plus_1);
    }
    this.rootModelFile = ProgrammaticIntermediateModelTransformation.toModelFile(rootFile, this.strategy);
    boolean _supportsTransformation = ProgrammaticIntermediateModelTransformation.supportsTransformation(this.rootModelFile);
    boolean _not = (!_supportsTransformation);
    if (_not) {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Intermediate model transformation is not ");
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("supported for files of type *.");
      String _fileExtension_1 = rootFile.getFileExtension();
      _builder_2.append(_fileExtension_1);
      _builder_2.append(" ");
      String _plus_2 = (_builder_1.toString() + _builder_2);
      throw new IllegalArgumentException(_plus_2);
    }
    this.resolvedChildren = this.resolveTransitiveChildren(this.rootModelFile);
  }
  
  /**
   * Retrieve a transformation strategy from a given model file extension
   */
  public static AbstractUiModelTransformationStrategy getTransformationStrategy(final String fileExtension) {
    for (final Function0<? extends AbstractUiModelTransformationStrategy> strategyConstructor : ProgrammaticIntermediateModelTransformation.AVAILABLE_TRANSFORMATION_STRATEGY_CONSTRUCTORS) {
      {
        final AbstractUiModelTransformationStrategy strategy = strategyConstructor.apply();
        boolean _contains = strategy.getModelFileTypeExtensions().contains(fileExtension);
        if (_contains) {
          return strategy;
        }
      }
    }
    return null;
  }
  
  /**
   * Convert an IFile instance to a ModelFile instance if the given strategy permits it
   */
  private static ModelFile toModelFile(final IFile file, final AbstractUiModelTransformationStrategy strategy) {
    final ModelFileTypeDescription modelFileTypeDescription = strategy.getModelFileTypeDescription(file.getFileExtension());
    if ((modelFileTypeDescription == null)) {
      return null;
    }
    final ModelFile modelFile = new ModelFile(file, modelFileTypeDescription);
    modelFile.setTransformationTargetPath(ProgrammaticIntermediateModelTransformation.buildTransformationTargetPath(file, strategy));
    return modelFile;
  }
  
  /**
   * Build the strategy-specific transformation target path of the given IFile. The target path
   * consists of the IFile's project path and the strategy-specific default transformation target
   * path.
   */
  private static String buildTransformationTargetPath(final IFile file, final AbstractUiModelTransformationStrategy transformationStrategy) {
    final String projectRelativePath = transformationStrategy.getDefaultTransformationTargetPath(file);
    IPath _fullPath = file.getProject().getFullPath();
    return (_fullPath + projectRelativePath);
  }
  
  /**
   * Check if a model clustered in an IFile instance supports transformation
   */
  public static boolean supportsTranformation(final IFile file) {
    String _fileExtension = null;
    if (file!=null) {
      _fileExtension=file.getFileExtension();
    }
    AbstractUiModelTransformationStrategy _transformationStrategy = null;
    if (_fileExtension!=null) {
      _transformationStrategy=ProgrammaticIntermediateModelTransformation.getTransformationStrategy(_fileExtension);
    }
    final AbstractUiModelTransformationStrategy strategy = _transformationStrategy;
    return ((strategy != null) && ProgrammaticIntermediateModelTransformation.supportsTransformation(ProgrammaticIntermediateModelTransformation.toModelFile(file, strategy)));
  }
  
  /**
   * Helper to check if model represented by a ModelFile instance supports transformation
   */
  private static boolean supportsTransformation(final ModelFile modelFile) {
    return ((modelFile != null) && modelFile.getFileTypeDescription().canBeTransformed());
  }
  
  /**
   * Resolve all transitive children of a ModelFile. The returned list will contain all transitive
   * children as ModelFile instances. The method takes care of their proper initialization which
   * also entails the resolution of childs' children.
   */
  private HashSet<ModelFile> resolveTransitiveChildren(final ModelFile modelFile) {
    modelFile.setChildren(this.getImportedTransformableModelFiles(modelFile));
    final ArrayDeque<ModelFile> todoModelFiles = new ArrayDeque<ModelFile>();
    todoModelFiles.addAll(modelFile.getChildren());
    final HashSet<ModelFile> resolvedChildren = CollectionLiterals.<ModelFile>newHashSet();
    while ((!todoModelFiles.isEmpty())) {
      {
        final ModelFile currentModelFile = todoModelFiles.pop();
        currentModelFile.setChildren(this.getImportedTransformableModelFiles(currentModelFile));
        boolean _add = resolvedChildren.add(currentModelFile);
        if (_add) {
          final Function1<ModelFile, Boolean> _function = (ModelFile it) -> {
            boolean _contains = resolvedChildren.contains(it);
            return Boolean.valueOf((!_contains));
          };
          final Iterable<ModelFile> nextModelFiles = IterableExtensions.<ModelFile>filter(currentModelFile.getChildren(), _function);
          Iterables.<ModelFile>addAll(todoModelFiles, nextModelFiles);
        }
      }
    }
    return resolvedChildren;
  }
  
  /**
   * Get the transformable model files imported by a given model file
   */
  private List<ModelFile> getImportedTransformableModelFiles(final ModelFile parentModelFile) {
    boolean _supportsTransformation = ProgrammaticIntermediateModelTransformation.supportsTransformation(parentModelFile);
    boolean _not = (!_supportsTransformation);
    if (_not) {
      return CollectionLiterals.<ModelFile>emptyList();
    }
    final ArrayList<ModelFile> importedModelFiles = CollectionLiterals.<ModelFile>newArrayList();
    final Function1<IFile, ModelFile> _function = (IFile it) -> {
      return ProgrammaticIntermediateModelTransformation.toModelFile(it, this.strategy);
    };
    final Map<String, ModelFile> importedFileByAlias = MapExtensions.<String, IFile, ModelFile>mapValues(this.strategy.getImportedModelFiles(parentModelFile), _function);
    Set<Map.Entry<String, ModelFile>> _entrySet = importedFileByAlias.entrySet();
    for (final Map.Entry<String, ModelFile> aliasAndFile : _entrySet) {
      {
        final ModelFile importedModelFile = aliasAndFile.getValue();
        boolean _supportsTransformation_1 = ProgrammaticIntermediateModelTransformation.supportsTransformation(importedModelFile);
        if (_supportsTransformation_1) {
          importedModelFile.setImportAlias(aliasAndFile.getKey());
          importedModelFiles.add(importedModelFile);
        }
      }
    }
    return importedModelFiles;
  }
  
  /**
   * Run transformations on the root model file and its children.
   * 
   * @param intent Supports the identification of the transformation intent by callbacks. Must not
   *               be null or empty.
   * @param data Arbitrary data that together with the intent is passed to callbacks. May be null.
   * @param display Reference to a Display instance in a GUI thread. May be null if the
   *                transformation takes place outside the GUI thread.
   * @param runBlocking Forces the thread that invoked the transformation to wait until all
   *                    transformations were finished.
   * @param nextTransformationCallback Callback that the next transformation is about to begin.
   *                                   May be null.
   * @param transformationExceptionCallback Callback that a transformation occurred. In this case,
   *                                        there will be no transformationSuccessfulCallback. May
   *                                        be null.
   * @param transformationSuccessfulCallback Callback that the transformation was successful. In
   *                                         this case, there will be no
   *                                         transformationExceptionCallback. May be null.
   * @param transformationSuccessfulCallback Callback that all transformations were finished.
   *                                         May be null.
   */
  public void run(final String intent, final Object data, final Display display, final boolean runBlocking, final Predicate<ModelFile> nextTransformationCallback, final Predicate<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationException> transformationExceptionCallback, final Predicate<List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult>> transformationSuccessfulCallback, final Function2<? super List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult>, ? super List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationException>, ? extends Boolean> transformationsFinishedCallback) {
    this.run(intent, data, display, runBlocking, 
      Collections.<Predicate<ModelFile>>unmodifiableList(CollectionLiterals.<Predicate<ModelFile>>newArrayList(nextTransformationCallback)), 
      Collections.<Predicate<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationException>>unmodifiableList(CollectionLiterals.<Predicate<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationException>>newArrayList(transformationExceptionCallback)), 
      Collections.<Predicate<List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult>>>unmodifiableList(CollectionLiterals.<Predicate<List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult>>>newArrayList(transformationSuccessfulCallback)), 
      Collections.<Function2<? super List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult>, ? super List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationException>, ? extends Boolean>>unmodifiableList(CollectionLiterals.<Function2<? super List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult>, ? super List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationException>, ? extends Boolean>>newArrayList(transformationsFinishedCallback)));
  }
  
  /**
   * Bulk version of run() that can take more than one callback per transformation event
   */
  public void run(final String intent, final Object data, final Display display, final boolean runBlocking, final List<Predicate<ModelFile>> nextTransformationCallbacks, final List<Predicate<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationException>> transformationExceptionCallbacks, final List<Predicate<List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult>>> transformationSuccessfulCallbacks, final List<Function2<? super List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult>, ? super List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationException>, ? extends Boolean>> transformationsFinishedCallbacks) {
    try {
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(intent);
      if (_isNullOrEmpty) {
        throw new IllegalArgumentException("Transformation intent must not be null or empty");
      }
      this.intent = intent;
      this.data = data;
      this.nextTransformationCallbacks = nextTransformationCallbacks;
      this.transformationExceptionCallbacks = transformationExceptionCallbacks;
      this.transformationSuccessfulCallbacks = transformationSuccessfulCallbacks;
      this.transformationsFinishedCallbacks = transformationsFinishedCallbacks;
      this.transformationExceptions = CollectionLiterals.<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationException>newArrayList();
      LinkedList<ModelFile> _modelFilesToTransform = this.getModelFilesToTransform();
      final Predicate<ModelFile> _function = (ModelFile it) -> {
        return this.nextTransformationCallback(it);
      };
      final Predicate<Exception> _function_1 = (Exception it) -> {
        return this.transformationExceptionCallback(it);
      };
      final Predicate<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>> _function_2 = (List<AbstractIntermediateModelTransformationStrategy.TransformationResult> it) -> {
        return this.transformationSuccessfulCallback(it);
      };
      final Predicate<List<AbstractIntermediateModelTransformationStrategy.TransformationResult>> _function_3 = (List<AbstractIntermediateModelTransformationStrategy.TransformationResult> it) -> {
        return this.transformationsFinishedCallback(it);
      };
      final TransformationThread transformationThread = new TransformationThread(_modelFilesToTransform, 
        true, 
        false, display, _function, 
        null, _function_1, _function_2, _function_3);
      transformationThread.start();
      if (runBlocking) {
        transformationThread.join();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Get all model files to transform. The resulting list contains the root model file and its
   * transitive children ordered by their strategy-specific transformation order.
   */
  private LinkedList<ModelFile> getModelFilesToTransform() {
    final ArrayList<ModelFile> modelFilesToTransform = CollectionLiterals.<ModelFile>newArrayList(this.rootModelFile);
    modelFilesToTransform.addAll(this.resolvedChildren);
    return this.strategy.sortByTransformationOrder(modelFilesToTransform);
  }
  
  /**
   * Invoke callbacks that the next transformation is about to begin
   */
  private boolean nextTransformationCallback(final ModelFile modelFile) {
    this.exceptionInCurrentTransformation = false;
    return this.<ModelFile>runTransformationCallbacks(this.nextTransformationCallbacks, modelFile);
  }
  
  /**
   * Helper to run a list of transformation callbacks. The return value indicates whether a
   * transformation signaled to continue transformations or stop them.
   */
  private <T extends Object> boolean runTransformationCallbacks(final List<Predicate<T>> callbacks, final T argument) {
    if ((callbacks == null)) {
      return true;
    }
    for (final Predicate<T> callback : callbacks) {
      {
        final boolean continueTransformations = callback.apply(argument);
        if ((!continueTransformations)) {
          return false;
        }
      }
    }
    return true;
  }
  
  /**
   * Invoke callbacks that a transformation exception occurred
   */
  private boolean transformationExceptionCallback(final Exception exception) {
    this.exceptionInCurrentTransformation = true;
    final ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationException transformationException = new ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationException(exception, 
      this.intent, 
      this.data);
    this.transformationExceptions.add(transformationException);
    return this.<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationException>runTransformationCallbacks(this.transformationExceptionCallbacks, transformationException);
  }
  
  /**
   * Invoke callbacks that the current transformation was finished successfully. In case there
   * occurred an exception before, the callbacks will not be invoked.
   */
  private boolean transformationSuccessfulCallback(final List<AbstractIntermediateModelTransformationStrategy.TransformationResult> results) {
    if (this.exceptionInCurrentTransformation) {
      return true;
    }
    final List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult> transformationResults = this.toProgrammaticTransformationResults(results);
    return this.<List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult>>runTransformationCallbacks(this.transformationSuccessfulCallbacks, transformationResults);
  }
  
  /**
   * Convert a list of transformation results to ProgrammaticIntermediateModelTransformationResult
   * instances
   */
  private List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult> toProgrammaticTransformationResults(final List<AbstractIntermediateModelTransformationStrategy.TransformationResult> results) {
    final Function1<AbstractIntermediateModelTransformationStrategy.TransformationResult, ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult> _function = (AbstractIntermediateModelTransformationStrategy.TransformationResult it) -> {
      return new ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult(it, this.intent, this.data);
    };
    return IterableExtensions.<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult>toList(ListExtensions.<AbstractIntermediateModelTransformationStrategy.TransformationResult, ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult>map(results, _function));
  }
  
  /**
   * Invoke callbacks that the current transformation finished
   */
  private boolean transformationsFinishedCallback(final List<AbstractIntermediateModelTransformationStrategy.TransformationResult> results) {
    final List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult> transformationResults = this.toProgrammaticTransformationResults(results);
    return this.<List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationResult>, List<ProgrammaticIntermediateModelTransformation.ProgrammaticIntermediateModelTransformationException>>runTransformationCallbacks(this.transformationsFinishedCallbacks, transformationResults, 
      this.transformationExceptions);
  }
  
  /**
   * Helper to run a list of transformation callbacks of which each takes two arguments. The
   * return value indicates whether a transformation signaled to continue transformations or stop
   * them.
   */
  private <T1 extends Object, T2 extends Object> boolean runTransformationCallbacks(final List<Function2<? super T1, ? super T2, ? extends Boolean>> callbacks, final T1 argument1, final T2 argument2) {
    if ((callbacks == null)) {
      return true;
    }
    for (final Function2<? super T1, ? super T2, ? extends Boolean> callback : callbacks) {
      {
        final Boolean continueTransformations = callback.apply(argument1, argument2);
        if ((!(continueTransformations).booleanValue())) {
          return false;
        }
      }
    }
    return true;
  }
  
  @Pure
  public AbstractUiModelTransformationStrategy getStrategy() {
    return this.strategy;
  }
  
  @Pure
  public ModelFile getRootModelFile() {
    return this.rootModelFile;
  }
}
