package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations

import java.util.List
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.Argument
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.SourceModelArgumentType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelArgumentType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelsOfAllImportsArgumentType
import de.fhdo.lemma.eclipse.ui.ProgrammaticIntermediateModelTransformation
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AbstractIntermediateModelArgumentTypeWithEnumValue
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.ImportedIntermediateModelKind
import de.fhdo.lemma.eclipse.ui.ServiceModelTransformationStrategy
import de.fhdo.lemma.eclipse.ui.OperationModelTransformationStrategy
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.FileArgumentType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.FolderArgumentType
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AllImportedIntermediateModelKinds
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.RawStringArgumentType
import org.apache.commons.io.FilenameUtils
import de.fhdo.lemma.eclipse.ui.ModelFile
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.StringPairArgumentType
import java.io.File
import java.io.IOException
import static de.fhdo.lemma.model_processing.eclipse.launcher.Utils.*
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelOfImportWithAliasArgumentType
import de.fhdo.lemma.eclipse.ui.AbstractUiModelTransformationStrategy
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.IntermediateModelOfFirstImportArgumentType

/**
 * Generator for the commandline to execute a model processing launch configuration.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class CommandLineGenerator {
    static val NO_VALUE_STRING = "<NO VALUE GIVEN>"

    val ProcessingConfiguration configuration
    val ProgrammaticIntermediateModelTransformation programmaticIntermediateTransformation
    val String domainModelFileTypeId
    val String serviceModelFileTypeId
    val String operationModelFileTypeId
    val collectedWarnings = <String>newArrayList

    /**
     * Constructor
     */
    new(ProcessingConfiguration configuration) {
        this.configuration = configuration
        programmaticIntermediateTransformation
            = configuration.programmaticIntermediateTransformation
        domainModelFileTypeId = ServiceModelTransformationStrategy.DATA_MODEL_FILE_TYPE_ID
        serviceModelFileTypeId = programmaticIntermediateTransformation?.strategy
            ?.serviceModelFileTypeId
        operationModelFileTypeId = OperationModelTransformationStrategy.OPERATION_MODEL_FILE_TYPE_ID
    }

    /**
     * Get the programmatic intermediate transformation applicable to the source model file of the
     * given processing configuration
     */
    private def getProgrammaticIntermediateTransformation(ProcessingConfiguration configuration) {
        // Check if the processing configuration requires an intermediate transformation which is
        // the case when it got a commandline argument assigned that specifies a certain kind of
        // intermediate model
        val intermediateTransformatioRequired = configuration.arguments.exists[
            AbstractIntermediateModelArgumentTypeWithEnumValue.isAssignableFrom(it.type.class)
        ]

        return if (!intermediateTransformatioRequired)
                null
            else if (configuration.sourceModelFile !== null)
                new ProgrammaticIntermediateModelTransformation(configuration.sourceModelFile)
            else
                throw new IllegalArgumentException("Processing configuration specifies arguments " +
                    "requiring intermediate model representations but no source model file for " +
                    "intermediate transformations was given")
    }

    /**
     * Get the file type ID for LEMMA service models from the kind of the given transformation
     * strategy
     */
    private def getServiceModelFileTypeId(AbstractUiModelTransformationStrategy strategy) {
        if (strategy === null)
            return null

        return switch (strategy) {
            ServiceModelTransformationStrategy:
                ServiceModelTransformationStrategy.SERVICE_MODEL_FILE_TYPE_ID
            OperationModelTransformationStrategy:
                OperationModelTransformationStrategy.SERVICE_MODEL_FILE_TYPE_ID
            default:
                throw new IllegalArgumentException("Service model file type identifier not " +
                    "determinable for intermediate transformation strategy " +
                    strategy.class.simpleName)
        }
    }

    /**
     * Get the coherent parts of the commandline and related warnings
     */
    final def Pair<CoherentCommandLineParts, List<String>> generateCoherentCommandLineParts() {
        collectedWarnings.clear
        val commandLineParts = new CoherentCommandLineParts()

        val processorExecutablePath = if (!configuration.processorExecutablePath.nullOrEmpty)
                configuration.processorExecutablePath.quoteIfContainsSpaces
            // For all processor executable types besides "raw executables", we expect a processor
            // executable path
            else if (configuration.processorExecutableType !=
                ProcessorExecutableType.RAW_EXECUTABLE)
                "<NO PROCESSOR EXECUTABLE PATH SPECIFIED>"
            else
                ""

        val executionCommandParts = configuration.generateExecutionCommandParts()
        commandLineParts.addExecutionCommandPart(executionCommandParts.key)
        commandLineParts.addExecutionCommandParts(executionCommandParts.value)
        commandLineParts.addExecutionCommandPart(processorExecutablePath)

        configuration.determineArgumentParameterValues().forEach[_, parameterValues |
            commandLineParts.addParameterValues(parameterValues)
        ]

        return commandLineParts -> collectedWarnings
    }

    /**
     * Class representing lists of coherent commandline parts. A commandline part is either an
     * execution command part or coherent argument parameters. The coherence of a commandline part
     * is technically defined by their belonging to the same List instance.
     */
    static class CoherentCommandLineParts {
        val executionCommandParts = <List<String>>newArrayList
        val argumentParameters = <List<String>>newArrayList

        /**
         * Add an execution command part consisting of a single String element
         */
        protected def addExecutionCommandPart(String part) {
            addExecutionCommandPart(#[part])
        }

        /**
         * Add an execution command part consisting of coherent String elements
         */
        protected def addExecutionCommandPart(List<String> part) {
            executionCommandParts.add(part)
        }

        /**
         * Add execution command parts consisting of a list of coherent String elements
         */
        protected def addExecutionCommandParts(List<List<String>> parts) {
            executionCommandParts.addAll(parts)
        }

        /**
         * Add argument parameters consisting of a list of coherent String elements
         */
        protected def addParameterValues(ParameterValues parameterValues) {
            argumentParameters.addAll(parameterValues.unfoldWithoutNullValues)
        }

        /**
         * Merge all coherent commandline parts in their List forms in a single List instance
         */
        protected def mergeParts() {
            val result = <List<String>>newArrayList
            result.addAll(executionCommandParts)
            result.addAll(argumentParameters)
            return result.unmodifiableView
        }

        /**
         * Merge the Strings of all coherent commandline parts in a single List instance
         */
        protected def mergeAndFlattenParts() {
            return mergeParts.flatten.toList.unmodifiableView
        }
    }

    /**
     * Quote the given String if it contains spaces. In case the String is null or empty, return an
     * unquoted placeholder String like "<NO VALUE GIVEN>".
     */
    private def quoteIfContainsSpaces(String s) {
        return if (s.nullOrEmpty)
                NO_VALUE_STRING
            else if (s.contains(" "))
                '''"«s»"'''
            else
                s
    }

    /**
     * Generate the execution command parts for the given model processing configuration
     */
    private def generateExecutionCommandParts(ProcessingConfiguration configuration) {
        val command = configuration.basicProcessorExecutionCommand
            ?.trim
            ?.quoteIfContainsSpaces
        if (command === null)
            return #["<NO BASIC EXECUTION COMMAND SPECIFIED>"] -> emptyList

        return switch(configuration.processorExecutableType) {
            case LOCAL_DOCKER_IMAGE: configuration.generateDockerExecutionCommandParts(command)
            case LOCAL_JAVA_PROGRAM: newArrayList(
                command,
                // Prevent illegal reflective access warnings until LEMMA is fully compatible with
                // the Java Platform Module System
                "--add-opens",
                "java.base/java.lang=ALL-UNNAMED",
                "-jar"
            ) -> emptyList
            case RAW_EXECUTABLE: newArrayList(command) -> emptyList
        }
    }

    /**
     * Generate the execution command parts for local Docker images. Note that the method will also
     * add potential warnings to the state of the CommandLineGenerator object.
     */
    private def generateDockerExecutionCommandParts(ProcessingConfiguration configuration,
        String command) {
        /*
         * The basic command part is the Docker execution command together with the "run" method,
         * and the "-i(nteractive)" flag for keeping STDIN open and thus accessible during the
         * command's execution
         */
        val commandParts = newArrayList(command, "run", "-i")

        /* Determine additional command parameters */
        val additionalCommandParameters = <List<String>>newArrayList()

        // Try to add the user ID and user group ID as an additional command parameter so that
        // artifacts produced by the model processor execution, e.g., generated code, doesn't have
        // exclusive root permissions but become adaptable also by the current Eclipse user.
        try {
            // TODO: Check compatibility with Windows
            val userId = getUserId()
            val groupId = getUserGroupId()
            additionalCommandParameters.add(#["-u", '''«userId»:«groupId»'''])
        } catch(UserInfoNotDeterminable ex) {
            var message = ex.message
            if (!message.endsWith("."))
                message = message + "."
            collectedWarnings.add('''«message» Docker container will run as "root".''')
        }

        // Add volume parameters. The absolute path to the Eclipse project of the model processing
        // configuration's source model file will always become a volume parameter. Additional
        // volume parameters result from the configuration's argument. A folder argument will
        // become a volume parameter as well as the absolute path to the folder storing the file of
        // a file argument.
        val projectPath = configuration.sourceModelFile.project.location.makeAbsolute.toString
        val volumePaths = newHashSet(projectPath)

        configuration.arguments.forEach[
            if (it.type.identifier == FolderArgumentType.IDENTIFIER)
                volumePaths.add(it.value)
            else if (it.type.identifier == FileArgumentType.IDENTIFIER) {
                val absolutePath = new File(it.value).absolutePath
                volumePaths.add(FilenameUtils.getFullPathNoEndSeparator(absolutePath))
            }
        ]

        volumePaths.forEach[additionalCommandParameters.addAsDockerVolumeParameter(it)]

        /* Return the determined command parts and their parameters */
        return commandParts -> additionalCommandParameters
    }

    /**
     * Get the ID of the current user via the "id -u" command
     */
    private def getUserId() {
        return getUserInfo("u", "User ID")
    }

    /**
     * Get information about the current user via the "id" command. The idCommandFlag parameter
     * determines the flag (without a preceding dash) to invoke the "id" command, e.g., "u" for the
     * retrieval of the user's ID. The printablePart parameter determines a printable version of the
     * retrieved information, e.g., "User ID", to be used in error messages.
     */
    private def getUserInfo(String idCommandFlag, String printablePart) {
        val command = '''id -«idCommandFlag»'''
        val userInfoResult = try {
            executeShellCommandBlocking(command, 50, 4)
        } catch (IOException ex) {
            throw new UserInfoNotDeterminable('''«printablePart» not determinable: «ex.message»''')
        }

        val userInfo = userInfoResult.value.trim
        if (userInfoResult.key != 0)
            throw new UserInfoNotDeterminable('''«printablePart» not determinable. Execution ''' +
                '''of "«command»" returned with exit code «userInfoResult.key»: ''' +
                (userInfo ?: '''<No output from «command»>'''))

        return userInfo
    }

    /**
     * Exception to signal that information about the current user was not determinable
     */
    private static class UserInfoNotDeterminable extends Exception {
        new(String message) {
            super(message)
        }
    }

    /**
     * Get the ID of the current user via the "id -g" command
     */
    private def getUserGroupId() {
        getUserInfo("g", "User group ID")
    }

    /**
     * Add the given path as a Docker volume parameter to the given list of coherent parameters
     */
    private def addAsDockerVolumeParameter(List<List<String>> parameters, String path) {
        var folder = path
        val fobj = new File(folder)
        if (!fobj.directory)
            folder = FilenameUtils.getFullPathNoEndSeparator(fobj.absolutePath)

        val volumeParameterParts = newArrayList("-v")
        volumeParameterParts.add('''«folder»:«folder»''')
        parameters.add(volumeParameterParts)
    }

    /**
     * Determine the values for the arguments of the execution of a model processing configuration
     */
    private def determineArgumentParameterValues(ProcessingConfiguration configuration) {
        val argumentParameterValues = <Argument, ParameterValues>newLinkedHashMap

        configuration.arguments.forEach[argument |
            val parameterValues = switch(argument.type) {
                FileArgumentType |
                FolderArgumentType:
                    argument.generateFileSystemParameterValues
                IntermediateModelArgumentType:
                    argument.generateIntermediateModelParameterValues
                IntermediateModelOfFirstImportArgumentType:
                    argument.generateIntermediateModelOfFirstImportParameterValues
                IntermediateModelsOfAllImportsArgumentType:
                    argument.generateIntermediateModelsOfAllImportsParameterValues
                IntermediateModelOfImportWithAliasArgumentType:
                    argument.generateIntermediateModelOfImportWithAliasParameterValues
                RawStringArgumentType:
                    argument.generateRawStringParameterValues
                SourceModelArgumentType:
                    argument.generateSourceModelParameterValues
                StringPairArgumentType:
                    argument.generateStringPairParameterValues
                default: throw new IllegalArgumentException("Value determination for argument " +
                    '''type «argument.type.name» not supported''')
            }

            argumentParameterValues.put(argument, parameterValues)
        ]

        return argumentParameterValues
    }

    /**
     * Class representing values for the parameters of the arguments of a model processing
     * configuration's execution
     */
    private static class ParameterValues {
        val pairs = <Pair<String, String>>newArrayList

        /**
         * Empty constructor
         */
        new() {
            // NOOP
        }

        /**
         * Constructor for an argument parameter without a value
         */
        new(Argument argument) {
            add(argument)
        }

        /**
         * Constructor for an argument parameter with a value
         */
        new(Argument argument, String value) {
            add(argument, value)
        }

        /**
         * Add an argument parameter without a value
         */
        def add(Argument argument) {
            add(argument, null)
        }

        /**
         * Add an argument parameter with a value
         */
        def add(Argument argument, String value) {
            add(argument.parameter, value)
        }

        /**
         * Add an argument parameter in its String form with a value
         */
        def add(String parameter, String value) {
            val parameterForCommandLine = parameter ?: "<NO PARAMETER GIVEN>"
            pairs.add(parameterForCommandLine -> value)
        }

        /**
         * Return collected parameter values as a List of String Lists. Each nested List comprises
         * at most two String values: The first String is the parameter name, the second String is
         * the parameter value. For positional parameters, where the value is null, the nested List
         * will only comprise one element, i.e., the parameter name.
         */
        def unfoldWithoutNullValues() {
            return pairs.map[
                it.value !== null ? #[it.key, it.value] : #[it.key]
            ]
        }
    }

    /**
     * Generate parameter values for an Argument that represents a filesystem element. The result
     * will be a ParameterValues instance that consists of the Argument and its value, which is
     * interpreted as a path to a filesystem element. That is, the value string will be quoted if it
     * contains spaces.
     */
    private def generateFileSystemParameterValues(Argument argument) {
        return new ParameterValues(argument,
            argument.value?.quoteIfContainsSpaces?.valueForCommandLine)
    }

    /**
     * Helper to map the given String to a value applicable on the commandline. If the String is not
     * null or empty, the result will be the String itself. Otherwise, the helper returns a
     * non-empty placeholder String like "<NO VALUE GIVEN>".
     */
    private def getValueForCommandLine(String value) {
        return if (!value.nullOrEmpty)
                value
            else
                NO_VALUE_STRING
    }

    /**
     * Generate parameter values for an Argument that represents the intermediate representation of
     * the model processing configuration's source model file. The result will be a ParameterValues
     * instance that consists of the Argument and a value that is the absolute (possibly quoted)
     * target path of the intermediate model to be produced from the model processing
     * configuration's source model file.
     */
    private def generateIntermediateModelParameterValues(Argument argument) {
        val value = programmaticIntermediateTransformation.rootModelFile
            .absoluteTransformationTargetPath.quoteIfContainsSpaces
        return new ParameterValues(argument, value)
    }

    /**
     * Helper to get the absolute target path of an intermediate transformation of the given model
     * file. The target path consists of the path to the folder storing the model file (which, by
     * definition, is a location in an Eclipse project) and the transformation target path specified
     * by the model file (which, by definition, is a relative path).
     */
    private def getAbsoluteTransformationTargetPath(ModelFile modelFile) {
        val transformationTargetPath = modelFile.transformationTargetPath
        if (transformationTargetPath === null)
            return null

        val projectFolder = modelFile?.file?.project?.location?.makeAbsolute?.toFile
        val parentFolder = projectFolder?.parent
        return if (parentFolder !== null)
                FilenameUtils.separatorsToSystem('''«parentFolder»«transformationTargetPath»''')
            else
                null
    }

    /**
     * Generate parameter values for an Argument that represents the intermediate representation of
     * the model first imported by the model processing configuration's source model file. The
     * result will be a ParameterValues instance that consists of the Argument and a value that is
     * the absolute (possibly quoted) target path of the intermediate model to be produced from the
     * first imported model.
     */
    private def generateIntermediateModelOfFirstImportParameterValues(Argument argument) {
        val modelKind = ImportedIntermediateModelKind.valueOf(argument.value)

        val firstImportedModel = switch (modelKind) {
            case FIRST_DOMAIN_MODEL: getFirstRootModelChildOfType(domainModelFileTypeId)
            case FIRST_OPERATION_MODEL: getFirstRootModelChildOfType(operationModelFileTypeId)
            case FIRST_SERVICE_MODEL: getFirstRootModelChildOfType(serviceModelFileTypeId)
            default: throw new IllegalArgumentException("Retrieving the first imported model of " +
                '''kind «modelKind» is not supported''')
        }

        return if (firstImportedModel !== null) {
                val value = firstImportedModel
                    .absoluteTransformationTargetPath
                    .quoteIfContainsSpaces
                new ParameterValues(argument, value)
            } else
                null
    }

    /**
     * Helper to get the first imported model of the model processing configuration's source model
     * file with the given model file type ID and as a ModeFile instance
     */
    private def getFirstRootModelChildOfType(String modelFileTypeId) {
        return programmaticIntermediateTransformation.rootModelFile.children
            .findFirst[fileTypeDescription.fileType == modelFileTypeId]
    }

    /**
     * Generate parameter values for an Argument that represents the intermediate versions of all
     * models imported by the model processing configuration's source model file. The result will be
     * a ParameterValues instance that consists of as many Argument-value pairs as there are
     * imported models. Each value in such a pair is the absolute (possibly quoted) target path of
     * the intermediate model to be produced from an imported model.
     */
    private def generateIntermediateModelsOfAllImportsParameterValues(Argument argument) {
        val modelKind = AllImportedIntermediateModelKinds.valueOf(argument.value)

        val importedModels = switch (modelKind) {
            case ALL_DOMAIN_MODELS: getRootModelChildrenOfType(domainModelFileTypeId)
            case ALL_OPERATION_MODELS: getRootModelChildrenOfType(operationModelFileTypeId)
            case ALL_SERVICE_MODELS: getRootModelChildrenOfType(serviceModelFileTypeId)
            default: throw new IllegalArgumentException("Retrieving all imported models of kind " +
                '''«modelKind» is not supported''')
        }

        val parameterValues = new ParameterValues()
        importedModels.forEach[
            val value = absoluteTransformationTargetPath.quoteIfContainsSpaces
            parameterValues.add(argument, value)
        ]
        return parameterValues
    }

    /**
     * Helper to get the children of the model processing configuration's source model file with the
     * given model file type ID and as ModeFile instances
     */
    private def getRootModelChildrenOfType(String modelFileTypeId) {
        return programmaticIntermediateTransformation.rootModelFile.children
            .filter[fileTypeDescription.fileType == modelFileTypeId]
    }

    /**
     * Generate parameter values for an Argument that represents the intermediate representation of
     * the model imported by the model processing configuration's source model file with a specified
     * alias. The result will be a ParameterValues instance that consists of the Argument and a
     * value that is the absolute (possibly quoted) target path of the intermediate model to be
     * produced from the imported model.
     */
    private def generateIntermediateModelOfImportWithAliasParameterValues(Argument argument) {
        val importedModel = programmaticIntermediateTransformation.rootModelFile.children
            .findFirst[importAlias == argument.value]

        return if (importedModel !== null) {
                val value = importedModel.absoluteTransformationTargetPath.quoteIfContainsSpaces
                new ParameterValues(argument, value)
            } else
                null
    }

    /**
     * Generate parameter values for an Argument that represents a raw string. The result will be a
     * ParameterValues instance that solely consists of the Argument.
     */
    private def generateRawStringParameterValues(Argument argument) {
        return new ParameterValues(argument)
    }

    /**
     * Generate parameter values for an Argument that represents the model processing
     * configuration's source model file. The result will be a ParameterValues instance that
     * consists of the Argument and a value that is the absolute (possibly quoted) path of the
     * source model file.
     */
    private def generateSourceModelParameterValues(Argument argument) {
        val absoluteSourceModelPath = configuration.sourceModelFile?.rawLocation?.makeAbsolute
            ?.toString?.quoteIfContainsSpaces
        return new ParameterValues(argument, absoluteSourceModelPath)
    }

    /**
     * Generate parameter values for an Argument that represents a string pair. The result will be a
     * ParameterValues instance that consists of the Argument and its value, which will be quoted if
     * it contains spaces, or replaced by a placeholder if it is null or empty.
     */
    private def generateStringPairParameterValues(Argument argument) {
        return new ParameterValues(argument,
            argument.value?.quoteIfContainsSpaces?.valueForCommandLine)
    }

    /**
     * Get a printable representation of the coherent commandline parts joined by the given
     * delimiter
     */
    final def toPrintableCommandLine(CoherentCommandLineParts coherentCommandLineParts,
        String delimiter) {
        return coherentCommandLineParts.mergeParts.map[it.join(" ")].join(delimiter)
    }

    /**
     * Get a representation of the coherent commandline parts that is executable. By contrast to a
     * printable representation, an executable representation is a List consisting of Strings that
     * are commandline parts and can be passed to a Java ProcessBuilder.
     */
    final def toExecutableCommandLine(CoherentCommandLineParts coherentCommandLineParts) {
        // We again remove the quotes of parameter values with spaces because Java's ProcessBuilder
        // expects unquoted commandline options
        return coherentCommandLineParts.mergeAndFlattenParts.map[it.removeSurroundingQuotes].toList
    }

    /**
     * Remove quotes around a given String
     */
    private def removeSurroundingQuotes(String s) {
        return if (s.startsWith("\"") && s.endsWith("\""))
                s.substring(1, s.length-1)
            else
                s
    }
}