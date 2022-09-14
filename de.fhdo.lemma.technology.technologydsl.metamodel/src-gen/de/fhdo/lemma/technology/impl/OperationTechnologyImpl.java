/**
 */
package de.fhdo.lemma.technology.impl;

import de.fhdo.lemma.technology.OperationEnvironment;
import de.fhdo.lemma.technology.OperationTechnology;
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
 *   <li>{@link de.fhdo.lemma.technology.impl.OperationTechnologyImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.OperationTechnologyImpl#getOperationEnvironments <em>Operation Environments</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.OperationTechnologyImpl#getServiceProperties <em>Service Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class OperationTechnologyImpl extends MinimalEObjectImpl.Container implements OperationTechnology {
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
     * The cached value of the '{@link #getOperationEnvironments() <em>Operation Environments</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperationEnvironments()
     * @generated
     * @ordered
     */
    protected EList<OperationEnvironment> operationEnvironments;

    /**
     * The cached value of the '{@link #getServiceProperties() <em>Service Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getServiceProperties()
     * @generated
     * @ordered
     */
    protected EList<TechnologySpecificProperty> serviceProperties;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected OperationTechnologyImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TechnologyPackage.Literals.OPERATION_TECHNOLOGY;
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
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.OPERATION_TECHNOLOGY__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<OperationEnvironment> getOperationEnvironments() {
        if (operationEnvironments == null) {
            operationEnvironments = new EObjectContainmentWithInverseEList<OperationEnvironment>(OperationEnvironment.class, this, TechnologyPackage.OPERATION_TECHNOLOGY__OPERATION_ENVIRONMENTS, TechnologyPackage.OPERATION_ENVIRONMENT__OPERATION_TECHNOLOGY);
        }
        return operationEnvironments;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TechnologySpecificProperty> getServiceProperties() {
        if (serviceProperties == null) {
            serviceProperties = new EObjectContainmentWithInverseEList<TechnologySpecificProperty>(TechnologySpecificProperty.class, this, TechnologyPackage.OPERATION_TECHNOLOGY__SERVICE_PROPERTIES, TechnologyPackage.TECHNOLOGY_SPECIFIC_PROPERTY__OPERATION_TECHNOLOGY);
        }
        return serviceProperties;
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
            case TechnologyPackage.OPERATION_TECHNOLOGY__OPERATION_ENVIRONMENTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getOperationEnvironments()).basicAdd(otherEnd, msgs);
            case TechnologyPackage.OPERATION_TECHNOLOGY__SERVICE_PROPERTIES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getServiceProperties()).basicAdd(otherEnd, msgs);
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
            case TechnologyPackage.OPERATION_TECHNOLOGY__OPERATION_ENVIRONMENTS:
                return ((InternalEList<?>)getOperationEnvironments()).basicRemove(otherEnd, msgs);
            case TechnologyPackage.OPERATION_TECHNOLOGY__SERVICE_PROPERTIES:
                return ((InternalEList<?>)getServiceProperties()).basicRemove(otherEnd, msgs);
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
            case TechnologyPackage.OPERATION_TECHNOLOGY__NAME:
                return getName();
            case TechnologyPackage.OPERATION_TECHNOLOGY__OPERATION_ENVIRONMENTS:
                return getOperationEnvironments();
            case TechnologyPackage.OPERATION_TECHNOLOGY__SERVICE_PROPERTIES:
                return getServiceProperties();
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
            case TechnologyPackage.OPERATION_TECHNOLOGY__NAME:
                setName((String)newValue);
                return;
            case TechnologyPackage.OPERATION_TECHNOLOGY__OPERATION_ENVIRONMENTS:
                getOperationEnvironments().clear();
                getOperationEnvironments().addAll((Collection<? extends OperationEnvironment>)newValue);
                return;
            case TechnologyPackage.OPERATION_TECHNOLOGY__SERVICE_PROPERTIES:
                getServiceProperties().clear();
                getServiceProperties().addAll((Collection<? extends TechnologySpecificProperty>)newValue);
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
            case TechnologyPackage.OPERATION_TECHNOLOGY__NAME:
                setName(NAME_EDEFAULT);
                return;
            case TechnologyPackage.OPERATION_TECHNOLOGY__OPERATION_ENVIRONMENTS:
                getOperationEnvironments().clear();
                return;
            case TechnologyPackage.OPERATION_TECHNOLOGY__SERVICE_PROPERTIES:
                getServiceProperties().clear();
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
            case TechnologyPackage.OPERATION_TECHNOLOGY__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case TechnologyPackage.OPERATION_TECHNOLOGY__OPERATION_ENVIRONMENTS:
                return operationEnvironments != null && !operationEnvironments.isEmpty();
            case TechnologyPackage.OPERATION_TECHNOLOGY__SERVICE_PROPERTIES:
                return serviceProperties != null && !serviceProperties.isEmpty();
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

} //OperationTechnologyImpl
