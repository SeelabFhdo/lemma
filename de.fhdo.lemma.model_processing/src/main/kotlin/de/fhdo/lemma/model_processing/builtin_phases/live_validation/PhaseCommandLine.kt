package de.fhdo.lemma.model_processing.builtin_phases.live_validation

import de.fhdo.lemma.live_validation.protocol.extensions.LiveValidationServer.DEFAULT_HOSTNAME
import de.fhdo.lemma.live_validation.protocol.extensions.LiveValidationServer.DEFAULT_PORT
import picocli.CommandLine

/**
 * Singleton, which represents the commandline of the [LiveValidationPhase].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object PhaseCommandLine {
    @CommandLine.Spec
    private lateinit var commandSpec: CommandLine.Model.CommandSpec

    // Port commandline option
    var port: Int = DEFAULT_PORT
        @CommandLine.Option(
            names = ["-p", "--port"],
            paramLabel = "SERVER_PORT",
            description = ["the port to be used by the live validation server"]
        )
        set(value) {
            if (value < 0 || value > 65535)
                throw CommandLine.ParameterException(
                    commandSpec.commandLine(),
                    "Port number must be between 0 and 65535"
                )

            field = value
        }

    // Hostname commandline option
    @CommandLine.Option(
        names = ["-h", "--hostname"],
        paramLabel = "HOSTNAME",
        description = ["the hostname to be used by the live validation server"]
    )
    var hostname: String = DEFAULT_HOSTNAME

    /**
     * Invoke the singleton instance to parse the commandline arguments
     */
    internal operator fun invoke(args: Array<String>) {
        CommandLine(this)
            .setOverwrittenOptionsAllowed(true)
            .parse(*args)
    }
}