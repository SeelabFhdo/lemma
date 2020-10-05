/**
 */
package de.fhdo.lemma.data;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Represents built-in primitive types that correspond to Java's primitive types in syntax,
 * semantics, naming and size. Strings and dates, however, are also treated as primitive types.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.PrimitiveType#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.PrimitiveType#getTypeSize <em>Type Size</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.DataPackage#getPrimitiveType()
 * @model abstract="true"
 * @generated
 */
public interface PrimitiveType extends Type {
	/**
	 * Returns the value of the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get printable name of PrimitiveType instance
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type Name</em>' attribute.
	 * @see de.fhdo.lemma.data.DataPackage#getPrimitiveType_TypeName()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getTypeName();

	/**
	 * Returns the value of the '<em><b>Type Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get size of built-in primitive type
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type Size</em>' attribute.
	 * @see de.fhdo.lemma.data.DataPackage#getPrimitiveType_TypeSize()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Integer getTypeSize();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Compare the size of two built-in primitive types, following the semantics of Java's
	 * Comparator.compare() method
	 * <!-- end-model-doc -->
	 * @model unique="false" typeToCompareUnique="false"
	 * @generated
	 */
	int sizeCompare(PrimitiveType typeToCompare);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Check if type is compatible with another built-in primitive type
	 * <!-- end-model-doc -->
	 * @model unique="false" typeToCheckUnique="false"
	 * @generated
	 */
	boolean isCompatibleWith(PrimitiveType typeToCheck);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Convenience operation for retrieving all concrete built-in primitive types' meta-classes
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EList<Class<?>> getBuiltinPrimitiveTypes();

} // PrimitiveType
