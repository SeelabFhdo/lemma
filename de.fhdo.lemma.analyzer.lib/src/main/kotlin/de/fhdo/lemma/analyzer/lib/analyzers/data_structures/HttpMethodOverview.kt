package de.fhdo.lemma.analyzer.lib.analyzers.data_structures

import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect
import de.fhdo.lemma.technology.CommunicationType

/**
 * Enumeration of HTTP methods.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("unused")
enum class HttpMethod(val string: String) {
    CONNECT("connect"),
    DELETE("delete"),
    GET("get"),
    HEAD("head"),
    OPTIONS("options"),
    PATCH("patch"),
    POST("post"),
    PUT("put"),
    TRACE("trace");

    companion object {
        /**
         * Value set of of the enumeration
         */
        val valueSet = values().toSet()

        /**
         * Create an [HttpMethod] from a given [String]
         */
        fun fromString(s: String) = values().find { it.string == s }
    }
}

/**
 * Get the list of [HttpMethod]s from this [UnifiedOperationView].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun UnifiedOperationView.getHttpMethods(httpMethods: Set<HttpMethod>)
    = aspects.map { it.toHttpMethodName() }.mapNotNull { HttpMethod.fromString(it) }.filter { it in httpMethods }

/**
 * Extract the name of an [HttpMethod] from this [IntermediateImportedAspect].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun IntermediateImportedAspect.toHttpMethodName() = name.toLowerCase().removeSuffix("mapping")

/**
 * Class to provide an overview of [HttpMethod]s for a given list of [UnifiedOperations].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
class HttpMethodOverview(private val unifiedOperations: UnifiedOperations,
    val httpMethods: Set<HttpMethod> = HttpMethod.valueSet) {
    val operationsWithHttpMethods = UnifiedOperations()
    private val httpMethodsPerOperation = mutableMapOf<UnifiedOperationView, Set<HttpMethod>>()
    private val operationsPerHttpMethod = mutableMapOf<HttpMethod, MutableSet<UnifiedOperationView>>()
    val operationsWithoutHttpMethods = UnifiedOperations()

    companion object {
        /**
         * Get the distribution of [HttpMethod]s for the given [operations] and [httpMethods]
         */
        fun getHttpMethodDistribution(operations: List<UnifiedOperationView>,
            httpMethods: Set<HttpMethod> = HttpMethod.valueSet) : Map<HttpMethod, Int> {
            val httpMethodsOfOperations = operations.map { it.getHttpMethods(httpMethods) }.flatten()
            return httpMethodsOfOperations.associateWith { method -> httpMethodsOfOperations.count { it == method } }
        }
    }

    /**
     * Initialization
     */
    init {
        for (unifiedOperation in unifiedOperations) {
            val matchingHttpMethods = unifiedOperation.aspects.getMatchingHttpMethods(httpMethods)
            if (matchingHttpMethods.isEmpty()) {
                operationsWithoutHttpMethods.add(unifiedOperation)
                continue
            }

            operationsWithHttpMethods.add(unifiedOperation)
            httpMethodsPerOperation[unifiedOperation] = matchingHttpMethods
            unifiedOperation.associateWithHttpMethods(matchingHttpMethods)
        }
    }

    /**
     * Associate this [UnifiedOperationView] with the given [httpMethods] in the [operationsPerHttpMethod] [Map]
     */
    private fun UnifiedOperationView.associateWithHttpMethods(httpMethods: Set<HttpMethod>) {
        httpMethods.forEach { httpMethod ->
            if (httpMethod !in operationsPerHttpMethod)
                operationsPerHttpMethod[httpMethod] = mutableSetOf()
            operationsPerHttpMethod[httpMethod]!!.add(this)
        }
    }

    /**
     * Iterate over all operations in the [HttpMethodOverview], for which [HttpMethod]s were detected
     */
    fun forEachHttpOperation(action: (UnifiedOperationView, Set<HttpMethod>) -> Unit)
        = operationsWithHttpMethods.forEach { action(it, httpMethodsPerOperation[it]!!) }

    /**
     * Get all detected [HttpMethod]s of the given [operation]
     */
    fun getHttpMethods(operation: UnifiedOperationView) : Set<HttpMethod> {
        require(operation in httpMethodsPerOperation) {
            "Operation ${operation.operation.qualifiedName} is not part of HTTP method overview"
        }
        return httpMethodsPerOperation[operation]!!
    }

    /**
     * Get all operations that specify an endpoint for the given [communicationType] and [protocol]. The
     * [includeHttpOperations] and [includeNonHttpOperations] parameters enable tto control whether operations with
     * and/or without [HttpMethod]s shall be considered.
     */
    fun getOperationsWithExplicitEndpoint(communicationType: CommunicationType, protocol: String,
        includeHttpOperations: Boolean = true, includeNonHttpOperations: Boolean = true) : UnifiedOperations {
        val operations = when {
            includeHttpOperations && includeNonHttpOperations -> unifiedOperations
            includeHttpOperations -> operationsWithHttpMethods
            includeNonHttpOperations -> operationsWithoutHttpMethods
            else -> UnifiedOperations()
        }

        val operationsWithEndpoints = operations.filter { operation ->
            operation.endpoints.any {
                it.communicationType == communicationType.name && it.protocol.toLowerCase() == protocol
            }
        }

        return UnifiedOperations(operationsWithEndpoints)
    }
}

/**
 * Get all [IntermediateImportedAspect]s from this list, which represent an [HttpMethod] from the given set of
 * [httpMethods].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun List<IntermediateImportedAspect>.getMatchingHttpMethods(httpMethods: Set<HttpMethod>)
    = mapNotNull {
            val httpMethod = HttpMethod.fromString(it.toHttpMethodName())
            if (httpMethod != null && httpMethod in httpMethods)
                httpMethod
            else
                null
        }.toSet()