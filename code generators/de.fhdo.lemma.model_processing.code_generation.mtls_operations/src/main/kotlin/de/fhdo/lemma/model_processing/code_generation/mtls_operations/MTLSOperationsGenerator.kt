package de.fhdo.lemma.model_processing.code_generation.mtls_operations

import de.fhdo.lemma.model_processing.AbstractModelProcessor

private const val BASE_PACKAGE = "de.fhdo.lemma.model_processing.code_generation.mtls_operations"

class MtlsOperationsGenerator: AbstractModelProcessor(BASE_PACKAGE) {
}


fun main(args: Array<String>) {
    MtlsOperationsGenerator().run(args)
}