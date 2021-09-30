/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.operation.intermediate.IntermediateOperationEnvironment;
import de.fhdo.lemma.operation.intermediate.IntermediateOperationTechnology;
import de.fhdo.lemma.operation.intermediate.IntermediatePackage;
import de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificProperty;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Technology</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationTechnologyImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationTechnologyImpl#getEnvironment <em>Environment</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationTechnologyImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class IntermediateOperationTechnologyImpl extends MinimalEObjectImpl.Container implements IntermediateOperationTechnology {
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
     * The cached value of the '{@link #getEnvironment() <em>Environment</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEnvironment()
     * @generated
     * @ordered
     */
    protected IntermediateOperationEnvironment environment;

    /**
     * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProperties()
     * @generated
     * @ordered
     */
    protected EList<IntermediateTechnologySpecificProperty> properties;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IntermediateOperationTechnologyImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_OPERATION_TECHNOLOGY;
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
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateOperationEnvironment getEnvironment() {
        return environment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetEnvironment(IntermediateOperationEnvironment newEnvironment, NotificationChain msgs) {
        IntermediateOperationEnvironment oldEnvironment = environment;
        environment = newEnvironment;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__ENVIRONMENT, oldEnvironment, newEnvironment);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEnvironment(IntermediateOperationEnvironment newEnvironment) {
        if (newEnvironment != environment) {
            NotificationChain msgs = null;
            if (environment != null)
                msgs = ((InternalEObject)environment).eInverseRemove(this, IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT__OPERATION_TECHNOLOGY, IntermediateOperationEnvironment.class, msgs);
            if (newEnvironment != null)
                msgs = ((InternalEObject)newEnvironment).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_OPERATION_ENVIRONMENT__OPERATION_TECHNOLOGY, IntermediateOperationEnvironment.class, msgs);
            msgs = basicSetEnvironment(newEnvironment, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__ENVIRONMENT, newEnvironment, newEnvironment));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateTechnologySpecificProperty> getProperties() {
        if (properties == null) {
            properties = new EObjectContainmentWithInverseEList<IntermediateTechnologySpecificProperty>(IntermediateTechnologySpecificProperty.class, this, IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__PROPERTIES, IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY__OPERATION_TECHNOLOGY);
        }
        return properties;
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__ENVIRONMENT:
                if (environment != null)
                    msgs = ((InternalEObject)environment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__ENVIRONMENT, null, msgs);
                return basicSetEnvironment((IntermediateOperationEnvironment)otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__PROPERTIES:
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__ENVIRONMENT:
                return basicSetEnvironment(null, msgs);
            case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__PROPERTIES:
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__NAME:
                return getName();
            case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__ENVIRONMENT:
                return getEnvironment();
            case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__PROPERTIES:
                return getProperties();
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__NAME:
                setName((String)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__ENVIRONMENT:
                setEnvironment((IntermediateOperationEnvironment)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__PROPERTIES:
                getProperties().clear();
                getProperties().addAll((Collection<? extends IntermediateTechnologySpecificProperty>)newValue);
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__NAME:
                setName(NAME_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__ENVIRONMENT:
                setEnvironment((IntermediateOperationEnvironment)null);
                return;
            case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__PROPERTIES:
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
            case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__ENVIRONMENT:
                return environment != null;
            case IntermediatePackage.INTERMEDIATE_OPERATION_TECHNOLOGY__PROPERTIES:
                return properties != null && !properties.isEmpty();
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
        result.append(')');
        return result.toString();
    }

} //IntermediateOperationTechnologyImpl
