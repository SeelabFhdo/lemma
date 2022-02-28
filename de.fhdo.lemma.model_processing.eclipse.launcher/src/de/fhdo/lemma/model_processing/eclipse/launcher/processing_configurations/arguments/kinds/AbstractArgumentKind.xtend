package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds

import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List
import de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types.AbstractArgumentType

/**
 * Abstract superclass for argument kinds.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
abstract class AbstractArgumentKind {
    @Accessors(PUBLIC_GETTER)
    val ArgumentKindIdentifier identifier

    /**
     * Two argument kinds are equal if they have the same identifier
     */
    final override equals(Object o) {
        return if (o === this)
            true
        else if (!(o instanceof AbstractArgumentKind))
            false
        else
            identifier == (o as AbstractArgumentKind).identifier
    }

    @Accessors(PUBLIC_GETTER)
    val String name

    val List<AbstractArgumentType> supportedArgumentTypes

    /**
     * Constructor
     */
    new(ArgumentKindIdentifier identifier, String name,
        AbstractArgumentType... supportedArgumentTypes) {
        if (identifier === null)
            throw new IllegalArgumentException("Argument kind identifier must not be null")
        else if (name.nullOrEmpty)
            throw new IllegalArgumentException("Argument kind name must not be null or empty")
        else if (supportedArgumentTypes.empty)
            throw new IllegalArgumentException("Argument types must not be empty")

        this.identifier = identifier
        this.name = name
        this.supportedArgumentTypes = supportedArgumentTypes
    }

    /**
     * Get the argument types supported by the kind
     */
    final def getSupportedArgumentTypes() {
        return supportedArgumentTypes.unmodifiableView
    }

    /**
     * Get the first argument type supported by the kind. The method determines the first argument
     * by sorting the supported argument types by name and returning the argument type with the
     * lexicographically first name.
     */
    final def getAlphabeticallyFirstSupportedArgumentType() {
        return supportedArgumentTypes.sortBy[name].get(0)
    }

    /**
     * Validate if the argument kind supports the given argument type
     */
    final def validateTypeSupport(AbstractArgumentType type) {
        if (!supportedArgumentTypes.contains(type))
            throw new IllegalArgumentException('''Argument kind "«name»" does not support ''' +
                '''argument type "«type.name»"''')
    }
}