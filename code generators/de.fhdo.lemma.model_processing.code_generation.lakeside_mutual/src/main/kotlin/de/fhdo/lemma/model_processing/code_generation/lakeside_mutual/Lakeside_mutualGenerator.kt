package de.fhdo.lemma.model_processing.code_generation.lakeside_mutual

import de.fhdo.lemma.model_processing.AbstractModelProcessor
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.Genlet

private const val BASE_PACKAGE = "de.fhdo.lemma.model_processing.code_generation.lakeside_mutual"

class Lakeside_mutualGenerator : AbstractModelProcessor(BASE_PACKAGE), Genlet {
    override fun nameOfCodeGenerationHandlerPackage() = "$BASE_PACKAGE.handlers"
}
fun main(args: Array<String>) {
    Lakeside_mutualGenerator().run(args)
}