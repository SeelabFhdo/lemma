package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import de.fhdo.lemma.eclipse.ui.AbstractUiModelTransformationStrategy;
import de.fhdo.lemma.eclipse.ui.ModelFile;
import de.fhdo.lemma.eclipse.ui.OperationModelTransformationStrategy;
import de.fhdo.lemma.eclipse.ui.ProgrammaticIntermediateModelTransformation;
import de.fhdo.lemma.eclipse.ui.ServiceModelTransformationStrategy;
import de.fhdo.lemma.model_processing.eclipse.launcher.Utils;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AbstractArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AbstractIntermediateModelArgumentTypeWithEnumValue;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AllImportedIntermediateModelKinds;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.ArgumentTypeIdentifier;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.FileArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.FolderArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.ImportedIntermediateModelKind;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelOfFirstImportArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelOfImportWithAliasArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelsOfAllImportsArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.RawStringArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.SourceModelArgumentType;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.StringPairArgumentType;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.apache.commons.io.FilenameUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Generator for the commandline to execute a model processing launch configuration.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public final class CommandLineGenerator {
  /**
   * Class representing lists of coherent commandline parts. A commandline part is either an
   * execution command part or coherent argument parameters. The coherence of a commandline part
   * is technically defined by their belonging to the same List instance.
   */
  public static class CoherentCommandLineParts {
    private final ArrayList<List<String>> executionCommandParts = CollectionLiterals.<List<String>>newArrayList();

    private final ArrayList<List<String>> argumentParameters = CollectionLiterals.<List<String>>newArrayList();

    /**
     * Add an execution command part consisting of a single String element
     */
    protected boolean addExecutionCommandPart(final String part) {
      return this.addExecutionCommandPart(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(part)));
    }

    /**
     * Add an execution command part consisting of coherent String elements
     */
    protected boolean addExecutionCommandPart(final List<String> part) {
      return this.executionCommandParts.add(part);
    }

    /**
     * Add execution command parts consisting of a list of coherent String elements
     */
    protected boolean addExecutionCommandParts(final List<List<String>> parts) {
      return this.executionCommandParts.addAll(parts);
    }

    /**
     * Add argument parameters consisting of a list of coherent String elements
     */
    protected boolean addParameterValues(final CommandLineGenerator.ParameterValues parameterValues) {
      return this.argumentParameters.addAll(parameterValues.unfoldWithoutNullValues());
    }

    /**
     * Merge all coherent commandline parts in their List forms in a single List instance
     */
    protected List<List<String>> mergeParts() {
      final ArrayList<List<String>> result = CollectionLiterals.<List<String>>newArrayList();
      result.addAll(this.executionCommandParts);
      result.addAll(this.argumentParameters);
      return Collections.<List<String>>unmodifiableList(result);
    }

    /**
     * Merge the Strings of all coherent commandline parts in a single List instance
     */
    protected List<String> mergeAndFlattenParts() {
      return Collections.<String>unmodifiableList(IterableExtensions.<String>toList(Iterables.<String>concat(this.mergeParts())));
    }
  }

  /**
   * Exception to signal that information about the current user was not determinable
   */
  private static class UserInfoNotDeterminable extends Exception {
    public UserInfoNotDeterminable(final String message) {
      super(message);
    }
  }

  /**
   * Class representing values for the parameters of the arguments of a model processing
   * configuration's execution
   */
  private static class ParameterValues {
    private final ArrayList<Pair<String, String>> pairs = CollectionLiterals.<Pair<String, String>>newArrayList();

    /**
     * Empty constructor
     */
    public ParameterValues() {
    }

    /**
     * Constructor for an argument parameter without a value
     */
    public ParameterValues(final Argument argument) {
      this.add(argument);
    }

    /**
     * Constructor for an argument parameter with a value
     */
    public ParameterValues(final Argument argument, final String value) {
      this.add(argument, value);
    }

    /**
     * Add an argument parameter without a value
     */
    public boolean add(final Argument argument) {
      return this.add(argument, null);
    }

    /**
     * Add an argument parameter with a value
     */
    public boolean add(final Argument argument, final String value) {
      return this.add(argument.getParameter(), value);
    }

    /**
     * Add an argument parameter in its String form with a value
     */
    public boolean add(final String parameter, final String value) {
      boolean _xblockexpression = false;
      {
        String _elvis = null;
        if (parameter != null) {
          _elvis = parameter;
        } else {
          _elvis = "<NO PARAMETER GIVEN>";
        }
        final String parameterForCommandLine = _elvis;
        Pair<String, String> _mappedTo = Pair.<String, String>of(parameterForCommandLine, value);
        _xblockexpression = this.pairs.add(_mappedTo);
      }
      return _xblockexpression;
    }

    /**
     * Return collected parameter values as a List of String Lists. Each nested List comprises
     * at most two String values: The first String is the parameter name, the second String is
     * the parameter value. For positional parameters, where the value is null, the nested List
     * will only comprise one element, i.e., the parameter name.
     */
    public List<List<String>> unfoldWithoutNullValues() {
      final Function1<Pair<String, String>, List<String>> _function = (Pair<String, String> it) -> {
        List<String> _xifexpression = null;
        String _value = it.getValue();
        boolean _tripleNotEquals = (_value != null);
        if (_tripleNotEquals) {
          String _key = it.getKey();
          String _value_1 = it.getValue();
          _xifexpression = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_key, _value_1));
        } else {
          String _key_1 = it.getKey();
          _xifexpression = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_key_1));
        }
        return _xifexpression;
      };
      return ListExtensions.<Pair<String, String>, List<String>>map(this.pairs, _function);
    }
  }

  private static final String NO_VALUE_STRING = "<NO VALUE GIVEN>";

  private final ProcessingConfiguration configuration;

  private final ProgrammaticIntermediateModelTransformation programmaticIntermediateTransformation;

  private final String domainModelFileTypeId;

  private final String serviceModelFileTypeId;

  private final String operationModelFileTypeId;

  private final ArrayList<String> collectedWarnings = CollectionLiterals.<String>newArrayList();

  /**
   * Constructor
   */
  public CommandLineGenerator(final ProcessingConfiguration configuration) {
    this.configuration = configuration;
    this.programmaticIntermediateTransformation = this.getProgrammaticIntermediateTransformation(configuration);
    this.domainModelFileTypeId = ServiceModelTransformationStrategy.DATA_MODEL_FILE_TYPE_ID;
    AbstractUiModelTransformationStrategy _strategy = null;
    if (this.programmaticIntermediateTransformation!=null) {
      _strategy=this.programmaticIntermediateTransformation.getStrategy();
    }
    String _serviceModelFileTypeId = null;
    if (_strategy!=null) {
      _serviceModelFileTypeId=this.getServiceModelFileTypeId(_strategy);
    }
    this.serviceModelFileTypeId = _serviceModelFileTypeId;
    this.operationModelFileTypeId = OperationModelTransformationStrategy.OPERATION_MODEL_FILE_TYPE_ID;
  }

  /**
   * Get the programmatic intermediate transformation applicable to the source model file of the
   * given processing configuration
   */
  private ProgrammaticIntermediateModelTransformation getProgrammaticIntermediateTransformation(final ProcessingConfiguration configuration) {
    final Function1<Argument, Boolean> _function = (Argument it) -> {
      return Boolean.valueOf(AbstractIntermediateModelArgumentTypeWithEnumValue.class.isAssignableFrom(it.getType().getClass()));
    };
    final boolean intermediateTransformatioRequired = IterableExtensions.<Argument>exists(configuration.getArguments(), _function);
    ProgrammaticIntermediateModelTransformation _xifexpression = null;
    if ((!intermediateTransformatioRequired)) {
      _xifexpression = null;
    } else {
      ProgrammaticIntermediateModelTransformation _xifexpression_1 = null;
      IFile _sourceModelFile = configuration.getSourceModelFile();
      boolean _tripleNotEquals = (_sourceModelFile != null);
      if (_tripleNotEquals) {
        IFile _sourceModelFile_1 = configuration.getSourceModelFile();
        _xifexpression_1 = new ProgrammaticIntermediateModelTransformation(_sourceModelFile_1);
      } else {
        throw new IllegalArgumentException((("Processing configuration specifies arguments " + 
          "requiring intermediate model representations but no source model file for ") + 
          "intermediate transformations was given"));
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }

  /**
   * Get the file type ID for LEMMA service models from the kind of the given transformation
   * strategy
   */
  private String getServiceModelFileTypeId(final AbstractUiModelTransformationStrategy strategy) {
    if ((strategy == null)) {
      return null;
    }
    String _switchResult = null;
    boolean _matched = false;
    if (strategy instanceof ServiceModelTransformationStrategy) {
      _matched=true;
      _switchResult = ServiceModelTransformationStrategy.SERVICE_MODEL_FILE_TYPE_ID;
    }
    if (!_matched) {
      if (strategy instanceof OperationModelTransformationStrategy) {
        _matched=true;
        _switchResult = OperationModelTransformationStrategy.SERVICE_MODEL_FILE_TYPE_ID;
      }
    }
    if (!_matched) {
      String _simpleName = strategy.getClass().getSimpleName();
      String _plus = (("Service model file type identifier not " + 
        "determinable for intermediate transformation strategy ") + _simpleName);
      throw new IllegalArgumentException(_plus);
    }
    return _switchResult;
  }

  /**
   * Get the coherent parts of the commandline and related warnings
   */
  public final Pair<CommandLineGenerator.CoherentCommandLineParts, List<String>> generateCoherentCommandLineParts() {
    this.collectedWarnings.clear();
    final CommandLineGenerator.CoherentCommandLineParts commandLineParts = new CommandLineGenerator.CoherentCommandLineParts();
    String _xifexpression = null;
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(this.configuration.getProcessorExecutablePath());
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      _xifexpression = this.quoteIfContainsSpaces(this.configuration.getProcessorExecutablePath());
    } else {
      String _xifexpression_1 = null;
      ProcessorExecutableType _processorExecutableType = this.configuration.getProcessorExecutableType();
      boolean _notEquals = (!Objects.equal(_processorExecutableType, 
        ProcessorExecutableType.RAW_EXECUTABLE));
      if (_notEquals) {
        _xifexpression_1 = "<NO PROCESSOR EXECUTABLE PATH SPECIFIED>";
      } else {
        _xifexpression_1 = "";
      }
      _xifexpression = _xifexpression_1;
    }
    final String processorExecutablePath = _xifexpression;
    final Pair<? extends List<String>, ? extends List<List<String>>> executionCommandParts = this.generateExecutionCommandParts(this.configuration);
    commandLineParts.addExecutionCommandPart(executionCommandParts.getKey());
    commandLineParts.addExecutionCommandParts(executionCommandParts.getValue());
    commandLineParts.addExecutionCommandPart(processorExecutablePath);
    final BiConsumer<Argument, CommandLineGenerator.ParameterValues> _function = (Argument __, CommandLineGenerator.ParameterValues parameterValues) -> {
      commandLineParts.addParameterValues(parameterValues);
    };
    this.determineArgumentParameterValues(this.configuration).forEach(_function);
    return Pair.<CommandLineGenerator.CoherentCommandLineParts, List<String>>of(commandLineParts, this.collectedWarnings);
  }

  /**
   * Quote the given String if it contains spaces. In case the String is null or empty, return an
   * unquoted placeholder String like "<NO VALUE GIVEN>".
   */
  private String quoteIfContainsSpaces(final String s) {
    String _xifexpression = null;
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(s);
    if (_isNullOrEmpty) {
      _xifexpression = CommandLineGenerator.NO_VALUE_STRING;
    } else {
      String _xifexpression_1 = null;
      boolean _contains = s.contains(" ");
      if (_contains) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("\"");
        _builder.append(s);
        _builder.append("\"");
        _xifexpression_1 = _builder.toString();
      } else {
        _xifexpression_1 = s;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }

  /**
   * Generate the execution command parts for the given model processing configuration
   */
  private Pair<? extends List<String>, ? extends List<List<String>>> generateExecutionCommandParts(final ProcessingConfiguration configuration) {
    String _basicProcessorExecutionCommand = configuration.getBasicProcessorExecutionCommand();
    String _trim = null;
    if (_basicProcessorExecutionCommand!=null) {
      _trim=_basicProcessorExecutionCommand.trim();
    }
    String _quoteIfContainsSpaces = null;
    if (_trim!=null) {
      _quoteIfContainsSpaces=this.quoteIfContainsSpaces(_trim);
    }
    final String command = _quoteIfContainsSpaces;
    if ((command == null)) {
      List<List<String>> _emptyList = CollectionLiterals.<List<String>>emptyList();
      return Pair.<List<String>, List<List<String>>>of(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("<NO BASIC EXECUTION COMMAND SPECIFIED>")), _emptyList);
    }
    Pair<ArrayList<String>, ? extends List<List<String>>> _switchResult = null;
    ProcessorExecutableType _processorExecutableType = configuration.getProcessorExecutableType();
    if (_processorExecutableType != null) {
      switch (_processorExecutableType) {
        case LOCAL_DOCKER_IMAGE:
          _switchResult = this.generateDockerExecutionCommandParts(configuration, command);
          break;
        case LOCAL_JAVA_PROGRAM:
          ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList(command, 
            "--add-opens", 
            "java.base/java.lang=ALL-UNNAMED", 
            "-jar");
          List<List<String>> _emptyList_1 = CollectionLiterals.<List<String>>emptyList();
          _switchResult = Pair.<ArrayList<String>, List<List<String>>>of(_newArrayList, _emptyList_1);
          break;
        case RAW_EXECUTABLE:
          ArrayList<String> _newArrayList_1 = CollectionLiterals.<String>newArrayList(command);
          List<List<String>> _emptyList_2 = CollectionLiterals.<List<String>>emptyList();
          _switchResult = Pair.<ArrayList<String>, List<List<String>>>of(_newArrayList_1, _emptyList_2);
          break;
        default:
          break;
      }
    }
    return _switchResult;
  }

  /**
   * Generate the execution command parts for local Docker images. Note that the method will also
   * add potential warnings to the state of the CommandLineGenerator object.
   */
  private Pair<ArrayList<String>, ArrayList<List<String>>> generateDockerExecutionCommandParts(final ProcessingConfiguration configuration, final String command) {
    final ArrayList<String> commandParts = CollectionLiterals.<String>newArrayList(command, "run", "-i");
    final ArrayList<List<String>> additionalCommandParameters = CollectionLiterals.<List<String>>newArrayList();
    try {
      final String userId = this.getUserId();
      final String groupId = this.getUserGroupId();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(userId);
      _builder.append(":");
      _builder.append(groupId);
      additionalCommandParameters.add(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("-u", _builder.toString())));
    } catch (final Throwable _t) {
      if (_t instanceof CommandLineGenerator.UserInfoNotDeterminable) {
        final CommandLineGenerator.UserInfoNotDeterminable ex = (CommandLineGenerator.UserInfoNotDeterminable)_t;
        String message = ex.getMessage();
        boolean _endsWith = message.endsWith(".");
        boolean _not = (!_endsWith);
        if (_not) {
          message = (message + ".");
        }
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(message);
        _builder_1.append(" Docker container will run as \"root\".");
        this.collectedWarnings.add(_builder_1.toString());
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    final String projectPath = configuration.getSourceModelFile().getProject().getLocation().makeAbsolute().toString();
    final HashSet<String> volumePaths = CollectionLiterals.<String>newHashSet(projectPath);
    final Consumer<Argument> _function = (Argument it) -> {
      ArgumentTypeIdentifier _identifier = it.getType().getIdentifier();
      boolean _equals = Objects.equal(_identifier, FolderArgumentType.IDENTIFIER);
      if (_equals) {
        volumePaths.add(it.getValue());
      } else {
        ArgumentTypeIdentifier _identifier_1 = it.getType().getIdentifier();
        boolean _equals_1 = Objects.equal(_identifier_1, FileArgumentType.IDENTIFIER);
        if (_equals_1) {
          String _value = it.getValue();
          final String absolutePath = new File(_value).getAbsolutePath();
          volumePaths.add(FilenameUtils.getFullPathNoEndSeparator(absolutePath));
        }
      }
    };
    configuration.getArguments().forEach(_function);
    final Consumer<String> _function_1 = (String it) -> {
      this.addAsDockerVolumeParameter(additionalCommandParameters, it);
    };
    volumePaths.forEach(_function_1);
    return Pair.<ArrayList<String>, ArrayList<List<String>>>of(commandParts, additionalCommandParameters);
  }

  /**
   * Get the ID of the current user via the "id -u" command
   */
  private String getUserId() {
    return this.getUserInfo("u", "User ID");
  }

  /**
   * Get information about the current user via the "id" command. The idCommandFlag parameter
   * determines the flag (without a preceding dash) to invoke the "id" command, e.g., "u" for the
   * retrieval of the user's ID. The printablePart parameter determines a printable version of the
   * retrieved information, e.g., "User ID", to be used in error messages.
   */
  private String getUserInfo(final String idCommandFlag, final String printablePart) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("id -");
      _builder.append(idCommandFlag);
      final String command = _builder.toString();
      Pair<Integer, String> _xtrycatchfinallyexpression = null;
      try {
        _xtrycatchfinallyexpression = Utils.executeShellCommandBlocking(command, 50, 4);
      } catch (final Throwable _t) {
        if (_t instanceof IOException) {
          final IOException ex = (IOException)_t;
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append(printablePart);
          _builder_1.append(" not determinable: ");
          String _message = ex.getMessage();
          _builder_1.append(_message);
          throw new CommandLineGenerator.UserInfoNotDeterminable(_builder_1.toString());
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      final Pair<Integer, String> userInfoResult = _xtrycatchfinallyexpression;
      final String userInfo = userInfoResult.getValue().trim();
      Integer _key = userInfoResult.getKey();
      boolean _notEquals = ((_key).intValue() != 0);
      if (_notEquals) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(printablePart);
        _builder_1.append(" not determinable. Execution ");
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("of \"");
        _builder_2.append(command);
        _builder_2.append("\" returned with exit code ");
        Integer _key_1 = userInfoResult.getKey();
        _builder_2.append(_key_1);
        _builder_2.append(": ");
        String _plus = (_builder_1.toString() + _builder_2);
        String _elvis = null;
        if (userInfo != null) {
          _elvis = userInfo;
        } else {
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("<No output from ");
          _builder_3.append(command);
          _builder_3.append(">");
          _elvis = _builder_3.toString();
        }
        String _plus_1 = (_plus + _elvis);
        throw new CommandLineGenerator.UserInfoNotDeterminable(_plus_1);
      }
      return userInfo;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Get the ID of the current user via the "id -g" command
   */
  private String getUserGroupId() {
    return this.getUserInfo("g", "User group ID");
  }

  /**
   * Add the given path as a Docker volume parameter to the given list of coherent parameters
   */
  private boolean addAsDockerVolumeParameter(final List<List<String>> parameters, final String path) {
    boolean _xblockexpression = false;
    {
      String folder = path;
      final File fobj = new File(folder);
      boolean _isDirectory = fobj.isDirectory();
      boolean _not = (!_isDirectory);
      if (_not) {
        folder = FilenameUtils.getFullPathNoEndSeparator(fobj.getAbsolutePath());
      }
      final ArrayList<String> volumeParameterParts = CollectionLiterals.<String>newArrayList("-v");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(folder);
      _builder.append(":");
      _builder.append(folder);
      volumeParameterParts.add(_builder.toString());
      _xblockexpression = parameters.add(volumeParameterParts);
    }
    return _xblockexpression;
  }

  /**
   * Determine the values for the arguments of the execution of a model processing configuration
   */
  private LinkedHashMap<Argument, CommandLineGenerator.ParameterValues> determineArgumentParameterValues(final ProcessingConfiguration configuration) {
    final LinkedHashMap<Argument, CommandLineGenerator.ParameterValues> argumentParameterValues = CollectionLiterals.<Argument, CommandLineGenerator.ParameterValues>newLinkedHashMap();
    final Consumer<Argument> _function = (Argument argument) -> {
      CommandLineGenerator.ParameterValues _switchResult = null;
      AbstractArgumentType _type = argument.getType();
      boolean _matched = false;
      if (_type instanceof FileArgumentType || _type instanceof FolderArgumentType) {
        _matched=true;
        _switchResult = this.generateFileSystemParameterValues(argument);
      }
      if (!_matched) {
        if (_type instanceof IntermediateModelArgumentType) {
          _matched=true;
          _switchResult = this.generateIntermediateModelParameterValues(argument);
        }
      }
      if (!_matched) {
        if (_type instanceof IntermediateModelOfFirstImportArgumentType) {
          _matched=true;
          _switchResult = this.generateIntermediateModelOfFirstImportParameterValues(argument);
        }
      }
      if (!_matched) {
        if (_type instanceof IntermediateModelsOfAllImportsArgumentType) {
          _matched=true;
          _switchResult = this.generateIntermediateModelsOfAllImportsParameterValues(argument);
        }
      }
      if (!_matched) {
        if (_type instanceof IntermediateModelOfImportWithAliasArgumentType) {
          _matched=true;
          _switchResult = this.generateIntermediateModelOfImportWithAliasParameterValues(argument);
        }
      }
      if (!_matched) {
        if (_type instanceof RawStringArgumentType) {
          _matched=true;
          _switchResult = this.generateRawStringParameterValues(argument);
        }
      }
      if (!_matched) {
        if (_type instanceof SourceModelArgumentType) {
          _matched=true;
          _switchResult = this.generateSourceModelParameterValues(argument);
        }
      }
      if (!_matched) {
        if (_type instanceof StringPairArgumentType) {
          _matched=true;
          _switchResult = this.generateStringPairParameterValues(argument);
        }
      }
      if (!_matched) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("type ");
        String _name = argument.getType().getName();
        _builder.append(_name);
        _builder.append(" not supported");
        String _plus = ("Value determination for argument " + _builder);
        throw new IllegalArgumentException(_plus);
      }
      final CommandLineGenerator.ParameterValues parameterValues = _switchResult;
      argumentParameterValues.put(argument, parameterValues);
    };
    configuration.getArguments().forEach(_function);
    return argumentParameterValues;
  }

  /**
   * Generate parameter values for an Argument that represents a filesystem element. The result
   * will be a ParameterValues instance that consists of the Argument and its value, which is
   * interpreted as a path to a filesystem element. That is, the value string will be quoted if it
   * contains spaces.
   */
  private CommandLineGenerator.ParameterValues generateFileSystemParameterValues(final Argument argument) {
    String _value = argument.getValue();
    String _quoteIfContainsSpaces = null;
    if (_value!=null) {
      _quoteIfContainsSpaces=this.quoteIfContainsSpaces(_value);
    }
    String _valueForCommandLine = null;
    if (_quoteIfContainsSpaces!=null) {
      _valueForCommandLine=this.getValueForCommandLine(_quoteIfContainsSpaces);
    }
    return new CommandLineGenerator.ParameterValues(argument, _valueForCommandLine);
  }

  /**
   * Helper to map the given String to a value applicable on the commandline. If the String is not
   * null or empty, the result will be the String itself. Otherwise, the helper returns a
   * non-empty placeholder String like "<NO VALUE GIVEN>".
   */
  private String getValueForCommandLine(final String value) {
    String _xifexpression = null;
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(value);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      _xifexpression = value;
    } else {
      _xifexpression = CommandLineGenerator.NO_VALUE_STRING;
    }
    return _xifexpression;
  }

  /**
   * Generate parameter values for an Argument that represents the intermediate representation of
   * the model processing configuration's source model file. The result will be a ParameterValues
   * instance that consists of the Argument and a value that is the absolute (possibly quoted)
   * target path of the intermediate model to be produced from the model processing
   * configuration's source model file.
   */
  private CommandLineGenerator.ParameterValues generateIntermediateModelParameterValues(final Argument argument) {
    final String value = this.quoteIfContainsSpaces(this.getAbsoluteTransformationTargetPath(this.programmaticIntermediateTransformation.getRootModelFile()));
    return new CommandLineGenerator.ParameterValues(argument, value);
  }

  /**
   * Helper to get the absolute target path of an intermediate transformation of the given model
   * file. The target path consists of the path to the folder storing the model file (which, by
   * definition, is a location in an Eclipse project) and the transformation target path specified
   * by the model file (which, by definition, is a relative path).
   */
  private String getAbsoluteTransformationTargetPath(final ModelFile modelFile) {
    final String transformationTargetPath = modelFile.getTransformationTargetPath();
    if ((transformationTargetPath == null)) {
      return null;
    }
    IFile _file = null;
    if (modelFile!=null) {
      _file=modelFile.getFile();
    }
    IProject _project = null;
    if (_file!=null) {
      _project=_file.getProject();
    }
    IPath _location = null;
    if (_project!=null) {
      _location=_project.getLocation();
    }
    IPath _makeAbsolute = null;
    if (_location!=null) {
      _makeAbsolute=_location.makeAbsolute();
    }
    File _file_1 = null;
    if (_makeAbsolute!=null) {
      _file_1=_makeAbsolute.toFile();
    }
    final File projectFolder = _file_1;
    String _parent = null;
    if (projectFolder!=null) {
      _parent=projectFolder.getParent();
    }
    final String parentFolder = _parent;
    String _xifexpression = null;
    if ((parentFolder != null)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(parentFolder);
      _builder.append(transformationTargetPath);
      _xifexpression = FilenameUtils.separatorsToSystem(_builder.toString());
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }

  /**
   * Generate parameter values for an Argument that represents the intermediate representation of
   * the model first imported by the model processing configuration's source model file. The
   * result will be a ParameterValues instance that consists of the Argument and a value that is
   * the absolute (possibly quoted) target path of the intermediate model to be produced from the
   * first imported model.
   */
  private CommandLineGenerator.ParameterValues generateIntermediateModelOfFirstImportParameterValues(final Argument argument) {
    final ImportedIntermediateModelKind modelKind = ImportedIntermediateModelKind.valueOf(argument.getValue());
    ModelFile _switchResult = null;
    if (modelKind != null) {
      switch (modelKind) {
        case FIRST_DOMAIN_MODEL:
          _switchResult = this.getFirstRootModelChildOfType(this.domainModelFileTypeId);
          break;
        case FIRST_OPERATION_MODEL:
          _switchResult = this.getFirstRootModelChildOfType(this.operationModelFileTypeId);
          break;
        case FIRST_SERVICE_MODEL:
          _switchResult = this.getFirstRootModelChildOfType(this.serviceModelFileTypeId);
          break;
        default:
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("kind ");
          _builder.append(modelKind);
          _builder.append(" is not supported");
          String _plus = ("Retrieving the first imported model of " + _builder);
          throw new IllegalArgumentException(_plus);
      }
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("kind ");
      _builder.append(modelKind);
      _builder.append(" is not supported");
      String _plus = ("Retrieving the first imported model of " + _builder);
      throw new IllegalArgumentException(_plus);
    }
    final ModelFile firstImportedModel = _switchResult;
    CommandLineGenerator.ParameterValues _xifexpression = null;
    if ((firstImportedModel != null)) {
      CommandLineGenerator.ParameterValues _xblockexpression = null;
      {
        final String value = this.quoteIfContainsSpaces(this.getAbsoluteTransformationTargetPath(firstImportedModel));
        _xblockexpression = new CommandLineGenerator.ParameterValues(argument, value);
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }

  /**
   * Helper to get the first imported model of the model processing configuration's source model
   * file with the given model file type ID and as a ModeFile instance
   */
  private ModelFile getFirstRootModelChildOfType(final String modelFileTypeId) {
    final Function1<ModelFile, Boolean> _function = (ModelFile it) -> {
      String _fileType = it.getFileTypeDescription().getFileType();
      return Boolean.valueOf(Objects.equal(_fileType, modelFileTypeId));
    };
    return IterableExtensions.<ModelFile>findFirst(this.programmaticIntermediateTransformation.getRootModelFile().getChildren(), _function);
  }

  /**
   * Generate parameter values for an Argument that represents the intermediate versions of all
   * models imported by the model processing configuration's source model file. The result will be
   * a ParameterValues instance that consists of as many Argument-value pairs as there are
   * imported models. Each value in such a pair is the absolute (possibly quoted) target path of
   * the intermediate model to be produced from an imported model.
   */
  private CommandLineGenerator.ParameterValues generateIntermediateModelsOfAllImportsParameterValues(final Argument argument) {
    final AllImportedIntermediateModelKinds modelKind = AllImportedIntermediateModelKinds.valueOf(argument.getValue());
    Iterable<ModelFile> _switchResult = null;
    if (modelKind != null) {
      switch (modelKind) {
        case ALL_DOMAIN_MODELS:
          _switchResult = this.getRootModelChildrenOfType(this.domainModelFileTypeId);
          break;
        case ALL_OPERATION_MODELS:
          _switchResult = this.getRootModelChildrenOfType(this.operationModelFileTypeId);
          break;
        case ALL_SERVICE_MODELS:
          _switchResult = this.getRootModelChildrenOfType(this.serviceModelFileTypeId);
          break;
        default:
          StringConcatenation _builder = new StringConcatenation();
          _builder.append(modelKind);
          _builder.append(" is not supported");
          String _plus = ("Retrieving all imported models of kind " + _builder);
          throw new IllegalArgumentException(_plus);
      }
    } else {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(modelKind);
      _builder.append(" is not supported");
      String _plus = ("Retrieving all imported models of kind " + _builder);
      throw new IllegalArgumentException(_plus);
    }
    final Iterable<ModelFile> importedModels = _switchResult;
    final CommandLineGenerator.ParameterValues parameterValues = new CommandLineGenerator.ParameterValues();
    final Consumer<ModelFile> _function = (ModelFile it) -> {
      final String value = this.quoteIfContainsSpaces(this.getAbsoluteTransformationTargetPath(it));
      parameterValues.add(argument, value);
    };
    importedModels.forEach(_function);
    return parameterValues;
  }

  /**
   * Helper to get the children of the model processing configuration's source model file with the
   * given model file type ID and as ModeFile instances
   */
  private Iterable<ModelFile> getRootModelChildrenOfType(final String modelFileTypeId) {
    final Function1<ModelFile, Boolean> _function = (ModelFile it) -> {
      String _fileType = it.getFileTypeDescription().getFileType();
      return Boolean.valueOf(Objects.equal(_fileType, modelFileTypeId));
    };
    return IterableExtensions.<ModelFile>filter(this.programmaticIntermediateTransformation.getRootModelFile().getChildren(), _function);
  }

  /**
   * Generate parameter values for an Argument that represents the intermediate representation of
   * the model imported by the model processing configuration's source model file with a specified
   * alias. The result will be a ParameterValues instance that consists of the Argument and a
   * value that is the absolute (possibly quoted) target path of the intermediate model to be
   * produced from the imported model.
   */
  private CommandLineGenerator.ParameterValues generateIntermediateModelOfImportWithAliasParameterValues(final Argument argument) {
    final Function1<ModelFile, Boolean> _function = (ModelFile it) -> {
      String _importAlias = it.getImportAlias();
      String _value = argument.getValue();
      return Boolean.valueOf(Objects.equal(_importAlias, _value));
    };
    final ModelFile importedModel = IterableExtensions.<ModelFile>findFirst(this.programmaticIntermediateTransformation.getRootModelFile().getChildren(), _function);
    CommandLineGenerator.ParameterValues _xifexpression = null;
    if ((importedModel != null)) {
      CommandLineGenerator.ParameterValues _xblockexpression = null;
      {
        final String value = this.quoteIfContainsSpaces(this.getAbsoluteTransformationTargetPath(importedModel));
        _xblockexpression = new CommandLineGenerator.ParameterValues(argument, value);
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }

  /**
   * Generate parameter values for an Argument that represents a raw string. The result will be a
   * ParameterValues instance that solely consists of the Argument.
   */
  private CommandLineGenerator.ParameterValues generateRawStringParameterValues(final Argument argument) {
    return new CommandLineGenerator.ParameterValues(argument);
  }

  /**
   * Generate parameter values for an Argument that represents the model processing
   * configuration's source model file. The result will be a ParameterValues instance that
   * consists of the Argument and a value that is the absolute (possibly quoted) path of the
   * source model file.
   */
  private CommandLineGenerator.ParameterValues generateSourceModelParameterValues(final Argument argument) {
    IFile _sourceModelFile = this.configuration.getSourceModelFile();
    IPath _rawLocation = null;
    if (_sourceModelFile!=null) {
      _rawLocation=_sourceModelFile.getRawLocation();
    }
    IPath _makeAbsolute = null;
    if (_rawLocation!=null) {
      _makeAbsolute=_rawLocation.makeAbsolute();
    }
    String _string = null;
    if (_makeAbsolute!=null) {
      _string=_makeAbsolute.toString();
    }
    String _quoteIfContainsSpaces = null;
    if (_string!=null) {
      _quoteIfContainsSpaces=this.quoteIfContainsSpaces(_string);
    }
    final String absoluteSourceModelPath = _quoteIfContainsSpaces;
    return new CommandLineGenerator.ParameterValues(argument, absoluteSourceModelPath);
  }

  /**
   * Generate parameter values for an Argument that represents a string pair. The result will be a
   * ParameterValues instance that consists of the Argument and its value, which will be quoted if
   * it contains spaces, or replaced by a placeholder if it is null or empty.
   */
  private CommandLineGenerator.ParameterValues generateStringPairParameterValues(final Argument argument) {
    String _value = argument.getValue();
    String _quoteIfContainsSpaces = null;
    if (_value!=null) {
      _quoteIfContainsSpaces=this.quoteIfContainsSpaces(_value);
    }
    String _valueForCommandLine = null;
    if (_quoteIfContainsSpaces!=null) {
      _valueForCommandLine=this.getValueForCommandLine(_quoteIfContainsSpaces);
    }
    return new CommandLineGenerator.ParameterValues(argument, _valueForCommandLine);
  }

  /**
   * Get a printable representation of the coherent commandline parts joined by the given
   * delimiter
   */
  public final String toPrintableCommandLine(final CommandLineGenerator.CoherentCommandLineParts coherentCommandLineParts, final String delimiter) {
    final Function1<List<String>, String> _function = (List<String> it) -> {
      return IterableExtensions.join(it, " ");
    };
    return IterableExtensions.join(ListExtensions.<List<String>, String>map(coherentCommandLineParts.mergeParts(), _function), delimiter);
  }

  /**
   * Get a representation of the coherent commandline parts that is executable. By contrast to a
   * printable representation, an executable representation is a List consisting of Strings that
   * are commandline parts and can be passed to a Java ProcessBuilder.
   */
  public final List<String> toExecutableCommandLine(final CommandLineGenerator.CoherentCommandLineParts coherentCommandLineParts) {
    final Function1<String, String> _function = (String it) -> {
      return this.removeSurroundingQuotes(it);
    };
    return IterableExtensions.<String>toList(ListExtensions.<String, String>map(coherentCommandLineParts.mergeAndFlattenParts(), _function));
  }

  /**
   * Remove quotes around a given String
   */
  private String removeSurroundingQuotes(final String s) {
    String _xifexpression = null;
    if ((s.startsWith("\"") && s.endsWith("\""))) {
      int _length = s.length();
      int _minus = (_length - 1);
      _xifexpression = s.substring(1, _minus);
    } else {
      _xifexpression = s;
    }
    return _xifexpression;
  }
}
