/**
 */
package de.fhdo.lemma.operation.intermediate;

import de.fhdo.lemma.service.intermediate.IntermediateTechnology;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Endpoint Technology</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * EndpointTechnology
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateEndpointTechnology#getEndpoint <em>Endpoint</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateEndpointTechnology()
 * @model
 * @generated
 */
public interface IntermediateEndpointTechnology extends IntermediateTechnology {
	/**
	 * Returns the value of the '<em><b>Endpoint</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEndpoint#getEndpointTechnology <em>Endpoint Technology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoint</em>' container reference.
	 * @see #setEndpoint(IntermediateOperationEndpoint)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateEndpointTechnology_Endpoint()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationEndpoint#getEndpointTechnology
	 * @model opposite="endpointTechnology" transient="false"
	 * @generated
	 */
	IntermediateOperationEndpoint getEndpoint();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateEndpointTechnology#getEndpoint <em>Endpoint</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endpoint</em>' container reference.
	 * @see #getEndpoint()
	 * @generated
	 */
	void setEndpoint(IntermediateOperationEndpoint value);

} // IntermediateEndpointTechnology
