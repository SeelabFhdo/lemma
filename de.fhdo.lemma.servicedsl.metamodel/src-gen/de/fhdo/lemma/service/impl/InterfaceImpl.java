/**
 */
package de.fhdo.lemma.service.impl;

import de.fhdo.lemma.service.Endpoint;
import de.fhdo.lemma.service.ImportedServiceAspect;
import de.fhdo.lemma.service.Interface;
import de.fhdo.lemma.service.Microservice;
import de.fhdo.lemma.service.Operation;
import de.fhdo.lemma.service.ProtocolSpecification;
import de.fhdo.lemma.service.ReferredOperation;
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
 * An implementation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.impl.InterfaceImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.InterfaceImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.InterfaceImpl#isNotImplemented <em>Not Implemented</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.InterfaceImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.InterfaceImpl#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.InterfaceImpl#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.InterfaceImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.InterfaceImpl#getReferredOperations <em>Referred Operations</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.InterfaceImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.InterfaceImpl#getMicroservice <em>Microservice</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.InterfaceImpl#getEffectiveVisibility <em>Effective Visibility</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.InterfaceImpl#isEffectivelyImplemented <em>Effectively Implemented</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.InterfaceImpl#isEffectivelyInternal <em>Effectively Internal</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InterfaceImpl extends MinimalEObjectImpl.Container implements Interface {
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
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

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
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> operations;

	/**
	 * The cached value of the '{@link #getReferredOperations() <em>Referred Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<ReferredOperation> referredOperations;

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
	 * The default value of the '{@link #getEffectiveVisibility() <em>Effective Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEffectiveVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final Visibility EFFECTIVE_VISIBILITY_EDEFAULT = Visibility.NONE;

	/**
	 * The default value of the '{@link #isEffectivelyImplemented() <em>Effectively Implemented</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEffectivelyImplemented()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EFFECTIVELY_IMPLEMENTED_EDEFAULT = false;

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
	protected InterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicePackage.Literals.INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.INTERFACE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.INTERFACE__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isNotImplemented() {
		return notImplemented;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNotImplemented(boolean newNotImplemented) {
		boolean oldNotImplemented = notImplemented;
		notImplemented = newNotImplemented;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.INTERFACE__NOT_IMPLEMENTED, oldNotImplemented, notImplemented));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Visibility getVisibility() {
		return visibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVisibility(Visibility newVisibility) {
		Visibility oldVisibility = visibility;
		visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.INTERFACE__VISIBILITY, oldVisibility, visibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Endpoint> getEndpoints() {
		if (endpoints == null) {
			endpoints = new EObjectContainmentWithInverseEList<Endpoint>(Endpoint.class, this, ServicePackage.INTERFACE__ENDPOINTS, ServicePackage.ENDPOINT__INTERFACE);
		}
		return endpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ProtocolSpecification> getProtocols() {
		if (protocols == null) {
			protocols = new EObjectContainmentEList<ProtocolSpecification>(ProtocolSpecification.class, this, ServicePackage.INTERFACE__PROTOCOLS);
		}
		return protocols;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Operation> getOperations() {
		if (operations == null) {
			operations = new EObjectContainmentWithInverseEList<Operation>(Operation.class, this, ServicePackage.INTERFACE__OPERATIONS, ServicePackage.OPERATION__INTERFACE);
		}
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ReferredOperation> getReferredOperations() {
		if (referredOperations == null) {
			referredOperations = new EObjectContainmentWithInverseEList<ReferredOperation>(ReferredOperation.class, this, ServicePackage.INTERFACE__REFERRED_OPERATIONS, ServicePackage.REFERRED_OPERATION__INTERFACE);
		}
		return referredOperations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ImportedServiceAspect> getAspects() {
		if (aspects == null) {
			aspects = new EObjectContainmentWithInverseEList<ImportedServiceAspect>(ImportedServiceAspect.class, this, ServicePackage.INTERFACE__ASPECTS, ServicePackage.IMPORTED_SERVICE_ASPECT__INTERFACE);
		}
		return aspects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Microservice getMicroservice() {
		if (eContainerFeatureID() != ServicePackage.INTERFACE__MICROSERVICE) return null;
		return (Microservice)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Microservice basicGetMicroservice() {
		if (eContainerFeatureID() != ServicePackage.INTERFACE__MICROSERVICE) return null;
		return (Microservice)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMicroservice(Microservice newMicroservice, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMicroservice, ServicePackage.INTERFACE__MICROSERVICE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMicroservice(Microservice newMicroservice) {
		if (newMicroservice != eInternalContainer() || (eContainerFeatureID() != ServicePackage.INTERFACE__MICROSERVICE && newMicroservice != null)) {
			if (EcoreUtil.isAncestor(this, newMicroservice))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMicroservice != null)
				msgs = ((InternalEObject)newMicroservice).eInverseAdd(this, ServicePackage.MICROSERVICE__INTERFACES, Microservice.class, msgs);
			msgs = basicSetMicroservice(newMicroservice, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.INTERFACE__MICROSERVICE, newMicroservice, newMicroservice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Visibility getEffectiveVisibility() {
		Microservice _microservice = this.getMicroservice();
		boolean _tripleEquals = (_microservice == null);
		if (_tripleEquals) {
			return null;
		}
		final Visibility serviceVisibility = this.getMicroservice().getEffectiveVisibility();
		if (serviceVisibility != null) {
			switch (serviceVisibility) {
				case INTERNAL:
					Visibility _visibility = this.getVisibility();
					boolean _tripleEquals_1 = (_visibility == Visibility.NONE);
					if (_tripleEquals_1) {
						return Visibility.IN_MODEL;
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
						return serviceVisibility;
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
						return serviceVisibility;
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
	@Override
	public boolean isEffectivelyImplemented() {
		return ((!this.isNotImplemented()) && IterableExtensions.<Operation>exists(this.getOperations(), new Function1<Operation, Boolean>() {
			public Boolean apply(final Operation it) {
				boolean _isNotImplemented = it.isNotImplemented();
				return Boolean.valueOf((!_isNotImplemented));
			}
		}));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEffectivelyInternal() {
		Visibility _effectiveVisibility = this.getEffectiveVisibility();
		return (_effectiveVisibility == Visibility.INTERNAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
		this.getMicroservice().t_effectiveProtocolSpecifications().forEach(_function_1);
		return effectiveProtocolSpecifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getQualifiedNameParts() {
		EList<String> _xblockexpression = null;
		{
			if (((this.getName() == null) || this.getName().isEmpty())) {
				return ECollections.<String>asEList(CollectionLiterals.<String>newArrayList());
			}
			final EList<String> nameParts = this.getMicroservice().getQualifiedNameParts();
			String _version = this.getVersion();
			boolean _tripleNotEquals = (_version != null);
			if (_tripleNotEquals) {
				nameParts.add(this.getVersion());
			}
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
	@Override
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
			case ServicePackage.INTERFACE__ENDPOINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEndpoints()).basicAdd(otherEnd, msgs);
			case ServicePackage.INTERFACE__OPERATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOperations()).basicAdd(otherEnd, msgs);
			case ServicePackage.INTERFACE__REFERRED_OPERATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getReferredOperations()).basicAdd(otherEnd, msgs);
			case ServicePackage.INTERFACE__ASPECTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspects()).basicAdd(otherEnd, msgs);
			case ServicePackage.INTERFACE__MICROSERVICE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMicroservice((Microservice)otherEnd, msgs);
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
			case ServicePackage.INTERFACE__ENDPOINTS:
				return ((InternalEList<?>)getEndpoints()).basicRemove(otherEnd, msgs);
			case ServicePackage.INTERFACE__PROTOCOLS:
				return ((InternalEList<?>)getProtocols()).basicRemove(otherEnd, msgs);
			case ServicePackage.INTERFACE__OPERATIONS:
				return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
			case ServicePackage.INTERFACE__REFERRED_OPERATIONS:
				return ((InternalEList<?>)getReferredOperations()).basicRemove(otherEnd, msgs);
			case ServicePackage.INTERFACE__ASPECTS:
				return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
			case ServicePackage.INTERFACE__MICROSERVICE:
				return basicSetMicroservice(null, msgs);
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
			case ServicePackage.INTERFACE__MICROSERVICE:
				return eInternalContainer().eInverseRemove(this, ServicePackage.MICROSERVICE__INTERFACES, Microservice.class, msgs);
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
			case ServicePackage.INTERFACE__NAME:
				return getName();
			case ServicePackage.INTERFACE__VERSION:
				return getVersion();
			case ServicePackage.INTERFACE__NOT_IMPLEMENTED:
				return isNotImplemented();
			case ServicePackage.INTERFACE__VISIBILITY:
				return getVisibility();
			case ServicePackage.INTERFACE__ENDPOINTS:
				return getEndpoints();
			case ServicePackage.INTERFACE__PROTOCOLS:
				return getProtocols();
			case ServicePackage.INTERFACE__OPERATIONS:
				return getOperations();
			case ServicePackage.INTERFACE__REFERRED_OPERATIONS:
				return getReferredOperations();
			case ServicePackage.INTERFACE__ASPECTS:
				return getAspects();
			case ServicePackage.INTERFACE__MICROSERVICE:
				if (resolve) return getMicroservice();
				return basicGetMicroservice();
			case ServicePackage.INTERFACE__EFFECTIVE_VISIBILITY:
				return getEffectiveVisibility();
			case ServicePackage.INTERFACE__EFFECTIVELY_IMPLEMENTED:
				return isEffectivelyImplemented();
			case ServicePackage.INTERFACE__EFFECTIVELY_INTERNAL:
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
			case ServicePackage.INTERFACE__NAME:
				setName((String)newValue);
				return;
			case ServicePackage.INTERFACE__VERSION:
				setVersion((String)newValue);
				return;
			case ServicePackage.INTERFACE__NOT_IMPLEMENTED:
				setNotImplemented((Boolean)newValue);
				return;
			case ServicePackage.INTERFACE__VISIBILITY:
				setVisibility((Visibility)newValue);
				return;
			case ServicePackage.INTERFACE__ENDPOINTS:
				getEndpoints().clear();
				getEndpoints().addAll((Collection<? extends Endpoint>)newValue);
				return;
			case ServicePackage.INTERFACE__PROTOCOLS:
				getProtocols().clear();
				getProtocols().addAll((Collection<? extends ProtocolSpecification>)newValue);
				return;
			case ServicePackage.INTERFACE__OPERATIONS:
				getOperations().clear();
				getOperations().addAll((Collection<? extends Operation>)newValue);
				return;
			case ServicePackage.INTERFACE__REFERRED_OPERATIONS:
				getReferredOperations().clear();
				getReferredOperations().addAll((Collection<? extends ReferredOperation>)newValue);
				return;
			case ServicePackage.INTERFACE__ASPECTS:
				getAspects().clear();
				getAspects().addAll((Collection<? extends ImportedServiceAspect>)newValue);
				return;
			case ServicePackage.INTERFACE__MICROSERVICE:
				setMicroservice((Microservice)newValue);
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
			case ServicePackage.INTERFACE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ServicePackage.INTERFACE__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case ServicePackage.INTERFACE__NOT_IMPLEMENTED:
				setNotImplemented(NOT_IMPLEMENTED_EDEFAULT);
				return;
			case ServicePackage.INTERFACE__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case ServicePackage.INTERFACE__ENDPOINTS:
				getEndpoints().clear();
				return;
			case ServicePackage.INTERFACE__PROTOCOLS:
				getProtocols().clear();
				return;
			case ServicePackage.INTERFACE__OPERATIONS:
				getOperations().clear();
				return;
			case ServicePackage.INTERFACE__REFERRED_OPERATIONS:
				getReferredOperations().clear();
				return;
			case ServicePackage.INTERFACE__ASPECTS:
				getAspects().clear();
				return;
			case ServicePackage.INTERFACE__MICROSERVICE:
				setMicroservice((Microservice)null);
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
			case ServicePackage.INTERFACE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ServicePackage.INTERFACE__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case ServicePackage.INTERFACE__NOT_IMPLEMENTED:
				return notImplemented != NOT_IMPLEMENTED_EDEFAULT;
			case ServicePackage.INTERFACE__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
			case ServicePackage.INTERFACE__ENDPOINTS:
				return endpoints != null && !endpoints.isEmpty();
			case ServicePackage.INTERFACE__PROTOCOLS:
				return protocols != null && !protocols.isEmpty();
			case ServicePackage.INTERFACE__OPERATIONS:
				return operations != null && !operations.isEmpty();
			case ServicePackage.INTERFACE__REFERRED_OPERATIONS:
				return referredOperations != null && !referredOperations.isEmpty();
			case ServicePackage.INTERFACE__ASPECTS:
				return aspects != null && !aspects.isEmpty();
			case ServicePackage.INTERFACE__MICROSERVICE:
				return basicGetMicroservice() != null;
			case ServicePackage.INTERFACE__EFFECTIVE_VISIBILITY:
				return getEffectiveVisibility() != EFFECTIVE_VISIBILITY_EDEFAULT;
			case ServicePackage.INTERFACE__EFFECTIVELY_IMPLEMENTED:
				return isEffectivelyImplemented() != EFFECTIVELY_IMPLEMENTED_EDEFAULT;
			case ServicePackage.INTERFACE__EFFECTIVELY_INTERNAL:
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
			case ServicePackage.INTERFACE___TEFFECTIVE_PROTOCOL_SPECIFICATIONS:
				return t_effectiveProtocolSpecifications();
			case ServicePackage.INTERFACE___GET_QUALIFIED_NAME_PARTS:
				return getQualifiedNameParts();
			case ServicePackage.INTERFACE___BUILD_QUALIFIED_NAME__STRING:
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
		result.append(", version: ");
		result.append(version);
		result.append(", notImplemented: ");
		result.append(notImplemented);
		result.append(", visibility: ");
		result.append(visibility);
		result.append(')');
		return result.toString();
	}

} //InterfaceImpl
