/**
 */
package de.fhdo.ddmm.technology.mapping.impl;

import de.fhdo.ddmm.data.EnumerationField;
import de.fhdo.ddmm.data.Type;

import de.fhdo.ddmm.service.Import;

import de.fhdo.ddmm.technology.mapping.ComplexParameterMapping;
import de.fhdo.ddmm.technology.mapping.DataFieldHierarchy;
import de.fhdo.ddmm.technology.mapping.MappingPackage;
import de.fhdo.ddmm.technology.mapping.TechnologySpecificFieldMapping;
import de.fhdo.ddmm.technology.mapping.TechnologySpecificImportedServiceAspect;

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
 * An implementation of the model object '<em><b>Technology Specific Field Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.TechnologySpecificFieldMappingImpl#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.TechnologySpecificFieldMappingImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.TechnologySpecificFieldMappingImpl#getEnumerationField <em>Enumeration Field</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.TechnologySpecificFieldMappingImpl#getDataFieldHierarchy <em>Data Field Hierarchy</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.TechnologySpecificFieldMappingImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.TechnologySpecificFieldMappingImpl#getParameterMapping <em>Parameter Mapping</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TechnologySpecificFieldMappingImpl extends MinimalEObjectImpl.Container implements TechnologySpecificFieldMapping {
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
     * The cached value of the '{@link #getEnumerationField() <em>Enumeration Field</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEnumerationField()
     * @generated
     * @ordered
     */
    protected EnumerationField enumerationField;

    /**
     * The cached value of the '{@link #getDataFieldHierarchy() <em>Data Field Hierarchy</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataFieldHierarchy()
     * @generated
     * @ordered
     */
    protected DataFieldHierarchy dataFieldHierarchy;

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
    protected TechnologySpecificFieldMappingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MappingPackage.Literals.TECHNOLOGY_SPECIFIC_FIELD_MAPPING;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Import getTechnology() {
        if (technology != null && technology.eIsProxy()) {
            InternalEObject oldTechnology = (InternalEObject)technology;
            technology = (Import)eResolveProxy(oldTechnology);
            if (technology != oldTechnology) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__TECHNOLOGY, oldTechnology, technology));
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
    @Override
    public void setTechnology(Import newTechnology) {
        Import oldTechnology = technology;
        technology = newTechnology;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__TECHNOLOGY, oldTechnology, technology));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Type getType() {
        if (type != null && type.eIsProxy()) {
            InternalEObject oldType = (InternalEObject)type;
            type = (Type)eResolveProxy(oldType);
            if (type != oldType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__TYPE, oldType, type));
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
    @Override
    public void setType(Type newType) {
        Type oldType = type;
        type = newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__TYPE, oldType, type));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EnumerationField getEnumerationField() {
        if (enumerationField != null && enumerationField.eIsProxy()) {
            InternalEObject oldEnumerationField = (InternalEObject)enumerationField;
            enumerationField = (EnumerationField)eResolveProxy(oldEnumerationField);
            if (enumerationField != oldEnumerationField) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__ENUMERATION_FIELD, oldEnumerationField, enumerationField));
            }
        }
        return enumerationField;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EnumerationField basicGetEnumerationField() {
        return enumerationField;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setEnumerationField(EnumerationField newEnumerationField) {
        EnumerationField oldEnumerationField = enumerationField;
        enumerationField = newEnumerationField;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__ENUMERATION_FIELD, oldEnumerationField, enumerationField));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DataFieldHierarchy getDataFieldHierarchy() {
        return dataFieldHierarchy;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDataFieldHierarchy(DataFieldHierarchy newDataFieldHierarchy, NotificationChain msgs) {
        DataFieldHierarchy oldDataFieldHierarchy = dataFieldHierarchy;
        dataFieldHierarchy = newDataFieldHierarchy;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__DATA_FIELD_HIERARCHY, oldDataFieldHierarchy, newDataFieldHierarchy);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setDataFieldHierarchy(DataFieldHierarchy newDataFieldHierarchy) {
        if (newDataFieldHierarchy != dataFieldHierarchy) {
            NotificationChain msgs = null;
            if (dataFieldHierarchy != null)
                msgs = ((InternalEObject)dataFieldHierarchy).eInverseRemove(this, MappingPackage.DATA_FIELD_HIERARCHY__MAPPING, DataFieldHierarchy.class, msgs);
            if (newDataFieldHierarchy != null)
                msgs = ((InternalEObject)newDataFieldHierarchy).eInverseAdd(this, MappingPackage.DATA_FIELD_HIERARCHY__MAPPING, DataFieldHierarchy.class, msgs);
            msgs = basicSetDataFieldHierarchy(newDataFieldHierarchy, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__DATA_FIELD_HIERARCHY, newDataFieldHierarchy, newDataFieldHierarchy));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<TechnologySpecificImportedServiceAspect> getAspects() {
        if (aspects == null) {
            aspects = new EObjectContainmentWithInverseEList<TechnologySpecificImportedServiceAspect>(TechnologySpecificImportedServiceAspect.class, this, MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__ASPECTS, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__FIELD_MAPPING);
        }
        return aspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ComplexParameterMapping getParameterMapping() {
        if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__PARAMETER_MAPPING) return null;
        return (ComplexParameterMapping)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComplexParameterMapping basicGetParameterMapping() {
        if (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__PARAMETER_MAPPING) return null;
        return (ComplexParameterMapping)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetParameterMapping(ComplexParameterMapping newParameterMapping, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newParameterMapping, MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__PARAMETER_MAPPING, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setParameterMapping(ComplexParameterMapping newParameterMapping) {
        if (newParameterMapping != eInternalContainer() || (eContainerFeatureID() != MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__PARAMETER_MAPPING && newParameterMapping != null)) {
            if (EcoreUtil.isAncestor(this, newParameterMapping))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newParameterMapping != null)
                msgs = ((InternalEObject)newParameterMapping).eInverseAdd(this, MappingPackage.COMPLEX_PARAMETER_MAPPING__FIELD_MAPPINGS, ComplexParameterMapping.class, msgs);
            msgs = basicSetParameterMapping(newParameterMapping, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__PARAMETER_MAPPING, newParameterMapping, newParameterMapping));
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
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__DATA_FIELD_HIERARCHY:
                if (dataFieldHierarchy != null)
                    msgs = ((InternalEObject)dataFieldHierarchy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__DATA_FIELD_HIERARCHY, null, msgs);
                return basicSetDataFieldHierarchy((DataFieldHierarchy)otherEnd, msgs);
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__ASPECTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspects()).basicAdd(otherEnd, msgs);
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__PARAMETER_MAPPING:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetParameterMapping((ComplexParameterMapping)otherEnd, msgs);
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
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__DATA_FIELD_HIERARCHY:
                return basicSetDataFieldHierarchy(null, msgs);
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__ASPECTS:
                return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__PARAMETER_MAPPING:
                return basicSetParameterMapping(null, msgs);
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
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__PARAMETER_MAPPING:
                return eInternalContainer().eInverseRemove(this, MappingPackage.COMPLEX_PARAMETER_MAPPING__FIELD_MAPPINGS, ComplexParameterMapping.class, msgs);
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
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__TECHNOLOGY:
                if (resolve) return getTechnology();
                return basicGetTechnology();
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__TYPE:
                if (resolve) return getType();
                return basicGetType();
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__ENUMERATION_FIELD:
                if (resolve) return getEnumerationField();
                return basicGetEnumerationField();
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__DATA_FIELD_HIERARCHY:
                return getDataFieldHierarchy();
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__ASPECTS:
                return getAspects();
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__PARAMETER_MAPPING:
                if (resolve) return getParameterMapping();
                return basicGetParameterMapping();
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
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__TECHNOLOGY:
                setTechnology((Import)newValue);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__TYPE:
                setType((Type)newValue);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__ENUMERATION_FIELD:
                setEnumerationField((EnumerationField)newValue);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__DATA_FIELD_HIERARCHY:
                setDataFieldHierarchy((DataFieldHierarchy)newValue);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__ASPECTS:
                getAspects().clear();
                getAspects().addAll((Collection<? extends TechnologySpecificImportedServiceAspect>)newValue);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__PARAMETER_MAPPING:
                setParameterMapping((ComplexParameterMapping)newValue);
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
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__TECHNOLOGY:
                setTechnology((Import)null);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__TYPE:
                setType((Type)null);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__ENUMERATION_FIELD:
                setEnumerationField((EnumerationField)null);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__DATA_FIELD_HIERARCHY:
                setDataFieldHierarchy((DataFieldHierarchy)null);
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__ASPECTS:
                getAspects().clear();
                return;
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__PARAMETER_MAPPING:
                setParameterMapping((ComplexParameterMapping)null);
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
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__TECHNOLOGY:
                return technology != null;
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__TYPE:
                return type != null;
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__ENUMERATION_FIELD:
                return enumerationField != null;
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__DATA_FIELD_HIERARCHY:
                return dataFieldHierarchy != null;
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__ASPECTS:
                return aspects != null && !aspects.isEmpty();
            case MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__PARAMETER_MAPPING:
                return basicGetParameterMapping() != null;
        }
        return super.eIsSet(featureID);
    }

} //TechnologySpecificFieldMappingImpl
