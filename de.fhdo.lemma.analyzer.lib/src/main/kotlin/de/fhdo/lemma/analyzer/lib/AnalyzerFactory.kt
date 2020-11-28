package de.fhdo.lemma.analyzer.lib

import de.fhdo.lemma.analyzer.lib.impl.domain.basic.DomainBasicAnalyzer
import de.fhdo.lemma.analyzer.lib.impl.service.basic.ServiceBasicAnalyzer
import de.fhdo.lemma.analyzer.lib.impl.service.metrics.athanasopoulos.AthanasopoulosMetricsAnalyzer
import de.fhdo.lemma.analyzer.lib.impl.service.metrics.engel.EngelMetricsAnalyzer
import de.fhdo.lemma.analyzer.lib.impl.service.metrics.haupt.HauptMetricsAnalyzer
import de.fhdo.lemma.analyzer.lib.impl.service.metrics.hirzalla.HirzallaMetricsAnalyzer
import org.eclipse.emf.ecore.EObject

/**
 * Interface for all analyzers including those for metrics calculation.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
interface AnalyzerI {
    /**
     * Set the analysis models for the analyzer. The [clearModels] flag will result in the deletion of all previous
     * analysis models (default). The [clearCache] flag will instruct the analyzer to clear the map of cached model
     * elements from the invocations of previous analysis functions (default).
     */
    fun setAnalysisModels(modelRoots: List<EObject>, clearModels: Boolean = true, clearCache: Boolean = true)
}

/**
 * Tagging interface of analyzers for metrics calculation.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("unused")
interface MetricBasedAnalyzerI : AnalyzerI

/**
 * Enumeration to unambiguously identify all supported analyzers including those for metrics calculation.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("unused")
enum class Analyzers(val analyzerName: String) {
    DOMAIN_BASIC("domain"),
    SERVICE_BASIC("service"),
    SERVICE_METRICS_ATHANASOPOULOS("athanasopoulos"),
    SERVICE_METRICS_ENGEL("engel"),
    SERVICE_METRICS_HAUPT("haupt"),
    SERVICE_METRICS_HIRZALLA("hirzalla")
}

/**
 * Factory method to create an analyzer from a literal of the [Analyzers] enumeration. Invoke, e.g., by
 * [Analyzers].LITERAL.createAnalyzer() or createAnalyzer([Analyzers].LITERAL).
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("unused")
fun Analyzers.createAnalyzer() : AnalyzerI
    = when(this) {
        Analyzers.DOMAIN_BASIC -> DomainBasicAnalyzer()
        Analyzers.SERVICE_BASIC -> ServiceBasicAnalyzer()
        Analyzers.SERVICE_METRICS_ATHANASOPOULOS -> AthanasopoulosMetricsAnalyzer()
        Analyzers.SERVICE_METRICS_ENGEL -> EngelMetricsAnalyzer()
        Analyzers.SERVICE_METRICS_HAUPT -> HauptMetricsAnalyzer()
        Analyzers.SERVICE_METRICS_HIRZALLA -> HirzallaMetricsAnalyzer()
    }