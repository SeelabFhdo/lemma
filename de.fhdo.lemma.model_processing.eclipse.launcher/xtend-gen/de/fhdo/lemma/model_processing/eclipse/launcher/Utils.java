package de.fhdo.lemma.model_processing.eclipse.launcher;

import com.google.common.base.Objects;
import de.fhdo.lemma.data.ComplexTypeImport;
import de.fhdo.lemma.data.DataModel;
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration;
import de.fhdo.lemma.operation.OperationModel;
import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.ImportType;
import de.fhdo.lemma.service.ServiceModel;
import de.fhdo.lemma.technology.Technology;
import de.fhdo.lemma.technology.TechnologyImport;
import de.fhdo.lemma.technology.mapping.TechnologyMapping;
import de.fhdo.lemma.utils.LemmaUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.typed.BeanProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.typed.WidgetProperties;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Utility methods for the model processing launch configuration.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class Utils {
  /**
   * Canonical form of a LEMMA model import that subsumes all relevant information which are
   * common for different kinds of LEMMA imports (e.g., ComplexTypeImport for DataModel instances
   * and Import ServiceModel instances)
   */
  public static class ImportInfo {
    @Accessors(AccessorType.PUBLIC_GETTER)
    private final String alias;

    @Accessors(AccessorType.PUBLIC_GETTER)
    private final String importUri;

    public ImportInfo(final String alias, final String importUri) {
      this.alias = alias;
      this.importUri = importUri;
    }

    @Pure
    public String getAlias() {
      return this.alias;
    }

    @Pure
    public String getImportUri() {
      return this.importUri;
    }
  }

  private static final List<? extends Class<? extends EObject>> TRANSFORMABLE_MODEL_KINDS = Collections.<Class<? extends EObject>>unmodifiableList(CollectionLiterals.<Class<? extends EObject>>newArrayList(DataModel.class, ServiceModel.class, OperationModel.class));

  /**
   * Find a file with a certain name in a certain project of the current workspace
   */
  public static IFile findFileInWorkspaceProject(final String projectName, final String filename) {
    IFile _xtrycatchfinallyexpression = null;
    try {
      IProject _findProjectInCurrentWorkspace = Utils.findProjectInCurrentWorkspace(projectName);
      IResource _findMember = null;
      if (_findProjectInCurrentWorkspace!=null) {
        _findMember=_findProjectInCurrentWorkspace.findMember(filename);
      }
      _xtrycatchfinallyexpression = ((IFile) _findMember);
    } catch (final Throwable _t) {
      if (_t instanceof ClassCastException) {
        _xtrycatchfinallyexpression = null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }

  /**
   * Find a certain project of the current workspace
   */
  public static IProject findProjectInCurrentWorkspace(final String projectName) {
    final Function1<IProject, Boolean> _function = (IProject it) -> {
      String _name = it.getName();
      return Boolean.valueOf(Objects.equal(_name, projectName));
    };
    return IterableExtensions.<IProject>findFirst(((Iterable<IProject>)Conversions.doWrapArray(ResourcesPlugin.getWorkspace().getRoot().getProjects())), _function);
  }

  /**
   * Throw an IllegalArgumentException with a given message in case a given String is null or
   * empty
   */
  public static void notNullOrEmpty(final String s, final String errorMessage) {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(s);
    if (_isNullOrEmpty) {
      throw new IllegalArgumentException(errorMessage);
    }
  }

  /**
   * Throw an IllegalArgumentException with a given message in case a given String is empty
   */
  public static void notEmpty(final String s, final String errorMessage) {
    boolean _isEmpty = s.isEmpty();
    if (_isEmpty) {
      throw new IllegalArgumentException(errorMessage);
    }
  }

  /**
   * Throw an IllegalArgumentException with a given message in case a given object is null
   */
  public static void notNull(final Object o, final String errorMessage) {
    if ((o == null)) {
      throw new IllegalArgumentException(errorMessage);
    }
  }

  /**
   * Find an XML element's first child that has a given tag
   */
  public static Element findChildElementWithTag(final Element parent, final String tag) {
    final NodeList children = parent.getChildNodes();
    int _length = children.getLength();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _length, true);
    for (final Integer n : _doubleDotLessThan) {
      {
        final Node child = children.item((n).intValue());
        if (((child instanceof Element) && Objects.equal(((Element) child).getTagName(), tag))) {
          return ((Element) child);
        }
      }
    }
    return null;
  }

  /**
   * Check if all elements of two lists are equal (==-semantics)
   */
  public static <T extends Object> boolean equalLists(final List<T> l1, final List<? extends T> l2) {
    int _size = l1.size();
    int _size_1 = l2.size();
    boolean _tripleNotEquals = (_size != _size_1);
    if (_tripleNotEquals) {
      return false;
    }
    int _size_2 = l1.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size_2, true);
    for (final Integer i : _doubleDotLessThan) {
      T _get = l1.get((i).intValue());
      T _get_1 = l2.get((i).intValue());
      boolean _notEquals = (!Objects.equal(_get, _get_1));
      if (_notEquals) {
        return false;
      }
    }
    return true;
  }

  /**
   * Perform a "flat" copy of a given list. A "flat" copy is a new ArrayList instance that
   * comprises the same elements of the given list.
   */
  public static <T extends Object> ArrayList<T> flatCopy(final List<T> list) {
    final ArrayList<T> copy = CollectionLiterals.<T>newArrayList();
    copy.addAll(list);
    return copy;
  }

  /**
   * Add an element to the given list and return the list
   */
  public static <T extends Object> List<T> addInPlace(final List<T> list, final T element) {
    list.add(element);
    return list;
  }

  /**
   * Move an element one index up in a given list and return the list. Note that the "move up"-
   * behavior is "rotating", i.e., an item at index 0 will be put to the end of the list.
   */
  public static <T extends Object> List<T> moveUpInPlace(final List<T> list, final T element) {
    final int index = list.indexOf(element);
    boolean _matched = false;
    if (Objects.equal(index, 0)) {
      _matched=true;
      list.remove(0);
      list.add(element);
    }
    if (!_matched) {
      if ((index > 0)) {
        _matched=true;
        list.add((index - 1), element);
        list.remove((index + 1));
      }
    }
    return list;
  }

  /**
   * Move an element one index down in a given list and return the list. Note that the "move
   * down"-behavior is "rotating", i.e., an item at the end of the list will be put to index 0.
   */
  public static <T extends Object> List<T> moveDownInPlace(final List<T> list, final T element) {
    final int index = list.indexOf(element);
    int _size = list.size();
    final int lastIndex = (_size - 1);
    boolean _matched = false;
    if (((index > (-1)) && (index == lastIndex))) {
      _matched=true;
      list.remove(lastIndex);
      list.add(0, element);
    }
    if (!_matched) {
      if ((index > (-1))) {
        _matched=true;
        list.remove(index);
        list.add((index + 1), element);
      }
    }
    return list;
  }

  /**
   * Add an element from the given list and return the list
   */
  public static <T extends Object> List<T> removeInPlace(final List<T> list, final T element) {
    list.remove(element);
    return list;
  }

  /**
   * Remove all given elements from a list and return the list
   */
  public static <T extends Object> List<T> removeAllInPlace(final List<T> list, final List<T> elements) {
    list.removeAll(elements);
    return list;
  }

  /**
   * Bind a UI control to a property of a Bean class and attach a validation listener to the
   * control. A validation listener will call the given validation procedure each time the control
   * is changed and on the new value of the control. In case the value is invalid, the validation
   * procedure is expected to throw an IllegalArgumentException whose message the validation
   * listener will display as a decoration for the given control.
   */
  public static <T extends Object> Pair<Binding, ControlDecoration> bindWithValidationDecorationSupport(final Control control, final DataBindingContext dataBindingContext, final Class<T> beanClass, final String propertyName, final T source, final Procedure1<? super String> validationProcedure) {
    final ISWTObservableValue<String> target = Utils.toObservableValue(control);
    final IObservableValue<Object> model = BeanProperties.<T, Object>value(beanClass, propertyName).observe(source);
    final Object updateStrategy = null;
    final ControlDecoration decoration = new ControlDecoration(control, (SWT.TOP | SWT.LEFT));
    Utils.addValidationListener(control, decoration, validationProcedure);
    final Binding bindValue = dataBindingContext.<String, Object>bindValue(target, model, ((UpdateValueStrategy<? super String, ?>)updateStrategy), null);
    return Pair.<Binding, ControlDecoration>of(bindValue, decoration);
  }

  /**
   * Wrap a generic SWT Control into an ISWTObservableValue
   */
  private static ISWTObservableValue<String> _toObservableValue(final Control control) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Creation of ");
    String _simpleName = ISWTObservableValue.class.getSimpleName();
    _builder.append(_simpleName);
    _builder.append(" ");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("instance not supported for controls of type ");
    String _simpleName_1 = control.getClass().getSimpleName();
    _builder_1.append(_simpleName_1);
    String _plus = (_builder.toString() + _builder_1);
    throw new IllegalArgumentException(_plus);
  }

  /**
   * Wrap an SWT Text into an ISWTObservableValue
   */
  private static ISWTObservableValue<String> _toObservableValue(final Text text) {
    return WidgetProperties.<Text>text(SWT.Modify).observe(text);
  }

  /**
   * Wrap an SWT Combo into an ISWTObservableValue
   */
  private static ISWTObservableValue<String> _toObservableValue(final Combo combo) {
    return WidgetProperties.comboSelection().observe(combo);
  }

  /**
   * Add a validation listener to a generic SWT Control
   */
  private static void _addValidationListener(final Control control, final ControlDecoration decoration, final Procedure1<? super String> validationProcedure) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type ");
    String _simpleName = control.getClass().getSimpleName();
    _builder.append(_simpleName);
    String _plus = ("Validation listeners not supported for controls of " + _builder);
    throw new IllegalArgumentException(_plus);
  }

  /**
   * Add a validation listener to an SWT Text
   */
  private static void _addValidationListener(final Text text, final ControlDecoration decoration, final Procedure1<? super String> validationProcedure) {
    final ModifyListener _function = (ModifyEvent it) -> {
      try {
        validationProcedure.apply(((Text) it.widget).getText());
        decoration.hide();
      } catch (final Throwable _t) {
        if (_t instanceof IllegalArgumentException) {
          final IllegalArgumentException ex = (IllegalArgumentException)_t;
          decoration.setDescriptionText(ex.getMessage());
          decoration.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR).getImage());
          decoration.show();
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    };
    text.addModifyListener(_function);
  }

  /**
   * Add a validation listener to an SWT Combo
   */
  private static void _addValidationListener(final Combo combo, final ControlDecoration decoration, final Procedure1<? super String> validationProcedure) {
    combo.addSelectionListener(new SelectionListener() {
      @Override
      public void widgetDefaultSelected(final SelectionEvent event) {
        this.widgetSelected(event);
      }

      @Override
      public void widgetSelected(final SelectionEvent event) {
        try {
          validationProcedure.apply(combo.getText());
          decoration.hide();
        } catch (final Throwable _t) {
          if (_t instanceof IllegalArgumentException) {
            final IllegalArgumentException ex = (IllegalArgumentException)_t;
            decoration.setDescriptionText(ex.getMessage());
            decoration.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR).getImage());
            decoration.show();
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    });
  }

  /**
   * Check if the user selected only a single row in a given TableViewer. If so, return the
   * corresponding IStructuredSelection instance. Otherwise display an error dialog.
   */
  public static IStructuredSelection singleRowSelectionOrError(final TableViewer viewer) {
    ISelection _selection = viewer.getSelection();
    final IStructuredSelection selection = ((IStructuredSelection) _selection);
    IStructuredSelection _xifexpression = null;
    boolean _isEmpty = selection.isEmpty();
    if (_isEmpty) {
      Object _xblockexpression = null;
      {
        MessageDialog.openError(viewer.getControl().getShell(), "No Row Selected", ("Please select a " + 
          "single row."));
        _xblockexpression = null;
      }
      _xifexpression = ((IStructuredSelection)_xblockexpression);
    } else {
      IStructuredSelection _xifexpression_1 = null;
      int _length = ((Object[])Conversions.unwrapArray(selection, Object.class)).length;
      boolean _greaterThan = (_length > 1);
      if (_greaterThan) {
        Object _xblockexpression_1 = null;
        {
          MessageDialog.openError(viewer.getControl().getShell(), "Too Many Rows Selected", ("Please " + 
            "select only a single row."));
          _xblockexpression_1 = null;
        }
        _xifexpression_1 = ((IStructuredSelection)_xblockexpression_1);
      } else {
        _xifexpression_1 = selection;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }

  /**
   * Check if the user selected at least one row in a given TableViewer. If so, return the
   * corresponding IStructuredSelection instance. Otherwise display an error dialog.
   */
  public static IStructuredSelection rowSelectionOrError(final TableViewer viewer) {
    ISelection _selection = viewer.getSelection();
    final IStructuredSelection selection = ((IStructuredSelection) _selection);
    IStructuredSelection _xifexpression = null;
    boolean _isEmpty = selection.isEmpty();
    if (_isEmpty) {
      Object _xblockexpression = null;
      {
        MessageDialog.openError(viewer.getControl().getShell(), "No Rows Selected", ("Please select at " + 
          "least one row."));
        _xblockexpression = null;
      }
      _xifexpression = ((IStructuredSelection)_xblockexpression);
    } else {
      _xifexpression = selection;
    }
    return _xifexpression;
  }

  /**
   * Print the given string to the MessageConsoleStream indenting it by one INDENT
   */
  public static void printlnIndent(final MessageConsoleStream stream, final String s) {
    Utils.printlnIndent(stream, s, 1);
  }

  public static final String INDENT = " ".repeat(2);

  /**
   * Print the given string to the MessageConsoleStream indenting it by the given number of
   * INDENTs
   */
  public static void printlnIndent(final MessageConsoleStream stream, final String s, final int numberOfIndents) {
    String _repeat = Utils.INDENT.repeat(numberOfIndents);
    String _plus = (_repeat + s);
    stream.println(_plus);
  }

  /**
   * Get the currently active SWT Shell
   */
  public static Shell getActiveShell() {
    return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
  }

  /**
   * Get the current workbench display
   */
  public static Display getWorkbenchDisplay() {
    return PlatformUI.getWorkbench().getDisplay();
  }

  /**
   * Execute the given command in a blocking fashion. The command will be executed in a new
   * Process and the helper will wait for the Process to terminate in at most
   * (cycleTime * maxCycles) milliseconds. If the Process does not terminate within that time, the
   * helper will kill the Process and throw an IllegalStateException. Otherwise, the helper will
   * return the Process's exit value, and STDOUT output (Process exited with value 0) or STDERR
   * output (Process exited with a value other than 0).
   */
  public static Pair<Integer, String> executeShellCommandBlocking(final String command, final int cycleTime, final int maxCycles) {
    try {
      final Process process = Runtime.getRuntime().exec(command);
      final ByteArrayOutputStream infoStream = new ByteArrayOutputStream();
      process.getInputStream().transferTo(infoStream);
      final ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
      process.getErrorStream().transferTo(errorStream);
      int cycle = 0;
      while ((process.isAlive() && (cycle < maxCycles))) {
        try {
          process.waitFor(cycleTime, TimeUnit.MILLISECONDS);
          int _cycle = cycle;
          cycle = (_cycle + 1);
        } catch (final Throwable _t) {
          if (_t instanceof InterruptedException) {
            final InterruptedException ex = (InterruptedException)_t;
            process.destroyForcibly();
            throw ex;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
      boolean _isAlive = process.isAlive();
      if (_isAlive) {
        process.destroyForcibly();
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Command ");
        _builder.append(command);
        _builder.append(" didn\'t finish in granted time ");
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("(");
        _builder_1.append((cycleTime * maxCycles));
        _builder_1.append(" ms)");
        String _plus = (_builder.toString() + _builder_1);
        throw new IllegalStateException(_plus);
      }
      ByteArrayOutputStream _xifexpression = null;
      int _exitValue = process.exitValue();
      boolean _equals = (_exitValue == 0);
      if (_equals) {
        _xifexpression = infoStream;
      } else {
        _xifexpression = errorStream;
      }
      final ByteArrayOutputStream messageStream = _xifexpression;
      int _exitValue_1 = process.exitValue();
      String _string = messageStream.toString(StandardCharsets.UTF_8);
      return Pair.<Integer, String>of(Integer.valueOf(_exitValue_1), _string);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Parse the source model file of the given model processing configuration for imports. The
   * method returns a list of Pairs whose keys are the EObject classes of the root elements of the
   * imported metamodel kinds and whose values are ImportInfo instances that subsume relevant
   * information about a model import in a canonical form.
   */
  public static List<Pair<Class<? extends EObject>, Utils.ImportInfo>> parseTransformableImportedModelsOfSourceModelFile(final ProcessingConfiguration processingConfiguration) {
    final IFile sourceModelFile = processingConfiguration.getSourceModelFile();
    if ((sourceModelFile == null)) {
      throw new IllegalArgumentException("Please specify an existing source model file");
    }
    final Function1<Pair<Class<? extends EObject>, Utils.ImportInfo>, Boolean> _function = (Pair<Class<? extends EObject>, Utils.ImportInfo> it) -> {
      return Boolean.valueOf(Utils.TRANSFORMABLE_MODEL_KINDS.contains(it.getKey()));
    };
    final List<Pair<Class<? extends EObject>, Utils.ImportInfo>> imports = IterableExtensions.<Pair<Class<? extends EObject>, Utils.ImportInfo>>toList(IterableExtensions.<Pair<Class<? extends EObject>, Utils.ImportInfo>>filter(Utils.parseImports(sourceModelFile), _function));
    boolean _isEmpty = imports.isEmpty();
    if (_isEmpty) {
      throw new IllegalArgumentException("Source model does not import other models");
    }
    return imports;
  }

  /**
   * Retrieve all imports from a LEMMA model represented by the given IFile. The helper returns a
   * list of Pairs whose keys are the EObject classes of the root elements of the imported
   * metamodel kinds (e.g., DataModel for a "datatype" import in a service model) and whose values
   * are ImportInfo instances that subsume relevant information about a model import in a
   * canonical form.
   */
  public static List<Pair<Class<? extends EObject>, Utils.ImportInfo>> parseImports(final IFile file) {
    try {
      final XtextResource resource = LemmaUiUtils.loadXtextResource(file);
      final EObject modelRoot = resource.getContents().get(0);
      List<? extends Pair<? extends Class<? extends EObject>, Utils.ImportInfo>> _list = IterableExtensions.toList(Utils.typedImports(modelRoot));
      return ((List<Pair<Class<? extends EObject>, Utils.ImportInfo>>) _list);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
        StringConcatenation _builder = new StringConcatenation();
        String _name = file.getName();
        _builder.append(_name);
        _builder.append(": ");
        String _message = ex.getMessage();
        _builder.append(_message);
        String _plus = ("Error during parsing of model file" + _builder);
        throw new IllegalArgumentException(_plus);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }

  /**
   * Return a list of Pairs of root element types and ImportInfo instances of imports in a given
   * DataModel
   */
  protected static List<? extends Pair<? extends Class<? extends EObject>, Utils.ImportInfo>> _typedImports(final DataModel modelRoot) {
    final Function1<ComplexTypeImport, Pair<Class<DataModel>, Utils.ImportInfo>> _function = (ComplexTypeImport it) -> {
      String _name = it.getName();
      String _importURI = it.getImportURI();
      Utils.ImportInfo _importInfo = new Utils.ImportInfo(_name, _importURI);
      return Pair.<Class<DataModel>, Utils.ImportInfo>of(DataModel.class, _importInfo);
    };
    return ListExtensions.<ComplexTypeImport, Pair<Class<DataModel>, Utils.ImportInfo>>map(modelRoot.getComplexTypeImports(), _function);
  }

  /**
   * Return a list of Pairs of root element types and ImportInfo instances of imports in a given
   * Technology
   */
  protected static List<? extends Pair<? extends Class<? extends EObject>, Utils.ImportInfo>> _typedImports(final Technology modelRoot) {
    final Function1<TechnologyImport, Pair<Class<Technology>, Utils.ImportInfo>> _function = (TechnologyImport it) -> {
      String _name = it.getName();
      String _importURI = it.getImportURI();
      Utils.ImportInfo _importInfo = new Utils.ImportInfo(_name, _importURI);
      return Pair.<Class<Technology>, Utils.ImportInfo>of(Technology.class, _importInfo);
    };
    return ListExtensions.<TechnologyImport, Pair<Class<Technology>, Utils.ImportInfo>>map(modelRoot.getImports(), _function);
  }

  /**
   * Return a list of Pairs of root element types and ImportInfo instances of imports in a given
   * ServiceModel
   */
  protected static List<? extends Pair<? extends Class<? extends EObject>, Utils.ImportInfo>> _typedImports(final ServiceModel modelRoot) {
    final Function1<Import, Pair<Class<? extends EObject>, Utils.ImportInfo>> _function = (Import it) -> {
      Class<? extends EObject> _modelRootClass = Utils.getModelRootClass(it.getImportType());
      String _name = it.getName();
      String _importURI = it.getImportURI();
      Utils.ImportInfo _importInfo = new Utils.ImportInfo(_name, _importURI);
      return Pair.<Class<? extends EObject>, Utils.ImportInfo>of(_modelRootClass, _importInfo);
    };
    return ListExtensions.<Import, Pair<Class<? extends EObject>, Utils.ImportInfo>>map(modelRoot.getImports(), _function);
  }

  /**
   * Helper to get the EObject class of a model that is imported using a certain ImportType
   */
  private static Class<? extends EObject> getModelRootClass(final ImportType importType) {
    Class<? extends EObject> _switchResult = null;
    if (importType != null) {
      switch (importType) {
        case DATATYPES:
          _switchResult = DataModel.class;
          break;
        case TECHNOLOGY:
          _switchResult = Technology.class;
          break;
        case MICROSERVICES:
          _switchResult = ServiceModel.class;
          break;
        case OPERATION_NODES:
          _switchResult = OperationModel.class;
          break;
        default:
          break;
      }
    }
    return _switchResult;
  }

  /**
   * Return a list of Pairs of root element types and ImportInfo instances of imports in a given
   * TechnologyMapping
   */
  protected static List<? extends Pair<? extends Class<? extends EObject>, Utils.ImportInfo>> _typedImports(final TechnologyMapping modelRoot) {
    final Function1<Import, Pair<Class<? extends EObject>, Utils.ImportInfo>> _function = (Import it) -> {
      Class<? extends EObject> _modelRootClass = Utils.getModelRootClass(it.getImportType());
      String _name = it.getName();
      String _importURI = it.getImportURI();
      Utils.ImportInfo _importInfo = new Utils.ImportInfo(_name, _importURI);
      return Pair.<Class<? extends EObject>, Utils.ImportInfo>of(_modelRootClass, _importInfo);
    };
    return ListExtensions.<Import, Pair<Class<? extends EObject>, Utils.ImportInfo>>map(modelRoot.getImports(), _function);
  }

  /**
   * Return a list of Pairs of root element types and ImportInfo instances of imports in a given
   * OperationModel
   */
  protected static List<? extends Pair<? extends Class<? extends EObject>, Utils.ImportInfo>> _typedImports(final OperationModel modelRoot) {
    final Function1<Import, Pair<Class<? extends EObject>, Utils.ImportInfo>> _function = (Import it) -> {
      Class<? extends EObject> _modelRootClass = Utils.getModelRootClass(it.getImportType());
      String _name = it.getName();
      String _importURI = it.getImportURI();
      Utils.ImportInfo _importInfo = new Utils.ImportInfo(_name, _importURI);
      return Pair.<Class<? extends EObject>, Utils.ImportInfo>of(_modelRootClass, _importInfo);
    };
    return ListExtensions.<Import, Pair<Class<? extends EObject>, Utils.ImportInfo>>map(modelRoot.getImports(), _function);
  }

  /**
   * Make the paths of a DataModel's imports absolute w.r.t. the given base IFile
   */
  protected static void _makeImportPathsAbsolute(final DataModel modelRoot, final IFile basefile) {
    Utils.makeImportPathsAbsoluteFromBasefilePath(modelRoot, 
      basefile.getRawLocation().makeAbsolute().toString());
  }

  /**
   * Make the paths of a DataModel's imports absolute w.r.t. the given base path
   */
  protected static void _makeImportPathsAbsoluteFromBasefilePath(final DataModel modelRoot, final String absoluteBasefilePath) {
    final Consumer<ComplexTypeImport> _function = (ComplexTypeImport it) -> {
      it.setImportURI(LemmaUtils.convertToAbsolutePath(it.getImportURI(), absoluteBasefilePath));
    };
    modelRoot.getComplexTypeImports().forEach(_function);
  }

  /**
   * Make the paths of a Technology's imports absolute w.r.t. the given base IFile
   */
  protected static void _makeImportPathsAbsolute(final Technology modelRoot, final IFile basefile) {
    Utils.makeImportPathsAbsoluteFromBasefilePath(modelRoot, 
      basefile.getRawLocation().makeAbsolute().toString());
  }

  /**
   * Make the paths of a Technology's imports absolute w.r.t. the given base path
   */
  protected static void _makeImportPathsAbsoluteFromBasefilePath(final Technology modelRoot, final String absoluteBasefilePath) {
    final Consumer<TechnologyImport> _function = (TechnologyImport it) -> {
      it.setImportURI(LemmaUtils.convertToAbsolutePath(it.getImportURI(), absoluteBasefilePath));
    };
    modelRoot.getImports().forEach(_function);
  }

  /**
   * Make the paths of a ServiceModel's imports absolute w.r.t. the given base IFile
   */
  protected static void _makeImportPathsAbsolute(final ServiceModel modelRoot, final IFile basefile) {
    Utils.makeImportPathsAbsoluteFromBasefilePath(modelRoot, 
      basefile.getRawLocation().makeAbsolute().toString());
  }

  /**
   * Make the paths of a ServiceModel's imports absolute w.r.t. the given base path
   */
  protected static void _makeImportPathsAbsoluteFromBasefilePath(final ServiceModel modelRoot, final String absoluteBasefilePath) {
    final Consumer<Import> _function = (Import it) -> {
      Utils.makeImportPathAbsolute(it, absoluteBasefilePath);
    };
    modelRoot.getImports().forEach(_function);
  }

  /**
   * Make the path of the given Import absolute w.r.t. the given base path
   */
  private static void makeImportPathAbsolute(final Import import_, final String absoluteBasefilePath) {
    import_.setImportURI(LemmaUtils.convertToAbsolutePath(import_.getImportURI(), absoluteBasefilePath));
  }

  /**
   * Make the paths of a TechnologyMapping's imports absolute w.r.t. the given base IFile
   */
  protected static void _makeImportPathsAbsolute(final TechnologyMapping modelRoot, final IFile basefile) {
    Utils.makeImportPathsAbsoluteFromBasefilePath(modelRoot, 
      basefile.getRawLocation().makeAbsolute().toString());
  }

  /**
   * Make the paths of a TechnologyMapping's imports absolute w.r.t. the given base path
   */
  protected static void _makeImportPathsAbsoluteFromBasefilePath(final TechnologyMapping modelRoot, final String absoluteBasefilePath) {
    final Consumer<Import> _function = (Import it) -> {
      Utils.makeImportPathAbsolute(it, absoluteBasefilePath);
    };
    modelRoot.getImports().forEach(_function);
  }

  /**
   * Make the paths of an OperationModel's imports absolute w.r.t. the given base IFile
   */
  protected static void _makeImportPathsAbsolute(final OperationModel modelRoot, final IFile basefile) {
    Utils.makeImportPathsAbsoluteFromBasefilePath(modelRoot, 
      basefile.getRawLocation().makeAbsolute().toString());
  }

  /**
   * Make the paths of an OperationModel's imports absolute w.r.t. the given base path
   */
  protected static void _makeImportPathsAbsoluteFromBasefilePath(final OperationModel modelRoot, final String absoluteBasefilePath) {
    final Consumer<Import> _function = (Import it) -> {
      Utils.makeImportPathAbsolute(it, absoluteBasefilePath);
    };
    modelRoot.getImports().forEach(_function);
  }

  /**
   * Programmatically trigger the validation of a text field by temporarily changing its value to
   * a different one
   */
  public static void triggerValidation(final Text field) {
    final String currentText = field.getText();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(currentText);
    _builder.append("TriggerUpdate");
    field.setText(_builder.toString());
    field.setText(currentText);
  }

  /**
   * Parse the given XML String into an XML Document
   */
  public static Document parseXmlString(final String xml) {
    try {
      final DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      byte[] _bytes = xml.getBytes();
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_bytes);
      return builder.parse(_byteArrayInputStream);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Return the root element of the given XML Document if it has the given tag or null otherwise
   */
  public static Element getRootElementWithTag(final Document document, final String tag) {
    final Element rootElement = document.getDocumentElement();
    Element _xifexpression = null;
    if ((((rootElement != null) && (rootElement instanceof Element)) && 
      Objects.equal(((Element) rootElement).getTagName(), tag))) {
      _xifexpression = ((Element) rootElement);
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }

  /**
   * Get all model processing launch configurations
   */
  public static Map<String, ILaunchConfiguration> getModelProcessingLaunchConfigurations() {
    try {
      final Function1<ILaunchConfiguration, String> _function = (ILaunchConfiguration it) -> {
        return it.getName();
      };
      final Function1<ILaunchConfiguration, ILaunchConfiguration> _function_1 = (ILaunchConfiguration it) -> {
        return it;
      };
      return IterableExtensions.<ILaunchConfiguration, String, ILaunchConfiguration>toMap(((Iterable<? extends ILaunchConfiguration>)Conversions.doWrapArray(LaunchConfigurationConstants.LAUNCH_MANAGER.getLaunchConfigurations(LaunchConfigurationConstants.PROCESSING_CONFIGURATION_LAUNCH_CONFIGURATION_TYPE))), _function, _function_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Get the IFile selected by the given ISelection
   */
  public static IFile getSelectedFile(final ISelection selection) {
    IFile _xifexpression = null;
    if ((selection instanceof IStructuredSelection)) {
      IFile _xblockexpression = null;
      {
        final IStructuredSelection structuredSelection = ((IStructuredSelection) selection);
        _xblockexpression = Platform.getAdapterManager().<IFile>getAdapter(structuredSelection.getFirstElement(), IFile.class);
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }

  /**
   * Get the IFile that is currently edited in the given IEditorPart
   */
  public static IFile getEditedFile(final IEditorPart editor) {
    IFile _xifexpression = null;
    IEditorInput _editorInput = editor.getEditorInput();
    if ((_editorInput instanceof FileEditorInput)) {
      IFile _xblockexpression = null;
      {
        IEditorInput _editorInput_1 = editor.getEditorInput();
        final IPath path = ((FileEditorInput) _editorInput_1).getPath();
        _xblockexpression = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(path);
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }

  /**
   * Get or create an Eclipse MessageConsole with the given name, and also reveal it
   */
  public static MessageConsole getAndRevealConsole(final String name) {
    final IConsoleManager consoleManager = ConsolePlugin.getDefault().getConsoleManager();
    final Function1<IConsole, Boolean> _function = (IConsole it) -> {
      String _name = it.getName();
      return Boolean.valueOf(Objects.equal(_name, name));
    };
    IConsole console = IterableExtensions.<IConsole>findFirst(((Iterable<IConsole>)Conversions.doWrapArray(consoleManager.getConsoles())), _function);
    if ((console == null)) {
      MessageConsole _messageConsole = new MessageConsole(name, null);
      console = _messageConsole;
      consoleManager.addConsoles(new IConsole[] { console });
    }
    consoleManager.showConsoleView(console);
    return ((MessageConsole) console);
  }

  /**
   * Create a new error MessageStream for the given MessageConsole. An error MessageStream has a
   * different color (normally red) than a "regular" MessageStream.
   */
  public static MessageConsoleStream newErrorMessageStream(final MessageConsole console) {
    final MessageConsoleStream stream = console.newMessageStream();
    final Runnable _function = () -> {
      stream.setColor(LaunchConfigurationConstants.CONSOLE_ERROR_COLOR);
    };
    Utils.getWorkbenchDisplay().syncExec(_function);
    return stream;
  }

  /**
   * Get the launch configurations applicable to the given IFile as a mapped resource
   */
  public static Iterable<ILaunchConfiguration> getLaunchConfigurationsForMappedResource(final ILaunchManager launchManager, final ILaunchConfigurationType configurationType, final IFile file) {
    try {
      final Function1<ILaunchConfiguration, Boolean> _function = (ILaunchConfiguration it) -> {
        try {
          return Boolean.valueOf(((it.getMappedResources() != null) && 
            IterableExtensions.<IResource>exists(((Iterable<IResource>)Conversions.doWrapArray(it.getMappedResources())), ((Function1<IResource, Boolean>) (IResource resource) -> {
              return Boolean.valueOf(((resource instanceof IFile) && Objects.equal(resource.getFullPath(), file.getFullPath())));
            }))));
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      return IterableExtensions.<ILaunchConfiguration>filter(((Iterable<ILaunchConfiguration>)Conversions.doWrapArray(LaunchConfigurationConstants.LAUNCH_MANAGER.getLaunchConfigurations(LaunchConfigurationConstants.PROCESSING_CHAIN_LAUNCH_CONFIGURATION_TYPE))), _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Helper to replace a given String searchString with a given String replacement in a given
   * String text.
   * 
   * Note: The method's code was translated to Xtend from the eponymous method of the Java-based
   * StringUtils class of Apache's Commons Lang library. By implementing our own version of the
   * method, we can provide the plugin also as an Eclipse drop-in as recent Eclipse versions don't
   * include Apache Commons Lang by default.
   */
  public static Object replace(final String text, final String searchString, final String replacement) {
    if (((StringExtensions.isNullOrEmpty(text) || StringExtensions.isNullOrEmpty(searchString)) || StringExtensions.isNullOrEmpty(replacement))) {
      return text;
    }
    int start = 0;
    int end = text.indexOf(searchString, start);
    if ((end == (-1))) {
      return text;
    }
    int replLength = searchString.length();
    int _length = replacement.length();
    int _minus = (_length - replLength);
    int _max = Math.max(_minus, 0);
    int increase = (_max * 16);
    int _length_1 = text.length();
    int _plus = (_length_1 + increase);
    StringBuilder buf = new StringBuilder(_plus);
    while ((end != (-1))) {
      {
        buf.append(text, start, end).append(replacement);
        start = (end + replLength);
        end = text.indexOf(searchString, start);
      }
    }
    buf.append(text, start, text.length());
    return buf;
  }

  /**
   * Helper to remove a given String remove from the start of a given String s.
   * 
   * Note: The method's code was translated to Xtend from the eponymous method of the Java-based
   * StringUtils class of Apache's Commons Lang library. By implementing our own version of the
   * method, we can provide the plugin also as an Eclipse drop-in as recent Eclipse versions don't
   * include Apache Commons Lang by default.
   */
  public static String removeStart(final String s, final String remove) {
    String _xifexpression = null;
    if ((StringExtensions.isNullOrEmpty(s) || StringExtensions.isNullOrEmpty(remove))) {
      _xifexpression = s;
    } else {
      String _xifexpression_1 = null;
      boolean _startsWith = s.startsWith(remove);
      if (_startsWith) {
        _xifexpression_1 = s.substring(remove.length());
      } else {
        _xifexpression_1 = s;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }

  /**
   * Helper to remove a given String remove from the end of a given String s.
   * 
   * Note: The method's code was translated to Xtend from the eponymous method of the Java-based
   * StringUtils class of Apache's Commons Lang library. By implementing our own version of the
   * method, we can provide the plugin also as an Eclipse drop-in as recent Eclipse versions don't
   * include Apache Commons Lang by default.
   */
  public static String removeEnd(final String s, final String remove) {
    String _xifexpression = null;
    if ((StringExtensions.isNullOrEmpty(s) || StringExtensions.isNullOrEmpty(remove))) {
      _xifexpression = s;
    } else {
      String _xifexpression_1 = null;
      boolean _endsWith = s.endsWith(remove);
      if (_endsWith) {
        int _length = s.length();
        int _length_1 = remove.length();
        int _minus = (_length - _length_1);
        _xifexpression_1 = s.substring(0, _minus);
      } else {
        _xifexpression_1 = s;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }

  /**
   * Helper to get the substring occurring in a given String s before a given String sep.
   * 
   * Note: The method's code was translated to Xtend from the eponymous method of the Java-based
   * StringUtils class of Apache's Commons Lang library. By implementing our own version of the
   * method, we can provide the plugin also as an Eclipse drop-in as recent Eclipse versions don't
   * include Apache Commons Lang by default.
   */
  public static String substringBeforeLast(final String s, final String sep) {
    if ((StringExtensions.isNullOrEmpty(s) || StringExtensions.isNullOrEmpty(sep))) {
      return s;
    }
    final int pos = s.lastIndexOf(sep);
    String _xifexpression = null;
    if ((pos == (-1))) {
      _xifexpression = s;
    } else {
      _xifexpression = s.substring(0, pos);
    }
    return _xifexpression;
  }

  /**
   * Helper to get the substring occurring in a given String s after a given String sep.
   * 
   * Note: The method's code was translated to Xtend from the eponymous method of the Java-based
   * StringUtils class of Apache's Commons Lang library. By implementing our own version of the
   * method, we can provide the plugin also as an Eclipse drop-in as recent Eclipse versions don't
   * include Apache Commons Lang by default.
   */
  public static String substringAfterLast(final String s, final String sep) {
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(s);
    if (_isNullOrEmpty) {
      return s;
    }
    final int pos = s.lastIndexOf(sep);
    String _xifexpression = null;
    if (((pos == (-1)) || (pos == (s.length() - 1)))) {
      _xifexpression = "";
    } else {
      _xifexpression = s.substring((pos + 1));
    }
    return _xifexpression;
  }

  private static ISWTObservableValue<String> toObservableValue(final Control combo) {
    if (combo instanceof Combo) {
      return _toObservableValue((Combo)combo);
    } else if (combo instanceof Text) {
      return _toObservableValue((Text)combo);
    } else if (combo != null) {
      return _toObservableValue(combo);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(combo).toString());
    }
  }

  private static void addValidationListener(final Control combo, final ControlDecoration decoration, final Procedure1<? super String> validationProcedure) {
    if (combo instanceof Combo
         && validationProcedure != null) {
      _addValidationListener((Combo)combo, decoration, validationProcedure);
      return;
    } else if (combo instanceof Text
         && validationProcedure != null) {
      _addValidationListener((Text)combo, decoration, validationProcedure);
      return;
    } else if (combo != null
         && validationProcedure != null) {
      _addValidationListener(combo, decoration, validationProcedure);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(combo, decoration, validationProcedure).toString());
    }
  }

  public static List<? extends Pair<? extends Class<? extends EObject>, Utils.ImportInfo>> typedImports(final EObject modelRoot) {
    if (modelRoot instanceof DataModel) {
      return _typedImports((DataModel)modelRoot);
    } else if (modelRoot instanceof OperationModel) {
      return _typedImports((OperationModel)modelRoot);
    } else if (modelRoot instanceof ServiceModel) {
      return _typedImports((ServiceModel)modelRoot);
    } else if (modelRoot instanceof Technology) {
      return _typedImports((Technology)modelRoot);
    } else if (modelRoot instanceof TechnologyMapping) {
      return _typedImports((TechnologyMapping)modelRoot);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(modelRoot).toString());
    }
  }

  public static void makeImportPathsAbsolute(final EObject modelRoot, final IFile basefile) {
    if (modelRoot instanceof DataModel) {
      _makeImportPathsAbsolute((DataModel)modelRoot, basefile);
      return;
    } else if (modelRoot instanceof OperationModel) {
      _makeImportPathsAbsolute((OperationModel)modelRoot, basefile);
      return;
    } else if (modelRoot instanceof ServiceModel) {
      _makeImportPathsAbsolute((ServiceModel)modelRoot, basefile);
      return;
    } else if (modelRoot instanceof Technology) {
      _makeImportPathsAbsolute((Technology)modelRoot, basefile);
      return;
    } else if (modelRoot instanceof TechnologyMapping) {
      _makeImportPathsAbsolute((TechnologyMapping)modelRoot, basefile);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(modelRoot, basefile).toString());
    }
  }

  public static void makeImportPathsAbsoluteFromBasefilePath(final EObject modelRoot, final String absoluteBasefilePath) {
    if (modelRoot instanceof DataModel) {
      _makeImportPathsAbsoluteFromBasefilePath((DataModel)modelRoot, absoluteBasefilePath);
      return;
    } else if (modelRoot instanceof OperationModel) {
      _makeImportPathsAbsoluteFromBasefilePath((OperationModel)modelRoot, absoluteBasefilePath);
      return;
    } else if (modelRoot instanceof ServiceModel) {
      _makeImportPathsAbsoluteFromBasefilePath((ServiceModel)modelRoot, absoluteBasefilePath);
      return;
    } else if (modelRoot instanceof Technology) {
      _makeImportPathsAbsoluteFromBasefilePath((Technology)modelRoot, absoluteBasefilePath);
      return;
    } else if (modelRoot instanceof TechnologyMapping) {
      _makeImportPathsAbsoluteFromBasefilePath((TechnologyMapping)modelRoot, absoluteBasefilePath);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(modelRoot, absoluteBasefilePath).toString());
    }
  }
}
