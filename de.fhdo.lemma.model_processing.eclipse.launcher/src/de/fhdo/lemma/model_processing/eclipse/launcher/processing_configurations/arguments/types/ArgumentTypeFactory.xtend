package de.fhdo.lemma.model_processing.eclipse.launcher.processing_configurations.arguments.types

/**
 * Factory for argument type creation. Note that the factory caches created argument types and
 * returns the same AbstractArgumentType instance for repeated factory queries for the same argument
 * types.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
final class ArgumentTypeFactory {
    static val CREATED_TYPES = <ArgumentTypeIdentifier, AbstractArgumentType>newHashMap

    /**
     * Create an argument type or return an already created argument type from the given identifier
     * string. Return null if the identifier string is null or empty.
     */
    static def fromIdentifier(String identifierString) {
        return if (!identifierString.nullOrEmpty)
                fromIdentifier(ArgumentTypeIdentifier.valueOf(identifierString))
            else
                null
    }

    /**
     * Create an argument type or return an already created argument type from the given argument
     * type identifier. Return null if the identifier is null.
     */
    static def fromIdentifier(ArgumentTypeIdentifier identifier) {
        if (identifier === null)
            return null

        val existingType = CREATED_TYPES.get(identifier)
        if (existingType !== null)
            return existingType

        val createdType = switch (identifier) {
            case FileArgumentType.IDENTIFIER:
                new FileArgumentType()
            case FolderArgumentType.IDENTIFIER:
                new FolderArgumentType()
            case IntermediateModelArgumentType.IDENTIFIER:
                new IntermediateModelArgumentType()
            case IntermediateModelOfFirstImportArgumentType.IDENTIFIER:
                new IntermediateModelOfFirstImportArgumentType()
            case IntermediateModelsOfAllImportsArgumentType.IDENTIFIER:
                new IntermediateModelsOfAllImportsArgumentType()
            case IntermediateModelOfImportWithAliasArgumentType.IDENTIFIER:
                new IntermediateModelOfImportWithAliasArgumentType()
            case RawStringArgumentType.IDENTIFIER:
                new RawStringArgumentType()
            case SourceModelArgumentType.IDENTIFIER:
                new SourceModelArgumentType()
            case StringPairArgumentType.IDENTIFIER:
                new StringPairArgumentType()
            default:
                throw new IllegalArgumentException("Creation of argument type with identifier " +
                    '''"«identifier»" not supported''')
        }

        CREATED_TYPES.put(identifier, createdType)
        return createdType
    }
}