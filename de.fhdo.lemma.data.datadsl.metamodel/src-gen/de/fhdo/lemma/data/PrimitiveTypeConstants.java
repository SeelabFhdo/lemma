/**
 */
package de.fhdo.lemma.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Primitive Type Constants</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Enumeration for primitive type constants (literal: type name, value: type size)
 * <!-- end-model-doc -->
 * @see de.fhdo.lemma.data.DataPackage#getPrimitiveTypeConstants()
 * @model
 * @generated
 */
public enum PrimitiveTypeConstants implements Enumerator {
    /**
     * The '<em><b>BOOLEAN</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #BOOLEAN_VALUE
     * @generated
     * @ordered
     */
    BOOLEAN(1, "BOOLEAN", "boolean"),

    /**
     * The '<em><b>BYTE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #BYTE_VALUE
     * @generated
     * @ordered
     */
    BYTE(8, "BYTE", "byte"),

    /**
     * The '<em><b>CHARACTER</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CHARACTER_VALUE
     * @generated
     * @ordered
     */
    CHARACTER(16, "CHARACTER", "char"),

    /**
     * The '<em><b>DATE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DATE_VALUE
     * @generated
     * @ordered
     */
    DATE(-1, "DATE", "date"),

    /**
     * The '<em><b>DOUBLE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DOUBLE_VALUE
     * @generated
     * @ordered
     */
    DOUBLE(64, "DOUBLE", "double"),

    /**
     * The '<em><b>FLOAT</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #FLOAT_VALUE
     * @generated
     * @ordered
     */
    FLOAT(32, "FLOAT", "float"),

    /**
     * The '<em><b>INTEGER</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #INTEGER_VALUE
     * @generated
     * @ordered
     */
    INTEGER(32, "INTEGER", "int"),

    /**
     * The '<em><b>LONG</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #LONG_VALUE
     * @generated
     * @ordered
     */
    LONG(64, "LONG", "long"),

    /**
     * The '<em><b>SHORT</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #SHORT_VALUE
     * @generated
     * @ordered
     */
    SHORT(16, "SHORT", "short"),

    /**
     * The '<em><b>STRING</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #STRING_VALUE
     * @generated
     * @ordered
     */
    STRING(-1, "STRING", "string"),

    /**
     * The '<em><b>UNSPECIFIED</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #UNSPECIFIED_VALUE
     * @generated
     * @ordered
     */
    UNSPECIFIED(-1, "UNSPECIFIED", "unspecified");

    /**
     * The '<em><b>BOOLEAN</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #BOOLEAN
     * @model literal="boolean"
     * @generated
     * @ordered
     */
    public static final int BOOLEAN_VALUE = 1;

    /**
     * The '<em><b>BYTE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #BYTE
     * @model literal="byte"
     * @generated
     * @ordered
     */
    public static final int BYTE_VALUE = 8;

    /**
     * The '<em><b>CHARACTER</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CHARACTER
     * @model literal="char"
     * @generated
     * @ordered
     */
    public static final int CHARACTER_VALUE = 16;

    /**
     * The '<em><b>DATE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DATE
     * @model literal="date"
     * @generated
     * @ordered
     */
    public static final int DATE_VALUE = -1;

    /**
     * The '<em><b>DOUBLE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DOUBLE
     * @model literal="double"
     * @generated
     * @ordered
     */
    public static final int DOUBLE_VALUE = 64;

    /**
     * The '<em><b>FLOAT</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #FLOAT
     * @model literal="float"
     * @generated
     * @ordered
     */
    public static final int FLOAT_VALUE = 32;

    /**
     * The '<em><b>INTEGER</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #INTEGER
     * @model literal="int"
     * @generated
     * @ordered
     */
    public static final int INTEGER_VALUE = 32;

    /**
     * The '<em><b>LONG</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #LONG
     * @model literal="long"
     * @generated
     * @ordered
     */
    public static final int LONG_VALUE = 64;

    /**
     * The '<em><b>SHORT</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #SHORT
     * @model literal="short"
     * @generated
     * @ordered
     */
    public static final int SHORT_VALUE = 16;

    /**
     * The '<em><b>STRING</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #STRING
     * @model literal="string"
     * @generated
     * @ordered
     */
    public static final int STRING_VALUE = -1;

    /**
     * The '<em><b>UNSPECIFIED</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #UNSPECIFIED
     * @model literal="unspecified"
     * @generated
     * @ordered
     */
    public static final int UNSPECIFIED_VALUE = -1;

    /**
     * An array of all the '<em><b>Primitive Type Constants</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final PrimitiveTypeConstants[] VALUES_ARRAY =
        new PrimitiveTypeConstants[] {
            BOOLEAN,
            BYTE,
            CHARACTER,
            DATE,
            DOUBLE,
            FLOAT,
            INTEGER,
            LONG,
            SHORT,
            STRING,
            UNSPECIFIED,
        };

    /**
     * A public read-only list of all the '<em><b>Primitive Type Constants</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<PrimitiveTypeConstants> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Primitive Type Constants</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static PrimitiveTypeConstants get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            PrimitiveTypeConstants result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Primitive Type Constants</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static PrimitiveTypeConstants getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            PrimitiveTypeConstants result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Primitive Type Constants</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static PrimitiveTypeConstants get(int value) {
        switch (value) {
            case BOOLEAN_VALUE: return BOOLEAN;
            case BYTE_VALUE: return BYTE;
            case CHARACTER_VALUE: return CHARACTER;
            case DATE_VALUE: return DATE;
            case DOUBLE_VALUE: return DOUBLE;
            case FLOAT_VALUE: return FLOAT;
        }
        return null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final int value;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final String name;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final String literal;

    /**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private PrimitiveTypeConstants(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getValue() {
      return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
      return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getLiteral() {
      return literal;
    }

    /**
     * Returns the literal value of the enumerator, which is its string representation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        return literal;
    }
    
} //PrimitiveTypeConstants
