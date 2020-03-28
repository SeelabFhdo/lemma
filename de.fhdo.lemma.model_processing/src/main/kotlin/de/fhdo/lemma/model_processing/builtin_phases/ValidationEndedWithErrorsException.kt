package de.fhdo.lemma.model_processing.builtin_phases

import de.fhdo.lemma.model_processing.phases.PhaseException

/**
 * Exception to communicate that a validation phase resulted in validation errors.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class ValidationEndedWithErrorsException : PhaseException("There were errors in the validated model",
    exitModelProcessor = true)