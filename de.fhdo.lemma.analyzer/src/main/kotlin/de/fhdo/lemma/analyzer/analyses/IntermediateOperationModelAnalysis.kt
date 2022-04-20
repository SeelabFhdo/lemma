package de.fhdo.lemma.analyzer.analyses

import de.fhdo.lemma.analyzer.blankLine
import de.fhdo.lemma.analyzer.item
import de.fhdo.lemma.analyzer.itemText
import de.fhdo.lemma.analyzer.lib.Analyzers
import de.fhdo.lemma.analyzer.lib.analyzers.AntiPatternAnalyzerI
import de.fhdo.lemma.analyzer.lib.createAnalyzer
import de.fhdo.lemma.analyzer.modules.AbstractAnalysisModule
import de.fhdo.lemma.analyzer.modules.ModuleInfo
import de.fhdo.lemma.analyzer.modules.ValueStore
import de.fhdo.lemma.analyzer.section
import de.fhdo.lemma.analyzer.subsection
import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import org.eclipse.emf.ecore.resource.Resource

/**
 * Intermediate model validator, which implements a basic analysis for operation models.
 *
 * @author [Philip Wizenty](mailto:philip.wizenty@fh-dortmund.de)
 */
@Suppress("unused")
@IntermediateModelValidator
internal class IntermediateOperationModelAnalysis : AbstractAnalysisModule<IntermediateOperationModel>() {
    companion object {
        const val MODULE_CLI_OPTION_NAME = "operation-model-analysis"
    }

    private lateinit var analyzer: AntiPatternAnalyzerI

    /**
     * Set language namespace for the operation intermediate package
     */
    override fun getLanguageNamespace() = IntermediatePackage.eNS_URI

    /**
     * Specify module info for [IntermediateServiceModelAnalysis]
     */
    override fun moduleInfo() = ModuleInfo("Basic Operation Analysis", MODULE_CLI_OPTION_NAME)

    /**
     * Initialize [AntiPatternAnalyzerI]
     */
    @Before
    private fun createAnalyzer(resource: Resource) {
        analyzer = Analyzers.OPERATION_BASIC.createAnalyzer() as AntiPatternAnalyzerI
    }

    /**
     * Perform model analysis
     */
    override fun analysis(args: Map<String, String>) {
        analyzer.setAnalysisModels(loadedModels)
        printIntroduction()
        printContainerNames()
    }

    /**
     * Print the introduction of the analysis
     */
    private fun printIntroduction() {
        val heading = "Operation Analysis for Models:\n\t" +
                loadedModelsWithPath.keys.joinToString("\n\t") { itemText(it) }
        section(heading)
    }

    /**
     * Extract container name from operation name
     */
    private fun printContainerNames() {
        val containerNames = analyzer.findContainerName()
        subsection("Overview of Operation Models (Model Count: ${loadedModels.size})")
        item(containerNames, "# Container")
        ValueStore["containerNames"] = containerNames
        blankLine()
    }
}