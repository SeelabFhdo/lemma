/**
 */
package de.fhdo.lemma.service;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Api Operation Comment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * API comment for an operation
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.ApiOperationComment#getComment <em>Comment</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.ApiOperationComment#getParameterComments <em>Parameter Comments</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.ApiOperationComment#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.ServicePackage#getApiOperationComment()
 * @model
 * @generated
 */
public interface ApiOperationComment extends EObject {
	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see de.fhdo.lemma.service.ServicePackage#getApiOperationComment_Comment()
	 * @model unique="false"
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.ApiOperationComment#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Parameter Comments</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.ApiParameterComment}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.ApiParameterComment#getOperationComment <em>Operation Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Comments</em>' containment reference list.
	 * @see de.fhdo.lemma.service.ServicePackage#getApiOperationComment_ParameterComments()
	 * @see de.fhdo.lemma.service.ApiParameterComment#getOperationComment
	 * @model opposite="operationComment" containment="true"
	 * @generated
	 */
	EList<ApiParameterComment> getParameterComments();

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.Operation#getApiOperationComment <em>Api Operation Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' container reference.
	 * @see #setOperation(Operation)
	 * @see de.fhdo.lemma.service.ServicePackage#getApiOperationComment_Operation()
	 * @see de.fhdo.lemma.service.Operation#getApiOperationComment
	 * @model opposite="apiOperationComment" transient="false"
	 * @generated
	 */
	Operation getOperation();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.ApiOperationComment#getOperation <em>Operation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' container reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(Operation value);

} // ApiOperationComment
