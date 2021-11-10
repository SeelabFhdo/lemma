/**
 */
package de.fhdo.lemma.service.impl;

import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.MappedComplexType;
import de.fhdo.lemma.service.Microservice;
import de.fhdo.lemma.service.ServicePackage;
import de.fhdo.lemma.service.TechnologyReference;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Technology Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.impl.TechnologyReferenceImpl#isIsTypeDefinitionTechnology <em>Is Type Definition Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.TechnologyReferenceImpl#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.TechnologyReferenceImpl#getMicroservice <em>Microservice</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.TechnologyReferenceImpl#getMappedComplexType <em>Mapped Complex Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TechnologyReferenceImpl extends MinimalEObjectImpl.Container implements TechnologyReference {
    /**
     * The default value of the '{@link #isIsTypeDefinitionTechnology() <em>Is Type Definition Technology</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsTypeDefinitionTechnology()
     * @generated
     * @ordered
     */
    protected static final boolean IS_TYPE_DEFINITION_TECHNOLOGY_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIsTypeDefinitionTechnology() <em>Is Type Definition Technology</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsTypeDefinitionTechnology()
     * @generated
     * @ordered
     */
    protected boolean isTypeDefinitionTechnology = IS_TYPE_DEFINITION_TECHNOLOGY_EDEFAULT;

    /**
     * The cached value of the '{@link #getTechnology() <em>Technology</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTechnology()
     * @generated
     * @ordered
     */
    protected Import technology;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TechnologyReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ServicePackage.Literals.TECHNOLOGY_REFERENCE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isIsTypeDefinitionTechnology() {
        return isTypeDefinitionTechnology;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIsTypeDefinitionTechnology(boolean newIsTypeDefinitionTechnology) {
        boolean oldIsTypeDefinitionTechnology = isTypeDefinitionTechnology;
        isTypeDefinitionTechnology = newIsTypeDefinitionTechnology;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.TECHNOLOGY_REFERENCE__IS_TYPE_DEFINITION_TECHNOLOGY, oldIsTypeDefinitionTechnology, isTypeDefinitionTechnology));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Import getTechnology() {
        if (technology != null && technology.eIsProxy()) {
            InternalEObject oldTechnology = (InternalEObject)technology;
            technology = (Import)eResolveProxy(oldTechnology);
            if (technology != oldTechnology) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicePackage.TECHNOLOGY_REFERENCE__TECHNOLOGY, oldTechnology, technology));
            }
        }
        return technology;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Import basicGetTechnology() {
        return technology;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTechnology(Import newTechnology) {
        Import oldTechnology = technology;
        technology = newTechnology;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.TECHNOLOGY_REFERENCE__TECHNOLOGY, oldTechnology, technology));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Microservice getMicroservice() {
        if (eContainerFeatureID() != ServicePackage.TECHNOLOGY_REFERENCE__MICROSERVICE) return null;
        return (Microservice)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Microservice basicGetMicroservice() {
        if (eContainerFeatureID() != ServicePackage.TECHNOLOGY_REFERENCE__MICROSERVICE) return null;
        return (Microservice)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetMicroservice(Microservice newMicroservice, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newMicroservice, ServicePackage.TECHNOLOGY_REFERENCE__MICROSERVICE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMicroservice(Microservice newMicroservice) {
        if (newMicroservice != eInternalContainer() || (eContainerFeatureID() != ServicePackage.TECHNOLOGY_REFERENCE__MICROSERVICE && newMicroservice != null)) {
            if (EcoreUtil.isAncestor(this, newMicroservice))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newMicroservice != null)
                msgs = ((InternalEObject)newMicroservice).eInverseAdd(this, ServicePackage.MICROSERVICE__TECHNOLOGY_REFERENCES, Microservice.class, msgs);
            msgs = basicSetMicroservice(newMicroservice, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.TECHNOLOGY_REFERENCE__MICROSERVICE, newMicroservice, newMicroservice));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MappedComplexType getMappedComplexType() {
        if (eContainerFeatureID() != ServicePackage.TECHNOLOGY_REFERENCE__MAPPED_COMPLEX_TYPE) return null;
        return (MappedComplexType)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MappedComplexType basicGetMappedComplexType() {
        if (eContainerFeatureID() != ServicePackage.TECHNOLOGY_REFERENCE__MAPPED_COMPLEX_TYPE) return null;
        return (MappedComplexType)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetMappedComplexType(MappedComplexType newMappedComplexType, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newMappedComplexType, ServicePackage.TECHNOLOGY_REFERENCE__MAPPED_COMPLEX_TYPE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMappedComplexType(MappedComplexType newMappedComplexType) {
        if (newMappedComplexType != eInternalContainer() || (eContainerFeatureID() != ServicePackage.TECHNOLOGY_REFERENCE__MAPPED_COMPLEX_TYPE && newMappedComplexType != null)) {
            if (EcoreUtil.isAncestor(this, newMappedComplexType))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newMappedComplexType != null)
                msgs = ((InternalEObject)newMappedComplexType).eInverseAdd(this, ServicePackage.MAPPED_COMPLEX_TYPE__TECHNOLOGY_REFERENCES, MappedComplexType.class, msgs);
            msgs = basicSetMappedComplexType(newMappedComplexType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.TECHNOLOGY_REFERENCE__MAPPED_COMPLEX_TYPE, newMappedComplexType, newMappedComplexType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ServicePackage.TECHNOLOGY_REFERENCE__MICROSERVICE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetMicroservice((Microservice)otherEnd, msgs);
            case ServicePackage.TECHNOLOGY_REFERENCE__MAPPED_COMPLEX_TYPE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetMappedComplexType((MappedComplexType)otherEnd, msgs);
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
            case ServicePackage.TECHNOLOGY_REFERENCE__MICROSERVICE:
                return basicSetMicroservice(null, msgs);
            case ServicePackage.TECHNOLOGY_REFERENCE__MAPPED_COMPLEX_TYPE:
                return basicSetMappedComplexType(null, msgs);
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
            case ServicePackage.TECHNOLOGY_REFERENCE__MICROSERVICE:
                return eInternalContainer().eInverseRemove(this, ServicePackage.MICROSERVICE__TECHNOLOGY_REFERENCES, Microservice.class, msgs);
            case ServicePackage.TECHNOLOGY_REFERENCE__MAPPED_COMPLEX_TYPE:
                return eInternalContainer().eInverseRemove(this, ServicePackage.MAPPED_COMPLEX_TYPE__TECHNOLOGY_REFERENCES, MappedComplexType.class, msgs);
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
            case ServicePackage.TECHNOLOGY_REFERENCE__IS_TYPE_DEFINITION_TECHNOLOGY:
                return isIsTypeDefinitionTechnology();
            case ServicePackage.TECHNOLOGY_REFERENCE__TECHNOLOGY:
                if (resolve) return getTechnology();
                return basicGetTechnology();
            case ServicePackage.TECHNOLOGY_REFERENCE__MICROSERVICE:
                if (resolve) return getMicroservice();
                return basicGetMicroservice();
            case ServicePackage.TECHNOLOGY_REFERENCE__MAPPED_COMPLEX_TYPE:
                if (resolve) return getMappedComplexType();
                return basicGetMappedComplexType();
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
            case ServicePackage.TECHNOLOGY_REFERENCE__IS_TYPE_DEFINITION_TECHNOLOGY:
                setIsTypeDefinitionTechnology((Boolean)newValue);
                return;
            case ServicePackage.TECHNOLOGY_REFERENCE__TECHNOLOGY:
                setTechnology((Import)newValue);
                return;
            case ServicePackage.TECHNOLOGY_REFERENCE__MICROSERVICE:
                setMicroservice((Microservice)newValue);
                return;
            case ServicePackage.TECHNOLOGY_REFERENCE__MAPPED_COMPLEX_TYPE:
                setMappedComplexType((MappedComplexType)newValue);
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
            case ServicePackage.TECHNOLOGY_REFERENCE__IS_TYPE_DEFINITION_TECHNOLOGY:
                setIsTypeDefinitionTechnology(IS_TYPE_DEFINITION_TECHNOLOGY_EDEFAULT);
                return;
            case ServicePackage.TECHNOLOGY_REFERENCE__TECHNOLOGY:
                setTechnology((Import)null);
                return;
            case ServicePackage.TECHNOLOGY_REFERENCE__MICROSERVICE:
                setMicroservice((Microservice)null);
                return;
            case ServicePackage.TECHNOLOGY_REFERENCE__MAPPED_COMPLEX_TYPE:
                setMappedComplexType((MappedComplexType)null);
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
            case ServicePackage.TECHNOLOGY_REFERENCE__IS_TYPE_DEFINITION_TECHNOLOGY:
                return isTypeDefinitionTechnology != IS_TYPE_DEFINITION_TECHNOLOGY_EDEFAULT;
            case ServicePackage.TECHNOLOGY_REFERENCE__TECHNOLOGY:
                return technology != null;
            case ServicePackage.TECHNOLOGY_REFERENCE__MICROSERVICE:
                return basicGetMicroservice() != null;
            case ServicePackage.TECHNOLOGY_REFERENCE__MAPPED_COMPLEX_TYPE:
                return basicGetMappedComplexType() != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (isTypeDefinitionTechnology: ");
        result.append(isTypeDefinitionTechnology);
        result.append(')');
        return result.toString();
    }

} //TechnologyReferenceImpl
