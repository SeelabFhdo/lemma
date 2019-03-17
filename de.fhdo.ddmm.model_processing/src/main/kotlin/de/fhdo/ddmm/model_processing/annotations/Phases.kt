package de.fhdo.ddmm.model_processing.annotations

import de.fhdo.ddmm.model_processing.command_line.BasicOption
import de.fhdo.ddmm.model_processing.phases.AbstractModelProcessingPhase
import kotlin.reflect.KClass

/**
 * Internal annotation to identify the starting model processing phase.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Target(AnnotationTarget.CLASS)
internal annotation class InitialModelProcessingPhase(val id: String, val isBlocking: Boolean = false)

/**
 * Annotation for model processing phases. The [after] parameter identifies the processing phase after which this phase
 * is to be executed. If a phase has more than one successor, the execution order of the successors is random.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Target(AnnotationTarget.CLASS)
annotation class ModelProcessingPhase(val id: String, val after: KClass<out AbstractModelProcessingPhase>,
    val isBlocking: Boolean = false)

/**
 * Annotation for model processing phases that need to be invoked explicitly leveraging the commandline. For an example
 * see [de.fhdo.ddmm.model_processing.builtin_phases.live_validation.SourceModelLiveValidationPhase].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Target(AnnotationTarget.CLASS)
annotation class ExplicitlyInvokedModelProcessingPhase(val id: String, val isBlocking: Boolean = false)

/**
 * Annotation to be used with one of the phase annotations [InitialModelProcessingPhase], [ModelProcessingPhase], or
 * [ExplicitlyInvokedModelProcessingPhase]. Determines commandline options, which are required by the respective phase.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Target(AnnotationTarget.CLASS)
annotation class RequiresBasicCommandLineOptions(vararg val requiredOptions: BasicOption)

/**
 * Annotation to mark functions that have to be executed before a phase is executed. The actual semantics and usage
 * depends on the respective phase. If a phase has more than one @Before function, the order of their executions is
 * random.
 *
 * For instance, in the context of the
 * [de.fhdo.ddmm.model_processing.builtin_phases.source_model_validation.SourceModelValidationPhase], functions within
 * an Xtext-based source model validator, i.e., implementers of
 * [de.fhdo.ddmm.model_processing.builtin_phases.source_model_validation.AbstractXtextSourceModelValidator], annotated
 * with @Before are executed before the validation of the Xtext model is executed. Moreover, depending of the phase,
 * functions annotated with @Before possibly need to exhibit a certain signature. In the case of Xtext-based source
 * model validators, @Before functions need a parameter of type [org.eclipse.emf.ecore.resource.Resource].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Target(AnnotationTarget.FUNCTION)
annotation class Before

/**
 * Annotation to mark functions that have to be executed after a phase was executed. The actual semantics and usage
 * depends on the respective phase. If a phase has more than one @After function, the order of their executions is
 * random.
 *
 * Currently, @After is not supported by any phase. However, it exhibits the same characteristics as [@Before](Before).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Target(AnnotationTarget.FUNCTION)
annotation class After