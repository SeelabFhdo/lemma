/**
 */
package de.fhdo.lemma.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Import Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * *
 * Determines the allowed types of imports
 * <!-- end-model-doc -->
 * @see de.fhdo.lemma.service.ServicePackage#getImportType()
 * @model
 * @generated
 */
public enum ImportType implements Enumerator {
	/**
	 * The '<em><b>DATATYPES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATATYPES_VALUE
	 * @generated
	 * @ordered
	 */
	DATATYPES(0, "DATATYPES", "DATATYPES"),

	/**
	 * The '<em><b>TECHNOLOGY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TECHNOLOGY_VALUE
	 * @generated
	 * @ordered
	 */
	TECHNOLOGY(0, "TECHNOLOGY", "TECHNOLOGY"),

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
	 * The '<em><b>OPERATION NODES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPERATION_NODES_VALUE
	 * @generated
	 * @ordered
	 */
	OPERATION_NODES(0, "OPERATION_NODES", "OPERATION_NODES");

	/**
	 * The '<em><b>DATATYPES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATATYPES
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DATATYPES_VALUE = 0;

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
	 * The '<em><b>OPERATION NODES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPERATION_NODES
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OPERATION_NODES_VALUE = 0;

	/**
	 * An array of all the '<em><b>Import Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ImportType[] VALUES_ARRAY =
		new ImportType[] {
			DATATYPES,
			TECHNOLOGY,
			MICROSERVICES,
			OPERATION_NODES,
		};

	/**
	 * A public read-only list of all the '<em><b>Import Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ImportType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Import Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ImportType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ImportType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Import Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ImportType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ImportType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Import Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ImportType get(int value) {
		switch (value) {
			case DATATYPES_VALUE: return DATATYPES;
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
	private ImportType(int value, String name, String literal) {
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
	
} //ImportType
