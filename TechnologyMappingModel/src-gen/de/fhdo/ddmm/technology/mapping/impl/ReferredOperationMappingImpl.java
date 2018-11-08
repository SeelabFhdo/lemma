/**
 */
package de.fhdo.ddmm.technology.mapping.impl;

import de.fhdo.ddmm.service.ReferredOperation;

import de.fhdo.ddmm.technology.mapping.MappingPackage;
import de.fhdo.ddmm.technology.mapping.MicroserviceMapping;
import de.fhdo.ddmm.technology.mapping.ReferredOperationMapping;
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
 * An implementation of the model object '<em><b>Referred Operation Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.ReferredOperationMappingImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.ReferredOperationMappingImpl#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.ReferredOperationMappingImpl#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.ReferredOperationMappingImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.ReferredOperationMappingImpl#getMicroserviceMapping <em>Microservice Mapping</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferredOperationMappingImpl extends MinimalEObjectImpl.Container implements ReferredOperationMapping {
    /**
     * The cached value of the '{@link #getOperation() <em>Operation</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperation()
     * @generated
     * @ordered
     */
    protected ReferredOperation operation;

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
    protected ReferredOperationMappingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MappingPackage.Literals.REFERRED_OPERATION_MAPPING;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ReferredOperation getOperation() {
        if (operation != null && operation.eIsProxy()) {
            InternalEObject oldOperation = (InternalEObject)operation;
            operation = (ReferredOperation)eResolveProxy(oldOperation);
            if (operation != oldOperation) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.REFERRED_OPERATION_MAPPING__OPERATION, oldOperation, operation));
            }
        }
        return operation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ReferredOperation basicGetOperation() {
        return operation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOperation(ReferredOperation newOperation) {
        ReferredOperation oldOperation = operation;
        operation = newOperation;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.REFERRED_OPERATION_MAPPING__OPERATION, oldOperation, operation));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TechnologySpecificEndpoint> getEndpoints() {
        if (endpoints == null) {
            endpoints = new EObjectContainmentWithInverseEList<TechnologySpecificEndpoint>(TechnologySpecificEndpoint.class, this, MappingPackage.REFERRED_OPERATION_MAPPING__ENDPOINTS, MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__REFERRED_OPERATION_MAPPING);
        }
        return endpoints;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TechnologySpecificProtocolSpecification> getProtocols() {
        if (protocols == null) {
            protocols = new EObjectContainmentEList<TechnologySpecificProtocolSpecification>(TechnologySpecificProtocolSpecification.class, this, MappingPackage.REFERRED_OPERATION_MAPPING__PROTOCOLS);
        }
        return protocols;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TechnologySpecificImportedServiceAspect> getAspects() {
        if (aspects == null) {
            aspects = new EObjectContainmentWithInverseEList<TechnologySpecificImportedServiceAspect>(TechnologySpecificImportedServiceAspect.class, this, MappingPackage.REFERRED_OPERATION_MAPPING__ASPECTS, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION_MAPPING);
        }
        return aspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MicroserviceMapping getMicroserviceMapping() {
        if (eContainerFeatureID() != MappingPackage.REFERRED_OPERATION_MAPPING__MICROSERVICE_MAPPING) return null;
        return (MicroserviceMapping)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MicroserviceMapping basicGetMicroserviceMapping() {
        if (eContainerFeatureID() != MappingPackage.REFERRED_OPERATION_MAPPING__MICROSERVICE_MAPPING) return null;
        return (MicroserviceMapping)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetMicroserviceMapping(MicroserviceMapping newMicroserviceMapping, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newMicroserviceMapping, MappingPackage.REFERRED_OPERATION_MAPPING__MICROSERVICE_MAPPING, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMicroserviceMapping(MicroserviceMapping newMicroserviceMapping) {
        if (newMicroserviceMapping != eInternalContainer() || (eContainerFeatureID() != MappingPackage.REFERRED_OPERATION_MAPPING__MICROSERVICE_MAPPING && newMicroserviceMapping != null)) {
            if (EcoreUtil.isAncestor(this, newMicroserviceMapping))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newMicroserviceMapping != null)
                msgs = ((InternalEObject)newMicroserviceMapping).eInverseAdd(this, MappingPackage.MICROSERVICE_MAPPING__REFERRED_OPERATION_MAPPINGS, MicroserviceMapping.class, msgs);
            msgs = basicSetMicroserviceMapping(newMicroserviceMapping, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.REFERRED_OPERATION_MAPPING__MICROSERVICE_MAPPING, newMicroserviceMapping, newMicroserviceMapping));
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
            case MappingPackage.REFERRED_OPERATION_MAPPING__ENDPOINTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getEndpoints()).basicAdd(otherEnd, msgs);
            case MappingPackage.REFERRED_OPERATION_MAPPING__ASPECTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspects()).basicAdd(otherEnd, msgs);
            case MappingPackage.REFERRED_OPERATION_MAPPING__MICROSERVICE_MAPPING:
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
            case MappingPackage.REFERRED_OPERATION_MAPPING__ENDPOINTS:
                return ((InternalEList<?>)getEndpoints()).basicRemove(otherEnd, msgs);
            case MappingPackage.REFERRED_OPERATION_MAPPING__PROTOCOLS:
                return ((InternalEList<?>)getProtocols()).basicRemove(otherEnd, msgs);
            case MappingPackage.REFERRED_OPERATION_MAPPING__ASPECTS:
                return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
            case MappingPackage.REFERRED_OPERATION_MAPPING__MICROSERVICE_MAPPING:
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
            case MappingPackage.REFERRED_OPERATION_MAPPING__MICROSERVICE_MAPPING:
                return eInternalContainer().eInverseRemove(this, MappingPackage.MICROSERVICE_MAPPING__REFERRED_OPERATION_MAPPINGS, MicroserviceMapping.class, msgs);
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
            case MappingPackage.REFERRED_OPERATION_MAPPING__OPERATION:
                if (resolve) return getOperation();
                return basicGetOperation();
            case MappingPackage.REFERRED_OPERATION_MAPPING__ENDPOINTS:
                return getEndpoints();
            case MappingPackage.REFERRED_OPERATION_MAPPING__PROTOCOLS:
                return getProtocols();
            case MappingPackage.REFERRED_OPERATION_MAPPING__ASPECTS:
                return getAspects();
            case MappingPackage.REFERRED_OPERATION_MAPPING__MICROSERVICE_MAPPING:
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
            case MappingPackage.REFERRED_OPERATION_MAPPING__OPERATION:
                setOperation((ReferredOperation)newValue);
                return;
            case MappingPackage.REFERRED_OPERATION_MAPPING__ENDPOINTS:
                getEndpoints().clear();
                getEndpoints().addAll((Collection<? extends TechnologySpecificEndpoint>)newValue);
                return;
            case MappingPackage.REFERRED_OPERATION_MAPPING__PROTOCOLS:
                getProtocols().clear();
                getProtocols().addAll((Collection<? extends TechnologySpecificProtocolSpecification>)newValue);
                return;
            case MappingPackage.REFERRED_OPERATION_MAPPING__ASPECTS:
                getAspects().clear();
                getAspects().addAll((Collection<? extends TechnologySpecificImportedServiceAspect>)newValue);
                return;
            case MappingPackage.REFERRED_OPERATION_MAPPING__MICROSERVICE_MAPPING:
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
            case MappingPackage.REFERRED_OPERATION_MAPPING__OPERATION:
                setOperation((ReferredOperation)null);
                return;
            case MappingPackage.REFERRED_OPERATION_MAPPING__ENDPOINTS:
                getEndpoints().clear();
                return;
            case MappingPackage.REFERRED_OPERATION_MAPPING__PROTOCOLS:
                getProtocols().clear();
                return;
            case MappingPackage.REFERRED_OPERATION_MAPPING__ASPECTS:
                getAspects().clear();
                return;
            case MappingPackage.REFERRED_OPERATION_MAPPING__MICROSERVICE_MAPPING:
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
            case MappingPackage.REFERRED_OPERATION_MAPPING__OPERATION:
                return operation != null;
            case MappingPackage.REFERRED_OPERATION_MAPPING__ENDPOINTS:
                return endpoints != null && !endpoints.isEmpty();
            case MappingPackage.REFERRED_OPERATION_MAPPING__PROTOCOLS:
                return protocols != null && !protocols.isEmpty();
            case MappingPackage.REFERRED_OPERATION_MAPPING__ASPECTS:
                return aspects != null && !aspects.isEmpty();
            case MappingPackage.REFERRED_OPERATION_MAPPING__MICROSERVICE_MAPPING:
                return basicGetMicroserviceMapping() != null;
        }
        return super.eIsSet(featureID);
    }

} //ReferredOperationMappingImpl
