package de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.AbstractGenlet
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletEvent
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletEventObject
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletEventType
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedFileContent
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedNode
import de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak.handlers.aspects.IntermediateMicroserviceHandler
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel

private const val BASE_PACKAGE = "de.fhdo.lemma.model_processing.code_generation.springcloud.keycloak"


class KeycloakGenerator : AbstractGenlet(BASE_PACKAGE) {
    override fun nameOfCodeGenerationHandlerPackage() = "$BASE_PACKAGE.handlers"
    override fun nameOfAspectHandlerPackage() = "${nameOfCodeGenerationHandlerPackage()}.aspects"

    /**
     * React to a code generation event
     */
    override fun onEvent(event: GenletEvent): Pair<Set<GenletGeneratedNode>, Set<GenletGeneratedFileContent>>? {
        if (event.type != GenletEventType.MICROSERVICE_GENERATION_FINISHED)
            return null
        val retval = IntermediateMicroserviceHandler.handleMicroserviceGenerationFinished()
        Context.State.reset()
        return retval
    }
}

fun main(args: Array<String>) {
    KeycloakGenerator().run(args)
}