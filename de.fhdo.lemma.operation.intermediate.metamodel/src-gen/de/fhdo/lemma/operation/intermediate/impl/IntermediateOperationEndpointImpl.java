/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.operation.intermediate.IntermediateEndpointTechnology;
import de.fhdo.lemma.operation.intermediate.IntermediateOperationEndpoint;
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode;
import de.fhdo.lemma.operation.intermediate.IntermediatePackage;

import de.fhdo.lemma.service.intermediate.impl.IntermediateEndpointImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Endpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationEndpointImpl#getEndpointTechnology <em>Endpoint Technology</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateOperationEndpointImpl#getNode <em>Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateOperationEndpointImpl extends IntermediateEndpointImpl implements IntermediateOperationEndpoint {
	/**
	 * The cached value of the '{@link #getEndpointTechnology() <em>Endpoint Technology</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointTechnology()
	 * @generated
	 * @ordered
	 */
	protected IntermediateEndpointTechnology endpointTechnology;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntermediateOperationEndpointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IntermediatePackage.Literals.INTERMEDIATE_OPERATION_ENDPOINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateEndpointTechnology getEndpointTechnology() {
		return endpointTechnology;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndpointTechnology(IntermediateEndpointTechnology newEndpointTechnology, NotificationChain msgs) {
		IntermediateEndpointTechnology oldEndpointTechnology = endpointTechnology;
		endpointTechnology = newEndpointTechnology;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT__ENDPOINT_TECHNOLOGY, oldEndpointTechnology, newEndpointTechnology);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEndpointTechnology(IntermediateEndpointTechnology newEndpointTechnology) {
		if (newEndpointTechnology != endpointTechnology) {
			NotificationChain msgs = null;
			if (endpointTechnology != null)
				msgs = ((InternalEObject)endpointTechnology).eInverseRemove(this, IntermediatePackage.INTERMEDIATE_ENDPOINT_TECHNOLOGY__ENDPOINT, IntermediateEndpointTechnology.class, msgs);
			if (newEndpointTechnology != null)
				msgs = ((InternalEObject)newEndpointTechnology).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_ENDPOINT_TECHNOLOGY__ENDPOINT, IntermediateEndpointTechnology.class, msgs);
			msgs = basicSetEndpointTechnology(newEndpointTechnology, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT__ENDPOINT_TECHNOLOGY, newEndpointTechnology, newEndpointTechnology));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateOperationNode getNode() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT__NODE) return null;
		return (IntermediateOperationNode)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateOperationNode basicGetNode() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT__NODE) return null;
		return (IntermediateOperationNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNode(IntermediateOperationNode newNode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newNode, IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT__NODE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNode(IntermediateOperationNode newNode) {
		if (newNode != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT__NODE && newNode != null)) {
			if (EcoreUtil.isAncestor(this, newNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newNode != null)
				msgs = ((InternalEObject)newNode).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__ENDPOINTS, IntermediateOperationNode.class, msgs);
			msgs = basicSetNode(newNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT__NODE, newNode, newNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT__ENDPOINT_TECHNOLOGY:
				if (endpointTechnology != null)
					msgs = ((InternalEObject)endpointTechnology).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT__ENDPOINT_TECHNOLOGY, null, msgs);
				return basicSetEndpointTechnology((IntermediateEndpointTechnology)otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT__NODE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetNode((IntermediateOperationNode)otherEnd, msgs);
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT__ENDPOINT_TECHNOLOGY:
				return basicSetEndpointTechnology(null, msgs);
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT__NODE:
				return basicSetNode(null, msgs);
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT__NODE:
				return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__ENDPOINTS, IntermediateOperationNode.class, msgs);
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT__ENDPOINT_TECHNOLOGY:
				return getEndpointTechnology();
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT__NODE:
				if (resolve) return getNode();
				return basicGetNode();
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT__ENDPOINT_TECHNOLOGY:
				setEndpointTechnology((IntermediateEndpointTechnology)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT__NODE:
				setNode((IntermediateOperationNode)newValue);
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT__ENDPOINT_TECHNOLOGY:
				setEndpointTechnology((IntermediateEndpointTechnology)null);
				return;
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT__NODE:
				setNode((IntermediateOperationNode)null);
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
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT__ENDPOINT_TECHNOLOGY:
				return endpointTechnology != null;
			case IntermediatePackage.INTERMEDIATE_OPERATION_ENDPOINT__NODE:
				return basicGetNode() != null;
		}
		return super.eIsSet(featureID);
	}

} //IntermediateOperationEndpointImpl
