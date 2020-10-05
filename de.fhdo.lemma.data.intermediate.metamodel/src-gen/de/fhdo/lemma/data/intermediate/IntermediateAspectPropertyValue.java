/**
 */
package de.fhdo.lemma.data.intermediate;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aspect Property Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Property value
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateAspectPropertyValue#getValue <em>Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateAspectPropertyValue#getProperty <em>Property</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.IntermediateAspectPropertyValue#getAspect <em>Aspect</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateAspectPropertyValue()
 * @model
 * @generated
 */
public interface IntermediateAspectPropertyValue extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateAspectPropertyValue_Value()
	 * @model unique="false"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateAspectPropertyValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' reference.
	 * @see #setProperty(IntermediateAspectProperty)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateAspectPropertyValue_Property()
	 * @model
	 * @generated
	 */
	IntermediateAspectProperty getProperty();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateAspectPropertyValue#getProperty <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' reference.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(IntermediateAspectProperty value);

	/**
	 * Returns the value of the '<em><b>Aspect</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getPropertyValues <em>Property Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspect</em>' container reference.
	 * @see #setAspect(IntermediateImportedAspect)
	 * @see de.fhdo.lemma.data.intermediate.IntermediatePackage#getIntermediateAspectPropertyValue_Aspect()
	 * @see de.fhdo.lemma.data.intermediate.IntermediateImportedAspect#getPropertyValues
	 * @model opposite="propertyValues" transient="false"
	 * @generated
	 */
	IntermediateImportedAspect getAspect();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.data.intermediate.IntermediateAspectPropertyValue#getAspect <em>Aspect</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aspect</em>' container reference.
	 * @see #getAspect()
	 * @generated
	 */
	void setAspect(IntermediateImportedAspect value);

} // IntermediateAspectPropertyValue
