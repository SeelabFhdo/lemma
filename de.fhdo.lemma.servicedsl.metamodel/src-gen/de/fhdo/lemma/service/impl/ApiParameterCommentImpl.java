/**
 */
package de.fhdo.lemma.service.impl;

import de.fhdo.lemma.service.ApiOperationComment;
import de.fhdo.lemma.service.ApiParameterComment;
import de.fhdo.lemma.service.Parameter;
import de.fhdo.lemma.service.ServicePackage;

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
 *   <li>{@link de.fhdo.lemma.service.impl.ApiParameterCommentImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ApiParameterCommentImpl#isRequired <em>Required</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ApiParameterCommentImpl#isReturned <em>Returned</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ApiParameterCommentImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ApiParameterCommentImpl#getOperationComment <em>Operation Comment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ApiParameterCommentImpl extends MinimalEObjectImpl.Container implements ApiParameterComment {
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
	 * The default value of the '{@link #isReturned() <em>Returned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReturned()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RETURNED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReturned() <em>Returned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReturned()
	 * @generated
	 * @ordered
	 */
	protected boolean returned = RETURNED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected Parameter parameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ApiParameterCommentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicePackage.Literals.API_PARAMETER_COMMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.API_PARAMETER_COMMENT__COMMENT, oldComment, comment));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.API_PARAMETER_COMMENT__REQUIRED, oldRequired, required));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isReturned() {
		return returned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReturned(boolean newReturned) {
		boolean oldReturned = returned;
		returned = newReturned;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.API_PARAMETER_COMMENT__RETURNED, oldReturned, returned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Parameter getParameter() {
		if (parameter != null && parameter.eIsProxy()) {
			InternalEObject oldParameter = (InternalEObject)parameter;
			parameter = (Parameter)eResolveProxy(oldParameter);
			if (parameter != oldParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicePackage.API_PARAMETER_COMMENT__PARAMETER, oldParameter, parameter));
			}
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter basicGetParameter() {
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParameter(Parameter newParameter) {
		Parameter oldParameter = parameter;
		parameter = newParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.API_PARAMETER_COMMENT__PARAMETER, oldParameter, parameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ApiOperationComment getOperationComment() {
		if (eContainerFeatureID() != ServicePackage.API_PARAMETER_COMMENT__OPERATION_COMMENT) return null;
		return (ApiOperationComment)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApiOperationComment basicGetOperationComment() {
		if (eContainerFeatureID() != ServicePackage.API_PARAMETER_COMMENT__OPERATION_COMMENT) return null;
		return (ApiOperationComment)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperationComment(ApiOperationComment newOperationComment, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOperationComment, ServicePackage.API_PARAMETER_COMMENT__OPERATION_COMMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperationComment(ApiOperationComment newOperationComment) {
		if (newOperationComment != eInternalContainer() || (eContainerFeatureID() != ServicePackage.API_PARAMETER_COMMENT__OPERATION_COMMENT && newOperationComment != null)) {
			if (EcoreUtil.isAncestor(this, newOperationComment))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOperationComment != null)
				msgs = ((InternalEObject)newOperationComment).eInverseAdd(this, ServicePackage.API_OPERATION_COMMENT__PARAMETER_COMMENTS, ApiOperationComment.class, msgs);
			msgs = basicSetOperationComment(newOperationComment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.API_PARAMETER_COMMENT__OPERATION_COMMENT, newOperationComment, newOperationComment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicePackage.API_PARAMETER_COMMENT__OPERATION_COMMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOperationComment((ApiOperationComment)otherEnd, msgs);
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
			case ServicePackage.API_PARAMETER_COMMENT__OPERATION_COMMENT:
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
			case ServicePackage.API_PARAMETER_COMMENT__OPERATION_COMMENT:
				return eInternalContainer().eInverseRemove(this, ServicePackage.API_OPERATION_COMMENT__PARAMETER_COMMENTS, ApiOperationComment.class, msgs);
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
			case ServicePackage.API_PARAMETER_COMMENT__COMMENT:
				return getComment();
			case ServicePackage.API_PARAMETER_COMMENT__REQUIRED:
				return isRequired();
			case ServicePackage.API_PARAMETER_COMMENT__RETURNED:
				return isReturned();
			case ServicePackage.API_PARAMETER_COMMENT__PARAMETER:
				if (resolve) return getParameter();
				return basicGetParameter();
			case ServicePackage.API_PARAMETER_COMMENT__OPERATION_COMMENT:
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
			case ServicePackage.API_PARAMETER_COMMENT__COMMENT:
				setComment((String)newValue);
				return;
			case ServicePackage.API_PARAMETER_COMMENT__REQUIRED:
				setRequired((Boolean)newValue);
				return;
			case ServicePackage.API_PARAMETER_COMMENT__RETURNED:
				setReturned((Boolean)newValue);
				return;
			case ServicePackage.API_PARAMETER_COMMENT__PARAMETER:
				setParameter((Parameter)newValue);
				return;
			case ServicePackage.API_PARAMETER_COMMENT__OPERATION_COMMENT:
				setOperationComment((ApiOperationComment)newValue);
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
			case ServicePackage.API_PARAMETER_COMMENT__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case ServicePackage.API_PARAMETER_COMMENT__REQUIRED:
				setRequired(REQUIRED_EDEFAULT);
				return;
			case ServicePackage.API_PARAMETER_COMMENT__RETURNED:
				setReturned(RETURNED_EDEFAULT);
				return;
			case ServicePackage.API_PARAMETER_COMMENT__PARAMETER:
				setParameter((Parameter)null);
				return;
			case ServicePackage.API_PARAMETER_COMMENT__OPERATION_COMMENT:
				setOperationComment((ApiOperationComment)null);
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
			case ServicePackage.API_PARAMETER_COMMENT__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case ServicePackage.API_PARAMETER_COMMENT__REQUIRED:
				return required != REQUIRED_EDEFAULT;
			case ServicePackage.API_PARAMETER_COMMENT__RETURNED:
				return returned != RETURNED_EDEFAULT;
			case ServicePackage.API_PARAMETER_COMMENT__PARAMETER:
				return parameter != null;
			case ServicePackage.API_PARAMETER_COMMENT__OPERATION_COMMENT:
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
		result.append(", returned: ");
		result.append(returned);
		result.append(')');
		return result.toString();
	}

} //ApiParameterCommentImpl
