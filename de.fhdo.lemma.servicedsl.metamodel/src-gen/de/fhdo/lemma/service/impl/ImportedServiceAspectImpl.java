/**
 */
package de.fhdo.lemma.service.impl;

import de.fhdo.lemma.data.PrimitiveValue;

import de.fhdo.lemma.service.Import;
import de.fhdo.lemma.service.ImportedServiceAspect;
import de.fhdo.lemma.service.Interface;
import de.fhdo.lemma.service.MappedComplexType;
import de.fhdo.lemma.service.MappedDataOperation;
import de.fhdo.lemma.service.MappedDataOperationParameter;
import de.fhdo.lemma.service.MappedDataOperationReturnType;
import de.fhdo.lemma.service.MappedField;
import de.fhdo.lemma.service.Microservice;
import de.fhdo.lemma.service.Operation;
import de.fhdo.lemma.service.Parameter;
import de.fhdo.lemma.service.ReferredOperation;
import de.fhdo.lemma.service.ServicePackage;

import de.fhdo.lemma.technology.ServiceAspect;
import de.fhdo.lemma.technology.TechnologySpecificPropertyValueAssignment;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Imported Service Aspect</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.impl.ImportedServiceAspectImpl#getImport <em>Import</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ImportedServiceAspectImpl#getImportedAspect <em>Imported Aspect</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ImportedServiceAspectImpl#getSinglePropertyValue <em>Single Property Value</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ImportedServiceAspectImpl#getValues <em>Values</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ImportedServiceAspectImpl#getMicroservice <em>Microservice</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ImportedServiceAspectImpl#getInterface <em>Interface</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ImportedServiceAspectImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ImportedServiceAspectImpl#getReferredOperation <em>Referred Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ImportedServiceAspectImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ImportedServiceAspectImpl#getMappedComplexType <em>Mapped Complex Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ImportedServiceAspectImpl#getMappedField <em>Mapped Field</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ImportedServiceAspectImpl#getMappedDataOperation <em>Mapped Data Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ImportedServiceAspectImpl#getMappedDataOperationReturnType <em>Mapped Data Operation Return Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.ImportedServiceAspectImpl#getMappedDataOperationParameter <em>Mapped Data Operation Parameter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImportedServiceAspectImpl extends MinimalEObjectImpl.Container implements ImportedServiceAspect {
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
	 * The cached value of the '{@link #getImportedAspect() <em>Imported Aspect</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedAspect()
	 * @generated
	 * @ordered
	 */
	protected ServiceAspect importedAspect;

	/**
	 * The cached value of the '{@link #getSinglePropertyValue() <em>Single Property Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSinglePropertyValue()
	 * @generated
	 * @ordered
	 */
	protected PrimitiveValue singlePropertyValue;

	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<TechnologySpecificPropertyValueAssignment> values;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImportedServiceAspectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicePackage.Literals.IMPORTED_SERVICE_ASPECT;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicePackage.IMPORTED_SERVICE_ASPECT__IMPORT, oldImport, import_));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.IMPORTED_SERVICE_ASPECT__IMPORT, oldImport, import_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ServiceAspect getImportedAspect() {
		if (importedAspect != null && importedAspect.eIsProxy()) {
			InternalEObject oldImportedAspect = (InternalEObject)importedAspect;
			importedAspect = (ServiceAspect)eResolveProxy(oldImportedAspect);
			if (importedAspect != oldImportedAspect) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicePackage.IMPORTED_SERVICE_ASPECT__IMPORTED_ASPECT, oldImportedAspect, importedAspect));
			}
		}
		return importedAspect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceAspect basicGetImportedAspect() {
		return importedAspect;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImportedAspect(ServiceAspect newImportedAspect) {
		ServiceAspect oldImportedAspect = importedAspect;
		importedAspect = newImportedAspect;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.IMPORTED_SERVICE_ASPECT__IMPORTED_ASPECT, oldImportedAspect, importedAspect));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrimitiveValue getSinglePropertyValue() {
		return singlePropertyValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSinglePropertyValue(PrimitiveValue newSinglePropertyValue, NotificationChain msgs) {
		PrimitiveValue oldSinglePropertyValue = singlePropertyValue;
		singlePropertyValue = newSinglePropertyValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ServicePackage.IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE, oldSinglePropertyValue, newSinglePropertyValue);
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
	public void setSinglePropertyValue(PrimitiveValue newSinglePropertyValue) {
		if (newSinglePropertyValue != singlePropertyValue) {
			NotificationChain msgs = null;
			if (singlePropertyValue != null)
				msgs = ((InternalEObject)singlePropertyValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ServicePackage.IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE, null, msgs);
			if (newSinglePropertyValue != null)
				msgs = ((InternalEObject)newSinglePropertyValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ServicePackage.IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE, null, msgs);
			msgs = basicSetSinglePropertyValue(newSinglePropertyValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE, newSinglePropertyValue, newSinglePropertyValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TechnologySpecificPropertyValueAssignment> getValues() {
		if (values == null) {
			values = new EObjectContainmentEList<TechnologySpecificPropertyValueAssignment>(TechnologySpecificPropertyValueAssignment.class, this, ServicePackage.IMPORTED_SERVICE_ASPECT__VALUES);
		}
		return values;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Microservice getMicroservice() {
		if (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__MICROSERVICE) return null;
		return (Microservice)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Microservice basicGetMicroservice() {
		if (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__MICROSERVICE) return null;
		return (Microservice)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMicroservice(Microservice newMicroservice, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMicroservice, ServicePackage.IMPORTED_SERVICE_ASPECT__MICROSERVICE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMicroservice(Microservice newMicroservice) {
		if (newMicroservice != eInternalContainer() || (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__MICROSERVICE && newMicroservice != null)) {
			if (EcoreUtil.isAncestor(this, newMicroservice))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMicroservice != null)
				msgs = ((InternalEObject)newMicroservice).eInverseAdd(this, ServicePackage.MICROSERVICE__ASPECTS, Microservice.class, msgs);
			msgs = basicSetMicroservice(newMicroservice, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.IMPORTED_SERVICE_ASPECT__MICROSERVICE, newMicroservice, newMicroservice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Interface getInterface() {
		if (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__INTERFACE) return null;
		return (Interface)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interface basicGetInterface() {
		if (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__INTERFACE) return null;
		return (Interface)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInterface(Interface newInterface, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newInterface, ServicePackage.IMPORTED_SERVICE_ASPECT__INTERFACE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInterface(Interface newInterface) {
		if (newInterface != eInternalContainer() || (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__INTERFACE && newInterface != null)) {
			if (EcoreUtil.isAncestor(this, newInterface))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInterface != null)
				msgs = ((InternalEObject)newInterface).eInverseAdd(this, ServicePackage.INTERFACE__ASPECTS, Interface.class, msgs);
			msgs = basicSetInterface(newInterface, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.IMPORTED_SERVICE_ASPECT__INTERFACE, newInterface, newInterface));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Operation getOperation() {
		if (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__OPERATION) return null;
		return (Operation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetOperation() {
		if (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__OPERATION) return null;
		return (Operation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperation(Operation newOperation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOperation, ServicePackage.IMPORTED_SERVICE_ASPECT__OPERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperation(Operation newOperation) {
		if (newOperation != eInternalContainer() || (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__OPERATION && newOperation != null)) {
			if (EcoreUtil.isAncestor(this, newOperation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOperation != null)
				msgs = ((InternalEObject)newOperation).eInverseAdd(this, ServicePackage.OPERATION__ASPECTS, Operation.class, msgs);
			msgs = basicSetOperation(newOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.IMPORTED_SERVICE_ASPECT__OPERATION, newOperation, newOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ReferredOperation getReferredOperation() {
		if (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION) return null;
		return (ReferredOperation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferredOperation basicGetReferredOperation() {
		if (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION) return null;
		return (ReferredOperation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReferredOperation(ReferredOperation newReferredOperation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newReferredOperation, ServicePackage.IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredOperation(ReferredOperation newReferredOperation) {
		if (newReferredOperation != eInternalContainer() || (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION && newReferredOperation != null)) {
			if (EcoreUtil.isAncestor(this, newReferredOperation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newReferredOperation != null)
				msgs = ((InternalEObject)newReferredOperation).eInverseAdd(this, ServicePackage.REFERRED_OPERATION__ASPECTS, ReferredOperation.class, msgs);
			msgs = basicSetReferredOperation(newReferredOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION, newReferredOperation, newReferredOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Parameter getParameter() {
		if (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__PARAMETER) return null;
		return (Parameter)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter basicGetParameter() {
		if (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__PARAMETER) return null;
		return (Parameter)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameter(Parameter newParameter, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParameter, ServicePackage.IMPORTED_SERVICE_ASPECT__PARAMETER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParameter(Parameter newParameter) {
		if (newParameter != eInternalContainer() || (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__PARAMETER && newParameter != null)) {
			if (EcoreUtil.isAncestor(this, newParameter))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParameter != null)
				msgs = ((InternalEObject)newParameter).eInverseAdd(this, ServicePackage.PARAMETER__ASPECTS, Parameter.class, msgs);
			msgs = basicSetParameter(newParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.IMPORTED_SERVICE_ASPECT__PARAMETER, newParameter, newParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappedComplexType getMappedComplexType() {
		if (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_COMPLEX_TYPE) return null;
		return (MappedComplexType)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappedComplexType basicGetMappedComplexType() {
		if (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_COMPLEX_TYPE) return null;
		return (MappedComplexType)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappedComplexType(MappedComplexType newMappedComplexType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMappedComplexType, ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_COMPLEX_TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMappedComplexType(MappedComplexType newMappedComplexType) {
		if (newMappedComplexType != eInternalContainer() || (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_COMPLEX_TYPE && newMappedComplexType != null)) {
			if (EcoreUtil.isAncestor(this, newMappedComplexType))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMappedComplexType != null)
				msgs = ((InternalEObject)newMappedComplexType).eInverseAdd(this, ServicePackage.MAPPED_COMPLEX_TYPE__ASPECTS, MappedComplexType.class, msgs);
			msgs = basicSetMappedComplexType(newMappedComplexType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_COMPLEX_TYPE, newMappedComplexType, newMappedComplexType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappedField getMappedField() {
		if (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_FIELD) return null;
		return (MappedField)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappedField basicGetMappedField() {
		if (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_FIELD) return null;
		return (MappedField)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappedField(MappedField newMappedField, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMappedField, ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_FIELD, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMappedField(MappedField newMappedField) {
		if (newMappedField != eInternalContainer() || (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_FIELD && newMappedField != null)) {
			if (EcoreUtil.isAncestor(this, newMappedField))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMappedField != null)
				msgs = ((InternalEObject)newMappedField).eInverseAdd(this, ServicePackage.MAPPED_FIELD__ASPECTS, MappedField.class, msgs);
			msgs = basicSetMappedField(newMappedField, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_FIELD, newMappedField, newMappedField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappedDataOperation getMappedDataOperation() {
		if (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION) return null;
		return (MappedDataOperation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappedDataOperation basicGetMappedDataOperation() {
		if (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION) return null;
		return (MappedDataOperation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappedDataOperation(MappedDataOperation newMappedDataOperation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMappedDataOperation, ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMappedDataOperation(MappedDataOperation newMappedDataOperation) {
		if (newMappedDataOperation != eInternalContainer() || (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION && newMappedDataOperation != null)) {
			if (EcoreUtil.isAncestor(this, newMappedDataOperation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMappedDataOperation != null)
				msgs = ((InternalEObject)newMappedDataOperation).eInverseAdd(this, ServicePackage.MAPPED_DATA_OPERATION__ASPECTS, MappedDataOperation.class, msgs);
			msgs = basicSetMappedDataOperation(newMappedDataOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION, newMappedDataOperation, newMappedDataOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappedDataOperationReturnType getMappedDataOperationReturnType() {
		if (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_RETURN_TYPE) return null;
		return (MappedDataOperationReturnType)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappedDataOperationReturnType basicGetMappedDataOperationReturnType() {
		if (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_RETURN_TYPE) return null;
		return (MappedDataOperationReturnType)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappedDataOperationReturnType(MappedDataOperationReturnType newMappedDataOperationReturnType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMappedDataOperationReturnType, ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_RETURN_TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMappedDataOperationReturnType(MappedDataOperationReturnType newMappedDataOperationReturnType) {
		if (newMappedDataOperationReturnType != eInternalContainer() || (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_RETURN_TYPE && newMappedDataOperationReturnType != null)) {
			if (EcoreUtil.isAncestor(this, newMappedDataOperationReturnType))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMappedDataOperationReturnType != null)
				msgs = ((InternalEObject)newMappedDataOperationReturnType).eInverseAdd(this, ServicePackage.MAPPED_DATA_OPERATION_RETURN_TYPE__ASPECTS, MappedDataOperationReturnType.class, msgs);
			msgs = basicSetMappedDataOperationReturnType(newMappedDataOperationReturnType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_RETURN_TYPE, newMappedDataOperationReturnType, newMappedDataOperationReturnType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappedDataOperationParameter getMappedDataOperationParameter() {
		if (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_PARAMETER) return null;
		return (MappedDataOperationParameter)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappedDataOperationParameter basicGetMappedDataOperationParameter() {
		if (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_PARAMETER) return null;
		return (MappedDataOperationParameter)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappedDataOperationParameter(MappedDataOperationParameter newMappedDataOperationParameter, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMappedDataOperationParameter, ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_PARAMETER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMappedDataOperationParameter(MappedDataOperationParameter newMappedDataOperationParameter) {
		if (newMappedDataOperationParameter != eInternalContainer() || (eContainerFeatureID() != ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_PARAMETER && newMappedDataOperationParameter != null)) {
			if (EcoreUtil.isAncestor(this, newMappedDataOperationParameter))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMappedDataOperationParameter != null)
				msgs = ((InternalEObject)newMappedDataOperationParameter).eInverseAdd(this, ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__ASPECTS, MappedDataOperationParameter.class, msgs);
			msgs = basicSetMappedDataOperationParameter(newMappedDataOperationParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_PARAMETER, newMappedDataOperationParameter, newMappedDataOperationParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MICROSERVICE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMicroservice((Microservice)otherEnd, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__INTERFACE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInterface((Interface)otherEnd, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__OPERATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOperation((Operation)otherEnd, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetReferredOperation((ReferredOperation)otherEnd, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__PARAMETER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParameter((Parameter)otherEnd, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_COMPLEX_TYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMappedComplexType((MappedComplexType)otherEnd, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_FIELD:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMappedField((MappedField)otherEnd, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMappedDataOperation((MappedDataOperation)otherEnd, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_RETURN_TYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMappedDataOperationReturnType((MappedDataOperationReturnType)otherEnd, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_PARAMETER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMappedDataOperationParameter((MappedDataOperationParameter)otherEnd, msgs);
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
			case ServicePackage.IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE:
				return basicSetSinglePropertyValue(null, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__VALUES:
				return ((InternalEList<?>)getValues()).basicRemove(otherEnd, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MICROSERVICE:
				return basicSetMicroservice(null, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__INTERFACE:
				return basicSetInterface(null, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__OPERATION:
				return basicSetOperation(null, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION:
				return basicSetReferredOperation(null, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__PARAMETER:
				return basicSetParameter(null, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_COMPLEX_TYPE:
				return basicSetMappedComplexType(null, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_FIELD:
				return basicSetMappedField(null, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION:
				return basicSetMappedDataOperation(null, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_RETURN_TYPE:
				return basicSetMappedDataOperationReturnType(null, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_PARAMETER:
				return basicSetMappedDataOperationParameter(null, msgs);
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
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MICROSERVICE:
				return eInternalContainer().eInverseRemove(this, ServicePackage.MICROSERVICE__ASPECTS, Microservice.class, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__INTERFACE:
				return eInternalContainer().eInverseRemove(this, ServicePackage.INTERFACE__ASPECTS, Interface.class, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__OPERATION:
				return eInternalContainer().eInverseRemove(this, ServicePackage.OPERATION__ASPECTS, Operation.class, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION:
				return eInternalContainer().eInverseRemove(this, ServicePackage.REFERRED_OPERATION__ASPECTS, ReferredOperation.class, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__PARAMETER:
				return eInternalContainer().eInverseRemove(this, ServicePackage.PARAMETER__ASPECTS, Parameter.class, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_COMPLEX_TYPE:
				return eInternalContainer().eInverseRemove(this, ServicePackage.MAPPED_COMPLEX_TYPE__ASPECTS, MappedComplexType.class, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_FIELD:
				return eInternalContainer().eInverseRemove(this, ServicePackage.MAPPED_FIELD__ASPECTS, MappedField.class, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION:
				return eInternalContainer().eInverseRemove(this, ServicePackage.MAPPED_DATA_OPERATION__ASPECTS, MappedDataOperation.class, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_RETURN_TYPE:
				return eInternalContainer().eInverseRemove(this, ServicePackage.MAPPED_DATA_OPERATION_RETURN_TYPE__ASPECTS, MappedDataOperationReturnType.class, msgs);
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_PARAMETER:
				return eInternalContainer().eInverseRemove(this, ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__ASPECTS, MappedDataOperationParameter.class, msgs);
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
			case ServicePackage.IMPORTED_SERVICE_ASPECT__IMPORT:
				if (resolve) return getImport();
				return basicGetImport();
			case ServicePackage.IMPORTED_SERVICE_ASPECT__IMPORTED_ASPECT:
				if (resolve) return getImportedAspect();
				return basicGetImportedAspect();
			case ServicePackage.IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE:
				return getSinglePropertyValue();
			case ServicePackage.IMPORTED_SERVICE_ASPECT__VALUES:
				return getValues();
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MICROSERVICE:
				if (resolve) return getMicroservice();
				return basicGetMicroservice();
			case ServicePackage.IMPORTED_SERVICE_ASPECT__INTERFACE:
				if (resolve) return getInterface();
				return basicGetInterface();
			case ServicePackage.IMPORTED_SERVICE_ASPECT__OPERATION:
				if (resolve) return getOperation();
				return basicGetOperation();
			case ServicePackage.IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION:
				if (resolve) return getReferredOperation();
				return basicGetReferredOperation();
			case ServicePackage.IMPORTED_SERVICE_ASPECT__PARAMETER:
				if (resolve) return getParameter();
				return basicGetParameter();
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_COMPLEX_TYPE:
				if (resolve) return getMappedComplexType();
				return basicGetMappedComplexType();
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_FIELD:
				if (resolve) return getMappedField();
				return basicGetMappedField();
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION:
				if (resolve) return getMappedDataOperation();
				return basicGetMappedDataOperation();
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_RETURN_TYPE:
				if (resolve) return getMappedDataOperationReturnType();
				return basicGetMappedDataOperationReturnType();
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_PARAMETER:
				if (resolve) return getMappedDataOperationParameter();
				return basicGetMappedDataOperationParameter();
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
			case ServicePackage.IMPORTED_SERVICE_ASPECT__IMPORT:
				setImport((Import)newValue);
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__IMPORTED_ASPECT:
				setImportedAspect((ServiceAspect)newValue);
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE:
				setSinglePropertyValue((PrimitiveValue)newValue);
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends TechnologySpecificPropertyValueAssignment>)newValue);
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MICROSERVICE:
				setMicroservice((Microservice)newValue);
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__INTERFACE:
				setInterface((Interface)newValue);
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__OPERATION:
				setOperation((Operation)newValue);
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION:
				setReferredOperation((ReferredOperation)newValue);
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__PARAMETER:
				setParameter((Parameter)newValue);
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_COMPLEX_TYPE:
				setMappedComplexType((MappedComplexType)newValue);
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_FIELD:
				setMappedField((MappedField)newValue);
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION:
				setMappedDataOperation((MappedDataOperation)newValue);
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_RETURN_TYPE:
				setMappedDataOperationReturnType((MappedDataOperationReturnType)newValue);
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_PARAMETER:
				setMappedDataOperationParameter((MappedDataOperationParameter)newValue);
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
			case ServicePackage.IMPORTED_SERVICE_ASPECT__IMPORT:
				setImport((Import)null);
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__IMPORTED_ASPECT:
				setImportedAspect((ServiceAspect)null);
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE:
				setSinglePropertyValue((PrimitiveValue)null);
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__VALUES:
				getValues().clear();
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MICROSERVICE:
				setMicroservice((Microservice)null);
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__INTERFACE:
				setInterface((Interface)null);
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__OPERATION:
				setOperation((Operation)null);
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION:
				setReferredOperation((ReferredOperation)null);
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__PARAMETER:
				setParameter((Parameter)null);
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_COMPLEX_TYPE:
				setMappedComplexType((MappedComplexType)null);
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_FIELD:
				setMappedField((MappedField)null);
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION:
				setMappedDataOperation((MappedDataOperation)null);
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_RETURN_TYPE:
				setMappedDataOperationReturnType((MappedDataOperationReturnType)null);
				return;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_PARAMETER:
				setMappedDataOperationParameter((MappedDataOperationParameter)null);
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
			case ServicePackage.IMPORTED_SERVICE_ASPECT__IMPORT:
				return import_ != null;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__IMPORTED_ASPECT:
				return importedAspect != null;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__SINGLE_PROPERTY_VALUE:
				return singlePropertyValue != null;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__VALUES:
				return values != null && !values.isEmpty();
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MICROSERVICE:
				return basicGetMicroservice() != null;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__INTERFACE:
				return basicGetInterface() != null;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__OPERATION:
				return basicGetOperation() != null;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__REFERRED_OPERATION:
				return basicGetReferredOperation() != null;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__PARAMETER:
				return basicGetParameter() != null;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_COMPLEX_TYPE:
				return basicGetMappedComplexType() != null;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_FIELD:
				return basicGetMappedField() != null;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION:
				return basicGetMappedDataOperation() != null;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_RETURN_TYPE:
				return basicGetMappedDataOperationReturnType() != null;
			case ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_PARAMETER:
				return basicGetMappedDataOperationParameter() != null;
		}
		return super.eIsSet(featureID);
	}

} //ImportedServiceAspectImpl
