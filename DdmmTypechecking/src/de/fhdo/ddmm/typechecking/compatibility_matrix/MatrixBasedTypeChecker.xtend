package de.fhdo.ddmm.typechecking.compatibility_matrix

import de.fhdo.ddmm.typechecking.TypeCheckerI
import de.fhdo.ddmm.data.Type
import de.fhdo.ddmm.typechecking.TypecheckingUtils
import org.eclipse.xtext.EcoreUtil2
import de.fhdo.ddmm.technology.Technology
import de.fhdo.ddmm.technology.CompatibilityDirection

/**
 * Type checker for technology-specific types, whose compatibility might be defined in a
 * compatibility matrix.
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de>Florian Rademacher</a>
 */
class MatrixBasedTypeChecker implements TypeCheckerI<Type> {
    /**
     * Compare two technology-specific types on the basis of the compatibility matrix of their
     * parent technology model. If no compatibility matrix is defined, the method will return false.
     */
    override compatible(Type basicType, Type typeToCheck) {
        /* Types need to be technology-specific */
        if (!TypecheckingUtils.isTechnologySpecific(basicType) &&
            !TypecheckingUtils.isTechnologySpecific(typeToCheck))
            return false

        /*
         * Types need to be defined in the same technology model, so that they belong to the same
         * compatibility matrix, if any
         */
        val basicModel = EcoreUtil2.getContainerOfType(basicType, Technology)
        val toCheckModel = EcoreUtil2.getContainerOfType(typeToCheck, Technology)
        if (basicModel != toCheckModel)
            return false

        /*
         * There need to exist a compatibility matrix
         */
        val compatibilityEntries = basicModel.compatibilityEntries
        if (compatibilityEntries.empty)
            return false

        /* Search for matching compatibility mappings in the matrix */
        return compatibilityEntries.exists[entry | entry.compatibleTypes.exists[compatibleType |
            compatibleEntry(basicType, typeToCheck, entry.mappingType, compatibleType,
                entry.direction)
        ]]
    }

    /**
     * Check if an entry in a compatibility matrix describes the compatibility between the given
     * basic type and the type to check
     */
    private def compatibleEntry(Type basicType, Type typeToCheck, Type mappingType,
        Type compatibleType, CompatibilityDirection direction) {
        val basicName = basicType.typeName
        val toCheckName = typeToCheck.typeName
        val mappingName = mappingType.typeName
        val compatibleName = compatibleType.typeName

        /*
         * What needs to be found is a compatibility entry that corresponds to the semantics of
         * type to check -> basic type (read "type to check can be converted to basic type")
         */
        // Mapping entry corresponds to "compatible type <- mapping type", which means that type to
        // check must equal (==) mapping type and basic type == compatible type
        if (direction === CompatibilityDirection.MAPPING_TO_COMPATIBLE_TYPES)
            return toCheckName == mappingName && basicName == compatibleName

        // Mapping entry corresponds to "compatible type -> mapping type", which means that type to
        // check == compatible type and basic type == mapping type
        else if (direction === CompatibilityDirection.COMPATIBLE_TYPES_TO_MAPPING)
            return toCheckName == compatibleName && basicName == mappingName

        // Mapping entry corresponds to "compatible type <-> mapping type", which means that either
        //     type to check == mapping type and basic type == compatible type
        // or
        //     type to check == compatible type and basic type == mapping type
        else if (direction === CompatibilityDirection.BIDIRECTIONAL)
            return toCheckName == mappingName && basicName == compatibleName ||
                toCheckName == compatibleName && basicName == mappingName

        return false
    }

    /**
     * Get type name
     */
    override typeName(Type type) {
        return TypecheckingUtils.getTypeName(type)
    }
}