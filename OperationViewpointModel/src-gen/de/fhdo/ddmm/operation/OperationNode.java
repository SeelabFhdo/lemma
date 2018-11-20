/**
 */
package de.fhdo.ddmm.operation;

import de.fhdo.ddmm.service.Import;

import de.fhdo.ddmm.technology.OperationEnvironment;
import de.fhdo.ddmm.technology.TechnologySpecificPropertyValueAssignment;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * An operation node is a node to which services may be deployed, e.g., a container or some
 * infrastructure component like a configuration provider
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.operation.OperationNode#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.operation.OperationNode#getTechnologies <em>Technologies</em>}</li>
 *   <li>{@link de.fhdo.ddmm.operation.OperationNode#getOperationEnvironment <em>Operation Environment</em>}</li>
 *   <li>{@link de.fhdo.ddmm.operation.OperationNode#getDeployedServices <em>Deployed Services</em>}</li>
 *   <li>{@link de.fhdo.ddmm.operation.OperationNode#getDefaultServicePropertyValues <em>Default Service Property Values</em>}</li>
 *   <li>{@link de.fhdo.ddmm.operation.OperationNode#getDeploymentSpecifications <em>Deployment Specifications</em>}</li>
 *   <li>{@link de.fhdo.ddmm.operation.OperationNode#getAspects <em>Aspects</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.operation.OperationPackage#getOperationNode()
 * @model abstract="true"
 * @generated
 */
public interface OperationNode extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Mandatory service properties need to have values assigned.
     *          Ensured by: DSL validator.
     *     (C2) Depending on the concrete type of the operation node, service properties must
     *          correspond to those defined in the deployment technology (for containers) or the
     *          infrastructure technology (for infrastructure nodes).
     *          Ensured by: DSL scope provider.
     *     (C3) Services in service deployment specifications must correspond to those being
     *          deployed to the operation node.
     *          Ensured by: DSL scope provider.
     *     (C4) The operation environment must be defined in the assigned deployment technology
     *          (for containers) or infrastructure technology (for infrastructure nodes).
     *          Ensured by: DSL scope provider.
     *     (C5) There might exactly be one deployment specification per service.
     *          Ensured by: DSL validator.
     *     (C6) Deployed services must be unique.
     *          Ensured by: DSL validator.
     *     (C6) Each service property might receive a value once.
     *          Ensured by: DSL validator.
     *     (C7) A technology might be assigned exactly once to an operation node.
     *          Ensured by: DSL validator.
     *     (C8) Assigned technologies may not only define service-specific concepts.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.fhdo.ddmm.operation.OperationPackage#getOperationNode_Name()
     * @model unique="false"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.operation.OperationNode#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Technologies</b></em>' reference list.
     * The list contents are of type {@link de.fhdo.ddmm.service.Import}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Technologies</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Technologies</em>' reference list.
     * @see de.fhdo.ddmm.operation.OperationPackage#getOperationNode_Technologies()
     * @model required="true"
     * @generated
     */
    EList<Import> getTechnologies();

    /**
     * Returns the value of the '<em><b>Operation Environment</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operation Environment</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operation Environment</em>' reference.
     * @see #setOperationEnvironment(OperationEnvironment)
     * @see de.fhdo.ddmm.operation.OperationPackage#getOperationNode_OperationEnvironment()
     * @model
     * @generated
     */
    OperationEnvironment getOperationEnvironment();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.operation.OperationNode#getOperationEnvironment <em>Operation Environment</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operation Environment</em>' reference.
     * @see #getOperationEnvironment()
     * @generated
     */
    void setOperationEnvironment(OperationEnvironment value);

    /**
     * Returns the value of the '<em><b>Deployed Services</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.operation.ImportedMicroservice}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.operation.ImportedMicroservice#getOperationNode <em>Operation Node</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Deployed Services</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Deployed Services</em>' containment reference list.
     * @see de.fhdo.ddmm.operation.OperationPackage#getOperationNode_DeployedServices()
     * @see de.fhdo.ddmm.operation.ImportedMicroservice#getOperationNode
     * @model opposite="operationNode" containment="true" required="true"
     * @generated
     */
    EList<ImportedMicroservice> getDeployedServices();

    /**
     * Returns the value of the '<em><b>Default Service Property Values</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.TechnologySpecificPropertyValueAssignment}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Service Property Values</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Service Property Values</em>' containment reference list.
     * @see de.fhdo.ddmm.operation.OperationPackage#getOperationNode_DefaultServicePropertyValues()
     * @model containment="true"
     * @generated
     */
    EList<TechnologySpecificPropertyValueAssignment> getDefaultServicePropertyValues();

    /**
     * Returns the value of the '<em><b>Deployment Specifications</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.operation.ServiceDeploymentSpecification}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.operation.ServiceDeploymentSpecification#getOperationNode <em>Operation Node</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Deployment Specifications</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Deployment Specifications</em>' containment reference list.
     * @see de.fhdo.ddmm.operation.OperationPackage#getOperationNode_DeploymentSpecifications()
     * @see de.fhdo.ddmm.operation.ServiceDeploymentSpecification#getOperationNode
     * @model opposite="operationNode" containment="true"
     * @generated
     */
    EList<ServiceDeploymentSpecification> getDeploymentSpecifications();

    /**
     * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.operation.ImportedOperationAspect}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.operation.ImportedOperationAspect#getOperationNode <em>Operation Node</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Aspects</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Aspects</em>' containment reference list.
     * @see de.fhdo.ddmm.operation.OperationPackage#getOperationNode_Aspects()
     * @see de.fhdo.ddmm.operation.ImportedOperationAspect#getOperationNode
     * @model opposite="operationNode" containment="true"
     * @generated
     */
    EList<ImportedOperationAspect> getAspects();

} // OperationNode
