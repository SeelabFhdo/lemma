/**
 */
package de.fhdo.lemma.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Microservice Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * *
 * Type of a microservice
 * <!-- end-model-doc -->
 * @see de.fhdo.lemma.service.ServicePackage#getMicroserviceType()
 * @model
 * @generated
 */
public enum MicroserviceType implements Enumerator {
    /**
     * The '<em><b>FUNCTIONAL</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #FUNCTIONAL_VALUE
     * @generated
     * @ordered
     */
    FUNCTIONAL(0, "FUNCTIONAL", "FUNCTIONAL"),

    /**
     * The '<em><b>UTILITY</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #UTILITY_VALUE
     * @generated
     * @ordered
     */
    UTILITY(0, "UTILITY", "UTILITY"),

    /**
     * The '<em><b>INFRASTRUCTURE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #INFRASTRUCTURE_VALUE
     * @generated
     * @ordered
     */
    INFRASTRUCTURE(0, "INFRASTRUCTURE", "INFRASTRUCTURE");

    /**
     * The '<em><b>FUNCTIONAL</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>FUNCTIONAL</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #FUNCTIONAL
     * @model
     * @generated
     * @ordered
     */
    public static final int FUNCTIONAL_VALUE = 0;

    /**
     * The '<em><b>UTILITY</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>UTILITY</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #UTILITY
     * @model
     * @generated
     * @ordered
     */
    public static final int UTILITY_VALUE = 0;

    /**
     * The '<em><b>INFRASTRUCTURE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>INFRASTRUCTURE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #INFRASTRUCTURE
     * @model
     * @generated
     * @ordered
     */
    public static final int INFRASTRUCTURE_VALUE = 0;

    /**
     * An array of all the '<em><b>Microservice Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final MicroserviceType[] VALUES_ARRAY =
        new MicroserviceType[] {
            FUNCTIONAL,
            UTILITY,
            INFRASTRUCTURE,
        };

    /**
     * A public read-only list of all the '<em><b>Microservice Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<MicroserviceType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Microservice Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static MicroserviceType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            MicroserviceType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Microservice Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static MicroserviceType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            MicroserviceType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Microservice Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static MicroserviceType get(int value) {
        switch (value) {
            case FUNCTIONAL_VALUE: return FUNCTIONAL;
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
    private MicroserviceType(int value, String name, String literal) {
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
    
} //MicroserviceType
