package de.fhdo.lemma.model_processing.command_line

import de.fhdo.lemma.model_processing.asFile
import de.fhdo.lemma.model_processing.containsAny
import picocli.CommandLine
import picocli.CommandLine.Model.CommandSpec
import picocli.CommandLine.Option
import picocli.CommandLine.ParameterException
import picocli.CommandLine.Spec

/**
 * Enumeration of basic commandline options. A "basic" commandline option is distinguished from a phase-specific
 * commandline option as being relevant to the model processor as a whole and independent of any specific phase.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
enum class BasicOption(val names: List<String>) {
    SOURCE_MODEL_FILE(listOf("-s", "--source_model")),
    INTERMEDIATE_MODEL_FILE(listOf("-i", "--intermediate_model")),
    TARGET_FOLDER(listOf("-t", "--target_folder")),
    @Suppress("unused")
    INVOKE_ONLY_SPECIFIED_PHASES(listOf("--invoke_only_specified_phases"))
}

/**
 * Object to represent the basic commandline
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
object BasicCommandLine {
    private const val DEBUG_OPTION_NAME = "--debug"

    @Spec
    private lateinit var commandSpec: CommandSpec

    /* Commandline option that specifies the source model file */
    var sourceModelFile: String? = null
        @Option(
            names = ["-s", "--source_model"],
            paramLabel = "SOURCE_MODEL_FILE",
            description = ["the source model file"]
        )
        set(value) {
            if (value != null && !value.asFile().exists())
                throw ParameterException(commandSpec.commandLine(), "Source model file $value does not exist")

            field = value
        }

    /* Commandline option that specifies the intermediate model file */
    var intermediateModelFile: String? = null
        @Option(
            names = ["-i", "--intermediate_model"],
            paramLabel = "INTERMEDIATE_MODEL_FILE",
            description = ["the intermediate model file"]
        )
        set(value) {
            if (value != null && !value.asFile().exists())
                throw ParameterException(commandSpec.commandLine(), "Intermediate model file $value does not exist")

            field = value
        }

    /* Commandline option that specifies the target folder of the model processing tasks like code generation */
    @Option(
        names = ["-t", "--target_folder"],
        paramLabel = "TARGET_FOLDER",
        description = ["model processing target folder"]
    )
    var targetFolder: String? = null

    /* Commandline option to instruct the model processor to print debug messages to standard output */
    @Suppress("unused")
    var debugSpecification: String? = null
        @Option(
            names = [DEBUG_OPTION_NAME],
            description = [
                "print debug messages to standard output (may receive a list of space-delimited strings of which " +
                "each identifies the kind of debug messages to print; debug message kinds involve phase identifiers)"
            ],
            arity = "0..1"
        )
        set(value) {
            if (value != null && value.isNotEmpty())
                debugMessageKinds.addAll(value.split(" "))

            field = value
        }

    internal val debugMessageKinds = mutableListOf<String>()

    /**
     * Did the user request to run model processing in debug mode?
     */
    internal fun debugMode() = parsedOptions.any { it.names().contains(DEBUG_OPTION_NAME) }

    /* Commandline option to instruct the model processor to only invoke all explicitly specified phases */
    @Option(
        names = ["--invoke_only_specified_phases"],
        description = ["invoke only those phases that were explicitly specified as command line parameters"]
    )
    var invokeOnlySpecifiedPhases: Boolean = false

    /*
     * Commandline option to instruct the model processor to continue after phase errors
     */
    @Option(
        names = ["--continue_after_phase_errors"],
        description = ["continue model processing after the occurrence of phase errors"]
    )
    var continueAfterPhaseErrors: Boolean = false

    private var parsedCommandLine: CommandLine? = null
    private var parsedOptions: List<CommandLine.Model.OptionSpec> = emptyList()

    /**
     * Parse the commandline by invoking the object
     */
    internal operator fun invoke(args: List<String>) {
        if (parsedCommandLine != null)
            return

        parsedCommandLine = CommandLine(this)
            .setOverwrittenOptionsAllowed(true)
            .parse(*args.toTypedArray())[0]

        parsedOptions = parsedCommandLine
            ?.parseResult!!
            .matchedOptions()
            .map { it as CommandLine.Model.OptionSpec }
    }

    /**
     * Helper to determine if the parsed commandline exhibits the given [BasicOption]
     */
    internal fun hasParsedOption(option: BasicOption) : Boolean =
        if (parsedCommandLine != null)
            parsedOptions.any { it.names().containsAny(option.names) }
        else
            false
}