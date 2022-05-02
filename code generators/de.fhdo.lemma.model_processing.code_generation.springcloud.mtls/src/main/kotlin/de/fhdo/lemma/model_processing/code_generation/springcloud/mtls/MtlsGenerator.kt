package de.fhdo.lemma.model_processing.code_generation.springcloud.mtls

import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.AbstractGenlet
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletEvent
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletEventType
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedFileContent
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedNode

private const val BASE_PACKAGE = "de.fhdo.lemma.model_processing.code_generation.springcloud.mtls"


class MtlsGenerator : AbstractGenlet(BASE_PACKAGE) {
    override fun nameOfCodeGenerationHandlerPackage() = "$BASE_PACKAGE.handlers"
    override fun nameOfAspectHandlerPackage() = "${nameOfCodeGenerationHandlerPackage()}.aspects"


    /**
     * React to a code generation event
     */
    override fun onEvent(event: GenletEvent): Pair<Set<GenletGeneratedNode>, Set<GenletGeneratedFileContent>>? {
        if (event.type != GenletEventType.MICROSERVICE_GENERATION_FINISHED)
            return null
        return null
    }
}

fun main(args: Array<String>) {
    MtlsGenerator().run(args)
}