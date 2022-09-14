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
import de.fhdo.lemma.technology.ServiceAspectPointcut;
import de.fhdo.lemma.technology.ServiceAspectPointcutSelector;
import de.fhdo.lemma.technology.TechnologyPackage;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Aspect Pointcut</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.impl.ServiceAspectPointcutImpl#isForExchangePattern <em>For Exchange Pattern</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.ServiceAspectPointcutImpl#isForCommunicationType <em>For Communication Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.ServiceAspectPointcutImpl#isForProtocol <em>For Protocol</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.ServiceAspectPointcutImpl#isForDataFormat <em>For Data Format</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.ServiceAspectPointcutImpl#getExchangePattern <em>Exchange Pattern</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.ServiceAspectPointcutImpl#getCommunicationType <em>Communication Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.ServiceAspectPointcutImpl#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.ServiceAspectPointcutImpl#getDataFormat <em>Data Format</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.ServiceAspectPointcutImpl#getSelector <em>Selector</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.ServiceAspectPointcutImpl#getEffectiveType <em>Effective Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.ServiceAspectPointcutImpl#getEffectiveSelectorName <em>Effective Selector Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.ServiceAspectPointcutImpl#getEffectiveValue <em>Effective Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.ServiceAspectPointcutImpl#getPrintableEffectiveValue <em>Printable Effective Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.impl.ServiceAspectPointcutImpl#getOrderedPointcutTypes <em>Ordered Pointcut Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ServiceAspectPointcutImpl extends MinimalEObjectImpl.Container implements ServiceAspectPointcut {
    /**
     * The default value of the '{@link #isForExchangePattern() <em>For Exchange Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isForExchangePattern()
     * @generated
     * @ordered
     */
    protected static final boolean FOR_EXCHANGE_PATTERN_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isForExchangePattern() <em>For Exchange Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isForExchangePattern()
     * @generated
     * @ordered
     */
    protected boolean forExchangePattern = FOR_EXCHANGE_PATTERN_EDEFAULT;

    /**
     * The default value of the '{@link #isForCommunicationType() <em>For Communication Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isForCommunicationType()
     * @generated
     * @ordered
     */
    protected static final boolean FOR_COMMUNICATION_TYPE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isForCommunicationType() <em>For Communication Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isForCommunicationType()
     * @generated
     * @ordered
     */
    protected boolean forCommunicationType = FOR_COMMUNICATION_TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #isForProtocol() <em>For Protocol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isForProtocol()
     * @generated
     * @ordered
     */
    protected static final boolean FOR_PROTOCOL_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isForProtocol() <em>For Protocol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isForProtocol()
     * @generated
     * @ordered
     */
    protected boolean forProtocol = FOR_PROTOCOL_EDEFAULT;

    /**
     * The default value of the '{@link #isForDataFormat() <em>For Data Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isForDataFormat()
     * @generated
     * @ordered
     */
    protected static final boolean FOR_DATA_FORMAT_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isForDataFormat() <em>For Data Format</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isForDataFormat()
     * @generated
     * @ordered
     */
    protected boolean forDataFormat = FOR_DATA_FORMAT_EDEFAULT;

    /**
     * The default value of the '{@link #getExchangePattern() <em>Exchange Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExchangePattern()
     * @generated
     * @ordered
     */
    protected static final ExchangePattern EXCHANGE_PATTERN_EDEFAULT = ExchangePattern.IN;

    /**
     * The cached value of the '{@link #getExchangePattern() <em>Exchange Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExchangePattern()
     * @generated
     * @ordered
     */
    protected ExchangePattern exchangePattern = EXCHANGE_PATTERN_EDEFAULT;

    /**
     * The default value of the '{@link #getCommunicationType() <em>Communication Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCommunicationType()
     * @generated
     * @ordered
     */
    protected static final CommunicationType COMMUNICATION_TYPE_EDEFAULT = CommunicationType.SYNCHRONOUS;

    /**
     * The cached value of the '{@link #getCommunicationType() <em>Communication Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCommunicationType()
     * @generated
     * @ordered
     */
    protected CommunicationType communicationType = COMMUNICATION_TYPE_EDEFAULT;

    /**
     * The cached value of the '{@link #getProtocol() <em>Protocol</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProtocol()
     * @generated
     * @ordered
     */
    protected Protocol protocol;

    /**
     * The cached value of the '{@link #getDataFormat() <em>Data Format</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataFormat()
     * @generated
     * @ordered
     */
    protected DataFormat dataFormat;

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
    protected ServiceAspectPointcutImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TechnologyPackage.Literals.SERVICE_ASPECT_POINTCUT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isForExchangePattern() {
        return forExchangePattern;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setForExchangePattern(boolean newForExchangePattern) {
        boolean oldForExchangePattern = forExchangePattern;
        forExchangePattern = newForExchangePattern;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.SERVICE_ASPECT_POINTCUT__FOR_EXCHANGE_PATTERN, oldForExchangePattern, forExchangePattern));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isForCommunicationType() {
        return forCommunicationType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setForCommunicationType(boolean newForCommunicationType) {
        boolean oldForCommunicationType = forCommunicationType;
        forCommunicationType = newForCommunicationType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.SERVICE_ASPECT_POINTCUT__FOR_COMMUNICATION_TYPE, oldForCommunicationType, forCommunicationType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isForProtocol() {
        return forProtocol;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setForProtocol(boolean newForProtocol) {
        boolean oldForProtocol = forProtocol;
        forProtocol = newForProtocol;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.SERVICE_ASPECT_POINTCUT__FOR_PROTOCOL, oldForProtocol, forProtocol));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isForDataFormat() {
        return forDataFormat;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setForDataFormat(boolean newForDataFormat) {
        boolean oldForDataFormat = forDataFormat;
        forDataFormat = newForDataFormat;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.SERVICE_ASPECT_POINTCUT__FOR_DATA_FORMAT, oldForDataFormat, forDataFormat));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExchangePattern getExchangePattern() {
        return exchangePattern;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExchangePattern(ExchangePattern newExchangePattern) {
        ExchangePattern oldExchangePattern = exchangePattern;
        exchangePattern = newExchangePattern == null ? EXCHANGE_PATTERN_EDEFAULT : newExchangePattern;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.SERVICE_ASPECT_POINTCUT__EXCHANGE_PATTERN, oldExchangePattern, exchangePattern));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CommunicationType getCommunicationType() {
        return communicationType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCommunicationType(CommunicationType newCommunicationType) {
        CommunicationType oldCommunicationType = communicationType;
        communicationType = newCommunicationType == null ? COMMUNICATION_TYPE_EDEFAULT : newCommunicationType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.SERVICE_ASPECT_POINTCUT__COMMUNICATION_TYPE, oldCommunicationType, communicationType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Protocol getProtocol() {
        if (protocol != null && protocol.eIsProxy()) {
            InternalEObject oldProtocol = (InternalEObject)protocol;
            protocol = (Protocol)eResolveProxy(oldProtocol);
            if (protocol != oldProtocol) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, TechnologyPackage.SERVICE_ASPECT_POINTCUT__PROTOCOL, oldProtocol, protocol));
            }
        }
        return protocol;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Protocol basicGetProtocol() {
        return protocol;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setProtocol(Protocol newProtocol) {
        Protocol oldProtocol = protocol;
        protocol = newProtocol;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.SERVICE_ASPECT_POINTCUT__PROTOCOL, oldProtocol, protocol));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataFormat getDataFormat() {
        if (dataFormat != null && dataFormat.eIsProxy()) {
            InternalEObject oldDataFormat = (InternalEObject)dataFormat;
            dataFormat = (DataFormat)eResolveProxy(oldDataFormat);
            if (dataFormat != oldDataFormat) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, TechnologyPackage.SERVICE_ASPECT_POINTCUT__DATA_FORMAT, oldDataFormat, dataFormat));
            }
        }
        return dataFormat;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataFormat basicGetDataFormat() {
        return dataFormat;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDataFormat(DataFormat newDataFormat) {
        DataFormat oldDataFormat = dataFormat;
        dataFormat = newDataFormat;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.SERVICE_ASPECT_POINTCUT__DATA_FORMAT, oldDataFormat, dataFormat));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ServiceAspectPointcutSelector getSelector() {
        if (eContainerFeatureID() != TechnologyPackage.SERVICE_ASPECT_POINTCUT__SELECTOR) return null;
        return (ServiceAspectPointcutSelector)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ServiceAspectPointcutSelector basicGetSelector() {
        if (eContainerFeatureID() != TechnologyPackage.SERVICE_ASPECT_POINTCUT__SELECTOR) return null;
        return (ServiceAspectPointcutSelector)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSelector(ServiceAspectPointcutSelector newSelector, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newSelector, TechnologyPackage.SERVICE_ASPECT_POINTCUT__SELECTOR, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSelector(ServiceAspectPointcutSelector newSelector) {
        if (newSelector != eInternalContainer() || (eContainerFeatureID() != TechnologyPackage.SERVICE_ASPECT_POINTCUT__SELECTOR && newSelector != null)) {
            if (EcoreUtil.isAncestor(this, newSelector))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newSelector != null)
                msgs = ((InternalEObject)newSelector).eInverseAdd(this, TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR__POINTCUTS, ServiceAspectPointcutSelector.class, msgs);
            msgs = basicSetSelector(newSelector, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TechnologyPackage.SERVICE_ASPECT_POINTCUT__SELECTOR, newSelector, newSelector));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PointcutType getEffectiveType() {
        PointcutType _xifexpression = null;
        boolean _isForExchangePattern = this.isForExchangePattern();
        if (_isForExchangePattern) {
            _xifexpression = PointcutType.EXCHANGE_PATTERN;
        }
        else {
            PointcutType _xifexpression_1 = null;
            boolean _isForCommunicationType = this.isForCommunicationType();
            if (_isForCommunicationType) {
                _xifexpression_1 = PointcutType.COMMUNICATION_TYPE;
            }
            else {
                PointcutType _xifexpression_2 = null;
                boolean _isForProtocol = this.isForProtocol();
                if (_isForProtocol) {
                    _xifexpression_2 = PointcutType.PROTOCOL;
                }
                else {
                    PointcutType _xifexpression_3 = null;
                    boolean _isForDataFormat = this.isForDataFormat();
                    if (_isForDataFormat) {
                        _xifexpression_3 = PointcutType.DATA_FORMAT;
                    }
                    else {
                        _xifexpression_3 = null;
                    }
                    _xifexpression_2 = _xifexpression_3;
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
    public String getEffectiveSelectorName() {
        String _switchResult = null;
        PointcutType _effectiveType = this.getEffectiveType();
        if (_effectiveType != null) {
            switch (_effectiveType) {
                case EXCHANGE_PATTERN:
                    _switchResult = "exchange_pattern";
                    break;
                case COMMUNICATION_TYPE:
                    _switchResult = "communication_type";
                    break;
                case PROTOCOL:
                    _switchResult = "protocol";
                    break;
                case DATA_FORMAT:
                    _switchResult = "data_format";
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
        if (((this.getEffectiveType() == PointcutType.EXCHANGE_PATTERN) && (this.getExchangePattern() != null))) {
            _xifexpression = this.getExchangePattern().getName();
        }
        else {
            String _xifexpression_1 = null;
            if (((this.getEffectiveType() == PointcutType.COMMUNICATION_TYPE) && (this.getCommunicationType() != null))) {
                _xifexpression_1 = this.getCommunicationType().getName();
            }
            else {
                String _xifexpression_2 = null;
                if (((this.getEffectiveType() == PointcutType.PROTOCOL) && (this.getProtocol() != null))) {
                    _xifexpression_2 = this.getProtocol().getName();
                }
                else {
                    String _xifexpression_3 = null;
                    if (((this.getEffectiveType() == PointcutType.DATA_FORMAT) && (this.getDataFormat() != null))) {
                        _xifexpression_3 = this.getDataFormat().getFormatName();
                    }
                    else {
                        _xifexpression_3 = null;
                    }
                    _xifexpression_2 = _xifexpression_3;
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
        if (((this.getEffectiveType() == PointcutType.EXCHANGE_PATTERN) && (this.getExchangePattern() != null))) {
            _xifexpression = this.getExchangePattern().getName().toLowerCase();
        }
        else {
            String _xifexpression_1 = null;
            if (((this.getEffectiveType() == PointcutType.COMMUNICATION_TYPE) && 
                Objects.equal(CommunicationType.ASYNCHRONOUS, this.getCommunicationType()))) {
                _xifexpression_1 = "async";
            }
            else {
                String _xifexpression_2 = null;
                if (((this.getEffectiveType() == PointcutType.COMMUNICATION_TYPE) && 
                    Objects.equal(CommunicationType.SYNCHRONOUS, this.getCommunicationType()))) {
                    _xifexpression_2 = "sync";
                }
                else {
                    String _xifexpression_3 = null;
                    if (((this.getEffectiveType() == PointcutType.PROTOCOL) && (this.getProtocol() != null))) {
                        _xifexpression_3 = this.getProtocol().getName();
                    }
                    else {
                        String _xifexpression_4 = null;
                        if (((this.getEffectiveType() == PointcutType.DATA_FORMAT) && (this.getDataFormat() != null))) {
                            _xifexpression_4 = this.getDataFormat().getFormatName();
                        }
                        else {
                            _xifexpression_4 = null;
                        }
                        _xifexpression_3 = _xifexpression_4;
                    }
                    _xifexpression_2 = _xifexpression_3;
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
        return ECollections.<PointcutType>asEList(java.util.Collections.<PointcutType>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<PointcutType>newArrayList(PointcutType.EXCHANGE_PATTERN, PointcutType.COMMUNICATION_TYPE, PointcutType.PROTOCOL, PointcutType.DATA_FORMAT)));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isValidSelectorFor(final JoinPointType joinPoint) {
        boolean _switchResult = false;
        PointcutType _effectiveType = this.getEffectiveType();
        if (_effectiveType != null) {
            switch (_effectiveType) {
                case EXCHANGE_PATTERN:
                    _switchResult = this.getSelector().getServiceAspect().isValidSelectorForJoinPoint(joinPoint, this.getExchangePattern(), null, 
                        null, null);
                    break;
                case COMMUNICATION_TYPE:
                    _switchResult = this.getSelector().getServiceAspect().isValidSelectorForJoinPoint(joinPoint, null, 
                        this.getCommunicationType(), null, null);
                    break;
                case PROTOCOL:
                    _switchResult = this.getSelector().getServiceAspect().isValidSelectorForJoinPoint(joinPoint, null, null, this.getProtocol(), 
                        null);
                    break;
                case DATA_FORMAT:
                    _switchResult = this.getSelector().getServiceAspect().isValidSelectorForJoinPoint(joinPoint, null, null, null, 
                        this.getDataFormat());
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
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__SELECTOR:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetSelector((ServiceAspectPointcutSelector)otherEnd, msgs);
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
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__SELECTOR:
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
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__SELECTOR:
                return eInternalContainer().eInverseRemove(this, TechnologyPackage.SERVICE_ASPECT_POINTCUT_SELECTOR__POINTCUTS, ServiceAspectPointcutSelector.class, msgs);
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
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__FOR_EXCHANGE_PATTERN:
                return isForExchangePattern();
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__FOR_COMMUNICATION_TYPE:
                return isForCommunicationType();
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__FOR_PROTOCOL:
                return isForProtocol();
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__FOR_DATA_FORMAT:
                return isForDataFormat();
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__EXCHANGE_PATTERN:
                return getExchangePattern();
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__COMMUNICATION_TYPE:
                return getCommunicationType();
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__PROTOCOL:
                if (resolve) return getProtocol();
                return basicGetProtocol();
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__DATA_FORMAT:
                if (resolve) return getDataFormat();
                return basicGetDataFormat();
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__SELECTOR:
                if (resolve) return getSelector();
                return basicGetSelector();
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__EFFECTIVE_TYPE:
                return getEffectiveType();
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__EFFECTIVE_SELECTOR_NAME:
                return getEffectiveSelectorName();
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__EFFECTIVE_VALUE:
                return getEffectiveValue();
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__PRINTABLE_EFFECTIVE_VALUE:
                return getPrintableEffectiveValue();
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__ORDERED_POINTCUT_TYPES:
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
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__FOR_EXCHANGE_PATTERN:
                setForExchangePattern((Boolean)newValue);
                return;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__FOR_COMMUNICATION_TYPE:
                setForCommunicationType((Boolean)newValue);
                return;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__FOR_PROTOCOL:
                setForProtocol((Boolean)newValue);
                return;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__FOR_DATA_FORMAT:
                setForDataFormat((Boolean)newValue);
                return;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__EXCHANGE_PATTERN:
                setExchangePattern((ExchangePattern)newValue);
                return;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__COMMUNICATION_TYPE:
                setCommunicationType((CommunicationType)newValue);
                return;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__PROTOCOL:
                setProtocol((Protocol)newValue);
                return;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__DATA_FORMAT:
                setDataFormat((DataFormat)newValue);
                return;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__SELECTOR:
                setSelector((ServiceAspectPointcutSelector)newValue);
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
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__FOR_EXCHANGE_PATTERN:
                setForExchangePattern(FOR_EXCHANGE_PATTERN_EDEFAULT);
                return;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__FOR_COMMUNICATION_TYPE:
                setForCommunicationType(FOR_COMMUNICATION_TYPE_EDEFAULT);
                return;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__FOR_PROTOCOL:
                setForProtocol(FOR_PROTOCOL_EDEFAULT);
                return;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__FOR_DATA_FORMAT:
                setForDataFormat(FOR_DATA_FORMAT_EDEFAULT);
                return;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__EXCHANGE_PATTERN:
                setExchangePattern(EXCHANGE_PATTERN_EDEFAULT);
                return;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__COMMUNICATION_TYPE:
                setCommunicationType(COMMUNICATION_TYPE_EDEFAULT);
                return;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__PROTOCOL:
                setProtocol((Protocol)null);
                return;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__DATA_FORMAT:
                setDataFormat((DataFormat)null);
                return;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__SELECTOR:
                setSelector((ServiceAspectPointcutSelector)null);
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
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__FOR_EXCHANGE_PATTERN:
                return forExchangePattern != FOR_EXCHANGE_PATTERN_EDEFAULT;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__FOR_COMMUNICATION_TYPE:
                return forCommunicationType != FOR_COMMUNICATION_TYPE_EDEFAULT;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__FOR_PROTOCOL:
                return forProtocol != FOR_PROTOCOL_EDEFAULT;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__FOR_DATA_FORMAT:
                return forDataFormat != FOR_DATA_FORMAT_EDEFAULT;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__EXCHANGE_PATTERN:
                return exchangePattern != EXCHANGE_PATTERN_EDEFAULT;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__COMMUNICATION_TYPE:
                return communicationType != COMMUNICATION_TYPE_EDEFAULT;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__PROTOCOL:
                return protocol != null;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__DATA_FORMAT:
                return dataFormat != null;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__SELECTOR:
                return basicGetSelector() != null;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__EFFECTIVE_TYPE:
                return getEffectiveType() != EFFECTIVE_TYPE_EDEFAULT;
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__EFFECTIVE_SELECTOR_NAME:
                return EFFECTIVE_SELECTOR_NAME_EDEFAULT == null ? getEffectiveSelectorName() != null : !EFFECTIVE_SELECTOR_NAME_EDEFAULT.equals(getEffectiveSelectorName());
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__EFFECTIVE_VALUE:
                return EFFECTIVE_VALUE_EDEFAULT == null ? getEffectiveValue() != null : !EFFECTIVE_VALUE_EDEFAULT.equals(getEffectiveValue());
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__PRINTABLE_EFFECTIVE_VALUE:
                return PRINTABLE_EFFECTIVE_VALUE_EDEFAULT == null ? getPrintableEffectiveValue() != null : !PRINTABLE_EFFECTIVE_VALUE_EDEFAULT.equals(getPrintableEffectiveValue());
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT__ORDERED_POINTCUT_TYPES:
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
    public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
        switch (operationID) {
            case TechnologyPackage.SERVICE_ASPECT_POINTCUT___IS_VALID_SELECTOR_FOR__JOINPOINTTYPE:
                return isValidSelectorFor((JoinPointType)arguments.get(0));
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
        result.append(" (forExchangePattern: ");
        result.append(forExchangePattern);
        result.append(", forCommunicationType: ");
        result.append(forCommunicationType);
        result.append(", forProtocol: ");
        result.append(forProtocol);
        result.append(", forDataFormat: ");
        result.append(forDataFormat);
        result.append(", exchangePattern: ");
        result.append(exchangePattern);
        result.append(", communicationType: ");
        result.append(communicationType);
        result.append(')');
        return result.toString();
    }

} //ServiceAspectPointcutImpl
