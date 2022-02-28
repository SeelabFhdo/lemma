package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations

import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument
import javax.xml.stream.XMLStreamWriter

import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*
import org.w3c.dom.Element
import java.util.function.Supplier
import de.fhdo.lemma.model_processing.eclipse.launcher.ModelElementWithPropertyChangeSupport
import java.nio.file.Files
import java.nio.file.Paths
import java.io.IOException
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy
import java.io.ByteArrayOutputStream
import javax.xml.stream.XMLOutputFactory
import java.nio.charset.StandardCharsets
import org.eclipse.debug.core.ILaunchConfiguration
import static de.fhdo.lemma.model_processing.eclipse.launcher.LaunchConfigurationConstants.*
import org.eclipse.core.resources.IFile

/**
 * Domain concept for model processing configurations.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class ProcessingConfiguration extends ModelElementWithPropertyChangeSupport implements Cloneable {
    static val XML_CONFIGURATION_ELEMENT = "processingConfiguration"
    static val XML_CONFIGURATION_ATTR_SOURCE_MODEL_PROJECT_NAME = "sourceModelProjectName"
    static val XML_CONFIGURATION_ATTR_SOURCE_MODEL_FILE_PATH = "sourceModelFilePath"
    static val XML_PROCESSOR_ELEMENT = "processor"
    static val XML_PROCESSOR_TYPE_ELEMENT = "type"
    static val XML_PROCESSOR_BASIC_EXECUTION_COMMAND_ELEMENT = "basicExecutionCommand"
    static val XML_PROCESSOR_PATH_ELEMENT = "path"
    static val XML_ARGUMENTS_ELEMENT = "arguments"

    @Accessors(PUBLIC_GETTER)
    var String sourceModelProjectName

    /**
     * Set the name of the source model project and fire a corresponding property change event
     */
    final def setSourceModelProjectName(String sourceModelProjectName) {
        firePropertyChange("sourceModelProjectName", this.sourceModelProjectName,
            this.sourceModelProjectName = sourceModelProjectName)
    }

    @Accessors(PUBLIC_GETTER)
    var String sourceModelFilePath

    /**
     * Set the path of the source model file and fire a corresponding property change event
     */
    final def setSourceModelFilePath(String sourceModelFilePath) {
        firePropertyChange("sourceModelFilePath", this.sourceModelFilePath,
            this.sourceModelFilePath = sourceModelFilePath)
    }

    /**
     * Get the source model file as an IFile in the current Eclipse workspace. Return null in case
     * the name of the source model project or the path to the source model are invalid.
     */
    final def IFile getSourceModelFile() {
        try {
            validateSourceModelProjectName(sourceModelProjectName)
            validateSourceModelFilePath(sourceModelProjectName, sourceModelFilePath)
        } catch (IllegalArgumentException ex) {
            return null
        }

        return findFileInWorkspaceProject(sourceModelProjectName, sourceModelFilePath)
    }

    @Accessors
    var ProcessorExecutableType processorExecutableType

    /**
     * Set the type of the model processor executable and fire a corresponding property change event
     */
    final def setProcessorExecutableType(ProcessorExecutableType processorExecutableType) {
        firePropertyChange("processorExecutableType", this.processorExecutableType,
            this.processorExecutableType = processorExecutableType)
    }

    @Accessors(PUBLIC_GETTER)
    var String basicProcessorExecutionCommand

    /**
     * Set the basic model processor execution command and fire a corresponding property change
     * event
     */
    final def setBasicProcessorExecutionCommand(String basicProcessorExecutionCommand) {
        firePropertyChange("basicProcessorExecutionCommand", this.basicProcessorExecutionCommand,
            this.basicProcessorExecutionCommand = basicProcessorExecutionCommand)
    }

    @Accessors
    var String processorExecutablePath

    /**
     * Set the path to the model processor executable and fire a corresponding property change event
     */
    final def setProcessorExecutablePath(String processorExecutablePath) {
        firePropertyChange("processorExecutablePath", this.processorExecutablePath,
            this.processorExecutablePath = processorExecutablePath)
    }

    @Accessors(PUBLIC_GETTER)
    var arguments = <Argument>newArrayList

    /**
     * Two model processing configurations are equal when they point to the same source model, have
     * the same model processor configuration, and the same entries in their execution arguments
     */
    final override equals(Object o) {
        return if (o === this)
            true
        else if (!(o instanceof ProcessingConfiguration))
            false
        else {
            val otherConfig = o as ProcessingConfiguration

            sourceModelProjectName == otherConfig.sourceModelProjectName &&
            sourceModelFilePath == otherConfig.sourceModelFilePath &&
            processorExecutableType == otherConfig.processorExecutableType &&
            basicProcessorExecutionCommand == otherConfig.basicProcessorExecutionCommand &&
            processorExecutablePath == otherConfig.processorExecutablePath &&
            equalLists(arguments, otherConfig.arguments)
        }
    }

    /**
     * Clone the configuration which also entails the cloning of its execution arguments
     */
    override clone() {
        val clone = super.clone() as ProcessingConfiguration
        clone.arguments = newArrayList(arguments.map[clone() as Argument])
        return clone
    }

    /**
     * Deserialize the model processing configuration from its XML representation stored in the
     * given ILaunchConfiguration
     */
    static def deserializeFrom(ILaunchConfiguration launchConfiguration) {
        val xml = launchConfiguration.getAttribute(PROCESSING_CONFIGURATION_ATTRIBUTE, "")
        if (xml.empty)
            return null

        val root = getRootElementWithTag(parseXmlString(xml), XML_CONFIGURATION_ELEMENT)
        if (root === null)
            throw new IllegalArgumentException("Error during deserialization of processing " +
                '''configuration: Root XML element «XML_CONFIGURATION_ELEMENT» not found''')

        val processorInformation = root.deserializeProcessorInformation
        val configuration = new ProcessingConfiguration(
            root.getAttribute(XML_CONFIGURATION_ATTR_SOURCE_MODEL_PROJECT_NAME),
            root.getAttribute(XML_CONFIGURATION_ATTR_SOURCE_MODEL_FILE_PATH),
            processorInformation.processorExecutableType,
            processorInformation.processorExecutablePath,
            processorInformation.basicProcessorExecutionCommand
        )

        configuration.arguments = initializeItems(root, XML_ARGUMENTS_ELEMENT,
            Argument.XML_ARGUMENT_ELEMENT, [new Argument()])

        return configuration
    }

    /**
     * Helper to initialize a List of ProcessingConfigurationItem instances that are stored as XML
     * sub-elements of an XML parent element which itself is a sub-element of a given XML root
     * element
     */
    private static def <T extends ProcessingConfigurationItem> initializeItems(
        Element root,
        String itemParentTag,
        String itemTag,
        Supplier<T> constructItemInstance
    ) {
        val items = <T>newArrayList
        val childElement = findChildElementWithTag(root, itemParentTag)
        val elements = childElement.getElementsByTagName(itemTag)
        for (n : 0..<elements.length) {
            val item = constructItemInstance.get()
            item.deserializeFrom(elements.item(n) as Element)
            items.add(item)
        }
        return items
    }

    /**
     * Helper to deserialize information related to the model processor from the given root Element
     * of a model processing configuration's XML representation
     */
    private static def deserializeProcessorInformation(Element configurationRoot) {
        val processorElement = findChildElementWithTag(configurationRoot, XML_PROCESSOR_ELEMENT)
        if (processorElement === null)
            return null

        val executableTypeElement = findChildElementWithTag(processorElement,
            XML_PROCESSOR_TYPE_ELEMENT)
        val processorExecutableType = try {
                ProcessorExecutableType.valueOf(executableTypeElement.textContent)
            } catch (Exception ex) {
                null
            }

        val basicProcessorExecutionCommand = findChildElementWithTag(processorElement,
            XML_PROCESSOR_BASIC_EXECUTION_COMMAND_ELEMENT)?.textContent

        val processorExecutablePath = findChildElementWithTag(processorElement,
            XML_PROCESSOR_PATH_ELEMENT)?.textContent

        return new ProcessorInformation(processorExecutableType, basicProcessorExecutionCommand,
            processorExecutablePath)
    }

    /**
     * Class to make information about a model processor accessible in a coherent manner
     */
    private static class ProcessorInformation {
        @Accessors(PUBLIC_GETTER)
        val ProcessorExecutableType processorExecutableType
        @Accessors(PUBLIC_GETTER)
        val String basicProcessorExecutionCommand
        @Accessors(PUBLIC_GETTER)
        val String processorExecutablePath

        new (ProcessorExecutableType processorExecutableType, String basicProcessorExecutionCommand,
            String processorExecutablePath) {
            this.processorExecutableType = processorExecutableType
            this.basicProcessorExecutionCommand = basicProcessorExecutionCommand
            this.processorExecutablePath = processorExecutablePath
        }
    }

    /**
     * Set a model processing configuration as a String attribute of the given
     * ILaunchConfigurationWorkingCopy. The String attribute receives as value the configuration's
     * XML representation. Furthermore, the source model file of the model processor configuration
     * is set as the mapped resource of the ILaunchConfigurationWorkingCopy. Note that calling this
     * method has the side effect of converting the given model processing configuration into its
     * internal representation.
     */
    static def setProcessingConfigurationAsAttribute(
        ILaunchConfigurationWorkingCopy launchConfiguration,
        ProcessingConfiguration processingConfiguration
    ) {
        val out = new ByteArrayOutputStream
        val factory = XMLOutputFactory.newInstance()
        val writer = factory.createXMLStreamWriter(out)
        processingConfiguration.convertToInternalRepresentation()
        processingConfiguration.serializeTo(writer)
        launchConfiguration.setAttribute(PROCESSING_CONFIGURATION_ATTRIBUTE,
            out.toString(StandardCharsets.UTF_8))
        out.close()
        writer.close()

        launchConfiguration.mappedResources = #[processingConfiguration.sourceModelFile]
    }

    /**
     * Serialize the model processing configuration to XML
     */
    private def void serializeTo(XMLStreamWriter writer) {
        writer.writeStartElement(XML_CONFIGURATION_ELEMENT)

        writer.writeAttribute(XML_CONFIGURATION_ATTR_SOURCE_MODEL_PROJECT_NAME,
            sourceModelProjectName)
        writer.writeAttribute(XML_CONFIGURATION_ATTR_SOURCE_MODEL_FILE_PATH, sourceModelFilePath)
        writer.serializeProcessorInformationToXml

        writer.writeStartElement(XML_ARGUMENTS_ELEMENT)
        arguments.forEach[it.serializeTo(writer)]
        writer.writeEndElement()

        writer.writeEndElement()
    }

    /**
     * Helper to serialize information related to the configuration's model processor to XML
     */
    private def serializeProcessorInformationToXml(XMLStreamWriter writer) {
        writer.writeStartElement(XML_PROCESSOR_ELEMENT)

        writer.writeStartElement(XML_PROCESSOR_TYPE_ELEMENT)
        writer.writeCharacters(processorExecutableType.name ?: "")
        writer.writeEndElement()

        writer.writeStartElement(XML_PROCESSOR_BASIC_EXECUTION_COMMAND_ELEMENT)
        writer.writeCharacters(basicProcessorExecutionCommand ?: "")
        writer.writeEndElement()

        writer.writeStartElement(XML_PROCESSOR_PATH_ELEMENT)
        writer.writeCharacters(processorExecutablePath ?: "")
        writer.writeEndElement()

        writer.writeEndElement()
    }

    /**
     * Empty constructor
     */
    new() {
        // NOOP
    }

    /**
     * Constructor
     */
    new(
        String sourceModelProjectName,
        String sourceModelFilePath,
        ProcessorExecutableType processorExecutableType,
        String processorExecutablePath,
        String basicProcessorExecutionCommand
    ) {
        this.sourceModelProjectName = sourceModelProjectName
        this.sourceModelFilePath = sourceModelFilePath
        this.processorExecutableType = processorExecutableType
        this.processorExecutablePath = processorExecutablePath
        this.basicProcessorExecutionCommand = basicProcessorExecutionCommand
    }

    /**
     * Convert the configuration to its internal representation
     */
    final def convertToInternalRepresentation() {
        arguments.forEach[it.convertToInternalRepresentation()]
    }

    /**
     * Validate the model processing configuration in its user representation
     */
    def validateInUserRepresentation() {
        validateSourceModelProjectName(sourceModelProjectName)
        validateSourceModelFilePath(sourceModelProjectName, sourceModelFilePath)
        validateProcessorExecutableType(processorExecutableType)
        validateBasicProcessorExecutionCommand(processorExecutableType, basicProcessorExecutionCommand)
        validateProcessorExecutablePath(processorExecutableType, basicProcessorExecutionCommand,
            processorExecutablePath)
        validateArgumentsInUserRepresentation(this, arguments)
    }

    /**
     * Validate the given source model project name
     */
    static def validateSourceModelProjectName(String sourceModelProjectName) {
        notNullOrEmpty(sourceModelProjectName, "Processing configuration must specify a source " +
            "model project")
        notNull(findProjectInCurrentWorkspace(sourceModelProjectName), "Source model project " +
            "does not exist in workspace")
    }

    /**
     * Validate the given source model file path w.r.t. the source model project with the given name
     */
    static def validateSourceModelFilePath(String sourceModelProjectName,
        String sourceModelFilePath) {
        validateSourceModelProjectName(sourceModelProjectName)

        notNullOrEmpty(sourceModelFilePath, "Processing configuration must specify the path to a " +
            "source model file relative to a source model project path")
        notNull(findFileInWorkspaceProject(sourceModelProjectName, sourceModelFilePath), "Source " +
            "model file does not exist in source model project")
    }

    /**
     * Validate the given type of the model processor executable
     */
    static def validateProcessorExecutableType(ProcessorExecutableType processorExecutableType) {
        notNull(processorExecutableType, "Processing configuration must specify type of " +
            "processor executable")
    }

    /**
     * Validate the given basic model processor execution command w.r.t. the given model processor
     * executable type
     */
    static def validateBasicProcessorExecutionCommand(
        ProcessorExecutableType processorExecutableType,
        String processorExecutionCommand
    ) {
        notNull(processorExecutionCommand, "Processing configuration must specify a basic " +
            "execution command")

        if (processorExecutableType == ProcessorExecutableType.LOCAL_DOCKER_IMAGE)
            notEmpty(processorExecutionCommand, "Docker-based processing configurations must " +
                "specify a basic execution command")
    }

    /**
     * Validate the given path to the model processor executable w.r.t. the given model processor
     * executable type and execution command
     */
    static def validateProcessorExecutablePath(
        ProcessorExecutableType processorExecutableType,
        String processorExecutionCommand,
        String processorExecutablePath
    ) {
        notNullOrEmpty(processorExecutablePath, "Processing configuration must specify path to " +
            "processor executable")
        if (processorExecutableType == ProcessorExecutableType.LOCAL_JAVA_PROGRAM)
            processorExecutablePath.validateJavaProcessorExecutablePath
        else if (processorExecutableType == ProcessorExecutableType.LOCAL_DOCKER_IMAGE)
            processorExecutablePath.validateDockerProcessorExecutablePath(processorExecutionCommand)
    }

    /**
     * Validate the given path to the model processor executable that is a local Java program
     */
    private static def validateJavaProcessorExecutablePath(String processorExecutablePath) {
        if (!Files.isRegularFile(Paths.get(processorExecutablePath)))
            throw new IllegalArgumentException("Executable processor file does not exist")
    }

    /**
     * Validate the given path to the model processor executable that is a local Docker image
     */
    private static def validateDockerProcessorExecutablePath(String processorExecutablePath,
        String processorExecutionCommand) {
        notEmpty(processorExecutablePath, "Processing configuration must specify Docker image name")
        notNullOrEmpty(processorExecutionCommand, "Docker image validation not possible because " +
            "no processor executable is specified")

        val imageValidationCommand = '''«processorExecutionCommand» inspect ''' +
            processorExecutablePath
        try {
            val commandResult = executeShellCommandBlocking(imageValidationCommand, 50, 4)
            if (commandResult.key == 1)
                throw new IllegalArgumentException("Image does not exist")
            else if (commandResult.key > 1)
                throw new IllegalArgumentException("Docker image validation not possible. " +
                    '''«imageValidationCommand» returned with exit code «commandResult.key»: ''' +
                    commandResult.value)
        } catch (IOException ex) {
            throw new IllegalArgumentException("Docker image validation not possible: Invalid " +
                '''validation command "«imageValidationCommand»"''')
        }
    }

    /**
     * Validate model processor execution arguments in user representation
     */
    static def validateArgumentsInUserRepresentation(ProcessingConfiguration configuration,
        List<Argument> arguments) {
        arguments?.forEach[it.validateInUserRepresentation(configuration)]
    }

    /**
     * Convert the model processing configuration to its user representation
     */
    final def convertToUserRepresentation() {
        arguments.forEach[it.convertToUserRepresentation()]
    }
}