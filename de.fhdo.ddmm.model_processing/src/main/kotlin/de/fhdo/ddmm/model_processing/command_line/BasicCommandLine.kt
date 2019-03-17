package de.fhdo.ddmm.model_processing.command_line

import de.fhdo.ddmm.model_processing.asFile
import de.fhdo.ddmm.model_processing.containsAny
import picocli.CommandLine
import picocli.CommandLine.Model.CommandSpec
import picocli.CommandLine.Option
import picocli.CommandLine.ParameterException
import picocli.CommandLine.Spec

/**
 * Enumeration of basic commandline options that may be specified by model processing phases as being required in the
 * form of parameters of [de.fhdo.ddmm.model_processing.annotations.RequiresBasicCommandLineOptions].
 *
 * A "basic" commandline option is distinguished from a phase-specific commandline option. It is relevant for the model
 * processor as a whole and independent of any specific phase.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
enum class BasicOption(val names: List<String>) {
    SOURCE_MODEL_FILE(listOf("-s", "--source_model")),
    INTERMEDIATE_MODEL_FILE(listOf("-i", "--intermediate_model")),
    TARGET_FOLDER(listOf("-t", "--target_folder")),
    INVOKE_ONLY_SPECIFIED_PHASES(listOf("--invoke_only_specified_phases"))
}

/**
 * Object to represent the
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
object BasicCommandLine {
    @Spec
    private lateinit var commandSpec: CommandSpec

    /*
     * Commandline option that specifies the source model file, i.e., the Xtext file, before it was transformed into
     * an intermediate model file
     */
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

    /* Commandline option that specifies the target folder of the model processing */
    @Option(
        names = ["-t", "--target_folder"],
        paramLabel = "TARGET_FOLDER",
        description = ["the target folder of the model processing"]
    )
    var targetFolder: String? = null

    /*
     * Commandline option to instruct the model processor to only invoke all explicitly specified phases
     */
    @Option(
        names = ["--invoke_only_specified_phases"],
        description = ["invoke only those phases that were explicitly specified as command line parameters"]
    )
    var invokeOnlySpecifiedPhases: Boolean = false

    /*
     * Commandline option to instruct the model processor to exit on phase errors
     */
    @Option(
        names = ["--exit_on_error"],
        description = ["exit model processor when errors occur in a phase"]
    )
    var exitOnError: Boolean = false

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