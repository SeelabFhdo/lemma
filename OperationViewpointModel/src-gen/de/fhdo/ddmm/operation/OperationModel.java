/**
 */
package de.fhdo.ddmm.operation;

import de.fhdo.ddmm.service.Import;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * This metamodel represents the Operation Modeling Viewpoint, which is used for specifying
 * services' operation.
 *  * @author <a href="mailto:florian.rademacher@fh-dortmund.de">Florian Rademacher</a>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.operation.OperationModel#getImports <em>Imports</em>}</li>
 *   <li>{@link de.fhdo.ddmm.operation.OperationModel#getContainers <em>Containers</em>}</li>
 *   <li>{@link de.fhdo.ddmm.operation.OperationModel#getInfrastructureNodes <em>Infrastructure Nodes</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.operation.OperationPackage#getOperationModel()
 * @model
 * @generated
 */
public interface OperationModel extends EObject {
    /**
     * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.Import}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Model must contain at least one container or infrastructure node.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Imports</em>' containment reference list.
     * @see de.fhdo.ddmm.operation.OperationPackage#getOperationModel_Imports()
     * @model containment="true" required="true"
     * @generated
     */
    EList<Import> getImports();

    /**
     * Returns the value of the '<em><b>Containers</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.operation.Container}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.operation.Container#getOperationModel <em>Operation Model</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Containers</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Containers</em>' containment reference list.
     * @see de.fhdo.ddmm.operation.OperationPackage#getOperationModel_Containers()
     * @see de.fhdo.ddmm.operation.Container#getOperationModel
     * @model opposite="operationModel" containment="true"
     * @generated
     */
    EList<Container> getContainers();

    /**
     * Returns the value of the '<em><b>Infrastructure Nodes</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.operation.InfrastructureNode}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.operation.InfrastructureNode#getOperationModel <em>Operation Model</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Infrastructure Nodes</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Infrastructure Nodes</em>' containment reference list.
     * @see de.fhdo.ddmm.operation.OperationPackage#getOperationModel_InfrastructureNodes()
     * @see de.fhdo.ddmm.operation.InfrastructureNode#getOperationModel
     * @model opposite="operationModel" containment="true"
     * @generated
     */
    EList<InfrastructureNode> getInfrastructureNodes();

} // OperationModel
