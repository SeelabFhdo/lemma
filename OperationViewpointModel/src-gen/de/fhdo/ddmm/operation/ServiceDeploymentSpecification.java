/**
 */
package de.fhdo.ddmm.operation;

import de.fhdo.ddmm.service.Import;

import de.fhdo.ddmm.technology.TechnologySpecificPropertyValueAssignment;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Deployment Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Represents the further specification of a service being deployed to an operation node
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.operation.ServiceDeploymentSpecification#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.ddmm.operation.ServiceDeploymentSpecification#getService <em>Service</em>}</li>
 *   <li>{@link de.fhdo.ddmm.operation.ServiceDeploymentSpecification#getServicePropertyValues <em>Service Property Values</em>}</li>
 *   <li>{@link de.fhdo.ddmm.operation.ServiceDeploymentSpecification#getBasicEndpoints <em>Basic Endpoints</em>}</li>
 *   <li>{@link de.fhdo.ddmm.operation.ServiceDeploymentSpecification#getOperationNode <em>Operation Node</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.operation.OperationPackage#getServiceDeploymentSpecification()
 * @model
 * @generated
 */
public interface ServiceDeploymentSpecification extends EObject {
    /**
     * Returns the value of the '<em><b>Import</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * *
     * Implicit Constraints:
     *     (C1) Each service property might receive a value once.
     *          Ensured by: DSL validator.
     *     (C2) Endpoints must be unique for protocol and data format combination.
     *          Ensured by: DSL validator.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Import</em>' reference.
     * @see #setImport(Import)
     * @see de.fhdo.ddmm.operation.OperationPackage#getServiceDeploymentSpecification_Import()
     * @model
     * @generated
     */
    Import getImport();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.operation.ServiceDeploymentSpecification#getImport <em>Import</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Import</em>' reference.
     * @see #getImport()
     * @generated
     */
    void setImport(Import value);

    /**
     * Returns the value of the '<em><b>Service</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Service</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Service</em>' reference.
     * @see #setService(ImportedMicroservice)
     * @see de.fhdo.ddmm.operation.OperationPackage#getServiceDeploymentSpecification_Service()
     * @model
     * @generated
     */
    ImportedMicroservice getService();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.operation.ServiceDeploymentSpecification#getService <em>Service</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Service</em>' reference.
     * @see #getService()
     * @generated
     */
    void setService(ImportedMicroservice value);

    /**
     * Returns the value of the '<em><b>Service Property Values</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.technology.TechnologySpecificPropertyValueAssignment}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Service Property Values</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Service Property Values</em>' containment reference list.
     * @see de.fhdo.ddmm.operation.OperationPackage#getServiceDeploymentSpecification_ServicePropertyValues()
     * @model containment="true"
     * @generated
     */
    EList<TechnologySpecificPropertyValueAssignment> getServicePropertyValues();

    /**
     * Returns the value of the '<em><b>Basic Endpoints</b></em>' containment reference list.
     * The list contents are of type {@link de.fhdo.ddmm.operation.BasicEndpoint}.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.operation.BasicEndpoint#getDeploymentSpecification <em>Deployment Specification</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Basic Endpoints</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Basic Endpoints</em>' containment reference list.
     * @see de.fhdo.ddmm.operation.OperationPackage#getServiceDeploymentSpecification_BasicEndpoints()
     * @see de.fhdo.ddmm.operation.BasicEndpoint#getDeploymentSpecification
     * @model opposite="deploymentSpecification" containment="true"
     * @generated
     */
    EList<BasicEndpoint> getBasicEndpoints();

    /**
     * Returns the value of the '<em><b>Operation Node</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.operation.OperationNode#getDeploymentSpecifications <em>Deployment Specifications</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operation Node</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operation Node</em>' container reference.
     * @see #setOperationNode(OperationNode)
     * @see de.fhdo.ddmm.operation.OperationPackage#getServiceDeploymentSpecification_OperationNode()
     * @see de.fhdo.ddmm.operation.OperationNode#getDeploymentSpecifications
     * @model opposite="deploymentSpecifications" transient="false"
     * @generated
     */
    OperationNode getOperationNode();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.operation.ServiceDeploymentSpecification#getOperationNode <em>Operation Node</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operation Node</em>' container reference.
     * @see #getOperationNode()
     * @generated
     */
    void setOperationNode(OperationNode value);

} // ServiceDeploymentSpecification
