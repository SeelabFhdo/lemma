/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode;
import de.fhdo.lemma.operation.intermediate.IntermediatePackage;
import de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference;

import de.fhdo.lemma.service.intermediate.impl.MicroserviceReferenceImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Microservice Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.OperationMicroserviceReferenceImpl#isEffectivelyImplemented <em>Effectively Implemented</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.OperationMicroserviceReferenceImpl#getMicroserviceType <em>Microservice Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.OperationMicroserviceReferenceImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.OperationMicroserviceReferenceImpl#getNode <em>Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationMicroserviceReferenceImpl extends MicroserviceReferenceImpl implements OperationMicroserviceReference {
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
	 * The default value of the '{@link #getMicroserviceType() <em>Microservice Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMicroserviceType()
	 * @generated
	 * @ordered
	 */
	protected static final String MICROSERVICE_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMicroserviceType() <em>Microservice Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMicroserviceType()
	 * @generated
	 * @ordered
	 */
	protected String microserviceType = MICROSERVICE_TYPE_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationMicroserviceReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IntermediatePackage.Literals.OPERATION_MICROSERVICE_REFERENCE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__EFFECTIVELY_IMPLEMENTED, oldEffectivelyImplemented, effectivelyImplemented));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMicroserviceType() {
		return microserviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMicroserviceType(String newMicroserviceType) {
		String oldMicroserviceType = microserviceType;
		microserviceType = newMicroserviceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__MICROSERVICE_TYPE, oldMicroserviceType, microserviceType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__VISIBILITY, oldVisibility, visibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateOperationNode getNode() {
		if (eContainerFeatureID() != IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__NODE) return null;
		return (IntermediateOperationNode)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateOperationNode basicGetNode() {
		if (eContainerFeatureID() != IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__NODE) return null;
		return (IntermediateOperationNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNode(IntermediateOperationNode newNode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newNode, IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__NODE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNode(IntermediateOperationNode newNode) {
		if (newNode != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__NODE && newNode != null)) {
			if (EcoreUtil.isAncestor(this, newNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newNode != null)
				msgs = ((InternalEObject)newNode).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPLOYED_SERVICES, IntermediateOperationNode.class, msgs);
			msgs = basicSetNode(newNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__NODE, newNode, newNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__NODE:
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
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__NODE:
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
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__NODE:
				return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__DEPLOYED_SERVICES, IntermediateOperationNode.class, msgs);
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
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__EFFECTIVELY_IMPLEMENTED:
				return isEffectivelyImplemented();
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__MICROSERVICE_TYPE:
				return getMicroserviceType();
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__VISIBILITY:
				return getVisibility();
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__NODE:
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
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__EFFECTIVELY_IMPLEMENTED:
				setEffectivelyImplemented((Boolean)newValue);
				return;
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__MICROSERVICE_TYPE:
				setMicroserviceType((String)newValue);
				return;
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__VISIBILITY:
				setVisibility((String)newValue);
				return;
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__NODE:
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
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__EFFECTIVELY_IMPLEMENTED:
				setEffectivelyImplemented(EFFECTIVELY_IMPLEMENTED_EDEFAULT);
				return;
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__MICROSERVICE_TYPE:
				setMicroserviceType(MICROSERVICE_TYPE_EDEFAULT);
				return;
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__NODE:
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
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__EFFECTIVELY_IMPLEMENTED:
				return effectivelyImplemented != EFFECTIVELY_IMPLEMENTED_EDEFAULT;
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__MICROSERVICE_TYPE:
				return MICROSERVICE_TYPE_EDEFAULT == null ? microserviceType != null : !MICROSERVICE_TYPE_EDEFAULT.equals(microserviceType);
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__VISIBILITY:
				return VISIBILITY_EDEFAULT == null ? visibility != null : !VISIBILITY_EDEFAULT.equals(visibility);
			case IntermediatePackage.OPERATION_MICROSERVICE_REFERENCE__NODE:
				return basicGetNode() != null;
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
		result.append(" (effectivelyImplemented: ");
		result.append(effectivelyImplemented);
		result.append(", microserviceType: ");
		result.append(microserviceType);
		result.append(", visibility: ");
		result.append(visibility);
		result.append(')');
		return result.toString();
	}

} //OperationMicroserviceReferenceImpl
