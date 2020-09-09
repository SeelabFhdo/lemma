/**
 */
package de.fhdo.lemma.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Complex Type Feature</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * *
 * Possible features for a complex type. Remember to adapt ComplexType.getAllDomainFeatures() if a
 * new domain-driven-design-related feature is added.
 * <!-- end-model-doc -->
 * @see de.fhdo.lemma.data.DataPackage#getComplexTypeFeature()
 * @model
 * @generated
 */
public enum ComplexTypeFeature implements Enumerator {
    /**
     * The '<em><b>AGGREGATE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #AGGREGATE_VALUE
     * @generated
     * @ordered
     */
    AGGREGATE(0, "AGGREGATE", "AGGREGATE"),

    /**
     * The '<em><b>APPLICATION SERVICE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #APPLICATION_SERVICE_VALUE
     * @generated
     * @ordered
     */
    APPLICATION_SERVICE(0, "APPLICATION_SERVICE", "APPLICATION_SERVICE"),

    /**
     * The '<em><b>DOMAIN EVENT</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DOMAIN_EVENT_VALUE
     * @generated
     * @ordered
     */
    DOMAIN_EVENT(0, "DOMAIN_EVENT", "DOMAIN_EVENT"),

    /**
     * The '<em><b>DOMAIN SERVICE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DOMAIN_SERVICE_VALUE
     * @generated
     * @ordered
     */
    DOMAIN_SERVICE(0, "DOMAIN_SERVICE", "DOMAIN_SERVICE"),

    /**
     * The '<em><b>ENTITY</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ENTITY_VALUE
     * @generated
     * @ordered
     */
    ENTITY(0, "ENTITY", "ENTITY"),

    /**
     * The '<em><b>FACTORY</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #FACTORY_VALUE
     * @generated
     * @ordered
     */
    FACTORY(0, "FACTORY", "FACTORY"),

    /**
     * The '<em><b>INFRASTRUCTURE SERVICE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #INFRASTRUCTURE_SERVICE_VALUE
     * @generated
     * @ordered
     */
    INFRASTRUCTURE_SERVICE(0, "INFRASTRUCTURE_SERVICE", "INFRASTRUCTURE_SERVICE"),

    /**
     * The '<em><b>REPOSITORY</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #REPOSITORY_VALUE
     * @generated
     * @ordered
     */
    REPOSITORY(0, "REPOSITORY", "REPOSITORY"),

    /**
     * The '<em><b>SERVICE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #SERVICE_VALUE
     * @generated
     * @ordered
     */
    SERVICE(0, "SERVICE", "SERVICE"),

    /**
     * The '<em><b>SPECIFICATION</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #SPECIFICATION_VALUE
     * @generated
     * @ordered
     */
    SPECIFICATION(0, "SPECIFICATION", "SPECIFICATION"),

    /**
     * The '<em><b>VALUE OBJECT</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #VALUE_OBJECT_VALUE
     * @generated
     * @ordered
     */
    VALUE_OBJECT(0, "VALUE_OBJECT", "VALUE_OBJECT");

    /**
     * The '<em><b>AGGREGATE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #AGGREGATE
     * @model
     * @generated
     * @ordered
     */
    public static final int AGGREGATE_VALUE = 0;

    /**
     * The '<em><b>APPLICATION SERVICE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #APPLICATION_SERVICE
     * @model
     * @generated
     * @ordered
     */
    public static final int APPLICATION_SERVICE_VALUE = 0;

    /**
     * The '<em><b>DOMAIN EVENT</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DOMAIN_EVENT
     * @model
     * @generated
     * @ordered
     */
    public static final int DOMAIN_EVENT_VALUE = 0;

    /**
     * The '<em><b>DOMAIN SERVICE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #DOMAIN_SERVICE
     * @model
     * @generated
     * @ordered
     */
    public static final int DOMAIN_SERVICE_VALUE = 0;

    /**
     * The '<em><b>ENTITY</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ENTITY
     * @model
     * @generated
     * @ordered
     */
    public static final int ENTITY_VALUE = 0;

    /**
     * The '<em><b>FACTORY</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #FACTORY
     * @model
     * @generated
     * @ordered
     */
    public static final int FACTORY_VALUE = 0;

    /**
     * The '<em><b>INFRASTRUCTURE SERVICE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #INFRASTRUCTURE_SERVICE
     * @model
     * @generated
     * @ordered
     */
    public static final int INFRASTRUCTURE_SERVICE_VALUE = 0;

    /**
     * The '<em><b>REPOSITORY</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #REPOSITORY
     * @model
     * @generated
     * @ordered
     */
    public static final int REPOSITORY_VALUE = 0;

    /**
     * The '<em><b>SERVICE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #SERVICE
     * @model
     * @generated
     * @ordered
     */
    public static final int SERVICE_VALUE = 0;

    /**
     * The '<em><b>SPECIFICATION</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #SPECIFICATION
     * @model
     * @generated
     * @ordered
     */
    public static final int SPECIFICATION_VALUE = 0;

    /**
     * The '<em><b>VALUE OBJECT</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #VALUE_OBJECT
     * @model
     * @generated
     * @ordered
     */
    public static final int VALUE_OBJECT_VALUE = 0;

    /**
     * An array of all the '<em><b>Complex Type Feature</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final ComplexTypeFeature[] VALUES_ARRAY =
        new ComplexTypeFeature[] {
            AGGREGATE,
            APPLICATION_SERVICE,
            DOMAIN_EVENT,
            DOMAIN_SERVICE,
            ENTITY,
            FACTORY,
            INFRASTRUCTURE_SERVICE,
            REPOSITORY,
            SERVICE,
            SPECIFICATION,
            VALUE_OBJECT,
        };

    /**
     * A public read-only list of all the '<em><b>Complex Type Feature</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<ComplexTypeFeature> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Complex Type Feature</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static ComplexTypeFeature get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ComplexTypeFeature result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Complex Type Feature</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static ComplexTypeFeature getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            ComplexTypeFeature result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Complex Type Feature</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static ComplexTypeFeature get(int value) {
        switch (value) {
            case AGGREGATE_VALUE: return AGGREGATE;
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
    private ComplexTypeFeature(int value, String name, String literal) {
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
    
} //ComplexTypeFeature
