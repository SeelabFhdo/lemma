/**
 */
package de.fhdo.lemma.technology.impl;

import de.fhdo.lemma.data.PrimitiveType;
import de.fhdo.lemma.data.PrimitiveValue;

import de.fhdo.lemma.technology.OperationTechnology;
import de.fhdo.lemma.technology.PropertyFeature;
import de.fhdo.lemma.technology.TechnologyAspect;
import de.fhdo.lemma.technology.TechnologyPackage;
import de.fhdo.lemma.technology.TechnologySpecificProperty;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specific Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologySpecificPropertyImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologySpecificPropertyImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologySpecificPropertyImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologySpecificPropertyImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologySpecificPropertyImpl#getOperationTechnology <em>Operation Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologySpecificPropertyImpl#getTechnologyAspect <em>Technology Aspect</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologySpecificPropertyImpl#isIsMandatory <em>Is Mandatory</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TechnologySpecificPropertyImpl extends MinimalEObjectImpl.Container implements TechnologySpecificProperty {
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected PrimitiveType type;

    /**
     * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultValue()
     * @generated
     * @ordered
     */
    protected PrimitiveValue defaultValue;

    /**
     * The cached value of the '{@link #getFeatures() <em>Features</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFeatures()
     * @generated
     * @ordered
     */
    protected EList<PropertyFeature> features;

    /**
     * The default value of the '{@link #isIsMandatory() <em>Is Mandatory</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsMandatory()
     * @generated
     * @ordered
     */
    protected static final boolean IS_MANDATORY_EDEFAULT = false;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TechnologySpecificPropertyImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TechnologyPackage.Literals.TECHNOLOGY_SPECIFIC_PROPERTY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimitiveType getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetType(PrimitiveType newType, NotificationChain msgs) {
        PrimitiveType oldType = type;
        type = newType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__TYPE, oldType, newType);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType(PrimitiveType newType) {
        if (newType != type) {
            NotificationChain msgs = null;
            if (type != null)
                msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__TYPE, null, msgs);
            if (newType != null)
                msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__TYPE, null, msgs);
            msgs = basicSetType(newType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__TYPE, newType, newType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimitiveValue getDefaultValue() {
        return defaultValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDefaultValue(PrimitiveValue newDefaultValue, NotificationChain msgs) {
        PrimitiveValue oldDefaultValue = defaultValue;
        defaultValue = newDefaultValue;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__DEFAULT_VALUE, oldDefaultValue, newDefaultValue);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefaultValue(PrimitiveValue newDefaultValue) {
        if (newDefaultValue != defaultValue) {
            NotificationChain msgs = null;
            if (defaultValue != null)
                msgs = ((InternalEObject)defaultValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__DEFAULT_VALUE, null, msgs);
            if (newDefaultValue != null)
                msgs = ((InternalEObject)newDefaultValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__DEFAULT_VALUE, null, msgs);
            msgs = basicSetDefaultValue(newDefaultValue, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__DEFAULT_VALUE, newDefaultValue, newDefaultValue));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PropertyFeature> getFeatures() {
        if (features == null) {
            features = new EDataTypeEList<PropertyFeature>(PropertyFeature.class, this, TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__FEATURES);
        }
        return features;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationTechnology getOperationTechnology() {
        if (eContainerFeatureID() != TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__OPERATION_TECHNOLOGY) return null;
        return (OperationTechnology)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationTechnology basicGetOperationTechnology() {
        if (eContainerFeatureID() != TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__OPERATION_TECHNOLOGY) return null;
        return (OperationTechnology)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOperationTechnology(OperationTechnology newOperationTechnology, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOperationTechnology, TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__OPERATION_TECHNOLOGY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOperationTechnology(OperationTechnology newOperationTechnology) {
        if (newOperationTechnology != eInternalContainer() || (eContainerFeatureID() != TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__OPERATION_TECHNOLOGY && newOperationTechnology != null)) {
            if (EcoreUtil.isAncestor(this, newOperationTechnology))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOperationTechnology != null)
                msgs = ((InternalEObject)newOperationTechnology).eInverseAdd(this, TechnologyPackage.OPERATION_TECHNOLOGY__SERVICE_PROPERTIES, OperationTechnology.class, msgs);
            msgs = basicSetOperationTechnology(newOperationTechnology, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__OPERATION_TECHNOLOGY, newOperationTechnology, newOperationTechnology));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologyAspect getTechnologyAspect() {
        if (eContainerFeatureID() != TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__TECHNOLOGY_ASPECT) return null;
        return (TechnologyAspect)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologyAspect basicGetTechnologyAspect() {
        if (eContainerFeatureID() != TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__TECHNOLOGY_ASPECT) return null;
        return (TechnologyAspect)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTechnologyAspect(TechnologyAspect newTechnologyAspect, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newTechnologyAspect, TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__TECHNOLOGY_ASPECT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTechnologyAspect(TechnologyAspect newTechnologyAspect) {
        if (newTechnologyAspect != eInternalContainer() || (eContainerFeatureID() != TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__TECHNOLOGY_ASPECT && newTechnologyAspect != null)) {
            if (EcoreUtil.isAncestor(this, newTechnologyAspect))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newTechnologyAspect != null)
                msgs = ((InternalEObject)newTechnologyAspect).eInverseAdd(this, TechnologyPackage.TECHNOLOGY_ASPECT__PROPERTIES, TechnologyAspect.class, msgs);
            msgs = basicSetTechnologyAspect(newTechnologyAspect, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__TECHNOLOGY_ASPECT, newTechnologyAspect, newTechnologyAspect));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isIsMandatory() {
        return this.getFeatures().contains(PropertyFeature.MANDATORY);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__OPERATION_TECHNOLOGY:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOperationTechnology((OperationTechnology)otherEnd, msgs);
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__TECHNOLOGY_ASPECT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetTechnologyAspect((TechnologyAspect)otherEnd, msgs);
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
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__TYPE:
                return basicSetType(null, msgs);
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__DEFAULT_VALUE:
                return basicSetDefaultValue(null, msgs);
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__OPERATION_TECHNOLOGY:
                return basicSetOperationTechnology(null, msgs);
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__TECHNOLOGY_ASPECT:
                return basicSetTechnologyAspect(null, msgs);
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
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__OPERATION_TECHNOLOGY:
                return eInternalContainer().eInverseRemove(this, TechnologyPackage.OPERATION_TECHNOLOGY__SERVICE_PROPERTIES, OperationTechnology.class, msgs);
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__TECHNOLOGY_ASPECT:
                return eInternalContainer().eInverseRemove(this, TechnologyPackage.TECHNOLOGY_ASPECT__PROPERTIES, TechnologyAspect.class, msgs);
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
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__NAME:
                return getName();
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__TYPE:
                return getType();
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__DEFAULT_VALUE:
                return getDefaultValue();
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__FEATURES:
                return getFeatures();
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__OPERATION_TECHNOLOGY:
                if (resolve) return getOperationTechnology();
                return basicGetOperationTechnology();
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__TECHNOLOGY_ASPECT:
                if (resolve) return getTechnologyAspect();
                return basicGetTechnologyAspect();
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__IS_MANDATORY:
                return isIsMandatory();
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
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__NAME:
                setName((String)newValue);
                return;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__TYPE:
                setType((PrimitiveType)newValue);
                return;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__DEFAULT_VALUE:
                setDefaultValue((PrimitiveValue)newValue);
                return;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__FEATURES:
                getFeatures().clear();
                getFeatures().addAll((Collection<? extends PropertyFeature>)newValue);
                return;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__OPERATION_TECHNOLOGY:
                setOperationTechnology((OperationTechnology)newValue);
                return;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__TECHNOLOGY_ASPECT:
                setTechnologyAspect((TechnologyAspect)newValue);
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
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__NAME:
                setName(NAME_EDEFAULT);
                return;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__TYPE:
                setType((PrimitiveType)null);
                return;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__DEFAULT_VALUE:
                setDefaultValue((PrimitiveValue)null);
                return;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__FEATURES:
                getFeatures().clear();
                return;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__OPERATION_TECHNOLOGY:
                setOperationTechnology((OperationTechnology)null);
                return;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__TECHNOLOGY_ASPECT:
                setTechnologyAspect((TechnologyAspect)null);
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
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__TYPE:
                return type != null;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__DEFAULT_VALUE:
                return defaultValue != null;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__FEATURES:
                return features != null && !features.isEmpty();
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__OPERATION_TECHNOLOGY:
                return basicGetOperationTechnology() != null;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__TECHNOLOGY_ASPECT:
                return basicGetTechnologyAspect() != null;
            case TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__IS_MANDATORY:
                return isIsMandatory() != IS_MANDATORY_EDEFAULT;
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
        result.append(" (name: ");
        result.append(name);
        result.append(", features: ");
        result.append(features);
        result.append(')');
        return result.toString();
    }

} //TechnologySpecificPropertyImpl
