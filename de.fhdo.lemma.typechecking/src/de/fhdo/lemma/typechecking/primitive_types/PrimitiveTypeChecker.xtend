package de.fhdo.lemma.typechecking.primitive_types

import de.fhdo.lemma.data.PrimitiveType
import de.fhdo.lemma.typechecking.TypeCheckerI
import de.fhdo.lemma.technology.TechnologySpecificPrimitiveType
import de.fhdo.lemma.typechecking.TypecheckingUtils
import de.fhdo.lemma.data.PrimitiveUnspecified

/**
 * Simple TypeChecker implementation for PrimitiveTypes and TechnologySpecificPrimitiveTypes that
 * builds upon the metamodel's PrimitiveType compatibility check.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class PrimitiveTypeChecker implements TypeCheckerI<PrimitiveType> {
    /**
     * Compare two built-in or technology-specific primitive types. Note that mixing PrimitiveType
     * and TechnologySpecificPrimitiveType instances is possible.
     */
    override compatible(PrimitiveType basicType, PrimitiveType typeToCheck) {
        return checkCompatibility(basicType, typeToCheck)
    }

    /**
     * Dispatcher method to check compatibility of two PrimitiveType instances
     */
    private dispatch def checkCompatibility(PrimitiveType basicType, PrimitiveType typeToCheck) {
        return basicType.isCompatibleWith(typeToCheck)
    }

    /**
     * Dispatcher method to check if PrimitiveType instance is compatible with
     * TechnologySpecificPrimitiveType instance
     */
    private dispatch def checkCompatibility(TechnologySpecificPrimitiveType basicType,
        PrimitiveType typeToCheck) {
        // The technology-specific type is compatible with the primitive type to check if one of the
        // former's basic built-in primitive types is compatible with the primitive type to check.
        // The unspecified primitive type is a special case. It is only compatible to a
        // technology-specific type when the latter is based on the unspecified primitive type.
        return if (!(typeToCheck instanceof PrimitiveUnspecified))
                basicType.basicBuiltinPrimitiveTypes.exists[isCompatibleWith(typeToCheck)]
            else
                basicType.basicBuiltinPrimitiveTypes.exists[it instanceof PrimitiveUnspecified]
    }

    /**
     * Dispatcher method to check if TechnologySpecificPrimitiveType instance is compatible with
     * PrimitiveType instance
     */
    private dispatch def checkCompatibility(PrimitiveType basicType,
        TechnologySpecificPrimitiveType typeToCheck) {
        // The primitive type is compatible with the technology-specific type to check if it is
        // compatible with one of the latter's basic built-in primitive types. The unspecified
        // primitive type is a special case. It is only compatible to a technology-specific type
        // when the latter is based on the unspecified primitive type.
        return if (!(basicType instanceof PrimitiveUnspecified))
                typeToCheck.basicBuiltinPrimitiveTypes.exists[basicType.isCompatibleWith(it)]
            else
                typeToCheck.basicBuiltinPrimitiveTypes.exists[it instanceof PrimitiveUnspecified]
    }

    /**
     * Dispatcher method to check compatibility of two TechnologySpecificPrimitiveType instances
     */
    private dispatch def checkCompatibility(TechnologySpecificPrimitiveType basicType,
        TechnologySpecificPrimitiveType typeToCheck) {
        // The basic type is compatible with the type to check of there exists a combination of
        // compatible basic built-in primitive types
        return basicType.basicBuiltinPrimitiveTypes.exists[basic |
            typeToCheck.basicBuiltinPrimitiveTypes.exists[toCheck |
                basic.isCompatibleWith(toCheck)
            ]
        ]
    }

    /**
     * Get name of primitive or technology-specific primitive type
     */
    override typeName(PrimitiveType type) {
        return TypecheckingUtils.getTypeName(type)
    }
}