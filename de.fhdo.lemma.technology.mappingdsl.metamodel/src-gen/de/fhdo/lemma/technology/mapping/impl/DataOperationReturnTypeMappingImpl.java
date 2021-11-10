/**
 */
package de.fhdo.lemma.technology.mapping.impl;

import de.fhdo.lemma.data.Type;

import de.fhdo.lemma.service.Import;

import de.fhdo.lemma.technology.mapping.DataOperationMapping;
import de.fhdo.lemma.technology.mapping.DataOperationReturnTypeMapping;
import de.fhdo.lemma.technology.mapping.MappingPackage;
import de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Operation Return Type Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.DataOperationReturnTypeMappingImpl#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.DataOperationReturnTypeMappingImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.DataOperationReturnTypeMappingImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.DataOperationReturnTypeMappingImpl#getOperationMapping <em>Operation Mapping</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataOperationReturnTypeMappingImpl extends MinimalEObjectImpl.Container implements DataOperationReturnTypeMapping {
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
     * The cached value of the '{@link #getType() <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected Type type;

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
    protected DataOperationReturnTypeMappingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MappingPackage.Literals.DATA_OPERATION_RETURN_TYPE_MAPPING;
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__TECHNOLOGY, oldTechnology, technology));
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
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__TECHNOLOGY, oldTechnology, technology));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Type getType() {
        if (type != null && type.eIsProxy()) {
            InternalEObject oldType = (InternalEObject)type;
            type = (Type)eResolveProxy(oldType);
            if (type != oldType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__TYPE, oldType, type));
            }
        }
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Type basicGetType() {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType(Type newType) {
        Type oldType = type;
        type = newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__TYPE, oldType, type));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TechnologySpecificImportedServiceAspect> getAspects() {
        if (aspects == null) {
            aspects = new EObjectContainmentWithInverseEList<TechnologySpecificImportedServiceAspect>(TechnologySpecificImportedServiceAspect.class, this, MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__ASPECTS, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_RETURN_TYPE_MAPPING);
        }
        return aspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataOperationMapping getOperationMapping() {
        if (eContainerFeatureID() != MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__OPERATION_MAPPING) return null;
        return (DataOperationMapping)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataOperationMapping basicGetOperationMapping() {
        if (eContainerFeatureID() != MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__OPERATION_MAPPING) return null;
        return (DataOperationMapping)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOperationMapping(DataOperationMapping newOperationMapping, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOperationMapping, MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__OPERATION_MAPPING, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOperationMapping(DataOperationMapping newOperationMapping) {
        if (newOperationMapping != eInternalContainer() || (eContainerFeatureID() != MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__OPERATION_MAPPING && newOperationMapping != null)) {
            if (EcoreUtil.isAncestor(this, newOperationMapping))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOperationMapping != null)
                msgs = ((InternalEObject)newOperationMapping).eInverseAdd(this, MappingPackage.DATA_OPERATION_MAPPING__RETURN_TYPE_MAPPING, DataOperationMapping.class, msgs);
            msgs = basicSetOperationMapping(newOperationMapping, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__OPERATION_MAPPING, newOperationMapping, newOperationMapping));
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
            case MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__ASPECTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspects()).basicAdd(otherEnd, msgs);
            case MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__OPERATION_MAPPING:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOperationMapping((DataOperationMapping)otherEnd, msgs);
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
            case MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__ASPECTS:
                return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
            case MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__OPERATION_MAPPING:
                return basicSetOperationMapping(null, msgs);
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
            case MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__OPERATION_MAPPING:
                return eInternalContainer().eInverseRemove(this, MappingPackage.DATA_OPERATION_MAPPING__RETURN_TYPE_MAPPING, DataOperationMapping.class, msgs);
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
            case MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__TECHNOLOGY:
                if (resolve) return getTechnology();
                return basicGetTechnology();
            case MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__TYPE:
                if (resolve) return getType();
                return basicGetType();
            case MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__ASPECTS:
                return getAspects();
            case MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__OPERATION_MAPPING:
                if (resolve) return getOperationMapping();
                return basicGetOperationMapping();
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
            case MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__TECHNOLOGY:
                setTechnology((Import)newValue);
                return;
            case MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__TYPE:
                setType((Type)newValue);
                return;
            case MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__ASPECTS:
                getAspects().clear();
                getAspects().addAll((Collection<? extends TechnologySpecificImportedServiceAspect>)newValue);
                return;
            case MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__OPERATION_MAPPING:
                setOperationMapping((DataOperationMapping)newValue);
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
            case MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__TECHNOLOGY:
                setTechnology((Import)null);
                return;
            case MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__TYPE:
                setType((Type)null);
                return;
            case MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__ASPECTS:
                getAspects().clear();
                return;
            case MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__OPERATION_MAPPING:
                setOperationMapping((DataOperationMapping)null);
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
            case MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__TECHNOLOGY:
                return technology != null;
            case MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__TYPE:
                return type != null;
            case MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__ASPECTS:
                return aspects != null && !aspects.isEmpty();
            case MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__OPERATION_MAPPING:
                return basicGetOperationMapping() != null;
        }
        return super.eIsSet(featureID);
    }

} //DataOperationReturnTypeMappingImpl
