/**
 */
package de.fhdo.lemma.service.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect;

import de.fhdo.lemma.service.intermediate.InterfaceReference;
import de.fhdo.lemma.service.intermediate.IntermediateEndpoint;
import de.fhdo.lemma.service.intermediate.IntermediateInterface;
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice;
import de.fhdo.lemma.service.intermediate.IntermediatePackage;
import de.fhdo.lemma.service.intermediate.IntermediateProtocolSpecification;
import de.fhdo.lemma.service.intermediate.IntermediateServiceModel;
import de.fhdo.lemma.service.intermediate.IntermediateTechnology;
import de.fhdo.lemma.service.intermediate.MicroserviceReference;
import de.fhdo.lemma.service.intermediate.OperationReference;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Microservice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateMicroserviceImpl#getSourceModelUri <em>Source Model Uri</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateMicroserviceImpl#getSourceMappingModelUri <em>Source Mapping Model Uri</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateMicroserviceImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateMicroserviceImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateMicroserviceImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateMicroserviceImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateMicroserviceImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateMicroserviceImpl#isEffectivelyImplemented <em>Effectively Implemented</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateMicroserviceImpl#getTechnologies <em>Technologies</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateMicroserviceImpl#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateMicroserviceImpl#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateMicroserviceImpl#getRequiredMicroservices <em>Required Microservices</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateMicroserviceImpl#getRequiredInterfaces <em>Required Interfaces</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateMicroserviceImpl#getRequiredOperations <em>Required Operations</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateMicroserviceImpl#getInterfaces <em>Interfaces</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateMicroserviceImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateMicroserviceImpl#getServiceModel <em>Service Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateMicroserviceImpl extends MinimalEObjectImpl.Container implements IntermediateMicroservice {
	/**
	 * The default value of the '{@link #getSourceModelUri() <em>Source Model Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceModelUri()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_MODEL_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceModelUri() <em>Source Model Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceModelUri()
	 * @generated
	 * @ordered
	 */
	protected String sourceModelUri = SOURCE_MODEL_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceMappingModelUri() <em>Source Mapping Model Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceMappingModelUri()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_MAPPING_MODEL_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceMappingModelUri() <em>Source Mapping Model Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceMappingModelUri()
	 * @generated
	 * @ordered
	 */
	protected String sourceMappingModelUri = SOURCE_MAPPING_MODEL_URI_EDEFAULT;

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
	 * The default value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String qualifiedName = QUALIFIED_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final String VISIBILITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected String visibility = VISIBILITY_EDEFAULT;

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
	 * The cached value of the '{@link #isEffectivelyImplemented() <em>Effectively Implemented</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEffectivelyImplemented()
	 * @generated
	 * @ordered
	 */
	protected boolean effectivelyImplemented = EFFECTIVELY_IMPLEMENTED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTechnologies() <em>Technologies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTechnologies()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateTechnology> technologies;

	/**
	 * The cached value of the '{@link #getEndpoints() <em>Endpoints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpoints()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateEndpoint> endpoints;

	/**
	 * The cached value of the '{@link #getProtocols() <em>Protocols</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtocols()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateProtocolSpecification> protocols;

	/**
	 * The cached value of the '{@link #getRequiredMicroservices() <em>Required Microservices</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredMicroservices()
	 * @generated
	 * @ordered
	 */
	protected EList<MicroserviceReference> requiredMicroservices;

	/**
	 * The cached value of the '{@link #getRequiredInterfaces() <em>Required Interfaces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<InterfaceReference> requiredInterfaces;

	/**
	 * The cached value of the '{@link #getRequiredOperations() <em>Required Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationReference> requiredOperations;

	/**
	 * The cached value of the '{@link #getInterfaces() <em>Interfaces</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaces()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateInterface> interfaces;

	/**
	 * The cached value of the '{@link #getAspects() <em>Aspects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAspects()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateImportedAspect> aspects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntermediateMicroserviceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IntermediatePackage.Literals.INTERMEDIATE_MICROSERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSourceModelUri() {
		return sourceModelUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSourceModelUri(String newSourceModelUri) {
		String oldSourceModelUri = sourceModelUri;
		sourceModelUri = newSourceModelUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_MICROSERVICE__SOURCE_MODEL_URI, oldSourceModelUri, sourceModelUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSourceMappingModelUri() {
		return sourceMappingModelUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSourceMappingModelUri(String newSourceMappingModelUri) {
		String oldSourceMappingModelUri = sourceMappingModelUri;
		sourceMappingModelUri = newSourceMappingModelUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_MICROSERVICE__SOURCE_MAPPING_MODEL_URI, oldSourceMappingModelUri, sourceMappingModelUri));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_MICROSERVICE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_MICROSERVICE__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getQualifiedName() {
		return qualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQualifiedName(String newQualifiedName) {
		String oldQualifiedName = qualifiedName;
		qualifiedName = newQualifiedName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_MICROSERVICE__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_MICROSERVICE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVisibility() {
		return visibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVisibility(String newVisibility) {
		String oldVisibility = visibility;
		visibility = newVisibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_MICROSERVICE__VISIBILITY, oldVisibility, visibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEffectivelyImplemented() {
		return effectivelyImplemented;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEffectivelyImplemented(boolean newEffectivelyImplemented) {
		boolean oldEffectivelyImplemented = effectivelyImplemented;
		effectivelyImplemented = newEffectivelyImplemented;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_MICROSERVICE__EFFECTIVELY_IMPLEMENTED, oldEffectivelyImplemented, effectivelyImplemented));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IntermediateTechnology> getTechnologies() {
		if (technologies == null) {
			technologies = new EObjectContainmentWithInverseEList<IntermediateTechnology>(IntermediateTechnology.class, this, IntermediatePackage.INTERMEDIATE_MICROSERVICE__TECHNOLOGIES, IntermediatePackage.INTERMEDIATE_TECHNOLOGY__MICROSERVICE);
		}
		return technologies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IntermediateEndpoint> getEndpoints() {
		if (endpoints == null) {
			endpoints = new EObjectContainmentWithInverseEList<IntermediateEndpoint>(IntermediateEndpoint.class, this, IntermediatePackage.INTERMEDIATE_MICROSERVICE__ENDPOINTS, IntermediatePackage.INTERMEDIATE_ENDPOINT__MICROSERVICE);
		}
		return endpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IntermediateProtocolSpecification> getProtocols() {
		if (protocols == null) {
			protocols = new EObjectContainmentEList<IntermediateProtocolSpecification>(IntermediateProtocolSpecification.class, this, IntermediatePackage.INTERMEDIATE_MICROSERVICE__PROTOCOLS);
		}
		return protocols;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MicroserviceReference> getRequiredMicroservices() {
		if (requiredMicroservices == null) {
			requiredMicroservices = new EObjectContainmentWithInverseEList<MicroserviceReference>(MicroserviceReference.class, this, IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_MICROSERVICES, IntermediatePackage.MICROSERVICE_REFERENCE__REQUIRING_MICROSERVICE);
		}
		return requiredMicroservices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<InterfaceReference> getRequiredInterfaces() {
		if (requiredInterfaces == null) {
			requiredInterfaces = new EObjectContainmentWithInverseEList<InterfaceReference>(InterfaceReference.class, this, IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_INTERFACES, IntermediatePackage.INTERFACE_REFERENCE__REQUIRING_MICROSERVICE);
		}
		return requiredInterfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<OperationReference> getRequiredOperations() {
		if (requiredOperations == null) {
			requiredOperations = new EObjectContainmentWithInverseEList<OperationReference>(OperationReference.class, this, IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_OPERATIONS, IntermediatePackage.OPERATION_REFERENCE__REQUIRING_MICROSERVICE);
		}
		return requiredOperations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IntermediateInterface> getInterfaces() {
		if (interfaces == null) {
			interfaces = new EObjectContainmentWithInverseEList<IntermediateInterface>(IntermediateInterface.class, this, IntermediatePackage.INTERMEDIATE_MICROSERVICE__INTERFACES, IntermediatePackage.INTERMEDIATE_INTERFACE__MICROSERVICE);
		}
		return interfaces;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IntermediateImportedAspect> getAspects() {
		if (aspects == null) {
			aspects = new EObjectContainmentEList<IntermediateImportedAspect>(IntermediateImportedAspect.class, this, IntermediatePackage.INTERMEDIATE_MICROSERVICE__ASPECTS);
		}
		return aspects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateServiceModel getServiceModel() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_MICROSERVICE__SERVICE_MODEL) return null;
		return (IntermediateServiceModel)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateServiceModel basicGetServiceModel() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_MICROSERVICE__SERVICE_MODEL) return null;
		return (IntermediateServiceModel)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetServiceModel(IntermediateServiceModel newServiceModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newServiceModel, IntermediatePackage.INTERMEDIATE_MICROSERVICE__SERVICE_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setServiceModel(IntermediateServiceModel newServiceModel) {
		if (newServiceModel != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_MICROSERVICE__SERVICE_MODEL && newServiceModel != null)) {
			if (EcoreUtil.isAncestor(this, newServiceModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newServiceModel != null)
				msgs = ((InternalEObject)newServiceModel).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_SERVICE_MODEL__MICROSERVICES, IntermediateServiceModel.class, msgs);
			msgs = basicSetServiceModel(newServiceModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_MICROSERVICE__SERVICE_MODEL, newServiceModel, newServiceModel));
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
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__TECHNOLOGIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTechnologies()).basicAdd(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__ENDPOINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEndpoints()).basicAdd(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_MICROSERVICES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequiredMicroservices()).basicAdd(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_INTERFACES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequiredInterfaces()).basicAdd(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_OPERATIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequiredOperations()).basicAdd(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__INTERFACES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInterfaces()).basicAdd(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__SERVICE_MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetServiceModel((IntermediateServiceModel)otherEnd, msgs);
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
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__TECHNOLOGIES:
				return ((InternalEList<?>)getTechnologies()).basicRemove(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__ENDPOINTS:
				return ((InternalEList<?>)getEndpoints()).basicRemove(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__PROTOCOLS:
				return ((InternalEList<?>)getProtocols()).basicRemove(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_MICROSERVICES:
				return ((InternalEList<?>)getRequiredMicroservices()).basicRemove(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_INTERFACES:
				return ((InternalEList<?>)getRequiredInterfaces()).basicRemove(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_OPERATIONS:
				return ((InternalEList<?>)getRequiredOperations()).basicRemove(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__INTERFACES:
				return ((InternalEList<?>)getInterfaces()).basicRemove(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__ASPECTS:
				return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__SERVICE_MODEL:
				return basicSetServiceModel(null, msgs);
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
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__SERVICE_MODEL:
				return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_SERVICE_MODEL__MICROSERVICES, IntermediateServiceModel.class, msgs);
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
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__SOURCE_MODEL_URI:
				return getSourceModelUri();
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__SOURCE_MAPPING_MODEL_URI:
				return getSourceMappingModelUri();
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__NAME:
				return getName();
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__VERSION:
				return getVersion();
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__QUALIFIED_NAME:
				return getQualifiedName();
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__TYPE:
				return getType();
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__VISIBILITY:
				return getVisibility();
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__EFFECTIVELY_IMPLEMENTED:
				return isEffectivelyImplemented();
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__TECHNOLOGIES:
				return getTechnologies();
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__ENDPOINTS:
				return getEndpoints();
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__PROTOCOLS:
				return getProtocols();
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_MICROSERVICES:
				return getRequiredMicroservices();
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_INTERFACES:
				return getRequiredInterfaces();
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_OPERATIONS:
				return getRequiredOperations();
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__INTERFACES:
				return getInterfaces();
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__ASPECTS:
				return getAspects();
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__SERVICE_MODEL:
				if (resolve) return getServiceModel();
				return basicGetServiceModel();
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
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__SOURCE_MODEL_URI:
				setSourceModelUri((String)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__SOURCE_MAPPING_MODEL_URI:
				setSourceMappingModelUri((String)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__NAME:
				setName((String)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__VERSION:
				setVersion((String)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__QUALIFIED_NAME:
				setQualifiedName((String)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__TYPE:
				setType((String)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__VISIBILITY:
				setVisibility((String)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__EFFECTIVELY_IMPLEMENTED:
				setEffectivelyImplemented((Boolean)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__TECHNOLOGIES:
				getTechnologies().clear();
				getTechnologies().addAll((Collection<? extends IntermediateTechnology>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__ENDPOINTS:
				getEndpoints().clear();
				getEndpoints().addAll((Collection<? extends IntermediateEndpoint>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__PROTOCOLS:
				getProtocols().clear();
				getProtocols().addAll((Collection<? extends IntermediateProtocolSpecification>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_MICROSERVICES:
				getRequiredMicroservices().clear();
				getRequiredMicroservices().addAll((Collection<? extends MicroserviceReference>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_INTERFACES:
				getRequiredInterfaces().clear();
				getRequiredInterfaces().addAll((Collection<? extends InterfaceReference>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_OPERATIONS:
				getRequiredOperations().clear();
				getRequiredOperations().addAll((Collection<? extends OperationReference>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__INTERFACES:
				getInterfaces().clear();
				getInterfaces().addAll((Collection<? extends IntermediateInterface>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__ASPECTS:
				getAspects().clear();
				getAspects().addAll((Collection<? extends IntermediateImportedAspect>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__SERVICE_MODEL:
				setServiceModel((IntermediateServiceModel)newValue);
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
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__SOURCE_MODEL_URI:
				setSourceModelUri(SOURCE_MODEL_URI_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__SOURCE_MAPPING_MODEL_URI:
				setSourceMappingModelUri(SOURCE_MAPPING_MODEL_URI_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__QUALIFIED_NAME:
				setQualifiedName(QUALIFIED_NAME_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__EFFECTIVELY_IMPLEMENTED:
				setEffectivelyImplemented(EFFECTIVELY_IMPLEMENTED_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__TECHNOLOGIES:
				getTechnologies().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__ENDPOINTS:
				getEndpoints().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__PROTOCOLS:
				getProtocols().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_MICROSERVICES:
				getRequiredMicroservices().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_INTERFACES:
				getRequiredInterfaces().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_OPERATIONS:
				getRequiredOperations().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__INTERFACES:
				getInterfaces().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__ASPECTS:
				getAspects().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__SERVICE_MODEL:
				setServiceModel((IntermediateServiceModel)null);
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
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__SOURCE_MODEL_URI:
				return SOURCE_MODEL_URI_EDEFAULT == null ? sourceModelUri != null : !SOURCE_MODEL_URI_EDEFAULT.equals(sourceModelUri);
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__SOURCE_MAPPING_MODEL_URI:
				return SOURCE_MAPPING_MODEL_URI_EDEFAULT == null ? sourceMappingModelUri != null : !SOURCE_MAPPING_MODEL_URI_EDEFAULT.equals(sourceMappingModelUri);
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__VISIBILITY:
				return VISIBILITY_EDEFAULT == null ? visibility != null : !VISIBILITY_EDEFAULT.equals(visibility);
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__EFFECTIVELY_IMPLEMENTED:
				return effectivelyImplemented != EFFECTIVELY_IMPLEMENTED_EDEFAULT;
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__TECHNOLOGIES:
				return technologies != null && !technologies.isEmpty();
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__ENDPOINTS:
				return endpoints != null && !endpoints.isEmpty();
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__PROTOCOLS:
				return protocols != null && !protocols.isEmpty();
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_MICROSERVICES:
				return requiredMicroservices != null && !requiredMicroservices.isEmpty();
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_INTERFACES:
				return requiredInterfaces != null && !requiredInterfaces.isEmpty();
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__REQUIRED_OPERATIONS:
				return requiredOperations != null && !requiredOperations.isEmpty();
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__INTERFACES:
				return interfaces != null && !interfaces.isEmpty();
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__ASPECTS:
				return aspects != null && !aspects.isEmpty();
			case IntermediatePackage.INTERMEDIATE_MICROSERVICE__SERVICE_MODEL:
				return basicGetServiceModel() != null;
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
		result.append(" (sourceModelUri: ");
		result.append(sourceModelUri);
		result.append(", sourceMappingModelUri: ");
		result.append(sourceMappingModelUri);
		result.append(", name: ");
		result.append(name);
		result.append(", version: ");
		result.append(version);
		result.append(", qualifiedName: ");
		result.append(qualifiedName);
		result.append(", type: ");
		result.append(type);
		result.append(", visibility: ");
		result.append(visibility);
		result.append(", effectivelyImplemented: ");
		result.append(effectivelyImplemented);
		result.append(')');
		return result.toString();
	}

} //IntermediateMicroserviceImpl
