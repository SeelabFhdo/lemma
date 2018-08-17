package de.fhdo.ddmm.typechecking

import de.fhdo.ddmm.data.Type
import de.fhdo.ddmm.data.PrimitiveType
import de.fhdo.ddmm.data.ComplexType
import de.fhdo.ddmm.typechecking.complex_types.ComplexTypeChecker
import de.fhdo.ddmm.typechecking.primitive_types.PrimitiveTypeChecker
import de.fhdo.ddmm.typechecking.compatibility_matrix.MatrixBasedTypeChecker

/**
 * Generic type checker that uses the corresponding TypeCheckers for the given Type instances to
 * check.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de>Florian Rademacher</a>
 */
class TypeChecker {
    def checkTypeCompatibility(Type basicType, Type typeToCheck)
        throws TypesNotCompatibleException {
        if (basicType === null || typeToCheck === null)
            throw new IllegalArgumentException("None of the arguments must be null")

        /*
         * Try technology-specific type checking first, in case the compatibility of both types is
         * defined in a compatibility matrix. That is, both types are compatible "by definition" and
         * no further checks are necessary.
         */
        if (TypecheckingUtils.isTechnologySpecific(basicType) &&
            TypecheckingUtils.isTechnologySpecific(typeToCheck)) {
            val matrixBasedChecker = new MatrixBasedTypeChecker()
            if (matrixBasedChecker.compatible(basicType, typeToCheck))
                return true
        }

        /*
         * Determine type checker to use, if both types aren't technology-specific or do not have
         * their compatibility defined by a technology-specific compatibility matrix. Perform check
         * leveraging the determined type checker.
         */
        var TypeCheckerI typeChecker = null
        // PrimitiveType
        if (basicType instanceof PrimitiveType && typeToCheck instanceof PrimitiveType)
            typeChecker = new PrimitiveTypeChecker
        // ComplexType
        else if (basicType instanceof ComplexType && typeToCheck instanceof ComplexType)
            typeChecker = new ComplexTypeChecker
        // Basic type and type to check differ, and checking is hence not possible
        else
            throw new TypesNotCompatibleException(basicType.class.name, typeToCheck.class.name)

        performTypeCheck(typeChecker, basicType, typeToCheck)
    }

    /**
     * Perform the actual type checking with the given type checker
     */
    private def performTypeCheck(TypeCheckerI typeChecker, Type basicType, Type typeToCheck)
        throws TypesNotCompatibleException {
        var Boolean typesCompatible = null

        try {
            typesCompatible = typeChecker.compatible(basicType, typeToCheck)
        // In case the compatibility check might fail unexpectedly. Might be removed in the future,
        // when checker implementations got properly tested.
        } catch(Exception ex) {
            ex.printStackTrace
        }

        if (typesCompatible !== null && !typesCompatible)
            throw new TypesNotCompatibleException(typeChecker.typeName(basicType),
                typeChecker.typeName(typeToCheck))
    }
}