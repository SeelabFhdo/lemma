/**
 */
package de.fhdo.lemma.service.intermediate;

import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Field Aspects</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Aspects assigned to a data field of a structured parameter
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.intermediate.DataFieldAspects#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.DataFieldAspects#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.DataFieldAspects#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.DataFieldAspects#getParameter <em>Parameter</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getDataFieldAspects()
 * @model
 * @generated
 */
public interface DataFieldAspects extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getDataFieldAspects_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.DataFieldAspects#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualified Name</em>' attribute.
	 * @see #setQualifiedName(String)
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getDataFieldAspects_QualifiedName()
	 * @model unique="false"
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.DataFieldAspects#getQualifiedName <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Name</em>' attribute.
	 * @see #getQualifiedName()
	 * @generated
	 */
	void setQualifiedName(String value);

	/**
	 * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspects</em>' containment reference list.
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getDataFieldAspects_Aspects()
	 * @model containment="true"
	 * @generated
	 */
	EList<IntermediateImportedAspect> getAspects();

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.IntermediateParameter#getFieldAspects <em>Field Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' container reference.
	 * @see #setParameter(IntermediateParameter)
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getDataFieldAspects_Parameter()
	 * @see de.fhdo.lemma.service.intermediate.IntermediateParameter#getFieldAspects
	 * @model opposite="fieldAspects" transient="false"
	 * @generated
	 */
	IntermediateParameter getParameter();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.DataFieldAspects#getParameter <em>Parameter</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' container reference.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(IntermediateParameter value);

} // DataFieldAspects
