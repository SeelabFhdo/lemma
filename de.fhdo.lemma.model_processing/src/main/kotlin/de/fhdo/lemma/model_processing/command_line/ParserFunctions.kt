package de.fhdo.lemma.model_processing.command_line

import de.fhdo.lemma.model_processing.subList
import picocli.CommandLine

/**
 * Parse the commandline passed to the model processor. The function takes the "raw" commandline arguments and a list
 * of "part identifiers". The part identifiers introduce a sub-part of the commandline, which may take its own, distinct
 * parameters, e.g., a phase ID or the name of an
 * [de.fhdo.lemma.model_processing.builtin_phases.code_generation.AbstractCodeGenerationModule]. That is, to allow users
 * to specify sub-part-specific parameters on the commandline by first stating the respective part identifier and
 * preceding it with the desired commandline options.
 *
 * For instance, the "live_validation" phase allows users to explicitly specify the hostname and port of the Live
 * Validation server to be used. These information can be passed to the phase by invoking the model processors via
 *      java -jar model_processor.jar [SOME_BASIC_OPTIONS] live_validation --hostname 193.25.22.138 --port 631
 * i.e., "live_validation" is the part identifier in this case.
 *
 * The function returns a pair consisting of a list of strings (basic commandline options) and a map of strings to list
 * of strings (part-specific commandline options per part identifier).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun parseCommandLine(args: Array<String>, partIds: List<String>)
    : Pair<List<String>, Map<String, List<String>>> {
    if (args.isEmpty())
        return emptyList<String>() to emptyMap()

    val rawCommandLineParameters = parseCommandLineRaw(args)
    val (partParametersStartIndex, basicParameters) = parseBasicParameters(rawCommandLineParameters, partIds)
    val partParameters = parsePartParameters(rawCommandLineParameters.subList(partParametersStartIndex), partIds)
    return Pair(basicParameters, partParameters)
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
 * part-specific one.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun parseBasicParameters(rawParameters: List<String>, partIds: List<String>) : Pair<Int, List<String>> {
    if (rawParameters.isEmpty())
        return Pair(0, emptyList())

    var currentParameterIndex = 0
    var currentParameter = rawParameters[currentParameterIndex]

    // A commandline option is considered to be a basic one, until an option occurs, whose name corresponds to a
    // part identifier. Starting with this option, all following options are considered to be either part-specific
    // commandline parameters or another part identifier.
    val basicParameters = mutableListOf<String>()
    while (currentParameter !in partIds) {
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
 * Determine all part-specific commandline parameters. Note that the function expects the [rawPartParameters] list
 * passed to it to start with the first part identifier detected after the last basic commandline option (cf.
 * [parseBasicParameters]).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun parsePartParameters(rawPartParameters: List<String>, partIds: List<String>) : Map<String, List<String>> {
    if (rawPartParameters.isEmpty())
        return emptyMap()

    // This is a linked hash map to keep the order of the part parameters as they were stated by the user on the
    // commandline. For example, this allows the user to run explicitly invoked phases in the desired order.
    val partParameters = LinkedHashMap<String, MutableList<String>>()
    var currentParameterIndex = 0
    var currentPart: String? = null
    while (currentParameterIndex < rawPartParameters.size) {
        val currentParameter = rawPartParameters[currentParameterIndex]

        // Each iterated commandline option, which corresponds to a part identifier, starts a new list of part-specific
        // parameters. The list may be empty, if no specific parameters were passed for the part by the user.
        if (currentParameter in partIds) {
            partParameters[currentParameter] = mutableListOf()
            currentPart = currentParameter
        } else if (currentPart != null)
            partParameters[currentPart]!!.add(currentParameter)

        currentParameterIndex++
    }

    return partParameters
}