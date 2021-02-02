package de.fhdo.lemma.model_processing.code_generation.springcloud.domain_events

import de.fhdo.lemma.model_processing.AbstractModelProcessor
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.AbstractGenlet
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletEvent
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletEventType
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedFileContent
import de.fhdo.lemma.model_processing.code_generation.java_base.genlets.GenletGeneratedNode
import de.fhdo.lemma.model_processing.code_generation.springcloud.domain_events.state.EventGroups

private const val BASE_PACKAGE = "de.fhdo.lemma.model_processing.code_generation.springcloud.domain_events"

/**
 * Main class of the Domain Events generator realized on the basis of LEMMA's model processing framework as an
 * [AbstractModelProcessor].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
class DomainEventsGenerator : AbstractGenlet(BASE_PACKAGE) {
    override fun nameOfCodeGenerationHandlerPackage() = "$BASE_PACKAGE.handlers"
    override fun nameOfAspectHandlerPackage() = "${nameOfCodeGenerationHandlerPackage()}.aspects"

    /**
     * React to a code generation event
     */
    override fun onEvent(event: GenletEvent) : Pair<Set<GenletGeneratedNode>, Set<GenletGeneratedFileContent>>? {
        if (event.type != GenletEventType.OVERALL_GENERATION_FINISHED)
            return null

        // Return all generated event group nodes, when the overall code generation was finished
        val generatedNodes = EventGroups.getGeneratedNodes()
        EventGroups.reset()
        return generatedNodes to emptySet()
    }
}

/**
 * Entry point of the Domain Events generator.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
fun main(args: Array<String>) {
    DomainEventsGenerator().run(args)
}