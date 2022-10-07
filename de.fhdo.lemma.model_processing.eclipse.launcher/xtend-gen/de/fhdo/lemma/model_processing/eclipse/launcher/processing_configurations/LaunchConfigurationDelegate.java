package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations;

import com.google.common.base.Objects;
import de.fhdo.lemma.eclipse.ui.utils.LemmaUiUtils;
import de.fhdo.lemma.model_processing.eclipse.launcher.Utils;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AbstractArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AbstractIntermediateModelArgumentTypeWithEnumValue;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Delegate for model processing launch configurations.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class LaunchConfigurationDelegate implements ILaunchConfigurationDelegate {
  public static final String CONSOLE_NAME = "LEMMA Model Processor Run";
  
  public static final String DISABLE_CONSOLE_CLEARING_LAUNCH_ATTRIBUTE = (("lemma" + 
    LaunchConfigurationDelegate.class.getName()) + "DisableConsoleClearing");
  
  private static final String INDENT = "  ";
  
  private static final String MODEL_PROCESSOR_EXECUTION_ABORTED_MESSAGE = "Model processor execution aborted";
  
  private MessageConsoleStream infoStream;
  
  private MessageConsoleStream errorStream;
  
  private int headlineLength;
  
  /**
   * Show the commandline of the given ILaunchConfiguration which must be a valid model processing
   * launch configuration
   */
  @Override
  public final String showCommandLine(final ILaunchConfiguration launchConfiguration, final String mode, final ILaunch launch, final IProgressMonitor monitor) {
    final ProcessingConfiguration configuration = ProcessingConfiguration.deserializeFrom(launchConfiguration);
    if ((configuration == null)) {
      return null;
    }
    String _xtrycatchfinallyexpression = null;
    try {
      String _xblockexpression = null;
      {
        final CommandLineGenerator generator = new CommandLineGenerator(configuration);
        final Pair<CommandLineGenerator.CoherentCommandLineParts, List<String>> partsAndWarnings = generator.generateCoherentCommandLineParts();
        final Consumer<String> _function = (String it) -> {
          MessageDialog.openWarning(Utils.getActiveShell(), "Warning during commandline generation", it);
        };
        partsAndWarnings.getValue().forEach(_function);
        _xblockexpression = generator.toPrintableCommandLine(partsAndWarnings.getKey(), "\n\t");
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
        Object _xblockexpression_1 = null;
        {
          this.showCommandLineGenerationError(ex);
          _xblockexpression_1 = null;
        }
        _xtrycatchfinallyexpression = ((String)_xblockexpression_1);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  /**
   * Helper to display an error message from an exception occurred during commandline generation
   */
  private void showCommandLineGenerationError(final Exception ex) {
    String _xifexpression = null;
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(ex.getMessage());
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      _xifexpression = ex.getMessage();
    } else {
      StringConcatenation _builder = new StringConcatenation();
      String _simpleName = ex.getClass().getSimpleName();
      _builder.append(_simpleName);
      _builder.append(" occurred");
      _xifexpression = _builder.toString();
    }
    String message = _xifexpression;
    MessageDialog.openError(Utils.getActiveShell(), "Error during commandline generation", message);
  }
  
  /**
   * Launch the given ILaunchConfiguration which must be a valid model processing launch
   * configuration
   */
  @Override
  public final void launch(final ILaunchConfiguration launchConfiguration, final String mode, final ILaunch launch, final IProgressMonitor monitor) {
    try {
      final ProcessingConfiguration configuration = ProcessingConfiguration.deserializeFrom(launchConfiguration);
      if ((configuration == null)) {
        Status _status = new Status(IStatus.ERROR, LaunchConfigurationDelegate.class, 
          "LEMMA model processor configuration not readable. Launch aborted.");
        throw new CoreException(_status);
      }
      try {
        configuration.convertToUserRepresentation();
        configuration.validateInUserRepresentation();
      } catch (final Throwable _t) {
        if (_t instanceof IllegalArgumentException) {
          final IllegalArgumentException ex = (IllegalArgumentException)_t;
          String _message = ex.getMessage();
          String _plus = (("Invalid LEMMA model " + 
            "processor configuration:\n") + _message);
          String _plus_1 = (_plus + "\n\nLaunch aborted.");
          Status _status_1 = new Status(IStatus.ERROR, LaunchConfigurationDelegate.class, _plus_1);
          throw new CoreException(_status_1);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      final MessageConsole console = Utils.getAndRevealConsole(LaunchConfigurationDelegate.CONSOLE_NAME);
      final boolean disableConsoleClearing = launchConfiguration.getAttribute(LaunchConfigurationDelegate.DISABLE_CONSOLE_CLEARING_LAUNCH_ATTRIBUTE, false);
      if ((!disableConsoleClearing)) {
        console.clearConsole();
      }
      this.openStreams(console);
      boolean _erroneousModels = this.erroneousModels(configuration.getSourceModelFile());
      if (_erroneousModels) {
        this.errorStream.println(LaunchConfigurationDelegate.MODEL_PROCESSOR_EXECUTION_ABORTED_MESSAGE);
        this.closeStreams();
        return;
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("\"");
      String _name = launchConfiguration.getName();
      _builder.append(_name);
      _builder.append("\"");
      final String headline = ("Executing LEMMA model processor configuration " + _builder);
      this.headlineLength = headline.length();
      this.infoStream.println(headline);
      final SubMonitor subMonitor = SubMonitor.convert(monitor, 1);
      boolean _intermediateTransformationRequired = this.intermediateTransformationRequired(configuration);
      if (_intermediateTransformationRequired) {
        this.printSepLine(this.infoStream);
        final Procedure0 _function = () -> {
          this.runModelProcessor(configuration, launch, subMonitor);
        };
        final Procedure0 _function_1 = () -> {
          this.displayAbortMessageAndCloseStreams();
        };
        new IntermediateTransformationExecutor(configuration, 
          this.infoStream, 
          this.errorStream, _function, _function_1).run();
      } else {
        this.runModelProcessor(configuration, launch, subMonitor);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Open all relevant console streams
   */
  private MessageConsoleStream openStreams(final MessageConsole console) {
    MessageConsoleStream _xblockexpression = null;
    {
      this.infoStream = console.newMessageStream();
      _xblockexpression = this.errorStream = Utils.newErrorMessageStream(console);
    }
    return _xblockexpression;
  }
  
  /**
   * Helper to check if the given IFile is a LEMMA model with errors or (possibly transitively)
   * imports LEMMA models with errors. This method will also print all direct and transitive
   * errors to the error stream of the previously opened console.
   */
  private boolean erroneousModels(final IFile sourceModelFile) {
    final String absoluteSourceModelPath = sourceModelFile.getRawLocation().makeAbsolute().toString();
    final HashMap<String, List<String>> erroneousModels = this.transitiveModelValidation(absoluteSourceModelPath);
    List<String> _elvis = null;
    List<String> _get = erroneousModels.get(absoluteSourceModelPath);
    if (_get != null) {
      _elvis = _get;
    } else {
      _elvis = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList());
    }
    final List<String> modelErrors = _elvis;
    boolean _isEmpty = modelErrors.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      String _join = IterableExtensions.join(modelErrors, "\n\t");
      String _plus = ("Model contains errors:\n\t" + _join);
      this.errorStream.println(_plus);
      this.errorStream.println();
    }
    final Function1<Map.Entry<String, List<String>>, Boolean> _function = (Map.Entry<String, List<String>> it) -> {
      String _key = it.getKey();
      return Boolean.valueOf((!Objects.equal(_key, absoluteSourceModelPath)));
    };
    final Iterable<Map.Entry<String, List<String>>> importedModelErrors = IterableExtensions.<Map.Entry<String, List<String>>>filter(erroneousModels.entrySet(), _function);
    boolean _isEmpty_1 = IterableExtensions.isEmpty(importedModelErrors);
    boolean _not_1 = (!_isEmpty_1);
    if (_not_1) {
      this.errorStream.println("Imported models contain errors:");
      final Consumer<Map.Entry<String, List<String>>> _function_1 = (Map.Entry<String, List<String>> it) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("\t");
        _builder.append("- ");
        String _key = it.getKey();
        _builder.append(_key);
        _builder.append(":");
        this.errorStream.println(_builder.toString());
        final Consumer<String> _function_2 = (String it_1) -> {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("\t\t");
          _builder_1.append("- ");
          _builder_1.append(it_1);
          this.errorStream.println(_builder_1.toString());
        };
        it.getValue().forEach(_function_2);
      };
      importedModelErrors.forEach(_function_1);
      this.errorStream.println();
    }
    boolean _isEmpty_2 = erroneousModels.isEmpty();
    return (!_isEmpty_2);
  }
  
  /**
   * Helper to perform a validation of the LEMMA model located at the given file path together
   * with a validation of all directly or indirectly (i.e., transitively) imported models.
   */
  private HashMap<String, List<String>> transitiveModelValidation(final String rootModelFilepath) {
    final HashMap<String, List<String>> erroneousModels = CollectionLiterals.<String, List<String>>newHashMap();
    final ArrayDeque<String> modelsToValidate = new ArrayDeque<String>();
    modelsToValidate.push(rootModelFilepath);
    final HashSet<String> validatedModels = CollectionLiterals.<String>newHashSet();
    while ((!modelsToValidate.isEmpty())) {
      {
        final String modelPath = modelsToValidate.pop();
        boolean _contains = validatedModels.contains(modelPath);
        boolean _not = (!_contains);
        if (_not) {
          XtextResource xtextResource = null;
          try {
            xtextResource = LemmaUiUtils.loadXtextResource(modelPath);
            final EObject modelRoot = xtextResource.getContents().get(0);
            Utils.makeImportPathsAbsoluteFromBasefilePath(modelRoot, modelPath);
            final List<String> errorMessages = this.toErrorMessages(LemmaUiUtils.validateXtextResource(xtextResource));
            boolean _isEmpty = errorMessages.isEmpty();
            boolean _not_1 = (!_isEmpty);
            if (_not_1) {
              erroneousModels.put(modelPath, errorMessages);
            }
          } catch (final Throwable _t) {
            if (_t instanceof Exception) {
              final Exception ex = (Exception)_t;
              String _message = ex.getMessage();
              erroneousModels.put(modelPath, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_message)));
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
          Set<String> _xtrycatchfinallyexpression = null;
          try {
            Set<String> _absolutePathsOfImportedModels = null;
            if (xtextResource!=null) {
              _absolutePathsOfImportedModels=this.getAbsolutePathsOfImportedModels(xtextResource, modelPath);
            }
            _xtrycatchfinallyexpression = _absolutePathsOfImportedModels;
          } catch (final Throwable _t) {
            if (_t instanceof Exception) {
              final Exception ex = (Exception)_t;
              Object _xblockexpression = null;
              {
                String _message = ex.getMessage();
                erroneousModels.put(modelPath, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_message)));
                _xblockexpression = null;
              }
              _xtrycatchfinallyexpression = ((Set<String>)_xblockexpression);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
          final Set<String> importedModelPaths = _xtrycatchfinallyexpression;
          if (importedModelPaths!=null) {
            final Consumer<String> _function = (String it) -> {
              boolean _contains_1 = validatedModels.contains(it);
              boolean _not_1 = (!_contains_1);
              if (_not_1) {
                modelsToValidate.add(it);
              }
            };
            importedModelPaths.forEach(_function);
          }
          validatedModels.add(modelPath);
        }
      }
    }
    return erroneousModels;
  }
  
  /**
   * Helper to convert a list of Issues resulting from a programmatic Xtext model validation to a
   * printable list of strings. The result list will only cover those Issues with an ERROR
   * Severity.
   */
  private List<String> toErrorMessages(final List<Issue> issues) {
    final Function1<Issue, Boolean> _function = (Issue it) -> {
      Severity _severity = it.getSeverity();
      return Boolean.valueOf(Objects.equal(_severity, Severity.ERROR));
    };
    final Function1<Issue, String> _function_1 = (Issue it) -> {
      StringConcatenation _builder = new StringConcatenation();
      Integer _lineNumber = it.getLineNumber();
      _builder.append(_lineNumber);
      _builder.append(":");
      Integer _column = it.getColumn();
      _builder.append(_column);
      _builder.append(": ");
      String _message = it.getMessage();
      _builder.append(_message);
      return _builder.toString();
    };
    return IterableExtensions.<String>toList(IterableExtensions.<Issue, String>map(IterableExtensions.<Issue>filter(issues, _function), _function_1));
  }
  
  /**
   * Helper to convert the paths of all models imported by the given XtextResource (which must
   * represent a LEMMA model) to absolute paths based on the given absolute basepath
   */
  private Set<String> getAbsolutePathsOfImportedModels(final XtextResource resource, final String absoluteBasepath) {
    boolean _isEmpty = resource.getContents().isEmpty();
    if (_isEmpty) {
      return Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet());
    }
    final EObject modelRoot = resource.getContents().get(0);
    Utils.makeImportPathsAbsoluteFromBasefilePath(modelRoot, absoluteBasepath);
    final Function1<Pair<? extends Class<? extends EObject>, Utils.ImportInfo>, String> _function = (Pair<? extends Class<? extends EObject>, Utils.ImportInfo> it) -> {
      return it.getValue().getImportUri();
    };
    return IterableExtensions.<String>toSet(ListExtensions.map(Utils.typedImports(modelRoot), _function));
  }
  
  /**
   * Close all relevant console streams
   */
  private void closeStreams() {
    try {
      this.infoStream.close();
      this.errorStream.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Check if the given model processing launch configuration requires intermediate model
   * transformations
   */
  private boolean intermediateTransformationRequired(final ProcessingConfiguration configuration) {
    final Function1<Argument, Boolean> _function = (Argument it) -> {
      AbstractArgumentType _type = it.getType();
      return Boolean.valueOf((_type instanceof AbstractIntermediateModelArgumentTypeWithEnumValue));
    };
    return IterableExtensions.<Argument>exists(configuration.getArguments(), _function);
  }
  
  /**
   * Print a line of separating dashes and with the length of the current headline to the given
   * console stream. In case the current headline has a length less or equal zerp, nothing will
   * be printed.
   */
  private void printSepLine(final MessageConsoleStream stream) {
    if ((this.headlineLength <= 0)) {
      return;
    }
    stream.println("-".repeat(this.headlineLength));
  }
  
  /**
   * Display a message that the model processor execution was aborted (e.g., due to the occurrence
   * of errors during an intermediate transformation or the preparation of a model processor's
   * execution) and close all relevant console streams
   */
  private void displayAbortMessageAndCloseStreams() {
    this.errorStream.println(("\n" + LaunchConfigurationDelegate.MODEL_PROCESSOR_EXECUTION_ABORTED_MESSAGE));
    this.closeStreams();
  }
  
  /**
   * Run a LEMMA model processor for the given model processing launch configuration and its
   * ILaunch instantiation
   */
  private void runModelProcessor(final ProcessingConfiguration configuration, final ILaunch launch, final IProgressMonitor monitor) {
    this.printSepLine(this.infoStream);
    final CommandLineGenerator commandLineGenerator = new CommandLineGenerator(configuration);
    CommandLineGenerator.CoherentCommandLineParts commandLineParts = null;
    try {
      final Pair<CommandLineGenerator.CoherentCommandLineParts, List<String>> partsAndWarnings = commandLineGenerator.generateCoherentCommandLineParts();
      List<String> _value = partsAndWarnings.getValue();
      for (final String warning : _value) {
        {
          String warningMessage = warning;
          boolean _endsWith = warningMessage.endsWith(".");
          boolean _not = (!_endsWith);
          if (_not) {
            warningMessage = (warningMessage + ".");
          }
          boolean _endsWith_1 = warningMessage.endsWith(" ");
          boolean _not_1 = (!_endsWith_1);
          if (_not_1) {
            warningMessage = (warningMessage + " ");
          }
          warningMessage = (warningMessage + "Do you want to continue?");
          final boolean continue_ = this.askForContinuationAfterWarning(("Warning during commandline " + 
            "generation"), warningMessage);
          if ((!continue_)) {
            this.displayAbortMessageAndCloseStreams();
            return;
          }
        }
      }
      commandLineParts = partsAndWarnings.getKey();
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
        final Runnable _function = () -> {
          this.showCommandLineGenerationError(ex);
        };
        Utils.getWorkbenchDisplay().syncExec(_function);
        this.displayAbortMessageAndCloseStreams();
        return;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    this.infoStream.println("Running model processor:");
    String _repeat = LaunchConfigurationDelegate.INDENT.repeat(2);
    String _plus = ("\n" + _repeat);
    final String printableCommandLine = commandLineGenerator.toPrintableCommandLine(commandLineParts, _plus);
    Utils.printlnIndent(this.infoStream, printableCommandLine);
    this.infoStream.println();
    try {
      final List<String> commandline = commandLineGenerator.toExecutableCommandLine(commandLineParts);
      final File workdir = configuration.getSourceModelFile().getRawLocation().makeAbsolute().toFile().getParentFile();
      final Process process = DebugPlugin.exec(((String[])Conversions.unwrapArray(commandline, String.class)), workdir);
      process.getInputStream().transferTo(this.infoStream);
      process.getErrorStream().transferTo(this.errorStream);
      DebugPlugin.newProcess(launch, process, "");
      Utils.getAndRevealConsole(LaunchConfigurationDelegate.CONSOLE_NAME);
      final Runnable processObserver = new Runnable() {
        @Override
        public void run() {
          boolean processDestroyed = false;
          while ((process.isAlive() && (!processDestroyed))) {
            try {
              process.waitFor(250, TimeUnit.MILLISECONDS);
            } catch (final Throwable _t) {
              if (_t instanceof InterruptedException) {
                process.destroyForcibly();
                processDestroyed = true;
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
          }
          int _exitValue = process.exitValue();
          boolean _equals = (_exitValue == 0);
          if (_equals) {
            LaunchConfigurationDelegate.this.infoStream.println("Model processor execution finished");
          } else {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("(exit code: ");
            int _exitValue_1 = process.exitValue();
            _builder.append(_exitValue_1);
            _builder.append(")");
            String _plus = ("\nModel processor execution finished with errors " + _builder);
            LaunchConfigurationDelegate.this.errorStream.println(_plus);
          }
          LaunchConfigurationDelegate.this.closeStreams();
          monitor.worked(1);
          monitor.done();
        }
      };
      new Thread(processObserver).start();
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
        this.infoStream.println();
        this.errorStream.println(ex.getMessage());
        this.closeStreams();
        monitor.done();
        return;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * Helper to ask the user for a continuation of the current action in the event of a previously
   * occurred warning
   */
  private boolean askForContinuationAfterWarning(final String title, final String message) {
    abstract class __LaunchConfigurationDelegate_2 implements Runnable {
      boolean continuationConfirmed;
    }
    
    final __LaunchConfigurationDelegate_2 continuationDialogRunnable = new __LaunchConfigurationDelegate_2() {
      @Override
      public void run() {
        Shell _activeShell = Utils.getActiveShell();
        final MessageDialog dialog = new MessageDialog(_activeShell, title, null, message, 
          MessageDialog.WARNING, new String[] { "Continue", "Cancel" }, 0);
        int _open = dialog.open();
        boolean _equals = (_open == 0);
        this.continuationConfirmed = _equals;
      }
    };
    Utils.getWorkbenchDisplay().syncExec(continuationDialogRunnable);
    return continuationDialogRunnable.continuationConfirmed;
  }
}
