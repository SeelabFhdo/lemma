/**
 */
package de.fhdo.ddmm.service.intermediate;

import de.fhdo.ddmm.technology.CommunicationType;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protocol Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Protocol specification
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateProtocolSpecification#getCommunicationType <em>Communication Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateProtocolSpecification#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.intermediate.IntermediateProtocolSpecification#getDataFormat <em>Data Format</em>}</li>
 * </ul>
 *
 * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateProtocolSpecification()
 * @model
 * @generated
 */
public interface IntermediateProtocolSpecification extends EObject {
    /**
     * Returns the value of the '<em><b>Communication Type</b></em>' attribute.
     * The literals are from the enumeration {@link de.fhdo.ddmm.technology.CommunicationType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Communication Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Communication Type</em>' attribute.
     * @see de.fhdo.ddmm.technology.CommunicationType
     * @see #setCommunicationType(CommunicationType)
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateProtocolSpecification_CommunicationType()
     * @model unique="false"
     * @generated
     */
    CommunicationType getCommunicationType();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateProtocolSpecification#getCommunicationType <em>Communication Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Communication Type</em>' attribute.
     * @see de.fhdo.ddmm.technology.CommunicationType
     * @see #getCommunicationType()
     * @generated
     */
    void setCommunicationType(CommunicationType value);

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
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateProtocolSpecification_Protocol()
     * @model unique="false"
     * @generated
     */
    String getProtocol();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateProtocolSpecification#getProtocol <em>Protocol</em>}' attribute.
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
     * @see de.fhdo.ddmm.service.intermediate.IntermediatePackage#getIntermediateProtocolSpecification_DataFormat()
     * @model unique="false"
     * @generated
     */
    String getDataFormat();

    /**
     * Sets the value of the '{@link de.fhdo.ddmm.service.intermediate.IntermediateProtocolSpecification#getDataFormat <em>Data Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Format</em>' attribute.
     * @see #getDataFormat()
     * @generated
     */
    void setDataFormat(String value);

} // IntermediateProtocolSpecification
