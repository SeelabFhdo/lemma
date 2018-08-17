package de.fhdo.ddmm.typechecking

import de.fhdo.ddmm.data.Type
import de.fhdo.ddmm.technology.TechnologySpecificPrimitiveType
import de.fhdo.ddmm.data.ComplexType
import de.fhdo.ddmm.data.PrimitiveType
import org.eclipse.xtext.naming.QualifiedName
import de.fhdo.ddmm.technology.TechnologySpecificDataStructure
import de.fhdo.ddmm.technology.TechnologySpecificListType

/**
 * This class defines _static_ utility methods to be used across DSLs' implementations for generic
 * type and typechecking tasks.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de>Florian Rademacher</a>
 */
class TypecheckingUtils {
    /**
     * Get name of a type
     */
    static def getTypeName(Type type) {
        if (type === null)
            return null

        val nameParts = switch (type) {
            TechnologySpecificPrimitiveType: #[type.name]
            PrimitiveType: #[type.typeName]
            ComplexType: type.qualifiedNameParts
            default: null
        }

        if (nameParts === null)
            return null

        return QualifiedName.create(nameParts).toString
    }

    /**
     * Determine if a type is technology-specific
     */
    static def isTechnologySpecific(Type type) {
        if (type === null)
            return false

        return type instanceof TechnologySpecificPrimitiveType ||
            type instanceof TechnologySpecificDataStructure ||
            type instanceof TechnologySpecificListType
    }
}