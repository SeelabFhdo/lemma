/**
 */
package de.fhdo.ddmm.data.impl;

import de.fhdo.ddmm.data.ComplexTypeImport;
import de.fhdo.ddmm.data.DataModel;
import de.fhdo.ddmm.data.DataPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Type Import</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.data.impl.ComplexTypeImportImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.impl.ComplexTypeImportImpl#getImportURI <em>Import URI</em>}</li>
 *   <li>{@link de.fhdo.ddmm.data.impl.ComplexTypeImportImpl#getDataModel <em>Data Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComplexTypeImportImpl extends MinimalEObjectImpl.Container implements ComplexTypeImport {
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
     * The default value of the '{@link #getImportURI() <em>Import URI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImportURI()
     * @generated
     * @ordered
     */
    protected static final String IMPORT_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getImportURI() <em>Import URI</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImportURI()
     * @generated
     * @ordered
     */
    protected String importURI = IMPORT_URI_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ComplexTypeImportImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DataPackage.Literals.COMPLEX_TYPE_IMPORT;
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
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.COMPLEX_TYPE_IMPORT__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getImportURI() {
        return importURI;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setImportURI(String newImportURI) {
        String oldImportURI = importURI;
        importURI = newImportURI;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.COMPLEX_TYPE_IMPORT__IMPORT_URI, oldImportURI, importURI));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DataModel getDataModel() {
        if (eContainerFeatureID() != DataPackage.COMPLEX_TYPE_IMPORT__DATA_MODEL) return null;
        return (DataModel)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataModel basicGetDataModel() {
        if (eContainerFeatureID() != DataPackage.COMPLEX_TYPE_IMPORT__DATA_MODEL) return null;
        return (DataModel)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDataModel(DataModel newDataModel, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newDataModel, DataPackage.COMPLEX_TYPE_IMPORT__DATA_MODEL, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setDataModel(DataModel newDataModel) {
        if (newDataModel != eInternalContainer() || (eContainerFeatureID() != DataPackage.COMPLEX_TYPE_IMPORT__DATA_MODEL && newDataModel != null)) {
            if (EcoreUtil.isAncestor(this, newDataModel))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newDataModel != null)
                msgs = ((InternalEObject)newDataModel).eInverseAdd(this, DataPackage.DATA_MODEL__COMPLEX_TYPE_IMPORTS, DataModel.class, msgs);
            msgs = basicSetDataModel(newDataModel, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.COMPLEX_TYPE_IMPORT__DATA_MODEL, newDataModel, newDataModel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case DataPackage.COMPLEX_TYPE_IMPORT__DATA_MODEL:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetDataModel((DataModel)otherEnd, msgs);
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
            case DataPackage.COMPLEX_TYPE_IMPORT__DATA_MODEL:
                return basicSetDataModel(null, msgs);
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
            case DataPackage.COMPLEX_TYPE_IMPORT__DATA_MODEL:
                return eInternalContainer().eInverseRemove(this, DataPackage.DATA_MODEL__COMPLEX_TYPE_IMPORTS, DataModel.class, msgs);
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
            case DataPackage.COMPLEX_TYPE_IMPORT__NAME:
                return getName();
            case DataPackage.COMPLEX_TYPE_IMPORT__IMPORT_URI:
                return getImportURI();
            case DataPackage.COMPLEX_TYPE_IMPORT__DATA_MODEL:
                if (resolve) return getDataModel();
                return basicGetDataModel();
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
            case DataPackage.COMPLEX_TYPE_IMPORT__NAME:
                setName((String)newValue);
                return;
            case DataPackage.COMPLEX_TYPE_IMPORT__IMPORT_URI:
                setImportURI((String)newValue);
                return;
            case DataPackage.COMPLEX_TYPE_IMPORT__DATA_MODEL:
                setDataModel((DataModel)newValue);
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
            case DataPackage.COMPLEX_TYPE_IMPORT__NAME:
                setName(NAME_EDEFAULT);
                return;
            case DataPackage.COMPLEX_TYPE_IMPORT__IMPORT_URI:
                setImportURI(IMPORT_URI_EDEFAULT);
                return;
            case DataPackage.COMPLEX_TYPE_IMPORT__DATA_MODEL:
                setDataModel((DataModel)null);
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
            case DataPackage.COMPLEX_TYPE_IMPORT__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case DataPackage.COMPLEX_TYPE_IMPORT__IMPORT_URI:
                return IMPORT_URI_EDEFAULT == null ? importURI != null : !IMPORT_URI_EDEFAULT.equals(importURI);
            case DataPackage.COMPLEX_TYPE_IMPORT__DATA_MODEL:
                return basicGetDataModel() != null;
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
        result.append(", importURI: ");
        result.append(importURI);
        result.append(')');
        return result.toString();
    }

} //ComplexTypeImportImpl
