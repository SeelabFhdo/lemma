package de.fhdo.lemma.analyzer.lib.impl.operation.antipattern

import de.fhdo.lemma.analyzer.lib.analyzers.AntiPatternAnalyzerI
import de.fhdo.lemma.analyzer.lib.impl.AbstractSingleModelTypeAnalyzer
import de.fhdo.lemma.analyzer.lib.impl.Cache
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode

/**
 * Analyses operation nodes and returns their name
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
internal class ContainerNameAnalyzer
    : AbstractSingleModelTypeAnalyzer<IntermediateOperationModel>(IntermediateOperationModel::class.java),
    AntiPatternAnalyzerI {
    /**
     * Return the name of a IntermediateOperationNode
     */
    override fun findContainerName(): List<String> {
        val containerNames = mutableListOf<String>()
        Cache.allOperationNodes().forEach{containerNames.add(it.name)}
        return containerNames
    }
}