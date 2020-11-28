@file:Suppress("CascadeIf")

package de.fhdo.lemma.analyzer.lib.analyzers.data_structures

import de.fhdo.lemma.analyzer.lib.getDefiningModel
import de.fhdo.lemma.analyzer.lib.impl.Cache
import de.fhdo.lemma.analyzer.lib.toAbsoluteFilePath
import de.fhdo.lemma.service.intermediate.InterfaceReference
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import de.fhdo.lemma.service.intermediate.MicroserviceReference
import de.fhdo.lemma.service.intermediate.OperationReference

/**
 * Class to unify dependencies of a microservice to other microservices, their interfaces, or operations.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class UnifiedDependency private constructor (
    private val imported: Boolean,
    private val qualifiedMicroserviceName: String,
    val otherServiceModelFilePath: String
) {
    companion object {
        /**
         * Get the substring of this [String] before the last [count] delimiters. For example,
         *      "org.example.service".substringBeforeLast(".", 2)
         *  will return "org".
         */
        private fun String.substringBeforeLast(delimiter: String, count: Int) : String {
            var result = this
            for (n in 1..count)
                result = result.substringBeforeLast(delimiter, this)
            return result
        }

        /**
         * Construct a [UnifiedDependency] instance from a [MicroserviceReference]
         */
        internal fun from(reference: MicroserviceReference, otherServiceModelFilePath: String) : UnifiedDependency {
            return if (reference.isImported)
                UnifiedDependency(reference, otherServiceModelFilePath)
            else
                UnifiedDependency(reference)
        }

        /**
         * Construct a [UnifiedDependency] instance from an [InterfaceReference]
         */
        internal fun from(reference: InterfaceReference, otherServiceModelFilePath: String) : UnifiedDependency {
            return if (reference.isImported)
                UnifiedDependency(reference, otherServiceModelFilePath)
            else
                UnifiedDependency(reference)
        }

        /**
         * Construct a [UnifiedDependency] instance from an [OperationReference]
         */
        internal fun from(reference: OperationReference, otherServiceModelFilePath: String) : UnifiedDependency {
            return if (reference.isImported)
                UnifiedDependency(reference, otherServiceModelFilePath)
            else
                UnifiedDependency(reference)
        }
    }

    private val identifier
        = if (imported) "$otherServiceModelFilePath$$$qualifiedMicroserviceName" else "$$$qualifiedMicroserviceName"
    private var importUri = ""
    private var localModel: IntermediateServiceModel? = null

    lateinit var resolvedDependency: IntermediateMicroservice

    /**
     * Construct a [UnifiedDependency] instance that represents the dependency to a microservice with name
     * [qualifiedMicroserviceName] from the [importUri] that points to the service model at the
     * [otherServiceModelFilePath].
     */
    constructor(qualifiedMicroserviceName: String, importUri: String, otherServiceModelFilePath: String)
        : this(true, qualifiedMicroserviceName, otherServiceModelFilePath.toAbsoluteFilePath()) {
        this.importUri = importUri
        resolveDependency()
    }

    /**
     * Resolve the [IntermediateMicroservice], which defines this [UnifiedDependency], i.e., the independent
     * microservice itself, or one of its interfaces or operations
     */
    private fun resolveDependency() {
        resolvedDependency = if (imported)
            Cache.getResolvedMicroservice(qualifiedMicroserviceName, importUri, otherServiceModelFilePath)
        else
            Cache.getResolvedMicroservice(qualifiedMicroserviceName, localModel!!)
    }

    /**
     * Construct a [UnifiedDependency] instance that represents the dependency to a microservice with name
     * [qualifiedMicroserviceName] from same service model [localModel]. That is, the independent microservice does not
     * originate from another, imported service model.
     */
    constructor(qualifiedMicroserviceName: String, localModel: IntermediateServiceModel)
        : this(false, qualifiedMicroserviceName, "") {
        this.localModel = localModel
        resolveDependency()
    }

    /**
     * Construct a [UnifiedDependency] instance from the given [MicroserviceReference] that points to a microservice in
     * the service model at the [otherServiceModelFilePath].
     */
    constructor(reference: MicroserviceReference, otherServiceModelFilePath: String)
        : this(reference.qualifiedName, reference.import.importUri, otherServiceModelFilePath) {
        resolveDependency()
    }

    /**
     * Construct a [UnifiedDependency] instance from the given [MicroserviceReference] that points to a microservice in
     * the same service model as the dependent microservice.
     */
    constructor(reference: MicroserviceReference) : this(reference.qualifiedName, reference.getDefiningModel()) {
        resolveDependency()
    }

    /**
     * Construct a [UnifiedDependency] instance from the given [InterfaceReference] that points to an interface in the
     * service model at the [otherServiceModelFilePath].
     */
    constructor(reference: InterfaceReference, otherServiceModelFilePath: String) : this(
        reference.qualifiedName.substringBeforeLast("."),
        reference.import.importUri,
        otherServiceModelFilePath
    ) {
        resolveDependency()
    }

    /**
     * Construct a [UnifiedDependency] instance from the given [InterfaceReference] that points to an interface in the
     * same service model as the dependent microservice.
     */
    constructor(reference: InterfaceReference)
        : this(reference.qualifiedName.substringBeforeLast("."), reference.getDefiningModel()) {
        resolveDependency()
    }

    /**
     * Construct a [UnifiedDependency] instance from the given [OperationReference] that points to an operation in the
     * service model at the [otherServiceModelFilePath].
     */
    constructor(reference: OperationReference, otherServiceModelFilePath: String) : this(
        reference.qualifiedName.substringBeforeLast(".", 2),
        reference.import.importUri,
        otherServiceModelFilePath
    ) {
        resolveDependency()
    }

    /**
     * Construct a [UnifiedDependency] instance from the given [OperationReference] that points to an operation in the
     * same service model as the dependent microservice.
     */
    constructor(reference: OperationReference)
        : this(reference.qualifiedName.substringBeforeLast(".", 2), reference.getDefiningModel()){
        resolveDependency()
    }

    override fun hashCode() = identifier.hashCode()

    override fun equals(other: Any?)
        = if (this === other) true
            else if (other == null) false
            else if (other is UnifiedDependency) other.identifier == identifier
            else false
}