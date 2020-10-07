/**
 */
package de.fhdo.lemma.technology.mapping.impl;

import de.fhdo.lemma.data.DataOperation;

import de.fhdo.lemma.technology.mapping.ComplexTypeMapping;
import de.fhdo.lemma.technology.mapping.DataOperationMapping;
import de.fhdo.lemma.technology.mapping.DataOperationParameterMapping;
import de.fhdo.lemma.technology.mapping.DataOperationReturnTypeMapping;
import de.fhdo.lemma.technology.mapping.MappingPackage;
import de.fhdo.lemma.technology.mapping.TechnologySpecificImportedServiceAspect;

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
 * An implementation of the model object '<em><b>Data Operation Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.DataOperationMappingImpl#getDataOperation <em>Data Operation</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.DataOperationMappingImpl#getAspects <em>Aspects</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.DataOperationMappingImpl#getReturnTypeMapping <em>Return Type Mapping</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.DataOperationMappingImpl#getParameterMappings <em>Parameter Mappings</em>}</li>
 *   <li>{@link de.fhdo.lemma.technology.mapping.impl.DataOperationMappingImpl#getTypeMapping <em>Type Mapping</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataOperationMappingImpl extends MinimalEObjectImpl.Container implements DataOperationMapping {
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
    protected EList<TechnologySpecificImportedServiceAspect> aspects;

    /**
     * The cached value of the '{@link #getReturnTypeMapping() <em>Return Type Mapping</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReturnTypeMapping()
     * @generated
     * @ordered
     */
    protected DataOperationReturnTypeMapping returnTypeMapping;

    /**
     * The cached value of the '{@link #getParameterMappings() <em>Parameter Mappings</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParameterMappings()
     * @generated
     * @ordered
     */
    protected EList<DataOperationParameterMapping> parameterMappings;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DataOperationMappingImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return MappingPackage.Literals.DATA_OPERATION_MAPPING;
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
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingPackage.DATA_OPERATION_MAPPING__DATA_OPERATION, oldDataOperation, dataOperation));
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
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.DATA_OPERATION_MAPPING__DATA_OPERATION, oldDataOperation, dataOperation));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<TechnologySpecificImportedServiceAspect> getAspects() {
        if (aspects == null) {
            aspects = new EObjectContainmentWithInverseEList<TechnologySpecificImportedServiceAspect>(TechnologySpecificImportedServiceAspect.class, this, MappingPackage.DATA_OPERATION_MAPPING__ASPECTS, MappingPackage.TECHNOLOGY_SPECIFIC_IMPORTED_SERVICE_ASPECT__DATA_OPERATION_MAPPING);
        }
        return aspects;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DataOperationReturnTypeMapping getReturnTypeMapping() {
        return returnTypeMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetReturnTypeMapping(DataOperationReturnTypeMapping newReturnTypeMapping, NotificationChain msgs) {
        DataOperationReturnTypeMapping oldReturnTypeMapping = returnTypeMapping;
        returnTypeMapping = newReturnTypeMapping;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MappingPackage.DATA_OPERATION_MAPPING__RETURN_TYPE_MAPPING, oldReturnTypeMapping, newReturnTypeMapping);
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
    public void setReturnTypeMapping(DataOperationReturnTypeMapping newReturnTypeMapping) {
        if (newReturnTypeMapping != returnTypeMapping) {
            NotificationChain msgs = null;
            if (returnTypeMapping != null)
                msgs = ((InternalEObject)returnTypeMapping).eInverseRemove(this, MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__OPERATION_MAPPING, DataOperationReturnTypeMapping.class, msgs);
            if (newReturnTypeMapping != null)
                msgs = ((InternalEObject)newReturnTypeMapping).eInverseAdd(this, MappingPackage.DATA_OPERATION_RETURN_TYPE_MAPPING__OPERATION_MAPPING, DataOperationReturnTypeMapping.class, msgs);
            msgs = basicSetReturnTypeMapping(newReturnTypeMapping, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.DATA_OPERATION_MAPPING__RETURN_TYPE_MAPPING, newReturnTypeMapping, newReturnTypeMapping));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<DataOperationParameterMapping> getParameterMappings() {
        if (parameterMappings == null) {
            parameterMappings = new EObjectContainmentWithInverseEList<DataOperationParameterMapping>(DataOperationParameterMapping.class, this, MappingPackage.DATA_OPERATION_MAPPING__PARAMETER_MAPPINGS, MappingPackage.DATA_OPERATION_PARAMETER_MAPPING__OPERATION_MAPPING);
        }
        return parameterMappings;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ComplexTypeMapping getTypeMapping() {
        if (eContainerFeatureID() != MappingPackage.DATA_OPERATION_MAPPING__TYPE_MAPPING) return null;
        return (ComplexTypeMapping)eContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComplexTypeMapping basicGetTypeMapping() {
        if (eContainerFeatureID() != MappingPackage.DATA_OPERATION_MAPPING__TYPE_MAPPING) return null;
        return (ComplexTypeMapping)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTypeMapping(ComplexTypeMapping newTypeMapping, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newTypeMapping, MappingPackage.DATA_OPERATION_MAPPING__TYPE_MAPPING, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setTypeMapping(ComplexTypeMapping newTypeMapping) {
        if (newTypeMapping != eInternalContainer() || (eContainerFeatureID() != MappingPackage.DATA_OPERATION_MAPPING__TYPE_MAPPING && newTypeMapping != null)) {
            if (EcoreUtil.isAncestor(this, newTypeMapping))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newTypeMapping != null)
                msgs = ((InternalEObject)newTypeMapping).eInverseAdd(this, MappingPackage.COMPLEX_TYPE_MAPPING__OPERATION_MAPPINGS, ComplexTypeMapping.class, msgs);
            msgs = basicSetTypeMapping(newTypeMapping, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.DATA_OPERATION_MAPPING__TYPE_MAPPING, newTypeMapping, newTypeMapping));
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
            case MappingPackage.DATA_OPERATION_MAPPING__ASPECTS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getAspects()).basicAdd(otherEnd, msgs);
            case MappingPackage.DATA_OPERATION_MAPPING__RETURN_TYPE_MAPPING:
                if (returnTypeMapping != null)
                    msgs = ((InternalEObject)returnTypeMapping).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MappingPackage.DATA_OPERATION_MAPPING__RETURN_TYPE_MAPPING, null, msgs);
                return basicSetReturnTypeMapping((DataOperationReturnTypeMapping)otherEnd, msgs);
            case MappingPackage.DATA_OPERATION_MAPPING__PARAMETER_MAPPINGS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameterMappings()).basicAdd(otherEnd, msgs);
            case MappingPackage.DATA_OPERATION_MAPPING__TYPE_MAPPING:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetTypeMapping((ComplexTypeMapping)otherEnd, msgs);
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
            case MappingPackage.DATA_OPERATION_MAPPING__ASPECTS:
                return ((InternalEList<?>)getAspects()).basicRemove(otherEnd, msgs);
            case MappingPackage.DATA_OPERATION_MAPPING__RETURN_TYPE_MAPPING:
                return basicSetReturnTypeMapping(null, msgs);
            case MappingPackage.DATA_OPERATION_MAPPING__PARAMETER_MAPPINGS:
                return ((InternalEList<?>)getParameterMappings()).basicRemove(otherEnd, msgs);
            case MappingPackage.DATA_OPERATION_MAPPING__TYPE_MAPPING:
                return basicSetTypeMapping(null, msgs);
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
            case MappingPackage.DATA_OPERATION_MAPPING__TYPE_MAPPING:
                return eInternalContainer().eInverseRemove(this, MappingPackage.COMPLEX_TYPE_MAPPING__OPERATION_MAPPINGS, ComplexTypeMapping.class, msgs);
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
            case MappingPackage.DATA_OPERATION_MAPPING__DATA_OPERATION:
                if (resolve) return getDataOperation();
                return basicGetDataOperation();
            case MappingPackage.DATA_OPERATION_MAPPING__ASPECTS:
                return getAspects();
            case MappingPackage.DATA_OPERATION_MAPPING__RETURN_TYPE_MAPPING:
                return getReturnTypeMapping();
            case MappingPackage.DATA_OPERATION_MAPPING__PARAMETER_MAPPINGS:
                return getParameterMappings();
            case MappingPackage.DATA_OPERATION_MAPPING__TYPE_MAPPING:
                if (resolve) return getTypeMapping();
                return basicGetTypeMapping();
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
            case MappingPackage.DATA_OPERATION_MAPPING__DATA_OPERATION:
                setDataOperation((DataOperation)newValue);
                return;
            case MappingPackage.DATA_OPERATION_MAPPING__ASPECTS:
                getAspects().clear();
                getAspects().addAll((Collection<? extends TechnologySpecificImportedServiceAspect>)newValue);
                return;
            case MappingPackage.DATA_OPERATION_MAPPING__RETURN_TYPE_MAPPING:
                setReturnTypeMapping((DataOperationReturnTypeMapping)newValue);
                return;
            case MappingPackage.DATA_OPERATION_MAPPING__PARAMETER_MAPPINGS:
                getParameterMappings().clear();
                getParameterMappings().addAll((Collection<? extends DataOperationParameterMapping>)newValue);
                return;
            case MappingPackage.DATA_OPERATION_MAPPING__TYPE_MAPPING:
                setTypeMapping((ComplexTypeMapping)newValue);
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
            case MappingPackage.DATA_OPERATION_MAPPING__DATA_OPERATION:
                setDataOperation((DataOperation)null);
                return;
            case MappingPackage.DATA_OPERATION_MAPPING__ASPECTS:
                getAspects().clear();
                return;
            case MappingPackage.DATA_OPERATION_MAPPING__RETURN_TYPE_MAPPING:
                setReturnTypeMapping((DataOperationReturnTypeMapping)null);
                return;
            case MappingPackage.DATA_OPERATION_MAPPING__PARAMETER_MAPPINGS:
                getParameterMappings().clear();
                return;
            case MappingPackage.DATA_OPERATION_MAPPING__TYPE_MAPPING:
                setTypeMapping((ComplexTypeMapping)null);
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
            case MappingPackage.DATA_OPERATION_MAPPING__DATA_OPERATION:
                return dataOperation != null;
            case MappingPackage.DATA_OPERATION_MAPPING__ASPECTS:
                return aspects != null && !aspects.isEmpty();
            case MappingPackage.DATA_OPERATION_MAPPING__RETURN_TYPE_MAPPING:
                return returnTypeMapping != null;
            case MappingPackage.DATA_OPERATION_MAPPING__PARAMETER_MAPPINGS:
                return parameterMappings != null && !parameterMappings.isEmpty();
            case MappingPackage.DATA_OPERATION_MAPPING__TYPE_MAPPING:
                return basicGetTypeMapping() != null;
        }
        return super.eIsSet(featureID);
    }

} //DataOperationMappingImpl
