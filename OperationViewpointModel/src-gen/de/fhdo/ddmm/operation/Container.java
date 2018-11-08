/**
 */
package de.fhdo.ddmm.operation;

import de.fhdo.ddmm.technology.DeploymentTechnology;

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
 *   <li>{@link de.fhdo.ddmm.operation.Container#getDeploymentTechnology <em>Deployment Technology</em>}</li>
 *   <li>{@link de.fhdo.ddmm.operation.Container#getDefaultBasicEndpoints <em>Default Basic Endpoints</em>}</li>
 *   <li>{@link de.fhdo.ddmm.operation.Container#getOperationModel <em>Operation Model</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.operation.OperationPackage#getContainer()
 * @model
 * @generated
 */
public interface Container extends OperationNode {
    /**
     * Returns the value of the '<em><b>Deployment Technology</b></em>' reference.
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
     * @return the value of the '<em>Deployment Technology</em>' reference.
     * @see #setDeploymentTechnology(DeploymentTechnology)
     * @see de.fhdo.ddmm.operation.OperationPackage#getContainer_DeploymentTechnology()
     * @model
     * @generated
     */
    DeploymentTechnology getDeploymentTechnology();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.operation.Container#getDeploymentTechnology <em>Deployment Technology</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Deployment Technology</em>' reference.
     * @see #getDeploymentTechnology()
     * @generated
     */
    void setDeploymentTechnology(DeploymentTechnology value);

    /**
     * Returns the value of the '<em><b>Default Basic Endpoints</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.operation.BasicEndpoint}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.operation.BasicEndpoint#getContainer <em>Container</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Basic Endpoints</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Basic Endpoints</em>' containment reference list.
     * @see de.fhdo.ddmm.operation.OperationPackage#getContainer_DefaultBasicEndpoints()
     * @see de.fhdo.ddmm.operation.BasicEndpoint#getContainer
     * @model opposite="container" containment="true"
     * @generated
     */
    EList<BasicEndpoint> getDefaultBasicEndpoints();

    /**
     * Returns the value of the '<em><b>Operation Model</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.operation.OperationModel#getContainers <em>Containers</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operation Model</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operation Model</em>' container reference.
     * @see #setOperationModel(OperationModel)
     * @see de.fhdo.ddmm.operation.OperationPackage#getContainer_OperationModel()
     * @see de.fhdo.ddmm.operation.OperationModel#getContainers
     * @model opposite="containers" transient="false"
     * @generated
     */
    OperationModel getOperationModel();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.operation.Container#getOperationModel <em>Operation Model</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operation Model</em>' container reference.
     * @see #getOperationModel()
     * @generated
     */
    void setOperationModel(OperationModel value);

} // Container
