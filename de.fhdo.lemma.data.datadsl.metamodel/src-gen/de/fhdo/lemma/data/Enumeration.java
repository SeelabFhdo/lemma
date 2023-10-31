/**
 */
package de.fhdo.lemma.data;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Represents an enumeration that can have a variety of fields with arbitrary initializing values
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.Enumeration#getFields <em>Fields</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.DataPackage#getEnumeration()
 * @model
 * @generated
 */
public interface Enumeration extends ComplexType {
	/**
	 * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.data.EnumerationField}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.EnumerationField#getEnumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Implicit Constraints:
	 *     (C1) Field names must be unique.
	 *          Ensured by: DSL validator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fields</em>' containment reference list.
	 * @see de.fhdo.lemma.data.DataPackage#getEnumeration_Fields()
	 * @see de.fhdo.lemma.data.EnumerationField#getEnumeration
	 * @model opposite="enumeration" containment="true" required="true"
	 * @generated
	 */
	EList<EnumerationField> getFields();

} // Enumeration
