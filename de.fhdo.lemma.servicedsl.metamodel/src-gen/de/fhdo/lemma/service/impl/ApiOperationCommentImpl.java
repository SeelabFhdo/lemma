/**
 */
package de.fhdo.lemma.service.impl;

import de.fhdo.lemma.service.ApiOperationComment;
import de.fhdo.lemma.service.ApiParameterComment;
import de.fhdo.lemma.service.Operation;
import de.fhdo.lemma.service.ServicePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Api Operation Comment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.impl.ApiOperationCommentImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ApiOperationCommentImpl#getParameterComments <em>Parameter Comments</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ApiOperationCommentImpl#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ApiOperationCommentImpl extends MinimalEObjectImpl.Container implements ApiOperationComment {
	/**
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected String comment = COMMENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameterComments() <em>Parameter Comments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterComments()
	 * @generated
	 * @ordered
	 */
	protected EList<ApiParameterComment> parameterComments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApiOperationCommentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicePackage.Literals.API_OPERATION_COMMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getComment() {
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setComment(String newComment) {
		String oldComment = comment;
		comment = newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.API_OPERATION_COMMENT__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ApiParameterComment> getParameterComments() {
		if (parameterComments == null) {
			parameterComments = new EObjectContainmentWithInverseEList<ApiParameterComment>(ApiParameterComment.class, this, ServicePackage.API_OPERATION_COMMENT__PARAMETER_COMMENTS, ServicePackage.API_PARAMETER_COMMENT__OPERATION_COMMENT);
		}
		return parameterComments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Operation getOperation() {
		if (eContainerFeatureID() != ServicePackage.API_OPERATION_COMMENT__OPERATION) return null;
		return (Operation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetOperation() {
		if (eContainerFeatureID() != ServicePackage.API_OPERATION_COMMENT__OPERATION) return null;
		return (Operation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperation(Operation newOperation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOperation, ServicePackage.API_OPERATION_COMMENT__OPERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperation(Operation newOperation) {
		if (newOperation != eInternalContainer() || (eContainerFeatureID() != ServicePackage.API_OPERATION_COMMENT__OPERATION && newOperation != null)) {
			if (EcoreUtil.isAncestor(this, newOperation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOperation != null)
				msgs = ((InternalEObject)newOperation).eInverseAdd(this, ServicePackage.OPERATION__API_OPERATION_COMMENT, Operation.class, msgs);
			msgs = basicSetOperation(newOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.API_OPERATION_COMMENT__OPERATION, newOperation, newOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicePackage.API_OPERATION_COMMENT__PARAMETER_COMMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameterComments()).basicAdd(otherEnd, msgs);
			case ServicePackage.API_OPERATION_COMMENT__OPERATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOperation((Operation)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicePackage.API_OPERATION_COMMENT__PARAMETER_COMMENTS:
				return ((InternalEList<?>)getParameterComments()).basicRemove(otherEnd, msgs);
			case ServicePackage.API_OPERATION_COMMENT__OPERATION:
				return basicSetOperation(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ServicePackage.API_OPERATION_COMMENT__OPERATION:
				return eInternalContainer().eInverseRemove(this, ServicePackage.OPERATION__API_OPERATION_COMMENT, Operation.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ServicePackage.API_OPERATION_COMMENT__COMMENT:
				return getComment();
			case ServicePackage.API_OPERATION_COMMENT__PARAMETER_COMMENTS:
				return getParameterComments();
			case ServicePackage.API_OPERATION_COMMENT__OPERATION:
				if (resolve) return getOperation();
				return basicGetOperation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ServicePackage.API_OPERATION_COMMENT__COMMENT:
				setComment((String)newValue);
				return;
			case ServicePackage.API_OPERATION_COMMENT__PARAMETER_COMMENTS:
				getParameterComments().clear();
				getParameterComments().addAll((Collection<? extends ApiParameterComment>)newValue);
				return;
			case ServicePackage.API_OPERATION_COMMENT__OPERATION:
				setOperation((Operation)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ServicePackage.API_OPERATION_COMMENT__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case ServicePackage.API_OPERATION_COMMENT__PARAMETER_COMMENTS:
				getParameterComments().clear();
				return;
			case ServicePackage.API_OPERATION_COMMENT__OPERATION:
				setOperation((Operation)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ServicePackage.API_OPERATION_COMMENT__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case ServicePackage.API_OPERATION_COMMENT__PARAMETER_COMMENTS:
				return parameterComments != null && !parameterComments.isEmpty();
			case ServicePackage.API_OPERATION_COMMENT__OPERATION:
				return basicGetOperation() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (comment: ");
		result.append(comment);
		result.append(')');
		return result.toString();
	}

} //ApiOperationCommentImpl
