/**
 */
package de.fhdo.lemma.data.intermediate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aspect Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Aspect property
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateAspectProperty#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateAspectProperty#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateAspectProperty#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateAspectProperty#getFeatureNames <em>Feature Names</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateAspectProperty#getAspect <em>Aspect</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateAspectProperty()
 * @model
 * @generated
 */
public interface IntermediateAspectProperty extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateAspectProperty_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateAspectProperty#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateAspectProperty_Type()
	 * @model unique="false"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateAspectProperty#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' attribute.
	 * @see #setDefaultValue(String)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateAspectProperty_DefaultValue()
	 * @model unique="false"
	 * @generated
	 */
	String getDefaultValue();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateAspectProperty#getDefaultValue <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' attribute.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(String value);

	/**
	 * Returns the value of the '<em><b>Feature Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Names</em>' attribute list.
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateAspectProperty_FeatureNames()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getFeatureNames();

	/**
	 * Returns the value of the '<em><b>Aspect</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspect</em>' container reference.
	 * @see #setAspect(IntermediateImportedAspect)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateAspectProperty_Aspect()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getProperties
	 * @model opposite="properties" transient="false"
	 * @generated
	 */
	IntermediateImportedAspect getAspect();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateAspectProperty#getAspect <em>Aspect</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aspect</em>' container reference.
	 * @see #getAspect()
	 * @generated
	 */
	void setAspect(IntermediateImportedAspect value);

} // IntermediateAspectProperty
