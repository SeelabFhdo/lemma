package de.fhdo.lemma.analyzer.analyses

import de.fhdo.lemma.analyzer.blankLine
import de.fhdo.lemma.analyzer.item
import de.fhdo.lemma.analyzer.itemText
import de.fhdo.lemma.analyzer.lib.Analyzers
import de.fhdo.lemma.analyzer.lib.analyzers.MicroserviceNameAnalyzerI
import de.fhdo.lemma.analyzer.lib.createAnalyzer
import de.fhdo.lemma.analyzer.modules.AbstractAnalysisModule
import de.fhdo.lemma.analyzer.modules.ModuleInfo
import de.fhdo.lemma.analyzer.modules.ValueStore
import de.fhdo.lemma.analyzer.section
import de.fhdo.lemma.analyzer.subsection
import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.service.intermediate.IntermediatePackage
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import org.eclipse.emf.ecore.resource.Resource

@Suppress("unused")
@IntermediateModelValidator
internal class IntermediateServiceModelAnalysisDemo : AbstractAnalysisModule<IntermediateServiceModel>() {
    companion object {
        const val MODULE_CLI_OPTION_NAME = "service-name-model-analysis"
    }

    private lateinit var analyzer: MicroserviceNameAnalyzerI

    override fun getLanguageNamespace() = IntermediatePackage.eNS_URI

    override fun moduleInfo() = ModuleInfo("Service Name Model Analysis",
        IntermediateOperationModelAnalysis.MODULE_CLI_OPTION_NAME
    )

    @Before
    private fun createAnalyzer(resource: Resource) {
        analyzer = Analyzers.SERVICE_NAME.createAnalyzer() as MicroserviceNameAnalyzerI
    }


    override fun analysis(args: Map<String, String>) {
        analyzer.setAnalysisModels(loadedModels)
        printIntroduction()
        printMicroserviceNames()
    }

    /**
     * Print the introduction of the analysis
     */
    private fun printIntroduction() {
        val heading = "Service Name Analysis for Models:\n\t" +
                loadedModelsWithPath.keys.joinToString("\n\t") { itemText(it) }
        section(heading)
    }

    /**
     * Print the content of the analysis
     */
    private fun printMicroserviceNames() {
        val names = analyzer.findMicroserviceNames()
        subsection("Overview of Service Models (Model Count: ${loadedModels.size})")
        item(names, "# Microservices")
        ValueStore["containerNames"] = names
        blankLine()
    }
}