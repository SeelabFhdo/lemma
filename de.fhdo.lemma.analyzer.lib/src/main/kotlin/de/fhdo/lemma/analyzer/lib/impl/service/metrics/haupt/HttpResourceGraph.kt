package de.fhdo.lemma.analyzer.lib.impl.service.metrics.haupt

import de.fhdo.lemma.analyzer.lib.analyzers.data_structures.HttpMethod
import de.fhdo.lemma.analyzer.lib.analyzers.data_structures.HttpMethodOverview
import de.fhdo.lemma.analyzer.lib.extractDomainTerms
import de.fhdo.lemma.analyzer.lib.impl.Cache
import de.fhdo.lemma.analyzer.lib.impl.service.metrics.engel.DependencyGraph
import de.fhdo.lemma.analyzer.lib.operationsWithProtocolAndExclusiveVisibility
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.data.intermediate.IntermediateCollectionType
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediateParameter
import de.fhdo.lemma.technology.CommunicationType
import de.fhdo.lemma.technology.ExchangePattern
import org.jgrapht.GraphPath
import org.jgrapht.alg.shortestpath.AllDirectedPaths
import org.jgrapht.graph.DefaultDirectedGraph
import org.jgrapht.graph.DefaultEdge
import org.jgrapht.nio.DefaultAttribute
import org.jgrapht.nio.dot.DOTExporter
import java.io.StringWriter
import java.util.ArrayDeque

private typealias Resources = Map<String, IntermediateComplexType>
internal typealias ResourcesPerHttpMethod = Map<HttpMethod, Set<IntermediateComplexType>>

private val READ_ONLY_HTTP_METHODS = setOf(HttpMethod.GET)

// Stateful methods according to https://tools.ietf.org/html/rfc7231#section-4.3
private val WRITE_HTTP_METHODS = setOf(HttpMethod.DELETE, HttpMethod.PATCH, HttpMethod.POST, HttpMethod.PUT)

/**
 * Class to represent a graph of HTTP resources for a [microservice] according to the metrics suite of
 * [Haupt et al.](https://ieeexplore.ieee.org/abstract/document/7930199). The class identifies HTTP resources from the
 * microservice by means of the parameters of the service's operations with a certain [protocolName], e.g., "HTTP" or
 * "REST", and for the given [communicationType] (most likely, this will be synchronous given the common usage of HTTP).
 *
 * Basically, An HTTP resource graph is a directed, unweighted graph. Its vertices represent HTTP resources and and edge
 * indicates a "part-of" relationship between two HTTP resources. The target vertex of the edge is a nested resource
 * (part-of) the resource represented by the source vertex.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("MemberVisibilityCanBePrivate")
class HttpResourceGraph(
    val microservice: IntermediateMicroservice,
    val protocolName: String,
    val communicationType: CommunicationType
) : DefaultDirectedGraph<ResourceGraphVertex, DefaultEdge>(DefaultEdge::class.java) {
    val resources: Resources
    val resourcesPerHttpMethod: ResourcesPerHttpMethod
    val rootResources: List<String>
    val readOnlyResources: Set<String>
    val deleteResources: Set<String>
    val postResources: Set<String>
    val linkCount: Int
    val longestResourcePath: List<String>

    /**
     * Initialization
     */
    init {
        val (resources, resourcesPerHttpMethod) = determineResources()
        this.resources = resources
        this.resourcesPerHttpMethod = resourcesPerHttpMethod

        setupResourceGraph(resources.values)
        rootResources = getRoots().map { it.qualifiedName }
        readOnlyResources = resourcesPerHttpMethod.filterReadOnlyResources()
        deleteResources = resourcesPerHttpMethod.filterByMethods(setOf(HttpMethod.DELETE))
        postResources = resourcesPerHttpMethod.filterByMethods(setOf(HttpMethod.POST))
        linkCount = edgeSet().count()
        longestResourcePath = longestPath()?.vertexList?.map { it.qualifiedName } ?: emptyList()
    }

    /**
     * Helper to determine HTTP resources from the [microservice]s REST operations
     */
    private fun determineResources() : Pair<Resources, ResourcesPerHttpMethod> {
        val resources = mutableMapOf<String, IntermediateComplexType>()
        val resourcesPerHttpMethod = mutableMapOf<HttpMethod, MutableSet<IntermediateComplexType>>()

        getHttpMethodOverview().forEachHttpOperation { unifiedOperation, httpMethods ->
            val candidateResourceParameters = unifiedOperation.operation.parameters.filter { it.mayHandleResource() }
            val handledResourceTypes = candidateResourceParameters.resolveUniqueResourceTypes()

            for (resourceType in handledResourceTypes) {
                resources[resourceType.qualifiedName] = resourceType
                httpMethods.forEach { httpMethod ->
                    if (httpMethod !in resourcesPerHttpMethod)
                        resourcesPerHttpMethod[httpMethod] = mutableSetOf()
                    resourcesPerHttpMethod[httpMethod]!!.add(resourceType)
                }
            }
        }

        return resources to resourcesPerHttpMethod
    }

    /**
     * Helper to retrieve an [HttpMethodOverview] for the operations of the current [microservice]
     */
    private fun getHttpMethodOverview() : HttpMethodOverview {
        // The relevant operations for the HTTP method overview have the given communication type and protocol name, and
        // have a public or architecture visibility to actually enable resource manipulation
        val operations = microservice.operationsWithProtocolAndExclusiveVisibility(protocolName, communicationType)
        return HttpMethodOverview(operations)
    }

    /**
     * Check if this [IntermediateParameter] is a candidate for handling HTTP resources. Specifically, such
     * [IntermediateParameter]s have an incoming direction.
     */
    private fun IntermediateParameter.mayHandleResource() =
        communicationType == this.communicationType &&
        exchangePattern in listOf(ExchangePattern.IN.name, ExchangePattern.INOUT.name)

    /**
     * Helper to resolve all resource [IntermediateComplexType]s of this list of [IntermediateParameter]s. This method
     * will filter duplicate [IntermediateComplexType]s based on their qualified names.
     */
    private fun List<IntermediateParameter>.resolveUniqueResourceTypes()
        = map { it.resolveUniqueResourceTypes() }.flatten().distinctBy { it.qualifiedName }

    /**
     * Helper to resolve all resource [IntermediateComplexType]s of this [IntermediateParameter]. The resulting list of
     * [IntermediateComplexType]s will also comprise nested resources. This method will filter duplicate
     * [IntermediateComplexType]s based on their qualified names.
     */
    private fun IntermediateParameter.resolveUniqueResourceTypes() : List<IntermediateComplexType> {
        if (type !is IntermediateComplexType)
            return emptyList()

        val resourceTypes = (type as IntermediateComplexType).resolveResourceTypes()
        return resourceTypes.distinctBy { it.qualifiedName }
    }

    /**
     * Helper to resolve all nested resource [IntermediateComplexType]s of this [IntermediateComplexType]. We do not
     * consider enumerations as HTTP resources and the method will return an empty list if this
     * [IntermediateComplexType] is an enumeration.
     */
    private fun IntermediateComplexType.resolveResourceTypes(includeValueObjects: Boolean = true)
        = when(val resolvedType = Cache.getResolvedType(this)) {
            is IntermediateDataStructure -> resolvedType.resolveResourceTypes(includeValueObjects)
            is IntermediateCollectionType -> resolvedType.resolveResourceTypes()
            else -> emptyList()
        }

    /**
     * Helper to resolve all nested resource [IntermediateComplexType]s of this [IntermediateDataStructure]. We only
     * consider [IntermediateDataStructure] that are aggregates or entities as resources.
     *
     * In case the [includeValueObjects] parameter is set to true, we also try to identify resources based on the domain
     * terms in the name of the value object. That is, because microservice operations may only operate on value objects
     * (as DTOs) and not on aggregates or entities directly. Suppose for example a value object named "CustomerDto" that
     * represents a DTO for the "Customer" entity. In this case, the method will extract the domain term "Customer" from
     * the name of the value object and match the "Customer" entity. Consequently, it will treat the "Customer" entity
     * to also represent an HTTP resource handled by the microservice operation that receives "CustomerDto" instances.
     */
    private fun IntermediateDataStructure.resolveResourceTypes(includeValueObjects: Boolean) = when {
        isResource() -> listOf(this)
        "VALUE_OBJECT" in featureNames && includeValueObjects -> {
            val siblingResources = this.eContainer().eContents()
                .filterIsInstance<IntermediateDataStructure>()
                .filter { it.isResource() }
            val domainTerms = name.extractDomainTerms()
            var currentPrefixTerms: String
            val matchingResources = mutableListOf<IntermediateComplexType>()
            // Count backwards to, e.g., match CustomerProfile (Entity) and CustomerAggregateRoot (Aggregate)
            // separately. Otherwise, when counting forward, both resource types would be matched by the name CustomerId
            // and counted only once. That is, because both start with the term "Customer".
            for (n in domainTerms.size downTo 1) {
                currentPrefixTerms = domainTerms.subList(0, n).joinToString("")
                matchingResources.addAll(siblingResources.filter { it.name.startsWith(currentPrefixTerms) })
            }
            matchingResources
        }
        else -> emptyList()
    }

    /**
     * Check is this [IntermediateDataStructure] represents an HTTP resource, which is the case when it is an aggregate
     * or entity
     */
    private fun IntermediateDataStructure.isResource() = featureNames.any { it == "AGGREGATE" || it == "ENTITY" }

    /**
     * Helper to resolve all nested resource [IntermediateComplexType]s of this [IntermediateCollectionType]. Nested
     * resources can only occur in structured collection types.
     */
    private fun IntermediateCollectionType.resolveResourceTypes() : List<IntermediateComplexType>
        = dataFields.filterIsInstance<IntermediateComplexType>().map { it.resolveResourceTypes() }.flatten()

    /**
     * Setup the actual HTTP resource graph. This method also tries to find additional nested resources from the given
     * [initialResourceTypes].
     */
    private fun setupResourceGraph(initialResourceTypes: Collection<IntermediateComplexType>) {
        val resourceTypesTodo = ArrayDeque(initialResourceTypes)
        val doneResourceTypes = mutableSetOf<String>()

        while(resourceTypesTodo.isNotEmpty()) {
            val resourceType = resourceTypesTodo.pop()
            val resourceTypeVertex = addVertex(resourceType)
            doneResourceTypes.add(resourceTypeVertex.qualifiedName)

            resourceType.getNestedResources().forEach {
                val nestedVertex = addVertex(it, resourceTypeVertex)
                if (nestedVertex.qualifiedName !in doneResourceTypes)
                    resourceTypesTodo.add(it)
            }
        }
    }

    /**
     * Add a vertex to the HTTP resource graph for the given [resourceType] representing an HTTP resource.
     * The [parentVertex] may identify the defining resource of the nested [resourceType].
     */
    private fun addVertex(resourceType: IntermediateComplexType, parentVertex: ResourceGraphVertex? = null)
        : ResourceGraphVertex {
        val vertex = ResourceGraphVertex(resourceType)
        addVertex(vertex)

        if (parentVertex != null)
            addEdge(parentVertex, vertex)

        return vertex
    }

    /**
     * Helper to find all nested resource [IntermediateComplexType]s of this [IntermediateComplexType] resource. A
     * nested resource either originates from the non-hidden data fields of [IntermediateDataStructure]s or from data
     * fields in structured [IntermediateCollectionType]s.
     */
    private fun IntermediateComplexType.getNestedResources() : List<IntermediateComplexType> {
        val nestedFieldsWithComplexTypes = when (this) {
            is IntermediateDataStructure -> dataFields.filter { !it.isHidden && it.type is IntermediateComplexType }
            is IntermediateCollectionType -> dataFields.filter { it.type is IntermediateComplexType }
            else -> return emptyList()
        }

        val nestedResourceTypes = nestedFieldsWithComplexTypes
            // Don't derive resources from value objects as we are only interested in the links between "real"
            // resources, i.e., aggregates and entities
            .map { (it.type as IntermediateComplexType).resolveResourceTypes(false) }
            .flatten()
        return nestedResourceTypes.map { Cache.getResolvedType(it) }
    }

    /**
     * Get the root resources of this [HttpResourceGraph]
     */
    private fun getRoots() = vertexSet().filter { vertex -> incomingEdgesOf(vertex).isEmpty() }

    /**
     * Filter all read-only resources from this [ResourcesPerHttpMethod] instance. Read-only resources must stem from
     * microservice operations that do not provide [WRITE_HTTP_METHODS] but one or more [READ_ONLY_HTTP_METHODS].
     */
    private fun ResourcesPerHttpMethod.filterReadOnlyResources() : Set<String> {
        val writeResources = filterByMethods(WRITE_HTTP_METHODS)
        return filterByMethods(READ_ONLY_HTTP_METHODS)
            // A read-only resource must not also be a write resource
            .filter { it !in writeResources }
            .toSet()
    }

    /**
     * Helper to filter the HTTP methods in this [ResourcesPerHttpMethod] instance by the given [httpMethods]
     */
    private fun ResourcesPerHttpMethod.filterByMethods(httpMethods: Set<HttpMethod>)
        = httpMethods.mapNotNull { this[it] }.flatten().map { it.qualifiedName }.toSet()

    /**
     * Find the longest path of vertices in the [HttpResourceGraph]. In case there are longest paths with the same
     * number of vertices, the method will only return one of them.
     */
    private fun longestPath() : GraphPath<ResourceGraphVertex, DefaultEdge>? {
        val roots = getRoots().toSet()
        val leaves = getLeaves().toSet()
        val allPaths = AllDirectedPaths(this).getAllPaths(roots, leaves, false, Integer.MAX_VALUE)
        return allPaths.maxByOrNull { it.length }
    }

    /**
     * Get the leave resources of this [HttpResourceGraph]
     */
    private fun getLeaves() = vertexSet().filter { vertex -> outgoingEdgesOf(vertex).isEmpty() }

    /**
     * Return a [String] representation of this [DependencyGraph] in GraphViz's DOT format
     */
    override fun toString(): String {
        val exporter = DOTExporter<ResourceGraphVertex, DefaultEdge>()
        exporter.setVertexAttributeProvider { vertex ->
            mapOf("label" to DefaultAttribute.createAttribute(vertex.qualifiedName))
        }

        val writer = StringWriter()
        exporter.exportGraph(this, writer)
        return writer.toString()
    }
}