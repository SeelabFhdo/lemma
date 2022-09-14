/**
 */
package de.fhdo.lemma.technology;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Communication Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * *
 * Possible types of communication
 * <!-- end-model-doc -->
 * @see de.fhdo.lemma.technology.TechnologyPackage#getCommunicationType()
 * @model
 * @generated
 */
public enum CommunicationType implements Enumerator {
    /**
     * The '<em><b>SYNCHRONOUS</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #SYNCHRONOUS_VALUE
     * @generated
     * @ordered
     */
    SYNCHRONOUS(0, "SYNCHRONOUS", "SYNCHRONOUS"),

    /**
     * The '<em><b>ASYNCHRONOUS</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ASYNCHRONOUS_VALUE
     * @generated
     * @ordered
     */
    ASYNCHRONOUS(0, "ASYNCHRONOUS", "ASYNCHRONOUS");

    /**
     * The '<em><b>SYNCHRONOUS</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #SYNCHRONOUS
     * @model
     * @generated
     * @ordered
     */
    public static final int SYNCHRONOUS_VALUE = 0;

    /**
     * The '<em><b>ASYNCHRONOUS</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ASYNCHRONOUS
     * @model
     * @generated
     * @ordered
     */
    public static final int ASYNCHRONOUS_VALUE = 0;

    /**
     * An array of all the '<em><b>Communication Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final CommunicationType[] VALUES_ARRAY =
        new CommunicationType[] {
            SYNCHRONOUS,
            ASYNCHRONOUS,
        };

    /**
     * A public read-only list of all the '<em><b>Communication Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<CommunicationType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Communication Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static CommunicationType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            CommunicationType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Communication Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static CommunicationType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            CommunicationType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Communication Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static CommunicationType get(int value) {
        switch (value) {
            case SYNCHRONOUS_VALUE: return SYNCHRONOUS;
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
    private CommunicationType(int value, String name, String literal) {
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
    
} //CommunicationType
