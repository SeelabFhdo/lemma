/**
 */
package de.fhdo.ddmm.technology.mapping.impl;

import de.fhdo.ddmm.data.DataField;

import de.fhdo.ddmm.technology.mapping.DataFieldHierarchy;
import de.fhdo.ddmm.technology.mapping.MappingPackage;
import de.fhdo.ddmm.technology.mapping.TechnologySpecificDataFieldTypeMapping;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Field Hierarchy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.DataFieldHierarchyImpl#getDataFields <em>Data Fields</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.DataFieldHierarchyImpl#getPrevious <em>Previous</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.DataFieldHierarchyImpl#getMapping <em>Mapping</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataFieldHierarchyImpl extends MinimalEObjectImpl.Container implements DataFieldHierarchy {
    /**
     * The cached value of the '{@link #getDataFields() <em>Data Fields</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataFields()
     * @generated
     * @ordered
     */
    protected EList<DataField> dataFields;

    /**
     * The cached value of the '{@link #getPrevious() <em>Previous</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPrevious()
     * @generated
     * @ordered
     */
    protected DataFieldHierarchy previous;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DataFieldHierarchyImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MappingPackage.Literals.DATA_FIELD_HIERARCHY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<DataField> getDataFields() {
        if (dataFields == null) {
            dataFields = new EObjectResolvingEList<DataField>(DataField.class, this, MappingPackage.DATA_FIELD_HIERARCHY__DATA_FIELDS);
        }
        return dataFields;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataFieldHierarchy getPrevious() {
        return previous;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPrevious(DataFieldHierarchy newPrevious, NotificationChain msgs) {
        DataFieldHierarchy oldPrevious = previous;
        previous = newPrevious;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MappingPackage.DATA_FIELD_HIERARCHY__PREVIOUS, oldPrevious, newPrevious);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPrevious(DataFieldHierarchy newPrevious) {
        if (newPrevious != previous) {
            NotificationChain msgs = null;
            if (previous != null)
                msgs = ((InternalEObject)previous).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MappingPackage.DATA_FIELD_HIERARCHY__PREVIOUS, null, msgs);
            if (newPrevious != null)
                msgs = ((InternalEObject)newPrevious).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MappingPackage.DATA_FIELD_HIERARCHY__PREVIOUS, null, msgs);
            msgs = basicSetPrevious(newPrevious, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.DATA_FIELD_HIERARCHY__PREVIOUS, newPrevious, newPrevious));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologySpecificDataFieldTypeMapping getMapping() {
        if (eContainerFeatureID() != MappingPackage.DATA_FIELD_HIERARCHY__MAPPING) return null;
        return (TechnologySpecificDataFieldTypeMapping)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologySpecificDataFieldTypeMapping basicGetMapping() {
        if (eContainerFeatureID() != MappingPackage.DATA_FIELD_HIERARCHY__MAPPING) return null;
        return (TechnologySpecificDataFieldTypeMapping)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetMapping(TechnologySpecificDataFieldTypeMapping newMapping, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newMapping, MappingPackage.DATA_FIELD_HIERARCHY__MAPPING, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMapping(TechnologySpecificDataFieldTypeMapping newMapping) {
        if (newMapping != eInternalContainer() || (eContainerFeatureID() != MappingPackage.DATA_FIELD_HIERARCHY__MAPPING && newMapping != null)) {
            if (EcoreUtil.isAncestor(this, newMapping))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newMapping != null)
                msgs = ((InternalEObject)newMapping).eInverseAdd(this, MappingPackage.TECHNOLOGY_SPECIFIC_DATA_FIELD_TYPE_MAPPING__DATA_FIELD_HIERARCHY, TechnologySpecificDataFieldTypeMapping.class, msgs);
            msgs = basicSetMapping(newMapping, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.DATA_FIELD_HIERARCHY__MAPPING, newMapping, newMapping));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case MappingPackage.DATA_FIELD_HIERARCHY__MAPPING:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetMapping((TechnologySpecificDataFieldTypeMapping)otherEnd, msgs);
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
            case MappingPackage.DATA_FIELD_HIERARCHY__PREVIOUS:
                return basicSetPrevious(null, msgs);
            case MappingPackage.DATA_FIELD_HIERARCHY__MAPPING:
                return basicSetMapping(null, msgs);
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
            case MappingPackage.DATA_FIELD_HIERARCHY__MAPPING:
                return eInternalContainer().eInverseRemove(this, MappingPackage.TECHNOLOGY_SPECIFIC_DATA_FIELD_TYPE_MAPPING__DATA_FIELD_HIERARCHY, TechnologySpecificDataFieldTypeMapping.class, msgs);
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
            case MappingPackage.DATA_FIELD_HIERARCHY__DATA_FIELDS:
                return getDataFields();
            case MappingPackage.DATA_FIELD_HIERARCHY__PREVIOUS:
                return getPrevious();
            case MappingPackage.DATA_FIELD_HIERARCHY__MAPPING:
                if (resolve) return getMapping();
                return basicGetMapping();
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
            case MappingPackage.DATA_FIELD_HIERARCHY__DATA_FIELDS:
                getDataFields().clear();
                getDataFields().addAll((Collection<? extends DataField>)newValue);
                return;
            case MappingPackage.DATA_FIELD_HIERARCHY__PREVIOUS:
                setPrevious((DataFieldHierarchy)newValue);
                return;
            case MappingPackage.DATA_FIELD_HIERARCHY__MAPPING:
                setMapping((TechnologySpecificDataFieldTypeMapping)newValue);
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
            case MappingPackage.DATA_FIELD_HIERARCHY__DATA_FIELDS:
                getDataFields().clear();
                return;
            case MappingPackage.DATA_FIELD_HIERARCHY__PREVIOUS:
                setPrevious((DataFieldHierarchy)null);
                return;
            case MappingPackage.DATA_FIELD_HIERARCHY__MAPPING:
                setMapping((TechnologySpecificDataFieldTypeMapping)null);
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
            case MappingPackage.DATA_FIELD_HIERARCHY__DATA_FIELDS:
                return dataFields != null && !dataFields.isEmpty();
            case MappingPackage.DATA_FIELD_HIERARCHY__PREVIOUS:
                return previous != null;
            case MappingPackage.DATA_FIELD_HIERARCHY__MAPPING:
                return basicGetMapping() != null;
        }
        return super.eIsSet(featureID);
    }

} //DataFieldHierarchyImpl
