package de.fhdo.lemma.model_processing.code_generation.java_base.serialization.configuration

import com.github.javaparser.printer.PrettyPrinterConfiguration
import java.nio.charset.Charset

/**
 * Abstract superclass for serialization configurations. Uses JavaParser's [PrettyPrinterConfiguration] as basis.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
abstract class AbstractSerializationConfiguration(val charset: Charset) : PrettyPrinterConfiguration()