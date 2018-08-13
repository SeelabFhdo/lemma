package de.fhdo.ddmm.data.typechecking.primitive_types

import de.fhdo.ddmm.data.PrimitiveType
import de.fhdo.ddmm.data.typechecking.TypeCheckerI

/**
 * Simple TypeChecker implementation for PrimitiveTypes that builds upon the metamodel's
 * PrimitiveType compatibility check.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de>Florian Rademacher</a>
 */
class PrimitiveTypeChecker implements TypeCheckerI<PrimitiveType> {
    override compatible(PrimitiveType basicType, PrimitiveType typeToCheck) {
        return basicType.isCompatibleWith(typeToCheck)
    }

    override typeName(PrimitiveType type) {
        return type.typeName
    }
}