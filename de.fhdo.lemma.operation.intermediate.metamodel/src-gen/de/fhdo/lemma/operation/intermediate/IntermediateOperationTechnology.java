/**
 */
package de.fhdo.lemma.operation.intermediate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Technology</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Abstract superclass of technologies specific to intermediate service operation
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology#getEnvironment <em>Environment</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationTechnology()
 * @model abstract="true"
 * @generated
 */
public interface IntermediateOperationTechnology extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationTechnology_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Environment</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment#getOperationTechnology <em>Operation Technology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Environment</em>' containment reference.
	 * @see #setEnvironment(IntermediateOperationEnvironment)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationTechnology_Environment()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment#getOperationTechnology
	 * @model opposite="operationTechnology" containment="true"
	 * @generated
	 */
	IntermediateOperationEnvironment getEnvironment();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology#getEnvironment <em>Environment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Environment</em>' containment reference.
	 * @see #getEnvironment()
	 * @generated
	 */
	void setEnvironment(IntermediateOperationEnvironment value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getOperationTechnology <em>Operation Technology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationTechnology_Properties()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty#getOperationTechnology
	 * @model opposite="operationTechnology" containment="true"
	 * @generated
	 */
	EList<IntermediateTechnologySpecificProperty> getProperties();

} // IntermediateOperationTechnology
