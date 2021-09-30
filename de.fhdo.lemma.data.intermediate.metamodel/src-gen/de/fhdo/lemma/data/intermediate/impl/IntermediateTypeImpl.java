/**
 */
package de.fhdo.lemma.data.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateDataField;
import de.fhdo.lemma.data.intermediate.IntermediateDataOperationParameter;
import de.fhdo.lemma.data.intermediate.IntermediateDataOperationReturnType;
import de.fhdo.lemma.data.intermediate.IntermediatePackage;
import de.fhdo.lemma.data.intermediate.IntermediateType;
import de.fhdo.lemma.data.intermediate.IntermediateTypeKind;
import de.fhdo.lemma.data.intermediate.IntermediateTypeOrigin;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateTypeImpl#getOrigin <em>Origin</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateTypeImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateTypeImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateTypeImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateTypeImpl#getDataField <em>Data Field</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class IntermediateTypeImpl extends MinimalEObjectImpl.Container implements IntermediateType {
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getOrigin() <em>Origin</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOrigin()
     * @generated
     * @ordered
     */
    protected static final IntermediateTypeOrigin ORIGIN_EDEFAULT = IntermediateTypeOrigin.DUMMY_FOR_XMI_SERIALIZER_BUG;

    /**
     * The cached value of the '{@link #getOrigin() <em>Origin</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOrigin()
     * @generated
     * @ordered
     */
    protected IntermediateTypeOrigin origin = ORIGIN_EDEFAULT;

    /**
     * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getKind()
     * @generated
     * @ordered
     */
    protected static final IntermediateTypeKind KIND_EDEFAULT = IntermediateTypeKind.DUMMY_FOR_XMI_SERIALIZER_BUG;

    /**
     * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getKind()
     * @generated
     * @ordered
     */
    protected IntermediateTypeKind kind = KIND_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IntermediateTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_TYPE__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateTypeOrigin getOrigin() {
        return origin;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOrigin(IntermediateTypeOrigin newOrigin) {
        IntermediateTypeOrigin oldOrigin = origin;
        origin = newOrigin == null ? ORIGIN_EDEFAULT : newOrigin;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_TYPE__ORIGIN, oldOrigin, origin));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateTypeKind getKind() {
        return kind;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setKind(IntermediateTypeKind newKind) {
        IntermediateTypeKind oldKind = kind;
        kind = newKind == null ? KIND_EDEFAULT : newKind;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_TYPE__KIND, oldKind, kind));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataOperationReturnType getReturnType() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_TYPE__RETURN_TYPE) return null;
        return (IntermediateDataOperationReturnType)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataOperationReturnType basicGetReturnType() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_TYPE__RETURN_TYPE) return null;
        return (IntermediateDataOperationReturnType)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetReturnType(IntermediateDataOperationReturnType newReturnType, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newReturnType, IntermediatePackage.INTERMEDIATE_TYPE__RETURN_TYPE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReturnType(IntermediateDataOperationReturnType newReturnType) {
        if (newReturnType != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_TYPE__RETURN_TYPE && newReturnType != null)) {
            if (EcoreUtil.isAncestor(this, newReturnType))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newReturnType != null)
                msgs = ((InternalEObject)newReturnType).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_DATA_OPERATION_RETURN_TYPE__TYPE, IntermediateDataOperationReturnType.class, msgs);
            msgs = basicSetReturnType(newReturnType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_TYPE__RETURN_TYPE, newReturnType, newReturnType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataOperationParameter getParameter() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_TYPE__PARAMETER) return null;
        return (IntermediateDataOperationParameter)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataOperationParameter basicGetParameter() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_TYPE__PARAMETER) return null;
        return (IntermediateDataOperationParameter)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetParameter(IntermediateDataOperationParameter newParameter, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newParameter, IntermediatePackage.INTERMEDIATE_TYPE__PARAMETER, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParameter(IntermediateDataOperationParameter newParameter) {
        if (newParameter != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_TYPE__PARAMETER && newParameter != null)) {
            if (EcoreUtil.isAncestor(this, newParameter))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newParameter != null)
                msgs = ((InternalEObject)newParameter).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__TYPE, IntermediateDataOperationParameter.class, msgs);
            msgs = basicSetParameter(newParameter, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_TYPE__PARAMETER, newParameter, newParameter));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataField getDataField() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_TYPE__DATA_FIELD) return null;
        return (IntermediateDataField)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataField basicGetDataField() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_TYPE__DATA_FIELD) return null;
        return (IntermediateDataField)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDataField(IntermediateDataField newDataField, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newDataField, IntermediatePackage.INTERMEDIATE_TYPE__DATA_FIELD, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDataField(IntermediateDataField newDataField) {
        if (newDataField != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_TYPE__DATA_FIELD && newDataField != null)) {
            if (EcoreUtil.isAncestor(this, newDataField))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newDataField != null)
                msgs = ((InternalEObject)newDataField).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_DATA_FIELD__TYPE, IntermediateDataField.class, msgs);
            msgs = basicSetDataField(newDataField, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_TYPE__DATA_FIELD, newDataField, newDataField));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case IntermediatePackage.INTERMEDIATE_TYPE__RETURN_TYPE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetReturnType((IntermediateDataOperationReturnType)otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_TYPE__PARAMETER:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetParameter((IntermediateDataOperationParameter)otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_TYPE__DATA_FIELD:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetDataField((IntermediateDataField)otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_TYPE__RETURN_TYPE:
                return basicSetReturnType(null, msgs);
            case IntermediatePackage.INTERMEDIATE_TYPE__PARAMETER:
                return basicSetParameter(null, msgs);
            case IntermediatePackage.INTERMEDIATE_TYPE__DATA_FIELD:
                return basicSetDataField(null, msgs);
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
            case IntermediatePackage.INTERMEDIATE_TYPE__RETURN_TYPE:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_DATA_OPERATION_RETURN_TYPE__TYPE, IntermediateDataOperationReturnType.class, msgs);
            case IntermediatePackage.INTERMEDIATE_TYPE__PARAMETER:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_DATA_OPERATION_PARAMETER__TYPE, IntermediateDataOperationParameter.class, msgs);
            case IntermediatePackage.INTERMEDIATE_TYPE__DATA_FIELD:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_DATA_FIELD__TYPE, IntermediateDataField.class, msgs);
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
            case IntermediatePackage.INTERMEDIATE_TYPE__NAME:
                return getName();
            case IntermediatePackage.INTERMEDIATE_TYPE__ORIGIN:
                return getOrigin();
            case IntermediatePackage.INTERMEDIATE_TYPE__KIND:
                return getKind();
            case IntermediatePackage.INTERMEDIATE_TYPE__RETURN_TYPE:
                if (resolve) return getReturnType();
                return basicGetReturnType();
            case IntermediatePackage.INTERMEDIATE_TYPE__PARAMETER:
                if (resolve) return getParameter();
                return basicGetParameter();
            case IntermediatePackage.INTERMEDIATE_TYPE__DATA_FIELD:
                if (resolve) return getDataField();
                return basicGetDataField();
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
            case IntermediatePackage.INTERMEDIATE_TYPE__NAME:
                setName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_TYPE__ORIGIN:
                setOrigin((IntermediateTypeOrigin)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_TYPE__KIND:
                setKind((IntermediateTypeKind)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_TYPE__RETURN_TYPE:
                setReturnType((IntermediateDataOperationReturnType)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_TYPE__PARAMETER:
                setParameter((IntermediateDataOperationParameter)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_TYPE__DATA_FIELD:
                setDataField((IntermediateDataField)newValue);
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
            case IntermediatePackage.INTERMEDIATE_TYPE__NAME:
                setName(NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_TYPE__ORIGIN:
                setOrigin(ORIGIN_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_TYPE__KIND:
                setKind(KIND_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_TYPE__RETURN_TYPE:
                setReturnType((IntermediateDataOperationReturnType)null);
                return;
            case IntermediatePackage.INTERMEDIATE_TYPE__PARAMETER:
                setParameter((IntermediateDataOperationParameter)null);
                return;
            case IntermediatePackage.INTERMEDIATE_TYPE__DATA_FIELD:
                setDataField((IntermediateDataField)null);
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
            case IntermediatePackage.INTERMEDIATE_TYPE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case IntermediatePackage.INTERMEDIATE_TYPE__ORIGIN:
                return origin != ORIGIN_EDEFAULT;
            case IntermediatePackage.INTERMEDIATE_TYPE__KIND:
                return kind != KIND_EDEFAULT;
            case IntermediatePackage.INTERMEDIATE_TYPE__RETURN_TYPE:
                return basicGetReturnType() != null;
            case IntermediatePackage.INTERMEDIATE_TYPE__PARAMETER:
                return basicGetParameter() != null;
            case IntermediatePackage.INTERMEDIATE_TYPE__DATA_FIELD:
                return basicGetDataField() != null;
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
        result.append(" (name: ");
        result.append(name);
        result.append(", origin: ");
        result.append(origin);
        result.append(", kind: ");
        result.append(kind);
        result.append(')');
        return result.toString();
    }

} //IntermediateTypeImpl
