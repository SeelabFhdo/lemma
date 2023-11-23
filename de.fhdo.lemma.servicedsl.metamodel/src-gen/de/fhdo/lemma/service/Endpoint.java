/**
 */
package de.fhdo.lemma.service;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Represents an endpoint, i.e., the assignment of physical addresses, e.g., URIs with a protocol,
 * e.g., REST/JSON.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.Endpoint#getAddresses <em>Addresses</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Endpoint#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Endpoint#getMicroservice <em>Microservice</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Endpoint#getInterface <em>Interface</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Endpoint#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Endpoint#getReferredOperation <em>Referred Operation</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.ServicePackage#getEndpoint()
 * @model
 * @generated
 */
public interface Endpoint extends EObject {
	/**
	 * Returns the value of the '<em><b>Addresses</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Implicit Constraints:
	 *     (C1) Addresses must be unique.
	 *          Ensured by: DSL validator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Addresses</em>' attribute list.
	 * @see de.fhdo.lemma.service.ServicePackage#getEndpoint_Addresses()
	 * @model unique="false" required="true"
	 * @generated
	 */
	EList<String> getAddresses();

	/**
	 * Returns the value of the '<em><b>Protocols</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.ImportedProtocolAndDataFormat}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.ImportedProtocolAndDataFormat#getEndpoint <em>Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocols</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getEndpoint_Protocols()
	 * @see de.fhdo.lemma.service.ImportedProtocolAndDataFormat#getEndpoint
	 * @model opposite="endpoint" containment="true" required="true"
	 * @generated
	 */
	EList<ImportedProtocolAndDataFormat> getProtocols();

	/**
	 * Returns the value of the '<em><b>Microservice</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.Microservice#getEndpoints <em>Endpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Microservice</em>' container reference.
	 * @see #setMicroservice(Microservice)
	 * @see de.fhdo.lemma.service.ServicePackage#getEndpoint_Microservice()
	 * @see de.fhdo.lemma.service.Microservice#getEndpoints
	 * @model opposite="endpoints" transient="false"
	 * @generated
	 */
	Microservice getMicroservice();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Endpoint#getMicroservice <em>Microservice</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Microservice</em>' container reference.
	 * @see #getMicroservice()
	 * @generated
	 */
	void setMicroservice(Microservice value);

	/**
	 * Returns the value of the '<em><b>Interface</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.Interface#getEndpoints <em>Endpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface</em>' container reference.
	 * @see #setInterface(Interface)
	 * @see de.fhdo.lemma.service.ServicePackage#getEndpoint_Interface()
	 * @see de.fhdo.lemma.service.Interface#getEndpoints
	 * @model opposite="endpoints" transient="false"
	 * @generated
	 */
	Interface getInterface();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Endpoint#getInterface <em>Interface</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface</em>' container reference.
	 * @see #getInterface()
	 * @generated
	 */
	void setInterface(Interface value);

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.Operation#getEndpoints <em>Endpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' container reference.
	 * @see #setOperation(Operation)
	 * @see de.fhdo.lemma.service.ServicePackage#getEndpoint_Operation()
	 * @see de.fhdo.lemma.service.Operation#getEndpoints
	 * @model opposite="endpoints" transient="false"
	 * @generated
	 */
	Operation getOperation();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Endpoint#getOperation <em>Operation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' container reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(Operation value);

	/**
	 * Returns the value of the '<em><b>Referred Operation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.ReferredOperation#getEndpoints <em>Endpoints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Operation</em>' container reference.
	 * @see #setReferredOperation(ReferredOperation)
	 * @see de.fhdo.lemma.service.ServicePackage#getEndpoint_ReferredOperation()
	 * @see de.fhdo.lemma.service.ReferredOperation#getEndpoints
	 * @model opposite="endpoints" transient="false"
	 * @generated
	 */
	ReferredOperation getReferredOperation();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Endpoint#getReferredOperation <em>Referred Operation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Operation</em>' container reference.
	 * @see #getReferredOperation()
	 * @generated
	 */
	void setReferredOperation(ReferredOperation value);

} // Endpoint
