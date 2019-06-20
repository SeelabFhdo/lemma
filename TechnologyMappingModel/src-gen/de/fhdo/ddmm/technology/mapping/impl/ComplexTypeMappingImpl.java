/**
 */
package de.fhdo.ddmm.technology.mapping.impl;

import de.fhdo.ddmm.service.Import;

import de.fhdo.ddmm.technology.mapping.ComplexTypeMapping;
import de.fhdo.ddmm.technology.mapping.ImportedComplexType;
import de.fhdo.ddmm.technology.mapping.MappingPackage;
import de.fhdo.ddmm.technology.mapping.TechnologyMapping;
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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Type Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.ComplexTypeMappingImpl#getT_sourceModelUri <em>Tsource Model Uri</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.ComplexTypeMappingImpl#getTechnologies <em>Technologies</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.ComplexTypeMappingImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.ComplexTypeMappingImpl#getFieldMappings <em>Field Mappings</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.ComplexTypeMappingImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.ComplexTypeMappingImpl#getMappingModel <em>Mapping Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComplexTypeMappingImpl extends MinimalEObjectImpl.Container implements ComplexTypeMapping {
    /**
     * The default value of the '{@link #getT_sourceModelUri() <em>Tsource Model Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getT_sourceModelUri()
     * @generated
     * @ordered
     */
    protected static final String TSOURCE_MODEL_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getT_sourceModelUri() <em>Tsource Model Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getT_sourceModelUri()
     * @generated
     * @ordered
     */
    protected String t_sourceModelUri = TSOURCE_MODEL_URI_EDEFAULT;

    /**
     * The cached value of the '{@link #getTechnologies() <em>Technologies</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTechnologies()
     * @generated
     * @ordered
     */
    protected EList<Import> technologies;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected ImportedComplexType type;

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
    protected ComplexTypeMappingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MappingPackage.Literals.COMPLEX_TYPE_MAPPING;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getT_sourceModelUri() {
        return t_sourceModelUri;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setT_sourceModelUri(String newT_sourceModelUri) {
        String oldT_sourceModelUri = t_sourceModelUri;
        t_sourceModelUri = newT_sourceModelUri;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.COMPLEX_TYPE_MAPPING__TSOURCE_MODEL_URI, oldT_sourceModelUri, t_sourceModelUri));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<Import> getTechnologies() {
        if (technologies == null) {
            technologies = new EObjectResolvingEList<Import>(Import.class, this, MappingPackage.COMPLEX_TYPE_MAPPING__TECHNOLOGIES);
        }
        return technologies;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ImportedComplexType getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetType(ImportedComplexType newType, NotificationChain msgs) {
        ImportedComplexType oldType = type;
        type = newType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MappingPackage.COMPLEX_TYPE_MAPPING__TYPE, oldType, newType);
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
    public void setType(ImportedComplexType newType) {
        if (newType != type) {
            NotificationChain msgs = null;
            if (type != null)
                msgs = ((InternalEObject)type).eInverseRemove(this, MappingPackage.IMPORTED_COMPLEX_TYPE__TYPE_MAPPING, ImportedComplexType.class, msgs);
            if (newType != null)
                msgs = ((InternalEObject)newType).eInverseAdd(this, MappingPackage.IMPORTED_COMPLEX_TYPE__TYPE_MAPPING, ImportedComplexType.class, msgs);
            msgs = basicSetType(newType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.COMPLEX_TYPE_MAPPING__TYPE, newType, newType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<TechnologySpecificFieldMapping> getFieldMappings() {
        if (fieldMappings == null) {
            fieldMappings = new EObjectContainmentWithInverseEList<TechnologySpecificFieldMapping>(TechnologySpecificFieldMapping.class, this, MappingPackage.COMPLEX_TYPE_MAPPING__FIELD_MAPPINGS, MappingPackage.TECHNOLOGY_SPECIFIC_FIELD_MAPPING__TYPE_MAPPING);
        }
        return fieldMappings;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<TechnologySpecificImportedServiceAspect> getAspects() {
        if (aspects == null) {
            aspects = new EObjectContainmentWithInverseEList<TechnologySpecificImportedServiceAspect>(TechnologySpecificImportedServiceAspect.class, this, MappingPackage.COMPLEX_TYPE_MAPPING__ASPECTS, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__TYPE_MAPPING);
        }
        return aspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public TechnologyMapping getMappingModel() {
        if (eContainerFeatureID() != MappingPackage.COMPLEX_TYPE_MAPPING__MAPPING_MODEL) return null;
        return (TechnologyMapping)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologyMapping basicGetMappingModel() {
        if (eContainerFeatureID() != MappingPackage.COMPLEX_TYPE_MAPPING__MAPPING_MODEL) return null;
        return (TechnologyMapping)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetMappingModel(TechnologyMapping newMappingModel, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newMappingModel, MappingPackage.COMPLEX_TYPE_MAPPING__MAPPING_MODEL, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setMappingModel(TechnologyMapping newMappingModel) {
        if (newMappingModel != eInternalContainer() || (eContainerFeatureID() != MappingPackage.COMPLEX_TYPE_MAPPING__MAPPING_MODEL && newMappingModel != null)) {
            if (EcoreUtil.isAncestor(this, newMappingModel))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newMappingModel != null)
                msgs = ((InternalEObject)newMappingModel).eInverseAdd(this, MappingPackage.TECHNOLOGY_MAPPING__TYPE_MAPPINGS, TechnologyMapping.class, msgs);
            msgs = basicSetMappingModel(newMappingModel, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.COMPLEX_TYPE_MAPPING__MAPPING_MODEL, newMappingModel, newMappingModel));
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
            case MappingPackage.COMPLEX_TYPE_MAPPING__TYPE:
                if (type != null)
                    msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MappingPackage.COMPLEX_TYPE_MAPPING__TYPE, null, msgs);
                return basicSetType((ImportedComplexType)otherEnd, msgs);
            case MappingPackage.COMPLEX_TYPE_MAPPING__FIELD_MAPPINGS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getFieldMappings()).basicAdd(otherEnd, msgs);
            case MappingPackage.COMPLEX_TYPE_MAPPING__ASPECTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspects()).basicAdd(otherEnd, msgs);
            case MappingPackage.COMPLEX_TYPE_MAPPING__MAPPING_MODEL:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetMappingModel((TechnologyMapping)otherEnd, msgs);
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
            case MappingPackage.COMPLEX_TYPE_MAPPING__TYPE:
                return basicSetType(null, msgs);
            case MappingPackage.COMPLEX_TYPE_MAPPING__FIELD_MAPPINGS:
                return ((InternalEList<?>)getFieldMappings()).basicRemove(otherEnd, msgs);
            case MappingPackage.COMPLEX_TYPE_MAPPING__ASPECTS:
                return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
            case MappingPackage.COMPLEX_TYPE_MAPPING__MAPPING_MODEL:
                return basicSetMappingModel(null, msgs);
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
            case MappingPackage.COMPLEX_TYPE_MAPPING__MAPPING_MODEL:
                return eInternalContainer().eInverseRemove(this, MappingPackage.TECHNOLOGY_MAPPING__TYPE_MAPPINGS, TechnologyMapping.class, msgs);
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
            case MappingPackage.COMPLEX_TYPE_MAPPING__TSOURCE_MODEL_URI:
                return getT_sourceModelUri();
            case MappingPackage.COMPLEX_TYPE_MAPPING__TECHNOLOGIES:
                return getTechnologies();
            case MappingPackage.COMPLEX_TYPE_MAPPING__TYPE:
                return getType();
            case MappingPackage.COMPLEX_TYPE_MAPPING__FIELD_MAPPINGS:
                return getFieldMappings();
            case MappingPackage.COMPLEX_TYPE_MAPPING__ASPECTS:
                return getAspects();
            case MappingPackage.COMPLEX_TYPE_MAPPING__MAPPING_MODEL:
                if (resolve) return getMappingModel();
                return basicGetMappingModel();
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
            case MappingPackage.COMPLEX_TYPE_MAPPING__TSOURCE_MODEL_URI:
                setT_sourceModelUri((String)newValue);
                return;
            case MappingPackage.COMPLEX_TYPE_MAPPING__TECHNOLOGIES:
                getTechnologies().clear();
                getTechnologies().addAll((Collection<? extends Import>)newValue);
                return;
            case MappingPackage.COMPLEX_TYPE_MAPPING__TYPE:
                setType((ImportedComplexType)newValue);
                return;
            case MappingPackage.COMPLEX_TYPE_MAPPING__FIELD_MAPPINGS:
                getFieldMappings().clear();
                getFieldMappings().addAll((Collection<? extends TechnologySpecificFieldMapping>)newValue);
                return;
            case MappingPackage.COMPLEX_TYPE_MAPPING__ASPECTS:
                getAspects().clear();
                getAspects().addAll((Collection<? extends TechnologySpecificImportedServiceAspect>)newValue);
                return;
            case MappingPackage.COMPLEX_TYPE_MAPPING__MAPPING_MODEL:
                setMappingModel((TechnologyMapping)newValue);
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
            case MappingPackage.COMPLEX_TYPE_MAPPING__TSOURCE_MODEL_URI:
                setT_sourceModelUri(TSOURCE_MODEL_URI_EDEFAULT);
                return;
            case MappingPackage.COMPLEX_TYPE_MAPPING__TECHNOLOGIES:
                getTechnologies().clear();
                return;
            case MappingPackage.COMPLEX_TYPE_MAPPING__TYPE:
                setType((ImportedComplexType)null);
                return;
            case MappingPackage.COMPLEX_TYPE_MAPPING__FIELD_MAPPINGS:
                getFieldMappings().clear();
                return;
            case MappingPackage.COMPLEX_TYPE_MAPPING__ASPECTS:
                getAspects().clear();
                return;
            case MappingPackage.COMPLEX_TYPE_MAPPING__MAPPING_MODEL:
                setMappingModel((TechnologyMapping)null);
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
            case MappingPackage.COMPLEX_TYPE_MAPPING__TSOURCE_MODEL_URI:
                return TSOURCE_MODEL_URI_EDEFAULT == null ? t_sourceModelUri != null : !TSOURCE_MODEL_URI_EDEFAULT.equals(t_sourceModelUri);
            case MappingPackage.COMPLEX_TYPE_MAPPING__TECHNOLOGIES:
                return technologies != null && !technologies.isEmpty();
            case MappingPackage.COMPLEX_TYPE_MAPPING__TYPE:
                return type != null;
            case MappingPackage.COMPLEX_TYPE_MAPPING__FIELD_MAPPINGS:
                return fieldMappings != null && !fieldMappings.isEmpty();
            case MappingPackage.COMPLEX_TYPE_MAPPING__ASPECTS:
                return aspects != null && !aspects.isEmpty();
            case MappingPackage.COMPLEX_TYPE_MAPPING__MAPPING_MODEL:
                return basicGetMappingModel() != null;
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
        result.append(" (t_sourceModelUri: ");
        result.append(t_sourceModelUri);
        result.append(')');
        return result.toString();
    }

} //ComplexTypeMappingImpl
