/**
 */
package de.fhdo.lemma.data;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Represents a field in an enumeration
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.EnumerationField#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.EnumerationField#getInitializationValue <em>Initialization Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.EnumerationField#getEnumeration <em>Enumeration</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.DataPackage#getEnumerationField()
 * @model
 * @generated
 */
public interface EnumerationField extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fhdo.lemma.data.DataPackage#getEnumerationField_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.EnumerationField#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Initialization Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialization Value</em>' containment reference.
	 * @see #setInitializationValue(PrimitiveValue)
	 * @see de.fhdo.lemma.data.DataPackage#getEnumerationField_InitializationValue()
	 * @model containment="true"
	 * @generated
	 */
	PrimitiveValue getInitializationValue();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.EnumerationField#getInitializationValue <em>Initialization Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialization Value</em>' containment reference.
	 * @see #getInitializationValue()
	 * @generated
	 */
	void setInitializationValue(PrimitiveValue value);

	/**
	 * Returns the value of the '<em><b>Enumeration</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.Enumeration#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumeration</em>' container reference.
	 * @see #setEnumeration(Enumeration)
	 * @see de.fhdo.lemma.data.DataPackage#getEnumerationField_Enumeration()
	 * @see de.fhdo.lemma.data.Enumeration#getFields
	 * @model opposite="fields" transient="false"
	 * @generated
	 */
	Enumeration getEnumeration();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.EnumerationField#getEnumeration <em>Enumeration</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enumeration</em>' container reference.
	 * @see #getEnumeration()
	 * @generated
	 */
	void setEnumeration(Enumeration value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get parts of the enumeration field for creating a qualified name
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EList<String> getQualifiedNameParts();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Build qualified name from qualified name parts
	 * <!-- end-model-doc -->
	 * @model unique="false" separatorUnique="false"
	 * @generated
	 */
	String buildQualifiedName(String separator);

} // EnumerationField
