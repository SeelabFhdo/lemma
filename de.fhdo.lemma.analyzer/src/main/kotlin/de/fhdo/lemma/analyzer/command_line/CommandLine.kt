package de.fhdo.lemma.analyzer.command_line

import picocli.CommandLine

/**
 * Commandline of the static analyzer.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object CommandLine {
    internal var initialized = false
        private set

    @Suppress("unused")
    @CommandLine.Spec
    private lateinit var commandSpec: CommandLine.Model.CommandSpec

    @CommandLine.Unmatched
    var unmatched = mutableListOf<String>()

    /*
     * Selected analysis modules
     */
    @CommandLine.Option(
        names = ["--analysis_module"],
        paramLabel = "ANALYSIS_MODULE",
        description = ["analysis module to execute"]
    )
    var modules = getAnalysisModulesCliOptionNames()

    /*
     * CSV file for result export
     */
    @CommandLine.Option(
        names = ["--csv_file"],
        paramLabel = "CSV_FILEPATH",
        description = ["target CSV file"]
    )
    var csvFile: String? = null

    /*
     * Prefix to add to all column headings in exported CSV file
     */
    @CommandLine.Option(
        names = ["--csv_column_prefix"],
        paramLabel = "CSV_COLUMN_PREFIX",
        description = ["prefix for column headings in CSV file"]
    )
    var csvColumnPrefix: String? = null

    /*
     * CSV variable separator
     */
    @CommandLine.Option(
        names = ["--csv_variable_separator"],
        paramLabel = "CSV_VARIABLE_SEPARATOR",
        description = ["separator for static and variable parts of a CSV column"]
    )
    var csvVariableSeparator: String = "_"

    /*
     * Intermediate model file to analyze additionally to the intermediate model file passed to the model processors by
     * means of the --intermediate_model CLI option
     */
    @CommandLine.Option(
        names = ["--additional_intermediate_model"],
        paramLabel = "ADDITIONAL_INTERMEDIATE_MODEL_FILE",
        description = ["an additional intermediate model file to analyze"]
    )
    var additionalIntermediateModels = mutableListOf<String>()

    /*
     * Print value store
     */
    @CommandLine.Option(
        names = ["--print_value_store"],
        paramLabel = "PRINT_VALUE_STORE",
        description = ["print collected values to stdout"]
    )
    var printValueStore = false

    /**
     * Parse the commandline by invoking the Singleton
     */
    internal operator fun invoke(args: Array<String>) {
        check(!initialized) { "Commandline object has already been initialized" }
        CommandLine(this)
            .setStopAtUnmatched(false)
            .setStopAtPositional(false)
            .setOverwrittenOptionsAllowed(true)
            .parse(*args)
        initialized = true
    }
}