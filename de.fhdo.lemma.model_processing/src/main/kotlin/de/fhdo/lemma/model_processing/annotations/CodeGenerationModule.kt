package de.fhdo.lemma.model_processing.annotations

import de.fhdo.lemma.model_processing.phases.ModelKind

/**
 * Annotation to identify code generation modules.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("unused")
@Target(AnnotationTarget.CLASS)
annotation class CodeGenerationModule(val name: String, vararg val modelKinds: ModelKind = [ModelKind.INTERMEDIATE],
    val dependsOn: String = "")

/**
 * Annotation for code generation modules that need to be explicitly invoked leveraging the commandline.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("unused")
@Target(AnnotationTarget.CLASS)
annotation class ExplicitlyInvokedCodeGenerationModule(val name: String,
    vararg val modelKinds: ModelKind = [ModelKind.INTERMEDIATE])