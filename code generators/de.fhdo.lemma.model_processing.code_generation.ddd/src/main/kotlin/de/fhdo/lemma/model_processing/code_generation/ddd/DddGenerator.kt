package de.fhdo.lemma.model_processing.code_generation.ddd

import de.fhdo.lemma.model_processing.AbstractModelProcessor
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.Genlet

private const val BASE_PACKAGE = "de.fhdo.lemma.model_processing.code_generation.ddd"

class DddGenerator : AbstractModelProcessor(BASE_PACKAGE), Genlet {
    override fun nameOfCodeGenerationHandlerPackage() = "$BASE_PACKAGE.handlers"
}

fun main(args: Array<String>) {
    DddGenerator().run(args)
}