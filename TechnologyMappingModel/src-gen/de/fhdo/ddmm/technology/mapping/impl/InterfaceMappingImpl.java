/**
 */
package de.fhdo.ddmm.technology.mapping.impl;

import de.fhdo.ddmm.service.Interface;

import de.fhdo.ddmm.technology.mapping.InterfaceMapping;
import de.fhdo.ddmm.technology.mapping.MappingPackage;
import de.fhdo.ddmm.technology.mapping.MicroserviceMapping;
import de.fhdo.ddmm.technology.mapping.TechnologySpecificEndpoint;
import de.fhdo.ddmm.technology.mapping.TechnologySpecificImportedServiceAspect;
import de.fhdo.ddmm.technology.mapping.TechnologySpecificProtocolSpecification;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interface Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.InterfaceMappingImpl#getInterface <em>Interface</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.InterfaceMappingImpl#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.InterfaceMappingImpl#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.InterfaceMappingImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.InterfaceMappingImpl#getMicroserviceMapping <em>Microservice Mapping</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InterfaceMappingImpl extends MinimalEObjectImpl.Container implements InterfaceMapping {
    /**
     * The cached value of the '{@link #getInterface() <em>Interface</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInterface()
     * @generated
     * @ordered
     */
    protected Interface interface_;

    /**
     * The cached value of the '{@link #getEndpoints() <em>Endpoints</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEndpoints()
     * @generated
     * @ordered
     */
    protected EList<TechnologySpecificEndpoint> endpoints;

    /**
     * The cached value of the '{@link #getProtocols() <em>Protocols</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProtocols()
     * @generated
     * @ordered
     */
    protected EList<TechnologySpecificProtocolSpecification> protocols;

    /**
     * The cached value of the '{@link #getAspects() <em>Aspects</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAspects()
     * @generated
     * @ordered
     */
    protected EList<TechnologySpecificImportedServiceAspect> aspects;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected InterfaceMappingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MappingPackage.Literals.INTERFACE_MAPPING;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Interface getInterface() {
        if (interface_ != null && interface_.eIsProxy()) {
            InternalEObject oldInterface = (InternalEObject)interface_;
            interface_ = (Interface)eResolveProxy(oldInterface);
            if (interface_ != oldInterface) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.INTERFACE_MAPPING__INTERFACE, oldInterface, interface_));
            }
        }
        return interface_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Interface basicGetInterface() {
        return interface_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setInterface(Interface newInterface) {
        Interface oldInterface = interface_;
        interface_ = newInterface;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.INTERFACE_MAPPING__INTERFACE, oldInterface, interface_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<TechnologySpecificEndpoint> getEndpoints() {
        if (endpoints == null) {
            endpoints = new EObjectContainmentWithInverseEList<TechnologySpecificEndpoint>(TechnologySpecificEndpoint.class, this, MappingPackage.INTERFACE_MAPPING__ENDPOINTS, MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__INTERFACE_MAPPING);
        }
        return endpoints;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<TechnologySpecificProtocolSpecification> getProtocols() {
        if (protocols == null) {
            protocols = new EObjectContainmentEList<TechnologySpecificProtocolSpecification>(TechnologySpecificProtocolSpecification.class, this, MappingPackage.INTERFACE_MAPPING__PROTOCOLS);
        }
        return protocols;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<TechnologySpecificImportedServiceAspect> getAspects() {
        if (aspects == null) {
            aspects = new EObjectContainmentWithInverseEList<TechnologySpecificImportedServiceAspect>(TechnologySpecificImportedServiceAspect.class, this, MappingPackage.INTERFACE_MAPPING__ASPECTS, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__INTERFACE_MAPPING);
        }
        return aspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public MicroserviceMapping getMicroserviceMapping() {
        if (eContainerFeatureID() != MappingPackage.INTERFACE_MAPPING__MICROSERVICE_MAPPING) return null;
        return (MicroserviceMapping)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MicroserviceMapping basicGetMicroserviceMapping() {
        if (eContainerFeatureID() != MappingPackage.INTERFACE_MAPPING__MICROSERVICE_MAPPING) return null;
        return (MicroserviceMapping)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetMicroserviceMapping(MicroserviceMapping newMicroserviceMapping, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newMicroserviceMapping, MappingPackage.INTERFACE_MAPPING__MICROSERVICE_MAPPING, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setMicroserviceMapping(MicroserviceMapping newMicroserviceMapping) {
        if (newMicroserviceMapping != eInternalContainer() || (eContainerFeatureID() != MappingPackage.INTERFACE_MAPPING__MICROSERVICE_MAPPING && newMicroserviceMapping != null)) {
            if (EcoreUtil.isAncestor(this, newMicroserviceMapping))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newMicroserviceMapping != null)
                msgs = ((InternalEObject)newMicroserviceMapping).eInverseAdd(this, MappingPackage.MICROSERVICE_MAPPING__INTERFACE_MAPPINGS, MicroserviceMapping.class, msgs);
            msgs = basicSetMicroserviceMapping(newMicroserviceMapping, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.INTERFACE_MAPPING__MICROSERVICE_MAPPING, newMicroserviceMapping, newMicroserviceMapping));
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
            case MappingPackage.INTERFACE_MAPPING__ENDPOINTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getEndpoints()).basicAdd(otherEnd, msgs);
            case MappingPackage.INTERFACE_MAPPING__ASPECTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspects()).basicAdd(otherEnd, msgs);
            case MappingPackage.INTERFACE_MAPPING__MICROSERVICE_MAPPING:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetMicroserviceMapping((MicroserviceMapping)otherEnd, msgs);
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
            case MappingPackage.INTERFACE_MAPPING__ENDPOINTS:
                return ((InternalEList<?>)getEndpoints()).basicRemove(otherEnd, msgs);
            case MappingPackage.INTERFACE_MAPPING__PROTOCOLS:
                return ((InternalEList<?>)getProtocols()).basicRemove(otherEnd, msgs);
            case MappingPackage.INTERFACE_MAPPING__ASPECTS:
                return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
            case MappingPackage.INTERFACE_MAPPING__MICROSERVICE_MAPPING:
                return basicSetMicroserviceMapping(null, msgs);
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
            case MappingPackage.INTERFACE_MAPPING__MICROSERVICE_MAPPING:
                return eInternalContainer().eInverseRemove(this, MappingPackage.MICROSERVICE_MAPPING__INTERFACE_MAPPINGS, MicroserviceMapping.class, msgs);
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
            case MappingPackage.INTERFACE_MAPPING__INTERFACE:
                if (resolve) return getInterface();
                return basicGetInterface();
            case MappingPackage.INTERFACE_MAPPING__ENDPOINTS:
                return getEndpoints();
            case MappingPackage.INTERFACE_MAPPING__PROTOCOLS:
                return getProtocols();
            case MappingPackage.INTERFACE_MAPPING__ASPECTS:
                return getAspects();
            case MappingPackage.INTERFACE_MAPPING__MICROSERVICE_MAPPING:
                if (resolve) return getMicroserviceMapping();
                return basicGetMicroserviceMapping();
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
            case MappingPackage.INTERFACE_MAPPING__INTERFACE:
                setInterface((Interface)newValue);
                return;
            case MappingPackage.INTERFACE_MAPPING__ENDPOINTS:
                getEndpoints().clear();
                getEndpoints().addAll((Collection<? extends TechnologySpecificEndpoint>)newValue);
                return;
            case MappingPackage.INTERFACE_MAPPING__PROTOCOLS:
                getProtocols().clear();
                getProtocols().addAll((Collection<? extends TechnologySpecificProtocolSpecification>)newValue);
                return;
            case MappingPackage.INTERFACE_MAPPING__ASPECTS:
                getAspects().clear();
                getAspects().addAll((Collection<? extends TechnologySpecificImportedServiceAspect>)newValue);
                return;
            case MappingPackage.INTERFACE_MAPPING__MICROSERVICE_MAPPING:
                setMicroserviceMapping((MicroserviceMapping)newValue);
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
            case MappingPackage.INTERFACE_MAPPING__INTERFACE:
                setInterface((Interface)null);
                return;
            case MappingPackage.INTERFACE_MAPPING__ENDPOINTS:
                getEndpoints().clear();
                return;
            case MappingPackage.INTERFACE_MAPPING__PROTOCOLS:
                getProtocols().clear();
                return;
            case MappingPackage.INTERFACE_MAPPING__ASPECTS:
                getAspects().clear();
                return;
            case MappingPackage.INTERFACE_MAPPING__MICROSERVICE_MAPPING:
                setMicroserviceMapping((MicroserviceMapping)null);
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
            case MappingPackage.INTERFACE_MAPPING__INTERFACE:
                return interface_ != null;
            case MappingPackage.INTERFACE_MAPPING__ENDPOINTS:
                return endpoints != null && !endpoints.isEmpty();
            case MappingPackage.INTERFACE_MAPPING__PROTOCOLS:
                return protocols != null && !protocols.isEmpty();
            case MappingPackage.INTERFACE_MAPPING__ASPECTS:
                return aspects != null && !aspects.isEmpty();
            case MappingPackage.INTERFACE_MAPPING__MICROSERVICE_MAPPING:
                return basicGetMicroserviceMapping() != null;
        }
        return super.eIsSet(featureID);
    }

} //InterfaceMappingImpl
