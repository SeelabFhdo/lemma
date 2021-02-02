package de.fhdo.lemma.model_processing.code_generation.lakeside_mutual

import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.AbstractGenlet

private const val BASE_PACKAGE = "de.fhdo.lemma.model_processing.code_generation.lakeside_mutual"

class Lakeside_mutualGenerator : AbstractGenlet(BASE_PACKAGE) {
    override fun nameOfCodeGenerationHandlerPackage() = "$BASE_PACKAGE.handlers"
}
fun main(args: Array<String>) {
    Lakeside_mutualGenerator().run(args)
}