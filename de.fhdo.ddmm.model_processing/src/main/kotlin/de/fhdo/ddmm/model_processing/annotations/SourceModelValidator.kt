package de.fhdo.ddmm.model_processing.annotations

import de.fhdo.ddmm.model_processing.builtin_phases.source_model_validation.SourceModelValidationMode

/**
 * Annotation to identify source model validators.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Target(AnnotationTarget.CLASS)
annotation class SourceModelValidator(
    val validationMode: SourceModelValidationMode = SourceModelValidationMode.BASIC,
    vararg val supportedFileExtensions: String
)