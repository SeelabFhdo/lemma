package de.fhdo.lemma.model_processing.phases

/**
 * Abort a phase's processing exceptionally
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
open class PhaseException(message: String? = null, val exitModelProcessor: Boolean = false) : Exception(message)