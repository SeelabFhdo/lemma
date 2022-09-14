/**
 */
package de.fhdo.lemma.technology.impl;

import com.google.common.base.Objects;

import de.fhdo.lemma.technology.CommunicationType;
import de.fhdo.lemma.technology.DataFormat;
import de.fhdo.lemma.technology.ExchangePattern;
import de.fhdo.lemma.technology.JoinPointType;
import de.fhdo.lemma.technology.PointcutType;
import de.fhdo.lemma.technology.Protocol;
import de.fhdo.lemma.technology.ServiceAspect;
import de.fhdo.lemma.technology.ServiceAspectPointcut;
import de.fhdo.lemma.technology.ServiceAspectPointcutSelector;
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
 * An implementation of the model object '<em><b>Service Aspect</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.impl.ServiceAspectImpl#getPointcutSelectors <em>Pointcut Selectors</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.ServiceAspectImpl#getTechnology <em>Technology</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ServiceAspectImpl extends TechnologyAspectImpl implements ServiceAspect {
    /**
     * The cached value of the '{@link #getPointcutSelectors() <em>Pointcut Selectors</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPointcutSelectors()
     * @generated
     * @ordered
     */
    protected EList<ServiceAspectPointcutSelector> pointcutSelectors;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ServiceAspectImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TechnologyPackage.Literals.SERVICE_ASPECT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ServiceAspectPointcutSelector> getPointcutSelectors() {
        if (pointcutSelectors == null) {
            pointcutSelectors = new EObjectContainmentWithInverseEList<ServiceAspectPointcutSelector>(ServiceAspectPointcutSelector.class, this, TechnologyPackage.SERVICE_ASPECT__POINTCUT_SELECTORS, TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR__SERVICE_ASPECT);
        }
        return pointcutSelectors;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Technology getTechnology() {
        if (eContainerFeatureID() != TechnologyPackage.SERVICE_ASPECT__TECHNOLOGY) return null;
        return (Technology)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Technology basicGetTechnology() {
        if (eContainerFeatureID() != TechnologyPackage.SERVICE_ASPECT__TECHNOLOGY) return null;
        return (Technology)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTechnology(Technology newTechnology, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newTechnology, TechnologyPackage.SERVICE_ASPECT__TECHNOLOGY, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTechnology(Technology newTechnology) {
        if (newTechnology != eInternalContainer() || (eContainerFeatureID() != TechnologyPackage.SERVICE_ASPECT__TECHNOLOGY && newTechnology != null)) {
            if (EcoreUtil.isAncestor(this, newTechnology))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newTechnology != null)
                msgs = ((InternalEObject)newTechnology).eInverseAdd(this, TechnologyPackage.TECHNOLOGY__SERVICE_ASPECTS, Technology.class, msgs);
            msgs = basicSetTechnology(newTechnology, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.SERVICE_ASPECT__TECHNOLOGY, newTechnology, newTechnology));
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
    public boolean isValidSelectorForJoinPoint(final JoinPointType joinPoint, final ServiceAspectPointcutSelector selector) {
        final Function1<ServiceAspectPointcut, Boolean> _function = new Function1<ServiceAspectPointcut, Boolean>() {
            public Boolean apply(final ServiceAspectPointcut it) {
                return Boolean.valueOf(it.isForExchangePattern());
            }
        };
        ServiceAspectPointcut _findFirst = IterableExtensions.<ServiceAspectPointcut>findFirst(selector.getPointcuts(), _function);
        ExchangePattern _exchangePattern = null;
        if (_findFirst!=null) {
            _exchangePattern=_findFirst.getExchangePattern();
        }
        final ExchangePattern exchangePattern = _exchangePattern;
        final Function1<ServiceAspectPointcut, Boolean> _function_1 = new Function1<ServiceAspectPointcut, Boolean>() {
            public Boolean apply(final ServiceAspectPointcut it) {
                return Boolean.valueOf(it.isForExchangePattern());
            }
        };
        ServiceAspectPointcut _findFirst_1 = IterableExtensions.<ServiceAspectPointcut>findFirst(selector.getPointcuts(), _function_1);
        CommunicationType _communicationType = null;
        if (_findFirst_1!=null) {
            _communicationType=_findFirst_1.getCommunicationType();
        }
        final CommunicationType communicationType = _communicationType;
        final Function1<ServiceAspectPointcut, Boolean> _function_2 = new Function1<ServiceAspectPointcut, Boolean>() {
            public Boolean apply(final ServiceAspectPointcut it) {
                return Boolean.valueOf(it.isForExchangePattern());
            }
        };
        ServiceAspectPointcut _findFirst_2 = IterableExtensions.<ServiceAspectPointcut>findFirst(selector.getPointcuts(), _function_2);
        Protocol _protocol = null;
        if (_findFirst_2!=null) {
            _protocol=_findFirst_2.getProtocol();
        }
        final Protocol protocol = _protocol;
        final Function1<ServiceAspectPointcut, Boolean> _function_3 = new Function1<ServiceAspectPointcut, Boolean>() {
            public Boolean apply(final ServiceAspectPointcut it) {
                return Boolean.valueOf(it.isForExchangePattern());
            }
        };
        ServiceAspectPointcut _findFirst_3 = IterableExtensions.<ServiceAspectPointcut>findFirst(selector.getPointcuts(), _function_3);
        DataFormat _dataFormat = null;
        if (_findFirst_3!=null) {
            _dataFormat=_findFirst_3.getDataFormat();
        }
        final DataFormat dataFormat = _dataFormat;
        return this.isValidSelectorForJoinPoint(joinPoint, exchangePattern, communicationType, protocol, dataFormat);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isValidSelectorForJoinPoint(final JoinPointType joinPoint, final ExchangePattern exchangePattern, final CommunicationType communicationType, final Protocol protocol, final DataFormat dataFormat) {
        boolean _switchResult = false;
        if (joinPoint != null) {
            switch (joinPoint) {
                case COMPLEX_TYPES:
                    _switchResult = false;
                    break;
                case DATA_FIELDS:
                    _switchResult = true;
                    break;
                case DATA_OPERATIONS:
                    _switchResult = false;
                    break;
                case DATA_OPERATION_PARAMETERS:
                    _switchResult = false;
                    break;
                case MICROSERVICES:
                    _switchResult = ((exchangePattern == null) && (communicationType == null));
                    break;
                case INTERFACES:
                    _switchResult = ((exchangePattern == null) && (communicationType == null));
                    break;
                case OPERATIONS:
                    _switchResult = ((exchangePattern == null) && (communicationType == null));
                    break;
                case PARAMETERS:
                    _switchResult = true;
                    break;
                default:
                    _switchResult = false;
                    break;
            }
        }
        else {
            _switchResult = false;
        }
        return _switchResult;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean hasMatchingSelector(final ExchangePattern forExchangePattern, final CommunicationType forCommunicationType, final Protocol forProtocol, final DataFormat forDataFormat) {
        boolean _isEmpty = this.getPointcutSelectors().isEmpty();
        if (_isEmpty) {
            return true;
        }
        EList<ServiceAspectPointcutSelector> _pointcutSelectors = this.getPointcutSelectors();
        for (final ServiceAspectPointcutSelector selector : _pointcutSelectors) {
            {
                EList<PointcutType> pointcutTypes = selector.getPointcuts().get(0).getOrderedPointcutTypes();
                boolean allPointcutsMatch = true;
                int pointcutTypeIndex = 0;
                while ((allPointcutsMatch && (pointcutTypeIndex < pointcutTypes.size()))) {
                    {
                        final PointcutType pointcutType = pointcutTypes.get(pointcutTypeIndex);
                        final Function1<ServiceAspectPointcut, Boolean> _function = new Function1<ServiceAspectPointcut, Boolean>() {
                            public Boolean apply(final ServiceAspectPointcut it) {
                                PointcutType _effectiveType = it.getEffectiveType();
                                return Boolean.valueOf(Objects.equal(_effectiveType, pointcutType));
                            }
                        };
                        final Function1<ServiceAspectPointcut, String> _function_1 = new Function1<ServiceAspectPointcut, String>() {
                            public String apply(final ServiceAspectPointcut it) {
                                return it.getEffectiveValue();
                            }
                        };
                        List<String> pointcutValuesOfType = IterableExtensions.<String>toList(IterableExtensions.<ServiceAspectPointcut, String>map(IterableExtensions.<ServiceAspectPointcut>filter(selector.getPointcuts(), _function), _function_1));
                        String _switchResult = null;
                        if (pointcutType != null) {
                            switch (pointcutType) {
                                case EXCHANGE_PATTERN:
                                    String _xifexpression = null;
                                    if ((forExchangePattern != null)) {
                                        _xifexpression = forExchangePattern.getName();
                                    }
                                    _switchResult = _xifexpression;
                                    break;
                                case COMMUNICATION_TYPE:
                                    String _xifexpression_1 = null;
                                    if ((forCommunicationType != null)) {
                                        _xifexpression_1 = forCommunicationType.getName();
                                    }
                                    _switchResult = _xifexpression_1;
                                    break;
                                case PROTOCOL:
                                    String _xifexpression_2 = null;
                                    if ((forProtocol != null)) {
                                        _xifexpression_2 = forProtocol.getName();
                                    }
                                    _switchResult = _xifexpression_2;
                                    break;
                                case DATA_FORMAT:
                                    String _xifexpression_3 = null;
                                    if ((forDataFormat != null)) {
                                        _xifexpression_3 = forDataFormat.getFormatName();
                                    }
                                    _switchResult = _xifexpression_3;
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
            case TechnologyPackage.SERVICE_ASPECT__POINTCUT_SELECTORS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getPointcutSelectors()).basicAdd(otherEnd, msgs);
            case TechnologyPackage.SERVICE_ASPECT__TECHNOLOGY:
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
            case TechnologyPackage.SERVICE_ASPECT__POINTCUT_SELECTORS:
                return ((InternalEList<?>)getPointcutSelectors()).basicRemove(otherEnd, msgs);
            case TechnologyPackage.SERVICE_ASPECT__TECHNOLOGY:
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
            case TechnologyPackage.SERVICE_ASPECT__TECHNOLOGY:
                return eInternalContainer().eInverseRemove(this, TechnologyPackage.TECHNOLOGY__SERVICE_ASPECTS, Technology.class, msgs);
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
            case TechnologyPackage.SERVICE_ASPECT__POINTCUT_SELECTORS:
                return getPointcutSelectors();
            case TechnologyPackage.SERVICE_ASPECT__TECHNOLOGY:
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
            case TechnologyPackage.SERVICE_ASPECT__POINTCUT_SELECTORS:
                getPointcutSelectors().clear();
                getPointcutSelectors().addAll((Collection<? extends ServiceAspectPointcutSelector>)newValue);
                return;
            case TechnologyPackage.SERVICE_ASPECT__TECHNOLOGY:
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
            case TechnologyPackage.SERVICE_ASPECT__POINTCUT_SELECTORS:
                getPointcutSelectors().clear();
                return;
            case TechnologyPackage.SERVICE_ASPECT__TECHNOLOGY:
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
            case TechnologyPackage.SERVICE_ASPECT__POINTCUT_SELECTORS:
                return pointcutSelectors != null && !pointcutSelectors.isEmpty();
            case TechnologyPackage.SERVICE_ASPECT__TECHNOLOGY:
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
            case TechnologyPackage.SERVICE_ASPECT___GET_QUALIFIED_NAME_PARTS__BOOLEAN_BOOLEAN:
                return getQualifiedNameParts((Boolean)arguments.get(0), (Boolean)arguments.get(1));
            case TechnologyPackage.SERVICE_ASPECT___BUILD_QUALIFIED_NAME__STRING_BOOLEAN_BOOLEAN:
                return buildQualifiedName((String)arguments.get(0), (Boolean)arguments.get(1), (Boolean)arguments.get(2));
            case TechnologyPackage.SERVICE_ASPECT___IS_VALID_SELECTOR_FOR_JOIN_POINT__JOINPOINTTYPE_SERVICEASPECTPOINTCUTSELECTOR:
                return isValidSelectorForJoinPoint((JoinPointType)arguments.get(0), (ServiceAspectPointcutSelector)arguments.get(1));
            case TechnologyPackage.SERVICE_ASPECT___IS_VALID_SELECTOR_FOR_JOIN_POINT__JOINPOINTTYPE_EXCHANGEPATTERN_COMMUNICATIONTYPE_PROTOCOL_DATAFORMAT:
                return isValidSelectorForJoinPoint((JoinPointType)arguments.get(0), (ExchangePattern)arguments.get(1), (CommunicationType)arguments.get(2), (Protocol)arguments.get(3), (DataFormat)arguments.get(4));
            case TechnologyPackage.SERVICE_ASPECT___HAS_MATCHING_SELECTOR__EXCHANGEPATTERN_COMMUNICATIONTYPE_PROTOCOL_DATAFORMAT:
                return hasMatchingSelector((ExchangePattern)arguments.get(0), (CommunicationType)arguments.get(1), (Protocol)arguments.get(2), (DataFormat)arguments.get(3));
        }
        return super.eInvoke(operationID, arguments);
    }

} //ServiceAspectImpl
