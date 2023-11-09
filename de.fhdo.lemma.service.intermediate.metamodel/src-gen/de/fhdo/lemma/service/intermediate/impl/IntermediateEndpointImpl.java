/**
 */
package de.fhdo.lemma.service.intermediate.impl;

import de.fhdo.lemma.service.intermediate.IntermediateEndpoint;
import de.fhdo.lemma.service.intermediate.IntermediateInterface;
import de.fhdo.lemma.service.intermediate.IntermediateMicroservice;
import de.fhdo.lemma.service.intermediate.IntermediateOperation;
import de.fhdo.lemma.service.intermediate.IntermediatePackage;
import de.fhdo.lemma.service.intermediate.IntermediateReferredOperation;
import de.fhdo.lemma.service.intermediate.IntermediateTechnology;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Endpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateEndpointImpl#getCommunicationType <em>Communication Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateEndpointImpl#getProtocol <em>Protocol</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateEndpointImpl#getDataFormat <em>Data Format</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateEndpointImpl#getAddresses <em>Addresses</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateEndpointImpl#getTechnology <em>Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateEndpointImpl#getMicroservice <em>Microservice</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateEndpointImpl#getInterface <em>Interface</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateEndpointImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateEndpointImpl#getReferredOperation <em>Referred Operation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateEndpointImpl extends MinimalEObjectImpl.Container implements IntermediateEndpoint {
	/**
	 * The default value of the '{@link #getCommunicationType() <em>Communication Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommunicationType()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMUNICATION_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommunicationType() <em>Communication Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommunicationType()
	 * @generated
	 * @ordered
	 */
	protected String communicationType = COMMUNICATION_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getProtocol() <em>Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtocol()
	 * @generated
	 * @ordered
	 */
	protected static final String PROTOCOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProtocol() <em>Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtocol()
	 * @generated
	 * @ordered
	 */
	protected String protocol = PROTOCOL_EDEFAULT;

	/**
	 * The default value of the '{@link #getDataFormat() <em>Data Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDataFormat() <em>Data Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataFormat()
	 * @generated
	 * @ordered
	 */
	protected String dataFormat = DATA_FORMAT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAddresses() <em>Addresses</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddresses()
	 * @generated
	 * @ordered
	 */
	protected EList<String> addresses;

	/**
	 * The cached value of the '{@link #getTechnology() <em>Technology</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTechnology()
	 * @generated
	 * @ordered
	 */
	protected IntermediateTechnology technology;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntermediateEndpointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IntermediatePackage.Literals.INTERMEDIATE_ENDPOINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCommunicationType() {
		return communicationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCommunicationType(String newCommunicationType) {
		String oldCommunicationType = communicationType;
		communicationType = newCommunicationType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_ENDPOINT__COMMUNICATION_TYPE, oldCommunicationType, communicationType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getProtocol() {
		return protocol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProtocol(String newProtocol) {
		String oldProtocol = protocol;
		protocol = newProtocol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_ENDPOINT__PROTOCOL, oldProtocol, protocol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDataFormat() {
		return dataFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataFormat(String newDataFormat) {
		String oldDataFormat = dataFormat;
		dataFormat = newDataFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_ENDPOINT__DATA_FORMAT, oldDataFormat, dataFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getAddresses() {
		if (addresses == null) {
			addresses = new EDataTypeEList<String>(String.class, this, IntermediatePackage.INTERMEDIATE_ENDPOINT__ADDRESSES);
		}
		return addresses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateTechnology getTechnology() {
		if (technology != null && technology.eIsProxy()) {
			InternalEObject oldTechnology = (InternalEObject)technology;
			technology = (IntermediateTechnology)eResolveProxy(oldTechnology);
			if (technology != oldTechnology) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.INTERMEDIATE_ENDPOINT__TECHNOLOGY, oldTechnology, technology));
			}
		}
		return technology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateTechnology basicGetTechnology() {
		return technology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTechnology(IntermediateTechnology newTechnology) {
		IntermediateTechnology oldTechnology = technology;
		technology = newTechnology;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_ENDPOINT__TECHNOLOGY, oldTechnology, technology));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateMicroservice getMicroservice() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_ENDPOINT__MICROSERVICE) return null;
		return (IntermediateMicroservice)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateMicroservice basicGetMicroservice() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_ENDPOINT__MICROSERVICE) return null;
		return (IntermediateMicroservice)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMicroservice(IntermediateMicroservice newMicroservice, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMicroservice, IntermediatePackage.INTERMEDIATE_ENDPOINT__MICROSERVICE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMicroservice(IntermediateMicroservice newMicroservice) {
		if (newMicroservice != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_ENDPOINT__MICROSERVICE && newMicroservice != null)) {
			if (EcoreUtil.isAncestor(this, newMicroservice))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMicroservice != null)
				msgs = ((InternalEObject)newMicroservice).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_MICROSERVICE__ENDPOINTS, IntermediateMicroservice.class, msgs);
			msgs = basicSetMicroservice(newMicroservice, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_ENDPOINT__MICROSERVICE, newMicroservice, newMicroservice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateInterface getInterface() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_ENDPOINT__INTERFACE) return null;
		return (IntermediateInterface)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateInterface basicGetInterface() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_ENDPOINT__INTERFACE) return null;
		return (IntermediateInterface)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInterface(IntermediateInterface newInterface, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInterface, IntermediatePackage.INTERMEDIATE_ENDPOINT__INTERFACE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInterface(IntermediateInterface newInterface) {
		if (newInterface != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_ENDPOINT__INTERFACE && newInterface != null)) {
			if (EcoreUtil.isAncestor(this, newInterface))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInterface != null)
				msgs = ((InternalEObject)newInterface).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_INTERFACE__ENDPOINTS, IntermediateInterface.class, msgs);
			msgs = basicSetInterface(newInterface, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_ENDPOINT__INTERFACE, newInterface, newInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateOperation getOperation() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_ENDPOINT__OPERATION) return null;
		return (IntermediateOperation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateOperation basicGetOperation() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_ENDPOINT__OPERATION) return null;
		return (IntermediateOperation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperation(IntermediateOperation newOperation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOperation, IntermediatePackage.INTERMEDIATE_ENDPOINT__OPERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperation(IntermediateOperation newOperation) {
		if (newOperation != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_ENDPOINT__OPERATION && newOperation != null)) {
			if (EcoreUtil.isAncestor(this, newOperation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOperation != null)
				msgs = ((InternalEObject)newOperation).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_OPERATION__ENDPOINTS, IntermediateOperation.class, msgs);
			msgs = basicSetOperation(newOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_ENDPOINT__OPERATION, newOperation, newOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateReferredOperation getReferredOperation() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_ENDPOINT__REFERRED_OPERATION) return null;
		return (IntermediateReferredOperation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateReferredOperation basicGetReferredOperation() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_ENDPOINT__REFERRED_OPERATION) return null;
		return (IntermediateReferredOperation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReferredOperation(IntermediateReferredOperation newReferredOperation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newReferredOperation, IntermediatePackage.INTERMEDIATE_ENDPOINT__REFERRED_OPERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredOperation(IntermediateReferredOperation newReferredOperation) {
		if (newReferredOperation != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_ENDPOINT__REFERRED_OPERATION && newReferredOperation != null)) {
			if (EcoreUtil.isAncestor(this, newReferredOperation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newReferredOperation != null)
				msgs = ((InternalEObject)newReferredOperation).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__ENDPOINTS, IntermediateReferredOperation.class, msgs);
			msgs = basicSetReferredOperation(newReferredOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_ENDPOINT__REFERRED_OPERATION, newReferredOperation, newReferredOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__MICROSERVICE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMicroservice((IntermediateMicroservice)otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__INTERFACE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInterface((IntermediateInterface)otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__OPERATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOperation((IntermediateOperation)otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__REFERRED_OPERATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetReferredOperation((IntermediateReferredOperation)otherEnd, msgs);
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
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__MICROSERVICE:
				return basicSetMicroservice(null, msgs);
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__INTERFACE:
				return basicSetInterface(null, msgs);
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__OPERATION:
				return basicSetOperation(null, msgs);
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__REFERRED_OPERATION:
				return basicSetReferredOperation(null, msgs);
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
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__MICROSERVICE:
				return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_MICROSERVICE__ENDPOINTS, IntermediateMicroservice.class, msgs);
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__INTERFACE:
				return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_INTERFACE__ENDPOINTS, IntermediateInterface.class, msgs);
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__OPERATION:
				return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_OPERATION__ENDPOINTS, IntermediateOperation.class, msgs);
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__REFERRED_OPERATION:
				return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_REFERRED_OPERATION__ENDPOINTS, IntermediateReferredOperation.class, msgs);
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
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__COMMUNICATION_TYPE:
				return getCommunicationType();
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__PROTOCOL:
				return getProtocol();
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__DATA_FORMAT:
				return getDataFormat();
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__ADDRESSES:
				return getAddresses();
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__TECHNOLOGY:
				if (resolve) return getTechnology();
				return basicGetTechnology();
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__MICROSERVICE:
				if (resolve) return getMicroservice();
				return basicGetMicroservice();
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__INTERFACE:
				if (resolve) return getInterface();
				return basicGetInterface();
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__OPERATION:
				if (resolve) return getOperation();
				return basicGetOperation();
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__REFERRED_OPERATION:
				if (resolve) return getReferredOperation();
				return basicGetReferredOperation();
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
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__COMMUNICATION_TYPE:
				setCommunicationType((String)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__PROTOCOL:
				setProtocol((String)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__DATA_FORMAT:
				setDataFormat((String)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__ADDRESSES:
				getAddresses().clear();
				getAddresses().addAll((Collection<? extends String>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__TECHNOLOGY:
				setTechnology((IntermediateTechnology)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__MICROSERVICE:
				setMicroservice((IntermediateMicroservice)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__INTERFACE:
				setInterface((IntermediateInterface)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__OPERATION:
				setOperation((IntermediateOperation)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__REFERRED_OPERATION:
				setReferredOperation((IntermediateReferredOperation)newValue);
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
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__COMMUNICATION_TYPE:
				setCommunicationType(COMMUNICATION_TYPE_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__PROTOCOL:
				setProtocol(PROTOCOL_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__DATA_FORMAT:
				setDataFormat(DATA_FORMAT_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__ADDRESSES:
				getAddresses().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__TECHNOLOGY:
				setTechnology((IntermediateTechnology)null);
				return;
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__MICROSERVICE:
				setMicroservice((IntermediateMicroservice)null);
				return;
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__INTERFACE:
				setInterface((IntermediateInterface)null);
				return;
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__OPERATION:
				setOperation((IntermediateOperation)null);
				return;
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__REFERRED_OPERATION:
				setReferredOperation((IntermediateReferredOperation)null);
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
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__COMMUNICATION_TYPE:
				return COMMUNICATION_TYPE_EDEFAULT == null ? communicationType != null : !COMMUNICATION_TYPE_EDEFAULT.equals(communicationType);
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__PROTOCOL:
				return PROTOCOL_EDEFAULT == null ? protocol != null : !PROTOCOL_EDEFAULT.equals(protocol);
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__DATA_FORMAT:
				return DATA_FORMAT_EDEFAULT == null ? dataFormat != null : !DATA_FORMAT_EDEFAULT.equals(dataFormat);
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__ADDRESSES:
				return addresses != null && !addresses.isEmpty();
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__TECHNOLOGY:
				return technology != null;
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__MICROSERVICE:
				return basicGetMicroservice() != null;
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__INTERFACE:
				return basicGetInterface() != null;
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__OPERATION:
				return basicGetOperation() != null;
			case IntermediatePackage.INTERMEDIATE_ENDPOINT__REFERRED_OPERATION:
				return basicGetReferredOperation() != null;
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
		result.append(" (communicationType: ");
		result.append(communicationType);
		result.append(", protocol: ");
		result.append(protocol);
		result.append(", dataFormat: ");
		result.append(dataFormat);
		result.append(", addresses: ");
		result.append(addresses);
		result.append(')');
		return result.toString();
	}

} //IntermediateEndpointImpl
