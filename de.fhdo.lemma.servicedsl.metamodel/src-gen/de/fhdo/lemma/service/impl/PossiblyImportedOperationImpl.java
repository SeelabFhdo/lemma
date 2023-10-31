/**
 */
package de.fhdo.lemma.service.impl;

import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.Interface;
import de.fhdo.lemma.service.Microservice;
import de.fhdo.lemma.service.Operation;
import de.fhdo.lemma.service.Parameter;
import de.fhdo.lemma.service.PossiblyImportedInterface;
import de.fhdo.lemma.service.PossiblyImportedMicroservice;
import de.fhdo.lemma.service.PossiblyImportedOperation;
import de.fhdo.lemma.service.ServicePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Possibly Imported Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.impl.PossiblyImportedOperationImpl#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.PossiblyImportedOperationImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.PossiblyImportedOperationImpl#getRequiringMicroservice <em>Requiring Microservice</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.PossiblyImportedOperationImpl#getInitializedParameter <em>Initialized Parameter</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.PossiblyImportedOperationImpl#isRequired <em>Required</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.PossiblyImportedOperationImpl#isRequiredByInterface <em>Required By Interface</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.PossiblyImportedOperationImpl#isRequiredByMicroservice <em>Required By Microservice</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.PossiblyImportedOperationImpl#isRequiredByContainer <em>Required By Container</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PossiblyImportedOperationImpl extends MinimalEObjectImpl.Container implements PossiblyImportedOperation {
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
	 * The cached value of the '{@link #getOperation() <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected Operation operation;

	/**
	 * The default value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REQUIRED_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isRequiredByInterface() <em>Required By Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequiredByInterface()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REQUIRED_BY_INTERFACE_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isRequiredByMicroservice() <em>Required By Microservice</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequiredByMicroservice()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REQUIRED_BY_MICROSERVICE_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isRequiredByContainer() <em>Required By Container</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequiredByContainer()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REQUIRED_BY_CONTAINER_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PossiblyImportedOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicePackage.Literals.POSSIBLY_IMPORTED_OPERATION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicePackage.POSSIBLY_IMPORTED_OPERATION__IMPORT, oldImport, import_));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.POSSIBLY_IMPORTED_OPERATION__IMPORT, oldImport, import_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Operation getOperation() {
		if (operation != null && operation.eIsProxy()) {
			InternalEObject oldOperation = (InternalEObject)operation;
			operation = (Operation)eResolveProxy(oldOperation);
			if (operation != oldOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicePackage.POSSIBLY_IMPORTED_OPERATION__OPERATION, oldOperation, operation));
			}
		}
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetOperation() {
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperation(Operation newOperation) {
		Operation oldOperation = operation;
		operation = newOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.POSSIBLY_IMPORTED_OPERATION__OPERATION, oldOperation, operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Microservice getRequiringMicroservice() {
		if (eContainerFeatureID() != ServicePackage.POSSIBLY_IMPORTED_OPERATION__REQUIRING_MICROSERVICE) return null;
		return (Microservice)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Microservice basicGetRequiringMicroservice() {
		if (eContainerFeatureID() != ServicePackage.POSSIBLY_IMPORTED_OPERATION__REQUIRING_MICROSERVICE) return null;
		return (Microservice)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequiringMicroservice(Microservice newRequiringMicroservice, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRequiringMicroservice, ServicePackage.POSSIBLY_IMPORTED_OPERATION__REQUIRING_MICROSERVICE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRequiringMicroservice(Microservice newRequiringMicroservice) {
		if (newRequiringMicroservice != eInternalContainer() || (eContainerFeatureID() != ServicePackage.POSSIBLY_IMPORTED_OPERATION__REQUIRING_MICROSERVICE && newRequiringMicroservice != null)) {
			if (EcoreUtil.isAncestor(this, newRequiringMicroservice))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRequiringMicroservice != null)
				msgs = ((InternalEObject)newRequiringMicroservice).eInverseAdd(this, ServicePackage.MICROSERVICE__REQUIRED_OPERATIONS, Microservice.class, msgs);
			msgs = basicSetRequiringMicroservice(newRequiringMicroservice, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.POSSIBLY_IMPORTED_OPERATION__REQUIRING_MICROSERVICE, newRequiringMicroservice, newRequiringMicroservice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Parameter getInitializedParameter() {
		if (eContainerFeatureID() != ServicePackage.POSSIBLY_IMPORTED_OPERATION__INITIALIZED_PARAMETER) return null;
		return (Parameter)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter basicGetInitializedParameter() {
		if (eContainerFeatureID() != ServicePackage.POSSIBLY_IMPORTED_OPERATION__INITIALIZED_PARAMETER) return null;
		return (Parameter)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitializedParameter(Parameter newInitializedParameter, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInitializedParameter, ServicePackage.POSSIBLY_IMPORTED_OPERATION__INITIALIZED_PARAMETER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInitializedParameter(Parameter newInitializedParameter) {
		if (newInitializedParameter != eInternalContainer() || (eContainerFeatureID() != ServicePackage.POSSIBLY_IMPORTED_OPERATION__INITIALIZED_PARAMETER && newInitializedParameter != null)) {
			if (EcoreUtil.isAncestor(this, newInitializedParameter))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInitializedParameter != null)
				msgs = ((InternalEObject)newInitializedParameter).eInverseAdd(this, ServicePackage.PARAMETER__INITIALIZED_BY_OPERATION, Parameter.class, msgs);
			msgs = basicSetInitializedParameter(newInitializedParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.POSSIBLY_IMPORTED_OPERATION__INITIALIZED_PARAMETER, newInitializedParameter, newInitializedParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRequired() {
		Microservice _requiringMicroservice = this.getRequiringMicroservice();
		return (_requiringMicroservice != null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRequiredByInterface() {
		if ((((this.getOperation() == null) || 
			(!this.isRequired())) || 
			(this.getRequiringMicroservice().getRequiredInterfaces() == null))) {
			return false;
		}
		final Function1<PossiblyImportedInterface, Interface> _function = new Function1<PossiblyImportedInterface, Interface>() {
			public Interface apply(final PossiblyImportedInterface it) {
				return it.getInterface();
			}
		};
		boolean _contains = XcoreEListExtensions.<PossiblyImportedInterface, Interface>map(this.getRequiringMicroservice().getRequiredInterfaces(), _function).contains(this.getOperation().getInterface());
		if (_contains) {
			return true;
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRequiredByMicroservice() {
		if (((((this.getOperation() == null) || 
			(!this.isRequired())) || 
			(this.getRequiringMicroservice().getRequiredMicroservices() == null)) || 
			(this.getOperation().getInterface() == null))) {
			return false;
		}
		final Function1<PossiblyImportedMicroservice, Microservice> _function = new Function1<PossiblyImportedMicroservice, Microservice>() {
			public Microservice apply(final PossiblyImportedMicroservice it) {
				return it.getMicroservice();
			}
		};
		boolean _contains = XcoreEListExtensions.<PossiblyImportedMicroservice, Microservice>map(this.getRequiringMicroservice().getRequiredMicroservices(), _function).contains(this.getOperation().getInterface().getMicroservice());
		if (_contains) {
			return true;
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRequiredByContainer() {
		return (this.isRequiredByInterface() || this.isRequiredByMicroservice());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__REQUIRING_MICROSERVICE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRequiringMicroservice((Microservice)otherEnd, msgs);
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__INITIALIZED_PARAMETER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInitializedParameter((Parameter)otherEnd, msgs);
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
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__REQUIRING_MICROSERVICE:
				return basicSetRequiringMicroservice(null, msgs);
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__INITIALIZED_PARAMETER:
				return basicSetInitializedParameter(null, msgs);
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
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__REQUIRING_MICROSERVICE:
				return eInternalContainer().eInverseRemove(this, ServicePackage.MICROSERVICE__REQUIRED_OPERATIONS, Microservice.class, msgs);
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__INITIALIZED_PARAMETER:
				return eInternalContainer().eInverseRemove(this, ServicePackage.PARAMETER__INITIALIZED_BY_OPERATION, Parameter.class, msgs);
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
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__IMPORT:
				if (resolve) return getImport();
				return basicGetImport();
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__OPERATION:
				if (resolve) return getOperation();
				return basicGetOperation();
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__REQUIRING_MICROSERVICE:
				if (resolve) return getRequiringMicroservice();
				return basicGetRequiringMicroservice();
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__INITIALIZED_PARAMETER:
				if (resolve) return getInitializedParameter();
				return basicGetInitializedParameter();
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__REQUIRED:
				return isRequired();
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__REQUIRED_BY_INTERFACE:
				return isRequiredByInterface();
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__REQUIRED_BY_MICROSERVICE:
				return isRequiredByMicroservice();
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__REQUIRED_BY_CONTAINER:
				return isRequiredByContainer();
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
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__IMPORT:
				setImport((Import)newValue);
				return;
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__OPERATION:
				setOperation((Operation)newValue);
				return;
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__REQUIRING_MICROSERVICE:
				setRequiringMicroservice((Microservice)newValue);
				return;
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__INITIALIZED_PARAMETER:
				setInitializedParameter((Parameter)newValue);
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
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__IMPORT:
				setImport((Import)null);
				return;
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__OPERATION:
				setOperation((Operation)null);
				return;
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__REQUIRING_MICROSERVICE:
				setRequiringMicroservice((Microservice)null);
				return;
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__INITIALIZED_PARAMETER:
				setInitializedParameter((Parameter)null);
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
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__IMPORT:
				return import_ != null;
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__OPERATION:
				return operation != null;
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__REQUIRING_MICROSERVICE:
				return basicGetRequiringMicroservice() != null;
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__INITIALIZED_PARAMETER:
				return basicGetInitializedParameter() != null;
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__REQUIRED:
				return isRequired() != REQUIRED_EDEFAULT;
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__REQUIRED_BY_INTERFACE:
				return isRequiredByInterface() != REQUIRED_BY_INTERFACE_EDEFAULT;
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__REQUIRED_BY_MICROSERVICE:
				return isRequiredByMicroservice() != REQUIRED_BY_MICROSERVICE_EDEFAULT;
			case ServicePackage.POSSIBLY_IMPORTED_OPERATION__REQUIRED_BY_CONTAINER:
				return isRequiredByContainer() != REQUIRED_BY_CONTAINER_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //PossiblyImportedOperationImpl
