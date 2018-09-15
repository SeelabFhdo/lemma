package de.fhdo.ddmm.typechecking.technology_specific

import de.fhdo.ddmm.typechecking.TypeCheckerI
import de.fhdo.ddmm.data.Type
import de.fhdo.ddmm.typechecking.TypecheckingUtils
import org.eclipse.xtext.EcoreUtil2
import de.fhdo.ddmm.technology.Technology
import de.fhdo.ddmm.technology.CompatibilityDirection
import org.eclipse.xtext.naming.QualifiedName

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
         * There needs to exist a compatibility matrix in the model of the basic type
         */
        val basicModel = EcoreUtil2.getContainerOfType(basicType, Technology)
        val compatibilityEntries = basicModel.compatibilityEntries
        if (compatibilityEntries.empty)
            return false

        /* Search for matching compatibility mappings in the matrix */
        val toCheckModel = EcoreUtil2.getContainerOfType(typeToCheck, Technology)
        return compatibilityEntries.exists[entry | entry.compatibleTypes.exists[compatibleType |
            compatibleEntry(basicType, basicModel, typeToCheck, toCheckModel,
                entry.mappingType.type, compatibleType.type, entry.direction)
        ]]
    }

    /**
     * Check if an entry in a compatibility matrix describes the compatibility between the given
     * basic type and the type to check
     */
    private def compatibleEntry(Type basicType, Technology basicModel, Type typeToCheck,
        Technology toCheckModel, Type mappingType, Type compatibleType,
        CompatibilityDirection direction) {
        /*
         * Build type names that include their defining technology model's names. This is necessary,
         * because a compatibility matrix may contain imported types from other technology models.
         *
         */
        val basicName = QualifiedName.create(basicModel.name, basicType.typeName).toString
        val toCheckName = QualifiedName.create(toCheckModel.name, typeToCheck.typeName).toString

        val mappingModel = EcoreUtil2.getContainerOfType(mappingType, Technology)
        val mappingName = QualifiedName.create(mappingModel.name, mappingType.typeName).toString

        val compatibleModel = EcoreUtil2.getContainerOfType(compatibleType, Technology)
        val compatibleName = QualifiedName.create(compatibleModel.name, compatibleType.typeName)
            .toString

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