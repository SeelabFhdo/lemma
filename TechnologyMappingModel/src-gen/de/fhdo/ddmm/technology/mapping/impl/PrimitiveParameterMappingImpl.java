/**
 */
package de.fhdo.ddmm.technology.mapping.impl;

import de.fhdo.ddmm.technology.TechnologySpecificPrimitiveType;

import de.fhdo.ddmm.technology.mapping.MappingPackage;
import de.fhdo.ddmm.technology.mapping.PrimitiveParameterMapping;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Parameter Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.ddmm.technology.mapping.impl.PrimitiveParameterMappingImpl#getPrimitiveType <em>Primitive Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PrimitiveParameterMappingImpl extends ParameterMappingImpl implements PrimitiveParameterMapping {
    /**
     * The cached value of the '{@link #getPrimitiveType() <em>Primitive Type</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPrimitiveType()
     * @generated
     * @ordered
     */
    protected TechnologySpecificPrimitiveType primitiveType;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PrimitiveParameterMappingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MappingPackage.Literals.PRIMITIVE_PARAMETER_MAPPING;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologySpecificPrimitiveType getPrimitiveType() {
        if (primitiveType != null && primitiveType.eIsProxy()) {
            InternalEObject oldPrimitiveType = (InternalEObject)primitiveType;
            primitiveType = (TechnologySpecificPrimitiveType)eResolveProxy(oldPrimitiveType);
            if (primitiveType != oldPrimitiveType) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.PRIMITIVE_PARAMETER_MAPPING__PRIMITIVE_TYPE, oldPrimitiveType, primitiveType));
            }
        }
        return primitiveType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TechnologySpecificPrimitiveType basicGetPrimitiveType() {
        return primitiveType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPrimitiveType(TechnologySpecificPrimitiveType newPrimitiveType) {
        TechnologySpecificPrimitiveType oldPrimitiveType = primitiveType;
        primitiveType = newPrimitiveType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.PRIMITIVE_PARAMETER_MAPPING__PRIMITIVE_TYPE, oldPrimitiveType, primitiveType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case MappingPackage.PRIMITIVE_PARAMETER_MAPPING__PRIMITIVE_TYPE:
                if (resolve) return getPrimitiveType();
                return basicGetPrimitiveType();
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
            case MappingPackage.PRIMITIVE_PARAMETER_MAPPING__PRIMITIVE_TYPE:
                setPrimitiveType((TechnologySpecificPrimitiveType)newValue);
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
            case MappingPackage.PRIMITIVE_PARAMETER_MAPPING__PRIMITIVE_TYPE:
                setPrimitiveType((TechnologySpecificPrimitiveType)null);
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
            case MappingPackage.PRIMITIVE_PARAMETER_MAPPING__PRIMITIVE_TYPE:
                return primitiveType != null;
        }
        return super.eIsSet(featureID);
    }

} //PrimitiveParameterMappingImpl
