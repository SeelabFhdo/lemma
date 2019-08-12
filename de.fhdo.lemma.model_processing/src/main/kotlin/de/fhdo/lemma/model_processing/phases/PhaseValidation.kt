package de.fhdo.lemma.model_processing.phases

import de.fhdo.lemma.model_processing.annotations.RequiresBasicCommandLineOptions
import de.fhdo.lemma.model_processing.command_line.BasicCommandLine
import de.fhdo.lemma.model_processing.command_line.BasicOption
import de.fhdo.lemma.model_processing.findIsInstance

/**
 * Validate a loaded and initialized model processing phase
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun AbstractModelProcessingPhase.validate() {
    checkRequiredCommandLineOptionsPassed(this)
}

/**
 * Helper to check that all required commandline options of the phase were passed.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun checkRequiredCommandLineOptionsPassed(phase: AbstractModelProcessingPhase) {
    val missingOption =
        findRequiredCommandLineOption(phase) { !BasicCommandLine.hasParsedOption(it) }
    if (missingOption != null)
        throw MissingCommandLineOptionException(missingOption.names)
}

/**
 * Helper to search [RequiresBasicCommandLineOptions] of a model processing phase on the basis of a search predicate.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun findRequiredCommandLineOption(phase: AbstractModelProcessingPhase, predicate: (BasicOption) -> (Boolean))
    : BasicOption? {
    val requiredOptionsAnnotation = phase::class.annotations.findIsInstance<RequiresBasicCommandLineOptions>()
        ?: return null
    return requiredOptionsAnnotation.requiredOptions.find { predicate(it) }
}