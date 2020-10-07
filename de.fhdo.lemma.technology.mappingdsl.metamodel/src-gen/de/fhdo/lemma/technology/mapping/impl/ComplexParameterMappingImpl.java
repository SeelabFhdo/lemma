/**
 */
package de.fhdo.lemma.technology.mapping.impl;

import de.fhdo.lemma.data.ComplexType;

import de.fhdo.lemma.service.Import;

import de.fhdo.lemma.technology.mapping.ComplexParameterMapping;
import de.fhdo.lemma.technology.mapping.MappingPackage;
import de.fhdo.lemma.technology.mapping.TechnologySpecificFieldMapping;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Parameter Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.ComplexParameterMappingImpl#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.ComplexParameterMappingImpl#getTechnologySpecificComplexType <em>Technology Specific Complex Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.ComplexParameterMappingImpl#getFieldMappings <em>Field Mappings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComplexParameterMappingImpl extends ParameterMappingImpl implements ComplexParameterMapping {
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
     * The cached value of the '{@link #getTechnologySpecificComplexType() <em>Technology Specific Complex Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTechnologySpecificComplexType()
     * @generated
     * @ordered
     */
    protected ComplexType technologySpecificComplexType;

    /**
     * The cached value of the '{@link #getFieldMappings() <em>Field Mappings</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFieldMappings()
     * @generated
     * @ordered
     */
    protected EList<TechnologySpecificFieldMapping> fieldMappings;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ComplexParameterMappingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MappingPackage.Literals.COMPLEX_PARAMETER_MAPPING;
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.COMPLEX_PARAMETER_MAPPING__TECHNOLOGY, oldTechnology, technology));
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
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.COMPLEX_PARAMETER_MAPPING__TECHNOLOGY, oldTechnology, technology));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ComplexType getTechnologySpecificComplexType() {
        if (technologySpecificComplexType != null && technologySpecificComplexType.eIsProxy()) {
            InternalEObject oldTechnologySpecificComplexType = (InternalEObject)technologySpecificComplexType;
            technologySpecificComplexType = (ComplexType)eResolveProxy(oldTechnologySpecificComplexType);
            if (technologySpecificComplexType != oldTechnologySpecificComplexType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.COMPLEX_PARAMETER_MAPPING__TECHNOLOGY_SPECIFIC_COMPLEX_TYPE, oldTechnologySpecificComplexType, technologySpecificComplexType));
            }
        }
        return technologySpecificComplexType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComplexType basicGetTechnologySpecificComplexType() {
        return technologySpecificComplexType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setTechnologySpecificComplexType(ComplexType newTechnologySpecificComplexType) {
        ComplexType oldTechnologySpecificComplexType = technologySpecificComplexType;
        technologySpecificComplexType = newTechnologySpecificComplexType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.COMPLEX_PARAMETER_MAPPING__TECHNOLOGY_SPECIFIC_COMPLEX_TYPE, oldTechnologySpecificComplexType, technologySpecificComplexType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<TechnologySpecificFieldMapping> getFieldMappings() {
        if (fieldMappings == null) {
            fieldMappings = new EObjectContainmentWithInverseEList<TechnologySpecificFieldMapping>(TechnologySpecificFieldMapping.class, this, MappingPackage.COMPLEX_PARAMETER_MAPPING__FIELD_MAPPINGS, MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__PARAMETER_MAPPING);
        }
        return fieldMappings;
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
            case MappingPackage.COMPLEX_PARAMETER_MAPPING__FIELD_MAPPINGS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getFieldMappings()).basicAdd(otherEnd, msgs);
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
            case MappingPackage.COMPLEX_PARAMETER_MAPPING__FIELD_MAPPINGS:
                return ((InternalEList<?>)getFieldMappings()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MappingPackage.COMPLEX_PARAMETER_MAPPING__TECHNOLOGY:
                if (resolve) return getTechnology();
                return basicGetTechnology();
            case MappingPackage.COMPLEX_PARAMETER_MAPPING__TECHNOLOGY_SPECIFIC_COMPLEX_TYPE:
                if (resolve) return getTechnologySpecificComplexType();
                return basicGetTechnologySpecificComplexType();
            case MappingPackage.COMPLEX_PARAMETER_MAPPING__FIELD_MAPPINGS:
                return getFieldMappings();
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
            case MappingPackage.COMPLEX_PARAMETER_MAPPING__TECHNOLOGY:
                setTechnology((Import)newValue);
                return;
            case MappingPackage.COMPLEX_PARAMETER_MAPPING__TECHNOLOGY_SPECIFIC_COMPLEX_TYPE:
                setTechnologySpecificComplexType((ComplexType)newValue);
                return;
            case MappingPackage.COMPLEX_PARAMETER_MAPPING__FIELD_MAPPINGS:
                getFieldMappings().clear();
                getFieldMappings().addAll((Collection<? extends TechnologySpecificFieldMapping>)newValue);
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
            case MappingPackage.COMPLEX_PARAMETER_MAPPING__TECHNOLOGY:
                setTechnology((Import)null);
                return;
            case MappingPackage.COMPLEX_PARAMETER_MAPPING__TECHNOLOGY_SPECIFIC_COMPLEX_TYPE:
                setTechnologySpecificComplexType((ComplexType)null);
                return;
            case MappingPackage.COMPLEX_PARAMETER_MAPPING__FIELD_MAPPINGS:
                getFieldMappings().clear();
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
            case MappingPackage.COMPLEX_PARAMETER_MAPPING__TECHNOLOGY:
                return technology != null;
            case MappingPackage.COMPLEX_PARAMETER_MAPPING__TECHNOLOGY_SPECIFIC_COMPLEX_TYPE:
                return technologySpecificComplexType != null;
            case MappingPackage.COMPLEX_PARAMETER_MAPPING__FIELD_MAPPINGS:
                return fieldMappings != null && !fieldMappings.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //ComplexParameterMappingImpl
