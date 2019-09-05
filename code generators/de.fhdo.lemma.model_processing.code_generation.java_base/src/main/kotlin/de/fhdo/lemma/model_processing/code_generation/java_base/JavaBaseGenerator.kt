package de.fhdo.lemma.model_processing.code_generation.java_base

import de.fhdo.lemma.model_processing.AbstractModelProcessor

/**
 * Main class of the Java base generator realized on the basis of LEMMA's model processing framework as an
 * [AbstractModelProcessor].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class JavaBaseGenerator : AbstractModelProcessor("de.fhdo.lemma.model_processing.code_generation.java_base")

/**
 * Entry point of the Java base generator.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun main(args: Array<String>) {
    JavaBaseGenerator().run(args)
}