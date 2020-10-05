/**
 */
package de.fhdo.lemma.service;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Api Parameter Comment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * API comment for an operation's parameter
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.ApiParameterComment#getComment <em>Comment</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.ApiParameterComment#isRequired <em>Required</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.ApiParameterComment#getParameter <em>Parameter</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.ApiParameterComment#getOperationComment <em>Operation Comment</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.ServicePackage#getApiParameterComment()
 * @model
 * @generated
 */
public interface ApiParameterComment extends EObject {
	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see de.fhdo.lemma.service.ServicePackage#getApiParameterComment_Comment()
	 * @model unique="false"
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.ApiParameterComment#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required</em>' attribute.
	 * @see #setRequired(boolean)
	 * @see de.fhdo.lemma.service.ServicePackage#getApiParameterComment_Required()
	 * @model unique="false"
	 * @generated
	 */
	boolean isRequired();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.ApiParameterComment#isRequired <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required</em>' attribute.
	 * @see #isRequired()
	 * @generated
	 */
	void setRequired(boolean value);

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' reference.
	 * @see #setParameter(Parameter)
	 * @see de.fhdo.lemma.service.ServicePackage#getApiParameterComment_Parameter()
	 * @model
	 * @generated
	 */
	Parameter getParameter();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.ApiParameterComment#getParameter <em>Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' reference.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(Parameter value);

	/**
	 * Returns the value of the '<em><b>Operation Comment</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.ApiOperationComment#getParameterComments <em>Parameter Comments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Comment</em>' container reference.
	 * @see #setOperationComment(ApiOperationComment)
	 * @see de.fhdo.lemma.service.ServicePackage#getApiParameterComment_OperationComment()
	 * @see de.fhdo.lemma.service.ApiOperationComment#getParameterComments
	 * @model opposite="parameterComments" transient="false"
	 * @generated
	 */
	ApiOperationComment getOperationComment();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.ApiParameterComment#getOperationComment <em>Operation Comment</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Comment</em>' container reference.
	 * @see #getOperationComment()
	 * @generated
	 */
	void setOperationComment(ApiOperationComment value);

} // ApiParameterComment
