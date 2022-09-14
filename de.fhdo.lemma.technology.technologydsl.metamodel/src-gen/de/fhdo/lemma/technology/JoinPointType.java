/**
 */
package de.fhdo.lemma.technology;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Join Point Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * *
 * Types of the possible join points of technology aspects
 * <!-- end-model-doc -->
 * @see de.fhdo.lemma.technology.TechnologyPackage#getJoinPointType()
 * @model
 * @generated
 */
public enum JoinPointType implements Enumerator {
    /**
     * The '<em><b>DATA OPERATIONS</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DATA_OPERATIONS_VALUE
     * @generated
     * @ordered
     */
    DATA_OPERATIONS(0, "DATA_OPERATIONS", "DATA_OPERATIONS"),

    /**
     * The '<em><b>DATA OPERATION PARAMETERS</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DATA_OPERATION_PARAMETERS_VALUE
     * @generated
     * @ordered
     */
    DATA_OPERATION_PARAMETERS(0, "DATA_OPERATION_PARAMETERS", "DATA_OPERATION_PARAMETERS"),

    /**
     * The '<em><b>MICROSERVICES</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MICROSERVICES_VALUE
     * @generated
     * @ordered
     */
    MICROSERVICES(0, "MICROSERVICES", "MICROSERVICES"),

    /**
     * The '<em><b>INTERFACES</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #INTERFACES_VALUE
     * @generated
     * @ordered
     */
    INTERFACES(0, "INTERFACES", "INTERFACES"),

    /**
     * The '<em><b>OPERATIONS</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #OPERATIONS_VALUE
     * @generated
     * @ordered
     */
    OPERATIONS(0, "OPERATIONS", "OPERATIONS"),

    /**
     * The '<em><b>PARAMETERS</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #PARAMETERS_VALUE
     * @generated
     * @ordered
     */
    PARAMETERS(0, "PARAMETERS", "PARAMETERS"),

    /**
     * The '<em><b>COMPLEX TYPES</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #COMPLEX_TYPES_VALUE
     * @generated
     * @ordered
     */
    COMPLEX_TYPES(0, "COMPLEX_TYPES", "COMPLEX_TYPES"),

    /**
     * The '<em><b>DATA FIELDS</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DATA_FIELDS_VALUE
     * @generated
     * @ordered
     */
    DATA_FIELDS(0, "DATA_FIELDS", "DATA_FIELDS"),

    /**
     * The '<em><b>CONTAINERS</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CONTAINERS_VALUE
     * @generated
     * @ordered
     */
    CONTAINERS(0, "CONTAINERS", "CONTAINERS"),

    /**
     * The '<em><b>INFRASTRUCTURE NODES</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #INFRASTRUCTURE_NODES_VALUE
     * @generated
     * @ordered
     */
    INFRASTRUCTURE_NODES(0, "INFRASTRUCTURE_NODES", "INFRASTRUCTURE_NODES");

    /**
     * The '<em><b>DATA OPERATIONS</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DATA_OPERATIONS
     * @model
     * @generated
     * @ordered
     */
    public static final int DATA_OPERATIONS_VALUE = 0;

    /**
     * The '<em><b>DATA OPERATION PARAMETERS</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DATA_OPERATION_PARAMETERS
     * @model
     * @generated
     * @ordered
     */
    public static final int DATA_OPERATION_PARAMETERS_VALUE = 0;

    /**
     * The '<em><b>MICROSERVICES</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MICROSERVICES
     * @model
     * @generated
     * @ordered
     */
    public static final int MICROSERVICES_VALUE = 0;

    /**
     * The '<em><b>INTERFACES</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #INTERFACES
     * @model
     * @generated
     * @ordered
     */
    public static final int INTERFACES_VALUE = 0;

    /**
     * The '<em><b>OPERATIONS</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #OPERATIONS
     * @model
     * @generated
     * @ordered
     */
    public static final int OPERATIONS_VALUE = 0;

    /**
     * The '<em><b>PARAMETERS</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #PARAMETERS
     * @model
     * @generated
     * @ordered
     */
    public static final int PARAMETERS_VALUE = 0;

    /**
     * The '<em><b>COMPLEX TYPES</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #COMPLEX_TYPES
     * @model
     * @generated
     * @ordered
     */
    public static final int COMPLEX_TYPES_VALUE = 0;

    /**
     * The '<em><b>DATA FIELDS</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DATA_FIELDS
     * @model
     * @generated
     * @ordered
     */
    public static final int DATA_FIELDS_VALUE = 0;

    /**
     * The '<em><b>CONTAINERS</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CONTAINERS
     * @model
     * @generated
     * @ordered
     */
    public static final int CONTAINERS_VALUE = 0;

    /**
     * The '<em><b>INFRASTRUCTURE NODES</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #INFRASTRUCTURE_NODES
     * @model
     * @generated
     * @ordered
     */
    public static final int INFRASTRUCTURE_NODES_VALUE = 0;

    /**
     * An array of all the '<em><b>Join Point Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final JoinPointType[] VALUES_ARRAY =
        new JoinPointType[] {
            DATA_OPERATIONS,
            DATA_OPERATION_PARAMETERS,
            MICROSERVICES,
            INTERFACES,
            OPERATIONS,
            PARAMETERS,
            COMPLEX_TYPES,
            DATA_FIELDS,
            CONTAINERS,
            INFRASTRUCTURE_NODES,
        };

    /**
     * A public read-only list of all the '<em><b>Join Point Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<JoinPointType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Join Point Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static JoinPointType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            JoinPointType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Join Point Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static JoinPointType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            JoinPointType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Join Point Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static JoinPointType get(int value) {
        switch (value) {
            case DATA_OPERATIONS_VALUE: return DATA_OPERATIONS;
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
    private JoinPointType(int value, String name, String literal) {
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
    
} //JoinPointType
