package de.fhdo.lemma.model_processing.command_line

import de.fhdo.lemma.model_processing.subList
import picocli.CommandLine

/**
 * Parse the commandline passed to the model processor. The function takes the "raw" commandline arguments and a list
 * of model processing phase IDs to distinguish them from basic commandline options. That is, to allow users to specify
 * phase-specific parameters on the commandline by first stating the respective phase's ID and preceding it with the
 * desired commandline options.
 *
 * For instance, the "live_validation" phase allows users to explicitly specify the hostname and port of the Live
 * Validation server to be used. These information can be passed to the phase by invoking the model processors via
 *      java -jar model_processor.jar [SOME_BASIC_OPTIONS] live_validation --hostname 193.25.22.138 --port 631
 *
 * The function returns a pair consisting of a list of strings (basic commandline options) and a map of strings to list
 * of strings (phase-specific commandline options per phase ID).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun parseCommandLine(args: Array<String>, phaseIds: List<String>)
    : Pair<List<String>, Map<String, List<String>>> {
    val rawCommandLineParameters = parseCommandLineRaw(args)
    val (phaseParametersStartIndex, basicParameters) = parseBasicParameters(rawCommandLineParameters, phaseIds)
    val phaseParameters = parsePhaseParameters(rawCommandLineParameters.subList(phaseParametersStartIndex), phaseIds)
    return Pair(basicParameters, phaseParameters)
}

/**
 * Parse commandline "raw", i.e., return a list of strings, each denoting a token that was recognized by the commandline
 * parser without determining the token as an option or an option value.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun parseCommandLineRaw(args: Array<String>) = RawCommandLine(args).rawParameters

/**
 * Internal helper class to leverage [picocli] and its [CommandLine] utility to perform "raw" commandline parsing.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@CommandLine.Command
private class RawCommandLine(args: Array<String>) {
    @CommandLine.Unmatched
    lateinit var rawParameters: List<String>

    init {
        CommandLine.populateCommand(this, *args)
    }
}

/**
 * Determine the basic commandline options and the index of the first commandline option that is not a basic but a
 * phase-specific one.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun parseBasicParameters(rawParameters: List<String>, phaseIds: List<String>) : Pair<Int, List<String>> {
    if (rawParameters.isEmpty())
        return Pair(0, emptyList())

    var currentParameterIndex = 0
    var currentParameter = rawParameters[currentParameterIndex]

    // A commandline option is considered to be a basic one, until an option occurs, whose name corresponds to a
    // phase ID. Starting with this option, all following options are considered to be either phase-specific commandline
    // parameters or another phase ID.
    val basicParameters = mutableListOf<String>()
    while (currentParameter !in phaseIds) {
        basicParameters.add(currentParameter)
        currentParameterIndex++

        if (currentParameterIndex < rawParameters.size)
            currentParameter = rawParameters[currentParameterIndex]
        else
            break
    }

    return Pair(currentParameterIndex, basicParameters)
}

/**
 * Determine all phase-specific commandline parameters. Note that the function expects the [rawPhaseParameters] list
 * passed to it to start with the first phase ID, detected after the last basic commandline option (cf.
 * [parseBasicParameters]).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun parsePhaseParameters(rawPhaseParameters: List<String>, phaseIds: List<String>) : Map<String, List<String>> {
    if (rawPhaseParameters.isEmpty())
        return emptyMap()

    // This is a linked hash map to keep the order of the phase parameters as they were stated by the user on the
    // command line. This allows the user to run explicitly invoked phases in the desired order.
    val phaseParameters = LinkedHashMap<String, MutableList<String>>()
    var currentParameterIndex = 0
    var currentPhase: String? = null
    while (currentParameterIndex < rawPhaseParameters.size) {
        val currentParameter = rawPhaseParameters[currentParameterIndex]

        // Each iterated commandline option, which corresponds to a phase ID, starts a new list of phase-specific
        // parameters. The list may be empty, if no specific parameters were passed for the phase by the user.
        if (currentParameter in phaseIds) {
            phaseParameters[currentParameter] = mutableListOf()
            currentPhase = currentParameter
        } else if (currentPhase != null)
            phaseParameters[currentPhase]!!.add(currentParameter)

        currentParameterIndex++
    }

    return phaseParameters
}