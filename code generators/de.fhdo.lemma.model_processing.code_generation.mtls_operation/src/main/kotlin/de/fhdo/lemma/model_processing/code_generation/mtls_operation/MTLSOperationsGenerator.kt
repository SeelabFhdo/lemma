package de.fhdo.lemma.model_processing.code_generation.mtls_operation

import de.fhdo.lemma.model_processing.AbstractModelProcessor
import de.fhdo.lemma.model_processing.code_generation.mtls_operation.utils.parseApplicationNames

public const val BASE_PACKAGE = "de.fhdo.lemma.model_processing.code_generation.mtls_operation"

class MtlsOperationsGenerator : AbstractModelProcessor(BASE_PACKAGE)

fun main(args: Array<String>) {
//    parseApplicationNames("de.pelki.ms1=ms1")
//    parseApplicationNames("de.pelki.ms1=ms1=")
//    parseApplicationNames("de.pelki.ms1=ms1,")
//    parseApplicationNames("de.pelki.ms1= ms1")
//    parseApplicationNames("de.pelki.ms1=ms1,de.pelki.ms1=ms1")
//    parseApplicationNames("de.pelki.ms1 = ms1,de.pelki.ms1=ms1")
//    parseApplicationNames("de.pelki.ms1 =ms1,de.pelki.ms1=ms1")
//    parseApplicationNames("de.pelki.ms1= ms1,de.pelki.ms1=ms1")
//    parseApplicationNames("de.pelki.ms1=ms1,de.pelki.ms1=ms1,")
//    parseApplicationNames("de.pelki.ms1=ms1,de.pelki.ms1=ms1,de.pelki.ms1=ms1")
//    parseApplicationNames("de.pelki.ms1=ms1,de.pelki.ms1=ms1,de.pelki.ms1=ms1,")
//    parseApplicationNames("de.pelki.ms1=ms1,de.pelki.ms1=ms1,de.pelki.ms1=ms1,de.pelki.ms1=ms1")
//    parseApplicationNames("de.pelki.ms1=ms1,de.pelki.ms1=ms1,de.pelki.ms1=ms1,de.pelki.ms1=ms1,")
    MtlsOperationsGenerator().run(args)
}