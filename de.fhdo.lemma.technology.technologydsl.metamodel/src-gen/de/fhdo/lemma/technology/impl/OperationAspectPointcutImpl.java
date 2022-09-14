/**
 */
package de.fhdo.lemma.technology.impl;

import de.fhdo.lemma.technology.DeploymentTechnology;
import de.fhdo.lemma.technology.InfrastructureTechnology;
import de.fhdo.lemma.technology.OperationAspectPointcut;
import de.fhdo.lemma.technology.OperationAspectPointcutSelector;
import de.fhdo.lemma.technology.PointcutType;
import de.fhdo.lemma.technology.TechnologyPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Aspect Pointcut</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.impl.OperationAspectPointcutImpl#isForTechnology <em>For Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.OperationAspectPointcutImpl#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.OperationAspectPointcutImpl#getSelector <em>Selector</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.OperationAspectPointcutImpl#getEffectiveType <em>Effective Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.OperationAspectPointcutImpl#getEffectiveSelectorName <em>Effective Selector Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.OperationAspectPointcutImpl#getEffectiveValue <em>Effective Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.OperationAspectPointcutImpl#getPrintableEffectiveValue <em>Printable Effective Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.OperationAspectPointcutImpl#getOrderedPointcutTypes <em>Ordered Pointcut Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationAspectPointcutImpl extends MinimalEObjectImpl.Container implements OperationAspectPointcut {
    /**
     * The default value of the '{@link #isForTechnology() <em>For Technology</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isForTechnology()
     * @generated
     * @ordered
     */
    protected static final boolean FOR_TECHNOLOGY_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isForTechnology() <em>For Technology</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isForTechnology()
     * @generated
     * @ordered
     */
    protected boolean forTechnology = FOR_TECHNOLOGY_EDEFAULT;

    /**
     * The cached value of the '{@link #getTechnology() <em>Technology</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTechnology()
     * @generated
     * @ordered
     */
    protected EObject technology;

    /**
     * The default value of the '{@link #getEffectiveType() <em>Effective Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEffectiveType()
     * @generated
     * @ordered
     */
    protected static final PointcutType EFFECTIVE_TYPE_EDEFAULT = PointcutType.EXCHANGE_PATTERN;

    /**
     * The default value of the '{@link #getEffectiveSelectorName() <em>Effective Selector Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEffectiveSelectorName()
     * @generated
     * @ordered
     */
    protected static final String EFFECTIVE_SELECTOR_NAME_EDEFAULT = null;

    /**
     * The default value of the '{@link #getEffectiveValue() <em>Effective Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEffectiveValue()
     * @generated
     * @ordered
     */
    protected static final String EFFECTIVE_VALUE_EDEFAULT = null;

    /**
     * The default value of the '{@link #getPrintableEffectiveValue() <em>Printable Effective Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPrintableEffectiveValue()
     * @generated
     * @ordered
     */
    protected static final String PRINTABLE_EFFECTIVE_VALUE_EDEFAULT = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected OperationAspectPointcutImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TechnologyPackage.Literals.OPERATION_ASPECT_POINTCUT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isForTechnology() {
        return forTechnology;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setForTechnology(boolean newForTechnology) {
        boolean oldForTechnology = forTechnology;
        forTechnology = newForTechnology;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.OPERATION_ASPECT_POINTCUT__FOR_TECHNOLOGY, oldForTechnology, forTechnology));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EObject getTechnology() {
        if (technology != null && technology.eIsProxy()) {
            InternalEObject oldTechnology = (InternalEObject)technology;
            technology = eResolveProxy(oldTechnology);
            if (technology != oldTechnology) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, TechnologyPackage.OPERATION_ASPECT_POINTCUT__TECHNOLOGY, oldTechnology, technology));
            }
        }
        return technology;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EObject basicGetTechnology() {
        return technology;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTechnology(EObject newTechnology) {
        EObject oldTechnology = technology;
        technology = newTechnology;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.OPERATION_ASPECT_POINTCUT__TECHNOLOGY, oldTechnology, technology));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationAspectPointcutSelector getSelector() {
        if (eContainerFeatureID() != TechnologyPackage.OPERATION_ASPECT_POINTCUT__SELECTOR) return null;
        return (OperationAspectPointcutSelector)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationAspectPointcutSelector basicGetSelector() {
        if (eContainerFeatureID() != TechnologyPackage.OPERATION_ASPECT_POINTCUT__SELECTOR) return null;
        return (OperationAspectPointcutSelector)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSelector(OperationAspectPointcutSelector newSelector, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newSelector, TechnologyPackage.OPERATION_ASPECT_POINTCUT__SELECTOR, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSelector(OperationAspectPointcutSelector newSelector) {
        if (newSelector != eInternalContainer() || (eContainerFeatureID() != TechnologyPackage.OPERATION_ASPECT_POINTCUT__SELECTOR && newSelector != null)) {
            if (EcoreUtil.isAncestor(this, newSelector))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newSelector != null)
                msgs = ((InternalEObject)newSelector).eInverseAdd(this, TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR__POINTCUTS, OperationAspectPointcutSelector.class, msgs);
            msgs = basicSetSelector(newSelector, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.OPERATION_ASPECT_POINTCUT__SELECTOR, newSelector, newSelector));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PointcutType getEffectiveType() {
        PointcutType _xifexpression = null;
        boolean _isForTechnology = this.isForTechnology();
        if (_isForTechnology) {
            _xifexpression = PointcutType.TECHNOLOGY;
        }
        else {
            _xifexpression = null;
        }
        return _xifexpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getEffectiveSelectorName() {
        String _switchResult = null;
        PointcutType _effectiveType = this.getEffectiveType();
        if (_effectiveType != null) {
            switch (_effectiveType) {
                case TECHNOLOGY:
                    _switchResult = "technology";
                    break;
                default:
                    _switchResult = null;
                    break;
            }
        }
        else {
            _switchResult = null;
        }
        return _switchResult;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getEffectiveValue() {
        String _xifexpression = null;
        if (((this.getEffectiveType() == PointcutType.TECHNOLOGY) && (this.getTechnology() != null))) {
            String _xifexpression_1 = null;
            EObject _technology = this.getTechnology();
            if ((_technology instanceof DeploymentTechnology)) {
                EObject _technology_1 = this.getTechnology();
                _xifexpression_1 = ((DeploymentTechnology) _technology_1).getName();
            }
            else {
                String _xifexpression_2 = null;
                EObject _technology_2 = this.getTechnology();
                if ((_technology_2 instanceof InfrastructureTechnology)) {
                    EObject _technology_3 = this.getTechnology();
                    _xifexpression_2 = ((InfrastructureTechnology) _technology_3).getName();
                }
                else {
                    _xifexpression_2 = null;
                }
                _xifexpression_1 = _xifexpression_2;
            }
            _xifexpression = _xifexpression_1;
        }
        return _xifexpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getPrintableEffectiveValue() {
        String _xifexpression = null;
        if (((this.getEffectiveType() == PointcutType.TECHNOLOGY) && (this.getTechnology() != null))) {
            String _xifexpression_1 = null;
            EObject _technology = this.getTechnology();
            if ((_technology instanceof DeploymentTechnology)) {
                EObject _technology_1 = this.getTechnology();
                _xifexpression_1 = ((DeploymentTechnology) _technology_1).getName();
            }
            else {
                String _xifexpression_2 = null;
                EObject _technology_2 = this.getTechnology();
                if ((_technology_2 instanceof InfrastructureTechnology)) {
                    EObject _technology_3 = this.getTechnology();
                    _xifexpression_2 = ((InfrastructureTechnology) _technology_3).getName();
                }
                else {
                    _xifexpression_2 = null;
                }
                _xifexpression_1 = _xifexpression_2;
            }
            _xifexpression = _xifexpression_1;
        }
        return _xifexpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PointcutType> getOrderedPointcutTypes() {
        return ECollections.<PointcutType>asEList(java.util.Collections.<PointcutType>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<PointcutType>newArrayList(PointcutType.TECHNOLOGY)));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT__SELECTOR:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetSelector((OperationAspectPointcutSelector)otherEnd, msgs);
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
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT__SELECTOR:
                return basicSetSelector(null, msgs);
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
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT__SELECTOR:
                return eInternalContainer().eInverseRemove(this, TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR__POINTCUTS, OperationAspectPointcutSelector.class, msgs);
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
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT__FOR_TECHNOLOGY:
                return isForTechnology();
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT__TECHNOLOGY:
                if (resolve) return getTechnology();
                return basicGetTechnology();
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT__SELECTOR:
                if (resolve) return getSelector();
                return basicGetSelector();
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT__EFFECTIVE_TYPE:
                return getEffectiveType();
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT__EFFECTIVE_SELECTOR_NAME:
                return getEffectiveSelectorName();
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT__EFFECTIVE_VALUE:
                return getEffectiveValue();
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT__PRINTABLE_EFFECTIVE_VALUE:
                return getPrintableEffectiveValue();
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT__ORDERED_POINTCUT_TYPES:
                return getOrderedPointcutTypes();
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
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT__FOR_TECHNOLOGY:
                setForTechnology((Boolean)newValue);
                return;
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT__TECHNOLOGY:
                setTechnology((EObject)newValue);
                return;
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT__SELECTOR:
                setSelector((OperationAspectPointcutSelector)newValue);
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
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT__FOR_TECHNOLOGY:
                setForTechnology(FOR_TECHNOLOGY_EDEFAULT);
                return;
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT__TECHNOLOGY:
                setTechnology((EObject)null);
                return;
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT__SELECTOR:
                setSelector((OperationAspectPointcutSelector)null);
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
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT__FOR_TECHNOLOGY:
                return forTechnology != FOR_TECHNOLOGY_EDEFAULT;
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT__TECHNOLOGY:
                return technology != null;
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT__SELECTOR:
                return basicGetSelector() != null;
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT__EFFECTIVE_TYPE:
                return getEffectiveType() != EFFECTIVE_TYPE_EDEFAULT;
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT__EFFECTIVE_SELECTOR_NAME:
                return EFFECTIVE_SELECTOR_NAME_EDEFAULT == null ? getEffectiveSelectorName() != null : !EFFECTIVE_SELECTOR_NAME_EDEFAULT.equals(getEffectiveSelectorName());
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT__EFFECTIVE_VALUE:
                return EFFECTIVE_VALUE_EDEFAULT == null ? getEffectiveValue() != null : !EFFECTIVE_VALUE_EDEFAULT.equals(getEffectiveValue());
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT__PRINTABLE_EFFECTIVE_VALUE:
                return PRINTABLE_EFFECTIVE_VALUE_EDEFAULT == null ? getPrintableEffectiveValue() != null : !PRINTABLE_EFFECTIVE_VALUE_EDEFAULT.equals(getPrintableEffectiveValue());
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT__ORDERED_POINTCUT_TYPES:
                return !getOrderedPointcutTypes().isEmpty();
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
        result.append(" (forTechnology: ");
        result.append(forTechnology);
        result.append(')');
        return result.toString();
    }

} //OperationAspectPointcutImpl
