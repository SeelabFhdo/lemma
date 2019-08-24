package de.fhdo.lemma.model_processing.code_generation.springcloud

import de.fhdo.lemma.model_processing.AbstractModelProcessor
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.Genlet

private const val BASE_PACKAGE = "de.fhdo.lemma.model_processing.code_generation.springcloud"

class SpringcloudGenerator : AbstractModelProcessor(BASE_PACKAGE), Genlet {
    override fun nameOfCodeGenerationHandlerPackage() = "$BASE_PACKAGE.handlers"
    override fun nameOfAspectHandlerPackage() = "${nameOfCodeGenerationHandlerPackage()}.aspects"
    override fun nameOfDependencyFragmentProviderPackage() = "$BASE_PACKAGE.dependencies"
}
fun main(args: Array<String>) {
    SpringcloudGenerator().run(args)
}