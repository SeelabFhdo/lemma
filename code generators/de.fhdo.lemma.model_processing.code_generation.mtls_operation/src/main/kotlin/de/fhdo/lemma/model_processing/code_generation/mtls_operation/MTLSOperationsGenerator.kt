package de.fhdo.lemma.model_processing.code_generation.mtls_operation

import de.fhdo.lemma.model_processing.AbstractModelProcessor

public const val BASE_PACKAGE = "de.fhdo.lemma.model_processing.code_generation.mtls_operation"

class MtlsOperationsGenerator : AbstractModelProcessor(BASE_PACKAGE)

fun main(args: Array<String>) {
    MtlsOperationsGenerator().run(args)
}