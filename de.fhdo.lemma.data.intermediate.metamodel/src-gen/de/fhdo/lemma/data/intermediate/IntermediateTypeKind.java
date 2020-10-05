/**
 */
package de.fhdo.lemma.data.intermediate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Type Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * *
 * Data type kind
 * <!-- end-model-doc -->
 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateTypeKind()
 * @model
 * @generated
 */
public enum IntermediateTypeKind implements Enumerator {
	/**
	 * The '<em><b>DUMMY FOR XMI SERIALIZER BUG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DUMMY_FOR_XMI_SERIALIZER_BUG_VALUE
	 * @generated
	 * @ordered
	 */
	DUMMY_FOR_XMI_SERIALIZER_BUG(0, "DUMMY_FOR_XMI_SERIALIZER_BUG", "DUMMY_FOR_XMI_SERIALIZER_BUG"),

	/**
	 * The '<em><b>ENUMERATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENUMERATION_VALUE
	 * @generated
	 * @ordered
	 */
	ENUMERATION(0, "ENUMERATION", "ENUMERATION"),

	/**
	 * The '<em><b>LIST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIST_VALUE
	 * @generated
	 * @ordered
	 */
	LIST(0, "LIST", "LIST"),

	/**
	 * The '<em><b>PRIMITIVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRIMITIVE_VALUE
	 * @generated
	 * @ordered
	 */
	PRIMITIVE(0, "PRIMITIVE", "PRIMITIVE"),

	/**
	 * The '<em><b>STRUCTURE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRUCTURE_VALUE
	 * @generated
	 * @ordered
	 */
	STRUCTURE(0, "STRUCTURE", "STRUCTURE");

	/**
	 * The '<em><b>DUMMY FOR XMI SERIALIZER BUG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DUMMY_FOR_XMI_SERIALIZER_BUG
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DUMMY_FOR_XMI_SERIALIZER_BUG_VALUE = 0;

	/**
	 * The '<em><b>ENUMERATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENUMERATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ENUMERATION_VALUE = 0;

	/**
	 * The '<em><b>LIST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LIST_VALUE = 0;

	/**
	 * The '<em><b>PRIMITIVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRIMITIVE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRIMITIVE_VALUE = 0;

	/**
	 * The '<em><b>STRUCTURE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRUCTURE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STRUCTURE_VALUE = 0;

	/**
	 * An array of all the '<em><b>Type Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IntermediateTypeKind[] VALUES_ARRAY =
		new IntermediateTypeKind[] {
			DUMMY_FOR_XMI_SERIALIZER_BUG,
			ENUMERATION,
			LIST,
			PRIMITIVE,
			STRUCTURE,
		};

	/**
	 * A public read-only list of all the '<em><b>Type Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IntermediateTypeKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Type Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IntermediateTypeKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IntermediateTypeKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IntermediateTypeKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IntermediateTypeKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IntermediateTypeKind get(int value) {
		switch (value) {
			case DUMMY_FOR_XMI_SERIALIZER_BUG_VALUE: return DUMMY_FOR_XMI_SERIALIZER_BUG;
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
	private IntermediateTypeKind(int value, String name, String literal) {
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
	
} //IntermediateTypeKind
