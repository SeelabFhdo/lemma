/**
 */
package de.fhdo.lemma.data.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateDataField;
import de.fhdo.lemma.data.intermediate.IntermediateListType;
import de.fhdo.lemma.data.intermediate.IntermediatePackage;
import de.fhdo.lemma.data.intermediate.IntermediatePrimitiveType;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateListTypeImpl#isPrimitiveList <em>Primitive List</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateListTypeImpl#isStructuredList <em>Structured List</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateListTypeImpl#getPrimitiveType <em>Primitive Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateListTypeImpl#getDataFields <em>Data Fields</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateListTypeImpl extends IntermediateComplexTypeImpl implements IntermediateListType {
	/**
	 * The default value of the '{@link #isPrimitiveList() <em>Primitive List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrimitiveList()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PRIMITIVE_LIST_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPrimitiveList() <em>Primitive List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrimitiveList()
	 * @generated
	 * @ordered
	 */
	protected boolean primitiveList = PRIMITIVE_LIST_EDEFAULT;

	/**
	 * The default value of the '{@link #isStructuredList() <em>Structured List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStructuredList()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STRUCTURED_LIST_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStructuredList() <em>Structured List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStructuredList()
	 * @generated
	 * @ordered
	 */
	protected boolean structuredList = STRUCTURED_LIST_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPrimitiveType() <em>Primitive Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitiveType()
	 * @generated
	 * @ordered
	 */
	protected IntermediatePrimitiveType primitiveType;

	/**
	 * The cached value of the '{@link #getDataFields() <em>Data Fields</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataFields()
	 * @generated
	 * @ordered
	 */
	protected EList<IntermediateDataField> dataFields;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntermediateListTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IntermediatePackage.Literals.INTERMEDIATE_LIST_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isPrimitiveList() {
		return primitiveList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimitiveList(boolean newPrimitiveList) {
		boolean oldPrimitiveList = primitiveList;
		primitiveList = newPrimitiveList;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_LIST_TYPE__PRIMITIVE_LIST, oldPrimitiveList, primitiveList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isStructuredList() {
		return structuredList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStructuredList(boolean newStructuredList) {
		boolean oldStructuredList = structuredList;
		structuredList = newStructuredList;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_LIST_TYPE__STRUCTURED_LIST, oldStructuredList, structuredList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntermediatePrimitiveType getPrimitiveType() {
		return primitiveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrimitiveType(IntermediatePrimitiveType newPrimitiveType, NotificationChain msgs) {
		IntermediatePrimitiveType oldPrimitiveType = primitiveType;
		primitiveType = newPrimitiveType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_LIST_TYPE__PRIMITIVE_TYPE, oldPrimitiveType, newPrimitiveType);
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
	public void setPrimitiveType(IntermediatePrimitiveType newPrimitiveType) {
		if (newPrimitiveType != primitiveType) {
			NotificationChain msgs = null;
			if (primitiveType != null)
				msgs = ((InternalEObject)primitiveType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntermediatePackage.INTERMEDIATE_LIST_TYPE__PRIMITIVE_TYPE, null, msgs);
			if (newPrimitiveType != null)
				msgs = ((InternalEObject)newPrimitiveType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IntermediatePackage.INTERMEDIATE_LIST_TYPE__PRIMITIVE_TYPE, null, msgs);
			msgs = basicSetPrimitiveType(newPrimitiveType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_LIST_TYPE__PRIMITIVE_TYPE, newPrimitiveType, newPrimitiveType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IntermediateDataField> getDataFields() {
		if (dataFields == null) {
			dataFields = new EObjectContainmentWithInverseEList<IntermediateDataField>(IntermediateDataField.class, this, IntermediatePackage.INTERMEDIATE_LIST_TYPE__DATA_FIELDS, IntermediatePackage.INTERMEDIATE_DATA_FIELD__LIST_TYPE);
		}
		return dataFields;
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
			case IntermediatePackage.INTERMEDIATE_LIST_TYPE__DATA_FIELDS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDataFields()).basicAdd(otherEnd, msgs);
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
			case IntermediatePackage.INTERMEDIATE_LIST_TYPE__PRIMITIVE_TYPE:
				return basicSetPrimitiveType(null, msgs);
			case IntermediatePackage.INTERMEDIATE_LIST_TYPE__DATA_FIELDS:
				return ((InternalEList<?>)getDataFields()).basicRemove(otherEnd, msgs);
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
			case IntermediatePackage.INTERMEDIATE_LIST_TYPE__PRIMITIVE_LIST:
				return isPrimitiveList();
			case IntermediatePackage.INTERMEDIATE_LIST_TYPE__STRUCTURED_LIST:
				return isStructuredList();
			case IntermediatePackage.INTERMEDIATE_LIST_TYPE__PRIMITIVE_TYPE:
				return getPrimitiveType();
			case IntermediatePackage.INTERMEDIATE_LIST_TYPE__DATA_FIELDS:
				return getDataFields();
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
			case IntermediatePackage.INTERMEDIATE_LIST_TYPE__PRIMITIVE_LIST:
				setPrimitiveList((Boolean)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_LIST_TYPE__STRUCTURED_LIST:
				setStructuredList((Boolean)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_LIST_TYPE__PRIMITIVE_TYPE:
				setPrimitiveType((IntermediatePrimitiveType)newValue);
				return;
			case IntermediatePackage.INTERMEDIATE_LIST_TYPE__DATA_FIELDS:
				getDataFields().clear();
				getDataFields().addAll((Collection<? extends IntermediateDataField>)newValue);
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
			case IntermediatePackage.INTERMEDIATE_LIST_TYPE__PRIMITIVE_LIST:
				setPrimitiveList(PRIMITIVE_LIST_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_LIST_TYPE__STRUCTURED_LIST:
				setStructuredList(STRUCTURED_LIST_EDEFAULT);
				return;
			case IntermediatePackage.INTERMEDIATE_LIST_TYPE__PRIMITIVE_TYPE:
				setPrimitiveType((IntermediatePrimitiveType)null);
				return;
			case IntermediatePackage.INTERMEDIATE_LIST_TYPE__DATA_FIELDS:
				getDataFields().clear();
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
			case IntermediatePackage.INTERMEDIATE_LIST_TYPE__PRIMITIVE_LIST:
				return primitiveList != PRIMITIVE_LIST_EDEFAULT;
			case IntermediatePackage.INTERMEDIATE_LIST_TYPE__STRUCTURED_LIST:
				return structuredList != STRUCTURED_LIST_EDEFAULT;
			case IntermediatePackage.INTERMEDIATE_LIST_TYPE__PRIMITIVE_TYPE:
				return primitiveType != null;
			case IntermediatePackage.INTERMEDIATE_LIST_TYPE__DATA_FIELDS:
				return dataFields != null && !dataFields.isEmpty();
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
		result.append(" (primitiveList: ");
		result.append(primitiveList);
		result.append(", structuredList: ");
		result.append(structuredList);
		result.append(')');
		return result.toString();
	}

} //IntermediateListTypeImpl
