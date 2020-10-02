/**
 */
package de.fhdo.lemma.operation.intermediate.impl;

import de.fhdo.lemma.operation.intermediate.IntermediateOperationEndpoint;
import de.fhdo.lemma.operation.intermediate.IntermediateOperationNode;
import de.fhdo.lemma.operation.intermediate.IntermediatePackage;
import de.fhdo.lemma.operation.intermediate.IntermediateServiceDeploymentSpecification;
import de.fhdo.lemma.operation.intermediate.IntermediateTechnologySpecificPropertyValue;
import de.fhdo.lemma.operation.intermediate.OperationMicroserviceReference;

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
 * An implementation of the model object '<em><b>Service Deployment Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateServiceDeploymentSpecificationImpl#getOperationMicroserviceReference <em>Operation Microservice Reference</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateServiceDeploymentSpecificationImpl#getEndpoints <em>Endpoints</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateServiceDeploymentSpecificationImpl#getPropertyValues <em>Property Values</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.intermediate.impl.IntermediateServiceDeploymentSpecificationImpl#getOperationNode <em>Operation Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateServiceDeploymentSpecificationImpl extends MinimalEObjectImpl.Container implements IntermediateServiceDeploymentSpecification {
	/**
	 * The cached value of the '{@link #getOperationMicroserviceReference() <em>Operation Microservice Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationMicroserviceReference()
	 * @generated
	 * @ordered
	 */
	protected OperationMicroserviceReference operationMicroserviceReference;

	/**
	 * The cached value of the '{@link #getEndpoints() <em>Endpoints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpoints()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateOperationEndpoint> endpoints;

	/**
	 * The cached value of the '{@link #getPropertyValues() <em>Property Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyValues()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateTechnologySpecificPropertyValue> propertyValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntermediateServiceDeploymentSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IntermediatePackage.Literals.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperationMicroserviceReference getOperationMicroserviceReference() {
		if (operationMicroserviceReference != null && operationMicroserviceReference.eIsProxy()) {
			InternalEObject oldOperationMicroserviceReference = (InternalEObject)operationMicroserviceReference;
			operationMicroserviceReference = (OperationMicroserviceReference)eResolveProxy(oldOperationMicroserviceReference);
			if (operationMicroserviceReference != oldOperationMicroserviceReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_MICROSERVICE_REFERENCE, oldOperationMicroserviceReference, operationMicroserviceReference));
			}
		}
		return operationMicroserviceReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationMicroserviceReference basicGetOperationMicroserviceReference() {
		return operationMicroserviceReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperationMicroserviceReference(OperationMicroserviceReference newOperationMicroserviceReference) {
		OperationMicroserviceReference oldOperationMicroserviceReference = operationMicroserviceReference;
		operationMicroserviceReference = newOperationMicroserviceReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_MICROSERVICE_REFERENCE, oldOperationMicroserviceReference, operationMicroserviceReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IntermediateOperationEndpoint> getEndpoints() {
		if (endpoints == null) {
			endpoints = new EObjectContainmentEList<IntermediateOperationEndpoint>(IntermediateOperationEndpoint.class, this, IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__ENDPOINTS);
		}
		return endpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IntermediateTechnologySpecificPropertyValue> getPropertyValues() {
		if (propertyValues == null) {
			propertyValues = new EObjectContainmentWithInverseEList<IntermediateTechnologySpecificPropertyValue>(IntermediateTechnologySpecificPropertyValue.class, this, IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__PROPERTY_VALUES, IntermediatePackage.INTERMEDIATE_TECHNOLOGY_SPECIFIC_PROPERTY_VALUE__SPECIFICATION);
		}
		return propertyValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateOperationNode getOperationNode() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE) return null;
		return (IntermediateOperationNode)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateOperationNode basicGetOperationNode() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE) return null;
		return (IntermediateOperationNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperationNode(IntermediateOperationNode newOperationNode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOperationNode, IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperationNode(IntermediateOperationNode newOperationNode) {
		if (newOperationNode != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE && newOperationNode != null)) {
			if (EcoreUtil.isAncestor(this, newOperationNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOperationNode != null)
				msgs = ((InternalEObject)newOperationNode).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__SPECIFICATIONS, IntermediateOperationNode.class, msgs);
			msgs = basicSetOperationNode(newOperationNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE, newOperationNode, newOperationNode));
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
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__PROPERTY_VALUES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPropertyValues()).basicAdd(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOperationNode((IntermediateOperationNode)otherEnd, msgs);
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
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__ENDPOINTS:
				return ((InternalEList<?>)getEndpoints()).basicRemove(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__PROPERTY_VALUES:
				return ((InternalEList<?>)getPropertyValues()).basicRemove(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE:
				return basicSetOperationNode(null, msgs);
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
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE:
				return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_OPERATION_NODE__SPECIFICATIONS, IntermediateOperationNode.class, msgs);
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
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_MICROSERVICE_REFERENCE:
				if (resolve) return getOperationMicroserviceReference();
				return basicGetOperationMicroserviceReference();
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__ENDPOINTS:
				return getEndpoints();
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__PROPERTY_VALUES:
				return getPropertyValues();
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE:
				if (resolve) return getOperationNode();
				return basicGetOperationNode();
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
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_MICROSERVICE_REFERENCE:
				setOperationMicroserviceReference((OperationMicroserviceReference)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__ENDPOINTS:
				getEndpoints().clear();
				getEndpoints().addAll((Collection<? extends IntermediateOperationEndpoint>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__PROPERTY_VALUES:
				getPropertyValues().clear();
				getPropertyValues().addAll((Collection<? extends IntermediateTechnologySpecificPropertyValue>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE:
				setOperationNode((IntermediateOperationNode)newValue);
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
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_MICROSERVICE_REFERENCE:
				setOperationMicroserviceReference((OperationMicroserviceReference)null);
				return;
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__ENDPOINTS:
				getEndpoints().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__PROPERTY_VALUES:
				getPropertyValues().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE:
				setOperationNode((IntermediateOperationNode)null);
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
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_MICROSERVICE_REFERENCE:
				return operationMicroserviceReference != null;
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__ENDPOINTS:
				return endpoints != null && !endpoints.isEmpty();
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__PROPERTY_VALUES:
				return propertyValues != null && !propertyValues.isEmpty();
			case IntermediatePackage.INTERMEDIATE_SERVICE_DEPLOYMENT_SPECIFICATION__OPERATION_NODE:
				return basicGetOperationNode() != null;
		}
		return super.eIsSet(featureID);
	}

} //IntermediateServiceDeploymentSpecificationImpl
