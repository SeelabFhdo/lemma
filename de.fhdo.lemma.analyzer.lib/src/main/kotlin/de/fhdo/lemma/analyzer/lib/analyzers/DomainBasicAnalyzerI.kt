package de.fhdo.lemma.analyzer.lib.analyzers

import de.fhdo.lemma.analyzer.lib.AnalyzerI
import de.fhdo.lemma.data.intermediate.IntermediateComplexType

/**
 * Perform basic analyses on domain models.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
interface DomainBasicAnalyzerI : AnalyzerI {
    /**
     * Count the number of bounded contexts
     */
    fun countBoundedContexts() : Int

    /**
     * Count all domain concepts
     */
    fun countDomainConcepts() : Int

    /**
     * Count all domain concepts that are of the given [clazz]
     */
    fun <T> countDomainConceptsOfType(clazz: Class<T>) : Int

    /**
     * Count the number of enumerations per bounded context
     */
    fun countEnumerationsPerBoundedContext() : Map<String, Int>

    /**
     * Count the number of collection types per bounded context
     */
    fun countCollectionTypesPerBoundedContext() : Map<String, Int>

    /**
     * Count the number of data structures per bounded context
     */
    fun countDataStructuresPerBoundedContext() : Map<String, Int>

    /**
     * Count features
     */
    fun countFeatures() : Map<String, Int>

    /**
     * Count features on the given list of [complexTypes]
     */
    fun countFeatures(complexTypes: List<IntermediateComplexType>) : Map<String, Int>

    /**
     * Count features per bounded context
     */
    fun countFeaturesPerBoundedContext() : Map<String, Map<String, Int>>

    /**
     * Count features per bounded context for the given list of [complexTypes]
     */
    fun countFeaturesPerBoundedContext(complexTypes: List<IntermediateComplexType>) : Map<String, Map<String, Int>>

    /**
     * Count features per complex type kind, i.e., "COLLECTION", "ENUMERATION", and "STRUCTURE"
     */
    fun countFeaturesPerComplexTypeKind() : Map<String, Map<String, Int>>

    /**
     * Count features per complex type kind, i.e., "COLLECTION", "ENUMERATION", and "STRUCTURE", for the given list of
     * [complexTypes]
     */
    fun countFeaturesPerComplexTypeKind(complexTypes: List<IntermediateComplexType>) : Map<String, Map<String, Int>>
}