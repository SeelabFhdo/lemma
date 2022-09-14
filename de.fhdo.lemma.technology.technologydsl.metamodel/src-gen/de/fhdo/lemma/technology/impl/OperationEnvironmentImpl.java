/**
 */
package de.fhdo.lemma.technology.impl;

import de.fhdo.lemma.technology.OperationEnvironment;
import de.fhdo.lemma.technology.OperationTechnology;
import de.fhdo.lemma.technology.TechnologyPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Environment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.impl.OperationEnvironmentImpl#getEnvironmentName <em>Environment Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.OperationEnvironmentImpl#isDefault <em>Default</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.OperationEnvironmentImpl#getOperationTechnology <em>Operation Technology</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationEnvironmentImpl extends MinimalEObjectImpl.Container implements OperationEnvironment {
    /**
     * The default value of the '{@link #getEnvironmentName() <em>Environment Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEnvironmentName()
     * @generated
     * @ordered
     */
    protected static final String ENVIRONMENT_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEnvironmentName() <em>Environment Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEnvironmentName()
     * @generated
     * @ordered
     */
    protected String environmentName = ENVIRONMENT_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #isDefault() <em>Default</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDefault()
     * @generated
     * @ordered
     */
    protected static final boolean DEFAULT_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isDefault() <em>Default</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDefault()
     * @generated
     * @ordered
     */
    protected boolean default_ = DEFAULT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected OperationEnvironmentImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TechnologyPackage.Literals.OPERATION_ENVIRONMENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getEnvironmentName() {
        return environmentName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEnvironmentName(String newEnvironmentName) {
        String oldEnvironmentName = environmentName;
        environmentName = newEnvironmentName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.OPERATION_ENVIRONMENT__ENVIRONMENT_NAME, oldEnvironmentName, environmentName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isDefault() {
        return default_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefault(boolean newDefault) {
        boolean oldDefault = default_;
        default_ = newDefault;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.OPERATION_ENVIRONMENT__DEFAULT, oldDefault, default_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationTechnology getOperationTechnology() {
        if (eContainerFeatureID() != TechnologyPackage.OPERATION_ENVIRONMENT__OPERATION_TECHNOLOGY) return null;
        return (OperationTechnology)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationTechnology basicGetOperationTechnology() {
        if (eContainerFeatureID() != TechnologyPackage.OPERATION_ENVIRONMENT__OPERATION_TECHNOLOGY) return null;
        return (OperationTechnology)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOperationTechnology(OperationTechnology newOperationTechnology, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOperationTechnology, TechnologyPackage.OPERATION_ENVIRONMENT__OPERATION_TECHNOLOGY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOperationTechnology(OperationTechnology newOperationTechnology) {
        if (newOperationTechnology != eInternalContainer() || (eContainerFeatureID() != TechnologyPackage.OPERATION_ENVIRONMENT__OPERATION_TECHNOLOGY && newOperationTechnology != null)) {
            if (EcoreUtil.isAncestor(this, newOperationTechnology))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOperationTechnology != null)
                msgs = ((InternalEObject)newOperationTechnology).eInverseAdd(this, TechnologyPackage.OPERATION_TECHNOLOGY__OPERATION_ENVIRONMENTS, OperationTechnology.class, msgs);
            msgs = basicSetOperationTechnology(newOperationTechnology, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.OPERATION_ENVIRONMENT__OPERATION_TECHNOLOGY, newOperationTechnology, newOperationTechnology));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TechnologyPackage.OPERATION_ENVIRONMENT__OPERATION_TECHNOLOGY:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOperationTechnology((OperationTechnology)otherEnd, msgs);
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
            case TechnologyPackage.OPERATION_ENVIRONMENT__OPERATION_TECHNOLOGY:
                return basicSetOperationTechnology(null, msgs);
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
            case TechnologyPackage.OPERATION_ENVIRONMENT__OPERATION_TECHNOLOGY:
                return eInternalContainer().eInverseRemove(this, TechnologyPackage.OPERATION_TECHNOLOGY__OPERATION_ENVIRONMENTS, OperationTechnology.class, msgs);
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
            case TechnologyPackage.OPERATION_ENVIRONMENT__ENVIRONMENT_NAME:
                return getEnvironmentName();
            case TechnologyPackage.OPERATION_ENVIRONMENT__DEFAULT:
                return isDefault();
            case TechnologyPackage.OPERATION_ENVIRONMENT__OPERATION_TECHNOLOGY:
                if (resolve) return getOperationTechnology();
                return basicGetOperationTechnology();
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
            case TechnologyPackage.OPERATION_ENVIRONMENT__ENVIRONMENT_NAME:
                setEnvironmentName((String)newValue);
                return;
            case TechnologyPackage.OPERATION_ENVIRONMENT__DEFAULT:
                setDefault((Boolean)newValue);
                return;
            case TechnologyPackage.OPERATION_ENVIRONMENT__OPERATION_TECHNOLOGY:
                setOperationTechnology((OperationTechnology)newValue);
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
            case TechnologyPackage.OPERATION_ENVIRONMENT__ENVIRONMENT_NAME:
                setEnvironmentName(ENVIRONMENT_NAME_EDEFAULT);
                return;
            case TechnologyPackage.OPERATION_ENVIRONMENT__DEFAULT:
                setDefault(DEFAULT_EDEFAULT);
                return;
            case TechnologyPackage.OPERATION_ENVIRONMENT__OPERATION_TECHNOLOGY:
                setOperationTechnology((OperationTechnology)null);
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
            case TechnologyPackage.OPERATION_ENVIRONMENT__ENVIRONMENT_NAME:
                return ENVIRONMENT_NAME_EDEFAULT == null ? environmentName != null : !ENVIRONMENT_NAME_EDEFAULT.equals(environmentName);
            case TechnologyPackage.OPERATION_ENVIRONMENT__DEFAULT:
                return default_ != DEFAULT_EDEFAULT;
            case TechnologyPackage.OPERATION_ENVIRONMENT__OPERATION_TECHNOLOGY:
                return basicGetOperationTechnology() != null;
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
        result.append(" (environmentName: ");
        result.append(environmentName);
        result.append(", default: ");
        result.append(default_);
        result.append(')');
        return result.toString();
    }

} //OperationEnvironmentImpl
