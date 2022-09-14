/**
 */
package de.fhdo.lemma.technology.mapping.impl;

import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.TechnologyReference;

import de.fhdo.lemma.technology.Technology;

import de.fhdo.lemma.technology.mapping.ImportedMicroservice;
import de.fhdo.lemma.technology.mapping.InterfaceMapping;
import de.fhdo.lemma.technology.mapping.MappingPackage;
import de.fhdo.lemma.technology.mapping.MicroserviceMapping;
import de.fhdo.lemma.technology.mapping.OperationMapping;
import de.fhdo.lemma.technology.mapping.ReferredOperationMapping;
import de.fhdo.lemma.technology.mapping.TechnologyMapping;
import de.fhdo.lemma.technology.mapping.TechnologySpecificEndpoint;
import de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect;
import de.fhdo.lemma.technology.mapping.TechnologySpecificProtocolSpecification;

import de.fhdo.lemma.utils.LemmaUtils;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Microservice Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.MicroserviceMappingImpl#getTechnologyReferences <em>Technology References</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.MicroserviceMappingImpl#getMicroservice <em>Microservice</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.MicroserviceMappingImpl#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.MicroserviceMappingImpl#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.MicroserviceMappingImpl#getInterfaceMappings <em>Interface Mappings</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.MicroserviceMappingImpl#getOperationMappings <em>Operation Mappings</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.MicroserviceMappingImpl#getReferredOperationMappings <em>Referred Operation Mappings</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.MicroserviceMappingImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.MicroserviceMappingImpl#getMappingModel <em>Mapping Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MicroserviceMappingImpl extends MinimalEObjectImpl.Container implements MicroserviceMapping {
    /**
     * The cached value of the '{@link #getTechnologyReferences() <em>Technology References</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTechnologyReferences()
     * @generated
     * @ordered
     */
    protected EList<TechnologyReference> technologyReferences;

    /**
     * The cached value of the '{@link #getMicroservice() <em>Microservice</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMicroservice()
     * @generated
     * @ordered
     */
    protected ImportedMicroservice microservice;

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
     * The cached value of the '{@link #getInterfaceMappings() <em>Interface Mappings</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInterfaceMappings()
     * @generated
     * @ordered
     */
    protected EList<InterfaceMapping> interfaceMappings;

    /**
     * The cached value of the '{@link #getOperationMappings() <em>Operation Mappings</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperationMappings()
     * @generated
     * @ordered
     */
    protected EList<OperationMapping> operationMappings;

    /**
     * The cached value of the '{@link #getReferredOperationMappings() <em>Referred Operation Mappings</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReferredOperationMappings()
     * @generated
     * @ordered
     */
    protected EList<ReferredOperationMapping> referredOperationMappings;

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
    protected MicroserviceMappingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MappingPackage.Literals.MICROSERVICE_MAPPING;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TechnologyReference> getTechnologyReferences() {
        if (technologyReferences == null) {
            technologyReferences = new EObjectContainmentEList<TechnologyReference>(TechnologyReference.class, this, MappingPackage.MICROSERVICE_MAPPING__TECHNOLOGY_REFERENCES);
        }
        return technologyReferences;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ImportedMicroservice getMicroservice() {
        return microservice;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetMicroservice(ImportedMicroservice newMicroservice, NotificationChain msgs) {
        ImportedMicroservice oldMicroservice = microservice;
        microservice = newMicroservice;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MappingPackage.MICROSERVICE_MAPPING__MICROSERVICE, oldMicroservice, newMicroservice);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMicroservice(ImportedMicroservice newMicroservice) {
        if (newMicroservice != microservice) {
            NotificationChain msgs = null;
            if (microservice != null)
                msgs = ((InternalEObject)microservice).eInverseRemove(this, MappingPackage.IMPORTED_MICROSERVICE__MICROSERVICE_MAPPING, ImportedMicroservice.class, msgs);
            if (newMicroservice != null)
                msgs = ((InternalEObject)newMicroservice).eInverseAdd(this, MappingPackage.IMPORTED_MICROSERVICE__MICROSERVICE_MAPPING, ImportedMicroservice.class, msgs);
            msgs = basicSetMicroservice(newMicroservice, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MICROSERVICE_MAPPING__MICROSERVICE, newMicroservice, newMicroservice));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TechnologySpecificEndpoint> getEndpoints() {
        if (endpoints == null) {
            endpoints = new EObjectContainmentWithInverseEList<TechnologySpecificEndpoint>(TechnologySpecificEndpoint.class, this, MappingPackage.MICROSERVICE_MAPPING__ENDPOINTS, MappingPackage.TECHNOLOGY_SPECIFIC_ENDPOINT__MICROSERVICE_MAPPING);
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
            protocols = new EObjectContainmentEList<TechnologySpecificProtocolSpecification>(TechnologySpecificProtocolSpecification.class, this, MappingPackage.MICROSERVICE_MAPPING__PROTOCOLS);
        }
        return protocols;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<InterfaceMapping> getInterfaceMappings() {
        if (interfaceMappings == null) {
            interfaceMappings = new EObjectContainmentWithInverseEList<InterfaceMapping>(InterfaceMapping.class, this, MappingPackage.MICROSERVICE_MAPPING__INTERFACE_MAPPINGS, MappingPackage.INTERFACE_MAPPING__MICROSERVICE_MAPPING);
        }
        return interfaceMappings;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<OperationMapping> getOperationMappings() {
        if (operationMappings == null) {
            operationMappings = new EObjectContainmentWithInverseEList<OperationMapping>(OperationMapping.class, this, MappingPackage.MICROSERVICE_MAPPING__OPERATION_MAPPINGS, MappingPackage.OPERATION_MAPPING__MICROSERVICE_MAPPING);
        }
        return operationMappings;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ReferredOperationMapping> getReferredOperationMappings() {
        if (referredOperationMappings == null) {
            referredOperationMappings = new EObjectContainmentWithInverseEList<ReferredOperationMapping>(ReferredOperationMapping.class, this, MappingPackage.MICROSERVICE_MAPPING__REFERRED_OPERATION_MAPPINGS, MappingPackage.REFERRED_OPERATION_MAPPING__MICROSERVICE_MAPPING);
        }
        return referredOperationMappings;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TechnologySpecificImportedServiceAspect> getAspects() {
        if (aspects == null) {
            aspects = new EObjectContainmentWithInverseEList<TechnologySpecificImportedServiceAspect>(TechnologySpecificImportedServiceAspect.class, this, MappingPackage.MICROSERVICE_MAPPING__ASPECTS, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__MICROSERVICE_MAPPING);
        }
        return aspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologyMapping getMappingModel() {
        if (eContainerFeatureID() != MappingPackage.MICROSERVICE_MAPPING__MAPPING_MODEL) return null;
        return (TechnologyMapping)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologyMapping basicGetMappingModel() {
        if (eContainerFeatureID() != MappingPackage.MICROSERVICE_MAPPING__MAPPING_MODEL) return null;
        return (TechnologyMapping)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetMappingModel(TechnologyMapping newMappingModel, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newMappingModel, MappingPackage.MICROSERVICE_MAPPING__MAPPING_MODEL, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMappingModel(TechnologyMapping newMappingModel) {
        if (newMappingModel != eInternalContainer() || (eContainerFeatureID() != MappingPackage.MICROSERVICE_MAPPING__MAPPING_MODEL && newMappingModel != null)) {
            if (EcoreUtil.isAncestor(this, newMappingModel))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newMappingModel != null)
                msgs = ((InternalEObject)newMappingModel).eInverseAdd(this, MappingPackage.TECHNOLOGY_MAPPING__SERVICE_MAPPINGS, TechnologyMapping.class, msgs);
            msgs = basicSetMappingModel(newMappingModel, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.MICROSERVICE_MAPPING__MAPPING_MODEL, newMappingModel, newMappingModel));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TechnologyReference> getAllTypeDefinitionTechnologyReferences() {
        final Function1<TechnologyReference, Boolean> _function = new Function1<TechnologyReference, Boolean>() {
            public Boolean apply(final TechnologyReference it) {
                boolean _xblockexpression = false;
                {
                    final Resource resource = it.getTechnology().eResource();
                    final String importURI = it.getTechnology().getImportURI();
                    final Technology technologyModel = LemmaUtils.<Technology>getImportedModelRoot(resource, importURI, Technology.class);
                    _xblockexpression = (((!technologyModel.getPrimitiveTypes().isEmpty()) || 
                        (!technologyModel.getCollectionTypes().isEmpty())) || 
                        (!technologyModel.getDataStructures().isEmpty()));
                }
                return Boolean.valueOf(_xblockexpression);
            }
        };
        return ECollections.<TechnologyReference>toEList(IterableExtensions.<TechnologyReference>filter(this.getTechnologyReferences(), _function));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Import getTypeDefinitionTechnologyImport() {
        final Function1<TechnologyReference, Boolean> _function = new Function1<TechnologyReference, Boolean>() {
            public Boolean apply(final TechnologyReference it) {
                return Boolean.valueOf(it.isIsTypeDefinitionTechnology());
            }
        };
        TechnologyReference _findFirst = IterableExtensions.<TechnologyReference>findFirst(this.getTechnologyReferences(), _function);
        Import _technology = null;
        if (_findFirst!=null) {
            _technology=_findFirst.getTechnology();
        }
        final Import explicitTypeDefinitionTechnologyImport = _technology;
        if ((explicitTypeDefinitionTechnologyImport != null)) {
            return explicitTypeDefinitionTechnologyImport;
        }
        final EList<TechnologyReference> allTypeDefinitionTechnologyReferences = this.getAllTypeDefinitionTechnologyReferences();
        Import _xifexpression = null;
        boolean _isEmpty = allTypeDefinitionTechnologyReferences.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
            _xifexpression = allTypeDefinitionTechnologyReferences.get(0).getTechnology();
        }
        else {
            _xifexpression = null;
        }
        return _xifexpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Technology getTypeDefinitionTechnology() {
        final Import typeDefinitionTechnologyImport = this.getTypeDefinitionTechnologyImport();
        Technology _xifexpression = null;
        if ((typeDefinitionTechnologyImport != null)) {
            _xifexpression = LemmaUtils.<Technology>getImportedModelRoot(
                typeDefinitionTechnologyImport.eResource(), 
                typeDefinitionTechnologyImport.getImportURI(), 
                Technology.class);
        }
        else {
            _xifexpression = null;
        }
        return _xifexpression;
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
            case MappingPackage.MICROSERVICE_MAPPING__MICROSERVICE:
                if (microservice != null)
                    msgs = ((InternalEObject)microservice).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MappingPackage.MICROSERVICE_MAPPING__MICROSERVICE, null, msgs);
                return basicSetMicroservice((ImportedMicroservice)otherEnd, msgs);
            case MappingPackage.MICROSERVICE_MAPPING__ENDPOINTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getEndpoints()).basicAdd(otherEnd, msgs);
            case MappingPackage.MICROSERVICE_MAPPING__INTERFACE_MAPPINGS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getInterfaceMappings()).basicAdd(otherEnd, msgs);
            case MappingPackage.MICROSERVICE_MAPPING__OPERATION_MAPPINGS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getOperationMappings()).basicAdd(otherEnd, msgs);
            case MappingPackage.MICROSERVICE_MAPPING__REFERRED_OPERATION_MAPPINGS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getReferredOperationMappings()).basicAdd(otherEnd, msgs);
            case MappingPackage.MICROSERVICE_MAPPING__ASPECTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspects()).basicAdd(otherEnd, msgs);
            case MappingPackage.MICROSERVICE_MAPPING__MAPPING_MODEL:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetMappingModel((TechnologyMapping)otherEnd, msgs);
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
            case MappingPackage.MICROSERVICE_MAPPING__TECHNOLOGY_REFERENCES:
                return ((InternalEList<?>)getTechnologyReferences()).basicRemove(otherEnd, msgs);
            case MappingPackage.MICROSERVICE_MAPPING__MICROSERVICE:
                return basicSetMicroservice(null, msgs);
            case MappingPackage.MICROSERVICE_MAPPING__ENDPOINTS:
                return ((InternalEList<?>)getEndpoints()).basicRemove(otherEnd, msgs);
            case MappingPackage.MICROSERVICE_MAPPING__PROTOCOLS:
                return ((InternalEList<?>)getProtocols()).basicRemove(otherEnd, msgs);
            case MappingPackage.MICROSERVICE_MAPPING__INTERFACE_MAPPINGS:
                return ((InternalEList<?>)getInterfaceMappings()).basicRemove(otherEnd, msgs);
            case MappingPackage.MICROSERVICE_MAPPING__OPERATION_MAPPINGS:
                return ((InternalEList<?>)getOperationMappings()).basicRemove(otherEnd, msgs);
            case MappingPackage.MICROSERVICE_MAPPING__REFERRED_OPERATION_MAPPINGS:
                return ((InternalEList<?>)getReferredOperationMappings()).basicRemove(otherEnd, msgs);
            case MappingPackage.MICROSERVICE_MAPPING__ASPECTS:
                return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
            case MappingPackage.MICROSERVICE_MAPPING__MAPPING_MODEL:
                return basicSetMappingModel(null, msgs);
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
            case MappingPackage.MICROSERVICE_MAPPING__MAPPING_MODEL:
                return eInternalContainer().eInverseRemove(this, MappingPackage.TECHNOLOGY_MAPPING__SERVICE_MAPPINGS, TechnologyMapping.class, msgs);
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
            case MappingPackage.MICROSERVICE_MAPPING__TECHNOLOGY_REFERENCES:
                return getTechnologyReferences();
            case MappingPackage.MICROSERVICE_MAPPING__MICROSERVICE:
                return getMicroservice();
            case MappingPackage.MICROSERVICE_MAPPING__ENDPOINTS:
                return getEndpoints();
            case MappingPackage.MICROSERVICE_MAPPING__PROTOCOLS:
                return getProtocols();
            case MappingPackage.MICROSERVICE_MAPPING__INTERFACE_MAPPINGS:
                return getInterfaceMappings();
            case MappingPackage.MICROSERVICE_MAPPING__OPERATION_MAPPINGS:
                return getOperationMappings();
            case MappingPackage.MICROSERVICE_MAPPING__REFERRED_OPERATION_MAPPINGS:
                return getReferredOperationMappings();
            case MappingPackage.MICROSERVICE_MAPPING__ASPECTS:
                return getAspects();
            case MappingPackage.MICROSERVICE_MAPPING__MAPPING_MODEL:
                if (resolve) return getMappingModel();
                return basicGetMappingModel();
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
            case MappingPackage.MICROSERVICE_MAPPING__TECHNOLOGY_REFERENCES:
                getTechnologyReferences().clear();
                getTechnologyReferences().addAll((Collection<? extends TechnologyReference>)newValue);
                return;
            case MappingPackage.MICROSERVICE_MAPPING__MICROSERVICE:
                setMicroservice((ImportedMicroservice)newValue);
                return;
            case MappingPackage.MICROSERVICE_MAPPING__ENDPOINTS:
                getEndpoints().clear();
                getEndpoints().addAll((Collection<? extends TechnologySpecificEndpoint>)newValue);
                return;
            case MappingPackage.MICROSERVICE_MAPPING__PROTOCOLS:
                getProtocols().clear();
                getProtocols().addAll((Collection<? extends TechnologySpecificProtocolSpecification>)newValue);
                return;
            case MappingPackage.MICROSERVICE_MAPPING__INTERFACE_MAPPINGS:
                getInterfaceMappings().clear();
                getInterfaceMappings().addAll((Collection<? extends InterfaceMapping>)newValue);
                return;
            case MappingPackage.MICROSERVICE_MAPPING__OPERATION_MAPPINGS:
                getOperationMappings().clear();
                getOperationMappings().addAll((Collection<? extends OperationMapping>)newValue);
                return;
            case MappingPackage.MICROSERVICE_MAPPING__REFERRED_OPERATION_MAPPINGS:
                getReferredOperationMappings().clear();
                getReferredOperationMappings().addAll((Collection<? extends ReferredOperationMapping>)newValue);
                return;
            case MappingPackage.MICROSERVICE_MAPPING__ASPECTS:
                getAspects().clear();
                getAspects().addAll((Collection<? extends TechnologySpecificImportedServiceAspect>)newValue);
                return;
            case MappingPackage.MICROSERVICE_MAPPING__MAPPING_MODEL:
                setMappingModel((TechnologyMapping)newValue);
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
            case MappingPackage.MICROSERVICE_MAPPING__TECHNOLOGY_REFERENCES:
                getTechnologyReferences().clear();
                return;
            case MappingPackage.MICROSERVICE_MAPPING__MICROSERVICE:
                setMicroservice((ImportedMicroservice)null);
                return;
            case MappingPackage.MICROSERVICE_MAPPING__ENDPOINTS:
                getEndpoints().clear();
                return;
            case MappingPackage.MICROSERVICE_MAPPING__PROTOCOLS:
                getProtocols().clear();
                return;
            case MappingPackage.MICROSERVICE_MAPPING__INTERFACE_MAPPINGS:
                getInterfaceMappings().clear();
                return;
            case MappingPackage.MICROSERVICE_MAPPING__OPERATION_MAPPINGS:
                getOperationMappings().clear();
                return;
            case MappingPackage.MICROSERVICE_MAPPING__REFERRED_OPERATION_MAPPINGS:
                getReferredOperationMappings().clear();
                return;
            case MappingPackage.MICROSERVICE_MAPPING__ASPECTS:
                getAspects().clear();
                return;
            case MappingPackage.MICROSERVICE_MAPPING__MAPPING_MODEL:
                setMappingModel((TechnologyMapping)null);
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
            case MappingPackage.MICROSERVICE_MAPPING__TECHNOLOGY_REFERENCES:
                return technologyReferences != null && !technologyReferences.isEmpty();
            case MappingPackage.MICROSERVICE_MAPPING__MICROSERVICE:
                return microservice != null;
            case MappingPackage.MICROSERVICE_MAPPING__ENDPOINTS:
                return endpoints != null && !endpoints.isEmpty();
            case MappingPackage.MICROSERVICE_MAPPING__PROTOCOLS:
                return protocols != null && !protocols.isEmpty();
            case MappingPackage.MICROSERVICE_MAPPING__INTERFACE_MAPPINGS:
                return interfaceMappings != null && !interfaceMappings.isEmpty();
            case MappingPackage.MICROSERVICE_MAPPING__OPERATION_MAPPINGS:
                return operationMappings != null && !operationMappings.isEmpty();
            case MappingPackage.MICROSERVICE_MAPPING__REFERRED_OPERATION_MAPPINGS:
                return referredOperationMappings != null && !referredOperationMappings.isEmpty();
            case MappingPackage.MICROSERVICE_MAPPING__ASPECTS:
                return aspects != null && !aspects.isEmpty();
            case MappingPackage.MICROSERVICE_MAPPING__MAPPING_MODEL:
                return basicGetMappingModel() != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
        switch (operationID) {
            case MappingPackage.MICROSERVICE_MAPPING___GET_ALL_TYPE_DEFINITION_TECHNOLOGY_REFERENCES:
                return getAllTypeDefinitionTechnologyReferences();
            case MappingPackage.MICROSERVICE_MAPPING___GET_TYPE_DEFINITION_TECHNOLOGY_IMPORT:
                return getTypeDefinitionTechnologyImport();
            case MappingPackage.MICROSERVICE_MAPPING___GET_TYPE_DEFINITION_TECHNOLOGY:
                return getTypeDefinitionTechnology();
        }
        return super.eInvoke(operationID, arguments);
    }

} //MicroserviceMappingImpl
