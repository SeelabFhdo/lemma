/**
 */
package de.fhdo.lemma.technology.impl;

import com.google.common.base.Objects;

import de.fhdo.lemma.technology.PointcutType;
import de.fhdo.lemma.technology.ServiceAspect;
import de.fhdo.lemma.technology.ServiceAspectPointcut;
import de.fhdo.lemma.technology.ServiceAspectPointcutSelector;
import de.fhdo.lemma.technology.TechnologyPackage;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import java.util.function.Consumer;

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

import org.eclipse.xtext.xbase.lib.CollectionLiterals;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Aspect Pointcut Selector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.impl.ServiceAspectPointcutSelectorImpl#getPointcuts <em>Pointcuts</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.ServiceAspectPointcutSelectorImpl#getServiceAspect <em>Service Aspect</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.ServiceAspectPointcutSelectorImpl#getSelectorString <em>Selector String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ServiceAspectPointcutSelectorImpl extends MinimalEObjectImpl.Container implements ServiceAspectPointcutSelector {
    /**
     * The cached value of the '{@link #getPointcuts() <em>Pointcuts</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPointcuts()
     * @generated
     * @ordered
     */
    protected EList<ServiceAspectPointcut> pointcuts;

    /**
     * The default value of the '{@link #getSelectorString() <em>Selector String</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSelectorString()
     * @generated
     * @ordered
     */
    protected static final String SELECTOR_STRING_EDEFAULT = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ServiceAspectPointcutSelectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TechnologyPackage.Literals.SERVICE_ASPECT_POINTCUT_SELECTOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ServiceAspectPointcut> getPointcuts() {
        if (pointcuts == null) {
            pointcuts = new EObjectContainmentWithInverseEList<ServiceAspectPointcut>(ServiceAspectPointcut.class, this, TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR__POINTCUTS, TechnologyPackage.SERVICE_ASPECT_POINTCUT__SELECTOR);
        }
        return pointcuts;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ServiceAspect getServiceAspect() {
        if (eContainerFeatureID() != TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR__SERVICE_ASPECT) return null;
        return (ServiceAspect)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ServiceAspect basicGetServiceAspect() {
        if (eContainerFeatureID() != TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR__SERVICE_ASPECT) return null;
        return (ServiceAspect)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetServiceAspect(ServiceAspect newServiceAspect, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newServiceAspect, TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR__SERVICE_ASPECT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setServiceAspect(ServiceAspect newServiceAspect) {
        if (newServiceAspect != eInternalContainer() || (eContainerFeatureID() != TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR__SERVICE_ASPECT && newServiceAspect != null)) {
            if (EcoreUtil.isAncestor(this, newServiceAspect))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newServiceAspect != null)
                msgs = ((InternalEObject)newServiceAspect).eInverseAdd(this, TechnologyPackage.SERVICE_ASPECT__POINTCUT_SELECTORS, ServiceAspect.class, msgs);
            msgs = basicSetServiceAspect(newServiceAspect, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR__SERVICE_ASPECT, newServiceAspect, newServiceAspect));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getSelectorString() {
        boolean _isEmpty = this.getPointcuts().isEmpty();
        if (_isEmpty) {
            return "";
        }
        final EList<PointcutType> orderedPointcutTypes = this.getPointcuts().get(0).getOrderedPointcutTypes();
        String selectorString = "";
        for (final PointcutType pointcutType : orderedPointcutTypes) {
            final Function1<ServiceAspectPointcut, Boolean> _function = new Function1<ServiceAspectPointcut, Boolean>() {
                public Boolean apply(final ServiceAspectPointcut it) {
                    PointcutType _effectiveType = it.getEffectiveType();
                    return Boolean.valueOf(Objects.equal(_effectiveType, pointcutType));
                }
            };
            Iterable<ServiceAspectPointcut> _filter = IterableExtensions.<ServiceAspectPointcut>filter(this.getPointcuts(), _function);
            for (final ServiceAspectPointcut pointcut : _filter) {
                {
                    String _selectorString = selectorString;
                    String _effectiveSelectorName = pointcut.getEffectiveSelectorName();
                    String _plus = (_effectiveSelectorName + " = ");
                    String _printableEffectiveValue = pointcut.getPrintableEffectiveValue();
                    String _plus_1 = (_plus + _printableEffectiveValue);
                    selectorString = (_selectorString + _plus_1);
                    String _selectorString_1 = selectorString;
                    selectorString = (_selectorString_1 + ", ");
                }
            }
        }
        int _length = selectorString.length();
        boolean _greaterThan = (_length > 2);
        if (_greaterThan) {
            int _length_1 = selectorString.length();
            final int trailingCommaBegin = (_length_1 - 2);
            selectorString = selectorString.substring(0, trailingCommaBegin);
        }
        return selectorString;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Map<PointcutType, List<String>> orderedSelectorValues() {
        boolean _isEmpty = this.getPointcuts().isEmpty();
        if (_isEmpty) {
            return null;
        }
        final LinkedHashMap<PointcutType, List<String>> orderedValues = CollectionLiterals.<PointcutType, List<String>>newLinkedHashMap();
        final EList<PointcutType> orderedPointcutTypes = this.getPointcuts().get(0).getOrderedPointcutTypes();
        final Consumer<PointcutType> _function = new Consumer<PointcutType>() {
            public void accept(final PointcutType pointcutType) {
                final Function1<ServiceAspectPointcut, Boolean> _function = new Function1<ServiceAspectPointcut, Boolean>() {
                    public Boolean apply(final ServiceAspectPointcut it) {
                        PointcutType _effectiveType = it.getEffectiveType();
                        return Boolean.valueOf(Objects.equal(_effectiveType, pointcutType));
                    }
                };
                final Consumer<ServiceAspectPointcut> _function_1 = new Consumer<ServiceAspectPointcut>() {
                    public void accept(final ServiceAspectPointcut it) {
                        List<String> pointcutStrings = orderedValues.get(pointcutType);
                        if ((pointcutStrings == null)) {
                            pointcutStrings = CollectionLiterals.<String>newArrayList();
                            orderedValues.put(pointcutType, pointcutStrings);
                        }
                        pointcutStrings.add(it.getEffectiveValue());
                    }
                };
                IterableExtensions.<ServiceAspectPointcut>filter(ServiceAspectPointcutSelectorImpl.this.getPointcuts(), _function).forEach(_function_1);
            }
        };
        orderedPointcutTypes.forEach(_function);
        return orderedValues;
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
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR__POINTCUTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getPointcuts()).basicAdd(otherEnd, msgs);
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR__SERVICE_ASPECT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetServiceAspect((ServiceAspect)otherEnd, msgs);
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
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR__POINTCUTS:
                return ((InternalEList<?>)getPointcuts()).basicRemove(otherEnd, msgs);
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR__SERVICE_ASPECT:
                return basicSetServiceAspect(null, msgs);
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
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR__SERVICE_ASPECT:
                return eInternalContainer().eInverseRemove(this, TechnologyPackage.SERVICE_ASPECT__POINTCUT_SELECTORS, ServiceAspect.class, msgs);
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
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR__POINTCUTS:
                return getPointcuts();
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR__SERVICE_ASPECT:
                if (resolve) return getServiceAspect();
                return basicGetServiceAspect();
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR__SELECTOR_STRING:
                return getSelectorString();
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
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR__POINTCUTS:
                getPointcuts().clear();
                getPointcuts().addAll((Collection<? extends ServiceAspectPointcut>)newValue);
                return;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR__SERVICE_ASPECT:
                setServiceAspect((ServiceAspect)newValue);
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
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR__POINTCUTS:
                getPointcuts().clear();
                return;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR__SERVICE_ASPECT:
                setServiceAspect((ServiceAspect)null);
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
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR__POINTCUTS:
                return pointcuts != null && !pointcuts.isEmpty();
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR__SERVICE_ASPECT:
                return basicGetServiceAspect() != null;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR__SELECTOR_STRING:
                return SELECTOR_STRING_EDEFAULT == null ? getSelectorString() != null : !SELECTOR_STRING_EDEFAULT.equals(getSelectorString());
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
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR___ORDERED_SELECTOR_VALUES:
                return orderedSelectorValues();
        }
        return super.eInvoke(operationID, arguments);
    }

} //ServiceAspectPointcutSelectorImpl
