package de.fhdo.lemma.model_processing.annotations

/**
 * Annotation to identify code generation modules.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Target(AnnotationTarget.CLASS)
annotation class CodeGenerationModule(val name: String, val dependsOn: String = "")

/**
 * Annotation for code generation modules that need to be explicitly invoked leveraging the commandline.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Target(AnnotationTarget.CLASS)
annotation class ExplicitlyInvokedCodeGenerationModule(val name: String)