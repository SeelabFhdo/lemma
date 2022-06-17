package de.fhdo.lemma.model_processing.code_generation.keycloak.operation

import de.fhdo.lemma.model_processing.AbstractModelProcessor

const val BASE_PACKAGE = "de.fhdo.lemma.model_processing.code_generation.keycloak.operation"

class KeycloakOperationsGenerator : AbstractModelProcessor(BASE_PACKAGE)

fun main(args: Array<String>) {
    KeycloakOperationsGenerator().run(args)
}