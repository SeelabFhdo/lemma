/**
 */
package de.fhdo.lemma.operation.impl;

import de.fhdo.lemma.operation.ImportedMicroservice;
import de.fhdo.lemma.operation.OperationNode;
import de.fhdo.lemma.operation.OperationPackage;

import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.Microservice;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Imported Microservice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.impl.ImportedMicroserviceImpl#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.ImportedMicroserviceImpl#getMicroservice <em>Microservice</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.ImportedMicroserviceImpl#getOperationNode <em>Operation Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImportedMicroserviceImpl extends MinimalEObjectImpl.Container implements ImportedMicroservice {
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
     * The cached value of the '{@link #getMicroservice() <em>Microservice</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMicroservice()
     * @generated
     * @ordered
     */
    protected Microservice microservice;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ImportedMicroserviceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return OperationPackage.Literals.IMPORTED_MICROSERVICE;
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationPackage.IMPORTED_MICROSERVICE__IMPORT, oldImport, import_));
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
            eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.IMPORTED_MICROSERVICE__IMPORT, oldImport, import_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Microservice getMicroservice() {
        if (microservice != null && microservice.eIsProxy()) {
            InternalEObject oldMicroservice = (InternalEObject)microservice;
            microservice = (Microservice)eResolveProxy(oldMicroservice);
            if (microservice != oldMicroservice) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationPackage.IMPORTED_MICROSERVICE__MICROSERVICE, oldMicroservice, microservice));
            }
        }
        return microservice;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Microservice basicGetMicroservice() {
        return microservice;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMicroservice(Microservice newMicroservice) {
        Microservice oldMicroservice = microservice;
        microservice = newMicroservice;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.IMPORTED_MICROSERVICE__MICROSERVICE, oldMicroservice, microservice));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationNode getOperationNode() {
        if (eContainerFeatureID() != OperationPackage.IMPORTED_MICROSERVICE__OPERATION_NODE) return null;
        return (OperationNode)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationNode basicGetOperationNode() {
        if (eContainerFeatureID() != OperationPackage.IMPORTED_MICROSERVICE__OPERATION_NODE) return null;
        return (OperationNode)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOperationNode(OperationNode newOperationNode, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOperationNode, OperationPackage.IMPORTED_MICROSERVICE__OPERATION_NODE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOperationNode(OperationNode newOperationNode) {
        if (newOperationNode != eInternalContainer() || (eContainerFeatureID() != OperationPackage.IMPORTED_MICROSERVICE__OPERATION_NODE && newOperationNode != null)) {
            if (EcoreUtil.isAncestor(this, newOperationNode))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOperationNode != null)
                msgs = ((InternalEObject)newOperationNode).eInverseAdd(this, OperationPackage.OPERATION_NODE__DEPLOYED_SERVICES, OperationNode.class, msgs);
            msgs = basicSetOperationNode(newOperationNode, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.IMPORTED_MICROSERVICE__OPERATION_NODE, newOperationNode, newOperationNode));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case OperationPackage.IMPORTED_MICROSERVICE__OPERATION_NODE:
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
            case OperationPackage.IMPORTED_MICROSERVICE__OPERATION_NODE:
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
            case OperationPackage.IMPORTED_MICROSERVICE__OPERATION_NODE:
                return eInternalContainer().eInverseRemove(this, OperationPackage.OPERATION_NODE__DEPLOYED_SERVICES, OperationNode.class, msgs);
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
            case OperationPackage.IMPORTED_MICROSERVICE__IMPORT:
                if (resolve) return getImport();
                return basicGetImport();
            case OperationPackage.IMPORTED_MICROSERVICE__MICROSERVICE:
                if (resolve) return getMicroservice();
                return basicGetMicroservice();
            case OperationPackage.IMPORTED_MICROSERVICE__OPERATION_NODE:
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
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case OperationPackage.IMPORTED_MICROSERVICE__IMPORT:
                setImport((Import)newValue);
                return;
            case OperationPackage.IMPORTED_MICROSERVICE__MICROSERVICE:
                setMicroservice((Microservice)newValue);
                return;
            case OperationPackage.IMPORTED_MICROSERVICE__OPERATION_NODE:
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
            case OperationPackage.IMPORTED_MICROSERVICE__IMPORT:
                setImport((Import)null);
                return;
            case OperationPackage.IMPORTED_MICROSERVICE__MICROSERVICE:
                setMicroservice((Microservice)null);
                return;
            case OperationPackage.IMPORTED_MICROSERVICE__OPERATION_NODE:
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
            case OperationPackage.IMPORTED_MICROSERVICE__IMPORT:
                return import_ != null;
            case OperationPackage.IMPORTED_MICROSERVICE__MICROSERVICE:
                return microservice != null;
            case OperationPackage.IMPORTED_MICROSERVICE__OPERATION_NODE:
                return basicGetOperationNode() != null;
        }
        return super.eIsSet(featureID);
    }

} //ImportedMicroserviceImpl
