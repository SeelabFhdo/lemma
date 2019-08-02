/**
 */
package de.fhdo.lemma.service.intermediate.impl;

import de.fhdo.lemma.service.intermediate.IntermediateApiOperationComment;
import de.fhdo.lemma.service.intermediate.IntermediateApiParameterComment;
import de.fhdo.lemma.service.intermediate.IntermediateOperation;
import de.fhdo.lemma.service.intermediate.IntermediatePackage;

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
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateApiOperationCommentImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateApiOperationCommentImpl#getParameterComments <em>Parameter Comments</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateApiOperationCommentImpl#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateApiOperationCommentImpl extends MinimalEObjectImpl.Container implements IntermediateApiOperationComment {
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
    protected EList<IntermediateApiParameterComment> parameterComments;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IntermediateApiOperationCommentImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_API_OPERATION_COMMENT;
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__COMMENT, oldComment, comment));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<IntermediateApiParameterComment> getParameterComments() {
        if (parameterComments == null) {
            parameterComments = new EObjectContainmentWithInverseEList<IntermediateApiParameterComment>(IntermediateApiParameterComment.class, this, IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__PARAMETER_COMMENTS, IntermediatePackage.INTERMEDIATE_API_PARAMETER_COMMENT__OPERATION_COMMENT);
        }
        return parameterComments;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntermediateOperation getOperation() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__OPERATION) return null;
        return (IntermediateOperation)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateOperation basicGetOperation() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__OPERATION) return null;
        return (IntermediateOperation)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOperation(IntermediateOperation newOperation, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOperation, IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__OPERATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setOperation(IntermediateOperation newOperation) {
        if (newOperation != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__OPERATION && newOperation != null)) {
            if (EcoreUtil.isAncestor(this, newOperation))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOperation != null)
                msgs = ((InternalEObject)newOperation).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_OPERATION__API_OPERATION_COMMENT, IntermediateOperation.class, msgs);
            msgs = basicSetOperation(newOperation, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__OPERATION, newOperation, newOperation));
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
            case IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__PARAMETER_COMMENTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameterComments()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__OPERATION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOperation((IntermediateOperation)otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__PARAMETER_COMMENTS:
                return ((InternalEList<?>)getParameterComments()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__OPERATION:
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
            case IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__OPERATION:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_OPERATION__API_OPERATION_COMMENT, IntermediateOperation.class, msgs);
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
            case IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__COMMENT:
                return getComment();
            case IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__PARAMETER_COMMENTS:
                return getParameterComments();
            case IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__OPERATION:
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
            case IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__COMMENT:
                setComment((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__PARAMETER_COMMENTS:
                getParameterComments().clear();
                getParameterComments().addAll((Collection<? extends IntermediateApiParameterComment>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__OPERATION:
                setOperation((IntermediateOperation)newValue);
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
            case IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__COMMENT:
                setComment(COMMENT_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__PARAMETER_COMMENTS:
                getParameterComments().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__OPERATION:
                setOperation((IntermediateOperation)null);
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
            case IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__COMMENT:
                return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
            case IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__PARAMETER_COMMENTS:
                return parameterComments != null && !parameterComments.isEmpty();
            case IntermediatePackage.INTERMEDIATE_API_OPERATION_COMMENT__OPERATION:
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

} //IntermediateApiOperationCommentImpl
