/**
 */
package de.fhdo.ddmm.operation;

import de.fhdo.ddmm.service.Import;
import de.fhdo.ddmm.service.Microservice;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Imported Microservice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Represents an imported microservice
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.operation.ImportedMicroservice#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.ddmm.operation.ImportedMicroservice#getMicroservice <em>Microservice</em>}</li>
 *   <li>{@link de.fhdo.ddmm.operation.ImportedMicroservice#getOperationNode <em>Operation Node</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.operation.OperationPackage#getImportedMicroservice()
 * @model
 * @generated
 */
public interface ImportedMicroservice extends EObject {
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
     * @see de.fhdo.ddmm.operation.OperationPackage#getImportedMicroservice_Import()
     * @model
     * @generated
     */
    Import getImport();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.operation.ImportedMicroservice#getImport <em>Import</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Import</em>' reference.
     * @see #getImport()
     * @generated
     */
    void setImport(Import value);

    /**
     * Returns the value of the '<em><b>Microservice</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Microservice</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Microservice</em>' reference.
     * @see #setMicroservice(Microservice)
     * @see de.fhdo.ddmm.operation.OperationPackage#getImportedMicroservice_Microservice()
     * @model
     * @generated
     */
    Microservice getMicroservice();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.operation.ImportedMicroservice#getMicroservice <em>Microservice</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Microservice</em>' reference.
     * @see #getMicroservice()
     * @generated
     */
    void setMicroservice(Microservice value);

    /**
     * Returns the value of the '<em><b>Operation Node</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.ddmm.operation.OperationNode#getDeployedServices <em>Deployed Services</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operation Node</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operation Node</em>' container reference.
     * @see #setOperationNode(OperationNode)
     * @see de.fhdo.ddmm.operation.OperationPackage#getImportedMicroservice_OperationNode()
     * @see de.fhdo.ddmm.operation.OperationNode#getDeployedServices
     * @model opposite="deployedServices" transient="false"
     * @generated
     */
    OperationNode getOperationNode();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.operation.ImportedMicroservice#getOperationNode <em>Operation Node</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operation Node</em>' container reference.
     * @see #getOperationNode()
     * @generated
     */
    void setOperationNode(OperationNode value);

} // ImportedMicroservice
