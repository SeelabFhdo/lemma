/**
 */
package de.fhdo.lemma.data.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateEnumeration;
import de.fhdo.lemma.data.intermediate.IntermediateEnumerationField;
import de.fhdo.lemma.data.intermediate.IntermediatePackage;
import de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType;

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
 * An implementation of the model object '<em><b>Enumeration Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateEnumerationFieldImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateEnumerationFieldImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateEnumerationFieldImpl#getInitializationValue <em>Initialization Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateEnumerationFieldImpl#getInitializationValueCompatibleTypes <em>Initialization Value Compatible Types</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateEnumerationFieldImpl#getEnumeration <em>Enumeration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateEnumerationFieldImpl extends MinimalEObjectImpl.Container implements IntermediateEnumerationField {
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
     * The default value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQualifiedName()
     * @generated
     * @ordered
     */
    protected static final String QUALIFIED_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQualifiedName()
     * @generated
     * @ordered
     */
    protected String qualifiedName = QUALIFIED_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getInitializationValue() <em>Initialization Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInitializationValue()
     * @generated
     * @ordered
     */
    protected static final String INITIALIZATION_VALUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getInitializationValue() <em>Initialization Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInitializationValue()
     * @generated
     * @ordered
     */
    protected String initializationValue = INITIALIZATION_VALUE_EDEFAULT;

    /**
     * The cached value of the '{@link #getInitializationValueCompatibleTypes() <em>Initialization Value Compatible Types</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInitializationValueCompatibleTypes()
     * @generated
     * @ordered
     */
    protected EList<IntermediatePrimitiveType> initializationValueCompatibleTypes;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IntermediateEnumerationFieldImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_ENUMERATION_FIELD;
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getQualifiedName() {
        return qualifiedName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setQualifiedName(String newQualifiedName) {
        String oldQualifiedName = qualifiedName;
        qualifiedName = newQualifiedName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getInitializationValue() {
        return initializationValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInitializationValue(String newInitializationValue) {
        String oldInitializationValue = initializationValue;
        initializationValue = newInitializationValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__INITIALIZATION_VALUE, oldInitializationValue, initializationValue));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediatePrimitiveType> getInitializationValueCompatibleTypes() {
        if (initializationValueCompatibleTypes == null) {
            initializationValueCompatibleTypes = new EObjectContainmentWithInverseEList<IntermediatePrimitiveType>(IntermediatePrimitiveType.class, this, IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__INITIALIZATION_VALUE_COMPATIBLE_TYPES, IntermediatePackage.INTERMEDIATE_PRIMITIVE_TYPE__INITIALIZED_ENUMERATION_FIELD);
        }
        return initializationValueCompatibleTypes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateEnumeration getEnumeration() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__ENUMERATION) return null;
        return (IntermediateEnumeration)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateEnumeration basicGetEnumeration() {
        if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__ENUMERATION) return null;
        return (IntermediateEnumeration)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetEnumeration(IntermediateEnumeration newEnumeration, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newEnumeration, IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__ENUMERATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEnumeration(IntermediateEnumeration newEnumeration) {
        if (newEnumeration != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__ENUMERATION && newEnumeration != null)) {
            if (EcoreUtil.isAncestor(this, newEnumeration))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newEnumeration != null)
                msgs = ((InternalEObject)newEnumeration).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_ENUMERATION__FIELDS, IntermediateEnumeration.class, msgs);
            msgs = basicSetEnumeration(newEnumeration, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__ENUMERATION, newEnumeration, newEnumeration));
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
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__INITIALIZATION_VALUE_COMPATIBLE_TYPES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getInitializationValueCompatibleTypes()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__ENUMERATION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetEnumeration((IntermediateEnumeration)otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__INITIALIZATION_VALUE_COMPATIBLE_TYPES:
                return ((InternalEList<?>)getInitializationValueCompatibleTypes()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__ENUMERATION:
                return basicSetEnumeration(null, msgs);
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
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__ENUMERATION:
                return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_ENUMERATION__FIELDS, IntermediateEnumeration.class, msgs);
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
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__NAME:
                return getName();
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__QUALIFIED_NAME:
                return getQualifiedName();
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__INITIALIZATION_VALUE:
                return getInitializationValue();
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__INITIALIZATION_VALUE_COMPATIBLE_TYPES:
                return getInitializationValueCompatibleTypes();
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__ENUMERATION:
                if (resolve) return getEnumeration();
                return basicGetEnumeration();
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
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__NAME:
                setName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__QUALIFIED_NAME:
                setQualifiedName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__INITIALIZATION_VALUE:
                setInitializationValue((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__INITIALIZATION_VALUE_COMPATIBLE_TYPES:
                getInitializationValueCompatibleTypes().clear();
                getInitializationValueCompatibleTypes().addAll((Collection<? extends IntermediatePrimitiveType>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__ENUMERATION:
                setEnumeration((IntermediateEnumeration)newValue);
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
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__NAME:
                setName(NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__QUALIFIED_NAME:
                setQualifiedName(QUALIFIED_NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__INITIALIZATION_VALUE:
                setInitializationValue(INITIALIZATION_VALUE_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__INITIALIZATION_VALUE_COMPATIBLE_TYPES:
                getInitializationValueCompatibleTypes().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__ENUMERATION:
                setEnumeration((IntermediateEnumeration)null);
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
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__QUALIFIED_NAME:
                return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__INITIALIZATION_VALUE:
                return INITIALIZATION_VALUE_EDEFAULT == null ? initializationValue != null : !INITIALIZATION_VALUE_EDEFAULT.equals(initializationValue);
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__INITIALIZATION_VALUE_COMPATIBLE_TYPES:
                return initializationValueCompatibleTypes != null && !initializationValueCompatibleTypes.isEmpty();
            case IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__ENUMERATION:
                return basicGetEnumeration() != null;
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
        result.append(", qualifiedName: ");
        result.append(qualifiedName);
        result.append(", initializationValue: ");
        result.append(initializationValue);
        result.append(')');
        return result.toString();
    }

} //IntermediateEnumerationFieldImpl
