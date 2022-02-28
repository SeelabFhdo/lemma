package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types

import java.util.Map
import java.util.List
import com.google.common.collect.BiMap
import com.google.common.collect.HashBiMap
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration

/**
 * Abstract superclass for argument types that are based on enumerations whose literals determine
 * types' valid values.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
abstract class AbstractArgumentTypeWithEnumValueSelection<T extends Enum<?>>
    extends AbstractArgumentType {
    val List<String> literalDescriptionsSorted
    val String enumClassName
    val BiMap<String, String> literalNamesAndDescriptions

    /**
     * Constructor. Note that the descriptions in the map of literal descriptions must be unique to
     * allow unambiguous identification of a literal from its description (which is the user
     * representation of the value of an argument with this enumeration-based type).
     */
    new(ArgumentTypeIdentifier identifier, String name, Map<T, String> literalsAndDescriptions) {
        super(identifier, name)

        if (literalsAndDescriptions.empty)
            throw new IllegalArgumentException("No literal descriptions given")

        literalDescriptionsSorted = literalsAndDescriptions.values.sort
        enumClassName = literalsAndDescriptions.keySet.toList.get(0).class.simpleName

        if (literalsAndDescriptions.values.size != literalsAndDescriptions.values.toSet.size)
            throw new IllegalArgumentException("Duplicate descriptions for enum " + enumClassName)

        literalNamesAndDescriptions = HashBiMap.create(
            literalsAndDescriptions.keySet.toMap([it.name], [literalsAndDescriptions.get(it)])
        )
    }

    /**
     * Get the description of the given literal
     */
    final def getLiteralDescription(T literal) {
        return getLiteralDescription(literal.name)
    }

    /**
     * Convert the given literal description into its internal representation, i.e., the name of the
     * the literal, for this enumeration-based type
     */
    final override convertValueToInternalRepresentation(String literalDescription) {
        return getLiteralName(literalDescription)
    }

    /**
     * Get the name of the literal from the given description
     */
    final def getLiteralName(String literalDescription) {
        return literalNamesAndDescriptions.inverse().get(literalDescription)
    }

    /**
     * Validate the internal value, i.e., the name of the literal, of an argument of this
     * enumeration-based type
     */
    final override validateValueInInternalRepresentation(
        ProcessingConfiguration processingConfiguration,
        String literalName
    ) {
        if (!literalNamesAndDescriptions.keySet.contains(literalName))
            throw new IllegalArgumentException('''Invalid literal name "«literalName»" for ''' +
                '''enum «enumClassName»''')
    }

    /**
     * Convert the given literal name into its user representation, i.e., the description of the
     * the literal, for this enumeration-based type
     */
    final override convertValueToUserRepresentation(String literalName) {
        return getLiteralDescription(literalName)
    }

    /**
     * Get the description of the literal with the given name
     */
    final def getLiteralDescription(String literalName) {
        return literalNamesAndDescriptions.get(literalName)
    }

    /**
     * Validate the user value, i.e., the description of the literal, of an argument of this
     * enumeration-based type. Implementers may override this method to accompany user validation
     * with additional checks. However, overridden methods must invoke this method on the
     * superclass.
     */
    override validateValueInUserRepresentation(ProcessingConfiguration configuration,
        String literalDescription) {
        if (!literalNamesAndDescriptions.inverse().keySet.contains(literalDescription))
            throw new IllegalArgumentException("Please select a value from the following: " +
                literalDescriptionsSorted.join(", "))
    }

    /**
     * Get the literal descriptions in alphabetic order
     */
    final def getLiteralDescriptionsSorted() {
        return literalDescriptionsSorted.unmodifiableView
    }
}
