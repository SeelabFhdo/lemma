/**
 */
package de.fhdo.lemma.data.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateCollectionType;
import de.fhdo.lemma.data.intermediate.IntermediateDataField;
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
 * An implementation of the model object '<em><b>Collection Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateCollectionTypeImpl#isPrimitiveCollection <em>Primitive Collection</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateCollectionTypeImpl#isStructuredCollection <em>Structured Collection</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateCollectionTypeImpl#getPrimitiveType <em>Primitive Type</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateCollectionTypeImpl#getDataFields <em>Data Fields</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateCollectionTypeImpl extends IntermediateComplexTypeImpl implements IntermediateCollectionType {
    /**
     * The default value of the '{@link #isPrimitiveCollection() <em>Primitive Collection</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isPrimitiveCollection()
     * @generated
     * @ordered
     */
    protected static final boolean PRIMITIVE_COLLECTION_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isPrimitiveCollection() <em>Primitive Collection</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isPrimitiveCollection()
     * @generated
     * @ordered
     */
    protected boolean primitiveCollection = PRIMITIVE_COLLECTION_EDEFAULT;

    /**
     * The default value of the '{@link #isStructuredCollection() <em>Structured Collection</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isStructuredCollection()
     * @generated
     * @ordered
     */
    protected static final boolean STRUCTURED_COLLECTION_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isStructuredCollection() <em>Structured Collection</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isStructuredCollection()
     * @generated
     * @ordered
     */
    protected boolean structuredCollection = STRUCTURED_COLLECTION_EDEFAULT;

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
    protected IntermediateCollectionTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_COLLECTION_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isPrimitiveCollection() {
        return primitiveCollection;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPrimitiveCollection(boolean newPrimitiveCollection) {
        boolean oldPrimitiveCollection = primitiveCollection;
        primitiveCollection = newPrimitiveCollection;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__PRIMITIVE_COLLECTION, oldPrimitiveCollection, primitiveCollection));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isStructuredCollection() {
        return structuredCollection;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStructuredCollection(boolean newStructuredCollection) {
        boolean oldStructuredCollection = structuredCollection;
        structuredCollection = newStructuredCollection;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__STRUCTURED_COLLECTION, oldStructuredCollection, structuredCollection));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
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
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__PRIMITIVE_TYPE, oldPrimitiveType, newPrimitiveType);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPrimitiveType(IntermediatePrimitiveType newPrimitiveType) {
        if (newPrimitiveType != primitiveType) {
            NotificationChain msgs = null;
            if (primitiveType != null)
                msgs = ((InternalEObject)primitiveType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__PRIMITIVE_TYPE, null, msgs);
            if (newPrimitiveType != null)
                msgs = ((InternalEObject)newPrimitiveType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__PRIMITIVE_TYPE, null, msgs);
            msgs = basicSetPrimitiveType(newPrimitiveType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__PRIMITIVE_TYPE, newPrimitiveType, newPrimitiveType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateDataField> getDataFields() {
        if (dataFields == null) {
            dataFields = new EObjectContainmentWithInverseEList<IntermediateDataField>(IntermediateDataField.class, this, IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__DATA_FIELDS, IntermediatePackage.INTERMEDIATE_DATA_FIELD__COLLECTION_TYPE);
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
            case IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__DATA_FIELDS:
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
            case IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__PRIMITIVE_TYPE:
                return basicSetPrimitiveType(null, msgs);
            case IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__DATA_FIELDS:
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
            case IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__PRIMITIVE_COLLECTION:
                return isPrimitiveCollection();
            case IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__STRUCTURED_COLLECTION:
                return isStructuredCollection();
            case IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__PRIMITIVE_TYPE:
                return getPrimitiveType();
            case IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__DATA_FIELDS:
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
            case IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__PRIMITIVE_COLLECTION:
                setPrimitiveCollection((Boolean)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__STRUCTURED_COLLECTION:
                setStructuredCollection((Boolean)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__PRIMITIVE_TYPE:
                setPrimitiveType((IntermediatePrimitiveType)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__DATA_FIELDS:
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
            case IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__PRIMITIVE_COLLECTION:
                setPrimitiveCollection(PRIMITIVE_COLLECTION_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__STRUCTURED_COLLECTION:
                setStructuredCollection(STRUCTURED_COLLECTION_EDEFAULT);
                return;
            case IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__PRIMITIVE_TYPE:
                setPrimitiveType((IntermediatePrimitiveType)null);
                return;
            case IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__DATA_FIELDS:
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
            case IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__PRIMITIVE_COLLECTION:
                return primitiveCollection != PRIMITIVE_COLLECTION_EDEFAULT;
            case IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__STRUCTURED_COLLECTION:
                return structuredCollection != STRUCTURED_COLLECTION_EDEFAULT;
            case IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__PRIMITIVE_TYPE:
                return primitiveType != null;
            case IntermediatePackage.INTERMEDIATE_COLLECTION_TYPE__DATA_FIELDS:
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
        result.append(" (primitiveCollection: ");
        result.append(primitiveCollection);
        result.append(", structuredCollection: ");
        result.append(structuredCollection);
        result.append(')');
        return result.toString();
    }

} //IntermediateCollectionTypeImpl
