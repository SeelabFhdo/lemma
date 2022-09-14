package de.fhdo.lemma.analyzer.analyses

import de.fhdo.lemma.analyzer.blankLine
import de.fhdo.lemma.analyzer.item
import de.fhdo.lemma.analyzer.itemItem
import de.fhdo.lemma.analyzer.itemText
import de.fhdo.lemma.analyzer.items
import de.fhdo.lemma.analyzer.lib.Analyzers
import de.fhdo.lemma.analyzer.lib.analyzers.DomainBasicAnalyzerI
import de.fhdo.lemma.analyzer.lib.createAnalyzer
import de.fhdo.lemma.analyzer.lib.filterAllEObjectInstances
import de.fhdo.lemma.analyzer.modules.AbstractAnalysisModule
import de.fhdo.lemma.analyzer.modules.ModuleInfo
import de.fhdo.lemma.analyzer.modules.ValueStore
import de.fhdo.lemma.analyzer.nestedMapItems
import de.fhdo.lemma.analyzer.putNestedMapToValueStore
import de.fhdo.lemma.analyzer.putToValueStore
import de.fhdo.lemma.analyzer.section
import de.fhdo.lemma.analyzer.subsection
import de.fhdo.lemma.data.intermediate.IntermediateComplexType
import de.fhdo.lemma.data.intermediate.IntermediateDataModel
import de.fhdo.lemma.data.intermediate.IntermediatePackage
import de.fhdo.lemma.model_processing.annotations.Before
import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import org.eclipse.emf.ecore.resource.Resource

/**
 * Intermediate model validator, which implements a basic analysis for domain models.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
@Suppress("unused")
@IntermediateModelValidator
internal class IntermediateDomainModelAnalysis : AbstractAnalysisModule<IntermediateDataModel>() {
    companion object {
        const val MODULE_CLI_OPTION_NAME = "basic-domain-analysis"
    }

    private lateinit var analyzer: DomainBasicAnalyzerI

    override fun getLanguageNamespace() = IntermediatePackage.eNS_URI

    override fun moduleInfo() = ModuleInfo("Basic Domain Analysis", MODULE_CLI_OPTION_NAME)

    /**
     * Create the [analyzer] instance before the actual validation starts
     */
    @Suppress("UNUSED_PARAMETER")
    @Before
    private fun createAnalyzer(resource: Resource) {
        analyzer = Analyzers.DOMAIN_BASIC.createAnalyzer() as DomainBasicAnalyzerI
    }

    override fun analysis(args: Map<String, String>) {
        analyzer.setAnalysisModels(loadedModels)

        printIntroduction()
        domainModelOverview()
        featureOverview()
    }

    /**
     * Print the introduction of the analysis
     */
    private fun printIntroduction() {
        val heading = "Domain Analysis for Models:\n\t" +
            loadedModelsWithPath.keys.joinToString("\n\t") { itemText(it) }
        section(heading)
    }

    /**
     * Perform basic analysis for domain models
     */
    private fun domainModelOverview() {
        val boundedContextCount = analyzer.countBoundedContexts()
        val enumerationsPerBoundedContext = analyzer.countEnumerationsPerBoundedContext()
        val totalEnumerationCount = enumerationsPerBoundedContext.values.sum()
        val collectionTypesPerBoundedContext = analyzer.countCollectionTypesPerBoundedContext()
        val totalCollectionTypeCount = collectionTypesPerBoundedContext.values.sum()
        val structuresPerBoundedContext = analyzer.countDataStructuresPerBoundedContext()
        val totalStructureCount = structuresPerBoundedContext.values.sum()

        subsection("Overview of Domain Models (Model Count: ${loadedModels.size})")
        item(boundedContextCount, "# Bounded Contexts")
        ValueStore["boundedContextCount"] = boundedContextCount

        blankLine()
        items(structuresPerBoundedContext, heading = "# Data Structures per Bounded Context")
        structuresPerBoundedContext.putToValueStore("dataStructureCountInContext")
        itemItem(totalStructureCount, "Total Data Structure Count")
        ValueStore["totalDataStructureCount"] = totalStructureCount

        blankLine()
        items(enumerationsPerBoundedContext, heading = "# Enumerations per Bounded Context")
        enumerationsPerBoundedContext.putToValueStore("enumerationCountInContext")
        itemItem(totalEnumerationCount, "Total Enumeration Count")
        ValueStore["totalEnumerationCount"] = totalEnumerationCount

        blankLine()
        items(collectionTypesPerBoundedContext, heading = "# Collection Types per Bounded Context")
        collectionTypesPerBoundedContext.putToValueStore("collectionTypesCountInContext")
        itemItem(totalCollectionTypeCount, "Total Collection Type Count")
        ValueStore["totalCollectionTypeCount"] = totalCollectionTypeCount

        ValueStore["totalDomainConceptCount"] = totalStructureCount + totalEnumerationCount + totalCollectionTypeCount
    }

    /**
     * Perform analysis to provide an overview of the features in domain models
     */
    private fun featureOverview() {
        val complexTypes = loadedModels.filterAllEObjectInstances<IntermediateComplexType>()
        val features = analyzer.countFeatures(complexTypes)
        val featuresPerBoundedContext = analyzer.countFeaturesPerBoundedContext(complexTypes)
        val featuresPerComplexTypeKind = analyzer.countFeaturesPerComplexTypeKind(complexTypes)

        subsection("Overview of Domain Features (Model Count: ${loadedModels.size})")
        items(features, heading = "# Features")
        features.putToValueStore("domainFeaturesCount")

        blankLine()
        nestedMapItems(featuresPerBoundedContext, heading = "# Features per bounded context")
        featuresPerBoundedContext.putNestedMapToValueStore("domainFeaturesCountInContext")

        blankLine()
        nestedMapItems(featuresPerComplexTypeKind, heading = "# Features per complex type kind")
        featuresPerComplexTypeKind.putNestedMapToValueStore("domainFeaturesCountPerComplexTypeKind")
    }
}