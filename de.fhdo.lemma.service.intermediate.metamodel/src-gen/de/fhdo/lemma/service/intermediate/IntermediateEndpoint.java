/**
 */
package de.fhdo.lemma.service.intermediate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Endpoint
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getCommunicationType <em>Communication Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getDataFormat <em>Data Format</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getAddresses <em>Addresses</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getMicroservice <em>Microservice</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getInterface <em>Interface</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getReferredOperation <em>Referred Operation</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateEndpoint()
 * @model
 * @generated
 */
public interface IntermediateEndpoint extends EObject {
    /**
     * Returns the value of the '<em><b>Communication Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Communication Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Communication Type</em>' attribute.
     * @see #setCommunicationType(String)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateEndpoint_CommunicationType()
     * @model unique="false"
     * @generated
     */
    String getCommunicationType();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getCommunicationType <em>Communication Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Communication Type</em>' attribute.
     * @see #getCommunicationType()
     * @generated
     */
    void setCommunicationType(String value);

    /**
     * Returns the value of the '<em><b>Protocol</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Protocol</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Protocol</em>' attribute.
     * @see #setProtocol(String)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateEndpoint_Protocol()
     * @model unique="false"
     * @generated
     */
    String getProtocol();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getProtocol <em>Protocol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Protocol</em>' attribute.
     * @see #getProtocol()
     * @generated
     */
    void setProtocol(String value);

    /**
     * Returns the value of the '<em><b>Data Format</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Format</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Format</em>' attribute.
     * @see #setDataFormat(String)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateEndpoint_DataFormat()
     * @model unique="false"
     * @generated
     */
    String getDataFormat();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getDataFormat <em>Data Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Format</em>' attribute.
     * @see #getDataFormat()
     * @generated
     */
    void setDataFormat(String value);

    /**
     * Returns the value of the '<em><b>Addresses</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Addresses</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Addresses</em>' attribute list.
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateEndpoint_Addresses()
     * @model unique="false"
     * @generated
     */
    EList<String> getAddresses();

    /**
     * Returns the value of the '<em><b>Technology</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Technology</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Technology</em>' reference.
     * @see #setTechnology(IntermediateTechnology)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateEndpoint_Technology()
     * @model
     * @generated
     */
    IntermediateTechnology getTechnology();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getTechnology <em>Technology</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Technology</em>' reference.
     * @see #getTechnology()
     * @generated
     */
    void setTechnology(IntermediateTechnology value);

    /**
     * Returns the value of the '<em><b>Microservice</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getEndpoints <em>Endpoints</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Microservice</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Microservice</em>' container reference.
     * @see #setMicroservice(IntermediateMicroservice)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateEndpoint_Microservice()
     * @see de.fhdo.lemma.service.intermediate.IntermediateMicroservice#getEndpoints
     * @model opposite="endpoints" transient="false"
     * @generated
     */
    IntermediateMicroservice getMicroservice();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getMicroservice <em>Microservice</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Microservice</em>' container reference.
     * @see #getMicroservice()
     * @generated
     */
    void setMicroservice(IntermediateMicroservice value);

    /**
     * Returns the value of the '<em><b>Interface</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.IntermediateInterface#getEndpoints <em>Endpoints</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Interface</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Interface</em>' container reference.
     * @see #setInterface(IntermediateInterface)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateEndpoint_Interface()
     * @see de.fhdo.lemma.service.intermediate.IntermediateInterface#getEndpoints
     * @model opposite="endpoints" transient="false"
     * @generated
     */
    IntermediateInterface getInterface();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getInterface <em>Interface</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Interface</em>' container reference.
     * @see #getInterface()
     * @generated
     */
    void setInterface(IntermediateInterface value);

    /**
     * Returns the value of the '<em><b>Operation</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getEndpoints <em>Endpoints</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operation</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operation</em>' container reference.
     * @see #setOperation(IntermediateOperation)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateEndpoint_Operation()
     * @see de.fhdo.lemma.service.intermediate.IntermediateOperation#getEndpoints
     * @model opposite="endpoints" transient="false"
     * @generated
     */
    IntermediateOperation getOperation();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getOperation <em>Operation</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operation</em>' container reference.
     * @see #getOperation()
     * @generated
     */
    void setOperation(IntermediateOperation value);

    /**
     * Returns the value of the '<em><b>Referred Operation</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getEndpoints <em>Endpoints</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Referred Operation</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Referred Operation</em>' container reference.
     * @see #setReferredOperation(IntermediateReferredOperation)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateEndpoint_ReferredOperation()
     * @see de.fhdo.lemma.service.intermediate.IntermediateReferredOperation#getEndpoints
     * @model opposite="endpoints" transient="false"
     * @generated
     */
    IntermediateReferredOperation getReferredOperation();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateEndpoint#getReferredOperation <em>Referred Operation</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Referred Operation</em>' container reference.
     * @see #getReferredOperation()
     * @generated
     */
    void setReferredOperation(IntermediateReferredOperation value);

} // IntermediateEndpoint
