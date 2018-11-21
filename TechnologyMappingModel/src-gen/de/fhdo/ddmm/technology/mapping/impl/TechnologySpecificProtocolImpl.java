/**
 */
package de.fhdo.ddmm.technology.mapping.impl;

import de.fhdo.ddmm.service.Import;

import de.fhdo.ddmm.technology.DataFormat;
import de.fhdo.ddmm.technology.Protocol;

import de.fhdo.ddmm.technology.mapping.MappingPackage;
import de.fhdo.ddmm.technology.mapping.TechnologySpecificEndpoint;
import de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocol;
import de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocolSpecification;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Technology Specific Protocol</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.TechnologySpecificProtocolImpl#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.TechnologySpecificProtocolImpl#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.TechnologySpecificProtocolImpl#getDataFormat <em>Data Format</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.TechnologySpecificProtocolImpl#getProtocolSpecification <em>Protocol Specification</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.TechnologySpecificProtocolImpl#getEndpoint <em>Endpoint</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TechnologySpecificProtocolImpl extends MinimalEObjectImpl.Container implements TechnologySpecificProtocol {
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
    protected TechnologySpecificProtocolImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MappingPackage.Literals.TECHNOLOGY_SPECIFIC_PROTOCOL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Import getTechnology() {
        if (technology != null && technology.eIsProxy()) {
            InternalEObject oldTechnology = (InternalEObject)technology;
            technology = (Import)eResolveProxy(oldTechnology);
            if (technology != oldTechnology) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__TECHNOLOGY, oldTechnology, technology));
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
    public void setTechnology(Import newTechnology) {
        Import oldTechnology = technology;
        technology = newTechnology;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__TECHNOLOGY, oldTechnology, technology));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Protocol getProtocol() {
        if (protocol != null && protocol.eIsProxy()) {
            InternalEObject oldProtocol = (InternalEObject)protocol;
            protocol = (Protocol)eResolveProxy(oldProtocol);
            if (protocol != oldProtocol) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__PROTOCOL, oldProtocol, protocol));
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
    public void setProtocol(Protocol newProtocol) {
        Protocol oldProtocol = protocol;
        protocol = newProtocol;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__PROTOCOL, oldProtocol, protocol));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataFormat getDataFormat() {
        if (dataFormat != null && dataFormat.eIsProxy()) {
            InternalEObject oldDataFormat = (InternalEObject)dataFormat;
            dataFormat = (DataFormat)eResolveProxy(oldDataFormat);
            if (dataFormat != oldDataFormat) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__DATA_FORMAT, oldDataFormat, dataFormat));
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
    public void setDataFormat(DataFormat newDataFormat) {
        DataFormat oldDataFormat = dataFormat;
        dataFormat = newDataFormat;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__DATA_FORMAT, oldDataFormat, dataFormat));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologySpecificProtocolSpecification getProtocolSpecification() {
        if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__PROTOCOL_SPECIFICATION) return null;
        return (TechnologySpecificProtocolSpecification)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologySpecificProtocolSpecification basicGetProtocolSpecification() {
        if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__PROTOCOL_SPECIFICATION) return null;
        return (TechnologySpecificProtocolSpecification)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetProtocolSpecification(TechnologySpecificProtocolSpecification newProtocolSpecification, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newProtocolSpecification, MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__PROTOCOL_SPECIFICATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setProtocolSpecification(TechnologySpecificProtocolSpecification newProtocolSpecification) {
        if (newProtocolSpecification != eInternalContainer() || (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__PROTOCOL_SPECIFICATION && newProtocolSpecification != null)) {
            if (EcoreUtil.isAncestor(this, newProtocolSpecification))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newProtocolSpecification != null)
                msgs = ((InternalEObject)newProtocolSpecification).eInverseAdd(this, MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL_SPECIFICATION__TECHNOLOGY_SPECIFIC_PROTOCOL, TechnologySpecificProtocolSpecification.class, msgs);
            msgs = basicSetProtocolSpecification(newProtocolSpecification, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__PROTOCOL_SPECIFICATION, newProtocolSpecification, newProtocolSpecification));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologySpecificEndpoint getEndpoint() {
        if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__ENDPOINT) return null;
        return (TechnologySpecificEndpoint)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologySpecificEndpoint basicGetEndpoint() {
        if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__ENDPOINT) return null;
        return (TechnologySpecificEndpoint)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetEndpoint(TechnologySpecificEndpoint newEndpoint, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newEndpoint, MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__ENDPOINT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEndpoint(TechnologySpecificEndpoint newEndpoint) {
        if (newEndpoint != eInternalContainer() || (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__ENDPOINT && newEndpoint != null)) {
            if (EcoreUtil.isAncestor(this, newEndpoint))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newEndpoint != null)
                msgs = ((InternalEObject)newEndpoint).eInverseAdd(this, MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__TECHNOLOGY_SPECIFIC_PROTOCOLS, TechnologySpecificEndpoint.class, msgs);
            msgs = basicSetEndpoint(newEndpoint, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__ENDPOINT, newEndpoint, newEndpoint));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__PROTOCOL_SPECIFICATION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetProtocolSpecification((TechnologySpecificProtocolSpecification)otherEnd, msgs);
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__ENDPOINT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetEndpoint((TechnologySpecificEndpoint)otherEnd, msgs);
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
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__PROTOCOL_SPECIFICATION:
                return basicSetProtocolSpecification(null, msgs);
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__ENDPOINT:
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
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__PROTOCOL_SPECIFICATION:
                return eInternalContainer().eInverseRemove(this, MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL_SPECIFICATION__TECHNOLOGY_SPECIFIC_PROTOCOL, TechnologySpecificProtocolSpecification.class, msgs);
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__ENDPOINT:
                return eInternalContainer().eInverseRemove(this, MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__TECHNOLOGY_SPECIFIC_PROTOCOLS, TechnologySpecificEndpoint.class, msgs);
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
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__TECHNOLOGY:
                if (resolve) return getTechnology();
                return basicGetTechnology();
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__PROTOCOL:
                if (resolve) return getProtocol();
                return basicGetProtocol();
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__DATA_FORMAT:
                if (resolve) return getDataFormat();
                return basicGetDataFormat();
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__PROTOCOL_SPECIFICATION:
                if (resolve) return getProtocolSpecification();
                return basicGetProtocolSpecification();
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__ENDPOINT:
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
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__TECHNOLOGY:
                setTechnology((Import)newValue);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__PROTOCOL:
                setProtocol((Protocol)newValue);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__DATA_FORMAT:
                setDataFormat((DataFormat)newValue);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__PROTOCOL_SPECIFICATION:
                setProtocolSpecification((TechnologySpecificProtocolSpecification)newValue);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__ENDPOINT:
                setEndpoint((TechnologySpecificEndpoint)newValue);
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
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__TECHNOLOGY:
                setTechnology((Import)null);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__PROTOCOL:
                setProtocol((Protocol)null);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__DATA_FORMAT:
                setDataFormat((DataFormat)null);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__PROTOCOL_SPECIFICATION:
                setProtocolSpecification((TechnologySpecificProtocolSpecification)null);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__ENDPOINT:
                setEndpoint((TechnologySpecificEndpoint)null);
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
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__TECHNOLOGY:
                return technology != null;
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__PROTOCOL:
                return protocol != null;
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__DATA_FORMAT:
                return dataFormat != null;
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__PROTOCOL_SPECIFICATION:
                return basicGetProtocolSpecification() != null;
            case MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__ENDPOINT:
                return basicGetEndpoint() != null;
        }
        return super.eIsSet(featureID);
    }

} //TechnologySpecificProtocolImpl
