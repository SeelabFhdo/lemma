package de.fhdo.lemma.model_processing.code_generation.springcloud

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration
import de.fhdo.lemma.model_processing.code_generation.springcloud.Context.State as State
import de.fhdo.lemma.model_processing.AbstractModelProcessor
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.Genlet
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletEvent
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletEventObject
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletEventType
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedFileContent
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedNode
import de.fhdo.lemma.model_processing.code_generation.springcloud.handlers.MicroserviceHandler

private const val BASE_PACKAGE = "de.fhdo.lemma.model_processing.code_generation.springcloud"

class SpringcloudGenerator : AbstractModelProcessor(BASE_PACKAGE), Genlet {
    override fun nameOfCodeGenerationHandlerPackage() = "$BASE_PACKAGE.handlers"
    override fun nameOfAspectHandlerPackage() = "${nameOfCodeGenerationHandlerPackage()}.aspects"
    override fun nameOfDependencyFragmentProviderPackage() = "$BASE_PACKAGE.dependencies"

    override fun onEvent(event: GenletEvent) : Pair<Set<GenletGeneratedNode>, Set<GenletGeneratedFileContent>>? {
        if (event.type != GenletEventType.MICROSERVICE_GENERATION_FINISHED)
            return null

        val microserviceClass = event.get<ClassOrInterfaceDeclaration>(GenletEventObject.GENERATED_MICROSERVICE_CLASS)!!
        val finalServiceClass = MicroserviceHandler.handleMicroserviceGenerationFinished(microserviceClass)
        State.reset()
        return finalServiceClass
    }
}

fun main(args: Array<String>) {
    SpringcloudGenerator().run(args)
}