package de.fhdo.lemma.analyzer.lib.impl

import de.fhdo.lemma.analyzer.lib.AnalyzerI
import org.eclipse.emf.ecore.EObject

/**
 * Superclass for all analyzers including those for metrics calculation. Provides a convenience implementation of the
 * [AnalyzerI] interface.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal abstract class AbstractAnalyzer : AnalyzerI {
    override fun setAnalysisModels(modelRoots: List<EObject>, clearModels: Boolean, clearCache: Boolean) {
        checkAnalysisModels(modelRoots)
        setAnalysisModelsInternal(modelRoots, clearModels, clearCache)
    }

    /**
     * Version of [setAnalysisModels] for analyzer-specific (i.e., "internal") preparations of analysis models. Will be
     * invoked by [setAnalysisModels] at the end of its execution.
     */
    internal abstract fun setAnalysisModelsInternal(modelRoots: List<EObject>, clearModels: Boolean,
        clearCache: Boolean)

    /**
     * Perform checks on the analysis [modelRoots]
     */
    internal open fun checkAnalysisModels(modelRoots: List<EObject>) {
        require(modelRoots.isNotEmpty()) { "Model roots must not be empty" }
    }
}