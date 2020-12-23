/**
 */
package de.fhdo.lemma.operation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * A container is the central operation node. It enables service deployment and operation.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.Container#getDeploymentTechnology <em>Deployment Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.Container#getDefaultBasicEndpoints <em>Default Basic Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.Container#getOperationModel <em>Operation Model</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.OperationPackage#getContainer()
 * @model
 * @generated
 */
public interface Container extends OperationNode {
	/**
	 * Returns the value of the '<em><b>Deployment Technology</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.DeploymentTechnologyReference#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Implicit Constraints:
	 *     (C1) Protocols of basic endpoints must correspond to those defined in the technology
	 *          being assigned to the operation node.
	 *          Ensured by: DSL scope provider.
	 *     (C2) The deployment technology must be one defined in the technology assigned to the
	 *          operation node.
	 *          Ensured by: DSL scope provider.
	 *     (C3) Endpoints must be unique for protocol and data format combination.
	 *          Ensured by: DSL validator.
	 *     (C4) Each deployed service needs to have a basic endpoint assigned, either via a default
	 *          endpoint or a service-specific endpoint, for each protocol/data format combination
	 *          in the technology being assigned to the operation node.
	 *          Ensured by: DSL validator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Deployment Technology</em>' containment reference.
	 * @see #setDeploymentTechnology(DeploymentTechnologyReference)
	 * @see de.fhdo.lemma.operation.OperationPackage#getContainer_DeploymentTechnology()
	 * @see de.fhdo.lemma.operation.DeploymentTechnologyReference#getContainer
	 * @model opposite="container" containment="true"
	 * @generated
	 */
	DeploymentTechnologyReference getDeploymentTechnology();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.Container#getDeploymentTechnology <em>Deployment Technology</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deployment Technology</em>' containment reference.
	 * @see #getDeploymentTechnology()
	 * @generated
	 */
	void setDeploymentTechnology(DeploymentTechnologyReference value);

	/**
	 * Returns the value of the '<em><b>Default Basic Endpoints</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.operation.BasicEndpoint}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.BasicEndpoint#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Basic Endpoints</em>' containment reference list.
	 * @see de.fhdo.lemma.operation.OperationPackage#getContainer_DefaultBasicEndpoints()
	 * @see de.fhdo.lemma.operation.BasicEndpoint#getContainer
	 * @model opposite="container" containment="true"
	 * @generated
	 */
	EList<BasicEndpoint> getDefaultBasicEndpoints();

	/**
	 * Returns the value of the '<em><b>Operation Model</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.OperationModel#getContainers <em>Containers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Model</em>' container reference.
	 * @see #setOperationModel(OperationModel)
	 * @see de.fhdo.lemma.operation.OperationPackage#getContainer_OperationModel()
	 * @see de.fhdo.lemma.operation.OperationModel#getContainers
	 * @model opposite="containers" transient="false"
	 * @generated
	 */
	OperationModel getOperationModel();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.Container#getOperationModel <em>Operation Model</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Model</em>' container reference.
	 * @see #getOperationModel()
	 * @generated
	 */
	void setOperationModel(OperationModel value);

} // Container
