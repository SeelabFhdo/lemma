package de.fhdo.lemma.model_processing.code_generation.java_base.serialization.configuration

import java.nio.charset.Charset

/**
 * Default serialization configuration.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal object DefaultSerializationConfiguration : AbstractSerializationConfiguration(Charset.forName("UTF-8")) {
    init {
        indentType = IndentType.SPACES
        indentSize = 4
        isOrderImports = true
    }
}