package de.fhdo.lemma.model_processing.code_generation.java_base.serialization.code_generation

import com.github.javaparser.printer.PrettyPrinterConfiguration

/**
 * Default [PrettyPrinterConfiguration] for code generation serialization.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object DefaultCodeGenerationSerializationPrettyPrinterConfiguration : PrettyPrinterConfiguration() {
    init {
        indentType = IndentType.SPACES
        indentSize = 4
        isOrderImports = true
    }
}