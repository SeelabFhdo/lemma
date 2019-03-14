/**
 */
package de.fhdo.ddmm.service.impl;

import de.fhdo.ddmm.service.Import;
import de.fhdo.ddmm.service.Microservice;
import de.fhdo.ddmm.service.PossiblyImportedMicroservice;
import de.fhdo.ddmm.service.ServicePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Possibly Imported Microservice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.service.impl.PossiblyImportedMicroserviceImpl#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.PossiblyImportedMicroserviceImpl#getMicroservice <em>Microservice</em>}</li>
 *   <li>{@link de.fhdo.ddmm.service.impl.PossiblyImportedMicroserviceImpl#getRequiringMicroservice <em>Requiring Microservice</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PossiblyImportedMicroserviceImpl extends MinimalEObjectImpl.Container implements PossiblyImportedMicroservice {
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
    protected PossiblyImportedMicroserviceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ServicePackage.Literals.POSSIBLY_IMPORTED_MICROSERVICE;
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE__IMPORT, oldImport, import_));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE__IMPORT, oldImport, import_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Microservice getMicroservice() {
        if (microservice != null && microservice.eIsProxy()) {
            InternalEObject oldMicroservice = (InternalEObject)microservice;
            microservice = (Microservice)eResolveProxy(oldMicroservice);
            if (microservice != oldMicroservice) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE__MICROSERVICE, oldMicroservice, microservice));
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
    @Override
    public void setMicroservice(Microservice newMicroservice) {
        Microservice oldMicroservice = microservice;
        microservice = newMicroservice;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE__MICROSERVICE, oldMicroservice, microservice));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Microservice getRequiringMicroservice() {
        if (eContainerFeatureID() != ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE__REQUIRING_MICROSERVICE) return null;
        return (Microservice)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Microservice basicGetRequiringMicroservice() {
        if (eContainerFeatureID() != ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE__REQUIRING_MICROSERVICE) return null;
        return (Microservice)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetRequiringMicroservice(Microservice newRequiringMicroservice, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newRequiringMicroservice, ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE__REQUIRING_MICROSERVICE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setRequiringMicroservice(Microservice newRequiringMicroservice) {
        if (newRequiringMicroservice != eInternalContainer() || (eContainerFeatureID() != ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE__REQUIRING_MICROSERVICE && newRequiringMicroservice != null)) {
            if (EcoreUtil.isAncestor(this, newRequiringMicroservice))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newRequiringMicroservice != null)
                msgs = ((InternalEObject)newRequiringMicroservice).eInverseAdd(this, ServicePackage.MICROSERVICE__REQUIRED_MICROSERVICES, Microservice.class, msgs);
            msgs = basicSetRequiringMicroservice(newRequiringMicroservice, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE__REQUIRING_MICROSERVICE, newRequiringMicroservice, newRequiringMicroservice));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE__REQUIRING_MICROSERVICE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetRequiringMicroservice((Microservice)otherEnd, msgs);
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
            case ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE__REQUIRING_MICROSERVICE:
                return basicSetRequiringMicroservice(null, msgs);
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
            case ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE__REQUIRING_MICROSERVICE:
                return eInternalContainer().eInverseRemove(this, ServicePackage.MICROSERVICE__REQUIRED_MICROSERVICES, Microservice.class, msgs);
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
            case ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE__IMPORT:
                if (resolve) return getImport();
                return basicGetImport();
            case ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE__MICROSERVICE:
                if (resolve) return getMicroservice();
                return basicGetMicroservice();
            case ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE__REQUIRING_MICROSERVICE:
                if (resolve) return getRequiringMicroservice();
                return basicGetRequiringMicroservice();
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
            case ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE__IMPORT:
                setImport((Import)newValue);
                return;
            case ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE__MICROSERVICE:
                setMicroservice((Microservice)newValue);
                return;
            case ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE__REQUIRING_MICROSERVICE:
                setRequiringMicroservice((Microservice)newValue);
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
            case ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE__IMPORT:
                setImport((Import)null);
                return;
            case ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE__MICROSERVICE:
                setMicroservice((Microservice)null);
                return;
            case ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE__REQUIRING_MICROSERVICE:
                setRequiringMicroservice((Microservice)null);
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
            case ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE__IMPORT:
                return import_ != null;
            case ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE__MICROSERVICE:
                return microservice != null;
            case ServicePackage.POSSIBLY_IMPORTED_MICROSERVICE__REQUIRING_MICROSERVICE:
                return basicGetRequiringMicroservice() != null;
        }
        return super.eIsSet(featureID);
    }

} //PossiblyImportedMicroserviceImpl
