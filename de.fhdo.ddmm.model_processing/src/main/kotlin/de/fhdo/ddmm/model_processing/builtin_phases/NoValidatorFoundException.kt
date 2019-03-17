package de.fhdo.ddmm.model_processing.builtin_phases

/**
 * Exception to be thrown when no validator could be found on the classpath.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class NoValidatorFoundException(override val message: String) : Exception(message)