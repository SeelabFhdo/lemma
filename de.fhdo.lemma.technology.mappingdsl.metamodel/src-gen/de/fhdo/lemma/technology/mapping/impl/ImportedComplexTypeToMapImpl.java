/**
 */
package de.fhdo.lemma.technology.mapping.impl;

import de.fhdo.lemma.data.ComplexType;

import de.fhdo.lemma.service.Import;

import de.fhdo.lemma.technology.mapping.ComplexTypeMapping;
import de.fhdo.lemma.technology.mapping.ImportedComplexTypeToMap;
import de.fhdo.lemma.technology.mapping.MappingPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Imported Complex Type To Map</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.ImportedComplexTypeToMapImpl#getServiceModelImport <em>Service Model Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.ImportedComplexTypeToMapImpl#getDataModelImport <em>Data Model Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.ImportedComplexTypeToMapImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.ImportedComplexTypeToMapImpl#getTypeMapping <em>Type Mapping</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImportedComplexTypeToMapImpl extends MinimalEObjectImpl.Container implements ImportedComplexTypeToMap {
    /**
     * The cached value of the '{@link #getServiceModelImport() <em>Service Model Import</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getServiceModelImport()
     * @generated
     * @ordered
     */
    protected Import serviceModelImport;

    /**
     * The cached value of the '{@link #getDataModelImport() <em>Data Model Import</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataModelImport()
     * @generated
     * @ordered
     */
    protected Import dataModelImport;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected ComplexType type;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ImportedComplexTypeToMapImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MappingPackage.Literals.IMPORTED_COMPLEX_TYPE_TO_MAP;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Import getServiceModelImport() {
        if (serviceModelImport != null && serviceModelImport.eIsProxy()) {
            InternalEObject oldServiceModelImport = (InternalEObject)serviceModelImport;
            serviceModelImport = (Import)eResolveProxy(oldServiceModelImport);
            if (serviceModelImport != oldServiceModelImport) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__SERVICE_MODEL_IMPORT, oldServiceModelImport, serviceModelImport));
            }
        }
        return serviceModelImport;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Import basicGetServiceModelImport() {
        return serviceModelImport;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setServiceModelImport(Import newServiceModelImport) {
        Import oldServiceModelImport = serviceModelImport;
        serviceModelImport = newServiceModelImport;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__SERVICE_MODEL_IMPORT, oldServiceModelImport, serviceModelImport));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Import getDataModelImport() {
        if (dataModelImport != null && dataModelImport.eIsProxy()) {
            InternalEObject oldDataModelImport = (InternalEObject)dataModelImport;
            dataModelImport = (Import)eResolveProxy(oldDataModelImport);
            if (dataModelImport != oldDataModelImport) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__DATA_MODEL_IMPORT, oldDataModelImport, dataModelImport));
            }
        }
        return dataModelImport;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Import basicGetDataModelImport() {
        return dataModelImport;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setDataModelImport(Import newDataModelImport) {
        Import oldDataModelImport = dataModelImport;
        dataModelImport = newDataModelImport;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__DATA_MODEL_IMPORT, oldDataModelImport, dataModelImport));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ComplexType getType() {
        if (type != null && type.eIsProxy()) {
            InternalEObject oldType = (InternalEObject)type;
            type = (ComplexType)eResolveProxy(oldType);
            if (type != oldType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__TYPE, oldType, type));
            }
        }
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComplexType basicGetType() {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setType(ComplexType newType) {
        ComplexType oldType = type;
        type = newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__TYPE, oldType, type));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ComplexTypeMapping getTypeMapping() {
        if (eContainerFeatureID() != MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__TYPE_MAPPING) return null;
        return (ComplexTypeMapping)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComplexTypeMapping basicGetTypeMapping() {
        if (eContainerFeatureID() != MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__TYPE_MAPPING) return null;
        return (ComplexTypeMapping)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTypeMapping(ComplexTypeMapping newTypeMapping, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newTypeMapping, MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__TYPE_MAPPING, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setTypeMapping(ComplexTypeMapping newTypeMapping) {
        if (newTypeMapping != eInternalContainer() || (eContainerFeatureID() != MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__TYPE_MAPPING && newTypeMapping != null)) {
            if (EcoreUtil.isAncestor(this, newTypeMapping))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newTypeMapping != null)
                msgs = ((InternalEObject)newTypeMapping).eInverseAdd(this, MappingPackage.COMPLEX_TYPE_MAPPING__TYPE, ComplexTypeMapping.class, msgs);
            msgs = basicSetTypeMapping(newTypeMapping, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__TYPE_MAPPING, newTypeMapping, newTypeMapping));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__TYPE_MAPPING:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetTypeMapping((ComplexTypeMapping)otherEnd, msgs);
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
            case MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__TYPE_MAPPING:
                return basicSetTypeMapping(null, msgs);
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
            case MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__TYPE_MAPPING:
                return eInternalContainer().eInverseRemove(this, MappingPackage.COMPLEX_TYPE_MAPPING__TYPE, ComplexTypeMapping.class, msgs);
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
            case MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__SERVICE_MODEL_IMPORT:
                if (resolve) return getServiceModelImport();
                return basicGetServiceModelImport();
            case MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__DATA_MODEL_IMPORT:
                if (resolve) return getDataModelImport();
                return basicGetDataModelImport();
            case MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__TYPE:
                if (resolve) return getType();
                return basicGetType();
            case MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__TYPE_MAPPING:
                if (resolve) return getTypeMapping();
                return basicGetTypeMapping();
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
            case MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__SERVICE_MODEL_IMPORT:
                setServiceModelImport((Import)newValue);
                return;
            case MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__DATA_MODEL_IMPORT:
                setDataModelImport((Import)newValue);
                return;
            case MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__TYPE:
                setType((ComplexType)newValue);
                return;
            case MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__TYPE_MAPPING:
                setTypeMapping((ComplexTypeMapping)newValue);
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
            case MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__SERVICE_MODEL_IMPORT:
                setServiceModelImport((Import)null);
                return;
            case MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__DATA_MODEL_IMPORT:
                setDataModelImport((Import)null);
                return;
            case MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__TYPE:
                setType((ComplexType)null);
                return;
            case MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__TYPE_MAPPING:
                setTypeMapping((ComplexTypeMapping)null);
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
            case MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__SERVICE_MODEL_IMPORT:
                return serviceModelImport != null;
            case MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__DATA_MODEL_IMPORT:
                return dataModelImport != null;
            case MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__TYPE:
                return type != null;
            case MappingPackage.IMPORTED_COMPLEX_TYPE_TO_MAP__TYPE_MAPPING:
                return basicGetTypeMapping() != null;
        }
        return super.eIsSet(featureID);
    }

} //ImportedComplexTypeToMapImpl
