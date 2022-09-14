/**
 */
package de.fhdo.lemma.technology.impl;

import de.fhdo.lemma.technology.AspectFeature;
import de.fhdo.lemma.technology.JoinPointType;
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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aspect</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologyAspectImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologyAspectImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologyAspectImpl#getJoinPoints <em>Join Points</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologyAspectImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.TechnologyAspectImpl#isIsSingleValued <em>Is Single Valued</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TechnologyAspectImpl extends MinimalEObjectImpl.Container implements TechnologyAspect {
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
     * The cached value of the '{@link #getFeatures() <em>Features</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFeatures()
     * @generated
     * @ordered
     */
    protected EList<AspectFeature> features;

    /**
     * The cached value of the '{@link #getJoinPoints() <em>Join Points</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getJoinPoints()
     * @generated
     * @ordered
     */
    protected EList<JoinPointType> joinPoints;

    /**
     * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProperties()
     * @generated
     * @ordered
     */
    protected EList<TechnologySpecificProperty> properties;

    /**
     * The default value of the '{@link #isIsSingleValued() <em>Is Single Valued</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIsSingleValued()
     * @generated
     * @ordered
     */
    protected static final boolean IS_SINGLE_VALUED_EDEFAULT = false;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TechnologyAspectImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TechnologyPackage.Literals.TECHNOLOGY_ASPECT;
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
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.TECHNOLOGY_ASPECT__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<AspectFeature> getFeatures() {
        if (features == null) {
            features = new EDataTypeEList<AspectFeature>(AspectFeature.class, this, TechnologyPackage.TECHNOLOGY_ASPECT__FEATURES);
        }
        return features;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<JoinPointType> getJoinPoints() {
        if (joinPoints == null) {
            joinPoints = new EDataTypeEList<JoinPointType>(JoinPointType.class, this, TechnologyPackage.TECHNOLOGY_ASPECT__JOIN_POINTS);
        }
        return joinPoints;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TechnologySpecificProperty> getProperties() {
        if (properties == null) {
            properties = new EObjectContainmentWithInverseEList<TechnologySpecificProperty>(TechnologySpecificProperty.class, this, TechnologyPackage.TECHNOLOGY_ASPECT__PROPERTIES, TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__TECHNOLOGY_ASPECT);
        }
        return properties;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isIsSingleValued() {
        boolean _xifexpression = false;
        EList<AspectFeature> _features = this.getFeatures();
        boolean _tripleNotEquals = (_features != null);
        if (_tripleNotEquals) {
            _xifexpression = this.getFeatures().contains(AspectFeature.SINGLE_VALUED);
        }
        else {
            _xifexpression = false;
        }
        return _xifexpression;
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
            case TechnologyPackage.TECHNOLOGY_ASPECT__PROPERTIES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getProperties()).basicAdd(otherEnd, msgs);
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
            case TechnologyPackage.TECHNOLOGY_ASPECT__PROPERTIES:
                return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
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
            case TechnologyPackage.TECHNOLOGY_ASPECT__NAME:
                return getName();
            case TechnologyPackage.TECHNOLOGY_ASPECT__FEATURES:
                return getFeatures();
            case TechnologyPackage.TECHNOLOGY_ASPECT__JOIN_POINTS:
                return getJoinPoints();
            case TechnologyPackage.TECHNOLOGY_ASPECT__PROPERTIES:
                return getProperties();
            case TechnologyPackage.TECHNOLOGY_ASPECT__IS_SINGLE_VALUED:
                return isIsSingleValued();
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
            case TechnologyPackage.TECHNOLOGY_ASPECT__NAME:
                setName((String)newValue);
                return;
            case TechnologyPackage.TECHNOLOGY_ASPECT__FEATURES:
                getFeatures().clear();
                getFeatures().addAll((Collection<? extends AspectFeature>)newValue);
                return;
            case TechnologyPackage.TECHNOLOGY_ASPECT__JOIN_POINTS:
                getJoinPoints().clear();
                getJoinPoints().addAll((Collection<? extends JoinPointType>)newValue);
                return;
            case TechnologyPackage.TECHNOLOGY_ASPECT__PROPERTIES:
                getProperties().clear();
                getProperties().addAll((Collection<? extends TechnologySpecificProperty>)newValue);
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
            case TechnologyPackage.TECHNOLOGY_ASPECT__NAME:
                setName(NAME_EDEFAULT);
                return;
            case TechnologyPackage.TECHNOLOGY_ASPECT__FEATURES:
                getFeatures().clear();
                return;
            case TechnologyPackage.TECHNOLOGY_ASPECT__JOIN_POINTS:
                getJoinPoints().clear();
                return;
            case TechnologyPackage.TECHNOLOGY_ASPECT__PROPERTIES:
                getProperties().clear();
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
            case TechnologyPackage.TECHNOLOGY_ASPECT__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case TechnologyPackage.TECHNOLOGY_ASPECT__FEATURES:
                return features != null && !features.isEmpty();
            case TechnologyPackage.TECHNOLOGY_ASPECT__JOIN_POINTS:
                return joinPoints != null && !joinPoints.isEmpty();
            case TechnologyPackage.TECHNOLOGY_ASPECT__PROPERTIES:
                return properties != null && !properties.isEmpty();
            case TechnologyPackage.TECHNOLOGY_ASPECT__IS_SINGLE_VALUED:
                return isIsSingleValued() != IS_SINGLE_VALUED_EDEFAULT;
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
        result.append(", joinPoints: ");
        result.append(joinPoints);
        result.append(')');
        return result.toString();
    }

} //TechnologyAspectImpl
