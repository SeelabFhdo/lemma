package de.fhdo.lemma.analyzer.analyses

import de.fhdo.lemma.analyzer.*
import de.fhdo.lemma.analyzer.lib.Analyzers
import de.fhdo.lemma.analyzer.lib.analyzers.AntipatternOperationAnalyzerI
import de.fhdo.lemma.analyzer.lib.createAnalyzer
import de.fhdo.lemma.analyzer.modules.AbstractAnalysisModule
import de.fhdo.lemma.analyzer.modules.ModuleInfo
import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.operation.intermediate.IntermediateOperationModel
import de.fhdo.lemma.operation.intermediate.IntermediatePackage
import org.eclipse.emf.ecore.resource.Resource


@IntermediateModelValidator
internal class IntermediateOperationAntipatternAnalysis : AbstractAnalysisModule<IntermediateOperationModel>() {
    companion object{
        const val MODULE_CLI_OPTION_NAME = "operation-antipattern-analysis"
    }

    private lateinit var analyzer: AntipatternOperationAnalyzerI

    override fun moduleInfo() = ModuleInfo("Operation Antipattern Analysis", MODULE_CLI_OPTION_NAME)

    @Before
    private fun createAnalyzer(resource: Resource) {
        analyzer = Analyzers.OPERATION_ANTIPATTERN.createAnalyzer() as AntipatternOperationAnalyzerI
    }

    override fun analysis(args: Map<String, String>) {
        analyzer.setAnalysisModels(loadedModels)
        val result = analyzer.checkExistingAntipattern()
        AntipatternAnalysisPrinting.printAntipatternAnalysis(result, "Operation")
    }

    override fun getLanguageNamespace() = IntermediatePackage.eNS_URI
}