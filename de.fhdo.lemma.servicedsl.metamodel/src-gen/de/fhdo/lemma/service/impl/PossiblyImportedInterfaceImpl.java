/**
 */
package de.fhdo.lemma.service.impl;

import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.Interface;
import de.fhdo.lemma.service.Microservice;
import de.fhdo.lemma.service.PossiblyImportedInterface;
import de.fhdo.lemma.service.PossiblyImportedMicroservice;
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
 * An implementation of the model object '<em><b>Possibly Imported Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.impl.PossiblyImportedInterfaceImpl#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.PossiblyImportedInterfaceImpl#getInterface <em>Interface</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.PossiblyImportedInterfaceImpl#getRequiringMicroservice <em>Requiring Microservice</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.PossiblyImportedInterfaceImpl#isRequired <em>Required</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.PossiblyImportedInterfaceImpl#isRequiredByContainer <em>Required By Container</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PossiblyImportedInterfaceImpl extends MinimalEObjectImpl.Container implements PossiblyImportedInterface {
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
	 * The cached value of the '{@link #getInterface() <em>Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterface()
	 * @generated
	 * @ordered
	 */
	protected Interface interface_;

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
	protected PossiblyImportedInterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicePackage.Literals.POSSIBLY_IMPORTED_INTERFACE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicePackage.POSSIBLY_IMPORTED_INTERFACE__IMPORT, oldImport, import_));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.POSSIBLY_IMPORTED_INTERFACE__IMPORT, oldImport, import_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Interface getInterface() {
		if (interface_ != null && interface_.eIsProxy()) {
			InternalEObject oldInterface = (InternalEObject)interface_;
			interface_ = (Interface)eResolveProxy(oldInterface);
			if (interface_ != oldInterface) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicePackage.POSSIBLY_IMPORTED_INTERFACE__INTERFACE, oldInterface, interface_));
			}
		}
		return interface_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface basicGetInterface() {
		return interface_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInterface(Interface newInterface) {
		Interface oldInterface = interface_;
		interface_ = newInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.POSSIBLY_IMPORTED_INTERFACE__INTERFACE, oldInterface, interface_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Microservice getRequiringMicroservice() {
		if (eContainerFeatureID() != ServicePackage.POSSIBLY_IMPORTED_INTERFACE__REQUIRING_MICROSERVICE) return null;
		return (Microservice)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Microservice basicGetRequiringMicroservice() {
		if (eContainerFeatureID() != ServicePackage.POSSIBLY_IMPORTED_INTERFACE__REQUIRING_MICROSERVICE) return null;
		return (Microservice)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequiringMicroservice(Microservice newRequiringMicroservice, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRequiringMicroservice, ServicePackage.POSSIBLY_IMPORTED_INTERFACE__REQUIRING_MICROSERVICE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRequiringMicroservice(Microservice newRequiringMicroservice) {
		if (newRequiringMicroservice != eInternalContainer() || (eContainerFeatureID() != ServicePackage.POSSIBLY_IMPORTED_INTERFACE__REQUIRING_MICROSERVICE && newRequiringMicroservice != null)) {
			if (EcoreUtil.isAncestor(this, newRequiringMicroservice))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRequiringMicroservice != null)
				msgs = ((InternalEObject)newRequiringMicroservice).eInverseAdd(this, ServicePackage.MICROSERVICE__REQUIRED_INTERFACES, Microservice.class, msgs);
			msgs = basicSetRequiringMicroservice(newRequiringMicroservice, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.POSSIBLY_IMPORTED_INTERFACE__REQUIRING_MICROSERVICE, newRequiringMicroservice, newRequiringMicroservice));
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
	public boolean isRequiredByContainer() {
		if (((this.getInterface() == null) || (!this.isRequired()))) {
			return false;
		}
		if (((this.getRequiringMicroservice().getRequiredMicroservices() != null) && 
			XcoreEListExtensions.<PossiblyImportedMicroservice, Microservice>map(this.getRequiringMicroservice().getRequiredMicroservices(), new Function1<PossiblyImportedMicroservice, Microservice>() {
				public Microservice apply(final PossiblyImportedMicroservice it) {
					return it.getMicroservice();
				}
			}).contains(this.getInterface().getMicroservice()))) {
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicePackage.POSSIBLY_IMPORTED_INTERFACE__REQUIRING_MICROSERVICE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRequiringMicroservice((Microservice)otherEnd, msgs);
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
			case ServicePackage.POSSIBLY_IMPORTED_INTERFACE__REQUIRING_MICROSERVICE:
				return basicSetRequiringMicroservice(null, msgs);
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
			case ServicePackage.POSSIBLY_IMPORTED_INTERFACE__REQUIRING_MICROSERVICE:
				return eInternalContainer().eInverseRemove(this, ServicePackage.MICROSERVICE__REQUIRED_INTERFACES, Microservice.class, msgs);
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
			case ServicePackage.POSSIBLY_IMPORTED_INTERFACE__IMPORT:
				if (resolve) return getImport();
				return basicGetImport();
			case ServicePackage.POSSIBLY_IMPORTED_INTERFACE__INTERFACE:
				if (resolve) return getInterface();
				return basicGetInterface();
			case ServicePackage.POSSIBLY_IMPORTED_INTERFACE__REQUIRING_MICROSERVICE:
				if (resolve) return getRequiringMicroservice();
				return basicGetRequiringMicroservice();
			case ServicePackage.POSSIBLY_IMPORTED_INTERFACE__REQUIRED:
				return isRequired();
			case ServicePackage.POSSIBLY_IMPORTED_INTERFACE__REQUIRED_BY_CONTAINER:
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
			case ServicePackage.POSSIBLY_IMPORTED_INTERFACE__IMPORT:
				setImport((Import)newValue);
				return;
			case ServicePackage.POSSIBLY_IMPORTED_INTERFACE__INTERFACE:
				setInterface((Interface)newValue);
				return;
			case ServicePackage.POSSIBLY_IMPORTED_INTERFACE__REQUIRING_MICROSERVICE:
				setRequiringMicroservice((Microservice)newValue);
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
			case ServicePackage.POSSIBLY_IMPORTED_INTERFACE__IMPORT:
				setImport((Import)null);
				return;
			case ServicePackage.POSSIBLY_IMPORTED_INTERFACE__INTERFACE:
				setInterface((Interface)null);
				return;
			case ServicePackage.POSSIBLY_IMPORTED_INTERFACE__REQUIRING_MICROSERVICE:
				setRequiringMicroservice((Microservice)null);
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
			case ServicePackage.POSSIBLY_IMPORTED_INTERFACE__IMPORT:
				return import_ != null;
			case ServicePackage.POSSIBLY_IMPORTED_INTERFACE__INTERFACE:
				return interface_ != null;
			case ServicePackage.POSSIBLY_IMPORTED_INTERFACE__REQUIRING_MICROSERVICE:
				return basicGetRequiringMicroservice() != null;
			case ServicePackage.POSSIBLY_IMPORTED_INTERFACE__REQUIRED:
				return isRequired() != REQUIRED_EDEFAULT;
			case ServicePackage.POSSIBLY_IMPORTED_INTERFACE__REQUIRED_BY_CONTAINER:
				return isRequiredByContainer() != REQUIRED_BY_CONTAINER_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //PossiblyImportedInterfaceImpl
