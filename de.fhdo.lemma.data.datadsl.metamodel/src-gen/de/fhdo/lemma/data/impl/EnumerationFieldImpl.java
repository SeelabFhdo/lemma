/**
 */
package de.fhdo.lemma.data.impl;

import de.fhdo.lemma.data.DataPackage;
import de.fhdo.lemma.data.Enumeration;
import de.fhdo.lemma.data.EnumerationField;
import de.fhdo.lemma.data.PrimitiveValue;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumeration Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.impl.EnumerationFieldImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.EnumerationFieldImpl#getInitializationValue <em>Initialization Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.EnumerationFieldImpl#getEnumeration <em>Enumeration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumerationFieldImpl extends MinimalEObjectImpl.Container implements EnumerationField {
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
     * The cached value of the '{@link #getInitializationValue() <em>Initialization Value</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInitializationValue()
     * @generated
     * @ordered
     */
    protected PrimitiveValue initializationValue;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EnumerationFieldImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DataPackage.Literals.ENUMERATION_FIELD;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setName(String newName) {
        String oldName = name;
        name = newName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ENUMERATION_FIELD__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PrimitiveValue getInitializationValue() {
        return initializationValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInitializationValue(PrimitiveValue newInitializationValue, NotificationChain msgs) {
        PrimitiveValue oldInitializationValue = initializationValue;
        initializationValue = newInitializationValue;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataPackage.ENUMERATION_FIELD__INITIALIZATION_VALUE, oldInitializationValue, newInitializationValue);
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
    public void setInitializationValue(PrimitiveValue newInitializationValue) {
        if (newInitializationValue != initializationValue) {
            NotificationChain msgs = null;
            if (initializationValue != null)
                msgs = ((InternalEObject)initializationValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataPackage.ENUMERATION_FIELD__INITIALIZATION_VALUE, null, msgs);
            if (newInitializationValue != null)
                msgs = ((InternalEObject)newInitializationValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataPackage.ENUMERATION_FIELD__INITIALIZATION_VALUE, null, msgs);
            msgs = basicSetInitializationValue(newInitializationValue, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ENUMERATION_FIELD__INITIALIZATION_VALUE, newInitializationValue, newInitializationValue));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Enumeration getEnumeration() {
        if (eContainerFeatureID() != DataPackage.ENUMERATION_FIELD__ENUMERATION) return null;
        return (Enumeration)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Enumeration basicGetEnumeration() {
        if (eContainerFeatureID() != DataPackage.ENUMERATION_FIELD__ENUMERATION) return null;
        return (Enumeration)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetEnumeration(Enumeration newEnumeration, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newEnumeration, DataPackage.ENUMERATION_FIELD__ENUMERATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setEnumeration(Enumeration newEnumeration) {
        if (newEnumeration != eInternalContainer() || (eContainerFeatureID() != DataPackage.ENUMERATION_FIELD__ENUMERATION && newEnumeration != null)) {
            if (EcoreUtil.isAncestor(this, newEnumeration))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newEnumeration != null)
                msgs = ((InternalEObject)newEnumeration).eInverseAdd(this, DataPackage.ENUMERATION__FIELDS, Enumeration.class, msgs);
            msgs = basicSetEnumeration(newEnumeration, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.ENUMERATION_FIELD__ENUMERATION, newEnumeration, newEnumeration));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<String> getQualifiedNameParts() {
        EList<String> _xblockexpression = null;
        {
            if (((this.getName() == null) || this.getName().isEmpty())) {
                return ECollections.<String>asEList(CollectionLiterals.<String>newArrayList());
            }
            final EList<String> nameParts = this.getEnumeration().getQualifiedNameParts();
            nameParts.add(this.getName());
            _xblockexpression = ECollections.<String>asEList(nameParts);
        }
        return _xblockexpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String buildQualifiedName(final String separator) {
        if ((separator == null)) {
            return null;
        }
        String qualifiedName = "";
        EList<String> _qualifiedNameParts = this.getQualifiedNameParts();
        for (final String part : _qualifiedNameParts) {
            String _qualifiedName = qualifiedName;
            qualifiedName = (_qualifiedName + (separator + part));
        }
        boolean _isEmpty = qualifiedName.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
            qualifiedName = qualifiedName.substring(separator.length());
        }
        return qualifiedName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case DataPackage.ENUMERATION_FIELD__ENUMERATION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetEnumeration((Enumeration)otherEnd, msgs);
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
            case DataPackage.ENUMERATION_FIELD__INITIALIZATION_VALUE:
                return basicSetInitializationValue(null, msgs);
            case DataPackage.ENUMERATION_FIELD__ENUMERATION:
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
            case DataPackage.ENUMERATION_FIELD__ENUMERATION:
                return eInternalContainer().eInverseRemove(this, DataPackage.ENUMERATION__FIELDS, Enumeration.class, msgs);
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
            case DataPackage.ENUMERATION_FIELD__NAME:
                return getName();
            case DataPackage.ENUMERATION_FIELD__INITIALIZATION_VALUE:
                return getInitializationValue();
            case DataPackage.ENUMERATION_FIELD__ENUMERATION:
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
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case DataPackage.ENUMERATION_FIELD__NAME:
                setName((String)newValue);
                return;
            case DataPackage.ENUMERATION_FIELD__INITIALIZATION_VALUE:
                setInitializationValue((PrimitiveValue)newValue);
                return;
            case DataPackage.ENUMERATION_FIELD__ENUMERATION:
                setEnumeration((Enumeration)newValue);
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
            case DataPackage.ENUMERATION_FIELD__NAME:
                setName(NAME_EDEFAULT);
                return;
            case DataPackage.ENUMERATION_FIELD__INITIALIZATION_VALUE:
                setInitializationValue((PrimitiveValue)null);
                return;
            case DataPackage.ENUMERATION_FIELD__ENUMERATION:
                setEnumeration((Enumeration)null);
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
            case DataPackage.ENUMERATION_FIELD__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case DataPackage.ENUMERATION_FIELD__INITIALIZATION_VALUE:
                return initializationValue != null;
            case DataPackage.ENUMERATION_FIELD__ENUMERATION:
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
    public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
        switch (operationID) {
            case DataPackage.ENUMERATION_FIELD___GET_QUALIFIED_NAME_PARTS:
                return getQualifiedNameParts();
            case DataPackage.ENUMERATION_FIELD___BUILD_QUALIFIED_NAME__STRING:
                return buildQualifiedName((String)arguments.get(0));
        }
        return super.eInvoke(operationID, arguments);
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
        result.append(')');
        return result.toString();
    }

} //EnumerationFieldImpl
