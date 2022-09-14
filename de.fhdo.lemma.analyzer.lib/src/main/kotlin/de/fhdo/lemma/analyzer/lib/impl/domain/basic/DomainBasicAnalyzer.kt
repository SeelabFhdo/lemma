package de.fhdo.lemma.analyzer.lib.impl.domain.basic

import de.fhdo.lemma.analyzer.lib.analyzers.DomainBasicAnalyzerI
import de.fhdo.lemma.analyzer.lib.featureNames
import de.fhdo.lemma.analyzer.lib.filterAllEObjectInstances
import de.fhdo.lemma.analyzer.lib.forFeatures
import de.fhdo.lemma.analyzer.lib.impl.AbstractSingleModelTypeAnalyzer
import de.fhdo.lemma.analyzer.lib.impl.Cache
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataModel
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure
import de.fhdo.lemma.data.intermediate.IntermediateEnumeration
import de.fhdo.lemma.data.intermediate.IntermediateCollectionType

/**
 * Implementation of basic analyses on domain models.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class DomainBasicAnalyzer
    : AbstractSingleModelTypeAnalyzer<IntermediateDataModel>(IntermediateDataModel::class.java), DomainBasicAnalyzerI {
    override fun countBoundedContexts() = models.sumBy { it.contexts.size }

    override fun countDomainConcepts() = models.sumBy { it.filterAllEObjectInstances<IntermediateComplexType>().size }

    override fun <T> countDomainConceptsOfType(clazz: Class<T>) = models.sumBy {
        it.filterAllEObjectInstances(clazz).size
    }

    override fun countEnumerationsPerBoundedContext() = countComplexTypePerBoundedContext<IntermediateEnumeration>()

    /**
     * Helper to count [IntermediateComplexType] instances per bounded context
     */
    private inline fun <reified T: IntermediateComplexType> countComplexTypePerBoundedContext() : Map<String, Int> {
        val countPerBoundedContext = LinkedHashMap<String, Int>()
        Cache.allContexts().forEach {
                if (it.name !in countPerBoundedContext)
                    countPerBoundedContext[it.name] = 0
                val currentCount = countPerBoundedContext[it.name]!!
                countPerBoundedContext[it.name] = currentCount + it.complexTypes.filterIsInstance<T>().size
            }
        return countPerBoundedContext
    }

    override fun countCollectionTypesPerBoundedContext()
        = countComplexTypePerBoundedContext<IntermediateCollectionType>()

    override fun countDataStructuresPerBoundedContext() = countComplexTypePerBoundedContext<IntermediateDataStructure>()

    override fun countFeatures() = countFeatures(models.filterAllEObjectInstances())

    override fun countFeatures(complexTypes: List<IntermediateComplexType>) : Map<String, Int> {
        val featureCounts = mutableMapOf<String, Int>()
        for (complexType in complexTypes) {
            complexType.featureNames().forEach {
                val currentFeatureCount = featureCounts[it] ?: 0
                featureCounts[it] = currentFeatureCount + 1
            }
        }
        return featureCounts
    }

    override fun countFeaturesPerBoundedContext()
        = countFeaturesPerBoundedContext(models.filterIsInstance(IntermediateComplexType::class.java))

    override fun countFeaturesPerBoundedContext(complexTypes: List<IntermediateComplexType>)
        : Map<String, Map<String, Int>> {
        val featureCounts = mutableMapOf<String, MutableMap<String, Int>>()
        complexTypes.forFeatures { complexType, feature ->
            val context = complexType.context?.name ?: ""
            when {
                context !in featureCounts -> featureCounts[context] = mutableMapOf(feature to 1)
                feature !in featureCounts[context]!! -> featureCounts[context]!![feature] = 1
                else -> {
                    val currentFeatureCount = featureCounts[context]!![feature]!!
                    featureCounts[context]!![feature] = currentFeatureCount + 1
                }
            }
        }
        return featureCounts
    }

    override fun countFeaturesPerComplexTypeKind()
        = countFeaturesPerComplexTypeKind(models.filterIsInstance(IntermediateComplexType::class.java))

    override fun countFeaturesPerComplexTypeKind(complexTypes: List<IntermediateComplexType>)
        : Map<String, Map<String, Int>> {
        val featureCounts = mutableMapOf<String, MutableMap<String, Int>>()
        complexTypes.forFeatures { complexType, feature ->
            val complexTypeKind = complexType.kind.literal
            when {
                complexTypeKind !in featureCounts -> featureCounts[complexTypeKind] = mutableMapOf(feature to 1)
                feature !in featureCounts[complexTypeKind]!! -> featureCounts[complexTypeKind]!![feature] = 1
                else -> {
                    val currentFeatureCount = featureCounts[complexTypeKind]!![feature]!!
                    featureCounts[complexTypeKind]!![feature] = currentFeatureCount + 1
                }
            }
        }
        return featureCounts
    }
}