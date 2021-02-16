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

/**
 * Annotation for debugging purposes in intermediate model validators. If a validation  method throws an Exception,
 * this annotation wil result in rethrowing the Exception to the validator implementation.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Target(AnnotationTarget.FUNCTION)
annotation class RethrowExceptions

/**
 * Annotation to constrain the instances of validated objects for a check method in an intermediate model validator to
 * exactly the type of the method's first parameter.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Target(AnnotationTarget.FUNCTION)
annotation class ExcludeSubtypes