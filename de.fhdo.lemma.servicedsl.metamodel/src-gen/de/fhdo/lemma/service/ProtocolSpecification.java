/**
 */
package de.fhdo.lemma.service;

import de.fhdo.lemma.technology.CommunicationType;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protocol Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Protocol specification that combines a communication type with an imported protocol. Used to
 * specify, e.g., the default asynchronous and/or synchronous protocol of services, interfaces, and
 * operations.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.ProtocolSpecification#getCommunicationType <em>Communication Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.ProtocolSpecification#getProtocol <em>Protocol</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.ServicePackage#getProtocolSpecification()
 * @model
 * @generated
 */
public interface ProtocolSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Communication Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.fhdo.lemma.technology.CommunicationType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Communication Type</em>' attribute.
	 * @see de.fhdo.lemma.technology.CommunicationType
	 * @see #setCommunicationType(CommunicationType)
	 * @see de.fhdo.lemma.service.ServicePackage#getProtocolSpecification_CommunicationType()
	 * @model unique="false"
	 * @generated
	 */
	CommunicationType getCommunicationType();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.ProtocolSpecification#getCommunicationType <em>Communication Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Communication Type</em>' attribute.
	 * @see de.fhdo.lemma.technology.CommunicationType
	 * @see #getCommunicationType()
	 * @generated
	 */
	void setCommunicationType(CommunicationType value);

	/**
	 * Returns the value of the '<em><b>Protocol</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.ImportedProtocolAndDataFormat#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocol</em>' containment reference.
	 * @see #setProtocol(ImportedProtocolAndDataFormat)
	 * @see de.fhdo.lemma.service.ServicePackage#getProtocolSpecification_Protocol()
	 * @see de.fhdo.lemma.service.ImportedProtocolAndDataFormat#getSpecification
	 * @model opposite="specification" containment="true"
	 * @generated
	 */
	ImportedProtocolAndDataFormat getProtocol();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.ProtocolSpecification#getProtocol <em>Protocol</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protocol</em>' containment reference.
	 * @see #getProtocol()
	 * @generated
	 */
	void setProtocol(ImportedProtocolAndDataFormat value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Reusable helper method to determine effective protocol specifications from a list of
	 * ProtocolSpecification instances as combinations of Protocol and DataFormat. In case a
	 * ProtocolSpecification instance does not specify an explicit or implicit (i.e., default) data
	 * format, the effective protocol specifications correspond to the ProtocolSpecification's
	 * Protocol being combined with all of its DataFormats.
	 * <!-- end-model-doc -->
	 * @model dataType="de.fhdo.lemma.service.TupleList" unique="false" specificationsUnique="false" specificationsMany="true"
	 * @generated
	 */
	List<Map<String, Object>> effectiveProtocolSpecifications(EList<ProtocolSpecification> specifications);

} // ProtocolSpecification
