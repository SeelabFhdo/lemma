package de.fhdo.lemma.model_processing.builtin_phases.intermediate_model_query

import de.fhdo.lemma.model_processing.asFile
import picocli.CommandLine
import picocli.CommandLine.Model.CommandSpec
import picocli.CommandLine.ParameterException

/**
 * Singleton, which represents the commandline of the [IntermediateModelQueryPhase].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object PhaseCommandLine {
    @CommandLine.Spec
    private lateinit var commandSpec: CommandSpec

    // Query file commandline option
    var queryFile: String? = null
        @CommandLine.Option(
            names = ["-f", "--query_file"],
            paramLabel = "QUERY_FILE",
            description = ["the query file to be used to query the intermediate model"]
        )
        set(value) {
            if (value != null && !value.asFile().exists())
                throw ParameterException(commandSpec.commandLine(), "Intermediate model query file $value does not " +
                    "exist")

            field = value
        }

    /**
     * Invoke the singleton instance to parse the commandline arguments
     */
    internal operator fun invoke(args: Array<String>) {
        CommandLine(this)
            .setOverwrittenOptionsAllowed(true)
            .parse(*args)
    }
}