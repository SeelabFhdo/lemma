/**
 */
package de.fhdo.lemma.service.impl;

import de.fhdo.lemma.data.DataOperation;

import de.fhdo.lemma.service.ImportedServiceAspect;
import de.fhdo.lemma.service.MappedComplexType;
import de.fhdo.lemma.service.MappedDataOperation;
import de.fhdo.lemma.service.MappedDataOperationParameter;
import de.fhdo.lemma.service.MappedDataOperationReturnType;
import de.fhdo.lemma.service.ServicePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapped Data Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.impl.MappedDataOperationImpl#getDataOperation <em>Data Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.MappedDataOperationImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.MappedDataOperationImpl#getMappedReturnType <em>Mapped Return Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.MappedDataOperationImpl#getMappedParameters <em>Mapped Parameters</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.MappedDataOperationImpl#getMappedComplexType <em>Mapped Complex Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappedDataOperationImpl extends MinimalEObjectImpl.Container implements MappedDataOperation {
	/**
	 * The cached value of the '{@link #getDataOperation() <em>Data Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataOperation()
	 * @generated
	 * @ordered
	 */
	protected DataOperation dataOperation;

	/**
	 * The cached value of the '{@link #getAspects() <em>Aspects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAspects()
	 * @generated
	 * @ordered
	 */
	protected EList<ImportedServiceAspect> aspects;

	/**
	 * The cached value of the '{@link #getMappedReturnType() <em>Mapped Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappedReturnType()
	 * @generated
	 * @ordered
	 */
	protected MappedDataOperationReturnType mappedReturnType;

	/**
	 * The cached value of the '{@link #getMappedParameters() <em>Mapped Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappedParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<MappedDataOperationParameter> mappedParameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappedDataOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicePackage.Literals.MAPPED_DATA_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataOperation getDataOperation() {
		if (dataOperation != null && dataOperation.eIsProxy()) {
			InternalEObject oldDataOperation = (InternalEObject)dataOperation;
			dataOperation = (DataOperation)eResolveProxy(oldDataOperation);
			if (dataOperation != oldDataOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicePackage.MAPPED_DATA_OPERATION__DATA_OPERATION, oldDataOperation, dataOperation));
			}
		}
		return dataOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataOperation basicGetDataOperation() {
		return dataOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataOperation(DataOperation newDataOperation) {
		DataOperation oldDataOperation = dataOperation;
		dataOperation = newDataOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.MAPPED_DATA_OPERATION__DATA_OPERATION, oldDataOperation, dataOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ImportedServiceAspect> getAspects() {
		if (aspects == null) {
			aspects = new EObjectContainmentWithInverseEList<ImportedServiceAspect>(ImportedServiceAspect.class, this, ServicePackage.MAPPED_DATA_OPERATION__ASPECTS, ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION);
		}
		return aspects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappedDataOperationReturnType getMappedReturnType() {
		return mappedReturnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappedReturnType(MappedDataOperationReturnType newMappedReturnType, NotificationChain msgs) {
		MappedDataOperationReturnType oldMappedReturnType = mappedReturnType;
		mappedReturnType = newMappedReturnType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ServicePackage.MAPPED_DATA_OPERATION__MAPPED_RETURN_TYPE, oldMappedReturnType, newMappedReturnType);
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
	public void setMappedReturnType(MappedDataOperationReturnType newMappedReturnType) {
		if (newMappedReturnType != mappedReturnType) {
			NotificationChain msgs = null;
			if (mappedReturnType != null)
				msgs = ((InternalEObject)mappedReturnType).eInverseRemove(this, ServicePackage.MAPPED_DATA_OPERATION_RETURN_TYPE__MAPPED_OPERATION, MappedDataOperationReturnType.class, msgs);
			if (newMappedReturnType != null)
				msgs = ((InternalEObject)newMappedReturnType).eInverseAdd(this, ServicePackage.MAPPED_DATA_OPERATION_RETURN_TYPE__MAPPED_OPERATION, MappedDataOperationReturnType.class, msgs);
			msgs = basicSetMappedReturnType(newMappedReturnType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.MAPPED_DATA_OPERATION__MAPPED_RETURN_TYPE, newMappedReturnType, newMappedReturnType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappedDataOperationParameter> getMappedParameters() {
		if (mappedParameters == null) {
			mappedParameters = new EObjectContainmentWithInverseEList<MappedDataOperationParameter>(MappedDataOperationParameter.class, this, ServicePackage.MAPPED_DATA_OPERATION__MAPPED_PARAMETERS, ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__MAPPED_OPERATION);
		}
		return mappedParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappedComplexType getMappedComplexType() {
		if (eContainerFeatureID() != ServicePackage.MAPPED_DATA_OPERATION__MAPPED_COMPLEX_TYPE) return null;
		return (MappedComplexType)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappedComplexType basicGetMappedComplexType() {
		if (eContainerFeatureID() != ServicePackage.MAPPED_DATA_OPERATION__MAPPED_COMPLEX_TYPE) return null;
		return (MappedComplexType)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappedComplexType(MappedComplexType newMappedComplexType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMappedComplexType, ServicePackage.MAPPED_DATA_OPERATION__MAPPED_COMPLEX_TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMappedComplexType(MappedComplexType newMappedComplexType) {
		if (newMappedComplexType != eInternalContainer() || (eContainerFeatureID() != ServicePackage.MAPPED_DATA_OPERATION__MAPPED_COMPLEX_TYPE && newMappedComplexType != null)) {
			if (EcoreUtil.isAncestor(this, newMappedComplexType))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMappedComplexType != null)
				msgs = ((InternalEObject)newMappedComplexType).eInverseAdd(this, ServicePackage.MAPPED_COMPLEX_TYPE__MAPPED_OPERATIONS, MappedComplexType.class, msgs);
			msgs = basicSetMappedComplexType(newMappedComplexType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.MAPPED_DATA_OPERATION__MAPPED_COMPLEX_TYPE, newMappedComplexType, newMappedComplexType));
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
			case ServicePackage.MAPPED_DATA_OPERATION__ASPECTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspects()).basicAdd(otherEnd, msgs);
			case ServicePackage.MAPPED_DATA_OPERATION__MAPPED_RETURN_TYPE:
				if (mappedReturnType != null)
					msgs = ((InternalEObject)mappedReturnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ServicePackage.MAPPED_DATA_OPERATION__MAPPED_RETURN_TYPE, null, msgs);
				return basicSetMappedReturnType((MappedDataOperationReturnType)otherEnd, msgs);
			case ServicePackage.MAPPED_DATA_OPERATION__MAPPED_PARAMETERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMappedParameters()).basicAdd(otherEnd, msgs);
			case ServicePackage.MAPPED_DATA_OPERATION__MAPPED_COMPLEX_TYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMappedComplexType((MappedComplexType)otherEnd, msgs);
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
			case ServicePackage.MAPPED_DATA_OPERATION__ASPECTS:
				return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
			case ServicePackage.MAPPED_DATA_OPERATION__MAPPED_RETURN_TYPE:
				return basicSetMappedReturnType(null, msgs);
			case ServicePackage.MAPPED_DATA_OPERATION__MAPPED_PARAMETERS:
				return ((InternalEList<?>)getMappedParameters()).basicRemove(otherEnd, msgs);
			case ServicePackage.MAPPED_DATA_OPERATION__MAPPED_COMPLEX_TYPE:
				return basicSetMappedComplexType(null, msgs);
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
			case ServicePackage.MAPPED_DATA_OPERATION__MAPPED_COMPLEX_TYPE:
				return eInternalContainer().eInverseRemove(this, ServicePackage.MAPPED_COMPLEX_TYPE__MAPPED_OPERATIONS, MappedComplexType.class, msgs);
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
			case ServicePackage.MAPPED_DATA_OPERATION__DATA_OPERATION:
				if (resolve) return getDataOperation();
				return basicGetDataOperation();
			case ServicePackage.MAPPED_DATA_OPERATION__ASPECTS:
				return getAspects();
			case ServicePackage.MAPPED_DATA_OPERATION__MAPPED_RETURN_TYPE:
				return getMappedReturnType();
			case ServicePackage.MAPPED_DATA_OPERATION__MAPPED_PARAMETERS:
				return getMappedParameters();
			case ServicePackage.MAPPED_DATA_OPERATION__MAPPED_COMPLEX_TYPE:
				if (resolve) return getMappedComplexType();
				return basicGetMappedComplexType();
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
			case ServicePackage.MAPPED_DATA_OPERATION__DATA_OPERATION:
				setDataOperation((DataOperation)newValue);
				return;
			case ServicePackage.MAPPED_DATA_OPERATION__ASPECTS:
				getAspects().clear();
				getAspects().addAll((Collection<? extends ImportedServiceAspect>)newValue);
				return;
			case ServicePackage.MAPPED_DATA_OPERATION__MAPPED_RETURN_TYPE:
				setMappedReturnType((MappedDataOperationReturnType)newValue);
				return;
			case ServicePackage.MAPPED_DATA_OPERATION__MAPPED_PARAMETERS:
				getMappedParameters().clear();
				getMappedParameters().addAll((Collection<? extends MappedDataOperationParameter>)newValue);
				return;
			case ServicePackage.MAPPED_DATA_OPERATION__MAPPED_COMPLEX_TYPE:
				setMappedComplexType((MappedComplexType)newValue);
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
			case ServicePackage.MAPPED_DATA_OPERATION__DATA_OPERATION:
				setDataOperation((DataOperation)null);
				return;
			case ServicePackage.MAPPED_DATA_OPERATION__ASPECTS:
				getAspects().clear();
				return;
			case ServicePackage.MAPPED_DATA_OPERATION__MAPPED_RETURN_TYPE:
				setMappedReturnType((MappedDataOperationReturnType)null);
				return;
			case ServicePackage.MAPPED_DATA_OPERATION__MAPPED_PARAMETERS:
				getMappedParameters().clear();
				return;
			case ServicePackage.MAPPED_DATA_OPERATION__MAPPED_COMPLEX_TYPE:
				setMappedComplexType((MappedComplexType)null);
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
			case ServicePackage.MAPPED_DATA_OPERATION__DATA_OPERATION:
				return dataOperation != null;
			case ServicePackage.MAPPED_DATA_OPERATION__ASPECTS:
				return aspects != null && !aspects.isEmpty();
			case ServicePackage.MAPPED_DATA_OPERATION__MAPPED_RETURN_TYPE:
				return mappedReturnType != null;
			case ServicePackage.MAPPED_DATA_OPERATION__MAPPED_PARAMETERS:
				return mappedParameters != null && !mappedParameters.isEmpty();
			case ServicePackage.MAPPED_DATA_OPERATION__MAPPED_COMPLEX_TYPE:
				return basicGetMappedComplexType() != null;
		}
		return super.eIsSet(featureID);
	}

} //MappedDataOperationImpl
