/**
 */
package de.fhdo.ddmm.data.intermediate.impl;

import de.fhdo.ddmm.data.intermediate.IntermediateDataField;
import de.fhdo.ddmm.data.intermediate.IntermediatePackage;
import de.fhdo.ddmm.data.intermediate.IntermediateType;
import de.fhdo.ddmm.data.intermediate.IntermediateTypeKind;
import de.fhdo.ddmm.data.intermediate.IntermediateTypeOrigin;

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
 *   <li>{@link de.fhdo.ddmm.data.intermediate.impl.IntermediateTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.intermediate.impl.IntermediateTypeImpl#getOrigin <em>Origin</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.intermediate.impl.IntermediateTypeImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.intermediate.impl.IntermediateTypeImpl#getDataField <em>Data Field</em>}</li>
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
    @Override
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
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
    @Override
    public IntermediateTypeOrigin getOrigin() {
        return origin;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
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
    @Override
    public IntermediateTypeKind getKind() {
        return kind;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
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
    @Override
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
    @Override
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
