package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types

import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List
import java.util.Collections
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.ProcessingConfiguration

/**
 * Abstract superclass for argument types.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
abstract class AbstractArgumentType {
    @Accessors(PUBLIC_GETTER)
    val ArgumentTypeIdentifier identifier

    /**
     * Two argument types are equal if they have the same identifier
     */
    final override equals(Object o) {
        return if (o === this)
            true
        else if (!(o instanceof AbstractArgumentType))
            false
        else
            identifier == (o as AbstractArgumentType).identifier
    }

    @Accessors(PUBLIC_GETTER)
    val String name

    val List<String> possibleValues

    /**
     * Constructor argument types without constrained possible values
     */
    new(ArgumentTypeIdentifier identifier, String name) {
        this(identifier, name, emptyList)
    }

    /**
     * Constructor
     */
    new(ArgumentTypeIdentifier identifier, String name, List<String> possibleValues) {
        if (identifier === null)
            throw new IllegalArgumentException("Argument type identifier must not be null")
        else if (name.nullOrEmpty)
            throw new IllegalArgumentException("Argument type name must not be null or empty")
        else if (possibleValues === null)
            throw new IllegalArgumentException("List of possible values must not be null")

        this.identifier = identifier
        this.name = name
        this.possibleValues = newArrayList(possibleValues)
        Collections.sort(this.possibleValues)
    }

    /**
     * Convert the given value into its internal representation. By default, the given value will be
     * returned. Implementers can override this method to provide argument-type-specific conversion
     * behavior.
     */
    def convertValueToInternalRepresentation(String value) {
        return value
    }

    /**
     * Validate the given value in its internal representation w.r.t. a concrete argument type
     * implementation and in the context of the given model processing configuration
     */
    abstract def void validateValueInInternalRepresentation(
        ProcessingConfiguration processingConfiguration,
        String value
    )

    /**
     * Convert the given value into its user representation. By default, the given value will be
     * returned. Implementers can override this method to provide argument-type-specific conversion
     * behavior.
     */
    def convertValueToUserRepresentation(String value) {
        return value
    }

    /**
     * Validate the given value in user representation w.r.t. a concrete argument type
     * implementation and in the context of the given model processing configuration. By default,
     * the method delegates to validateValueInInternalRepresentation(). However, implementers may
     * override it in case a value has a user representation that differs from its internal
     * representation. For example, a value may internally constitute the literal of an enumeration
     * but will be represented to the user as some descriptive text of the literal's semantics. By
     * overriding the method, implementers can react to validation requests resulting from user
     * interactions, e.g., the selection of the descriptive text for a literal of an argument of an
     * enumeration-based type in the arguments table.
     */
    def void validateValueInUserRepresentation(
        ProcessingConfiguration processingConfiguration,
        String value
    ) {
        validateValueInInternalRepresentation(processingConfiguration, value)
    }

    /**
     * Get the list of the type's possible values
     */
    final def getPossibleValues() {
        return possibleValues.unmodifiableView
    }
}