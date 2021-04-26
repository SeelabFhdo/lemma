package de.fhdo.lemma.live_validation.server;

import picocli.CommandLine;

import static de.fhdo.lemma.live_validation.protocol.extensions.LiveValidationServer.DEFAULT_HOSTNAME;
import static de.fhdo.lemma.live_validation.protocol.extensions.LiveValidationServer.DEFAULT_PORT;
import static de.fhdo.lemma.live_validation.protocol.extensions.LiveValidationServer.DEFAULT_TIMEOUT_THRESHOLDS_IN_MILLISECONDS;
import static picocli.CommandLine.Option;
import static picocli.CommandLine.ParameterException;
import static picocli.CommandLine.Spec;

/**
 * Singleton which represents the parsed commandline of the application.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class LiveValidationCommandLine {
    private static LiveValidationCommandLine INSTANCE;

    @Spec
    private CommandLine.Model.CommandSpec spec;

    private static boolean alreadyParsed;

    private LiveValidationCommandLine() {}

    public static LiveValidationCommandLine instance() {
        if (INSTANCE == null)
            INSTANCE = new LiveValidationCommandLine();
        return INSTANCE;
    }

    /**
     * Parse the commandline
     */
    public void parse(String[] args) {
        if (alreadyParsed)
            return;

        new CommandLine(this).setOverwrittenOptionsAllowed(true).parseArgs(args);
        alreadyParsed = true;
    }

    /*
     * Port option (-p, --port)
     */
    private int port = DEFAULT_PORT;

    @Option(names = {"-p", "--port"}, paramLabel = "SERVER_PORT",
        description = {"the port to be used by the live validation server"})
    public void setPort(int port) {
        if (port < 0 || port > 65535)
            throw new ParameterException(spec.commandLine(), "Port number must be between 0 and 65535");

        this.port = port;
    }

    public int getPort() {
        return port;
    }

    /*
     * Hostname option (-h, --hostname)
     */
    @Option(names = {"-h", "--hostname"}, paramLabel = "HOSTNAME",
        description = {"the hostname to be used by the live validation server"})
    private String hostname = DEFAULT_HOSTNAME;

    public String getHostname() {
        return hostname;
    }

    /*
     * Debug option (--debug) to specify that debug logging messages shall be printed to standard output
     */
    @Option(names = {"--debug"}, description = {"instruct live validation server to print debug messages"})
    private boolean debug;

    public boolean isDebug() {
        return debug;
    }

    /*
     * Quiet option (--quiet) to specify that no messages shall be printed to standard output
     */
    @Option(names = {"--quiet"},
        description = {"instruct live validation server to print no messages (will be overridden by --debug)"})
    private boolean quiet;

    public boolean isQuiet() {
        return quiet;
    }

    /*
     * Trace option (--trace) to specify that LSP4J shall print exchanged LSP messages to standard output
     */
    @Option(names = {"--trace"},
        description = {"instruct live validation server to trace messages being exchanged with clients"})
    private boolean trace;

    public boolean isTrace() {
        return trace;
    }

    /*
     * Validation client timeout threshold (--timeout_threshold)
     */
    @Option(names = {"--timeout_threshold"}, paramLabel = "TIMEOUT_THRESHOLD",
        description = {"the threshold in milliseconds until which validation clients must send a response"})
    private long timeoutThreshold = DEFAULT_TIMEOUT_THRESHOLDS_IN_MILLISECONDS;

    public long getTimeoutThreshold() {
        return timeoutThreshold;
    }
}
