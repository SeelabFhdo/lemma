/**
 */
package de.fhdo.lemma.operation.impl;

import de.fhdo.lemma.operation.DeploymentTechnologyReference;
import de.fhdo.lemma.operation.OperationPackage;

import de.fhdo.lemma.service.Import;

import de.fhdo.lemma.technology.DeploymentTechnology;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deployment Technology Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.impl.DeploymentTechnologyReferenceImpl#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.DeploymentTechnologyReferenceImpl#getDeploymentTechnology <em>Deployment Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.DeploymentTechnologyReferenceImpl#getContainer <em>Container</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeploymentTechnologyReferenceImpl extends MinimalEObjectImpl.Container implements DeploymentTechnologyReference {
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
     * The cached value of the '{@link #getDeploymentTechnology() <em>Deployment Technology</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDeploymentTechnology()
     * @generated
     * @ordered
     */
    protected DeploymentTechnology deploymentTechnology;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DeploymentTechnologyReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return OperationPackage.Literals.DEPLOYMENT_TECHNOLOGY_REFERENCE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Import getImport() {
        if (import_ != null && import_.eIsProxy()) {
            InternalEObject oldImport = (InternalEObject)import_;
            import_ = (Import)eResolveProxy(oldImport);
            if (import_ != oldImport) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT, oldImport, import_));
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
    public void setImport(Import newImport) {
        Import oldImport = import_;
        import_ = newImport;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT, oldImport, import_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DeploymentTechnology getDeploymentTechnology() {
        if (deploymentTechnology != null && deploymentTechnology.eIsProxy()) {
            InternalEObject oldDeploymentTechnology = (InternalEObject)deploymentTechnology;
            deploymentTechnology = (DeploymentTechnology)eResolveProxy(oldDeploymentTechnology);
            if (deploymentTechnology != oldDeploymentTechnology) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__DEPLOYMENT_TECHNOLOGY, oldDeploymentTechnology, deploymentTechnology));
            }
        }
        return deploymentTechnology;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DeploymentTechnology basicGetDeploymentTechnology() {
        return deploymentTechnology;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDeploymentTechnology(DeploymentTechnology newDeploymentTechnology) {
        DeploymentTechnology oldDeploymentTechnology = deploymentTechnology;
        deploymentTechnology = newDeploymentTechnology;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__DEPLOYMENT_TECHNOLOGY, oldDeploymentTechnology, deploymentTechnology));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public de.fhdo.lemma.operation.Container getContainer() {
        if (eContainerFeatureID() != OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER) return null;
        return (de.fhdo.lemma.operation.Container)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public de.fhdo.lemma.operation.Container basicGetContainer() {
        if (eContainerFeatureID() != OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER) return null;
        return (de.fhdo.lemma.operation.Container)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetContainer(de.fhdo.lemma.operation.Container newContainer, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newContainer, OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setContainer(de.fhdo.lemma.operation.Container newContainer) {
        if (newContainer != eInternalContainer() || (eContainerFeatureID() != OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER && newContainer != null)) {
            if (EcoreUtil.isAncestor(this, newContainer))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newContainer != null)
                msgs = ((InternalEObject)newContainer).eInverseAdd(this, OperationPackage.CONTAINER__DEPLOYMENT_TECHNOLOGY, de.fhdo.lemma.operation.Container.class, msgs);
            msgs = basicSetContainer(newContainer, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER, newContainer, newContainer));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetContainer((de.fhdo.lemma.operation.Container)otherEnd, msgs);
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
            case OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER:
                return basicSetContainer(null, msgs);
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
            case OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER:
                return eInternalContainer().eInverseRemove(this, OperationPackage.CONTAINER__DEPLOYMENT_TECHNOLOGY, de.fhdo.lemma.operation.Container.class, msgs);
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
            case OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT:
                if (resolve) return getImport();
                return basicGetImport();
            case OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__DEPLOYMENT_TECHNOLOGY:
                if (resolve) return getDeploymentTechnology();
                return basicGetDeploymentTechnology();
            case OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER:
                if (resolve) return getContainer();
                return basicGetContainer();
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
            case OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT:
                setImport((Import)newValue);
                return;
            case OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__DEPLOYMENT_TECHNOLOGY:
                setDeploymentTechnology((DeploymentTechnology)newValue);
                return;
            case OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER:
                setContainer((de.fhdo.lemma.operation.Container)newValue);
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
            case OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT:
                setImport((Import)null);
                return;
            case OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__DEPLOYMENT_TECHNOLOGY:
                setDeploymentTechnology((DeploymentTechnology)null);
                return;
            case OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER:
                setContainer((de.fhdo.lemma.operation.Container)null);
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
            case OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__IMPORT:
                return import_ != null;
            case OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__DEPLOYMENT_TECHNOLOGY:
                return deploymentTechnology != null;
            case OperationPackage.DEPLOYMENT_TECHNOLOGY_REFERENCE__CONTAINER:
                return basicGetContainer() != null;
        }
        return super.eIsSet(featureID);
    }

} //DeploymentTechnologyReferenceImpl
