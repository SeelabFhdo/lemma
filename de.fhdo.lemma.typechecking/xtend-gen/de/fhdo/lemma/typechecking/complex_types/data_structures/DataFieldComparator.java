package de.fhdo.lemma.typechecking.complex_types.data_structures;

import de.fhdo.lemma.data.DataField;
import de.fhdo.lemma.data.PrimitiveType;
import java.util.Comparator;

/**
 * Comparator for data fields
 * 
 * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 */
@SuppressWarnings("all")
public class DataFieldComparator implements Comparator<DataField> {
  public enum ORDERING {
    ASCENDING,

    DESCENDING,

    NONE;
  }

  private DataFieldComparator.ORDERING ordering;

  /**
   * Constructor
   */
  public DataFieldComparator(final DataFieldComparator.ORDERING ordering) {
    this.ordering = ordering;
  }

  /**
   * Compare two data fields. The comparison is based on the types of the fields. If one or both
   * data fields are primitively typed, comparison is based on type sizes. Otherwise it is based
   * on field names.
   */
  @Override
  public int compare(final DataField field, final DataField fieldToCompare) {
    final int comparisonResult = this.compareFields(field, fieldToCompare);
    final DataFieldComparator.ORDERING ordering = this.ordering;
    if (ordering != null) {
      switch (ordering) {
        case DESCENDING:
          return (comparisonResult * (-1));
        default:
          return comparisonResult;
      }
    } else {
      return comparisonResult;
    }
  }

  /**
   * Do the actual comparison
   */
  private int compareFields(final DataField field, final DataField fieldToCompare) {
    if (((field == null) || (fieldToCompare == null))) {
      throw new NullPointerException("None of the arguments may be null");
    }
    PrimitiveType _primitiveType = field.getPrimitiveType();
    boolean _tripleNotEquals = (_primitiveType != null);
    if (_tripleNotEquals) {
      return field.getPrimitiveType().sizeCompare(fieldToCompare.getPrimitiveType());
    } else {
      PrimitiveType _primitiveType_1 = fieldToCompare.getPrimitiveType();
      boolean _tripleNotEquals_1 = (_primitiveType_1 != null);
      if (_tripleNotEquals_1) {
        int _sizeCompare = fieldToCompare.getPrimitiveType().sizeCompare(field.getPrimitiveType());
        return (_sizeCompare * (-1));
      }
    }
    String _name = field.getName();
    boolean _tripleNotEquals_2 = (_name != null);
    if (_tripleNotEquals_2) {
      return field.getName().compareTo(fieldToCompare.getName());
    } else {
      String _name_1 = fieldToCompare.getName();
      boolean _tripleNotEquals_3 = (_name_1 != null);
      if (_tripleNotEquals_3) {
        int _compareTo = fieldToCompare.getName().compareTo(field.getName());
        return (_compareTo * (-1));
      }
    }
    return 0;
  }
}
