package de.fhdo.lemma.analyzer.lib.impl

import de.fhdo.lemma.analyzer.lib.analyzers.data_structures.UnifiedDependency
import de.fhdo.lemma.analyzer.lib.analyzers.data_structures.UnifiedOperations
import de.fhdo.lemma.analyzer.lib.getDefiningModel
import de.fhdo.lemma.analyzer.lib.getDependencies
import de.fhdo.lemma.analyzer.lib.getEffectiveProtocols
import de.fhdo.lemma.analyzer.lib.hasProtocol
import de.fhdo.lemma.analyzer.lib.impl.service.metrics.engel.DependencyGraph
import de.fhdo.lemma.analyzer.lib.resolve
import de.fhdo.lemma.analyzer.lib.toAbsoluteModelFileUri
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataModel
import de.fhdo.lemma.data.intermediate.IntermediateImportedComplexType
import de.fhdo.lemma.model_processing.utils.asXmiResource
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice
import de.fhdo.lemma.service.intermediate.IntermediateOperation
import de.fhdo.lemma.service.intermediate.IntermediateReferredOperation
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import de.fhdo.lemma.technology.CommunicationType
import org.eclipse.emf.ecore.EObject

/**
 * The [Cache] identifies its entries by means of [CacheId] instances. A [CacheId] assigns a unique [String]-based [id]
 * to the [modelClazz] of a certain model element. Note that the identify if a [CacheId] is determined by the hash code
 * of the [id] _and_ [modelClazz]. Consequently, two distinct [CacheId]s may have the same [id] but concern different
 * [modelClazz] values.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal data class CacheId(val id: String, val modelClazz: Class<*>) {
    /**
     * Convenience method to clone this [CacheId] by preceding its [id] with the given [suffix] [String].
     */
    fun cloneWithSuffix(suffix: String) = CacheId("$id${suffix.capitalize()}", modelClazz)
}

internal val DOMAIN_MODEL_CLASS = IntermediateDataModel::class.java
internal val SERVICE_MODEL_CLASS = IntermediateServiceModel::class.java
internal val OPERATION_MODEL_CLASS = IntermediateOperationModel::class.java

/* Global, reusable CacheIds */
internal val ALL_CONTEXTS_CACHE_ID = CacheId("allContexts", DOMAIN_MODEL_CLASS)
internal val ALL_INTERFACES_CACHE_ID = CacheId("allInterfaces", SERVICE_MODEL_CLASS)
internal val ALL_MICROSERVICES_CACHE_ID = CacheId("allMicroservices", SERVICE_MODEL_CLASS)
internal val ALL_OPERATIONS_CACHE_ID = CacheId("allOperations", SERVICE_MODEL_CLASS)
internal val ALL_OPERATION_NODES_CACHE_ID = CacheId("allOperationNodes", OPERATION_MODEL_CLASS)
internal val ALL_EFFECTIVE_PROTOCOLS_CACHE_ID = CacheId("allEffectiveProtocols", SERVICE_MODEL_CLASS)
internal val ALL_REFERRED_OPERATIONS_CACHE_ID = CacheId("allReferredOperations", SERVICE_MODEL_CLASS)
internal val MICROSERVICE_DEPENDENCIES_CACHE_ID = CacheId("microserviceDependencies", SERVICE_MODEL_CLASS)
internal val MICROSERVICE_DEPENDENCY_GRAPH_CACHE_ID = CacheId("microserviceDependencyGraph", SERVICE_MODEL_CLASS)
internal val MICROSERVICE_UNIFIED_OPERATIONS_CACHE_ID = CacheId("microserviceUnifiedOperations", SERVICE_MODEL_CLASS)
internal val RESOLVED_COMPLEX_TYPES_CACHE_ID = CacheId("resolvedComplexTypes", DOMAIN_MODEL_CLASS)
internal val RESOLVED_MICROSERVICES_CACHE_ID = CacheId("resolvedMicroservices", SERVICE_MODEL_CLASS)
internal val RUNTIME_LOADED_SERVICE_MODELS_CACHE_ID = CacheId("runtimeLoadedServiceModels", SERVICE_MODEL_CLASS)

/**
 * Singleton to cache elements from analysis models in a manner that is shareable across analyzers to speed up the
 * execution of certain recurrent tasks in model traversal.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object Cache : HashMap<CacheId, Any?>() {
    private val models = mutableMapOf<Class<out EObject>, MutableSet<EObject>>()

    /**
     * Clear all cache [models] and all cache entries with the given [modelClazz]
     */
    internal fun clearCache(modelClazz: Class<*>) {
        models.remove(modelClazz)
        val cacheIdsOfModelClass = keys.filter { it.modelClazz == modelClazz }
        cacheIdsOfModelClass.forEach { remove(it) }
    }

    /**
     * Add models to the [Cache]. The [Cache] can only maintain elements from these models.
     */
    internal fun <T: EObject> addModels(newModels: List<T>, modelClazz: Class<T>) {
        if (modelClazz !in models)
            models[modelClazz] = mutableSetOf()
        models[modelClazz]!!.addAll(newModels)
    }

    /**
     * Cache function: Get all IntermediateContext instances from cached domain models
     */
    internal fun allContexts() = addOrGetCacheIterable(ALL_CONTEXTS_CACHE_ID) {
        allModelsOfType(DOMAIN_MODEL_CLASS).map { it.contexts }.flatten()
    }

    /**
     * returns all OperationNodes
     */
    internal fun allOperationNodes() = addOrGetCacheIterable(ALL_OPERATION_NODES_CACHE_ID) {
        allModelsOfType(OPERATION_MODEL_CLASS).map{it.containers}.flatten()
    }

    /**
     * Convenience method to add the [Iterable] returned by the [getCollection] lambda to the [Cache] under the given
     * [CacheId]. In case the [id] is already in the [Cache], this method will return the existing entry.
     */
    private fun <T> addOrGetCacheIterable(id: CacheId, getCollection: () -> Iterable<T>) : Iterable<T> {
        if (isCached(id))
            return getFromCacheOrEmptyList(id)!!

        val collection = getCollection()
        cache(id, collection)
        return collection
    }

    /**
     * Get all [models] with the given [modelClazz]
     */
    @Suppress("UNCHECKED_CAST")
    private fun <T: EObject> allModelsOfType(modelClazz: Class<T>) = models[modelClazz] as? MutableSet<T> ?: emptySet()

    /**
     * Cache function: Get all IntermediateMicroservice instances from cached service models
     */
    internal fun allMicroservices() = addOrGetCacheIterable(ALL_MICROSERVICES_CACHE_ID) {
        allModelsOfType(SERVICE_MODEL_CLASS).map { it.microservices }.flatten()
    }

    /**
     * Cache function: Get all IntermediateInterface instances from cached service models
     */
    internal fun allInterfaces() = addOrGetCacheIterable(ALL_INTERFACES_CACHE_ID) {
        allMicroservices().map { it.interfaces }.flatten()
    }

    /**
     * Cache function: Get all [IntermediateOperation] instances from cached service models
     */
    internal fun allOperations() = addOrGetCacheIterable(ALL_OPERATIONS_CACHE_ID) {
        allInterfaces().map { it.operations }.flatten()
    }

    /**
     * Cache function: Get all [IntermediateOperation]s with the given [communicationType] and [protocolName] from
     * cached service models
     */
    internal fun allOperationsWithProtocol(communicationType: CommunicationType, protocolName: String)
        : Iterable<IntermediateOperation> {
        val cacheSuffix = "${communicationType.name}$protocolName"
        val cacheId = ALL_OPERATIONS_CACHE_ID.cloneWithSuffix(cacheSuffix)

        return addOrGetCacheIterable(cacheId) {
            allOperations().filter { it.hasProtocol(communicationType, protocolName) }
        }
    }

    /**
     * Cache function: Get all [IntermediateReferredOperation] instances from cached service models
     */
    internal fun allReferredOperations() = addOrGetCacheIterable(ALL_REFERRED_OPERATIONS_CACHE_ID) {
        allInterfaces().map { it.referredOperations }.flatten()
    }

    /**
     * Cache function: Get all [IntermediateReferredOperation] instances with the given [communicationType] and
     * [protocolName] from cached service models
     */
    internal fun allReferredOperationsWithProtocol(communicationType: CommunicationType, protocolName: String)
        : Iterable<IntermediateReferredOperation> {
        val cacheSuffix = "${communicationType.name}$protocolName"
        val cacheId = ALL_REFERRED_OPERATIONS_CACHE_ID.cloneWithSuffix(cacheSuffix)

        return addOrGetCacheIterable(cacheId) {
            allReferredOperations()
                .filter { operation -> operation.protocols.any {
                    it.communicationType == communicationType.name &&
                    it.protocol.equals(protocolName, ignoreCase = true)
                } }
        }
    }

    /**
     * Cache function: Get all effective IntermediateProtocolSpecification instances for all microservices, interfaces,
     * operations, and referred operations
     */
    internal fun allEffectiveProtocols() = addOrGetCacheIterable(ALL_EFFECTIVE_PROTOCOLS_CACHE_ID) {
        val protocols = allMicroservices().map { it.getEffectiveProtocols() }.flatten().toMutableList()
        protocols.addAll(allInterfaces().map { it.getEffectiveProtocols() }.flatten())
        protocols.addAll(allOperations().map { it.getEffectiveProtocols() }.flatten())
        protocols.addAll(allReferredOperations().map { it.getEffectiveProtocols() }.flatten())
        protocols
    }

    /**
     * Cache function: Resolve the given [IntermediateComplexType]
     */
    internal fun getResolvedType(complexType: IntermediateComplexType) : IntermediateComplexType {
        val domainModelUri = if (complexType !is IntermediateImportedComplexType)
                complexType.getDefiningModel<IntermediateDataModel>().sourceModelUri
            else
                complexType.import.importUri
        val cacheSuffix = domainModelUri + complexType.qualifiedName
        val cacheId = RESOLVED_COMPLEX_TYPES_CACHE_ID.cloneWithSuffix(cacheSuffix)
        return addOrGetCacheObject(cacheId) { complexType.resolve() }!!
    }

    /**
     * Convenience method to add the object returned by the [getObject] lambda to the [Cache] under the given [CacheId].
     * In case the [id] is already in the [Cache], this method will return the existing entry.
     */
    @Suppress("UNCHECKED_CAST")
    internal fun <T> addOrGetCacheObject(id: CacheId, getObject: () -> T) : T? {
        val existingCacheObject = Cache[id] as? T
        if (existingCacheObject != null)
            return existingCacheObject

        val cacheObject = getObject()
        cache(id, cacheObject)
        return cacheObject
    }

    /**
     * Cache function: Get all dependencies of the given [microservice]
     */
    internal fun getDependencies(microservice: IntermediateMicroservice, definingModelFilePath: String,
        noDuplicates: Boolean = true) : List<UnifiedDependency> {
        val cacheSuffix = "${microservice.qualifiedName}$$$definingModelFilePath$$$noDuplicates"
        val cacheId = MICROSERVICE_DEPENDENCIES_CACHE_ID.cloneWithSuffix(cacheSuffix)
        return addOrGetCacheObject(cacheId) { microservice.getDependencies(definingModelFilePath, noDuplicates) }!!
    }

    /**
     * Cache function: Get the [DependencyGraph] of the given [microservice]
     */
    internal fun getDependencyGraph(microservice: IntermediateMicroservice, definingModelFilePath: String)
        : DependencyGraph {
        val cacheSuffix = "${microservice.qualifiedName}$$$definingModelFilePath"
        val cacheId = MICROSERVICE_DEPENDENCY_GRAPH_CACHE_ID.cloneWithSuffix(cacheSuffix)
        return addOrGetCacheObject(cacheId) { DependencyGraph(microservice, definingModelFilePath) }!!
    }

    /**
     * Cache function: Resolve the [IntermediateMicroservice] with the given [microserviceQualifiedName] from the
     * service model at [modelFileUri] relative to the [baseFilePath]
     */
    internal fun getResolvedMicroservice(microserviceQualifiedName: String, modelFileUri: String, baseFilePath: String)
        : IntermediateMicroservice {
        val absoluteModelFileUri = modelFileUri.toAbsoluteModelFileUri(baseFilePath)
        val runtimeServiceModel = getServiceModel(absoluteModelFileUri)
        return getResolvedMicroservice(microserviceQualifiedName, runtimeServiceModel, absoluteModelFileUri)
    }

    /**
     * Helper to add or get an [IntermediateServiceModel] from the [Cache] by means of its [modelFileUri]
     */
    private fun getServiceModel(modelFileUri: String) : IntermediateServiceModel {
        val cacheId = RUNTIME_LOADED_SERVICE_MODELS_CACHE_ID.cloneWithSuffix(modelFileUri)
        return addOrGetCacheObject(cacheId) { modelFileUri.asXmiResource().contents[0] as IntermediateServiceModel }!!
    }

    /**
     * Cache function: Resolve the [IntermediateMicroservice] with the given [microserviceQualifiedName] from the
     * [serviceModel] at [modelFileUri]
     */
    internal fun getResolvedMicroservice(microserviceQualifiedName: String, serviceModel: IntermediateServiceModel,
        modelFileUri: String = serviceModel.sourceModelUri) : IntermediateMicroservice {
        val cacheId = RESOLVED_MICROSERVICES_CACHE_ID.cloneWithSuffix("${modelFileUri}$$${microserviceQualifiedName}")
        return addOrGetCacheObject(cacheId) {
            serviceModel.microservices.first { it.qualifiedName == microserviceQualifiedName }
        }!!
    }

    /**
     * Cache function: Get the [UnifiedOperations] for the given [microservice]
     */
    internal fun getUnifiedOperations(microservice: IntermediateMicroservice) : UnifiedOperations {
        val qualifiedName = microservice.qualifiedName
        val modelUri = microservice.serviceModel.sourceModelUri
        val cacheId = MICROSERVICE_UNIFIED_OPERATIONS_CACHE_ID.cloneWithSuffix("${modelUri}$$${qualifiedName}")
        return addOrGetCacheObject(cacheId) {
            val operations = microservice.interfaces.map { it.operations }.flatten()
            val referredOperations = microservice.interfaces.map { it.referredOperations }.flatten()
            UnifiedOperations(operations, referredOperations)
        }!!
    }
}

/**
 * Cache the given [entry] object under the given [id].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun cache(id: CacheId, entry: Any?) = Cache.put(id, entry)

/**
 * Get the [Iterable] entry with the given [id]. If it does not exist, return an empty, immutable [List]
 */
internal fun <T> getFromCacheOrEmptyList(id: CacheId) = getFromCacheOr<Iterable<T>>(id, emptyList())

/**
 * Get the entry with the given [id]. If it does not exist, return the [or] value.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("UNCHECKED_CAST")
internal fun <T> getFromCacheOr(id: CacheId, or: T?) = Cache[id] as? T? ?: or


/**
 * Check if the entry with the given [id] exists in the [Cache].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun isCached(id: CacheId) = id in Cache