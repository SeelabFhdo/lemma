/**
 */
package de.fhdo.lemma.technology.impl;

import com.google.common.base.Objects;

import de.fhdo.lemma.technology.DeploymentTechnology;
import de.fhdo.lemma.technology.InfrastructureTechnology;
import de.fhdo.lemma.technology.OperationAspect;
import de.fhdo.lemma.technology.OperationAspectPointcut;
import de.fhdo.lemma.technology.OperationAspectPointcutSelector;
import de.fhdo.lemma.technology.PointcutType;
import de.fhdo.lemma.technology.Technology;
import de.fhdo.lemma.technology.TechnologyPackage;

import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Aspect</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.impl.OperationAspectImpl#getPointcutSelectors <em>Pointcut Selectors</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.OperationAspectImpl#getTechnology <em>Technology</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationAspectImpl extends TechnologyAspectImpl implements OperationAspect {
    /**
     * The cached value of the '{@link #getPointcutSelectors() <em>Pointcut Selectors</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPointcutSelectors()
     * @generated
     * @ordered
     */
    protected EList<OperationAspectPointcutSelector> pointcutSelectors;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected OperationAspectImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TechnologyPackage.Literals.OPERATION_ASPECT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<OperationAspectPointcutSelector> getPointcutSelectors() {
        if (pointcutSelectors == null) {
            pointcutSelectors = new EObjectContainmentWithInverseEList<OperationAspectPointcutSelector>(OperationAspectPointcutSelector.class, this, TechnologyPackage.OPERATION_ASPECT__POINTCUT_SELECTORS, TechnologyPackage.OPERATION_ASPECT_POINTCUT_SELECTOR__OPERATION_ASPECT);
        }
        return pointcutSelectors;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Technology getTechnology() {
        if (eContainerFeatureID() != TechnologyPackage.OPERATION_ASPECT__TECHNOLOGY) return null;
        return (Technology)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Technology basicGetTechnology() {
        if (eContainerFeatureID() != TechnologyPackage.OPERATION_ASPECT__TECHNOLOGY) return null;
        return (Technology)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTechnology(Technology newTechnology, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newTechnology, TechnologyPackage.OPERATION_ASPECT__TECHNOLOGY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTechnology(Technology newTechnology) {
        if (newTechnology != eInternalContainer() || (eContainerFeatureID() != TechnologyPackage.OPERATION_ASPECT__TECHNOLOGY && newTechnology != null)) {
            if (EcoreUtil.isAncestor(this, newTechnology))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newTechnology != null)
                msgs = ((InternalEObject)newTechnology).eInverseAdd(this, TechnologyPackage.TECHNOLOGY__OPERATION_ASPECTS, Technology.class, msgs);
            msgs = basicSetTechnology(newTechnology, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.OPERATION_ASPECT__TECHNOLOGY, newTechnology, newTechnology));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getQualifiedNameParts(final boolean withTechnologyName, final boolean withNamespace) {
        EList<String> _xblockexpression = null;
        {
            if (((this.getName() == null) || this.getName().isEmpty())) {
                return ECollections.<String>asEList(CollectionLiterals.<String>newArrayList());
            }
            final ArrayList<String> nameParts = CollectionLiterals.<String>newArrayList();
            if (withTechnologyName) {
                nameParts.add(this.getTechnology().getName());
            }
            if (withNamespace) {
                nameParts.add("_aspects");
            }
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
    public String buildQualifiedName(final String separator, final boolean withTechnologyName, final boolean withNamespace) {
        if ((separator == null)) {
            return null;
        }
        String qualifiedName = "";
        EList<String> _qualifiedNameParts = this.getQualifiedNameParts(withTechnologyName, withNamespace);
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
    public boolean hasMatchingSelector(final EObject forTechnology) {
        boolean _isEmpty = this.getPointcutSelectors().isEmpty();
        if (_isEmpty) {
            return true;
        }
        EList<OperationAspectPointcutSelector> _pointcutSelectors = this.getPointcutSelectors();
        for (final OperationAspectPointcutSelector selector : _pointcutSelectors) {
            {
                EList<PointcutType> pointcutTypes = selector.getPointcuts().get(0).getOrderedPointcutTypes();
                boolean allPointcutsMatch = true;
                int pointcutTypeIndex = 0;
                while ((allPointcutsMatch && (pointcutTypeIndex < pointcutTypes.size()))) {
                    {
                        final PointcutType pointcutType = pointcutTypes.get(pointcutTypeIndex);
                        final Function1<OperationAspectPointcut, Boolean> _function = new Function1<OperationAspectPointcut, Boolean>() {
                            public Boolean apply(final OperationAspectPointcut it) {
                                PointcutType _effectiveType = it.getEffectiveType();
                                return Boolean.valueOf(Objects.equal(_effectiveType, pointcutType));
                            }
                        };
                        final Function1<OperationAspectPointcut, String> _function_1 = new Function1<OperationAspectPointcut, String>() {
                            public String apply(final OperationAspectPointcut it) {
                                return it.getEffectiveValue();
                            }
                        };
                        List<String> pointcutValuesOfType = IterableExtensions.<String>toList(IterableExtensions.<OperationAspectPointcut, String>map(IterableExtensions.<OperationAspectPointcut>filter(selector.getPointcuts(), _function), _function_1));
                        String _switchResult = null;
                        if (pointcutType != null) {
                            switch (pointcutType) {
                                case TECHNOLOGY:
                                    String _xifexpression = null;
                                    if ((forTechnology != null)) {
                                        String _xifexpression_1 = null;
                                        if ((forTechnology instanceof DeploymentTechnology)) {
                                            _xifexpression_1 = ((DeploymentTechnology)forTechnology).getName();
                                        }
                                        else {
                                            String _xifexpression_2 = null;
                                            if ((forTechnology instanceof InfrastructureTechnology)) {
                                                _xifexpression_2 = ((InfrastructureTechnology)forTechnology).getName();
                                            }
                                            _xifexpression_1 = _xifexpression_2;
                                        }
                                        _xifexpression = _xifexpression_1;
                                    }
                                    _switchResult = _xifexpression;
                                    break;
                                default:
                                    _switchResult = null;
                                    break;
                            }
                        }
                        else {
                            _switchResult = null;
                        }
                        String forValue = _switchResult;
                        boolean _isEmpty_1 = pointcutValuesOfType.isEmpty();
                        boolean _not = (!_isEmpty_1);
                        if (_not) {
                            if ((forValue != null)) {
                                allPointcutsMatch = pointcutValuesOfType.contains(forValue);
                            }
                            else {
                                allPointcutsMatch = false;
                            }
                        }
                        pointcutTypeIndex++;
                    }
                }
                if (allPointcutsMatch) {
                    return true;
                }
            }
        }
        return false;
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
            case TechnologyPackage.OPERATION_ASPECT__POINTCUT_SELECTORS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getPointcutSelectors()).basicAdd(otherEnd, msgs);
            case TechnologyPackage.OPERATION_ASPECT__TECHNOLOGY:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetTechnology((Technology)otherEnd, msgs);
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
            case TechnologyPackage.OPERATION_ASPECT__POINTCUT_SELECTORS:
                return ((InternalEList<?>)getPointcutSelectors()).basicRemove(otherEnd, msgs);
            case TechnologyPackage.OPERATION_ASPECT__TECHNOLOGY:
                return basicSetTechnology(null, msgs);
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
            case TechnologyPackage.OPERATION_ASPECT__TECHNOLOGY:
                return eInternalContainer().eInverseRemove(this, TechnologyPackage.TECHNOLOGY__OPERATION_ASPECTS, Technology.class, msgs);
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
            case TechnologyPackage.OPERATION_ASPECT__POINTCUT_SELECTORS:
                return getPointcutSelectors();
            case TechnologyPackage.OPERATION_ASPECT__TECHNOLOGY:
                if (resolve) return getTechnology();
                return basicGetTechnology();
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
            case TechnologyPackage.OPERATION_ASPECT__POINTCUT_SELECTORS:
                getPointcutSelectors().clear();
                getPointcutSelectors().addAll((Collection<? extends OperationAspectPointcutSelector>)newValue);
                return;
            case TechnologyPackage.OPERATION_ASPECT__TECHNOLOGY:
                setTechnology((Technology)newValue);
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
            case TechnologyPackage.OPERATION_ASPECT__POINTCUT_SELECTORS:
                getPointcutSelectors().clear();
                return;
            case TechnologyPackage.OPERATION_ASPECT__TECHNOLOGY:
                setTechnology((Technology)null);
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
            case TechnologyPackage.OPERATION_ASPECT__POINTCUT_SELECTORS:
                return pointcutSelectors != null && !pointcutSelectors.isEmpty();
            case TechnologyPackage.OPERATION_ASPECT__TECHNOLOGY:
                return basicGetTechnology() != null;
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
            case TechnologyPackage.OPERATION_ASPECT___GET_QUALIFIED_NAME_PARTS__BOOLEAN_BOOLEAN:
                return getQualifiedNameParts((Boolean)arguments.get(0), (Boolean)arguments.get(1));
            case TechnologyPackage.OPERATION_ASPECT___BUILD_QUALIFIED_NAME__STRING_BOOLEAN_BOOLEAN:
                return buildQualifiedName((String)arguments.get(0), (Boolean)arguments.get(1), (Boolean)arguments.get(2));
            case TechnologyPackage.OPERATION_ASPECT___HAS_MATCHING_SELECTOR__EOBJECT:
                return hasMatchingSelector((EObject)arguments.get(0));
        }
        return super.eInvoke(operationID, arguments);
    }

} //OperationAspectImpl
