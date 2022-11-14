/**
 */
package de.fhdo.lemma.operation.impl;

import de.fhdo.lemma.operation.BasicEndpoint;
import de.fhdo.lemma.operation.DeploymentTechnologyReference;
import de.fhdo.lemma.operation.OperationModel;
import de.fhdo.lemma.operation.OperationPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.impl.ContainerImpl#getDeploymentTechnology <em>Deployment Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.ContainerImpl#getDefaultBasicEndpoints <em>Default Basic Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.ContainerImpl#getOperationModel <em>Operation Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContainerImpl extends OperationNodeImpl implements de.fhdo.lemma.operation.Container {
    /**
     * The cached value of the '{@link #getDeploymentTechnology() <em>Deployment Technology</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDeploymentTechnology()
     * @generated
     * @ordered
     */
    protected DeploymentTechnologyReference deploymentTechnology;

    /**
     * The cached value of the '{@link #getDefaultBasicEndpoints() <em>Default Basic Endpoints</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultBasicEndpoints()
     * @generated
     * @ordered
     */
    protected EList<BasicEndpoint> defaultBasicEndpoints;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ContainerImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return OperationPackage.Literals.CONTAINER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DeploymentTechnologyReference getDeploymentTechnology() {
        return deploymentTechnology;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDeploymentTechnology(DeploymentTechnologyReference newDeploymentTechnology, NotificationChain msgs) {
        DeploymentTechnologyReference oldDeploymentTechnology = deploymentTechnology;
        deploymentTechnology = newDeploymentTechnology;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationPackage.CONTAINER__DEPLOYMENT_TECHNOLOGY, oldDeploymentTechnology, newDeploymentTechnology);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDeploymentTechnology(DeploymentTechnologyReference newDeploymentTechnology) {
        if (newDeploymentTechnology != deploymentTechnology) {
            NotificationChain msgs = null;
            if (deploymentTechnology != null)
                msgs = ((InternalEObject)deploymentTechnology).eInverseRemove(this, OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER, DeploymentTechnologyReference.class, msgs);
            if (newDeploymentTechnology != null)
                msgs = ((InternalEObject)newDeploymentTechnology).eInverseAdd(this, OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER, DeploymentTechnologyReference.class, msgs);
            msgs = basicSetDeploymentTechnology(newDeploymentTechnology, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.CONTAINER__DEPLOYMENT_TECHNOLOGY, newDeploymentTechnology, newDeploymentTechnology));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<BasicEndpoint> getDefaultBasicEndpoints() {
        if (defaultBasicEndpoints == null) {
            defaultBasicEndpoints = new EObjectContainmentWithInverseEList<BasicEndpoint>(BasicEndpoint.class, this, OperationPackage.CONTAINER__DEFAULT_BASIC_ENDPOINTS, OperationPackage.BASIC_ENDPOINT__CONTAINER);
        }
        return defaultBasicEndpoints;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationModel getOperationModel() {
        if (eContainerFeatureID() != OperationPackage.CONTAINER__OPERATION_MODEL) return null;
        return (OperationModel)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationModel basicGetOperationModel() {
        if (eContainerFeatureID() != OperationPackage.CONTAINER__OPERATION_MODEL) return null;
        return (OperationModel)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOperationModel(OperationModel newOperationModel, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOperationModel, OperationPackage.CONTAINER__OPERATION_MODEL, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOperationModel(OperationModel newOperationModel) {
        if (newOperationModel != eInternalContainer() || (eContainerFeatureID() != OperationPackage.CONTAINER__OPERATION_MODEL && newOperationModel != null)) {
            if (EcoreUtil.isAncestor(this, newOperationModel))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOperationModel != null)
                msgs = ((InternalEObject)newOperationModel).eInverseAdd(this, OperationPackage.OPERATION_MODEL__CONTAINERS, OperationModel.class, msgs);
            msgs = basicSetOperationModel(newOperationModel, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.CONTAINER__OPERATION_MODEL, newOperationModel, newOperationModel));
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
            case OperationPackage.CONTAINER__DEPLOYMENT_TECHNOLOGY:
                if (deploymentTechnology != null)
                    msgs = ((InternalEObject)deploymentTechnology).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OperationPackage.CONTAINER__DEPLOYMENT_TECHNOLOGY, null, msgs);
                return basicSetDeploymentTechnology((DeploymentTechnologyReference)otherEnd, msgs);
            case OperationPackage.CONTAINER__DEFAULT_BASIC_ENDPOINTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getDefaultBasicEndpoints()).basicAdd(otherEnd, msgs);
            case OperationPackage.CONTAINER__OPERATION_MODEL:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOperationModel((OperationModel)otherEnd, msgs);
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
            case OperationPackage.CONTAINER__DEPLOYMENT_TECHNOLOGY:
                return basicSetDeploymentTechnology(null, msgs);
            case OperationPackage.CONTAINER__DEFAULT_BASIC_ENDPOINTS:
                return ((InternalEList<?>)getDefaultBasicEndpoints()).basicRemove(otherEnd, msgs);
            case OperationPackage.CONTAINER__OPERATION_MODEL:
                return basicSetOperationModel(null, msgs);
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
            case OperationPackage.CONTAINER__OPERATION_MODEL:
                return eInternalContainer().eInverseRemove(this, OperationPackage.OPERATION_MODEL__CONTAINERS, OperationModel.class, msgs);
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
            case OperationPackage.CONTAINER__DEPLOYMENT_TECHNOLOGY:
                return getDeploymentTechnology();
            case OperationPackage.CONTAINER__DEFAULT_BASIC_ENDPOINTS:
                return getDefaultBasicEndpoints();
            case OperationPackage.CONTAINER__OPERATION_MODEL:
                if (resolve) return getOperationModel();
                return basicGetOperationModel();
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
            case OperationPackage.CONTAINER__DEPLOYMENT_TECHNOLOGY:
                setDeploymentTechnology((DeploymentTechnologyReference)newValue);
                return;
            case OperationPackage.CONTAINER__DEFAULT_BASIC_ENDPOINTS:
                getDefaultBasicEndpoints().clear();
                getDefaultBasicEndpoints().addAll((Collection<? extends BasicEndpoint>)newValue);
                return;
            case OperationPackage.CONTAINER__OPERATION_MODEL:
                setOperationModel((OperationModel)newValue);
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
            case OperationPackage.CONTAINER__DEPLOYMENT_TECHNOLOGY:
                setDeploymentTechnology((DeploymentTechnologyReference)null);
                return;
            case OperationPackage.CONTAINER__DEFAULT_BASIC_ENDPOINTS:
                getDefaultBasicEndpoints().clear();
                return;
            case OperationPackage.CONTAINER__OPERATION_MODEL:
                setOperationModel((OperationModel)null);
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
            case OperationPackage.CONTAINER__DEPLOYMENT_TECHNOLOGY:
                return deploymentTechnology != null;
            case OperationPackage.CONTAINER__DEFAULT_BASIC_ENDPOINTS:
                return defaultBasicEndpoints != null && !defaultBasicEndpoints.isEmpty();
            case OperationPackage.CONTAINER__OPERATION_MODEL:
                return basicGetOperationModel() != null;
        }
        return super.eIsSet(featureID);
    }

} //ContainerImpl
