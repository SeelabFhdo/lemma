/**
 */
package de.fhdo.ddmm.operation;

import de.fhdo.ddmm.service.Import;

import de.fhdo.ddmm.technology.DeploymentTechnology;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deployment Technology Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Reference to a deployment technology
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.operation.DeploymentTechnologyReference#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.ddmm.operation.DeploymentTechnologyReference#getDeploymentTechnology <em>Deployment Technology</em>}</li>
 *   <li>{@link de.fhdo.ddmm.operation.DeploymentTechnologyReference#getContainer <em>Container</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.operation.OperationPackage#getDeploymentTechnologyReference()
 * @model
 * @generated
 */
public interface DeploymentTechnologyReference extends EObject {
    /**
     * Returns the value of the '<em><b>Import</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Import</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Import</em>' reference.
     * @see #setImport(Import)
     * @see de.fhdo.ddmm.operation.OperationPackage#getDeploymentTechnologyReference_Import()
     * @model
     * @generated
     */
    Import getImport();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.operation.DeploymentTechnologyReference#getImport <em>Import</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Import</em>' reference.
     * @see #getImport()
     * @generated
     */
    void setImport(Import value);

    /**
     * Returns the value of the '<em><b>Deployment Technology</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Deployment Technology</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Deployment Technology</em>' reference.
     * @see #setDeploymentTechnology(DeploymentTechnology)
     * @see de.fhdo.ddmm.operation.OperationPackage#getDeploymentTechnologyReference_DeploymentTechnology()
     * @model
     * @generated
     */
    DeploymentTechnology getDeploymentTechnology();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.operation.DeploymentTechnologyReference#getDeploymentTechnology <em>Deployment Technology</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Deployment Technology</em>' reference.
     * @see #getDeploymentTechnology()
     * @generated
     */
    void setDeploymentTechnology(DeploymentTechnology value);

    /**
     * Returns the value of the '<em><b>Container</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.operation.Container#getDeploymentTechnology <em>Deployment Technology</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Container</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Container</em>' container reference.
     * @see #setContainer(Container)
     * @see de.fhdo.ddmm.operation.OperationPackage#getDeploymentTechnologyReference_Container()
     * @see de.fhdo.ddmm.operation.Container#getDeploymentTechnology
     * @model opposite="deploymentTechnology" transient="false"
     * @generated
     */
    Container getContainer();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.operation.DeploymentTechnologyReference#getContainer <em>Container</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Container</em>' container reference.
     * @see #getContainer()
     * @generated
     */
    void setContainer(Container value);

} // DeploymentTechnologyReference
