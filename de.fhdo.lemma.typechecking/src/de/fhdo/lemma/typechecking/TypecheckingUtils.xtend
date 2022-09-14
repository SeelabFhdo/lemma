package de.fhdo.lemma.typechecking

import de.fhdo.lemma.data.Type
import de.fhdo.lemma.technology.TechnologySpecificPrimitiveType
import de.fhdo.lemma.data.ComplexType
import de.fhdo.lemma.data.PrimitiveType
import org.eclipse.xtext.naming.QualifiedName
import de.fhdo.lemma.technology.TechnologySpecificDataStructure
import de.fhdo.lemma.technology.TechnologySpecificCollectionType
import de.fhdo.lemma.technology.Technology

/**
 * This class defines _static_ utility methods to be used across DSLs' implementations for generic
 * type and typechecking tasks.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class TypecheckingUtils {
    /**
     * Get fully qualified name of a type
     */
    static def getTypeName(Type type) {
        return getTypeName(type, false)
    }

    /**
     * Get name of a type, possibly without qualifying parts
     */
    static def getTypeName(Type type, boolean withoutQualifyingParts) {
        val nameParts = getTypeNameParts(type, withoutQualifyingParts)
        if (nameParts === null)
            return null

        return QualifiedName.create(nameParts).toString
    }

    /**
     * Get full qualifying name parts of a type
     */
    static def getTypeNameParts(Type type, boolean withoutQualifyingParts) {
        if (type === null)
            return null

        val nameParts = switch (type) {
            TechnologySpecificPrimitiveType: type.qualifiedNameParts
            PrimitiveType: #[type.typeName]
            ComplexType: type.qualifiedNameParts
            default: null
        }

        if (nameParts === null)
            return null

        if (withoutQualifyingParts) {
            val namePartsWithoutQualifyingParts = <String> newArrayList(nameParts.last)
            return namePartsWithoutQualifyingParts
        } else
            return nameParts
    }

    /**
     * Determine if a type is technology-specific
     */
    static def isTechnologySpecific(Type type) {
        if (type === null)
            return false

        return type instanceof TechnologySpecificPrimitiveType ||
            type instanceof TechnologySpecificDataStructure ||
            type instanceof TechnologySpecificCollectionType
    }

    /**
     * Get technology of technology-specific type
     */
    static def getTechnology(Type type) {
        if (type === null || !isTechnologySpecific(type))
            return null

        switch (type) {
            TechnologySpecificPrimitiveType: type.technology
            TechnologySpecificDataStructure: type.technology
            TechnologySpecificCollectionType: type.technology
        }
    }

    /**
     * Find default technology-specific primitive type for builtin primitive type
     */
    static def findDefaultTechnologySpecificPrimitiveType(Technology technology,
        PrimitiveType primitiveType) {
        if (technology === null || primitiveType === null)
            return null

        return technology.primitiveTypes.findFirst[
            ^default && basicBuiltinPrimitiveTypes.exists[it.typeName === primitiveType.typeName]
        ]
    }
}