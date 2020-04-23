/**
 */
package de.fhdo.lemma.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Field Feature</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * *
 * Possible features for a data field
 * <!-- end-model-doc -->
 * @see de.fhdo.lemma.data.DataPackage#getDataFieldFeature()
 * @model
 * @generated
 */
public enum DataFieldFeature implements Enumerator {
    /**
     * The '<em><b>IDENTIFIER</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #IDENTIFIER_VALUE
     * @generated
     * @ordered
     */
    IDENTIFIER(0, "IDENTIFIER", "IDENTIFIER"),

    /**
     * The '<em><b>NEVER EMPTY</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #NEVER_EMPTY_VALUE
     * @generated
     * @ordered
     */
    NEVER_EMPTY(0, "NEVER_EMPTY", "NEVER_EMPTY"),

    /**
     * The '<em><b>PART</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #PART_VALUE
     * @generated
     * @ordered
     */
    PART(0, "PART", "PART");

    /**
     * The '<em><b>IDENTIFIER</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #IDENTIFIER
     * @model
     * @generated
     * @ordered
     */
    public static final int IDENTIFIER_VALUE = 0;

    /**
     * The '<em><b>NEVER EMPTY</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #NEVER_EMPTY
     * @model
     * @generated
     * @ordered
     */
    public static final int NEVER_EMPTY_VALUE = 0;

    /**
     * The '<em><b>PART</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #PART
     * @model
     * @generated
     * @ordered
     */
    public static final int PART_VALUE = 0;

    /**
     * An array of all the '<em><b>Field Feature</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final DataFieldFeature[] VALUES_ARRAY =
        new DataFieldFeature[] {
            IDENTIFIER,
            NEVER_EMPTY,
            PART,
        };

    /**
     * A public read-only list of all the '<em><b>Field Feature</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<DataFieldFeature> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Field Feature</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static DataFieldFeature get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            DataFieldFeature result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Field Feature</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static DataFieldFeature getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            DataFieldFeature result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Field Feature</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static DataFieldFeature get(int value) {
        switch (value) {
            case IDENTIFIER_VALUE: return IDENTIFIER;
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
    private DataFieldFeature(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int getValue() {
      return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getName() {
      return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
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
    
} //DataFieldFeature
