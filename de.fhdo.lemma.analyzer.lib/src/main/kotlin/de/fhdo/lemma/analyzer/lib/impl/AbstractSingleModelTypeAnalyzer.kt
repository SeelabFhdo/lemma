package de.fhdo.lemma.analyzer.lib.impl

import de.fhdo.lemma.analyzer.lib.getMetamodelConcept
import org.eclipse.emf.ecore.EObject

/**
 * Implementation of [AbstractAnalyzer] for analyzers that operate on a single analysis model.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal abstract class AbstractSingleModelTypeAnalyzer<T: EObject>(private val modelClazz: Class<T>)
    : AbstractAnalyzer() {
    protected val models = mutableListOf<T>()

    override fun checkAnalysisModels(modelRoots: List<EObject>) {
        super.checkAnalysisModels(modelRoots)
        require(modelRoots.all { modelClazz.isInstance(it) }) {
            "Analyzer models must be of type ${modelClazz::class.java.simpleName}"
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun setAnalysisModelsInternal(modelRoots: List<EObject>, clearModels: Boolean, clearCache: Boolean) {
        if (clearModels)
            models.clear()
        models.addAll(modelRoots.map { it as T })

        if (clearCache && modelRoots.isNotEmpty()) {
            // In case the previous unchecked cast to T succeeded, we can be sure that all model roots have the same
            // type
            val modelClazz = modelRoots[0].getMetamodelConcept()
            Cache.clearCache(modelClazz)
        }
        Cache.addModels(models, modelClazz)
    }
}