package de.fhdo.lemma.analyzer.command_line

import de.fhdo.lemma.analyzer.modules.AbstractAnalysisModule
import de.fhdo.lemma.model_processing.annotations.IntermediateModelValidator
import io.github.classgraph.ClassGraph
import io.github.classgraph.ClassInfo

private var scannedForAnalysisModules = false
private var analysisModuleCache = mutableListOf<ClassInfo>()

/**
 * Find analysis modules on the classpath. An analysis module has the [IntermediateModelValidator] annotation and
 * extends the [AbstractAnalysisModule] class.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun findAnalysisModules(packageName: String = "de.fhdo.lemma.analyzer", useCache: Boolean = true)
    : List<ClassInfo> {
    if (useCache && scannedForAnalysisModules)
        return analysisModuleCache

    analysisModuleCache = ClassGraph()
        .enableClassInfo()
        .enableAnnotationInfo()
        .whitelistPackages(packageName)
        .scan()
        .getClassesWithAnnotation(IntermediateModelValidator::class.qualifiedName)
        .filter { it.extendsSuperclass(AbstractAnalysisModule::class.java.name) }
        .toMutableList()
    scannedForAnalysisModules = true
    return analysisModuleCache
}

/**
 * Get the CLI options of all analysis modules.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun getAnalysisModulesCliOptionNames() : Set<String> {
    val analysisModules = findAnalysisModules()
    return analysisModules.map {
        val moduleInstance = it.loadClass().getDeclaredConstructor().newInstance() as AbstractAnalysisModule<*>
        val cliOptionName = moduleInstance.moduleInfo().cliOptionName
        cliOptionName
    }.toSet()
}