package de.fhdo.lemma.analyzer.lib

import de.fhdo.lemma.analyzer.lib.analyzers.data_structures.UnifiedDependency
import de.fhdo.lemma.analyzer.lib.analyzers.data_structures.UnifiedOperationView
import de.fhdo.lemma.analyzer.lib.analyzers.data_structures.UnifiedOperations
import de.fhdo.lemma.analyzer.lib.analyzers.data_structures.toUnifiedOperations
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataModel
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.data.intermediate.IntermediateEnumeration
import de.fhdo.lemma.data.intermediate.IntermediateImportedComplexType
import de.fhdo.lemma.model_processing.utils.loadModelRootRelative
import de.fhdo.lemma.model_processing.utils.removeFileUri
import de.fhdo.lemma.service.Visibility
import de.fhdo.lemma.service.intermediate.IntermediateInterface
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.service.intermediate.IntermediateProtocolSpecification
import de.fhdo.lemma.service.intermediate.IntermediateReferredOperation
import de.fhdo.lemma.technology.CommunicationType
import de.fhdo.lemma.utils.LemmaUtils
import org.eclipse.emf.ecore.EObject
import java.io.File
import java.lang.IllegalArgumentException

/**
 * Filter all sub-contents of this [EObject] by the given type [T].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
inline fun <reified T> EObject.filterAllEObjectInstances() : List<T> {
    val results = mutableListOf<T>()
    for (e in eAllContents()) {
        val targetInstance = e as? T ?: continue
        results.add(targetInstance)
    }
    return results
}

/**
 * Filter all sub-contents of this list of [EObject]s by the given type [T].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
inline fun <reified T> List<EObject>.filterAllEObjectInstances() = map { it.filterAllEObjectInstances<T>() }.flatten()

/**
 * Filter all sub-contents of this [EObject] by the given class [clazz].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("UNCHECKED_CAST")
fun <T> EObject.filterAllEObjectInstances(clazz: Class<T>) : List<T> {
    val results = mutableListOf<T>()
    eAllContents().forEach {
        if (clazz.isInstance(it))
            results.add(it as T)
    }
    return results
}

/**
 * Iterate through the feature names of the given list of [IntermediateComplexType]s, and execute [f] for each complex
 * type and feature.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun List<IntermediateComplexType>.forFeatures(f: (IntermediateComplexType, String) -> Unit)
    = forEach { complexType ->
        complexType.featureNames().sorted().forEach { feature -> f(complexType, feature) }
    }

/**
 * Get the names of all features of this [IntermediateComplexType].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateComplexType.featureNames()
    = when (this) {
        is IntermediateDataStructure -> featureNames
        is IntermediateEnumeration -> featureNames
        else -> emptyList()
    }

/**
 * Get the effective protocols of this [EObject], which may be an [IntermediateMicroservice], [IntermediateInterface],
 * [IntermediateOperation], or [IntermediateReferredOperation].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun EObject.getEffectiveProtocols() : List<IntermediateProtocolSpecification> {
    val (allProtocols, endpoints) = when (this) {
        is IntermediateMicroservice -> protocols to endpoints
        is IntermediateInterface -> protocols to endpoints
        is IntermediateOperation -> protocols to endpoints
        is IntermediateReferredOperation -> protocols to endpoints
        else -> throw IllegalArgumentException("${this::class.java.simpleName} does not have protocols and endpoints")
    }

    // We want IntermediateProtocolSpecification instances. Consequently, we do not retrieve the protocol information
    // from the IntermediateEndpoint but from the IntermediateProtocolSpecification instances. Moreover, the filter
    // finds the effective protocols, i.e., the protocols that are really applied by endpoints on this EObject.
    return allProtocols.filter { protocol ->
        endpoints.any {
            it.communicationType == protocol.communicationType &&
            it.protocol == protocol.protocol &&
            it.dataFormat == protocol.dataFormat
        }
    }
}

/**
 * Resolve this [IntermediateComplexType].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateComplexType.resolve() : IntermediateComplexType {
    /* Determine the defining model and referencing parts (version name, context name, and simple name) of this type */
    val definingModelUri = if (this is IntermediateImportedComplexType) import.importUri else null
    val definingModel = if (definingModelUri != null) {
            val importingModelFilePath = eResource().uri.toString().removeFileUri()
            loadModelRootRelative(definingModelUri, importingModelFilePath)
        } else
            getDefiningModel<IntermediateDataModel>()
    val (versionName, contextName, simpleName) = getQualifiedNameParts()

    /* Determine sources of this type's referencing parts (version and context instances) */
    val version = if (versionName != null) definingModel.versions.find { it.name == versionName } else null

    val context = if (contextName != null) {
        // A context may be part of a version or reside on the top-level of a data model
        if (version != null)
            version.contexts.find { it.name == contextName }
        else
            definingModel.contexts.find { it.name == contextName }
    } else
        null

    /* Resolve the type */
    val resolvedType = if (version != null && context != null)
    // According to its qualified name, the type is defined in a context within a version
        context.complexTypes.find { it.name == simpleName }
    else if (version != null && context == null)
    // According to its qualified name, the type is directly defined in a version
        version.complexTypes.find { it.name == simpleName }
    else if (context != null)
    // According to its qualified name, the type is directly defined in a context
        context.complexTypes.find { it.name == simpleName }
    else
    // There is neither a version nor a context surrounding the type (according to its qualified name), i.e., the
    // type is defined on the top-level of the model itself
        definingModel.complexTypes.find { it.name == simpleName }

    require(resolvedType != null) { "Complex type $qualifiedName could not be resolved" }
    return resolvedType
}

/**
 * Get the defining model of this [EObject], i.e., the root of the [EObject]'s object graph.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal inline fun <reified T: EObject> EObject.getDefiningModel() : T {
    var container = eContainer()
    while (container !is T)
        container = container.eContainer()
    return container
}

/**
 * Get the qualified name parts of this [IntermediateComplexType] as a [Triple]. If not null, the first triple component
 * is the type's version. If not null, the second triple component is the type's context. The third triple component is
 * never null and holds the type's simple, non-qualified name.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun IntermediateComplexType.getQualifiedNameParts() : Triple<String?, String?, String> {
    val qualifiedNameParts = qualifiedName.split(".")

    val version = if (qualifiedNameParts.size == 3) qualifiedNameParts[0] else null

    val context = when(qualifiedNameParts.size) {
        3 -> qualifiedNameParts[1]
        2 -> qualifiedNameParts[0]
        else -> null
    }

    val simpleName = when(qualifiedNameParts.size) {
        3 -> qualifiedNameParts[2]
        2 -> qualifiedNameParts[1]
        else -> qualifiedNameParts[0]
    }

    return Triple(version, context, simpleName)
}

/**
 * Get all [UnifiedOperations] of this [IntermediateMicroservice] with the given [protocolName], [communicationType],
 * and visibility kinds in the [visibilitySet]. By default, the considered visibility kinds are public and architecture.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateMicroservice.operationsWithProtocolAndExclusiveVisibility(
    protocolName: String,
    communicationType: CommunicationType,
    visibilitySet: Set<Visibility> = setOf(Visibility.PUBLIC, Visibility.ARCHITECTURE)
) : UnifiedOperations {
    val visibilitySetStrings = visibilitySet.map { it.name }
    if (visibility !in visibilitySetStrings)
        return UnifiedOperations()

    val unifiedOperations = UnifiedOperations()
    val interfaces = interfaces.filter { visibility in visibilitySetStrings }
    unifiedOperations.addAll(interfaces.map { it.operations }.flatten().map { UnifiedOperationView(it) })
    unifiedOperations.addAll(interfaces.map { it.referredOperations }.flatten().map { UnifiedOperationView(it) })
    return unifiedOperations.filter {
            it.operation.visibility in visibilitySetStrings &&
            it.operation.hasProtocol(communicationType, protocolName)
        }.toUnifiedOperations()
}

/**
 * Check if this [IntermediateOperation] has a protocol of the given [communicationType] and [protocolName].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateOperation.hasProtocol(communicationType: CommunicationType, protocolName: String)
    = protocols.any {
           it.communicationType == communicationType.name &&
           it.protocol.equals(protocolName, ignoreCase = true)
        }

/**
 * Extract domain terms from this [String]. We consider a domain term as a substring of this [String], whose first
 * letter has a different capitalization than the previous term. The [includeFirstTerm] parameter indicates whether to
 * include the first term of this [String] in the list of resulting domain terms. For instance, for the [String]
 * "getCustomerProfile" this method will return the list ["Customer", "Profile"] ([includeFirstTerm] = false) or
 * ["get", "Customer", "Profile"] ([includeFirstTerm] = true).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun String.extractDomainTerms(includeFirstTerm: Boolean = true) : List<String> {
    val candidateTerms = split("(?=\\p{Lu})".toRegex()).filter { it.isNotEmpty() }
    return when {
        includeFirstTerm -> candidateTerms
        candidateTerms.size == 1 -> emptyList()
        else -> candidateTerms.subList(1, candidateTerms.size)
    }
}

/**
 * Convert this [String] to an absolute file path.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun String.toAbsoluteFilePath()
    = with(File(this)) {
        if (this.isAbsolute)
            this@toAbsoluteFilePath
        else
            this.absoluteFile.canonicalPath
    }

/**
 * Convert this [String] to an absolute file URI.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun String.toAbsoluteModelFileUri(baseFilePath: String) : String {
    val absoluteBaseFilePath = baseFilePath.toAbsoluteFilePath()
    val modelFilePath = LemmaUtils.removeFileUri(this).removePrefix("//")
    return LemmaUtils.convertToAbsoluteFileUri(modelFilePath, absoluteBaseFilePath)
}

/**
 * Get all required microservices, interfaces, and operations of this [IntermediateMicroservice] from the service model
 * at the given [definingModelFilePath] in the form of [UnifiedDependency] instances. The [noDuplicates] flag indicates
 * whether to filter out duplicate dependencies or not (true by default).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun IntermediateMicroservice.getDependencies(definingModelFilePath: String, noDuplicates: Boolean = true)
    : List<UnifiedDependency> {
    val dependencies = Dependencies(noDuplicates)

    requiredMicroservices.forEach {
        dependencies.addWithDuplicateCheck(UnifiedDependency.from(it, definingModelFilePath))
    }
    requiredInterfaces.forEach { dependencies.addWithDuplicateCheck(UnifiedDependency.from(it, definingModelFilePath)) }
    requiredOperations.forEach { dependencies.addWithDuplicateCheck(UnifiedDependency.from(it, definingModelFilePath)) }

    return dependencies
}

/**
 * Helper implementation of [ArrayList] to maintain a list if [UnifiedDependency] instances with possible
 * duplicate-filtering.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private class Dependencies(val noDuplicates: Boolean) : ArrayList<UnifiedDependency>() {
    private val duplicateFilter = mutableSetOf<UnifiedDependency>()

    /**
     * Add a new [UnifiedDependency] to the list, possibly with duplicate-filtering
     */
    fun addWithDuplicateCheck(dependency: UnifiedDependency)
        = when {
                noDuplicates -> add(dependency)
                duplicateFilter.add(dependency) -> add(dependency)
                else -> false
            }
}

/**
 * Divide this [Int] by [n] and return the result or [divisionByZeroDefault] in case [n] is 0. [divisionByZeroDefault]
 * defaults to [Double.NaN].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun Int.divideBy(n: Int, divisionByZeroDefault: Double = Double.NaN)
    = if (n == 0) divisionByZeroDefault else toDouble() / n

/**
 * Convert this [String] to the matching [CommunicationType] literal. The identification of the matching literal is
 * case-insensitive. In case no matching literal can be found, this method throws an [IllegalArgumentException].
 */
internal fun String.toCommunicationTypeLiteral()
    = when(this.toLowerCase()) {
            CommunicationType.ASYNCHRONOUS.name.toLowerCase() -> CommunicationType.ASYNCHRONOUS
            CommunicationType.SYNCHRONOUS.name.toLowerCase() -> CommunicationType.SYNCHRONOUS
            else -> throw IllegalArgumentException("Unknown communication type literal \"$this\"")
        }