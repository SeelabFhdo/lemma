/**
 */
package de.fhdo.lemma.operation.intermediate;

import de.fhdo.lemma.service.intermediate.MicroserviceReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Microservice Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Reference to a operational microservice
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#isEffectivelyImplemented <em>Effectively Implemented</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getMicroserviceType <em>Microservice Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getNode <em>Node</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getOperationMicroserviceReference()
 * @model
 * @generated
 */
public interface OperationMicroserviceReference extends MicroserviceReference {
    /**
     * Returns the value of the '<em><b>Effectively Implemented</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Effectively Implemented</em>' attribute.
     * @see #setEffectivelyImplemented(boolean)
     * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getOperationMicroserviceReference_EffectivelyImplemented()
     * @model unique="false"
     * @generated
     */
    boolean isEffectivelyImplemented();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#isEffectivelyImplemented <em>Effectively Implemented</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Effectively Implemented</em>' attribute.
     * @see #isEffectivelyImplemented()
     * @generated
     */
    void setEffectivelyImplemented(boolean value);

    /**
     * Returns the value of the '<em><b>Microservice Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Microservice Type</em>' attribute.
     * @see #setMicroserviceType(String)
     * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getOperationMicroserviceReference_MicroserviceType()
     * @model unique="false"
     * @generated
     */
    String getMicroserviceType();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getMicroserviceType <em>Microservice Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Microservice Type</em>' attribute.
     * @see #getMicroserviceType()
     * @generated
     */
    void setMicroserviceType(String value);

    /**
     * Returns the value of the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Visibility</em>' attribute.
     * @see #setVisibility(String)
     * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getOperationMicroserviceReference_Visibility()
     * @model unique="false"
     * @generated
     */
    String getVisibility();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getVisibility <em>Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Visibility</em>' attribute.
     * @see #getVisibility()
     * @generated
     */
    void setVisibility(String value);

    /**
     * Returns the value of the '<em><b>Node</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getDeployedServices <em>Deployed Services</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Node</em>' container reference.
     * @see #setNode(IntermediateOperationNode)
     * @see de.fhdo.lemma.operation.intermediate.IntermediatePackage#getOperationMicroserviceReference_Node()
     * @see de.fhdo.lemma.operation.intermediate.IntermediateOperationNode#getDeployedServices
     * @model opposite="deployedServices" transient="false"
     * @generated
     */
    IntermediateOperationNode getNode();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference#getNode <em>Node</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Node</em>' container reference.
     * @see #getNode()
     * @generated
     */
    void setNode(IntermediateOperationNode value);

} // OperationMicroserviceReference
