/**
 */
package de.fhdo.lemma.service.impl;

import de.fhdo.lemma.service.ApiOperationComment;
import de.fhdo.lemma.service.Endpoint;
import de.fhdo.lemma.service.ImportedServiceAspect;
import de.fhdo.lemma.service.Interface;
import de.fhdo.lemma.service.Operation;
import de.fhdo.lemma.service.Parameter;
import de.fhdo.lemma.service.ProtocolSpecification;
import de.fhdo.lemma.service.ServicePackage;
import de.fhdo.lemma.service.Visibility;

import de.fhdo.lemma.technology.CommunicationType;
import de.fhdo.lemma.technology.Protocol;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.function.Consumer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions;

import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.impl.OperationImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.OperationImpl#isNotImplemented <em>Not Implemented</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.OperationImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.OperationImpl#getApiOperationComment <em>Api Operation Comment</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.OperationImpl#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.OperationImpl#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.OperationImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.OperationImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.OperationImpl#getInterface <em>Interface</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.OperationImpl#isNotImplementedByContainer <em>Not Implemented By Container</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.OperationImpl#isEffectivelyNotImplemented <em>Effectively Not Implemented</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.OperationImpl#getEffectiveVisibility <em>Effective Visibility</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.OperationImpl#isEffectivelyInternal <em>Effectively Internal</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationImpl extends MinimalEObjectImpl.Container implements Operation {
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
     * The default value of the '{@link #isNotImplemented() <em>Not Implemented</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isNotImplemented()
     * @generated
     * @ordered
     */
    protected static final boolean NOT_IMPLEMENTED_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isNotImplemented() <em>Not Implemented</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isNotImplemented()
     * @generated
     * @ordered
     */
    protected boolean notImplemented = NOT_IMPLEMENTED_EDEFAULT;

    /**
     * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVisibility()
     * @generated
     * @ordered
     */
    protected static final Visibility VISIBILITY_EDEFAULT = Visibility.NONE;

    /**
     * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVisibility()
     * @generated
     * @ordered
     */
    protected Visibility visibility = VISIBILITY_EDEFAULT;

    /**
     * The cached value of the '{@link #getApiOperationComment() <em>Api Operation Comment</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getApiOperationComment()
     * @generated
     * @ordered
     */
    protected ApiOperationComment apiOperationComment;

    /**
     * The cached value of the '{@link #getEndpoints() <em>Endpoints</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEndpoints()
     * @generated
     * @ordered
     */
    protected EList<Endpoint> endpoints;

    /**
     * The cached value of the '{@link #getProtocols() <em>Protocols</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProtocols()
     * @generated
     * @ordered
     */
    protected EList<ProtocolSpecification> protocols;

    /**
     * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParameters()
     * @generated
     * @ordered
     */
    protected EList<Parameter> parameters;

    /**
     * The cached value of the '{@link #getAspects() <em>Aspects</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAspects()
     * @generated
     * @ordered
     */
    protected EList<ImportedServiceAspect> aspects;

    /**
     * The default value of the '{@link #isNotImplementedByContainer() <em>Not Implemented By Container</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isNotImplementedByContainer()
     * @generated
     * @ordered
     */
    protected static final boolean NOT_IMPLEMENTED_BY_CONTAINER_EDEFAULT = false;

    /**
     * The default value of the '{@link #isEffectivelyNotImplemented() <em>Effectively Not Implemented</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEffectivelyNotImplemented()
     * @generated
     * @ordered
     */
    protected static final boolean EFFECTIVELY_NOT_IMPLEMENTED_EDEFAULT = false;

    /**
     * The default value of the '{@link #getEffectiveVisibility() <em>Effective Visibility</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEffectiveVisibility()
     * @generated
     * @ordered
     */
    protected static final Visibility EFFECTIVE_VISIBILITY_EDEFAULT = Visibility.NONE;

    /**
     * The default value of the '{@link #isEffectivelyInternal() <em>Effectively Internal</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEffectivelyInternal()
     * @generated
     * @ordered
     */
    protected static final boolean EFFECTIVELY_INTERNAL_EDEFAULT = false;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected OperationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ServicePackage.Literals.OPERATION;
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
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.OPERATION__NAME, oldName, name));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isNotImplemented() {
        return notImplemented;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setNotImplemented(boolean newNotImplemented) {
        boolean oldNotImplemented = notImplemented;
        notImplemented = newNotImplemented;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.OPERATION__NOT_IMPLEMENTED, oldNotImplemented, notImplemented));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Visibility getVisibility() {
        return visibility;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setVisibility(Visibility newVisibility) {
        Visibility oldVisibility = visibility;
        visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.OPERATION__VISIBILITY, oldVisibility, visibility));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ApiOperationComment getApiOperationComment() {
        return apiOperationComment;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetApiOperationComment(ApiOperationComment newApiOperationComment, NotificationChain msgs) {
        ApiOperationComment oldApiOperationComment = apiOperationComment;
        apiOperationComment = newApiOperationComment;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ServicePackage.OPERATION__API_OPERATION_COMMENT, oldApiOperationComment, newApiOperationComment);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setApiOperationComment(ApiOperationComment newApiOperationComment) {
        if (newApiOperationComment != apiOperationComment) {
            NotificationChain msgs = null;
            if (apiOperationComment != null)
                msgs = ((InternalEObject)apiOperationComment).eInverseRemove(this, ServicePackage.API_OPERATION_COMMENT__OPERATION, ApiOperationComment.class, msgs);
            if (newApiOperationComment != null)
                msgs = ((InternalEObject)newApiOperationComment).eInverseAdd(this, ServicePackage.API_OPERATION_COMMENT__OPERATION, ApiOperationComment.class, msgs);
            msgs = basicSetApiOperationComment(newApiOperationComment, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.OPERATION__API_OPERATION_COMMENT, newApiOperationComment, newApiOperationComment));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Endpoint> getEndpoints() {
        if (endpoints == null) {
            endpoints = new EObjectContainmentWithInverseEList<Endpoint>(Endpoint.class, this, ServicePackage.OPERATION__ENDPOINTS, ServicePackage.ENDPOINT__OPERATION);
        }
        return endpoints;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ProtocolSpecification> getProtocols() {
        if (protocols == null) {
            protocols = new EObjectContainmentEList<ProtocolSpecification>(ProtocolSpecification.class, this, ServicePackage.OPERATION__PROTOCOLS);
        }
        return protocols;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Parameter> getParameters() {
        if (parameters == null) {
            parameters = new EObjectContainmentWithInverseEList<Parameter>(Parameter.class, this, ServicePackage.OPERATION__PARAMETERS, ServicePackage.PARAMETER__OPERATION);
        }
        return parameters;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ImportedServiceAspect> getAspects() {
        if (aspects == null) {
            aspects = new EObjectContainmentWithInverseEList<ImportedServiceAspect>(ImportedServiceAspect.class, this, ServicePackage.OPERATION__ASPECTS, ServicePackage.IMPORTED_SERVICE_ASPECT__OPERATION);
        }
        return aspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Interface getInterface() {
        if (eContainerFeatureID() != ServicePackage.OPERATION__INTERFACE) return null;
        return (Interface)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Interface basicGetInterface() {
        if (eContainerFeatureID() != ServicePackage.OPERATION__INTERFACE) return null;
        return (Interface)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInterface(Interface newInterface, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newInterface, ServicePackage.OPERATION__INTERFACE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInterface(Interface newInterface) {
        if (newInterface != eInternalContainer() || (eContainerFeatureID() != ServicePackage.OPERATION__INTERFACE && newInterface != null)) {
            if (EcoreUtil.isAncestor(this, newInterface))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newInterface != null)
                msgs = ((InternalEObject)newInterface).eInverseAdd(this, ServicePackage.INTERFACE__OPERATIONS, Interface.class, msgs);
            msgs = basicSetInterface(newInterface, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.OPERATION__INTERFACE, newInterface, newInterface));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isNotImplementedByContainer() {
        Interface _interface = this.getInterface();
        boolean _tripleEquals = (_interface == null);
        if (_tripleEquals) {
            return false;
        }
        return this.getInterface().isNotImplemented();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isEffectivelyNotImplemented() {
        return (this.isNotImplemented() || this.isNotImplementedByContainer());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Visibility getEffectiveVisibility() {
        Interface _interface = this.getInterface();
        boolean _tripleEquals = (_interface == null);
        if (_tripleEquals) {
            return null;
        }
        final Visibility interfaceVisibility = this.getInterface().getEffectiveVisibility();
        if ((interfaceVisibility == null)) {
            return null;
        }
        if (interfaceVisibility != null) {
            switch (interfaceVisibility) {
                case IN_MODEL:
                case INTERNAL:
                    Visibility _visibility = this.getVisibility();
                    boolean _tripleEquals_1 = (_visibility == Visibility.NONE);
                    if (_tripleEquals_1) {
                        return interfaceVisibility;
                    }
                    else {
                        Visibility _visibility_1 = this.getVisibility();
                        boolean _tripleEquals_2 = (_visibility_1 == Visibility.INTERNAL);
                        if (_tripleEquals_2) {
                            return this.getVisibility();
                        }
                    }
                    break;
                case ARCHITECTURE:
                    Visibility _visibility_2 = this.getVisibility();
                    boolean _tripleEquals_3 = (_visibility_2 == Visibility.NONE);
                    if (_tripleEquals_3) {
                        return interfaceVisibility;
                    }
                    else {
                        if (((this.getVisibility() == Visibility.INTERNAL) || 
                            (this.getVisibility() == Visibility.ARCHITECTURE))) {
                            return this.getVisibility();
                        }
                    }
                    break;
                case PUBLIC:
                    Visibility _visibility_3 = this.getVisibility();
                    boolean _tripleEquals_4 = (_visibility_3 == Visibility.NONE);
                    if (_tripleEquals_4) {
                        return interfaceVisibility;
                    }
                    else {
                        if ((((this.getVisibility() == Visibility.INTERNAL) || 
                            (this.getVisibility() == Visibility.ARCHITECTURE)) || 
                            (this.getVisibility() == Visibility.PUBLIC))) {
                            return this.getVisibility();
                        }
                    }
                    break;
                default:
                    return null;
            }
        }
        else {
            return null;
        }
        return null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isEffectivelyInternal() {
        Visibility _effectiveVisibility = this.getEffectiveVisibility();
        return (_effectiveVisibility == Visibility.INTERNAL);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public List<Map<String, Object>> t_effectiveProtocolSpecifications() {
        List<Map<String, Object>> _xifexpression = null;
        boolean _isEmpty = this.getProtocols().isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
            _xifexpression = this.getProtocols().get(0).effectiveProtocolSpecifications(this.getProtocols());
        }
        else {
            _xifexpression = CollectionLiterals.<Map<String, Object>>newArrayList();
        }
        final List<Map<String, Object>> effectiveProtocolSpecifications = _xifexpression;
        final Function1<ProtocolSpecification, CommunicationType> _function = new Function1<ProtocolSpecification, CommunicationType>() {
            public CommunicationType apply(final ProtocolSpecification it) {
                return it.getProtocol().getImportedProtocol().getCommunicationType();
            }
        };
        final Set<CommunicationType> protocolSpecificationsCommunicationTypes = IterableExtensions.<CommunicationType>toSet(XcoreEListExtensions.<ProtocolSpecification, CommunicationType>map(this.getProtocols(), _function));
        final Consumer<Map<String, Object>> _function_1 = new Consumer<Map<String, Object>>() {
            public void accept(final Map<String, Object> microserviceEffectiveProtocolTuple) {
                Object _get = microserviceEffectiveProtocolTuple.get("protocol");
                final Protocol protocol = ((Protocol) _get);
                boolean _contains = protocolSpecificationsCommunicationTypes.contains(protocol.getCommunicationType());
                boolean _not = (!_contains);
                if (_not) {
                    effectiveProtocolSpecifications.add(microserviceEffectiveProtocolTuple);
                }
            }
        };
        this.getInterface().t_effectiveProtocolSpecifications().forEach(_function_1);
        return effectiveProtocolSpecifications;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getQualifiedNameParts() {
        EList<String> _xblockexpression = null;
        {
            if (((this.getName() == null) || this.getName().isEmpty())) {
                return ECollections.<String>asEList(CollectionLiterals.<String>newArrayList());
            }
            final EList<String> nameParts = this.getInterface().getQualifiedNameParts();
            CollectionExtensions.<String>addAll(nameParts, this.getName());
            _xblockexpression = ECollections.<String>asEList(nameParts);
        }
        return _xblockexpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
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
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ServicePackage.OPERATION__API_OPERATION_COMMENT:
                if (apiOperationComment != null)
                    msgs = ((InternalEObject)apiOperationComment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ServicePackage.OPERATION__API_OPERATION_COMMENT, null, msgs);
                return basicSetApiOperationComment((ApiOperationComment)otherEnd, msgs);
            case ServicePackage.OPERATION__ENDPOINTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getEndpoints()).basicAdd(otherEnd, msgs);
            case ServicePackage.OPERATION__PARAMETERS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameters()).basicAdd(otherEnd, msgs);
            case ServicePackage.OPERATION__ASPECTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspects()).basicAdd(otherEnd, msgs);
            case ServicePackage.OPERATION__INTERFACE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetInterface((Interface)otherEnd, msgs);
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
            case ServicePackage.OPERATION__API_OPERATION_COMMENT:
                return basicSetApiOperationComment(null, msgs);
            case ServicePackage.OPERATION__ENDPOINTS:
                return ((InternalEList<?>)getEndpoints()).basicRemove(otherEnd, msgs);
            case ServicePackage.OPERATION__PROTOCOLS:
                return ((InternalEList<?>)getProtocols()).basicRemove(otherEnd, msgs);
            case ServicePackage.OPERATION__PARAMETERS:
                return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
            case ServicePackage.OPERATION__ASPECTS:
                return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
            case ServicePackage.OPERATION__INTERFACE:
                return basicSetInterface(null, msgs);
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
            case ServicePackage.OPERATION__INTERFACE:
                return eInternalContainer().eInverseRemove(this, ServicePackage.INTERFACE__OPERATIONS, Interface.class, msgs);
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
            case ServicePackage.OPERATION__NAME:
                return getName();
            case ServicePackage.OPERATION__NOT_IMPLEMENTED:
                return isNotImplemented();
            case ServicePackage.OPERATION__VISIBILITY:
                return getVisibility();
            case ServicePackage.OPERATION__API_OPERATION_COMMENT:
                return getApiOperationComment();
            case ServicePackage.OPERATION__ENDPOINTS:
                return getEndpoints();
            case ServicePackage.OPERATION__PROTOCOLS:
                return getProtocols();
            case ServicePackage.OPERATION__PARAMETERS:
                return getParameters();
            case ServicePackage.OPERATION__ASPECTS:
                return getAspects();
            case ServicePackage.OPERATION__INTERFACE:
                if (resolve) return getInterface();
                return basicGetInterface();
            case ServicePackage.OPERATION__NOT_IMPLEMENTED_BY_CONTAINER:
                return isNotImplementedByContainer();
            case ServicePackage.OPERATION__EFFECTIVELY_NOT_IMPLEMENTED:
                return isEffectivelyNotImplemented();
            case ServicePackage.OPERATION__EFFECTIVE_VISIBILITY:
                return getEffectiveVisibility();
            case ServicePackage.OPERATION__EFFECTIVELY_INTERNAL:
                return isEffectivelyInternal();
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
            case ServicePackage.OPERATION__NAME:
                setName((String)newValue);
                return;
            case ServicePackage.OPERATION__NOT_IMPLEMENTED:
                setNotImplemented((Boolean)newValue);
                return;
            case ServicePackage.OPERATION__VISIBILITY:
                setVisibility((Visibility)newValue);
                return;
            case ServicePackage.OPERATION__API_OPERATION_COMMENT:
                setApiOperationComment((ApiOperationComment)newValue);
                return;
            case ServicePackage.OPERATION__ENDPOINTS:
                getEndpoints().clear();
                getEndpoints().addAll((Collection<? extends Endpoint>)newValue);
                return;
            case ServicePackage.OPERATION__PROTOCOLS:
                getProtocols().clear();
                getProtocols().addAll((Collection<? extends ProtocolSpecification>)newValue);
                return;
            case ServicePackage.OPERATION__PARAMETERS:
                getParameters().clear();
                getParameters().addAll((Collection<? extends Parameter>)newValue);
                return;
            case ServicePackage.OPERATION__ASPECTS:
                getAspects().clear();
                getAspects().addAll((Collection<? extends ImportedServiceAspect>)newValue);
                return;
            case ServicePackage.OPERATION__INTERFACE:
                setInterface((Interface)newValue);
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
            case ServicePackage.OPERATION__NAME:
                setName(NAME_EDEFAULT);
                return;
            case ServicePackage.OPERATION__NOT_IMPLEMENTED:
                setNotImplemented(NOT_IMPLEMENTED_EDEFAULT);
                return;
            case ServicePackage.OPERATION__VISIBILITY:
                setVisibility(VISIBILITY_EDEFAULT);
                return;
            case ServicePackage.OPERATION__API_OPERATION_COMMENT:
                setApiOperationComment((ApiOperationComment)null);
                return;
            case ServicePackage.OPERATION__ENDPOINTS:
                getEndpoints().clear();
                return;
            case ServicePackage.OPERATION__PROTOCOLS:
                getProtocols().clear();
                return;
            case ServicePackage.OPERATION__PARAMETERS:
                getParameters().clear();
                return;
            case ServicePackage.OPERATION__ASPECTS:
                getAspects().clear();
                return;
            case ServicePackage.OPERATION__INTERFACE:
                setInterface((Interface)null);
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
            case ServicePackage.OPERATION__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case ServicePackage.OPERATION__NOT_IMPLEMENTED:
                return notImplemented != NOT_IMPLEMENTED_EDEFAULT;
            case ServicePackage.OPERATION__VISIBILITY:
                return visibility != VISIBILITY_EDEFAULT;
            case ServicePackage.OPERATION__API_OPERATION_COMMENT:
                return apiOperationComment != null;
            case ServicePackage.OPERATION__ENDPOINTS:
                return endpoints != null && !endpoints.isEmpty();
            case ServicePackage.OPERATION__PROTOCOLS:
                return protocols != null && !protocols.isEmpty();
            case ServicePackage.OPERATION__PARAMETERS:
                return parameters != null && !parameters.isEmpty();
            case ServicePackage.OPERATION__ASPECTS:
                return aspects != null && !aspects.isEmpty();
            case ServicePackage.OPERATION__INTERFACE:
                return basicGetInterface() != null;
            case ServicePackage.OPERATION__NOT_IMPLEMENTED_BY_CONTAINER:
                return isNotImplementedByContainer() != NOT_IMPLEMENTED_BY_CONTAINER_EDEFAULT;
            case ServicePackage.OPERATION__EFFECTIVELY_NOT_IMPLEMENTED:
                return isEffectivelyNotImplemented() != EFFECTIVELY_NOT_IMPLEMENTED_EDEFAULT;
            case ServicePackage.OPERATION__EFFECTIVE_VISIBILITY:
                return getEffectiveVisibility() != EFFECTIVE_VISIBILITY_EDEFAULT;
            case ServicePackage.OPERATION__EFFECTIVELY_INTERNAL:
                return isEffectivelyInternal() != EFFECTIVELY_INTERNAL_EDEFAULT;
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
            case ServicePackage.OPERATION___TEFFECTIVE_PROTOCOL_SPECIFICATIONS:
                return t_effectiveProtocolSpecifications();
            case ServicePackage.OPERATION___GET_QUALIFIED_NAME_PARTS:
                return getQualifiedNameParts();
            case ServicePackage.OPERATION___BUILD_QUALIFIED_NAME__STRING:
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
        result.append(", notImplemented: ");
        result.append(notImplemented);
        result.append(", visibility: ");
        result.append(visibility);
        result.append(')');
        return result.toString();
    }

} //OperationImpl
