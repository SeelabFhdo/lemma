/**
 */
package de.fhdo.lemma.data.intermediate.impl;

import de.fhdo.lemma.data.intermediate.IntermediateEnumeration;
import de.fhdo.lemma.data.intermediate.IntermediateEnumerationField;
import de.fhdo.lemma.data.intermediate.IntermediatePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateEnumerationImpl#getFeatureNames <em>Feature Names</em>}</li>
 *   <li>{@link de.fhdo.lemma.data.intermediate.impl.IntermediateEnumerationImpl#getFields <em>Fields</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntermediateEnumerationImpl extends IntermediateComplexTypeImpl implements IntermediateEnumeration {
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
     * The cached value of the '{@link #getFields() <em>Fields</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFields()
     * @generated
     * @ordered
     */
    protected EList<IntermediateEnumerationField> fields;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IntermediateEnumerationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IntermediatePackage.Literals.INTERMEDIATE_ENUMERATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getFeatureNames() {
        if (featureNames == null) {
            featureNames = new EDataTypeEList<String>(String.class, this, IntermediatePackage.INTERMEDIATE_ENUMERATION__FEATURE_NAMES);
        }
        return featureNames;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<IntermediateEnumerationField> getFields() {
        if (fields == null) {
            fields = new EObjectContainmentWithInverseEList<IntermediateEnumerationField>(IntermediateEnumerationField.class, this, IntermediatePackage.INTERMEDIATE_ENUMERATION__FIELDS, IntermediatePackage.INTERMEDIATE_ENUMERATION_FIELD__ENUMERATION);
        }
        return fields;
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
            case IntermediatePackage.INTERMEDIATE_ENUMERATION__FIELDS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getFields()).basicAdd(otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_ENUMERATION__FIELDS:
                return ((InternalEList<?>)getFields()).basicRemove(otherEnd, msgs);
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
            case IntermediatePackage.INTERMEDIATE_ENUMERATION__FEATURE_NAMES:
                return getFeatureNames();
            case IntermediatePackage.INTERMEDIATE_ENUMERATION__FIELDS:
                return getFields();
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
            case IntermediatePackage.INTERMEDIATE_ENUMERATION__FEATURE_NAMES:
                getFeatureNames().clear();
                getFeatureNames().addAll((Collection<? extends String>)newValue);
                return;
            case IntermediatePackage.INTERMEDIATE_ENUMERATION__FIELDS:
                getFields().clear();
                getFields().addAll((Collection<? extends IntermediateEnumerationField>)newValue);
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
            case IntermediatePackage.INTERMEDIATE_ENUMERATION__FEATURE_NAMES:
                getFeatureNames().clear();
                return;
            case IntermediatePackage.INTERMEDIATE_ENUMERATION__FIELDS:
                getFields().clear();
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
            case IntermediatePackage.INTERMEDIATE_ENUMERATION__FEATURE_NAMES:
                return featureNames != null && !featureNames.isEmpty();
            case IntermediatePackage.INTERMEDIATE_ENUMERATION__FIELDS:
                return fields != null && !fields.isEmpty();
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

} //IntermediateEnumerationImpl
