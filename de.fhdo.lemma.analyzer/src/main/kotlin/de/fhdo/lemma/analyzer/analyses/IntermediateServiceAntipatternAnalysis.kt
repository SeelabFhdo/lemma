package de.fhdo.lemma.analyzer.analyses

import de.fhdo.lemma.analyzer.AntipatternAnalysisPrinting
import de.fhdo.lemma.analyzer.lib.Analyzers
import de.fhdo.lemma.analyzer.lib.analyzers.AntipatternServiceAnalyzerI
import de.fhdo.lemma.analyzer.lib.createAnalyzer
import de.fhdo.lemma.analyzer.modules.AbstractAnalysisModule
import de.fhdo.lemma.analyzer.modules.ModuleInfo
import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import de.fhdo.lemma.service.intermediate.IntermediatePackage
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel
import org.eclipse.emf.ecore.resource.Resource

@IntermediateModelValidator
internal class IntermediateServiceAntipatternAnalysis : AbstractAnalysisModule<IntermediateServiceModel>(){
    companion object{
        const val MODULE_CLI_OPTION_NAME = "operation-antipattern-analysis"
    }

    private lateinit var analyzer: AntipatternServiceAnalyzerI

    override fun moduleInfo() = ModuleInfo("Service Antipattern Analysis", MODULE_CLI_OPTION_NAME)

    @Before
    private fun createAnalyzer(resource: Resource) {
        analyzer = Analyzers.SERVICE_ANTIPATTERN.createAnalyzer() as AntipatternServiceAnalyzerI
    }

    override fun analysis(args: Map<String, String>) {
        analyzer.setAnalysisModels(loadedModels)
        val antipattern = analyzer.checkExistingAntipattern()
        AntipatternAnalysisPrinting.printAntipatternAnalysis(antipattern, "Service")
    }

    override fun getLanguageNamespace() = IntermediatePackage.eNS_URI
}