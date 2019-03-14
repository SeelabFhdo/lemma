/**
 */
package de.fhdo.ddmm.operation.impl;

import de.fhdo.ddmm.operation.BasicEndpoint;
import de.fhdo.ddmm.operation.ImportedMicroservice;
import de.fhdo.ddmm.operation.OperationNode;
import de.fhdo.ddmm.operation.OperationPackage;
import de.fhdo.ddmm.operation.ServiceDeploymentSpecification;

import de.fhdo.ddmm.service.Import;

import de.fhdo.ddmm.technology.TechnologySpecificPropertyValueAssignment;

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
 * An implementation of the model object '<em><b>Service Deployment Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.operation.impl.ServiceDeploymentSpecificationImpl#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.ddmm.operation.impl.ServiceDeploymentSpecificationImpl#getService <em>Service</em>}</li>
 *   <li>{@link de.fhdo.ddmm.operation.impl.ServiceDeploymentSpecificationImpl#getServicePropertyValues <em>Service Property Values</em>}</li>
 *   <li>{@link de.fhdo.ddmm.operation.impl.ServiceDeploymentSpecificationImpl#getBasicEndpoints <em>Basic Endpoints</em>}</li>
 *   <li>{@link de.fhdo.ddmm.operation.impl.ServiceDeploymentSpecificationImpl#getOperationNode <em>Operation Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ServiceDeploymentSpecificationImpl extends MinimalEObjectImpl.Container implements ServiceDeploymentSpecification {
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
     * The cached value of the '{@link #getService() <em>Service</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getService()
     * @generated
     * @ordered
     */
    protected ImportedMicroservice service;

    /**
     * The cached value of the '{@link #getServicePropertyValues() <em>Service Property Values</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getServicePropertyValues()
     * @generated
     * @ordered
     */
    protected EList<TechnologySpecificPropertyValueAssignment> servicePropertyValues;

    /**
     * The cached value of the '{@link #getBasicEndpoints() <em>Basic Endpoints</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBasicEndpoints()
     * @generated
     * @ordered
     */
    protected EList<BasicEndpoint> basicEndpoints;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ServiceDeploymentSpecificationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return OperationPackage.Literals.SERVICE_DEPLOYMENT_SPECIFICATION;
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__IMPORT, oldImport, import_));
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
            eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__IMPORT, oldImport, import_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ImportedMicroservice getService() {
        if (service != null && service.eIsProxy()) {
            InternalEObject oldService = (InternalEObject)service;
            service = (ImportedMicroservice)eResolveProxy(oldService);
            if (service != oldService) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__SERVICE, oldService, service));
            }
        }
        return service;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ImportedMicroservice basicGetService() {
        return service;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setService(ImportedMicroservice newService) {
        ImportedMicroservice oldService = service;
        service = newService;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__SERVICE, oldService, service));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<TechnologySpecificPropertyValueAssignment> getServicePropertyValues() {
        if (servicePropertyValues == null) {
            servicePropertyValues = new EObjectContainmentEList<TechnologySpecificPropertyValueAssignment>(TechnologySpecificPropertyValueAssignment.class, this, OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__SERVICE_PROPERTY_VALUES);
        }
        return servicePropertyValues;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<BasicEndpoint> getBasicEndpoints() {
        if (basicEndpoints == null) {
            basicEndpoints = new EObjectContainmentWithInverseEList<BasicEndpoint>(BasicEndpoint.class, this, OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__BASIC_ENDPOINTS, OperationPackage.BASIC_ENDPOINT__DEPLOYMENT_SPECIFICATION);
        }
        return basicEndpoints;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public OperationNode getOperationNode() {
        if (eContainerFeatureID() != OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE) return null;
        return (OperationNode)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationNode basicGetOperationNode() {
        if (eContainerFeatureID() != OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE) return null;
        return (OperationNode)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOperationNode(OperationNode newOperationNode, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOperationNode, OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setOperationNode(OperationNode newOperationNode) {
        if (newOperationNode != eInternalContainer() || (eContainerFeatureID() != OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE && newOperationNode != null)) {
            if (EcoreUtil.isAncestor(this, newOperationNode))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOperationNode != null)
                msgs = ((InternalEObject)newOperationNode).eInverseAdd(this, OperationPackage.OPERATION_NODE__DEPLOYMENT_SPECIFICATIONS, OperationNode.class, msgs);
            msgs = basicSetOperationNode(newOperationNode, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE, newOperationNode, newOperationNode));
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
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__BASIC_ENDPOINTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getBasicEndpoints()).basicAdd(otherEnd, msgs);
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOperationNode((OperationNode)otherEnd, msgs);
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
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__SERVICE_PROPERTY_VALUES:
                return ((InternalEList<?>)getServicePropertyValues()).basicRemove(otherEnd, msgs);
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__BASIC_ENDPOINTS:
                return ((InternalEList<?>)getBasicEndpoints()).basicRemove(otherEnd, msgs);
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE:
                return basicSetOperationNode(null, msgs);
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
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE:
                return eInternalContainer().eInverseRemove(this, OperationPackage.OPERATION_NODE__DEPLOYMENT_SPECIFICATIONS, OperationNode.class, msgs);
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
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__IMPORT:
                if (resolve) return getImport();
                return basicGetImport();
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__SERVICE:
                if (resolve) return getService();
                return basicGetService();
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__SERVICE_PROPERTY_VALUES:
                return getServicePropertyValues();
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__BASIC_ENDPOINTS:
                return getBasicEndpoints();
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE:
                if (resolve) return getOperationNode();
                return basicGetOperationNode();
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
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__IMPORT:
                setImport((Import)newValue);
                return;
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__SERVICE:
                setService((ImportedMicroservice)newValue);
                return;
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__SERVICE_PROPERTY_VALUES:
                getServicePropertyValues().clear();
                getServicePropertyValues().addAll((Collection<? extends TechnologySpecificPropertyValueAssignment>)newValue);
                return;
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__BASIC_ENDPOINTS:
                getBasicEndpoints().clear();
                getBasicEndpoints().addAll((Collection<? extends BasicEndpoint>)newValue);
                return;
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE:
                setOperationNode((OperationNode)newValue);
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
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__IMPORT:
                setImport((Import)null);
                return;
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__SERVICE:
                setService((ImportedMicroservice)null);
                return;
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__SERVICE_PROPERTY_VALUES:
                getServicePropertyValues().clear();
                return;
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__BASIC_ENDPOINTS:
                getBasicEndpoints().clear();
                return;
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE:
                setOperationNode((OperationNode)null);
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
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__IMPORT:
                return import_ != null;
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__SERVICE:
                return service != null;
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__SERVICE_PROPERTY_VALUES:
                return servicePropertyValues != null && !servicePropertyValues.isEmpty();
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__BASIC_ENDPOINTS:
                return basicEndpoints != null && !basicEndpoints.isEmpty();
            case OperationPackage.SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE:
                return basicGetOperationNode() != null;
        }
        return super.eIsSet(featureID);
    }

} //ServiceDeploymentSpecificationImpl
