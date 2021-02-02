package de.fhdo.lemma.model_processing.code_generation.ddd

import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.AbstractGenlet
import java.util.*

private const val BASE_PACKAGE = "de.fhdo.lemma.model_processing.code_generation.ddd"

internal lateinit var DDD_VERSION : String

class DddGenerator : AbstractGenlet(BASE_PACKAGE) {
    override fun nameOfCodeGenerationHandlerPackage() = "$BASE_PACKAGE.handlers"

    override fun setClassLoader(classLoader: ClassLoader) {
        DDD_VERSION = classLoader.getResourceAsStream("ddd.genlet.properties")
            ?.use { Properties().apply { load(it) } }
            ?.getProperty("lemma.ddd.version")
            ?: "0.0.1-SNAPSHOT"
    }
}

fun main(args: Array<String>) {
    DddGenerator().run(args)
}