/**
 */
package de.fhdo.lemma.service.intermediate;

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
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateApiOperationComment#getComment <em>Comment</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateApiOperationComment#getParameterComments <em>Parameter Comments</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.IntermediateApiOperationComment#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateApiOperationComment()
 * @model
 * @generated
 */
public interface IntermediateApiOperationComment extends EObject {
	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateApiOperationComment_Comment()
	 * @model unique="false"
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateApiOperationComment#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Parameter Comments</b></em>' containment reference list.
	 * The list contents are of type {@link de.fhdo.lemma.service.intermediate.IntermediateApiParameterComment}.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.IntermediateApiParameterComment#getOperationComment <em>Operation Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Comments</em>' containment reference list.
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateApiOperationComment_ParameterComments()
	 * @see de.fhdo.lemma.service.intermediate.IntermediateApiParameterComment#getOperationComment
	 * @model opposite="operationComment" containment="true"
	 * @generated
	 */
	EList<IntermediateApiParameterComment> getParameterComments();

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fhdo.lemma.service.intermediate.IntermediateOperation#getApiOperationComment <em>Api Operation Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' container reference.
	 * @see #setOperation(IntermediateOperation)
	 * @see de.fhdo.lemma.service.intermediate.IntermediatePackage#getIntermediateApiOperationComment_Operation()
	 * @see de.fhdo.lemma.service.intermediate.IntermediateOperation#getApiOperationComment
	 * @model opposite="apiOperationComment" transient="false"
	 * @generated
	 */
	IntermediateOperation getOperation();

	/**
	 * Sets the value of the '{@link de.fhdo.lemma.service.intermediate.IntermediateApiOperationComment#getOperation <em>Operation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' container reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(IntermediateOperation value);

} // IntermediateApiOperationComment
