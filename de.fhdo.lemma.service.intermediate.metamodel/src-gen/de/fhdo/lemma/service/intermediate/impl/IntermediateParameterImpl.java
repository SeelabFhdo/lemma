/**
 */
package de.fhdo.lemma.service.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateImportedAspect;
import de.fhdo.lemma.data.intermediate.IntermediateType;

import de.fhdo.lemma.service.intermediate.DataFieldAspects;
import de.fhdo.lemma.service.intermediate.IntermediateOperation;
import de.fhdo.lemma.service.intermediate.IntermediatePackage;
import de.fhdo.lemma.service.intermediate.IntermediateParameter;
import de.fhdo.lemma.service.intermediate.OperationReference;

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
 * An implementation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateParameterImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateParameterImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateParameterImpl#getExchangePattern <em>Exchange Pattern</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateParameterImpl#getCommunicationType <em>Communication Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateParameterImpl#isCommunicatesFault <em>Communicates Fault</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateParameterImpl#isOptional <em>Optional</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateParameterImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateParameterImpl#getOriginalType <em>Original Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateParameterImpl#getInitializedByOperation <em>Initialized By Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateParameterImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateParameterImpl#getFieldAspects <em>Field Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.service.intermediate.impl.IntermediateParameterImpl#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateParameterImpl extends MinimalEObjectImpl.Container implements IntermediateParameter {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String qualifiedName = QUALIFIED_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getExchangePattern() <em>Exchange Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExchangePattern()
	 * @generated
	 * @ordered
	 */
	protected static final String EXCHANGE_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExchangePattern() <em>Exchange Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExchangePattern()
	 * @generated
	 * @ordered
	 */
	protected String exchangePattern = EXCHANGE_PATTERN_EDEFAULT;

	/**
	 * The default value of the '{@link #getCommunicationType() <em>Communication Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommunicationType()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMUNICATION_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCommunicationType() <em>Communication Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommunicationType()
	 * @generated
	 * @ordered
	 */
	protected String communicationType = COMMUNICATION_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isCommunicatesFault() <em>Communicates Fault</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCommunicatesFault()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMMUNICATES_FAULT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCommunicatesFault() <em>Communicates Fault</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCommunicatesFault()
	 * @generated
	 * @ordered
	 */
	protected boolean communicatesFault = COMMUNICATES_FAULT_EDEFAULT;

	/**
	 * The default value of the '{@link #isOptional() <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOptional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OPTIONAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOptional() <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOptional()
	 * @generated
	 * @ordered
	 */
	protected boolean optional = OPTIONAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected IntermediateType type;

	/**
	 * The cached value of the '{@link #getOriginalType() <em>Original Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalType()
	 * @generated
	 * @ordered
	 */
	protected IntermediateType originalType;

	/**
	 * The cached value of the '{@link #getInitializedByOperation() <em>Initialized By Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializedByOperation()
	 * @generated
	 * @ordered
	 */
	protected OperationReference initializedByOperation;

	/**
	 * The cached value of the '{@link #getAspects() <em>Aspects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAspects()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateImportedAspect> aspects;

	/**
	 * The cached value of the '{@link #getFieldAspects() <em>Field Aspects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldAspects()
	 * @generated
	 * @ordered
	 */
	protected EList<DataFieldAspects> fieldAspects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntermediateParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IntermediatePackage.Literals.INTERMEDIATE_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_PARAMETER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getQualifiedName() {
		return qualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQualifiedName(String newQualifiedName) {
		String oldQualifiedName = qualifiedName;
		qualifiedName = newQualifiedName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_PARAMETER__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getExchangePattern() {
		return exchangePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExchangePattern(String newExchangePattern) {
		String oldExchangePattern = exchangePattern;
		exchangePattern = newExchangePattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_PARAMETER__EXCHANGE_PATTERN, oldExchangePattern, exchangePattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCommunicationType() {
		return communicationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCommunicationType(String newCommunicationType) {
		String oldCommunicationType = communicationType;
		communicationType = newCommunicationType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_PARAMETER__COMMUNICATION_TYPE, oldCommunicationType, communicationType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isCommunicatesFault() {
		return communicatesFault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCommunicatesFault(boolean newCommunicatesFault) {
		boolean oldCommunicatesFault = communicatesFault;
		communicatesFault = newCommunicatesFault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_PARAMETER__COMMUNICATES_FAULT, oldCommunicatesFault, communicatesFault));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isOptional() {
		return optional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOptional(boolean newOptional) {
		boolean oldOptional = optional;
		optional = newOptional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_PARAMETER__OPTIONAL, oldOptional, optional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(IntermediateType newType, NotificationChain msgs) {
		IntermediateType oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_PARAMETER__TYPE, oldType, newType);
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
	public void setType(IntermediateType newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntermediatePackage.INTERMEDIATE_PARAMETER__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IntermediatePackage.INTERMEDIATE_PARAMETER__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_PARAMETER__TYPE, newType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateType getOriginalType() {
		return originalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOriginalType(IntermediateType newOriginalType, NotificationChain msgs) {
		IntermediateType oldOriginalType = originalType;
		originalType = newOriginalType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_PARAMETER__ORIGINAL_TYPE, oldOriginalType, newOriginalType);
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
	public void setOriginalType(IntermediateType newOriginalType) {
		if (newOriginalType != originalType) {
			NotificationChain msgs = null;
			if (originalType != null)
				msgs = ((InternalEObject)originalType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntermediatePackage.INTERMEDIATE_PARAMETER__ORIGINAL_TYPE, null, msgs);
			if (newOriginalType != null)
				msgs = ((InternalEObject)newOriginalType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IntermediatePackage.INTERMEDIATE_PARAMETER__ORIGINAL_TYPE, null, msgs);
			msgs = basicSetOriginalType(newOriginalType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_PARAMETER__ORIGINAL_TYPE, newOriginalType, newOriginalType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperationReference getInitializedByOperation() {
		return initializedByOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitializedByOperation(OperationReference newInitializedByOperation, NotificationChain msgs) {
		OperationReference oldInitializedByOperation = initializedByOperation;
		initializedByOperation = newInitializedByOperation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_PARAMETER__INITIALIZED_BY_OPERATION, oldInitializedByOperation, newInitializedByOperation);
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
	public void setInitializedByOperation(OperationReference newInitializedByOperation) {
		if (newInitializedByOperation != initializedByOperation) {
			NotificationChain msgs = null;
			if (initializedByOperation != null)
				msgs = ((InternalEObject)initializedByOperation).eInverseRemove(this, IntermediatePackage.OPERATION_REFERENCE__INITIALIZED_PARAMETER, OperationReference.class, msgs);
			if (newInitializedByOperation != null)
				msgs = ((InternalEObject)newInitializedByOperation).eInverseAdd(this, IntermediatePackage.OPERATION_REFERENCE__INITIALIZED_PARAMETER, OperationReference.class, msgs);
			msgs = basicSetInitializedByOperation(newInitializedByOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_PARAMETER__INITIALIZED_BY_OPERATION, newInitializedByOperation, newInitializedByOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IntermediateImportedAspect> getAspects() {
		if (aspects == null) {
			aspects = new EObjectContainmentEList<IntermediateImportedAspect>(IntermediateImportedAspect.class, this, IntermediatePackage.INTERMEDIATE_PARAMETER__ASPECTS);
		}
		return aspects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataFieldAspects> getFieldAspects() {
		if (fieldAspects == null) {
			fieldAspects = new EObjectContainmentWithInverseEList<DataFieldAspects>(DataFieldAspects.class, this, IntermediatePackage.INTERMEDIATE_PARAMETER__FIELD_ASPECTS, IntermediatePackage.DATA_FIELD_ASPECTS__PARAMETER);
		}
		return fieldAspects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediateOperation getOperation() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_PARAMETER__OPERATION) return null;
		return (IntermediateOperation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntermediateOperation basicGetOperation() {
		if (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_PARAMETER__OPERATION) return null;
		return (IntermediateOperation)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperation(IntermediateOperation newOperation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOperation, IntermediatePackage.INTERMEDIATE_PARAMETER__OPERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperation(IntermediateOperation newOperation) {
		if (newOperation != eInternalContainer() || (eContainerFeatureID() != IntermediatePackage.INTERMEDIATE_PARAMETER__OPERATION && newOperation != null)) {
			if (EcoreUtil.isAncestor(this, newOperation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOperation != null)
				msgs = ((InternalEObject)newOperation).eInverseAdd(this, IntermediatePackage.INTERMEDIATE_OPERATION__PARAMETERS, IntermediateOperation.class, msgs);
			msgs = basicSetOperation(newOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_PARAMETER__OPERATION, newOperation, newOperation));
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
			case IntermediatePackage.INTERMEDIATE_PARAMETER__INITIALIZED_BY_OPERATION:
				if (initializedByOperation != null)
					msgs = ((InternalEObject)initializedByOperation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntermediatePackage.INTERMEDIATE_PARAMETER__INITIALIZED_BY_OPERATION, null, msgs);
				return basicSetInitializedByOperation((OperationReference)otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_PARAMETER__FIELD_ASPECTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFieldAspects()).basicAdd(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_PARAMETER__OPERATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOperation((IntermediateOperation)otherEnd, msgs);
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
			case IntermediatePackage.INTERMEDIATE_PARAMETER__TYPE:
				return basicSetType(null, msgs);
			case IntermediatePackage.INTERMEDIATE_PARAMETER__ORIGINAL_TYPE:
				return basicSetOriginalType(null, msgs);
			case IntermediatePackage.INTERMEDIATE_PARAMETER__INITIALIZED_BY_OPERATION:
				return basicSetInitializedByOperation(null, msgs);
			case IntermediatePackage.INTERMEDIATE_PARAMETER__ASPECTS:
				return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_PARAMETER__FIELD_ASPECTS:
				return ((InternalEList<?>)getFieldAspects()).basicRemove(otherEnd, msgs);
			case IntermediatePackage.INTERMEDIATE_PARAMETER__OPERATION:
				return basicSetOperation(null, msgs);
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
			case IntermediatePackage.INTERMEDIATE_PARAMETER__OPERATION:
				return eInternalContainer().eInverseRemove(this, IntermediatePackage.INTERMEDIATE_OPERATION__PARAMETERS, IntermediateOperation.class, msgs);
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
			case IntermediatePackage.INTERMEDIATE_PARAMETER__NAME:
				return getName();
			case IntermediatePackage.INTERMEDIATE_PARAMETER__QUALIFIED_NAME:
				return getQualifiedName();
			case IntermediatePackage.INTERMEDIATE_PARAMETER__EXCHANGE_PATTERN:
				return getExchangePattern();
			case IntermediatePackage.INTERMEDIATE_PARAMETER__COMMUNICATION_TYPE:
				return getCommunicationType();
			case IntermediatePackage.INTERMEDIATE_PARAMETER__COMMUNICATES_FAULT:
				return isCommunicatesFault();
			case IntermediatePackage.INTERMEDIATE_PARAMETER__OPTIONAL:
				return isOptional();
			case IntermediatePackage.INTERMEDIATE_PARAMETER__TYPE:
				return getType();
			case IntermediatePackage.INTERMEDIATE_PARAMETER__ORIGINAL_TYPE:
				return getOriginalType();
			case IntermediatePackage.INTERMEDIATE_PARAMETER__INITIALIZED_BY_OPERATION:
				return getInitializedByOperation();
			case IntermediatePackage.INTERMEDIATE_PARAMETER__ASPECTS:
				return getAspects();
			case IntermediatePackage.INTERMEDIATE_PARAMETER__FIELD_ASPECTS:
				return getFieldAspects();
			case IntermediatePackage.INTERMEDIATE_PARAMETER__OPERATION:
				if (resolve) return getOperation();
				return basicGetOperation();
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
			case IntermediatePackage.INTERMEDIATE_PARAMETER__NAME:
				setName((String)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__QUALIFIED_NAME:
				setQualifiedName((String)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__EXCHANGE_PATTERN:
				setExchangePattern((String)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__COMMUNICATION_TYPE:
				setCommunicationType((String)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__COMMUNICATES_FAULT:
				setCommunicatesFault((Boolean)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__OPTIONAL:
				setOptional((Boolean)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__TYPE:
				setType((IntermediateType)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__ORIGINAL_TYPE:
				setOriginalType((IntermediateType)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__INITIALIZED_BY_OPERATION:
				setInitializedByOperation((OperationReference)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__ASPECTS:
				getAspects().clear();
				getAspects().addAll((Collection<? extends IntermediateImportedAspect>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__FIELD_ASPECTS:
				getFieldAspects().clear();
				getFieldAspects().addAll((Collection<? extends DataFieldAspects>)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__OPERATION:
				setOperation((IntermediateOperation)newValue);
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
			case IntermediatePackage.INTERMEDIATE_PARAMETER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__QUALIFIED_NAME:
				setQualifiedName(QUALIFIED_NAME_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__EXCHANGE_PATTERN:
				setExchangePattern(EXCHANGE_PATTERN_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__COMMUNICATION_TYPE:
				setCommunicationType(COMMUNICATION_TYPE_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__COMMUNICATES_FAULT:
				setCommunicatesFault(COMMUNICATES_FAULT_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__OPTIONAL:
				setOptional(OPTIONAL_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__TYPE:
				setType((IntermediateType)null);
				return;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__ORIGINAL_TYPE:
				setOriginalType((IntermediateType)null);
				return;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__INITIALIZED_BY_OPERATION:
				setInitializedByOperation((OperationReference)null);
				return;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__ASPECTS:
				getAspects().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__FIELD_ASPECTS:
				getFieldAspects().clear();
				return;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__OPERATION:
				setOperation((IntermediateOperation)null);
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
			case IntermediatePackage.INTERMEDIATE_PARAMETER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case IntermediatePackage.INTERMEDIATE_PARAMETER__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
			case IntermediatePackage.INTERMEDIATE_PARAMETER__EXCHANGE_PATTERN:
				return EXCHANGE_PATTERN_EDEFAULT == null ? exchangePattern != null : !EXCHANGE_PATTERN_EDEFAULT.equals(exchangePattern);
			case IntermediatePackage.INTERMEDIATE_PARAMETER__COMMUNICATION_TYPE:
				return COMMUNICATION_TYPE_EDEFAULT == null ? communicationType != null : !COMMUNICATION_TYPE_EDEFAULT.equals(communicationType);
			case IntermediatePackage.INTERMEDIATE_PARAMETER__COMMUNICATES_FAULT:
				return communicatesFault != COMMUNICATES_FAULT_EDEFAULT;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__OPTIONAL:
				return optional != OPTIONAL_EDEFAULT;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__TYPE:
				return type != null;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__ORIGINAL_TYPE:
				return originalType != null;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__INITIALIZED_BY_OPERATION:
				return initializedByOperation != null;
			case IntermediatePackage.INTERMEDIATE_PARAMETER__ASPECTS:
				return aspects != null && !aspects.isEmpty();
			case IntermediatePackage.INTERMEDIATE_PARAMETER__FIELD_ASPECTS:
				return fieldAspects != null && !fieldAspects.isEmpty();
			case IntermediatePackage.INTERMEDIATE_PARAMETER__OPERATION:
				return basicGetOperation() != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", qualifiedName: ");
		result.append(qualifiedName);
		result.append(", exchangePattern: ");
		result.append(exchangePattern);
		result.append(", communicationType: ");
		result.append(communicationType);
		result.append(", communicatesFault: ");
		result.append(communicatesFault);
		result.append(", optional: ");
		result.append(optional);
		result.append(')');
		return result.toString();
	}

} //IntermediateParameterImpl
