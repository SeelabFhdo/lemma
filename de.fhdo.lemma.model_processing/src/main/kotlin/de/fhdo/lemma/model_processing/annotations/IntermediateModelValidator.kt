package de.fhdo.lemma.model_processing.annotations

/**
 * Annotation to identify intermediate model validators.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Target(AnnotationTarget.CLASS)
annotation class IntermediateModelValidator

/**
 * Annotation to identify methods in intermediate model validators that are to be invoked prior to each call of a
 * validation method.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Target(AnnotationTarget.FUNCTION)
annotation class BeforeCheck