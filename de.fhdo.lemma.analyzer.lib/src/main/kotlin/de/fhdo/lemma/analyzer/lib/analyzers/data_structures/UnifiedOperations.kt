package de.fhdo.lemma.analyzer.lib.analyzers.data_structures

import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.service.intermediate.IntermediateEndpoint
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.service.intermediate.IntermediateProtocolSpecification
import de.fhdo.lemma.service.intermediate.IntermediateReferredOperation

/**
 * Class to provide a unified view on [IntermediateOperation]s and [IntermediateReferredOperation]s.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("unused")
class UnifiedOperationView(
    val operation: IntermediateOperation,
    val endpoints: List<IntermediateEndpoint>,
    val protocols: List<IntermediateProtocolSpecification>,
    val aspects: List<IntermediateImportedAspect>
) {
    /**
     * Construct a [UnifiedOperationView] instance from an [IntermediateOperation]
     */
    constructor(operation: IntermediateOperation)
        : this(operation, operation.endpoints, operation.protocols, operation.aspects)

    /**
     * Construct a [UnifiedOperationView] instance from an [IntermediateReferredOperation]. The [operation] attribute of
     * the instance will point to the original operation.
     */
    constructor(referredOperation: IntermediateReferredOperation)
        : this(referredOperation.operation, referredOperation.endpoints, referredOperation.protocols,
            referredOperation.aspects)
}

/**
 * Shorthand extension method to create a [UnifiedOperations] instance from this list of [UnifiedOperationView]s.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun List<UnifiedOperationView>.toUnifiedOperations() = UnifiedOperations(this)

/**
 * List of [UnifiedOperationView]s with additional helper methods.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
class UnifiedOperations() : ArrayList<UnifiedOperationView>() {
    /**
     * Construct a [UnifiedOperations] instance that contains the given list of [IntermediateOperation]s and
     * [IntermediateReferredOperation]s.
     */
    constructor(
        operations: Iterable<IntermediateOperation>,
        referredOperations: Iterable<IntermediateReferredOperation>
    ) : this() {
        addOperations(operations)
        addReferredOperations(referredOperations)
    }

    /**
     * Construct a [UnifiedOperations] instance that contains the given [UnifiedOperationView] instances.
     */
    constructor(views: Iterable<UnifiedOperationView>) : this() {
        addAll(views)
    }

    /**
     * Add an [IntermediateOperation] to the list of [UnifiedOperations]
     */
    fun addOperation(operation: IntermediateOperation) = add(UnifiedOperationView(operation))

    /**
     * Add several [IntermediateOperation]s to the list of [UnifiedOperations]
     */
    fun addOperations(operations: Iterable<IntermediateOperation>) = addAll(operations.map { UnifiedOperationView(it) })

    /**
     * Add an [IntermediateReferredOperation] to the list of [UnifiedOperations]
     */
    fun addReferredOperation(operation: IntermediateReferredOperation) = add(UnifiedOperationView(operation))

    /**
     * Add several [IntermediateReferredOperation]s to the list of [UnifiedOperations]
     */
    fun addReferredOperations(operations: Iterable<IntermediateReferredOperation>)
            = addAll(operations.map { UnifiedOperationView(it) })
}