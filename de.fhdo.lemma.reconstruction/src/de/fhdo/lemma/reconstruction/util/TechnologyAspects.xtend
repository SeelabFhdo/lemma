package de.fhdo.lemma.reconstruction.util

import java.util.Collections
import java.util.LinkedHashMap
import java.util.LinkedHashSet
import java.util.List
import java.util.Map
import java.util.Set
import java.util.regex.Pattern

/**
 * The service aspects a hand-written technology model of this bundle declares.
 *
 * The reconstruction finds the annotations a REST controller is written with,
 * and a technology model declares a service aspect for each of them it knows:
 * GetMapping for an operation, PathVariable for a parameter, and so on. Only a
 * declared aspect can be referred to, and only at the join point it is declared
 * for, so the generator asks here before it emits a reference. An annotation
 * the model does not declare is left out: a reference that does not resolve is
 * worse than a visible gap.
 *
 * The declared properties are read along with it, because the reconstruction
 * reports every element value an annotation states while an aspect declares
 * only some of them as properties. @RequestParam(required = false) is the case
 * in Lakeside Mutual: the model gives the aspect a value and a defaultValue and
 * no required, and assigning a property that does not exist would be an error
 * in the generated model.
 *
 * Reading the model is a scan of its declarations rather than a parse, as in
 * [[TechnologyTypes]]: the Technology DSL is not on the classpath of this
 * bundle, and the declarations are what is needed.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class TechnologyAspects {
    /**
     * A declared service aspect.
     */
    static class Aspect {
        /**
         * The join points the aspect is declared for, as the model writes them:
         * "operations", "parameters", "fields", "microservices" and the others
         * of the Technology DSL.
         */
        public val Set<String> joinPoints

        /**
         * The properties the aspect declares, by name, each with the primitive
         * type the model declares it as, in declaration order.
         */
        public val Map<String, String> properties

        new (Set<String> joinPoints, Map<String, String> properties) {
            this.joinPoints = joinPoints
            this.properties = properties
        }
    }

    /**
     * An aspect declaration: its name, optional features in angle brackets, the
     * join points it is declared for, and either a body of properties or a
     * semicolon for an aspect without any.
     */
    static val DECLARATION = Pattern.compile(
        "aspect\\s+(\\w+)\\s*(?:<[^>]*>)?\\s*for\\s+([^{;]+?)\\s*(?:\\{([^}]*)\\}|;)",
        Pattern.DOTALL)

    /**
     * A property of an aspect. The type is one of the primitive types of the
     * Data DSL, which is what makes this different from the other declarations
     * a body holds, such as a selector.
     *
     * A property named after a keyword is declared with a caret - ``string
     * ^protocol`` - and the caret is syntax rather than part of the name. Read
     * with it, the name matched no reconstructed fact and the value was
     * silently dropped from the generated model.
     */
    static val PROPERTY = Pattern.compile(
        "\\b(boolean|byte|char|date|double|float|int|long|short|string|unspecified)" +
        "\\s+\\^?(\\w+)")

    /**
     * The primitive types of the Data DSL that a value is written as a number
     * for. The others are written as a string, and boolean as itself.
     */
    static val NUMERIC_TYPES = #{"byte", "double", "float", "int", "long", "short"}

    static val BOOLEAN_TYPE = "boolean"

    static val cache = new LinkedHashMap<String, Map<String, Aspect>>

    /**
     * Read the service aspects a technology model declares, by name.
     *
     * @param modelFileName file name of the model inside this bundle
     * @return the declared aspects, empty when the model cannot be read
     */
    def static Map<String, Aspect> declaredAspects(String modelFileName) {
        if (cache.containsKey(modelFileName)) {
            return cache.get(modelFileName)
        }

        val aspects = new LinkedHashMap<String, Aspect>
        val model = TechnologyTypes.readModel(modelFileName)
        if (model !== null) {
            val matcher = DECLARATION.matcher(model)
            while (matcher.find) {
                val joinPoints = new LinkedHashSet<String>
                matcher.group(2).split(",").forEach[joinPoints.add(it.trim)]
                aspects.put(matcher.group(1),
                    new Aspect(joinPoints, propertiesOf(matcher.group(3))))
            }
        }

        cache.put(modelFileName, aspects)
        return aspects
    }

    /**
     * Read the aspect a technology model declares under a name for a join
     * point, or null when it declares none.
     *
     * @param modelFileName file name of the model inside this bundle
     * @param name name of the aspect, which is the name of the annotation the
     *        reconstruction found
     * @param joinPoint join point the aspect has to be declared for
     * @return the aspect, or null
     */
    def static Aspect declaredAspect(String modelFileName, String name, String joinPoint) {
        if (name.nullOrEmpty) {
            return null
        }
        val aspect = declaredAspects(modelFileName).get(name)
        if (aspect === null || !aspect.joinPoints.contains(joinPoint)) {
            return null
        }
        return aspect
    }

    /**
     * Read the names of the properties a body of an aspect declares.
     */
    private def static Map<String, String> propertiesOf(String body) {
        val properties = new LinkedHashMap<String, String>
        if (body === null) {
            return properties
        }
        val matcher = PROPERTY.matcher(body)
        while (matcher.find) {
            properties.put(matcher.group(2), matcher.group(1))
        }
        return properties
    }

    /**
     * Whether a declared property holds a number rather than a string.
     */
    def static boolean isNumeric(Aspect aspect, String propertyName) {
        return NUMERIC_TYPES.contains(aspect.properties.get(propertyName))
    }

    /**
     * Whether a declared property holds a boolean.
     */
    def static boolean isBoolean(Aspect aspect, String propertyName) {
        return BOOLEAN_TYPE == aspect.properties.get(propertyName)
    }

    /**
     * Keep only the values an aspect declares a property for, in the order the
     * model declares them.
     *
     * The reconstruction reports every element value an annotation states, and
     * the model is the closed vocabulary that decides which of them can be
     * expressed.
     *
     * @param aspect the declared aspect
     * @param values the values the reconstruction reported
     * @return the names of the values to assign, in declaration order
     */
    def static List<String> assignableProperties(Aspect aspect, Map<String, String> values) {
        if (aspect === null || values === null || values.empty) {
            return Collections.emptyList
        }
        return aspect.properties.keySet.filter[values.containsKey(it)].toList
    }
}
