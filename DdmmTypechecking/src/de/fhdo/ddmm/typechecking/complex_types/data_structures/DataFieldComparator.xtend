package de.fhdo.ddmm.typechecking.complex_types.data_structures

import java.util.Comparator
import de.fhdo.ddmm.data.DataField

/**
 * Comparator for data fields
 *
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
class DataFieldComparator implements Comparator<DataField> {
    enum ORDERING {
        ASCENDING,
        DESCENDING,
        NONE
    }

    var ORDERING ordering

    /**
     * Constructor
     */
    new(ORDERING ordering) {
        this.ordering = ordering
    }

    /**
     * Compare two data fields. The comparison is based on the types of the fields. If one or both
     * data fields are primitively typed, comparison is based on type sizes. Otherwise it is based
     * on field names.
     */
    override compare(DataField field, DataField fieldToCompare) {
        val comparisonResult = compareFields(field, fieldToCompare)

        switch (ordering) {
            case DESCENDING: return comparisonResult * -1
            default: return comparisonResult
        }
    }

    /**
     * Do the actual comparison
     */
    private def compareFields(DataField field, DataField fieldToCompare) {
        if (field === null || fieldToCompare === null)
            throw new NullPointerException("None of the arguments may be null")

        /* One field is of primitive type and we can do a size comparison */
        if (field.primitiveType !== null)
            return field.primitiveType.sizeCompare(fieldToCompare.primitiveType)
        else if (fieldToCompare.primitiveType !== null)
            return fieldToCompare.primitiveType.sizeCompare(field.primitiveType) * -1

        /*
         * Both fields are not of primitive type. If one field's name is not null, compare it with
         * the other field's name.
         */
        if (field.name !== null)
            return field.name.compareTo(fieldToCompare.name)
        else if (fieldToCompare.name !== null)
            return fieldToCompare.name.compareTo(field.name) * -1

        /* Both fields are not primitively typed and both field names are null */
        return 0
    }
}