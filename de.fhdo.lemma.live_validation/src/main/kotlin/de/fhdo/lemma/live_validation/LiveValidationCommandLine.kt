package de.fhdo.lemma.live_validation

import de.fhdo.lemma.live_validation.protocol.LiveValidationServer
import picocli.CommandLine

/**
 * Internal object, which represents the parsed commandline of the application.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object LiveValidationCommandLine {
    @CommandLine.Spec
    private lateinit var commandSpec: CommandLine.Model.CommandSpec

    private var alreadyParsed = false

    /*
     * Port option (-p, --port)
     */
    var port = LiveValidationServer.DEFAULT_PORT
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

    /*
     * Hostname option (-h, --hostname)
     */
    @CommandLine.Option(
        names = ["-h", "--hostname"],
        paramLabel = "HOSTNAME",
        description = ["the hostname to be used by the live validation server"]
    )
    var hostname = LiveValidationServer.DEFAULT_HOSTNAME

    /*
     * Debug option (--debug) to specify that debug logging messages shall be printed to standard output
     */
    @CommandLine.Option(
        names = ["--debug"],
        description = ["instruct live validation server to print debug messages"]
    )
    var debug = false

    /*
     * Quiet option (--quiet) to specify that no messages shall be printed to standard output
     */
    @CommandLine.Option(
        names = ["--quiet"],
        description = ["instruct live validation server to print no messages (will be overridden by --debug)"]
    )
    var quiet = false

    /*
     * Trace option (--trace) to specify that LSP4J shall print exchanged LSP messages to standard output
     */
    @CommandLine.Option(
        names = ["--trace"],
        description = ["instruct live validation server to trace messages being exchanged with clients"]
    )
    var trace = false

    /*
     * Validation client timeout threshold (--timeout_threshold)
     */
    @CommandLine.Option(
        names = ["--timeout_threshold"],
        paramLabel = "TIMEOUT_THRESHOLD",
        description = ["the threshold in milliseconds until which validation clients must send a response"]
    )
    var timeoutThreshold = LiveValidationServer.DEFAULT_TIMEOUT_THRESHOLDS_IN_MILLISECONDS

    /**
     * Parse the commandline by invoking this object
     */
    internal operator fun invoke(args: Array<String>) {
        if (alreadyParsed)
            return

        CommandLine(this)
            .setOverwrittenOptionsAllowed(true)
            .parseArgs(*args)

        alreadyParsed = true
    }
}
