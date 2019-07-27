/**
 */
package de.fhdo.lemma.operation.impl;

import de.fhdo.lemma.operation.InfrastructureNode;
import de.fhdo.lemma.operation.InfrastructureTechnologyReference;
import de.fhdo.lemma.operation.OperationPackage;

import de.fhdo.lemma.service.Import;

import de.fhdo.lemma.technology.InfrastructureTechnology;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Infrastructure Technology Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.impl.InfrastructureTechnologyReferenceImpl#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.InfrastructureTechnologyReferenceImpl#getInfrastructureTechnology <em>Infrastructure Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.InfrastructureTechnologyReferenceImpl#getInfrastructureNode <em>Infrastructure Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InfrastructureTechnologyReferenceImpl extends MinimalEObjectImpl.Container implements InfrastructureTechnologyReference {
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
     * The cached value of the '{@link #getInfrastructureTechnology() <em>Infrastructure Technology</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInfrastructureTechnology()
     * @generated
     * @ordered
     */
    protected InfrastructureTechnology infrastructureTechnology;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected InfrastructureTechnologyReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return OperationPackage.Literals.INFRASTRUCTURE_TECHNOLOGY_REFERENCE;
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__IMPORT, oldImport, import_));
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
            eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__IMPORT, oldImport, import_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public InfrastructureTechnology getInfrastructureTechnology() {
        if (infrastructureTechnology != null && infrastructureTechnology.eIsProxy()) {
            InternalEObject oldInfrastructureTechnology = (InternalEObject)infrastructureTechnology;
            infrastructureTechnology = (InfrastructureTechnology)eResolveProxy(oldInfrastructureTechnology);
            if (infrastructureTechnology != oldInfrastructureTechnology) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_TECHNOLOGY, oldInfrastructureTechnology, infrastructureTechnology));
            }
        }
        return infrastructureTechnology;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureTechnology basicGetInfrastructureTechnology() {
        return infrastructureTechnology;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setInfrastructureTechnology(InfrastructureTechnology newInfrastructureTechnology) {
        InfrastructureTechnology oldInfrastructureTechnology = infrastructureTechnology;
        infrastructureTechnology = newInfrastructureTechnology;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_TECHNOLOGY, oldInfrastructureTechnology, infrastructureTechnology));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public InfrastructureNode getInfrastructureNode() {
        if (eContainerFeatureID() != OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE) return null;
        return (InfrastructureNode)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public InfrastructureNode basicGetInfrastructureNode() {
        if (eContainerFeatureID() != OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE) return null;
        return (InfrastructureNode)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInfrastructureNode(InfrastructureNode newInfrastructureNode, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newInfrastructureNode, OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setInfrastructureNode(InfrastructureNode newInfrastructureNode) {
        if (newInfrastructureNode != eInternalContainer() || (eContainerFeatureID() != OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE && newInfrastructureNode != null)) {
            if (EcoreUtil.isAncestor(this, newInfrastructureNode))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newInfrastructureNode != null)
                msgs = ((InternalEObject)newInfrastructureNode).eInverseAdd(this, OperationPackage.INFRASTRUCTURE_NODE__INFRASTRUCTURE_TECHNOLOGY, InfrastructureNode.class, msgs);
            msgs = basicSetInfrastructureNode(newInfrastructureNode, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE, newInfrastructureNode, newInfrastructureNode));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetInfrastructureNode((InfrastructureNode)otherEnd, msgs);
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
            case OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE:
                return basicSetInfrastructureNode(null, msgs);
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
            case OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE:
                return eInternalContainer().eInverseRemove(this, OperationPackage.INFRASTRUCTURE_NODE__INFRASTRUCTURE_TECHNOLOGY, InfrastructureNode.class, msgs);
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
            case OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__IMPORT:
                if (resolve) return getImport();
                return basicGetImport();
            case OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_TECHNOLOGY:
                if (resolve) return getInfrastructureTechnology();
                return basicGetInfrastructureTechnology();
            case OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE:
                if (resolve) return getInfrastructureNode();
                return basicGetInfrastructureNode();
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
            case OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__IMPORT:
                setImport((Import)newValue);
                return;
            case OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_TECHNOLOGY:
                setInfrastructureTechnology((InfrastructureTechnology)newValue);
                return;
            case OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE:
                setInfrastructureNode((InfrastructureNode)newValue);
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
            case OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__IMPORT:
                setImport((Import)null);
                return;
            case OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_TECHNOLOGY:
                setInfrastructureTechnology((InfrastructureTechnology)null);
                return;
            case OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE:
                setInfrastructureNode((InfrastructureNode)null);
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
            case OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__IMPORT:
                return import_ != null;
            case OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_TECHNOLOGY:
                return infrastructureTechnology != null;
            case OperationPackage.INFRASTRUCTURE_TECHNOLOGY_REFERENCE__INFRASTRUCTURE_NODE:
                return basicGetInfrastructureNode() != null;
        }
        return super.eIsSet(featureID);
    }

} //InfrastructureTechnologyReferenceImpl
