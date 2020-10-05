/**
 */
package de.fhdo.lemma.service.intermediate.impl;

import de.fhdo.lemma.service.intermediate.IntermediateApiOperationComment;
import de.fhdo.lemma.service.intermediate.IntermediateApiParameterComment;
import de.fhdo.lemma.service.intermediate.IntermediatePackage;
import de.fhdo.lemma.service.intermediate.IntermediateParameter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Api Parameter Comment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateApiParameterCommentImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateApiParameterCommentImpl#isRequired <em>Required</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateApiParameterCommentImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateApiParameterCommentImpl#getOperationComment <em>Operation Comment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateApiParameterCommentImpl extends MinimalEObjectImpl.Container implements IntermediateApiParameterComment {
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
	 * The default value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REQUIRED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected boolean required = REQUIRED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected IntermediateParameter parameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntermediateApiParameterCommentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IntermediatePackage.Literals.INTERMEDIATE_API_PARAMETER_COMMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRequired() {
		return required;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRequired(boolean newRequired) {
		boolean oldRequired = required;
		required = newRequired;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__REQUIRED, oldRequired, required));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateParameter getParameter() {
		if (parameter != null && parameter.eIsProxy()) {
			InternalEObject oldParameter = (InternalEObject)parameter;
			parameter = (IntermediateParameter)eResolveProxy(oldParameter);
			if (parameter != oldParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__PARAMETER, oldParameter, parameter));
			}
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateParameter basicGetParameter() {
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParameter(IntermediateParameter newParameter) {
		IntermediateParameter oldParameter = parameter;
		parameter = newParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__PARAMETER, oldParameter, parameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateApiOperationComment getOperationComment() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__OPERATION_COMMENT) return null;
		return (IntermediateApiOperationComment)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateApiOperationComment basicGetOperationComment() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__OPERATION_COMMENT) return null;
		return (IntermediateApiOperationComment)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperationComment(IntermediateApiOperationComment newOperationComment, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOperationComment, IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__OPERATION_COMMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperationComment(IntermediateApiOperationComment newOperationComment) {
		if (newOperationComment != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__OPERATION_COMMENT && newOperationComment != null)) {
			if (EcoreUtil.isAncestor(this, newOperationComment))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOperationComment != null)
				msgs = ((InternalEObject)newOperationComment).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__PARAMETER_COMMENTS, IntermediateApiOperationComment.class, msgs);
			msgs = basicSetOperationComment(newOperationComment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__OPERATION_COMMENT, newOperationComment, newOperationComment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__OPERATION_COMMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOperationComment((IntermediateApiOperationComment)otherEnd, msgs);
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
			case IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__OPERATION_COMMENT:
				return basicSetOperationComment(null, msgs);
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
			case IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__OPERATION_COMMENT:
				return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__PARAMETER_COMMENTS, IntermediateApiOperationComment.class, msgs);
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
			case IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__COMMENT:
				return getComment();
			case IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__REQUIRED:
				return isRequired();
			case IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__PARAMETER:
				if (resolve) return getParameter();
				return basicGetParameter();
			case IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__OPERATION_COMMENT:
				if (resolve) return getOperationComment();
				return basicGetOperationComment();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__COMMENT:
				setComment((String)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__REQUIRED:
				setRequired((Boolean)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__PARAMETER:
				setParameter((IntermediateParameter)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__OPERATION_COMMENT:
				setOperationComment((IntermediateApiOperationComment)newValue);
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
			case IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__REQUIRED:
				setRequired(REQUIRED_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__PARAMETER:
				setParameter((IntermediateParameter)null);
				return;
			case IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__OPERATION_COMMENT:
				setOperationComment((IntermediateApiOperationComment)null);
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
			case IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__REQUIRED:
				return required != REQUIRED_EDEFAULT;
			case IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__PARAMETER:
				return parameter != null;
			case IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__OPERATION_COMMENT:
				return basicGetOperationComment() != null;
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
		result.append(", required: ");
		result.append(required);
		result.append(')');
		return result.toString();
	}

} //IntermediateApiParameterCommentImpl
