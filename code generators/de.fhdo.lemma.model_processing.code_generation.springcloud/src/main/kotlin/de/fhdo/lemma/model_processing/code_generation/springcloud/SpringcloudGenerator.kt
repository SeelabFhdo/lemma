package de.fhdo.lemma.model_processing.code_generation.springcloud

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.springcloud.Context.State as State
import de.fhdo.lemma.model_processing.AbstractModelProcessor
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.AbstractGenlet
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletEvent
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletEventObject
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletEventType
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedFileContent
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedNode
import de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.MicroserviceHandler

private const val BASE_PACKAGE = "de.fhdo.lemma.model_processing.code_generation.springcloud"

/**
 * Main class of the Spring Cloud generator realized on the basis of LEMMA's model processing framework as an
 * [AbstractModelProcessor].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class SpringcloudGenerator : AbstractGenlet(BASE_PACKAGE) {
    override fun nameOfCodeGenerationHandlerPackage() = "$BASE_PACKAGE.handlers"
    override fun nameOfAspectHandlerPackage() = "${nameOfCodeGenerationHandlerPackage()}.aspects"
    override fun nameOfDependencyFragmentProviderPackage() = "$BASE_PACKAGE.dependencies"

    /**
     * React to a code generation event
     */
    override fun onEvent(event: GenletEvent) : Pair<Set<GenletGeneratedNode>, Set<GenletGeneratedFileContent>>? {
        if (event.type != GenletEventType.MICROSERVICE_GENERATION_FINISHED)
            return null

        // Handle finish of the current microservice's Java generation
        val microserviceClass = event.get<ClassOrInterfaceDeclaration>(GenletEventObject.GENERATED_MICROSERVICE_CLASS)!!
        val finalServiceClass = MicroserviceHandler.handleMicroserviceGenerationFinished(microserviceClass)
        State.reset()
        return finalServiceClass
    }
}

/**
 * Entry point of the Spring Cloud generator.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun main(args: Array<String>) {
    SpringcloudGenerator().run(args)
}