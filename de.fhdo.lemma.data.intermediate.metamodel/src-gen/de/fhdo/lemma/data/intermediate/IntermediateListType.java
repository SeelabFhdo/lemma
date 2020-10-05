/**
 */
package de.fhdo.lemma.data.intermediate;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * List type
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateListType#isPrimitiveList <em>Primitive List</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateListType#isStructuredList <em>Structured List</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateListType#getPrimitiveType <em>Primitive Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateListType#getDataFields <em>Data Fields</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateListType()
 * @model
 * @generated
 */
public interface IntermediateListType extends IntermediateComplexType {
	/**
	 * Returns the value of the '<em><b>Primitive List</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive List</em>' attribute.
	 * @see #setPrimitiveList(boolean)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateListType_PrimitiveList()
	 * @model unique="false"
	 * @generated
	 */
	boolean isPrimitiveList();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateListType#isPrimitiveList <em>Primitive List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive List</em>' attribute.
	 * @see #isPrimitiveList()
	 * @generated
	 */
	void setPrimitiveList(boolean value);

	/**
	 * Returns the value of the '<em><b>Structured List</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Structured List</em>' attribute.
	 * @see #setStructuredList(boolean)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateListType_StructuredList()
	 * @model unique="false"
	 * @generated
	 */
	boolean isStructuredList();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateListType#isStructuredList <em>Structured List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Structured List</em>' attribute.
	 * @see #isStructuredList()
	 * @generated
	 */
	void setStructuredList(boolean value);

	/**
	 * Returns the value of the '<em><b>Primitive Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive Type</em>' containment reference.
	 * @see #setPrimitiveType(IntermediatePrimitiveType)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateListType_PrimitiveType()
	 * @model containment="true"
	 * @generated
	 */
	IntermediatePrimitiveType getPrimitiveType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateListType#getPrimitiveType <em>Primitive Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive Type</em>' containment reference.
	 * @see #getPrimitiveType()
	 * @generated
	 */
	void setPrimitiveType(IntermediatePrimitiveType value);

	/**
	 * Returns the value of the '<em><b>Data Fields</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateDataField}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateDataField#getListType <em>List Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Fields</em>' containment reference list.
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateListType_DataFields()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateDataField#getListType
	 * @model opposite="listType" containment="true"
	 * @generated
	 */
	EList<IntermediateDataField> getDataFields();

} // IntermediateListType
