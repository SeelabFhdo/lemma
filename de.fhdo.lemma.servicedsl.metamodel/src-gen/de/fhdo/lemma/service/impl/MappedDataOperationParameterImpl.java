/**
 */
package de.fhdo.lemma.service.impl;

import de.fhdo.lemma.data.DataOperationParameter;

import de.fhdo.lemma.service.ImportedServiceAspect;
import de.fhdo.lemma.service.ImportedType;
import de.fhdo.lemma.service.MappedDataOperation;
import de.fhdo.lemma.service.MappedDataOperationParameter;
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
 * An implementation of the model object '<em><b>Mapped Data Operation Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.impl.MappedDataOperationParameterImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.MappedDataOperationParameterImpl#getMappedType <em>Mapped Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.MappedDataOperationParameterImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.impl.MappedDataOperationParameterImpl#getMappedOperation <em>Mapped Operation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappedDataOperationParameterImpl extends MinimalEObjectImpl.Container implements MappedDataOperationParameter {
	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected DataOperationParameter parameter;

	/**
	 * The cached value of the '{@link #getMappedType() <em>Mapped Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappedType()
	 * @generated
	 * @ordered
	 */
	protected ImportedType mappedType;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappedDataOperationParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicePackage.Literals.MAPPED_DATA_OPERATION_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataOperationParameter getParameter() {
		if (parameter != null && parameter.eIsProxy()) {
			InternalEObject oldParameter = (InternalEObject)parameter;
			parameter = (DataOperationParameter)eResolveProxy(oldParameter);
			if (parameter != oldParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__PARAMETER, oldParameter, parameter));
			}
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataOperationParameter basicGetParameter() {
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParameter(DataOperationParameter newParameter) {
		DataOperationParameter oldParameter = parameter;
		parameter = newParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__PARAMETER, oldParameter, parameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImportedType getMappedType() {
		return mappedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappedType(ImportedType newMappedType, NotificationChain msgs) {
		ImportedType oldMappedType = mappedType;
		mappedType = newMappedType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__MAPPED_TYPE, oldMappedType, newMappedType);
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
	public void setMappedType(ImportedType newMappedType) {
		if (newMappedType != mappedType) {
			NotificationChain msgs = null;
			if (mappedType != null)
				msgs = ((InternalEObject)mappedType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__MAPPED_TYPE, null, msgs);
			if (newMappedType != null)
				msgs = ((InternalEObject)newMappedType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__MAPPED_TYPE, null, msgs);
			msgs = basicSetMappedType(newMappedType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__MAPPED_TYPE, newMappedType, newMappedType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ImportedServiceAspect> getAspects() {
		if (aspects == null) {
			aspects = new EObjectContainmentWithInverseEList<ImportedServiceAspect>(ImportedServiceAspect.class, this, ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__ASPECTS, ServicePackage.IMPORTED_SERVICE_ASPECT__MAPPED_DATA_OPERATION_PARAMETER);
		}
		return aspects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappedDataOperation getMappedOperation() {
		if (eContainerFeatureID() != ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__MAPPED_OPERATION) return null;
		return (MappedDataOperation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappedDataOperation basicGetMappedOperation() {
		if (eContainerFeatureID() != ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__MAPPED_OPERATION) return null;
		return (MappedDataOperation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappedOperation(MappedDataOperation newMappedOperation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMappedOperation, ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__MAPPED_OPERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMappedOperation(MappedDataOperation newMappedOperation) {
		if (newMappedOperation != eInternalContainer() || (eContainerFeatureID() != ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__MAPPED_OPERATION && newMappedOperation != null)) {
			if (EcoreUtil.isAncestor(this, newMappedOperation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMappedOperation != null)
				msgs = ((InternalEObject)newMappedOperation).eInverseAdd(this, ServicePackage.MAPPED_DATA_OPERATION__MAPPED_PARAMETERS, MappedDataOperation.class, msgs);
			msgs = basicSetMappedOperation(newMappedOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__MAPPED_OPERATION, newMappedOperation, newMappedOperation));
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
			case ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__ASPECTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspects()).basicAdd(otherEnd, msgs);
			case ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__MAPPED_OPERATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMappedOperation((MappedDataOperation)otherEnd, msgs);
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
			case ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__MAPPED_TYPE:
				return basicSetMappedType(null, msgs);
			case ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__ASPECTS:
				return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
			case ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__MAPPED_OPERATION:
				return basicSetMappedOperation(null, msgs);
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
			case ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__MAPPED_OPERATION:
				return eInternalContainer().eInverseRemove(this, ServicePackage.MAPPED_DATA_OPERATION__MAPPED_PARAMETERS, MappedDataOperation.class, msgs);
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
			case ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__PARAMETER:
				if (resolve) return getParameter();
				return basicGetParameter();
			case ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__MAPPED_TYPE:
				return getMappedType();
			case ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__ASPECTS:
				return getAspects();
			case ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__MAPPED_OPERATION:
				if (resolve) return getMappedOperation();
				return basicGetMappedOperation();
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
			case ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__PARAMETER:
				setParameter((DataOperationParameter)newValue);
				return;
			case ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__MAPPED_TYPE:
				setMappedType((ImportedType)newValue);
				return;
			case ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__ASPECTS:
				getAspects().clear();
				getAspects().addAll((Collection<? extends ImportedServiceAspect>)newValue);
				return;
			case ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__MAPPED_OPERATION:
				setMappedOperation((MappedDataOperation)newValue);
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
			case ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__PARAMETER:
				setParameter((DataOperationParameter)null);
				return;
			case ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__MAPPED_TYPE:
				setMappedType((ImportedType)null);
				return;
			case ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__ASPECTS:
				getAspects().clear();
				return;
			case ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__MAPPED_OPERATION:
				setMappedOperation((MappedDataOperation)null);
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
			case ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__PARAMETER:
				return parameter != null;
			case ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__MAPPED_TYPE:
				return mappedType != null;
			case ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__ASPECTS:
				return aspects != null && !aspects.isEmpty();
			case ServicePackage.MAPPED_DATA_OPERATION_PARAMETER__MAPPED_OPERATION:
				return basicGetMappedOperation() != null;
		}
		return super.eIsSet(featureID);
	}

} //MappedDataOperationParameterImpl
