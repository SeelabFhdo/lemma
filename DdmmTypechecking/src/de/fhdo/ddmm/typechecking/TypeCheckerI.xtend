package de.fhdo.ddmm.typechecking

import de.fhdo.ddmm.data.Type

/**
 * Interface for type checkers of a certain Type
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
interface TypeCheckerI<T extends Type> {
    def boolean compatible(T basicType, T typeToCheck)

    def String typeName(T type)
}