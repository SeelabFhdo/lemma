package de.fhdo.lemma.model_processing.phases

/**
 * Exception that a required commandline option is not provided
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class MissingCommandLineOptionException(options: List<String>) :
    PhaseException("Missing command line option ${options.joinToString()}")