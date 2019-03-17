package de.fhdo.ddmm.model_processing.annotations

/**
 * Annotation to identify code generation modules.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Target(AnnotationTarget.CLASS)
annotation class CodeGenerationModule(val name: String, val dependsOn: String = "")