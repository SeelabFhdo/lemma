/**
 */
package de.fhdo.lemma.service.intermediate;

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
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateProtocolSpecification#getCommunicationType <em>Communication Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateProtocolSpecification#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateProtocolSpecification#getDataFormat <em>Data Format</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateProtocolSpecification()
 * @model
 * @generated
 */
public interface IntermediateProtocolSpecification extends EObject {
    /**
     * Returns the value of the '<em><b>Communication Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Communication Type</em>' attribute.
     * @see #setCommunicationType(String)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateProtocolSpecification_CommunicationType()
     * @model unique="false"
     * @generated
     */
    String getCommunicationType();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateProtocolSpecification#getCommunicationType <em>Communication Type</em>}' attribute.
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
     * <!-- end-user-doc -->
     * @return the value of the '<em>Protocol</em>' attribute.
     * @see #setProtocol(String)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateProtocolSpecification_Protocol()
     * @model unique="false"
     * @generated
     */
    String getProtocol();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateProtocolSpecification#getProtocol <em>Protocol</em>}' attribute.
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
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Format</em>' attribute.
     * @see #setDataFormat(String)
     * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateProtocolSpecification_DataFormat()
     * @model unique="false"
     * @generated
     */
    String getDataFormat();

    /**
     * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateProtocolSpecification#getDataFormat <em>Data Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Format</em>' attribute.
     * @see #getDataFormat()
     * @generated
     */
    void setDataFormat(String value);

} // IntermediateProtocolSpecification
