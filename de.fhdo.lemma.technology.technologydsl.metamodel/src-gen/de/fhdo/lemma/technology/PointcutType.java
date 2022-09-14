/**
 */
package de.fhdo.lemma.technology;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Pointcut Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * *
 * Types of the possible pointcuts of technology aspects
 * <!-- end-model-doc -->
 * @see de.fhdo.lemma.technology.TechnologyPackage#getPointcutType()
 * @model
 * @generated
 */
public enum PointcutType implements Enumerator {
    /**
     * The '<em><b>EXCHANGE PATTERN</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #EXCHANGE_PATTERN_VALUE
     * @generated
     * @ordered
     */
    EXCHANGE_PATTERN(0, "EXCHANGE_PATTERN", "EXCHANGE_PATTERN"),

    /**
     * The '<em><b>COMMUNICATION TYPE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #COMMUNICATION_TYPE_VALUE
     * @generated
     * @ordered
     */
    COMMUNICATION_TYPE(0, "COMMUNICATION_TYPE", "COMMUNICATION_TYPE"),

    /**
     * The '<em><b>PROTOCOL</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #PROTOCOL_VALUE
     * @generated
     * @ordered
     */
    PROTOCOL(0, "PROTOCOL", "PROTOCOL"),

    /**
     * The '<em><b>DATA FORMAT</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DATA_FORMAT_VALUE
     * @generated
     * @ordered
     */
    DATA_FORMAT(0, "DATA_FORMAT", "DATA_FORMAT"),

    /**
     * The '<em><b>TECHNOLOGY</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #TECHNOLOGY_VALUE
     * @generated
     * @ordered
     */
    TECHNOLOGY(0, "TECHNOLOGY", "TECHNOLOGY");

    /**
     * The '<em><b>EXCHANGE PATTERN</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #EXCHANGE_PATTERN
     * @model
     * @generated
     * @ordered
     */
    public static final int EXCHANGE_PATTERN_VALUE = 0;

    /**
     * The '<em><b>COMMUNICATION TYPE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #COMMUNICATION_TYPE
     * @model
     * @generated
     * @ordered
     */
    public static final int COMMUNICATION_TYPE_VALUE = 0;

    /**
     * The '<em><b>PROTOCOL</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #PROTOCOL
     * @model
     * @generated
     * @ordered
     */
    public static final int PROTOCOL_VALUE = 0;

    /**
     * The '<em><b>DATA FORMAT</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DATA_FORMAT
     * @model
     * @generated
     * @ordered
     */
    public static final int DATA_FORMAT_VALUE = 0;

    /**
     * The '<em><b>TECHNOLOGY</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #TECHNOLOGY
     * @model
     * @generated
     * @ordered
     */
    public static final int TECHNOLOGY_VALUE = 0;

    /**
     * An array of all the '<em><b>Pointcut Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final PointcutType[] VALUES_ARRAY =
        new PointcutType[] {
            EXCHANGE_PATTERN,
            COMMUNICATION_TYPE,
            PROTOCOL,
            DATA_FORMAT,
            TECHNOLOGY,
        };

    /**
     * A public read-only list of all the '<em><b>Pointcut Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<PointcutType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Pointcut Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static PointcutType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            PointcutType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Pointcut Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static PointcutType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            PointcutType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Pointcut Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static PointcutType get(int value) {
        switch (value) {
            case EXCHANGE_PATTERN_VALUE: return EXCHANGE_PATTERN;
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
    private PointcutType(int value, String name, String literal) {
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
    
} //PointcutType
