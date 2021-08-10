package de.fhdo.lemma.model_processing.annotations

import de.fhdo.lemma.model_processing.command_line.BasicOption
import de.fhdo.lemma.model_processing.phases.AbstractModelProcessingPhase
import kotlin.reflect.KClass

/**
 * Internal annotation to identify the initial model processing phase. The [isOmittable] flag determines if the phase
 * can be omitted by the user. When the flag is set to false, the phase will always be executed. The [isBlocking] flag
 * specifies that the user needs to actively terminate the execution of the phase. That is, the respective model
 * processor will not terminate when it executes a blocking phase.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Target(AnnotationTarget.CLASS)
internal annotation class InitialModelProcessingPhase(val id: String, val isOmittable: Boolean = false,
    val isBlocking: Boolean = false)

/**
 * Annotation for model processing phases. The [after] parameter identifies the processing phase after which this phase
 * is to be executed. If a phase has more than one successor, the execution order of the successors is
 * non-deterministic.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("unused")
@Target(AnnotationTarget.CLASS)
annotation class ModelProcessingPhase(val id: String, val after: KClass<out AbstractModelProcessingPhase>,
    val isOmittable: Boolean = true, val isBlocking: Boolean = false)

/**
 * Annotation for model processing phases that need to be invoked explicitly leveraging the commandline. For an example
 * see [de.fhdo.lemma.model_processing.builtin_phases.live_validation.LiveValidationPhase].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("unused")
@Target(AnnotationTarget.CLASS)
annotation class ExplicitlyInvokedModelProcessingPhase(val id: String, val isOmittable: Boolean = true,
    val isBlocking: Boolean = false)

/**
 * Annotation to be used with one of the phase annotations [InitialModelProcessingPhase], [ModelProcessingPhase], or
 * [ExplicitlyInvokedModelProcessingPhase]. Determines a [BasicOption], which is consumed by the respective phase. When
 * the [BasicOption] is not present, the phase will not be executed. If in addition [errorIfNotPresent] is set to true,
 * the user will be informed with an error message about the missing option and the aborted execution of the phase.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Target(AnnotationTarget.CLASS)
annotation class ConsumesBasicCommandLineOption(val requiredOption: BasicOption, val errorIfNotPresent: Boolean = false)

/**
 * Annotation to mark functions that have to be executed before a phase is executed. The actual semantics and usage
 * depends on the respective phase. If a phase has more than one @Before function, the order of their executions is
 * random.
 *
 * For instance, in the context of the
 * [de.fhdo.lemma.model_processing.builtin_phases.source_model_validation.SourceModelValidationPhase], functions within
 * an Xtext-based source model validator, i.e., implementers of
 * [de.fhdo.lemma.model_processing.phases.validation.AbstractXtextModelValidator], annotated with @Before are executed
 * before the validation of the Xtext model is executed. Moreover, depending on the phase, functions annotated with
 * @Before possibly need to exhibit a certain signature. In the case of Xtext-based source model validators, @Before
 * functions need a parameter of type [org.eclipse.emf.ecore.resource.Resource].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Target(AnnotationTarget.FUNCTION)
annotation class Before

/**
 * Annotation to mark functions that have to be executed after a phase was executed. The actual semantics and usage
 * depends on the respective phase. However, it exhibits the same characteristics as [@Before](Before).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Target(AnnotationTarget.FUNCTION)
annotation class After