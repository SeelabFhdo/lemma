/**
 */
package de.fhdo.lemma.operation.intermediate;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Environment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Intermediate operation environment of an intermediate operation technology, e.g., an image
 * of a deployment container
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment#getEnvironmentName <em>Environment Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment#isDefault <em>Default</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment#getOperationTechnology <em>Operation Technology</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationEnvironment()
 * @model
 * @generated
 */
public interface IntermediateOperationEnvironment extends EObject {
	/**
	 * Returns the value of the '<em><b>Environment Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Environment Name</em>' attribute.
	 * @see #setEnvironmentName(String)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationEnvironment_EnvironmentName()
	 * @model unique="false"
	 * @generated
	 */
	String getEnvironmentName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment#getEnvironmentName <em>Environment Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Environment Name</em>' attribute.
	 * @see #getEnvironmentName()
	 * @generated
	 */
	void setEnvironmentName(String value);

	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(boolean)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationEnvironment_Default()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isDefault();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment#isDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #isDefault()
	 * @generated
	 */
	void setDefault(boolean value);

	/**
	 * Returns the value of the '<em><b>Operation Technology</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology#getEnvironment <em>Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Technology</em>' container reference.
	 * @see #setOperationTechnology(IntermediateOperationTechnology)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationEnvironment_OperationTechnology()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology#getEnvironment
	 * @model opposite="environment" transient="false"
	 * @generated
	 */
	IntermediateOperationTechnology getOperationTechnology();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment#getOperationTechnology <em>Operation Technology</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Technology</em>' container reference.
	 * @see #getOperationTechnology()
	 * @generated
	 */
	void setOperationTechnology(IntermediateOperationTechnology value);

} // IntermediateOperationEnvironment
