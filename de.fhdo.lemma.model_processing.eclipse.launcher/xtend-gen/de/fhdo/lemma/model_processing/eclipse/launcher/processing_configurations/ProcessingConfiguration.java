package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations;

import com.google.common.base.Objects;
import de.fhdo.lemma.model_processing.eclipse.launcher.LaunchConfigurationConstants;
import de.fhdo.lemma.model_processing.eclipse.launcher.ModelElementWithPropertyChangeSupport;
import de.fhdo.lemma.model_processing.eclipse.launcher.Utils;
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Domain concept for model processing configurations.
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class ProcessingConfiguration extends ModelElementWithPropertyChangeSupport implements Cloneable {
  /**
   * Class to make information about a model processor accessible in a coherent manner
   */
  private static class ProcessorInformation {
    @Accessors(AccessorType.PUBLIC_GETTER)
    private final ProcessorExecutableType processorExecutableType;
    
    @Accessors(AccessorType.PUBLIC_GETTER)
    private final String basicProcessorExecutionCommand;
    
    @Accessors(AccessorType.PUBLIC_GETTER)
    private final String processorExecutablePath;
    
    public ProcessorInformation(final ProcessorExecutableType processorExecutableType, final String basicProcessorExecutionCommand, final String processorExecutablePath) {
      this.processorExecutableType = processorExecutableType;
      this.basicProcessorExecutionCommand = basicProcessorExecutionCommand;
      this.processorExecutablePath = processorExecutablePath;
    }
    
    @Pure
    public ProcessorExecutableType getProcessorExecutableType() {
      return this.processorExecutableType;
    }
    
    @Pure
    public String getBasicProcessorExecutionCommand() {
      return this.basicProcessorExecutionCommand;
    }
    
    @Pure
    public String getProcessorExecutablePath() {
      return this.processorExecutablePath;
    }
  }
  
  private static final String XML_CONFIGURATION_ELEMENT = "processingConfiguration";
  
  private static final String XML_CONFIGURATION_ATTR_SOURCE_MODEL_PROJECT_NAME = "sourceModelProjectName";
  
  private static final String XML_CONFIGURATION_ATTR_SOURCE_MODEL_FILE_PATH = "sourceModelFilePath";
  
  private static final String XML_PROCESSOR_ELEMENT = "processor";
  
  private static final String XML_PROCESSOR_TYPE_ELEMENT = "type";
  
  private static final String XML_PROCESSOR_BASIC_EXECUTION_COMMAND_ELEMENT = "basicExecutionCommand";
  
  private static final String XML_PROCESSOR_PATH_ELEMENT = "path";
  
  private static final String XML_ARGUMENTS_ELEMENT = "arguments";
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String sourceModelProjectName;
  
  /**
   * Set the name of the source model project and fire a corresponding property change event
   */
  public final void setSourceModelProjectName(final String sourceModelProjectName) {
    this.firePropertyChange("sourceModelProjectName", this.sourceModelProjectName, 
      this.sourceModelProjectName = sourceModelProjectName);
  }
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String sourceModelFilePath;
  
  /**
   * Set the path of the source model file and fire a corresponding property change event
   */
  public final void setSourceModelFilePath(final String sourceModelFilePath) {
    this.firePropertyChange("sourceModelFilePath", this.sourceModelFilePath, 
      this.sourceModelFilePath = sourceModelFilePath);
  }
  
  /**
   * Get the source model file as an IFile in the current Eclipse workspace. Return null in case
   * the name of the source model project or the path to the source model are invalid.
   */
  public final IFile getSourceModelFile() {
    try {
      ProcessingConfiguration.validateSourceModelProjectName(this.sourceModelProjectName);
      ProcessingConfiguration.validateSourceModelFilePath(this.sourceModelProjectName, this.sourceModelFilePath);
    } catch (final Throwable _t) {
      if (_t instanceof IllegalArgumentException) {
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return Utils.findFileInWorkspaceProject(this.sourceModelProjectName, this.sourceModelFilePath);
  }
  
  @Accessors
  private ProcessorExecutableType processorExecutableType;
  
  /**
   * Set the type of the model processor executable and fire a corresponding property change event
   */
  public final void setProcessorExecutableType(final ProcessorExecutableType processorExecutableType) {
    this.firePropertyChange("processorExecutableType", this.processorExecutableType, 
      this.processorExecutableType = processorExecutableType);
  }
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String basicProcessorExecutionCommand;
  
  /**
   * Set the basic model processor execution command and fire a corresponding property change
   * event
   */
  public final void setBasicProcessorExecutionCommand(final String basicProcessorExecutionCommand) {
    this.firePropertyChange("basicProcessorExecutionCommand", this.basicProcessorExecutionCommand, 
      this.basicProcessorExecutionCommand = basicProcessorExecutionCommand);
  }
  
  @Accessors
  private String processorExecutablePath;
  
  /**
   * Set the path to the model processor executable and fire a corresponding property change event
   */
  public final void setProcessorExecutablePath(final String processorExecutablePath) {
    this.firePropertyChange("processorExecutablePath", this.processorExecutablePath, 
      this.processorExecutablePath = processorExecutablePath);
  }
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private ArrayList<Argument> arguments = CollectionLiterals.<Argument>newArrayList();
  
  /**
   * Two model processing configurations are equal when they point to the same source model, have
   * the same model processor configuration, and the same entries in their execution arguments
   */
  @Override
  public final boolean equals(final Object o) {
    boolean _xifexpression = false;
    if ((o == this)) {
      _xifexpression = true;
    } else {
      boolean _xifexpression_1 = false;
      if ((!(o instanceof ProcessingConfiguration))) {
        _xifexpression_1 = false;
      } else {
        boolean _xblockexpression = false;
        {
          final ProcessingConfiguration otherConfig = ((ProcessingConfiguration) o);
          _xblockexpression = (((((Objects.equal(this.sourceModelProjectName, otherConfig.sourceModelProjectName) && 
            Objects.equal(this.sourceModelFilePath, otherConfig.sourceModelFilePath)) && 
            Objects.equal(this.processorExecutableType, otherConfig.processorExecutableType)) && 
            Objects.equal(this.basicProcessorExecutionCommand, otherConfig.basicProcessorExecutionCommand)) && 
            Objects.equal(this.processorExecutablePath, otherConfig.processorExecutablePath)) && 
            Utils.<Argument>equalLists(this.arguments, otherConfig.arguments));
        }
        _xifexpression_1 = _xblockexpression;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  /**
   * Clone the configuration which also entails the cloning of its execution arguments
   */
  @Override
  public Object clone() {
    try {
      Object _clone = super.clone();
      final ProcessingConfiguration clone = ((ProcessingConfiguration) _clone);
      final Function1<Argument, Argument> _function = (Argument it) -> {
        Object _clone_1 = it.clone();
        return ((Argument) _clone_1);
      };
      clone.arguments = CollectionLiterals.<Argument>newArrayList(((Argument[])Conversions.unwrapArray(ListExtensions.<Argument, Argument>map(this.arguments, _function), Argument.class)));
      return clone;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Deserialize the model processing configuration from its XML representation stored in the
   * given ILaunchConfiguration
   */
  public static ProcessingConfiguration deserializeFrom(final ILaunchConfiguration launchConfiguration) {
    try {
      final String xml = launchConfiguration.getAttribute(LaunchConfigurationConstants.PROCESSING_CONFIGURATION_ATTRIBUTE, "");
      boolean _isEmpty = xml.isEmpty();
      if (_isEmpty) {
        return null;
      }
      final Element root = Utils.getRootElementWithTag(Utils.parseXmlString(xml), ProcessingConfiguration.XML_CONFIGURATION_ELEMENT);
      if ((root == null)) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("configuration: Root XML element ");
        _builder.append(ProcessingConfiguration.XML_CONFIGURATION_ELEMENT);
        _builder.append(" not found");
        String _plus = ("Error during deserialization of processing " + _builder);
        throw new IllegalArgumentException(_plus);
      }
      final ProcessingConfiguration.ProcessorInformation processorInformation = ProcessingConfiguration.deserializeProcessorInformation(root);
      String _attribute = root.getAttribute(ProcessingConfiguration.XML_CONFIGURATION_ATTR_SOURCE_MODEL_PROJECT_NAME);
      String _attribute_1 = root.getAttribute(ProcessingConfiguration.XML_CONFIGURATION_ATTR_SOURCE_MODEL_FILE_PATH);
      final ProcessingConfiguration configuration = new ProcessingConfiguration(_attribute, _attribute_1, 
        processorInformation.processorExecutableType, 
        processorInformation.processorExecutablePath, 
        processorInformation.basicProcessorExecutionCommand);
      final Supplier<Argument> _function = () -> {
        return new Argument();
      };
      configuration.arguments = ProcessingConfiguration.<Argument>initializeItems(root, ProcessingConfiguration.XML_ARGUMENTS_ELEMENT, 
        Argument.XML_ARGUMENT_ELEMENT, _function);
      return configuration;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Helper to initialize a List of ProcessingConfigurationItem instances that are stored as XML
   * sub-elements of an XML parent element which itself is a sub-element of a given XML root
   * element
   */
  private static <T extends ProcessingConfigurationItem> ArrayList<T> initializeItems(final Element root, final String itemParentTag, final String itemTag, final Supplier<T> constructItemInstance) {
    final ArrayList<T> items = CollectionLiterals.<T>newArrayList();
    final Element childElement = Utils.findChildElementWithTag(root, itemParentTag);
    final NodeList elements = childElement.getElementsByTagName(itemTag);
    int _length = elements.getLength();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _length, true);
    for (final Integer n : _doubleDotLessThan) {
      {
        final T item = constructItemInstance.get();
        Node _item = elements.item((n).intValue());
        item.deserializeFrom(((Element) _item));
        items.add(item);
      }
    }
    return items;
  }
  
  /**
   * Helper to deserialize information related to the model processor from the given root Element
   * of a model processing configuration's XML representation
   */
  private static ProcessingConfiguration.ProcessorInformation deserializeProcessorInformation(final Element configurationRoot) {
    final Element processorElement = Utils.findChildElementWithTag(configurationRoot, ProcessingConfiguration.XML_PROCESSOR_ELEMENT);
    if ((processorElement == null)) {
      return null;
    }
    final Element executableTypeElement = Utils.findChildElementWithTag(processorElement, 
      ProcessingConfiguration.XML_PROCESSOR_TYPE_ELEMENT);
    ProcessorExecutableType _xtrycatchfinallyexpression = null;
    try {
      _xtrycatchfinallyexpression = ProcessorExecutableType.valueOf(executableTypeElement.getTextContent());
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        _xtrycatchfinallyexpression = null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    final ProcessorExecutableType processorExecutableType = _xtrycatchfinallyexpression;
    Element _findChildElementWithTag = Utils.findChildElementWithTag(processorElement, 
      ProcessingConfiguration.XML_PROCESSOR_BASIC_EXECUTION_COMMAND_ELEMENT);
    String _textContent = null;
    if (_findChildElementWithTag!=null) {
      _textContent=_findChildElementWithTag.getTextContent();
    }
    final String basicProcessorExecutionCommand = _textContent;
    Element _findChildElementWithTag_1 = Utils.findChildElementWithTag(processorElement, 
      ProcessingConfiguration.XML_PROCESSOR_PATH_ELEMENT);
    String _textContent_1 = null;
    if (_findChildElementWithTag_1!=null) {
      _textContent_1=_findChildElementWithTag_1.getTextContent();
    }
    final String processorExecutablePath = _textContent_1;
    return new ProcessingConfiguration.ProcessorInformation(processorExecutableType, basicProcessorExecutionCommand, processorExecutablePath);
  }
  
  /**
   * Set a model processing configuration as a String attribute of the given
   * ILaunchConfigurationWorkingCopy. The String attribute receives as value the configuration's
   * XML representation. Furthermore, the source model file of the model processor configuration
   * is set as the mapped resource of the ILaunchConfigurationWorkingCopy. Note that calling this
   * method has the side effect of converting the given model processing configuration into its
   * internal representation.
   */
  public static void setProcessingConfigurationAsAttribute(final ILaunchConfigurationWorkingCopy launchConfiguration, final ProcessingConfiguration processingConfiguration) {
    try {
      final ByteArrayOutputStream out = new ByteArrayOutputStream();
      final XMLOutputFactory factory = XMLOutputFactory.newInstance();
      final XMLStreamWriter writer = factory.createXMLStreamWriter(out);
      processingConfiguration.convertToInternalRepresentation();
      processingConfiguration.serializeTo(writer);
      launchConfiguration.setAttribute(LaunchConfigurationConstants.PROCESSING_CONFIGURATION_ATTRIBUTE, 
        out.toString(StandardCharsets.UTF_8));
      out.close();
      writer.close();
      IFile _sourceModelFile = processingConfiguration.getSourceModelFile();
      launchConfiguration.setMappedResources(new IResource[] { _sourceModelFile });
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Serialize the model processing configuration to XML
   */
  private void serializeTo(final XMLStreamWriter writer) {
    try {
      writer.writeStartElement(ProcessingConfiguration.XML_CONFIGURATION_ELEMENT);
      writer.writeAttribute(ProcessingConfiguration.XML_CONFIGURATION_ATTR_SOURCE_MODEL_PROJECT_NAME, 
        this.sourceModelProjectName);
      writer.writeAttribute(ProcessingConfiguration.XML_CONFIGURATION_ATTR_SOURCE_MODEL_FILE_PATH, this.sourceModelFilePath);
      this.serializeProcessorInformationToXml(writer);
      writer.writeStartElement(ProcessingConfiguration.XML_ARGUMENTS_ELEMENT);
      final Consumer<Argument> _function = (Argument it) -> {
        it.serializeTo(writer);
      };
      this.arguments.forEach(_function);
      writer.writeEndElement();
      writer.writeEndElement();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Helper to serialize information related to the configuration's model processor to XML
   */
  private void serializeProcessorInformationToXml(final XMLStreamWriter writer) {
    try {
      writer.writeStartElement(ProcessingConfiguration.XML_PROCESSOR_ELEMENT);
      writer.writeStartElement(ProcessingConfiguration.XML_PROCESSOR_TYPE_ELEMENT);
      String _elvis = null;
      String _name = this.processorExecutableType.name();
      if (_name != null) {
        _elvis = _name;
      } else {
        _elvis = "";
      }
      writer.writeCharacters(_elvis);
      writer.writeEndElement();
      writer.writeStartElement(ProcessingConfiguration.XML_PROCESSOR_BASIC_EXECUTION_COMMAND_ELEMENT);
      String _elvis_1 = null;
      if (this.basicProcessorExecutionCommand != null) {
        _elvis_1 = this.basicProcessorExecutionCommand;
      } else {
        _elvis_1 = "";
      }
      writer.writeCharacters(_elvis_1);
      writer.writeEndElement();
      writer.writeStartElement(ProcessingConfiguration.XML_PROCESSOR_PATH_ELEMENT);
      String _elvis_2 = null;
      if (this.processorExecutablePath != null) {
        _elvis_2 = this.processorExecutablePath;
      } else {
        _elvis_2 = "";
      }
      writer.writeCharacters(_elvis_2);
      writer.writeEndElement();
      writer.writeEndElement();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Empty constructor
   */
  public ProcessingConfiguration() {
  }
  
  /**
   * Constructor
   */
  public ProcessingConfiguration(final String sourceModelProjectName, final String sourceModelFilePath, final ProcessorExecutableType processorExecutableType, final String processorExecutablePath, final String basicProcessorExecutionCommand) {
    this.sourceModelProjectName = sourceModelProjectName;
    this.sourceModelFilePath = sourceModelFilePath;
    this.processorExecutableType = processorExecutableType;
    this.processorExecutablePath = processorExecutablePath;
    this.basicProcessorExecutionCommand = basicProcessorExecutionCommand;
  }
  
  /**
   * Convert the configuration to its internal representation
   */
  public final void convertToInternalRepresentation() {
    final Consumer<Argument> _function = (Argument it) -> {
      it.convertToInternalRepresentation();
    };
    this.arguments.forEach(_function);
  }
  
  /**
   * Validate the model processing configuration in its user representation
   */
  public void validateInUserRepresentation() {
    ProcessingConfiguration.validateSourceModelProjectName(this.sourceModelProjectName);
    ProcessingConfiguration.validateSourceModelFilePath(this.sourceModelProjectName, this.sourceModelFilePath);
    ProcessingConfiguration.validateProcessorExecutableType(this.processorExecutableType);
    ProcessingConfiguration.validateBasicProcessorExecutionCommand(this.processorExecutableType, this.basicProcessorExecutionCommand);
    ProcessingConfiguration.validateProcessorExecutablePath(this.processorExecutableType, this.basicProcessorExecutionCommand, 
      this.processorExecutablePath);
    ProcessingConfiguration.validateArgumentsInUserRepresentation(this, this.arguments);
  }
  
  /**
   * Validate the given source model project name
   */
  public static void validateSourceModelProjectName(final String sourceModelProjectName) {
    Utils.notNullOrEmpty(sourceModelProjectName, ("Processing configuration must specify a source " + 
      "model project"));
    Utils.notNull(Utils.findProjectInCurrentWorkspace(sourceModelProjectName), ("Source model project " + 
      "does not exist in workspace"));
  }
  
  /**
   * Validate the given source model file path w.r.t. the source model project with the given name
   */
  public static void validateSourceModelFilePath(final String sourceModelProjectName, final String sourceModelFilePath) {
    ProcessingConfiguration.validateSourceModelProjectName(sourceModelProjectName);
    Utils.notNullOrEmpty(sourceModelFilePath, ("Processing configuration must specify the path to a " + 
      "source model file relative to a source model project path"));
    Utils.notNull(Utils.findFileInWorkspaceProject(sourceModelProjectName, sourceModelFilePath), ("Source " + 
      "model file does not exist in source model project"));
  }
  
  /**
   * Validate the given type of the model processor executable
   */
  public static void validateProcessorExecutableType(final ProcessorExecutableType processorExecutableType) {
    Utils.notNull(processorExecutableType, ("Processing configuration must specify type of " + 
      "processor executable"));
  }
  
  /**
   * Validate the given basic model processor execution command w.r.t. the given model processor
   * executable type
   */
  public static void validateBasicProcessorExecutionCommand(final ProcessorExecutableType processorExecutableType, final String processorExecutionCommand) {
    Utils.notNull(processorExecutionCommand, ("Processing configuration must specify a basic " + 
      "execution command"));
    boolean _equals = Objects.equal(processorExecutableType, ProcessorExecutableType.LOCAL_DOCKER_IMAGE);
    if (_equals) {
      Utils.notEmpty(processorExecutionCommand, ("Docker-based processing configurations must " + 
        "specify a basic execution command"));
    }
  }
  
  /**
   * Validate the given path to the model processor executable w.r.t. the given model processor
   * executable type and execution command
   */
  public static void validateProcessorExecutablePath(final ProcessorExecutableType processorExecutableType, final String processorExecutionCommand, final String processorExecutablePath) {
    Utils.notNullOrEmpty(processorExecutablePath, ("Processing configuration must specify path to " + 
      "processor executable"));
    boolean _equals = Objects.equal(processorExecutableType, ProcessorExecutableType.LOCAL_JAVA_PROGRAM);
    if (_equals) {
      ProcessingConfiguration.validateJavaProcessorExecutablePath(processorExecutablePath);
    } else {
      boolean _equals_1 = Objects.equal(processorExecutableType, ProcessorExecutableType.LOCAL_DOCKER_IMAGE);
      if (_equals_1) {
        ProcessingConfiguration.validateDockerProcessorExecutablePath(processorExecutablePath, processorExecutionCommand);
      }
    }
  }
  
  /**
   * Validate the given path to the model processor executable that is a local Java program
   */
  private static void validateJavaProcessorExecutablePath(final String processorExecutablePath) {
    boolean _isRegularFile = Files.isRegularFile(Paths.get(processorExecutablePath));
    boolean _not = (!_isRegularFile);
    if (_not) {
      throw new IllegalArgumentException("Executable processor file does not exist");
    }
  }
  
  /**
   * Validate the given path to the model processor executable that is a local Docker image
   */
  private static void validateDockerProcessorExecutablePath(final String processorExecutablePath, final String processorExecutionCommand) {
    Utils.notEmpty(processorExecutablePath, "Processing configuration must specify Docker image name");
    Utils.notNullOrEmpty(processorExecutionCommand, ("Docker image validation not possible because " + 
      "no processor executable is specified"));
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(processorExecutionCommand);
    _builder.append(" inspect ");
    final String imageValidationCommand = (_builder.toString() + processorExecutablePath);
    try {
      final Pair<Integer, String> commandResult = Utils.executeShellCommandBlocking(imageValidationCommand, 50, 4);
      Integer _key = commandResult.getKey();
      boolean _equals = ((_key).intValue() == 1);
      if (_equals) {
        throw new IllegalArgumentException("Image does not exist");
      } else {
        Integer _key_1 = commandResult.getKey();
        boolean _greaterThan = ((_key_1).intValue() > 1);
        if (_greaterThan) {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append(imageValidationCommand);
          _builder_1.append(" returned with exit code ");
          Integer _key_2 = commandResult.getKey();
          _builder_1.append(_key_2);
          _builder_1.append(": ");
          String _plus = ("Docker image validation not possible. " + _builder_1);
          String _value = commandResult.getValue();
          String _plus_1 = (_plus + _value);
          throw new IllegalArgumentException(_plus_1);
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("validation command \"");
        _builder_2.append(imageValidationCommand);
        _builder_2.append("\"");
        String _plus_2 = ("Docker image validation not possible: Invalid " + _builder_2);
        throw new IllegalArgumentException(_plus_2);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * Validate model processor execution arguments in user representation
   */
  public static void validateArgumentsInUserRepresentation(final ProcessingConfiguration configuration, final List<Argument> arguments) {
    if (arguments!=null) {
      final Consumer<Argument> _function = (Argument it) -> {
        it.validateInUserRepresentation(configuration);
      };
      arguments.forEach(_function);
    }
  }
  
  /**
   * Convert the model processing configuration to its user representation
   */
  public final void convertToUserRepresentation() {
    final Consumer<Argument> _function = (Argument it) -> {
      it.convertToUserRepresentation();
    };
    this.arguments.forEach(_function);
  }
  
  @Pure
  public String getSourceModelProjectName() {
    return this.sourceModelProjectName;
  }
  
  @Pure
  public String getSourceModelFilePath() {
    return this.sourceModelFilePath;
  }
  
  @Pure
  public ProcessorExecutableType getProcessorExecutableType() {
    return this.processorExecutableType;
  }
  
  @Pure
  public String getBasicProcessorExecutionCommand() {
    return this.basicProcessorExecutionCommand;
  }
  
  @Pure
  public String getProcessorExecutablePath() {
    return this.processorExecutablePath;
  }
  
  @Pure
  public ArrayList<Argument> getArguments() {
    return this.arguments;
  }
}
