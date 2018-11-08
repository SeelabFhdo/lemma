/**
 */
package de.fhdo.ddmm.data.impl;

import de.fhdo.ddmm.data.ComplexType;
import de.fhdo.ddmm.data.ComplexTypeImport;
import de.fhdo.ddmm.data.DataField;
import de.fhdo.ddmm.data.DataPackage;
import de.fhdo.ddmm.data.PossiblyImportedComplexType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Possibly Imported Complex Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.data.impl.PossiblyImportedComplexTypeImpl#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.impl.PossiblyImportedComplexTypeImpl#getComplexType <em>Complex Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.impl.PossiblyImportedComplexTypeImpl#getDataField <em>Data Field</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PossiblyImportedComplexTypeImpl extends MinimalEObjectImpl.Container implements PossiblyImportedComplexType {
    /**
     * The cached value of the '{@link #getImport() <em>Import</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImport()
     * @generated
     * @ordered
     */
    protected ComplexTypeImport import_;

    /**
     * The cached value of the '{@link #getComplexType() <em>Complex Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getComplexType()
     * @generated
     * @ordered
     */
    protected ComplexType complexType;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PossiblyImportedComplexTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DataPackage.Literals.POSSIBLY_IMPORTED_COMPLEX_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComplexTypeImport getImport() {
        if (import_ != null && import_.eIsProxy()) {
            InternalEObject oldImport = (InternalEObject)import_;
            import_ = (ComplexTypeImport)eResolveProxy(oldImport);
            if (import_ != oldImport) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__IMPORT, oldImport, import_));
            }
        }
        return import_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComplexTypeImport basicGetImport() {
        return import_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setImport(ComplexTypeImport newImport) {
        ComplexTypeImport oldImport = import_;
        import_ = newImport;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__IMPORT, oldImport, import_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComplexType getComplexType() {
        if (complexType != null && complexType.eIsProxy()) {
            InternalEObject oldComplexType = (InternalEObject)complexType;
            complexType = (ComplexType)eResolveProxy(oldComplexType);
            if (complexType != oldComplexType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__COMPLEX_TYPE, oldComplexType, complexType));
            }
        }
        return complexType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComplexType basicGetComplexType() {
        return complexType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setComplexType(ComplexType newComplexType) {
        ComplexType oldComplexType = complexType;
        complexType = newComplexType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__COMPLEX_TYPE, oldComplexType, complexType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataField getDataField() {
        if (eContainerFeatureID() != DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__DATA_FIELD) return null;
        return (DataField)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataField basicGetDataField() {
        if (eContainerFeatureID() != DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__DATA_FIELD) return null;
        return (DataField)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDataField(DataField newDataField, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newDataField, DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__DATA_FIELD, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDataField(DataField newDataField) {
        if (newDataField != eInternalContainer() || (eContainerFeatureID() != DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__DATA_FIELD && newDataField != null)) {
            if (EcoreUtil.isAncestor(this, newDataField))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newDataField != null)
                msgs = ((InternalEObject)newDataField).eInverseAdd(this, DataPackage.DATA_FIELD__COMPLEX_TYPE, DataField.class, msgs);
            msgs = basicSetDataField(newDataField, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__DATA_FIELD, newDataField, newDataField));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__DATA_FIELD:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetDataField((DataField)otherEnd, msgs);
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
            case DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__DATA_FIELD:
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
            case DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__DATA_FIELD:
                return eInternalContainer().eInverseRemove(this, DataPackage.DATA_FIELD__COMPLEX_TYPE, DataField.class, msgs);
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
            case DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__IMPORT:
                if (resolve) return getImport();
                return basicGetImport();
            case DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__COMPLEX_TYPE:
                if (resolve) return getComplexType();
                return basicGetComplexType();
            case DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__DATA_FIELD:
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
            case DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__IMPORT:
                setImport((ComplexTypeImport)newValue);
                return;
            case DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__COMPLEX_TYPE:
                setComplexType((ComplexType)newValue);
                return;
            case DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__DATA_FIELD:
                setDataField((DataField)newValue);
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
            case DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__IMPORT:
                setImport((ComplexTypeImport)null);
                return;
            case DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__COMPLEX_TYPE:
                setComplexType((ComplexType)null);
                return;
            case DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__DATA_FIELD:
                setDataField((DataField)null);
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
            case DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__IMPORT:
                return import_ != null;
            case DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__COMPLEX_TYPE:
                return complexType != null;
            case DataPackage.POSSIBLY_IMPORTED_COMPLEX_TYPE__DATA_FIELD:
                return basicGetDataField() != null;
        }
        return super.eIsSet(featureID);
    }

} //PossiblyImportedComplexTypeImpl
