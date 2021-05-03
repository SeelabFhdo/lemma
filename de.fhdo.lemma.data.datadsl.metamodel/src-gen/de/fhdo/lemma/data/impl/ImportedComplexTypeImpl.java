/**
 */
package de.fhdo.lemma.data.impl;

import de.fhdo.lemma.data.ComplexTypeImport;
import de.fhdo.lemma.data.DataField;
import de.fhdo.lemma.data.DataOperation;
import de.fhdo.lemma.data.DataOperationParameter;
import de.fhdo.lemma.data.DataPackage;
import de.fhdo.lemma.data.ImportedComplexType;
import de.fhdo.lemma.data.Type;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Imported Complex Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.impl.ImportedComplexTypeImpl#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.ImportedComplexTypeImpl#getImportedType <em>Imported Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.ImportedComplexTypeImpl#getDataField <em>Data Field</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.ImportedComplexTypeImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.ImportedComplexTypeImpl#getParameter <em>Parameter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImportedComplexTypeImpl extends MinimalEObjectImpl.Container implements ImportedComplexType {
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
     * The cached value of the '{@link #getImportedType() <em>Imported Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImportedType()
     * @generated
     * @ordered
     */
    protected Type importedType;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ImportedComplexTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DataPackage.Literals.IMPORTED_COMPLEX_TYPE;
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataPackage.IMPORTED_COMPLEX_TYPE__IMPORT, oldImport, import_));
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
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.IMPORTED_COMPLEX_TYPE__IMPORT, oldImport, import_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Type getImportedType() {
        if (importedType != null && importedType.eIsProxy()) {
            InternalEObject oldImportedType = (InternalEObject)importedType;
            importedType = (Type)eResolveProxy(oldImportedType);
            if (importedType != oldImportedType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataPackage.IMPORTED_COMPLEX_TYPE__IMPORTED_TYPE, oldImportedType, importedType));
            }
        }
        return importedType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Type basicGetImportedType() {
        return importedType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setImportedType(Type newImportedType) {
        Type oldImportedType = importedType;
        importedType = newImportedType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.IMPORTED_COMPLEX_TYPE__IMPORTED_TYPE, oldImportedType, importedType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataField getDataField() {
        if (eContainerFeatureID() != DataPackage.IMPORTED_COMPLEX_TYPE__DATA_FIELD) return null;
        return (DataField)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataField basicGetDataField() {
        if (eContainerFeatureID() != DataPackage.IMPORTED_COMPLEX_TYPE__DATA_FIELD) return null;
        return (DataField)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDataField(DataField newDataField, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newDataField, DataPackage.IMPORTED_COMPLEX_TYPE__DATA_FIELD, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDataField(DataField newDataField) {
        if (newDataField != eInternalContainer() || (eContainerFeatureID() != DataPackage.IMPORTED_COMPLEX_TYPE__DATA_FIELD && newDataField != null)) {
            if (EcoreUtil.isAncestor(this, newDataField))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newDataField != null)
                msgs = ((InternalEObject)newDataField).eInverseAdd(this, DataPackage.DATA_FIELD__IMPORTED_COMPLEX_TYPE, DataField.class, msgs);
            msgs = basicSetDataField(newDataField, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.IMPORTED_COMPLEX_TYPE__DATA_FIELD, newDataField, newDataField));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataOperation getOperation() {
        if (eContainerFeatureID() != DataPackage.IMPORTED_COMPLEX_TYPE__OPERATION) return null;
        return (DataOperation)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataOperation basicGetOperation() {
        if (eContainerFeatureID() != DataPackage.IMPORTED_COMPLEX_TYPE__OPERATION) return null;
        return (DataOperation)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOperation(DataOperation newOperation, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOperation, DataPackage.IMPORTED_COMPLEX_TYPE__OPERATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOperation(DataOperation newOperation) {
        if (newOperation != eInternalContainer() || (eContainerFeatureID() != DataPackage.IMPORTED_COMPLEX_TYPE__OPERATION && newOperation != null)) {
            if (EcoreUtil.isAncestor(this, newOperation))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOperation != null)
                msgs = ((InternalEObject)newOperation).eInverseAdd(this, DataPackage.DATA_OPERATION__IMPORTED_COMPLEX_RETURN_TYPE, DataOperation.class, msgs);
            msgs = basicSetOperation(newOperation, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.IMPORTED_COMPLEX_TYPE__OPERATION, newOperation, newOperation));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataOperationParameter getParameter() {
        if (eContainerFeatureID() != DataPackage.IMPORTED_COMPLEX_TYPE__PARAMETER) return null;
        return (DataOperationParameter)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataOperationParameter basicGetParameter() {
        if (eContainerFeatureID() != DataPackage.IMPORTED_COMPLEX_TYPE__PARAMETER) return null;
        return (DataOperationParameter)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetParameter(DataOperationParameter newParameter, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newParameter, DataPackage.IMPORTED_COMPLEX_TYPE__PARAMETER, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParameter(DataOperationParameter newParameter) {
        if (newParameter != eInternalContainer() || (eContainerFeatureID() != DataPackage.IMPORTED_COMPLEX_TYPE__PARAMETER && newParameter != null)) {
            if (EcoreUtil.isAncestor(this, newParameter))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newParameter != null)
                msgs = ((InternalEObject)newParameter).eInverseAdd(this, DataPackage.DATA_OPERATION_PARAMETER__IMPORTED_COMPLEX_TYPE, DataOperationParameter.class, msgs);
            msgs = basicSetParameter(newParameter, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.IMPORTED_COMPLEX_TYPE__PARAMETER, newParameter, newParameter));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case DataPackage.IMPORTED_COMPLEX_TYPE__DATA_FIELD:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetDataField((DataField)otherEnd, msgs);
            case DataPackage.IMPORTED_COMPLEX_TYPE__OPERATION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOperation((DataOperation)otherEnd, msgs);
            case DataPackage.IMPORTED_COMPLEX_TYPE__PARAMETER:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetParameter((DataOperationParameter)otherEnd, msgs);
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
            case DataPackage.IMPORTED_COMPLEX_TYPE__DATA_FIELD:
                return basicSetDataField(null, msgs);
            case DataPackage.IMPORTED_COMPLEX_TYPE__OPERATION:
                return basicSetOperation(null, msgs);
            case DataPackage.IMPORTED_COMPLEX_TYPE__PARAMETER:
                return basicSetParameter(null, msgs);
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
            case DataPackage.IMPORTED_COMPLEX_TYPE__DATA_FIELD:
                return eInternalContainer().eInverseRemove(this, DataPackage.DATA_FIELD__IMPORTED_COMPLEX_TYPE, DataField.class, msgs);
            case DataPackage.IMPORTED_COMPLEX_TYPE__OPERATION:
                return eInternalContainer().eInverseRemove(this, DataPackage.DATA_OPERATION__IMPORTED_COMPLEX_RETURN_TYPE, DataOperation.class, msgs);
            case DataPackage.IMPORTED_COMPLEX_TYPE__PARAMETER:
                return eInternalContainer().eInverseRemove(this, DataPackage.DATA_OPERATION_PARAMETER__IMPORTED_COMPLEX_TYPE, DataOperationParameter.class, msgs);
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
            case DataPackage.IMPORTED_COMPLEX_TYPE__IMPORT:
                if (resolve) return getImport();
                return basicGetImport();
            case DataPackage.IMPORTED_COMPLEX_TYPE__IMPORTED_TYPE:
                if (resolve) return getImportedType();
                return basicGetImportedType();
            case DataPackage.IMPORTED_COMPLEX_TYPE__DATA_FIELD:
                if (resolve) return getDataField();
                return basicGetDataField();
            case DataPackage.IMPORTED_COMPLEX_TYPE__OPERATION:
                if (resolve) return getOperation();
                return basicGetOperation();
            case DataPackage.IMPORTED_COMPLEX_TYPE__PARAMETER:
                if (resolve) return getParameter();
                return basicGetParameter();
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
            case DataPackage.IMPORTED_COMPLEX_TYPE__IMPORT:
                setImport((ComplexTypeImport)newValue);
                return;
            case DataPackage.IMPORTED_COMPLEX_TYPE__IMPORTED_TYPE:
                setImportedType((Type)newValue);
                return;
            case DataPackage.IMPORTED_COMPLEX_TYPE__DATA_FIELD:
                setDataField((DataField)newValue);
                return;
            case DataPackage.IMPORTED_COMPLEX_TYPE__OPERATION:
                setOperation((DataOperation)newValue);
                return;
            case DataPackage.IMPORTED_COMPLEX_TYPE__PARAMETER:
                setParameter((DataOperationParameter)newValue);
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
            case DataPackage.IMPORTED_COMPLEX_TYPE__IMPORT:
                setImport((ComplexTypeImport)null);
                return;
            case DataPackage.IMPORTED_COMPLEX_TYPE__IMPORTED_TYPE:
                setImportedType((Type)null);
                return;
            case DataPackage.IMPORTED_COMPLEX_TYPE__DATA_FIELD:
                setDataField((DataField)null);
                return;
            case DataPackage.IMPORTED_COMPLEX_TYPE__OPERATION:
                setOperation((DataOperation)null);
                return;
            case DataPackage.IMPORTED_COMPLEX_TYPE__PARAMETER:
                setParameter((DataOperationParameter)null);
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
            case DataPackage.IMPORTED_COMPLEX_TYPE__IMPORT:
                return import_ != null;
            case DataPackage.IMPORTED_COMPLEX_TYPE__IMPORTED_TYPE:
                return importedType != null;
            case DataPackage.IMPORTED_COMPLEX_TYPE__DATA_FIELD:
                return basicGetDataField() != null;
            case DataPackage.IMPORTED_COMPLEX_TYPE__OPERATION:
                return basicGetOperation() != null;
            case DataPackage.IMPORTED_COMPLEX_TYPE__PARAMETER:
                return basicGetParameter() != null;
        }
        return super.eIsSet(featureID);
    }

} //ImportedComplexTypeImpl
