/**
 */
package de.fhdo.lemma.service;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Represents an operation within an interface of a microservice
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.Operation#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Operation#isNotImplemented <em>Not Implemented</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Operation#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Operation#getApiOperationComment <em>Api Operation Comment</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Operation#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Operation#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Operation#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Operation#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Operation#getInterface <em>Interface</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Operation#isNotImplementedByContainer <em>Not Implemented By Container</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Operation#isEffectivelyNotImplemented <em>Effectively Not Implemented</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Operation#getEffectiveVisibility <em>Effective Visibility</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.Operation#isEffectivelyInternal <em>Effectively Internal</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.ServicePackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Implicit Constraints:
	 *     (C1) There might be at most one protocol per communication type assigned to an operation.
	 *          Ensured by: DSL validator.
	 *     (C2) Combination of endpoints' protocols and data formats must be unique.
	 *          Ensured by: DSL validator.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fhdo.lemma.service.ServicePackage#getOperation_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Operation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Not Implemented</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Not Implemented</em>' attribute.
	 * @see #setNotImplemented(boolean)
	 * @see de.fhdo.lemma.service.ServicePackage#getOperation_NotImplemented()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isNotImplemented();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Operation#isNotImplemented <em>Not Implemented</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Not Implemented</em>' attribute.
	 * @see #isNotImplemented()
	 * @generated
	 */
	void setNotImplemented(boolean value);

	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * The default value is <code>"NONE"</code>.
	 * The literals are from the enumeration {@link de.fhdo.lemma.service.Visibility}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visibility</em>' attribute.
	 * @see de.fhdo.lemma.service.Visibility
	 * @see #setVisibility(Visibility)
	 * @see de.fhdo.lemma.service.ServicePackage#getOperation_Visibility()
	 * @model default="NONE" unique="false"
	 * @generated
	 */
	Visibility getVisibility();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Operation#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see de.fhdo.lemma.service.Visibility
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(Visibility value);

	/**
	 * Returns the value of the '<em><b>Api Operation Comment</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.ApiOperationComment#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Api Operation Comment</em>' containment reference.
	 * @see #setApiOperationComment(ApiOperationComment)
	 * @see de.fhdo.lemma.service.ServicePackage#getOperation_ApiOperationComment()
	 * @see de.fhdo.lemma.service.ApiOperationComment#getOperation
	 * @model opposite="operation" containment="true"
	 * @generated
	 */
	ApiOperationComment getApiOperationComment();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Operation#getApiOperationComment <em>Api Operation Comment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Api Operation Comment</em>' containment reference.
	 * @see #getApiOperationComment()
	 * @generated
	 */
	void setApiOperationComment(ApiOperationComment value);

	/**
	 * Returns the value of the '<em><b>Endpoints</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.Endpoint}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.Endpoint#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoints</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getOperation_Endpoints()
	 * @see de.fhdo.lemma.service.Endpoint#getOperation
	 * @model opposite="operation" containment="true"
	 * @generated
	 */
	EList<Endpoint> getEndpoints();

	/**
	 * Returns the value of the '<em><b>Protocols</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.ProtocolSpecification}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocols</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getOperation_Protocols()
	 * @model containment="true" upper="2"
	 * @generated
	 */
	EList<ProtocolSpecification> getProtocols();

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.Parameter}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.Parameter#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getOperation_Parameters()
	 * @see de.fhdo.lemma.service.Parameter#getOperation
	 * @model opposite="operation" containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Aspects</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.ImportedServiceAspect}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.ImportedServiceAspect#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aspects</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getOperation_Aspects()
	 * @see de.fhdo.lemma.service.ImportedServiceAspect#getOperation
	 * @model opposite="operation" containment="true"
	 * @generated
	 */
	EList<ImportedServiceAspect> getAspects();

	/**
	 * Returns the value of the '<em><b>Interface</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.Interface#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interface</em>' container reference.
	 * @see #setInterface(Interface)
	 * @see de.fhdo.lemma.service.ServicePackage#getOperation_Interface()
	 * @see de.fhdo.lemma.service.Interface#getOperations
	 * @model opposite="operations" transient="false"
	 * @generated
	 */
	Interface getInterface();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.Operation#getInterface <em>Interface</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface</em>' container reference.
	 * @see #getInterface()
	 * @generated
	 */
	void setInterface(Interface value);

	/**
	 * Returns the value of the '<em><b>Not Implemented By Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Check if the operation is indirectly not implemented, because its container, i.e., interface,
	 * is already marked as being not implemented
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Not Implemented By Container</em>' attribute.
	 * @see de.fhdo.lemma.service.ServicePackage#getOperation_NotImplementedByContainer()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isNotImplementedByContainer();

	/**
	 * Returns the value of the '<em><b>Effectively Not Implemented</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Check, if an operation is effectively not implemented, either directly or indirectly, i.e.,
	 * because its interface is already marked as being not implemented
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Effectively Not Implemented</em>' attribute.
	 * @see de.fhdo.lemma.service.ServicePackage#getOperation_EffectivelyNotImplemented()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isEffectivelyNotImplemented();

	/**
	 * Returns the value of the '<em><b>Effective Visibility</b></em>' attribute.
	 * The literals are from the enumeration {@link de.fhdo.lemma.service.Visibility}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Get effective visibility
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Effective Visibility</em>' attribute.
	 * @see de.fhdo.lemma.service.Visibility
	 * @see de.fhdo.lemma.service.ServicePackage#getOperation_EffectiveVisibility()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Visibility getEffectiveVisibility();

	/**
	 * Returns the value of the '<em><b>Effectively Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Convenience method to check if an interface is effectively marked as being internal
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Effectively Internal</em>' attribute.
	 * @see de.fhdo.lemma.service.ServicePackage#getOperation_EffectivelyInternal()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isEffectivelyInternal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * TRANSFORMATION ONLY: Get effective protocols of the operation as combinations of Protocol
	 * and DataFormat. The effective protocols are primarily determined by the operation's protocol
	 * specifications. If a protocol specification for a communication type is missing, the type's
	 * effective protocols are taken from the containing interface.
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
	 * Get parts of the operation for creating a qualified name
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

} // Operation
