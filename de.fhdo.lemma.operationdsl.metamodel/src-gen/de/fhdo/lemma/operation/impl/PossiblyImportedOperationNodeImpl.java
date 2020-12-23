/**
 */
package de.fhdo.lemma.operation.impl;

import de.fhdo.lemma.operation.InfrastructureNode;
import de.fhdo.lemma.operation.OperationNode;
import de.fhdo.lemma.operation.OperationPackage;
import de.fhdo.lemma.operation.PossiblyImportedOperationNode;

import de.fhdo.lemma.service.Import;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Possibly Imported Operation Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.operation.impl.PossiblyImportedOperationNodeImpl#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.operation.impl.PossiblyImportedOperationNodeImpl#getNode <em>Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PossiblyImportedOperationNodeImpl extends MinimalEObjectImpl.Container implements PossiblyImportedOperationNode {
	/**
	 * The cached value of the '{@link #getImport() <em>Import</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImport()
	 * @generated
	 * @ordered
	 */
	protected Import import_;

	/**
	 * The cached value of the '{@link #getNode() <em>Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode()
	 * @generated
	 * @ordered
	 */
	protected OperationNode node;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PossiblyImportedOperationNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OperationPackage.Literals.POSSIBLY_IMPORTED_OPERATION_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Import getImport() {
		if (import_ != null && import_.eIsProxy()) {
			InternalEObject oldImport = (InternalEObject)import_;
			import_ = (Import)eResolveProxy(oldImport);
			if (import_ != oldImport) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationPackage.POSSIBLY_IMPORTED_OPERATION_NODE__IMPORT, oldImport, import_));
			}
		}
		return import_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Import basicGetImport() {
		return import_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImport(Import newImport) {
		Import oldImport = import_;
		import_ = newImport;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.POSSIBLY_IMPORTED_OPERATION_NODE__IMPORT, oldImport, import_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperationNode getNode() {
		if (node != null && node.eIsProxy()) {
			InternalEObject oldNode = (InternalEObject)node;
			node = (OperationNode)eResolveProxy(oldNode);
			if (node != oldNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OperationPackage.POSSIBLY_IMPORTED_OPERATION_NODE__NODE, oldNode, node));
			}
		}
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationNode basicGetNode() {
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNode(OperationNode newNode) {
		OperationNode oldNode = node;
		node = newNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationPackage.POSSIBLY_IMPORTED_OPERATION_NODE__NODE, oldNode, node));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTechnologyName(final OperationNode node) {
		String _switchResult = null;
		boolean _matched = false;
		if (node instanceof InfrastructureNode) {
			_matched=true;
			_switchResult = ((InfrastructureNode)node).getInfrastructureTechnology().getInfrastructureTechnology().buildQualifiedName(".", true, 
				false);
		}
		if (!_matched) {
			if (node instanceof de.fhdo.lemma.operation.Container) {
				_matched=true;
				_switchResult = ((de.fhdo.lemma.operation.Container)node).getDeploymentTechnology().getDeploymentTechnology().buildQualifiedName(".", true, false);
			}
		}
		if (!_matched) {
			_switchResult = null;
		}
		return _switchResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationPackage.POSSIBLY_IMPORTED_OPERATION_NODE__IMPORT:
				if (resolve) return getImport();
				return basicGetImport();
			case OperationPackage.POSSIBLY_IMPORTED_OPERATION_NODE__NODE:
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
			case OperationPackage.POSSIBLY_IMPORTED_OPERATION_NODE__IMPORT:
				setImport((Import)newValue);
				return;
			case OperationPackage.POSSIBLY_IMPORTED_OPERATION_NODE__NODE:
				setNode((OperationNode)newValue);
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
			case OperationPackage.POSSIBLY_IMPORTED_OPERATION_NODE__IMPORT:
				setImport((Import)null);
				return;
			case OperationPackage.POSSIBLY_IMPORTED_OPERATION_NODE__NODE:
				setNode((OperationNode)null);
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
			case OperationPackage.POSSIBLY_IMPORTED_OPERATION_NODE__IMPORT:
				return import_ != null;
			case OperationPackage.POSSIBLY_IMPORTED_OPERATION_NODE__NODE:
				return node != null;
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
			case OperationPackage.POSSIBLY_IMPORTED_OPERATION_NODE___GET_TECHNOLOGY_NAME__OPERATIONNODE:
				return getTechnologyName((OperationNode)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //PossiblyImportedOperationNodeImpl
