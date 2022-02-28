package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.kinds

/**
 * Factory for argument kind creation. Note that the factory caches created argument kinds and
 * returns the same AbstractArgumentKind instance for repeated factory queries for the same argument
 * kinds.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
 final class ArgumentKindFactory {
    static val CREATED_KINDS = <ArgumentKindIdentifier, AbstractArgumentKind>newHashMap

    /**
     * Create an argument kind or return an already created argument kind from the given identifier
     * string. Return null if the identifier string is null or empty.
     */
    static def fromIdentifier(String identifierString) {
        return if (!identifierString.nullOrEmpty)
                fromIdentifier(ArgumentKindIdentifier.valueOf(identifierString))
            else
                null
    }

    /**
     * Create an argument kind or return an already created argument kind from the given argument
     * kind identifier. Return null if the identifier is null.
     */
    static def fromIdentifier(ArgumentKindIdentifier identifier) {
        if (identifier === null)
            return null

        val existingKind = CREATED_KINDS.get(identifier)
        if (existingKind !== null)
            return existingKind

        val createdKind = switch (identifier) {
            case ConstantParameterArgumentKind.IDENTIFIER:
                new ConstantParameterArgumentKind()
            case MultiValuedParameterArgumentKind.IDENTIFIER:
                new MultiValuedParameterArgumentKind()
            case SingleValuedParameterArgumentKind.IDENTIFIER:
                new SingleValuedParameterArgumentKind()
            default:
                throw new IllegalArgumentException("Creation of argument kind with identifier " +
                '''"«identifier»" not supported''')
        }

        CREATED_KINDS.put(identifier, createdKind)
        return createdKind
    }
}