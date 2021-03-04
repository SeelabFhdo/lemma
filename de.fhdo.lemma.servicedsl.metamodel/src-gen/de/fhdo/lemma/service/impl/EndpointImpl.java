/**
 */
package de.fhdo.lemma.service.impl;

import de.fhdo.lemma.service.Endpoint;
import de.fhdo.lemma.service.ImportedProtocolAndDataFormat;
import de.fhdo.lemma.service.Interface;
import de.fhdo.lemma.service.Microservice;
import de.fhdo.lemma.service.Operation;
import de.fhdo.lemma.service.ReferredOperation;
import de.fhdo.lemma.service.ServicePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Endpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.impl.EndpointImpl#getAddresses <em>Addresses</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.EndpointImpl#getProtocols <em>Protocols</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.EndpointImpl#getMicroservice <em>Microservice</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.EndpointImpl#getInterface <em>Interface</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.EndpointImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.EndpointImpl#getReferredOperation <em>Referred Operation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EndpointImpl extends MinimalEObjectImpl.Container implements Endpoint {
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
	 * The cached value of the '{@link #getProtocols() <em>Protocols</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtocols()
	 * @generated
	 * @ordered
	 */
	protected EList<ImportedProtocolAndDataFormat> protocols;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EndpointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicePackage.Literals.ENDPOINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getAddresses() {
		if (addresses == null) {
			addresses = new EDataTypeEList<String>(String.class, this, ServicePackage.ENDPOINT__ADDRESSES);
		}
		return addresses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ImportedProtocolAndDataFormat> getProtocols() {
		if (protocols == null) {
			protocols = new EObjectContainmentWithInverseEList<ImportedProtocolAndDataFormat>(ImportedProtocolAndDataFormat.class, this, ServicePackage.ENDPOINT__PROTOCOLS, ServicePackage.IMPORTED_PROTOCOL_AND_DATA_FORMAT__ENDPOINT);
		}
		return protocols;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Microservice getMicroservice() {
		if (eContainerFeatureID() != ServicePackage.ENDPOINT__MICROSERVICE) return null;
		return (Microservice)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Microservice basicGetMicroservice() {
		if (eContainerFeatureID() != ServicePackage.ENDPOINT__MICROSERVICE) return null;
		return (Microservice)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMicroservice(Microservice newMicroservice, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMicroservice, ServicePackage.ENDPOINT__MICROSERVICE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMicroservice(Microservice newMicroservice) {
		if (newMicroservice != eInternalContainer() || (eContainerFeatureID() != ServicePackage.ENDPOINT__MICROSERVICE && newMicroservice != null)) {
			if (EcoreUtil.isAncestor(this, newMicroservice))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMicroservice != null)
				msgs = ((InternalEObject)newMicroservice).eInverseAdd(this, ServicePackage.MICROSERVICE__ENDPOINTS, Microservice.class, msgs);
			msgs = basicSetMicroservice(newMicroservice, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.ENDPOINT__MICROSERVICE, newMicroservice, newMicroservice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Interface getInterface() {
		if (eContainerFeatureID() != ServicePackage.ENDPOINT__INTERFACE) return null;
		return (Interface)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface basicGetInterface() {
		if (eContainerFeatureID() != ServicePackage.ENDPOINT__INTERFACE) return null;
		return (Interface)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInterface(Interface newInterface, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInterface, ServicePackage.ENDPOINT__INTERFACE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInterface(Interface newInterface) {
		if (newInterface != eInternalContainer() || (eContainerFeatureID() != ServicePackage.ENDPOINT__INTERFACE && newInterface != null)) {
			if (EcoreUtil.isAncestor(this, newInterface))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInterface != null)
				msgs = ((InternalEObject)newInterface).eInverseAdd(this, ServicePackage.INTERFACE__ENDPOINTS, Interface.class, msgs);
			msgs = basicSetInterface(newInterface, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.ENDPOINT__INTERFACE, newInterface, newInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Operation getOperation() {
		if (eContainerFeatureID() != ServicePackage.ENDPOINT__OPERATION) return null;
		return (Operation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetOperation() {
		if (eContainerFeatureID() != ServicePackage.ENDPOINT__OPERATION) return null;
		return (Operation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperation(Operation newOperation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOperation, ServicePackage.ENDPOINT__OPERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperation(Operation newOperation) {
		if (newOperation != eInternalContainer() || (eContainerFeatureID() != ServicePackage.ENDPOINT__OPERATION && newOperation != null)) {
			if (EcoreUtil.isAncestor(this, newOperation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOperation != null)
				msgs = ((InternalEObject)newOperation).eInverseAdd(this, ServicePackage.OPERATION__ENDPOINTS, Operation.class, msgs);
			msgs = basicSetOperation(newOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.ENDPOINT__OPERATION, newOperation, newOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ReferredOperation getReferredOperation() {
		if (eContainerFeatureID() != ServicePackage.ENDPOINT__REFERRED_OPERATION) return null;
		return (ReferredOperation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferredOperation basicGetReferredOperation() {
		if (eContainerFeatureID() != ServicePackage.ENDPOINT__REFERRED_OPERATION) return null;
		return (ReferredOperation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReferredOperation(ReferredOperation newReferredOperation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newReferredOperation, ServicePackage.ENDPOINT__REFERRED_OPERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredOperation(ReferredOperation newReferredOperation) {
		if (newReferredOperation != eInternalContainer() || (eContainerFeatureID() != ServicePackage.ENDPOINT__REFERRED_OPERATION && newReferredOperation != null)) {
			if (EcoreUtil.isAncestor(this, newReferredOperation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newReferredOperation != null)
				msgs = ((InternalEObject)newReferredOperation).eInverseAdd(this, ServicePackage.REFERRED_OPERATION__ENDPOINTS, ReferredOperation.class, msgs);
			msgs = basicSetReferredOperation(newReferredOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.ENDPOINT__REFERRED_OPERATION, newReferredOperation, newReferredOperation));
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
			case ServicePackage.ENDPOINT__PROTOCOLS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProtocols()).basicAdd(otherEnd, msgs);
			case ServicePackage.ENDPOINT__MICROSERVICE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMicroservice((Microservice)otherEnd, msgs);
			case ServicePackage.ENDPOINT__INTERFACE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInterface((Interface)otherEnd, msgs);
			case ServicePackage.ENDPOINT__OPERATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOperation((Operation)otherEnd, msgs);
			case ServicePackage.ENDPOINT__REFERRED_OPERATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetReferredOperation((ReferredOperation)otherEnd, msgs);
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
			case ServicePackage.ENDPOINT__PROTOCOLS:
				return ((InternalEList<?>)getProtocols()).basicRemove(otherEnd, msgs);
			case ServicePackage.ENDPOINT__MICROSERVICE:
				return basicSetMicroservice(null, msgs);
			case ServicePackage.ENDPOINT__INTERFACE:
				return basicSetInterface(null, msgs);
			case ServicePackage.ENDPOINT__OPERATION:
				return basicSetOperation(null, msgs);
			case ServicePackage.ENDPOINT__REFERRED_OPERATION:
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
			case ServicePackage.ENDPOINT__MICROSERVICE:
				return eInternalContainer().eInverseRemove(this, ServicePackage.MICROSERVICE__ENDPOINTS, Microservice.class, msgs);
			case ServicePackage.ENDPOINT__INTERFACE:
				return eInternalContainer().eInverseRemove(this, ServicePackage.INTERFACE__ENDPOINTS, Interface.class, msgs);
			case ServicePackage.ENDPOINT__OPERATION:
				return eInternalContainer().eInverseRemove(this, ServicePackage.OPERATION__ENDPOINTS, Operation.class, msgs);
			case ServicePackage.ENDPOINT__REFERRED_OPERATION:
				return eInternalContainer().eInverseRemove(this, ServicePackage.REFERRED_OPERATION__ENDPOINTS, ReferredOperation.class, msgs);
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
			case ServicePackage.ENDPOINT__ADDRESSES:
				return getAddresses();
			case ServicePackage.ENDPOINT__PROTOCOLS:
				return getProtocols();
			case ServicePackage.ENDPOINT__MICROSERVICE:
				if (resolve) return getMicroservice();
				return basicGetMicroservice();
			case ServicePackage.ENDPOINT__INTERFACE:
				if (resolve) return getInterface();
				return basicGetInterface();
			case ServicePackage.ENDPOINT__OPERATION:
				if (resolve) return getOperation();
				return basicGetOperation();
			case ServicePackage.ENDPOINT__REFERRED_OPERATION:
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
			case ServicePackage.ENDPOINT__ADDRESSES:
				getAddresses().clear();
				getAddresses().addAll((Collection<? extends String>)newValue);
				return;
			case ServicePackage.ENDPOINT__PROTOCOLS:
				getProtocols().clear();
				getProtocols().addAll((Collection<? extends ImportedProtocolAndDataFormat>)newValue);
				return;
			case ServicePackage.ENDPOINT__MICROSERVICE:
				setMicroservice((Microservice)newValue);
				return;
			case ServicePackage.ENDPOINT__INTERFACE:
				setInterface((Interface)newValue);
				return;
			case ServicePackage.ENDPOINT__OPERATION:
				setOperation((Operation)newValue);
				return;
			case ServicePackage.ENDPOINT__REFERRED_OPERATION:
				setReferredOperation((ReferredOperation)newValue);
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
			case ServicePackage.ENDPOINT__ADDRESSES:
				getAddresses().clear();
				return;
			case ServicePackage.ENDPOINT__PROTOCOLS:
				getProtocols().clear();
				return;
			case ServicePackage.ENDPOINT__MICROSERVICE:
				setMicroservice((Microservice)null);
				return;
			case ServicePackage.ENDPOINT__INTERFACE:
				setInterface((Interface)null);
				return;
			case ServicePackage.ENDPOINT__OPERATION:
				setOperation((Operation)null);
				return;
			case ServicePackage.ENDPOINT__REFERRED_OPERATION:
				setReferredOperation((ReferredOperation)null);
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
			case ServicePackage.ENDPOINT__ADDRESSES:
				return addresses != null && !addresses.isEmpty();
			case ServicePackage.ENDPOINT__PROTOCOLS:
				return protocols != null && !protocols.isEmpty();
			case ServicePackage.ENDPOINT__MICROSERVICE:
				return basicGetMicroservice() != null;
			case ServicePackage.ENDPOINT__INTERFACE:
				return basicGetInterface() != null;
			case ServicePackage.ENDPOINT__OPERATION:
				return basicGetOperation() != null;
			case ServicePackage.ENDPOINT__REFERRED_OPERATION:
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
		result.append(" (addresses: ");
		result.append(addresses);
		result.append(')');
		return result.toString();
	}

} //EndpointImpl
