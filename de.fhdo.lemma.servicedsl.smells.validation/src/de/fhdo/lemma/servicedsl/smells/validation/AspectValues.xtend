package de.fhdo.lemma.servicedsl.smells.validation

import de.fhdo.lemma.data.PrimitiveValue
import de.fhdo.lemma.service.ImportedServiceAspect
import java.util.Map

/**
 * Reads what an aspect states, as text.
 *
 * Here rather than in each consumer: the editor's validator, the command
 * line's detector and the quickfix all need the same values out of the same
 * aspects, and a third hand-written copy of this is how the three would start
 * disagreeing.
 *
 * As text, because text is what the facts are. They reached the model through
 * a database that carries only strings, so a boolean or a number is compared
 * as what was written - and both halves of the detection then compare the same
 * thing.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class AspectValues {
    /**
     * The name of the aspect, or null where the reference does not resolve.
     *
     * Resolves inside a running Xtext. Outside one it does not, which is why
     * the command line reads names from a parse tree instead.
     */
    static def String nameOf(ImportedServiceAspect aspect) {
        return aspect?.importedAspect?.name
    }

    /**
     * Every property the aspect assigns, by property name.
     */
    static def Map<String, String> of(ImportedServiceAspect aspect) {
        val values = <String, String>newLinkedHashMap
        if (aspect === null) {
            return values
        }
        for (assignment : aspect.values) {
            val name = assignment.property?.name
            val value = assignment.value
            if (name !== null && value !== null) {
                val text = value.asText
                if (text !== null) {
                    values.put(name, text)
                }
            }
        }
        return values
    }

    private static def String asText(PrimitiveValue value) {
        if (value.stringValue !== null) {
            return value.stringValue
        }
        if (value.booleanValue !== null) {
            return value.booleanValue.toString
        }
        if (value.numericValue !== null) {
            return value.numericValue.toString
        }
        return null
    }
}
