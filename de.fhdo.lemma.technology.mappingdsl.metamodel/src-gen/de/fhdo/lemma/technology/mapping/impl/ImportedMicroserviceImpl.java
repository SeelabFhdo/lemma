/**
 */
package de.fhdo.lemma.technology.mapping.impl;

import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.Microservice;

import de.fhdo.lemma.technology.mapping.ImportedMicroservice;
import de.fhdo.lemma.technology.mapping.MappingPackage;
import de.fhdo.lemma.technology.mapping.MicroserviceMapping;

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
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.ImportedMicroserviceImpl#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.ImportedMicroserviceImpl#getMicroservice <em>Microservice</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.ImportedMicroserviceImpl#getMicroserviceMapping <em>Microservice Mapping</em>}</li>
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
        return MappingPackage.Literals.IMPORTED_MICROSERVICE;
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.IMPORTED_MICROSERVICE__IMPORT, oldImport, import_));
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
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.IMPORTED_MICROSERVICE__IMPORT, oldImport, import_));
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.IMPORTED_MICROSERVICE__MICROSERVICE, oldMicroservice, microservice));
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
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.IMPORTED_MICROSERVICE__MICROSERVICE, oldMicroservice, microservice));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public MicroserviceMapping getMicroserviceMapping() {
        if (eContainerFeatureID() != MappingPackage.IMPORTED_MICROSERVICE__MICROSERVICE_MAPPING) return null;
        return (MicroserviceMapping)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MicroserviceMapping basicGetMicroserviceMapping() {
        if (eContainerFeatureID() != MappingPackage.IMPORTED_MICROSERVICE__MICROSERVICE_MAPPING) return null;
        return (MicroserviceMapping)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetMicroserviceMapping(MicroserviceMapping newMicroserviceMapping, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newMicroserviceMapping, MappingPackage.IMPORTED_MICROSERVICE__MICROSERVICE_MAPPING, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setMicroserviceMapping(MicroserviceMapping newMicroserviceMapping) {
        if (newMicroserviceMapping != eInternalContainer() || (eContainerFeatureID() != MappingPackage.IMPORTED_MICROSERVICE__MICROSERVICE_MAPPING && newMicroserviceMapping != null)) {
            if (EcoreUtil.isAncestor(this, newMicroserviceMapping))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newMicroserviceMapping != null)
                msgs = ((InternalEObject)newMicroserviceMapping).eInverseAdd(this, MappingPackage.MICROSERVICE_MAPPING__MICROSERVICE, MicroserviceMapping.class, msgs);
            msgs = basicSetMicroserviceMapping(newMicroserviceMapping, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.IMPORTED_MICROSERVICE__MICROSERVICE_MAPPING, newMicroserviceMapping, newMicroserviceMapping));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MappingPackage.IMPORTED_MICROSERVICE__MICROSERVICE_MAPPING:
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
            case MappingPackage.IMPORTED_MICROSERVICE__MICROSERVICE_MAPPING:
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
            case MappingPackage.IMPORTED_MICROSERVICE__MICROSERVICE_MAPPING:
                return eInternalContainer().eInverseRemove(this, MappingPackage.MICROSERVICE_MAPPING__MICROSERVICE, MicroserviceMapping.class, msgs);
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
            case MappingPackage.IMPORTED_MICROSERVICE__IMPORT:
                if (resolve) return getImport();
                return basicGetImport();
            case MappingPackage.IMPORTED_MICROSERVICE__MICROSERVICE:
                if (resolve) return getMicroservice();
                return basicGetMicroservice();
            case MappingPackage.IMPORTED_MICROSERVICE__MICROSERVICE_MAPPING:
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
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case MappingPackage.IMPORTED_MICROSERVICE__IMPORT:
                setImport((Import)newValue);
                return;
            case MappingPackage.IMPORTED_MICROSERVICE__MICROSERVICE:
                setMicroservice((Microservice)newValue);
                return;
            case MappingPackage.IMPORTED_MICROSERVICE__MICROSERVICE_MAPPING:
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
            case MappingPackage.IMPORTED_MICROSERVICE__IMPORT:
                setImport((Import)null);
                return;
            case MappingPackage.IMPORTED_MICROSERVICE__MICROSERVICE:
                setMicroservice((Microservice)null);
                return;
            case MappingPackage.IMPORTED_MICROSERVICE__MICROSERVICE_MAPPING:
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
            case MappingPackage.IMPORTED_MICROSERVICE__IMPORT:
                return import_ != null;
            case MappingPackage.IMPORTED_MICROSERVICE__MICROSERVICE:
                return microservice != null;
            case MappingPackage.IMPORTED_MICROSERVICE__MICROSERVICE_MAPPING:
                return basicGetMicroserviceMapping() != null;
        }
        return super.eIsSet(featureID);
    }

} //ImportedMicroserviceImpl
