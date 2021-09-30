/**
 */
package de.fhdo.lemma.data.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateDataField;
import de.fhdo.lemma.data.intermediate.IntermediateEnumerationField;
import de.fhdo.lemma.data.intermediate.IntermediatePackage;
import de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediatePrimitiveTypeImpl#getSize <em>Size</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediatePrimitiveTypeImpl#getInitializedDataField <em>Initialized Data Field</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediatePrimitiveTypeImpl#getInitializedEnumerationField <em>Initialized Enumeration Field</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediatePrimitiveTypeImpl extends IntermediateTypeImpl implements IntermediatePrimitiveType {
    /**
     * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSize()
     * @generated
     * @ordered
     */
    protected static final Integer SIZE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSize()
     * @generated
     * @ordered
     */
    protected Integer size = SIZE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IntermediatePrimitiveTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_PRIMITIVE_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer getSize() {
        return size;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSize(Integer newSize) {
        Integer oldSize = size;
        size = newSize;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__SIZE, oldSize, size));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataField getInitializedDataField() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_DATA_FIELD) return null;
        return (IntermediateDataField)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataField basicGetInitializedDataField() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_DATA_FIELD) return null;
        return (IntermediateDataField)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInitializedDataField(IntermediateDataField newInitializedDataField, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newInitializedDataField, IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_DATA_FIELD, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInitializedDataField(IntermediateDataField newInitializedDataField) {
        if (newInitializedDataField != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_DATA_FIELD && newInitializedDataField != null)) {
            if (EcoreUtil.isAncestor(this, newInitializedDataField))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newInitializedDataField != null)
                msgs = ((InternalEObject)newInitializedDataField).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_DATA_FIELD__INITIALIZATION_VALUE_COMPATIBLE_TYPES, IntermediateDataField.class, msgs);
            msgs = basicSetInitializedDataField(newInitializedDataField, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_DATA_FIELD, newInitializedDataField, newInitializedDataField));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateEnumerationField getInitializedEnumerationField() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_ENUMERATION_FIELD) return null;
        return (IntermediateEnumerationField)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateEnumerationField basicGetInitializedEnumerationField() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_ENUMERATION_FIELD) return null;
        return (IntermediateEnumerationField)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInitializedEnumerationField(IntermediateEnumerationField newInitializedEnumerationField, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newInitializedEnumerationField, IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_ENUMERATION_FIELD, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInitializedEnumerationField(IntermediateEnumerationField newInitializedEnumerationField) {
        if (newInitializedEnumerationField != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_ENUMERATION_FIELD && newInitializedEnumerationField != null)) {
            if (EcoreUtil.isAncestor(this, newInitializedEnumerationField))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newInitializedEnumerationField != null)
                msgs = ((InternalEObject)newInitializedEnumerationField).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__INITIALIZATION_VALUE_COMPATIBLE_TYPES, IntermediateEnumerationField.class, msgs);
            msgs = basicSetInitializedEnumerationField(newInitializedEnumerationField, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_ENUMERATION_FIELD, newInitializedEnumerationField, newInitializedEnumerationField));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_DATA_FIELD:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetInitializedDataField((IntermediateDataField)otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_ENUMERATION_FIELD:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetInitializedEnumerationField((IntermediateEnumerationField)otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_DATA_FIELD:
                return basicSetInitializedDataField(null, msgs);
            case IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_ENUMERATION_FIELD:
                return basicSetInitializedEnumerationField(null, msgs);
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
            case IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_DATA_FIELD:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_DATA_FIELD__INITIALIZATION_VALUE_COMPATIBLE_TYPES, IntermediateDataField.class, msgs);
            case IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_ENUMERATION_FIELD:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__INITIALIZATION_VALUE_COMPATIBLE_TYPES, IntermediateEnumerationField.class, msgs);
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
            case IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__SIZE:
                return getSize();
            case IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_DATA_FIELD:
                if (resolve) return getInitializedDataField();
                return basicGetInitializedDataField();
            case IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_ENUMERATION_FIELD:
                if (resolve) return getInitializedEnumerationField();
                return basicGetInitializedEnumerationField();
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
            case IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__SIZE:
                setSize((Integer)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_DATA_FIELD:
                setInitializedDataField((IntermediateDataField)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_ENUMERATION_FIELD:
                setInitializedEnumerationField((IntermediateEnumerationField)newValue);
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
            case IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__SIZE:
                setSize(SIZE_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_DATA_FIELD:
                setInitializedDataField((IntermediateDataField)null);
                return;
            case IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_ENUMERATION_FIELD:
                setInitializedEnumerationField((IntermediateEnumerationField)null);
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
            case IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__SIZE:
                return SIZE_EDEFAULT == null ? size != null : !SIZE_EDEFAULT.equals(size);
            case IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_DATA_FIELD:
                return basicGetInitializedDataField() != null;
            case IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_ENUMERATION_FIELD:
                return basicGetInitializedEnumerationField() != null;
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
        result.append(" (size: ");
        result.append(size);
        result.append(')');
        return result.toString();
    }

} //IntermediatePrimitiveTypeImpl
