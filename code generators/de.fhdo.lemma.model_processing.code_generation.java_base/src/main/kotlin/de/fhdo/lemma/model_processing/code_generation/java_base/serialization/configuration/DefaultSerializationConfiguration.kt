package de.fhdo.lemma.model_processing.code_generation.java_base.serialization.configuration

import com.github.javaparser.printer.configuration.DefaultConfigurationOption
import com.github.javaparser.printer.configuration.Indentation
import java.nio.charset.Charset

/**
 * Default serialization configuration.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object DefaultSerializationConfiguration : AbstractSerializationConfiguration(Charset.forName("UTF-8")) {
    init {
        addOption(DefaultConfigurationOption(ConfigOption.INDENTATION, Indentation(Indentation.IndentType.SPACES, 4)))
        addOption(DefaultConfigurationOption(ConfigOption.ORDER_IMPORTS, true))
    }
}