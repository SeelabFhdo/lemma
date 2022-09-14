/**
 */
package de.fhdo.lemma.technology;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Compatibility Direction</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * *
 * Represents the direction of compatibility in a compatibility matrix entry.
 *  * Semantics:
 *     - MAPPING_TO_COMPATIBLE_TYPES: The mapping type of the entry may be converted into instances
 *                                    the compatible types.
 *     - COMPATIBLE_TYPES_TO_MAPPING: The compatible types of the entry may be converted into an
 *                                    instance of the mapping type.
 *     - BIDIRECTONAL: Both conversion directions are possible.
 * <!-- end-model-doc -->
 * @see de.fhdo.lemma.technology.TechnologyPackage#getCompatibilityDirection()
 * @model
 * @generated
 */
public enum CompatibilityDirection implements Enumerator {
    /**
     * The '<em><b>MAPPING TO COMPATIBLE TYPES</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MAPPING_TO_COMPATIBLE_TYPES_VALUE
     * @generated
     * @ordered
     */
    MAPPING_TO_COMPATIBLE_TYPES(0, "MAPPING_TO_COMPATIBLE_TYPES", "MAPPING_TO_COMPATIBLE_TYPES"),

    /**
     * The '<em><b>COMPATIBLE TYPES TO MAPPING</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #COMPATIBLE_TYPES_TO_MAPPING_VALUE
     * @generated
     * @ordered
     */
    COMPATIBLE_TYPES_TO_MAPPING(0, "COMPATIBLE_TYPES_TO_MAPPING", "COMPATIBLE_TYPES_TO_MAPPING"),

    /**
     * The '<em><b>BIDIRECTIONAL</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #BIDIRECTIONAL_VALUE
     * @generated
     * @ordered
     */
    BIDIRECTIONAL(0, "BIDIRECTIONAL", "BIDIRECTIONAL");

    /**
     * The '<em><b>MAPPING TO COMPATIBLE TYPES</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MAPPING_TO_COMPATIBLE_TYPES
     * @model
     * @generated
     * @ordered
     */
    public static final int MAPPING_TO_COMPATIBLE_TYPES_VALUE = 0;

    /**
     * The '<em><b>COMPATIBLE TYPES TO MAPPING</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #COMPATIBLE_TYPES_TO_MAPPING
     * @model
     * @generated
     * @ordered
     */
    public static final int COMPATIBLE_TYPES_TO_MAPPING_VALUE = 0;

    /**
     * The '<em><b>BIDIRECTIONAL</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #BIDIRECTIONAL
     * @model
     * @generated
     * @ordered
     */
    public static final int BIDIRECTIONAL_VALUE = 0;

    /**
     * An array of all the '<em><b>Compatibility Direction</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final CompatibilityDirection[] VALUES_ARRAY =
        new CompatibilityDirection[] {
            MAPPING_TO_COMPATIBLE_TYPES,
            COMPATIBLE_TYPES_TO_MAPPING,
            BIDIRECTIONAL,
        };

    /**
     * A public read-only list of all the '<em><b>Compatibility Direction</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<CompatibilityDirection> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Compatibility Direction</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static CompatibilityDirection get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            CompatibilityDirection result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Compatibility Direction</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static CompatibilityDirection getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            CompatibilityDirection result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Compatibility Direction</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static CompatibilityDirection get(int value) {
        switch (value) {
            case MAPPING_TO_COMPATIBLE_TYPES_VALUE: return MAPPING_TO_COMPATIBLE_TYPES;
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
    private CompatibilityDirection(int value, String name, String literal) {
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
    
} //CompatibilityDirection
