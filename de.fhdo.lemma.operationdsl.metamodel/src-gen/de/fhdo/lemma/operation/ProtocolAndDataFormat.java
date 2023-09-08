/**
 */
package de.fhdo.lemma.operation;

import de.fhdo.lemma.service.Import;

import de.fhdo.lemma.technology.DataFormat;
import de.fhdo.lemma.technology.Protocol;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protocol And Data Format</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Concept to consolidate a protocol and data format from a given technology
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.ProtocolAndDataFormat#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.ProtocolAndDataFormat#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.ProtocolAndDataFormat#getDataFormat <em>Data Format</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.ProtocolAndDataFormat#getEndpoint <em>Endpoint</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.operation.OperationPackage#getProtocolAndDataFormat()
 * @model
 * @generated
 */
public interface ProtocolAndDataFormat extends EObject {
	/**
	 * Returns the value of the '<em><b>Technology</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Implicit Constraints:
	 *     (C1) Protocol must be one from the technology assigned to the parent operation node.
	 *          Ensured by: DSL scope provider.
	 *     (C2) Data format must be one from the technology assigned to the parent operation node
	 *          and correspond to the protocol.
	 *          Ensured by: DSL scope provider.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Technology</em>' reference.
	 * @see #setTechnology(Import)
	 * @see de.fhdo.lemma.operation.OperationPackage#getProtocolAndDataFormat_Technology()
	 * @model
	 * @generated
	 */
	Import getTechnology();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.ProtocolAndDataFormat#getTechnology <em>Technology</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Technology</em>' reference.
	 * @see #getTechnology()
	 * @generated
	 */
	void setTechnology(Import value);

	/**
	 * Returns the value of the '<em><b>Protocol</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocol</em>' reference.
	 * @see #setProtocol(Protocol)
	 * @see de.fhdo.lemma.operation.OperationPackage#getProtocolAndDataFormat_Protocol()
	 * @model
	 * @generated
	 */
	Protocol getProtocol();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.ProtocolAndDataFormat#getProtocol <em>Protocol</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protocol</em>' reference.
	 * @see #getProtocol()
	 * @generated
	 */
	void setProtocol(Protocol value);

	/**
	 * Returns the value of the '<em><b>Data Format</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Format</em>' reference.
	 * @see #setDataFormat(DataFormat)
	 * @see de.fhdo.lemma.operation.OperationPackage#getProtocolAndDataFormat_DataFormat()
	 * @model
	 * @generated
	 */
	DataFormat getDataFormat();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.ProtocolAndDataFormat#getDataFormat <em>Data Format</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Format</em>' reference.
	 * @see #getDataFormat()
	 * @generated
	 */
	void setDataFormat(DataFormat value);

	/**
	 * Returns the value of the '<em><b>Endpoint</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.operation.BasicEndpoint#getProtocols <em>Protocols</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoint</em>' container reference.
	 * @see #setEndpoint(BasicEndpoint)
	 * @see de.fhdo.lemma.operation.OperationPackage#getProtocolAndDataFormat_Endpoint()
	 * @see de.fhdo.lemma.operation.BasicEndpoint#getProtocols
	 * @model opposite="protocols" transient="false"
	 * @generated
	 */
	BasicEndpoint getEndpoint();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.operation.ProtocolAndDataFormat#getEndpoint <em>Endpoint</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endpoint</em>' container reference.
	 * @see #getEndpoint()
	 * @generated
	 */
	void setEndpoint(BasicEndpoint value);

} // ProtocolAndDataFormat
