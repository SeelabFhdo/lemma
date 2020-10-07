/**
 */
package de.fhdo.lemma.operation.impl;

import de.fhdo.lemma.operation.BasicEndpoint;
import de.fhdo.lemma.operation.OperationPackage;
import de.fhdo.lemma.operation.ProtocolAndDataFormat;

import de.fhdo.lemma.service.Import;

import de.fhdo.lemma.technology.DataFormat;
import de.fhdo.lemma.technology.Protocol;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Protocol And Data Format</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.impl.ProtocolAndDataFormatImpl#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.ProtocolAndDataFormatImpl#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.ProtocolAndDataFormatImpl#getDataFormat <em>Data Format</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.ProtocolAndDataFormatImpl#getEndpoint <em>Endpoint</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProtocolAndDataFormatImpl extends MinimalEObjectImpl.Container implements ProtocolAndDataFormat {
    /**
     * The cached value of the '{@link #getTechnology() <em>Technology</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTechnology()
     * @generated
     * @ordered
     */
    protected Import technology;

    /**
     * The cached value of the '{@link #getProtocol() <em>Protocol</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProtocol()
     * @generated
     * @ordered
     */
    protected Protocol protocol;

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
    protected ProtocolAndDataFormatImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return OperationPackage.Literals.PROTOCOL_AND_DATA_FORMAT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Import getTechnology() {
        if (technology != null && technology.eIsProxy()) {
            InternalEObject oldTechnology = (InternalEObject)technology;
            technology = (Import)eResolveProxy(oldTechnology);
            if (technology != oldTechnology) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationPackage.PROTOCOL_AND_DATA_FORMAT__TECHNOLOGY, oldTechnology, technology));
            }
        }
        return technology;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Import basicGetTechnology() {
        return technology;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setTechnology(Import newTechnology) {
        Import oldTechnology = technology;
        technology = newTechnology;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.PROTOCOL_AND_DATA_FORMAT__TECHNOLOGY, oldTechnology, technology));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Protocol getProtocol() {
        if (protocol != null && protocol.eIsProxy()) {
            InternalEObject oldProtocol = (InternalEObject)protocol;
            protocol = (Protocol)eResolveProxy(oldProtocol);
            if (protocol != oldProtocol) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationPackage.PROTOCOL_AND_DATA_FORMAT__PROTOCOL, oldProtocol, protocol));
            }
        }
        return protocol;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Protocol basicGetProtocol() {
        return protocol;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setProtocol(Protocol newProtocol) {
        Protocol oldProtocol = protocol;
        protocol = newProtocol;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.PROTOCOL_AND_DATA_FORMAT__PROTOCOL, oldProtocol, protocol));
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationPackage.PROTOCOL_AND_DATA_FORMAT__DATA_FORMAT, oldDataFormat, dataFormat));
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
            eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.PROTOCOL_AND_DATA_FORMAT__DATA_FORMAT, oldDataFormat, dataFormat));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public BasicEndpoint getEndpoint() {
        if (eContainerFeatureID() != OperationPackage.PROTOCOL_AND_DATA_FORMAT__ENDPOINT) return null;
        return (BasicEndpoint)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BasicEndpoint basicGetEndpoint() {
        if (eContainerFeatureID() != OperationPackage.PROTOCOL_AND_DATA_FORMAT__ENDPOINT) return null;
        return (BasicEndpoint)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetEndpoint(BasicEndpoint newEndpoint, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newEndpoint, OperationPackage.PROTOCOL_AND_DATA_FORMAT__ENDPOINT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setEndpoint(BasicEndpoint newEndpoint) {
        if (newEndpoint != eInternalContainer() || (eContainerFeatureID() != OperationPackage.PROTOCOL_AND_DATA_FORMAT__ENDPOINT && newEndpoint != null)) {
            if (EcoreUtil.isAncestor(this, newEndpoint))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newEndpoint != null)
                msgs = ((InternalEObject)newEndpoint).eInverseAdd(this, OperationPackage.BASIC_ENDPOINT__PROTOCOLS, BasicEndpoint.class, msgs);
            msgs = basicSetEndpoint(newEndpoint, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.PROTOCOL_AND_DATA_FORMAT__ENDPOINT, newEndpoint, newEndpoint));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case OperationPackage.PROTOCOL_AND_DATA_FORMAT__ENDPOINT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetEndpoint((BasicEndpoint)otherEnd, msgs);
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
            case OperationPackage.PROTOCOL_AND_DATA_FORMAT__ENDPOINT:
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
            case OperationPackage.PROTOCOL_AND_DATA_FORMAT__ENDPOINT:
                return eInternalContainer().eInverseRemove(this, OperationPackage.BASIC_ENDPOINT__PROTOCOLS, BasicEndpoint.class, msgs);
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
            case OperationPackage.PROTOCOL_AND_DATA_FORMAT__TECHNOLOGY:
                if (resolve) return getTechnology();
                return basicGetTechnology();
            case OperationPackage.PROTOCOL_AND_DATA_FORMAT__PROTOCOL:
                if (resolve) return getProtocol();
                return basicGetProtocol();
            case OperationPackage.PROTOCOL_AND_DATA_FORMAT__DATA_FORMAT:
                if (resolve) return getDataFormat();
                return basicGetDataFormat();
            case OperationPackage.PROTOCOL_AND_DATA_FORMAT__ENDPOINT:
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
            case OperationPackage.PROTOCOL_AND_DATA_FORMAT__TECHNOLOGY:
                setTechnology((Import)newValue);
                return;
            case OperationPackage.PROTOCOL_AND_DATA_FORMAT__PROTOCOL:
                setProtocol((Protocol)newValue);
                return;
            case OperationPackage.PROTOCOL_AND_DATA_FORMAT__DATA_FORMAT:
                setDataFormat((DataFormat)newValue);
                return;
            case OperationPackage.PROTOCOL_AND_DATA_FORMAT__ENDPOINT:
                setEndpoint((BasicEndpoint)newValue);
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
            case OperationPackage.PROTOCOL_AND_DATA_FORMAT__TECHNOLOGY:
                setTechnology((Import)null);
                return;
            case OperationPackage.PROTOCOL_AND_DATA_FORMAT__PROTOCOL:
                setProtocol((Protocol)null);
                return;
            case OperationPackage.PROTOCOL_AND_DATA_FORMAT__DATA_FORMAT:
                setDataFormat((DataFormat)null);
                return;
            case OperationPackage.PROTOCOL_AND_DATA_FORMAT__ENDPOINT:
                setEndpoint((BasicEndpoint)null);
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
            case OperationPackage.PROTOCOL_AND_DATA_FORMAT__TECHNOLOGY:
                return technology != null;
            case OperationPackage.PROTOCOL_AND_DATA_FORMAT__PROTOCOL:
                return protocol != null;
            case OperationPackage.PROTOCOL_AND_DATA_FORMAT__DATA_FORMAT:
                return dataFormat != null;
            case OperationPackage.PROTOCOL_AND_DATA_FORMAT__ENDPOINT:
                return basicGetEndpoint() != null;
        }
        return super.eIsSet(featureID);
    }

} //ProtocolAndDataFormatImpl
