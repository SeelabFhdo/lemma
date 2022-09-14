/**
 */
package de.fhdo.lemma.technology.impl;

import com.google.common.base.Objects;

import de.fhdo.lemma.technology.OperationAspect;
import de.fhdo.lemma.technology.OperationAspectPointcut;
import de.fhdo.lemma.technology.OperationAspectPointcutSelector;
import de.fhdo.lemma.technology.PointcutType;
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
 * An implementation of the model object '<em><b>Operation Aspect Pointcut Selector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.impl.OperationAspectPointcutSelectorImpl#getPointcuts <em>Pointcuts</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.OperationAspectPointcutSelectorImpl#getOperationAspect <em>Operation Aspect</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.OperationAspectPointcutSelectorImpl#getSelectorString <em>Selector String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationAspectPointcutSelectorImpl extends MinimalEObjectImpl.Container implements OperationAspectPointcutSelector {
    /**
     * The cached value of the '{@link #getPointcuts() <em>Pointcuts</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPointcuts()
     * @generated
     * @ordered
     */
    protected EList<OperationAspectPointcut> pointcuts;

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
    protected OperationAspectPointcutSelectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TechnologyPackage.Literals.OPERATION_ASPECT_POINTCUT_SELECTOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<OperationAspectPointcut> getPointcuts() {
        if (pointcuts == null) {
            pointcuts = new EObjectContainmentWithInverseEList<OperationAspectPointcut>(OperationAspectPointcut.class, this, TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR__POINTCUTS, TechnologyPackage.OPERATION_ASPECT_POINTCUT__SELECTOR);
        }
        return pointcuts;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationAspect getOperationAspect() {
        if (eContainerFeatureID() != TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR__OPERATION_ASPECT) return null;
        return (OperationAspect)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OperationAspect basicGetOperationAspect() {
        if (eContainerFeatureID() != TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR__OPERATION_ASPECT) return null;
        return (OperationAspect)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOperationAspect(OperationAspect newOperationAspect, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newOperationAspect, TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR__OPERATION_ASPECT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOperationAspect(OperationAspect newOperationAspect) {
        if (newOperationAspect != eInternalContainer() || (eContainerFeatureID() != TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR__OPERATION_ASPECT && newOperationAspect != null)) {
            if (EcoreUtil.isAncestor(this, newOperationAspect))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newOperationAspect != null)
                msgs = ((InternalEObject)newOperationAspect).eInverseAdd(this, TechnologyPackage.OPERATION_ASPECT__POINTCUT_SELECTORS, OperationAspect.class, msgs);
            msgs = basicSetOperationAspect(newOperationAspect, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR__OPERATION_ASPECT, newOperationAspect, newOperationAspect));
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
            final Function1<OperationAspectPointcut, Boolean> _function = new Function1<OperationAspectPointcut, Boolean>() {
                public Boolean apply(final OperationAspectPointcut it) {
                    PointcutType _effectiveType = it.getEffectiveType();
                    return Boolean.valueOf(Objects.equal(_effectiveType, pointcutType));
                }
            };
            Iterable<OperationAspectPointcut> _filter = IterableExtensions.<OperationAspectPointcut>filter(this.getPointcuts(), _function);
            for (final OperationAspectPointcut pointcut : _filter) {
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
                final Function1<OperationAspectPointcut, Boolean> _function = new Function1<OperationAspectPointcut, Boolean>() {
                    public Boolean apply(final OperationAspectPointcut it) {
                        PointcutType _effectiveType = it.getEffectiveType();
                        return Boolean.valueOf(Objects.equal(_effectiveType, pointcutType));
                    }
                };
                final Consumer<OperationAspectPointcut> _function_1 = new Consumer<OperationAspectPointcut>() {
                    public void accept(final OperationAspectPointcut it) {
                        List<String> pointcutStrings = orderedValues.get(pointcutType);
                        if ((pointcutStrings == null)) {
                            pointcutStrings = CollectionLiterals.<String>newArrayList();
                            orderedValues.put(pointcutType, pointcutStrings);
                        }
                        pointcutStrings.add(it.getEffectiveValue());
                    }
                };
                IterableExtensions.<OperationAspectPointcut>filter(OperationAspectPointcutSelectorImpl.this.getPointcuts(), _function).forEach(_function_1);
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
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR__POINTCUTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getPointcuts()).basicAdd(otherEnd, msgs);
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR__OPERATION_ASPECT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetOperationAspect((OperationAspect)otherEnd, msgs);
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
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR__POINTCUTS:
                return ((InternalEList<?>)getPointcuts()).basicRemove(otherEnd, msgs);
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR__OPERATION_ASPECT:
                return basicSetOperationAspect(null, msgs);
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
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR__OPERATION_ASPECT:
                return eInternalContainer().eInverseRemove(this, TechnologyPackage.OPERATION_ASPECT__POINTCUT_SELECTORS, OperationAspect.class, msgs);
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
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR__POINTCUTS:
                return getPointcuts();
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR__OPERATION_ASPECT:
                if (resolve) return getOperationAspect();
                return basicGetOperationAspect();
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR__SELECTOR_STRING:
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
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR__POINTCUTS:
                getPointcuts().clear();
                getPointcuts().addAll((Collection<? extends OperationAspectPointcut>)newValue);
                return;
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR__OPERATION_ASPECT:
                setOperationAspect((OperationAspect)newValue);
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
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR__POINTCUTS:
                getPointcuts().clear();
                return;
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR__OPERATION_ASPECT:
                setOperationAspect((OperationAspect)null);
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
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR__POINTCUTS:
                return pointcuts != null && !pointcuts.isEmpty();
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR__OPERATION_ASPECT:
                return basicGetOperationAspect() != null;
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR__SELECTOR_STRING:
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
            case TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR___ORDERED_SELECTOR_VALUES:
                return orderedSelectorValues();
        }
        return super.eInvoke(operationID, arguments);
    }

} //OperationAspectPointcutSelectorImpl
