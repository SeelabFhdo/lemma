/**
 */
package de.fhdo.lemma.technology;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Exchange Pattern</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * *
 * Exchange patterns
 * <!-- end-model-doc -->
 * @see de.fhdo.lemma.technology.TechnologyPackage#getExchangePattern()
 * @model
 * @generated
 */
public enum ExchangePattern implements Enumerator {
    /**
     * The '<em><b>IN</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #IN_VALUE
     * @generated
     * @ordered
     */
    IN(0, "IN", "IN"),

    /**
     * The '<em><b>OUT</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #OUT_VALUE
     * @generated
     * @ordered
     */
    OUT(0, "OUT", "OUT"),

    /**
     * The '<em><b>INOUT</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #INOUT_VALUE
     * @generated
     * @ordered
     */
    INOUT(0, "INOUT", "INOUT");

    /**
     * The '<em><b>IN</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #IN
     * @model
     * @generated
     * @ordered
     */
    public static final int IN_VALUE = 0;

    /**
     * The '<em><b>OUT</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #OUT
     * @model
     * @generated
     * @ordered
     */
    public static final int OUT_VALUE = 0;

    /**
     * The '<em><b>INOUT</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #INOUT
     * @model
     * @generated
     * @ordered
     */
    public static final int INOUT_VALUE = 0;

    /**
     * An array of all the '<em><b>Exchange Pattern</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final ExchangePattern[] VALUES_ARRAY =
        new ExchangePattern[] {
            IN,
            OUT,
            INOUT,
        };

    /**
     * A public read-only list of all the '<em><b>Exchange Pattern</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<ExchangePattern> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Exchange Pattern</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static ExchangePattern get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ExchangePattern result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Exchange Pattern</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static ExchangePattern getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ExchangePattern result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Exchange Pattern</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static ExchangePattern get(int value) {
        switch (value) {
            case IN_VALUE: return IN;
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
    private ExchangePattern(int value, String name, String literal) {
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
    
} //ExchangePattern
