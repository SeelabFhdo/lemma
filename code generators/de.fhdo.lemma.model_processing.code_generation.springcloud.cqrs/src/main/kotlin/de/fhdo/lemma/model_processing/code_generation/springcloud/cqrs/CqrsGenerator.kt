package de.fhdo.lemma.model_processing.code_generation.springcloud.cqrs

import de.fhdo.lemma.model_processing.AbstractModelProcessor
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.Genlet

private const val BASE_PACKAGE = "de.fhdo.lemma.model_processing.code_generation.springcloud.cqrs"

/**
 * Main class of the CQRS generator realized on the basis of LEMMA's model processing framework as an
 * [AbstractModelProcessor].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class CqrsGenerator : AbstractModelProcessor(BASE_PACKAGE), Genlet {
    override fun nameOfCodeGenerationHandlerPackage() = "$BASE_PACKAGE.handlers"
    override fun nameOfAspectHandlerPackage() = "${nameOfCodeGenerationHandlerPackage()}.aspects"
}

/**
 * Entry point of the CQRS generator.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun main(args: Array<String>) {
    CqrsGenerator().run(args)
}