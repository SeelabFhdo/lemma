/**
 */
package de.fhdo.ddmm.technology.mapping.impl;

import de.fhdo.ddmm.technology.mapping.InterfaceMapping;
import de.fhdo.ddmm.technology.mapping.MappingPackage;
import de.fhdo.ddmm.technology.mapping.MicroserviceMapping;
import de.fhdo.ddmm.technology.mapping.OperationMapping;
import de.fhdo.ddmm.technology.mapping.ReferredOperationMapping;
import de.fhdo.ddmm.technology.mapping.TechnologySpecificEndpoint;
import de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocol;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Technology Specific Endpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.TechnologySpecificEndpointImpl#getAddresses <em>Addresses</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.TechnologySpecificEndpointImpl#getTechnologySpecificProtocols <em>Technology Specific Protocols</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.TechnologySpecificEndpointImpl#getMicroserviceMapping <em>Microservice Mapping</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.TechnologySpecificEndpointImpl#getInterfaceMapping <em>Interface Mapping</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.TechnologySpecificEndpointImpl#getOperationMapping <em>Operation Mapping</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.TechnologySpecificEndpointImpl#getReferredOperationMapping <em>Referred Operation Mapping</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TechnologySpecificEndpointImpl extends MinimalEObjectImpl.Container implements TechnologySpecificEndpoint {
    /**
     * The cached value of the '{@link #getAddresses() <em>Addresses</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAddresses()
     * @generated
     * @ordered
     */
    protected EList<String> addresses;

    /**
     * The cached value of the '{@link #getTechnologySpecificProtocols() <em>Technology Specific Protocols</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTechnologySpecificProtocols()
     * @generated
     * @ordered
     */
    protected EList<TechnologySpecificProtocol> technologySpecificProtocols;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TechnologySpecificEndpointImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MappingPackage.Literals.TECHNOLOGY_SPECIFIC_ENDPOINT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getAddresses() {
        if (addresses == null) {
            addresses = new EDataTypeEList<String>(String.class, this, MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__ADDRESSES);
        }
        return addresses;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TechnologySpecificProtocol> getTechnologySpecificProtocols() {
        if (technologySpecificProtocols == null) {
            technologySpecificProtocols = new EObjectContainmentWithInverseEList<TechnologySpecificProtocol>(TechnologySpecificProtocol.class, this, MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__TECHNOLOGY_SPECIFIC_PROTOCOLS, MappingPackage.TECHNOLOGY_SPECIFIC_PROTOCOL__ENDPOINT);
        }
        return technologySpecificProtocols;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MicroserviceMapping getMicroserviceMapping() {
        if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__MICROSERVICE_MAPPING) return null;
        return (MicroserviceMapping)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MicroserviceMapping basicGetMicroserviceMapping() {
        if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__MICROSERVICE_MAPPING) return null;
        return (MicroserviceMapping)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetMicroserviceMapping(MicroserviceMapping newMicroserviceMapping, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newMicroserviceMapping, MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__MICROSERVICE_MAPPING, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMicroserviceMapping(MicroserviceMapping newMicroserviceMapping) {
        if (newMicroserviceMapping != eInternalContainer() || (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__MICROSERVICE_MAPPING && newMicroserviceMapping != null)) {
            if (EcoreUtil.isAncestor(this, newMicroserviceMapping))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newMicroserviceMapping != null)
                msgs = ((InternalEObject)newMicroserviceMapping).eInverseAdd(this, MappingPackage.MICROSERVICE_MAPPING__ENDPOINTS, MicroserviceMapping.class, msgs);
            msgs = basicSetMicroserviceMapping(newMicroserviceMapping, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__MICROSERVICE_MAPPING, newMicroserviceMapping, newMicroserviceMapping));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InterfaceMapping getInterfaceMapping() {
        if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__INTERFACE_MAPPING) return null;
        return (InterfaceMapping)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InterfaceMapping basicGetInterfaceMapping() {
        if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__INTERFACE_MAPPING) return null;
        return (InterfaceMapping)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInterfaceMapping(InterfaceMapping newInterfaceMapping, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newInterfaceMapping, MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__INTERFACE_MAPPING, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInterfaceMapping(InterfaceMapping newInterfaceMapping) {
        if (newInterfaceMapping != eInternalContainer() || (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__INTERFACE_MAPPING && newInterfaceMapping != null)) {
            if (EcoreUtil.isAncestor(this, newInterfaceMapping))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newInterfaceMapping != null)
                msgs = ((InternalEObject)newInterfaceMapping).eInverseAdd(this, MappingPackage.INTERFACE_MAPPING__ENDPOINTS, InterfaceMapping.class, msgs);
            msgs = basicSetInterfaceMapping(newInterfaceMapping, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__INTERFACE_MAPPING, newInterfaceMapping, newInterfaceMapping));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationMapping getOperationMapping() {
        if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__OPERATION_MAPPING) return null;
        return (OperationMapping)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationMapping basicGetOperationMapping() {
        if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__OPERATION_MAPPING) return null;
        return (OperationMapping)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOperationMapping(OperationMapping newOperationMapping, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOperationMapping, MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__OPERATION_MAPPING, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOperationMapping(OperationMapping newOperationMapping) {
        if (newOperationMapping != eInternalContainer() || (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__OPERATION_MAPPING && newOperationMapping != null)) {
            if (EcoreUtil.isAncestor(this, newOperationMapping))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOperationMapping != null)
                msgs = ((InternalEObject)newOperationMapping).eInverseAdd(this, MappingPackage.OPERATION_MAPPING__ENDPOINTS, OperationMapping.class, msgs);
            msgs = basicSetOperationMapping(newOperationMapping, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__OPERATION_MAPPING, newOperationMapping, newOperationMapping));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ReferredOperationMapping getReferredOperationMapping() {
        if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__REFERRED_OPERATION_MAPPING) return null;
        return (ReferredOperationMapping)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ReferredOperationMapping basicGetReferredOperationMapping() {
        if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__REFERRED_OPERATION_MAPPING) return null;
        return (ReferredOperationMapping)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetReferredOperationMapping(ReferredOperationMapping newReferredOperationMapping, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newReferredOperationMapping, MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__REFERRED_OPERATION_MAPPING, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReferredOperationMapping(ReferredOperationMapping newReferredOperationMapping) {
        if (newReferredOperationMapping != eInternalContainer() || (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__REFERRED_OPERATION_MAPPING && newReferredOperationMapping != null)) {
            if (EcoreUtil.isAncestor(this, newReferredOperationMapping))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newReferredOperationMapping != null)
                msgs = ((InternalEObject)newReferredOperationMapping).eInverseAdd(this, MappingPackage.REFERRED_OPERATION_MAPPING__ENDPOINTS, ReferredOperationMapping.class, msgs);
            msgs = basicSetReferredOperationMapping(newReferredOperationMapping, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__REFERRED_OPERATION_MAPPING, newReferredOperationMapping, newReferredOperationMapping));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__TECHNOLOGY_SPECIFIC_PROTOCOLS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getTechnologySpecificProtocols()).basicAdd(otherEnd, msgs);
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__MICROSERVICE_MAPPING:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetMicroserviceMapping((MicroserviceMapping)otherEnd, msgs);
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__INTERFACE_MAPPING:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetInterfaceMapping((InterfaceMapping)otherEnd, msgs);
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__OPERATION_MAPPING:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOperationMapping((OperationMapping)otherEnd, msgs);
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__REFERRED_OPERATION_MAPPING:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetReferredOperationMapping((ReferredOperationMapping)otherEnd, msgs);
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
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__TECHNOLOGY_SPECIFIC_PROTOCOLS:
                return ((InternalEList<?>)getTechnologySpecificProtocols()).basicRemove(otherEnd, msgs);
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__MICROSERVICE_MAPPING:
                return basicSetMicroserviceMapping(null, msgs);
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__INTERFACE_MAPPING:
                return basicSetInterfaceMapping(null, msgs);
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__OPERATION_MAPPING:
                return basicSetOperationMapping(null, msgs);
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__REFERRED_OPERATION_MAPPING:
                return basicSetReferredOperationMapping(null, msgs);
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
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__MICROSERVICE_MAPPING:
                return eInternalContainer().eInverseRemove(this, MappingPackage.MICROSERVICE_MAPPING__ENDPOINTS, MicroserviceMapping.class, msgs);
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__INTERFACE_MAPPING:
                return eInternalContainer().eInverseRemove(this, MappingPackage.INTERFACE_MAPPING__ENDPOINTS, InterfaceMapping.class, msgs);
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__OPERATION_MAPPING:
                return eInternalContainer().eInverseRemove(this, MappingPackage.OPERATION_MAPPING__ENDPOINTS, OperationMapping.class, msgs);
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__REFERRED_OPERATION_MAPPING:
                return eInternalContainer().eInverseRemove(this, MappingPackage.REFERRED_OPERATION_MAPPING__ENDPOINTS, ReferredOperationMapping.class, msgs);
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
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__ADDRESSES:
                return getAddresses();
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__TECHNOLOGY_SPECIFIC_PROTOCOLS:
                return getTechnologySpecificProtocols();
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__MICROSERVICE_MAPPING:
                if (resolve) return getMicroserviceMapping();
                return basicGetMicroserviceMapping();
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__INTERFACE_MAPPING:
                if (resolve) return getInterfaceMapping();
                return basicGetInterfaceMapping();
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__OPERATION_MAPPING:
                if (resolve) return getOperationMapping();
                return basicGetOperationMapping();
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__REFERRED_OPERATION_MAPPING:
                if (resolve) return getReferredOperationMapping();
                return basicGetReferredOperationMapping();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__ADDRESSES:
                getAddresses().clear();
                getAddresses().addAll((Collection<? extends String>)newValue);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__TECHNOLOGY_SPECIFIC_PROTOCOLS:
                getTechnologySpecificProtocols().clear();
                getTechnologySpecificProtocols().addAll((Collection<? extends TechnologySpecificProtocol>)newValue);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__MICROSERVICE_MAPPING:
                setMicroserviceMapping((MicroserviceMapping)newValue);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__INTERFACE_MAPPING:
                setInterfaceMapping((InterfaceMapping)newValue);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__OPERATION_MAPPING:
                setOperationMapping((OperationMapping)newValue);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__REFERRED_OPERATION_MAPPING:
                setReferredOperationMapping((ReferredOperationMapping)newValue);
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
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__ADDRESSES:
                getAddresses().clear();
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__TECHNOLOGY_SPECIFIC_PROTOCOLS:
                getTechnologySpecificProtocols().clear();
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__MICROSERVICE_MAPPING:
                setMicroserviceMapping((MicroserviceMapping)null);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__INTERFACE_MAPPING:
                setInterfaceMapping((InterfaceMapping)null);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__OPERATION_MAPPING:
                setOperationMapping((OperationMapping)null);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__REFERRED_OPERATION_MAPPING:
                setReferredOperationMapping((ReferredOperationMapping)null);
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
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__ADDRESSES:
                return addresses != null && !addresses.isEmpty();
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__TECHNOLOGY_SPECIFIC_PROTOCOLS:
                return technologySpecificProtocols != null && !technologySpecificProtocols.isEmpty();
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__MICROSERVICE_MAPPING:
                return basicGetMicroserviceMapping() != null;
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__INTERFACE_MAPPING:
                return basicGetInterfaceMapping() != null;
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__OPERATION_MAPPING:
                return basicGetOperationMapping() != null;
            case MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__REFERRED_OPERATION_MAPPING:
                return basicGetReferredOperationMapping() != null;
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

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (addresses: ");
        result.append(addresses);
        result.append(')');
        return result.toString();
    }

} //TechnologySpecificEndpointImpl
