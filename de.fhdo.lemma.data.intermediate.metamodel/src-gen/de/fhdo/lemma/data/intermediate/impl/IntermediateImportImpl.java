/**
 */
package de.fhdo.lemma.data.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateDataModel;
import de.fhdo.lemma.data.intermediate.IntermediateImport;
import de.fhdo.lemma.data.intermediate.IntermediatePackage;

import de.fhdo.lemma.service.ImportType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Import</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateImportImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateImportImpl#getImportUri <em>Import Uri</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateImportImpl#getImportTypeName <em>Import Type Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateImportImpl#getDataModel <em>Data Model</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateImportImpl#getImportTypeNameForDatatypes <em>Import Type Name For Datatypes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateImportImpl extends MinimalEObjectImpl.Container implements IntermediateImport {
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
     * The default value of the '{@link #getImportUri() <em>Import Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImportUri()
     * @generated
     * @ordered
     */
    protected static final String IMPORT_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getImportUri() <em>Import Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImportUri()
     * @generated
     * @ordered
     */
    protected String importUri = IMPORT_URI_EDEFAULT;

    /**
     * The default value of the '{@link #getImportTypeName() <em>Import Type Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImportTypeName()
     * @generated
     * @ordered
     */
    protected static final String IMPORT_TYPE_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getImportTypeName() <em>Import Type Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImportTypeName()
     * @generated
     * @ordered
     */
    protected String importTypeName = IMPORT_TYPE_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getImportTypeNameForDatatypes() <em>Import Type Name For Datatypes</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImportTypeNameForDatatypes()
     * @generated
     * @ordered
     */
    protected static final String IMPORT_TYPE_NAME_FOR_DATATYPES_EDEFAULT = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IntermediateImportImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_IMPORT;
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_IMPORT__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getImportUri() {
        return importUri;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setImportUri(String newImportUri) {
        String oldImportUri = importUri;
        importUri = newImportUri;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_IMPORT__IMPORT_URI, oldImportUri, importUri));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getImportTypeName() {
        return importTypeName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setImportTypeName(String newImportTypeName) {
        String oldImportTypeName = importTypeName;
        importTypeName = newImportTypeName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_IMPORT__IMPORT_TYPE_NAME, oldImportTypeName, importTypeName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataModel getDataModel() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORT__DATA_MODEL) return null;
        return (IntermediateDataModel)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataModel basicGetDataModel() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORT__DATA_MODEL) return null;
        return (IntermediateDataModel)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDataModel(IntermediateDataModel newDataModel, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newDataModel, IntermediatePackage.INTERMEDIATE_IMPORT__DATA_MODEL, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDataModel(IntermediateDataModel newDataModel) {
        if (newDataModel != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_IMPORT__DATA_MODEL && newDataModel != null)) {
            if (EcoreUtil.isAncestor(this, newDataModel))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newDataModel != null)
                msgs = ((InternalEObject)newDataModel).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_DATA_MODEL__IMPORTS, IntermediateDataModel.class, msgs);
            msgs = basicSetDataModel(newDataModel, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_IMPORT__DATA_MODEL, newDataModel, newDataModel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getImportTypeNameForDatatypes() {
        return ImportType.DATATYPES.getLiteral();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case IntermediatePackage.INTERMEDIATE_IMPORT__DATA_MODEL:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetDataModel((IntermediateDataModel)otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_IMPORT__DATA_MODEL:
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
            case IntermediatePackage.INTERMEDIATE_IMPORT__DATA_MODEL:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_DATA_MODEL__IMPORTS, IntermediateDataModel.class, msgs);
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
            case IntermediatePackage.INTERMEDIATE_IMPORT__NAME:
                return getName();
            case IntermediatePackage.INTERMEDIATE_IMPORT__IMPORT_URI:
                return getImportUri();
            case IntermediatePackage.INTERMEDIATE_IMPORT__IMPORT_TYPE_NAME:
                return getImportTypeName();
            case IntermediatePackage.INTERMEDIATE_IMPORT__DATA_MODEL:
                if (resolve) return getDataModel();
                return basicGetDataModel();
            case IntermediatePackage.INTERMEDIATE_IMPORT__IMPORT_TYPE_NAME_FOR_DATATYPES:
                return getImportTypeNameForDatatypes();
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
            case IntermediatePackage.INTERMEDIATE_IMPORT__NAME:
                setName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORT__IMPORT_URI:
                setImportUri((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORT__IMPORT_TYPE_NAME:
                setImportTypeName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORT__DATA_MODEL:
                setDataModel((IntermediateDataModel)newValue);
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
            case IntermediatePackage.INTERMEDIATE_IMPORT__NAME:
                setName(NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORT__IMPORT_URI:
                setImportUri(IMPORT_URI_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORT__IMPORT_TYPE_NAME:
                setImportTypeName(IMPORT_TYPE_NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_IMPORT__DATA_MODEL:
                setDataModel((IntermediateDataModel)null);
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
            case IntermediatePackage.INTERMEDIATE_IMPORT__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case IntermediatePackage.INTERMEDIATE_IMPORT__IMPORT_URI:
                return IMPORT_URI_EDEFAULT == null ? importUri != null : !IMPORT_URI_EDEFAULT.equals(importUri);
            case IntermediatePackage.INTERMEDIATE_IMPORT__IMPORT_TYPE_NAME:
                return IMPORT_TYPE_NAME_EDEFAULT == null ? importTypeName != null : !IMPORT_TYPE_NAME_EDEFAULT.equals(importTypeName);
            case IntermediatePackage.INTERMEDIATE_IMPORT__DATA_MODEL:
                return basicGetDataModel() != null;
            case IntermediatePackage.INTERMEDIATE_IMPORT__IMPORT_TYPE_NAME_FOR_DATATYPES:
                return IMPORT_TYPE_NAME_FOR_DATATYPES_EDEFAULT == null ? getImportTypeNameForDatatypes() != null : !IMPORT_TYPE_NAME_FOR_DATATYPES_EDEFAULT.equals(getImportTypeNameForDatatypes());
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
        result.append(", importUri: ");
        result.append(importUri);
        result.append(", importTypeName: ");
        result.append(importTypeName);
        result.append(')');
        return result.toString();
    }

} //IntermediateImportImpl
