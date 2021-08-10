package de.fhdo.lemma.model_processing.phases

import de.fhdo.lemma.model_processing.annotations.ExplicitlyInvokedModelProcessingPhase
import de.fhdo.lemma.model_processing.annotations.InitialModelProcessingPhase
import de.fhdo.lemma.model_processing.annotations.ModelProcessingPhase
import de.fhdo.lemma.model_processing.annotations.findAnnotatedClasses
import de.fhdo.lemma.model_processing.annotations.get
import io.github.classgraph.AnnotationClassRef
import io.github.classgraph.ClassInfo
import java.lang.IllegalStateException
import java.util.LinkedList

private val PHASE_SUPERCLASS_NAME = AbstractModelProcessingPhase::class.java.name

/**
 * Load all model processing phases found in the "model_processing" package of the LEMMA project (for built-in phases)
 * and in the model processor implementer's package (for custom phases).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun loadProcessingPhases(modelProcessingPackage: String, processorImplementationPackage: String)
    : LinkedHashSet<AbstractModelProcessingPhase> {
    val initialPhase = findInitialProcessingPhase(modelProcessingPackage)
    val phasesAfterInitialPhase = findAnnotatedClasses(modelProcessingPackage, ModelProcessingPhase::class)
    // Prevent duplicates in case the implementation package is a sub-package of the model processing package
    if (!processorImplementationPackage.startsWith(modelProcessingPackage))
        phasesAfterInitialPhase.addAll(findAnnotatedClasses(processorImplementationPackage,
            ModelProcessingPhase::class))

    val loadedAndInitializedPhases = LinkedHashSet<AbstractModelProcessingPhase>()

    // Find all phases that are to invoked after the initial phase and iterate over all subsequent phases to also find
    // their successors. The resulting linked hash set of loaded and initialized phases keeps the insertion order. That
    // is, all loaded and initialized phases are later executed sequentially in the order they were found based on their
    // after-relationships resulting from their [ModelProcessingPhase] annotations. Note that if a phase has more than
    // one successor the execution order of the successors is random.
    val phasesToLoad = LinkedList<ClassInfo>()
    phasesToLoad.add(initialPhase)
    while (!phasesToLoad.isEmpty()) {
        val phaseToLoad = phasesToLoad.pop()
        loadedAndInitializedPhases.loadAndAddPhase(phaseToLoad, processorImplementationPackage)

        // Find the loaded phase's successors
        phasesToLoad.addAll(
            phasesAfterInitialPhase.filter {
                val after = it.annotationInfo[ModelProcessingPhase::class]!!.parameterValues!!.get("after").value
                    as AnnotationClassRef
                phaseToLoad.name == after.name
            }
        )
    }

    return loadedAndInitializedPhases
}

/**
 * Helper to find the initial model processing phase. Note that there can only be one phase annotated with
 * [InitialModelProcessingPhase].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun findInitialProcessingPhase(modelProcessingPackage: String) : ClassInfo {
    val annotatedClasses = findAnnotatedClasses(modelProcessingPackage, InitialModelProcessingPhase::class)

    return when (annotatedClasses.size) {
        0 -> throw IllegalStateException("Initial model processing phase not found")
        1 -> annotatedClasses[0]
        else -> throw IllegalStateException("Ambiguous initial model processing phases")
    }
}

/**
 * Load all model processing phases that are to be explicitly invoked via the commandline and thus not executed
 * automatically after any other phase.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun loadExplicitlyInvokedProcessingPhases(modelProcessingPackage: String,
    processorImplementationPackage: String) : LinkedHashSet<AbstractModelProcessingPhase> {
    val phases = findAnnotatedClasses(modelProcessingPackage, ExplicitlyInvokedModelProcessingPhase::class)
    // Prevent duplicates in case the implementation package is a sub-package of the model processing package
    if (!processorImplementationPackage.startsWith(modelProcessingPackage))
        phases.addAll(findAnnotatedClasses(processorImplementationPackage,
            ExplicitlyInvokedModelProcessingPhase::class))

    val loadedAndInitializedPhases = LinkedHashSet<AbstractModelProcessingPhase>()
    phases.forEach { loadedAndInitializedPhases.loadAndAddPhase(it, processorImplementationPackage) }

    return loadedAndInitializedPhases
}

/**
 * Convenience extension method of [MutableSet] to combine loading, initializing, and adding a model processing phase to
 * a phase set.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun MutableSet<AbstractModelProcessingPhase>.loadAndAddPhase(phaseToLoad: ClassInfo,
    processorImplementationPackage: String) {
    if (!phaseToLoad.extendsSuperclass(PHASE_SUPERCLASS_NAME))
        throw IllegalStateException("Designated model processing phase ${phaseToLoad.name} does not inherit " +
            "from $PHASE_SUPERCLASS_NAME")

    val newPhase = loadAndInitializeProcessingPhase(
        phaseToLoad,
        processorImplementationPackage
    )

    if (!add(newPhase))
        throw IllegalStateException("Duplicate phase ${newPhase.id}")
}

/**
 * Helper to load and initialize a model processing phase
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun loadAndInitializeProcessingPhase(phaseClassInfo: ClassInfo, processorImplementationPackage: String)
    : AbstractModelProcessingPhase {
    val phaseId = findPhaseAnnotationParameter<String>(phaseClassInfo, "id")
        ?: throw IllegalStateException("No model processing phase annotation found for designated model processing " +
            "phase ${phaseClassInfo.name}")
    val isOmittable = findPhaseAnnotationParameter<Boolean>(phaseClassInfo, "isOmittable")!!
    val isBlocking = findPhaseAnnotationParameter<Boolean>(phaseClassInfo, "isBlocking")!!

    /* Load and initialize the phase */
    val loadedPhase = phaseClassInfo
        .loadClass(AbstractModelProcessingPhase::class.java)
        .getDeclaredConstructor()
        .newInstance()

    loadedPhase.initialize(phaseId, isOmittable, isBlocking, processorImplementationPackage)
    return loadedPhase
}

/**
 * Helper to determine phase annotation parameter by brute-forcing each possible phase annotation
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun <T: Any> findPhaseAnnotationParameter(phaseClassInfo: ClassInfo, parameterName: String) : T? {
    /* Determine phase ID by brute-forcing on each possible annotation to mark a model processing phase */
    var parameterValue = phaseClassInfo.annotationInfo[InitialModelProcessingPhase::class]
        ?.parameterValues?.get(parameterName)

    if (parameterValue == null)
        parameterValue = phaseClassInfo.annotationInfo[ModelProcessingPhase::class]
            ?.parameterValues?.get(parameterName)

    if (parameterValue == null)
        parameterValue = phaseClassInfo.annotationInfo[ExplicitlyInvokedModelProcessingPhase::class]
            ?.parameterValues?.get(parameterName)

    @Suppress("UNCHECKED_CAST")
    return parameterValue?.value as? T
}