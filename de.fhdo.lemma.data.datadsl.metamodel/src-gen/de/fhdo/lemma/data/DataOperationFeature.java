/**
 */
package de.fhdo.lemma.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Operation Feature</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * *
 * Possible features for a data operation
 * <!-- end-model-doc -->
 * @see de.fhdo.lemma.data.DataPackage#getDataOperationFeature()
 * @model
 * @generated
 */
public enum DataOperationFeature implements Enumerator {
    /**
     * The '<em><b>CLOSURE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CLOSURE_VALUE
     * @generated
     * @ordered
     */
    CLOSURE(0, "CLOSURE", "CLOSURE"),

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
     * The '<em><b>SIDE EFFECT FREE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #SIDE_EFFECT_FREE_VALUE
     * @generated
     * @ordered
     */
    SIDE_EFFECT_FREE(0, "SIDE_EFFECT_FREE", "SIDE_EFFECT_FREE"),

    /**
     * The '<em><b>VALIDATOR</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #VALIDATOR_VALUE
     * @generated
     * @ordered
     */
    VALIDATOR(0, "VALIDATOR", "VALIDATOR");

    /**
     * The '<em><b>CLOSURE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CLOSURE
     * @model
     * @generated
     * @ordered
     */
    public static final int CLOSURE_VALUE = 0;

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
     * The '<em><b>SIDE EFFECT FREE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #SIDE_EFFECT_FREE
     * @model
     * @generated
     * @ordered
     */
    public static final int SIDE_EFFECT_FREE_VALUE = 0;

    /**
     * The '<em><b>VALIDATOR</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #VALIDATOR
     * @model
     * @generated
     * @ordered
     */
    public static final int VALIDATOR_VALUE = 0;

    /**
     * An array of all the '<em><b>Operation Feature</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final DataOperationFeature[] VALUES_ARRAY =
        new DataOperationFeature[] {
            CLOSURE,
            IDENTIFIER,
            SIDE_EFFECT_FREE,
            VALIDATOR,
        };

    /**
     * A public read-only list of all the '<em><b>Operation Feature</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<DataOperationFeature> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Operation Feature</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static DataOperationFeature get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            DataOperationFeature result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Operation Feature</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static DataOperationFeature getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            DataOperationFeature result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Operation Feature</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static DataOperationFeature get(int value) {
        switch (value) {
            case CLOSURE_VALUE: return CLOSURE;
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
    private DataOperationFeature(int value, String name, String literal) {
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
    
} //DataOperationFeature
