/**
 */
package de.fhdo.lemma.data;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Representation of a list with either a primitive type or several data fields
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.ListType#getPrimitiveType <em>Primitive Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.ListType#getDataFields <em>Data Fields</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.DataPackage#getListType()
 * @model
 * @generated
 */
public interface ListType extends ComplexType {
	/**
	 * Returns the value of the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Implicit Constraints:
	 *     (C1) List has either primitive type assigned or data fields.
	 *          Ensured by: DSL grammar.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Primitive Type</em>' containment reference.
	 * @see #setPrimitiveType(PrimitiveType)
	 * @see de.fhdo.lemma.data.DataPackage#getListType_PrimitiveType()
	 * @model containment="true"
	 * @generated
	 */
	PrimitiveType getPrimitiveType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.ListType#getPrimitiveType <em>Primitive Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive Type</em>' containment reference.
	 * @see #getPrimitiveType()
	 * @generated
	 */
	void setPrimitiveType(PrimitiveType value);

	/**
	 * Returns the value of the '<em><b>Data Fields</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.data.DataField}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.DataField#getListType <em>List Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Fields</em>' containment reference list.
	 * @see de.fhdo.lemma.data.DataPackage#getListType_DataFields()
	 * @see de.fhdo.lemma.data.DataField#getListType
	 * @model opposite="listType" containment="true"
	 * @generated
	 */
	EList<DataField> getDataFields();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Convenience method to compare field counts of two lists
	 * <!-- end-model-doc -->
	 * @model unique="false" listToCompareUnique="false"
	 * @generated
	 */
	int compareFieldCounts(ListType listToCompare);

} // ListType
