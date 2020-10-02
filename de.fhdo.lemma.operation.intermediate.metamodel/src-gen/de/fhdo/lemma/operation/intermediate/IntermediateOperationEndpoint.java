/**
 */
package de.fhdo.lemma.operation.intermediate;

import de.fhdo.lemma.service.intermediate.IntermediateEndpoint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * OperationEndpoint
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEndpoint#getEndpointTechnology <em>Endpoint Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEndpoint#getNode <em>Node</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationEndpoint()
 * @model
 * @generated
 */
public interface IntermediateOperationEndpoint extends IntermediateEndpoint {
	/**
	 * Returns the value of the '<em><b>Endpoint Technology</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateEndpointTechnology#getEndpoint <em>Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoint Technology</em>' containment reference.
	 * @see #setEndpointTechnology(IntermediateEndpointTechnology)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationEndpoint_EndpointTechnology()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateEndpointTechnology#getEndpoint
	 * @model opposite="endpoint" containment="true"
	 * @generated
	 */
	IntermediateEndpointTechnology getEndpointTechnology();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEndpoint#getEndpointTechnology <em>Endpoint Technology</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endpoint Technology</em>' containment reference.
	 * @see #getEndpointTechnology()
	 * @generated
	 */
	void setEndpointTechnology(IntermediateEndpointTechnology value);

	/**
	 * Returns the value of the '<em><b>Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getEndpoints <em>Endpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' container reference.
	 * @see #setNode(IntermediateOperationNode)
	 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getIntermediateOperationEndpoint_Node()
	 * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getEndpoints
	 * @model opposite="endpoints" transient="false"
	 * @generated
	 */
	IntermediateOperationNode getNode();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationEndpoint#getNode <em>Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' container reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(IntermediateOperationNode value);

} // IntermediateOperationEndpoint
