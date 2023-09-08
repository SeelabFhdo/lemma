/**
 */
package de.fhdo.lemma.service;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Referred Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Represents an operation to which an interface other than its defining interface refers. Used for
 * interface mashups.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.ReferredOperation#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.ReferredOperation#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.ReferredOperation#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.ReferredOperation#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.ReferredOperation#getInterface <em>Interface</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.ServicePackage#getReferredOperation()
 * @model
 * @generated
 */
public interface ReferredOperation extends EObject {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Implicit Constraints:
	 *     (C1) There might be at most one protocol per communication type assigned to a referred
	 *          operation.
	 *          Ensured by: DSL validator.
	 *     (C2) Combination of endpoints' protocols and data formats must be unique.
	 *          Ensured by: DSL validator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Operation</em>' reference.
	 * @see #setOperation(Operation)
	 * @see de.fhdo.lemma.service.ServicePackage#getReferredOperation_Operation()
	 * @model
	 * @generated
	 */
	Operation getOperation();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.ReferredOperation#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(Operation value);

	/**
	 * Returns the value of the '<em><b>Endpoints</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.Endpoint}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.Endpoint#getReferredOperation <em>Referred Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoints</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getReferredOperation_Endpoints()
	 * @see de.fhdo.lemma.service.Endpoint#getReferredOperation
	 * @model opposite="referredOperation" containment="true"
	 * @generated
	 */
	EList<Endpoint> getEndpoints();

	/**
	 * Returns the value of the '<em><b>Protocols</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.ProtocolSpecification}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocols</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getReferredOperation_Protocols()
	 * @model containment="true" upper="2"
	 * @generated
	 */
	EList<ProtocolSpecification> getProtocols();

	/**
	 * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.ImportedServiceAspect}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.ImportedServiceAspect#getReferredOperation <em>Referred Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspects</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getReferredOperation_Aspects()
	 * @see de.fhdo.lemma.service.ImportedServiceAspect#getReferredOperation
	 * @model opposite="referredOperation" containment="true"
	 * @generated
	 */
	EList<ImportedServiceAspect> getAspects();

	/**
	 * Returns the value of the '<em><b>Interface</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.Interface#getReferredOperations <em>Referred Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface</em>' container reference.
	 * @see #setInterface(Interface)
	 * @see de.fhdo.lemma.service.ServicePackage#getReferredOperation_Interface()
	 * @see de.fhdo.lemma.service.Interface#getReferredOperations
	 * @model opposite="referredOperations" transient="false"
	 * @generated
	 */
	Interface getInterface();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.ReferredOperation#getInterface <em>Interface</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface</em>' container reference.
	 * @see #getInterface()
	 * @generated
	 */
	void setInterface(Interface value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * TRANSFORMATION ONLY: Get effective protocols of the referred operation as combinations of
	 * Protocol and DataFormat. The effective protocols are primarily determined by the referred
	 * operations _own_ (i.e., _not_ the operation it refers to) protocol specifications. If a
	 * protocol specification for a communication type is missing, the type's effective protocols
	 * are taken from the interface that surrounds the referred operation (i.e., _not_ the interface
	 * of the operation being referred to).
	 * <!-- end-model-doc -->
	 * @model dataType="de.fhdo.lemma.service.TupleList" unique="false"
	 * @generated
	 */
	List<Map<String, Object>> t_effectiveProtocolSpecifications();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get parts of the referred operation for creating a qualified name
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	EList<String> getQualifiedNameParts();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Build qualified name from qualified name parts
	 * <!-- end-model-doc -->
	 * @model unique="false" separatorUnique="false"
	 * @generated
	 */
	String buildQualifiedName(String separator);

} // ReferredOperation
