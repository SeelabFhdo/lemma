/**
 */
package de.fhdo.ddmm.operation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Infrastructure Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * An infrastructure node is an operation node with supporting character, e.g., a configuration
 * provider
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.operation.InfrastructureNode#getInfrastructureTechnology <em>Infrastructure Technology</em>}</li>
 *   <li>{@link de.fhdo.ddmm.operation.InfrastructureNode#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.ddmm.operation.InfrastructureNode#getOperationModel <em>Operation Model</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.operation.OperationPackage#getInfrastructureNode()
 * @model
 * @generated
 */
public interface InfrastructureNode extends OperationNode {
    /**
     * Returns the value of the '<em><b>Infrastructure Technology</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.operation.InfrastructureTechnologyReference#getInfrastructureNode <em>Infrastructure Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Protocols of endpoints must correspond to those defined in the technology being
     *          assigned to the operation node.
     *          Ensured by: DSL scope provider.
     *     (C2) The infrastructure technology must be one defined in the technology assigned to the
     *          operation node.
     *          Ensured by: DSL scope provider.
     *     (C3) Endpoints must be unique for protocol and data format combination.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Infrastructure Technology</em>' containment reference.
     * @see #setInfrastructureTechnology(InfrastructureTechnologyReference)
     * @see de.fhdo.ddmm.operation.OperationPackage#getInfrastructureNode_InfrastructureTechnology()
     * @see de.fhdo.ddmm.operation.InfrastructureTechnologyReference#getInfrastructureNode
     * @model opposite="infrastructureNode" containment="true"
     * @generated
     */
    InfrastructureTechnologyReference getInfrastructureTechnology();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.operation.InfrastructureNode#getInfrastructureTechnology <em>Infrastructure Technology</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Infrastructure Technology</em>' containment reference.
     * @see #getInfrastructureTechnology()
     * @generated
     */
    void setInfrastructureTechnology(InfrastructureTechnologyReference value);

    /**
     * Returns the value of the '<em><b>Endpoints</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.operation.BasicEndpoint}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.operation.BasicEndpoint#getInfrastructureNode <em>Infrastructure Node</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoints</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Endpoints</em>' containment reference list.
     * @see de.fhdo.ddmm.operation.OperationPackage#getInfrastructureNode_Endpoints()
     * @see de.fhdo.ddmm.operation.BasicEndpoint#getInfrastructureNode
     * @model opposite="infrastructureNode" containment="true"
     * @generated
     */
    EList<BasicEndpoint> getEndpoints();

    /**
     * Returns the value of the '<em><b>Operation Model</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.operation.OperationModel#getInfrastructureNodes <em>Infrastructure Nodes</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operation Model</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operation Model</em>' container reference.
     * @see #setOperationModel(OperationModel)
     * @see de.fhdo.ddmm.operation.OperationPackage#getInfrastructureNode_OperationModel()
     * @see de.fhdo.ddmm.operation.OperationModel#getInfrastructureNodes
     * @model opposite="infrastructureNodes" transient="false"
     * @generated
     */
    OperationModel getOperationModel();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.operation.InfrastructureNode#getOperationModel <em>Operation Model</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operation Model</em>' container reference.
     * @see #getOperationModel()
     * @generated
     */
    void setOperationModel(OperationModel value);

} // InfrastructureNode
