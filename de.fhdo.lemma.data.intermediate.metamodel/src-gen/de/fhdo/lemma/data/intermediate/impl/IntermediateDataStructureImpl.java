/**
 */
package de.fhdo.lemma.data.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateDataField;
import de.fhdo.lemma.data.intermediate.IntermediateDataOperation;
import de.fhdo.lemma.data.intermediate.IntermediateDataStructure;
import de.fhdo.lemma.data.intermediate.IntermediatePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Structure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataStructureImpl#getFeatureNames <em>Feature Names</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataStructureImpl#getSuper <em>Super</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataStructureImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateDataStructureImpl#getDataFields <em>Data Fields</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateDataStructureImpl extends IntermediateComplexTypeImpl implements IntermediateDataStructure {
    /**
     * The cached value of the '{@link #getFeatureNames() <em>Feature Names</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFeatureNames()
     * @generated
     * @ordered
     */
    protected EList<String> featureNames;

    /**
     * The cached value of the '{@link #getSuper() <em>Super</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSuper()
     * @generated
     * @ordered
     */
    protected IntermediateDataStructure super_;

    /**
     * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperations()
     * @generated
     * @ordered
     */
    protected EList<IntermediateDataOperation> operations;

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
    protected IntermediateDataStructureImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_DATA_STRUCTURE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getFeatureNames() {
        if (featureNames == null) {
            featureNames = new EDataTypeEList<String>(String.class, this, IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__FEATURE_NAMES);
        }
        return featureNames;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataStructure getSuper() {
        if (super_ != null && super_.eIsProxy()) {
            InternalEObject oldSuper = (InternalEObject)super_;
            super_ = (IntermediateDataStructure)eResolveProxy(oldSuper);
            if (super_ != oldSuper) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__SUPER, oldSuper, super_));
            }
        }
        return super_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IntermediateDataStructure basicGetSuper() {
        return super_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSuper(IntermediateDataStructure newSuper) {
        IntermediateDataStructure oldSuper = super_;
        super_ = newSuper;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__SUPER, oldSuper, super_));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateDataOperation> getOperations() {
        if (operations == null) {
            operations = new EObjectContainmentWithInverseEList<IntermediateDataOperation>(IntermediateDataOperation.class, this, IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__OPERATIONS, IntermediatePackage.INTERMEDIATE_DATA_OPERATION__DATA_STRUCTURE);
        }
        return operations;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateDataField> getDataFields() {
        if (dataFields == null) {
            dataFields = new EObjectContainmentWithInverseEList<IntermediateDataField>(IntermediateDataField.class, this, IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__DATA_FIELDS, IntermediatePackage.INTERMEDIATE_DATA_FIELD__DATA_STRUCTURE);
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
            case IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__OPERATIONS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getOperations()).basicAdd(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__DATA_FIELDS:
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
            case IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__OPERATIONS:
                return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
            case IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__DATA_FIELDS:
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
            case IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__FEATURE_NAMES:
                return getFeatureNames();
            case IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__SUPER:
                if (resolve) return getSuper();
                return basicGetSuper();
            case IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__OPERATIONS:
                return getOperations();
            case IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__DATA_FIELDS:
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
            case IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__FEATURE_NAMES:
                getFeatureNames().clear();
                getFeatureNames().addAll((Collection<? extends String>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__SUPER:
                setSuper((IntermediateDataStructure)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__OPERATIONS:
                getOperations().clear();
                getOperations().addAll((Collection<? extends IntermediateDataOperation>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__DATA_FIELDS:
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
            case IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__FEATURE_NAMES:
                getFeatureNames().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__SUPER:
                setSuper((IntermediateDataStructure)null);
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__OPERATIONS:
                getOperations().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__DATA_FIELDS:
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
            case IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__FEATURE_NAMES:
                return featureNames != null && !featureNames.isEmpty();
            case IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__SUPER:
                return super_ != null;
            case IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__OPERATIONS:
                return operations != null && !operations.isEmpty();
            case IntermediatePackage.INTERMEDIATE_DATA_STRUCTURE__DATA_FIELDS:
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
        result.append(" (featureNames: ");
        result.append(featureNames);
        result.append(')');
        return result.toString();
    }

} //IntermediateDataStructureImpl
