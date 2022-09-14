/**
 */
package de.fhdo.lemma.data.impl;

import de.fhdo.lemma.data.CollectionType;
import de.fhdo.lemma.data.DataField;
import de.fhdo.lemma.data.DataPackage;
import de.fhdo.lemma.data.PrimitiveType;

import java.lang.reflect.InvocationTargetException;

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
 * An implementation of the model object '<em><b>Collection Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.impl.CollectionTypeImpl#getPrimitiveType <em>Primitive Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.impl.CollectionTypeImpl#getDataFields <em>Data Fields</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectionTypeImpl extends ComplexTypeImpl implements CollectionType {
    /**
     * The cached value of the '{@link #getPrimitiveType() <em>Primitive Type</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPrimitiveType()
     * @generated
     * @ordered
     */
    protected PrimitiveType primitiveType;

    /**
     * The cached value of the '{@link #getDataFields() <em>Data Fields</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataFields()
     * @generated
     * @ordered
     */
    protected EList<DataField> dataFields;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CollectionTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return DataPackage.Literals.COLLECTION_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrimitiveType getPrimitiveType() {
        return primitiveType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetPrimitiveType(PrimitiveType newPrimitiveType, NotificationChain msgs) {
        PrimitiveType oldPrimitiveType = primitiveType;
        primitiveType = newPrimitiveType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DataPackage.COLLECTION_TYPE__PRIMITIVE_TYPE, oldPrimitiveType, newPrimitiveType);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPrimitiveType(PrimitiveType newPrimitiveType) {
        if (newPrimitiveType != primitiveType) {
            NotificationChain msgs = null;
            if (primitiveType != null)
                msgs = ((InternalEObject)primitiveType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DataPackage.COLLECTION_TYPE__PRIMITIVE_TYPE, null, msgs);
            if (newPrimitiveType != null)
                msgs = ((InternalEObject)newPrimitiveType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DataPackage.COLLECTION_TYPE__PRIMITIVE_TYPE, null, msgs);
            msgs = basicSetPrimitiveType(newPrimitiveType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DataPackage.COLLECTION_TYPE__PRIMITIVE_TYPE, newPrimitiveType, newPrimitiveType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<DataField> getDataFields() {
        if (dataFields == null) {
            dataFields = new EObjectContainmentWithInverseEList<DataField>(DataField.class, this, DataPackage.COLLECTION_TYPE__DATA_FIELDS, DataPackage.DATA_FIELD__COLLECTION_TYPE);
        }
        return dataFields;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int compareFieldCounts(final CollectionType otherCollection) {
        if ((otherCollection == null)) {
            return 1;
        }
        boolean _isIsPrimitiveCollection = otherCollection.isIsPrimitiveCollection();
        if (_isIsPrimitiveCollection) {
            if ((this.isIsPrimitiveCollection() || (this.getDataFields().size() == 1))) {
                return 0;
            }
            else {
                return 1;
            }
        }
        boolean _isIsPrimitiveCollection_1 = this.isIsPrimitiveCollection();
        if (_isIsPrimitiveCollection_1) {
            if ((otherCollection.isIsPrimitiveCollection() || (otherCollection.getDataFields().size() == 1))) {
                return 0;
            }
            else {
                return (-1);
            }
        }
        return super.compareFieldCounts(this.getDataFields(), otherCollection.getDataFields());
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
            case DataPackage.COLLECTION_TYPE__DATA_FIELDS:
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
            case DataPackage.COLLECTION_TYPE__PRIMITIVE_TYPE:
                return basicSetPrimitiveType(null, msgs);
            case DataPackage.COLLECTION_TYPE__DATA_FIELDS:
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
            case DataPackage.COLLECTION_TYPE__PRIMITIVE_TYPE:
                return getPrimitiveType();
            case DataPackage.COLLECTION_TYPE__DATA_FIELDS:
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
            case DataPackage.COLLECTION_TYPE__PRIMITIVE_TYPE:
                setPrimitiveType((PrimitiveType)newValue);
                return;
            case DataPackage.COLLECTION_TYPE__DATA_FIELDS:
                getDataFields().clear();
                getDataFields().addAll((Collection<? extends DataField>)newValue);
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
            case DataPackage.COLLECTION_TYPE__PRIMITIVE_TYPE:
                setPrimitiveType((PrimitiveType)null);
                return;
            case DataPackage.COLLECTION_TYPE__DATA_FIELDS:
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
            case DataPackage.COLLECTION_TYPE__PRIMITIVE_TYPE:
                return primitiveType != null;
            case DataPackage.COLLECTION_TYPE__DATA_FIELDS:
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
    public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
        switch (operationID) {
            case DataPackage.COLLECTION_TYPE___COMPARE_FIELD_COUNTS__COLLECTIONTYPE:
                return compareFieldCounts((CollectionType)arguments.get(0));
        }
        return super.eInvoke(operationID, arguments);
    }

} //CollectionTypeImpl
