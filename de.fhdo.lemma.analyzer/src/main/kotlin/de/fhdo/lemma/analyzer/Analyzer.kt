package de.fhdo.lemma.analyzer

import de.fhdo.lemma.analyzer.command_line.CommandLine
import de.fhdo.lemma.analyzer.modules.AbstractAnalysisModule
import de.fhdo.lemma.analyzer.modules.ValueStore
import de.fhdo.lemma.model_processing.AbstractModelProcessor

/**
 * Entrypoint class of the Static Analyzer as expected by LEMMA's model processing framework.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal class ModelProcessor : AbstractModelProcessor("de.fhdo.lemma.analyzer") {
    /**
     * Callback: React to the completion of model processing
     */
    override fun processingFinished(returnCode: Int) {
        // Print a hint when no analysis modules were executed all, e.g., because there exist no analysis modules for
        // the given model types
        if (AbstractAnalysisModule.getExecutedModulesList().isEmpty()) {
            println("No known modules were selected to execute")
            return
        }

        // If requested, print the value store contents
        if (CommandLine.printValueStore)
            println(ValueStore)

        // Hint at unconsumed CLI options, e.g., because none of the analysis modules supports them
        val unconsumedOptions = CommandLine.unmatched.filter {
                it !in AbstractAnalysisModule.getConsumedAdditionalCommandLineOptions()
            }
        if (unconsumedOptions.isNotEmpty())
            println("The following options were not consumed by any module:" +
                unconsumedOptions.joinToString("\n\t", "\n\t"))

        // Write CSV file if requested
        if (CommandLine.csvFile != null)
            ValueStore.writeAsCsv(CommandLine.csvFile!!)
    }
}

/**
 * Programmatic entrypoint to the Static Analyzer.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun main(args: Array<String>) {
    ModelProcessor().run(args)
}