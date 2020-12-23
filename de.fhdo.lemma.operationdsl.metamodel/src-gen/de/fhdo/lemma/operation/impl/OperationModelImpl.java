/**
 */
package de.fhdo.lemma.operation.impl;

import de.fhdo.lemma.operation.InfrastructureNode;
import de.fhdo.lemma.operation.OperationModel;
import de.fhdo.lemma.operation.OperationPackage;

import de.fhdo.lemma.service.Import;

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
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.impl.OperationModelImpl#getT_modelUri <em>Tmodel Uri</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.OperationModelImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.OperationModelImpl#getContainers <em>Containers</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.OperationModelImpl#getInfrastructureNodes <em>Infrastructure Nodes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationModelImpl extends MinimalEObjectImpl.Container implements OperationModel {
	/**
	 * The default value of the '{@link #getT_modelUri() <em>Tmodel Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT_modelUri()
	 * @generated
	 * @ordered
	 */
	protected static final String TMODEL_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getT_modelUri() <em>Tmodel Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT_modelUri()
	 * @generated
	 * @ordered
	 */
	protected String t_modelUri = TMODEL_URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<Import> imports;

	/**
	 * The cached value of the '{@link #getContainers() <em>Containers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainers()
	 * @generated
	 * @ordered
	 */
	protected EList<de.fhdo.lemma.operation.Container> containers;

	/**
	 * The cached value of the '{@link #getInfrastructureNodes() <em>Infrastructure Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfrastructureNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<InfrastructureNode> infrastructureNodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationPackage.Literals.OPERATION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getT_modelUri() {
		return t_modelUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT_modelUri(String newT_modelUri) {
		String oldT_modelUri = t_modelUri;
		t_modelUri = newT_modelUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.OPERATION_MODEL__TMODEL_URI, oldT_modelUri, t_modelUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Import> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<Import>(Import.class, this, OperationPackage.OPERATION_MODEL__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<de.fhdo.lemma.operation.Container> getContainers() {
		if (containers == null) {
			containers = new EObjectContainmentWithInverseEList<de.fhdo.lemma.operation.Container>(de.fhdo.lemma.operation.Container.class, this, OperationPackage.OPERATION_MODEL__CONTAINERS, OperationPackage.CONTAINER__OPERATION_MODEL);
		}
		return containers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<InfrastructureNode> getInfrastructureNodes() {
		if (infrastructureNodes == null) {
			infrastructureNodes = new EObjectContainmentWithInverseEList<InfrastructureNode>(InfrastructureNode.class, this, OperationPackage.OPERATION_MODEL__INFRASTRUCTURE_NODES, OperationPackage.INFRASTRUCTURE_NODE__OPERATION_MODEL);
		}
		return infrastructureNodes;
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
			case OperationPackage.OPERATION_MODEL__CONTAINERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getContainers()).basicAdd(otherEnd, msgs);
			case OperationPackage.OPERATION_MODEL__INFRASTRUCTURE_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInfrastructureNodes()).basicAdd(otherEnd, msgs);
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
			case OperationPackage.OPERATION_MODEL__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
			case OperationPackage.OPERATION_MODEL__CONTAINERS:
				return ((InternalEList<?>)getContainers()).basicRemove(otherEnd, msgs);
			case OperationPackage.OPERATION_MODEL__INFRASTRUCTURE_NODES:
				return ((InternalEList<?>)getInfrastructureNodes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationPackage.OPERATION_MODEL__TMODEL_URI:
				return getT_modelUri();
			case OperationPackage.OPERATION_MODEL__IMPORTS:
				return getImports();
			case OperationPackage.OPERATION_MODEL__CONTAINERS:
				return getContainers();
			case OperationPackage.OPERATION_MODEL__INFRASTRUCTURE_NODES:
				return getInfrastructureNodes();
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
			case OperationPackage.OPERATION_MODEL__TMODEL_URI:
				setT_modelUri((String)newValue);
				return;
			case OperationPackage.OPERATION_MODEL__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends Import>)newValue);
				return;
			case OperationPackage.OPERATION_MODEL__CONTAINERS:
				getContainers().clear();
				getContainers().addAll((Collection<? extends de.fhdo.lemma.operation.Container>)newValue);
				return;
			case OperationPackage.OPERATION_MODEL__INFRASTRUCTURE_NODES:
				getInfrastructureNodes().clear();
				getInfrastructureNodes().addAll((Collection<? extends InfrastructureNode>)newValue);
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
			case OperationPackage.OPERATION_MODEL__TMODEL_URI:
				setT_modelUri(TMODEL_URI_EDEFAULT);
				return;
			case OperationPackage.OPERATION_MODEL__IMPORTS:
				getImports().clear();
				return;
			case OperationPackage.OPERATION_MODEL__CONTAINERS:
				getContainers().clear();
				return;
			case OperationPackage.OPERATION_MODEL__INFRASTRUCTURE_NODES:
				getInfrastructureNodes().clear();
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
			case OperationPackage.OPERATION_MODEL__TMODEL_URI:
				return TMODEL_URI_EDEFAULT == null ? t_modelUri != null : !TMODEL_URI_EDEFAULT.equals(t_modelUri);
			case OperationPackage.OPERATION_MODEL__IMPORTS:
				return imports != null && !imports.isEmpty();
			case OperationPackage.OPERATION_MODEL__CONTAINERS:
				return containers != null && !containers.isEmpty();
			case OperationPackage.OPERATION_MODEL__INFRASTRUCTURE_NODES:
				return infrastructureNodes != null && !infrastructureNodes.isEmpty();
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
		result.append(" (t_modelUri: ");
		result.append(t_modelUri);
		result.append(')');
		return result.toString();
	}

} //OperationModelImpl
