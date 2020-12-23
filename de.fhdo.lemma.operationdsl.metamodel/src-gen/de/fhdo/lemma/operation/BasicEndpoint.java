/**
 */
package de.fhdo.lemma.operation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Default and service-specific basic endpoints
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.BasicEndpoint#getAddresses <em>Addresses</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.BasicEndpoint#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.BasicEndpoint#getContainer <em>Container</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.BasicEndpoint#getInfrastructureNode <em>Infrastructure Node</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.BasicEndpoint#getDeploymentSpecification <em>Deployment Specification</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.OperationPackage#getBasicEndpoint()
 * @model
 * @generated
 */
public interface BasicEndpoint extends EObject {
	/**
	 * Returns the value of the '<em><b>Addresses</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Implicit Constraints:
	 *     (C1) Addresses must be unique.
	 *          Ensured by: DSL validator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Addresses</em>' attribute list.
	 * @see de.fhdo.lemma.operation.OperationPackage#getBasicEndpoint_Addresses()
	 * @model unique="false" required="true"
	 * @generated
	 */
	EList<String> getAddresses();

	/**
	 * Returns the value of the '<em><b>Protocols</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.operation.ProtocolAndDataFormat}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.ProtocolAndDataFormat#getEndpoint <em>Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocols</em>' containment reference list.
	 * @see de.fhdo.lemma.operation.OperationPackage#getBasicEndpoint_Protocols()
	 * @see de.fhdo.lemma.operation.ProtocolAndDataFormat#getEndpoint
	 * @model opposite="endpoint" containment="true" required="true"
	 * @generated
	 */
	EList<ProtocolAndDataFormat> getProtocols();

	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.Container#getDefaultBasicEndpoints <em>Default Basic Endpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(Container)
	 * @see de.fhdo.lemma.operation.OperationPackage#getBasicEndpoint_Container()
	 * @see de.fhdo.lemma.operation.Container#getDefaultBasicEndpoints
	 * @model opposite="defaultBasicEndpoints" transient="false"
	 * @generated
	 */
	Container getContainer();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.BasicEndpoint#getContainer <em>Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(Container value);

	/**
	 * Returns the value of the '<em><b>Infrastructure Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.InfrastructureNode#getEndpoints <em>Endpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Infrastructure Node</em>' container reference.
	 * @see #setInfrastructureNode(InfrastructureNode)
	 * @see de.fhdo.lemma.operation.OperationPackage#getBasicEndpoint_InfrastructureNode()
	 * @see de.fhdo.lemma.operation.InfrastructureNode#getEndpoints
	 * @model opposite="endpoints" transient="false"
	 * @generated
	 */
	InfrastructureNode getInfrastructureNode();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.BasicEndpoint#getInfrastructureNode <em>Infrastructure Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Infrastructure Node</em>' container reference.
	 * @see #getInfrastructureNode()
	 * @generated
	 */
	void setInfrastructureNode(InfrastructureNode value);

	/**
	 * Returns the value of the '<em><b>Deployment Specification</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.ServiceDeploymentSpecification#getBasicEndpoints <em>Basic Endpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deployment Specification</em>' container reference.
	 * @see #setDeploymentSpecification(ServiceDeploymentSpecification)
	 * @see de.fhdo.lemma.operation.OperationPackage#getBasicEndpoint_DeploymentSpecification()
	 * @see de.fhdo.lemma.operation.ServiceDeploymentSpecification#getBasicEndpoints
	 * @model opposite="basicEndpoints" transient="false"
	 * @generated
	 */
	ServiceDeploymentSpecification getDeploymentSpecification();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.BasicEndpoint#getDeploymentSpecification <em>Deployment Specification</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deployment Specification</em>' container reference.
	 * @see #getDeploymentSpecification()
	 * @generated
	 */
	void setDeploymentSpecification(ServiceDeploymentSpecification value);

} // BasicEndpoint
