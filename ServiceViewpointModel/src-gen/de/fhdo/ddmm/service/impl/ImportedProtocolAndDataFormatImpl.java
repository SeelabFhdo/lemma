/**
 */
package de.fhdo.ddmm.service.impl;

import de.fhdo.ddmm.service.Endpoint;
import de.fhdo.ddmm.service.Import;
import de.fhdo.ddmm.service.ImportedProtocolAndDataFormat;
import de.fhdo.ddmm.service.ProtocolSpecification;
import de.fhdo.ddmm.service.ServicePackage;

import de.fhdo.ddmm.technology.DataFormat;
import de.fhdo.ddmm.technology.Protocol;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Imported Protocol And Data Format</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.impl.ImportedProtocolAndDataFormatImpl#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.ImportedProtocolAndDataFormatImpl#getImportedProtocol <em>Imported Protocol</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.ImportedProtocolAndDataFormatImpl#getDataFormat <em>Data Format</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.ImportedProtocolAndDataFormatImpl#getSpecification <em>Specification</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.ImportedProtocolAndDataFormatImpl#getEndpoint <em>Endpoint</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImportedProtocolAndDataFormatImpl extends MinimalEObjectImpl.Container implements ImportedProtocolAndDataFormat {
    /**
     * The cached value of the '{@link #getImport() <em>Import</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImport()
     * @generated
     * @ordered
     */
    protected Import import_;

    /**
     * The cached value of the '{@link #getImportedProtocol() <em>Imported Protocol</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImportedProtocol()
     * @generated
     * @ordered
     */
    protected Protocol importedProtocol;

    /**
     * The cached value of the '{@link #getDataFormat() <em>Data Format</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataFormat()
     * @generated
     * @ordered
     */
    protected DataFormat dataFormat;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ImportedProtocolAndDataFormatImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ServicePackage.Literals.IMPORTED_PROTOCOL_AND_DATA_FORMAT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Import getImport() {
        if (import_ != null && import_.eIsProxy()) {
            InternalEObject oldImport = (InternalEObject)import_;
            import_ = (Import)eResolveProxy(oldImport);
            if (import_ != oldImport) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__IMPORT, oldImport, import_));
            }
        }
        return import_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Import basicGetImport() {
        return import_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setImport(Import newImport) {
        Import oldImport = import_;
        import_ = newImport;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__IMPORT, oldImport, import_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Protocol getImportedProtocol() {
        if (importedProtocol != null && importedProtocol.eIsProxy()) {
            InternalEObject oldImportedProtocol = (InternalEObject)importedProtocol;
            importedProtocol = (Protocol)eResolveProxy(oldImportedProtocol);
            if (importedProtocol != oldImportedProtocol) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__IMPORTED_PROTOCOL, oldImportedProtocol, importedProtocol));
            }
        }
        return importedProtocol;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Protocol basicGetImportedProtocol() {
        return importedProtocol;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setImportedProtocol(Protocol newImportedProtocol) {
        Protocol oldImportedProtocol = importedProtocol;
        importedProtocol = newImportedProtocol;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__IMPORTED_PROTOCOL, oldImportedProtocol, importedProtocol));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DataFormat getDataFormat() {
        if (dataFormat != null && dataFormat.eIsProxy()) {
            InternalEObject oldDataFormat = (InternalEObject)dataFormat;
            dataFormat = (DataFormat)eResolveProxy(oldDataFormat);
            if (dataFormat != oldDataFormat) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__DATA_FORMAT, oldDataFormat, dataFormat));
            }
        }
        return dataFormat;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataFormat basicGetDataFormat() {
        return dataFormat;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setDataFormat(DataFormat newDataFormat) {
        DataFormat oldDataFormat = dataFormat;
        dataFormat = newDataFormat;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__DATA_FORMAT, oldDataFormat, dataFormat));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ProtocolSpecification getSpecification() {
        if (eContainerFeatureID() != ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__SPECIFICATION) return null;
        return (ProtocolSpecification)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProtocolSpecification basicGetSpecification() {
        if (eContainerFeatureID() != ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__SPECIFICATION) return null;
        return (ProtocolSpecification)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSpecification(ProtocolSpecification newSpecification, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newSpecification, ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__SPECIFICATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setSpecification(ProtocolSpecification newSpecification) {
        if (newSpecification != eInternalContainer() || (eContainerFeatureID() != ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__SPECIFICATION && newSpecification != null)) {
            if (EcoreUtil.isAncestor(this, newSpecification))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newSpecification != null)
                msgs = ((InternalEObject)newSpecification).eInverseAdd(this, ServicePackage.PROTOCOL_SPECIFICATION__PROTOCOL, ProtocolSpecification.class, msgs);
            msgs = basicSetSpecification(newSpecification, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__SPECIFICATION, newSpecification, newSpecification));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Endpoint getEndpoint() {
        if (eContainerFeatureID() != ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__ENDPOINT) return null;
        return (Endpoint)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Endpoint basicGetEndpoint() {
        if (eContainerFeatureID() != ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__ENDPOINT) return null;
        return (Endpoint)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetEndpoint(Endpoint newEndpoint, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newEndpoint, ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__ENDPOINT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setEndpoint(Endpoint newEndpoint) {
        if (newEndpoint != eInternalContainer() || (eContainerFeatureID() != ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__ENDPOINT && newEndpoint != null)) {
            if (EcoreUtil.isAncestor(this, newEndpoint))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newEndpoint != null)
                msgs = ((InternalEObject)newEndpoint).eInverseAdd(this, ServicePackage.ENDPOINT__PROTOCOLS, Endpoint.class, msgs);
            msgs = basicSetEndpoint(newEndpoint, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__ENDPOINT, newEndpoint, newEndpoint));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__SPECIFICATION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetSpecification((ProtocolSpecification)otherEnd, msgs);
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__ENDPOINT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetEndpoint((Endpoint)otherEnd, msgs);
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
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__SPECIFICATION:
                return basicSetSpecification(null, msgs);
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__ENDPOINT:
                return basicSetEndpoint(null, msgs);
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
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__SPECIFICATION:
                return eInternalContainer().eInverseRemove(this, ServicePackage.PROTOCOL_SPECIFICATION__PROTOCOL, ProtocolSpecification.class, msgs);
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__ENDPOINT:
                return eInternalContainer().eInverseRemove(this, ServicePackage.ENDPOINT__PROTOCOLS, Endpoint.class, msgs);
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
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__IMPORT:
                if (resolve) return getImport();
                return basicGetImport();
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__IMPORTED_PROTOCOL:
                if (resolve) return getImportedProtocol();
                return basicGetImportedProtocol();
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__DATA_FORMAT:
                if (resolve) return getDataFormat();
                return basicGetDataFormat();
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__SPECIFICATION:
                if (resolve) return getSpecification();
                return basicGetSpecification();
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__ENDPOINT:
                if (resolve) return getEndpoint();
                return basicGetEndpoint();
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
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__IMPORT:
                setImport((Import)newValue);
                return;
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__IMPORTED_PROTOCOL:
                setImportedProtocol((Protocol)newValue);
                return;
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__DATA_FORMAT:
                setDataFormat((DataFormat)newValue);
                return;
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__SPECIFICATION:
                setSpecification((ProtocolSpecification)newValue);
                return;
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__ENDPOINT:
                setEndpoint((Endpoint)newValue);
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
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__IMPORT:
                setImport((Import)null);
                return;
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__IMPORTED_PROTOCOL:
                setImportedProtocol((Protocol)null);
                return;
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__DATA_FORMAT:
                setDataFormat((DataFormat)null);
                return;
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__SPECIFICATION:
                setSpecification((ProtocolSpecification)null);
                return;
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__ENDPOINT:
                setEndpoint((Endpoint)null);
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
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__IMPORT:
                return import_ != null;
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__IMPORTED_PROTOCOL:
                return importedProtocol != null;
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__DATA_FORMAT:
                return dataFormat != null;
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__SPECIFICATION:
                return basicGetSpecification() != null;
            case ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__ENDPOINT:
                return basicGetEndpoint() != null;
        }
        return super.eIsSet(featureID);
    }

} //ImportedProtocolAndDataFormatImpl
