/**
 */
package de.fhdo.lemma.data.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateAspectProperty;
import de.fhdo.lemma.data.intermediate.IntermediateAspectPropertyValue;
import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect;
import de.fhdo.lemma.data.intermediate.IntermediatePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aspect Property Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateAspectPropertyValueImpl#getValue <em>Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateAspectPropertyValueImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateAspectPropertyValueImpl#getAspect <em>Aspect</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateAspectPropertyValueImpl extends MinimalEObjectImpl.Container implements IntermediateAspectPropertyValue {
    /**
     * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected static final String VALUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected String value = VALUE_EDEFAULT;

    /**
     * The cached value of the '{@link #getProperty() <em>Property</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProperty()
     * @generated
     * @ordered
     */
    protected IntermediateAspectProperty property;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IntermediateAspectPropertyValueImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_ASPECT_PROPERTY_VALUE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setValue(String newValue) {
        String oldValue = value;
        value = newValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE__VALUE, oldValue, value));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateAspectProperty getProperty() {
        if (property != null && property.eIsProxy()) {
            InternalEObject oldProperty = (InternalEObject)property;
            property = (IntermediateAspectProperty)eResolveProxy(oldProperty);
            if (property != oldProperty) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE__PROPERTY, oldProperty, property));
            }
        }
        return property;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateAspectProperty basicGetProperty() {
        return property;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setProperty(IntermediateAspectProperty newProperty) {
        IntermediateAspectProperty oldProperty = property;
        property = newProperty;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE__PROPERTY, oldProperty, property));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateImportedAspect getAspect() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE__ASPECT) return null;
        return (IntermediateImportedAspect)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateImportedAspect basicGetAspect() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE__ASPECT) return null;
        return (IntermediateImportedAspect)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetAspect(IntermediateImportedAspect newAspect, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newAspect, IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE__ASPECT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAspect(IntermediateImportedAspect newAspect) {
        if (newAspect != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE__ASPECT && newAspect != null)) {
            if (EcoreUtil.isAncestor(this, newAspect))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newAspect != null)
                msgs = ((InternalEObject)newAspect).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PROPERTY_VALUES, IntermediateImportedAspect.class, msgs);
            msgs = basicSetAspect(newAspect, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE__ASPECT, newAspect, newAspect));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE__ASPECT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetAspect((IntermediateImportedAspect)otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE__ASPECT:
                return basicSetAspect(null, msgs);
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
            case IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE__ASPECT:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_IMPORTED_ASPECT__PROPERTY_VALUES, IntermediateImportedAspect.class, msgs);
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
            case IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE__VALUE:
                return getValue();
            case IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE__PROPERTY:
                if (resolve) return getProperty();
                return basicGetProperty();
            case IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE__ASPECT:
                if (resolve) return getAspect();
                return basicGetAspect();
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
            case IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE__VALUE:
                setValue((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE__PROPERTY:
                setProperty((IntermediateAspectProperty)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE__ASPECT:
                setAspect((IntermediateImportedAspect)newValue);
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
            case IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE__VALUE:
                setValue(VALUE_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE__PROPERTY:
                setProperty((IntermediateAspectProperty)null);
                return;
            case IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE__ASPECT:
                setAspect((IntermediateImportedAspect)null);
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
            case IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE__VALUE:
                return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
            case IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE__PROPERTY:
                return property != null;
            case IntermediatePackage.INTERMEDIATE_ASPECT_PROPERTY_VALUE__ASPECT:
                return basicGetAspect() != null;
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
        result.append(" (value: ");
        result.append(value);
        result.append(')');
        return result.toString();
    }

} //IntermediateAspectPropertyValueImpl
